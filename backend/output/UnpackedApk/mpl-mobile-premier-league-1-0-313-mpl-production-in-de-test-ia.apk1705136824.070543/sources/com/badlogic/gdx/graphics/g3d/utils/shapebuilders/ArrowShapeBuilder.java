package com.badlogic.gdx.graphics.g3d.utils.shapebuilders;

import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;

public class ArrowShapeBuilder extends BaseShapeBuilder {
    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int i) {
        MeshPartBuilder meshPartBuilder2 = meshPartBuilder;
        float f10 = f2;
        float f11 = f3;
        float f12 = f4;
        int i2 = i;
        Vector3 obtainV3 = BaseShapeBuilder.obtainV3();
        obtainV3.x = f10;
        obtainV3.y = f11;
        obtainV3.z = f12;
        Vector3 obtainV32 = BaseShapeBuilder.obtainV3();
        obtainV32.x = f5;
        obtainV32.y = f6;
        obtainV32.z = f7;
        float dst = obtainV3.dst(obtainV32);
        float f13 = dst * f8;
        float sqrt = ((float) (Math.sqrt(0.3333333432674408d) * ((double) f13))) * 2.0f;
        float f14 = dst - f13;
        float f15 = sqrt * f9;
        Vector3 obtainV33 = BaseShapeBuilder.obtainV3();
        obtainV33.set(obtainV32);
        obtainV33.sub(obtainV3);
        Vector3 nor = obtainV33.nor();
        Vector3 obtainV34 = BaseShapeBuilder.obtainV3();
        obtainV34.set(nor);
        obtainV34.crs(Vector3.Z);
        if (obtainV34.isZero()) {
            obtainV34.set(Vector3.X);
        }
        obtainV34.crs(nor);
        obtainV34.nor();
        Vector3 obtainV35 = BaseShapeBuilder.obtainV3();
        obtainV35.set(nor);
        obtainV35.crs(obtainV34);
        Vector3 nor2 = obtainV35.nor();
        Vector3 obtainV36 = BaseShapeBuilder.obtainV3();
        obtainV36.set(obtainV32);
        obtainV36.sub(obtainV3);
        Vector3 nor3 = obtainV36.nor();
        Matrix4 vertexTransform = meshPartBuilder2.getVertexTransform(BaseShapeBuilder.obtainM4());
        Matrix4 obtainM4 = BaseShapeBuilder.obtainM4();
        float[] fArr = obtainM4.val;
        float f16 = f13;
        fArr[0] = nor2.x;
        float f17 = sqrt;
        fArr[4] = nor.x;
        fArr[8] = obtainV34.x;
        fArr[1] = nor2.y;
        fArr[5] = nor.y;
        fArr[9] = obtainV34.y;
        fArr[2] = nor2.z;
        fArr[6] = nor.z;
        fArr[10] = obtainV34.z;
        Matrix4 obtainM42 = BaseShapeBuilder.obtainM4();
        Vector3 obtainV37 = BaseShapeBuilder.obtainV3();
        obtainV37.set(nor3);
        obtainV37.scl(f14 / 2.0f);
        obtainV37.add(f10, f11, f12);
        obtainM4.setTranslation(obtainV37);
        obtainM42.set(obtainM4);
        obtainM42.mul(vertexTransform);
        meshPartBuilder2.setVertexTransform(obtainM42);
        CylinderShapeBuilder.build(meshPartBuilder2, f15, f14, f15, i2);
        Vector3 obtainV38 = BaseShapeBuilder.obtainV3();
        obtainV38.set(nor3);
        obtainV38.scl(f14);
        obtainV38.add(f10, f11, f12);
        obtainM4.setTranslation(obtainV38);
        obtainM42.set(obtainM4);
        obtainM42.mul(vertexTransform);
        meshPartBuilder2.setVertexTransform(obtainM42);
        float f18 = f17;
        ConeShapeBuilder.build(meshPartBuilder2, f18, f16, f18, i2);
        meshPartBuilder2.setVertexTransform(vertexTransform);
        BaseShapeBuilder.freeAll();
    }
}
