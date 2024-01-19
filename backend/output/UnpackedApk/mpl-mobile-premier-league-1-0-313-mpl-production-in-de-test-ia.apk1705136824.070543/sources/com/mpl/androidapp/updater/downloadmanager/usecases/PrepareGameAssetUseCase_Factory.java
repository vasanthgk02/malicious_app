package com.mpl.androidapp.updater.downloadmanager.usecases;

import dagger.internal.Factory;

public final class PrepareGameAssetUseCase_Factory implements Factory<PrepareGameAssetUseCase> {

    public static final class InstanceHolder {
        public static final PrepareGameAssetUseCase_Factory INSTANCE = new PrepareGameAssetUseCase_Factory();
    }

    public static PrepareGameAssetUseCase_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static PrepareGameAssetUseCase newInstance() {
        return new PrepareGameAssetUseCase();
    }

    public PrepareGameAssetUseCase get() {
        return newInstance();
    }
}
