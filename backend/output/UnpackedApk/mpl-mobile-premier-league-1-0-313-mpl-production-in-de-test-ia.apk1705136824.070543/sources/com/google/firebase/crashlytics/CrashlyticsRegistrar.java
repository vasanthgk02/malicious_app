package com.google.firebase.crashlytics;

import com.google.android.material.resources.TextAppearanceConfig;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.Arrays;
import java.util.List;

public class CrashlyticsRegistrar implements ComponentRegistrar {
    /* access modifiers changed from: private */
    public FirebaseCrashlytics buildCrashlytics(ComponentContainer componentContainer) {
        return FirebaseCrashlytics.init((FirebaseApp) componentContainer.get(FirebaseApp.class), (FirebaseInstallationsApi) componentContainer.get(FirebaseInstallationsApi.class), componentContainer.getDeferred(CrashlyticsNativeComponent.class), componentContainer.getDeferred(AnalyticsConnector.class));
    }

    public List<Component<?>> getComponents() {
        Builder<FirebaseCrashlytics> builder = Component.builder(FirebaseCrashlytics.class);
        builder.add(Dependency.required(FirebaseApp.class));
        builder.add(Dependency.required(FirebaseInstallationsApi.class));
        builder.add(new Dependency(CrashlyticsNativeComponent.class, 0, 2));
        builder.add(new Dependency(AnalyticsConnector.class, 0, 2));
        builder.factory(new ComponentFactory() {
            public final Object create(ComponentContainer componentContainer) {
                return CrashlyticsRegistrar.this.buildCrashlytics(componentContainer);
            }
        });
        builder.setInstantiation(2);
        return Arrays.asList(new Component[]{builder.build(), TextAppearanceConfig.create("fire-cls", "18.2.9")});
    }
}
