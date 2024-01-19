package com.netcore.android.geofence;

import android.content.Context;
import android.location.Location;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzw;
import com.netcore.android.event.SMTEventType;
import com.netcore.android.geofence.f.a.C0007a;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.network.SMTResponseListener;
import com.netcore.android.network.models.SMTGeoFenceResponse;
import com.netcore.android.network.models.SMTGeoFenceResponse.SMTGeoFenceList;
import com.netcore.android.network.models.SMTResponse;
import com.netcore.android.preference.SMTPreferenceConstants;
import com.netcore.android.preference.SMTPreferenceHelper;
import com.netcore.android.preference.SMTPreferenceHelper.Companion;
import com.paynimo.android.payment.util.Constant;
import com.twitter.sdk.android.tweetui.TweetUtils;
import com.userexperior.models.recording.enums.UeCustomType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SMTGeoFenceHandler.kt */
public final class d {
    public static volatile d n;
    public static final b o = new b(null);

    /* renamed from: a  reason: collision with root package name */
    public final String f1111a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1112b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1113c;

    /* renamed from: d  reason: collision with root package name */
    public String f1114d;

    /* renamed from: e  reason: collision with root package name */
    public String f1115e;

    /* renamed from: f  reason: collision with root package name */
    public Map<Integer, h> f1116f;
    public Map<Integer, h> g;
    public final List<String> h;
    public final List<String> i;
    public final f j;
    public final c k;
    public final i l;
    public final WeakReference<Context> m;

    /* compiled from: Comparisons.kt */
    public static final class a<T> implements Comparator<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Comparator f1117a;

        public a(Comparator comparator) {
            this.f1117a = comparator;
        }

