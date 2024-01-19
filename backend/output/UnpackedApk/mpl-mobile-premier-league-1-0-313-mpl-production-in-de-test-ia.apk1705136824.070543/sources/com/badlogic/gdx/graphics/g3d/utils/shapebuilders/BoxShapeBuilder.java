package com.badlogic.gdx.graphics.g3d.utils.shapebuilders;

import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder.VertexInfo;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;

public class BoxShapeBuilder extends BaseShapeBuilder {
    public static void build(MeshPartBuilder meshPartBuilder, BoundingBox boundingBox) {
        Vector3 obtainV3 = BaseShapeBuilder.obtainV3();
        Vector3 vector3 = boundingBox.min;
        obtainV3.set(vector3.x, vector3.y, vector3.z);
        Vector3 obtainV32 = BaseShapeBuilder.obtainV3();
        Vector3 vector32 = boundingBox.min;
        obtainV32.set(vector32.x, boundingBox.max.y, vector32.z);
        Vector3 obtainV33 = BaseShapeBuilder.obtainV3();
        float f2 = boundingBox.max.x;
        Vector3 vector33 = boundingBox.min;
        obtainV33.set(f2, vector33.y, vector33.z);
        Vector3 obtainV34 = BaseShapeBuilder.obtainV3();
        Vector3 vector34 = boundingBox.max;
        obtainV34.set(vector34.x, vector34.y, boundingBox.min.z);
        Vector3 obtainV35 = BaseShapeBuilder.obtainV3();
        Vector3 vector35 = boundingBox.min;
        obtainV35.set(vector35.x, vector35.y, boundingBox.max.z);
        Vector3 obtainV36 = BaseShapeBuilder.obtainV3();
        float f3 = boundingBox.min.x;
        Vector3 vector36 = boundingBox.max;
        obtainV36.set(f3, vector36.y, vector36.z);
        Vector3 obtainV37 = BaseShapeBuilder.obtainV3();
        Vector3 vector37 = boundingBox.max;
        obtainV37.set(vector37.x, boundingBox.min.y, vector37.z);
        Vector3 obtainV38 = BaseShapeBuilder.obtainV3();
        Vector3 vector38 = boundingBox.max;
        obtainV38.set(vector38.x, vector38.y, vector38.z);
        meshPartBuilder.box(obtainV3, obtainV32, obtainV33, obtainV34, obtainV35, obtainV36, obtainV37, obtainV38);
        BaseShapeBuilder.freeAll();
    }

    public static void build(MeshPartBuilder meshPartBuilder, VertexInfo vertexInfo, VertexInfo vertexInfo2, VertexInfo vertexInfo3, VertexInfo vertexInfo4, VertexInfo vertexInfo5, VertexInfo vertexInfo6, VertexInfo vertexInfo7, VertexInfo vertexInfo8) {
        meshPartBuilder.ensureVertices(8);
        short vertex = meshPartBuilder.vertex(vertexInfo);
        short vertex2 = meshPartBuilder.vertex(vertexInfo3);
        short vertex3 = meshPartBuilder.vertex(vertexInfo4);
        short vertex4 = meshPartBuilder.vertex(vertexInfo2);
        short vertex5 = meshPartBuilder.vertex(vertexInfo5);
        short vertex6 = meshPartBuilder.vertex(vertexInfo7);
        short vertex7 = meshPartBuilder.vertex(vertexInfo8);
        short vertex8 = meshPartBuilder.vertex(vertexInfo6);
        int primitiveType = meshPartBuilder.getPrimitiveType();
        if (primitiveType == 1) {
            meshPartBuilder.ensureIndices(24);
            meshPartBuilder.rect(vertex, vertex2, vertex3, vertex4);
            meshPartBuilder.rect(vertex6, vertex5, vertex8, vertex7);
            meshPartBuilder.index(vertex, vertex5, vertex4, vertex8, vertex3, vertex7, vertex2, vertex6);
        } else if (primitiveType == 0) {
            meshPartBuilder.ensureRectangleIndices(2);
            meshPartBuilder.rect(vertex, vertex2, vertex3, vertex4);
            meshPartBuilder.rect(vertex6, vertex5, vertex8, vertex7);
        } else {
            meshPartBuilder.ensureRectangleIndices(6);
            meshPartBuilder.rect(vertex, vertex2, vertex3, vertex4);
            meshPartBuilder.rect(vertex6, vertex5, vertex8, vertex7);
            meshPartBuilder.rect(vertex, vertex4, vertex8, vertex5);
            meshPartBuilder.rect(vertex6, vertex7, vertex3, vertex2);
            meshPartBuilder.rect(vertex6, vertex2, vertex, vertex5);
            meshPartBuilder.rect(vertex3, vertex7, vertex8, vertex4);
        }
    }

