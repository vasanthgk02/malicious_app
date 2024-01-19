package org.jboss.netty.util.internal.jzlib;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.jboss.netty.util.internal.jzlib.JZlib.WrapperType;

public final class Inflate {
    public static final int BAD = 13;
    public static final int BLOCKS = 7;
    public static final int CHECK1 = 11;
    public static final int CHECK2 = 10;
    public static final int CHECK3 = 9;
    public static final int CHECK4 = 8;
    public static final int DICT0 = 6;
    public static final int DICT1 = 5;
    public static final int DICT2 = 4;
    public static final int DICT3 = 3;
    public static final int DICT4 = 2;
    public static final int DONE = 12;
    public static final int FLAG = 1;
    public static final int GZIP_CM = 16;
    public static final int GZIP_CRC32 = 24;
    public static final int GZIP_FCOMMENT = 22;
    public static final int GZIP_FEXTRA = 20;
    public static final int GZIP_FHCRC = 23;
    public static final int GZIP_FLG = 17;
    public static final int GZIP_FNAME = 21;
    public static final int GZIP_ID1 = 14;
    public static final int GZIP_ID2 = 15;
    public static final int GZIP_ISIZE = 25;
    public static final int GZIP_MTIME_XFL_OS = 18;
    public static final int GZIP_XLEN = 19;
    public static final int METHOD = 0;
    public static final byte[] mark = {0, 0, -1, -1};
    public InfBlocks blocks;
    public int gzipBytesToRead;
    public int gzipCRC32;
    public int gzipFlag;
    public int gzipISize;
    public int gzipUncompressedBytes;
    public int gzipXLen;
    public int marker;
    public int method;
    public int mode;
    public long need;
    public final long[] was = new long[1];
    public int wbits;
    public WrapperType wrapperType;

