package com.google.firebase.perf.injection.modules;

import com.google.firebase.FirebaseApp;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.internal.Factory;

public final class FirebasePerformanceModule_ProvidesFirebaseAppFactory implements Factory<FirebaseApp> {
    public final FirebasePerformanceModule module;

    public FirebasePerformanceModule_ProvidesFirebaseAppFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    public Object get() {
        FirebaseApp firebaseApp = this.module.firebaseApp;
        TweetUtils.checkNotNull1(firebaseApp, "Cannot return null from a non-@Nullable @Provides method");
        return firebaseApp;
    }
}
