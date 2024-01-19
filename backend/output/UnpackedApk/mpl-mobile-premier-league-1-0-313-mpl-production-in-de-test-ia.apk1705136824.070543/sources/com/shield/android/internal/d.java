package com.shield.android.internal;

import android.util.Base64;
import com.android.tools.r8.GeneratedOutlineSupport;
import in.juspay.hypersdk.security.EncryptionHelper;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public final NativeUtils f1673a;

    public d(NativeUtils nativeUtils) {
        this.f1673a = nativeUtils;
    }

    public final String a(String str, byte[] bArr, SecretKey secretKey) throws Exception {
        if (b()) {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
            Cipher instance = Cipher.getInstance(this.f1673a.getPayloadTransformation());
            instance.init(1, secretKey, ivParameterSpec);
            return a(b(instance.doFinal(str.getBytes())));
        }
        IvParameterSpec ivParameterSpec2 = new IvParameterSpec(bArr);
        Cipher instance2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance2.init(1, secretKey, ivParameterSpec2);
        return a(b(instance2.doFinal(str.getBytes())));
    }

    public final boolean b() {
        return this.f1673a.a();
    }

    public String c(String str) throws Exception {
        if (b()) {
            KeyGenerator instance = KeyGenerator.getInstance(this.f1673a.getPayloadFormat());
            instance.init(256);
            SecretKey generateKey = instance.generateKey();
            byte[] bArr = new byte[16];
            new SecureRandom().nextBytes(bArr);
            String a2 = a(str, bArr, generateKey);
            String a3 = a(b(generateKey.getEncoded()));
            String a4 = a(b(bArr));
            return a(Base64.encode(GeneratedOutlineSupport.outline52(a2, ":", c((a4 + ":" + a3).getBytes())).getBytes(StandardCharsets.UTF_8), 2));
        }
        KeyGenerator instance2 = KeyGenerator.getInstance(EncryptionHelper.algorithm);
        instance2.init(256);
        SecretKey generateKey2 = instance2.generateKey();
        byte[] bArr2 = new byte[16];
        new SecureRandom().nextBytes(bArr2);
        String a5 = a(str, bArr2, generateKey2);
        String a6 = a(b(generateKey2.getEncoded()));
        String a7 = a(b(bArr2));
        return a(Base64.encode(GeneratedOutlineSupport.outline52(a5, ":", c((a7 + ":" + a6).getBytes())).getBytes(StandardCharsets.UTF_8), 2));
    }

    public final byte[] b(byte[] bArr) {
        return Base64.encode(bArr, 2);
    }

    public final String a(byte[] bArr) throws Exception {
        return new String(bArr, StandardCharsets.UTF_8);
    }

    public final byte[] a(String str) {
        return Base64.decode(str, 2);
    }

    public final String c(byte[] bArr) throws Exception {
        PublicKey publicKey;
        Cipher instance = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
        if (b()) {
            publicKey = KeyFactory.getInstance(this.f1673a.getKeyFormat()).generatePublic(new X509EncodedKeySpec(a(this.f1673a.getPb().replaceAll("\\s+", ""))));
        } else {
            publicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(a(a(a((String) "TUlHZk1BMEdDU3FHU0liM0RRRUJBUVVBQTRHTkFEQ0JpUUtCZ1FERzcxTE9WYzRpM2xXUWorQm1PNEQ3NGd1M1VPV2tlN3cybjNqcUxRTFdHZThaM05VVnRCc3hXTE9obHhvenpOOWhNMlJvUUZqaGoySDNZSFNVK2oxK0dzRTlYbFpzYjJaaERLY1FJc0tidzh2RzA3b1laaFl2THRRd21Wb1ZEdVVJdG85dmpQVHI0K1NROTlCZ1E2Yk0zUDRVZCtyenZmcFEvb2ZFWDkvVXhRSURBUUFC")).replaceAll("\\s+", ""))));
        }
        instance.init(1, publicKey);
        return a(b(instance.doFinal(bArr)));
    }
}
