package com.mpl.androidapp.updater.downloadmanager.utils;

import com.google.gson.Gson;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class DownloadManagerCursorStatus_Factory implements Factory<DownloadManagerCursorStatus> {
    public final Provider<Gson> gsonProvider;

    public DownloadManagerCursorStatus_Factory(Provider<Gson> provider) {
        this.gsonProvider = provider;
    }

    public static DownloadManagerCursorStatus_Factory create(Provider<Gson> provider) {
        return new DownloadManagerCursorStatus_Factory(provider);
    }

    public static DownloadManagerCursorStatus newInstance(Gson gson) {
        return new DownloadManagerCursorStatus(gson);
    }

    public DownloadManagerCursorStatus get() {
        return newInstance((Gson) this.gsonProvider.get());
    }
}
