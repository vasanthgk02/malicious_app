package com.google.firebase.perf;

import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class FirebasePerformance_Factory implements Factory<FirebasePerformance> {
    public final Provider<ConfigResolver> configResolverProvider;
    public final Provider<FirebaseApp> firebaseAppProvider;
    public final Provider<FirebaseInstallationsApi> firebaseInstallationsApiProvider;
    public final Provider<com.google.firebase.inject.Provider<RemoteConfigComponent>> firebaseRemoteConfigProvider;
    public final Provider<RemoteConfigManager> remoteConfigManagerProvider;
    public final Provider<SessionManager> sessionManagerProvider;
    public final Provider<com.google.firebase.inject.Provider<TransportFactory>> transportFactoryProvider;

    public FirebasePerformance_Factory(Provider<FirebaseApp> provider, Provider<com.google.firebase.inject.Provider<RemoteConfigComponent>> provider2, Provider<FirebaseInstallationsApi> provider3, Provider<com.google.firebase.inject.Provider<TransportFactory>> provider4, Provider<RemoteConfigManager> provider5, Provider<ConfigResolver> provider6, Provider<SessionManager> provider7) {
        this.firebaseAppProvider = provider;
        this.firebaseRemoteConfigProvider = provider2;
        this.firebaseInstallationsApiProvider = provider3;
        this.transportFactoryProvider = provider4;
        this.remoteConfigManagerProvider = provider5;
        this.configResolverProvider = provider6;
        this.sessionManagerProvider = provider7;
    }

    public Object get() {
        FirebasePerformance firebasePerformance = new FirebasePerformance((FirebaseApp) this.firebaseAppProvider.get(), (com.google.firebase.inject.Provider) this.firebaseRemoteConfigProvider.get(), (FirebaseInstallationsApi) this.firebaseInstallationsApiProvider.get(), (com.google.firebase.inject.Provider) this.transportFactoryProvider.get(), (RemoteConfigManager) this.remoteConfigManagerProvider.get(), (ConfigResolver) this.configResolverProvider.get(), (SessionManager) this.sessionManagerProvider.get());
        return firebasePerformance;
    }
}
