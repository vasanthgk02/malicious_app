package com.google.firebase.perf.injection.modules;

import com.google.firebase.perf.config.ConfigResolver;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.internal.Factory;

public final class FirebasePerformanceModule_ProvidesConfigResolverFactory implements Factory<ConfigResolver> {
    public final FirebasePerformanceModule module;

    public FirebasePerformanceModule_ProvidesConfigResolverFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    public Object get() {
        if (this.module != null) {
            ConfigResolver instance = ConfigResolver.getInstance();
            TweetUtils.checkNotNull1(instance, "Cannot return null from a non-@Nullable @Provides method");
            return instance;
        }
        throw null;
    }
}
