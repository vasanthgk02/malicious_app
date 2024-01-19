package com.mpl.androidapp.miniprofile.vm;

import com.google.gson.Gson;
import com.mpl.androidapp.miniprofile.repository.SendHeartRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class MiniProfileViewModel_Factory implements Factory<MiniProfileViewModel> {
    public final Provider<Gson> gsonProvider;
    public final Provider<SendHeartRepository> sendHeartRepositoryProvider;

    public MiniProfileViewModel_Factory(Provider<SendHeartRepository> provider, Provider<Gson> provider2) {
        this.sendHeartRepositoryProvider = provider;
        this.gsonProvider = provider2;
    }

    public static MiniProfileViewModel_Factory create(Provider<SendHeartRepository> provider, Provider<Gson> provider2) {
        return new MiniProfileViewModel_Factory(provider, provider2);
    }

    public static MiniProfileViewModel newInstance(SendHeartRepository sendHeartRepository, Gson gson) {
        return new MiniProfileViewModel(sendHeartRepository, gson);
    }

    public MiniProfileViewModel get() {
        return newInstance((SendHeartRepository) this.sendHeartRepositoryProvider.get(), (Gson) this.gsonProvider.get());
    }
}
