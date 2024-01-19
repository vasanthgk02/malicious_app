package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.Executor;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public abstract class GmsClientSupervisor {
    @VisibleForTesting
    public static HandlerThread zza;
    public static final Object zzc = new Object();
    public static zzr zzd;

    @KeepForSdk
    public static int getDefaultBindFlags() {
        return 4225;
    }

    @KeepForSdk
    public static GmsClientSupervisor getInstance(Context context) {
        synchronized (zzc) {
            try {
                if (zzd == null) {
                    zzd = new zzr(context.getApplicationContext(), context.getMainLooper());
                }
            }
        }
        return zzd;
    }

    @KeepForSdk
    public static HandlerThread getOrStartHandlerThread() {
        synchronized (zzc) {
            try {
                HandlerThread handlerThread = zza;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                zza = handlerThread2;
                handlerThread2.start();
                HandlerThread handlerThread3 = zza;
                return handlerThread3;
            }
        }
    }

    public abstract void zza(zzn zzn, ServiceConnection serviceConnection, String str);

    public abstract boolean zzc(zzn zzn, ServiceConnection serviceConnection, String str, Executor executor);
}
