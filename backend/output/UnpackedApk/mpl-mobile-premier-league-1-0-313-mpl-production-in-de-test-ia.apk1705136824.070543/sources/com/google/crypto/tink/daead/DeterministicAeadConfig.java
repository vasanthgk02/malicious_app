package com.google.crypto.tink.daead;

import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;

public final class DeterministicAeadConfig {
    static {
        new AesSivKeyManager();
        RegistryConfig registryConfig = RegistryConfig.DEFAULT_INSTANCE;
        try {
            Registry.registerKeyManager(new AesSivKeyManager(), true);
            Registry.registerPrimitiveWrapper(new DeterministicAeadWrapper());
        } catch (GeneralSecurityException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    public static void register() throws GeneralSecurityException {
        Registry.registerKeyManager(new AesSivKeyManager(), true);
        Registry.registerPrimitiveWrapper(new DeterministicAeadWrapper());
    }
}
