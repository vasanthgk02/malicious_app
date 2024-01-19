package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzee;
import com.google.android.material.resources.TextAppearanceConfig;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.AnalyticsConnectorImpl;
import com.google.firebase.analytics.connector.zza;
import com.google.firebase.analytics.connector.zzb;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.events.Subscriber;
import java.util.Arrays;
import java.util.List;

@KeepForSdk
@Keep
/* compiled from: com.google.android.gms:play-services-measurement-api@@20.1.2 */
public class AnalyticsConnectorRegistrar implements ComponentRegistrar {
    public static AnalyticsConnector lambda$getComponents$0(ComponentContainer componentContainer) {
        FirebaseApp firebaseApp = (FirebaseApp) componentContainer.get(FirebaseApp.class);
        Context context = (Context) componentContainer.get(Context.class);
        Subscriber subscriber = (Subscriber) componentContainer.get(Subscriber.class);
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(subscriber);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (AnalyticsConnectorImpl.zzc == null) {
            synchronized (AnalyticsConnectorImpl.class) {
                if (AnalyticsConnectorImpl.zzc == null) {
                    Bundle bundle = new Bundle(1);
                    if (firebaseApp.isDefaultApp()) {
                        subscriber.subscribe(DataCollectionDefaultChange.class, zzb.zza, zza.zza);
                        bundle.putBoolean("dataCollectionDefaultEnabled", firebaseApp.isDataCollectionDefaultEnabled());
                    }
                    AnalyticsConnectorImpl.zzc = new AnalyticsConnectorImpl(zzee.zzg(context, null, null, null, bundle).zzd());
                }
            }
        }
        return AnalyticsConnectorImpl.zzc;
    }

    @SuppressLint({"MissingPermission"})
    @Keep
    @KeepForSdk
    public List<Component<?>> getComponents() {
        Builder<AnalyticsConnector> builder = Component.builder(AnalyticsConnector.class);
        builder.add(Dependency.required(FirebaseApp.class));
        builder.add(Dependency.required(Context.class));
        builder.add(Dependency.required(Subscriber.class));
        builder.factory(zzb.zza);
        builder.setInstantiation(2);
        return Arrays.asList(new Component[]{builder.build(), TextAppearanceConfig.create("fire-analytics", "20.1.2")});
    }
}