    public static void build(MeshPartBuilder meshPartBuilder, Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34, Vector3 vector35, Vector3 vector36, Vector3 vector37, Vector3 vector38) {
        MeshPartBuilder meshPartBuilder2 = meshPartBuilder;
        Vector3 vector39 = vector3;
        Vector3 vector310 = vector32;
        Vector3 vector311 = vector33;
        Vector3 vector312 = vector34;
        Vector3 vector313 = vector35;
        Vector3 vector314 = vector36;
        Vector3 vector315 = vector37;
        Vector3 vector316 = vector38;
        if ((meshPartBuilder.getAttributes().getMask() & 408) == 0) {
            build(meshPartBuilder, BaseShapeBuilder.vertTmp1.set(vector39, null, null, null), BaseShapeBuilder.vertTmp2.set(vector310, null, null, null), BaseShapeBuilder.vertTmp3.set(vector311, null, null, null), BaseShapeBuilder.vertTmp4.set(vector312, null, null, null), BaseShapeBuilder.vertTmp5.set(vector313, null, null, null), BaseShapeBuilder.vertTmp6.set(vector314, null, null, null), BaseShapeBuilder.vertTmp7.set(vector315, null, null, null), BaseShapeBuilder.vertTmp8.set(vector316, null, null, null));
            return;
        }
        meshPartBuilder2.ensureVertices(24);
        meshPartBuilder2.ensureRectangleIndices(6);
        Vector3 vector317 = BaseShapeBuilder.tmpV1;
        vector317.set(vector39);
        vector317.lerp(vector312, 0.5f);
        Vector3 vector318 = BaseShapeBuilder.tmpV2;
        vector318.set(vector313);
        vector318.lerp(vector316, 0.5f);
        vector317.sub(vector318);
        Vector3 nor = vector317.nor();
        MeshPartBuilder meshPartBuilder3 = meshPartBuilder;
        Vector3 vector319 = nor;
        meshPartBuilder3.rect(vector3, vector32, vector34, vector33, nor);
        vector319.scl(-1.0f);
        meshPartBuilder3.rect(vector36, vector35, vector37, vector38, vector319);
        Vector3 vector320 = BaseShapeBuilder.tmpV1;
        vector320.set(vector39);
        vector320.lerp(vector315, 0.5f);
        Vector3 vector321 = BaseShapeBuilder.tmpV2;
        vector321.set(vector310);
        vector321.lerp(vector316, 0.5f);
        vector320.sub(vector321);
        Vector3 nor2 = vector320.nor();
        MeshPartBuilder meshPartBuilder4 = meshPartBuilder;
        Vector3 vector322 = nor2;
        meshPartBuilder4.rect(vector35, vector3, vector33, vector37, nor2);
        nor2.scl(-1.0f);
        Vector3 vector323 = vector36;
        meshPartBuilder4.rect(vector32, vector323, vector38, vector34, nor2);
        Vector3 vector324 = BaseShapeBuilder.tmpV1;
        vector324.set(vector39);
        vector324.lerp(vector314, 0.5f);
        Vector3 vector325 = BaseShapeBuilder.tmpV2;
        vector325.set(vector311);
        vector325.lerp(vector316, 0.5f);
        vector324.sub(vector325);
        Vector3 nor3 = vector324.nor();
        Vector3 vector326 = nor3;
        meshPartBuilder.rect(vector35, vector323, vector32, vector3, vector326);
        nor3.scl(-1.0f);
        meshPartBuilder.rect(vector33, vector34, vector38, vector37, vector326);
    }

