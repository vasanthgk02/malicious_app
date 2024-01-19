package com.google.android.gms.internal.auth;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzfc extends zzfe {
    public static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    public zzfc() {
        super(null);
    }

    public /* synthetic */ zzfc(zzfb zzfb) {
        super(null);
    }

    public final void zza(Object obj, long j) {
        Object obj2;
        List list = (List) zzgz.zzf(obj, j);
        if (list instanceof zzfa) {
            obj2 = ((zzfa) list).zze();
        } else if (!zza.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzfx) || !(list instanceof zzeu)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzeu zzeu = (zzeu) list;
                if (zzeu.zzc()) {
                    zzeu.zzb();
                }
                return;
            }
        } else {
            return;
        }
        zzgz.zzp(obj, j, obj2);
    }

    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r1v9, types: [java.util.ArrayList] */
    /* JADX WARNING: type inference failed for: r0v3, types: [com.google.android.gms.internal.auth.zzeu] */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: type inference failed for: r1v12, types: [com.google.android.gms.internal.auth.zzez] */
    /* JADX WARNING: type inference failed for: r2v15 */
    /* JADX WARNING: type inference failed for: r2v16 */
    /* JADX WARNING: type inference failed for: r1v15 */
    /* JADX WARNING: type inference failed for: r1v16 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <E> void zzb(java.lang.Object r5, java.lang.Object r6, long r7) {
        /*
            r4 = this;
            java.lang.Object r6 = com.google.android.gms.internal.auth.zzgz.zzf(r6, r7)
            java.util.List r6 = (java.util.List) r6
            int r0 = r6.size()
            java.lang.Object r1 = com.google.android.gms.internal.auth.zzgz.zzf(r5, r7)
            java.util.List r1 = (java.util.List) r1
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L_0x0039
            boolean r2 = r1 instanceof com.google.android.gms.internal.auth.zzfa
            if (r2 == 0) goto L_0x0020
            com.google.android.gms.internal.auth.zzez r1 = new com.google.android.gms.internal.auth.zzez
            r1.<init>(r0)
            goto L_0x0035
        L_0x0020:
            boolean r2 = r1 instanceof com.google.android.gms.internal.auth.zzfx
            if (r2 == 0) goto L_0x0030
            boolean r2 = r1 instanceof com.google.android.gms.internal.auth.zzeu
            if (r2 == 0) goto L_0x0030
            com.google.android.gms.internal.auth.zzeu r1 = (com.google.android.gms.internal.auth.zzeu) r1
            com.google.android.gms.internal.auth.zzeu r0 = r1.zzd(r0)
            r1 = r0
            goto L_0x0035
        L_0x0030:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
        L_0x0035:
            com.google.android.gms.internal.auth.zzgz.zzp(r5, r7, r1)
            goto L_0x008f
        L_0x0039:
            java.lang.Class<?> r2 = zza
            java.lang.Class r3 = r1.getClass()
            boolean r2 = r2.isAssignableFrom(r3)
            if (r2 == 0) goto L_0x0057
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = r1.size()
            int r3 = r3 + r0
            r2.<init>(r3)
            r2.addAll(r1)
            com.google.android.gms.internal.auth.zzgz.zzp(r5, r7, r2)
        L_0x0055:
            r1 = r2
            goto L_0x008f
        L_0x0057:
            boolean r2 = r1 instanceof com.google.android.gms.internal.auth.zzgu
            if (r2 == 0) goto L_0x0072
            com.google.android.gms.internal.auth.zzez r2 = new com.google.android.gms.internal.auth.zzez
            int r3 = r1.size()
            int r3 = r3 + r0
            r2.<init>(r3)
            com.google.android.gms.internal.auth.zzgu r1 = (com.google.android.gms.internal.auth.zzgu) r1
            int r0 = r2.size()
            r2.addAll(r0, r1)
            com.google.android.gms.internal.auth.zzgz.zzp(r5, r7, r2)
            goto L_0x0055
        L_0x0072:
            boolean r2 = r1 instanceof com.google.android.gms.internal.auth.zzfx
            if (r2 == 0) goto L_0x008f
            boolean r2 = r1 instanceof com.google.android.gms.internal.auth.zzeu
            if (r2 == 0) goto L_0x008f
            r2 = r1
            com.google.android.gms.internal.auth.zzeu r2 = (com.google.android.gms.internal.auth.zzeu) r2
            boolean r3 = r2.zzc()
            if (r3 != 0) goto L_0x008f
            int r1 = r1.size()
            int r1 = r1 + r0
            com.google.android.gms.internal.auth.zzeu r1 = r2.zzd(r1)
            com.google.android.gms.internal.auth.zzgz.zzp(r5, r7, r1)
        L_0x008f:
            int r0 = r1.size()
            int r2 = r6.size()
            if (r0 <= 0) goto L_0x009e
            if (r2 <= 0) goto L_0x009e
            r1.addAll(r6)
        L_0x009e:
            if (r0 > 0) goto L_0x00a1
            goto L_0x00a2
        L_0x00a1:
            r6 = r1
        L_0x00a2:
            com.google.android.gms.internal.auth.zzgz.zzp(r5, r7, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzfc.zzb(java.lang.Object, java.lang.Object, long):void");
    }
}