        public final int compare(T t, T t2) {
            int compare = this.f1117a.compare(t, t2);
            return compare != 0 ? compare : TweetUtils.compareValues(Integer.valueOf(((Number) t).intValue()), Integer.valueOf(((Number) t2).intValue()));
        }
    }

    /* compiled from: SMTGeoFenceHandler.kt */
    public static final class b {
        public b() {
        }

        private final d a(WeakReference<Context> weakReference) {
            return new d(weakReference, null);
        }

        public final d b(WeakReference<Context> weakReference) {
            Intrinsics.checkNotNullParameter(weakReference, "context");
            d a2 = d.n;
            if (a2 == null) {
                synchronized (this) {
                    try {
                        a2 = d.n;
                        if (a2 == null) {
                            d a3 = d.o.a(weakReference);
                            d.n = a3;
                            a2 = a3;
                        }
                    }
                }
            }
            return a2;
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SMTGeoFenceHandler.kt */
    public static final class c implements com.netcore.android.f.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f1118a;

        public c(d dVar) {
            this.f1118a = dVar;
        }

        public void onLocationFetchFailed(Exception exc) {
            Intrinsics.checkNotNullParameter(exc, "e");
        }

        public void onLocationFetchSuccess(Location location) {
            Intrinsics.checkNotNullParameter(location, "location");
            this.f1118a.f1114d = String.valueOf(location.getLatitude());
            this.f1118a.f1115e = String.valueOf(location.getLongitude());
            if (this.f1118a.e() || this.f1118a.d()) {
                g.a(g.i.b(this.f1118a.b(), this.f1118a.l), String.valueOf(location.getLatitude()), String.valueOf(location.getLongitude()), null, 4, null);
                return;
            }
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String h = this.f1118a.f1111a;
            StringBuilder outline79 = GeneratedOutlineSupport.outline79(h, UeCustomType.TAG, "Location not changed: ");
            outline79.append(this.f1118a.f1114d);
            outline79.append("   ");
            outline79.append(this.f1118a.f1115e);
            sMTLogger.i(h, outline79.toString());
        }
    }

    /* renamed from: com.netcore.android.geofence.d$d  reason: collision with other inner class name */
    /* compiled from: Comparisons.kt */
    public static final class C0006d<T> implements Comparator<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f1119a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ double f1120b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ double f1121c;

        public C0006d(d dVar, double d2, double d3) {
            this.f1119a = dVar;
            this.f1120b = d2;
            this.f1121c = d3;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x006b  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0089  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0037  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int compare(T r7, T r8) {
            /*
                r6 = this;
                java.lang.Number r7 = (java.lang.Number) r7
                int r7 = r7.intValue()
                com.netcore.android.geofence.d r0 = r6.f1119a
                java.util.Map r1 = r0.f1116f
                java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
                java.lang.Object r1 = r1.get(r2)
                com.netcore.android.geofence.h r1 = (com.netcore.android.geofence.h) r1
                r2 = 0
                if (r1 == 0) goto L_0x0024
                com.netcore.android.geofence.b r1 = r1.a()
                if (r1 == 0) goto L_0x0024
                java.lang.String r1 = r1.e()
                goto L_0x0025
            L_0x0024:
                r1 = r2
            L_0x0025:
                com.netcore.android.geofence.d r3 = r6.f1119a
                java.util.Map r3 = r3.f1116f
                java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
                java.lang.Object r7 = r3.get(r7)
                com.netcore.android.geofence.h r7 = (com.netcore.android.geofence.h) r7
                if (r7 == 0) goto L_0x0042
                com.netcore.android.geofence.b r7 = r7.a()
                if (r7 == 0) goto L_0x0042
                java.lang.String r7 = r7.f()
                goto L_0x0043
            L_0x0042:
                r7 = r2
            L_0x0043:
                double r3 = r6.f1120b
                java.lang.String r3 = java.lang.String.valueOf(r3)
                double r4 = r6.f1121c
                java.lang.String r4 = java.lang.String.valueOf(r4)
                java.lang.Float r7 = r0.a(r1, r7, r3, r4)
                java.lang.Number r8 = (java.lang.Number) r8
                int r8 = r8.intValue()
                com.netcore.android.geofence.d r0 = r6.f1119a
                java.util.Map r1 = r0.f1116f
                java.lang.Integer r3 = java.lang.Integer.valueOf(r8)
                java.lang.Object r1 = r1.get(r3)
                com.netcore.android.geofence.h r1 = (com.netcore.android.geofence.h) r1
                if (r1 == 0) goto L_0x0076
                com.netcore.android.geofence.b r1 = r1.a()
                if (r1 == 0) goto L_0x0076
                java.lang.String r1 = r1.e()
                goto L_0x0077
            L_0x0076:
                r1 = r2
            L_0x0077:
                com.netcore.android.geofence.d r3 = r6.f1119a
                java.util.Map r3 = r3.f1116f
                java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
                java.lang.Object r8 = r3.get(r8)
                com.netcore.android.geofence.h r8 = (com.netcore.android.geofence.h) r8
                if (r8 == 0) goto L_0x0093
                com.netcore.android.geofence.b r8 = r8.a()
                if (r8 == 0) goto L_0x0093
                java.lang.String r2 = r8.f()
            L_0x0093:
                double r3 = r6.f1120b
                java.lang.String r8 = java.lang.String.valueOf(r3)
                double r3 = r6.f1121c
                java.lang.String r3 = java.lang.String.valueOf(r3)
                java.lang.Float r8 = r0.a(r1, r2, r8, r3)
                int r7 = com.twitter.sdk.android.tweetui.TweetUtils.compareValues(r7, r8)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.geofence.d.C0006d.compare(java.lang.Object, java.lang.Object):int");
        }
    }

    /* compiled from: SMTGeoFenceHandler.kt */
    public static final class e<TResult> implements OnSuccessListener<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f1122a;

        public e(d dVar) {
            this.f1122a = dVar;
        }

        /* renamed from: a */
        public final void onSuccess(Void voidR) {
            if (((Context) this.f1122a.b().get()) != null) {
                d dVar = this.f1122a;
                dVar.b(dVar.h, (String) "Registred_GeoFences");
            }
        }
    }

    /* compiled from: SMTGeoFenceHandler.kt */
    public static final class f implements OnFailureListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f1123a;

        public f(d dVar) {
            this.f1123a = dVar;
        }

        public final void onFailure(Exception exc) {
            Intrinsics.checkNotNullParameter(exc, "it");
            this.f1123a.f1111a;
            exc.getMessage();
        }
    }

    /* compiled from: SMTGeoFenceHandler.kt */
    public static final class g<TResult> implements OnSuccessListener<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ArrayList f1124a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f1125b;

        public g(ArrayList arrayList, d dVar) {
            this.f1124a = arrayList;
            this.f1125b = dVar;
        }

        /* renamed from: a */
        public final void onSuccess(Void voidR) {
            if (((Context) this.f1125b.b().get()) != null) {
                this.f1125b.a((List<String>) this.f1124a, (String) "Registred_GeoFences");
            }
        }
    }

    /* compiled from: SMTGeoFenceHandler.kt */
    public static final class h implements OnFailureListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f1126a;

        public h(ArrayList arrayList, d dVar) {
            this.f1126a = dVar;
        }

        public final void onFailure(Exception exc) {
            Intrinsics.checkNotNullParameter(exc, "it");
            exc.printStackTrace();
            this.f1126a.f1111a;
            exc.getMessage();
        }
    }

    /* compiled from: SMTGeoFenceHandler.kt */
    public static final class i implements SMTResponseListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f1127a;

        public i(d dVar) {
            this.f1127a = dVar;
        }

        public void onResponseFailure(SMTResponse sMTResponse) {
            Intrinsics.checkNotNullParameter(sMTResponse, Constant.TAG_RESPONSE);
            this.f1127a.f1111a;
            sMTResponse.getMessage();
        }

        public void onResponseSuccess(SMTResponse sMTResponse) {
            Intrinsics.checkNotNullParameter(sMTResponse, Constant.TAG_RESPONSE);
            if (sMTResponse instanceof SMTGeoFenceResponse) {
                SMTGeoFenceResponse sMTGeoFenceResponse = (SMTGeoFenceResponse) sMTResponse;
                SMTGeoFenceList geoFenceList = sMTGeoFenceResponse.getGeoFenceList();
                if (geoFenceList != null) {
                    ArrayList<String> deletedGroupIds = geoFenceList.getDeletedGroupIds();
                    if (deletedGroupIds != null) {
                        List<String> a2 = com.netcore.android.e.b.f1030c.b(this.f1127a.b()).a((List<String>) deletedGroupIds);
                        if (a2 != null) {
                            this.f1127a.i.addAll(a2);
                        }
                    }
                }
                SMTGeoFenceList geoFenceList2 = sMTGeoFenceResponse.getGeoFenceList();
                if (geoFenceList2 != null) {
                    ArrayList<String> deletedFenceIds = geoFenceList2.getDeletedFenceIds();
                    if (deletedFenceIds != null) {
                        this.f1127a.i.addAll(deletedFenceIds);
                    }
                }
                SMTLogger sMTLogger = SMTLogger.INSTANCE;
                String h = this.f1127a.f1111a;
                StringBuilder outline79 = GeneratedOutlineSupport.outline79(h, UeCustomType.TAG, "onResposneSuccess: ");
                outline79.append(this.f1127a.f1114d);
                outline79.append("  ");
                outline79.append(this.f1127a.f1115e);
                sMTLogger.i(h, outline79.toString());
                String c2 = this.f1127a.f1114d;
                boolean z = false;
                if (!(c2 == null || c2.length() == 0)) {
                    String d2 = this.f1127a.f1115e;
                    if (d2 == null || d2.length() == 0) {
                        z = true;
                    }
                    if (!z) {
                        d dVar = this.f1127a;
                        String c3 = dVar.f1114d;
                        Intrinsics.checkNotNull(c3);
                        double parseDouble = Double.parseDouble(c3);
                        String d3 = this.f1127a.f1115e;
                        Intrinsics.checkNotNull(d3);
                        dVar.a(parseDouble, Double.parseDouble(d3));
                    }
                }
            }
        }
    }

    /* compiled from: SMTGeoFenceHandler.kt */
    public static final class j implements com.netcore.android.f.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f1128a;

        public j(d dVar) {
            this.f1128a = dVar;
        }

        public void onLocationFetchFailed(Exception exc) {
            Intrinsics.checkNotNullParameter(exc, "e");
        }

        public void onLocationFetchSuccess(Location location) {
            Intrinsics.checkNotNullParameter(location, "location");
            this.f1128a.a(location.getLatitude(), location.getLongitude());
        }
    }

    /* compiled from: SMTGeoFenceHandler.kt */
    public static final class k<TResult> implements OnSuccessListener<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f1129a;

        public k(d dVar) {
            this.f1129a = dVar;
        }

        /* renamed from: a */
        public final void onSuccess(Void voidR) {
            if (((Context) this.f1129a.b().get()) != null) {
                d dVar = this.f1129a;
                dVar.b(dVar.h, (String) "Registred_GeoFences");
            }
        }
    }

    /* compiled from: SMTGeoFenceHandler.kt */
    public static final class l implements OnFailureListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f1130a;

        public l(d dVar) {
            this.f1130a = dVar;
        }

        public final void onFailure(Exception exc) {
            Intrinsics.checkNotNullParameter(exc, "it");
            this.f1130a.f1111a;
            exc.getMessage();
        }
    }

    /* compiled from: SMTGeoFenceHandler.kt */
    public static final class m<TResult> implements OnSuccessListener<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f1131a;

        public m(d dVar) {
            this.f1131a = dVar;
        }

        /* renamed from: a */
        public final void onSuccess(Void voidR) {
            Context context = (Context) this.f1131a.b().get();
            if (context != null) {
                Companion companion = SMTPreferenceHelper.Companion;
                Intrinsics.checkNotNullExpressionValue(context, "it");
                companion.getAppPreferenceInstance(context, null).setArray("Registred_GeoFences", new ArrayList());
            }
        }
    }

    /* compiled from: SMTGeoFenceHandler.kt */
    public static final class n implements OnFailureListener {

        /* renamed from: a  reason: collision with root package name */
        public static final n f1132a = new n();

        public final void onFailure(Exception exc) {
            Intrinsics.checkNotNullParameter(exc, "it");
        }
    }

    /* compiled from: SMTGeoFenceHandler.kt */
    public static final class o implements com.netcore.android.f.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f1133a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f1134b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f1135c;

        /* compiled from: SMTGeoFenceHandler.kt */
        public static final class a<TResult> implements OnSuccessListener<Void> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ o f1136a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ ArrayList f1137b;

            public a(o oVar, ArrayList arrayList) {
                this.f1136a = oVar;
                this.f1137b = arrayList;
            }

            /* renamed from: a */
            public final void onSuccess(Void voidR) {
                if (((Context) this.f1136a.f1134b.b().get()) != null) {
                    this.f1136a.f1134b.a((List<String>) this.f1137b, (String) "Registred_UserFences");
                }
            }
        }

        public o(Context context, d dVar, List list) {
            this.f1133a = context;
            this.f1134b = dVar;
            this.f1135c = list;
        }

        public void onLocationFetchFailed(Exception exc) {
            Intrinsics.checkNotNullParameter(exc, "e");
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0050 A[Catch:{ Exception -> 0x0086 }] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0053 A[Catch:{ Exception -> 0x0086 }] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0059 A[Catch:{ Exception -> 0x0086 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onLocationFetchSuccess(android.location.Location r21) {
            /*
                r20 = this;
                r1 = r20
                java.lang.String r0 = "location"
                r2 = r21
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>()
                java.util.ArrayList r4 = new java.util.ArrayList
                r4.<init>()
                java.util.List r0 = r1.f1135c
                java.util.Iterator r5 = r0.iterator()
            L_0x0019:
                boolean r0 = r5.hasNext()
                r6 = 1
                if (r0 == 0) goto L_0x0090
                java.lang.Object r0 = r5.next()
                com.netcore.android.geofence.f$a$a r0 = (com.netcore.android.geofence.f.a.C0007a) r0
                com.netcore.android.geofence.f$a$a r7 = com.netcore.android.geofence.f.a.C0007a.UPDATE_FROM_SERVER     // Catch:{ Exception -> 0x0086 }
                if (r0 != r7) goto L_0x002d
                java.lang.String r7 = "serverRefreshGeoFenceDistanceConfig"
                goto L_0x002f
            L_0x002d:
                java.lang.String r7 = "appRefreshGeoFenceDistanceConfig"
            L_0x002f:
                com.netcore.android.preference.SMTPreferenceHelper$Companion r8 = com.netcore.android.preference.SMTPreferenceHelper.Companion     // Catch:{ Exception -> 0x0086 }
                android.content.Context r9 = r1.f1133a     // Catch:{ Exception -> 0x0086 }
                java.lang.String r10 = "ctx"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)     // Catch:{ Exception -> 0x0086 }
                r10 = 0
                com.netcore.android.preference.SMTPreferenceHelper r8 = r8.getAppPreferenceInstance(r9, r10)     // Catch:{ Exception -> 0x0086 }
                java.lang.String r7 = r8.getString(r7)     // Catch:{ Exception -> 0x0086 }
                if (r7 == 0) goto L_0x004c
                int r8 = r7.length()     // Catch:{ Exception -> 0x0086 }
                if (r8 != 0) goto L_0x004a
                goto L_0x004c
            L_0x004a:
                r8 = 0
                goto L_0x004d
            L_0x004c:
                r8 = 1
            L_0x004d:
                r6 = r6 ^ r8
                if (r6 == 0) goto L_0x0051
                r10 = r7
            L_0x0051:
                if (r10 == 0) goto L_0x0059
                float r6 = java.lang.Float.parseFloat(r10)     // Catch:{ Exception -> 0x0086 }
                r13 = r6
                goto L_0x005d
            L_0x0059:
                r6 = 1157234688(0x44fa0000, float:2000.0)
                r13 = 1157234688(0x44fa0000, float:2000.0)
            L_0x005d:
                com.netcore.android.geofence.d r6 = r1.f1134b     // Catch:{ Exception -> 0x0086 }
                com.netcore.android.geofence.f r7 = r6.j     // Catch:{ Exception -> 0x0086 }
                java.lang.String r8 = r0.getValue()     // Catch:{ Exception -> 0x0086 }
                double r9 = r21.getLatitude()     // Catch:{ Exception -> 0x0086 }
                double r11 = r21.getLongitude()     // Catch:{ Exception -> 0x0086 }
                r14 = 0
                r16 = 0
                r18 = 64
                r19 = 0
                r15 = r0
                com.google.android.gms.location.Geofence r6 = com.netcore.android.geofence.f.a(r7, r8, r9, r11, r13, r14, r15, r16, r18, r19)     // Catch:{ Exception -> 0x0086 }
                r3.add(r6)     // Catch:{ Exception -> 0x0086 }
                java.lang.String r0 = r0.getValue()     // Catch:{ Exception -> 0x0086 }
                r4.add(r0)     // Catch:{ Exception -> 0x0086 }
                goto L_0x0019
            L_0x0086:
                r0 = move-exception
                com.netcore.android.geofence.d r6 = r1.f1134b
                r6.f1111a
                r0.getMessage()
                goto L_0x0019
            L_0x0090:
                com.netcore.android.logger.SMTLogger r0 = com.netcore.android.logger.SMTLogger.INSTANCE
                com.netcore.android.geofence.d r2 = r1.f1134b
                java.lang.String r2 = r2.f1111a
                java.lang.String r5 = "TAG"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r7 = "RegisterGeoFence onLocationFetchSuccess: "
                r5.append(r7)
                r5.append(r3)
                java.lang.String r5 = r5.toString()
                r0.i(r2, r5)
                boolean r0 = r3.isEmpty()
                r0 = r0 ^ r6
                if (r0 == 0) goto L_0x00d7
                com.netcore.android.geofence.d r0 = r1.f1134b
                com.netcore.android.geofence.f r0 = r0.j
                com.google.android.gms.tasks.Task r0 = r0.b(r3)
                if (r0 == 0) goto L_0x00d7
                com.netcore.android.geofence.d$o$a r2 = new com.netcore.android.geofence.d$o$a
                r2.<init>(r1, r4)
                com.google.android.gms.tasks.zzw r0 = (com.google.android.gms.tasks.zzw) r0
                java.util.concurrent.Executor r3 = com.google.android.gms.tasks.TaskExecutors.MAIN_THREAD
                r0.addOnSuccessListener(r3, r2)
                com.netcore.android.geofence.e r2 = com.netcore.android.geofence.e.f1138a
                java.util.concurrent.Executor r3 = com.google.android.gms.tasks.TaskExecutors.MAIN_THREAD
                r0.addOnFailureListener(r3, r2)
            L_0x00d7:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.geofence.d.o.onLocationFetchSuccess(android.location.Location):void");
        }
    }

    public d(WeakReference<Context> weakReference) {
        this.m = weakReference;
        this.f1111a = d.class.getSimpleName();
        this.f1112b = SMTEventType.EVENT_TYPE_CUSTOM;
        this.f1113c = 98;
        this.f1116f = new LinkedHashMap();
        this.g = new LinkedHashMap();
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = f.f1141f.b(weakReference);
        Map<Integer, h> c2 = c();
        if (c2 != null) {
            this.g = c2;
        }
        this.k = new c(this);
        this.l = new i(this);
    }

    /* access modifiers changed from: private */
    public final boolean d() {
        Context context = (Context) this.m.get();
        if (context != null) {
            try {
                Companion companion = SMTPreferenceHelper.Companion;
                Intrinsics.checkNotNullExpressionValue(context, "it");
                SMTPreferenceHelper appPreferenceInstance = companion.getAppPreferenceInstance(context, null);
                long parseLong = Long.parseLong(com.netcore.android.inapp.g.f1213b.b(appPreferenceInstance.getString(SMTPreferenceConstants.GEOFECE_LAST_MODIFIED_DATE)));
                long j2 = appPreferenceInstance.getLong(SMTPreferenceConstants.GEOFECE_LAST_MODIFIED_DATE_SDK, 0);
                SMTLogger sMTLogger = SMTLogger.INSTANCE;
                String str = this.f1111a;
                Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
                sMTLogger.i(str, "isGeoFencesModified: " + parseLong + " --- " + j2);
                if (parseLong == j2) {
                    return false;
                }
                appPreferenceInstance.setLong(SMTPreferenceConstants.GEOFECE_LAST_MODIFIED_DATE_SDK, parseLong);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final boolean e() {
        Context context = (Context) this.m.get();
        if (context == null) {
            return true;
        }
        Companion companion = SMTPreferenceHelper.Companion;
        Intrinsics.checkNotNullExpressionValue(context, "it");
        SMTPreferenceHelper appPreferenceInstance = companion.getAppPreferenceInstance(context, null);
        if ((!Intrinsics.areEqual(this.f1114d, appPreferenceInstance.getString(SMTPreferenceConstants.GEOFECE_LATITUDE))) || (!Intrinsics.areEqual(this.f1115e, appPreferenceInstance.getString(SMTPreferenceConstants.GEOFECE_LONGITUDE)))) {
            appPreferenceInstance.setString(SMTPreferenceConstants.GEOFECE_LATITUDE, String.valueOf(this.f1114d));
            appPreferenceInstance.setString(SMTPreferenceConstants.GEOFECE_LONGITUDE, String.valueOf(this.f1115e));
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str = this.f1111a;
            Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
            sMTLogger.i(str, "isLocationChanged: true");
            return true;
        }
        SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
        String str2 = this.f1111a;
        Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
        sMTLogger2.i(str2, "isLocationChanged: false");
        return false;
    }

    public final void c(List<? extends C0007a> list) {
        Intrinsics.checkNotNullParameter(list, "syncType");
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str = this.f1111a;
        Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
        sMTLogger.i(str, "UserLocationFenct type: " + list);
        Context context = (Context) this.m.get();
        if (context != null) {
            Intrinsics.checkNotNullExpressionValue(context, "ctx");
            new com.netcore.android.geofence.i.a(context).a(new o(context, this, list)).a().a();
        }
    }

    public final void f() {
        Context context = (Context) this.m.get();
        if (context != null) {
            Intrinsics.checkNotNullExpressionValue(context, "it");
            new com.netcore.android.geofence.i.a(context).a(new j(this)).a().a();
        }
    }

    public final void g() {
        if (((Context) this.m.get()) != null) {
            Task<Void> c2 = this.j.c();
            if (c2 != null) {
                zzw zzw = (zzw) c2;
                zzw.addOnSuccessListener(TaskExecutors.MAIN_THREAD, (OnSuccessListener<? super TResult>) new m<Object>(this));
                zzw.addOnFailureListener(TaskExecutors.MAIN_THREAD, n.f1132a);
            }
        }
    }

    public final WeakReference<Context> b() {
        return this.m;
    }

    public final void b(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "ids");
        Task<Void> c2 = this.j.c(list);
        if (c2 != null) {
            zzw zzw = (zzw) c2;
            zzw.addOnSuccessListener(TaskExecutors.MAIN_THREAD, (OnSuccessListener<? super TResult>) new k<Object>(this));
            zzw.addOnFailureListener(TaskExecutors.MAIN_THREAD, new l(this));
        }
    }

    private final Map<Integer, h> c() {
        Context context = (Context) this.m.get();
        if (context == null) {
            return null;
        }
        Companion companion = SMTPreferenceHelper.Companion;
        Intrinsics.checkNotNullExpressionValue(context, "it");
        List<String> array = companion.getAppPreferenceInstance(context, null).getArray("Registred_GeoFences");
        if (!array.isEmpty()) {
            return com.netcore.android.e.b.f1030c.b(this.m).b(array);
        }
        return null;
    }

    public static /* synthetic */ void a(d dVar, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = null;
        }
        dVar.a(num);
    }

    public final void a(Integer num) {
        Context context = (Context) this.m.get();
        if (context != null) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str = this.f1111a;
            Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
            sMTLogger.i(str, "SynWithServer");
            Intrinsics.checkNotNullExpressionValue(context, "it");
            new com.netcore.android.geofence.i.a(context).a(this.k).a().a();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b3 A[Catch:{ Exception -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d6 A[Catch:{ Exception -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00f9 A[Catch:{ Exception -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0102 A[Catch:{ Exception -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x011a A[Catch:{ Exception -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x011c A[Catch:{ Exception -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x011f A[Catch:{ Exception -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0120 A[Catch:{ Exception -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0123 A[Catch:{ Exception -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x013c A[Catch:{ Exception -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0141 A[Catch:{ Exception -> 0x014b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void b(java.util.Map<java.lang.Integer, com.netcore.android.geofence.h> r25) {
        /*
            r24 = this;
            r1 = r24
            if (r25 == 0) goto L_0x017f
            boolean r0 = r25.isEmpty()
            r2 = 1
            r0 = r0 ^ r2
            r3 = 0
            if (r0 == 0) goto L_0x0010
            r0 = r25
            goto L_0x0011
        L_0x0010:
            r0 = r3
        L_0x0011:
            if (r0 == 0) goto L_0x017f
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r6 = r0.iterator()
        L_0x0025:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x0151
            java.lang.Object r0 = r6.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r7 = r0.getValue()     // Catch:{ Exception -> 0x014b }
            com.netcore.android.geofence.h r7 = (com.netcore.android.geofence.h) r7     // Catch:{ Exception -> 0x014b }
            com.netcore.android.geofence.c r7 = r7.b()     // Catch:{ Exception -> 0x014b }
            if (r7 == 0) goto L_0x0042
            java.lang.String r7 = r7.d()     // Catch:{ Exception -> 0x014b }
            goto L_0x0043
        L_0x0042:
            r7 = r3
        L_0x0043:
            java.lang.String r8 = r1.f1112b     // Catch:{ Exception -> 0x014b }
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r8)     // Catch:{ Exception -> 0x014b }
            r8 = -1
            if (r7 == 0) goto L_0x006b
            com.netcore.android.utility.SMTCommonUtility r7 = com.netcore.android.utility.SMTCommonUtility.INSTANCE     // Catch:{ Exception -> 0x014b }
            java.lang.Object r10 = r0.getValue()     // Catch:{ Exception -> 0x014b }
            com.netcore.android.geofence.h r10 = (com.netcore.android.geofence.h) r10     // Catch:{ Exception -> 0x014b }
            com.netcore.android.geofence.c r10 = r10.b()     // Catch:{ Exception -> 0x014b }
            if (r10 == 0) goto L_0x0060
            java.lang.String r10 = r10.c()     // Catch:{ Exception -> 0x014b }
            goto L_0x0061
        L_0x0060:
            r10 = r3
        L_0x0061:
            long r10 = r7.convertStringDatetoTimeStamp(r10)     // Catch:{ Exception -> 0x014b }
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x014b }
            long r10 = r10 - r12
            goto L_0x006c
        L_0x006b:
            r10 = r8
        L_0x006c:
            com.netcore.android.geofence.f r12 = r1.j     // Catch:{ Exception -> 0x014b }
            java.lang.Object r7 = r0.getValue()     // Catch:{ Exception -> 0x014b }
            com.netcore.android.geofence.h r7 = (com.netcore.android.geofence.h) r7     // Catch:{ Exception -> 0x014b }
            com.netcore.android.geofence.b r7 = r7.a()     // Catch:{ Exception -> 0x014b }
            if (r7 == 0) goto L_0x007f
            java.lang.String r7 = r7.b()     // Catch:{ Exception -> 0x014b }
            goto L_0x0080
        L_0x007f:
            r7 = r3
        L_0x0080:
            java.lang.String r13 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x014b }
            java.lang.Object r7 = r0.getValue()     // Catch:{ Exception -> 0x014b }
            com.netcore.android.geofence.h r7 = (com.netcore.android.geofence.h) r7     // Catch:{ Exception -> 0x014b }
            com.netcore.android.geofence.b r7 = r7.a()     // Catch:{ Exception -> 0x014b }
            if (r7 == 0) goto L_0x009f
            java.lang.String r7 = r7.e()     // Catch:{ Exception -> 0x014b }
            if (r7 == 0) goto L_0x009f
            double r14 = java.lang.Double.parseDouble(r7)     // Catch:{ Exception -> 0x014b }
            java.lang.Double r7 = java.lang.Double.valueOf(r14)     // Catch:{ Exception -> 0x014b }
            goto L_0x00a0
        L_0x009f:
            r7 = r3
        L_0x00a0:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch:{ Exception -> 0x014b }
            double r14 = r7.doubleValue()     // Catch:{ Exception -> 0x014b }
            java.lang.Object r7 = r0.getValue()     // Catch:{ Exception -> 0x014b }
            com.netcore.android.geofence.h r7 = (com.netcore.android.geofence.h) r7     // Catch:{ Exception -> 0x014b }
            com.netcore.android.geofence.b r7 = r7.a()     // Catch:{ Exception -> 0x014b }
            if (r7 == 0) goto L_0x00c2
            java.lang.String r7 = r7.f()     // Catch:{ Exception -> 0x014b }
            if (r7 == 0) goto L_0x00c2
            double r16 = java.lang.Double.parseDouble(r7)     // Catch:{ Exception -> 0x014b }
            java.lang.Double r7 = java.lang.Double.valueOf(r16)     // Catch:{ Exception -> 0x014b }
            goto L_0x00c3
        L_0x00c2:
            r7 = r3
        L_0x00c3:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch:{ Exception -> 0x014b }
            double r16 = r7.doubleValue()     // Catch:{ Exception -> 0x014b }
            java.lang.Object r7 = r0.getValue()     // Catch:{ Exception -> 0x014b }
            com.netcore.android.geofence.h r7 = (com.netcore.android.geofence.h) r7     // Catch:{ Exception -> 0x014b }
            com.netcore.android.geofence.b r7 = r7.a()     // Catch:{ Exception -> 0x014b }
            if (r7 == 0) goto L_0x00e5
            java.lang.String r7 = r7.g()     // Catch:{ Exception -> 0x014b }
            if (r7 == 0) goto L_0x00e5
            float r7 = java.lang.Float.parseFloat(r7)     // Catch:{ Exception -> 0x014b }
            java.lang.Float r7 = java.lang.Float.valueOf(r7)     // Catch:{ Exception -> 0x014b }
            goto L_0x00e6
        L_0x00e5:
            r7 = r3
        L_0x00e6:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch:{ Exception -> 0x014b }
            float r18 = r7.floatValue()     // Catch:{ Exception -> 0x014b }
            java.lang.Object r7 = r0.getValue()     // Catch:{ Exception -> 0x014b }
            com.netcore.android.geofence.h r7 = (com.netcore.android.geofence.h) r7     // Catch:{ Exception -> 0x014b }
            com.netcore.android.geofence.c r7 = r7.b()     // Catch:{ Exception -> 0x014b }
            if (r7 == 0) goto L_0x0102
            int r7 = r7.b()     // Catch:{ Exception -> 0x014b }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x014b }
            goto L_0x0103
        L_0x0102:
            r7 = r3
        L_0x0103:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch:{ Exception -> 0x014b }
            int r19 = r7.intValue()     // Catch:{ Exception -> 0x014b }
            com.netcore.android.geofence.f$a$a r20 = com.netcore.android.geofence.f.a.C0007a.CAMPAIGN     // Catch:{ Exception -> 0x014b }
            java.lang.Long r7 = java.lang.Long.valueOf(r10)     // Catch:{ Exception -> 0x014b }
            long r10 = r7.longValue()     // Catch:{ Exception -> 0x014b }
            r21 = 0
            int r23 = (r10 > r21 ? 1 : (r10 == r21 ? 0 : -1))
            if (r23 <= 0) goto L_0x011c
            r10 = 1
            goto L_0x011d
        L_0x011c:
            r10 = 0
        L_0x011d:
            if (r10 == 0) goto L_0x0120
            goto L_0x0121
        L_0x0120:
            r7 = r3
        L_0x0121:
            if (r7 == 0) goto L_0x0127
            long r8 = r7.longValue()     // Catch:{ Exception -> 0x014b }
        L_0x0127:
            r21 = r8
            com.google.android.gms.location.Geofence r7 = r12.a(r13, r14, r16, r18, r19, r20, r21)     // Catch:{ Exception -> 0x014b }
            r4.add(r7)     // Catch:{ Exception -> 0x014b }
            java.lang.Object r0 = r0.getValue()     // Catch:{ Exception -> 0x014b }
            com.netcore.android.geofence.h r0 = (com.netcore.android.geofence.h) r0     // Catch:{ Exception -> 0x014b }
            com.netcore.android.geofence.b r0 = r0.a()     // Catch:{ Exception -> 0x014b }
            if (r0 == 0) goto L_0x0141
            java.lang.String r0 = r0.b()     // Catch:{ Exception -> 0x014b }
            goto L_0x0142
        L_0x0141:
            r0 = r3
        L_0x0142:
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x014b }
            r5.add(r0)     // Catch:{ Exception -> 0x014b }
            goto L_0x0025
        L_0x014b:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0025
        L_0x0151:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "registerGeoFences: "
            r0.append(r2)
            r0.append(r4)
            r0.toString()
            com.netcore.android.geofence.f r0 = r1.j
            com.google.android.gms.tasks.Task r0 = r0.b(r4)
            if (r0 == 0) goto L_0x017f
            com.netcore.android.geofence.d$g r2 = new com.netcore.android.geofence.d$g
            r2.<init>(r5, r1)
            com.google.android.gms.tasks.zzw r0 = (com.google.android.gms.tasks.zzw) r0
            java.util.concurrent.Executor r3 = com.google.android.gms.tasks.TaskExecutors.MAIN_THREAD
            r0.addOnSuccessListener(r3, r2)
            com.netcore.android.geofence.d$h r2 = new com.netcore.android.geofence.d$h
            r2.<init>(r5, r1)
            java.util.concurrent.Executor r3 = com.google.android.gms.tasks.TaskExecutors.MAIN_THREAD
            r0.addOnFailureListener(r3, r2)
        L_0x017f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.geofence.d.b(java.util.Map):void");
    }

    /* access modifiers changed from: private */
    public final void a(double d2, double d3) {
        List list;
        Map map;
        Map<Integer, h> a2 = com.netcore.android.e.b.f1030c.b(this.m).a(d2, d3);
        if (a2 != null) {
            this.f1116f = a2;
        }
        a(this.i);
        a(this.g);
        if (this.h.size() > 0) {
            Task<Void> c2 = this.j.c(this.h);
            if (c2 != null) {
                zzw zzw = (zzw) c2;
                zzw.addOnSuccessListener(TaskExecutors.MAIN_THREAD, (OnSuccessListener<? super TResult>) new e<Object>(this));
                zzw.addOnFailureListener(TaskExecutors.MAIN_THREAD, new f(this));
            }
        }
        Context context = (Context) this.m.get();
        if (context != null) {
            Map<Integer, h> map2 = this.f1116f;
            C0006d dVar = new C0006d(this, d2, d3);
            a aVar = new a(dVar);
            Intrinsics.checkNotNullParameter(map2, "<this>");
            Intrinsics.checkNotNullParameter(aVar, "comparator");
            TreeMap treeMap = new TreeMap(aVar);
            treeMap.putAll(map2);
            Intrinsics.checkNotNullParameter(treeMap, "<this>");
            if (treeMap.size() == 0) {
                list = EmptyList.INSTANCE;
            } else {
                Iterator it = treeMap.entrySet().iterator();
                if (!it.hasNext()) {
                    list = EmptyList.INSTANCE;
                } else {
                    Entry entry = (Entry) it.next();
                    if (!it.hasNext()) {
                        list = TweetUtils.listOf(new Pair(entry.getKey(), entry.getValue()));
                    } else {
                        ArrayList arrayList = new ArrayList(treeMap.size());
                        arrayList.add(new Pair(entry.getKey(), entry.getValue()));
                        do {
                            Entry entry2 = (Entry) it.next();
                            arrayList.add(new Pair(entry2.getKey(), entry2.getValue()));
                        } while (it.hasNext());
                        list = arrayList;
                    }
                }
            }
            Intrinsics.checkNotNullExpressionValue(context, "it");
            "processGeoFences: " + map;
            if (!map.isEmpty()) {
                b(map);
            }
        }
    }

    public /* synthetic */ d(WeakReference weakReference, DefaultConstructorMarker defaultConstructorMarker) {
        this(weakReference);
    }

    /* access modifiers changed from: private */
    public final void b(List<String> list, String str) {
        Context context = (Context) this.m.get();
        if (context != null) {
            Companion companion = SMTPreferenceHelper.Companion;
            Intrinsics.checkNotNullExpressionValue(context, "it");
            List<String> array = companion.getAppPreferenceInstance(context, null).getArray(str);
            ArrayList arrayList = new ArrayList();
            for (String str2 : array) {
                if (list.contains(str2)) {
                    str2 = null;
                }
                if (str2 != null) {
                    arrayList.add(str2);
                }
            }
            SMTPreferenceHelper.Companion.getAppPreferenceInstance(context, null).setArray(str, arrayList);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x000a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(java.util.Map<java.lang.Integer, com.netcore.android.geofence.h> r6) {
        /*
            r5 = this;
            if (r6 == 0) goto L_0x00ac
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x000a:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x00ac
            java.lang.Object r0 = r6.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.util.Map<java.lang.Integer, com.netcore.android.geofence.h> r1 = r5.f1116f
            java.lang.Object r2 = r0.getKey()
            java.lang.Object r1 = r1.get(r2)
            com.netcore.android.geofence.h r1 = (com.netcore.android.geofence.h) r1
            if (r1 == 0) goto L_0x0097
            com.netcore.android.geofence.c r2 = r1.b()
            if (r2 == 0) goto L_0x0076
            java.lang.Object r3 = r0.getValue()
            com.netcore.android.geofence.h r3 = (com.netcore.android.geofence.h) r3
            com.netcore.android.geofence.c r3 = r3.b()
            boolean r2 = r2.a(r3)
            r3 = 1
            if (r2 != r3) goto L_0x0076
            com.netcore.android.geofence.b r2 = r1.a()
            if (r2 == 0) goto L_0x0076
            java.lang.Object r4 = r0.getValue()
            com.netcore.android.geofence.h r4 = (com.netcore.android.geofence.h) r4
            com.netcore.android.geofence.b r4 = r4.a()
            boolean r2 = r2.a(r4)
            if (r2 != r3) goto L_0x0076
            com.netcore.android.geofence.b r1 = r1.a()
            if (r1 == 0) goto L_0x0092
            java.lang.String r1 = r1.b()
            if (r1 == 0) goto L_0x0092
            java.util.List<java.lang.String> r1 = r5.h
            java.lang.Object r2 = r0.getKey()
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            boolean r1 = r1.add(r2)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            goto L_0x0093
        L_0x0076:
            com.netcore.android.geofence.b r1 = r1.a()
            if (r1 == 0) goto L_0x0092
            java.lang.String r1 = r1.b()
            if (r1 == 0) goto L_0x0092
            java.lang.Integer.parseInt(r1)
            java.util.Map<java.lang.Integer, com.netcore.android.geofence.h> r1 = r5.f1116f
            java.lang.Object r2 = r0.getKey()
            java.lang.Object r1 = r1.remove(r2)
            com.netcore.android.geofence.h r1 = (com.netcore.android.geofence.h) r1
            goto L_0x0093
        L_0x0092:
            r1 = 0
        L_0x0093:
            if (r1 == 0) goto L_0x0097
            goto L_0x000a
        L_0x0097:
            java.util.List<java.lang.String> r1 = r5.h
            java.lang.Object r0 = r0.getKey()
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r1.add(r0)
            goto L_0x000a
        L_0x00ac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.geofence.d.a(java.util.Map):void");
    }

    private final void a(List<String> list) {
        for (String parseInt : list) {
            this.g.remove(Integer.valueOf(Integer.parseInt(parseInt)));
        }
        b(list, (String) "Registred_GeoFences");
    }

    /* access modifiers changed from: private */
    public final void a(List<String> list, String str) {
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str2 = this.f1111a;
        Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
        sMTLogger.i(str2, "AddIdsInPref: " + list + "  --  " + str);
        Context context = (Context) this.m.get();
        if (context != null) {
            Companion companion = SMTPreferenceHelper.Companion;
            Intrinsics.checkNotNullExpressionValue(context, "it");
            companion.getAppPreferenceInstance(context, null).setArray(str, ArraysKt___ArraysJvmKt.plus((Collection<? extends T>) companion.getAppPreferenceInstance(context, null).getArray(str), (Iterable<? extends T>) list));
        }
    }

    public final boolean a(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "ids");
        Intrinsics.checkNotNullParameter(str2, "key");
        Context context = (Context) this.m.get();
        if (context == null) {
            return false;
        }
        Companion companion = SMTPreferenceHelper.Companion;
        Intrinsics.checkNotNullExpressionValue(context, "it");
        return companion.getAppPreferenceInstance(context, null).getArray(str2).contains(str);
    }

    private final int a(Context context, int i2) {
        Integer num = null;
        Integer valueOf = Integer.valueOf(this.f1113c - SMTPreferenceHelper.Companion.getAppPreferenceInstance(context, null).getArray("Registred_GeoFences").size());
        if (valueOf.intValue() < i2) {
            num = valueOf;
        }
        return num != null ? num.intValue() : i2;
    }

    /* access modifiers changed from: private */
    public final Float a(String str, String str2, String str3, String str4) {
        try {
            Location location = new Location("");
            Intrinsics.checkNotNull(str);
            location.setLatitude(Double.parseDouble(str));
            Intrinsics.checkNotNull(str2);
            location.setLongitude(Double.parseDouble(str2));
            Location location2 = new Location("");
            Intrinsics.checkNotNull(str3);
            location2.setLatitude(Double.parseDouble(str3));
            Intrinsics.checkNotNull(str4);
            location2.setLongitude(Double.parseDouble(str4));
            return Float.valueOf(location.distanceTo(location2));
        } catch (Exception e2) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str5 = this.f1111a;
            GeneratedOutlineSupport.outline96(str5, UeCustomType.TAG, e2, sMTLogger, str5);
            return null;
        }
    }
}
