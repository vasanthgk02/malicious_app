package com.google.firebase.datatransport;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.datatransport.TransportFactory;
import com.google.android.material.resources.TextAppearanceConfig;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import java.util.Arrays;
import java.util.List;

@Keep
public class TransportRegistrar implements ComponentRegistrar {
    public List<Component<?>> getComponents() {
        Builder<TransportFactory> builder = Component.builder(TransportFactory.class);
        builder.add(Dependency.required(Context.class));
        builder.factory($$Lambda$TransportRegistrar$8MftFhDZTqyNaIMLf3wZTwlt260.INSTANCE);
        return Arrays.asList(new Component[]{builder.build(), TextAppearanceConfig.create("fire-transport", "18.1.1")});
    }
}
