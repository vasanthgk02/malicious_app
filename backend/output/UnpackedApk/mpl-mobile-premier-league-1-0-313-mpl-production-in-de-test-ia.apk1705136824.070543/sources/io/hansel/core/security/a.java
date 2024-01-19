package io.hansel.core.security;

import android.security.keystore.KeyGenParameterSpec.Builder;
import android.util.Base64;
import in.juspay.hypersdk.security.EncryptionHelper;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.GCMParameterSpec;

public class a implements c {
    public static AlgorithmParameterSpec b() {
        return new GCMParameterSpec(128, new byte[12]);
    }

    public String a(String str) {
        byte[] bytes = str.getBytes();
        Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
        instance.init(1, c(), b());
        return Base64.encodeToString(instance.doFinal(bytes), 2);
    }

    public void a() {
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load(null);
            if (!instance.containsAlias("SMT_PX_SEG_MAPS_KEY_ALIAS")) {
                KeyGenerator instance2 = KeyGenerator.getInstance(EncryptionHelper.algorithm, "AndroidKeyStore");
                instance2.init(new Builder("SMT_PX_SEG_MAPS_KEY_ALIAS", 3).setBlockModes(new String[]{"GCM"}).setEncryptionPaddings(new String[]{"NoPadding"}).setRandomizedEncryptionRequired(false).build());
                instance2.generateKey();
            }
        } catch (IOException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | CertificateException e2) {
            HSLLogger.printStackTrace(e2, "Encryption: Error generating secret key", LogGroup.PT);
        }
    }

    public String b(String str) {
        byte[] decode = Base64.decode(str, 2);
        Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
        instance.init(2, c(), b());
        return new String(instance.doFinal(decode));
    }

    public Key c() {
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load(null);
            return instance.getKey("SMT_PX_SEG_MAPS_KEY_ALIAS", null);
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException | CertificateException e2) {
            HSLLogger.printStackTrace(e2, "Encryption: Error accessing secret key", LogGroup.PT);
            return null;
        }
    }
}
