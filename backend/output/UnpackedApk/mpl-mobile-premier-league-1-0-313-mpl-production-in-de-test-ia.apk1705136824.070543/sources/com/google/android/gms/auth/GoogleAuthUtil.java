package com.google.android.gms.auth;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.auth.zzbw;
import com.google.android.gms.internal.auth.zzcz;
import com.google.android.gms.internal.auth.zzg;
import com.google.android.gms.internal.auth.zzh;
import com.google.android.gms.internal.auth.zzhj;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class GoogleAuthUtil extends zzl {
    public static void clearToken(Context context, String str) throws GooglePlayServicesAvailabilityException, GoogleAuthException, IOException {
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        zzl.zzj(context, 8400000);
        Bundle bundle = new Bundle();
        String str2 = context.getApplicationInfo().packageName;
        bundle.putString("clientPackageName", str2);
        if (!bundle.containsKey("androidPackageName")) {
            bundle.putString("androidPackageName", str2);
        }
        zzcz.zze(context);
        if (zzhj.zze() && zzl.zzm(context)) {
            zzg zza = zzh.zza(context);
            zzbw zzbw = new zzbw();
            zzbw.zza(str);
            try {
                zzl.zzh(zza.zza(zzbw), "clear token");
                return;
            } catch (ApiException e2) {
                zzl.zzk(e2, "clear token");
            }
        }
        zzl.zzg(context, zzl.zzc, new zzh(str, bundle));
    }

    public static String getToken(Context context, Account account, String str) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        TokenData tokenData;
        Bundle bundle = new Bundle();
        zzl.zzl(account);
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        Preconditions.checkNotEmpty(str, "Scope cannot be empty or null.");
        zzl.zzl(account);
        zzl.zzj(context, 8400000);
        Bundle bundle2 = new Bundle(bundle);
        String str2 = context.getApplicationInfo().packageName;
        bundle2.putString("clientPackageName", str2);
        if (TextUtils.isEmpty(bundle2.getString("androidPackageName"))) {
            bundle2.putString("androidPackageName", str2);
        }
        bundle2.putLong("service_connection_start_time_millis", SystemClock.elapsedRealtime());
        zzcz.zze(context);
        if (zzhj.zze() && zzl.zzm(context)) {
            try {
                Bundle bundle3 = (Bundle) zzl.zzh(zzh.zza(context).zzc(account, str, bundle2), "token retrieval");
                zzl.zzi(bundle3);
                tokenData = zzl.zzf(bundle3);
            } catch (ApiException e2) {
                zzl.zzk(e2, "token retrieval");
            }
            return tokenData.zzb;
        }
        tokenData = (TokenData) zzl.zzg(context, zzl.zzc, new zzg(account, str, bundle2));
        return tokenData.zzb;
    }
}
