package com.mpl.androidapp.filehandling.downloadservice.utils;

import com.google.gson.Gson;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class DownloadServiceCursorStatus_Factory implements Factory<DownloadServiceCursorStatus> {
    public final Provider<Gson> gsonProvider;

    public DownloadServiceCursorStatus_Factory(Provider<Gson> provider) {
        this.gsonProvider = provider;
    }

    public static DownloadServiceCursorStatus_Factory create(Provider<Gson> provider) {
        return new DownloadServiceCursorStatus_Factory(provider);
    }

    public static DownloadServiceCursorStatus newInstance(Gson gson) {
        return new DownloadServiceCursorStatus(gson);
    }

    public DownloadServiceCursorStatus get() {
        return newInstance((Gson) this.gsonProvider.get());
    }
}
