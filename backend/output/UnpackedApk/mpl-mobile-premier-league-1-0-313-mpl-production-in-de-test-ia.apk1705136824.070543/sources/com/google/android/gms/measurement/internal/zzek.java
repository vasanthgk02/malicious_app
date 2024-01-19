package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzek {
    public static final Object zza = new Object();
    public final String zzb;
    public final zzeh zzc;
    public final Object zzd;
    public final Object zze;
    public final Object zzf = new Object();
    public volatile Object zzg = null;
    public volatile Object zzh = null;

    public /* synthetic */ zzek(String str, Object obj, Object obj2, zzeh zzeh, zzej zzej) {
        this.zzb = str;
        this.zzd = obj;
        this.zze = obj2;
        this.zzc = zzeh;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:28|29|30|(1:32)|33|34|46|39) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0021, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r4 = com.google.android.gms.measurement.internal.zzel.zzaO.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r0.zzh = r1;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0044 */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0047 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x005e A[SYNTHETIC, Splitter:B:51:0x005e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zza(java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.zzf
            monitor-enter(r0)
            monitor-exit(r0)     // Catch:{ all -> 0x006c }
            if (r4 == 0) goto L_0x0007
            return r4
        L_0x0007:
            com.google.android.gms.measurement.internal.zzaa r4 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.zza
            if (r4 != 0) goto L_0x000e
            java.lang.Object r4 = r3.zzd
            return r4
        L_0x000e:
            java.lang.Object r4 = zza
            monitor-enter(r4)
            boolean r0 = com.google.android.gms.measurement.internal.zzaa.zza()     // Catch:{ all -> 0x0069 }
            if (r0 == 0) goto L_0x0022
            java.lang.Object r0 = r3.zzh     // Catch:{ all -> 0x0069 }
            if (r0 != 0) goto L_0x001e
            java.lang.Object r0 = r3.zzd     // Catch:{ all -> 0x0069 }
            goto L_0x0020
        L_0x001e:
            java.lang.Object r0 = r3.zzh     // Catch:{ all -> 0x0069 }
        L_0x0020:
            monitor-exit(r4)     // Catch:{ all -> 0x0069 }
            return r0
        L_0x0022:
            monitor-exit(r4)     // Catch:{ all -> 0x0069 }
            java.util.List r4 = com.google.android.gms.measurement.internal.zzel.zzaO     // Catch:{ SecurityException -> 0x0056 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ SecurityException -> 0x0056 }
        L_0x0029:
            boolean r0 = r4.hasNext()     // Catch:{ SecurityException -> 0x0056 }
            if (r0 == 0) goto L_0x0057
            java.lang.Object r0 = r4.next()     // Catch:{ SecurityException -> 0x0056 }
            com.google.android.gms.measurement.internal.zzek r0 = (com.google.android.gms.measurement.internal.zzek) r0     // Catch:{ SecurityException -> 0x0056 }
            boolean r1 = com.google.android.gms.measurement.internal.zzaa.zza()     // Catch:{ SecurityException -> 0x0056 }
            if (r1 != 0) goto L_0x004e
            r1 = 0
            com.google.android.gms.measurement.internal.zzeh r2 = r0.zzc     // Catch:{ IllegalStateException -> 0x0044 }
            if (r2 == 0) goto L_0x0044
            java.lang.Object r1 = r2.zza()     // Catch:{ IllegalStateException -> 0x0044 }
        L_0x0044:
            java.lang.Object r2 = zza     // Catch:{ SecurityException -> 0x0056 }
            monitor-enter(r2)     // Catch:{ SecurityException -> 0x0056 }
            r0.zzh = r1     // Catch:{ all -> 0x004b }
            monitor-exit(r2)     // Catch:{ all -> 0x004b }
            goto L_0x0029
        L_0x004b:
            r4 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x004b }
            throw r4     // Catch:{ SecurityException -> 0x0056 }
        L_0x004e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ SecurityException -> 0x0056 }
            java.lang.String r0 = "Refreshing flag cache must be done on a worker thread."
            r4.<init>(r0)     // Catch:{ SecurityException -> 0x0056 }
            throw r4     // Catch:{ SecurityException -> 0x0056 }
        L_0x0056:
        L_0x0057:
            com.google.android.gms.measurement.internal.zzeh r4 = r3.zzc
            if (r4 != 0) goto L_0x005e
            java.lang.Object r4 = r3.zzd
            return r4
        L_0x005e:
            java.lang.Object r4 = r4.zza()     // Catch:{ SecurityException -> 0x0066, IllegalStateException -> 0x0063 }
            return r4
        L_0x0063:
            java.lang.Object r4 = r3.zzd
            return r4
        L_0x0066:
            java.lang.Object r4 = r3.zzd
            return r4
        L_0x0069:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0069 }
            throw r0
        L_0x006c:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006c }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzek.zza(java.lang.Object):java.lang.Object");
    }
}
