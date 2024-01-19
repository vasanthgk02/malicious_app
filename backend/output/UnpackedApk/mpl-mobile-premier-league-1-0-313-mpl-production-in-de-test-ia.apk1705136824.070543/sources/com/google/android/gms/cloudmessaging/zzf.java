package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
public final /* synthetic */ class zzf implements Callback {
    public final /* synthetic */ zzm zza;

    public /* synthetic */ zzf(zzm zzm) {
        this.zza = zzm;
    }

    public final boolean handleMessage(Message message) {
        zzm zzm = this.zza;
        int i = message.arg1;
        boolean isLoggable = Log.isLoggable("MessengerIpcClient", 3);
        synchronized (zzm) {
            zzp zzp = zzm.zze.get(i);
            if (zzp != null) {
                zzm.zze.remove(i);
                zzm.zzf();
                Bundle data = message.getData();
                if (data.getBoolean("unsupported", false)) {
                    zzp.zzc(new zzq("Not supported by GmsCore", null));
                } else {
                    zzp.zza(data);
                }
            }
        }
        return true;
    }
}
