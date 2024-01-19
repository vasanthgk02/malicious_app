package com.google.android.gms.auth.api;

import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.Arrays;

@ShowFirstParty
@KeepForSdk
/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class AuthProxyOptions implements Optional {
    public static final AuthProxyOptions zza = new AuthProxyOptions(new Bundle());
    public final Bundle zzb;

    public /* synthetic */ AuthProxyOptions(Bundle bundle) {
        this.zzb = bundle;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004e, code lost:
        if (r1 == r7) goto L_0x0052;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r7 instanceof com.google.android.gms.auth.api.AuthProxyOptions
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            com.google.android.gms.auth.api.AuthProxyOptions r7 = (com.google.android.gms.auth.api.AuthProxyOptions) r7
            android.os.Bundle r1 = r6.zzb
            android.os.Bundle r7 = r7.zzb
            if (r1 == 0) goto L_0x004e
            if (r7 != 0) goto L_0x0015
            goto L_0x004e
        L_0x0015:
            int r3 = r1.size()
            int r4 = r7.size()
            if (r3 == r4) goto L_0x0020
            goto L_0x0051
        L_0x0020:
            java.util.Set r3 = r1.keySet()
            java.util.Set r4 = r7.keySet()
            boolean r4 = r3.containsAll(r4)
            if (r4 != 0) goto L_0x002f
            goto L_0x0051
        L_0x002f:
            java.util.Iterator r3 = r3.iterator()
        L_0x0033:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0052
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r1.get(r4)
            java.lang.Object r4 = r7.get(r4)
            boolean r4 = com.google.android.gms.common.internal.Objects.equal(r5, r4)
            if (r4 != 0) goto L_0x0033
            goto L_0x0051
        L_0x004e:
            if (r1 != r7) goto L_0x0051
            goto L_0x0052
        L_0x0051:
            r0 = 0
        L_0x0052:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.AuthProxyOptions.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzb});
    }
}
