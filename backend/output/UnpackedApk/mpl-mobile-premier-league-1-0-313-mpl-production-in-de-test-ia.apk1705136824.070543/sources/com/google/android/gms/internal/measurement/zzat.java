package com.google.android.gms.internal.measurement;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzat implements Iterable, zzap {
    public final String zza;

    public zzat(String str) {
        if (str != null) {
            this.zza = str;
            return;
        }
        throw new IllegalArgumentException("StringValue cannot be null.");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzat)) {
            return false;
        }
        return this.zza.equals(((zzat) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Iterator iterator() {
        return new zzas(this);
    }

    public final String toString() {
        return GeneratedOutlineSupport.outline52("\"", this.zza, "\"");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0170, code lost:
        com.google.android.gms.internal.measurement.zzh.zzh("toUpperCase", 0, r21);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0185, code lost:
        com.google.android.gms.internal.measurement.zzh.zzh("toUpperCase", 0, r21);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x019c, code lost:
        r0 = r18;
        com.google.android.gms.internal.measurement.zzh.zzh("toString", 0, r21);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01a7, code lost:
        com.google.android.gms.internal.measurement.zzh.zzh("toLowerCase", 0, r21);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01be, code lost:
        com.google.android.gms.internal.measurement.zzh.zzh("toLocaleLowerCase", 0, r21);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01d4, code lost:
        com.google.android.gms.internal.measurement.zzh.zzh(r5, 0, r21);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01e9, code lost:
        r1 = r21;
        com.google.android.gms.internal.measurement.zzh.zzj("substring", 2, r1);
        r2 = r18.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01f8, code lost:
        if (r21.isEmpty() != false) goto L_0x0214;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01fa, code lost:
        r5 = r20;
        r3 = (int) com.google.android.gms.internal.measurement.zzh.zza(r5.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0214, code lost:
        r5 = r20;
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x021c, code lost:
        if (r21.size() <= 1) goto L_0x0236;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x021e, code lost:
        r1 = (int) com.google.android.gms.internal.measurement.zzh.zza(r5.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(1)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0236, code lost:
        r1 = r2.length();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x023a, code lost:
        r3 = java.lang.Math.min(java.lang.Math.max(r3, 0), r2.length());
        r1 = java.lang.Math.min(java.lang.Math.max(r1, 0), r2.length());
        r4 = new com.google.android.gms.internal.measurement.zzat(r2.substring(java.lang.Math.min(r3, r1), java.lang.Math.max(r3, r1)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0267, code lost:
        r0 = r18;
        r5 = r20;
        r1 = r21;
        com.google.android.gms.internal.measurement.zzh.zzj("split", 2, r1);
        r2 = r0.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0277, code lost:
        if (r2.length() != 0) goto L_0x028a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x028a, code lost:
        r4 = new java.util.ArrayList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0294, code lost:
        if (r21.isEmpty() == false) goto L_0x029b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0296, code lost:
        r4.add(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x029b, code lost:
        r3 = r5.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzi();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02ae, code lost:
        if (r21.size() <= 1) goto L_0x02c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02b0, code lost:
        r5 = com.google.android.gms.internal.measurement.zzh.zzd(r5.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(1)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02c7, code lost:
        r5 = 2147483647L;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02ce, code lost:
        if (r5 != 0) goto L_0x02d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x02d7, code lost:
        r1 = r2.split(java.util.regex.Pattern.quote(r3), ((int) r5) + 1);
        r2 = r1.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x02e7, code lost:
        if (r3.isEmpty() == false) goto L_0x02fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x02e9, code lost:
        if (r2 <= 0) goto L_0x02fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02eb, code lost:
        r3 = r1[0].isEmpty();
        r7 = r2 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02fa, code lost:
        if (r1[r7].isEmpty() != false) goto L_0x02ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x02fd, code lost:
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x02fe, code lost:
        r7 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0302, code lost:
        if (((long) r2) <= r5) goto L_0x0306;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0304, code lost:
        r7 = r7 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0306, code lost:
        if (r3 >= r7) goto L_0x0315;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0308, code lost:
        r4.add(new com.google.android.gms.internal.measurement.zzat(r1[r3]));
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x031c, code lost:
        r5 = r20;
        r1 = r21;
        com.google.android.gms.internal.measurement.zzh.zzj("slice", 2, r1);
        r2 = r18.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x032c, code lost:
        if (r21.isEmpty() != false) goto L_0x0342;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x032e, code lost:
        r3 = r5.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzh().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0342, code lost:
        r3 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0344, code lost:
        r3 = com.google.android.gms.internal.measurement.zzh.zza(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x034c, code lost:
        if (r3 >= 0.0d) goto L_0x0359;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x034e, code lost:
        r3 = java.lang.Math.max(((double) r2.length()) + r3, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0359, code lost:
        r3 = java.lang.Math.min(r3, (double) r2.length());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0362, code lost:
        r3 = (int) r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0368, code lost:
        if (r21.size() <= 1) goto L_0x037d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x036a, code lost:
        r4 = r5.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(1)).zzh().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x037d, code lost:
        r4 = (double) r2.length();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0382, code lost:
        r4 = com.google.android.gms.internal.measurement.zzh.zza(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x038a, code lost:
        if (r4 >= 0.0d) goto L_0x0397;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x038c, code lost:
        r4 = java.lang.Math.max(((double) r2.length()) + r4, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0397, code lost:
        r4 = java.lang.Math.min(r4, (double) r2.length());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x03a0, code lost:
        r4 = new com.google.android.gms.internal.measurement.zzat(r2.substring(r3, java.lang.Math.max(0, ((int) r4) - r3) + r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x03b3, code lost:
        r0 = r18;
        r5 = r20;
        r1 = r21;
        com.google.android.gms.internal.measurement.zzh.zzj("search", 1, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x03c2, code lost:
        if (r21.isEmpty() != false) goto L_0x03d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x03c4, code lost:
        r16 = r5.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzi();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03d2, code lost:
        r1 = java.util.regex.Pattern.compile(r16).matcher(r0.zza);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x03e0, code lost:
        if (r1.find() == false) goto L_0x03f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x03ff, code lost:
        r0 = r18;
        r5 = r20;
        r1 = r21;
        com.google.android.gms.internal.measurement.zzh.zzj("replace", 2, r1);
        r2 = com.google.android.gms.internal.measurement.zzap.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x040f, code lost:
        if (r21.isEmpty() != false) goto L_0x0431;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0411, code lost:
        r16 = r5.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzi();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0425, code lost:
        if (r21.size() <= 1) goto L_0x0431;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0427, code lost:
        r2 = r5.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0431, code lost:
        r1 = r16;
        r3 = r0.zza;
        r4 = r3.indexOf(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0439, code lost:
        if (r4 < 0) goto L_0x0606;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x043d, code lost:
        if ((r2 instanceof com.google.android.gms.internal.measurement.zzai) == false) goto L_0x0464;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x043f, code lost:
        r2 = ((com.google.android.gms.internal.measurement.zzai) r2).zza(r5, java.util.Arrays.asList(new com.google.android.gms.internal.measurement.zzap[]{new com.google.android.gms.internal.measurement.zzat(r1), new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r4)), r0}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0464, code lost:
        r5 = new com.google.android.gms.internal.measurement.zzat(com.android.tools.r8.GeneratedOutlineSupport.outline52(r3.substring(0, r4), r2.zzi(), r3.substring(r1.length() + r4)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x0482, code lost:
        r5 = r20;
        r1 = r21;
        com.google.android.gms.internal.measurement.zzh.zzj("match", 1, r1);
        r2 = r18.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0492, code lost:
        if (r21.size() > 0) goto L_0x0497;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0494, code lost:
        r1 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0497, code lost:
        r1 = r5.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzi();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x04a6, code lost:
        r1 = java.util.regex.Pattern.compile(r1).matcher(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x04b2, code lost:
        if (r1.find() == false) goto L_0x04ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x04d2, code lost:
        r5 = r20;
        r1 = r21;
        com.google.android.gms.internal.measurement.zzh.zzj("lastIndexOf", 2, r1);
        r4 = r18.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x04e3, code lost:
        if (r21.size() > 0) goto L_0x04e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x04e6, code lost:
        r16 = r5.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzi();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x04f4, code lost:
        r3 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x04fa, code lost:
        if (r21.size() >= 2) goto L_0x04ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x04fc, code lost:
        r1 = Double.NaN;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x04ff, code lost:
        r1 = r5.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(1)).zzh().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0516, code lost:
        if (java.lang.Double.isNaN(r1) == false) goto L_0x051b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0518, code lost:
        r1 = Double.POSITIVE_INFINITY;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x051b, code lost:
        r1 = com.google.android.gms.internal.measurement.zzh.zza(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x051f, code lost:
        r5 = new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r4.lastIndexOf(r3, (int) r1)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0530, code lost:
        r5 = r20;
        r1 = r21;
        r3 = 0.0d;
        com.google.android.gms.internal.measurement.zzh.zzj("indexOf", 2, r1);
        r6 = r18.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0542, code lost:
        if (r21.size() > 0) goto L_0x0545;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0545, code lost:
        r16 = r5.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzi();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x0554, code lost:
        r7 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x055a, code lost:
        if (r21.size() >= 2) goto L_0x055d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x055d, code lost:
        r3 = r5.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(1)).zzh().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x0570, code lost:
        r3 = new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r6.indexOf(r7, (int) com.google.android.gms.internal.measurement.zzh.zza(r3))));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x0585, code lost:
        r1 = r21;
        com.google.android.gms.internal.measurement.zzh.zzh(r6, 1, r1);
        r2 = r18.zza;
        r1 = r20.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x05a6, code lost:
        if ("length".equals(r1.zzi()) == false) goto L_0x05ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x05ac, code lost:
        r3 = r1.zzh().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x05ba, code lost:
        if (r3 != java.lang.Math.floor(r3)) goto L_0x05c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x05bc, code lost:
        r1 = (int) r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x05bd, code lost:
        if (r1 < 0) goto L_0x05c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x05c3, code lost:
        if (r1 >= r2.length()) goto L_0x05c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x05cd, code lost:
        r0 = r18;
        r5 = r20;
        r1 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x05d7, code lost:
        if (r21.isEmpty() != false) goto L_0x0606;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x05d9, code lost:
        r2 = new java.lang.StringBuilder(r0.zza);
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x05e5, code lost:
        if (r3 >= r21.size()) goto L_0x05fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x05e7, code lost:
        r2.append(r5.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(r3)).zzi());
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x0608, code lost:
        r0 = r18;
        r5 = r20;
        r1 = r21;
        com.google.android.gms.internal.measurement.zzh.zzj(r4, 1, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x0616, code lost:
        if (r21.isEmpty() != false) goto L_0x0631;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x0618, code lost:
        r1 = (int) com.google.android.gms.internal.measurement.zzh.zza(r5.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x0631, code lost:
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x0632, code lost:
        r2 = r0.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x0634, code lost:
        if (r1 < 0) goto L_0x064c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x063a, code lost:
        if (r1 < r2.length()) goto L_0x063d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x063d, code lost:
        r3 = new com.google.android.gms.internal.measurement.zzat(java.lang.String.valueOf(r2.charAt(r1)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:?, code lost:
        return new com.google.android.gms.internal.measurement.zzat(r18.zza.trim());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:?, code lost:
        return new com.google.android.gms.internal.measurement.zzat(r18.zza.toUpperCase(java.util.Locale.ENGLISH));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:?, code lost:
        return new com.google.android.gms.internal.measurement.zzat(r18.zza.toLowerCase(java.util.Locale.ENGLISH));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:?, code lost:
        return new com.google.android.gms.internal.measurement.zzat(r18.zza.toLowerCase());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:?, code lost:
        return new com.google.android.gms.internal.measurement.zzat(r18.zza.toUpperCase());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:?, code lost:
        return new com.google.android.gms.internal.measurement.zzae(java.util.Arrays.asList(new com.google.android.gms.internal.measurement.zzap[]{r0}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:?, code lost:
        return new com.google.android.gms.internal.measurement.zzae();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:?, code lost:
        return new com.google.android.gms.internal.measurement.zzae(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r1.start()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(-1.0d));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:?, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:?, code lost:
        return new com.google.android.gms.internal.measurement.zzae(java.util.Arrays.asList(new com.google.android.gms.internal.measurement.zzap[]{new com.google.android.gms.internal.measurement.zzat(r1.group())}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzg;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:?, code lost:
        return new com.google.android.gms.internal.measurement.zzat(r2.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:?, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b6, code lost:
        r4 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x012c, code lost:
        r4 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x014e, code lost:
        r6 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0151, code lost:
        r6 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0160, code lost:
        r1 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0161, code lost:
        r16 = "undefined";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0163, code lost:
        switch(r1) {
            case 0: goto L_0x0608;
            case 1: goto L_0x05cd;
            case 2: goto L_0x0585;
            case 3: goto L_0x0530;
            case 4: goto L_0x04d2;
            case 5: goto L_0x0482;
            case 6: goto L_0x03ff;
            case 7: goto L_0x03b3;
            case 8: goto L_0x031c;
            case 9: goto L_0x0267;
            case 10: goto L_0x01e9;
            case 11: goto L_0x01d4;
            case 12: goto L_0x01be;
            case 13: goto L_0x01a7;
            case 14: goto L_0x019c;
            case 15: goto L_0x0185;
            case 16: goto L_0x0170;
            default: goto L_0x0166;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0166, code lost:
        r0 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x016f, code lost:
        throw new java.lang.IllegalArgumentException("Command not supported");
     */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0154  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzap zzbQ(java.lang.String r19, com.google.android.gms.internal.measurement.zzg r20, java.util.List r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            java.lang.String r4 = "charAt"
            boolean r5 = r4.equals(r1)
            java.lang.String r6 = "concat"
            java.lang.String r7 = "indexOf"
            java.lang.String r8 = "replace"
            java.lang.String r9 = "substring"
            java.lang.String r10 = "split"
            java.lang.String r11 = "slice"
            java.lang.String r12 = "match"
            java.lang.String r13 = "lastIndexOf"
            java.lang.String r14 = "toLocaleUpperCase"
            java.lang.String r15 = "search"
            java.lang.String r2 = "toLowerCase"
            java.lang.String r0 = "toLocaleLowerCase"
            java.lang.String r3 = "toString"
            r16 = r4
            java.lang.String r4 = "hasOwnProperty"
            r17 = r14
            java.lang.String r14 = "toUpperCase"
            if (r5 != 0) goto L_0x00ab
            boolean r5 = r6.equals(r1)
            if (r5 != 0) goto L_0x00ab
            boolean r5 = r4.equals(r1)
            if (r5 != 0) goto L_0x00ab
            boolean r5 = r7.equals(r1)
            if (r5 != 0) goto L_0x00ab
            boolean r5 = r13.equals(r1)
            if (r5 != 0) goto L_0x00ab
            boolean r5 = r12.equals(r1)
            if (r5 != 0) goto L_0x00ab
            boolean r5 = r8.equals(r1)
            if (r5 != 0) goto L_0x00ab
            boolean r5 = r15.equals(r1)
            if (r5 != 0) goto L_0x00ab
            boolean r5 = r11.equals(r1)
            if (r5 != 0) goto L_0x00ab
            boolean r5 = r10.equals(r1)
            if (r5 != 0) goto L_0x00ab
            boolean r5 = r9.equals(r1)
            if (r5 != 0) goto L_0x00ab
            boolean r5 = r2.equals(r1)
            if (r5 != 0) goto L_0x00ab
            boolean r5 = r0.equals(r1)
            if (r5 != 0) goto L_0x00ab
            boolean r5 = r3.equals(r1)
            if (r5 != 0) goto L_0x00ab
            boolean r5 = r14.equals(r1)
            if (r5 != 0) goto L_0x00ab
            r5 = r17
            boolean r17 = r5.equals(r1)
            if (r17 != 0) goto L_0x00ad
            r17 = r4
            java.lang.String r4 = "trim"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x0099
            goto L_0x00af
        L_0x0099:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r1
            java.lang.String r1 = "%s is not a String function"
            java.lang.String r1 = java.lang.String.format(r1, r2)
            r0.<init>(r1)
            throw r0
        L_0x00ab:
            r5 = r17
        L_0x00ad:
            r17 = r4
        L_0x00af:
            int r4 = r19.hashCode()
            switch(r4) {
                case -1789698943: goto L_0x0154;
                case -1776922004: goto L_0x0144;
                case -1464939364: goto L_0x0139;
                case -1361633751: goto L_0x012f;
                case -1354795244: goto L_0x0125;
                case -1137582698: goto L_0x011c;
                case -906336856: goto L_0x0114;
                case -726908483: goto L_0x010b;
                case -467511597: goto L_0x0103;
                case -399551817: goto L_0x00fa;
                case 3568674: goto L_0x00ef;
                case 103668165: goto L_0x00e7;
                case 109526418: goto L_0x00de;
                case 109648666: goto L_0x00d5;
                case 530542161: goto L_0x00cc;
                case 1094496948: goto L_0x00c3;
                case 1943291465: goto L_0x00ba;
                default: goto L_0x00b6;
            }
        L_0x00b6:
            r4 = r16
            goto L_0x0151
        L_0x00ba:
            boolean r1 = r1.equals(r7)
            if (r1 == 0) goto L_0x00b6
            r1 = 3
            goto L_0x012c
        L_0x00c3:
            boolean r1 = r1.equals(r8)
            if (r1 == 0) goto L_0x00b6
            r1 = 6
            goto L_0x012c
        L_0x00cc:
            boolean r1 = r1.equals(r9)
            if (r1 == 0) goto L_0x00b6
            r1 = 10
            goto L_0x012c
        L_0x00d5:
            boolean r1 = r1.equals(r10)
            if (r1 == 0) goto L_0x00b6
            r1 = 9
            goto L_0x012c
        L_0x00de:
            boolean r1 = r1.equals(r11)
            if (r1 == 0) goto L_0x00b6
            r1 = 8
            goto L_0x012c
        L_0x00e7:
            boolean r1 = r1.equals(r12)
            if (r1 == 0) goto L_0x00b6
            r1 = 5
            goto L_0x012c
        L_0x00ef:
            java.lang.String r4 = "trim"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00b6
            r1 = 16
            goto L_0x012c
        L_0x00fa:
            boolean r1 = r1.equals(r14)
            if (r1 == 0) goto L_0x00b6
            r1 = 15
            goto L_0x012c
        L_0x0103:
            boolean r1 = r1.equals(r13)
            if (r1 == 0) goto L_0x00b6
            r1 = 4
            goto L_0x012c
        L_0x010b:
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x00b6
            r1 = 11
            goto L_0x012c
        L_0x0114:
            boolean r1 = r1.equals(r15)
            if (r1 == 0) goto L_0x00b6
            r1 = 7
            goto L_0x012c
        L_0x011c:
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00b6
            r1 = 13
            goto L_0x012c
        L_0x0125:
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x00b6
            r1 = 1
        L_0x012c:
            r4 = r16
            goto L_0x014e
        L_0x012f:
            r4 = r16
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0151
            r1 = 0
            goto L_0x014e
        L_0x0139:
            r4 = r16
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0151
            r1 = 12
            goto L_0x014e
        L_0x0144:
            r4 = r16
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0151
            r1 = 14
        L_0x014e:
            r6 = r17
            goto L_0x0161
        L_0x0151:
            r6 = r17
            goto L_0x0160
        L_0x0154:
            r4 = r16
            r6 = r17
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x0160
            r1 = 2
            goto L_0x0161
        L_0x0160:
            r1 = -1
        L_0x0161:
            java.lang.String r16 = "undefined"
            switch(r1) {
                case 0: goto L_0x0608;
                case 1: goto L_0x05cd;
                case 2: goto L_0x0585;
                case 3: goto L_0x0530;
                case 4: goto L_0x04d2;
                case 5: goto L_0x0482;
                case 6: goto L_0x03ff;
                case 7: goto L_0x03b3;
                case 8: goto L_0x031c;
                case 9: goto L_0x0267;
                case 10: goto L_0x01e9;
                case 11: goto L_0x01d4;
                case 12: goto L_0x01be;
                case 13: goto L_0x01a7;
                case 14: goto L_0x019c;
                case 15: goto L_0x0185;
                case 16: goto L_0x0170;
                default: goto L_0x0166;
            }
        L_0x0166:
            r0 = r18
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Command not supported"
            r1.<init>(r2)
            throw r1
        L_0x0170:
            r0 = 0
            r1 = r21
            com.google.android.gms.internal.measurement.zzh.zzh(r14, r0, r1)
            r0 = r18
            java.lang.String r1 = r0.zza
            com.google.android.gms.internal.measurement.zzat r2 = new com.google.android.gms.internal.measurement.zzat
            java.lang.String r1 = r1.trim()
            r2.<init>(r1)
            goto L_0x064e
        L_0x0185:
            r0 = r18
            r1 = r21
            r2 = 0
            com.google.android.gms.internal.measurement.zzh.zzh(r14, r2, r1)
            java.lang.String r1 = r0.zza
            com.google.android.gms.internal.measurement.zzat r2 = new com.google.android.gms.internal.measurement.zzat
            java.util.Locale r3 = java.util.Locale.ENGLISH
            java.lang.String r1 = r1.toUpperCase(r3)
            r2.<init>(r1)
            goto L_0x064e
        L_0x019c:
            r0 = r18
            r1 = r21
            r2 = r3
            r3 = 0
            com.google.android.gms.internal.measurement.zzh.zzh(r2, r3, r1)
            goto L_0x0606
        L_0x01a7:
            r0 = r18
            r1 = r21
            r3 = 0
            com.google.android.gms.internal.measurement.zzh.zzh(r2, r3, r1)
            java.lang.String r1 = r0.zza
            com.google.android.gms.internal.measurement.zzat r2 = new com.google.android.gms.internal.measurement.zzat
            java.util.Locale r3 = java.util.Locale.ENGLISH
            java.lang.String r1 = r1.toLowerCase(r3)
            r2.<init>(r1)
            goto L_0x064e
        L_0x01be:
            r1 = r21
            r2 = r0
            r0 = r18
            r3 = 0
            com.google.android.gms.internal.measurement.zzh.zzh(r2, r3, r1)
            java.lang.String r1 = r0.zza
            com.google.android.gms.internal.measurement.zzat r2 = new com.google.android.gms.internal.measurement.zzat
            java.lang.String r1 = r1.toLowerCase()
            r2.<init>(r1)
            goto L_0x064e
        L_0x01d4:
            r0 = r18
            r1 = r21
            r2 = 0
            com.google.android.gms.internal.measurement.zzh.zzh(r5, r2, r1)
            java.lang.String r1 = r0.zza
            com.google.android.gms.internal.measurement.zzat r2 = new com.google.android.gms.internal.measurement.zzat
            java.lang.String r1 = r1.toUpperCase()
            r2.<init>(r1)
            goto L_0x064e
        L_0x01e9:
            r0 = r18
            r1 = r21
            r2 = 2
            r3 = 0
            com.google.android.gms.internal.measurement.zzh.zzj(r9, r2, r1)
            java.lang.String r2 = r0.zza
            boolean r4 = r21.isEmpty()
            if (r4 != 0) goto L_0x0214
            java.lang.Object r3 = r1.get(r3)
            com.google.android.gms.internal.measurement.zzap r3 = (com.google.android.gms.internal.measurement.zzap) r3
            r5 = r20
            com.google.android.gms.internal.measurement.zzap r3 = r5.zzb(r3)
            java.lang.Double r3 = r3.zzh()
            double r3 = r3.doubleValue()
            double r3 = com.google.android.gms.internal.measurement.zzh.zza(r3)
            int r3 = (int) r3
            goto L_0x0217
        L_0x0214:
            r5 = r20
            r3 = 0
        L_0x0217:
            int r4 = r21.size()
            r6 = 1
            if (r4 <= r6) goto L_0x0236
            java.lang.Object r1 = r1.get(r6)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r5.zzb(r1)
            java.lang.Double r1 = r1.zzh()
            double r4 = r1.doubleValue()
            double r4 = com.google.android.gms.internal.measurement.zzh.zza(r4)
            int r1 = (int) r4
            goto L_0x023a
        L_0x0236:
            int r1 = r2.length()
        L_0x023a:
            r4 = 0
            int r3 = java.lang.Math.max(r3, r4)
            int r5 = r2.length()
            int r3 = java.lang.Math.min(r3, r5)
            int r1 = java.lang.Math.max(r1, r4)
            int r4 = r2.length()
            int r1 = java.lang.Math.min(r1, r4)
            com.google.android.gms.internal.measurement.zzat r4 = new com.google.android.gms.internal.measurement.zzat
            int r5 = java.lang.Math.min(r3, r1)
            int r1 = java.lang.Math.max(r3, r1)
            java.lang.String r1 = r2.substring(r5, r1)
            r4.<init>(r1)
        L_0x0264:
            r2 = r4
            goto L_0x064e
        L_0x0267:
            r0 = r18
            r5 = r20
            r1 = r21
            r2 = 2
            com.google.android.gms.internal.measurement.zzh.zzj(r10, r2, r1)
            java.lang.String r2 = r0.zza
            int r3 = r2.length()
            if (r3 != 0) goto L_0x028a
            com.google.android.gms.internal.measurement.zzae r2 = new com.google.android.gms.internal.measurement.zzae
            r1 = 1
            com.google.android.gms.internal.measurement.zzap[] r1 = new com.google.android.gms.internal.measurement.zzap[r1]
            r3 = 0
            r1[r3] = r0
            java.util.List r1 = java.util.Arrays.asList(r1)
            r2.<init>(r1)
            goto L_0x064e
        L_0x028a:
            r3 = 0
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            boolean r6 = r21.isEmpty()
            if (r6 == 0) goto L_0x029b
            r4.add(r0)
            goto L_0x0315
        L_0x029b:
            java.lang.Object r3 = r1.get(r3)
            com.google.android.gms.internal.measurement.zzap r3 = (com.google.android.gms.internal.measurement.zzap) r3
            com.google.android.gms.internal.measurement.zzap r3 = r5.zzb(r3)
            java.lang.String r3 = r3.zzi()
            int r6 = r21.size()
            r7 = 1
            if (r6 <= r7) goto L_0x02c7
            java.lang.Object r1 = r1.get(r7)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r5.zzb(r1)
            java.lang.Double r1 = r1.zzh()
            double r5 = r1.doubleValue()
            long r5 = com.google.android.gms.internal.measurement.zzh.zzd(r5)
            goto L_0x02ca
        L_0x02c7:
            r5 = 2147483647(0x7fffffff, double:1.060997895E-314)
        L_0x02ca:
            r7 = 0
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 != 0) goto L_0x02d7
            com.google.android.gms.internal.measurement.zzae r2 = new com.google.android.gms.internal.measurement.zzae
            r2.<init>()
            goto L_0x064e
        L_0x02d7:
            java.lang.String r1 = java.util.regex.Pattern.quote(r3)
            int r7 = (int) r5
            int r7 = r7 + 1
            java.lang.String[] r1 = r2.split(r1, r7)
            int r2 = r1.length
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x02fd
            if (r2 <= 0) goto L_0x02fd
            r3 = 0
            r3 = r1[r3]
            boolean r3 = r3.isEmpty()
            int r7 = r2 + -1
            r8 = r1[r7]
            boolean r8 = r8.isEmpty()
            if (r8 != 0) goto L_0x02ff
            goto L_0x02fe
        L_0x02fd:
            r3 = 0
        L_0x02fe:
            r7 = r2
        L_0x02ff:
            long r8 = (long) r2
            int r2 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r2 <= 0) goto L_0x0306
            int r7 = r7 + -1
        L_0x0306:
            if (r3 >= r7) goto L_0x0315
            com.google.android.gms.internal.measurement.zzat r2 = new com.google.android.gms.internal.measurement.zzat
            r5 = r1[r3]
            r2.<init>(r5)
            r4.add(r2)
            int r3 = r3 + 1
            goto L_0x0306
        L_0x0315:
            com.google.android.gms.internal.measurement.zzae r2 = new com.google.android.gms.internal.measurement.zzae
            r2.<init>(r4)
            goto L_0x064e
        L_0x031c:
            r0 = r18
            r5 = r20
            r1 = r21
            r2 = 2
            com.google.android.gms.internal.measurement.zzh.zzj(r11, r2, r1)
            java.lang.String r2 = r0.zza
            boolean r3 = r21.isEmpty()
            if (r3 != 0) goto L_0x0342
            r3 = 0
            java.lang.Object r3 = r1.get(r3)
            com.google.android.gms.internal.measurement.zzap r3 = (com.google.android.gms.internal.measurement.zzap) r3
            com.google.android.gms.internal.measurement.zzap r3 = r5.zzb(r3)
            java.lang.Double r3 = r3.zzh()
            double r3 = r3.doubleValue()
            goto L_0x0344
        L_0x0342:
            r3 = 0
        L_0x0344:
            double r3 = com.google.android.gms.internal.measurement.zzh.zza(r3)
            r6 = 0
            int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x0359
            int r8 = r2.length()
            double r8 = (double) r8
            double r8 = r8 + r3
            double r3 = java.lang.Math.max(r8, r6)
            goto L_0x0362
        L_0x0359:
            int r6 = r2.length()
            double r6 = (double) r6
            double r3 = java.lang.Math.min(r3, r6)
        L_0x0362:
            int r3 = (int) r3
            int r4 = r21.size()
            r6 = 1
            if (r4 <= r6) goto L_0x037d
            java.lang.Object r1 = r1.get(r6)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r5.zzb(r1)
            java.lang.Double r1 = r1.zzh()
            double r4 = r1.doubleValue()
            goto L_0x0382
        L_0x037d:
            int r1 = r2.length()
            double r4 = (double) r1
        L_0x0382:
            double r4 = com.google.android.gms.internal.measurement.zzh.zza(r4)
            r6 = 0
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 >= 0) goto L_0x0397
            int r1 = r2.length()
            double r8 = (double) r1
            double r8 = r8 + r4
            double r4 = java.lang.Math.max(r8, r6)
            goto L_0x03a0
        L_0x0397:
            int r1 = r2.length()
            double r6 = (double) r1
            double r4 = java.lang.Math.min(r4, r6)
        L_0x03a0:
            int r1 = (int) r4
            int r1 = r1 - r3
            r4 = 0
            int r1 = java.lang.Math.max(r4, r1)
            com.google.android.gms.internal.measurement.zzat r4 = new com.google.android.gms.internal.measurement.zzat
            int r1 = r1 + r3
            java.lang.String r1 = r2.substring(r3, r1)
            r4.<init>(r1)
            goto L_0x0264
        L_0x03b3:
            r0 = r18
            r5 = r20
            r1 = r21
            r2 = 1
            r3 = 0
            com.google.android.gms.internal.measurement.zzh.zzj(r15, r2, r1)
            boolean r2 = r21.isEmpty()
            if (r2 != 0) goto L_0x03d2
            java.lang.Object r1 = r1.get(r3)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r5.zzb(r1)
            java.lang.String r16 = r1.zzi()
        L_0x03d2:
            java.lang.String r1 = r0.zza
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r16)
            java.util.regex.Matcher r1 = r2.matcher(r1)
            boolean r2 = r1.find()
            if (r2 == 0) goto L_0x03f2
            com.google.android.gms.internal.measurement.zzah r2 = new com.google.android.gms.internal.measurement.zzah
            int r1 = r1.start()
            double r3 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r3)
            r2.<init>(r1)
            goto L_0x064e
        L_0x03f2:
            com.google.android.gms.internal.measurement.zzah r2 = new com.google.android.gms.internal.measurement.zzah
            r3 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            java.lang.Double r1 = java.lang.Double.valueOf(r3)
            r2.<init>(r1)
            goto L_0x064e
        L_0x03ff:
            r0 = r18
            r5 = r20
            r1 = r21
            r2 = 2
            com.google.android.gms.internal.measurement.zzh.zzj(r8, r2, r1)
            com.google.android.gms.internal.measurement.zzap r2 = com.google.android.gms.internal.measurement.zzap.zzf
            boolean r3 = r21.isEmpty()
            if (r3 != 0) goto L_0x0431
            r3 = 0
            java.lang.Object r3 = r1.get(r3)
            com.google.android.gms.internal.measurement.zzap r3 = (com.google.android.gms.internal.measurement.zzap) r3
            com.google.android.gms.internal.measurement.zzap r3 = r5.zzb(r3)
            java.lang.String r16 = r3.zzi()
            int r3 = r21.size()
            r4 = 1
            if (r3 <= r4) goto L_0x0431
            java.lang.Object r1 = r1.get(r4)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r2 = r5.zzb(r1)
        L_0x0431:
            r1 = r16
            java.lang.String r3 = r0.zza
            int r4 = r3.indexOf(r1)
            if (r4 < 0) goto L_0x0606
            boolean r6 = r2 instanceof com.google.android.gms.internal.measurement.zzai
            if (r6 == 0) goto L_0x0464
            com.google.android.gms.internal.measurement.zzai r2 = (com.google.android.gms.internal.measurement.zzai) r2
            r6 = 3
            com.google.android.gms.internal.measurement.zzap[] r6 = new com.google.android.gms.internal.measurement.zzap[r6]
            com.google.android.gms.internal.measurement.zzat r7 = new com.google.android.gms.internal.measurement.zzat
            r7.<init>(r1)
            r8 = 0
            r6[r8] = r7
            com.google.android.gms.internal.measurement.zzah r7 = new com.google.android.gms.internal.measurement.zzah
            double r8 = (double) r4
            java.lang.Double r8 = java.lang.Double.valueOf(r8)
            r7.<init>(r8)
            r8 = 1
            r6[r8] = r7
            r7 = 2
            r6[r7] = r0
            java.util.List r6 = java.util.Arrays.asList(r6)
            com.google.android.gms.internal.measurement.zzap r2 = r2.zza(r5, r6)
        L_0x0464:
            com.google.android.gms.internal.measurement.zzat r5 = new com.google.android.gms.internal.measurement.zzat
            r6 = 0
            java.lang.String r6 = r3.substring(r6, r4)
            java.lang.String r2 = r2.zzi()
            int r1 = r1.length()
            int r1 = r1 + r4
            java.lang.String r1 = r3.substring(r1)
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline52(r6, r2, r1)
            r5.<init>(r1)
        L_0x047f:
            r2 = r5
            goto L_0x064e
        L_0x0482:
            r0 = r18
            r5 = r20
            r1 = r21
            r2 = 1
            com.google.android.gms.internal.measurement.zzh.zzj(r12, r2, r1)
            java.lang.String r2 = r0.zza
            int r3 = r21.size()
            if (r3 > 0) goto L_0x0497
            java.lang.String r1 = ""
            goto L_0x04a6
        L_0x0497:
            r3 = 0
            java.lang.Object r1 = r1.get(r3)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r5.zzb(r1)
            java.lang.String r1 = r1.zzi()
        L_0x04a6:
            java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r1)
            java.util.regex.Matcher r1 = r1.matcher(r2)
            boolean r2 = r1.find()
            if (r2 == 0) goto L_0x04ce
            com.google.android.gms.internal.measurement.zzae r2 = new com.google.android.gms.internal.measurement.zzae
            r3 = 1
            com.google.android.gms.internal.measurement.zzap[] r3 = new com.google.android.gms.internal.measurement.zzap[r3]
            com.google.android.gms.internal.measurement.zzat r4 = new com.google.android.gms.internal.measurement.zzat
            java.lang.String r1 = r1.group()
            r4.<init>(r1)
            r1 = 0
            r3[r1] = r4
            java.util.List r1 = java.util.Arrays.asList(r3)
            r2.<init>(r1)
            goto L_0x064e
        L_0x04ce:
            com.google.android.gms.internal.measurement.zzap r2 = com.google.android.gms.internal.measurement.zzap.zzg
            goto L_0x064e
        L_0x04d2:
            r0 = r18
            r5 = r20
            r1 = r21
            r2 = 2
            r3 = 0
            com.google.android.gms.internal.measurement.zzh.zzj(r13, r2, r1)
            java.lang.String r4 = r0.zza
            int r6 = r21.size()
            if (r6 > 0) goto L_0x04e6
            goto L_0x04f4
        L_0x04e6:
            java.lang.Object r3 = r1.get(r3)
            com.google.android.gms.internal.measurement.zzap r3 = (com.google.android.gms.internal.measurement.zzap) r3
            com.google.android.gms.internal.measurement.zzap r3 = r5.zzb(r3)
            java.lang.String r16 = r3.zzi()
        L_0x04f4:
            r3 = r16
            int r6 = r21.size()
            if (r6 >= r2) goto L_0x04ff
            r1 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            goto L_0x0512
        L_0x04ff:
            r2 = 1
            java.lang.Object r1 = r1.get(r2)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r5.zzb(r1)
            java.lang.Double r1 = r1.zzh()
            double r1 = r1.doubleValue()
        L_0x0512:
            boolean r5 = java.lang.Double.isNaN(r1)
            if (r5 == 0) goto L_0x051b
            r1 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            goto L_0x051f
        L_0x051b:
            double r1 = com.google.android.gms.internal.measurement.zzh.zza(r1)
        L_0x051f:
            com.google.android.gms.internal.measurement.zzah r5 = new com.google.android.gms.internal.measurement.zzah
            int r1 = (int) r1
            int r1 = r4.lastIndexOf(r3, r1)
            double r1 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r5.<init>(r1)
            goto L_0x047f
        L_0x0530:
            r0 = r18
            r5 = r20
            r1 = r21
            r2 = 2
            r3 = 0
            com.google.android.gms.internal.measurement.zzh.zzj(r7, r2, r1)
            java.lang.String r6 = r0.zza
            int r7 = r21.size()
            if (r7 > 0) goto L_0x0545
            goto L_0x0554
        L_0x0545:
            r7 = 0
            java.lang.Object r7 = r1.get(r7)
            com.google.android.gms.internal.measurement.zzap r7 = (com.google.android.gms.internal.measurement.zzap) r7
            com.google.android.gms.internal.measurement.zzap r7 = r5.zzb(r7)
            java.lang.String r16 = r7.zzi()
        L_0x0554:
            r7 = r16
            int r8 = r21.size()
            if (r8 >= r2) goto L_0x055d
            goto L_0x0570
        L_0x055d:
            r2 = 1
            java.lang.Object r1 = r1.get(r2)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r5.zzb(r1)
            java.lang.Double r1 = r1.zzh()
            double r3 = r1.doubleValue()
        L_0x0570:
            double r1 = com.google.android.gms.internal.measurement.zzh.zza(r3)
            com.google.android.gms.internal.measurement.zzah r3 = new com.google.android.gms.internal.measurement.zzah
            int r1 = (int) r1
            int r1 = r6.indexOf(r7, r1)
            double r1 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r3.<init>(r1)
            goto L_0x064a
        L_0x0585:
            r0 = r18
            r5 = r20
            r1 = r21
            r2 = 1
            com.google.android.gms.internal.measurement.zzh.zzh(r6, r2, r1)
            java.lang.String r2 = r0.zza
            r3 = 0
            java.lang.Object r1 = r1.get(r3)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r5.zzb(r1)
            java.lang.String r3 = r1.zzi()
            java.lang.String r4 = "length"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x05ac
            com.google.android.gms.internal.measurement.zzap r2 = com.google.android.gms.internal.measurement.zzap.zzk
            goto L_0x064e
        L_0x05ac:
            java.lang.Double r1 = r1.zzh()
            double r3 = r1.doubleValue()
            double r5 = java.lang.Math.floor(r3)
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x05c9
            int r1 = (int) r3
            if (r1 < 0) goto L_0x05c9
            int r2 = r2.length()
            if (r1 >= r2) goto L_0x05c9
            com.google.android.gms.internal.measurement.zzap r2 = com.google.android.gms.internal.measurement.zzap.zzk
            goto L_0x064e
        L_0x05c9:
            com.google.android.gms.internal.measurement.zzap r2 = com.google.android.gms.internal.measurement.zzap.zzl
            goto L_0x064e
        L_0x05cd:
            r0 = r18
            r5 = r20
            r1 = r21
            boolean r2 = r21.isEmpty()
            if (r2 != 0) goto L_0x0606
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = r0.zza
            r2.<init>(r3)
            r3 = 0
        L_0x05e1:
            int r4 = r21.size()
            if (r3 >= r4) goto L_0x05fb
            java.lang.Object r4 = r1.get(r3)
            com.google.android.gms.internal.measurement.zzap r4 = (com.google.android.gms.internal.measurement.zzap) r4
            com.google.android.gms.internal.measurement.zzap r4 = r5.zzb(r4)
            java.lang.String r4 = r4.zzi()
            r2.append(r4)
            int r3 = r3 + 1
            goto L_0x05e1
        L_0x05fb:
            com.google.android.gms.internal.measurement.zzat r1 = new com.google.android.gms.internal.measurement.zzat
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            r2 = r1
            goto L_0x064e
        L_0x0606:
            r2 = r0
            goto L_0x064e
        L_0x0608:
            r0 = r18
            r5 = r20
            r1 = r21
            r2 = 1
            com.google.android.gms.internal.measurement.zzh.zzj(r4, r2, r1)
            boolean r2 = r21.isEmpty()
            if (r2 != 0) goto L_0x0631
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r5.zzb(r1)
            java.lang.Double r1 = r1.zzh()
            double r1 = r1.doubleValue()
            double r1 = com.google.android.gms.internal.measurement.zzh.zza(r1)
            int r1 = (int) r1
            goto L_0x0632
        L_0x0631:
            r1 = 0
        L_0x0632:
            java.lang.String r2 = r0.zza
            if (r1 < 0) goto L_0x064c
            int r3 = r2.length()
            if (r1 < r3) goto L_0x063d
            goto L_0x064c
        L_0x063d:
            com.google.android.gms.internal.measurement.zzat r3 = new com.google.android.gms.internal.measurement.zzat
            char r1 = r2.charAt(r1)
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r3.<init>(r1)
        L_0x064a:
            r2 = r3
            goto L_0x064e
        L_0x064c:
            com.google.android.gms.internal.measurement.zzap r2 = com.google.android.gms.internal.measurement.zzap.zzm
        L_0x064e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzat.zzbQ(java.lang.String, com.google.android.gms.internal.measurement.zzg, java.util.List):com.google.android.gms.internal.measurement.zzap");
    }

    public final zzap zzd() {
        return new zzat(this.zza);
    }

    public final Boolean zzg() {
        return Boolean.valueOf(!this.zza.isEmpty());
    }

    public final Double zzh() {
        if (this.zza.isEmpty()) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(this.zza);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    public final String zzi() {
        return this.zza;
    }

    public final Iterator zzl() {
        return new zzar(this);
    }
}
