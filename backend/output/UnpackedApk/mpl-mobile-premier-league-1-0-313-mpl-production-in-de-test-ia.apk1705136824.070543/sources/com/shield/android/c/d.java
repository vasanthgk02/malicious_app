package com.shield.android.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import com.netcore.android.SMTConfigConstants;
import com.shield.android.internal.f;
import com.shield.android.internal.j;

public class d extends f {

    /* renamed from: b  reason: collision with root package name */
    public final Context f1513b;

    /* renamed from: c  reason: collision with root package name */
    public String f1514c = d.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    public final n f1515d;

    public d(Context context, n nVar) {
        this.f1513b = context;
        this.f1515d = nVar;
    }

    @SuppressLint({"MissingPermission"})
    public final boolean l(Context context) {
        boolean z = false;
        if ((!j.i(context, SMTConfigConstants.LOCATION_PERMISSION_MF_KEY) && !j.i(context, "android.permission.ACCESS_COARSE_LOCATION")) || !j.c(context)) {
            return false;
        }
        n nVar = this.f1515d;
        if (nVar != null) {
            try {
                if (nVar.f1538d == null) {
                    nVar.f1538d = nVar.f1537c.b();
                }
                Location location = nVar.f1538d;
                if (location != null && location.isFromMockProvider()) {
                    z = true;
                }
            } catch (Exception e2) {
                if (f.a().f1677b && e2.getMessage() != null) {
                    e2.getLocalizedMessage();
                }
            }
            return z;
        }
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0043 A[Catch:{ Exception -> 0x006f }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0082 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m(android.content.Context r8) {
        /*
            r7 = this;
            r0 = 1
            r1 = 0
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x006d }
            r3 = 23
            if (r2 < r3) goto L_0x002d
            java.lang.String r2 = "android.permission.ACCESS_NETWORK_STATE"
            int r2 = r8.checkCallingOrSelfPermission(r2)     // Catch:{ Exception -> 0x006d }
            if (r2 != 0) goto L_0x0012
            r2 = 1
            goto L_0x0013
        L_0x0012:
            r2 = 0
        L_0x0013:
            if (r2 == 0) goto L_0x002d
            java.lang.String r2 = "connectivity"
            java.lang.Object r8 = r8.getSystemService(r2)     // Catch:{ Exception -> 0x006d }
            android.net.ConnectivityManager r8 = (android.net.ConnectivityManager) r8     // Catch:{ Exception -> 0x006d }
            android.net.Network r2 = r8.getActiveNetwork()     // Catch:{ Exception -> 0x006d }
            android.net.NetworkCapabilities r8 = r8.getNetworkCapabilities(r2)     // Catch:{ Exception -> 0x006d }
            if (r8 == 0) goto L_0x002d
            r2 = 4
            boolean r8 = r8.hasTransport(r2)     // Catch:{ Exception -> 0x006d }
            goto L_0x002e
        L_0x002d:
            r8 = 0
        L_0x002e:
            java.util.Enumeration r2 = java.net.NetworkInterface.getNetworkInterfaces()     // Catch:{ Exception -> 0x006e }
            java.util.ArrayList r2 = java.util.Collections.list(r2)     // Catch:{ Exception -> 0x006e }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x006e }
            java.lang.String r3 = ""
            r4 = 0
        L_0x003d:
            boolean r5 = r2.hasNext()     // Catch:{ Exception -> 0x006f }
            if (r5 == 0) goto L_0x0080
            java.lang.Object r5 = r2.next()     // Catch:{ Exception -> 0x006f }
            java.net.NetworkInterface r5 = (java.net.NetworkInterface) r5     // Catch:{ Exception -> 0x006f }
            boolean r6 = r5.isUp()     // Catch:{ Exception -> 0x006f }
            if (r6 == 0) goto L_0x0053
            java.lang.String r3 = r5.getName()     // Catch:{ Exception -> 0x006f }
        L_0x0053:
            java.lang.String r5 = "tun"
            boolean r5 = r3.contains(r5)     // Catch:{ Exception -> 0x006f }
            if (r5 != 0) goto L_0x006b
            java.lang.String r5 = "ppp"
            boolean r5 = r3.contains(r5)     // Catch:{ Exception -> 0x006f }
            if (r5 != 0) goto L_0x006b
            java.lang.String r5 = "pptp"
            boolean r5 = r3.contains(r5)     // Catch:{ Exception -> 0x006f }
            if (r5 == 0) goto L_0x003d
        L_0x006b:
            r4 = 1
            goto L_0x003d
        L_0x006d:
            r8 = 0
        L_0x006e:
            r4 = 0
        L_0x006f:
            java.lang.String r2 = r7.f1514c
            com.shield.android.internal.f r2 = com.shield.android.internal.f.a(r2)
            java.lang.Object[] r3 = new java.lang.Object[r1]
            boolean r2 = r2.f1677b
            if (r2 == 0) goto L_0x0080
            java.lang.String r2 = "checking vpn"
            java.lang.String.format(r2, r3)
        L_0x0080:
            if (r8 != 0) goto L_0x0086
            if (r4 == 0) goto L_0x0085
            goto L_0x0086
        L_0x0085:
            r0 = 0
        L_0x0086:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shield.android.c.d.m(android.content.Context):boolean");
    }
}
