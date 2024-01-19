package com.badlogic.gdx.math;

import com.badlogic.gdx.utils.FloatArray;

public final class Intersector {

    /* renamed from: e  reason: collision with root package name */
    public static final Vector2 f3309e = new Vector2();
    public static final Vector2 ep1 = new Vector2();
    public static final Vector2 ep2 = new Vector2();
    public static final FloatArray floatArray = new FloatArray();
    public static final FloatArray floatArray2 = new FloatArray();
    public static final Vector2 ip = new Vector2();
    public static final Vector2 s = new Vector2();

    static {
        Vector3 vector3 = new Vector3();
        Vector3 vector32 = new Vector3();
        vector32.set(vector3);
        vector32.nor();
    }

    public static boolean intersectLines(Vector2 vector2, Vector2 vector22, Vector2 vector23, Vector2 vector24, Vector2 vector25) {
        float f2 = vector2.x;
        float f3 = vector2.y;
        float f4 = vector22.x;
        float f5 = vector22.y;
        float f6 = vector23.x;
        float f7 = vector23.y;
        float f8 = vector24.x;
        float f9 = vector24.y - f7;
        float f10 = f4 - f2;
        float f11 = f8 - f6;
        float f12 = f5 - f3;
        float f13 = (f9 * f10) - (f11 * f12);
        if (f13 == 0.0f) {
            return false;
        }
        if (vector25 != null) {
            float f14 = (((f3 - f7) * f11) - ((f2 - f6) * f9)) / f13;
            vector25.x = (f10 * f14) + f2;
            vector25.y = (f12 * f14) + f3;
        }
        return true;
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r3v2, types: [boolean, int] */
    /* JADX WARNING: type inference failed for: r3v3, types: [int] */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r3v26 */
    /* JADX WARNING: type inference failed for: r3v27 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v0
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY]]
      uses: [boolean, int, ?[int, short, byte, char]]
      mth insns count: 123
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean intersectPolygons(com.badlogic.gdx.math.Polygon r16, com.badlogic.gdx.math.Polygon r17, com.badlogic.gdx.math.Polygon r18) {
        /*
            r0 = r16
            r1 = r18
            float[] r2 = r0.localVertices
            int r2 = r2.length
            r3 = 0
            if (r2 == 0) goto L_0x010c
            r2 = r17
            float[] r4 = r2.localVertices
            int r4 = r4.length
            if (r4 != 0) goto L_0x0013
            goto L_0x010c
        L_0x0013:
            com.badlogic.gdx.math.Vector2 r4 = ip
            com.badlogic.gdx.math.Vector2 r5 = ep1
            com.badlogic.gdx.math.Vector2 r6 = ep2
            com.badlogic.gdx.math.Vector2 r7 = s
            com.badlogic.gdx.math.Vector2 r8 = f3309e
            com.badlogic.gdx.utils.FloatArray r9 = floatArray
            com.badlogic.gdx.utils.FloatArray r10 = floatArray2
            r9.size = r3
            r10.size = r3
            float[] r0 = r16.getTransformedVertices()
            int r11 = r0.length
            r10.addAll(r0, r3, r11)
            float[] r0 = r17.getTransformedVertices()
            int r2 = r0.length
            r11 = 2
            int r2 = r2 - r11
            r12 = 0
        L_0x0035:
            r13 = 1
            if (r12 > r2) goto L_0x00f2
            r14 = r0[r12]
            int r15 = r12 + 1
            r15 = r0[r15]
            r5.x = r14
            r5.y = r15
            if (r12 >= r2) goto L_0x0051
            int r14 = r12 + 2
            r14 = r0[r14]
            int r15 = r12 + 3
            r15 = r0[r15]
            r6.x = r14
            r6.y = r15
            goto L_0x0059
        L_0x0051:
            r14 = r0[r3]
            r15 = r0[r13]
            r6.x = r14
            r6.y = r15
        L_0x0059:
            int r14 = r10.size
            if (r14 != 0) goto L_0x005e
            return r3
        L_0x005e:
            int r14 = r14 + -2
            float r14 = r10.get(r14)
            int r15 = r10.size
            int r15 = r15 - r13
            float r15 = r10.get(r15)
            r7.x = r14
            r7.y = r15
            r14 = 0
        L_0x0070:
            int r15 = r10.size
            if (r14 >= r15) goto L_0x00e3
            float r15 = r10.get(r14)
            int r3 = r14 + 1
            float r3 = r10.get(r3)
            r8.x = r15
            r8.y = r3
            int r3 = pointLineSide(r6, r5, r7)
            if (r3 <= 0) goto L_0x008a
            r3 = 1
            goto L_0x008b
        L_0x008a:
            r3 = 0
        L_0x008b:
            int r15 = pointLineSide(r6, r5, r8)
            if (r15 <= 0) goto L_0x00c8
            if (r3 != 0) goto L_0x00bd
            intersectLines(r7, r8, r5, r6, r4)
            int r3 = r9.size
            if (r3 < r11) goto L_0x00b3
            int r3 = r3 + -2
            float r3 = r9.get(r3)
            float r15 = r4.x
            int r3 = (r3 > r15 ? 1 : (r3 == r15 ? 0 : -1))
            if (r3 != 0) goto L_0x00b3
            int r3 = r9.size
            int r3 = r3 - r13
            float r3 = r9.get(r3)
            float r15 = r4.y
            int r3 = (r3 > r15 ? 1 : (r3 == r15 ? 0 : -1))
            if (r3 == 0) goto L_0x00bd
        L_0x00b3:
            float r3 = r4.x
            r9.add(r3)
            float r3 = r4.y
            r9.add(r3)
        L_0x00bd:
            float r3 = r8.x
            r9.add(r3)
            float r3 = r8.y
            r9.add(r3)
            goto L_0x00d7
        L_0x00c8:
            if (r3 == 0) goto L_0x00d7
            intersectLines(r7, r8, r5, r6, r4)
            float r3 = r4.x
            r9.add(r3)
            float r3 = r4.y
            r9.add(r3)
        L_0x00d7:
            float r3 = r8.x
            float r15 = r8.y
            r7.x = r3
            r7.y = r15
            int r14 = r14 + 2
            r3 = 0
            goto L_0x0070
        L_0x00e3:
            r10.size = r3
            float[] r13 = r9.items
            int r14 = r9.size
            r10.addAll(r13, r3, r14)
            r9.size = r3
            int r12 = r12 + 2
            goto L_0x0035
        L_0x00f2:
            int r0 = r10.size
            if (r0 == 0) goto L_0x010c
            float[] r2 = r1.localVertices
            int r4 = r2.length
            if (r4 != r0) goto L_0x0101
            float[] r1 = r10.items
            java.lang.System.arraycopy(r1, r3, r2, r3, r0)
            goto L_0x010b
        L_0x0101:
            float[] r2 = new float[r0]
            float[] r4 = r10.items
            java.lang.System.arraycopy(r4, r3, r2, r3, r0)
            r1.setVertices(r2)
        L_0x010b:
            return r13
        L_0x010c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.math.Intersector.intersectPolygons(com.badlogic.gdx.math.Polygon, com.badlogic.gdx.math.Polygon, com.badlogic.gdx.math.Polygon):boolean");
    }

    public static int pointLineSide(Vector2 vector2, Vector2 vector22, Vector2 vector23) {
        float f2 = vector22.x;
        float f3 = vector2.x;
        float f4 = vector23.y;
        float f5 = vector2.y;
        return (int) Math.signum(((f4 - f5) * (f2 - f3)) - ((vector23.x - f3) * (vector22.y - f5)));
    }
}
