package com.cardinalcommerce.emvco.a.b;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.cardinalcommerce.shared.cs.utils.CCInitProvider;
import com.cardinalcommerce.shared.cs.utils.g;
import java.util.UUID;

public class b {

    /* renamed from: b  reason: collision with root package name */
    public final Context f2056b;

    /* renamed from: f  reason: collision with root package name */
    public String f2057f;

    public b() {
        Context context = CCInitProvider.f2212a;
        this.f2056b = context;
        g a2 = g.a(context);
        this.f2057f = a2.b((String) "SDKAppID", (String) null);
        long b2 = a2.b((String) "LastUpdatedTime", 0);
        try {
            long j = this.f2056b.getPackageManager().getPackageInfo(this.f2056b.getPackageName(), 0).lastUpdateTime;
            String str = this.f2057f;
            if (str == null || b2 == 0 || b2 != j) {
                str = UUID.randomUUID().toString();
                a2.a("SDKAppID", str);
                a2.a("LastUpdatedTime", Long.toString(j));
            }
            this.f2057f = str;
        } catch (NameNotFoundException e2) {
            String.valueOf(11318);
            e2.getLocalizedMessage();
            throw null;
        }
    }
}
