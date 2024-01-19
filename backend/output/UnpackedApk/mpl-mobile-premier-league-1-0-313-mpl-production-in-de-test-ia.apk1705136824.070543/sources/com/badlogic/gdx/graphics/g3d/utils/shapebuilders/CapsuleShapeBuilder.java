package com.badlogic.gdx.graphics.g3d.utils.shapebuilders;

import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class CapsuleShapeBuilder extends BaseShapeBuilder {
    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, int i) {
        float f4 = 2.0f * f2;
        if (f3 >= f4) {
            float f5 = f3 - f4;
            float f6 = f4;
            CylinderShapeBuilder.build(meshPartBuilder, f4, f5, f6, i, 0.0f, 360.0f, false);
            Matrix4 matrix4 = BaseShapeBuilder.matTmp1;
            matrix4.setToTranslation(0.0f, 0.5f * f5, 0.0f);
            float f7 = f4;
            float f8 = f4;
            int i2 = i;
            int i3 = i;
            SphereShapeBuilder.build(meshPartBuilder, matrix4, f7, f6, f8, i2, i3, 0.0f, 360.0f, 0.0f, 90.0f);
            Matrix4 matrix42 = BaseShapeBuilder.matTmp1;
            matrix42.setToTranslation(0.0f, f5 * -0.5f, 0.0f);
            SphereShapeBuilder.build(meshPartBuilder, matrix42, f7, f6, f8, i2, i3, 0.0f, 360.0f, 90.0f, 180.0f);
            return;
        }
        throw new GdxRuntimeException((String) "Height must be at least twice the radius");
    }
}
