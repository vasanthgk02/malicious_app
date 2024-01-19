package com.netcore.android.utility;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import com.netcore.android.logger.SMTLogger;
import com.userexperior.models.recording.enums.UeCustomType;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SMTAppInfo.kt */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f1269a = a.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public final String f1270b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1271c;

    /* renamed from: d  reason: collision with root package name */
    public final String f1272d;

    /* renamed from: e  reason: collision with root package name */
    public final h f1273e;

    /* renamed from: f  reason: collision with root package name */
    public final String f1274f;
    public final Context g;

    public a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.g = context;
        this.f1270b = b(context);
        this.f1271c = a(context);
        this.f1272d = context.getPackageName();
        this.f1273e = h.j.b(new WeakReference(context));
        this.f1274f = e();
    }

    private final String e() {
        return "3.2.15";
    }

    public final String a() {
        return this.f1271c;
    }

    public final String b() {
        return this.f1272d;
    }

    public final String c() {
        return this.f1270b;
    }

    public final h d() {
        return this.f1273e;
    }

    public final String f() {
        return this.f1274f;
    }

    private final String a(Context context) {
        long j;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (VERSION.SDK_INT >= 28) {
                j = packageInfo.getLongVersionCode();
            } else {
                j = (long) packageInfo.versionCode;
            }
            return String.valueOf(j);
        } catch (NameNotFoundException e2) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str = this.f1269a;
            Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
            sMTLogger.d(str, "Unable to get app build, error :- " + e2);
            return "";
        }
    }

    private final String b(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            Intrinsics.checkNotNullExpressionValue(packageInfo, "context.packageManager.g…o(context.packageName, 0)");
            String str = packageInfo.versionName;
            Intrinsics.checkNotNullExpressionValue(str, "packageInfo.versionName");
            return str;
        } catch (NameNotFoundException e2) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str2 = this.f1269a;
            Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
            sMTLogger.e(str2, "Unable to get app version name, error :- " + e2);
            return "";
        }
    }
}
