package com.netcore.android.utility;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import com.netcore.android.SMTManifestKeys;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.preference.SMTPreferenceConstants;
import com.netcore.android.preference.SMTPreferenceHelper;
import com.userexperior.models.recording.enums.UeCustomType;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SMTManifestInfo.kt */
public final class h {
    public static volatile h i;
    public static final a j = new a(null);

    /* renamed from: a  reason: collision with root package name */
    public final String f1307a;

    /* renamed from: b  reason: collision with root package name */
    public String f1308b;

    /* renamed from: c  reason: collision with root package name */
    public int f1309c;

    /* renamed from: d  reason: collision with root package name */
    public int f1310d;

    /* renamed from: e  reason: collision with root package name */
    public int f1311e;

    /* renamed from: f  reason: collision with root package name */
    public int f1312f;
    public boolean g;
    public final WeakReference<Context> h;

    /* compiled from: SMTManifestInfo.kt */
    public static final class a {
        public a() {
        }

        private final h a(WeakReference<Context> weakReference) {
            return new h(weakReference, null);
        }

        public final h b(WeakReference<Context> weakReference) {
            h hVar;
            Intrinsics.checkNotNullParameter(weakReference, "context");
            h a2 = h.i;
            if (a2 != null) {
                return a2;
            }
            synchronized (h.class) {
                try {
                    h a3 = h.i;
                    if (a3 != null) {
                        hVar = a3;
                    } else {
                        hVar = h.j.a(weakReference);
                        h.i = hVar;
                    }
                }
            }
            return hVar;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public h(WeakReference<Context> weakReference) {
        this.h = weakReference;
        this.f1307a = h.class.getSimpleName();
        this.f1309c = 1;
        this.f1312f = 1;
        d();
    }

    private final void d() {
        String str = "";
        try {
            Context context = (Context) this.h.get();
            if (context != null) {
                Intrinsics.checkNotNullExpressionValue(context, "it");
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                Bundle bundle = applicationInfo != null ? applicationInfo.metaData : null;
                SMTPreferenceHelper appPreferenceInstance = SMTPreferenceHelper.Companion.getAppPreferenceInstance(context, null);
                String string = appPreferenceInstance.getString("app_id", str);
                this.f1308b = string;
                if (string == null || string.length() == 0) {
                    if (bundle != null) {
                        String c2 = c(bundle, SMTManifestKeys.SMT_APP_ID);
                        this.f1308b = c2;
                        if (c2 != null) {
                            str = c2;
                        }
                        appPreferenceInstance.setString("app_id", str);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.os.Bundle");
                    }
                }
                if (bundle != null) {
                    this.f1309c = b(bundle, SMTManifestKeys.SMT_IS_AUTO_FETCHED_LOCATION);
                    this.f1310d = b(bundle, SMTManifestKeys.SMT_IS_AUTO_FETCH_INBOX_NOTIFICATIONS);
                    this.f1311e = b(bundle, SMTManifestKeys.SMT_IS_NOTIFICATION_LISTENER_ENABLED);
                    this.f1312f = b(bundle, SMTManifestKeys.SMT_SDK_V2_CONFIG_ON_UPDATE);
                    this.g = a(bundle, SMTManifestKeys.SMT_USE_ENCRYPTION);
                    appPreferenceInstance.setInt(SMTPreferenceConstants.SMT_MF_IS_AUTO_FETCH_LOCATION, this.f1309c);
                    appPreferenceInstance.setInt(SMTPreferenceConstants.SMT_MF_IS_AUTO_FETCH_INBOX_MESSAGE, this.f1310d);
                    appPreferenceInstance.setInt(SMTPreferenceConstants.SMT_MF_IS_NOTIFICATION_LISTENER_ENABLED, this.f1311e);
                    appPreferenceInstance.setInt(SMTPreferenceConstants.SMT_MF_SDK_V2_CONFIG_ON_UPDATE, this.f1312f);
                    SMTLogger sMTLogger = SMTLogger.INSTANCE;
                    String str2 = this.f1307a;
                    Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
                    sMTLogger.i(str2, "Smartech Manifest report AppId: " + this.f1308b + ", AutoFetchLocationEnabled: " + this.f1309c + ", NLEnabled: " + this.f1311e);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.os.Bundle");
            }
        } catch (Exception unused) {
            SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
            String str3 = this.f1307a;
            Intrinsics.checkNotNullExpressionValue(str3, UeCustomType.TAG);
            sMTLogger2.e(str3, "Error while reading manifest meta data: ");
        }
    }

    public final String b() {
        return this.f1308b;
    }

    public final boolean c() {
        return this.g;
    }

    private final int b(Bundle bundle, String str) {
        try {
            Object obj = bundle.get(str);
            if (obj != null) {
                return ((Integer) obj).intValue();
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        } catch (Exception unused) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str2 = this.f1307a;
            Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
            sMTLogger.i(str2, "No value for " + str + " in manifest.");
            return Intrinsics.areEqual(SMTManifestKeys.SMT_SDK_V2_CONFIG_ON_UPDATE, str) ? 1 : 0;
        }
    }

    private final String c(Bundle bundle, String str) {
        try {
            Object obj = bundle.get(str);
            if (obj == null) {
                return "";
            }
            String obj2 = obj.toString();
            if (obj2 != null) {
                return obj2;
            }
            return "";
        } catch (Exception unused) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str2 = this.f1307a;
            Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
            sMTLogger.i(str2, "No value for " + str + " in manifest.");
            return "";
        }
    }

    private final boolean a(Bundle bundle, String str) {
        try {
            Object obj = bundle.get(str);
            if (obj != null) {
                return ((Boolean) obj).booleanValue();
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        } catch (Exception unused) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str2 = this.f1307a;
            Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
            sMTLogger.e(str2, "No value for " + str + " in manifest.");
            return false;
        }
    }

    public /* synthetic */ h(WeakReference weakReference, DefaultConstructorMarker defaultConstructorMarker) {
        this(weakReference);
    }
}
