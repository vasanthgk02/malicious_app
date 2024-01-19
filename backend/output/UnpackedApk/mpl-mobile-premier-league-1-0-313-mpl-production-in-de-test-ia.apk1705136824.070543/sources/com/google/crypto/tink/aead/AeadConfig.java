package com.google.crypto.tink.aead;

import com.google.crypto.tink.Registry;
import com.google.crypto.tink.mac.MacConfig;
import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

public final class AeadConfig {
    @Deprecated
    public static final RegistryConfig TINK_1_0_0 = RegistryConfig.DEFAULT_INSTANCE;

    static {
        new AesCtrHmacAeadKeyManager();
        new AesGcmKeyManager();
        new AesGcmSivKeyManager();
        new AesEaxKeyManager();
        new KmsAeadKeyManager();
        new KmsEnvelopeAeadKeyManager();
        new ChaCha20Poly1305KeyManager();
        new XChaCha20Poly1305KeyManager();
        try {
            register();
        } catch (GeneralSecurityException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    public static void register() throws GeneralSecurityException {
        boolean z;
        MacConfig.register();
        Registry.registerKeyManager(new AesCtrHmacAeadKeyManager(), true);
        Registry.registerKeyManager(new AesEaxKeyManager(), true);
        Registry.registerKeyManager(new AesGcmKeyManager(), true);
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            z = true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            z = false;
        }
        if (z) {
            Registry.registerKeyManager(new AesGcmSivKeyManager(), true);
        }
        Registry.registerKeyManager(new ChaCha20Poly1305KeyManager(), true);
        Registry.registerKeyManager(new KmsAeadKeyManager(), true);
        Registry.registerKeyManager(new KmsEnvelopeAeadKeyManager(), true);
        Registry.registerKeyManager(new XChaCha20Poly1305KeyManager(), true);
        Registry.registerPrimitiveWrapper(new AeadWrapper());
    }
}
