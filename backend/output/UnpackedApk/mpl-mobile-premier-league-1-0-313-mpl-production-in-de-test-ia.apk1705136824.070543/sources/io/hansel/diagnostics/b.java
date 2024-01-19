package io.hansel.diagnostics;

import android.content.Context;
import android.content.Intent;
import io.hansel.core.base.utils.HSLInternalUtils;
import io.hansel.core.logger.HSLLogger;
import io.hansel.diagnostics.a.C0079a;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public final Context f5231a;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5232a;

        static {
            int[] iArr = new int[C0079a.values().length];
            f5232a = iArr;
            try {
                C0079a aVar = C0079a.DEVICE_INFO;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public b(Context context) {
        this.f5231a = context;
    }

    public static void a(Context context, String str, int i, String str2) {
        Intent intent = new Intent("io.hansel.diagnostics.response");
        intent.setPackage(str);
        intent.putExtra("ERROR", i);
        intent.putExtra("ERROR_MSG", str2);
        context.sendBroadcast(intent);
    }

    public static void a(Context context, String str, String str2) {
        Intent intent = new Intent();
        intent.setAction("io.hansel.diagnostics.response");
        intent.setPackage(str);
        intent.putExtra("d", str2);
        context.sendBroadcast(intent);
    }

    private void a(String str) {
        String deviceId = HSLInternalUtils.getDeviceId(this.f5231a.getContentResolver());
        if (deviceId != null) {
            a(this.f5231a, str, a.a().a(deviceId));
        }
    }

    public void a(String str, String str2) {
        try {
            String b2 = a.a().b(str2);
            C0079a valueOf = C0079a.valueOf(a.a().b(str));
            if (valueOf == null) {
                a(this.f5231a, b2, 1, "Not able to parse message");
            } else if (a.f5232a[valueOf.ordinal()] == 1) {
                a(b2);
            }
        } catch (Throwable th) {
            a(this.f5231a, str2, 2, "Not able to parse message");
            HSLLogger.printStackTrace(th);
        }
    }
}
