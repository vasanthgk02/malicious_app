package com.google.android.gms.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzey;
import com.google.android.gms.measurement.internal.zzfr;
import com.google.android.gms.measurement.internal.zzfr.zza;
import com.google.android.gms.measurement.internal.zzgi;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements zza {
    public zzfr zza;

    public void doStartService(Context context, Intent intent) {
        synchronized (WakefulBroadcastReceiver.sActiveWakeLocks) {
            int i = WakefulBroadcastReceiver.mNextId;
            int i2 = WakefulBroadcastReceiver.mNextId + 1;
            WakefulBroadcastReceiver.mNextId = i2;
            if (i2 <= 0) {
                WakefulBroadcastReceiver.mNextId = 1;
            }
            intent.putExtra("androidx.contentpager.content.wakelockid", i);
            ComponentName startService = context.startService(intent);
            if (startService != null) {
                WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "androidx.core:wake:" + startService.flattenToShortString());
                newWakeLock.setReferenceCounted(false);
                newWakeLock.acquire(60000);
                WakefulBroadcastReceiver.sActiveWakeLocks.put(i, newWakeLock);
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (this.zza == null) {
            this.zza = new zzfr(this);
        }
        zzfr zzfr = this.zza;
        if (zzfr != null) {
            zzey zzaz = zzgi.zzp(context, null, null).zzaz();
            if (intent == null) {
                zzaz.zzg.zza("Receiver called with null intent");
                return;
            }
            String action = intent.getAction();
            zzaz.zzl.zzb("Local receiver got", action);
            if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
                Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
                className.setAction("com.google.android.gms.measurement.UPLOAD");
                zzaz.zzl.zza("Starting wakeful intent.");
                zzfr.zza.doStartService(context, className);
            } else if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
                zzaz.zzg.zza("Install Referrer Broadcasts are deprecated");
            }
        } else {
            throw null;
        }
    }
}
