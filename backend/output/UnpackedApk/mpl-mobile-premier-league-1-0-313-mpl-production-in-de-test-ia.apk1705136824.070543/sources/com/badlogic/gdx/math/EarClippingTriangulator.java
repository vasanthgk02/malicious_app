package com.badlogic.gdx.math;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.ShortArray;

public class EarClippingTriangulator {
    public short[] indices;
    public final ShortArray indicesArray = new ShortArray();
    public final ShortArray triangles = new ShortArray();
    public int vertexCount;
    public final IntArray vertexTypes = new IntArray();
    public float[] vertices;

    public static int computeSpannedAreaSign(float f2, float f3, float f4, float f5, float f6, float f7) {
        return (int) Math.signum(((f5 - f3) * f6) + GeneratedOutlineSupport.outline3(f3, f7, f4, (f7 - f5) * f2));
    }

    public final int classifyVertex(int i) {
        short[] sArr = this.indices;
        int i2 = sArr[previousIndex(i)] * 2;
        int i3 = sArr[i] * 2;
        int i4 = sArr[(i + 1) % this.vertexCount] * 2;
        float[] fArr = this.vertices;
        return computeSpannedAreaSign(fArr[i2], fArr[i2 + 1], fArr[i3], fArr[i3 + 1], fArr[i4], fArr[i4 + 1]);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0069 A[LOOP:3: B:17:0x0067->B:18:0x0069, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01c3 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.badlogic.gdx.utils.ShortArray computeTriangles(float[] r27) {
        /*
            r26 = this;
            r0 = r26
            r1 = r27
            int r2 = r1.length
            r0.vertices = r1
            int r3 = r2 / 2
            r0.vertexCount = r3
            com.badlogic.gdx.utils.ShortArray r4 = r0.indicesArray
            r5 = 0
            r4.size = r5
            r4.ensureCapacity(r3)
            r4.size = r3
            short[] r4 = r4.items
            r0.indices = r4
            r6 = 2
            r7 = 1
            if (r2 > r6) goto L_0x001e
            goto L_0x0042
        L_0x001e:
            int r2 = r2 + r5
            int r2 = r2 - r6
            r8 = r1[r2]
            int r9 = r2 + 1
            r9 = r1[r9]
            r10 = 0
            r11 = 0
            r12 = 0
        L_0x0029:
            if (r11 > r2) goto L_0x003c
            r13 = r1[r11]
            int r14 = r11 + 1
            r14 = r1[r14]
            float r8 = r8 * r14
            float r9 = r9 * r13
            float r8 = r8 - r9
            float r12 = r12 + r8
            int r11 = r11 + 2
            r8 = r13
            r9 = r14
            goto L_0x0029
        L_0x003c:
            int r1 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r1 >= 0) goto L_0x0042
            r1 = 1
            goto L_0x0043
        L_0x0042:
            r1 = 0
        L_0x0043:
            if (r1 == 0) goto L_0x0051
            r1 = 0
        L_0x0046:
            if (r1 >= r3) goto L_0x005f
            int r2 = r5 + r1
            short r2 = (short) r2
            r4[r1] = r2
            int r1 = r1 + 1
            short r1 = (short) r1
            goto L_0x0046
        L_0x0051:
            int r1 = r3 + -1
            r2 = 0
        L_0x0054:
            if (r2 >= r3) goto L_0x005f
            int r8 = r5 + r1
            int r8 = r8 - r2
            short r8 = (short) r8
            r4[r2] = r8
            int r2 = r2 + 1
            goto L_0x0054
        L_0x005f:
            com.badlogic.gdx.utils.IntArray r1 = r0.vertexTypes
            r1.size = r5
            r1.ensureCapacity(r3)
            r2 = 0
        L_0x0067:
            if (r2 >= r3) goto L_0x0073
            int r4 = r0.classifyVertex(r2)
            r1.add(r4)
            int r2 = r2 + 1
            goto L_0x0067
        L_0x0073:
            com.badlogic.gdx.utils.ShortArray r1 = r0.triangles
            r1.size = r5
            int r3 = r3 - r6
            int r2 = java.lang.Math.max(r5, r3)
            r3 = 3
            int r2 = r2 * 3
            r1.ensureCapacity(r2)
            com.badlogic.gdx.utils.IntArray r2 = r0.vertexTypes
            int[] r2 = r2.items
        L_0x0086:
            int r4 = r0.vertexCount
            if (r4 <= r3) goto L_0x01c3
            r3 = 0
        L_0x008b:
            r5 = -1
            if (r3 >= r4) goto L_0x0117
            com.badlogic.gdx.utils.IntArray r8 = r0.vertexTypes
            int[] r8 = r8.items
            r9 = r8[r3]
            if (r9 != r5) goto L_0x0098
            goto L_0x010a
        L_0x0098:
            int r9 = r0.previousIndex(r3)
            int r10 = r3 + 1
            int r11 = r0.vertexCount
            int r10 = r10 % r11
            short[] r11 = r0.indices
            short r12 = r11[r9]
            int r12 = r12 * 2
            short r13 = r11[r3]
            int r13 = r13 * 2
            short r14 = r11[r10]
            int r14 = r14 * 2
            float[] r15 = r0.vertices
            r22 = r15[r12]
            int r12 = r12 + r7
            r12 = r15[r12]
            r23 = r15[r13]
            int r13 = r13 + r7
            r13 = r15[r13]
            r24 = r15[r14]
            int r14 = r14 + 1
            r14 = r15[r14]
        L_0x00c1:
            int r10 = r0.nextIndex(r10)
            if (r10 == r9) goto L_0x010e
            r6 = r8[r10]
            if (r6 == r7) goto L_0x010c
            short r6 = r11[r10]
            int r6 = r6 * 2
            r25 = r15[r6]
            int r6 = r6 + r7
            r6 = r15[r6]
            r16 = r24
            r17 = r14
            r18 = r22
            r19 = r12
            r20 = r25
            r21 = r6
            int r16 = computeSpannedAreaSign(r16, r17, r18, r19, r20, r21)
            if (r16 < 0) goto L_0x010c
            r16 = r22
            r17 = r12
            r18 = r23
            r19 = r13
            r20 = r25
            r21 = r6
            int r16 = computeSpannedAreaSign(r16, r17, r18, r19, r20, r21)
            if (r16 < 0) goto L_0x010c
            r16 = r23
            r17 = r13
            r18 = r24
            r19 = r14
            r20 = r25
            r21 = r6
            int r6 = computeSpannedAreaSign(r16, r17, r18, r19, r20, r21)
            if (r6 < 0) goto L_0x010c
        L_0x010a:
            r6 = 0
            goto L_0x010f
        L_0x010c:
            r6 = 2
            goto L_0x00c1
        L_0x010e:
            r6 = 1
        L_0x010f:
            if (r6 == 0) goto L_0x0112
            goto L_0x0128
        L_0x0112:
            int r3 = r3 + 1
            r6 = 2
            goto L_0x008b
        L_0x0117:
            com.badlogic.gdx.utils.IntArray r3 = r0.vertexTypes
            int[] r3 = r3.items
            r6 = 0
        L_0x011c:
            if (r6 >= r4) goto L_0x0127
            r8 = r3[r6]
            if (r8 == r5) goto L_0x0124
            r3 = r6
            goto L_0x0128
        L_0x0124:
            int r6 = r6 + 1
            goto L_0x011c
        L_0x0127:
            r3 = 0
        L_0x0128:
            short[] r4 = r0.indices
            com.badlogic.gdx.utils.ShortArray r6 = r0.triangles
            int r8 = r0.previousIndex(r3)
            short r8 = r4[r8]
            r6.add(r8)
            short r8 = r4[r3]
            r6.add(r8)
            int r8 = r3 + 1
            int r9 = r0.vertexCount
            int r9 = r8 % r9
            short r4 = r4[r9]
            r6.add(r4)
            com.badlogic.gdx.utils.ShortArray r4 = r0.indicesArray
            int r6 = r4.size
            java.lang.String r9 = " >= "
            java.lang.String r10 = "index can't be >= size: "
            if (r3 >= r6) goto L_0x01b0
            short[] r11 = r4.items
            short r12 = r11[r3]
            int r6 = r6 + -1
            r4.size = r6
            boolean r4 = r4.ordered
            if (r4 == 0) goto L_0x0160
            int r6 = r6 - r3
            java.lang.System.arraycopy(r11, r8, r11, r3, r6)
            goto L_0x0164
        L_0x0160:
            short r4 = r11[r6]
            r11[r3] = r4
        L_0x0164:
            com.badlogic.gdx.utils.IntArray r4 = r0.vertexTypes
            int r6 = r4.size
            if (r3 >= r6) goto L_0x019d
            int[] r9 = r4.items
            r10 = r9[r3]
            int r6 = r6 + -1
            r4.size = r6
            boolean r4 = r4.ordered
            if (r4 == 0) goto L_0x017b
            int r6 = r6 - r3
            java.lang.System.arraycopy(r9, r8, r9, r3, r6)
            goto L_0x017f
        L_0x017b:
            r4 = r9[r6]
            r9[r3] = r4
        L_0x017f:
            int r4 = r0.vertexCount
            int r4 = r4 + r5
            r0.vertexCount = r4
            int r4 = r0.previousIndex(r3)
            int r5 = r0.vertexCount
            if (r3 != r5) goto L_0x018d
            r3 = 0
        L_0x018d:
            int r5 = r0.classifyVertex(r4)
            r2[r4] = r5
            int r4 = r0.classifyVertex(r3)
            r2[r3] = r4
            r3 = 3
            r6 = 2
            goto L_0x0086
        L_0x019d:
            java.lang.IndexOutOfBoundsException r1 = new java.lang.IndexOutOfBoundsException
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline74(r10, r3, r9)
            int r3 = r4.size
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01b0:
            java.lang.IndexOutOfBoundsException r1 = new java.lang.IndexOutOfBoundsException
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline74(r10, r3, r9)
            int r3 = r4.size
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01c3:
            r2 = 3
            if (r4 != r2) goto L_0x01db
            com.badlogic.gdx.utils.ShortArray r2 = r0.triangles
            short[] r3 = r0.indices
            r4 = 0
            short r4 = r3[r4]
            r2.add(r4)
            short r4 = r3[r7]
            r2.add(r4)
            r4 = 2
            short r3 = r3[r4]
            r2.add(r3)
        L_0x01db:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.math.EarClippingTriangulator.computeTriangles(float[]):com.badlogic.gdx.utils.ShortArray");
    }

    public final int nextIndex(int i) {
        return (i + 1) % this.vertexCount;
    }

    public final int previousIndex(int i) {
        if (i == 0) {
            i = this.vertexCount;
        }
        return i - 1;
    }
}
