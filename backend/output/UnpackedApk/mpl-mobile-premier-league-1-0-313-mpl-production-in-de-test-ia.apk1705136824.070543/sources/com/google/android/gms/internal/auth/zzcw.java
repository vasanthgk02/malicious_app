package com.google.android.gms.internal.auth;

import android.util.Base64;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzcw extends zzcz {
    public final /* synthetic */ zzhl zza;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzcw(zzcx zzcx, String str, Object obj, boolean z, zzhl zzhl, byte[] bArr) {
        // this.zza = zzhl;
        super(zzcx, "getTokenRefactor__blocked_packages", obj, true, null);
    }

    public final Object zza(Object obj) {
        try {
            return zzhi.zzl(Base64.decode((String) obj, 3));
        } catch (IOException | IllegalArgumentException unused) {
            String.valueOf(super.zzc()).length();
            ((String) obj).length();
            return null;
        }
    }
}
