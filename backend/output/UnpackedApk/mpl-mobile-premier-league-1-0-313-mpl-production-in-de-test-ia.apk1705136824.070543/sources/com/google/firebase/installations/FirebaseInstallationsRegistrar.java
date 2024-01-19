package com.google.firebase.installations;

import androidx.annotation.Keep;
import com.google.android.material.resources.TextAppearanceConfig;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.heartbeatinfo.HeartBeatConsumer;
import com.google.firebase.heartbeatinfo.HeartBeatConsumerComponent$1;
import com.google.firebase.heartbeatinfo.HeartBeatController;
import java.util.Arrays;
import java.util.List;

@Keep
public class FirebaseInstallationsRegistrar implements ComponentRegistrar {
    public static /* synthetic */ FirebaseInstallationsApi lambda$getComponents$0(ComponentContainer componentContainer) {
        return new FirebaseInstallations((FirebaseApp) componentContainer.get(FirebaseApp.class), componentContainer.getProvider(HeartBeatController.class));
    }

    public List<Component<?>> getComponents() {
        Builder<FirebaseInstallationsApi> builder = Component.builder(FirebaseInstallationsApi.class);
        builder.add(Dependency.required(FirebaseApp.class));
        builder.add(Dependency.optionalProvider(HeartBeatController.class));
        builder.factory($$Lambda$FirebaseInstallationsRegistrar$jJao20QaP13N9Fls_i7Y46Gkts.INSTANCE);
        HeartBeatConsumerComponent$1 heartBeatConsumerComponent$1 = new HeartBeatConsumerComponent$1();
        Builder<HeartBeatConsumer> builder2 = Component.builder(HeartBeatConsumer.class);
        builder2.type = 1;
        builder2.factory(new ComponentFactory(heartBeatConsumerComponent$1) {
            public final /* synthetic */ Object f$0;

            {
                this.f$0 = r1;
            }

            public final Object create(ComponentContainer componentContainer) {
                return this.f$0;
            }
        });
        return Arrays.asList(new Component[]{builder.build(), builder2.build(), TextAppearanceConfig.create("fire-installations", "17.0.1")});
    }
}
