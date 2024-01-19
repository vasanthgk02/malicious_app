package com.google.firebase.perf;

import androidx.annotation.Keep;
import com.google.android.datatransport.TransportFactory;
import com.google.android.material.resources.TextAppearanceConfig;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesConfigResolverFactory;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesFirebaseAppFactory;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesSessionManagerFactory;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.internal.DoubleCheck;
import java.util.Arrays;
import java.util.List;

@Keep
public class FirebasePerfRegistrar implements ComponentRegistrar {
    public static FirebasePerformance providesFirebasePerformance(ComponentContainer componentContainer) {
        FirebasePerformanceModule firebasePerformanceModule = new FirebasePerformanceModule((FirebaseApp) componentContainer.get(FirebaseApp.class), (FirebaseInstallationsApi) componentContainer.get(FirebaseInstallationsApi.class), componentContainer.getProvider(RemoteConfigComponent.class), componentContainer.getProvider(TransportFactory.class));
        TweetUtils.checkBuilderRequirement(firebasePerformanceModule, FirebasePerformanceModule.class);
        FirebasePerformance_Factory firebasePerformance_Factory = new FirebasePerformance_Factory(new FirebasePerformanceModule_ProvidesFirebaseAppFactory(firebasePerformanceModule), new FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory(firebasePerformanceModule), new FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory(firebasePerformanceModule), new FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory(firebasePerformanceModule), new FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory(firebasePerformanceModule), new FirebasePerformanceModule_ProvidesConfigResolverFactory(firebasePerformanceModule), new FirebasePerformanceModule_ProvidesSessionManagerFactory(firebasePerformanceModule));
        return (FirebasePerformance) DoubleCheck.provider(firebasePerformance_Factory).get();
    }

    @Keep
    public List<Component<?>> getComponents() {
        Builder<FirebasePerformance> builder = Component.builder(FirebasePerformance.class);
        builder.add(Dependency.required(FirebaseApp.class));
        builder.add(Dependency.requiredProvider(RemoteConfigComponent.class));
        builder.add(Dependency.required(FirebaseInstallationsApi.class));
        builder.add(Dependency.requiredProvider(TransportFactory.class));
        builder.factory($$Lambda$Rp3QMY9cU4gIqy0ZT81gn0EUrE.INSTANCE);
        return Arrays.asList(new Component[]{builder.build(), TextAppearanceConfig.create("fire-perf", "20.0.6")});
    }
}
