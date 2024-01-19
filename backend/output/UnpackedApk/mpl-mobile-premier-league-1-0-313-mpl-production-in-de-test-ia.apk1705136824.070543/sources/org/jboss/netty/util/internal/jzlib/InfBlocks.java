package org.jboss.netty.util.internal.jzlib;

import androidx.core.app.FrameMetricsAggregator;
import com.badlogic.gdx.graphics.g3d.particles.batches.BillboardParticleBatch;
import com.mpl.androidapp.utils.Constant;
import sfs2x.client.entities.invitation.InvitationReply;

public final class InfBlocks {
    public static final int BAD = 9;
    public static final int BTREE = 4;
    public static final int CODES = 6;
    public static final int DONE = 8;
    public static final int DRY = 7;
    public static final int DTREE = 5;
    public static final int LENS = 1;
    public static final int STORED = 2;
    public static final int TABLE = 3;
    public static final int TYPE = 0;
    public static final int[] border = {16, 17, 18, 0, 8, 7, 9, 6, 10, 5, 11, 4, 12, 3, 13, 2, 14, 1, 15};
    public static final int[] inflate_mask = {0, 1, 3, 7, 15, 31, 63, 127, InvitationReply.EXPIRED, FrameMetricsAggregator.EVERY_DURATION, Constant.PERMISSIONS_REQUEST_AUDIO, 2047, 4095, BillboardParticleBatch.MAX_PARTICLES_PER_MESH, 16383, 32767, 65535};
    public final int[] bb = new int[1];
    public int bitb;
    public int bitk;
    public int[] blens;
    public long check;
    public final Object checkfn;
    public final InfCodes codes = new InfCodes();
    public final int end;
    public int[] hufts = new int[4320];
    public int index;
    public final InfTree inftree = new InfTree();
    public int last;
    public int left;
    public int mode;
    public int read;
    public int table;
    public final int[] tb = new int[1];
    public byte[] window;
    public int write;

    public InfBlocks(ZStream zStream, Object obj, int i) {
        this.window = new byte[i];
        this.end = i;
        this.checkfn = obj;
        this.mode = 0;
        reset(zStream, null);
    }

    public void free(ZStream zStream) {
        reset(zStream, null);
        this.window = null;
        this.hufts = null;
    }

