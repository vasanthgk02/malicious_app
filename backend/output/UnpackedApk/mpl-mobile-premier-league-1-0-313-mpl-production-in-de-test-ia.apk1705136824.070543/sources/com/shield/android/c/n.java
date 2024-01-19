package com.shield.android.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.os.Build.VERSION;
import com.netcore.android.SMTConfigConstants;
import com.shield.android.Shield;
import com.shield.android.internal.f;
import com.shield.android.internal.j;
import java.util.Locale;

public class n extends f implements q {

    /* renamed from: b  reason: collision with root package name */
    public final Context f1536b;

    /* renamed from: c  reason: collision with root package name */
    public p f1537c;

    /* renamed from: d  reason: collision with root package name */
    public Location f1538d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f1539e;

    public n(Context context, boolean z) {
        this.f1536b = context;
        this.f1539e = z;
        try {
            if (j.b(context)) {
                this.f1537c = new k(this.f1536b);
            } else {
                this.f1537c = new o(this.f1536b);
            }
            this.f1537c.a(this);
        } catch (Exception e2) {
            if (f.a().f1677b && e2.getMessage() != null) {
                e2.getLocalizedMessage();
            }
        }
    }

    @SuppressLint({"DefaultLocale"})
    public void a(Location location) {
        if (location != null) {
            try {
                if (!(this.f1538d == null || location.isFromMockProvider() == this.f1538d.isFromMockProvider())) {
                    Shield.getInstance().sendDeviceSignature("shield_gps_provider_xyz");
                }
            } catch (Exception e2) {
                if (f.a().f1677b && e2.getMessage() != null) {
                    e2.getLocalizedMessage();
                    return;
                }
                return;
            }
        }
        this.f1538d = location;
        if (!this.f1539e || (VERSION.SDK_INT >= 29 && !j.i(this.f1536b, SMTConfigConstants.LOCATION_PERMISSION_BG_KEY))) {
            this.f1537c.d();
        }
    }

    public final void e() {
        try {
            this.f1537c.c();
            Location b2 = this.f1537c.b();
            this.f1538d = b2;
            if (b2 != null) {
                Locale locale = Locale.ENGLISH;
                Object[] objArr = new Object[6];
                objArr[0] = Double.valueOf(b2.getLatitude());
                objArr[1] = Double.valueOf(this.f1538d.getLongitude());
                objArr[2] = Double.valueOf(this.f1538d.getAltitude());
                objArr[3] = Float.valueOf(this.f1538d.getSpeed());
                objArr[4] = Float.valueOf(this.f1538d.getAccuracy());
                objArr[5] = Float.valueOf(VERSION.SDK_INT >= 26 ? this.f1538d.getVerticalAccuracyMeters() : 0.0f);
                String format = String.format(locale, "%.6f,%.6f,%.6f,%.6f,%.6f,%.6f", objArr);
                if (format == null) {
                    format = "";
                }
                this.f1517a.put("LATLNG", format);
            }
        } catch (Exception e2) {
            if (f.a().f1677b && e2.getMessage() != null) {
                e2.getLocalizedMessage();
            }
        }
    }
}
