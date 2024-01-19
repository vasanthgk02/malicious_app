package com.mpl.androidapp.updater.downloadmanager.di.modules;

import android.app.DownloadManager;
import android.content.Context;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class DownloadManagerModule_ProvideDownloadManagerFactory implements Factory<DownloadManager> {
    public final Provider<Context> contextProvider;
    public final DownloadManagerModule module;

    public DownloadManagerModule_ProvideDownloadManagerFactory(DownloadManagerModule downloadManagerModule, Provider<Context> provider) {
        this.module = downloadManagerModule;
        this.contextProvider = provider;
    }

    public static DownloadManagerModule_ProvideDownloadManagerFactory create(DownloadManagerModule downloadManagerModule, Provider<Context> provider) {
        return new DownloadManagerModule_ProvideDownloadManagerFactory(downloadManagerModule, provider);
    }

    public static DownloadManager provideDownloadManager(DownloadManagerModule downloadManagerModule, Context context) {
        DownloadManager provideDownloadManager = downloadManagerModule.provideDownloadManager(context);
        TweetUtils.checkNotNullFromProvides(provideDownloadManager);
        return provideDownloadManager;
    }

    public DownloadManager get() {
        return provideDownloadManager(this.module, (Context) this.contextProvider.get());
    }
}
