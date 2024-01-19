package com.badlogic.gdx.graphics.g3d.particles.values;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.math.Vector3;

public final class PointSpawnShapeValue extends PrimitiveSpawnShapeValue {
    public PointSpawnShapeValue(PointSpawnShapeValue pointSpawnShapeValue) {
        super(pointSpawnShapeValue);
        load(pointSpawnShapeValue);
    }

    public SpawnShapeValue copy() {
        return new PointSpawnShapeValue(this);
    }

    public void spawnAux(Vector3 vector3, float f2) {
        float f3 = this.spawnWidth;
        vector3.x = GeneratedOutlineSupport.outline5(this.spawnWidthValue, f2, this.spawnWidthDiff, f3);
        float f4 = this.spawnHeight;
        vector3.y = GeneratedOutlineSupport.outline5(this.spawnHeightValue, f2, this.spawnHeightDiff, f4);
        float f5 = this.spawnDepth;
        vector3.z = GeneratedOutlineSupport.outline5(this.spawnDepthValue, f2, this.spawnDepthDiff, f5);
    }

    public PointSpawnShapeValue() {
    }
}
