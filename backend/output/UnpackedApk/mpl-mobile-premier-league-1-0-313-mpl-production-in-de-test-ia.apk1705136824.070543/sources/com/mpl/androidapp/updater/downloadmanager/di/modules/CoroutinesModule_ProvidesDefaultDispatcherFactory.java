package com.mpl.androidapp.updater.downloadmanager.di.modules;

import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.internal.Factory;
import kotlinx.coroutines.CoroutineDispatcher;

public final class CoroutinesModule_ProvidesDefaultDispatcherFactory implements Factory<CoroutineDispatcher> {

    public static final class InstanceHolder {
        public static final CoroutinesModule_ProvidesDefaultDispatcherFactory INSTANCE = new CoroutinesModule_ProvidesDefaultDispatcherFactory();
    }

    public static CoroutinesModule_ProvidesDefaultDispatcherFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CoroutineDispatcher providesDefaultDispatcher() {
        CoroutineDispatcher providesDefaultDispatcher = CoroutinesModule.providesDefaultDispatcher();
        TweetUtils.checkNotNullFromProvides(providesDefaultDispatcher);
        return providesDefaultDispatcher;
    }

    public CoroutineDispatcher get() {
        return providesDefaultDispatcher();
    }
}
