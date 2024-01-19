package com.google.android.gms.ads.identifier;

import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-ads-identifier@@17.1.0 */
public final class zzb extends Thread {
    public final CountDownLatch zza = new CountDownLatch(1);
    public boolean zzb = false;
    public final WeakReference<AdvertisingIdClient> zzc;
    public final long zzd;

    public zzb(AdvertisingIdClient advertisingIdClient, long j) {
        this.zzc = new WeakReference<>(advertisingIdClient);
        this.zzd = j;
        start();
    }

    public final void run() {
        try {
            if (!this.zza.await(this.zzd, TimeUnit.MILLISECONDS)) {
                AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient) this.zzc.get();
                if (advertisingIdClient != null) {
                    advertisingIdClient.zza();
                    this.zzb = true;
                }
            }
        } catch (InterruptedException unused) {
            AdvertisingIdClient advertisingIdClient2 = (AdvertisingIdClient) this.zzc.get();
            if (advertisingIdClient2 != null) {
                advertisingIdClient2.zza();
                this.zzb = true;
            }
        }
    }
}