    public int inflate_flush(ZStream zStream, int i) {
        int i2 = zStream.next_out_index;
        int i3 = this.read;
        int i4 = this.write;
        if (i3 > i4) {
            i4 = this.end;
        }
        int i5 = i4 - i3;
        int i6 = zStream.avail_out;
        if (i5 > i6) {
            i5 = i6;
        }
        if (i5 != 0 && i == -5) {
            i = 0;
        }
        zStream.avail_out -= i5;
        zStream.total_out += (long) i5;
        if (this.checkfn != null) {
            long adler32 = Adler32.adler32(this.check, this.window, i3, i5);
            this.check = adler32;
            zStream.adler = adler32;
        }
        System.arraycopy(this.window, i3, zStream.next_out, i2, i5);
        int i7 = i2 + i5;
        int i8 = i3 + i5;
        int i9 = this.end;
        if (i8 == i9) {
            if (this.write == i9) {
                this.write = 0;
            }
            int i10 = this.write - 0;
            int i11 = zStream.avail_out;
            if (i10 > i11) {
                i10 = i11;
            }
            if (i10 != 0 && i == -5) {
                i = 0;
            }
            zStream.avail_out -= i10;
            zStream.total_out += (long) i10;
            if (this.checkfn != null) {
                long adler322 = Adler32.adler32(this.check, this.window, 0, i10);
                this.check = adler322;
                zStream.adler = adler322;
            }
            System.arraycopy(this.window, 0, zStream.next_out, i7, i10);
            i7 += i10;
            i8 = i10 + 0;
        }
        zStream.next_out_index = i7;
        this.read = i8;
        return i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0340, code lost:
        r3 = r3 - 1;
        r12 = r12 | ((r11.next_in[r15] & 255) << r13);
        r13 = r13 + 8;
        r15 = r15 + 1;
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0351, code lost:
        r0.bitb = r12;
        r0.bitk = r13;
        r11.avail_in = r3;
        r11.total_in += (long) (r15 - r11.next_in_index);
        r11.next_in_index = r15;
        r0.write = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0369, code lost:
        return inflate_flush(r11, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x036a, code lost:
        r10 = r12 >>> r17;
        r5 = r5 + (inflate_mask[r6] & r10);
        r10 = r10 >>> r6;
        r13 = (r13 - r17) - r6;
        r6 = r0.index;
        r12 = r0.table;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0387, code lost:
        if ((r6 + r5) > (((r12 & 31) + 258) + ((r12 >> 5) & 31))) goto L_0x03b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x038b, code lost:
        if (r1 != 16) goto L_0x0391;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x038e, code lost:
        if (r6 >= 1) goto L_0x0391;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0391, code lost:
        if (r1 != 16) goto L_0x039a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0393, code lost:
        r1 = r0.blens[r6 - 1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x039a, code lost:
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x039b, code lost:
        r12 = r6 + 1;
        r0.blens[r6] = r1;
        r5 = r5 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x03a2, code lost:
        if (r5 != 0) goto L_0x03b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x03a4, code lost:
        r0.index = r12;
        r12 = r2;
        r4 = r10;
        r10 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x03a9, code lost:
        r14 = r8;
        r7 = r13;
        r13 = 0;
        r8 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x03b0, code lost:
        r6 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x03b2, code lost:
        r0.blens = null;
        r0.mode = 9;
        r11.msg = "invalid bit length repeat";
        r0.bitb = r10;
        r0.bitk = r13;
        r11.avail_in = r3;
        r11.total_in += (long) (r15 - r11.next_in_index);
        r11.next_in_index = r15;
        r0.write = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x03d4, code lost:
        return inflate_flush(r11, -3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006b, code lost:
        r7 = r1;
        r15 = r2;
        r6 = r3;
        r33 = r5;
        r5 = r4;
        r4 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a4, code lost:
        r6 = r4 & 16383;
        r0.table = r6;
        r7 = r6 & 31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00ac, code lost:
        if (r7 > 29) goto L_0x03d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00ae, code lost:
        r6 = (r6 >> 5) & 31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b2, code lost:
        if (r6 <= 29) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b6, code lost:
        r7 = (r7 + 258) + r6;
        r6 = r0.blens;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00bb, code lost:
        if (r6 == null) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00be, code lost:
        if (r6.length >= r7) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c1, code lost:
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c2, code lost:
        if (r6 >= r7) goto L_0x00cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c4, code lost:
        r0.blens[r6] = r13;
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00cb, code lost:
        r0.blens = new int[r7];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00cf, code lost:
        r4 = r4 >>> 14;
        r5 = r5 - 14;
        r0.index = r13;
        r0.mode = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00df, code lost:
        if (r0.index >= ((r0.table >>> 10) + r8)) goto L_0x0125;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e1, code lost:
        if (r4 >= 3) goto L_0x010f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e3, code lost:
        if (r6 == 0) goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00e5, code lost:
        r6 = r6 - 1;
        r5 = r5 | ((r11.next_in[r15] & 255) << r4);
        r4 = r4 + 8;
        r15 = r15 + 1;
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00f6, code lost:
        r0.bitb = r5;
        r0.bitk = r4;
        r11.avail_in = r6;
        r11.total_in += (long) (r15 - r11.next_in_index);
        r11.next_in_index = r15;
        r0.write = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x010e, code lost:
        return inflate_flush(r11, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x010f, code lost:
        r1 = r0.blens;
        r2 = border;
        r3 = r0.index;
        r0.index = r3 + 1;
        r1[r2[r3]] = r5 & 7;
        r5 = r5 >>> 3;
        r4 = r4 - 3;
        r8 = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0125, code lost:
        r1 = r0.index;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0129, code lost:
        if (r1 >= 19) goto L_0x0138;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x012b, code lost:
        r2 = r0.blens;
        r3 = border;
        r0.index = r1 + 1;
        r2[r3[r1]] = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0138, code lost:
        r3 = r0.bb;
        r3[r13] = 7;
        r12 = r4;
        r8 = r5;
        r10 = r6;
        r1 = r0.inftree.inflate_trees_bits(r0.blens, r3, r0.tb, r0.hufts, r35);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x014f, code lost:
        if (r1 == 0) goto L_0x0173;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0151, code lost:
        if (r1 != -3) goto L_0x015a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0153, code lost:
        r0.blens = null;
        r0.mode = 9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x015a, code lost:
        r0.bitb = r8;
        r0.bitk = r12;
        r11.avail_in = r10;
        r11.total_in += (long) (r15 - r11.next_in_index);
        r11.next_in_index = r15;
        r0.write = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0172, code lost:
        return inflate_flush(r11, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0173, code lost:
        r0.index = r13;
        r0.mode = 5;
        r33 = r12;
        r12 = r7;
        r7 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x017d, code lost:
        r1 = r0.table;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x018b, code lost:
        if (r0.index < (((r1 & 31) + 258) + ((r1 >> 5) & 31))) goto L_0x02af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x018d, code lost:
        r0.tb[r13] = -1;
        r6 = new int[1];
        r5 = new int[1];
        r6[r13] = 9;
        r5[r13] = 6;
        r13 = new int[1];
        r19 = new int[1];
        r22 = r5;
        r23 = r6;
        r24 = r12;
        r12 = r8;
        r8 = r13;
        r36 = r13;
        r20 = r14;
        r13 = r7;
        r25 = r10;
        r1 = r0.inftree.inflate_trees_dynamic((r1 & 31) + org.apache.commons.net.ftp.FTPReply.PATHNAME_CREATED, ((r1 >> 5) & 31) + 1, r0.blens, r6, r22, r19, r8, r0.hufts, r35);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01db, code lost:
        if (r1 == 0) goto L_0x0203;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01dd, code lost:
        if (r1 != -3) goto L_0x01e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01df, code lost:
        r0.blens = null;
        r0.mode = 9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01e6, code lost:
        r0.bitb = r12;
        r0.bitk = r13;
        r11.avail_in = r25;
        r11.total_in += (long) (r15 - r11.next_in_index);
        r11.next_in_index = r15;
        r0.write = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0202, code lost:
        return inflate_flush(r11, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0203, code lost:
        r8 = r20;
        r3 = r25;
        r1 = r0.codes;
        r27 = r23[0];
        r28 = r22[0];
        r4 = r0.hufts;
        r1.init(r27, r28, r4, r19[0], r4, r36[0]);
        r0.mode = 6;
        r4 = r12;
        r5 = r13;
        r2 = r15;
        r1 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0225, code lost:
        r0.bitb = r4;
        r0.bitk = r5;
        r11.avail_in = r3;
        r11.total_in += (long) (r2 - r11.next_in_index);
        r11.next_in_index = r2;
        r0.write = r8;
        r1 = r0.codes.proc(r0, r11, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0240, code lost:
        if (r1 == 1) goto L_0x0247;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0246, code lost:
        return inflate_flush(r11, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0247, code lost:
        r1 = r11.next_in_index;
        r3 = r11.avail_in;
        r4 = r0.bitb;
        r5 = r0.bitk;
        r14 = r0.write;
        r6 = r0.read;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0253, code lost:
        if (r14 >= r6) goto L_0x0258;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0255, code lost:
        r6 = (r6 - r14) - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0258, code lost:
        r6 = r0.end - r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x025e, code lost:
        if (r0.last != 0) goto L_0x0267;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0260, code lost:
        r0.mode = 0;
        r2 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0264, code lost:
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0267, code lost:
        r0.mode = 7;
        r2 = r1;
        r13 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x026c, code lost:
        r0.write = r14;
        r1 = inflate_flush(r11, r13);
        r14 = r0.write;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0276, code lost:
        if (r0.read == r14) goto L_0x0291;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0278, code lost:
        r0.bitb = r4;
        r0.bitk = r5;
        r11.avail_in = r3;
        r11.total_in += (long) (r2 - r11.next_in_index);
        r11.next_in_index = r2;
        r0.write = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0290, code lost:
        return inflate_flush(r11, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0291, code lost:
        r0.mode = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0295, code lost:
        r0.bitb = r4;
        r0.bitk = r5;
        r11.avail_in = r3;
        r11.total_in += (long) (r2 - r11.next_in_index);
        r11.next_in_index = r2;
        r0.write = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x02ae, code lost:
        return inflate_flush(r11, 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x02af, code lost:
        r13 = r7;
        r3 = r10;
        r24 = r12;
        r12 = r8;
        r8 = r14;
        r1 = r0.bb[0];
        r2 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x02c1, code lost:
        if (r13 >= r1) goto L_0x02ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x02c3, code lost:
        if (r3 == 0) goto L_0x02d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x02c5, code lost:
        r3 = r3 - 1;
        r12 = r12 | ((r11.next_in[r15] & 255) << r13);
        r13 = r13 + 8;
        r15 = r15 + 1;
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x02d6, code lost:
        r0.bitb = r12;
        r0.bitk = r13;
        r11.avail_in = r3;
        r11.total_in += (long) (r15 - r11.next_in_index);
        r11.next_in_index = r15;
        r0.write = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x02ee, code lost:
        return inflate_flush(r11, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x02ef, code lost:
        r5 = r0.tb;
        r17 = r5[0];
        r10 = r0.hufts;
        r17 = r5[0];
        r20 = inflate_mask;
        r17 = r10[((r17 + (r20[r1] & r12)) * 3) + 1];
        r1 = r10[((r5[0] + (r20[r17] & r12)) * 3) + 2];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0316, code lost:
        if (r1 >= 16) goto L_0x032c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0318, code lost:
        r4 = r12 >>> r17;
        r13 = r13 - r17;
        r5 = r0.blens;
        r6 = r0.index;
        r0.index = r6 + 1;
        r5[r6] = r1;
        r12 = r2;
        r10 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x032e, code lost:
        if (r1 != 18) goto L_0x0332;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0330, code lost:
        r6 = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0332, code lost:
        r6 = r1 - 14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0334, code lost:
        if (r1 != 18) goto L_0x0339;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0336, code lost:
        r5 = 11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0339, code lost:
        r5 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x033c, code lost:
        if (r13 >= (r17 + r6)) goto L_0x036a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x033e, code lost:
        if (r3 == 0) goto L_0x0351;
     */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x042f  */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x045a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int proc(org.jboss.netty.util.internal.jzlib.ZStream r35, int r36) {
        /*
            r34 = this;
            r0 = r34
            r11 = r35
            int r1 = r11.next_in_index
            int r2 = r11.avail_in
            int r3 = r0.bitb
            int r4 = r0.bitk
            int r5 = r0.write
            int r6 = r0.read
            r12 = 1
            if (r5 >= r6) goto L_0x0016
            int r6 = r6 - r5
            int r6 = r6 - r12
            goto L_0x0019
        L_0x0016:
            int r6 = r0.end
            int r6 = r6 - r5
        L_0x0019:
            r13 = 0
            r14 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            r1 = r36
        L_0x0021:
            int r7 = r0.mode
            r8 = 4
            r12 = 7
            r9 = -3
            r10 = 3
            switch(r7) {
                case 0: goto L_0x050d;
                case 1: goto L_0x049b;
                case 2: goto L_0x03f9;
                case 3: goto L_0x0074;
                case 4: goto L_0x006b;
                case 5: goto L_0x0064;
                case 6: goto L_0x0061;
                case 7: goto L_0x005e;
                case 8: goto L_0x0295;
                case 9: goto L_0x0045;
                default: goto L_0x002a;
            }
        L_0x002a:
            r8 = r14
            r1 = -2
            r0.bitb = r4
            r0.bitk = r5
            r11.avail_in = r3
            long r3 = r11.total_in
            int r5 = r11.next_in_index
            int r5 = r2 - r5
            long r5 = (long) r5
            long r3 = r3 + r5
            r11.total_in = r3
            r11.next_in_index = r2
            r0.write = r8
            int r1 = r0.inflate_flush(r11, r1)
            return r1
        L_0x0045:
            r0.bitb = r4
            r0.bitk = r5
            r11.avail_in = r3
            long r3 = r11.total_in
            int r1 = r11.next_in_index
            int r1 = r2 - r1
            long r5 = (long) r1
            long r3 = r3 + r5
            r11.total_in = r3
            r11.next_in_index = r2
            r0.write = r14
            int r1 = r0.inflate_flush(r11, r9)
            return r1
        L_0x005e:
            r13 = r1
            goto L_0x026c
        L_0x0061:
            r8 = r14
            goto L_0x0225
        L_0x0064:
            r12 = r1
            r15 = r2
            r10 = r3
            r8 = r4
            r7 = r5
            goto L_0x017d
        L_0x006b:
            r7 = r1
            r15 = r2
            r6 = r3
            r33 = r5
            r5 = r4
            r4 = r33
            goto L_0x00d8
        L_0x0074:
            r6 = 14
            if (r5 >= r6) goto L_0x00a4
            if (r3 == 0) goto L_0x008b
            int r3 = r3 + -1
            byte[] r1 = r11.next_in
            int r6 = r2 + 1
            byte r1 = r1[r2]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r5
            r4 = r4 | r1
            int r5 = r5 + 8
            r2 = r6
            r1 = 0
            goto L_0x0074
        L_0x008b:
            r0.bitb = r4
            r0.bitk = r5
            r11.avail_in = r3
            long r3 = r11.total_in
            int r5 = r11.next_in_index
            int r5 = r2 - r5
            long r5 = (long) r5
            long r3 = r3 + r5
            r11.total_in = r3
            r11.next_in_index = r2
            r0.write = r14
            int r1 = r0.inflate_flush(r11, r1)
            return r1
        L_0x00a4:
            r6 = r4 & 16383(0x3fff, float:2.2957E-41)
            r0.table = r6
            r7 = r6 & 31
            r15 = 29
            if (r7 > r15) goto L_0x03d5
            int r6 = r6 >> 5
            r6 = r6 & 31
            if (r6 <= r15) goto L_0x00b6
            goto L_0x03d5
        L_0x00b6:
            int r7 = r7 + 258
            int r7 = r7 + r6
            int[] r6 = r0.blens
            if (r6 == 0) goto L_0x00cb
            int r6 = r6.length
            if (r6 >= r7) goto L_0x00c1
            goto L_0x00cb
        L_0x00c1:
            r6 = 0
        L_0x00c2:
            if (r6 >= r7) goto L_0x00cf
            int[] r15 = r0.blens
            r15[r6] = r13
            int r6 = r6 + 1
            goto L_0x00c2
        L_0x00cb:
            int[] r6 = new int[r7]
            r0.blens = r6
        L_0x00cf:
            int r4 = r4 >>> 14
            int r5 = r5 + -14
            r0.index = r13
            r0.mode = r8
            goto L_0x006b
        L_0x00d8:
            int r1 = r0.index
            int r2 = r0.table
            int r2 = r2 >>> 10
            int r2 = r2 + r8
            if (r1 >= r2) goto L_0x0125
        L_0x00e1:
            if (r4 >= r10) goto L_0x010f
            if (r6 == 0) goto L_0x00f6
            int r6 = r6 + -1
            byte[] r1 = r11.next_in
            int r2 = r15 + 1
            byte r1 = r1[r15]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r4
            r5 = r5 | r1
            int r4 = r4 + 8
            r15 = r2
            r7 = 0
            goto L_0x00e1
        L_0x00f6:
            r0.bitb = r5
            r0.bitk = r4
            r11.avail_in = r6
            long r1 = r11.total_in
            int r3 = r11.next_in_index
            int r3 = r15 - r3
            long r3 = (long) r3
            long r1 = r1 + r3
            r11.total_in = r1
            r11.next_in_index = r15
            r0.write = r14
            int r1 = r0.inflate_flush(r11, r7)
            return r1
        L_0x010f:
            int[] r1 = r0.blens
            int[] r2 = border
            int r3 = r0.index
            int r8 = r3 + 1
            r0.index = r8
            r2 = r2[r3]
            r3 = r5 & 7
            r1[r2] = r3
            int r5 = r5 >>> 3
            int r4 = r4 + -3
            r8 = 4
            goto L_0x00d8
        L_0x0125:
            int r1 = r0.index
            r2 = 19
            if (r1 >= r2) goto L_0x0138
            int[] r2 = r0.blens
            int[] r3 = border
            int r8 = r1 + 1
            r0.index = r8
            r1 = r3[r1]
            r2[r1] = r13
            goto L_0x0125
        L_0x0138:
            int[] r3 = r0.bb
            r3[r13] = r12
            org.jboss.netty.util.internal.jzlib.InfTree r1 = r0.inftree
            int[] r2 = r0.blens
            int[] r8 = r0.tb
            int[] r10 = r0.hufts
            r12 = r4
            r4 = r8
            r8 = r5
            r5 = r10
            r10 = r6
            r6 = r35
            int r1 = r1.inflate_trees_bits(r2, r3, r4, r5, r6)
            if (r1 == 0) goto L_0x0173
            if (r1 != r9) goto L_0x015a
            r2 = 0
            r0.blens = r2
            r2 = 9
            r0.mode = r2
        L_0x015a:
            r0.bitb = r8
            r0.bitk = r12
            r11.avail_in = r10
            long r2 = r11.total_in
            int r4 = r11.next_in_index
            int r4 = r15 - r4
            long r4 = (long) r4
            long r2 = r2 + r4
            r11.total_in = r2
            r11.next_in_index = r15
            r0.write = r14
            int r1 = r0.inflate_flush(r11, r1)
            return r1
        L_0x0173:
            r0.index = r13
            r1 = 5
            r0.mode = r1
            r33 = r12
            r12 = r7
            r7 = r33
        L_0x017d:
            int r1 = r0.table
            int r2 = r0.index
            r3 = r1 & 31
            int r3 = r3 + 258
            int r4 = r1 >> 5
            r4 = r4 & 31
            int r3 = r3 + r4
            r4 = -1
            if (r2 < r3) goto L_0x02af
            int[] r2 = r0.tb
            r2[r13] = r4
            r2 = 1
            int[] r6 = new int[r2]
            int[] r5 = new int[r2]
            int[] r4 = new int[r2]
            int[] r3 = new int[r2]
            r16 = 9
            r6[r13] = r16
            r17 = 6
            r5[r13] = r17
            org.jboss.netty.util.internal.jzlib.InfTree r9 = r0.inftree
            r13 = r1 & 31
            int r13 = r13 + 257
            int r1 = r1 >> 5
            r1 = r1 & 31
            int r19 = r1 + 1
            int[] r2 = r0.blens
            int[] r1 = r0.hufts
            r21 = r1
            r1 = r9
            r9 = r2
            r2 = r13
            r13 = r3
            r3 = r19
            r19 = r4
            r4 = r9
            r22 = r5
            r5 = r6
            r23 = r6
            r6 = r22
            r9 = r7
            r7 = r19
            r24 = r12
            r12 = r8
            r8 = r13
            r36 = r13
            r20 = r14
            r14 = -3
            r13 = r9
            r9 = r21
            r25 = r10
            r10 = r35
            int r1 = r1.inflate_trees_dynamic(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            if (r1 == 0) goto L_0x0203
            if (r1 != r14) goto L_0x01e6
            r2 = 0
            r0.blens = r2
            r7 = 9
            r0.mode = r7
        L_0x01e6:
            r0.bitb = r12
            r0.bitk = r13
            r3 = r25
            r11.avail_in = r3
            long r2 = r11.total_in
            int r4 = r11.next_in_index
            int r4 = r15 - r4
            long r4 = (long) r4
            long r2 = r2 + r4
            r11.total_in = r2
            r11.next_in_index = r15
            r8 = r20
            r0.write = r8
            int r1 = r0.inflate_flush(r11, r1)
            return r1
        L_0x0203:
            r8 = r20
            r3 = r25
            org.jboss.netty.util.internal.jzlib.InfCodes r1 = r0.codes
            r2 = 0
            r27 = r23[r2]
            r28 = r22[r2]
            int[] r4 = r0.hufts
            r30 = r19[r2]
            r32 = r36[r2]
            r26 = r1
            r29 = r4
            r31 = r4
            r26.init(r27, r28, r29, r30, r31, r32)
            r9 = 6
            r0.mode = r9
            r4 = r12
            r5 = r13
            r2 = r15
            r1 = r24
        L_0x0225:
            r0.bitb = r4
            r0.bitk = r5
            r11.avail_in = r3
            long r3 = r11.total_in
            int r5 = r11.next_in_index
            int r5 = r2 - r5
            long r5 = (long) r5
            long r3 = r3 + r5
            r11.total_in = r3
            r11.next_in_index = r2
            r0.write = r8
            org.jboss.netty.util.internal.jzlib.InfCodes r2 = r0.codes
            int r1 = r2.proc(r0, r11, r1)
            r2 = 1
            if (r1 == r2) goto L_0x0247
            int r1 = r0.inflate_flush(r11, r1)
            return r1
        L_0x0247:
            int r1 = r11.next_in_index
            int r3 = r11.avail_in
            int r4 = r0.bitb
            int r5 = r0.bitk
            int r14 = r0.write
            int r6 = r0.read
            if (r14 >= r6) goto L_0x0258
            int r6 = r6 - r14
            int r6 = r6 - r2
            goto L_0x025c
        L_0x0258:
            int r2 = r0.end
            int r2 = r2 - r14
            r6 = r2
        L_0x025c:
            int r2 = r0.last
            if (r2 != 0) goto L_0x0267
            r2 = 0
            r0.mode = r2
            r2 = r1
        L_0x0264:
            r1 = 0
            goto L_0x05b6
        L_0x0267:
            r10 = 7
            r0.mode = r10
            r2 = r1
            r13 = 0
        L_0x026c:
            r0.write = r14
            int r1 = r0.inflate_flush(r11, r13)
            int r14 = r0.write
            int r6 = r0.read
            if (r6 == r14) goto L_0x0291
            r0.bitb = r4
            r0.bitk = r5
            r11.avail_in = r3
            long r3 = r11.total_in
            int r5 = r11.next_in_index
            int r5 = r2 - r5
            long r5 = (long) r5
            long r3 = r3 + r5
            r11.total_in = r3
            r11.next_in_index = r2
            r0.write = r14
            int r1 = r0.inflate_flush(r11, r1)
            return r1
        L_0x0291:
            r1 = 8
            r0.mode = r1
        L_0x0295:
            r0.bitb = r4
            r0.bitk = r5
            r11.avail_in = r3
            long r3 = r11.total_in
            int r1 = r11.next_in_index
            int r1 = r2 - r1
            long r5 = (long) r1
            long r3 = r3 + r5
            r11.total_in = r3
            r11.next_in_index = r2
            r0.write = r14
            r1 = 1
            int r1 = r0.inflate_flush(r11, r1)
            return r1
        L_0x02af:
            r13 = r7
            r3 = r10
            r24 = r12
            r7 = 9
            r9 = 6
            r10 = 7
            r12 = r8
            r8 = r14
            r14 = -3
            int[] r1 = r0.bb
            r2 = 0
            r1 = r1[r2]
            r2 = r24
        L_0x02c1:
            if (r13 >= r1) goto L_0x02ef
            if (r3 == 0) goto L_0x02d6
            int r3 = r3 + -1
            byte[] r2 = r11.next_in
            int r5 = r15 + 1
            byte r2 = r2[r15]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r13
            r12 = r12 | r2
            int r13 = r13 + 8
            r15 = r5
            r2 = 0
            goto L_0x02c1
        L_0x02d6:
            r0.bitb = r12
            r0.bitk = r13
            r11.avail_in = r3
            long r3 = r11.total_in
            int r1 = r11.next_in_index
            int r1 = r15 - r1
            long r5 = (long) r1
            long r3 = r3 + r5
            r11.total_in = r3
            r11.next_in_index = r15
            r0.write = r8
            int r1 = r0.inflate_flush(r11, r2)
            return r1
        L_0x02ef:
            int[] r5 = r0.tb
            r6 = 0
            r17 = r5[r6]
            int[] r10 = r0.hufts
            r17 = r5[r6]
            int[] r20 = inflate_mask
            r1 = r20[r1]
            r1 = r1 & r12
            int r17 = r17 + r1
            r1 = 3
            int r17 = r17 * 3
            r18 = 1
            int r17 = r17 + 1
            r17 = r10[r17]
            r5 = r5[r6]
            r6 = r20[r17]
            r6 = r6 & r12
            int r5 = r5 + r6
            int r5 = r5 * 3
            r1 = 2
            int r5 = r5 + r1
            r1 = r10[r5]
            r5 = 16
            if (r1 >= r5) goto L_0x032c
            int r4 = r12 >>> r17
            int r13 = r13 - r17
            int[] r5 = r0.blens
            int r6 = r0.index
            int r10 = r6 + 1
            r0.index = r10
            r5[r6] = r1
            r12 = r2
            r10 = r3
            r17 = 5
            goto L_0x03a9
        L_0x032c:
            r5 = 18
            if (r1 != r5) goto L_0x0332
            r6 = 7
            goto L_0x0334
        L_0x0332:
            int r6 = r1 + -14
        L_0x0334:
            if (r1 != r5) goto L_0x0339
            r5 = 11
            goto L_0x033a
        L_0x0339:
            r5 = 3
        L_0x033a:
            int r10 = r17 + r6
            if (r13 >= r10) goto L_0x036a
            if (r3 == 0) goto L_0x0351
            int r3 = r3 + -1
            byte[] r2 = r11.next_in
            int r10 = r15 + 1
            byte r2 = r2[r15]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r13
            r12 = r12 | r2
            int r13 = r13 + 8
            r15 = r10
            r2 = 0
            goto L_0x033a
        L_0x0351:
            r0.bitb = r12
            r0.bitk = r13
            r11.avail_in = r3
            long r3 = r11.total_in
            int r1 = r11.next_in_index
            int r1 = r15 - r1
            long r5 = (long) r1
            long r3 = r3 + r5
            r11.total_in = r3
            r11.next_in_index = r15
            r0.write = r8
            int r1 = r0.inflate_flush(r11, r2)
            return r1
        L_0x036a:
            int r10 = r12 >>> r17
            int r13 = r13 - r17
            int[] r12 = inflate_mask
            r12 = r12[r6]
            r12 = r12 & r10
            int r5 = r5 + r12
            int r10 = r10 >>> r6
            int r13 = r13 - r6
            int r6 = r0.index
            int r12 = r0.table
            int r9 = r6 + r5
            r14 = r12 & 31
            int r14 = r14 + 258
            r17 = 5
            int r12 = r12 >> 5
            r12 = r12 & 31
            int r14 = r14 + r12
            if (r9 > r14) goto L_0x03b2
            r9 = 16
            if (r1 != r9) goto L_0x0391
            r12 = 1
            if (r6 >= r12) goto L_0x0391
            goto L_0x03b2
        L_0x0391:
            if (r1 != r9) goto L_0x039a
            int[] r1 = r0.blens
            int r9 = r6 + -1
            r1 = r1[r9]
            goto L_0x039b
        L_0x039a:
            r1 = 0
        L_0x039b:
            int[] r9 = r0.blens
            int r12 = r6 + 1
            r9[r6] = r1
            int r5 = r5 + r4
            if (r5 != 0) goto L_0x03b0
            r0.index = r12
            r12 = r2
            r4 = r10
            r10 = r3
        L_0x03a9:
            r14 = r8
            r7 = r13
            r9 = -3
            r13 = 0
            r8 = r4
            goto L_0x017d
        L_0x03b0:
            r6 = r12
            goto L_0x039b
        L_0x03b2:
            r1 = 0
            r0.blens = r1
            r0.mode = r7
            java.lang.String r1 = "invalid bit length repeat"
            r11.msg = r1
            r0.bitb = r10
            r0.bitk = r13
            r11.avail_in = r3
            long r1 = r11.total_in
            int r3 = r11.next_in_index
            int r3 = r15 - r3
            long r3 = (long) r3
            long r1 = r1 + r3
            r11.total_in = r1
            r11.next_in_index = r15
            r0.write = r8
            r1 = -3
            int r1 = r0.inflate_flush(r11, r1)
            return r1
        L_0x03d5:
            r8 = r14
            r7 = 9
            r0.mode = r7
            java.lang.String r1 = "too many length or distance symbols"
            r11.msg = r1
            r0.bitb = r4
            r0.bitk = r5
            r11.avail_in = r3
            long r3 = r11.total_in
            int r1 = r11.next_in_index
            int r1 = r2 - r1
            long r5 = (long) r1
            long r3 = r3 + r5
            r11.total_in = r3
            r11.next_in_index = r2
            r0.write = r8
            r1 = -3
            int r1 = r0.inflate_flush(r11, r1)
            return r1
        L_0x03f9:
            r8 = r14
            if (r3 != 0) goto L_0x0415
            r0.bitb = r4
            r0.bitk = r5
            r11.avail_in = r3
            long r3 = r11.total_in
            int r5 = r11.next_in_index
            int r5 = r2 - r5
            long r5 = (long) r5
            long r3 = r3 + r5
            r11.total_in = r3
            r11.next_in_index = r2
            r0.write = r8
            int r1 = r0.inflate_flush(r11, r1)
            return r1
        L_0x0415:
            if (r6 != 0) goto L_0x0473
            int r7 = r0.end
            if (r8 != r7) goto L_0x042c
            int r9 = r0.read
            if (r9 == 0) goto L_0x042c
            if (r9 <= 0) goto L_0x0427
            int r9 = r9 + 0
            r6 = 1
            int r9 = r9 - r6
            r6 = r9
            goto L_0x042a
        L_0x0427:
            int r7 = r7 + 0
            r6 = r7
        L_0x042a:
            r14 = 0
            goto L_0x042d
        L_0x042c:
            r14 = r8
        L_0x042d:
            if (r6 != 0) goto L_0x0474
            r0.write = r14
            int r1 = r0.inflate_flush(r11, r1)
            int r6 = r0.write
            int r7 = r0.read
            if (r6 >= r7) goto L_0x043f
            int r7 = r7 - r6
            r8 = 1
            int r7 = r7 - r8
            goto L_0x0442
        L_0x043f:
            int r7 = r0.end
            int r7 = r7 - r6
        L_0x0442:
            int r8 = r0.end
            if (r6 != r8) goto L_0x0456
            int r9 = r0.read
            if (r9 == 0) goto L_0x0456
            if (r9 <= 0) goto L_0x0451
            int r9 = r9 + 0
            r6 = 1
            int r9 = r9 - r6
            goto L_0x0453
        L_0x0451:
            int r9 = r8 + 0
        L_0x0453:
            r6 = r9
            r14 = 0
            goto L_0x0458
        L_0x0456:
            r14 = r6
            r6 = r7
        L_0x0458:
            if (r6 != 0) goto L_0x0474
            r0.bitb = r4
            r0.bitk = r5
            r11.avail_in = r3
            long r3 = r11.total_in
            int r5 = r11.next_in_index
            int r5 = r2 - r5
            long r5 = (long) r5
            long r3 = r3 + r5
            r11.total_in = r3
            r11.next_in_index = r2
            r0.write = r14
            int r1 = r0.inflate_flush(r11, r1)
            return r1
        L_0x0473:
            r14 = r8
        L_0x0474:
            int r1 = r0.left
            if (r1 <= r3) goto L_0x0479
            r1 = r3
        L_0x0479:
            if (r1 <= r6) goto L_0x047c
            r1 = r6
        L_0x047c:
            byte[] r7 = r11.next_in
            byte[] r8 = r0.window
            java.lang.System.arraycopy(r7, r2, r8, r14, r1)
            int r2 = r2 + r1
            int r3 = r3 - r1
            int r14 = r14 + r1
            int r6 = r6 - r1
            int r7 = r0.left
            int r7 = r7 - r1
            r0.left = r7
            if (r7 == 0) goto L_0x0490
            goto L_0x0264
        L_0x0490:
            int r1 = r0.last
            if (r1 == 0) goto L_0x0496
            r12 = 7
            goto L_0x0497
        L_0x0496:
            r12 = 0
        L_0x0497:
            r0.mode = r12
            goto L_0x0264
        L_0x049b:
            r8 = r14
            r7 = 9
        L_0x049e:
            r9 = 32
            if (r5 >= r9) goto L_0x04ce
            if (r3 == 0) goto L_0x04b5
            int r3 = r3 + -1
            byte[] r1 = r11.next_in
            int r9 = r2 + 1
            byte r1 = r1[r2]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r5
            r4 = r4 | r1
            int r5 = r5 + 8
            r2 = r9
            r1 = 0
            goto L_0x049e
        L_0x04b5:
            r0.bitb = r4
            r0.bitk = r5
            r11.avail_in = r3
            long r3 = r11.total_in
            int r5 = r11.next_in_index
            int r5 = r2 - r5
            long r5 = (long) r5
            long r3 = r3 + r5
            r11.total_in = r3
            r11.next_in_index = r2
            r0.write = r8
            int r1 = r0.inflate_flush(r11, r1)
            return r1
        L_0x04ce:
            int r9 = ~r4
            r10 = 16
            int r9 = r9 >>> r10
            r10 = 65535(0xffff, float:9.1834E-41)
            r9 = r9 & r10
            r10 = r10 & r4
            if (r9 == r10) goto L_0x04f9
            r0.mode = r7
            java.lang.String r1 = "invalid stored block lengths"
            r11.msg = r1
            r0.bitb = r4
            r0.bitk = r5
            r11.avail_in = r3
            long r3 = r11.total_in
            int r1 = r11.next_in_index
            int r1 = r2 - r1
            long r5 = (long) r1
            long r3 = r3 + r5
            r11.total_in = r3
            r11.next_in_index = r2
            r0.write = r8
            r1 = -3
            int r1 = r0.inflate_flush(r11, r1)
            return r1
        L_0x04f9:
            r0.left = r10
            if (r10 == 0) goto L_0x04ff
            r9 = 2
            goto L_0x0506
        L_0x04ff:
            int r4 = r0.last
            if (r4 == 0) goto L_0x0505
            r9 = 7
            goto L_0x0506
        L_0x0505:
            r9 = 0
        L_0x0506:
            r0.mode = r9
            r14 = r8
            r4 = 0
            r5 = 0
            goto L_0x05b6
        L_0x050d:
            r8 = r14
            r7 = 9
        L_0x0510:
            r9 = 3
            if (r5 >= r9) goto L_0x053f
            if (r3 == 0) goto L_0x0526
            int r3 = r3 + -1
            byte[] r1 = r11.next_in
            int r9 = r2 + 1
            byte r1 = r1[r2]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r5
            r4 = r4 | r1
            int r5 = r5 + 8
            r2 = r9
            r1 = 0
            goto L_0x0510
        L_0x0526:
            r0.bitb = r4
            r0.bitk = r5
            r11.avail_in = r3
            long r3 = r11.total_in
            int r5 = r11.next_in_index
            int r5 = r2 - r5
            long r5 = (long) r5
            long r3 = r3 + r5
            r11.total_in = r3
            r11.next_in_index = r2
            r0.write = r8
            int r1 = r0.inflate_flush(r11, r1)
            return r1
        L_0x053f:
            r9 = r4 & 7
            r10 = r9 & 1
            r0.last = r10
            r10 = 1
            int r9 = r9 >>> r10
            if (r9 == 0) goto L_0x05a9
            if (r9 == r10) goto L_0x0580
            r10 = 2
            if (r9 == r10) goto L_0x0578
            r10 = 3
            if (r9 == r10) goto L_0x0554
        L_0x0551:
            r7 = 1
            r14 = 0
            goto L_0x05b5
        L_0x0554:
            int r1 = r4 >>> 3
            r4 = -3
            int r5 = r5 + r4
            r0.mode = r7
            java.lang.String r4 = "invalid block type"
            r11.msg = r4
            r0.bitb = r1
            r0.bitk = r5
            r11.avail_in = r3
            long r3 = r11.total_in
            int r1 = r11.next_in_index
            int r1 = r2 - r1
            long r5 = (long) r1
            long r3 = r3 + r5
            r11.total_in = r3
            r11.next_in_index = r2
            r0.write = r8
            r1 = -3
            int r1 = r0.inflate_flush(r11, r1)
            return r1
        L_0x0578:
            int r4 = r4 >>> 3
            int r5 = r5 + -3
            r7 = 3
            r0.mode = r7
            goto L_0x0551
        L_0x0580:
            r7 = 1
            int[] r9 = new int[r7]
            int[] r10 = new int[r7]
            int[][] r12 = new int[r7][]
            int[][] r13 = new int[r7][]
            org.jboss.netty.util.internal.jzlib.InfTree.inflate_trees_fixed(r9, r10, r12, r13)
            org.jboss.netty.util.internal.jzlib.InfCodes r7 = r0.codes
            r14 = 0
            r27 = r9[r14]
            r28 = r10[r14]
            r29 = r12[r14]
            r30 = 0
            r31 = r13[r14]
            r32 = 0
            r26 = r7
            r26.init(r27, r28, r29, r30, r31, r32)
            int r4 = r4 >>> 3
            int r5 = r5 + -3
            r7 = 6
            r0.mode = r7
            r7 = 1
            goto L_0x05b5
        L_0x05a9:
            r14 = 0
            int r4 = r4 >>> 3
            int r5 = r5 + -3
            r7 = r5 & 7
            int r4 = r4 >>> r7
            int r5 = r5 - r7
            r7 = 1
            r0.mode = r7
        L_0x05b5:
            r14 = r8
        L_0x05b6:
            r12 = 1
            r13 = 0
            goto L_0x0021
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.util.internal.jzlib.InfBlocks.proc(org.jboss.netty.util.internal.jzlib.ZStream, int):int");
    }

    public void reset(ZStream zStream, long[] jArr) {
        if (jArr != null) {
            jArr[0] = this.check;
        }
        this.mode = 0;
        this.bitk = 0;
        this.bitb = 0;
        this.write = 0;
        this.read = 0;
        if (this.checkfn != null) {
            long adler32 = Adler32.adler32(0, null, 0, 0);
            this.check = adler32;
            zStream.adler = adler32;
        }
    }

    public void set_dictionary(byte[] bArr, int i, int i2) {
        System.arraycopy(bArr, i, this.window, 0, i2);
        this.write = i2;
        this.read = i2;
    }

    public int sync_point() {
        return this.mode == 1 ? 1 : 0;
    }
}
