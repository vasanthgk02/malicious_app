package com.userexperior.utilities;

import android.os.Build.VERSION;
import android.security.keystore.KeyGenParameterSpec.Builder;
import in.juspay.hypersdk.security.EncryptionHelper;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStore.SecretKeyEntry;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f4266b;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f4267a;

    public static d a() {
        if (VERSION.SDK_INT < 23) {
            return null;
        }
        synchronized (d.class) {
            try {
                if (f4266b == null) {
                    f4266b = new d();
                }
            }
        }
        return f4266b;
    }

    public static SecretKey b() {
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load(null);
            if (instance.containsAlias("uekeystore")) {
                return ((SecretKeyEntry) instance.getEntry("uekeystore", null)).getSecretKey();
            }
            KeyGenerator instance2 = KeyGenerator.getInstance(EncryptionHelper.algorithm, "AndroidKeyStore");
            if (VERSION.SDK_INT >= 23) {
                instance2.init(new Builder("uekeystore", 3).setBlockModes(new String[]{"CBC"}).setEncryptionPaddings(new String[]{"PKCS7Padding"}).setKeySize(256).build());
                return instance2.generateKey();
            }
            return null;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        } catch (NoSuchProviderException e3) {
            e3.printStackTrace();
        } catch (InvalidAlgorithmParameterException e4) {
            e4.printStackTrace();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final byte[] a(String str) {
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            instance.init(1, b());
            this.f4267a = instance.getIV();
            return instance.doFinal(str.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e3) {
            e3.printStackTrace();
            return null;
        } catch (BadPaddingException e4) {
            e4.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e5) {
            e5.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e6) {
            e6.printStackTrace();
            return null;
        } catch (InvalidKeyException e7) {
            e7.printStackTrace();
            return null;
        } catch (Exception e8) {
            e8.printStackTrace();
            return null;
        }
    }
}
