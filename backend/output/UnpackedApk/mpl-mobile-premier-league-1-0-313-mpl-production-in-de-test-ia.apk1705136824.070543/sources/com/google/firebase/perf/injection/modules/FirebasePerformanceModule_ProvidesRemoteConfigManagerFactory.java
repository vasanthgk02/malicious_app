package com.google.firebase.perf.injection.modules;

import com.google.firebase.perf.config.RemoteConfigManager;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.internal.Factory;

public final class FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory implements Factory<RemoteConfigManager> {
    public final FirebasePerformanceModule module;

    public FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    public Object get() {
        if (this.module != null) {
            RemoteConfigManager instance = RemoteConfigManager.getInstance();
            TweetUtils.checkNotNull1(instance, "Cannot return null from a non-@Nullable @Provides method");
            return instance;
        }
        throw null;
    }
}
