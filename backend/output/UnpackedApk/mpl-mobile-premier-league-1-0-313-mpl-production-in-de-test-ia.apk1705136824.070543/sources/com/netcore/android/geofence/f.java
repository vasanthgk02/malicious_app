package com.netcore.android.geofence;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskApiCall.Builder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.location.zzbe;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.zzaq;
import com.google.android.gms.location.zzar;
import com.google.android.gms.location.zzas;
import com.google.android.gms.tasks.Task;
import com.netcore.android.SMTConfigConstants;
import com.netcore.android.e.b;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.utility.SMTCommonUtility;
import com.netcore.android.utility.g;
import com.twitter.sdk.android.tweetui.TweetUtils;
import in.juspay.services.HyperServices;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SMTGeoFenceSDK.kt */
public final class f {

    /* renamed from: d  reason: collision with root package name */
    public static volatile f f1139d = null;

    /* renamed from: e  reason: collision with root package name */
    public static final String f1140e = "SMTGeoFenceSDK";

    /* renamed from: f  reason: collision with root package name */
    public static final a f1141f = new a(null);

    /* renamed from: a  reason: collision with root package name */
    public Context f1142a;

    /* renamed from: b  reason: collision with root package name */
    public GeofencingClient f1143b;

    /* renamed from: c  reason: collision with root package name */
    public final WeakReference<Context> f1144c;

