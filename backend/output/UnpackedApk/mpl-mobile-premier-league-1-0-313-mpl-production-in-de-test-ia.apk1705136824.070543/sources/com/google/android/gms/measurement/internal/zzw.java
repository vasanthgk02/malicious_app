package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzej;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzw extends zzx {
    public final /* synthetic */ zzz zza;
    public final zzej zzh;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzw(zzz zzz, String str, int i, zzej zzej) {
        // this.zza = zzz;
        super(str, i);
        this.zzh = zzej;
    }

    public final int zza() {
        return this.zzh.zzb();
    }

    public final boolean zzb() {
        return this.zzh.zzo();
    }

    public final boolean zzc() {
        return false;
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v1, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r7v2, types: [java.lang.Integer] */
    /* JADX WARNING: type inference failed for: r7v3, types: [java.lang.Boolean] */
    /* JADX WARNING: type inference failed for: r6v1, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r6v2 */
    /* JADX WARNING: type inference failed for: r7v4, types: [java.lang.Boolean] */
    /* JADX WARNING: type inference failed for: r7v6, types: [java.lang.Boolean] */
    /* JADX WARNING: type inference failed for: r7v7, types: [java.lang.Boolean] */
    /* JADX WARNING: type inference failed for: r7v8, types: [java.lang.Boolean] */
    /* JADX WARNING: type inference failed for: r7v9, types: [java.lang.Boolean] */
    /* JADX WARNING: type inference failed for: r7v10, types: [java.lang.Boolean] */
    /* JADX WARNING: type inference failed for: r7v11, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r7v12, types: [java.lang.Integer] */
    /* JADX WARNING: type inference failed for: r5v52, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r5v54, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r5v55 */
    /* JADX WARNING: type inference failed for: r7v13 */
    /* JADX WARNING: type inference failed for: r7v14 */
    /* JADX WARNING: type inference failed for: r7v15 */
    /* JADX WARNING: type inference failed for: r7v16 */
    /* JADX WARNING: type inference failed for: r7v17 */
    /* JADX WARNING: type inference failed for: r7v18 */
    /* JADX WARNING: type inference failed for: r7v19 */
    /* JADX WARNING: type inference failed for: r7v20 */
    /* JADX WARNING: type inference failed for: r5v56 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r7v0
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], java.lang.Boolean, java.lang.Integer]
      uses: [java.lang.Object, ?[int, boolean, OBJECT, ARRAY, byte, short, char], java.lang.Boolean, ?[OBJECT, ARRAY]]
      mth insns count: 415
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0444  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x044c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x044d  */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzd(java.lang.Long r17, java.lang.Long r18, com.google.android.gms.internal.measurement.zzfs r19, long r20, com.google.android.gms.measurement.internal.zzar r22, boolean r23) {
        /*
            r16 = this;
            r0 = r16
            com.google.android.gms.internal.measurement.zzoi.zzc()
            com.google.android.gms.measurement.internal.zzz r1 = r0.zza
            com.google.android.gms.measurement.internal.zzgi r1 = r1.zzs
            com.google.android.gms.measurement.internal.zzaf r1 = r1.zzk
            java.lang.String r2 = r0.zzb
            com.google.android.gms.measurement.internal.zzek r3 = com.google.android.gms.measurement.internal.zzel.zzX
            boolean r1 = r1.zzs(r2, r3)
            com.google.android.gms.internal.measurement.zzej r2 = r0.zzh
            boolean r2 = r2.zzn()
            if (r2 == 0) goto L_0x0020
            r2 = r22
            long r2 = r2.zze
            goto L_0x0022
        L_0x0020:
            r2 = r20
        L_0x0022:
            com.google.android.gms.measurement.internal.zzz r4 = r0.zza
            com.google.android.gms.measurement.internal.zzgi r4 = r4.zzs
            com.google.android.gms.measurement.internal.zzey r4 = r4.zzaz()
            java.lang.String r4 = r4.zzq()
            r5 = 2
            boolean r4 = android.util.Log.isLoggable(r4, r5)
            java.lang.String r6 = "null"
            r7 = 0
            r8 = 1
            r9 = 0
            if (r4 == 0) goto L_0x0115
            com.google.android.gms.measurement.internal.zzz r4 = r0.zza
            com.google.android.gms.measurement.internal.zzgi r4 = r4.zzs
            com.google.android.gms.measurement.internal.zzey r4 = r4.zzaz()
            com.google.android.gms.measurement.internal.zzew r4 = r4.zzl
            int r10 = r0.zzc
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            com.google.android.gms.internal.measurement.zzej r11 = r0.zzh
            boolean r11 = r11.zzp()
            if (r11 == 0) goto L_0x005d
            com.google.android.gms.internal.measurement.zzej r11 = r0.zzh
            int r11 = r11.zzb()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            goto L_0x005e
        L_0x005d:
            r11 = r7
        L_0x005e:
            com.google.android.gms.measurement.internal.zzz r12 = r0.zza
            com.google.android.gms.measurement.internal.zzgi r12 = r12.zzs
            com.google.android.gms.measurement.internal.zzet r12 = r12.zzq
            com.google.android.gms.internal.measurement.zzej r13 = r0.zzh
            java.lang.String r13 = r13.zzg()
            java.lang.String r12 = r12.zzd(r13)
            java.lang.String r13 = "Evaluating filter. audience, filter, event"
            r4.zzd(r13, r10, r11, r12)
            com.google.android.gms.measurement.internal.zzz r4 = r0.zza
            com.google.android.gms.measurement.internal.zzgi r4 = r4.zzs
            com.google.android.gms.measurement.internal.zzey r4 = r4.zzaz()
            com.google.android.gms.measurement.internal.zzew r4 = r4.zzl
            com.google.android.gms.measurement.internal.zzz r10 = r0.zza
            com.google.android.gms.measurement.internal.zzli r10 = r10.zzf
            com.google.android.gms.measurement.internal.zzlk r10 = r10.zzi
            com.google.android.gms.measurement.internal.zzli.zzak(r10)
            com.google.android.gms.internal.measurement.zzej r11 = r0.zzh
            if (r11 != 0) goto L_0x008d
            r5 = r6
            goto L_0x0110
        L_0x008d:
            java.lang.String r12 = "\nevent_filter {\n"
            java.lang.StringBuilder r12 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r12)
            boolean r13 = r11.zzp()
            if (r13 == 0) goto L_0x00a6
            int r13 = r11.zzb()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            java.lang.String r14 = "filter_id"
            com.google.android.gms.measurement.internal.zzlk.zzI(r12, r9, r14, r13)
        L_0x00a6:
            com.google.android.gms.measurement.internal.zzgi r13 = r10.zzs
            com.google.android.gms.measurement.internal.zzet r13 = r13.zzq
            java.lang.String r14 = r11.zzg()
            java.lang.String r13 = r13.zzd(r14)
            java.lang.String r14 = "event_name"
            com.google.android.gms.measurement.internal.zzlk.zzI(r12, r9, r14, r13)
            boolean r13 = r11.zzk()
            boolean r14 = r11.zzm()
            boolean r15 = r11.zzn()
            java.lang.String r13 = com.google.android.gms.measurement.internal.zzlk.zzG(r13, r14, r15)
            boolean r14 = r13.isEmpty()
            if (r14 != 0) goto L_0x00d2
            java.lang.String r14 = "filter_type"
            com.google.android.gms.measurement.internal.zzlk.zzI(r12, r9, r14, r13)
        L_0x00d2:
            boolean r13 = r11.zzo()
            if (r13 == 0) goto L_0x00e1
            com.google.android.gms.internal.measurement.zzeq r13 = r11.zzf()
            java.lang.String r14 = "event_count_filter"
            com.google.android.gms.measurement.internal.zzlk.zzJ(r12, r8, r14, r13)
        L_0x00e1:
            int r13 = r11.zza()
            if (r13 <= 0) goto L_0x0104
            java.lang.String r13 = "  filters {\n"
            r12.append(r13)
            java.util.List r11 = r11.zzh()
            java.util.Iterator r11 = r11.iterator()
        L_0x00f4:
            boolean r13 = r11.hasNext()
            if (r13 == 0) goto L_0x0104
            java.lang.Object r13 = r11.next()
            com.google.android.gms.internal.measurement.zzel r13 = (com.google.android.gms.internal.measurement.zzel) r13
            r10.zzE(r12, r5, r13)
            goto L_0x00f4
        L_0x0104:
            com.google.android.gms.measurement.internal.zzlk.zzF(r12, r8)
            java.lang.String r5 = "}\n}\n"
            r12.append(r5)
            java.lang.String r5 = r12.toString()
        L_0x0110:
            java.lang.String r10 = "Filter definition"
            r4.zzb(r10, r5)
        L_0x0115:
            com.google.android.gms.internal.measurement.zzej r4 = r0.zzh
            boolean r4 = r4.zzp()
            if (r4 == 0) goto L_0x0491
            com.google.android.gms.internal.measurement.zzej r4 = r0.zzh
            int r4 = r4.zzb()
            r5 = 256(0x100, float:3.59E-43)
            if (r4 <= r5) goto L_0x0129
            goto L_0x0491
        L_0x0129:
            com.google.android.gms.internal.measurement.zzej r4 = r0.zzh
            boolean r4 = r4.zzk()
            com.google.android.gms.internal.measurement.zzej r5 = r0.zzh
            boolean r5 = r5.zzm()
            com.google.android.gms.internal.measurement.zzej r10 = r0.zzh
            boolean r10 = r10.zzn()
            if (r4 != 0) goto L_0x0144
            if (r5 != 0) goto L_0x0144
            if (r10 == 0) goto L_0x0142
            goto L_0x0144
        L_0x0142:
            r4 = 0
            goto L_0x0145
        L_0x0144:
            r4 = 1
        L_0x0145:
            if (r23 == 0) goto L_0x0171
            if (r4 != 0) goto L_0x0171
            com.google.android.gms.measurement.internal.zzz r1 = r0.zza
            com.google.android.gms.measurement.internal.zzgi r1 = r1.zzs
            com.google.android.gms.measurement.internal.zzey r1 = r1.zzaz()
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzl
            int r2 = r0.zzc
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            com.google.android.gms.internal.measurement.zzej r3 = r0.zzh
            boolean r3 = r3.zzp()
            if (r3 == 0) goto L_0x016b
            com.google.android.gms.internal.measurement.zzej r3 = r0.zzh
            int r3 = r3.zzb()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)
        L_0x016b:
            java.lang.String r3 = "Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID"
            r1.zzc(r3, r2, r7)
            return r8
        L_0x0171:
            com.google.android.gms.internal.measurement.zzej r5 = r0.zzh
            java.lang.String r10 = r19.zzh()
            boolean r11 = r5.zzo()
            if (r11 == 0) goto L_0x0193
            com.google.android.gms.internal.measurement.zzeq r11 = r5.zzf()
            java.lang.Boolean r2 = com.google.android.gms.measurement.internal.zzx.zzh(r2, r11)
            if (r2 != 0) goto L_0x0189
            goto L_0x0437
        L_0x0189:
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x0193
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            goto L_0x0437
        L_0x0193:
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            java.util.List r3 = r5.zzh()
            java.util.Iterator r3 = r3.iterator()
        L_0x01a0:
            boolean r11 = r3.hasNext()
            if (r11 == 0) goto L_0x01d9
            java.lang.Object r11 = r3.next()
            com.google.android.gms.internal.measurement.zzel r11 = (com.google.android.gms.internal.measurement.zzel) r11
            java.lang.String r12 = r11.zze()
            boolean r12 = r12.isEmpty()
            if (r12 == 0) goto L_0x01d1
            com.google.android.gms.measurement.internal.zzz r2 = r0.zza
            com.google.android.gms.measurement.internal.zzgi r2 = r2.zzs
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzg
            com.google.android.gms.measurement.internal.zzz r3 = r0.zza
            com.google.android.gms.measurement.internal.zzgi r3 = r3.zzs
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzq
            java.lang.String r3 = r3.zzd(r10)
            java.lang.String r5 = "null or empty param name in filter. event"
            r2.zzb(r5, r3)
            goto L_0x0437
        L_0x01d1:
            java.lang.String r11 = r11.zze()
            r2.add(r11)
            goto L_0x01a0
        L_0x01d9:
            androidx.collection.ArrayMap r3 = new androidx.collection.ArrayMap
            r3.<init>()
            java.util.List r11 = r19.zzi()
            java.util.Iterator r11 = r11.iterator()
        L_0x01e6:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x0273
            java.lang.Object r12 = r11.next()
            com.google.android.gms.internal.measurement.zzfw r12 = (com.google.android.gms.internal.measurement.zzfw) r12
            java.lang.String r13 = r12.zzg()
            boolean r13 = r2.contains(r13)
            if (r13 == 0) goto L_0x01e6
            boolean r13 = r12.zzw()
            if (r13 == 0) goto L_0x021a
            java.lang.String r13 = r12.zzg()
            boolean r14 = r12.zzw()
            if (r14 == 0) goto L_0x0215
            long r14 = r12.zzd()
            java.lang.Long r12 = java.lang.Long.valueOf(r14)
            goto L_0x0216
        L_0x0215:
            r12 = r7
        L_0x0216:
            r3.put(r13, r12)
            goto L_0x01e6
        L_0x021a:
            boolean r13 = r12.zzu()
            if (r13 == 0) goto L_0x0238
            java.lang.String r13 = r12.zzg()
            boolean r14 = r12.zzu()
            if (r14 == 0) goto L_0x0233
            double r14 = r12.zza()
            java.lang.Double r12 = java.lang.Double.valueOf(r14)
            goto L_0x0234
        L_0x0233:
            r12 = r7
        L_0x0234:
            r3.put(r13, r12)
            goto L_0x01e6
        L_0x0238:
            boolean r13 = r12.zzy()
            if (r13 == 0) goto L_0x024a
            java.lang.String r13 = r12.zzg()
            java.lang.String r12 = r12.zzh()
            r3.put(r13, r12)
            goto L_0x01e6
        L_0x024a:
            com.google.android.gms.measurement.internal.zzz r2 = r0.zza
            com.google.android.gms.measurement.internal.zzgi r2 = r2.zzs
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzg
            com.google.android.gms.measurement.internal.zzz r3 = r0.zza
            com.google.android.gms.measurement.internal.zzgi r3 = r3.zzs
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzq
            java.lang.String r3 = r3.zzd(r10)
            com.google.android.gms.measurement.internal.zzz r5 = r0.zza
            com.google.android.gms.measurement.internal.zzgi r5 = r5.zzs
            com.google.android.gms.measurement.internal.zzet r5 = r5.zzq
            java.lang.String r10 = r12.zzg()
            java.lang.String r5 = r5.zze(r10)
            java.lang.String r10 = "Unknown value for param. event, param"
            r2.zzc(r10, r3, r5)
            goto L_0x0437
        L_0x0273:
            java.util.List r2 = r5.zzh()
            java.util.Iterator r2 = r2.iterator()
        L_0x027b:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x0435
            java.lang.Object r5 = r2.next()
            com.google.android.gms.internal.measurement.zzel r5 = (com.google.android.gms.internal.measurement.zzel) r5
            boolean r11 = r5.zzh()
            if (r11 == 0) goto L_0x0295
            boolean r11 = r5.zzg()
            if (r11 == 0) goto L_0x0295
            r11 = 1
            goto L_0x0296
        L_0x0295:
            r11 = 0
        L_0x0296:
            java.lang.String r12 = r5.zze()
            boolean r13 = r12.isEmpty()
            if (r13 == 0) goto L_0x02bb
            com.google.android.gms.measurement.internal.zzz r2 = r0.zza
            com.google.android.gms.measurement.internal.zzgi r2 = r2.zzs
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzg
            com.google.android.gms.measurement.internal.zzz r3 = r0.zza
            com.google.android.gms.measurement.internal.zzgi r3 = r3.zzs
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzq
            java.lang.String r3 = r3.zzd(r10)
            java.lang.String r5 = "Event has empty param name. event"
            r2.zzb(r5, r3)
            goto L_0x0437
        L_0x02bb:
            java.lang.Object r13 = r3.getOrDefault(r12, r7)
            boolean r14 = r13 instanceof java.lang.Long
            if (r14 == 0) goto L_0x030a
            boolean r14 = r5.zzi()
            if (r14 != 0) goto L_0x02ee
            com.google.android.gms.measurement.internal.zzz r2 = r0.zza
            com.google.android.gms.measurement.internal.zzgi r2 = r2.zzs
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzg
            com.google.android.gms.measurement.internal.zzz r3 = r0.zza
            com.google.android.gms.measurement.internal.zzgi r3 = r3.zzs
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzq
            java.lang.String r3 = r3.zzd(r10)
            com.google.android.gms.measurement.internal.zzz r5 = r0.zza
            com.google.android.gms.measurement.internal.zzgi r5 = r5.zzs
            com.google.android.gms.measurement.internal.zzet r5 = r5.zzq
            java.lang.String r5 = r5.zze(r12)
            java.lang.String r10 = "No number filter for long param. event, param"
            r2.zzc(r10, r3, r5)
            goto L_0x0437
        L_0x02ee:
            java.lang.Long r13 = (java.lang.Long) r13
            long r12 = r13.longValue()
            com.google.android.gms.internal.measurement.zzeq r5 = r5.zzc()
            java.lang.Boolean r5 = com.google.android.gms.measurement.internal.zzx.zzh(r12, r5)
            if (r5 != 0) goto L_0x0300
            goto L_0x0437
        L_0x0300:
            boolean r5 = r5.booleanValue()
            if (r5 != r11) goto L_0x027b
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            goto L_0x0437
        L_0x030a:
            boolean r14 = r13 instanceof java.lang.Double
            if (r14 == 0) goto L_0x0360
            boolean r14 = r5.zzi()
            if (r14 != 0) goto L_0x0339
            com.google.android.gms.measurement.internal.zzz r2 = r0.zza
            com.google.android.gms.measurement.internal.zzgi r2 = r2.zzs
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzg
            com.google.android.gms.measurement.internal.zzz r3 = r0.zza
            com.google.android.gms.measurement.internal.zzgi r3 = r3.zzs
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzq
            java.lang.String r3 = r3.zzd(r10)
            com.google.android.gms.measurement.internal.zzz r5 = r0.zza
            com.google.android.gms.measurement.internal.zzgi r5 = r5.zzs
            com.google.android.gms.measurement.internal.zzet r5 = r5.zzq
            java.lang.String r5 = r5.zze(r12)
            java.lang.String r10 = "No number filter for double param. event, param"
            r2.zzc(r10, r3, r5)
            goto L_0x0437
        L_0x0339:
            java.lang.Double r13 = (java.lang.Double) r13
            double r12 = r13.doubleValue()
            com.google.android.gms.internal.measurement.zzeq r5 = r5.zzc()
            java.math.BigDecimal r14 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x0351 }
            r14.<init>(r12)     // Catch:{ NumberFormatException -> 0x0351 }
            double r12 = java.lang.Math.ulp(r12)     // Catch:{ NumberFormatException -> 0x0351 }
            java.lang.Boolean r5 = com.google.android.gms.measurement.internal.zzx.zze(r14, r5, r12)     // Catch:{ NumberFormatException -> 0x0351 }
            goto L_0x0352
        L_0x0351:
            r5 = r7
        L_0x0352:
            if (r5 != 0) goto L_0x0356
            goto L_0x0437
        L_0x0356:
            boolean r5 = r5.booleanValue()
            if (r5 != r11) goto L_0x027b
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            goto L_0x0437
        L_0x0360:
            boolean r14 = r13 instanceof java.lang.String
            if (r14 == 0) goto L_0x03e9
            boolean r14 = r5.zzk()
            if (r14 == 0) goto L_0x037d
            java.lang.String r13 = (java.lang.String) r13
            com.google.android.gms.internal.measurement.zzex r5 = r5.zzd()
            com.google.android.gms.measurement.internal.zzz r12 = r0.zza
            com.google.android.gms.measurement.internal.zzgi r12 = r12.zzs
            com.google.android.gms.measurement.internal.zzey r12 = r12.zzaz()
            java.lang.Boolean r5 = com.google.android.gms.measurement.internal.zzx.zzf(r13, r5, r12)
            goto L_0x0393
        L_0x037d:
            boolean r14 = r5.zzi()
            if (r14 == 0) goto L_0x03c5
            java.lang.String r13 = (java.lang.String) r13
            boolean r14 = com.google.android.gms.measurement.internal.zzlk.zzx(r13)
            if (r14 == 0) goto L_0x03a1
            com.google.android.gms.internal.measurement.zzeq r5 = r5.zzc()
            java.lang.Boolean r5 = com.google.android.gms.measurement.internal.zzx.zzi(r13, r5)
        L_0x0393:
            if (r5 != 0) goto L_0x0397
            goto L_0x0437
        L_0x0397:
            boolean r5 = r5.booleanValue()
            if (r5 != r11) goto L_0x027b
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            goto L_0x0437
        L_0x03a1:
            com.google.android.gms.measurement.internal.zzz r2 = r0.zza
            com.google.android.gms.measurement.internal.zzgi r2 = r2.zzs
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzg
            com.google.android.gms.measurement.internal.zzz r3 = r0.zza
            com.google.android.gms.measurement.internal.zzgi r3 = r3.zzs
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzq
            java.lang.String r3 = r3.zzd(r10)
            com.google.android.gms.measurement.internal.zzz r5 = r0.zza
            com.google.android.gms.measurement.internal.zzgi r5 = r5.zzs
            com.google.android.gms.measurement.internal.zzet r5 = r5.zzq
            java.lang.String r5 = r5.zze(r12)
            java.lang.String r10 = "Invalid param value for number filter. event, param"
            r2.zzc(r10, r3, r5)
            goto L_0x0437
        L_0x03c5:
            com.google.android.gms.measurement.internal.zzz r2 = r0.zza
            com.google.android.gms.measurement.internal.zzgi r2 = r2.zzs
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzg
            com.google.android.gms.measurement.internal.zzz r3 = r0.zza
            com.google.android.gms.measurement.internal.zzgi r3 = r3.zzs
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzq
            java.lang.String r3 = r3.zzd(r10)
            com.google.android.gms.measurement.internal.zzz r5 = r0.zza
            com.google.android.gms.measurement.internal.zzgi r5 = r5.zzs
            com.google.android.gms.measurement.internal.zzet r5 = r5.zzq
            java.lang.String r5 = r5.zze(r12)
            java.lang.String r10 = "No filter for String param. event, param"
            r2.zzc(r10, r3, r5)
            goto L_0x0437
        L_0x03e9:
            if (r13 != 0) goto L_0x0411
            com.google.android.gms.measurement.internal.zzz r2 = r0.zza
            com.google.android.gms.measurement.internal.zzgi r2 = r2.zzs
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzl
            com.google.android.gms.measurement.internal.zzz r3 = r0.zza
            com.google.android.gms.measurement.internal.zzgi r3 = r3.zzs
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzq
            java.lang.String r3 = r3.zzd(r10)
            com.google.android.gms.measurement.internal.zzz r5 = r0.zza
            com.google.android.gms.measurement.internal.zzgi r5 = r5.zzs
            com.google.android.gms.measurement.internal.zzet r5 = r5.zzq
            java.lang.String r5 = r5.zze(r12)
            java.lang.String r7 = "Missing param for filter. event, param"
            r2.zzc(r7, r3, r5)
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            goto L_0x0437
        L_0x0411:
            com.google.android.gms.measurement.internal.zzz r2 = r0.zza
            com.google.android.gms.measurement.internal.zzgi r2 = r2.zzs
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzg
            com.google.android.gms.measurement.internal.zzz r3 = r0.zza
            com.google.android.gms.measurement.internal.zzgi r3 = r3.zzs
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzq
            java.lang.String r3 = r3.zzd(r10)
            com.google.android.gms.measurement.internal.zzz r5 = r0.zza
            com.google.android.gms.measurement.internal.zzgi r5 = r5.zzs
            com.google.android.gms.measurement.internal.zzet r5 = r5.zzq
            java.lang.String r5 = r5.zze(r12)
            java.lang.String r10 = "Unknown param type. event, param"
            r2.zzc(r10, r3, r5)
            goto L_0x0437
        L_0x0435:
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
        L_0x0437:
            com.google.android.gms.measurement.internal.zzz r2 = r0.zza
            com.google.android.gms.measurement.internal.zzgi r2 = r2.zzs
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzl
            if (r7 != 0) goto L_0x0444
            goto L_0x0445
        L_0x0444:
            r6 = r7
        L_0x0445:
            java.lang.String r3 = "Event filter result"
            r2.zzb(r3, r6)
            if (r7 != 0) goto L_0x044d
            return r9
        L_0x044d:
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            r0.zzd = r2
            boolean r3 = r7.booleanValue()
            if (r3 != 0) goto L_0x0458
            return r8
        L_0x0458:
            r0.zze = r2
            if (r4 == 0) goto L_0x0490
            boolean r2 = r19.zzu()
            if (r2 == 0) goto L_0x0490
            long r2 = r19.zzd()
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            com.google.android.gms.internal.measurement.zzej r3 = r0.zzh
            boolean r3 = r3.zzm()
            if (r3 == 0) goto L_0x0482
            if (r1 == 0) goto L_0x047f
            com.google.android.gms.internal.measurement.zzej r1 = r0.zzh
            boolean r1 = r1.zzo()
            if (r1 != 0) goto L_0x047d
            goto L_0x047f
        L_0x047d:
            r2 = r17
        L_0x047f:
            r0.zzg = r2
            goto L_0x0490
        L_0x0482:
            if (r1 == 0) goto L_0x048e
            com.google.android.gms.internal.measurement.zzej r1 = r0.zzh
            boolean r1 = r1.zzo()
            if (r1 == 0) goto L_0x048e
            r2 = r18
        L_0x048e:
            r0.zzf = r2
        L_0x0490:
            return r8
        L_0x0491:
            com.google.android.gms.measurement.internal.zzz r1 = r0.zza
            com.google.android.gms.measurement.internal.zzgi r1 = r1.zzs
            com.google.android.gms.measurement.internal.zzey r1 = r1.zzaz()
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzg
            java.lang.String r2 = r0.zzb
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzey.zzn(r2)
            com.google.android.gms.internal.measurement.zzej r3 = r0.zzh
            boolean r3 = r3.zzp()
            if (r3 == 0) goto L_0x04b3
            com.google.android.gms.internal.measurement.zzej r3 = r0.zzh
            int r3 = r3.zzb()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)
        L_0x04b3:
            java.lang.String r3 = java.lang.String.valueOf(r7)
            java.lang.String r4 = "Invalid event filter ID. appId, id"
            r1.zzc(r4, r2, r3)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzw.zzd(java.lang.Long, java.lang.Long, com.google.android.gms.internal.measurement.zzfs, long, com.google.android.gms.measurement.internal.zzar, boolean):boolean");
    }
}
