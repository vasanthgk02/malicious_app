package com.netcore.android.geofence;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.location.Geofence;
import com.netcore.android.e.b;
import com.netcore.android.event.SMTEventId;
import com.netcore.android.event.e;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.utility.SMTCommonUtility;
import com.userexperior.models.recording.enums.UeCustomType;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GeofenceEventsHandler.kt */
public final class a {

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f1095c;

    /* renamed from: d  reason: collision with root package name */
    public static final C0005a f1096d = new C0005a(null);

    /* renamed from: a  reason: collision with root package name */
    public final String f1097a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f1098b;

    /* renamed from: com.netcore.android.geofence.a$a  reason: collision with other inner class name */
    /* compiled from: GeofenceEventsHandler.kt */
    public static final class C0005a {
        public C0005a() {
        }

        private final a a(Context context) {
            return new a(context, null);
        }

        public final a b(Context context) {
            a aVar;
            Intrinsics.checkNotNullParameter(context, "context");
            a a2 = a.f1095c;
            if (a2 != null) {
                return a2;
            }
            synchronized (a.class) {
                try {
                    a a3 = a.f1095c;
                    if (a3 != null) {
                        aVar = a3;
                    } else {
                        aVar = a.f1096d.a(context);
                        a.f1095c = aVar;
                    }
                }
            }
            return aVar;
        }

        public /* synthetic */ C0005a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(Context context) {
        this.f1098b = context;
        this.f1097a = a.class.getSimpleName();
    }

    public final void b(List<? extends Geofence> list) {
        Intrinsics.checkNotNullParameter(list, "triggeringGeoFences");
        a(91, SMTEventId.Companion.getEventName(91), list);
    }

    public final void c(List<? extends Geofence> list) {
        Intrinsics.checkNotNullParameter(list, "triggeringGeoFences");
        a(93, SMTEventId.Companion.getEventName(93), list);
    }

    public /* synthetic */ a(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    public final void a(List<? extends Geofence> list) {
        Intrinsics.checkNotNullParameter(list, "triggeringGeoFences");
        a(92, SMTEventId.Companion.getEventName(92), list);
    }

    private final void a(int i, String str, List<? extends Geofence> list) {
        for (Geofence requestId : list) {
            String requestId2 = requestId.getRequestId();
            com.netcore.android.e.b.a aVar = b.f1030c;
            b b2 = aVar.b(new WeakReference(this.f1098b));
            Intrinsics.checkNotNullExpressionValue(requestId2, "geoFenceId");
            b d2 = b2.d(requestId2);
            if (d2 != null) {
                try {
                    if (d2.d().length() > 0) {
                        c e2 = aVar.b(new WeakReference(this.f1098b)).e(d2.d());
                        HashMap hashMap = new HashMap();
                        SMTCommonUtility sMTCommonUtility = SMTCommonUtility.INSTANCE;
                        if (sMTCommonUtility.isInteger(d2.b())) {
                            hashMap.put("geof_id", Integer.valueOf(Integer.parseInt(d2.b())));
                        } else {
                            hashMap.put("geof_id", d2.b());
                        }
                        if (sMTCommonUtility.isInteger(d2.d())) {
                            hashMap.put("geof_grp_id", Integer.valueOf(Integer.parseInt(d2.d())));
                        } else {
                            hashMap.put("geof_grp_id", d2.d());
                        }
                        if (e2 != null) {
                            hashMap.put("geof_grp_name", e2.g());
                        }
                        hashMap.put("geof_name", d2.c());
                        e.a(e.f1081f.b(this.f1098b), i, str, hashMap, "system", false, 16, null);
                        com.netcore.android.event.a.g.b(this.f1098b).d();
                    } else {
                        SMTLogger sMTLogger = SMTLogger.INSTANCE;
                        String str2 = this.f1097a;
                        Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
                        sMTLogger.e(str2, "Geofence : Error while recording the event");
                    }
                } catch (Exception e3) {
                    SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
                    String str3 = this.f1097a;
                    GeneratedOutlineSupport.outline96(str3, UeCustomType.TAG, e3, sMTLogger2, str3);
                }
            }
        }
    }
}