    /* compiled from: SMTGeoFenceSDK.kt */
    public static final class a {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\b\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"com/netcore/android/geofence/f$a$a", "", "Lcom/netcore/android/geofence/f$a$a;", "", "a", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "CAMPAIGN", "UPDATE_FROM_LOCAL", "UPDATE_FROM_SERVER", "smartech_release"}, k = 1, mv = {1, 4, 1})
        /* renamed from: com.netcore.android.geofence.f$a$a  reason: collision with other inner class name */
        /* compiled from: SMTGeoFenceSDK.kt */
        public enum C0007a {
            CAMPAIGN("0"),
            UPDATE_FROM_LOCAL("-1"),
            UPDATE_FROM_SERVER("-2");
            

            /* renamed from: a  reason: collision with root package name */
            public final String f1146a;

            /* access modifiers changed from: public */
            C0007a(String str) {
                this.f1146a = str;
            }

            public final String getValue() {
                return this.f1146a;
            }
        }

        public a() {
        }

        private final f a(WeakReference<Context> weakReference) {
            return new f(weakReference, null);
        }

        public final f b(WeakReference<Context> weakReference) {
            f fVar;
            Intrinsics.checkNotNullParameter(weakReference, "context");
            f a2 = f.f1139d;
            if (a2 != null) {
                return a2;
            }
            synchronized (f.class) {
                try {
                    f a3 = f.f1139d;
                    if (a3 != null) {
                        fVar = a3;
                    } else {
                        fVar = f.f1141f.a(weakReference);
                        f.f1139d = fVar;
                    }
                }
            }
            return fVar;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public f(WeakReference<Context> weakReference) {
        this.f1144c = weakReference;
        Context context = (Context) weakReference.get();
        if (context != null) {
            Intrinsics.checkNotNullExpressionValue(context, "it");
            this.f1142a = context;
        }
        Context context2 = this.f1142a;
        if (context2 != null) {
            this.f1143b = LocationServices.getGeofencingClient(context2);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            throw null;
        }
    }

    private final PendingIntent b() {
        Context context = this.f1142a;
        if (context != null) {
            Intent intent = new Intent(context.getApplicationContext(), GeoFenceBroadcastReceiver.class);
            Context context2 = this.f1142a;
            if (context2 != null) {
                PendingIntent broadcast = PendingIntent.getBroadcast(context2.getApplicationContext(), 30, intent, SMTCommonUtility.INSTANCE.handlePendingIntent(134217728));
                Intrinsics.checkNotNullExpressionValue(broadcast, "PendingIntent.getBroadca…ent.FLAG_UPDATE_CURRENT))");
                return broadcast;
            }
            Intrinsics.throwUninitializedPropertyAccessException("context");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("context");
        throw null;
    }

    public final Task<Void> c() {
        GeofencingClient geofencingClient = this.f1143b;
        if (geofencingClient == null) {
            return null;
        }
        PendingIntent b2 = b();
        Builder builder = TaskApiCall.builder();
        builder.zaa = new zzar(b2);
        builder.zad = 2425;
        return geofencingClient.doWrite(builder.build());
    }

    public final void a(boolean z, g gVar) {
        Intrinsics.checkNotNullParameter(gVar, "mSmtInfo");
        d b2 = d.o.b(this.f1144c);
        Context context = (Context) this.f1144c.get();
        if (context != null) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str = f1140e;
            sMTLogger.i(str, "isGeoFenceEnabled: " + z);
            if (z) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("permission: ");
                SMTCommonUtility sMTCommonUtility = SMTCommonUtility.INSTANCE;
                outline73.append(sMTCommonUtility.shouldCheckPermission$smartech_release());
                Intrinsics.checkNotNullExpressionValue(context, "ctx");
                outline73.append(sMTCommonUtility.isPermissionGranted$smartech_release(context, SMTConfigConstants.LOCATION_PERMISSION_MF_KEY));
                sMTLogger.i(str, outline73.toString());
                if (!sMTCommonUtility.shouldCheckPermission$smartech_release() || sMTCommonUtility.isPermissionGranted$smartech_release(context, SMTConfigConstants.LOCATION_PERMISSION_MF_KEY)) {
                    StringBuilder outline732 = GeneratedOutlineSupport.outline73("permission: ");
                    outline732.append(sMTCommonUtility.shouldCheckLocationBGPermission$smartech_release());
                    outline732.append(sMTCommonUtility.isPermissionGranted$smartech_release(context, SMTConfigConstants.LOCATION_PERMISSION_BG_KEY));
                    sMTLogger.i(str, outline732.toString());
                    if (!sMTCommonUtility.shouldCheckLocationBGPermission$smartech_release() || sMTCommonUtility.isPermissionGranted$smartech_release(context, SMTConfigConstants.LOCATION_PERMISSION_BG_KEY)) {
                        StringBuilder outline733 = GeneratedOutlineSupport.outline73("1initialiseGeoFence: ");
                        C0007a aVar = C0007a.UPDATE_FROM_SERVER;
                        C0007a aVar2 = C0007a.UPDATE_FROM_LOCAL;
                        outline733.append(TweetUtils.arrayListOf(aVar, aVar2));
                        sMTLogger.i(str, outline733.toString());
                        ArrayList arrayListOf = TweetUtils.arrayListOf(aVar, aVar2);
                        ArrayList arrayList = new ArrayList();
                        for (Object next : arrayListOf) {
                            SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
                            String str2 = f1140e;
                            StringBuilder outline734 = GeneratedOutlineSupport.outline73("initialiseGeoFence step 1: ");
                            outline734.append(((C0007a) next).getValue());
                            sMTLogger2.i(str2, outline734.toString());
                            if (!b2.a(r2.getValue(), (String) "Registred_UserFences")) {
                                arrayList.add(next);
                            }
                        }
                        SMTLogger sMTLogger3 = SMTLogger.INSTANCE;
                        String str3 = f1140e;
                        StringBuilder outline735 = GeneratedOutlineSupport.outline73("initialiseGeoFence step 2: ");
                        outline735.append(arrayList.size());
                        sMTLogger3.i(str3, outline735.toString());
                        if (!(!arrayList.isEmpty())) {
                            arrayList = null;
                        }
                        if (arrayList != null) {
                            sMTLogger3.i(str3, "initialiseGeoFence step 3: ");
                            b2.c((List<? extends C0007a>) arrayList);
                        }
                        d.a(b2, (Integer) null, 1, (Object) null);
                        return;
                    }
                    return;
                }
                return;
            }
            com.netcore.android.e.b.a aVar3 = b.f1030c;
            aVar3.b(this.f1144c).a((String) null);
            aVar3.b(this.f1144c).b((String) null);
            b2.g();
        }
    }

    public /* synthetic */ f(WeakReference weakReference, DefaultConstructorMarker defaultConstructorMarker) {
        this(weakReference);
    }

    @SuppressLint({"MissingPermission"})
    public final Task<Void> b(List<? extends Geofence> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        GeofencingClient geofencingClient = this.f1143b;
        if (geofencingClient == null) {
            return null;
        }
        GeofencingRequest a2 = a(list);
        PendingIntent b2 = b();
        GeofencingRequest geofencingRequest = new GeofencingRequest(a2.zza, a2.zzb, a2.zzc, geofencingClient.getContextAttributionTag());
        Builder builder = TaskApiCall.builder();
        builder.zaa = new zzaq(geofencingRequest, b2);
        builder.zad = 2424;
        return geofencingClient.doWrite(builder.build());
    }

    public final Task<Void> c(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "ids");
        GeofencingClient geofencingClient = this.f1143b;
        if (geofencingClient == null) {
            return null;
        }
        Builder builder = TaskApiCall.builder();
        builder.zaa = new zzas(list);
        builder.zad = 2425;
        return geofencingClient.doWrite(builder.build());
    }

    private final GeofencingRequest a(List<? extends Geofence> list) {
        GeofencingRequest.Builder builder = new GeofencingRequest.Builder();
        builder.zzb = 5;
        builder.addGeofences(list);
        GeofencingRequest build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "GeofencingRequest.Builde…oFence)\n        }.build()");
        return build;
    }

    public static /* synthetic */ Geofence a(f fVar, String str, double d2, double d3, float f2, int i, C0007a aVar, long j, int i2, Object obj) {
        return fVar.a(str, d2, d3, f2, i, aVar, (i2 & 64) != 0 ? -1 : j);
    }

    @SuppressLint({"MissingPermission"})
    public final Geofence a(String str, double d2, double d3, float f2, int i, C0007a aVar, long j) {
        String str2 = str;
        double d4 = d2;
        double d5 = d3;
        float f3 = f2;
        Intrinsics.checkNotNullParameter(str2, HyperServices.REQUEST_ID);
        Intrinsics.checkNotNullParameter(aVar, "type");
        C0007a aVar2 = C0007a.CAMPAIGN;
        Geofence.Builder builder = new Geofence.Builder();
        Preconditions.checkNotNull(str2, "Request ID can't be set to null");
        builder.zza = str2;
        boolean z = false;
        boolean z2 = d4 >= -90.0d && d4 <= 90.0d;
        StringBuilder sb = new StringBuilder(42);
        sb.append("Invalid latitude: ");
        sb.append(d4);
        Preconditions.checkArgument(z2, sb.toString());
        boolean z3 = d5 >= -180.0d && d5 <= 180.0d;
        StringBuilder sb2 = new StringBuilder(43);
        sb2.append("Invalid longitude: ");
        sb2.append(d5);
        Preconditions.checkArgument(z3, sb2.toString());
        if (f3 > 0.0f) {
            z = true;
        }
        StringBuilder sb3 = new StringBuilder(31);
        sb3.append("Invalid radius: ");
        sb3.append(f3);
        Preconditions.checkArgument(z, sb3.toString());
        builder.zzd = 1;
        builder.zze = d4;
        builder.zzf = d5;
        builder.zzg = f3;
        builder.zzi = i * 1000;
        if (j < 0) {
            builder.zzc = -1;
        } else {
            builder.zzc = DefaultClock.zza.elapsedRealtime() + j;
        }
        builder.zzb = 7;
        String str3 = builder.zza;
        if (str3 == null) {
            throw new IllegalArgumentException("Request ID not set.");
        } else if (7 == 0) {
            throw new IllegalArgumentException("Transitions types not set.");
        } else if ((!true || !true) || builder.zzi >= 0) {
            long j2 = builder.zzc;
            if (j2 == Long.MIN_VALUE) {
                throw new IllegalArgumentException("Expiration not set.");
            } else if (builder.zzd != -1) {
                int i2 = builder.zzh;
                if (i2 >= 0) {
                    zzbe zzbe = new zzbe(str3, 7, 1, builder.zze, builder.zzf, builder.zzg, j2, i2, builder.zzi);
                    Intrinsics.checkNotNullExpressionValue(zzbe, "Geofence.Builder()\n     …\n                .build()");
                    return zzbe;
                }
                throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
            } else {
                throw new IllegalArgumentException("Geofence region not set.");
            }
        } else {
            throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
        }
    }
}
