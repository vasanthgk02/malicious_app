package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzaz extends zzaw {
    public zzaz() {
        this.zza.add(zzbl.APPLY);
        this.zza.add(zzbl.BLOCK);
        this.zza.add(zzbl.BREAK);
        this.zza.add(zzbl.CASE);
        this.zza.add(zzbl.DEFAULT);
        this.zza.add(zzbl.CONTINUE);
        this.zza.add(zzbl.DEFINE_FUNCTION);
        this.zza.add(zzbl.FN);
        this.zza.add(zzbl.IF);
        this.zza.add(zzbl.QUOTE);
        this.zza.add(zzbl.RETURN);
        this.zza.add(zzbl.SWITCH);
        this.zza.add(zzbl.TERNARY);
    }

    public static zzap zzc(zzg zzg, List list) {
        zzh.zzi(zzbl.FN.name(), 2, list);
        zzap zzb = zzg.zzb((zzap) list.get(0));
        zzap zzb2 = zzg.zzb((zzap) list.get(1));
        if (zzb2 instanceof zzae) {
            List zzm = ((zzae) zzb2).zzm();
            List arrayList = new ArrayList();
            if (list.size() > 2) {
                arrayList = list.subList(2, list.size());
            }
            return new zzao(zzb.zzi(), zzm, arrayList, zzg);
        }
        throw new IllegalArgumentException(String.format("FN requires an ArrayValue of parameter names found %s", new Object[]{zzb2.getClass().getCanonicalName()}));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x011b, code lost:
        if (r8.equals("continue") == false) goto L_0x011f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzap zza(java.lang.String r8, com.google.android.gms.internal.measurement.zzg r9, java.util.List r10) {
        /*
            r7 = this;
            com.google.android.gms.internal.measurement.zzbl r0 = com.google.android.gms.internal.measurement.zzbl.ADD
            com.google.android.gms.internal.measurement.zzbl r0 = com.google.android.gms.internal.measurement.zzh.zze(r8)
            int r0 = r0.ordinal()
            r1 = 3
            r2 = 2
            r3 = 1
            r4 = 0
            if (r0 == r2) goto L_0x01fc
            r5 = 15
            if (r0 == r5) goto L_0x01f0
            r5 = 25
            if (r0 == r5) goto L_0x01eb
            r5 = 41
            if (r0 == r5) goto L_0x0199
            r5 = 54
            if (r0 == r5) goto L_0x0193
            r5 = 57
            java.lang.String r6 = "return"
            if (r0 == r5) goto L_0x0177
            r5 = 19
            if (r0 == r5) goto L_0x0156
            r5 = 20
            if (r0 == r5) goto L_0x0132
            r5 = 60
            if (r0 == r5) goto L_0x0084
            r5 = 61
            if (r0 == r5) goto L_0x0058
            switch(r0) {
                case 11: goto L_0x004a;
                case 12: goto L_0x003e;
                case 13: goto L_0x0156;
                default: goto L_0x0039;
            }
        L_0x0039:
            com.google.android.gms.internal.measurement.zzap r8 = super.zzb(r8)
            return r8
        L_0x003e:
            com.google.android.gms.internal.measurement.zzbl r8 = com.google.android.gms.internal.measurement.zzbl.BREAK
            java.lang.String r8 = r8.name()
            com.google.android.gms.internal.measurement.zzh.zzh(r8, r4, r10)
            com.google.android.gms.internal.measurement.zzap r8 = com.google.android.gms.internal.measurement.zzap.zzi
            return r8
        L_0x004a:
            com.google.android.gms.internal.measurement.zzg r8 = r9.zza()
            com.google.android.gms.internal.measurement.zzae r9 = new com.google.android.gms.internal.measurement.zzae
            r9.<init>(r10)
            com.google.android.gms.internal.measurement.zzap r8 = r8.zzc(r9)
            return r8
        L_0x0058:
            com.google.android.gms.internal.measurement.zzbl r8 = com.google.android.gms.internal.measurement.zzbl.TERNARY
            java.lang.Object r8 = com.android.tools.r8.GeneratedOutlineSupport.outline27(r8, r1, r10, r4)
            com.google.android.gms.internal.measurement.zzap r8 = (com.google.android.gms.internal.measurement.zzap) r8
            com.google.android.gms.internal.measurement.zzap r8 = r9.zzb(r8)
            java.lang.Boolean r8 = r8.zzg()
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x0079
            java.lang.Object r8 = r10.get(r3)
            com.google.android.gms.internal.measurement.zzap r8 = (com.google.android.gms.internal.measurement.zzap) r8
            com.google.android.gms.internal.measurement.zzap r8 = r9.zzb(r8)
            goto L_0x0083
        L_0x0079:
            java.lang.Object r8 = r10.get(r2)
            com.google.android.gms.internal.measurement.zzap r8 = (com.google.android.gms.internal.measurement.zzap) r8
            com.google.android.gms.internal.measurement.zzap r8 = r9.zzb(r8)
        L_0x0083:
            return r8
        L_0x0084:
            com.google.android.gms.internal.measurement.zzbl r8 = com.google.android.gms.internal.measurement.zzbl.SWITCH
            java.lang.Object r8 = com.android.tools.r8.GeneratedOutlineSupport.outline27(r8, r1, r10, r4)
            com.google.android.gms.internal.measurement.zzap r8 = (com.google.android.gms.internal.measurement.zzap) r8
            com.google.android.gms.internal.measurement.zzap r8 = r9.zzb(r8)
            java.lang.Object r0 = r10.get(r3)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r9.zzb(r0)
            java.lang.Object r10 = r10.get(r2)
            com.google.android.gms.internal.measurement.zzap r10 = (com.google.android.gms.internal.measurement.zzap) r10
            com.google.android.gms.internal.measurement.zzap r10 = r9.zzb(r10)
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzae
            if (r1 == 0) goto L_0x012a
            boolean r1 = r10 instanceof com.google.android.gms.internal.measurement.zzae
            if (r1 == 0) goto L_0x0122
            com.google.android.gms.internal.measurement.zzae r0 = (com.google.android.gms.internal.measurement.zzae) r0
            com.google.android.gms.internal.measurement.zzae r10 = (com.google.android.gms.internal.measurement.zzae) r10
            r1 = 0
            r2 = 0
        L_0x00b2:
            int r4 = r0.zzc()
            if (r1 >= r4) goto L_0x00ed
            if (r2 != 0) goto L_0x00cb
            com.google.android.gms.internal.measurement.zzap r2 = r0.zze(r1)
            com.google.android.gms.internal.measurement.zzap r2 = r9.zzb(r2)
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x00c9
            goto L_0x00cb
        L_0x00c9:
            r2 = 0
            goto L_0x00ea
        L_0x00cb:
            com.google.android.gms.internal.measurement.zzap r2 = r10.zze(r1)
            com.google.android.gms.internal.measurement.zzap r2 = r9.zzb(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.measurement.zzag
            if (r4 == 0) goto L_0x00e9
            r8 = r2
            com.google.android.gms.internal.measurement.zzag r8 = (com.google.android.gms.internal.measurement.zzag) r8
            java.lang.String r8 = r8.zzc()
            java.lang.String r9 = "break"
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x011e
            com.google.android.gms.internal.measurement.zzap r8 = com.google.android.gms.internal.measurement.zzap.zzf
            return r8
        L_0x00e9:
            r2 = 1
        L_0x00ea:
            int r1 = r1 + 1
            goto L_0x00b2
        L_0x00ed:
            int r8 = r0.zzc()
            int r8 = r8 + r3
            int r1 = r10.zzc()
            if (r8 != r1) goto L_0x011f
            int r8 = r0.zzc()
            com.google.android.gms.internal.measurement.zzap r8 = r10.zze(r8)
            com.google.android.gms.internal.measurement.zzap r2 = r9.zzb(r8)
            boolean r8 = r2 instanceof com.google.android.gms.internal.measurement.zzag
            if (r8 == 0) goto L_0x011f
            r8 = r2
            com.google.android.gms.internal.measurement.zzag r8 = (com.google.android.gms.internal.measurement.zzag) r8
            java.lang.String r8 = r8.zzc()
            boolean r9 = r8.equals(r6)
            if (r9 != 0) goto L_0x011e
            java.lang.String r9 = "continue"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x011e
            goto L_0x011f
        L_0x011e:
            return r2
        L_0x011f:
            com.google.android.gms.internal.measurement.zzap r8 = com.google.android.gms.internal.measurement.zzap.zzf
            return r8
        L_0x0122:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "Malformed SWITCH statement, case statements are not a list"
            r8.<init>(r9)
            throw r8
        L_0x012a:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "Malformed SWITCH statement, cases are not a list"
            r8.<init>(r9)
            throw r8
        L_0x0132:
            com.google.android.gms.internal.measurement.zzbl r8 = com.google.android.gms.internal.measurement.zzbl.DEFINE_FUNCTION
            java.lang.String r8 = r8.name()
            com.google.android.gms.internal.measurement.zzh.zzi(r8, r2, r10)
            com.google.android.gms.internal.measurement.zzap r8 = zzc(r9, r10)
            r10 = r8
            com.google.android.gms.internal.measurement.zzai r10 = (com.google.android.gms.internal.measurement.zzai) r10
            java.lang.String r0 = r10.zzc()
            if (r0 != 0) goto L_0x014e
            java.lang.String r10 = ""
            r9.zzg(r10, r8)
            goto L_0x0155
        L_0x014e:
            java.lang.String r10 = r10.zzc()
            r9.zzg(r10, r8)
        L_0x0155:
            return r8
        L_0x0156:
            boolean r8 = r10.isEmpty()
            if (r8 == 0) goto L_0x015f
            com.google.android.gms.internal.measurement.zzap r8 = com.google.android.gms.internal.measurement.zzap.zzf
            goto L_0x0176
        L_0x015f:
            java.lang.Object r8 = r10.get(r4)
            com.google.android.gms.internal.measurement.zzap r8 = (com.google.android.gms.internal.measurement.zzap) r8
            com.google.android.gms.internal.measurement.zzap r8 = r9.zzb(r8)
            boolean r10 = r8 instanceof com.google.android.gms.internal.measurement.zzae
            if (r10 == 0) goto L_0x0174
            com.google.android.gms.internal.measurement.zzae r8 = (com.google.android.gms.internal.measurement.zzae) r8
            com.google.android.gms.internal.measurement.zzap r8 = r9.zzc(r8)
            goto L_0x0176
        L_0x0174:
            com.google.android.gms.internal.measurement.zzap r8 = com.google.android.gms.internal.measurement.zzap.zzf
        L_0x0176:
            return r8
        L_0x0177:
            boolean r8 = r10.isEmpty()
            if (r8 == 0) goto L_0x0180
            com.google.android.gms.internal.measurement.zzap r8 = com.google.android.gms.internal.measurement.zzap.zzj
            goto L_0x0192
        L_0x0180:
            com.google.android.gms.internal.measurement.zzbl r8 = com.google.android.gms.internal.measurement.zzbl.RETURN
            java.lang.Object r8 = com.android.tools.r8.GeneratedOutlineSupport.outline27(r8, r3, r10, r4)
            com.google.android.gms.internal.measurement.zzap r8 = (com.google.android.gms.internal.measurement.zzap) r8
            com.google.android.gms.internal.measurement.zzap r8 = r9.zzb(r8)
            com.google.android.gms.internal.measurement.zzag r9 = new com.google.android.gms.internal.measurement.zzag
            r9.<init>(r6, r8)
            r8 = r9
        L_0x0192:
            return r8
        L_0x0193:
            com.google.android.gms.internal.measurement.zzae r8 = new com.google.android.gms.internal.measurement.zzae
            r8.<init>(r10)
            return r8
        L_0x0199:
            com.google.android.gms.internal.measurement.zzbl r8 = com.google.android.gms.internal.measurement.zzbl.IF
            java.lang.String r8 = r8.name()
            com.google.android.gms.internal.measurement.zzh.zzi(r8, r2, r10)
            java.lang.Object r8 = r10.get(r4)
            com.google.android.gms.internal.measurement.zzap r8 = (com.google.android.gms.internal.measurement.zzap) r8
            com.google.android.gms.internal.measurement.zzap r8 = r9.zzb(r8)
            java.lang.Object r0 = r10.get(r3)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r9.zzb(r0)
            int r1 = r10.size()
            if (r1 <= r2) goto L_0x01c7
            java.lang.Object r10 = r10.get(r2)
            com.google.android.gms.internal.measurement.zzap r10 = (com.google.android.gms.internal.measurement.zzap) r10
            com.google.android.gms.internal.measurement.zzap r10 = r9.zzb(r10)
            goto L_0x01c8
        L_0x01c7:
            r10 = 0
        L_0x01c8:
            com.google.android.gms.internal.measurement.zzap r1 = com.google.android.gms.internal.measurement.zzap.zzf
            java.lang.Boolean r8 = r8.zzg()
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x01db
            com.google.android.gms.internal.measurement.zzae r0 = (com.google.android.gms.internal.measurement.zzae) r0
            com.google.android.gms.internal.measurement.zzap r1 = r9.zzc(r0)
            goto L_0x01e3
        L_0x01db:
            if (r10 == 0) goto L_0x01e3
            com.google.android.gms.internal.measurement.zzae r10 = (com.google.android.gms.internal.measurement.zzae) r10
            com.google.android.gms.internal.measurement.zzap r1 = r9.zzc(r10)
        L_0x01e3:
            boolean r8 = r1 instanceof com.google.android.gms.internal.measurement.zzag
            if (r8 == 0) goto L_0x01e8
            return r1
        L_0x01e8:
            com.google.android.gms.internal.measurement.zzap r8 = com.google.android.gms.internal.measurement.zzap.zzf
            return r8
        L_0x01eb:
            com.google.android.gms.internal.measurement.zzap r8 = zzc(r9, r10)
            return r8
        L_0x01f0:
            com.google.android.gms.internal.measurement.zzbl r8 = com.google.android.gms.internal.measurement.zzbl.BREAK
            java.lang.String r8 = r8.name()
            com.google.android.gms.internal.measurement.zzh.zzh(r8, r4, r10)
            com.google.android.gms.internal.measurement.zzap r8 = com.google.android.gms.internal.measurement.zzap.zzh
            return r8
        L_0x01fc:
            com.google.android.gms.internal.measurement.zzbl r8 = com.google.android.gms.internal.measurement.zzbl.APPLY
            java.lang.Object r8 = com.android.tools.r8.GeneratedOutlineSupport.outline27(r8, r1, r10, r4)
            com.google.android.gms.internal.measurement.zzap r8 = (com.google.android.gms.internal.measurement.zzap) r8
            com.google.android.gms.internal.measurement.zzap r8 = r9.zzb(r8)
            java.lang.Object r0 = r10.get(r3)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r9.zzb(r0)
            java.lang.String r0 = r0.zzi()
            java.lang.Object r10 = r10.get(r2)
            com.google.android.gms.internal.measurement.zzap r10 = (com.google.android.gms.internal.measurement.zzap) r10
            com.google.android.gms.internal.measurement.zzap r10 = r9.zzb(r10)
            boolean r1 = r10 instanceof com.google.android.gms.internal.measurement.zzae
            if (r1 == 0) goto L_0x023d
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0235
            com.google.android.gms.internal.measurement.zzae r10 = (com.google.android.gms.internal.measurement.zzae) r10
            java.util.List r10 = r10.zzm()
            com.google.android.gms.internal.measurement.zzap r8 = r8.zzbQ(r0, r9, r10)
            return r8
        L_0x0235:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "Function name for apply is undefined"
            r8.<init>(r9)
            throw r8
        L_0x023d:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.Object[] r9 = new java.lang.Object[r3]
            java.lang.Class r10 = r10.getClass()
            java.lang.String r10 = r10.getCanonicalName()
            r9[r4] = r10
            java.lang.String r10 = "Function arguments for Apply are not a list found %s"
            java.lang.String r9 = java.lang.String.format(r10, r9)
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzaz.zza(java.lang.String, com.google.android.gms.internal.measurement.zzg, java.util.List):com.google.android.gms.internal.measurement.zzap");
    }
}
