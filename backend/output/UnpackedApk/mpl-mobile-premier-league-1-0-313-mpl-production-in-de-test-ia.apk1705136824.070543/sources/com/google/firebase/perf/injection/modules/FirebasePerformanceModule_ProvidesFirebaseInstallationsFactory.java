package com.google.firebase.perf.injection.modules;

import com.google.firebase.installations.FirebaseInstallationsApi;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.internal.Factory;

public final class FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory implements Factory<FirebaseInstallationsApi> {
    public final FirebasePerformanceModule module;

    public FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    public Object get() {
        FirebaseInstallationsApi firebaseInstallationsApi = this.module.firebaseInstallations;
        TweetUtils.checkNotNull1(firebaseInstallationsApi, "Cannot return null from a non-@Nullable @Provides method");
        return firebaseInstallationsApi;
    }
}
