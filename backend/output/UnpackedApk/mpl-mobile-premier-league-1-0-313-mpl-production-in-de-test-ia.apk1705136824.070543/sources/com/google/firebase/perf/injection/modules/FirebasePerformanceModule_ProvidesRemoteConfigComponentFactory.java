package com.google.firebase.perf.injection.modules;

import com.google.firebase.inject.Provider;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.internal.Factory;

public final class FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory implements Factory<Provider<RemoteConfigComponent>> {
    public final FirebasePerformanceModule module;

    public FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    public Object get() {
        Provider<RemoteConfigComponent> provider = this.module.remoteConfigComponentProvider;
        TweetUtils.checkNotNull1(provider, "Cannot return null from a non-@Nullable @Provides method");
        return provider;
    }
}
