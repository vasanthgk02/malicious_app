package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzbh extends zzaw {
    public zzbh() {
        this.zza.add(zzbl.FOR_IN);
        this.zza.add(zzbl.FOR_IN_CONST);
        this.zza.add(zzbl.FOR_IN_LET);
        this.zza.add(zzbl.FOR_LET);
        this.zza.add(zzbl.FOR_OF);
        this.zza.add(zzbl.FOR_OF_CONST);
        this.zza.add(zzbl.FOR_OF_LET);
        this.zza.add(zzbl.WHILE);
    }

    public static zzap zzc(zzbf zzbf, Iterator it, zzap zzap) {
        if (it != null) {
            while (it.hasNext()) {
                zzap zzc = zzbf.zza((zzap) it.next()).zzc((zzae) zzap);
                if (zzc instanceof zzag) {
                    zzag zzag = (zzag) zzc;
                    if ("break".equals(zzag.zzc())) {
                        return zzap.zzf;
                    }
                    if ("return".equals(zzag.zzc())) {
                        return zzag;
                    }
                }
            }
        }
        return zzap.zzf;
    }

    public static zzap zzd(zzbf zzbf, zzap zzap, zzap zzap2) {
        return zzc(zzbf, zzap.zzl(), zzap2);
    }

    public static zzap zze(zzbf zzbf, zzap zzap, zzap zzap2) {
        if (zzap instanceof Iterable) {
            return zzc(zzbf, ((Iterable) zzap).iterator(), zzap2);
        }
        throw new IllegalArgumentException("Non-iterable type in for...of loop.");
    }

    /* JADX WARNING: type inference failed for: r1v9, types: [com.google.android.gms.internal.measurement.zzap] */
    /* JADX WARNING: type inference failed for: r1v14, types: [com.google.android.gms.internal.measurement.zzap] */
    /* JADX WARNING: type inference failed for: r1v15, types: [com.google.android.gms.internal.measurement.zzap] */
    /* JADX WARNING: type inference failed for: r1v20, types: [com.google.android.gms.internal.measurement.zzap] */
    /* JADX WARNING: type inference failed for: r5v6, types: [com.google.android.gms.internal.measurement.zzap] */
    /* JADX WARNING: type inference failed for: r5v7, types: [com.google.android.gms.internal.measurement.zzap] */
    /* JADX WARNING: type inference failed for: r5v13, types: [com.google.android.gms.internal.measurement.zzap] */
    /* JADX WARNING: type inference failed for: r5v15 */
    /* JADX WARNING: type inference failed for: r5v16 */
    /* JADX WARNING: type inference failed for: r5v17 */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x026f, code lost:
        if ("return".equals(r1.zzc()) != false) goto L_0x02ab;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzap zza(java.lang.String r10, com.google.android.gms.internal.measurement.zzg r11, java.util.List r12) {
        /*
            r9 = this;
            com.google.android.gms.internal.measurement.zzbl r0 = com.google.android.gms.internal.measurement.zzbl.ADD
            com.google.android.gms.internal.measurement.zzbl r0 = com.google.android.gms.internal.measurement.zzh.zze(r10)
            int r0 = r0.ordinal()
            r1 = 65
            r2 = 4
            java.lang.String r3 = "return"
            java.lang.String r4 = "break"
            r5 = 2
            r6 = 3
            r7 = 1
            r8 = 0
            if (r0 == r1) goto L_0x0220
            switch(r0) {
                case 26: goto L_0x01e6;
                case 27: goto L_0x01ac;
                case 28: goto L_0x0172;
                case 29: goto L_0x00cd;
                case 30: goto L_0x0093;
                case 31: goto L_0x0059;
                case 32: goto L_0x001f;
                default: goto L_0x001a;
            }
        L_0x001a:
            com.google.android.gms.internal.measurement.zzap r10 = super.zzb(r10)
            return r10
        L_0x001f:
            com.google.android.gms.internal.measurement.zzbl r10 = com.google.android.gms.internal.measurement.zzbl.FOR_OF_LET
            java.lang.Object r10 = com.android.tools.r8.GeneratedOutlineSupport.outline27(r10, r6, r12, r8)
            boolean r10 = r10 instanceof com.google.android.gms.internal.measurement.zzat
            if (r10 == 0) goto L_0x0051
            java.lang.Object r10 = r12.get(r8)
            com.google.android.gms.internal.measurement.zzap r10 = (com.google.android.gms.internal.measurement.zzap) r10
            java.lang.String r10 = r10.zzi()
            java.lang.Object r0 = r12.get(r7)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r11.zzb(r0)
            java.lang.Object r12 = r12.get(r5)
            com.google.android.gms.internal.measurement.zzap r12 = (com.google.android.gms.internal.measurement.zzap) r12
            com.google.android.gms.internal.measurement.zzap r12 = r11.zzb(r12)
            com.google.android.gms.internal.measurement.zzbe r1 = new com.google.android.gms.internal.measurement.zzbe
            r1.<init>(r11, r10)
            com.google.android.gms.internal.measurement.zzap r10 = zze(r1, r0, r12)
            return r10
        L_0x0051:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "Variable name in FOR_OF_LET must be a string"
            r10.<init>(r11)
            throw r10
        L_0x0059:
            com.google.android.gms.internal.measurement.zzbl r10 = com.google.android.gms.internal.measurement.zzbl.FOR_OF_CONST
            java.lang.Object r10 = com.android.tools.r8.GeneratedOutlineSupport.outline27(r10, r6, r12, r8)
            boolean r10 = r10 instanceof com.google.android.gms.internal.measurement.zzat
            if (r10 == 0) goto L_0x008b
            java.lang.Object r10 = r12.get(r8)
            com.google.android.gms.internal.measurement.zzap r10 = (com.google.android.gms.internal.measurement.zzap) r10
            java.lang.String r10 = r10.zzi()
            java.lang.Object r0 = r12.get(r7)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r11.zzb(r0)
            java.lang.Object r12 = r12.get(r5)
            com.google.android.gms.internal.measurement.zzap r12 = (com.google.android.gms.internal.measurement.zzap) r12
            com.google.android.gms.internal.measurement.zzap r12 = r11.zzb(r12)
            com.google.android.gms.internal.measurement.zzbd r1 = new com.google.android.gms.internal.measurement.zzbd
            r1.<init>(r11, r10)
            com.google.android.gms.internal.measurement.zzap r10 = zze(r1, r0, r12)
            return r10
        L_0x008b:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "Variable name in FOR_OF_CONST must be a string"
            r10.<init>(r11)
            throw r10
        L_0x0093:
            com.google.android.gms.internal.measurement.zzbl r10 = com.google.android.gms.internal.measurement.zzbl.FOR_OF
            java.lang.Object r10 = com.android.tools.r8.GeneratedOutlineSupport.outline27(r10, r6, r12, r8)
            boolean r10 = r10 instanceof com.google.android.gms.internal.measurement.zzat
            if (r10 == 0) goto L_0x00c5
            java.lang.Object r10 = r12.get(r8)
            com.google.android.gms.internal.measurement.zzap r10 = (com.google.android.gms.internal.measurement.zzap) r10
            java.lang.String r10 = r10.zzi()
            java.lang.Object r0 = r12.get(r7)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r11.zzb(r0)
            java.lang.Object r12 = r12.get(r5)
            com.google.android.gms.internal.measurement.zzap r12 = (com.google.android.gms.internal.measurement.zzap) r12
            com.google.android.gms.internal.measurement.zzap r12 = r11.zzb(r12)
            com.google.android.gms.internal.measurement.zzbg r1 = new com.google.android.gms.internal.measurement.zzbg
            r1.<init>(r11, r10)
            com.google.android.gms.internal.measurement.zzap r10 = zze(r1, r0, r12)
            return r10
        L_0x00c5:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "Variable name in FOR_OF must be a string"
            r10.<init>(r11)
            throw r10
        L_0x00cd:
            com.google.android.gms.internal.measurement.zzbl r10 = com.google.android.gms.internal.measurement.zzbl.FOR_LET
            java.lang.Object r10 = com.android.tools.r8.GeneratedOutlineSupport.outline27(r10, r2, r12, r8)
            com.google.android.gms.internal.measurement.zzap r10 = (com.google.android.gms.internal.measurement.zzap) r10
            com.google.android.gms.internal.measurement.zzap r10 = r11.zzb(r10)
            boolean r0 = r10 instanceof com.google.android.gms.internal.measurement.zzae
            if (r0 == 0) goto L_0x016a
            com.google.android.gms.internal.measurement.zzae r10 = (com.google.android.gms.internal.measurement.zzae) r10
            java.lang.Object r0 = r12.get(r7)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            java.lang.Object r1 = r12.get(r5)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            java.lang.Object r12 = r12.get(r6)
            com.google.android.gms.internal.measurement.zzap r12 = (com.google.android.gms.internal.measurement.zzap) r12
            com.google.android.gms.internal.measurement.zzap r12 = r11.zzb(r12)
            com.google.android.gms.internal.measurement.zzg r2 = r11.zza()
            r5 = 0
        L_0x00fa:
            int r6 = r10.zzc()
            if (r5 >= r6) goto L_0x0112
            com.google.android.gms.internal.measurement.zzap r6 = r10.zze(r5)
            java.lang.String r6 = r6.zzi()
            com.google.android.gms.internal.measurement.zzap r7 = r11.zzd(r6)
            r2.zzg(r6, r7)
            int r5 = r5 + 1
            goto L_0x00fa
        L_0x0112:
            com.google.android.gms.internal.measurement.zzap r5 = r11.zzb(r0)
            java.lang.Boolean r5 = r5.zzg()
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x0167
            r5 = r12
            com.google.android.gms.internal.measurement.zzae r5 = (com.google.android.gms.internal.measurement.zzae) r5
            com.google.android.gms.internal.measurement.zzap r5 = r11.zzc(r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.measurement.zzag
            if (r6 == 0) goto L_0x0145
            com.google.android.gms.internal.measurement.zzag r5 = (com.google.android.gms.internal.measurement.zzag) r5
            java.lang.String r6 = r5.zzc()
            boolean r6 = r4.equals(r6)
            if (r6 == 0) goto L_0x013a
            com.google.android.gms.internal.measurement.zzap r5 = com.google.android.gms.internal.measurement.zzap.zzf
            goto L_0x0169
        L_0x013a:
            java.lang.String r6 = r5.zzc()
            boolean r6 = r3.equals(r6)
            if (r6 == 0) goto L_0x0145
            goto L_0x0169
        L_0x0145:
            com.google.android.gms.internal.measurement.zzg r5 = r11.zza()
            r6 = 0
        L_0x014a:
            int r7 = r10.zzc()
            if (r6 >= r7) goto L_0x0162
            com.google.android.gms.internal.measurement.zzap r7 = r10.zze(r6)
            java.lang.String r7 = r7.zzi()
            com.google.android.gms.internal.measurement.zzap r8 = r2.zzd(r7)
            r5.zzg(r7, r8)
            int r6 = r6 + 1
            goto L_0x014a
        L_0x0162:
            r5.zzb(r1)
            r2 = r5
            goto L_0x0112
        L_0x0167:
            com.google.android.gms.internal.measurement.zzap r5 = com.google.android.gms.internal.measurement.zzap.zzf
        L_0x0169:
            return r5
        L_0x016a:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "Initializer variables in FOR_LET must be an ArrayList"
            r10.<init>(r11)
            throw r10
        L_0x0172:
            com.google.android.gms.internal.measurement.zzbl r10 = com.google.android.gms.internal.measurement.zzbl.FOR_IN_LET
            java.lang.Object r10 = com.android.tools.r8.GeneratedOutlineSupport.outline27(r10, r6, r12, r8)
            boolean r10 = r10 instanceof com.google.android.gms.internal.measurement.zzat
            if (r10 == 0) goto L_0x01a4
            java.lang.Object r10 = r12.get(r8)
            com.google.android.gms.internal.measurement.zzap r10 = (com.google.android.gms.internal.measurement.zzap) r10
            java.lang.String r10 = r10.zzi()
            java.lang.Object r0 = r12.get(r7)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r11.zzb(r0)
            java.lang.Object r12 = r12.get(r5)
            com.google.android.gms.internal.measurement.zzap r12 = (com.google.android.gms.internal.measurement.zzap) r12
            com.google.android.gms.internal.measurement.zzap r12 = r11.zzb(r12)
            com.google.android.gms.internal.measurement.zzbe r1 = new com.google.android.gms.internal.measurement.zzbe
            r1.<init>(r11, r10)
            com.google.android.gms.internal.measurement.zzap r10 = zzd(r1, r0, r12)
            return r10
        L_0x01a4:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "Variable name in FOR_IN_LET must be a string"
            r10.<init>(r11)
            throw r10
        L_0x01ac:
            com.google.android.gms.internal.measurement.zzbl r10 = com.google.android.gms.internal.measurement.zzbl.FOR_IN_CONST
            java.lang.Object r10 = com.android.tools.r8.GeneratedOutlineSupport.outline27(r10, r6, r12, r8)
            boolean r10 = r10 instanceof com.google.android.gms.internal.measurement.zzat
            if (r10 == 0) goto L_0x01de
            java.lang.Object r10 = r12.get(r8)
            com.google.android.gms.internal.measurement.zzap r10 = (com.google.android.gms.internal.measurement.zzap) r10
            java.lang.String r10 = r10.zzi()
            java.lang.Object r0 = r12.get(r7)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r11.zzb(r0)
            java.lang.Object r12 = r12.get(r5)
            com.google.android.gms.internal.measurement.zzap r12 = (com.google.android.gms.internal.measurement.zzap) r12
            com.google.android.gms.internal.measurement.zzap r12 = r11.zzb(r12)
            com.google.android.gms.internal.measurement.zzbd r1 = new com.google.android.gms.internal.measurement.zzbd
            r1.<init>(r11, r10)
            com.google.android.gms.internal.measurement.zzap r10 = zzd(r1, r0, r12)
            return r10
        L_0x01de:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "Variable name in FOR_IN_CONST must be a string"
            r10.<init>(r11)
            throw r10
        L_0x01e6:
            com.google.android.gms.internal.measurement.zzbl r10 = com.google.android.gms.internal.measurement.zzbl.FOR_IN
            java.lang.Object r10 = com.android.tools.r8.GeneratedOutlineSupport.outline27(r10, r6, r12, r8)
            boolean r10 = r10 instanceof com.google.android.gms.internal.measurement.zzat
            if (r10 == 0) goto L_0x0218
            java.lang.Object r10 = r12.get(r8)
            com.google.android.gms.internal.measurement.zzap r10 = (com.google.android.gms.internal.measurement.zzap) r10
            java.lang.String r10 = r10.zzi()
            java.lang.Object r0 = r12.get(r7)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r11.zzb(r0)
            java.lang.Object r12 = r12.get(r5)
            com.google.android.gms.internal.measurement.zzap r12 = (com.google.android.gms.internal.measurement.zzap) r12
            com.google.android.gms.internal.measurement.zzap r12 = r11.zzb(r12)
            com.google.android.gms.internal.measurement.zzbg r1 = new com.google.android.gms.internal.measurement.zzbg
            r1.<init>(r11, r10)
            com.google.android.gms.internal.measurement.zzap r10 = zzd(r1, r0, r12)
            return r10
        L_0x0218:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "Variable name in FOR_IN must be a string"
            r10.<init>(r11)
            throw r10
        L_0x0220:
            com.google.android.gms.internal.measurement.zzbl r10 = com.google.android.gms.internal.measurement.zzbl.WHILE
            java.lang.Object r10 = com.android.tools.r8.GeneratedOutlineSupport.outline27(r10, r2, r12, r8)
            com.google.android.gms.internal.measurement.zzap r10 = (com.google.android.gms.internal.measurement.zzap) r10
            java.lang.Object r0 = r12.get(r7)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            java.lang.Object r1 = r12.get(r5)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            java.lang.Object r12 = r12.get(r6)
            com.google.android.gms.internal.measurement.zzap r12 = (com.google.android.gms.internal.measurement.zzap) r12
            com.google.android.gms.internal.measurement.zzap r12 = r11.zzb(r12)
            com.google.android.gms.internal.measurement.zzap r1 = r11.zzb(r1)
            java.lang.Boolean r1 = r1.zzg()
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x024d
            goto L_0x0272
        L_0x024d:
            r1 = r12
            com.google.android.gms.internal.measurement.zzae r1 = (com.google.android.gms.internal.measurement.zzae) r1
            com.google.android.gms.internal.measurement.zzap r1 = r11.zzc(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzag
            if (r2 == 0) goto L_0x0272
            com.google.android.gms.internal.measurement.zzag r1 = (com.google.android.gms.internal.measurement.zzag) r1
            java.lang.String r2 = r1.zzc()
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0267
            com.google.android.gms.internal.measurement.zzap r1 = com.google.android.gms.internal.measurement.zzap.zzf
            goto L_0x02ab
        L_0x0267:
            java.lang.String r2 = r1.zzc()
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0272
            goto L_0x02ab
        L_0x0272:
            com.google.android.gms.internal.measurement.zzap r1 = r11.zzb(r10)
            java.lang.Boolean r1 = r1.zzg()
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x02a9
            r1 = r12
            com.google.android.gms.internal.measurement.zzae r1 = (com.google.android.gms.internal.measurement.zzae) r1
            com.google.android.gms.internal.measurement.zzap r1 = r11.zzc(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzag
            if (r2 == 0) goto L_0x02a5
            com.google.android.gms.internal.measurement.zzag r1 = (com.google.android.gms.internal.measurement.zzag) r1
            java.lang.String r2 = r1.zzc()
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x029a
            com.google.android.gms.internal.measurement.zzap r1 = com.google.android.gms.internal.measurement.zzap.zzf
            goto L_0x02ab
        L_0x029a:
            java.lang.String r2 = r1.zzc()
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x02a5
            goto L_0x02ab
        L_0x02a5:
            r11.zzb(r0)
            goto L_0x0272
        L_0x02a9:
            com.google.android.gms.internal.measurement.zzap r1 = com.google.android.gms.internal.measurement.zzap.zzf
        L_0x02ab:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbh.zza(java.lang.String, com.google.android.gms.internal.measurement.zzg, java.util.List):com.google.android.gms.internal.measurement.zzap");
    }
}
