package io.hansel.diagnostics;

import android.util.Base64;
import com.android.tools.r8.GeneratedOutlineSupport;
import in.juspay.hypersdk.security.EncryptionHelper;
import io.hansel.core.logger.HSLLogger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class c {

    /* renamed from: b  reason: collision with root package name */
    public static SecretKeySpec f5233b;

    /* renamed from: a  reason: collision with root package name */
    public String f5234a;

    public c(String str, String str2) {
        this.f5234a = str2;
        f5233b = a(str, str2);
    }

    private SecretKeySpec a(String str, String str2) {
        if (f5233b == null) {
            f5233b = new SecretKeySpec(d(c(str + str2)).getBytes(), EncryptionHelper.algorithm);
        }
        return f5233b;
    }

    public static String c(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                String hexString = Integer.toHexString(b2 & 255);
                while (hexString.length() < 2) {
                    hexString = "0" + hexString;
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            HSLLogger.printStackTrace(e2);
            return "";
        }
    }

    private String d(String str) {
        if (str.length() >= 32) {
            return str.substring(0, 32);
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73(str);
        int length = 32 - str.length();
        for (int i = 0; i < length; i++) {
            outline73.append("\u0000");
        }
        return outline73.toString();
    }

    public String a(String str) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Hansel_Cipher_Init_");
        outline73.append(this.f5234a);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(outline73.toString().getBytes("UTF-8"), 0, 16);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, f5233b, ivParameterSpec);
        return new String(instance.doFinal(Base64.decode(str, 2)), "UTF-8");
    }

    public String b(String str) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Hansel_Cipher_Init_");
        outline73.append(this.f5234a);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(outline73.toString().getBytes("UTF-8"), 0, 16);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(1, f5233b, ivParameterSpec);
        return Base64.encodeToString(instance.doFinal(str.getBytes("UTF-8")), 2);
    }
}
