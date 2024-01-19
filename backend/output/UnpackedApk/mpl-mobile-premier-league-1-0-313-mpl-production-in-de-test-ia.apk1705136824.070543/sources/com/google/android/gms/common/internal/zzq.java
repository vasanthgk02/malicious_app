package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler.Callback;
import android.os.Message;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class zzq implements Callback {
    public final /* synthetic */ zzr zza;

    public /* synthetic */ zzq(zzr zzr) {
        this.zza = zzr;
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.zza.zzb) {
                zzn zzn = (zzn) message.obj;
                zzo zzo = (zzo) this.zza.zzb.get(zzn);
                if (zzo != null && zzo.zzb.isEmpty()) {
                    if (zzo.zzd) {
                        zzo.zza.zzd.removeMessages(1, zzo.zzf);
                        zzr zzr = zzo.zza;
                        zzr.zzf.unbindService(zzr.zzc, zzo);
                        zzo.zzd = false;
                        zzo.zzc = 2;
                    }
                    this.zza.zzb.remove(zzn);
                }
            }
            return true;
        } else if (i != 1) {
            return false;
        } else {
            synchronized (this.zza.zzb) {
                zzn zzn2 = (zzn) message.obj;
                zzo zzo2 = (zzo) this.zza.zzb.get(zzn2);
                if (zzo2 != null && zzo2.zzc == 3) {
                    String.valueOf(zzn2);
                    new Exception();
                    ComponentName componentName = zzo2.zzg;
                    if (componentName == null) {
                        componentName = zzn2.zzd;
                    }
                    if (componentName == null) {
                        String str = zzn2.zzc;
                        Preconditions.checkNotNull(str);
                        componentName = new ComponentName(str, "unknown");
                    }
                    zzo2.onServiceDisconnected(componentName);
                }
            }
            return true;
        }
    }
}
