package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.SystemClock;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.BlockingServiceConnection;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads_identifier.zze;
import com.google.android.gms.internal.ads_identifier.zzf;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-ads-identifier@@17.1.0 */
public class AdvertisingIdClient {
    public BlockingServiceConnection zza;
    public zzf zzb;
    public boolean zzc;
    public final Object zzd;
    public zzb zze;
    public final long zzf;
    public final Context zzg;

    @KeepForSdkWithMembers
    /* compiled from: com.google.android.gms:play-services-ads-identifier@@17.1.0 */
    public static final class Info {
        public final String zza;
        public final boolean zzb;

        @Deprecated
        public Info(String str, boolean z) {
            this.zza = str;
            this.zzb = z;
        }

        public String getId() {
            return this.zza;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.zzb;
        }

        public String toString() {
            String str = this.zza;
            boolean z = this.zzb;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
            sb.append("{");
            sb.append(str);
            sb.append("}");
            sb.append(z);
            return sb.toString();
        }
    }

    @KeepForSdk
    public AdvertisingIdClient(Context context) {
        this(context, 30000, false, false);
    }

    @KeepForSdk
    public static Info getAdvertisingIdInfo(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1, true, false);
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            advertisingIdClient.zzb(false);
            Info zzd2 = advertisingIdClient.zzd(-1);
            advertisingIdClient.zzc(zzd2, true, 0.0f, SystemClock.elapsedRealtime() - elapsedRealtime, "", null);
            advertisingIdClient.zza();
            return zzd2;
        } catch (Throwable th) {
            advertisingIdClient.zza();
            throw th;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:42|43|44) */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0068, code lost:
        throw new java.io.IOException("Remote exception");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x0061 */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean getIsAdIdFakeForDebugLogging(android.content.Context r7) throws java.io.IOException, com.google.android.gms.common.GooglePlayServicesNotAvailableException, com.google.android.gms.common.GooglePlayServicesRepairableException {
        /*
            com.google.android.gms.ads.identifier.AdvertisingIdClient r6 = new com.google.android.gms.ads.identifier.AdvertisingIdClient
            r2 = -1
            r4 = 0
            r5 = 0
            r0 = r6
            r1 = r7
            r0.<init>(r1, r2, r4, r5)
            r7 = 0
            r6.zzb(r7)     // Catch:{ all -> 0x006c }
            java.lang.String r0 = "Calling this from your main thread can lead to deadlock"
            com.google.android.gms.common.internal.Preconditions.checkNotMainThread(r0)     // Catch:{ all -> 0x006c }
            monitor-enter(r6)     // Catch:{ all -> 0x006c }
            boolean r0 = r6.zzc     // Catch:{ all -> 0x0069 }
            if (r0 != 0) goto L_0x0049
            java.lang.Object r0 = r6.zzd     // Catch:{ all -> 0x0069 }
            monitor-enter(r0)     // Catch:{ all -> 0x0069 }
            com.google.android.gms.ads.identifier.zzb r1 = r6.zze     // Catch:{ all -> 0x0046 }
            if (r1 == 0) goto L_0x003e
            boolean r1 = r1.zzb     // Catch:{ all -> 0x0046 }
            if (r1 == 0) goto L_0x003e
            monitor-exit(r0)     // Catch:{ all -> 0x0046 }
            r6.zzb(r7)     // Catch:{ Exception -> 0x0035 }
            boolean r7 = r6.zzc     // Catch:{ all -> 0x0069 }
            if (r7 == 0) goto L_0x002d
            goto L_0x0049
        L_0x002d:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x0069 }
            java.lang.String r0 = "AdvertisingIdClient cannot reconnect."
            r7.<init>(r0)     // Catch:{ all -> 0x0069 }
            throw r7     // Catch:{ all -> 0x0069 }
        L_0x0035:
            r7 = move-exception
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0069 }
            java.lang.String r1 = "AdvertisingIdClient cannot reconnect."
            r0.<init>(r1, r7)     // Catch:{ all -> 0x0069 }
            throw r0     // Catch:{ all -> 0x0069 }
        L_0x003e:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x0046 }
            java.lang.String r1 = "AdvertisingIdClient is not connected."
            r7.<init>(r1)     // Catch:{ all -> 0x0046 }
            throw r7     // Catch:{ all -> 0x0046 }
        L_0x0046:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0046 }
            throw r7     // Catch:{ all -> 0x0069 }
        L_0x0049:
            com.google.android.gms.common.BlockingServiceConnection r7 = r6.zza     // Catch:{ all -> 0x0069 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ all -> 0x0069 }
            com.google.android.gms.internal.ads_identifier.zzf r7 = r6.zzb     // Catch:{ all -> 0x0069 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ all -> 0x0069 }
            com.google.android.gms.internal.ads_identifier.zzf r7 = r6.zzb     // Catch:{ RemoteException -> 0x0061 }
            boolean r7 = r7.zzd()     // Catch:{ RemoteException -> 0x0061 }
            monitor-exit(r6)     // Catch:{ all -> 0x0069 }
            r6.zze()     // Catch:{ all -> 0x006c }
            r6.zza()
            return r7
        L_0x0061:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x0069 }
            java.lang.String r0 = "Remote exception"
            r7.<init>(r0)     // Catch:{ all -> 0x0069 }
            throw r7     // Catch:{ all -> 0x0069 }
        L_0x0069:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0069 }
            throw r7     // Catch:{ all -> 0x006c }
        L_0x006c:
            r7 = move-exception
            r6.zza()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.getIsAdIdFakeForDebugLogging(android.content.Context):boolean");
    }

    @ShowFirstParty
    @KeepForSdk
    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:39|40|41) */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0063, code lost:
        throw new java.io.IOException("Remote exception");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x005c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.ads.identifier.AdvertisingIdClient.Info zzd(int r4) throws java.io.IOException {
        /*
            r3 = this;
            java.lang.String r4 = "Calling this from your main thread can lead to deadlock"
            com.google.android.gms.common.internal.Preconditions.checkNotMainThread(r4)
            monitor-enter(r3)
            boolean r4 = r3.zzc     // Catch:{ all -> 0x0064 }
            if (r4 != 0) goto L_0x003b
            java.lang.Object r4 = r3.zzd     // Catch:{ all -> 0x0064 }
            monitor-enter(r4)     // Catch:{ all -> 0x0064 }
            com.google.android.gms.ads.identifier.zzb r0 = r3.zze     // Catch:{ all -> 0x0038 }
            if (r0 == 0) goto L_0x0030
            boolean r0 = r0.zzb     // Catch:{ all -> 0x0038 }
            if (r0 == 0) goto L_0x0030
            monitor-exit(r4)     // Catch:{ all -> 0x0038 }
            r4 = 0
            r3.zzb(r4)     // Catch:{ Exception -> 0x0027 }
            boolean r4 = r3.zzc     // Catch:{ all -> 0x0064 }
            if (r4 == 0) goto L_0x001f
            goto L_0x003b
        L_0x001f:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x0064 }
            java.lang.String r0 = "AdvertisingIdClient cannot reconnect."
            r4.<init>(r0)     // Catch:{ all -> 0x0064 }
            throw r4     // Catch:{ all -> 0x0064 }
        L_0x0027:
            r4 = move-exception
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0064 }
            java.lang.String r1 = "AdvertisingIdClient cannot reconnect."
            r0.<init>(r1, r4)     // Catch:{ all -> 0x0064 }
            throw r0     // Catch:{ all -> 0x0064 }
        L_0x0030:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0038 }
            java.lang.String r1 = "AdvertisingIdClient is not connected."
            r0.<init>(r1)     // Catch:{ all -> 0x0038 }
            throw r0     // Catch:{ all -> 0x0038 }
        L_0x0038:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0038 }
            throw r0     // Catch:{ all -> 0x0064 }
        L_0x003b:
            com.google.android.gms.common.BlockingServiceConnection r4 = r3.zza     // Catch:{ all -> 0x0064 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ all -> 0x0064 }
            com.google.android.gms.internal.ads_identifier.zzf r4 = r3.zzb     // Catch:{ all -> 0x0064 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ all -> 0x0064 }
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r4 = new com.google.android.gms.ads.identifier.AdvertisingIdClient$Info     // Catch:{ RemoteException -> 0x005c }
            com.google.android.gms.internal.ads_identifier.zzf r0 = r3.zzb     // Catch:{ RemoteException -> 0x005c }
            java.lang.String r0 = r0.zzc()     // Catch:{ RemoteException -> 0x005c }
            com.google.android.gms.internal.ads_identifier.zzf r1 = r3.zzb     // Catch:{ RemoteException -> 0x005c }
            r2 = 1
            boolean r1 = r1.zze(r2)     // Catch:{ RemoteException -> 0x005c }
            r4.<init>(r0, r1)     // Catch:{ RemoteException -> 0x005c }
            monitor-exit(r3)     // Catch:{ all -> 0x0064 }
            r3.zze()
            return r4
        L_0x005c:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x0064 }
            java.lang.String r0 = "Remote exception"
            r4.<init>(r0)     // Catch:{ all -> 0x0064 }
            throw r4     // Catch:{ all -> 0x0064 }
        L_0x0064:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0064 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.zzd(int):com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:2|3|(3:5|6|7)|8|9|(1:11)|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0011 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0019  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zze() {
        /*
            r6 = this;
            java.lang.Object r0 = r6.zzd
            monitor-enter(r0)
            com.google.android.gms.ads.identifier.zzb r1 = r6.zze     // Catch:{ all -> 0x0022 }
            if (r1 == 0) goto L_0x0011
            java.util.concurrent.CountDownLatch r1 = r1.zza     // Catch:{ all -> 0x0022 }
            r1.countDown()     // Catch:{ all -> 0x0022 }
            com.google.android.gms.ads.identifier.zzb r1 = r6.zze     // Catch:{ InterruptedException -> 0x0011 }
            r1.join()     // Catch:{ InterruptedException -> 0x0011 }
        L_0x0011:
            long r1 = r6.zzf     // Catch:{ all -> 0x0022 }
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0020
            com.google.android.gms.ads.identifier.zzb r3 = new com.google.android.gms.ads.identifier.zzb     // Catch:{ all -> 0x0022 }
            r3.<init>(r6, r1)     // Catch:{ all -> 0x0022 }
            r6.zze = r3     // Catch:{ all -> 0x0022 }
        L_0x0020:
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            return
        L_0x0022:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.zze():void");
    }

    public final void finalize() throws Throwable {
        zza();
        super.finalize();
    }

    @KeepForSdk
    public Info getInfo() throws IOException {
        return zzd(-1);
    }

    @KeepForSdk
    public void start() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzb(true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0029, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza() {
        /*
            r3 = this;
            java.lang.String r0 = "Calling this from your main thread can lead to deadlock"
            com.google.android.gms.common.internal.Preconditions.checkNotMainThread(r0)
            monitor-enter(r3)
            android.content.Context r0 = r3.zzg     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x0028
            com.google.android.gms.common.BlockingServiceConnection r0 = r3.zza     // Catch:{ all -> 0x002a }
            if (r0 != 0) goto L_0x000f
            goto L_0x0028
        L_0x000f:
            boolean r0 = r3.zzc     // Catch:{ all -> 0x001e }
            if (r0 == 0) goto L_0x001e
            com.google.android.gms.common.stats.ConnectionTracker r0 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ all -> 0x001e }
            android.content.Context r1 = r3.zzg     // Catch:{ all -> 0x001e }
            com.google.android.gms.common.BlockingServiceConnection r2 = r3.zza     // Catch:{ all -> 0x001e }
            r0.unbindService(r1, r2)     // Catch:{ all -> 0x001e }
        L_0x001e:
            r0 = 0
            r3.zzc = r0     // Catch:{ all -> 0x002a }
            r0 = 0
            r3.zzb = r0     // Catch:{ all -> 0x002a }
            r3.zza = r0     // Catch:{ all -> 0x002a }
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            return
        L_0x0028:
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            return
        L_0x002a:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.zza():void");
    }

    @VisibleForTesting
    public final void zzb(boolean z) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.zzc) {
                    zza();
                }
                Context context = this.zzg;
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                int isGooglePlayServicesAvailable = GoogleApiAvailabilityLight.zza.isGooglePlayServicesAvailable(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
                if (isGooglePlayServicesAvailable != 0) {
                    if (isGooglePlayServicesAvailable != 2) {
                        throw new IOException("Google Play services not available");
                    }
                }
                BlockingServiceConnection blockingServiceConnection = new BlockingServiceConnection();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                if (ConnectionTracker.getInstance().bindService(context, intent, blockingServiceConnection, 1)) {
                    this.zza = blockingServiceConnection;
                    this.zzb = zze.zza(blockingServiceConnection.getServiceWithTimeout(MqttAsyncClient.DISCONNECT_TIMEOUT, TimeUnit.MILLISECONDS));
                    this.zzc = true;
                    if (z) {
                        zze();
                    }
                } else {
                    throw new IOException("Connection failure");
                }
            } catch (NameNotFoundException unused) {
                throw new GooglePlayServicesNotAvailableException(9);
            } catch (InterruptedException unused2) {
                throw new IOException("Interrupted exception");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @VisibleForTesting
    public final boolean zzc(Info info, boolean z, float f2, long j, String str, Throwable th) {
        if (Math.random() > 0.0d) {
            return false;
        }
        String str2 = "1";
        HashMap outline87 = GeneratedOutlineSupport.outline87("app_context", str2);
        if (info != null) {
            if (true != info.isLimitAdTrackingEnabled()) {
                str2 = "0";
            }
            outline87.put("limit_ad_tracking", str2);
            String id = info.getId();
            if (id != null) {
                outline87.put("ad_id_size", Integer.toString(id.length()));
            }
        }
        if (th != null) {
            outline87.put("error", th.getClass().getName());
        }
        outline87.put(InlineAnimation.TAG, "AdvertisingIdClient");
        outline87.put("time_spent", Long.toString(j));
        new zza(outline87).start();
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0015, code lost:
        r1 = r4;
     */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AdvertisingIdClient(android.content.Context r1, long r2, boolean r4, boolean r5) {
        /*
            r0 = this;
            r0.<init>()
            java.lang.Object r5 = new java.lang.Object
            r5.<init>()
            r0.zzd = r5
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r1)
            if (r4 == 0) goto L_0x0016
            android.content.Context r4 = r1.getApplicationContext()
            if (r4 == 0) goto L_0x0016
            r1 = r4
        L_0x0016:
            r0.zzg = r1
            r1 = 0
            r0.zzc = r1
            r0.zzf = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.<init>(android.content.Context, long, boolean, boolean):void");
    }
}
