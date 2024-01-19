package com.netcore.android.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.netcore.android.SMTConfigConstants;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.network.SMTThreadPoolManager;
import com.netcore.android.preference.SMTGUIDPreferenceHelper;
import com.netcore.android.preference.SMTPreferenceConstants;
import com.netcore.android.preference.SMTPreferenceHelper;
import com.netcore.android.preference.SMTPreferenceHelper.Companion;
import com.userexperior.models.recording.enums.UeCustomType;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

/* compiled from: SMTDeviceInfo.kt */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f1277a = d.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public final String f1278b = "android";

    /* renamed from: c  reason: collision with root package name */
    public final String f1279c = t();

    /* renamed from: d  reason: collision with root package name */
    public final String f1280d;

    /* renamed from: e  reason: collision with root package name */
    public final String f1281e;

    /* renamed from: f  reason: collision with root package name */
    public final String f1282f;
    public final String g;
    public final String h;
    public final String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public e n;
    public final Context o;

    /* compiled from: SMTDeviceInfo.kt */
    public static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f1283a;

        public a(d dVar) {
            this.f1283a = dVar;
        }

        public final void run() {
            d dVar = this.f1283a;
            Companion companion = SMTPreferenceHelper.Companion;
            dVar.a(companion.getAppPreferenceInstance(dVar.o, null).getString(SMTPreferenceConstants.SMT_LAST_KNOWN_LATITUDE));
            d dVar2 = this.f1283a;
            dVar2.b(companion.getAppPreferenceInstance(dVar2.o, null).getString(SMTPreferenceConstants.SMT_LAST_KNOWN_LONGITUDE));
            if (companion.getAppPreferenceInstance(this.f1283a.o, null).getInt(SMTPreferenceConstants.SMT_MF_IS_AUTO_FETCH_LOCATION, 0) == 1) {
                SMTCommonUtility sMTCommonUtility = SMTCommonUtility.INSTANCE;
                if (!sMTCommonUtility.shouldCheckPermission$smartech_release()) {
                    d dVar3 = this.f1283a;
                    dVar3.n = new e(dVar3.o, this.f1283a.k());
                    d.b(this.f1283a).a();
                } else if (sMTCommonUtility.isPermissionGranted$smartech_release(this.f1283a.o, SMTConfigConstants.LOCATION_PERMISSION_MF_KEY)) {
                    d dVar4 = this.f1283a;
                    dVar4.n = new e(dVar4.o, this.f1283a.k());
                    d.b(this.f1283a).a();
                }
            }
        }
    }

    /* compiled from: SMTDeviceInfo.kt */
    public static final class b implements com.netcore.android.f.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f1284a;

        public b(d dVar) {
            this.f1284a = dVar;
        }

        public void onLocationFetchFailed(Exception exc) {
            Intrinsics.checkNotNullParameter(exc, "e");
            d dVar = this.f1284a;
            Companion companion = SMTPreferenceHelper.Companion;
            dVar.a(companion.getAppPreferenceInstance(dVar.o, null).getString(SMTPreferenceConstants.SMT_LAST_KNOWN_LATITUDE));
            d dVar2 = this.f1284a;
            dVar2.b(companion.getAppPreferenceInstance(dVar2.o, null).getString(SMTPreferenceConstants.SMT_LAST_KNOWN_LONGITUDE));
        }

        public void onLocationFetchSuccess(Location location) {
            Intrinsics.checkNotNullParameter(location, "location");
            this.f1284a.a(location);
        }
    }

    public d(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.o = context;
        String m2 = m();
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "Locale.getDefault()");
        if (m2 != null) {
            String lowerCase = m2.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            this.f1280d = lowerCase;
            String n2 = n();
            Locale locale2 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale2, "Locale.getDefault()");
            if (n2 != null) {
                String lowerCase2 = n2.toLowerCase(locale2);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                this.f1281e = lowerCase2;
                this.f1282f = String.valueOf(c(context));
                this.g = String.valueOf(a(context));
                this.h = new SimpleDateFormat("ZZZZ", Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis()));
                Locale locale3 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale3, "Locale.getDefault()");
                String language = locale3.getLanguage();
                Intrinsics.checkNotNullExpressionValue(language, "Locale.getDefault().language");
                String lowerCase3 = language.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "(this as java.lang.String).toLowerCase()");
                this.i = lowerCase3;
                this.j = "";
                this.k = "";
                this.l = IdManager.DEFAULT_VERSION_NAME;
                this.m = IdManager.DEFAULT_VERSION_NAME;
                d(context);
                j();
                b();
                s();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public static final /* synthetic */ e b(d dVar) {
        e eVar = dVar.n;
        if (eVar != null) {
            return eVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fusedLocationManager");
        throw null;
    }

    private final void j() {
        SMTThreadPoolManager.INSTANCE.getIntance().execute(new a(this));
    }

    /* access modifiers changed from: private */
    public final com.netcore.android.f.b k() {
        return new b(this);
    }

    private final String m() {
        String str = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(str, "Build.MANUFACTURER");
        return str;
    }

    private final String n() {
        String str = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(str, "model");
        return CharsKt__CharKt.replace$default(str, m(), (String) "", false, 4);
    }

    private final String q() {
        Object systemService = this.o.getSystemService("window");
        if (systemService != null) {
            Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
            Intrinsics.checkNotNullExpressionValue(defaultDisplay, "display");
            int rotation = defaultDisplay.getRotation();
            return (rotation == 1 || rotation == 3) ? SMTConfigConstants.SCREEN_ORIENTATION_LANDSCAPE : SMTConfigConstants.SCREEN_ORIENTATION_PORTRAIT;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    private final String t() {
        String str = VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(str, "Build.VERSION.RELEASE");
        return str;
    }

    public final String d() {
        return this.i;
    }

    public final String e() {
        return this.f1280d;
    }

    public final String f() {
        return this.f1281e;
    }

    public final String g() {
        return this.f1282f;
    }

    public final String h() {
        return this.j;
    }

    public final String i() {
        return this.l;
    }

    public final String l() {
        return this.m;
    }

    public final String o() {
        return this.f1278b;
    }

    public final String p() {
        return this.f1279c;
    }

    public final String r() {
        return this.h;
    }

    public final String s() {
        String q = q();
        this.k = q;
        return q;
    }

    public final void u() {
        j();
    }

    private final void d(Context context) {
        SharedPreferences sharedPreferences;
        try {
            SMTPreferenceHelper appPreferenceInstance = SMTPreferenceHelper.Companion.getAppPreferenceInstance(context, null);
            boolean z = appPreferenceInstance.getBoolean(SMTPreferenceConstants.OLD_SDK_READ_STATUS, false);
            int i2 = appPreferenceInstance.getInt(SMTPreferenceConstants.SMT_MF_SDK_V2_CONFIG_ON_UPDATE, 1);
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str = this.f1277a;
            Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
            sMTLogger.internal(str, "SDK V2 Config update: " + i2);
            if (!z) {
                SMTGUIDPreferenceHelper appPreferenceInstance2 = SMTGUIDPreferenceHelper.Companion.getAppPreferenceInstance(context, null);
                if (VERSION.SDK_INT >= 24) {
                    sharedPreferences = context.getApplicationContext().createDeviceProtectedStorageContext().getSharedPreferences(SMTPreferenceConstants.OLD_SDK_PREFERENCES_FILE_NAME, 0);
                    Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.applicationConte…PREFERENCES_FILE_NAME, 0)");
                } else {
                    sharedPreferences = context.getSharedPreferences(SMTPreferenceConstants.OLD_SDK_PREFERENCES_FILE_NAME, 0);
                    Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…PREFERENCES_FILE_NAME, 0)");
                }
                String string = sharedPreferences.getString(SMTPreferenceConstants.OLD_SDK_PUSHID, "");
                String string2 = sharedPreferences.getString("identity", "");
                String string3 = sharedPreferences.getString(SMTPreferenceConstants.OLD_SDK_TOKEN, "");
                String str2 = this.f1277a;
                Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
                sMTLogger.i(str2, "Old identity: " + string2);
                String str3 = this.f1277a;
                Intrinsics.checkNotNullExpressionValue(str3, UeCustomType.TAG);
                sMTLogger.i(str3, "Old GUID: " + string);
                String str4 = this.f1277a;
                Intrinsics.checkNotNullExpressionValue(str4, UeCustomType.TAG);
                sMTLogger.i(str4, "Old token: " + string3);
                if (!(string == null || string2 == null || string3 == null)) {
                    if (string.length() > 0) {
                        appPreferenceInstance2.setString(SMTPreferenceConstants.SMT_GUID, string);
                    }
                    if ((string2.length() > 0) && i2 == 1) {
                        appPreferenceInstance.setString(SMTPreferenceConstants.SMT_USER_IDENTITY, string2);
                    }
                    if (string3.length() > 0) {
                        appPreferenceInstance.setString(SMTPreferenceConstants.FCM_PUSH_TOKEN_CURRENT, string3);
                        appPreferenceInstance.setString(SMTPreferenceConstants.FCM_PUSH_TOKEN_OLD, string3);
                        appPreferenceInstance.setBoolean(SMTPreferenceConstants.UPDATED_FROM_LEGACY_SDK, true);
                    }
                }
                appPreferenceInstance.setBoolean(SMTPreferenceConstants.OPT_IN_OUT_IN_APP_MESSAGES, true);
                appPreferenceInstance.setBoolean(SMTPreferenceConstants.OPT_IN_OUT_PUSH_NOTIFICATION, true);
                appPreferenceInstance.setBoolean(SMTPreferenceConstants.OPT_IN_OUT_TRACKING, true);
                appPreferenceInstance.setBoolean(SMTPreferenceConstants.SMT_LOCATION_PERMISSION, SMTCommonUtility.INSTANCE.isPermissionGranted$smartech_release(context, SMTConfigConstants.LOCATION_PERMISSION_MF_KEY));
                appPreferenceInstance.setBoolean(SMTPreferenceConstants.OLD_SDK_READ_STATUS, true);
            }
            String str5 = this.f1277a;
            Intrinsics.checkNotNullExpressionValue(str5, UeCustomType.TAG);
            sMTLogger.internal(str5, "Status of preference file: " + z);
        } catch (Exception e2) {
            SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
            String str6 = this.f1277a;
            GeneratedOutlineSupport.outline96(str6, UeCustomType.TAG, e2, sMTLogger2, str6);
        }
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.m = str;
    }

    public final String c() {
        return this.g;
    }

    private final void b() {
        this.j = a();
    }

    private final int c(Context context) {
        Object systemService = context.getSystemService("window");
        if (systemService != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.l = str;
    }

    private final String a() {
        return SMTCommonUtility.INSTANCE.getStoredGUID$smartech_release(this.o);
    }

    private final int b(Context context) {
        Object systemService = context.getSystemService("window");
        if (systemService != null) {
            WindowManager windowManager = (WindowManager) systemService;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int i2 = displayMetrics.heightPixels;
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            int i3 = displayMetrics.heightPixels;
            if (i3 > i2) {
                return i3 - i2;
            }
            return 0;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    private final int a(Context context) {
        Object systemService = context.getSystemService("window");
        if (systemService != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels + b(context);
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    public final void a(Location location) {
        Intrinsics.checkNotNullParameter(location, "location");
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str = this.f1277a;
        StringBuilder outline79 = GeneratedOutlineSupport.outline79(str, UeCustomType.TAG, "Fetched Location LATITUDE: ");
        outline79.append(location.getLatitude());
        outline79.append(", LONGITUDE: ");
        outline79.append(location.getLongitude());
        sMTLogger.i(str, outline79.toString());
        this.l = String.valueOf(location.getLatitude());
        this.m = String.valueOf(location.getLongitude());
        Companion companion = SMTPreferenceHelper.Companion;
        companion.getAppPreferenceInstance(this.o, null).setString(SMTPreferenceConstants.SMT_LAST_KNOWN_LATITUDE, this.l);
        companion.getAppPreferenceInstance(this.o, null).setString(SMTPreferenceConstants.SMT_LAST_KNOWN_LONGITUDE, this.m);
    }
}