    /* renamed from: org.jboss.netty.util.internal.jzlib.Inflate$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$jboss$netty$util$internal$jzlib$JZlib$WrapperType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(2:1|2)|3|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        static {
            /*
                org.jboss.netty.util.internal.jzlib.JZlib$WrapperType[] r0 = org.jboss.netty.util.internal.jzlib.JZlib.WrapperType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jboss$netty$util$internal$jzlib$JZlib$WrapperType = r0
                r1 = 1
                org.jboss.netty.util.internal.jzlib.JZlib$WrapperType r2 = org.jboss.netty.util.internal.jzlib.JZlib.WrapperType.NONE     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = $SwitchMap$org$jboss$netty$util$internal$jzlib$JZlib$WrapperType     // Catch:{ NoSuchFieldError -> 0x0016 }
                org.jboss.netty.util.internal.jzlib.JZlib$WrapperType r3 = org.jboss.netty.util.internal.jzlib.JZlib.WrapperType.ZLIB     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r1 = $SwitchMap$org$jboss$netty$util$internal$jzlib$JZlib$WrapperType     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jboss.netty.util.internal.jzlib.JZlib$WrapperType r2 = org.jboss.netty.util.internal.jzlib.JZlib.WrapperType.GZIP     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 3
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.util.internal.jzlib.Inflate.AnonymousClass1.<clinit>():void");
        }
    }

    private int inflateReset(ZStream zStream) {
        if (zStream == null || zStream.istate == null) {
            return -2;
        }
        zStream.total_out = 0;
        zStream.total_in = 0;
        zStream.msg = null;
        int ordinal = this.wrapperType.ordinal();
        if (ordinal == 0) {
            zStream.istate.mode = 7;
        } else if (ordinal == 1) {
            zStream.istate.mode = 0;
        } else if (ordinal == 2) {
            zStream.istate.mode = 14;
        }
        zStream.istate.blocks.reset(zStream, null);
        this.gzipUncompressedBytes = 0;
        return 0;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x024c, code lost:
        r2.avail_in = r0 - 1;
        r2.total_in++;
        r0 = r2.next_in;
        r3 = r2.next_in_index;
        r2.next_in_index = r3 + 1;
        r0 = r0[r3];
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0261, code lost:
        if (r0 != 0) goto L_0x0247;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0263, code lost:
        r0 = 2;
        r1.gzipBytesToRead = 2;
        r2.istate.mode = 23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x026f, code lost:
        if ((r0 & r1.gzipFlag) == 0) goto L_0x028f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0273, code lost:
        if (r1.gzipBytesToRead <= 0) goto L_0x028f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0277, code lost:
        if (r2.avail_in != 0) goto L_0x027a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0279, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x027a, code lost:
        r2.avail_in = r7 - 1;
        r2.total_in++;
        r2.next_in_index++;
        r1.gzipBytesToRead = r0 - 1;
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x028f, code lost:
        r2.istate.mode = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0296, code lost:
        r2.istate.mode = 21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0316, code lost:
        if (r2.avail_in != 0) goto L_0x0319;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0318, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0319, code lost:
        r2.avail_in = r0 - 1;
        r2.total_in++;
        r0 = r2.istate;
        r3 = r2.next_in;
        r7 = r2.next_in_index;
        r2.next_in_index = r7 + 1;
        r0.need = ((long) ((r3[r7] & 255) << 24)) & 4278190080L;
        r0.mode = 9;
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0340, code lost:
        if (r2.avail_in != 0) goto L_0x0343;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0342, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0343, code lost:
        r2.avail_in = r0 - 1;
        r2.total_in++;
        r0 = r2.istate;
        r7 = r0.need;
        r3 = r2.next_in;
        r9 = r2.next_in_index;
        r2.next_in_index = r9 + 1;
        r0.need = r7 + (((long) ((r3[r9] & 255) << org.apache.fontbox.ttf.GlyfDescript.X_DUAL)) & 16711680);
        r0.mode = 10;
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x036e, code lost:
        if (r2.avail_in != 0) goto L_0x0371;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0370, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0371, code lost:
        r2.avail_in = r0 - 1;
        r2.total_in++;
        r0 = r2.istate;
        r3 = r0.need;
        r5 = r2.next_in;
        r7 = r2.next_in_index;
        r2.next_in_index = r7 + 1;
        r0.need = r3 + (((long) ((r5[r7] & 255) << 8)) & 65280);
        r0.mode = 11;
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x039b, code lost:
        if (r2.avail_in != 0) goto L_0x039e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x039d, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0037, code lost:
        r0 = r1.gzipBytesToRead;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x039e, code lost:
        r2.avail_in = r0 - 1;
        r2.total_in++;
        r0 = r2.istate;
        r3 = r0.need;
        r5 = r2.next_in;
        r7 = r2.next_in_index;
        r2.next_in_index = r7 + 1;
        r3 = r3 + (((long) r5[r7]) & 255);
        r0.need = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x03c4, code lost:
        if (((int) r0.was[0]) == ((int) r3)) goto L_0x03d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x03c6, code lost:
        r0.mode = 13;
        r2.msg = "incorrect data check";
        r0.marker = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x03d0, code lost:
        r0.mode = 12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
        if (r0 <= 0) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
        if (r2.avail_in != 0) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0477, code lost:
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x047f, code lost:
        r0 = r2.avail_in;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0481, code lost:
        if (r0 != 0) goto L_0x0484;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0483, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0484, code lost:
        r2.avail_in = r0 - 1;
        r2.total_in++;
        r0 = r2.istate;
        r3 = r2.next_in;
        r4 = r2.next_in_index;
        r2.next_in_index = r4 + 1;
        r0.need = ((long) ((r3[r4] & 255) << 24)) & 4278190080L;
        r0.mode = 3;
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x04a7, code lost:
        r0 = r2.avail_in;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x04a9, code lost:
        if (r0 != 0) goto L_0x04ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x04ab, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x04ac, code lost:
        r2.avail_in = r0 - 1;
        r2.total_in++;
        r0 = r2.istate;
        r3 = r0.need;
        r5 = r2.next_in;
        r7 = r2.next_in_index;
        r2.next_in_index = r7 + 1;
        r0.need = r3 + (((long) ((r5[r7] & 255) << org.apache.fontbox.ttf.GlyfDescript.X_DUAL)) & 16711680);
        r0.mode = 4;
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x04d3, code lost:
        r0 = r2.avail_in;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x04d5, code lost:
        if (r0 != 0) goto L_0x04d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x04d7, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x04d8, code lost:
        r2.avail_in = r0 - 1;
        r2.total_in++;
        r0 = r2.istate;
        r3 = r0.need;
        r5 = r2.next_in;
        r7 = r2.next_in_index;
        r2.next_in_index = r7 + 1;
        r0.need = r3 + (((long) ((r5[r7] & 255) << 8)) & 65280);
        r0.mode = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x04fd, code lost:
        r0 = r2.avail_in;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x04ff, code lost:
        if (r0 != 0) goto L_0x0502;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0501, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0502, code lost:
        r2.avail_in = r0 - 1;
        r2.total_in++;
        r0 = r2.istate;
        r3 = r0.need;
        r5 = r2.next_in;
        r6 = r2.next_in_index;
        r2.next_in_index = r6 + 1;
        r3 = r3 + (((long) r5[r6]) & 255);
        r0.need = r3;
        r2.adler = r3;
        r0.mode = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0040, code lost:
        r2.avail_in = r5 - 1;
        r2.total_in++;
        r0 = r0 - 1;
        r1.gzipBytesToRead = r0;
        r3 = r2.istate;
        r5 = r3.gzipCRC32;
        r7 = r2.next_in;
        r8 = r2.next_in_index;
        r2.next_in_index = r8 + 1;
        r3.gzipCRC32 = ((r7[r8] & 255) << ((3 - r0) * 8)) | r5;
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0526, code lost:
        return 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0069, code lost:
        r0 = r2.crc32;
        r5 = r2.istate;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006f, code lost:
        if (r0 == r5.gzipCRC32) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0071, code lost:
        r5.mode = 13;
        r2.msg = "incorrect CRC32 checksum";
        r5.marker = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007b, code lost:
        r1.gzipBytesToRead = r4;
        r5.mode = 25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0081, code lost:
        r0 = r1.gzipBytesToRead;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0083, code lost:
        if (r0 <= 0) goto L_0x00b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0087, code lost:
        if (r2.avail_in != 0) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0089, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008a, code lost:
        r2.avail_in = r5 - 1;
        r2.total_in++;
        r0 = r0 - 1;
        r1.gzipBytesToRead = r0;
        r3 = r2.istate;
        r5 = r3.gzipISize;
        r7 = r2.next_in;
        r8 = r2.next_in_index;
        r2.next_in_index = r8 + 1;
        r3.gzipISize = ((r7[r8] & 255) << ((3 - r0) * 8)) | r5;
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b3, code lost:
        r0 = r1.gzipUncompressedBytes;
        r5 = r2.istate;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b9, code lost:
        if (r0 == r5.gzipISize) goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00bb, code lost:
        r5.mode = 13;
        r2.msg = "incorrect ISIZE checksum";
        r5.marker = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c5, code lost:
        r5.mode = 12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x018f, code lost:
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01bc, code lost:
        if ((r1.gzipFlag & r4) == 0) goto L_0x0296;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01be, code lost:
        r0 = r1.gzipBytesToRead;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01c0, code lost:
        if (r0 <= 0) goto L_0x01ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01c4, code lost:
        if (r2.avail_in != 0) goto L_0x01c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01c6, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01c7, code lost:
        r2.avail_in = r7 - 1;
        r2.total_in++;
        r3 = r1.gzipXLen;
        r7 = r2.next_in;
        r8 = r2.next_in_index;
        r2.next_in_index = r8 + 1;
        r1.gzipXLen = r3 | ((r7[r8] & 255) << ((1 - r0) * 8));
        r1.gzipBytesToRead = r0 - 1;
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01ed, code lost:
        r1.gzipBytesToRead = r1.gzipXLen;
        r2.istate.mode = 20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01f9, code lost:
        if (r1.gzipBytesToRead <= 0) goto L_0x0215;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01fd, code lost:
        if (r2.avail_in != 0) goto L_0x0200;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01ff, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0200, code lost:
        r2.avail_in = r7 - 1;
        r2.total_in++;
        r2.next_in_index++;
        r1.gzipBytesToRead = r0 - 1;
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0215, code lost:
        r2.istate.mode = 21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x021e, code lost:
        if ((r1.gzipFlag & 8) == 0) goto L_0x023c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0222, code lost:
        if (r2.avail_in != 0) goto L_0x0225;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0224, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0225, code lost:
        r2.avail_in = r0 - 1;
        r2.total_in++;
        r0 = r2.next_in;
        r3 = r2.next_in_index;
        r2.next_in_index = r3 + 1;
        r0 = r0[r3];
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x023a, code lost:
        if (r0 != 0) goto L_0x0220;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x023c, code lost:
        r2.istate.mode = 22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0245, code lost:
        if ((r1.gzipFlag & 16) == 0) goto L_0x0263;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0249, code lost:
        if (r2.avail_in != 0) goto L_0x024c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x024b, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int inflate(org.jboss.netty.util.internal.jzlib.ZStream r21, int r22) {
        /*
            r20 = this;
            r1 = r20
            r2 = r21
            if (r2 == 0) goto L_0x0527
            org.jboss.netty.util.internal.jzlib.Inflate r3 = r2.istate
            if (r3 == 0) goto L_0x0527
            byte[] r3 = r2.next_in
            if (r3 != 0) goto L_0x0010
            goto L_0x0527
        L_0x0010:
            r3 = -5
            r4 = 4
            r6 = r22
            if (r6 != r4) goto L_0x0018
            r6 = -5
            goto L_0x0019
        L_0x0018:
            r6 = 0
        L_0x0019:
            org.jboss.netty.util.internal.jzlib.Inflate r7 = r2.istate
            int r8 = r7.mode
            r9 = 6
            r16 = 4278190080(0xff000000, double:2.113706745E-314)
            r0 = 31
            r11 = 12
            r12 = 3
            r14 = 16
            r13 = 5
            r10 = 8
            r15 = 13
            r18 = 1
            r5 = 1
            switch(r8) {
                case 0: goto L_0x0405;
                case 1: goto L_0x0443;
                case 2: goto L_0x047f;
                case 3: goto L_0x04a7;
                case 4: goto L_0x04d3;
                case 5: goto L_0x0402;
                case 6: goto L_0x03f7;
                case 7: goto L_0x02a3;
                case 8: goto L_0x0314;
                case 9: goto L_0x033e;
                case 10: goto L_0x036c;
                case 11: goto L_0x0399;
                case 12: goto L_0x02a0;
                case 13: goto L_0x029e;
                case 14: goto L_0x00cc;
                case 15: goto L_0x00f8;
                case 16: goto L_0x0128;
                case 17: goto L_0x0159;
                case 18: goto L_0x0190;
                case 19: goto L_0x01b9;
                case 20: goto L_0x01f7;
                case 21: goto L_0x021b;
                case 22: goto L_0x0242;
                case 23: goto L_0x00c9;
                case 24: goto L_0x0037;
                case 25: goto L_0x0081;
                default: goto L_0x0035;
            }
        L_0x0035:
            r0 = -2
            return r0
        L_0x0037:
            int r0 = r1.gzipBytesToRead
            if (r0 <= 0) goto L_0x0069
            int r5 = r2.avail_in
            if (r5 != 0) goto L_0x0040
            return r3
        L_0x0040:
            int r5 = r5 + -1
            r2.avail_in = r5
            long r7 = r2.total_in
            long r7 = r7 + r18
            r2.total_in = r7
            int r0 = r0 + -1
            r1.gzipBytesToRead = r0
            org.jboss.netty.util.internal.jzlib.Inflate r3 = r2.istate
            int r5 = r3.gzipCRC32
            byte[] r7 = r2.next_in
            int r8 = r2.next_in_index
            int r9 = r8 + 1
            r2.next_in_index = r9
            byte r7 = r7[r8]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r0 = 3 - r0
            int r0 = r0 * 8
            int r0 = r7 << r0
            r0 = r0 | r5
            r3.gzipCRC32 = r0
            r3 = r6
            goto L_0x0037
        L_0x0069:
            int r0 = r2.crc32
            org.jboss.netty.util.internal.jzlib.Inflate r5 = r2.istate
            int r7 = r5.gzipCRC32
            if (r0 == r7) goto L_0x007b
            r5.mode = r15
            java.lang.String r0 = "incorrect CRC32 checksum"
            r2.msg = r0
            r5.marker = r13
            goto L_0x0478
        L_0x007b:
            r1.gzipBytesToRead = r4
            r0 = 25
            r5.mode = r0
        L_0x0081:
            int r0 = r1.gzipBytesToRead
            if (r0 <= 0) goto L_0x00b3
            int r5 = r2.avail_in
            if (r5 != 0) goto L_0x008a
            return r3
        L_0x008a:
            int r5 = r5 + -1
            r2.avail_in = r5
            long r7 = r2.total_in
            long r7 = r7 + r18
            r2.total_in = r7
            int r0 = r0 + -1
            r1.gzipBytesToRead = r0
            org.jboss.netty.util.internal.jzlib.Inflate r3 = r2.istate
            int r5 = r3.gzipISize
            byte[] r7 = r2.next_in
            int r8 = r2.next_in_index
            int r9 = r8 + 1
            r2.next_in_index = r9
            byte r7 = r7[r8]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r0 = 3 - r0
            int r0 = r0 * 8
            int r0 = r7 << r0
            r0 = r0 | r5
            r3.gzipISize = r0
            r3 = r6
            goto L_0x0081
        L_0x00b3:
            int r0 = r1.gzipUncompressedBytes
            org.jboss.netty.util.internal.jzlib.Inflate r5 = r2.istate
            int r7 = r5.gzipISize
            if (r0 == r7) goto L_0x00c5
            r5.mode = r15
            java.lang.String r0 = "incorrect ISIZE checksum"
            r2.msg = r0
            r5.marker = r13
            goto L_0x0478
        L_0x00c5:
            r5.mode = r11
            goto L_0x0478
        L_0x00c9:
            r0 = 2
            goto L_0x026c
        L_0x00cc:
            int r8 = r2.avail_in
            if (r8 != 0) goto L_0x00d1
            return r3
        L_0x00d1:
            int r8 = r8 + -1
            r2.avail_in = r8
            long r11 = r2.total_in
            long r11 = r11 + r18
            r2.total_in = r11
            byte[] r3 = r2.next_in
            int r8 = r2.next_in_index
            int r11 = r8 + 1
            r2.next_in_index = r11
            byte r3 = r3[r8]
            r3 = r3 & 255(0xff, float:3.57E-43)
            if (r3 == r0) goto L_0x00f3
            r7.mode = r15
            java.lang.String r0 = "not a gzip stream"
            r2.msg = r0
            r7.marker = r13
            goto L_0x0477
        L_0x00f3:
            r0 = 15
            r7.mode = r0
            r3 = r6
        L_0x00f8:
            int r0 = r2.avail_in
            if (r0 != 0) goto L_0x00fd
            return r3
        L_0x00fd:
            int r0 = r0 + -1
            r2.avail_in = r0
            long r7 = r2.total_in
            long r7 = r7 + r18
            r2.total_in = r7
            byte[] r0 = r2.next_in
            int r3 = r2.next_in_index
            int r7 = r3 + 1
            r2.next_in_index = r7
            byte r0 = r0[r3]
            r0 = r0 & 255(0xff, float:3.57E-43)
            r3 = 139(0x8b, float:1.95E-43)
            if (r0 == r3) goto L_0x0123
            org.jboss.netty.util.internal.jzlib.Inflate r0 = r2.istate
            r0.mode = r15
            java.lang.String r3 = "not a gzip stream"
            r2.msg = r3
            r0.marker = r13
            goto L_0x0477
        L_0x0123:
            org.jboss.netty.util.internal.jzlib.Inflate r0 = r2.istate
            r0.mode = r14
            r3 = r6
        L_0x0128:
            int r0 = r2.avail_in
            if (r0 != 0) goto L_0x012d
            return r3
        L_0x012d:
            int r0 = r0 + -1
            r2.avail_in = r0
            long r7 = r2.total_in
            long r7 = r7 + r18
            r2.total_in = r7
            byte[] r0 = r2.next_in
            int r3 = r2.next_in_index
            int r7 = r3 + 1
            r2.next_in_index = r7
            byte r0 = r0[r3]
            r0 = r0 & 255(0xff, float:3.57E-43)
            if (r0 == r10) goto L_0x0152
            org.jboss.netty.util.internal.jzlib.Inflate r0 = r2.istate
            r0.mode = r15
            java.lang.String r3 = "unknown compression method"
            r2.msg = r3
            r0.marker = r13
            goto L_0x0477
        L_0x0152:
            org.jboss.netty.util.internal.jzlib.Inflate r0 = r2.istate
            r3 = 17
            r0.mode = r3
            r3 = r6
        L_0x0159:
            int r0 = r2.avail_in
            if (r0 != 0) goto L_0x015e
            return r3
        L_0x015e:
            int r0 = r0 + -1
            r2.avail_in = r0
            long r7 = r2.total_in
            long r7 = r7 + r18
            r2.total_in = r7
            byte[] r0 = r2.next_in
            int r3 = r2.next_in_index
            int r7 = r3 + 1
            r2.next_in_index = r7
            byte r0 = r0[r3]
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1.gzipFlag = r0
            r0 = r0 & 226(0xe2, float:3.17E-43)
            if (r0 == 0) goto L_0x0187
            org.jboss.netty.util.internal.jzlib.Inflate r0 = r2.istate
            r0.mode = r15
            java.lang.String r3 = "unsupported flag"
            r2.msg = r3
            r0.marker = r13
            goto L_0x0477
        L_0x0187:
            r1.gzipBytesToRead = r9
            org.jboss.netty.util.internal.jzlib.Inflate r0 = r2.istate
            r3 = 18
            r0.mode = r3
        L_0x018f:
            r3 = r6
        L_0x0190:
            int r0 = r1.gzipBytesToRead
            if (r0 <= 0) goto L_0x01ad
            int r7 = r2.avail_in
            if (r7 != 0) goto L_0x0199
            return r3
        L_0x0199:
            int r7 = r7 + -1
            r2.avail_in = r7
            long r7 = r2.total_in
            long r7 = r7 + r18
            r2.total_in = r7
            int r3 = r2.next_in_index
            int r3 = r3 + r5
            r2.next_in_index = r3
            int r0 = r0 + -1
            r1.gzipBytesToRead = r0
            goto L_0x018f
        L_0x01ad:
            org.jboss.netty.util.internal.jzlib.Inflate r0 = r2.istate
            r7 = 19
            r0.mode = r7
            r0 = 0
            r1.gzipXLen = r0
            r0 = 2
            r1.gzipBytesToRead = r0
        L_0x01b9:
            int r0 = r1.gzipFlag
            r0 = r0 & r4
            if (r0 == 0) goto L_0x0296
        L_0x01be:
            int r0 = r1.gzipBytesToRead
            if (r0 <= 0) goto L_0x01ed
            int r7 = r2.avail_in
            if (r7 != 0) goto L_0x01c7
            return r3
        L_0x01c7:
            int r7 = r7 + -1
            r2.avail_in = r7
            long r7 = r2.total_in
            long r7 = r7 + r18
            r2.total_in = r7
            int r3 = r1.gzipXLen
            byte[] r7 = r2.next_in
            int r8 = r2.next_in_index
            int r9 = r8 + 1
            r2.next_in_index = r9
            byte r7 = r7[r8]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r8 = 1 - r0
            int r8 = r8 * 8
            int r7 = r7 << r8
            r3 = r3 | r7
            r1.gzipXLen = r3
            int r0 = r0 + -1
            r1.gzipBytesToRead = r0
            r3 = r6
            goto L_0x01be
        L_0x01ed:
            int r0 = r1.gzipXLen
            r1.gzipBytesToRead = r0
            org.jboss.netty.util.internal.jzlib.Inflate r0 = r2.istate
            r7 = 20
            r0.mode = r7
        L_0x01f7:
            int r0 = r1.gzipBytesToRead
            if (r0 <= 0) goto L_0x0215
            int r7 = r2.avail_in
            if (r7 != 0) goto L_0x0200
            return r3
        L_0x0200:
            int r7 = r7 + -1
            r2.avail_in = r7
            long r7 = r2.total_in
            long r7 = r7 + r18
            r2.total_in = r7
            int r3 = r2.next_in_index
            int r3 = r3 + r5
            r2.next_in_index = r3
            int r0 = r0 + -1
            r1.gzipBytesToRead = r0
            r3 = r6
            goto L_0x01f7
        L_0x0215:
            org.jboss.netty.util.internal.jzlib.Inflate r0 = r2.istate
            r7 = 21
            r0.mode = r7
        L_0x021b:
            int r0 = r1.gzipFlag
            r0 = r0 & r10
            if (r0 == 0) goto L_0x023c
        L_0x0220:
            int r0 = r2.avail_in
            if (r0 != 0) goto L_0x0225
            return r3
        L_0x0225:
            int r0 = r0 + -1
            r2.avail_in = r0
            long r7 = r2.total_in
            long r7 = r7 + r18
            r2.total_in = r7
            byte[] r0 = r2.next_in
            int r3 = r2.next_in_index
            int r7 = r3 + 1
            r2.next_in_index = r7
            byte r0 = r0[r3]
            r3 = r6
            if (r0 != 0) goto L_0x0220
        L_0x023c:
            org.jboss.netty.util.internal.jzlib.Inflate r0 = r2.istate
            r7 = 22
            r0.mode = r7
        L_0x0242:
            int r0 = r1.gzipFlag
            r0 = r0 & r14
            if (r0 == 0) goto L_0x0263
        L_0x0247:
            int r0 = r2.avail_in
            if (r0 != 0) goto L_0x024c
            return r3
        L_0x024c:
            int r0 = r0 + -1
            r2.avail_in = r0
            long r7 = r2.total_in
            long r7 = r7 + r18
            r2.total_in = r7
            byte[] r0 = r2.next_in
            int r3 = r2.next_in_index
            int r7 = r3 + 1
            r2.next_in_index = r7
            byte r0 = r0[r3]
            r3 = r6
            if (r0 != 0) goto L_0x0247
        L_0x0263:
            r0 = 2
            r1.gzipBytesToRead = r0
            org.jboss.netty.util.internal.jzlib.Inflate r7 = r2.istate
            r8 = 23
            r7.mode = r8
        L_0x026c:
            int r7 = r1.gzipFlag
            r0 = r0 & r7
            if (r0 == 0) goto L_0x028f
        L_0x0271:
            int r0 = r1.gzipBytesToRead
            if (r0 <= 0) goto L_0x028f
            int r7 = r2.avail_in
            if (r7 != 0) goto L_0x027a
            return r3
        L_0x027a:
            int r7 = r7 + -1
            r2.avail_in = r7
            long r7 = r2.total_in
            long r7 = r7 + r18
            r2.total_in = r7
            int r3 = r2.next_in_index
            int r3 = r3 + r5
            r2.next_in_index = r3
            int r0 = r0 + -1
            r1.gzipBytesToRead = r0
            r3 = r6
            goto L_0x0271
        L_0x028f:
            org.jboss.netty.util.internal.jzlib.Inflate r0 = r2.istate
            r5 = 7
            r0.mode = r5
            goto L_0x0478
        L_0x0296:
            org.jboss.netty.util.internal.jzlib.Inflate r0 = r2.istate
            r5 = 21
            r0.mode = r5
            goto L_0x0478
        L_0x029e:
            r0 = -3
            return r0
        L_0x02a0:
            r0 = 1
            goto L_0x03d4
        L_0x02a3:
            int r8 = r2.next_out_index
            org.jboss.netty.util.internal.jzlib.InfBlocks r0 = r7.blocks     // Catch:{ all -> 0x03e3 }
            int r0 = r0.proc(r2, r3)     // Catch:{ all -> 0x03e3 }
            r3 = -3
            if (r0 != r3) goto L_0x02cc
            org.jboss.netty.util.internal.jzlib.Inflate r3 = r2.istate     // Catch:{ all -> 0x03e3 }
            r3.mode = r15     // Catch:{ all -> 0x03e3 }
            org.jboss.netty.util.internal.jzlib.Inflate r3 = r2.istate     // Catch:{ all -> 0x03e3 }
            r5 = 0
            r3.marker = r5     // Catch:{ all -> 0x03e3 }
            int r3 = r2.next_out_index
            int r3 = r3 - r8
            int r5 = r1.gzipUncompressedBytes
            int r5 = r5 + r3
            r1.gzipUncompressedBytes = r5
            int r5 = r2.crc32
            byte[] r7 = r2.next_out
            int r3 = org.jboss.netty.util.internal.jzlib.CRC32.crc32(r5, r7, r8, r3)
            r2.crc32 = r3
            r3 = r0
            goto L_0x0478
        L_0x02cc:
            if (r0 != 0) goto L_0x02cf
            r0 = r6
        L_0x02cf:
            if (r0 == r5) goto L_0x02e4
            int r3 = r2.next_out_index
            int r3 = r3 - r8
            int r4 = r1.gzipUncompressedBytes
            int r4 = r4 + r3
            r1.gzipUncompressedBytes = r4
            int r4 = r2.crc32
            byte[] r5 = r2.next_out
            int r3 = org.jboss.netty.util.internal.jzlib.CRC32.crc32(r4, r5, r8, r3)
            r2.crc32 = r3
            return r0
        L_0x02e4:
            org.jboss.netty.util.internal.jzlib.Inflate r0 = r2.istate     // Catch:{ all -> 0x03e3 }
            org.jboss.netty.util.internal.jzlib.InfBlocks r0 = r0.blocks     // Catch:{ all -> 0x03e3 }
            org.jboss.netty.util.internal.jzlib.Inflate r3 = r2.istate     // Catch:{ all -> 0x03e3 }
            long[] r3 = r3.was     // Catch:{ all -> 0x03e3 }
            r0.reset(r2, r3)     // Catch:{ all -> 0x03e3 }
            int r0 = r2.next_out_index
            int r0 = r0 - r8
            int r3 = r1.gzipUncompressedBytes
            int r3 = r3 + r0
            r1.gzipUncompressedBytes = r3
            int r3 = r2.crc32
            byte[] r7 = r2.next_out
            int r0 = org.jboss.netty.util.internal.jzlib.CRC32.crc32(r3, r7, r8, r0)
            r2.crc32 = r0
            org.jboss.netty.util.internal.jzlib.Inflate r0 = r2.istate
            org.jboss.netty.util.internal.jzlib.JZlib$WrapperType r3 = r0.wrapperType
            org.jboss.netty.util.internal.jzlib.JZlib$WrapperType r7 = org.jboss.netty.util.internal.jzlib.JZlib.WrapperType.NONE
            if (r3 != r7) goto L_0x030d
            r0.mode = r11
            goto L_0x0477
        L_0x030d:
            org.jboss.netty.util.internal.jzlib.JZlib$WrapperType r7 = org.jboss.netty.util.internal.jzlib.JZlib.WrapperType.ZLIB
            if (r3 != r7) goto L_0x03d5
            r0.mode = r10
            r3 = r6
        L_0x0314:
            int r0 = r2.avail_in
            if (r0 != 0) goto L_0x0319
            return r3
        L_0x0319:
            int r0 = r0 + -1
            r2.avail_in = r0
            long r7 = r2.total_in
            long r7 = r7 + r18
            r2.total_in = r7
            org.jboss.netty.util.internal.jzlib.Inflate r0 = r2.istate
            byte[] r3 = r2.next_in
            int r7 = r2.next_in_index
            int r8 = r7 + 1
            r2.next_in_index = r8
            byte r3 = r3[r7]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r7 = 24
            int r3 = r3 << r7
            long r7 = (long) r3
            long r7 = r7 & r16
            r0.need = r7
            r3 = 9
            r0.mode = r3
            r3 = r6
        L_0x033e:
            int r0 = r2.avail_in
            if (r0 != 0) goto L_0x0343
            return r3
        L_0x0343:
            int r0 = r0 + -1
            r2.avail_in = r0
            long r7 = r2.total_in
            long r7 = r7 + r18
            r2.total_in = r7
            org.jboss.netty.util.internal.jzlib.Inflate r0 = r2.istate
            long r7 = r0.need
            byte[] r3 = r2.next_in
            int r9 = r2.next_in_index
            int r12 = r9 + 1
            r2.next_in_index = r12
            byte r3 = r3[r9]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << r14
            long r4 = (long) r3
            r16 = 16711680(0xff0000, double:8.256667E-317)
            long r3 = r4 & r16
            long r7 = r7 + r3
            r0.need = r7
            r3 = 10
            r0.mode = r3
            r3 = r6
        L_0x036c:
            int r0 = r2.avail_in
            if (r0 != 0) goto L_0x0371
            return r3
        L_0x0371:
            int r0 = r0 + -1
            r2.avail_in = r0
            long r3 = r2.total_in
            long r3 = r3 + r18
            r2.total_in = r3
            org.jboss.netty.util.internal.jzlib.Inflate r0 = r2.istate
            long r3 = r0.need
            byte[] r5 = r2.next_in
            int r7 = r2.next_in_index
            int r8 = r7 + 1
            r2.next_in_index = r8
            byte r5 = r5[r7]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r5 = r5 << r10
            long r7 = (long) r5
            r9 = 65280(0xff00, double:3.22526E-319)
            long r7 = r7 & r9
            long r3 = r3 + r7
            r0.need = r3
            r3 = 11
            r0.mode = r3
            r3 = r6
        L_0x0399:
            int r0 = r2.avail_in
            if (r0 != 0) goto L_0x039e
            return r3
        L_0x039e:
            int r0 = r0 + -1
            r2.avail_in = r0
            long r3 = r2.total_in
            long r3 = r3 + r18
            r2.total_in = r3
            org.jboss.netty.util.internal.jzlib.Inflate r0 = r2.istate
            long r3 = r0.need
            byte[] r5 = r2.next_in
            int r7 = r2.next_in_index
            int r8 = r7 + 1
            r2.next_in_index = r8
            byte r5 = r5[r7]
            long r7 = (long) r5
            r9 = 255(0xff, double:1.26E-321)
            long r7 = r7 & r9
            long r3 = r3 + r7
            r0.need = r3
            long[] r5 = r0.was
            r7 = 0
            r8 = r5[r7]
            int r5 = (int) r8
            int r4 = (int) r3
            if (r5 == r4) goto L_0x03d0
            r0.mode = r15
            java.lang.String r3 = "incorrect data check"
            r2.msg = r3
            r0.marker = r13
            goto L_0x0477
        L_0x03d0:
            r0.mode = r11
            goto L_0x02a0
        L_0x03d4:
            return r0
        L_0x03d5:
            r3 = 0
            r1.gzipCRC32 = r3
            r1.gzipISize = r3
            r3 = 4
            r1.gzipBytesToRead = r3
            r3 = 24
            r0.mode = r3
            goto L_0x0477
        L_0x03e3:
            r0 = move-exception
            int r3 = r2.next_out_index
            int r3 = r3 - r8
            int r4 = r1.gzipUncompressedBytes
            int r4 = r4 + r3
            r1.gzipUncompressedBytes = r4
            int r4 = r2.crc32
            byte[] r5 = r2.next_out
            int r3 = org.jboss.netty.util.internal.jzlib.CRC32.crc32(r4, r5, r8, r3)
            r2.crc32 = r3
            throw r0
        L_0x03f7:
            r7.mode = r15
            java.lang.String r0 = "need dictionary"
            r2.msg = r0
            r4 = 0
            r7.marker = r4
            r0 = -2
            return r0
        L_0x0402:
            r6 = r3
            goto L_0x04fd
        L_0x0405:
            r4 = 0
            int r5 = r2.avail_in
            if (r5 != 0) goto L_0x040b
            return r3
        L_0x040b:
            int r5 = r5 + -1
            r2.avail_in = r5
            long r4 = r2.total_in
            long r4 = r4 + r18
            r2.total_in = r4
            byte[] r3 = r2.next_in
            int r4 = r2.next_in_index
            int r5 = r4 + 1
            r2.next_in_index = r5
            byte r3 = r3[r4]
            r7.method = r3
            r4 = r3 & 15
            if (r4 == r10) goto L_0x042f
            r7.mode = r15
            java.lang.String r0 = "unknown compression method"
            r2.msg = r0
            r7.marker = r13
            goto L_0x0477
        L_0x042f:
            int r3 = r3 >> 4
            int r3 = r3 + r10
            int r4 = r7.wbits
            if (r3 <= r4) goto L_0x043f
            r7.mode = r15
            java.lang.String r0 = "invalid window size"
            r2.msg = r0
            r7.marker = r13
            goto L_0x0477
        L_0x043f:
            r3 = 1
            r7.mode = r3
            r3 = r6
        L_0x0443:
            int r4 = r2.avail_in
            if (r4 != 0) goto L_0x0448
            return r3
        L_0x0448:
            int r4 = r4 + -1
            r2.avail_in = r4
            long r3 = r2.total_in
            long r3 = r3 + r18
            r2.total_in = r3
            byte[] r3 = r2.next_in
            int r4 = r2.next_in_index
            int r5 = r4 + 1
            r2.next_in_index = r5
            byte r3 = r3[r4]
            r3 = r3 & 255(0xff, float:3.57E-43)
            org.jboss.netty.util.internal.jzlib.Inflate r4 = r2.istate
            int r5 = r4.method
            int r5 = r5 << r10
            int r5 = r5 + r3
            int r5 = r5 % r0
            if (r5 == 0) goto L_0x0470
            r4.mode = r15
            java.lang.String r0 = "incorrect header check"
            r2.msg = r0
            r4.marker = r13
            goto L_0x0477
        L_0x0470:
            r0 = r3 & 32
            if (r0 != 0) goto L_0x047b
            r0 = 7
            r4.mode = r0
        L_0x0477:
            r3 = r6
        L_0x0478:
            r4 = 4
            goto L_0x0019
        L_0x047b:
            r0 = 2
            r4.mode = r0
            r3 = r6
        L_0x047f:
            int r0 = r2.avail_in
            if (r0 != 0) goto L_0x0484
            return r3
        L_0x0484:
            r3 = 1
            int r0 = r0 - r3
            r2.avail_in = r0
            long r3 = r2.total_in
            long r3 = r3 + r18
            r2.total_in = r3
            org.jboss.netty.util.internal.jzlib.Inflate r0 = r2.istate
            byte[] r3 = r2.next_in
            int r4 = r2.next_in_index
            int r5 = r4 + 1
            r2.next_in_index = r5
            byte r3 = r3[r4]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r4 = 24
            int r3 = r3 << r4
            long r3 = (long) r3
            long r3 = r3 & r16
            r0.need = r3
            r0.mode = r12
            r3 = r6
        L_0x04a7:
            int r0 = r2.avail_in
            if (r0 != 0) goto L_0x04ac
            return r3
        L_0x04ac:
            r3 = 1
            int r0 = r0 - r3
            r2.avail_in = r0
            long r3 = r2.total_in
            long r3 = r3 + r18
            r2.total_in = r3
            org.jboss.netty.util.internal.jzlib.Inflate r0 = r2.istate
            long r3 = r0.need
            byte[] r5 = r2.next_in
            int r7 = r2.next_in_index
            int r8 = r7 + 1
            r2.next_in_index = r8
            byte r5 = r5[r7]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r5 = r5 << r14
            long r7 = (long) r5
            r11 = 16711680(0xff0000, double:8.256667E-317)
            long r7 = r7 & r11
            long r3 = r3 + r7
            r0.need = r3
            r3 = 4
            r0.mode = r3
            r3 = r6
        L_0x04d3:
            int r0 = r2.avail_in
            if (r0 != 0) goto L_0x04d8
            return r3
        L_0x04d8:
            r3 = 1
            int r0 = r0 - r3
            r2.avail_in = r0
            long r3 = r2.total_in
            long r3 = r3 + r18
            r2.total_in = r3
            org.jboss.netty.util.internal.jzlib.Inflate r0 = r2.istate
            long r3 = r0.need
            byte[] r5 = r2.next_in
            int r7 = r2.next_in_index
            int r8 = r7 + 1
            r2.next_in_index = r8
            byte r5 = r5[r7]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r5 = r5 << r10
            long r7 = (long) r5
            r10 = 65280(0xff00, double:3.22526E-319)
            long r7 = r7 & r10
            long r3 = r3 + r7
            r0.need = r3
            r0.mode = r13
        L_0x04fd:
            int r0 = r2.avail_in
            if (r0 != 0) goto L_0x0502
            return r6
        L_0x0502:
            r3 = 1
            int r0 = r0 - r3
            r2.avail_in = r0
            long r3 = r2.total_in
            long r3 = r3 + r18
            r2.total_in = r3
            org.jboss.netty.util.internal.jzlib.Inflate r0 = r2.istate
            long r3 = r0.need
            byte[] r5 = r2.next_in
            int r6 = r2.next_in_index
            int r7 = r6 + 1
            r2.next_in_index = r7
            byte r5 = r5[r6]
            long r5 = (long) r5
            r7 = 255(0xff, double:1.26E-321)
            long r5 = r5 & r7
            long r3 = r3 + r5
            r0.need = r3
            r2.adler = r3
            r0.mode = r9
            r0 = 2
            return r0
        L_0x0527:
            r0 = -2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.util.internal.jzlib.Inflate.inflate(org.jboss.netty.util.internal.jzlib.ZStream, int):int");
    }

    public int inflateEnd(ZStream zStream) {
        InfBlocks infBlocks = this.blocks;
        if (infBlocks != null) {
            infBlocks.free(zStream);
        }
        this.blocks = null;
        return 0;
    }

    public int inflateInit(ZStream zStream, int i, WrapperType wrapperType2) {
        Inflate inflate = null;
        zStream.msg = null;
        this.blocks = null;
        this.wrapperType = wrapperType2;
        if (i < 0) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("w: ", i));
        } else if (i < 8 || i > 15) {
            inflateEnd(zStream);
            return -2;
        } else {
            this.wbits = i;
            Inflate inflate2 = zStream.istate;
            if (inflate2.wrapperType != WrapperType.NONE) {
                inflate = this;
            }
            inflate2.blocks = new InfBlocks(zStream, inflate, 1 << i);
            inflateReset(zStream);
            return 0;
        }
    }

    public int inflateSetDictionary(ZStream zStream, byte[] bArr, int i) {
        int i2;
        int i3;
        if (zStream != null) {
            Inflate inflate = zStream.istate;
            if (inflate != null && inflate.mode == 6) {
                if (Adler32.adler32(1, bArr, 0, i) != zStream.adler) {
                    return -3;
                }
                zStream.adler = Adler32.adler32(0, null, 0, 0);
                int i4 = zStream.istate.wbits;
                if (i >= (1 << i4)) {
                    i3 = (1 << i4) - 1;
                    i2 = i - i3;
                } else {
                    i3 = i;
                    i2 = 0;
                }
                zStream.istate.blocks.set_dictionary(bArr, i2, i3);
                zStream.istate.mode = 7;
                return 0;
            }
        }
        return -2;
    }

    public int inflateSync(ZStream zStream) {
        if (zStream != null) {
            Inflate inflate = zStream.istate;
            if (inflate != null) {
                if (inflate.mode != 13) {
                    inflate.mode = 13;
                    inflate.marker = 0;
                }
                int i = zStream.avail_in;
                if (i == 0) {
                    return -5;
                }
                int i2 = zStream.next_in_index;
                int i3 = zStream.istate.marker;
                while (i != 0 && i3 < 4) {
                    byte[] bArr = zStream.next_in;
                    if (bArr[i2] == mark[i3]) {
                        i3++;
                    } else {
                        i3 = bArr[i2] != 0 ? 0 : 4 - i3;
                    }
                    i2++;
                    i--;
                }
                long j = zStream.total_in + ((long) (i2 - zStream.next_in_index));
                zStream.total_in = j;
                zStream.next_in_index = i2;
                zStream.avail_in = i;
                zStream.istate.marker = i3;
                if (i3 != 4) {
                    return -3;
                }
                long j2 = zStream.total_out;
                inflateReset(zStream);
                zStream.total_in = j;
                zStream.total_out = j2;
                zStream.istate.mode = 7;
                return 0;
            }
        }
        return -2;
    }
}
