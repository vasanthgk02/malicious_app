package com.google.firebase.perf.injection.modules;

import com.google.firebase.perf.session.SessionManager;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.internal.Factory;

public final class FirebasePerformanceModule_ProvidesSessionManagerFactory implements Factory<SessionManager> {
    public final FirebasePerformanceModule module;

    public FirebasePerformanceModule_ProvidesSessionManagerFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    public Object get() {
        if (this.module != null) {
            SessionManager instance = SessionManager.getInstance();
            TweetUtils.checkNotNull1(instance, "Cannot return null from a non-@Nullable @Provides method");
            return instance;
        }
        throw null;
    }
}
