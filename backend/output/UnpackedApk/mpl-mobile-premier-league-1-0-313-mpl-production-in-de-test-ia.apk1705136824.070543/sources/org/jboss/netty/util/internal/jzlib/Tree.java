package org.jboss.netty.util.internal.jzlib;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import org.apache.fontbox.ttf.GlyfDescript;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

public final class Tree {
    public static final byte[] _dist_code = {0, 1, 2, 3, 4, 4, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 0, 0, GlyfDescript.X_DUAL, 17, 18, 18, 19, 19, 20, 20, 20, 20, 21, 21, 21, 21, 22, 22, 22, 22, 22, 22, 22, 22, 23, 23, 23, 23, 23, 23, 23, 23, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29};
    public static final byte[] _length_code = {0, 1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 9, 10, 10, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 13, 13, 13, 13, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 15, 15, 15, 15, GlyfDescript.X_DUAL, GlyfDescript.X_DUAL, GlyfDescript.X_DUAL, GlyfDescript.X_DUAL, GlyfDescript.X_DUAL, GlyfDescript.X_DUAL, GlyfDescript.X_DUAL, GlyfDescript.X_DUAL, 17, 17, 17, 17, 17, 17, 17, 17, 18, 18, 18, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 19, 19, 19, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 28};
    public static final int[] base_dist = {0, 1, 2, 3, 4, 6, 8, 12, 16, 24, 32, 48, 64, 96, 128, 192, 256, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 512, GL20.GL_SRC_COLOR, 1024, 1536, 2048, 3072, 4096, GL30.GL_COLOR, 8192, 12288, 16384, 24576};
    public static final int[] base_length = {0, 1, 2, 3, 4, 5, 6, 7, 8, 10, 12, 14, 16, 20, 24, 28, 32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 0};
    public static final byte[] bl_order = {GlyfDescript.X_DUAL, 17, 18, 0, 8, 7, 9, 6, 10, 5, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 4, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 3, 13, 2, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 1, 15};
    public static final int[] extra_blbits = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 7};
    public static final int[] extra_dbits = {0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 13, 13};
    public static final int[] extra_lbits = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 0};
    public short[] dyn_tree;
    public int max_code;
    public StaticTree stat_desc;

    public static int bi_reverse(int i, int i2) {
        int i3 = 0;
        do {
            i >>>= 1;
            i3 = (i3 | (i & 1)) << 1;
            i2--;
        } while (i2 > 0);
        return i3 >>> 1;
    }

    public static int d_code(int i) {
        return i < 256 ? _dist_code[i] : _dist_code[(i >>> 7) + 256];
    }

    /* JADX WARNING: type inference failed for: r2v7, types: [short[]] */
    /* JADX WARNING: type inference failed for: r2v8, types: [short] */
    /* JADX WARNING: type inference failed for: r2v9, types: [int] */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r2v11, types: [int] */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* JADX WARNING: type inference failed for: r2v15 */
    /* JADX WARNING: type inference failed for: r2v16 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v10
      assigns: []
      uses: []
      mth insns count: 115
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void gen_bitlen(org.jboss.netty.util.internal.jzlib.Deflate r15) {
        /*
            r14 = this;
            short[] r0 = r14.dyn_tree
            org.jboss.netty.util.internal.jzlib.StaticTree r1 = r14.stat_desc
            short[] r2 = r1.static_tree
            int[] r3 = r1.extra_bits
            int r4 = r1.extra_base
            int r1 = r1.max_length
            r5 = 0
            r6 = 0
        L_0x000e:
            r7 = 15
            if (r6 > r7) goto L_0x0019
            short[] r7 = r15.bl_count
            r7[r6] = r5
            int r6 = r6 + 1
            goto L_0x000e
        L_0x0019:
            int[] r6 = r15.heap
            int r7 = r15.heap_max
            r6 = r6[r7]
            int r6 = r6 * 2
            int r6 = r6 + 1
            r0[r6] = r5
            int r7 = r7 + 1
            r6 = 0
        L_0x0028:
            r8 = 573(0x23d, float:8.03E-43)
            if (r7 >= r8) goto L_0x0074
            int[] r8 = r15.heap
            r8 = r8[r7]
            int r9 = r8 * 2
            int r10 = r9 + 1
            short r11 = r0[r10]
            int r11 = r11 * 2
            int r11 = r11 + 1
            short r11 = r0[r11]
            int r11 = r11 + 1
            if (r11 <= r1) goto L_0x0043
            int r6 = r6 + 1
            r11 = r1
        L_0x0043:
            short r12 = (short) r11
            r0[r10] = r12
            int r12 = r14.max_code
            if (r8 <= r12) goto L_0x004b
            goto L_0x0071
        L_0x004b:
            short[] r12 = r15.bl_count
            short r13 = r12[r11]
            int r13 = r13 + 1
            short r13 = (short) r13
            r12[r11] = r13
            if (r8 < r4) goto L_0x005a
            int r8 = r8 - r4
            r8 = r3[r8]
            goto L_0x005b
        L_0x005a:
            r8 = 0
        L_0x005b:
            short r9 = r0[r9]
            int r12 = r15.opt_len
            int r11 = r11 + r8
            int r11 = r11 * r9
            int r11 = r11 + r12
            r15.opt_len = r11
            if (r2 == 0) goto L_0x0071
            int r11 = r15.static_len
            short r10 = r2[r10]
            int r10 = r10 + r8
            int r10 = r10 * r9
            int r10 = r10 + r11
            r15.static_len = r10
        L_0x0071:
            int r7 = r7 + 1
            goto L_0x0028
        L_0x0074:
            if (r6 != 0) goto L_0x0077
            return
        L_0x0077:
            int r2 = r1 + -1
        L_0x0079:
            short[] r3 = r15.bl_count
            short r4 = r3[r2]
            if (r4 != 0) goto L_0x0082
            int r2 = r2 + -1
            goto L_0x0079
        L_0x0082:
            short r4 = r3[r2]
            int r4 = r4 + -1
            short r4 = (short) r4
            r3[r2] = r4
            int r2 = r2 + 1
            short r4 = r3[r2]
            int r4 = r4 + 2
            short r4 = (short) r4
            r3[r2] = r4
            short r2 = r3[r1]
            int r2 = r2 + -1
            short r2 = (short) r2
            r3[r1] = r2
            int r6 = r6 + -2
            if (r6 > 0) goto L_0x0077
        L_0x009d:
            if (r1 == 0) goto L_0x00d2
            short[] r2 = r15.bl_count
            short r2 = r2[r1]
        L_0x00a3:
            if (r2 == 0) goto L_0x00cf
            int[] r3 = r15.heap
            int r7 = r7 + -1
            r3 = r3[r7]
            int r4 = r14.max_code
            if (r3 <= r4) goto L_0x00b0
            goto L_0x00a3
        L_0x00b0:
            int r3 = r3 * 2
            int r4 = r3 + 1
            short r5 = r0[r4]
            if (r5 == r1) goto L_0x00cc
            int r5 = r15.opt_len
            long r5 = (long) r5
            long r8 = (long) r1
            short r10 = r0[r4]
            long r10 = (long) r10
            long r8 = r8 - r10
            short r3 = r0[r3]
            long r10 = (long) r3
            long r8 = r8 * r10
            long r8 = r8 + r5
            int r3 = (int) r8
            r15.opt_len = r3
            short r3 = (short) r1
            r0[r4] = r3
        L_0x00cc:
            int r2 = r2 + -1
            goto L_0x00a3
        L_0x00cf:
            int r1 = r1 + -1
            goto L_0x009d
        L_0x00d2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.util.internal.jzlib.Tree.gen_bitlen(org.jboss.netty.util.internal.jzlib.Deflate):void");
    }

    public static void gen_codes(short[] sArr, int i, short[] sArr2) {
        short[] sArr3 = new short[16];
        short s = 0;
        for (int i2 = 1; i2 <= 15; i2++) {
            s = (short) ((s + sArr2[i2 - 1]) << 1);
            sArr3[i2] = s;
        }
        for (int i3 = 0; i3 <= i; i3++) {
            int i4 = i3 * 2;
            short s2 = sArr[i4 + 1];
            if (s2 != 0) {
                short s3 = sArr3[s2];
                sArr3[s2] = (short) (s3 + 1);
                sArr[i4] = (short) bi_reverse(s3, s2);
            }
        }
    }

    public void build_tree(Deflate deflate) {
        int i;
        int i2;
        int i3;
        int i4;
        short[] sArr = this.dyn_tree;
        StaticTree staticTree = this.stat_desc;
        short[] sArr2 = staticTree.static_tree;
        int i5 = staticTree.elems;
        deflate.heap_len = 0;
        deflate.heap_max = JZlib.HEAP_SIZE;
        int i6 = -1;
        for (int i7 = 0; i7 < i5; i7++) {
            int i8 = i7 * 2;
            if (sArr[i8] != 0) {
                int[] iArr = deflate.heap;
                int i9 = deflate.heap_len + 1;
                deflate.heap_len = i9;
                iArr[i9] = i7;
                deflate.depth[i7] = 0;
                i6 = i7;
            } else {
                sArr[i8 + 1] = 0;
            }
        }
        while (true) {
            i = deflate.heap_len;
            if (i >= 2) {
                break;
            }
            int[] iArr2 = deflate.heap;
            int i10 = i + 1;
            deflate.heap_len = i10;
            if (i6 < 2) {
                i4 = i6 + 1;
                i3 = i4;
            } else {
                i3 = i6;
                i4 = 0;
            }
            iArr2[i10] = i4;
            int i11 = i4 * 2;
            sArr[i11] = 1;
            deflate.depth[i4] = 0;
            deflate.opt_len--;
            if (sArr2 != null) {
                deflate.static_len -= sArr2[i11 + 1];
            }
            i6 = i3;
        }
        this.max_code = i6;
        for (int i12 = i / 2; i12 >= 1; i12--) {
            deflate.pqdownheap(sArr, i12);
        }
        while (true) {
            int[] iArr3 = deflate.heap;
            int i13 = iArr3[1];
            deflate.heap_len = deflate.heap_len - 1;
            iArr3[1] = iArr3[i2];
            deflate.pqdownheap(sArr, 1);
            int[] iArr4 = deflate.heap;
            int i14 = iArr4[1];
            int i15 = deflate.heap_max - 1;
            deflate.heap_max = i15;
            iArr4[i15] = i13;
            int i16 = i15 - 1;
            deflate.heap_max = i16;
            iArr4[i16] = i14;
            int i17 = i13 * 2;
            int i18 = i14 * 2;
            sArr[i5 * 2] = (short) (sArr[i17] + sArr[i18]);
            byte[] bArr = deflate.depth;
            bArr[i5] = (byte) (Math.max(bArr[i13], bArr[i14]) + 1);
            short s = (short) i5;
            sArr[i18 + 1] = s;
            sArr[i17 + 1] = s;
            int i19 = i5 + 1;
            deflate.heap[1] = i5;
            deflate.pqdownheap(sArr, 1);
            if (deflate.heap_len < 2) {
                int[] iArr5 = deflate.heap;
                int i20 = deflate.heap_max - 1;
                deflate.heap_max = i20;
                iArr5[i20] = iArr5[1];
                gen_bitlen(deflate);
                gen_codes(sArr, i6, deflate.bl_count);
                return;
            }
            i5 = i19;
        }
    }
}
