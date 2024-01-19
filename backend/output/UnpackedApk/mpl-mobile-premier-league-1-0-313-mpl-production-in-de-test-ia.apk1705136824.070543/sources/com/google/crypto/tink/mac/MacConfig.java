package com.google.crypto.tink.mac;

import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;

public final class MacConfig {
    @Deprecated
    public static final RegistryConfig TINK_1_0_0 = RegistryConfig.DEFAULT_INSTANCE;

    static {
        new HmacKeyManager();
        try {
            register();
        } catch (GeneralSecurityException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    public static void register() throws GeneralSecurityException {
        Registry.registerKeyManager(new HmacKeyManager(), true);
        Registry.registerKeyManager(new AesCmacKeyManager(), true);
        Registry.registerPrimitiveWrapper(new MacWrapper());
    }
}
