package com.badlogic.gdx.graphics.g3d.utils.shapebuilders;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder.VertexInfo;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ShortArray;

public class SphereShapeBuilder extends BaseShapeBuilder {
    public static final Matrix3 normalTransform = new Matrix3();
    public static final ShortArray tmpIndices = new ShortArray();

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, float f4, int i, int i2) {
        build(meshPartBuilder, f2, f3, f4, i, i2, 0.0f, 360.0f, 0.0f, 180.0f);
    }

    @Deprecated
    public static void build(MeshPartBuilder meshPartBuilder, Matrix4 matrix4, float f2, float f3, float f4, int i, int i2) {
        build(meshPartBuilder, matrix4, f2, f3, f4, i, i2, 0.0f, 360.0f, 0.0f, 180.0f);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, float f4, int i, int i2, float f5, float f6, float f7, float f8) {
        Matrix4 matrix4 = BaseShapeBuilder.matTmp1;
        matrix4.idt();
        build(meshPartBuilder, matrix4, f2, f3, f4, i, i2, f5, f6, f7, f8);
    }

    @Deprecated
    public static void build(MeshPartBuilder meshPartBuilder, Matrix4 matrix4, float f2, float f3, float f4, int i, int i2, float f5, float f6, float f7, float f8) {
        float f9;
        float f10;
        float f11;
        MeshPartBuilder meshPartBuilder2 = meshPartBuilder;
        int i3 = i;
        int i4 = i2;
        float f12 = f7;
        float f13 = f8;
        boolean isEqual = MathUtils.isEqual(f12, 0.0f);
        boolean isEqual2 = MathUtils.isEqual(f13, 180.0f);
        float f14 = f2 * 0.5f;
        float f15 = f3 * 0.5f;
        float f16 = f5 * 0.017453292f;
        float f17 = (float) i3;
        float f18 = ((f6 - f5) * 0.017453292f) / f17;
        float f19 = f12 * 0.017453292f;
        float f20 = (float) i4;
        float f21 = ((f13 - f12) * 0.017453292f) / f20;
        float f22 = 1.0f / f17;
        float f23 = 1.0f / f20;
        float f24 = 0.5f * f4;
        VertexInfo vertexInfo = BaseShapeBuilder.vertTmp3.set(null, null, null, null);
        vertexInfo.hasNormal = true;
        vertexInfo.hasPosition = true;
        vertexInfo.hasUV = true;
        normalTransform.set(matrix4);
        int i5 = i3 + 3;
        ShortArray shortArray = tmpIndices;
        float f25 = f14;
        shortArray.size = 0;
        shortArray.ensureCapacity(i3 * 2);
        tmpIndices.size = i5;
        int i6 = i3 + 1;
        meshPartBuilder2.ensureVertices((i4 + 1) * i6);
        meshPartBuilder2.ensureRectangleIndices(i3);
        int i7 = 0;
        int i8 = 0;
        while (i7 <= i4) {
            int i9 = i6;
            float f26 = (float) i7;
            float f27 = (f21 * f26) + f19;
            float f28 = f26 * f23;
            float sin = MathUtils.sin(f27);
            float f29 = f21;
            float cos = MathUtils.cos(f27) * f15;
            float f30 = f15;
            float f31 = f23;
            int i10 = i8;
            int i11 = 0;
            while (i11 <= i3) {
                float f32 = f19;
                float f33 = (float) i11;
                float f34 = (f18 * f33) + f16;
                if ((i7 != 0 || !isEqual) && (i7 != i4 || !isEqual2)) {
                    f9 = 1.0f;
                    f10 = f33 * f22;
                } else {
                    f10 = (f33 - 0.5f) * f22;
                    f9 = 1.0f;
                }
                float f35 = f9 - f10;
                float f36 = f16;
                float f37 = f18;
                float f38 = f22;
                vertexInfo.position.set(MathUtils.cos(f34) * f25 * sin, cos, MathUtils.sin(f34) * f24 * sin);
                Vector3 vector3 = vertexInfo.normal;
                vector3.set(vertexInfo.position);
                vector3.mul(normalTransform);
                vector3.nor();
                vertexInfo.position.mul(matrix4);
                Vector2 vector2 = vertexInfo.uv;
                vector2.x = f35;
                vector2.y = f28;
                ShortArray shortArray2 = tmpIndices;
                short vertex = meshPartBuilder2.vertex(vertexInfo);
                if (i10 < shortArray2.size) {
                    shortArray2.items[i10] = vertex;
                    int i12 = i10 + i5;
                    if (i7 <= 0 || i11 <= 0) {
                        f11 = cos;
                    } else if (i7 != 1 || !isEqual) {
                        f11 = cos;
                        if (i7 != i4 || !isEqual2) {
                            meshPartBuilder2.rect(tmpIndices.get(i10), tmpIndices.get((i12 - 1) % i5), tmpIndices.get((i12 - (i3 + 2)) % i5), tmpIndices.get((i12 - i9) % i5));
                        } else {
                            meshPartBuilder2.triangle(tmpIndices.get(i10), tmpIndices.get((i12 - (i3 + 2)) % i5), tmpIndices.get((i12 - i9) % i5));
                        }
                    } else {
                        f11 = cos;
                        meshPartBuilder2.triangle(tmpIndices.get(i10), tmpIndices.get((i12 - 1) % i5), tmpIndices.get((i12 - i9) % i5));
                    }
                    i10 = (i10 + 1) % tmpIndices.size;
                    i11++;
                    i3 = i;
                    f19 = f32;
                    f22 = f38;
                    cos = f11;
                    f16 = f36;
                    f18 = f37;
                } else {
                    StringBuilder outline74 = GeneratedOutlineSupport.outline74("index can't be >= size: ", i10, " >= ");
                    outline74.append(shortArray2.size);
                    throw new IndexOutOfBoundsException(outline74.toString());
                }
            }
            float f39 = f16;
            float f40 = f18;
            float f41 = f22;
            float f42 = f19;
            Matrix4 matrix42 = matrix4;
            i7++;
            i6 = i9;
            f21 = f29;
            i3 = i;
            f23 = f31;
            i8 = i10;
            f15 = f30;
            f18 = f40;
        }
    }
}
