package com.netcore.android.utility;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import androidx.core.content.ContextCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.updater.downloadmanager.utils.Constants;
import com.netcore.android.f.c;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.network.SMTThreadPoolManager;
import com.paynimo.android.payment.util.Constant;
import com.razorpay.AnalyticsConstants;
import com.userexperior.models.recording.enums.UeCustomType;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SMTNetworkInfo.kt */
public final class j implements com.netcore.android.f.a, c {

    /* renamed from: a  reason: collision with root package name */
    public final String f1314a = j.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public String f1315b;

    /* renamed from: c  reason: collision with root package name */
    public String f1316c;

    /* renamed from: d  reason: collision with root package name */
    public String f1317d;

    /* renamed from: e  reason: collision with root package name */
    public String f1318e;

    /* renamed from: f  reason: collision with root package name */
    public i f1319f;
    public final Context g;

    /* compiled from: SMTNetworkInfo.kt */
    public static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f1320a;

        public a(j jVar) {
            this.f1320a = jVar;
        }

        public final void run() {
            this.f1320a.h();
        }
    }

    public j(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.g = context;
        String d2 = d(context);
        if (d2 != null) {
            String lowerCase = d2.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            this.f1315b = lowerCase;
            String b2 = b(context);
            if (b2 != null) {
                String lowerCase2 = b2.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase()");
                this.f1316c = lowerCase2;
                String c2 = c(context);
                if (c2 != null) {
                    String lowerCase3 = c2.toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase3, "(this as java.lang.String).toLowerCase()");
                    this.f1317d = lowerCase3;
                    String e2 = e(context);
                    if (e2 != null) {
                        String lowerCase4 = e2.toLowerCase();
                        Intrinsics.checkNotNullExpressionValue(lowerCase4, "(this as java.lang.String).toLowerCase()");
                        this.f1318e = lowerCase4;
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    private final String b(Context context) {
        try {
            Object systemService = context.getSystemService("phone");
            if (systemService != null) {
                String networkOperatorName = ((TelephonyManager) systemService).getNetworkOperatorName();
                Intrinsics.checkNotNullExpressionValue(networkOperatorName, "manager.networkOperatorName");
                return networkOperatorName;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
        } catch (Exception e2) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str = this.f1314a;
            Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
            sMTLogger.e(str, "Error while fetching Carrier error :-" + e2);
            return "";
        }
    }

    private final String c(Context context) {
        try {
            Object systemService = context.getSystemService("phone");
            if (systemService != null) {
                String simCountryIso = ((TelephonyManager) systemService).getSimCountryIso();
                Intrinsics.checkNotNullExpressionValue(simCountryIso, "tm.simCountryIso");
                return simCountryIso;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
        } catch (Exception e2) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str = this.f1314a;
            Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
            sMTLogger.e(str, "Error while fetching country code :-" + e2);
            return "";
        }
    }

    /* access modifiers changed from: private */
    public final void h() {
        this.f1315b = d(this.g);
        this.f1316c = b(this.g);
        this.f1317d = c(this.g);
        this.f1318e = e(this.g);
    }

    public final String d() {
        return this.f1316c;
    }

    public final String e() {
        return this.f1317d;
    }

    public final String f() {
        return this.f1315b;
    }

    public final String g() {
        return this.f1318e;
    }

    private final String d(Context context) {
        try {
            if (!SMTCommonUtility.INSTANCE.isNetworkAvailable(context)) {
                return "offline";
            }
            if (!a(context)) {
                return Constants.DOWNLOAD_STATUS_UNKNOWN;
            }
            Object systemService = context.getSystemService("connectivity");
            if (systemService != null) {
                ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
                if (VERSION.SDK_INT < 23) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1) {
                        return AnalyticsConstants.WIFI;
                    }
                } else {
                    NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                    if (networkCapabilities != null && networkCapabilities.hasTransport(1)) {
                        return AnalyticsConstants.WIFI;
                    }
                }
                Object systemService2 = context.getSystemService("phone");
                if (systemService2 != null) {
                    switch (((TelephonyManager) systemService2).getNetworkType()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return "2g";
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return "3g";
                        case 13:
                            return "4g";
                        default:
                            return "unknown";
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
            }
        } catch (Exception e2) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str = this.f1314a;
            Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
            String localizedMessage = e2.getLocalizedMessage();
            Intrinsics.checkNotNullExpressionValue(localizedMessage, "e.localizedMessage");
            sMTLogger.e(str, localizedMessage);
            return "unknown";
        }
    }

    private final String e(Context context) {
        String str = "UNKNOWN";
        try {
            if (!a(context)) {
                return Constants.DOWNLOAD_STATUS_UNKNOWN;
            }
            Object systemService = context.getSystemService("phone");
            if (systemService != null) {
                switch (((TelephonyManager) systemService).getNetworkType()) {
                    case 1:
                        str = "GPRS";
                        break;
                    case 2:
                        str = "EDGE";
                        break;
                    case 3:
                        str = "UMTS";
                        break;
                    case 4:
                        str = "CDMA";
                        break;
                    case 5:
                        str = "CDMA - EvDo rev. 0";
                        break;
                    case 6:
                        str = "CDMA - EvDo rev. A";
                        break;
                    case 7:
                        str = "CDMA - 1xRTT";
                        break;
                    case 8:
                        str = "HSDPA";
                        break;
                    case 9:
                        str = "HSUPA";
                        break;
                    case 10:
                        str = "HSPA";
                        break;
                    case 11:
                        str = "iDEN";
                        break;
                    case 12:
                        str = "CDMA - EvDo rev. B";
                        break;
                    case 13:
                        str = "LTE";
                        break;
                    case 14:
                        str = "CDMA - eHRPD";
                        break;
                    case 15:
                        str = "HSPA+";
                        break;
                    case 16:
                        str = "GSM";
                        break;
                    case 17:
                        str = "TD_SCDMA";
                        break;
                    case 18:
                        str = "IWLAN";
                        break;
                }
                return str;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
        } catch (Exception e2) {
            e2.printStackTrace();
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str2 = this.f1314a;
            Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
            sMTLogger.e(str2, "Error while fetching Radio type error :-" + e2);
            return str;
        }
    }

    public void a() {
        try {
            if (this.f1319f == null) {
                this.f1319f = new i(this);
                IntentFilter intentFilter = new IntentFilter(Constant.INTENT_NETWORK_STATUS);
                Context context = this.g;
                i iVar = this.f1319f;
                if (iVar != null) {
                    context.registerReceiver(iVar, intentFilter);
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("networkStateReceiver");
                    throw null;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void b() {
        try {
            SMTThreadPoolManager.INSTANCE.getIntance().execute(new a(this));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void c() {
        try {
            if (this.f1319f != null) {
                Context context = this.g;
                i iVar = this.f1319f;
                if (iVar != null) {
                    context.unregisterReceiver(iVar);
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("networkStateReceiver");
                    throw null;
                }
            }
        } catch (IllegalStateException e2) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str = this.f1314a;
            Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
            sMTLogger.e(str, String.valueOf(e2.getMessage()));
        } catch (Exception e3) {
            SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
            String str2 = this.f1314a;
            GeneratedOutlineSupport.outline96(str2, UeCustomType.TAG, e3, sMTLogger2, str2);
        }
    }

    private final boolean a(Context context) {
        return ContextCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") == 0;
    }
}
