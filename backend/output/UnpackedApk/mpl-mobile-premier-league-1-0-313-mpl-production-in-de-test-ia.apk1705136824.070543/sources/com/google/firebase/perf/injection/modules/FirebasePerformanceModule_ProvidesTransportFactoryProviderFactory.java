package com.google.firebase.perf.injection.modules;

import com.google.android.datatransport.TransportFactory;
import com.google.firebase.inject.Provider;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.internal.Factory;

public final class FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory implements Factory<Provider<TransportFactory>> {
    public final FirebasePerformanceModule module;

    public FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    public Object get() {
        Provider<TransportFactory> provider = this.module.transportFactoryProvider;
        TweetUtils.checkNotNull1(provider, "Cannot return null from a non-@Nullable @Provides method");
        return provider;
    }
}
