package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.SystemClock;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.zzw;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zacd implements OnCompleteListener {
    public final GoogleApiManager zaa;
    public final int zab;
    public final ApiKey zac;
    public final long zad;
    public final long zae;

    @VisibleForTesting
    public zacd(GoogleApiManager googleApiManager, int i, ApiKey apiKey, long j, long j2) {
        this.zaa = googleApiManager;
        this.zab = i;
        this.zac = apiKey;
        this.zad = j;
        this.zae = j2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        if (com.google.android.gms.common.util.ArrayUtils.contains(r0, r3) == false) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
        if (com.google.android.gms.common.util.ArrayUtils.contains(r0, r3) == false) goto L_0x0021;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.common.internal.ConnectionTelemetryConfiguration zab(com.google.android.gms.common.api.internal.zabq r1, com.google.android.gms.common.internal.BaseGmsClient r2, int r3) {
        /*
            com.google.android.gms.common.internal.ConnectionTelemetryConfiguration r2 = r2.getTelemetryConfiguration()
            if (r2 == 0) goto L_0x0028
            boolean r0 = r2.zzb
            if (r0 == 0) goto L_0x0028
            int[] r0 = r2.zzd
            if (r0 != 0) goto L_0x001a
            int[] r0 = r2.zzf
            if (r0 != 0) goto L_0x0013
            goto L_0x0021
        L_0x0013:
            boolean r3 = com.google.android.gms.common.util.ArrayUtils.contains(r0, r3)
            if (r3 == 0) goto L_0x0021
            goto L_0x0028
        L_0x001a:
            boolean r3 = com.google.android.gms.common.util.ArrayUtils.contains(r0, r3)
            if (r3 != 0) goto L_0x0021
            goto L_0x0028
        L_0x0021:
            int r1 = r1.zam
            int r3 = r2.zze
            if (r1 >= r3) goto L_0x0028
            return r2
        L_0x0028:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zacd.zab(com.google.android.gms.common.api.internal.zabq, com.google.android.gms.common.internal.BaseGmsClient, int):com.google.android.gms.common.internal.ConnectionTelemetryConfiguration");
    }

    public final void onComplete(Task task) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        long j;
        long j2;
        int i7;
        int i8;
        if (this.zaa.zaF()) {
            RootTelemetryConfiguration rootTelemetryConfiguration = RootTelemetryConfigManager.getInstance().zzc;
            if (rootTelemetryConfiguration == null || rootTelemetryConfiguration.zzb) {
                zabq zabq = (zabq) this.zaa.zap.get(this.zac);
                if (zabq != null) {
                    Client client = zabq.zac;
                    if (client instanceof BaseGmsClient) {
                        BaseGmsClient baseGmsClient = (BaseGmsClient) client;
                        boolean z = true;
                        boolean z2 = this.zad > 0;
                        int gCoreServiceId = baseGmsClient.getGCoreServiceId();
                        if (rootTelemetryConfiguration != null) {
                            boolean z3 = z2 & rootTelemetryConfiguration.zzc;
                            int i9 = rootTelemetryConfiguration.zzd;
                            int i10 = rootTelemetryConfiguration.zze;
                            i3 = rootTelemetryConfiguration.zza;
                            if (baseGmsClient.hasConnectionInfo() && !baseGmsClient.isConnecting()) {
                                ConnectionTelemetryConfiguration zab2 = zab(zabq, baseGmsClient, this.zab);
                                if (zab2 != null) {
                                    if (!zab2.zzc || this.zad <= 0) {
                                        z = false;
                                    }
                                    i10 = zab2.zze;
                                    z3 = z;
                                } else {
                                    return;
                                }
                            }
                            i2 = i9;
                            i = i10;
                        } else {
                            i3 = 0;
                            i2 = 5000;
                            i = 100;
                        }
                        GoogleApiManager googleApiManager = this.zaa;
                        if (task.isSuccessful()) {
                            i5 = 0;
                            i4 = 0;
                        } else {
                            if (((zzw) task).zzd) {
                                i7 = 100;
                            } else {
                                Exception exception = task.getException();
                                if (exception instanceof ApiException) {
                                    Status status = ((ApiException) exception).mStatus;
                                    int i11 = status.zzc;
                                    ConnectionResult connectionResult = status.zzf;
                                    if (connectionResult == null) {
                                        i8 = -1;
                                    } else {
                                        i8 = connectionResult.zzb;
                                    }
                                    i4 = i8;
                                    i5 = i11;
                                } else {
                                    i7 = 101;
                                }
                            }
                            i5 = i7;
                            i4 = -1;
                        }
                        if (z2) {
                            long j3 = this.zad;
                            j = System.currentTimeMillis();
                            j2 = j3;
                            i6 = (int) (SystemClock.elapsedRealtime() - this.zae);
                        } else {
                            j2 = 0;
                            j = 0;
                            i6 = -1;
                        }
                        MethodInvocation methodInvocation = new MethodInvocation(this.zab, i5, i4, j2, j, null, null, gCoreServiceId, i6);
                        long j4 = (long) i2;
                        Handler handler = googleApiManager.zat;
                        zace zace = new zace(methodInvocation, i3, j4, i);
                        handler.sendMessage(handler.obtainMessage(18, zace));
                    }
                }
            }
        }
    }
}
