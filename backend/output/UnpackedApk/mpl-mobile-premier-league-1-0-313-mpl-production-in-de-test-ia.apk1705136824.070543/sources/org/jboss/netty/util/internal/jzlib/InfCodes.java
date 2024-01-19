package org.jboss.netty.util.internal.jzlib;

import androidx.core.app.FrameMetricsAggregator;
import com.badlogic.gdx.graphics.g3d.particles.batches.BillboardParticleBatch;
import com.mpl.androidapp.utils.Constant;
import sfs2x.client.entities.invitation.InvitationReply;

public final class InfCodes {
    public static final int BADCODE = 9;
    public static final int COPY = 5;
    public static final int DIST = 3;
    public static final int DISTEXT = 4;
    public static final int END = 8;
    public static final int LEN = 1;
    public static final int LENEXT = 2;
    public static final int LIT = 6;
    public static final int START = 0;
    public static final int WASH = 7;
    public static final int[] inflate_mask = {0, 1, 3, 7, 15, 31, 63, 127, InvitationReply.EXPIRED, FrameMetricsAggregator.EVERY_DURATION, Constant.PERMISSIONS_REQUEST_AUDIO, 2047, 4095, BillboardParticleBatch.MAX_PARTICLES_PER_MESH, 16383, 32767, 65535};
    public byte dbits;
    public int dist;
    public int[] dtree;
    public int dtree_index;
    public int get;
    public byte lbits;
    public int len;
    public int lit;
    public int[] ltree;
    public int ltree_index;
    public int mode;
    public int need;
    public int[] tree;
    public int tree_index = 0;

