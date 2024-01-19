package com.badlogic.gdx.graphics.g3d.utils.shapebuilders;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.RenderableProvider;
import com.badlogic.gdx.graphics.g3d.model.MeshPart;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Array.ArrayIterator;
import com.badlogic.gdx.utils.FlushablePool;

public class RenderableShapeBuilder extends BaseShapeBuilder {
    public static final int FLOAT_BYTES = 4;
    public static short[] indices;
    public static final Array<Renderable> renderables = new Array<>();
    public static final RenderablePool renderablesPool = new RenderablePool();
    public static float[] vertices;

    public static class RenderablePool extends FlushablePool<Renderable> {
        public Renderable newObject() {
            return new Renderable();
        }

        public Renderable obtain() {
            Renderable renderable = (Renderable) super.obtain();
            renderable.environment = null;
            renderable.material = null;
            renderable.meshPart.set("", null, 0, 0, 0);
            renderable.shader = null;
            renderable.userData = null;
            return renderable;
        }
    }

    public static void buildNormals(MeshPartBuilder meshPartBuilder, RenderableProvider renderableProvider, float f2) {
        buildNormals(meshPartBuilder, renderableProvider, f2, BaseShapeBuilder.tmpColor0.set(0.0f, 0.0f, 1.0f, 1.0f), BaseShapeBuilder.tmpColor1.set(1.0f, 0.0f, 0.0f, 1.0f), BaseShapeBuilder.tmpColor2.set(0.0f, 1.0f, 0.0f, 1.0f));
    }

    public static void ensureIndicesCapacity(int i) {
        short[] sArr = indices;
        if (sArr == null || sArr.length < i) {
            indices = new short[i];
        }
    }

    public static void ensureVerticesCapacity(int i) {
        float[] fArr = vertices;
        if (fArr == null || fArr.length < i) {
            vertices = new float[i];
        }
    }

    public static short maxVerticeInIndices() {
        short s = Short.MIN_VALUE;
        int i = 0;
        while (true) {
            short[] sArr = indices;
            if (i >= sArr.length) {
                return s;
            }
            if (sArr[i] > s) {
                s = sArr[i];
            }
            i++;
        }
    }

    public static short minVerticeInIndices() {
        short s = Short.MAX_VALUE;
        int i = 0;
        while (true) {
            short[] sArr = indices;
            if (i >= sArr.length) {
                return s;
            }
            if (sArr[i] < s) {
                s = sArr[i];
            }
            i++;
        }
    }

    public static void buildNormals(MeshPartBuilder meshPartBuilder, RenderableProvider renderableProvider, float f2, Color color, Color color2, Color color3) {
        renderableProvider.getRenderables(renderables, renderablesPool);
        ArrayIterator it = renderables.iterator();
        while (it.hasNext()) {
            buildNormals(meshPartBuilder, (Renderable) it.next(), f2, color, color2, color3);
        }
        renderablesPool.flush();
        renderables.clear();
    }

    public static void buildNormals(MeshPartBuilder meshPartBuilder, Renderable renderable, float f2, Color color, Color color2, Color color3) {
        int i;
        int i2;
        MeshPartBuilder meshPartBuilder2 = meshPartBuilder;
        Renderable renderable2 = renderable;
        float f3 = f2;
        Mesh mesh = renderable2.meshPart.mesh;
        int i3 = mesh.getVertexAttribute(1) != null ? mesh.getVertexAttribute(1).offset / 4 : -1;
        int i4 = mesh.getVertexAttribute(8) != null ? mesh.getVertexAttribute(8).offset / 4 : -1;
        int i5 = mesh.getVertexAttribute(128) != null ? mesh.getVertexAttribute(128).offset / 4 : -1;
        int i6 = mesh.getVertexAttribute(256) != null ? mesh.getVertexAttribute(256).offset / 4 : -1;
        int vertexSize = mesh.getVertexSize() / 4;
        if (mesh.getNumIndices() > 0) {
            ensureIndicesCapacity(mesh.getNumIndices());
            MeshPart meshPart = renderable2.meshPart;
            mesh.getIndices(meshPart.offset, meshPart.size, indices, 0);
            i2 = minVerticeInIndices();
            i = maxVerticeInIndices() - i2;
        } else {
            MeshPart meshPart2 = renderable2.meshPart;
            int i7 = meshPart2.offset;
            i = meshPart2.size;
            i2 = i7;
        }
        int i8 = i * vertexSize;
        ensureVerticesCapacity(i8);
        mesh.getVertices(i2 * vertexSize, i8, vertices, 0);
        while (i2 < i) {
            int i9 = i2 * vertexSize;
            Vector3 vector3 = BaseShapeBuilder.tmpV0;
            float[] fArr = vertices;
            int i10 = i9 + i3;
            vector3.set(fArr[i10], fArr[i10 + 1], fArr[i10 + 2]);
            int i11 = -1;
            if (i4 != -1) {
                Vector3 vector32 = BaseShapeBuilder.tmpV1;
                float[] fArr2 = vertices;
                int i12 = i9 + i4;
                vector32.set(fArr2[i12], fArr2[i12 + 1], fArr2[i12 + 2]);
                Vector3 vector33 = BaseShapeBuilder.tmpV2;
                vector33.set(BaseShapeBuilder.tmpV0);
                Vector3 vector34 = BaseShapeBuilder.tmpV1;
                vector34.scl(f3);
                vector33.add(vector34);
                i11 = -1;
            }
            if (i5 != i11) {
                Vector3 vector35 = BaseShapeBuilder.tmpV3;
                float[] fArr3 = vertices;
                int i13 = i9 + i5;
                vector35.set(fArr3[i13], fArr3[i13 + 1], fArr3[i13 + 2]);
                Vector3 vector36 = BaseShapeBuilder.tmpV4;
                vector36.set(BaseShapeBuilder.tmpV0);
                Vector3 vector37 = BaseShapeBuilder.tmpV3;
                vector37.scl(f3);
                vector36.add(vector37);
                i11 = -1;
            }
            if (i6 != i11) {
                Vector3 vector38 = BaseShapeBuilder.tmpV5;
                float[] fArr4 = vertices;
                int i14 = i9 + i6;
                vector38.set(fArr4[i14], fArr4[i14 + 1], fArr4[i14 + 2]);
                Vector3 vector39 = BaseShapeBuilder.tmpV6;
                vector39.set(BaseShapeBuilder.tmpV0);
                Vector3 vector310 = BaseShapeBuilder.tmpV5;
                vector310.scl(f3);
                vector39.add(vector310);
            }
            BaseShapeBuilder.tmpV0.mul(renderable2.worldTransform);
            BaseShapeBuilder.tmpV2.mul(renderable2.worldTransform);
            BaseShapeBuilder.tmpV4.mul(renderable2.worldTransform);
            BaseShapeBuilder.tmpV6.mul(renderable2.worldTransform);
            Color color4 = color;
            if (i4 != -1) {
                meshPartBuilder2.setColor(color4);
                meshPartBuilder2.line(BaseShapeBuilder.tmpV0, BaseShapeBuilder.tmpV2);
            }
            Color color5 = color2;
            if (i5 != -1) {
                meshPartBuilder2.setColor(color5);
                meshPartBuilder2.line(BaseShapeBuilder.tmpV0, BaseShapeBuilder.tmpV4);
            }
            Color color6 = color3;
            if (i6 != -1) {
                meshPartBuilder2.setColor(color6);
                meshPartBuilder2.line(BaseShapeBuilder.tmpV0, BaseShapeBuilder.tmpV6);
            }
            i2++;
        }
    }
}
