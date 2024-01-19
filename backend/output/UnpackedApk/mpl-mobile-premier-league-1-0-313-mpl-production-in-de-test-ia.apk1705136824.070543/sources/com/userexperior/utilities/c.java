package com.userexperior.utilities;

import android.os.Build.VERSION;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStore.SecretKeyEntry;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class c {

    /* renamed from: b  reason: collision with root package name */
    public static c f4264b;

    /* renamed from: a  reason: collision with root package name */
    public KeyStore f4265a;

    public c() {
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            this.f4265a = instance;
            instance.load(null);
        } catch (KeyStoreException e2) {
            e2.printStackTrace();
        } catch (CertificateException e3) {
            e3.printStackTrace();
        } catch (NoSuchAlgorithmException e4) {
            e4.printStackTrace();
        } catch (IOException e5) {
            e5.printStackTrace();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public static c a() {
        if (VERSION.SDK_INT < 23) {
            return null;
        }
        synchronized (c.class) {
            try {
                if (f4264b == null) {
                    f4264b = new c();
                }
            }
        }
        return f4264b;
    }

    private SecretKey b() {
        try {
            return ((SecretKeyEntry) this.f4265a.getEntry("uekeystore", null)).getSecretKey();
        } catch (KeyStoreException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
            return null;
        } catch (UnrecoverableEntryException e4) {
            e4.printStackTrace();
            return null;
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public final String a(byte[] bArr, byte[] bArr2) {
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            instance.init(2, b(), new IvParameterSpec(bArr2));
            return new String(instance.doFinal(bArr), "UTF-8");
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvalidKeyException e4) {
            e4.printStackTrace();
            return null;
        } catch (InvalidAlgorithmParameterException e5) {
            e5.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e6) {
            e6.printStackTrace();
            return null;
        } catch (BadPaddingException e7) {
            e7.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e8) {
            e8.printStackTrace();
            return null;
        } catch (Exception e9) {
            e9.printStackTrace();
            return null;
        }
    }
}