    public static void build(MeshPartBuilder meshPartBuilder, Matrix4 matrix4) {
        Vector3 obtainV3 = BaseShapeBuilder.obtainV3();
        obtainV3.set(-0.5f, -0.5f, -0.5f);
        obtainV3.mul(matrix4);
        Vector3 obtainV32 = BaseShapeBuilder.obtainV3();
        obtainV32.set(-0.5f, 0.5f, -0.5f);
        obtainV32.mul(matrix4);
        Vector3 obtainV33 = BaseShapeBuilder.obtainV3();
        obtainV33.set(0.5f, -0.5f, -0.5f);
        obtainV33.mul(matrix4);
        Vector3 obtainV34 = BaseShapeBuilder.obtainV3();
        obtainV34.set(0.5f, 0.5f, -0.5f);
        obtainV34.mul(matrix4);
        Vector3 obtainV35 = BaseShapeBuilder.obtainV3();
        obtainV35.set(-0.5f, -0.5f, 0.5f);
        obtainV35.mul(matrix4);
        Vector3 obtainV36 = BaseShapeBuilder.obtainV3();
        obtainV36.set(-0.5f, 0.5f, 0.5f);
        obtainV36.mul(matrix4);
        Vector3 obtainV37 = BaseShapeBuilder.obtainV3();
        obtainV37.set(0.5f, -0.5f, 0.5f);
        obtainV37.mul(matrix4);
        Vector3 obtainV38 = BaseShapeBuilder.obtainV3();
        obtainV38.set(0.5f, 0.5f, 0.5f);
        obtainV38.mul(matrix4);
        build(meshPartBuilder, obtainV3, obtainV32, obtainV33, obtainV34, obtainV35, obtainV36, obtainV37, obtainV38);
        BaseShapeBuilder.freeAll();
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, float f4) {
        build(meshPartBuilder, 0.0f, 0.0f, 0.0f, f2, f3, f4);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = f5 * 0.5f;
        float f9 = f6 * 0.5f;
        float f10 = 0.5f * f7;
        float f11 = f2 - f8;
        float f12 = f3 - f9;
        float f13 = f4 - f10;
        float f14 = f2 + f8;
        float f15 = f3 + f9;
        float f16 = f4 + f10;
        Vector3 obtainV3 = BaseShapeBuilder.obtainV3();
        obtainV3.set(f11, f12, f13);
        Vector3 obtainV32 = BaseShapeBuilder.obtainV3();
        obtainV32.set(f11, f15, f13);
        Vector3 obtainV33 = BaseShapeBuilder.obtainV3();
        obtainV33.set(f14, f12, f13);
        Vector3 obtainV34 = BaseShapeBuilder.obtainV3();
        obtainV34.set(f14, f15, f13);
        Vector3 obtainV35 = BaseShapeBuilder.obtainV3();
        obtainV35.set(f11, f12, f16);
        Vector3 obtainV36 = BaseShapeBuilder.obtainV3();
        obtainV36.set(f11, f15, f16);
        Vector3 obtainV37 = BaseShapeBuilder.obtainV3();
        obtainV37.set(f14, f12, f16);
        Vector3 obtainV38 = BaseShapeBuilder.obtainV3();
        obtainV38.set(f14, f15, f16);
        build(meshPartBuilder, obtainV3, obtainV32, obtainV33, obtainV34, obtainV35, obtainV36, obtainV37, obtainV38);
        BaseShapeBuilder.freeAll();
    }
}
