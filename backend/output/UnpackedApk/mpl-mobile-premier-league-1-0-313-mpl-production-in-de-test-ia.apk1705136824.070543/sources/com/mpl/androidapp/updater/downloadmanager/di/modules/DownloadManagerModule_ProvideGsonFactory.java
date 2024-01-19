package com.mpl.androidapp.updater.downloadmanager.di.modules;

import com.google.gson.Gson;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.internal.Factory;

public final class DownloadManagerModule_ProvideGsonFactory implements Factory<Gson> {
    public final DownloadManagerModule module;

    public DownloadManagerModule_ProvideGsonFactory(DownloadManagerModule downloadManagerModule) {
        this.module = downloadManagerModule;
    }

    public static DownloadManagerModule_ProvideGsonFactory create(DownloadManagerModule downloadManagerModule) {
        return new DownloadManagerModule_ProvideGsonFactory(downloadManagerModule);
    }

    public static Gson provideGson(DownloadManagerModule downloadManagerModule) {
        Gson provideGson = downloadManagerModule.provideGson();
        TweetUtils.checkNotNullFromProvides(provideGson);
        return provideGson;
    }

    public Gson get() {
        return provideGson(this.module);
    }
}
