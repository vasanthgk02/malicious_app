package com.google.android.gms.security;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller.ProviderInstallListener;
import sfs2x.client.requests.LoginRequest;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class zza extends AsyncTask {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ ProviderInstallListener zzb;

    public zza(Context context, ProviderInstallListener providerInstallListener) {
        this.zza = context;
        this.zzb = providerInstallListener;
    }

    public final Object doInBackground(Object[] objArr) {
        Void[] voidArr = (Void[]) objArr;
        try {
            ProviderInstaller.installIfNeeded(this.zza);
            return Integer.valueOf(0);
        } catch (GooglePlayServicesRepairableException e2) {
            return Integer.valueOf(e2.zza);
        } catch (GooglePlayServicesNotAvailableException e3) {
            return Integer.valueOf(e3.errorCode);
        }
    }

    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        Integer num = (Integer) obj;
        if (num.intValue() == 0) {
            this.zzb.onProviderInstalled();
            return;
        }
        this.zzb.onProviderInstallFailed(num.intValue(), ProviderInstaller.zza.getErrorResolutionIntent(this.zza, num.intValue(), LoginRequest.KEY_PRIVILEGE_ID));
    }
}
