package com.mpl.androidapp.miniprofile.repository;

import com.mpl.androidapp.miniprofile.service.FollowPlayerService;
import com.mpl.androidapp.miniprofile.service.GameStatsService;
import com.mpl.androidapp.miniprofile.service.ProfileDetailsService;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class SendHeartRepository_Factory implements Factory<SendHeartRepository> {
    public final Provider<FollowPlayerService> followPlayerServiceProvider;
    public final Provider<GameStatsService> gameStatsServiceProvider;
    public final Provider<ProfileDetailsService> playersListServiceProvider;

    public SendHeartRepository_Factory(Provider<ProfileDetailsService> provider, Provider<FollowPlayerService> provider2, Provider<GameStatsService> provider3) {
        this.playersListServiceProvider = provider;
        this.followPlayerServiceProvider = provider2;
        this.gameStatsServiceProvider = provider3;
    }

    public static SendHeartRepository_Factory create(Provider<ProfileDetailsService> provider, Provider<FollowPlayerService> provider2, Provider<GameStatsService> provider3) {
        return new SendHeartRepository_Factory(provider, provider2, provider3);
    }

    public static SendHeartRepository newInstance(ProfileDetailsService profileDetailsService, FollowPlayerService followPlayerService, GameStatsService gameStatsService) {
        return new SendHeartRepository(profileDetailsService, followPlayerService, gameStatsService);
    }

    public SendHeartRepository get() {
        return newInstance((ProfileDetailsService) this.playersListServiceProvider.get(), (FollowPlayerService) this.followPlayerServiceProvider.get(), (GameStatsService) this.gameStatsServiceProvider.get());
    }
}
