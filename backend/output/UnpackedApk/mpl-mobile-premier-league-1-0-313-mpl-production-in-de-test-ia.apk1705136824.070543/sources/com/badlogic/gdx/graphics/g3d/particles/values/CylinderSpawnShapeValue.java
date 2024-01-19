package com.badlogic.gdx.graphics.g3d.particles.values;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

public final class CylinderSpawnShapeValue extends PrimitiveSpawnShapeValue {
    public CylinderSpawnShapeValue(CylinderSpawnShapeValue cylinderSpawnShapeValue) {
        super(cylinderSpawnShapeValue);
        load(cylinderSpawnShapeValue);
    }

    public SpawnShapeValue copy() {
        return new CylinderSpawnShapeValue(this);
    }

    public void spawnAux(Vector3 vector3, float f2) {
        float f3;
        float outline5 = GeneratedOutlineSupport.outline5(this.spawnWidthValue, f2, this.spawnWidthDiff, this.spawnWidth);
        float outline52 = GeneratedOutlineSupport.outline5(this.spawnHeightValue, f2, this.spawnHeightDiff, this.spawnHeight);
        float outline53 = GeneratedOutlineSupport.outline5(this.spawnDepthValue, f2, this.spawnDepthDiff, this.spawnDepth);
        float random = MathUtils.random(outline52) - (outline52 / 2.0f);
        if (this.edges) {
            f3 = outline5 / 2.0f;
        } else {
            f3 = MathUtils.random(outline5) / 2.0f;
            outline53 = MathUtils.random(outline53);
        }
        float f4 = outline53 / 2.0f;
        boolean z = false;
        float f5 = 0.0f;
        boolean z2 = f3 == 0.0f;
        if (f4 == 0.0f) {
            z = true;
        }
        if (!z2 && !z) {
            f5 = MathUtils.random(360.0f);
        } else if (z2) {
            f5 = MathUtils.random(1) == 0 ? -90.0f : 90.0f;
        } else if (z && MathUtils.random(1) != 0) {
            f5 = 180.0f;
        }
        vector3.set(MathUtils.cosDeg(f5) * f3, random, MathUtils.sinDeg(f5) * f4);
    }

    public CylinderSpawnShapeValue() {
    }
}