    public int inflate_fast(int i, int i2, int[] iArr, int i3, int[] iArr2, int i4, InfBlocks infBlocks, ZStream zStream) {
        int i5;
        int i6;
        int i7;
        int i8;
        InfBlocks infBlocks2 = infBlocks;
        ZStream zStream2 = zStream;
        int i9 = zStream2.next_in_index;
        int i10 = zStream2.avail_in;
        int i11 = infBlocks2.bitb;
        int i12 = infBlocks2.bitk;
        int i13 = infBlocks2.write;
        int i14 = infBlocks2.read;
        int i15 = i13 < i14 ? (i14 - i13) - 1 : infBlocks2.end - i13;
        int[] iArr3 = inflate_mask;
        int i16 = iArr3[i];
        int i17 = iArr3[i2];
        while (true) {
            if (i12 >= 20) {
                int i18 = i11 & i16;
                int i19 = (i3 + i18) * 3;
                int i20 = iArr[i19];
                if (i20 == 0) {
                    int i21 = i19 + 1;
                    i11 >>= iArr[i21];
                    i12 -= iArr[i21];
                    i8 = i13 + 1;
                    infBlocks2.window[i13] = (byte) iArr[i19 + 2];
                } else {
                    do {
                        int i22 = i19 + 1;
                        i11 >>= iArr[i22];
                        i12 -= iArr[i22];
                        if ((i20 & 16) != 0) {
                            int i23 = i20 & 15;
                            int i24 = iArr[i19 + 2] + (inflate_mask[i23] & i11);
                            int i25 = i11 >> i23;
                            int i26 = i12 - i23;
                            while (i26 < 15) {
                                i10--;
                                i25 |= (zStream2.next_in[i9] & 255) << i26;
                                i26 += 8;
                                i9++;
                            }
                            int i27 = i25 & i17;
                            int i28 = (i4 + i27) * 3;
                            int i29 = iArr2[i28];
                            while (true) {
                                int i30 = i28 + 1;
                                i25 >>= iArr2[i30];
                                i26 -= iArr2[i30];
                                if ((i29 & 16) != 0) {
                                    int i31 = i29 & 15;
                                    int i32 = i9;
                                    int i33 = i10;
                                    while (i26 < i31) {
                                        i33--;
                                        i25 |= (zStream2.next_in[i32] & 255) << i26;
                                        i26 += 8;
                                        i32++;
                                    }
                                    int i34 = iArr2[i28 + 2] + (inflate_mask[i31] & i25);
                                    int i35 = i25 >> i31;
                                    int i36 = i26 - i31;
                                    int i37 = i15 - i24;
                                    if (i13 >= i34) {
                                        int i38 = i13 - i34;
                                        int i39 = i13 - i38;
                                        if (i39 <= 0 || 2 <= i39) {
                                            byte[] bArr = infBlocks2.window;
                                            System.arraycopy(bArr, i38, bArr, i13, 2);
                                            i13 += 2;
                                            i5 = i38 + 2;
                                        } else {
                                            byte[] bArr2 = infBlocks2.window;
                                            int i40 = i13 + 1;
                                            int i41 = i38 + 1;
                                            bArr2[i13] = bArr2[i38];
                                            i13 = i40 + 1;
                                            i5 = i41 + 1;
                                            bArr2[i40] = bArr2[i41];
                                        }
                                        i24 -= 2;
                                    } else {
                                        i5 = i13 - i34;
                                        do {
                                            i7 = infBlocks2.end;
                                            i5 += i7;
                                        } while (i5 < 0);
                                        int i42 = i7 - i5;
                                        if (i24 > i42) {
                                            i24 -= i42;
                                            int i43 = i13 - i5;
                                            if (i43 <= 0 || i42 <= i43) {
                                                byte[] bArr3 = infBlocks2.window;
                                                System.arraycopy(bArr3, i5, bArr3, i13, i42);
                                                i13 += i42;
                                            } else {
                                                while (true) {
                                                    byte[] bArr4 = infBlocks2.window;
                                                    int i44 = i5 + 1;
                                                    bArr4[i13] = bArr4[i5];
                                                    i42--;
                                                    i13++;
                                                    if (i42 == 0) {
                                                        break;
                                                    }
                                                    i5 = i44;
                                                }
                                            }
                                            i5 = 0;
                                        }
                                    }
                                    int i45 = i13 - i5;
                                    if (i45 <= 0 || i24 <= i45) {
                                        byte[] bArr5 = infBlocks2.window;
                                        System.arraycopy(bArr5, i5, bArr5, i13, i24);
                                        i13 += i24;
                                    } else {
                                        while (true) {
                                            byte[] bArr6 = infBlocks2.window;
                                            int i46 = i5 + 1;
                                            bArr6[i13] = bArr6[i5];
                                            i24--;
                                            i13++;
                                            if (i24 == 0) {
                                                break;
                                            }
                                            i5 = i46;
                                        }
                                    }
                                    i10 = i33;
                                    i9 = i32;
                                    i11 = i35;
                                    i12 = i36;
                                    i6 = i37;
                                } else if (i29 == false || !true) {
                                    i27 = i27 + iArr2[i28 + 2] + (inflate_mask[i29] & i25);
                                    i28 = (i4 + i27) * 3;
                                    i29 = iArr2[i28];
                                } else {
                                    zStream2.msg = "invalid distance code";
                                    int i47 = zStream2.avail_in - i10;
                                    int i48 = i26 >> 3;
                                    if (i48 < i47) {
                                        i47 = i48;
                                    }
                                    int i49 = i9 - i47;
                                    infBlocks2.bitb = i25;
                                    infBlocks2.bitk = i26 - (i47 << 3);
                                    zStream2.avail_in = i10 + i47;
                                    zStream2.total_in += (long) (i49 - zStream2.next_in_index);
                                    zStream2.next_in_index = i49;
                                    infBlocks2.write = i13;
                                    return -3;
                                }
                            }
                            if (i15 < 258 || i10 < 10) {
                                int i50 = zStream2.avail_in - i10;
                                int i51 = i12 >> 3;
                            }
                        } else if ((i20 & 64) == 0) {
                            i18 = i18 + iArr[i19 + 2] + (inflate_mask[i20] & i11);
                            i19 = (i3 + i18) * 3;
                            i20 = iArr[i19];
                        } else if ((i20 & 32) != 0) {
                            int i52 = zStream2.avail_in - i10;
                            int i53 = i12 >> 3;
                            if (i53 < i52) {
                                i52 = i53;
                            }
                            int i54 = i9 - i52;
                            infBlocks2.bitb = i11;
                            infBlocks2.bitk = i12 - (i52 << 3);
                            zStream2.avail_in = i10 + i52;
                            zStream2.total_in += (long) (i54 - zStream2.next_in_index);
                            zStream2.next_in_index = i54;
                            infBlocks2.write = i13;
                            return 1;
                        } else {
                            zStream2.msg = "invalid literal/length code";
                            int i55 = zStream2.avail_in - i10;
                            int i56 = i12 >> 3;
                            if (i56 < i55) {
                                i55 = i56;
                            }
                            int i57 = i9 - i55;
                            infBlocks2.bitb = i11;
                            infBlocks2.bitk = i12 - (i55 << 3);
                            zStream2.avail_in = i10 + i55;
                            zStream2.total_in += (long) (i57 - zStream2.next_in_index);
                            zStream2.next_in_index = i57;
                            infBlocks2.write = i13;
                            return -3;
                        }
                    } while (i20 != 0);
                    int i58 = i19 + 1;
                    i11 >>= iArr[i58];
                    i12 -= iArr[i58];
                    i8 = i13 + 1;
                    infBlocks2.window[i13] = (byte) iArr[i19 + 2];
                }
                i6 = i15 - 1;
                i13 = i8;
                if (i15 < 258) {
                    break;
                }
                break;
            }
            i10--;
            i11 |= (zStream2.next_in[i9] & 255) << i12;
            i12 += 8;
            i9++;
        }
        int i502 = zStream2.avail_in - i10;
        int i512 = i12 >> 3;
        if (i512 < i502) {
            i502 = i512;
        }
        int i59 = i9 - i502;
        infBlocks2.bitb = i11;
        infBlocks2.bitk = i12 - (i502 << 3);
        zStream2.avail_in = i10 + i502;
        zStream2.total_in += (long) (i59 - zStream2.next_in_index);
        zStream2.next_in_index = i59;
        infBlocks2.write = i13;
        return 0;
    }

