package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.base.zau;

@SuppressLint({"HandlerLeak"})
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zac extends zau {
    public final /* synthetic */ GoogleApiAvailability zaa;
    public final Context zab;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zac(GoogleApiAvailability googleApiAvailability, Context context) {
        // this.zaa = googleApiAvailability;
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.zab = context.getApplicationContext();
    }

    public final void handleMessage(Message message) {
        if (message.what == 1) {
            int isGooglePlayServicesAvailable = this.zaa.isGooglePlayServicesAvailable(this.zab);
            if (this.zaa != null) {
                if (GooglePlayServicesUtilLight.isUserRecoverableError(isGooglePlayServicesAvailable)) {
                    GoogleApiAvailability googleApiAvailability = this.zaa;
                    Context context = this.zab;
                    googleApiAvailability.zae(context, isGooglePlayServicesAvailable, null, googleApiAvailability.getErrorResolutionPendingIntent(context, isGooglePlayServicesAvailable, 0, "n"));
                }
                return;
            }
            throw null;
        }
    }
}
