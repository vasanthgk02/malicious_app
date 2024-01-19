package com.badlogic.gdx.graphics.g3d.utils.shapebuilders;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder.VertexInfo;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class PatchShapeBuilder extends BaseShapeBuilder {
    public static void build(MeshPartBuilder meshPartBuilder, VertexInfo vertexInfo, VertexInfo vertexInfo2, VertexInfo vertexInfo3, VertexInfo vertexInfo4, int i, int i2) {
        if (i < 1 || i2 < 1) {
            throw new GdxRuntimeException(GeneratedOutlineSupport.outline43("divisionsU and divisionV must be > 0, u,v: ", i, ", ", i2));
        }
        meshPartBuilder.ensureVertices((i + 1) * (i2 + 1));
        meshPartBuilder.ensureRectangleIndices(i2 * i);
        for (int i3 = 0; i3 <= i; i3++) {
            float f2 = ((float) i3) / ((float) i);
            BaseShapeBuilder.vertTmp5.set(vertexInfo).lerp(vertexInfo2, f2);
            BaseShapeBuilder.vertTmp6.set(vertexInfo4).lerp(vertexInfo3, f2);
            for (int i4 = 0; i4 <= i2; i4++) {
                short vertex = meshPartBuilder.vertex(BaseShapeBuilder.vertTmp7.set(BaseShapeBuilder.vertTmp5).lerp(BaseShapeBuilder.vertTmp6, ((float) i4) / ((float) i2)));
                if (i3 > 0 && i4 > 0) {
                    int i5 = vertex - i2;
                    meshPartBuilder.rect((short) (i5 - 2), (short) (vertex - 1), vertex, (short) (i5 - 1));
                }
            }
        }
    }

    public static void build(MeshPartBuilder meshPartBuilder, Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34, Vector3 vector35, int i, int i2) {
        Vector3 vector36 = vector35;
        Vector3 vector37 = vector3;
        Vector3 vector38 = vector32;
        Vector3 vector39 = vector33;
        build(meshPartBuilder, BaseShapeBuilder.vertTmp1.set(vector3, vector36, null, null).setUV(0.0f, 1.0f), BaseShapeBuilder.vertTmp2.set(vector32, vector36, null, null).setUV(1.0f, 1.0f), BaseShapeBuilder.vertTmp3.set(vector33, vector36, null, null).setUV(1.0f, 0.0f), BaseShapeBuilder.vertTmp4.set(vector34, vector36, null, null).setUV(0.0f, 0.0f), i, i2);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, int i, int i2) {
        float f17 = f14;
        float f18 = f15;
        float f19 = f16;
        float f20 = f2;
        float f21 = f3;
        float f22 = f4;
        build(meshPartBuilder, BaseShapeBuilder.vertTmp1.set(null).setPos(f2, f3, f4).setNor(f17, f18, f19).setUV(0.0f, 1.0f), BaseShapeBuilder.vertTmp2.set(null).setPos(f5, f6, f7).setNor(f17, f18, f19).setUV(1.0f, 1.0f), BaseShapeBuilder.vertTmp3.set(null).setPos(f8, f9, f10).setNor(f17, f18, f19).setUV(1.0f, 0.0f), BaseShapeBuilder.vertTmp4.set(null).setPos(f11, f12, f13).setNor(f17, f18, f19).setUV(0.0f, 0.0f), i, i2);
    }
}
