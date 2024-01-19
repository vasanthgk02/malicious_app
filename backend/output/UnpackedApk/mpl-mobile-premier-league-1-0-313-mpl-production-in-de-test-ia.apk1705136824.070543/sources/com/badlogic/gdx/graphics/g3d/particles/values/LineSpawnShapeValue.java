package com.badlogic.gdx.graphics.g3d.particles.values;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

public final class LineSpawnShapeValue extends PrimitiveSpawnShapeValue {
    public LineSpawnShapeValue(LineSpawnShapeValue lineSpawnShapeValue) {
        super(lineSpawnShapeValue);
        load(lineSpawnShapeValue);
    }

    public SpawnShapeValue copy() {
        return new LineSpawnShapeValue(this);
    }

    public void spawnAux(Vector3 vector3, float f2) {
        float f3 = this.spawnWidth;
        float outline5 = GeneratedOutlineSupport.outline5(this.spawnWidthValue, f2, this.spawnWidthDiff, f3);
        float f4 = this.spawnHeight;
        float outline52 = GeneratedOutlineSupport.outline5(this.spawnHeightValue, f2, this.spawnHeightDiff, f4);
        float f5 = this.spawnDepth;
        float outline53 = GeneratedOutlineSupport.outline5(this.spawnDepthValue, f2, this.spawnDepthDiff, f5);
        float random = MathUtils.random();
        vector3.x = outline5 * random;
        vector3.y = outline52 * random;
        vector3.z = random * outline53;
    }

    public LineSpawnShapeValue() {
    }
}
