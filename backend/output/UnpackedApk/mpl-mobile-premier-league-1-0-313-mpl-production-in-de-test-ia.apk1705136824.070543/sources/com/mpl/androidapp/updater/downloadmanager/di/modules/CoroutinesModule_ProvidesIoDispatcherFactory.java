package com.mpl.androidapp.updater.downloadmanager.di.modules;

import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.internal.Factory;
import kotlinx.coroutines.CoroutineDispatcher;

public final class CoroutinesModule_ProvidesIoDispatcherFactory implements Factory<CoroutineDispatcher> {

    public static final class InstanceHolder {
        public static final CoroutinesModule_ProvidesIoDispatcherFactory INSTANCE = new CoroutinesModule_ProvidesIoDispatcherFactory();
    }

    public static CoroutinesModule_ProvidesIoDispatcherFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CoroutineDispatcher providesIoDispatcher() {
        CoroutineDispatcher providesIoDispatcher = CoroutinesModule.providesIoDispatcher();
        TweetUtils.checkNotNullFromProvides(providesIoDispatcher);
        return providesIoDispatcher;
    }

    public CoroutineDispatcher get() {
        return providesIoDispatcher();
    }
}
