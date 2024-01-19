package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzbb {
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01f5, code lost:
        r1 = r22.zzc();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01f9, code lost:
        r2 = r22.zzc();
        r4 = new com.google.android.gms.internal.measurement.zzae();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0207, code lost:
        if (r24.size() <= 1) goto L_0x026f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0209, code lost:
        r5 = java.lang.Math.max(0, (int) com.google.android.gms.internal.measurement.zzh.zza(r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(1)).zzh().doubleValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0225, code lost:
        if (r5 <= 0) goto L_0x0241;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0227, code lost:
        r6 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x022e, code lost:
        if (r6 >= java.lang.Math.min(r2, r1 + r5)) goto L_0x0241;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0230, code lost:
        r4.zzq(r4.zzc(), r9.zze(r1));
        r9.zzp(r1);
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0246, code lost:
        if (r24.size() <= 2) goto L_0x0283;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0248, code lost:
        r2 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x024d, code lost:
        if (r2 >= r24.size()) goto L_0x0283;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x024f, code lost:
        r5 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x025b, code lost:
        if ((r5 instanceof com.google.android.gms.internal.measurement.zzag) != false) goto L_0x0267;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x025d, code lost:
        r9.zzo((r1 + r2) - 2, r5);
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x026e, code lost:
        throw new java.lang.IllegalArgumentException("Failed to parse elements to add");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x026f, code lost:
        if (r1 >= r2) goto L_0x0283;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0271, code lost:
        r4.zzq(r4.zzc(), r9.zze(r1));
        r9.zzq(r1, null);
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0283, code lost:
        r0 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0284, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0285, code lost:
        r9 = r22;
        r3 = r23;
        r0 = r24;
        com.google.android.gms.internal.measurement.zzh.zzj("sort", 1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0294, code lost:
        if (r22.zzc() >= 2) goto L_0x0297;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0297, code lost:
        r1 = r22.zzm();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x029f, code lost:
        if (r24.isEmpty() != false) goto L_0x02bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02a1, code lost:
        r0 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x02ae, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzai) == false) goto L_0x02b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x02b0, code lost:
        r0 = (com.google.android.gms.internal.measurement.zzai) r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x02ba, code lost:
        throw new java.lang.IllegalArgumentException("Comparator should be a method");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02bb, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02bc, code lost:
        java.util.Collections.sort(r1, new com.google.android.gms.internal.measurement.zzba(r0, r3));
        r22.zzn();
        r0 = r1.iterator();
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x02d0, code lost:
        if (r0.hasNext() == false) goto L_0x02df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x02d2, code lost:
        r9.zzq(r2, (com.google.android.gms.internal.measurement.zzap) r0.next());
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x02df, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x02e0, code lost:
        r9 = r22;
        r3 = r23;
        r0 = r24;
        com.google.android.gms.internal.measurement.zzh.zzh("some", 1, r0);
        r0 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x02f7, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzai) == false) goto L_0x0350;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x02fd, code lost:
        if (r22.zzc() != 0) goto L_0x0302;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x02ff, code lost:
        r0 = com.google.android.gms.internal.measurement.zzap.zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0302, code lost:
        r0 = (com.google.android.gms.internal.measurement.zzai) r0;
        r1 = r22.zzk();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x030c, code lost:
        if (r1.hasNext() == false) goto L_0x034d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x030e, code lost:
        r2 = ((java.lang.Integer) r1.next()).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x031c, code lost:
        if (r9.zzs(r2) == false) goto L_0x0308;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0348, code lost:
        if (r0.zza(r3, java.util.Arrays.asList(new com.google.android.gms.internal.measurement.zzap[]{r9.zze(r2), new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r2)), r9})).zzg().booleanValue() == false) goto L_0x0308;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x034a, code lost:
        r0 = com.google.android.gms.internal.measurement.zzap.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x034d, code lost:
        r0 = com.google.android.gms.internal.measurement.zzap.zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x034f, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0357, code lost:
        throw new java.lang.IllegalArgumentException(r21);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0358, code lost:
        r9 = r22;
        r3 = r23;
        r0 = r24;
        com.google.android.gms.internal.measurement.zzh.zzj("slice", 2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0366, code lost:
        if (r24.isEmpty() == false) goto L_0x036d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0368, code lost:
        r0 = r22.zzd();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x036d, code lost:
        r4 = (double) r22.zzc();
        r6 = com.google.android.gms.internal.measurement.zzh.zza(r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x038b, code lost:
        if (r6 >= 0.0d) goto L_0x0393;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x038d, code lost:
        r6 = java.lang.Math.max(r6 + r4, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0393, code lost:
        r6 = java.lang.Math.min(r6, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x039c, code lost:
        if (r24.size() != 2) goto L_0x03c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x039e, code lost:
        r10 = com.google.android.gms.internal.measurement.zzh.zza(r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(1)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x03b7, code lost:
        if (r10 >= 0.0d) goto L_0x03bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x03b9, code lost:
        r4 = java.lang.Math.max(r4 + r10, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x03bf, code lost:
        r4 = java.lang.Math.min(r4, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x03c3, code lost:
        r0 = new com.google.android.gms.internal.measurement.zzae();
        r1 = (int) r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x03cc, code lost:
        if (((double) r1) >= r4) goto L_0x03dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x03ce, code lost:
        r0.zzq(r0.zzc(), r9.zze(r1));
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x03dc, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x03dd, code lost:
        r9 = r22;
        com.google.android.gms.internal.measurement.zzh.zzh("shift", 0, r24);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x03e9, code lost:
        if (r22.zzc() != 0) goto L_0x03ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x03eb, code lost:
        r0 = com.google.android.gms.internal.measurement.zzap.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x03ee, code lost:
        r0 = r9.zze(0);
        r9.zzp(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x03f5, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x03f6, code lost:
        r9 = r22;
        com.google.android.gms.internal.measurement.zzh.zzh("reverse", 0, r24);
        r0 = r22.zzc();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0402, code lost:
        if (r0 == 0) goto L_0x042d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0404, code lost:
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0407, code lost:
        if (r2 >= (r0 / 2)) goto L_0x042d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x040d, code lost:
        if (r9.zzs(r2) == false) goto L_0x042a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x040f, code lost:
        r1 = r9.zze(r2);
        r9.zzq(r2, null);
        r3 = (r0 - 1) - r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x041e, code lost:
        if (r9.zzs(r3) == false) goto L_0x0427;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0420, code lost:
        r9.zzq(r2, r9.zze(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0427, code lost:
        r9.zzq(r3, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x042a, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x042d, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x0439, code lost:
        return zzc(r22, r23, r24, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0445, code lost:
        return zzc(r22, r23, r24, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0446, code lost:
        r9 = r22;
        r3 = r23;
        r0 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0450, code lost:
        if (r24.isEmpty() != false) goto L_0x046e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0452, code lost:
        r0 = r24.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x045a, code lost:
        if (r0.hasNext() == false) goto L_0x046e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x045c, code lost:
        r9.zzq(r22.zzc(), r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.next()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x047c, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r22.zzc()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x047d, code lost:
        r9 = r22;
        com.google.android.gms.internal.measurement.zzh.zzh("pop", 0, r24);
        r0 = r22.zzc();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x0489, code lost:
        if (r0 != 0) goto L_0x048e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x048b, code lost:
        r0 = com.google.android.gms.internal.measurement.zzap.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x048e, code lost:
        r0 = r0 - 1;
        r1 = r9.zze(r0);
        r9.zzp(r0);
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x0498, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x0499, code lost:
        r1 = r21;
        r9 = r22;
        r3 = r23;
        r0 = r24;
        com.google.android.gms.internal.measurement.zzh.zzh("map", 1, r0);
        r0 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x04b2, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzao) == false) goto L_0x04c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x04b8, code lost:
        if (r22.zzc() != 0) goto L_0x04c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x04ba, code lost:
        r0 = new com.google.android.gms.internal.measurement.zzae();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x04c0, code lost:
        r0 = zzb(r9, r3, (com.google.android.gms.internal.measurement.zzao) r0, null, null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x04c7, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x04cd, code lost:
        throw new java.lang.IllegalArgumentException(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x04ce, code lost:
        r9 = r22;
        r3 = r23;
        r0 = r24;
        com.google.android.gms.internal.measurement.zzh.zzj("lastIndexOf", 2, r0);
        r4 = com.google.android.gms.internal.measurement.zzap.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x04de, code lost:
        if (r24.isEmpty() != false) goto L_0x04eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x04e0, code lost:
        r4 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x04eb, code lost:
        r5 = (double) (r22.zzc() - 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x04f7, code lost:
        if (r24.size() <= 1) goto L_0x052f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x04f9, code lost:
        r0 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x050f, code lost:
        if (java.lang.Double.isNaN(r0.zzh().doubleValue()) == false) goto L_0x0519;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x0511, code lost:
        r5 = (double) (r22.zzc() - 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x0519, code lost:
        r5 = com.google.android.gms.internal.measurement.zzh.zza(r0.zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x0527, code lost:
        if (r5 >= 0.0d) goto L_0x052f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x0529, code lost:
        r5 = r5 + ((double) r22.zzc());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x0531, code lost:
        if (r5 >= 0.0d) goto L_0x053d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x0533, code lost:
        r0 = new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(-1.0d));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x053d, code lost:
        r0 = (int) java.lang.Math.min((double) r22.zzc(), r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x0547, code lost:
        if (r0 < 0) goto L_0x0568;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x054d, code lost:
        if (r9.zzs(r0) == false) goto L_0x0565;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x0557, code lost:
        if (com.google.android.gms.internal.measurement.zzh.zzl(r9.zze(r0), r4) == false) goto L_0x0565;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x0559, code lost:
        r0 = new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x0565, code lost:
        r0 = r0 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0568, code lost:
        r0 = new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(-1.0d));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x0571, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x0572, code lost:
        r9 = r22;
        r3 = r23;
        r0 = r24;
        com.google.android.gms.internal.measurement.zzh.zzj("join", 1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x0580, code lost:
        if (r22.zzc() != 0) goto L_0x0585;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x0582, code lost:
        r0 = com.google.android.gms.internal.measurement.zzap.zzm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x0589, code lost:
        if (r24.isEmpty() != false) goto L_0x05a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x058b, code lost:
        r0 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x0598, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzan) != false) goto L_0x05a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x059c, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzau) == false) goto L_0x059f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x059f, code lost:
        r0 = r0.zzi();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x05a4, code lost:
        r0 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x05a7, code lost:
        r0 = ",";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x05a9, code lost:
        r0 = new com.google.android.gms.internal.measurement.zzat(r9.zzj(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x05b3, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x05b4, code lost:
        r9 = r22;
        r3 = r23;
        r0 = r24;
        com.google.android.gms.internal.measurement.zzh.zzj("indexOf", 2, r0);
        r4 = com.google.android.gms.internal.measurement.zzap.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:0x05c4, code lost:
        if (r24.isEmpty() != false) goto L_0x05d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x05c6, code lost:
        r4 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x05d6, code lost:
        if (r24.size() <= 1) goto L_0x060e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x05d8, code lost:
        r5 = com.google.android.gms.internal.measurement.zzh.zza(r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(1)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:0x05f5, code lost:
        if (r5 < ((double) r22.zzc())) goto L_0x0601;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x05f7, code lost:
        r0 = new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(-1.0d));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x0603, code lost:
        if (r5 >= 0.0d) goto L_0x060d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:266:0x0605, code lost:
        r1 = ((double) r22.zzc()) + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:267:0x060d, code lost:
        r1 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:268:0x060e, code lost:
        r0 = r22.zzk();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x0616, code lost:
        if (r0.hasNext() == false) goto L_0x063b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:271:0x0618, code lost:
        r3 = ((java.lang.Integer) r0.next()).intValue();
        r5 = (double) r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:272:0x0625, code lost:
        if (r5 < r1) goto L_0x0612;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:274:0x062f, code lost:
        if (com.google.android.gms.internal.measurement.zzh.zzl(r9.zze(r3), r4) == false) goto L_0x0612;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:275:0x0631, code lost:
        r0 = new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:276:0x063b, code lost:
        r0 = new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(-1.0d));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x0644, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:278:0x0645, code lost:
        r1 = r21;
        r9 = r22;
        r0 = r24;
        r3 = r23;
        com.google.android.gms.internal.measurement.zzh.zzh("forEach", 1, r0);
        r0 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:279:0x065f, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzao) == false) goto L_0x0673;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:281:0x0665, code lost:
        if (r22.zzb() != 0) goto L_0x066a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:282:0x0667, code lost:
        r0 = com.google.android.gms.internal.measurement.zzap.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x066a, code lost:
        zzb(r9, r3, (com.google.android.gms.internal.measurement.zzao) r0, null, null);
        r0 = com.google.android.gms.internal.measurement.zzap.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:284:0x0672, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x0678, code lost:
        throw new java.lang.IllegalArgumentException(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x0679, code lost:
        r1 = r21;
        r9 = r22;
        r3 = r23;
        r0 = r24;
        com.google.android.gms.internal.measurement.zzh.zzh(r20, 1, r0);
        r0 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:288:0x0694, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzao) == false) goto L_0x06d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:290:0x069a, code lost:
        if (r22.zzb() != 0) goto L_0x06a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:0x069c, code lost:
        r0 = new com.google.android.gms.internal.measurement.zzae();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:292:0x06a2, code lost:
        r1 = r22.zzd();
        r0 = zzb(r9, r3, (com.google.android.gms.internal.measurement.zzao) r0, null, java.lang.Boolean.TRUE);
        r2 = new com.google.android.gms.internal.measurement.zzae();
        r0 = r0.zzk();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:294:0x06bc, code lost:
        if (r0.hasNext() == false) goto L_0x06d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:295:0x06be, code lost:
        r2.zzq(r2.zzc(), ((com.google.android.gms.internal.measurement.zzae) r1).zze(((java.lang.Integer) r0.next()).intValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:296:0x06d7, code lost:
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x06d8, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x06de, code lost:
        throw new java.lang.IllegalArgumentException(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x002f, code lost:
        r4 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:300:0x06df, code lost:
        r1 = r21;
        r2 = r22;
        r3 = r23;
        r0 = r24;
        com.google.android.gms.internal.measurement.zzh.zzh("every", 1, r0);
        r0 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:301:0x06f8, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzao) == false) goto L_0x071d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x06fe, code lost:
        if (r22.zzc() != 0) goto L_0x0703;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:304:0x0700, code lost:
        r0 = com.google.android.gms.internal.measurement.zzap.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:306:0x0715, code lost:
        if (zzb(r2, r3, (com.google.android.gms.internal.measurement.zzao) r0, java.lang.Boolean.FALSE, java.lang.Boolean.TRUE).zzc() == r22.zzc()) goto L_0x071a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:307:0x0717, code lost:
        r0 = com.google.android.gms.internal.measurement.zzap.zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x071a, code lost:
        r0 = com.google.android.gms.internal.measurement.zzap.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:309:0x071c, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:311:0x0722, code lost:
        throw new java.lang.IllegalArgumentException(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:312:0x0723, code lost:
        r2 = r22;
        r3 = r23;
        r0 = r24;
        r1 = r22.zzd();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:313:0x0731, code lost:
        if (r24.isEmpty() != false) goto L_0x0785;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:314:0x0733, code lost:
        r0 = r24.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:316:0x073b, code lost:
        if (r0.hasNext() == false) goto L_0x0785;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:317:0x073d, code lost:
        r2 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.next());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:318:0x0749, code lost:
        if ((r2 instanceof com.google.android.gms.internal.measurement.zzag) != false) goto L_0x077d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:319:0x074b, code lost:
        r4 = (com.google.android.gms.internal.measurement.zzae) r1;
        r5 = r4.zzc();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:320:0x0754, code lost:
        if ((r2 instanceof com.google.android.gms.internal.measurement.zzae) == false) goto L_0x0779;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:321:0x0756, code lost:
        r2 = (com.google.android.gms.internal.measurement.zzae) r2;
        r6 = r2.zzk();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:323:0x0760, code lost:
        if (r6.hasNext() == false) goto L_0x0737;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:324:0x0762, code lost:
        r7 = (java.lang.Integer) r6.next();
        r4.zzq(r7.intValue() + r5, r2.zze(r7.intValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:325:0x0779, code lost:
        r4.zzq(r5, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:327:0x0784, code lost:
        throw new java.lang.IllegalStateException("Failed evaluation of arguments");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:328:0x0785, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:343:0x03dc, code lost:
        r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00d7, code lost:
        r4 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00fb, code lost:
        r0 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00fc, code lost:
        r20 = "filter";
        r21 = "Callback should be a method";
        r1 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0106, code lost:
        switch(r0) {
            case 0: goto L_0x0723;
            case 1: goto L_0x06df;
            case 2: goto L_0x0679;
            case 3: goto L_0x0645;
            case 4: goto L_0x05b4;
            case 5: goto L_0x0572;
            case 6: goto L_0x04ce;
            case 7: goto L_0x0499;
            case 8: goto L_0x047d;
            case 9: goto L_0x0446;
            case 10: goto L_0x043a;
            case 11: goto L_0x042e;
            case 12: goto L_0x03f6;
            case 13: goto L_0x03dd;
            case 14: goto L_0x0358;
            case 15: goto L_0x02e0;
            case 16: goto L_0x0285;
            case 17: goto L_0x01b8;
            case 18: goto L_0x01a3;
            case 19: goto L_0x0111;
            default: goto L_0x0109;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0110, code lost:
        throw new java.lang.IllegalArgumentException("Command not supported");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0115, code lost:
        if (r24.isEmpty() != false) goto L_0x0192;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0117, code lost:
        r0 = new com.google.android.gms.internal.measurement.zzae();
        r1 = r24.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0124, code lost:
        if (r1.hasNext() == false) goto L_0x0146;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0126, code lost:
        r2 = r23.zzb((com.google.android.gms.internal.measurement.zzap) r1.next());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0134, code lost:
        if ((r2 instanceof com.google.android.gms.internal.measurement.zzag) != false) goto L_0x013e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0136, code lost:
        r0.zzq(r0.zzc(), r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0145, code lost:
        throw new java.lang.IllegalStateException("Argument evaluation failed");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0146, code lost:
        r1 = r0.zzc();
        r2 = r22.zzk();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0152, code lost:
        if (r2.hasNext() == false) goto L_0x016d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0154, code lost:
        r3 = (java.lang.Integer) r2.next();
        r0.zzq(r3.intValue() + r1, r22.zze(r3.intValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x016d, code lost:
        r9 = r22;
        r22.zzn();
        r1 = r0.zzk();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x017a, code lost:
        if (r1.hasNext() == false) goto L_0x0194;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x017c, code lost:
        r2 = (java.lang.Integer) r1.next();
        r9.zzq(r2.intValue(), r0.zze(r2.intValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0192, code lost:
        r9 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01a2, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r22.zzc()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01a3, code lost:
        com.google.android.gms.internal.measurement.zzh.zzh(r4, 0, r24);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01b7, code lost:
        return new com.google.android.gms.internal.measurement.zzat(r22.zzj(","));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01b8, code lost:
        r9 = r22;
        r3 = r23;
        r0 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01c3, code lost:
        if (r24.isEmpty() == false) goto L_0x01cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01c5, code lost:
        r0 = new com.google.android.gms.internal.measurement.zzae();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01cc, code lost:
        r1 = (int) com.google.android.gms.internal.measurement.zzh.zza(r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01e3, code lost:
        if (r1 >= 0) goto L_0x01ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01e5, code lost:
        r1 = java.lang.Math.max(0, r22.zzc() + r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01f3, code lost:
        if (r1 <= r22.zzc()) goto L_0x01f9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.measurement.zzap zza(java.lang.String r21, com.google.android.gms.internal.measurement.zzae r22, com.google.android.gms.internal.measurement.zzg r23, java.util.List r24) {
        /*
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r24
            int r4 = r21.hashCode()
            java.lang.String r5 = "indexOf"
            java.lang.String r6 = "reverse"
            java.lang.String r7 = "slice"
            java.lang.String r8 = "shift"
            java.lang.String r9 = "every"
            java.lang.String r10 = "sort"
            java.lang.String r11 = "some"
            java.lang.String r12 = "join"
            java.lang.String r13 = "pop"
            java.lang.String r14 = "map"
            java.lang.String r15 = "lastIndexOf"
            java.lang.String r3 = "forEach"
            java.lang.String r1 = "filter"
            java.lang.String r2 = "toString"
            r16 = -1
            r17 = r2
            switch(r4) {
                case -1776922004: goto L_0x00f0;
                case -1354795244: goto L_0x00e4;
                case -1274492040: goto L_0x00da;
                case -934873754: goto L_0x00cd;
                case -895859076: goto L_0x00c2;
                case -678635926: goto L_0x00ba;
                case -467511597: goto L_0x00b2;
                case -277637751: goto L_0x00a7;
                case 107868: goto L_0x009f;
                case 111185: goto L_0x0096;
                case 3267882: goto L_0x008e;
                case 3452698: goto L_0x0083;
                case 3536116: goto L_0x007a;
                case 3536286: goto L_0x0071;
                case 96891675: goto L_0x0066;
                case 109407362: goto L_0x005c;
                case 109526418: goto L_0x0052;
                case 965561430: goto L_0x0046;
                case 1099846370: goto L_0x003c;
                case 1943291465: goto L_0x0033;
                default: goto L_0x002f;
            }
        L_0x002f:
            r4 = r17
            goto L_0x00fb
        L_0x0033:
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x002f
            r0 = 4
            goto L_0x00d7
        L_0x003c:
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x002f
            r0 = 12
            goto L_0x00d7
        L_0x0046:
            java.lang.String r4 = "reduceRight"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x002f
            r0 = 11
            goto L_0x00d7
        L_0x0052:
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x002f
            r0 = 14
            goto L_0x00d7
        L_0x005c:
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x002f
            r0 = 13
            goto L_0x00d7
        L_0x0066:
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x002f
            r4 = r17
            r0 = 1
            goto L_0x00fc
        L_0x0071:
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x002f
            r0 = 16
            goto L_0x00d7
        L_0x007a:
            boolean r0 = r0.equals(r11)
            if (r0 == 0) goto L_0x002f
            r0 = 15
            goto L_0x00d7
        L_0x0083:
            java.lang.String r4 = "push"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x002f
            r0 = 9
            goto L_0x00d7
        L_0x008e:
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x002f
            r0 = 5
            goto L_0x00d7
        L_0x0096:
            boolean r0 = r0.equals(r13)
            if (r0 == 0) goto L_0x002f
            r0 = 8
            goto L_0x00d7
        L_0x009f:
            boolean r0 = r0.equals(r14)
            if (r0 == 0) goto L_0x002f
            r0 = 7
            goto L_0x00d7
        L_0x00a7:
            java.lang.String r4 = "unshift"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x002f
            r0 = 19
            goto L_0x00d7
        L_0x00b2:
            boolean r0 = r0.equals(r15)
            if (r0 == 0) goto L_0x002f
            r0 = 6
            goto L_0x00d7
        L_0x00ba:
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x002f
            r0 = 3
            goto L_0x00d7
        L_0x00c2:
            java.lang.String r4 = "splice"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x002f
            r0 = 17
            goto L_0x00d7
        L_0x00cd:
            java.lang.String r4 = "reduce"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x002f
            r0 = 10
        L_0x00d7:
            r4 = r17
            goto L_0x00fc
        L_0x00da:
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x002f
            r4 = r17
            r0 = 2
            goto L_0x00fc
        L_0x00e4:
            java.lang.String r4 = "concat"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x002f
            r4 = r17
            r0 = 0
            goto L_0x00fc
        L_0x00f0:
            r4 = r17
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x00fb
            r0 = 18
            goto L_0x00fc
        L_0x00fb:
            r0 = -1
        L_0x00fc:
            r18 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            java.lang.String r2 = "Callback should be a method"
            r20 = r1
            r21 = r2
            r1 = 0
            switch(r0) {
                case 0: goto L_0x0723;
                case 1: goto L_0x06df;
                case 2: goto L_0x0679;
                case 3: goto L_0x0645;
                case 4: goto L_0x05b4;
                case 5: goto L_0x0572;
                case 6: goto L_0x04ce;
                case 7: goto L_0x0499;
                case 8: goto L_0x047d;
                case 9: goto L_0x0446;
                case 10: goto L_0x043a;
                case 11: goto L_0x042e;
                case 12: goto L_0x03f6;
                case 13: goto L_0x03dd;
                case 14: goto L_0x0358;
                case 15: goto L_0x02e0;
                case 16: goto L_0x0285;
                case 17: goto L_0x01b8;
                case 18: goto L_0x01a3;
                case 19: goto L_0x0111;
                default: goto L_0x0109;
            }
        L_0x0109:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Command not supported"
            r0.<init>(r1)
            throw r0
        L_0x0111:
            boolean r0 = r24.isEmpty()
            if (r0 != 0) goto L_0x0192
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>()
            java.util.Iterator r1 = r24.iterator()
        L_0x0120:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0146
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.measurement.zzap r2 = (com.google.android.gms.internal.measurement.zzap) r2
            r3 = r23
            com.google.android.gms.internal.measurement.zzap r2 = r3.zzb(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.measurement.zzag
            if (r4 != 0) goto L_0x013e
            int r4 = r0.zzc()
            r0.zzq(r4, r2)
            goto L_0x0120
        L_0x013e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Argument evaluation failed"
            r0.<init>(r1)
            throw r0
        L_0x0146:
            int r1 = r0.zzc()
            java.util.Iterator r2 = r22.zzk()
        L_0x014e:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x016d
            java.lang.Object r3 = r2.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r4 = r3.intValue()
            int r4 = r4 + r1
            int r3 = r3.intValue()
            r9 = r22
            com.google.android.gms.internal.measurement.zzap r3 = r9.zze(r3)
            r0.zzq(r4, r3)
            goto L_0x014e
        L_0x016d:
            r9 = r22
            r22.zzn()
            java.util.Iterator r1 = r0.zzk()
        L_0x0176:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0194
            java.lang.Object r2 = r1.next()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r3 = r2.intValue()
            int r2 = r2.intValue()
            com.google.android.gms.internal.measurement.zzap r2 = r0.zze(r2)
            r9.zzq(r3, r2)
            goto L_0x0176
        L_0x0192:
            r9 = r22
        L_0x0194:
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            int r1 = r22.zzc()
            double r1 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r0.<init>(r1)
            return r0
        L_0x01a3:
            r9 = r22
            r0 = r24
            r1 = r4
            r2 = 0
            com.google.android.gms.internal.measurement.zzh.zzh(r1, r2, r0)
            com.google.android.gms.internal.measurement.zzat r0 = new com.google.android.gms.internal.measurement.zzat
            java.lang.String r1 = ","
            java.lang.String r1 = r9.zzj(r1)
            r0.<init>(r1)
            return r0
        L_0x01b8:
            r9 = r22
            r3 = r23
            r0 = r24
            r2 = 0
            boolean r1 = r24.isEmpty()
            if (r1 == 0) goto L_0x01cc
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>()
            goto L_0x0284
        L_0x01cc:
            java.lang.Object r1 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r3.zzb(r1)
            java.lang.Double r1 = r1.zzh()
            double r4 = r1.doubleValue()
            double r4 = com.google.android.gms.internal.measurement.zzh.zza(r4)
            int r1 = (int) r4
            if (r1 >= 0) goto L_0x01ef
            int r4 = r22.zzc()
            int r4 = r4 + r1
            int r1 = java.lang.Math.max(r2, r4)
            goto L_0x01f9
        L_0x01ef:
            int r2 = r22.zzc()
            if (r1 <= r2) goto L_0x01f9
            int r1 = r22.zzc()
        L_0x01f9:
            int r2 = r22.zzc()
            com.google.android.gms.internal.measurement.zzae r4 = new com.google.android.gms.internal.measurement.zzae
            r4.<init>()
            int r5 = r24.size()
            r6 = 1
            if (r5 <= r6) goto L_0x026f
            java.lang.Object r5 = r0.get(r6)
            com.google.android.gms.internal.measurement.zzap r5 = (com.google.android.gms.internal.measurement.zzap) r5
            com.google.android.gms.internal.measurement.zzap r5 = r3.zzb(r5)
            java.lang.Double r5 = r5.zzh()
            double r5 = r5.doubleValue()
            double r5 = com.google.android.gms.internal.measurement.zzh.zza(r5)
            int r5 = (int) r5
            r6 = 0
            int r5 = java.lang.Math.max(r6, r5)
            if (r5 <= 0) goto L_0x0241
            r6 = r1
        L_0x0228:
            int r7 = r1 + r5
            int r7 = java.lang.Math.min(r2, r7)
            if (r6 >= r7) goto L_0x0241
            com.google.android.gms.internal.measurement.zzap r7 = r9.zze(r1)
            int r8 = r4.zzc()
            r4.zzq(r8, r7)
            r9.zzp(r1)
            int r6 = r6 + 1
            goto L_0x0228
        L_0x0241:
            int r2 = r24.size()
            r5 = 2
            if (r2 <= r5) goto L_0x0283
            r2 = 2
        L_0x0249:
            int r5 = r24.size()
            if (r2 >= r5) goto L_0x0283
            java.lang.Object r5 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzap r5 = (com.google.android.gms.internal.measurement.zzap) r5
            com.google.android.gms.internal.measurement.zzap r5 = r3.zzb(r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.measurement.zzag
            if (r6 != 0) goto L_0x0267
            int r6 = r1 + r2
            int r6 = r6 + -2
            r9.zzo(r6, r5)
            int r2 = r2 + 1
            goto L_0x0249
        L_0x0267:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Failed to parse elements to add"
            r0.<init>(r1)
            throw r0
        L_0x026f:
            if (r1 >= r2) goto L_0x0283
            com.google.android.gms.internal.measurement.zzap r0 = r9.zze(r1)
            int r3 = r4.zzc()
            r4.zzq(r3, r0)
            r0 = 0
            r9.zzq(r1, r0)
            int r1 = r1 + 1
            goto L_0x026f
        L_0x0283:
            r0 = r4
        L_0x0284:
            return r0
        L_0x0285:
            r9 = r22
            r3 = r23
            r0 = r24
            r1 = 1
            com.google.android.gms.internal.measurement.zzh.zzj(r10, r1, r0)
            int r1 = r22.zzc()
            r2 = 2
            if (r1 >= r2) goto L_0x0297
            goto L_0x02df
        L_0x0297:
            java.util.List r1 = r22.zzm()
            boolean r2 = r24.isEmpty()
            if (r2 != 0) goto L_0x02bb
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r3.zzb(r0)
            boolean r2 = r0 instanceof com.google.android.gms.internal.measurement.zzai
            if (r2 == 0) goto L_0x02b3
            com.google.android.gms.internal.measurement.zzai r0 = (com.google.android.gms.internal.measurement.zzai) r0
            goto L_0x02bc
        L_0x02b3:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Comparator should be a method"
            r0.<init>(r1)
            throw r0
        L_0x02bb:
            r0 = 0
        L_0x02bc:
            com.google.android.gms.internal.measurement.zzba r2 = new com.google.android.gms.internal.measurement.zzba
            r2.<init>(r0, r3)
            java.util.Collections.sort(r1, r2)
            r22.zzn()
            java.util.Iterator r0 = r1.iterator()
            r2 = 0
        L_0x02cc:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x02df
            int r1 = r2 + 1
            java.lang.Object r3 = r0.next()
            com.google.android.gms.internal.measurement.zzap r3 = (com.google.android.gms.internal.measurement.zzap) r3
            r9.zzq(r2, r3)
            r2 = r1
            goto L_0x02cc
        L_0x02df:
            return r9
        L_0x02e0:
            r9 = r22
            r3 = r23
            r0 = r24
            r1 = 1
            com.google.android.gms.internal.measurement.zzh.zzh(r11, r1, r0)
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r3.zzb(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzai
            if (r1 == 0) goto L_0x0350
            int r1 = r22.zzc()
            if (r1 != 0) goto L_0x0302
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzl
            goto L_0x034f
        L_0x0302:
            com.google.android.gms.internal.measurement.zzai r0 = (com.google.android.gms.internal.measurement.zzai) r0
            java.util.Iterator r1 = r22.zzk()
        L_0x0308:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x034d
            java.lang.Object r2 = r1.next()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            boolean r4 = r9.zzs(r2)
            if (r4 == 0) goto L_0x0308
            r4 = 3
            com.google.android.gms.internal.measurement.zzap[] r4 = new com.google.android.gms.internal.measurement.zzap[r4]
            com.google.android.gms.internal.measurement.zzap r5 = r9.zze(r2)
            r6 = 0
            r4[r6] = r5
            com.google.android.gms.internal.measurement.zzah r5 = new com.google.android.gms.internal.measurement.zzah
            double r6 = (double) r2
            java.lang.Double r2 = java.lang.Double.valueOf(r6)
            r5.<init>(r2)
            r2 = 1
            r4[r2] = r5
            r2 = 2
            r4[r2] = r9
            java.util.List r2 = java.util.Arrays.asList(r4)
            com.google.android.gms.internal.measurement.zzap r2 = r0.zza(r3, r2)
            java.lang.Boolean r2 = r2.zzg()
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0308
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzk
            goto L_0x034f
        L_0x034d:
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzl
        L_0x034f:
            return r0
        L_0x0350:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r21
            r0.<init>(r1)
            throw r0
        L_0x0358:
            r9 = r22
            r3 = r23
            r0 = r24
            r4 = 2
            com.google.android.gms.internal.measurement.zzh.zzj(r7, r4, r0)
            boolean r4 = r24.isEmpty()
            if (r4 == 0) goto L_0x036d
            com.google.android.gms.internal.measurement.zzap r0 = r22.zzd()
            goto L_0x03dc
        L_0x036d:
            int r4 = r22.zzc()
            double r4 = (double) r4
            r6 = 0
            java.lang.Object r6 = r0.get(r6)
            com.google.android.gms.internal.measurement.zzap r6 = (com.google.android.gms.internal.measurement.zzap) r6
            com.google.android.gms.internal.measurement.zzap r6 = r3.zzb(r6)
            java.lang.Double r6 = r6.zzh()
            double r6 = r6.doubleValue()
            double r6 = com.google.android.gms.internal.measurement.zzh.zza(r6)
            int r8 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r8 >= 0) goto L_0x0393
            double r6 = r6 + r4
            double r6 = java.lang.Math.max(r6, r1)
            goto L_0x0397
        L_0x0393:
            double r6 = java.lang.Math.min(r6, r4)
        L_0x0397:
            int r8 = r24.size()
            r10 = 2
            if (r8 != r10) goto L_0x03c3
            r8 = 1
            java.lang.Object r0 = r0.get(r8)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r3.zzb(r0)
            java.lang.Double r0 = r0.zzh()
            double r10 = r0.doubleValue()
            double r10 = com.google.android.gms.internal.measurement.zzh.zza(r10)
            int r0 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x03bf
            double r4 = r4 + r10
            double r4 = java.lang.Math.max(r4, r1)
            goto L_0x03c3
        L_0x03bf:
            double r4 = java.lang.Math.min(r4, r10)
        L_0x03c3:
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>()
            int r1 = (int) r6
        L_0x03c9:
            double r2 = (double) r1
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x03dc
            com.google.android.gms.internal.measurement.zzap r2 = r9.zze(r1)
            int r3 = r0.zzc()
            r0.zzq(r3, r2)
            int r1 = r1 + 1
            goto L_0x03c9
        L_0x03dc:
            return r0
        L_0x03dd:
            r9 = r22
            r0 = r24
            r1 = 0
            com.google.android.gms.internal.measurement.zzh.zzh(r8, r1, r0)
            int r0 = r22.zzc()
            if (r0 != 0) goto L_0x03ee
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzf
            goto L_0x03f5
        L_0x03ee:
            com.google.android.gms.internal.measurement.zzap r0 = r9.zze(r1)
            r9.zzp(r1)
        L_0x03f5:
            return r0
        L_0x03f6:
            r9 = r22
            r0 = r24
            r1 = 0
            com.google.android.gms.internal.measurement.zzh.zzh(r6, r1, r0)
            int r0 = r22.zzc()
            if (r0 == 0) goto L_0x042d
            r2 = 0
        L_0x0405:
            int r1 = r0 / 2
            if (r2 >= r1) goto L_0x042d
            boolean r1 = r9.zzs(r2)
            if (r1 == 0) goto L_0x042a
            com.google.android.gms.internal.measurement.zzap r1 = r9.zze(r2)
            r3 = 0
            r9.zzq(r2, r3)
            int r3 = r0 + -1
            int r3 = r3 - r2
            boolean r4 = r9.zzs(r3)
            if (r4 == 0) goto L_0x0427
            com.google.android.gms.internal.measurement.zzap r4 = r9.zze(r3)
            r9.zzq(r2, r4)
        L_0x0427:
            r9.zzq(r3, r1)
        L_0x042a:
            int r2 = r2 + 1
            goto L_0x0405
        L_0x042d:
            return r9
        L_0x042e:
            r9 = r22
            r3 = r23
            r0 = r24
            r1 = 0
            com.google.android.gms.internal.measurement.zzap r0 = zzc(r9, r3, r0, r1)
            return r0
        L_0x043a:
            r9 = r22
            r3 = r23
            r0 = r24
            r1 = 1
            com.google.android.gms.internal.measurement.zzap r0 = zzc(r9, r3, r0, r1)
            return r0
        L_0x0446:
            r9 = r22
            r3 = r23
            r0 = r24
            boolean r1 = r24.isEmpty()
            if (r1 != 0) goto L_0x046e
            java.util.Iterator r0 = r24.iterator()
        L_0x0456:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x046e
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r3.zzb(r1)
            int r2 = r22.zzc()
            r9.zzq(r2, r1)
            goto L_0x0456
        L_0x046e:
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            int r1 = r22.zzc()
            double r1 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r0.<init>(r1)
            return r0
        L_0x047d:
            r9 = r22
            r0 = r24
            r2 = 0
            com.google.android.gms.internal.measurement.zzh.zzh(r13, r2, r0)
            int r0 = r22.zzc()
            if (r0 != 0) goto L_0x048e
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzf
            goto L_0x0498
        L_0x048e:
            int r0 = r0 + -1
            com.google.android.gms.internal.measurement.zzap r1 = r9.zze(r0)
            r9.zzp(r0)
            r0 = r1
        L_0x0498:
            return r0
        L_0x0499:
            r1 = r21
            r9 = r22
            r3 = r23
            r0 = r24
            r2 = 0
            r4 = 1
            com.google.android.gms.internal.measurement.zzh.zzh(r14, r4, r0)
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r3.zzb(r0)
            boolean r2 = r0 instanceof com.google.android.gms.internal.measurement.zzao
            if (r2 == 0) goto L_0x04c8
            int r1 = r22.zzc()
            if (r1 != 0) goto L_0x04c0
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>()
            goto L_0x04c7
        L_0x04c0:
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            r1 = 0
            com.google.android.gms.internal.measurement.zzae r0 = zzb(r9, r3, r0, r1, r1)
        L_0x04c7:
            return r0
        L_0x04c8:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r1)
            throw r0
        L_0x04ce:
            r9 = r22
            r3 = r23
            r0 = r24
            r4 = 2
            com.google.android.gms.internal.measurement.zzh.zzj(r15, r4, r0)
            com.google.android.gms.internal.measurement.zzap r4 = com.google.android.gms.internal.measurement.zzap.zzf
            boolean r5 = r24.isEmpty()
            if (r5 != 0) goto L_0x04eb
            r5 = 0
            java.lang.Object r4 = r0.get(r5)
            com.google.android.gms.internal.measurement.zzap r4 = (com.google.android.gms.internal.measurement.zzap) r4
            com.google.android.gms.internal.measurement.zzap r4 = r3.zzb(r4)
        L_0x04eb:
            int r5 = r22.zzc()
            int r5 = r5 + -1
            double r5 = (double) r5
            int r7 = r24.size()
            r8 = 1
            if (r7 <= r8) goto L_0x052f
            java.lang.Object r0 = r0.get(r8)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r3.zzb(r0)
            java.lang.Double r3 = r0.zzh()
            double r5 = r3.doubleValue()
            boolean r3 = java.lang.Double.isNaN(r5)
            if (r3 == 0) goto L_0x0519
            int r0 = r22.zzc()
            int r0 = r0 + -1
            double r5 = (double) r0
            goto L_0x0525
        L_0x0519:
            java.lang.Double r0 = r0.zzh()
            double r5 = r0.doubleValue()
            double r5 = com.google.android.gms.internal.measurement.zzh.zza(r5)
        L_0x0525:
            int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x052f
            int r0 = r22.zzc()
            double r7 = (double) r0
            double r5 = r5 + r7
        L_0x052f:
            int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x053d
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r1 = java.lang.Double.valueOf(r18)
            r0.<init>(r1)
            goto L_0x0571
        L_0x053d:
            int r0 = r22.zzc()
            double r0 = (double) r0
            double r0 = java.lang.Math.min(r0, r5)
            int r0 = (int) r0
        L_0x0547:
            if (r0 < 0) goto L_0x0568
            boolean r1 = r9.zzs(r0)
            if (r1 == 0) goto L_0x0565
            com.google.android.gms.internal.measurement.zzap r1 = r9.zze(r0)
            boolean r1 = com.google.android.gms.internal.measurement.zzh.zzl(r1, r4)
            if (r1 == 0) goto L_0x0565
            com.google.android.gms.internal.measurement.zzah r1 = new com.google.android.gms.internal.measurement.zzah
            double r2 = (double) r0
            java.lang.Double r0 = java.lang.Double.valueOf(r2)
            r1.<init>(r0)
            r0 = r1
            goto L_0x0571
        L_0x0565:
            int r0 = r0 + -1
            goto L_0x0547
        L_0x0568:
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r1 = java.lang.Double.valueOf(r18)
            r0.<init>(r1)
        L_0x0571:
            return r0
        L_0x0572:
            r9 = r22
            r3 = r23
            r0 = r24
            r1 = 1
            com.google.android.gms.internal.measurement.zzh.zzj(r12, r1, r0)
            int r1 = r22.zzc()
            if (r1 != 0) goto L_0x0585
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzm
            goto L_0x05b3
        L_0x0585:
            boolean r1 = r24.isEmpty()
            if (r1 != 0) goto L_0x05a7
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r3.zzb(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzan
            if (r1 != 0) goto L_0x05a4
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzau
            if (r1 == 0) goto L_0x059f
            goto L_0x05a4
        L_0x059f:
            java.lang.String r0 = r0.zzi()
            goto L_0x05a9
        L_0x05a4:
            java.lang.String r0 = ""
            goto L_0x05a9
        L_0x05a7:
            java.lang.String r0 = ","
        L_0x05a9:
            com.google.android.gms.internal.measurement.zzat r1 = new com.google.android.gms.internal.measurement.zzat
            java.lang.String r0 = r9.zzj(r0)
            r1.<init>(r0)
            r0 = r1
        L_0x05b3:
            return r0
        L_0x05b4:
            r9 = r22
            r3 = r23
            r0 = r24
            r4 = 2
            com.google.android.gms.internal.measurement.zzh.zzj(r5, r4, r0)
            com.google.android.gms.internal.measurement.zzap r4 = com.google.android.gms.internal.measurement.zzap.zzf
            boolean r5 = r24.isEmpty()
            if (r5 != 0) goto L_0x05d1
            r5 = 0
            java.lang.Object r4 = r0.get(r5)
            com.google.android.gms.internal.measurement.zzap r4 = (com.google.android.gms.internal.measurement.zzap) r4
            com.google.android.gms.internal.measurement.zzap r4 = r3.zzb(r4)
        L_0x05d1:
            int r5 = r24.size()
            r6 = 1
            if (r5 <= r6) goto L_0x060e
            java.lang.Object r0 = r0.get(r6)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r3.zzb(r0)
            java.lang.Double r0 = r0.zzh()
            double r5 = r0.doubleValue()
            double r5 = com.google.android.gms.internal.measurement.zzh.zza(r5)
            int r0 = r22.zzc()
            double r7 = (double) r0
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 < 0) goto L_0x0601
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r1 = java.lang.Double.valueOf(r18)
            r0.<init>(r1)
            goto L_0x0644
        L_0x0601:
            int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x060d
            int r0 = r22.zzc()
            double r0 = (double) r0
            double r1 = r0 + r5
            goto L_0x060e
        L_0x060d:
            r1 = r5
        L_0x060e:
            java.util.Iterator r0 = r22.zzk()
        L_0x0612:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x063b
            java.lang.Object r3 = r0.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            double r5 = (double) r3
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 < 0) goto L_0x0612
            com.google.android.gms.internal.measurement.zzap r3 = r9.zze(r3)
            boolean r3 = com.google.android.gms.internal.measurement.zzh.zzl(r3, r4)
            if (r3 == 0) goto L_0x0612
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r1 = java.lang.Double.valueOf(r5)
            r0.<init>(r1)
            goto L_0x0644
        L_0x063b:
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r1 = java.lang.Double.valueOf(r18)
            r0.<init>(r1)
        L_0x0644:
            return r0
        L_0x0645:
            r1 = r21
            r9 = r22
            r0 = r24
            r2 = r3
            r4 = 1
            r3 = r23
            com.google.android.gms.internal.measurement.zzh.zzh(r2, r4, r0)
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r3.zzb(r0)
            boolean r2 = r0 instanceof com.google.android.gms.internal.measurement.zzao
            if (r2 == 0) goto L_0x0673
            int r1 = r22.zzb()
            if (r1 != 0) goto L_0x066a
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzf
            goto L_0x0672
        L_0x066a:
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            r1 = 0
            zzb(r9, r3, r0, r1, r1)
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzf
        L_0x0672:
            return r0
        L_0x0673:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r1)
            throw r0
        L_0x0679:
            r1 = r21
            r9 = r22
            r3 = r23
            r0 = r24
            r2 = r20
            r4 = 1
            com.google.android.gms.internal.measurement.zzh.zzh(r2, r4, r0)
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r3.zzb(r0)
            boolean r2 = r0 instanceof com.google.android.gms.internal.measurement.zzao
            if (r2 == 0) goto L_0x06d9
            int r1 = r22.zzb()
            if (r1 != 0) goto L_0x06a2
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>()
            goto L_0x06d8
        L_0x06a2:
            com.google.android.gms.internal.measurement.zzap r1 = r22.zzd()
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            r4 = 0
            com.google.android.gms.internal.measurement.zzae r0 = zzb(r9, r3, r0, r4, r2)
            com.google.android.gms.internal.measurement.zzae r2 = new com.google.android.gms.internal.measurement.zzae
            r2.<init>()
            java.util.Iterator r0 = r0.zzk()
        L_0x06b8:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x06d7
            java.lang.Object r3 = r0.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r4 = r1
            com.google.android.gms.internal.measurement.zzae r4 = (com.google.android.gms.internal.measurement.zzae) r4
            com.google.android.gms.internal.measurement.zzap r3 = r4.zze(r3)
            int r4 = r2.zzc()
            r2.zzq(r4, r3)
            goto L_0x06b8
        L_0x06d7:
            r0 = r2
        L_0x06d8:
            return r0
        L_0x06d9:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r1)
            throw r0
        L_0x06df:
            r1 = r21
            r2 = r22
            r3 = r23
            r0 = r24
            r4 = 1
            com.google.android.gms.internal.measurement.zzh.zzh(r9, r4, r0)
            r4 = 0
            java.lang.Object r0 = r0.get(r4)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r3.zzb(r0)
            boolean r4 = r0 instanceof com.google.android.gms.internal.measurement.zzao
            if (r4 == 0) goto L_0x071d
            int r1 = r22.zzc()
            if (r1 != 0) goto L_0x0703
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzk
            goto L_0x071c
        L_0x0703:
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            com.google.android.gms.internal.measurement.zzae r0 = zzb(r2, r3, r0, r1, r4)
            int r0 = r0.zzc()
            int r1 = r22.zzc()
            if (r0 == r1) goto L_0x071a
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzl
            goto L_0x071c
        L_0x071a:
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzk
        L_0x071c:
            return r0
        L_0x071d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r1)
            throw r0
        L_0x0723:
            r2 = r22
            r3 = r23
            r0 = r24
            com.google.android.gms.internal.measurement.zzap r1 = r22.zzd()
            boolean r2 = r24.isEmpty()
            if (r2 != 0) goto L_0x0785
            java.util.Iterator r0 = r24.iterator()
        L_0x0737:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0785
            java.lang.Object r2 = r0.next()
            com.google.android.gms.internal.measurement.zzap r2 = (com.google.android.gms.internal.measurement.zzap) r2
            com.google.android.gms.internal.measurement.zzap r2 = r3.zzb(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.measurement.zzag
            if (r4 != 0) goto L_0x077d
            r4 = r1
            com.google.android.gms.internal.measurement.zzae r4 = (com.google.android.gms.internal.measurement.zzae) r4
            int r5 = r4.zzc()
            boolean r6 = r2 instanceof com.google.android.gms.internal.measurement.zzae
            if (r6 == 0) goto L_0x0779
            com.google.android.gms.internal.measurement.zzae r2 = (com.google.android.gms.internal.measurement.zzae) r2
            java.util.Iterator r6 = r2.zzk()
        L_0x075c:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0737
            java.lang.Object r7 = r6.next()
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r8 = r7.intValue()
            int r7 = r7.intValue()
            com.google.android.gms.internal.measurement.zzap r7 = r2.zze(r7)
            int r8 = r8 + r5
            r4.zzq(r8, r7)
            goto L_0x075c
        L_0x0779:
            r4.zzq(r5, r2)
            goto L_0x0737
        L_0x077d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Failed evaluation of arguments"
            r0.<init>(r1)
            throw r0
        L_0x0785:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbb.zza(java.lang.String, com.google.android.gms.internal.measurement.zzae, com.google.android.gms.internal.measurement.zzg, java.util.List):com.google.android.gms.internal.measurement.zzap");
    }

    public static zzae zzb(zzae zzae, zzg zzg, zzai zzai, Boolean bool, Boolean bool2) {
        zzae zzae2 = new zzae();
        Iterator zzk = zzae.zzk();
        while (zzk.hasNext()) {
            int intValue = ((Integer) zzk.next()).intValue();
            if (zzae.zzs(intValue)) {
                zzap zza = zzai.zza(zzg, Arrays.asList(new zzap[]{zzae.zze(intValue), new zzah(Double.valueOf((double) intValue)), zzae}));
                if (zza.zzg().equals(bool)) {
                    return zzae2;
                }
                if (bool2 == null || zza.zzg().equals(bool2)) {
                    zzae2.zzq(intValue, zza);
                }
            }
        }
        return zzae2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0097 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.measurement.zzap zzc(com.google.android.gms.internal.measurement.zzae r9, com.google.android.gms.internal.measurement.zzg r10, java.util.List r11, boolean r12) {
        /*
            java.lang.String r0 = "reduce"
            r1 = 1
            com.google.android.gms.internal.measurement.zzh.zzi(r0, r1, r11)
            r2 = 2
            com.google.android.gms.internal.measurement.zzh.zzj(r0, r2, r11)
            r0 = 0
            java.lang.Object r3 = r11.get(r0)
            com.google.android.gms.internal.measurement.zzap r3 = (com.google.android.gms.internal.measurement.zzap) r3
            com.google.android.gms.internal.measurement.zzap r3 = r10.zzb(r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.zzai
            if (r4 == 0) goto L_0x00a0
            int r4 = r11.size()
            if (r4 != r2) goto L_0x0036
            java.lang.Object r11 = r11.get(r1)
            com.google.android.gms.internal.measurement.zzap r11 = (com.google.android.gms.internal.measurement.zzap) r11
            com.google.android.gms.internal.measurement.zzap r11 = r10.zzb(r11)
            boolean r4 = r11 instanceof com.google.android.gms.internal.measurement.zzag
            if (r4 != 0) goto L_0x002e
            goto L_0x003d
        L_0x002e:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Failed to parse initial value"
            r9.<init>(r10)
            throw r9
        L_0x0036:
            int r11 = r9.zzc()
            if (r11 == 0) goto L_0x0098
            r11 = 0
        L_0x003d:
            com.google.android.gms.internal.measurement.zzai r3 = (com.google.android.gms.internal.measurement.zzai) r3
            int r4 = r9.zzc()
            if (r12 == 0) goto L_0x0047
            r5 = 0
            goto L_0x0049
        L_0x0047:
            int r5 = r4 + -1
        L_0x0049:
            r6 = -1
            if (r12 == 0) goto L_0x004e
            int r4 = r4 + r6
            goto L_0x004f
        L_0x004e:
            r4 = 0
        L_0x004f:
            if (r1 == r12) goto L_0x0052
            goto L_0x0053
        L_0x0052:
            r6 = 1
        L_0x0053:
            if (r11 != 0) goto L_0x005a
            com.google.android.gms.internal.measurement.zzap r11 = r9.zze(r5)
            goto L_0x0095
        L_0x005a:
            int r12 = r4 - r5
            int r12 = r12 * r6
            if (r12 < 0) goto L_0x0097
            boolean r12 = r9.zzs(r5)
            if (r12 == 0) goto L_0x0095
            r12 = 4
            com.google.android.gms.internal.measurement.zzap[] r12 = new com.google.android.gms.internal.measurement.zzap[r12]
            r12[r0] = r11
            com.google.android.gms.internal.measurement.zzap r11 = r9.zze(r5)
            r12[r1] = r11
            com.google.android.gms.internal.measurement.zzah r11 = new com.google.android.gms.internal.measurement.zzah
            double r7 = (double) r5
            java.lang.Double r7 = java.lang.Double.valueOf(r7)
            r11.<init>(r7)
            r12[r2] = r11
            r11 = 3
            r12[r11] = r9
            java.util.List r11 = java.util.Arrays.asList(r12)
            com.google.android.gms.internal.measurement.zzap r11 = r3.zza(r10, r11)
            boolean r12 = r11 instanceof com.google.android.gms.internal.measurement.zzag
            if (r12 != 0) goto L_0x008d
            goto L_0x0095
        L_0x008d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Reduce operation failed"
            r9.<init>(r10)
            throw r9
        L_0x0095:
            int r5 = r5 + r6
            goto L_0x005a
        L_0x0097:
            return r11
        L_0x0098:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Empty array with no initial value error"
            r9.<init>(r10)
            throw r9
        L_0x00a0:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Callback should be a method"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbb.zzc(com.google.android.gms.internal.measurement.zzae, com.google.android.gms.internal.measurement.zzg, java.util.List, boolean):com.google.android.gms.internal.measurement.zzap");
    }
}
