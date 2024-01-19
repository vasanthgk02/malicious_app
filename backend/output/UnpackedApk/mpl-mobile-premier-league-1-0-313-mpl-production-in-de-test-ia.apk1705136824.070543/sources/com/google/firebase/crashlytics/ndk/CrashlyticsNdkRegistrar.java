package com.google.firebase.crashlytics.ndk;

import android.content.Context;
import com.google.android.material.resources.TextAppearanceConfig;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;
import java.util.Arrays;
import java.util.List;

public class CrashlyticsNdkRegistrar implements ComponentRegistrar {
    /* access modifiers changed from: private */
    public CrashlyticsNativeComponent buildCrashlyticsNdk(ComponentContainer componentContainer) {
        Context context = (Context) componentContainer.get(Context.class);
        return FirebaseCrashlyticsNdk.create(context, !DevelopmentPlatformProvider.isUnity(context));
    }

    public List<Component<?>> getComponents() {
        Builder<CrashlyticsNativeComponent> builder = Component.builder(CrashlyticsNativeComponent.class);
        builder.add(Dependency.required(Context.class));
        builder.factory(new ComponentFactory() {
            public final Object create(ComponentContainer componentContainer) {
                return CrashlyticsNdkRegistrar.this.buildCrashlyticsNdk(componentContainer);
            }
        });
        builder.setInstantiation(2);
        return Arrays.asList(new Component[]{builder.build(), TextAppearanceConfig.create("fire-cls-ndk", "18.2.9")});
    }
}