    public void init(int i, int i2, int[] iArr, int i3, int[] iArr2, int i4) {
        this.mode = 0;
        this.lbits = (byte) i;
        this.dbits = (byte) i2;
        this.ltree = iArr;
        this.ltree_index = i3;
        this.dtree = iArr2;
        this.dtree_index = i4;
        this.tree = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0234, code lost:
        r10.bitb = r3;
        r10.bitk = r4;
        r11.avail_in = r2;
        r11.total_in += (long) (r1 - r11.next_in_index);
        r11.next_in_index = r1;
        r10.write = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x024c, code lost:
        return r10.inflate_flush(r11, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x024d, code lost:
        r8 = (r9.tree_index + (inflate_mask[r7] & r3)) * 3;
        r7 = r9.tree;
        r14 = r8 + 1;
        r3 = r3 >> r7[r14];
        r4 = r4 - r7[r14];
        r14 = r7[r8];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0266, code lost:
        if ((r14 & 16) == 0) goto L_0x0277;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0268, code lost:
        r9.get = r14 & 15;
        r9.dist = r7[r8 + 2];
        r9.mode = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0279, code lost:
        if ((r14 & 64) != 0) goto L_0x0288;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x027b, code lost:
        r9.need = r14;
        r9.tree_index = (r8 / 3) + r7[r8 + 2];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0288, code lost:
        r9.mode = 9;
        r11.msg = "invalid distance code";
        r10.bitb = r3;
        r10.bitk = r4;
        r11.avail_in = r2;
        r11.total_in += (long) (r1 - r11.next_in_index);
        r11.next_in_index = r1;
        r10.write = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x02a8, code lost:
        return r10.inflate_flush(r11, -3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0388, code lost:
        r13 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x014f, code lost:
        r7 = r5 - r9.dist;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0153, code lost:
        if (r7 >= 0) goto L_0x0159;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0155, code lost:
        r7 = r7 + r10.end;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x015b, code lost:
        if (r9.len == 0) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x015d, code lost:
        if (r6 != 0) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x015f, code lost:
        r8 = r10.end;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0161, code lost:
        if (r5 != r8) goto L_0x0172;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0163, code lost:
        r14 = r10.read;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0165, code lost:
        if (r14 == 0) goto L_0x0172;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0167, code lost:
        if (r14 <= 0) goto L_0x016e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0169, code lost:
        r6 = (r14 + 0) - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x016e, code lost:
        r6 = r8 + 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0171, code lost:
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0172, code lost:
        if (r6 != 0) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0174, code lost:
        r10.write = r5;
        r0 = r10.inflate_flush(r11, r0);
        r5 = r10.write;
        r6 = r10.read;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x017e, code lost:
        if (r5 >= r6) goto L_0x0183;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0180, code lost:
        r6 = (r6 - r5) - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0183, code lost:
        r6 = r10.end - r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0186, code lost:
        r8 = r10.end;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0188, code lost:
        if (r5 != r8) goto L_0x0198;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018a, code lost:
        r14 = r10.read;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x018c, code lost:
        if (r14 == 0) goto L_0x0198;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x018e, code lost:
        if (r14 <= 0) goto L_0x0194;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0190, code lost:
        r14 = (r14 + 0) - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0194, code lost:
        r14 = r8 + 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0196, code lost:
        r6 = r14;
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0198, code lost:
        if (r6 != 0) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x019a, code lost:
        r10.bitb = r3;
        r10.bitk = r4;
        r11.avail_in = r2;
        r11.total_in += (long) (r1 - r11.next_in_index);
        r11.next_in_index = r1;
        r10.write = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01b2, code lost:
        return r10.inflate_flush(r11, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01b3, code lost:
        r8 = r10.window;
        r14 = r5 + 1;
        r15 = r7 + 1;
        r8[r5] = r8[r7];
        r6 = r6 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01c1, code lost:
        if (r15 != r10.end) goto L_0x01c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01c3, code lost:
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01c5, code lost:
        r7 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01c6, code lost:
        r9.len--;
        r5 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01cd, code lost:
        r9.mode = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x021d, code lost:
        r7 = r9.need;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x021f, code lost:
        if (r4 >= r7) goto L_0x024d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0221, code lost:
        if (r2 == 0) goto L_0x0234;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0223, code lost:
        r2 = r2 - 1;
        r3 = r3 | ((r11.next_in[r1] & 255) << r4);
        r4 = r4 + 8;
        r1 = r1 + 1;
        r0 = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int proc(org.jboss.netty.util.internal.jzlib.InfBlocks r19, org.jboss.netty.util.internal.jzlib.ZStream r20, int r21) {
        /*
            r18 = this;
            r9 = r18
            r10 = r19
            r11 = r20
            int r0 = r11.next_in_index
            int r1 = r11.avail_in
            int r2 = r10.bitb
            int r3 = r10.bitk
            int r4 = r10.write
            int r5 = r10.read
            r12 = 1
            if (r4 >= r5) goto L_0x0018
            int r5 = r5 - r4
            int r5 = r5 - r12
            goto L_0x001b
        L_0x0018:
            int r5 = r10.end
            int r5 = r5 - r4
        L_0x001b:
            r13 = 0
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            r1 = r0
            r0 = r21
        L_0x0024:
            int r7 = r9.mode
            r15 = -3
            r8 = 7
            r14 = 3
            switch(r7) {
                case 0: goto L_0x02ab;
                case 1: goto L_0x02a9;
                case 2: goto L_0x01d1;
                case 3: goto L_0x021d;
                case 4: goto L_0x0110;
                case 5: goto L_0x014f;
                case 6: goto L_0x00a9;
                case 7: goto L_0x005f;
                case 8: goto L_0x0090;
                case 9: goto L_0x0046;
                default: goto L_0x002c;
            }
        L_0x002c:
            r0 = -2
            r10.bitb = r3
            r10.bitk = r4
            r11.avail_in = r2
            long r2 = r11.total_in
            int r4 = r11.next_in_index
            int r4 = r1 - r4
            long r6 = (long) r4
            long r2 = r2 + r6
            r11.total_in = r2
            r11.next_in_index = r1
            r10.write = r5
            int r0 = r10.inflate_flush(r11, r0)
            return r0
        L_0x0046:
            r10.bitb = r3
            r10.bitk = r4
            r11.avail_in = r2
            long r2 = r11.total_in
            int r0 = r11.next_in_index
            int r0 = r1 - r0
            long r6 = (long) r0
            long r2 = r2 + r6
            r11.total_in = r2
            r11.next_in_index = r1
            r10.write = r5
            int r0 = r10.inflate_flush(r11, r15)
            return r0
        L_0x005f:
            if (r4 <= r8) goto L_0x0067
            int r4 = r4 + -8
            int r2 = r2 + 1
            int r1 = r1 + -1
        L_0x0067:
            r10.write = r5
            int r0 = r10.inflate_flush(r11, r0)
            int r5 = r10.write
            int r6 = r10.read
            if (r6 == r5) goto L_0x008c
            r10.bitb = r3
            r10.bitk = r4
            r11.avail_in = r2
            long r2 = r11.total_in
            int r4 = r11.next_in_index
            int r4 = r1 - r4
            long r6 = (long) r4
            long r2 = r2 + r6
            r11.total_in = r2
            r11.next_in_index = r1
            r10.write = r5
            int r0 = r10.inflate_flush(r11, r0)
            return r0
        L_0x008c:
            r0 = 8
            r9.mode = r0
        L_0x0090:
            r10.bitb = r3
            r10.bitk = r4
            r11.avail_in = r2
            long r2 = r11.total_in
            int r0 = r11.next_in_index
            int r0 = r1 - r0
            long r6 = (long) r0
            long r2 = r2 + r6
            r11.total_in = r2
            r11.next_in_index = r1
            r10.write = r5
            int r0 = r10.inflate_flush(r11, r12)
            return r0
        L_0x00a9:
            if (r6 != 0) goto L_0x00ff
            int r7 = r10.end
            if (r5 != r7) goto L_0x00be
            int r8 = r10.read
            if (r8 == 0) goto L_0x00be
            if (r8 <= 0) goto L_0x00ba
            int r8 = r8 + 0
            int r8 = r8 - r12
            r6 = r8
            goto L_0x00bd
        L_0x00ba:
            int r7 = r7 + 0
            r6 = r7
        L_0x00bd:
            r5 = 0
        L_0x00be:
            if (r6 != 0) goto L_0x00ff
            r10.write = r5
            int r0 = r10.inflate_flush(r11, r0)
            int r5 = r10.write
            int r6 = r10.read
            if (r5 >= r6) goto L_0x00cf
            int r6 = r6 - r5
            int r6 = r6 - r12
            goto L_0x00d2
        L_0x00cf:
            int r6 = r10.end
            int r6 = r6 - r5
        L_0x00d2:
            int r7 = r10.end
            if (r5 != r7) goto L_0x00e4
            int r8 = r10.read
            if (r8 == 0) goto L_0x00e4
            if (r8 <= 0) goto L_0x00e0
            int r8 = r8 + 0
            int r8 = r8 - r12
            goto L_0x00e2
        L_0x00e0:
            int r8 = r7 + 0
        L_0x00e2:
            r6 = r8
            r5 = 0
        L_0x00e4:
            if (r6 != 0) goto L_0x00ff
            r10.bitb = r3
            r10.bitk = r4
            r11.avail_in = r2
            long r2 = r11.total_in
            int r4 = r11.next_in_index
            int r4 = r1 - r4
            long r6 = (long) r4
            long r2 = r2 + r6
            r11.total_in = r2
            r11.next_in_index = r1
            r10.write = r5
            int r0 = r10.inflate_flush(r11, r0)
            return r0
        L_0x00ff:
            byte[] r0 = r10.window
            int r7 = r5 + 1
            int r8 = r9.lit
            byte r8 = (byte) r8
            r0[r5] = r8
            int r6 = r6 + -1
            r9.mode = r13
            r5 = r7
            r0 = 0
            goto L_0x0024
        L_0x0110:
            int r7 = r9.get
        L_0x0112:
            if (r4 >= r7) goto L_0x0140
            if (r2 == 0) goto L_0x0127
            int r2 = r2 + -1
            byte[] r0 = r11.next_in
            int r8 = r1 + 1
            byte r0 = r0[r1]
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r0 = r0 << r4
            r3 = r3 | r0
            int r4 = r4 + 8
            r1 = r8
            r0 = 0
            goto L_0x0112
        L_0x0127:
            r10.bitb = r3
            r10.bitk = r4
            r11.avail_in = r2
            long r2 = r11.total_in
            int r4 = r11.next_in_index
            int r4 = r1 - r4
            long r6 = (long) r4
            long r2 = r2 + r6
            r11.total_in = r2
            r11.next_in_index = r1
            r10.write = r5
            int r0 = r10.inflate_flush(r11, r0)
            return r0
        L_0x0140:
            int r8 = r9.dist
            int[] r14 = inflate_mask
            r14 = r14[r7]
            r14 = r14 & r3
            int r8 = r8 + r14
            r9.dist = r8
            int r3 = r3 >> r7
            int r4 = r4 - r7
            r7 = 5
            r9.mode = r7
        L_0x014f:
            int r7 = r9.dist
            int r7 = r5 - r7
        L_0x0153:
            if (r7 >= 0) goto L_0x0159
            int r8 = r10.end
            int r7 = r7 + r8
            goto L_0x0153
        L_0x0159:
            int r8 = r9.len
            if (r8 == 0) goto L_0x01cd
            if (r6 != 0) goto L_0x01b3
            int r8 = r10.end
            if (r5 != r8) goto L_0x0172
            int r14 = r10.read
            if (r14 == 0) goto L_0x0172
            if (r14 <= 0) goto L_0x016e
            int r14 = r14 + 0
            int r14 = r14 - r12
            r6 = r14
            goto L_0x0171
        L_0x016e:
            int r8 = r8 + 0
            r6 = r8
        L_0x0171:
            r5 = 0
        L_0x0172:
            if (r6 != 0) goto L_0x01b3
            r10.write = r5
            int r0 = r10.inflate_flush(r11, r0)
            int r5 = r10.write
            int r6 = r10.read
            if (r5 >= r6) goto L_0x0183
            int r6 = r6 - r5
            int r6 = r6 - r12
            goto L_0x0186
        L_0x0183:
            int r6 = r10.end
            int r6 = r6 - r5
        L_0x0186:
            int r8 = r10.end
            if (r5 != r8) goto L_0x0198
            int r14 = r10.read
            if (r14 == 0) goto L_0x0198
            if (r14 <= 0) goto L_0x0194
            int r14 = r14 + 0
            int r14 = r14 - r12
            goto L_0x0196
        L_0x0194:
            int r14 = r8 + 0
        L_0x0196:
            r6 = r14
            r5 = 0
        L_0x0198:
            if (r6 != 0) goto L_0x01b3
            r10.bitb = r3
            r10.bitk = r4
            r11.avail_in = r2
            long r2 = r11.total_in
            int r4 = r11.next_in_index
            int r4 = r1 - r4
            long r6 = (long) r4
            long r2 = r2 + r6
            r11.total_in = r2
            r11.next_in_index = r1
            r10.write = r5
            int r0 = r10.inflate_flush(r11, r0)
            return r0
        L_0x01b3:
            byte[] r8 = r10.window
            int r14 = r5 + 1
            int r15 = r7 + 1
            byte r7 = r8[r7]
            r8[r5] = r7
            int r6 = r6 + -1
            int r5 = r10.end
            if (r15 != r5) goto L_0x01c5
            r7 = 0
            goto L_0x01c6
        L_0x01c5:
            r7 = r15
        L_0x01c6:
            int r5 = r9.len
            int r5 = r5 - r12
            r9.len = r5
            r5 = r14
            goto L_0x0159
        L_0x01cd:
            r9.mode = r13
            goto L_0x0024
        L_0x01d1:
            int r7 = r9.get
        L_0x01d3:
            if (r4 >= r7) goto L_0x0201
            if (r2 == 0) goto L_0x01e8
            int r2 = r2 + -1
            byte[] r0 = r11.next_in
            int r8 = r1 + 1
            byte r0 = r0[r1]
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r0 = r0 << r4
            r3 = r3 | r0
            int r4 = r4 + 8
            r1 = r8
            r0 = 0
            goto L_0x01d3
        L_0x01e8:
            r10.bitb = r3
            r10.bitk = r4
            r11.avail_in = r2
            long r2 = r11.total_in
            int r4 = r11.next_in_index
            int r4 = r1 - r4
            long r6 = (long) r4
            long r2 = r2 + r6
            r11.total_in = r2
            r11.next_in_index = r1
            r10.write = r5
            int r0 = r10.inflate_flush(r11, r0)
            return r0
        L_0x0201:
            int r8 = r9.len
            int[] r16 = inflate_mask
            r16 = r16[r7]
            r16 = r3 & r16
            int r8 = r8 + r16
            r9.len = r8
            int r3 = r3 >> r7
            int r4 = r4 - r7
            byte r7 = r9.dbits
            r9.need = r7
            int[] r7 = r9.dtree
            r9.tree = r7
            int r7 = r9.dtree_index
            r9.tree_index = r7
            r9.mode = r14
        L_0x021d:
            int r7 = r9.need
        L_0x021f:
            if (r4 >= r7) goto L_0x024d
            if (r2 == 0) goto L_0x0234
            int r2 = r2 + -1
            byte[] r0 = r11.next_in
            int r8 = r1 + 1
            byte r0 = r0[r1]
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r0 = r0 << r4
            r3 = r3 | r0
            int r4 = r4 + 8
            r1 = r8
            r0 = 0
            goto L_0x021f
        L_0x0234:
            r10.bitb = r3
            r10.bitk = r4
            r11.avail_in = r2
            long r2 = r11.total_in
            int r4 = r11.next_in_index
            int r4 = r1 - r4
            long r6 = (long) r4
            long r2 = r2 + r6
            r11.total_in = r2
            r11.next_in_index = r1
            r10.write = r5
            int r0 = r10.inflate_flush(r11, r0)
            return r0
        L_0x024d:
            int r8 = r9.tree_index
            int[] r16 = inflate_mask
            r7 = r16[r7]
            r7 = r7 & r3
            int r8 = r8 + r7
            int r8 = r8 * 3
            int[] r7 = r9.tree
            int r14 = r8 + 1
            r16 = r7[r14]
            int r3 = r3 >> r16
            r14 = r7[r14]
            int r4 = r4 - r14
            r14 = r7[r8]
            r16 = r14 & 16
            if (r16 == 0) goto L_0x0277
            r14 = r14 & 15
            r9.get = r14
            int r8 = r8 + 2
            r7 = r7[r8]
            r9.dist = r7
            r7 = 4
            r9.mode = r7
            goto L_0x0024
        L_0x0277:
            r16 = r14 & 64
            if (r16 != 0) goto L_0x0288
            r9.need = r14
            int r14 = r8 / 3
            int r8 = r8 + 2
            r7 = r7[r8]
            int r14 = r14 + r7
            r9.tree_index = r14
            goto L_0x0024
        L_0x0288:
            r0 = 9
            r9.mode = r0
            java.lang.String r0 = "invalid distance code"
            r11.msg = r0
            r10.bitb = r3
            r10.bitk = r4
            r11.avail_in = r2
            long r2 = r11.total_in
            int r0 = r11.next_in_index
            int r0 = r1 - r0
            long r6 = (long) r0
            long r2 = r2 + r6
            r11.total_in = r2
            r11.next_in_index = r1
            r10.write = r5
            int r0 = r10.inflate_flush(r11, r15)
            return r0
        L_0x02a9:
            r13 = 7
            goto L_0x030d
        L_0x02ab:
            r7 = 258(0x102, float:3.62E-43)
            if (r6 < r7) goto L_0x02fe
            r7 = 10
            if (r2 < r7) goto L_0x02fe
            r10.bitb = r3
            r10.bitk = r4
            r11.avail_in = r2
            long r2 = r11.total_in
            int r0 = r11.next_in_index
            int r0 = r1 - r0
            long r6 = (long) r0
            long r2 = r2 + r6
            r11.total_in = r2
            r11.next_in_index = r1
            r10.write = r5
            byte r1 = r9.lbits
            byte r2 = r9.dbits
            int[] r3 = r9.ltree
            int r4 = r9.ltree_index
            int[] r5 = r9.dtree
            int r6 = r9.dtree_index
            r0 = r18
            r7 = r19
            r13 = 7
            r8 = r20
            int r0 = r0.inflate_fast(r1, r2, r3, r4, r5, r6, r7, r8)
            int r1 = r11.next_in_index
            int r2 = r11.avail_in
            int r3 = r10.bitb
            int r4 = r10.bitk
            int r5 = r10.write
            int r6 = r10.read
            if (r5 >= r6) goto L_0x02ef
            int r6 = r6 - r5
            int r6 = r6 - r12
            goto L_0x02f2
        L_0x02ef:
            int r6 = r10.end
            int r6 = r6 - r5
        L_0x02f2:
            if (r0 == 0) goto L_0x02ff
            if (r0 != r12) goto L_0x02f8
            r14 = 7
            goto L_0x02fa
        L_0x02f8:
            r14 = 9
        L_0x02fa:
            r9.mode = r14
            goto L_0x0388
        L_0x02fe:
            r13 = 7
        L_0x02ff:
            byte r7 = r9.lbits
            r9.need = r7
            int[] r7 = r9.ltree
            r9.tree = r7
            int r7 = r9.ltree_index
            r9.tree_index = r7
            r9.mode = r12
        L_0x030d:
            int r7 = r9.need
        L_0x030f:
            if (r4 >= r7) goto L_0x033d
            if (r2 == 0) goto L_0x0324
            int r2 = r2 + -1
            byte[] r0 = r11.next_in
            int r8 = r1 + 1
            byte r0 = r0[r1]
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r0 = r0 << r4
            r3 = r3 | r0
            int r4 = r4 + 8
            r1 = r8
            r0 = 0
            goto L_0x030f
        L_0x0324:
            r10.bitb = r3
            r10.bitk = r4
            r11.avail_in = r2
            long r2 = r11.total_in
            int r4 = r11.next_in_index
            int r4 = r1 - r4
            long r6 = (long) r4
            long r2 = r2 + r6
            r11.total_in = r2
            r11.next_in_index = r1
            r10.write = r5
            int r0 = r10.inflate_flush(r11, r0)
            return r0
        L_0x033d:
            int r8 = r9.tree_index
            int[] r17 = inflate_mask
            r7 = r17[r7]
            r7 = r7 & r3
            int r8 = r8 + r7
            int r8 = r8 * 3
            int[] r7 = r9.tree
            int r14 = r8 + 1
            r17 = r7[r14]
            int r3 = r3 >>> r17
            r14 = r7[r14]
            int r4 = r4 - r14
            r14 = r7[r8]
            if (r14 != 0) goto L_0x0360
            int r8 = r8 + 2
            r7 = r7[r8]
            r9.lit = r7
            r7 = 6
            r9.mode = r7
            goto L_0x0388
        L_0x0360:
            r17 = r14 & 16
            if (r17 == 0) goto L_0x0372
            r13 = r14 & 15
            r9.get = r13
            int r8 = r8 + 2
            r7 = r7[r8]
            r9.len = r7
            r7 = 2
            r9.mode = r7
            goto L_0x0388
        L_0x0372:
            r17 = r14 & 64
            if (r17 != 0) goto L_0x0382
            r9.need = r14
            int r13 = r8 / 3
            int r8 = r8 + 2
            r7 = r7[r8]
            int r13 = r13 + r7
            r9.tree_index = r13
            goto L_0x0388
        L_0x0382:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x038b
            r9.mode = r13
        L_0x0388:
            r13 = 0
            goto L_0x0024
        L_0x038b:
            r0 = 9
            r9.mode = r0
            java.lang.String r0 = "invalid literal/length code"
            r11.msg = r0
            r10.bitb = r3
            r10.bitk = r4
            r11.avail_in = r2
            long r2 = r11.total_in
            int r0 = r11.next_in_index
            int r0 = r1 - r0
            long r6 = (long) r0
            long r2 = r2 + r6
            r11.total_in = r2
            r11.next_in_index = r1
            r10.write = r5
            int r0 = r10.inflate_flush(r11, r15)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.util.internal.jzlib.InfCodes.proc(org.jboss.netty.util.internal.jzlib.InfBlocks, org.jboss.netty.util.internal.jzlib.ZStream, int):int");
    }
}
