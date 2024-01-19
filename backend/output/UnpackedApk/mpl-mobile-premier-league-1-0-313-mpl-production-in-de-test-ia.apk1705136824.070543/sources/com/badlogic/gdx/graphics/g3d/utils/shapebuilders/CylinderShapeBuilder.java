package com.badlogic.gdx.graphics.g3d.utils.shapebuilders;

import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder.VertexInfo;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class CylinderShapeBuilder extends BaseShapeBuilder {
    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, float f4, int i) {
        build(meshPartBuilder, f2, f3, f4, i, 0.0f, 360.0f);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, float f4, int i, float f5, float f6) {
        build(meshPartBuilder, f2, f3, f4, i, f5, f6, true);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, float f4, int i, float f5, float f6, boolean z) {
        MeshPartBuilder meshPartBuilder2 = meshPartBuilder;
        int i2 = i;
        float f7 = f2 * 0.5f;
        float f8 = f3 * 0.5f;
        float f9 = 0.5f * f4;
        float f10 = f5 * 0.017453292f;
        float f11 = (float) i2;
        float f12 = ((f6 - f5) * 0.017453292f) / f11;
        float f13 = 1.0f;
        float f14 = 1.0f / f11;
        VertexInfo vertexInfo = BaseShapeBuilder.vertTmp3.set(null, null, null, null);
        vertexInfo.hasNormal = true;
        vertexInfo.hasPosition = true;
        vertexInfo.hasUV = true;
        VertexInfo vertexInfo2 = BaseShapeBuilder.vertTmp4.set(null, null, null, null);
        vertexInfo2.hasNormal = true;
        vertexInfo2.hasPosition = true;
        vertexInfo2.hasUV = true;
        meshPartBuilder2.ensureVertices((i2 + 1) * 2);
        meshPartBuilder2.ensureRectangleIndices(i2);
        int i3 = 0;
        short s = 0;
        short s2 = 0;
        while (i3 <= i2) {
            float f15 = (float) i3;
            float f16 = (f12 * f15) + f10;
            float f17 = f13 - (f15 * f14);
            float f18 = f14;
            float f19 = f9;
            vertexInfo.position.set(MathUtils.cos(f16) * f7, 0.0f, MathUtils.sin(f16) * f9);
            Vector3 vector3 = vertexInfo.normal;
            vector3.set(vertexInfo.position);
            vector3.nor();
            Vector3 vector32 = vertexInfo.position;
            vector32.y = -f8;
            Vector2 vector2 = vertexInfo.uv;
            vector2.x = f17;
            vector2.y = 1.0f;
            vertexInfo2.position.set(vector32);
            vertexInfo2.normal.set(vertexInfo.normal);
            vertexInfo2.position.y = f8;
            Vector2 vector22 = vertexInfo2.uv;
            vector22.x = f17;
            vector22.y = 0.0f;
            short vertex = meshPartBuilder2.vertex(vertexInfo);
            short vertex2 = meshPartBuilder2.vertex(vertexInfo2);
            if (i3 != 0) {
                meshPartBuilder2.rect(s, vertex2, vertex, s2);
            }
            i3++;
            s2 = vertex;
            s = vertex2;
            f9 = f19;
            f14 = f18;
            f13 = 1.0f;
        }
        if (z) {
            float f20 = f2;
            float f21 = f8;
            float f22 = f4;
            int i4 = i;
            EllipseShapeBuilder.build(meshPartBuilder, f20, f22, 0.0f, 0.0f, i4, 0.0f, f21, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, f5, f6);
            EllipseShapeBuilder.build(meshPartBuilder, f20, f22, 0.0f, 0.0f, i4, 0.0f, -f21, 0.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 180.0f - f6, 180.0f - f5);
        }
    }
}
