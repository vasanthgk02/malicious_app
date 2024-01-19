package com.mpl.androidapp.updater.downloadmanager.downloadModules;

import android.content.Context;
import com.google.gson.Gson;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class DownloadProgressAssets_Factory implements Factory<DownloadProgressAssets> {
    public final Provider<Context> contextProvider;
    public final Provider<Gson> gsonProvider;

    public DownloadProgressAssets_Factory(Provider<Context> provider, Provider<Gson> provider2) {
        this.contextProvider = provider;
        this.gsonProvider = provider2;
    }

    public static DownloadProgressAssets_Factory create(Provider<Context> provider, Provider<Gson> provider2) {
        return new DownloadProgressAssets_Factory(provider, provider2);
    }

    public static DownloadProgressAssets newInstance(Context context, Gson gson) {
        return new DownloadProgressAssets(context, gson);
    }

    public DownloadProgressAssets get() {
        return newInstance((Context) this.contextProvider.get(), (Gson) this.gsonProvider.get());
    }
}
