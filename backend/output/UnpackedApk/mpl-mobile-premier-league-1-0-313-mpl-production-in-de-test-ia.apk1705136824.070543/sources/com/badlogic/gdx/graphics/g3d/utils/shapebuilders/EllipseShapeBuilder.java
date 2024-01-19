package com.badlogic.gdx.graphics.g3d.utils.shapebuilders;

import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder.VertexInfo;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class EllipseShapeBuilder extends BaseShapeBuilder {
    public static void build(MeshPartBuilder meshPartBuilder, float f2, int i, float f3, float f4, float f5, float f6, float f7, float f8) {
        build(meshPartBuilder, f2, i, f3, f4, f5, f6, f7, f8, 0.0f, 360.0f);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, int i, Vector3 vector3, Vector3 vector32) {
        build(meshPartBuilder, f2, i, vector3.x, vector3.y, vector3.z, vector32.x, vector32.y, vector32.z);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, int i, Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34) {
        Vector3 vector35 = vector3;
        Vector3 vector36 = vector32;
        Vector3 vector37 = vector33;
        Vector3 vector38 = vector34;
        build(meshPartBuilder, f2, i, vector35.x, vector35.y, vector35.z, vector36.x, vector36.y, vector36.z, vector37.x, vector37.y, vector37.z, vector38.x, vector38.y, vector38.z);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, int i, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14) {
        build(meshPartBuilder, f2, i, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, 0.0f, 360.0f);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, int i, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        float f11 = f2 * 2.0f;
        build(meshPartBuilder, f11, f11, i, f3, f4, f5, f6, f7, f8, f9, f10);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, int i, Vector3 vector3, Vector3 vector32, float f3, float f4) {
        Vector3 vector33 = vector3;
        Vector3 vector34 = vector32;
        build(meshPartBuilder, f2, i, vector33.x, vector33.y, vector33.z, vector34.x, vector34.y, vector34.z, f3, f4);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, int i, Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34, float f3, float f4) {
        Vector3 vector35 = vector3;
        Vector3 vector36 = vector32;
        Vector3 vector37 = vector33;
        Vector3 vector38 = vector34;
        build(meshPartBuilder, f2, i, vector35.x, vector35.y, vector35.z, vector36.x, vector36.y, vector36.z, vector37.x, vector37.y, vector37.z, vector38.x, vector38.y, vector38.z, f3, f4);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, int i, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        float f17 = f2 * 2.0f;
        build(meshPartBuilder, f17, f17, 0.0f, 0.0f, i, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, int i, float f4, float f5, float f6, float f7, float f8, float f9) {
        build(meshPartBuilder, f2, f3, i, f4, f5, f6, f7, f8, f9, 0.0f, 360.0f);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, int i, Vector3 vector3, Vector3 vector32) {
        build(meshPartBuilder, f2, f3, i, vector3.x, vector3.y, vector3.z, vector32.x, vector32.y, vector32.z);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, int i, Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34) {
        Vector3 vector35 = vector3;
        Vector3 vector36 = vector32;
        Vector3 vector37 = vector33;
        Vector3 vector38 = vector34;
        build(meshPartBuilder, f2, f3, i, vector35.x, vector35.y, vector35.z, vector36.x, vector36.y, vector36.z, vector37.x, vector37.y, vector37.z, vector38.x, vector38.y, vector38.z);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, int i, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15) {
        build(meshPartBuilder, f2, f3, i, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, 0.0f, 360.0f);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, int i, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        build(meshPartBuilder, f2, f3, 0.0f, 0.0f, i, f4, f5, f6, f7, f8, f9, f10, f11);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, int i, Vector3 vector3, Vector3 vector32, float f4, float f5) {
        Vector3 vector33 = vector3;
        Vector3 vector34 = vector32;
        build(meshPartBuilder, f2, f3, 0.0f, 0.0f, i, vector33.x, vector33.y, vector33.z, vector34.x, vector34.y, vector34.z, f4, f5);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, int i, Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34, float f4, float f5) {
        Vector3 vector35 = vector3;
        Vector3 vector36 = vector32;
        Vector3 vector37 = vector33;
        Vector3 vector38 = vector34;
        build(meshPartBuilder, f2, f3, 0.0f, 0.0f, i, vector35.x, vector35.y, vector35.z, vector36.x, vector36.y, vector36.z, vector37.x, vector37.y, vector37.z, vector38.x, vector38.y, vector38.z, f4, f5);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, int i, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        build(meshPartBuilder, f2, f3, 0.0f, 0.0f, i, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, float f4, float f5, int i, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
        float f14 = f9;
        float f15 = f10;
        float f16 = f11;
        Vector3 vector3 = BaseShapeBuilder.tmpV1;
        vector3.x = f14;
        vector3.y = f15;
        vector3.z = f16;
        vector3.crs(0.0f, 0.0f, 1.0f);
        Vector3 vector32 = BaseShapeBuilder.tmpV2;
        vector32.x = f14;
        vector32.y = f15;
        vector32.z = f16;
        vector32.crs(0.0f, 1.0f, 0.0f);
        if (BaseShapeBuilder.tmpV2.len2() > BaseShapeBuilder.tmpV1.len2()) {
            BaseShapeBuilder.tmpV1.set(BaseShapeBuilder.tmpV2);
        }
        Vector3 vector33 = BaseShapeBuilder.tmpV2;
        vector33.set(BaseShapeBuilder.tmpV1.nor());
        vector33.crs(f14, f15, f16);
        vector33.nor();
        Vector3 vector34 = BaseShapeBuilder.tmpV1;
        float f17 = vector34.x;
        float f18 = vector34.y;
        float f19 = vector34.z;
        Vector3 vector35 = BaseShapeBuilder.tmpV2;
        build(meshPartBuilder, f2, f3, f4, f5, i, f6, f7, f8, f9, f10, f11, f17, f18, f19, vector35.x, vector35.y, vector35.z, f12, f13);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, float f4, float f5, int i, float f6, float f7, float f8, float f9, float f10, float f11) {
        build(meshPartBuilder, f2, f3, f4, f5, i, f6, f7, f8, f9, f10, f11, 0.0f, 360.0f);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, float f4, float f5, int i, Vector3 vector3, Vector3 vector32) {
        Vector3 vector33 = vector3;
        Vector3 vector34 = vector32;
        build(meshPartBuilder, f2, f3, f4, f5, i, vector33.x, vector33.y, vector33.z, vector34.x, vector34.y, vector34.z, 0.0f, 360.0f);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, float f4, float f5, int i, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19) {
        Vector3 vector3;
        Vector3 vector32;
        short s;
        short s2;
        short s3;
        MeshPartBuilder meshPartBuilder2 = meshPartBuilder;
        int i2 = i;
        float f20 = f6;
        float f21 = f7;
        float f22 = f8;
        float f23 = f9;
        float f24 = f10;
        float f25 = f11;
        float f26 = f12;
        float f27 = f13;
        float f28 = f14;
        float f29 = f15;
        float f30 = f16;
        float f31 = f17;
        int i3 = (f4 > 0.0f ? 1 : (f4 == 0.0f ? 0 : -1));
        if (i3 <= 0 || f5 <= 0.0f) {
            meshPartBuilder2.ensureVertices(i2 + 2);
            meshPartBuilder2.ensureTriangleIndices(i2);
        } else if (f4 == f2 && f5 == f3) {
            int i4 = i2 + 1;
            meshPartBuilder2.ensureVertices(i4);
            meshPartBuilder2.ensureIndices(i4);
            if (meshPartBuilder.getPrimitiveType() != 1) {
                throw new GdxRuntimeException((String) "Incorrect primitive type : expect GL_LINES because innerWidth == width && innerHeight == height");
            }
        } else {
            int i5 = i2 + 1;
            meshPartBuilder2.ensureVertices(i5 * 2);
            meshPartBuilder2.ensureRectangleIndices(i5);
        }
        float f32 = ((f19 - f18) * 0.017453292f) / ((float) i2);
        Vector3 vector33 = BaseShapeBuilder.tmpV1;
        vector33.x = f26;
        vector33.y = f27;
        vector33.z = f28;
        float f33 = f18 * 0.017453292f;
        vector33.scl(f2 * 0.5f);
        Vector3 vector34 = BaseShapeBuilder.tmpV2;
        vector34.x = f29;
        vector34.y = f30;
        vector34.z = f31;
        Vector3 vector35 = vector33;
        vector34.scl(f3 * 0.5f);
        Vector3 vector36 = BaseShapeBuilder.tmpV3;
        vector36.x = f26;
        vector36.y = f27;
        vector36.z = f28;
        vector36.scl(f4 * 0.5f);
        Vector3 vector37 = BaseShapeBuilder.tmpV4;
        vector37.x = f29;
        vector37.y = f30;
        vector37.z = f31;
        vector37.scl(f5 * 0.5f);
        VertexInfo vertexInfo = BaseShapeBuilder.vertTmp3.set(null, null, null, null);
        vertexInfo.hasNormal = true;
        vertexInfo.hasPosition = true;
        vertexInfo.hasUV = true;
        Vector2 vector2 = vertexInfo.uv;
        vector2.x = 0.5f;
        vector2.y = 0.5f;
        Vector3 vector38 = vertexInfo.position;
        vector38.x = f20;
        vector38.y = f21;
        vector38.z = f22;
        Vector3 vector39 = vertexInfo.normal;
        vector39.x = f23;
        vector39.y = f24;
        vector39.z = f25;
        VertexInfo vertexInfo2 = BaseShapeBuilder.vertTmp4.set(null, null, null, null);
        vertexInfo2.hasNormal = true;
        vertexInfo2.hasPosition = true;
        vertexInfo2.hasUV = true;
        Vector2 vector22 = vertexInfo2.uv;
        vector22.x = 0.5f;
        vector22.y = 0.5f;
        Vector3 vector310 = vertexInfo2.position;
        vector310.x = f20;
        vector310.y = f21;
        vector310.z = f22;
        Vector3 vector311 = vertexInfo2.normal;
        vector311.x = f23;
        vector311.y = f24;
        vector311.z = f25;
        short vertex = meshPartBuilder2.vertex(vertexInfo2);
        float f34 = (f4 / f2) * 0.5f;
        float f35 = (f5 / f3) * 0.5f;
        int i6 = 0;
        int i7 = i;
        short s4 = 0;
        short s5 = 0;
        short s6 = 0;
        while (i6 <= i7) {
            float f36 = (((float) i6) * f32) + f33;
            float cos = MathUtils.cos(f36);
            float sin = MathUtils.sin(f36);
            short s7 = vertex;
            Vector3 vector312 = vertexInfo2.position;
            vector312.x = f20;
            vector312.y = f21;
            vector312.z = f22;
            float f37 = f35;
            short s8 = s5;
            Vector3 vector313 = vector35;
            float f38 = f34;
            Vector3 vector314 = vector37;
            vector35 = vector313;
            vector312.add((vector34.x * sin) + (vector313.x * cos), (vector34.y * sin) + (vector313.y * cos), (vector34.z * sin) + (vector313.z * cos));
            Vector2 vector23 = vertexInfo2.uv;
            vector23.x = (cos * 0.5f) + 0.5f;
            vector23.y = (sin * 0.5f) + 0.5f;
            short vertex2 = meshPartBuilder2.vertex(vertexInfo2);
            if (i3 <= 0 || f5 <= 0.0f) {
                s = s8;
                vector32 = vector314;
                vector3 = vector34;
                s3 = s6;
                s2 = s7;
                if (i6 != 0) {
                    meshPartBuilder2.triangle(vertex2, s4, s2);
                }
            } else if (f4 == f2 && f5 == f3) {
                if (i6 != 0) {
                    meshPartBuilder2.line(vertex2, s4);
                }
                s = s8;
                vector32 = vector314;
                vector3 = vector34;
                s3 = s6;
                s2 = s7;
            } else {
                Vector3 vector315 = vertexInfo.position;
                vector315.x = f20;
                vector315.y = f21;
                vector315.z = f22;
                vector32 = vector314;
                vector3 = vector34;
                vector315.add((vector32.x * sin) + (vector36.x * cos), (vector32.y * sin) + (vector36.y * cos), (vector32.z * sin) + (vector36.z * cos));
                Vector2 vector24 = vertexInfo.uv;
                vector24.x = (f38 * cos) + 0.5f;
                vector24.y = (f37 * sin) + 0.5f;
                short vertex3 = meshPartBuilder2.vertex(vertexInfo);
                if (i6 != 0) {
                    meshPartBuilder2.rect(vertex3, vertex2, s6, s8);
                }
                s = vertex3;
                s6 = vertex2;
                s2 = s7;
                i6++;
                i7 = i;
                f35 = f37;
                s4 = vertex2;
                vector37 = vector32;
                vertex = s2;
                s5 = s;
                vector34 = vector3;
                f34 = f38;
            }
            s6 = s3;
            i6++;
            i7 = i;
            f35 = f37;
            s4 = vertex2;
            vector37 = vector32;
            vertex = s2;
            s5 = s;
            vector34 = vector3;
            f34 = f38;
        }
    }
}
