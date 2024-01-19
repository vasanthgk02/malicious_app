package com.netcore.android.geofence;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.e.b;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.network.SMTEnumHttpMethodType;
import com.netcore.android.network.SMTNetworkManager;
import com.netcore.android.network.SMTRequestQueue;
import com.netcore.android.network.SMTResponseListener;
import com.netcore.android.network.models.SMTGeoFenceResponse;
import com.netcore.android.network.models.SMTGeoFenceResponse.SMTGeoFenceList;
import com.netcore.android.network.models.SMTRequest.Builder;
import com.netcore.android.network.models.SMTRequest.SMTApiTypeID;
import com.netcore.android.network.models.SMTResponse;
import com.netcore.android.preference.SMTPreferenceConstants;
import com.netcore.android.preference.SMTPreferenceHelper;
import com.netcore.android.preference.SMTPreferenceHelper.Companion;
import com.paynimo.android.payment.util.Constant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SMTGeoFenceService.kt */
public final class g implements SMTResponseListener {
    public static volatile g h;
    public static final a i = new a(null);

    /* renamed from: a  reason: collision with root package name */
    public final String f1147a;

    /* renamed from: b  reason: collision with root package name */
    public int f1148b;

    /* renamed from: c  reason: collision with root package name */
    public int f1149c;

    /* renamed from: d  reason: collision with root package name */
    public String f1150d;

    /* renamed from: e  reason: collision with root package name */
    public String f1151e;

    /* renamed from: f  reason: collision with root package name */
    public final WeakReference<Context> f1152f;
    public final SMTResponseListener g;

    /* compiled from: SMTGeoFenceService.kt */
    public static final class a {
        public a() {
        }

        private final g a(WeakReference<Context> weakReference, SMTResponseListener sMTResponseListener) {
            return new g(weakReference, sMTResponseListener, null);
        }

        public final g b(WeakReference<Context> weakReference, SMTResponseListener sMTResponseListener) {
            Intrinsics.checkNotNullParameter(weakReference, "context");
            Intrinsics.checkNotNullParameter(sMTResponseListener, "listner");
            g a2 = g.h;
            if (a2 == null) {
                synchronized (this) {
                    try {
                        a2 = g.h;
                        if (a2 == null) {
                            g a3 = g.i.a(weakReference, sMTResponseListener);
                            g.h = a3;
                            a2 = a3;
                        }
                    }
                }
            }
            return a2;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public g(WeakReference<Context> weakReference, SMTResponseListener sMTResponseListener) {
        this.f1152f = weakReference;
        this.g = sMTResponseListener;
        this.f1147a = "SMTGeoFenceService";
        new ArrayList();
        this.f1148b = 1;
        this.f1149c = 100;
    }

    private final String b() {
        Context context = (Context) this.f1152f.get();
        if (context == null) {
            return "";
        }
        Companion companion = SMTPreferenceHelper.Companion;
        Intrinsics.checkNotNullExpressionValue(context, "it");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "it.applicationContext");
        return companion.getAppPreferenceInstance(applicationContext, null).getString(SMTPreferenceConstants.SMT_BASE_URL_GEOFENCE);
    }

    public void onResponseFailure(SMTResponse sMTResponse) {
        Intrinsics.checkNotNullParameter(sMTResponse, Constant.TAG_RESPONSE);
        this.g.onResponseFailure(sMTResponse);
        sMTResponse.getMessage();
    }

