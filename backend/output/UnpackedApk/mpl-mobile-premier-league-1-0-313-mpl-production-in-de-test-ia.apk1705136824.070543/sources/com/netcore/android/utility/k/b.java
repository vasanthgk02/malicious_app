package com.netcore.android.utility.k;

import android.security.keystore.KeyGenParameterSpec.Builder;
import com.netcore.android.logger.SMTLogger;
import in.juspay.hypersdk.security.EncryptionHelper;
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

/* compiled from: SMTAesEncryption */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1321a = "b";

    public static AlgorithmParameterSpec b() {
        return new GCMParameterSpec(128, new byte[12]);
    }

    public byte[] a(byte[] bArr) {
        Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
        instance.init(1, c(), b());
        return instance.doFinal(bArr);
    }

    public Key c() {
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load(null);
            return instance.getKey("SMT_CE_DATABASE_ENCRYPTION_KEY", null);
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException | CertificateException e2) {
            SMTLogger.INSTANCE.e(f1321a, e2.getMessage());
            return null;
        }
    }

    public byte[] b(byte[] bArr) {
        Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
        instance.init(2, c(), b());
        return instance.doFinal(bArr);
    }

    public void a() {
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load(null);
            if (!instance.containsAlias("SMT_CE_DATABASE_ENCRYPTION_KEY")) {
                KeyGenerator instance2 = KeyGenerator.getInstance(EncryptionHelper.algorithm, "AndroidKeyStore");
                instance2.init(new Builder("SMT_CE_DATABASE_ENCRYPTION_KEY", 3).setBlockModes(new String[]{"GCM"}).setEncryptionPaddings(new String[]{"NoPadding"}).setRandomizedEncryptionRequired(false).build());
                instance2.generateKey();
            }
        } catch (IOException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | CertificateException e2) {
            SMTLogger.INSTANCE.e(f1321a, e2.getMessage());
        }
    }
}
