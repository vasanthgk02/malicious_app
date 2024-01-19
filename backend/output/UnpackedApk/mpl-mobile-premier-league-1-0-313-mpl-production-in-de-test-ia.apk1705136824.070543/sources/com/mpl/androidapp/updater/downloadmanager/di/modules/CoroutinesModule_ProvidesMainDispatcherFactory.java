package com.mpl.androidapp.updater.downloadmanager.di.modules;

import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.internal.Factory;
import kotlinx.coroutines.CoroutineDispatcher;

public final class CoroutinesModule_ProvidesMainDispatcherFactory implements Factory<CoroutineDispatcher> {

    public static final class InstanceHolder {
        public static final CoroutinesModule_ProvidesMainDispatcherFactory INSTANCE = new CoroutinesModule_ProvidesMainDispatcherFactory();
    }

    public static CoroutinesModule_ProvidesMainDispatcherFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CoroutineDispatcher providesMainDispatcher() {
        CoroutineDispatcher providesMainDispatcher = CoroutinesModule.providesMainDispatcher();
        TweetUtils.checkNotNullFromProvides(providesMainDispatcher);
        return providesMainDispatcher;
    }

    public CoroutineDispatcher get() {
        return providesMainDispatcher();
    }
}
