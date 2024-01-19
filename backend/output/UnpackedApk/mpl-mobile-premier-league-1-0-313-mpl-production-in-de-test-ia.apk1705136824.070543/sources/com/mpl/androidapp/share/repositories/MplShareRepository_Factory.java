package com.mpl.androidapp.share.repositories;

import com.mpl.androidapp.share.services.GenerateDeepLinkService;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class MplShareRepository_Factory implements Factory<MplShareRepository> {
    public final Provider<GenerateDeepLinkService> generateDeepLinkServiceProvider;

    public MplShareRepository_Factory(Provider<GenerateDeepLinkService> provider) {
        this.generateDeepLinkServiceProvider = provider;
    }

    public static MplShareRepository_Factory create(Provider<GenerateDeepLinkService> provider) {
        return new MplShareRepository_Factory(provider);
    }

    public static MplShareRepository newInstance(GenerateDeepLinkService generateDeepLinkService) {
        return new MplShareRepository(generateDeepLinkService);
    }

    public MplShareRepository get() {
        return newInstance((GenerateDeepLinkService) this.generateDeepLinkServiceProvider.get());
    }
}
