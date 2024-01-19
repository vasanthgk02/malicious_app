package com.mpl.androidapp.miniprofile.service;

import dagger.internal.Factory;

public final class GameStatsService_Factory implements Factory<GameStatsService> {

    public static final class InstanceHolder {
        public static final GameStatsService_Factory INSTANCE = new GameStatsService_Factory();
    }

    public static GameStatsService_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static GameStatsService newInstance() {
        return new GameStatsService();
    }

    public GameStatsService get() {
        return newInstance();
    }
}