    public void onResponseSuccess(SMTResponse sMTResponse) {
        Intrinsics.checkNotNullParameter(sMTResponse, Constant.TAG_RESPONSE);
        if (sMTResponse instanceof SMTGeoFenceResponse) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str = this.f1147a;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("response ");
            SMTGeoFenceResponse sMTGeoFenceResponse = (SMTGeoFenceResponse) sMTResponse;
            SMTGeoFenceList geoFenceList = sMTGeoFenceResponse.getGeoFenceList();
            ArrayList<c> arrayList = null;
            outline73.append(geoFenceList != null ? geoFenceList.getGeoFenceGroups() : null);
            sMTLogger.i(str, outline73.toString());
            SMTGeoFenceList geoFenceList2 = sMTGeoFenceResponse.getGeoFenceList();
            if (geoFenceList2 != null) {
                ArrayList<String> deletedGroupIds = geoFenceList2.getDeletedGroupIds();
                if (deletedGroupIds != null) {
                    b.f1030c.b(this.f1152f).a(a(deletedGroupIds));
                }
            }
            SMTGeoFenceList geoFenceList3 = sMTGeoFenceResponse.getGeoFenceList();
            if (geoFenceList3 != null) {
                ArrayList<String> deletedFenceIds = geoFenceList3.getDeletedFenceIds();
                if (deletedFenceIds != null) {
                    b.f1030c.b(this.f1152f).b(a(deletedFenceIds));
                }
            }
            SMTGeoFenceList geoFenceList4 = sMTGeoFenceResponse.getGeoFenceList();
            if (geoFenceList4 != null) {
                ArrayList<c> geoFenceGroups = geoFenceList4.getGeoFenceGroups();
                if (geoFenceGroups != null) {
                    for (c cVar : geoFenceGroups) {
                        com.netcore.android.e.b.a aVar = b.f1030c;
                        aVar.b(this.f1152f).a(cVar);
                        aVar.b(this.f1152f).a(cVar, cVar.e());
                    }
                }
            }
            Context context = (Context) this.f1152f.get();
            if (context != null) {
                Companion companion = SMTPreferenceHelper.Companion;
                Intrinsics.checkNotNullExpressionValue(context, "it");
                companion.getAppPreferenceInstance(context, null).setLong(SMTPreferenceConstants.SMT_LAST_GEOFENCE_FETCH_TIME, System.currentTimeMillis());
            }
            int i2 = 0;
            SMTGeoFenceList geoFenceList5 = sMTGeoFenceResponse.getGeoFenceList();
            if (geoFenceList5 != null) {
                ArrayList<c> geoFenceGroups2 = geoFenceList5.getGeoFenceGroups();
                if (geoFenceGroups2 != null) {
                    for (c e2 : geoFenceGroups2) {
                        i2 += e2.e().size();
                    }
                }
            }
            String str2 = this.f1147a;
            if (i2 >= this.f1149c) {
                this.f1148b++;
                a(this, this.f1150d, this.f1151e, null, 4, null);
                return;
            }
            SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("response ");
            SMTGeoFenceList geoFenceList6 = sMTGeoFenceResponse.getGeoFenceList();
            if (geoFenceList6 != null) {
                arrayList = geoFenceList6.getGeoFenceGroups();
            }
            outline732.append(arrayList);
            sMTLogger2.i(str2, outline732.toString());
            this.g.onResponseSuccess(sMTResponse);
        }
    }

    public static /* synthetic */ void a(g gVar, String str, String str2, Integer num, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            num = null;
        }
        gVar.a(str, str2, num);
    }

    public final void a(String str, String str2, Integer num) {
        this.f1150d = str;
        this.f1151e = str2;
        SMTNetworkManager.Companion.getInstance(SMTRequestQueue.Companion.getInstance()).processRequest(new Builder().setHttpMethod(SMTEnumHttpMethodType.GET).setBaseUrl(b()).setEndPoint(a(str, str2, this.f1148b, Integer.valueOf(this.f1149c), num)).setApiId(SMTApiTypeID.GEOFENCE_API).setResponseListener(this).build());
    }

    public /* synthetic */ g(WeakReference weakReference, SMTResponseListener sMTResponseListener, DefaultConstructorMarker defaultConstructorMarker) {
        this(weakReference, sMTResponseListener);
    }

    private final String a(String str, String str2, int i2, Integer num, Integer num2) {
        String str3;
        Context context = (Context) this.f1152f.get();
        if (context != null) {
            try {
                Companion companion = SMTPreferenceHelper.Companion;
                Intrinsics.checkNotNullExpressionValue(context, "it");
                SMTPreferenceHelper appPreferenceInstance = companion.getAppPreferenceInstance(context, null);
                appPreferenceInstance.getLong(SMTPreferenceConstants.SMT_LAST_GEOFENCE_FETCH_TIME);
                int i3 = appPreferenceInstance.getInt(SMTPreferenceConstants.GEOFECE_DISTANCE);
                String str4 = "geoFence?lat=" + str + "&long=" + str2 + "&page=" + i2;
                if (num != null) {
                    num.intValue();
                    str4 = str4 + "&count=" + num;
                }
                if (num2 != null) {
                    num2.intValue();
                    str4 = str4 + "&userId=" + num2;
                }
                SMTLogger sMTLogger = SMTLogger.INSTANCE;
                String str5 = this.f1147a;
                sMTLogger.internal(str5, "getGeoFenceApiEndPoint: " + b() + str3);
                return str3;
            } catch (Exception e2) {
                SMTLogger.INSTANCE.e(this.f1147a, String.valueOf(e2.getMessage()));
            }
        }
        return "";
    }

    public final String a(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "geoFenceGroupIds");
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        Iterator<String> it = arrayList.iterator();
        boolean z = true;
        while (it.hasNext()) {
            String next = it.next();
            if (z) {
                z = false;
                GeneratedOutlineSupport.outline102(sb, "'", next, "'");
            } else {
                GeneratedOutlineSupport.outline102(sb, ", '", next, "'");
            }
        }
        sb.append(")");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "inQuery.toString()");
        return sb2;
    }
}
