package com.google.firebase.abt.component;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.material.resources.TextAppearanceConfig;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import java.util.Arrays;
import java.util.List;

@Keep
public class AbtRegistrar implements ComponentRegistrar {
    public static /* synthetic */ AbtComponent lambda$getComponents$0(ComponentContainer componentContainer) {
        return new AbtComponent((Context) componentContainer.get(Context.class), componentContainer.getProvider(AnalyticsConnector.class));
    }

    public List<Component<?>> getComponents() {
        Builder<AbtComponent> builder = Component.builder(AbtComponent.class);
        builder.add(Dependency.required(Context.class));
        builder.add(Dependency.optionalProvider(AnalyticsConnector.class));
        builder.factory($$Lambda$AbtRegistrar$Ej8CjpLrHSdSGsZ1qe4TKlo40ts.INSTANCE);
        return Arrays.asList(new Component[]{builder.build(), TextAppearanceConfig.create("fire-abt", "21.0.1")});
    }
}
