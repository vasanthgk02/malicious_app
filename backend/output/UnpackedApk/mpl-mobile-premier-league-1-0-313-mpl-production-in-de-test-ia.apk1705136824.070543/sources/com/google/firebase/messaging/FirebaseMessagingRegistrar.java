package com.google.firebase.messaging;

import androidx.annotation.Keep;
import com.google.android.datatransport.TransportFactory;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.material.resources.TextAppearanceConfig;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.Arrays;
import java.util.List;

@KeepForSdk
@Keep
public class FirebaseMessagingRegistrar implements ComponentRegistrar {
    public static /* synthetic */ FirebaseMessaging lambda$getComponents$0(ComponentContainer componentContainer) {
        FirebaseMessaging firebaseMessaging = new FirebaseMessaging((FirebaseApp) componentContainer.get(FirebaseApp.class), (FirebaseInstanceIdInternal) componentContainer.get(FirebaseInstanceIdInternal.class), componentContainer.getProvider(UserAgentPublisher.class), componentContainer.getProvider(HeartBeatInfo.class), (FirebaseInstallationsApi) componentContainer.get(FirebaseInstallationsApi.class), (TransportFactory) componentContainer.get(TransportFactory.class), (Subscriber) componentContainer.get(Subscriber.class));
        return firebaseMessaging;
    }

    @Keep
    public List<Component<?>> getComponents() {
        Builder<FirebaseMessaging> builder = Component.builder(FirebaseMessaging.class);
        builder.add(Dependency.required(FirebaseApp.class));
        builder.add(new Dependency(FirebaseInstanceIdInternal.class, 0, 0));
        builder.add(Dependency.optionalProvider(UserAgentPublisher.class));
        builder.add(Dependency.optionalProvider(HeartBeatInfo.class));
        builder.add(new Dependency(TransportFactory.class, 0, 0));
        builder.add(Dependency.required(FirebaseInstallationsApi.class));
        builder.add(Dependency.required(Subscriber.class));
        builder.factory($$Lambda$FirebaseMessagingRegistrar$fQEaFFZnhQ5A7CkkPdmeVK4jgk.INSTANCE);
        builder.setInstantiation(1);
        return Arrays.asList(new Component[]{builder.build(), TextAppearanceConfig.create("fire-fcm", "23.0.2")});
    }
}
