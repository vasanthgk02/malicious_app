package com.badlogic.gdx.graphics.g3d.particles.values;

public final class RectangleSpawnShapeValue extends PrimitiveSpawnShapeValue {
    public RectangleSpawnShapeValue(RectangleSpawnShapeValue rectangleSpawnShapeValue) {
        super(rectangleSpawnShapeValue);
        load(rectangleSpawnShapeValue);
    }

    public SpawnShapeValue copy() {
        return new RectangleSpawnShapeValue(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0049, code lost:
        if (com.badlogic.gdx.math.MathUtils.random(1) == 0) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a3, code lost:
        if (com.badlogic.gdx.math.MathUtils.random(1) == 0) goto L_0x004b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void spawnAux(com.badlogic.gdx.math.Vector3 r8, float r9) {
        /*
            r7 = this;
            float r0 = r7.spawnWidth
            float r1 = r7.spawnWidthDiff
            com.badlogic.gdx.graphics.g3d.particles.values.ScaledNumericValue r2 = r7.spawnWidthValue
            float r0 = com.android.tools.r8.GeneratedOutlineSupport.outline5(r2, r9, r1, r0)
            float r1 = r7.spawnHeight
            float r2 = r7.spawnHeightDiff
            com.badlogic.gdx.graphics.g3d.particles.values.ScaledNumericValue r3 = r7.spawnHeightValue
            float r1 = com.android.tools.r8.GeneratedOutlineSupport.outline5(r3, r9, r2, r1)
            float r2 = r7.spawnDepth
            float r3 = r7.spawnDepthDiff
            com.badlogic.gdx.graphics.g3d.particles.values.ScaledNumericValue r4 = r7.spawnDepthValue
            float r9 = com.android.tools.r8.GeneratedOutlineSupport.outline5(r4, r9, r3, r2)
            boolean r2 = r7.edges
            r3 = 1073741824(0x40000000, float:2.0)
            if (r2 == 0) goto L_0x00b9
            java.util.Random r2 = com.badlogic.gdx.math.MathUtils.random
            r4 = 3
            int r2 = r2.nextInt(r4)
            r4 = -1
            int r2 = r2 + r4
            r5 = 0
            r6 = 1
            if (r2 != r4) goto L_0x005d
            int r2 = com.badlogic.gdx.math.MathUtils.random(r6)
            if (r2 != 0) goto L_0x0038
            float r0 = -r0
        L_0x0038:
            float r0 = r0 / r3
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x004e
            int r2 = com.badlogic.gdx.math.MathUtils.random(r6)
            if (r2 != 0) goto L_0x0044
            float r1 = -r1
        L_0x0044:
            float r1 = r1 / r3
            int r2 = com.badlogic.gdx.math.MathUtils.random(r6)
            if (r2 != 0) goto L_0x004c
        L_0x004b:
            float r9 = -r9
        L_0x004c:
            float r9 = r9 / r3
            goto L_0x00b2
        L_0x004e:
            float r2 = com.badlogic.gdx.math.MathUtils.random(r1)
            float r1 = r1 / r3
            float r1 = r2 - r1
            float r2 = com.badlogic.gdx.math.MathUtils.random(r9)
        L_0x0059:
            float r9 = r9 / r3
            float r9 = r2 - r9
            goto L_0x00b2
        L_0x005d:
            if (r2 != 0) goto L_0x008b
            int r2 = com.badlogic.gdx.math.MathUtils.random(r6)
            if (r2 != 0) goto L_0x0066
            float r9 = -r9
        L_0x0066:
            float r9 = r9 / r3
            int r2 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x007c
            int r2 = com.badlogic.gdx.math.MathUtils.random(r6)
            if (r2 != 0) goto L_0x0072
            float r1 = -r1
        L_0x0072:
            float r1 = r1 / r3
            int r2 = com.badlogic.gdx.math.MathUtils.random(r6)
            if (r2 != 0) goto L_0x007a
            float r0 = -r0
        L_0x007a:
            float r0 = r0 / r3
            goto L_0x00b2
        L_0x007c:
            float r2 = com.badlogic.gdx.math.MathUtils.random(r1)
            float r1 = r1 / r3
            float r1 = r2 - r1
            float r2 = com.badlogic.gdx.math.MathUtils.random(r0)
            float r0 = r0 / r3
            float r0 = r2 - r0
            goto L_0x00b2
        L_0x008b:
            int r2 = com.badlogic.gdx.math.MathUtils.random(r6)
            if (r2 != 0) goto L_0x0092
            float r1 = -r1
        L_0x0092:
            float r1 = r1 / r3
            int r2 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x00a6
            int r2 = com.badlogic.gdx.math.MathUtils.random(r6)
            if (r2 != 0) goto L_0x009e
            float r0 = -r0
        L_0x009e:
            float r0 = r0 / r3
            int r2 = com.badlogic.gdx.math.MathUtils.random(r6)
            if (r2 != 0) goto L_0x004c
            goto L_0x004b
        L_0x00a6:
            float r2 = com.badlogic.gdx.math.MathUtils.random(r0)
            float r0 = r0 / r3
            float r0 = r2 - r0
            float r2 = com.badlogic.gdx.math.MathUtils.random(r9)
            goto L_0x0059
        L_0x00b2:
            r8.x = r0
            r8.y = r1
            r8.z = r9
            goto L_0x00d1
        L_0x00b9:
            float r2 = com.badlogic.gdx.math.MathUtils.random(r0)
            float r0 = r0 / r3
            float r2 = r2 - r0
            r8.x = r2
            float r0 = com.badlogic.gdx.math.MathUtils.random(r1)
            float r1 = r1 / r3
            float r0 = r0 - r1
            r8.y = r0
            float r0 = com.badlogic.gdx.math.MathUtils.random(r9)
            float r9 = r9 / r3
            float r0 = r0 - r9
            r8.z = r0
        L_0x00d1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.g3d.particles.values.RectangleSpawnShapeValue.spawnAux(com.badlogic.gdx.math.Vector3, float):void");
    }

    public RectangleSpawnShapeValue() {
    }
}
