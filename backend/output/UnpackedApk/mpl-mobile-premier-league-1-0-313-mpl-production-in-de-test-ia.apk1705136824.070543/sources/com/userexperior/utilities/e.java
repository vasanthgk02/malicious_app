package com.userexperior.utilities;

import android.util.Base64;
import in.juspay.hypersdk.security.EncryptionHelper;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static String f4268a = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String a(int i) {
        StringBuilder sb = new StringBuilder();
        while (i != 0) {
            sb.append(f4268a.charAt(i % 62));
            i /= 62;
        }
        return sb.reverse().toString();
    }

    public static byte[] a(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 8);
            return new SecretKeySpec(decode, 0, decode.length, EncryptionHelper.algorithm).getEncoded();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, EncryptionHelper.algorithm);
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            instance.init(1, secretKeySpec, new IvParameterSpec(bArr2));
            return instance.doFinal(bArr3);
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvalidKeyException e4) {
            e4.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e5) {
            e5.printStackTrace();
            return null;
        } catch (BadPaddingException e6) {
            e6.printStackTrace();
            return null;
        } catch (Exception e7) {
            e7.printStackTrace();
            return null;
        }
    }

    public static byte[] b(String str) {
        if (str == null) {
            return null;
        }
        try {
            return Base64.decode(str, 8);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
