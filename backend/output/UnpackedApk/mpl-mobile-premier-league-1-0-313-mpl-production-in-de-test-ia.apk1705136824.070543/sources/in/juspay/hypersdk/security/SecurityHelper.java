package in.juspay.hypersdk.security;

import android.content.Context;
import android.os.Build.VERSION;
import android.security.KeyPairGeneratorSpec.Builder;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import io.sentry.DateUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.crypto.Cipher;
import javax.security.auth.x500.X500Principal;

public class SecurityHelper extends EncryptionHelper {
    public static final String RSA_TRANSFORM = "RSA/ECB/PKCS1Padding";
    public static final String SHA_256_RSA = "SHA256withRSA";

    public static void createKeys(Context context, String str, String str2) {
        KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtils.ISO_FORMAT_WITH_MILLIS);
        Date time = new GregorianCalendar().getTime();
        Date parse = simpleDateFormat.parse(str2);
        instance.initialize(VERSION.SDK_INT < 23 ? new Builder(context).setAlias(str).setSerialNumber(BigInteger.ONE).setSubject(new X500Principal(GeneratedOutlineSupport.outline52("CN=JUSPAY_", str, " CA Certificate"))).setStartDate(time).setEndDate(parse).setKeySize(2048).build() : new KeyGenParameterSpec.Builder(str, 7).setBlockModes(new String[]{"ECB"}).setEncryptionPaddings(new String[]{"PKCS1Padding", "OAEPPadding"}).setKeySize(2048).setUserAuthenticationRequired(false).setDigests(new String[]{"SHA-256", "SHA-512", CommonUtils.SHA1_INSTANCE}).setSignaturePaddings(new String[]{"PKCS1"}).setKeyValidityEnd(parse).build());
        instance.generateKeyPair();
    }

    public static void deleteKey(String str) {
        if (keyExists(str)) {
            getAndroidKeyStore().deleteEntry(str);
        }
    }

    public static KeyStore getAndroidKeyStore() {
        KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
        instance.load(null);
        return instance;
    }

    public static KeyPair getKeyPair(String str) {
        KeyStore androidKeyStore = getAndroidKeyStore();
        return new KeyPair(androidKeyStore.getCertificate(str).getPublicKey(), (PrivateKey) androidKeyStore.getKey(str, null));
    }

    public static byte[] getRequestNonce(String str) {
        SecureRandom secureRandom = new SecureRandom();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[24];
        secureRandom.nextBytes(bArr);
        try {
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(str.getBytes());
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            return null;
        }
    }

    public static boolean keyExists(String str) {
        return getAndroidKeyStore().containsAlias(str);
    }

    public static String rsaDecrypt(String str, String str2) {
        PrivateKey privateKey = getKeyPair(str).getPrivate();
        Cipher instance = Cipher.getInstance(RSA_TRANSFORM);
        instance.init(2, privateKey);
        return new String(instance.doFinal(Base64.decode(str2, 2)));
    }

    public static String rsaEncrypt(String str, String str2) {
        PublicKey publicKey = getKeyPair(str).getPublic();
        Cipher instance = Cipher.getInstance(RSA_TRANSFORM);
        instance.init(1, publicKey);
        return Base64.encodeToString(instance.doFinal(str2.getBytes()), 2);
    }

    public static String signData(String str, String str2) {
        byte[] bytes = str2.getBytes();
        KeyPair keyPair = getKeyPair(str);
        Signature instance = Signature.getInstance(SHA_256_RSA);
        instance.initSign(keyPair.getPrivate());
        instance.update(bytes);
        return Base64.encodeToString(instance.sign(), 2);
    }
}
