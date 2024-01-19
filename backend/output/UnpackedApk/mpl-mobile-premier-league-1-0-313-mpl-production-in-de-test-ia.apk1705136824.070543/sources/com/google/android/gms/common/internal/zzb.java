package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.common.zzi;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class zzb extends zzi {
    public final /* synthetic */ BaseGmsClient zza;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzb(BaseGmsClient baseGmsClient, Looper looper) {
        // this.zza = baseGmsClient;
        super(looper);
    }

    public static final void zza(Message message) {
        zzc zzc = (zzc) message.obj;
        if (((zza) zzc) != null) {
            zzc.zzg();
            return;
        }
        throw null;
    }

    public static final boolean zzb(Message message) {
        int i = message.what;
        return i == 2 || i == 1 || i == 7;
    }

    public final void handleMessage(Message message) {
        Object obj;
        ConnectionResult connectionResult;
        ConnectionResult connectionResult2;
        if (this.zza.zzd.get() != message.arg1) {
            if (zzb(message)) {
                zza(message);
            }
            return;
        }
        int i = message.what;
        if ((i == 1 || i == 7 || ((i == 4 && !this.zza.enableLocalFallback()) || message.what == 5)) && !this.zza.isConnecting()) {
            zza(message);
            return;
        }
        int i2 = message.what;
        PendingIntent pendingIntent = null;
        if (i2 == 4) {
            this.zza.zzB = new ConnectionResult(message.arg2);
            if (BaseGmsClient.zzo(this.zza)) {
                BaseGmsClient baseGmsClient = this.zza;
                if (!baseGmsClient.zzC) {
                    baseGmsClient.zzp(3, null);
                    return;
                }
            }
            BaseGmsClient baseGmsClient2 = this.zza;
            if (baseGmsClient2.zzB != null) {
                connectionResult2 = baseGmsClient2.zzB;
            } else {
                connectionResult2 = new ConnectionResult(8);
            }
            this.zza.zzc.onReportServiceBinding(connectionResult2);
            this.zza.onConnectionFailed(connectionResult2);
        } else if (i2 == 5) {
            BaseGmsClient baseGmsClient3 = this.zza;
            if (baseGmsClient3.zzB != null) {
                connectionResult = baseGmsClient3.zzB;
            } else {
                connectionResult = new ConnectionResult(8);
            }
            this.zza.zzc.onReportServiceBinding(connectionResult);
            this.zza.onConnectionFailed(connectionResult);
        } else if (i2 == 3) {
            Object obj2 = message.obj;
            if (obj2 instanceof PendingIntent) {
                pendingIntent = (PendingIntent) obj2;
            }
            ConnectionResult connectionResult3 = new ConnectionResult(message.arg2, pendingIntent);
            this.zza.zzc.onReportServiceBinding(connectionResult3);
            this.zza.onConnectionFailed(connectionResult3);
        } else if (i2 == 6) {
            this.zza.zzp(5, null);
            BaseGmsClient baseGmsClient4 = this.zza;
            if (baseGmsClient4.zzw != null) {
                baseGmsClient4.zzw.onConnectionSuspended(message.arg2);
            }
            this.zza.onConnectionSuspended(message.arg2);
            BaseGmsClient.zzn(this.zza, 5, 1, null);
        } else if (i2 == 2 && !this.zza.isConnected()) {
            zza(message);
        } else if (zzb(message)) {
            zzc zzc = (zzc) message.obj;
            synchronized (zzc) {
                obj = zzc.zza;
                if (zzc.zzb) {
                    zzc.toString();
                }
            }
            if (obj != null) {
                try {
                    zzc.zza(obj);
                } catch (RuntimeException e2) {
                    throw e2;
                }
            }
            synchronized (zzc) {
                zzc.zzb = true;
            }
            zzc.zzg();
        } else {
            int i3 = message.what;
            Log.wtf("GmsClient", "Don't know how to handle message: " + i3, new Exception());
        }
    }
}
