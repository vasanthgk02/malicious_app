package com.mpl.androidapp.updater.downloadmanager.usecases;

import dagger.internal.Factory;

public final class DownloadAssetTaskUseCase_Factory implements Factory<DownloadAssetTaskUseCase> {

    public static final class InstanceHolder {
        public static final DownloadAssetTaskUseCase_Factory INSTANCE = new DownloadAssetTaskUseCase_Factory();
    }

    public static DownloadAssetTaskUseCase_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DownloadAssetTaskUseCase newInstance() {
        return new DownloadAssetTaskUseCase();
    }

    public DownloadAssetTaskUseCase get() {
        return newInstance();
    }
}
