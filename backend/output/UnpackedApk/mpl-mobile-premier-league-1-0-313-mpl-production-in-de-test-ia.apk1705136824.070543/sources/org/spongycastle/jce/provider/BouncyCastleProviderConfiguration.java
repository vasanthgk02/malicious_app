package org.spongycastle.jce.provider;

import org.spongycastle.jcajce.provider.config.ProviderConfigurationPermission;

public class BouncyCastleProviderConfiguration {
    static {
        new ProviderConfigurationPermission("SC", "threadLocalEcImplicitlyCa");
        new ProviderConfigurationPermission("SC", "ecImplicitlyCa");
        new ProviderConfigurationPermission("SC", "threadLocalDhDefaultParams");
        new ProviderConfigurationPermission("SC", "DhDefaultParams");
    }

    public BouncyCastleProviderConfiguration() {
        new ThreadLocal();
        new ThreadLocal();
    }
}
