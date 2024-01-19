package in.juspay.hypersdk.security;

import android.os.Build.VERSION;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.utils.Constant;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

public class JOSEUtils {
    public static RSAPublicKey JWKtoRSAPublicKey(JSONObject jSONObject) {
        return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger(1, Base64Codec.decode(jSONObject.getString("n"))), new BigInteger(1, Base64Codec.decode(jSONObject.getString("e")))));
    }

    public static void assertIfMatches(String str, String str2) {
        if (!str.equals(str2)) {
            throw new Exception(GeneratedOutlineSupport.outline53("Assert failed, org=", str, ", expected=", str2));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void assertIfSupportedEncAlg(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = -1868738169(0xffffffff909d5187, float:-6.2051194E-29)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = -890830960(0xffffffffcae6ff90, float:-7569352.0)
            if (r0 == r1) goto L_0x0020
            r1 = -565207670(0xffffffffde4f9d8a, float:-3.7400663E18)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "RSA-OAEP"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0034
            r0 = 1
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "RSA-OAEP-256"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0034
            r0 = 2
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "RSA1_5"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0034
            r0 = 0
            goto L_0x0035
        L_0x0034:
            r0 = -1
        L_0x0035:
            if (r0 == 0) goto L_0x0048
            if (r0 == r3) goto L_0x0048
            if (r0 != r2) goto L_0x003c
            return
        L_0x003c:
            java.lang.Exception r0 = new java.lang.Exception
            java.lang.String r1 = "Not supported signing alg "
            java.lang.String r4 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r1, r4)
            r0.<init>(r4)
            throw r0
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.security.JOSEUtils.assertIfSupportedEncAlg(java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0036 A[ADDED_TO_REGION, RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void assertIfSupportedSigningAlg(java.lang.String r3) {
        /*
            int r0 = r3.hashCode()
            r1 = 78251122(0x4aa0472, float:3.997089E-36)
            r2 = 1
            if (r0 == r1) goto L_0x001a
            r1 = 78253877(0x4aa0f35, float:3.9980773E-36)
            if (r0 == r1) goto L_0x0010
            goto L_0x0024
        L_0x0010:
            java.lang.String r0 = "RS512"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0024
            r0 = 1
            goto L_0x0025
        L_0x001a:
            java.lang.String r0 = "RS256"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0024
            r0 = 0
            goto L_0x0025
        L_0x0024:
            r0 = -1
        L_0x0025:
            if (r0 == 0) goto L_0x0036
            if (r0 != r2) goto L_0x002a
            return
        L_0x002a:
            java.lang.Exception r0 = new java.lang.Exception
            java.lang.String r1 = "Not supported signing alg "
            java.lang.String r3 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r1, r3)
            r0.<init>(r3)
            throw r0
        L_0x0036:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.security.JOSEUtils.assertIfSupportedSigningAlg(java.lang.String):void");
    }

    public static byte[] concat(byte[]... bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            for (byte[] bArr2 : bArr) {
                if (bArr2 != null) {
                    byteArrayOutputStream.write(bArr2);
                }
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (IOException e2) {
            throw new IllegalStateException(e2.getMessage(), e2);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static String extractKey(String str, String str2) {
        JSONObject jSONObject = new JSONObject(str2);
        if (jSONObject.has(str)) {
            return jSONObject.getString(str);
        }
        throw new Exception(GeneratedOutlineSupport.outline50("JWS Sign - header missing ", str));
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getJavaAlg(java.lang.String r5) {
        /*
            int r0 = r5.hashCode()
            r1 = 4
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r0) {
                case -1868738169: goto L_0x0034;
                case -890830960: goto L_0x002a;
                case -565207670: goto L_0x0020;
                case 78251122: goto L_0x0016;
                case 78253877: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x003e
        L_0x000c:
            java.lang.String r0 = "RS512"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x003e
            r0 = 1
            goto L_0x003f
        L_0x0016:
            java.lang.String r0 = "RS256"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x003e
            r0 = 0
            goto L_0x003f
        L_0x0020:
            java.lang.String r0 = "RSA-OAEP"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x003e
            r0 = 3
            goto L_0x003f
        L_0x002a:
            java.lang.String r0 = "RSA-OAEP-256"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x003e
            r0 = 4
            goto L_0x003f
        L_0x0034:
            java.lang.String r0 = "RSA1_5"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x003e
            r0 = 2
            goto L_0x003f
        L_0x003e:
            r0 = -1
        L_0x003f:
            if (r0 == 0) goto L_0x0061
            if (r0 == r4) goto L_0x005e
            if (r0 == r3) goto L_0x005b
            if (r0 == r2) goto L_0x0058
            if (r0 != r1) goto L_0x004c
            java.lang.String r5 = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding"
            return r5
        L_0x004c:
            java.lang.Exception r0 = new java.lang.Exception
            java.lang.String r1 = "Not supported signing alg "
            java.lang.String r5 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r1, r5)
            r0.<init>(r5)
            throw r0
        L_0x0058:
            java.lang.String r5 = "RSA/ECB/OAEPWithSHA-1AndMGF1Padding"
            return r5
        L_0x005b:
            java.lang.String r5 = "RSA/ECB/PKCS1Padding"
            return r5
        L_0x005e:
            java.lang.String r5 = "SHA512withRSA"
            return r5
        L_0x0061:
            java.lang.String r5 = "SHA256withRSA"
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.security.JOSEUtils.getJavaAlg(java.lang.String):java.lang.String");
    }

    public static JSONObject jweDecrypt(String str, PrivateKey privateKey) {
        AlgorithmParameterSpec algorithmParameterSpec;
        String[] split = str.split("\\.");
        String str2 = new String(Base64Codec.decode(split[0]));
        String extractKey = extractKey("alg", str2);
        assertIfSupportedEncAlg(extractKey);
        assertIfMatches(extractKey("enc", str2), "A256GCM");
        new SecureRandom().nextBytes(new byte[2048]);
        String str3 = split[1];
        Cipher instance = Cipher.getInstance(getJavaAlg(extractKey));
        instance.init(2, privateKey);
        SecretKeySpec secretKeySpec = new SecretKeySpec(instance.doFinal(Base64Codec.decode(str3)), EncryptionHelper.algorithm);
        byte[] bytes = Base64Codec.encodeToString(str2.getBytes(StandardCharsets.UTF_8), true).getBytes(StandardCharsets.US_ASCII);
        SecretKeySpec secretKeySpec2 = new SecretKeySpec(secretKeySpec.getEncoded(), EncryptionHelper.algorithm);
        Cipher instance2 = Cipher.getInstance("AES/GCM/NoPadding");
        try {
            algorithmParameterSpec = VERSION.SDK_INT <= 23 ? new IvParameterSpec(Base64Codec.decode(split[2])) : new GCMParameterSpec(128, Base64Codec.decode(split[2]));
        } catch (Exception unused) {
            algorithmParameterSpec = new GCMParameterSpec(128, Base64Codec.decode(split[2]));
        }
        instance2.init(2, secretKeySpec2, algorithmParameterSpec);
        instance2.updateAAD(bytes);
        byte[] doFinal = instance2.doFinal(concat(Base64Codec.decode(split[3]), Base64Codec.decode(split[4])));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Constant.HEADER, str2);
        jSONObject.put("payload", new String(doFinal));
        return jSONObject;
    }

    public static String jweEncrypt(String str, String str2, byte[] bArr) {
        return jweEncrypt(str.getBytes(StandardCharsets.UTF_8), str2, (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr)));
    }

    public static String jweEncrypt(byte[] bArr, String str, RSAPublicKey rSAPublicKey) {
        AlgorithmParameterSpec algorithmParameterSpec;
        byte[] bArr2;
        String extractKey = extractKey("alg", str);
        assertIfSupportedEncAlg(extractKey);
        assertIfMatches(extractKey("enc", str), "A256GCM");
        byte[] bArr3 = new byte[32];
        new SecureRandom().nextBytes(bArr3);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr3, EncryptionHelper.algorithm);
        Cipher instance = Cipher.getInstance(getJavaAlg(extractKey));
        instance.init(1, rSAPublicKey);
        String encodeToString = Base64Codec.encodeToString(instance.doFinal(secretKeySpec.getEncoded()), true);
        byte[] bytes = Base64Codec.encodeToString(str.getBytes(StandardCharsets.UTF_8), true).getBytes(StandardCharsets.US_ASCII);
        byte[] bArr4 = new byte[12];
        new SecureRandom().nextBytes(bArr4);
        Cipher instance2 = Cipher.getInstance("AES/GCM/NoPadding");
        try {
            algorithmParameterSpec = VERSION.SDK_INT <= 23 ? new IvParameterSpec(bArr4) : new GCMParameterSpec(128, bArr4);
        } catch (Exception unused) {
            algorithmParameterSpec = new GCMParameterSpec(128, bArr4);
        }
        instance2.init(1, secretKeySpec, algorithmParameterSpec);
        instance2.updateAAD(bytes);
        byte[] doFinal = instance2.doFinal(bArr);
        int length = doFinal.length - 16;
        byte[] subArray = subArray(doFinal, 0, length);
        byte[] subArray2 = subArray(doFinal, length, 16);
        try {
            bArr2 = VERSION.SDK_INT <= 23 ? ((IvParameterSpec) instance2.getParameters().getParameterSpec(IvParameterSpec.class)).getIV() : ((GCMParameterSpec) instance2.getParameters().getParameterSpec(GCMParameterSpec.class)).getIV();
        } catch (Exception unused2) {
            bArr2 = ((GCMParameterSpec) instance2.getParameters().getParameterSpec(GCMParameterSpec.class)).getIV();
        }
        return Base64Codec.encodeToString(str.getBytes(StandardCharsets.UTF_8), true) + "." + encodeToString + "." + Base64Codec.encodeToString(bArr2, true) + "." + Base64Codec.encodeToString(subArray, true) + "." + Base64Codec.encodeToString(subArray2, true);
    }

    public static String jwsSign(String str, String str2, PrivateKey privateKey) {
        String str3 = Base64Codec.encodeToString(str2.getBytes(StandardCharsets.UTF_8), true) + "." + Base64Codec.encodeToString(str.getBytes(StandardCharsets.UTF_8), true);
        String extractKey = extractKey("alg", str2);
        assertIfSupportedSigningAlg(extractKey);
        Signature instance = Signature.getInstance(getJavaAlg(extractKey));
        instance.initSign(privateKey);
        instance.update(str3.getBytes(StandardCharsets.UTF_8));
        byte[] sign = instance.sign();
        StringBuilder outline78 = GeneratedOutlineSupport.outline78(str3, ".");
        outline78.append(Base64Codec.encodeToString(sign, true));
        return outline78.toString();
    }

    public static boolean jwsVerify(String str, byte[] bArr) {
        RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr));
        String[] split = str.split("\\.");
        if (split.length == 3) {
            String extractKey = extractKey("alg", new String(Base64Codec.decode(split[0])));
            assertIfSupportedSigningAlg(extractKey);
            Signature instance = Signature.getInstance(getJavaAlg(extractKey));
            instance.initVerify(rSAPublicKey);
            instance.update((split[0] + "." + split[1]).getBytes(StandardCharsets.UTF_8));
            return instance.verify(Base64Codec.decode(split[2]));
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("JWS Verify - mandatory params missing ");
        outline73.append(split.length);
        throw new Exception(outline73.toString());
    }

    public static byte[] subArray(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }
}
