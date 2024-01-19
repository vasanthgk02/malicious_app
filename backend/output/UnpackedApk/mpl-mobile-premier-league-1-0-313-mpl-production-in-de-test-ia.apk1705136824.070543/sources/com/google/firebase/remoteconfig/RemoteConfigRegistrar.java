package com.google.firebase.remoteconfig;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.material.resources.TextAppearanceConfig;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.abt.component.AbtComponent;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.Arrays;
import java.util.List;

@Keep
public class RemoteConfigRegistrar implements ComponentRegistrar {
    public static RemoteConfigComponent lambda$getComponents$0(ComponentContainer componentContainer) {
        FirebaseABTesting firebaseABTesting;
        Context context = (Context) componentContainer.get(Context.class);
        FirebaseApp firebaseApp = (FirebaseApp) componentContainer.get(FirebaseApp.class);
        FirebaseInstallationsApi firebaseInstallationsApi = (FirebaseInstallationsApi) componentContainer.get(FirebaseInstallationsApi.class);
        AbtComponent abtComponent = (AbtComponent) componentContainer.get(AbtComponent.class);
        synchronized (abtComponent) {
            try {
                if (!abtComponent.abtOriginInstances.containsKey("frc")) {
                    abtComponent.abtOriginInstances.put("frc", new FirebaseABTesting(abtComponent.analyticsConnector, "frc"));
                }
                firebaseABTesting = abtComponent.abtOriginInstances.get("frc");
            }
        }
        RemoteConfigComponent remoteConfigComponent = new RemoteConfigComponent(context, firebaseApp, firebaseInstallationsApi, firebaseABTesting, componentContainer.getProvider(AnalyticsConnector.class));
        return remoteConfigComponent;
    }

    public List<Component<?>> getComponents() {
        Builder<RemoteConfigComponent> builder = Component.builder(RemoteConfigComponent.class);
        builder.add(Dependency.required(Context.class));
        builder.add(Dependency.required(FirebaseApp.class));
        builder.add(Dependency.required(FirebaseInstallationsApi.class));
        builder.add(Dependency.required(AbtComponent.class));
        builder.add(Dependency.optionalProvider(AnalyticsConnector.class));
        builder.factory($$Lambda$RemoteConfigRegistrar$KZsUUeI2E4027tIE_XguszprpgM.INSTANCE);
        builder.setInstantiation(2);
        return Arrays.asList(new Component[]{builder.build(), TextAppearanceConfig.create("fire-rc", "21.0.2")});
    }
}
