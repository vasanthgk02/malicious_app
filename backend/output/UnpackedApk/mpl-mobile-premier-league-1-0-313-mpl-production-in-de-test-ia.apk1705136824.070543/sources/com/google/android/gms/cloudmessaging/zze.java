package com.google.android.gms.cloudmessaging;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
public final /* synthetic */ class zze implements Runnable {
    public final /* synthetic */ CloudMessagingReceiver zza;
    public final /* synthetic */ Intent zzb;
    public final /* synthetic */ Context zzc;
    public final /* synthetic */ boolean zzd;
    public final /* synthetic */ PendingResult zze;

    public /* synthetic */ zze(CloudMessagingReceiver cloudMessagingReceiver, Intent intent, Context context, boolean z, PendingResult pendingResult) {
        this.zza = cloudMessagingReceiver;
        this.zzb = intent;
        this.zzc = context;
        this.zzd = z;
        this.zze = pendingResult;
    }

    public final void run() {
        int i;
        CloudMessagingReceiver cloudMessagingReceiver = this.zza;
        Intent intent = this.zzb;
        Context context = this.zzc;
        boolean z = this.zzd;
        PendingResult pendingResult = this.zze;
        Intent intent2 = null;
        if (cloudMessagingReceiver != null) {
            try {
                Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
                if (parcelableExtra instanceof Intent) {
                    intent2 = (Intent) parcelableExtra;
                }
                if (intent2 != null) {
                    i = cloudMessagingReceiver.zzc(context, intent2);
                } else {
                    i = cloudMessagingReceiver.zzb(context, intent);
                }
                if (z) {
                    pendingResult.setResultCode(i);
                }
            } finally {
                pendingResult.finish();
            }
        } else {
            throw null;
        }
    }
}
