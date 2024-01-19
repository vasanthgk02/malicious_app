package com.badlogic.gdx.graphics.g3d.particles.batches;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.DepthTestAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.model.MeshPart;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleShader;
import com.badlogic.gdx.graphics.g3d.particles.ParticleShader.AlignMode;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData.SaveData;
import com.badlogic.gdx.graphics.g3d.particles.renderers.BillboardControllerRenderData;
import com.badlogic.gdx.graphics.g3d.shaders.DefaultShader;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Array.ArrayIterator;
import com.badlogic.gdx.utils.Pool;

public class BillboardParticleBatch extends BufferedParticleBatch<BillboardControllerRenderData> {
    public static final VertexAttributes CPU_ATTRIBUTES = new VertexAttributes(new VertexAttribute(1, 3, ShaderProgram.POSITION_ATTRIBUTE), new VertexAttribute(16, 2, "a_texCoord0"), new VertexAttribute(2, 4, ShaderProgram.COLOR_ATTRIBUTE));
    public static final int CPU_COLOR_OFFSET = ((short) (CPU_ATTRIBUTES.findByUsage(2).offset / 4));
    public static final int CPU_POSITION_OFFSET = ((short) (CPU_ATTRIBUTES.findByUsage(1).offset / 4));
    public static final int CPU_UV_OFFSET = ((short) (CPU_ATTRIBUTES.findByUsage(16).offset / 4));
    public static final int CPU_VERTEX_SIZE = (CPU_ATTRIBUTES.vertexSize / 4);
    public static final VertexAttributes GPU_ATTRIBUTES = new VertexAttributes(new VertexAttribute(1, 3, ShaderProgram.POSITION_ATTRIBUTE), new VertexAttribute(16, 2, "a_texCoord0"), new VertexAttribute(2, 4, ShaderProgram.COLOR_ATTRIBUTE), new VertexAttribute(512, 4, "a_sizeAndRotation"));
    public static final int GPU_COLOR_OFFSET = ((short) (GPU_ATTRIBUTES.findByUsage(2).offset / 4));
    public static final int GPU_POSITION_OFFSET = ((short) (GPU_ATTRIBUTES.findByUsage(1).offset / 4));
    public static final int GPU_SIZE_ROTATION_OFFSET = ((short) (GPU_ATTRIBUTES.findByUsage(512).offset / 4));
    public static final int GPU_UV_OFFSET = ((short) (GPU_ATTRIBUTES.findByUsage(16).offset / 4));
    public static final int GPU_VERTEX_SIZE = (GPU_ATTRIBUTES.vertexSize / 4);
    public static final int MAX_PARTICLES_PER_MESH = 8191;
    public static final int MAX_VERTICES_PER_MESH = 32764;
    public static final Matrix3 TMP_M3 = new Matrix3();
    public static final Vector3 TMP_V1 = new Vector3();
    public static final Vector3 TMP_V2 = new Vector3();
    public static final Vector3 TMP_V3 = new Vector3();
    public static final Vector3 TMP_V4 = new Vector3();
    public static final Vector3 TMP_V5 = new Vector3();
    public static final Vector3 TMP_V6 = new Vector3();
    public static final int directionUsage = 1024;
    public static final int sizeAndRotationUsage = 512;
    public BlendingAttribute blendingAttribute;
    public VertexAttributes currentAttributes;
    public int currentVertexSize;
    public DepthTestAttribute depthTestAttribute;
    public short[] indices;
    public AlignMode mode;
    public RenderablePool renderablePool;
    public Array<Renderable> renderables;
    public Shader shader;
    public Texture texture;
    public boolean useGPU;
    public float[] vertices;

    public static class Config {
        public AlignMode mode;
        public boolean useGPU;

        public Config() {
        }

        public Config(boolean z, AlignMode alignMode) {
            this.useGPU = z;
            this.mode = alignMode;
        }
    }

    public class RenderablePool extends Pool<Renderable> {
        public RenderablePool() {
        }

        public Renderable newObject() {
            return BillboardParticleBatch.this.allocRenderable();
        }
    }

    public BillboardParticleBatch(AlignMode alignMode, boolean z, int i, BlendingAttribute blendingAttribute2, DepthTestAttribute depthTestAttribute2) {
        super(BillboardControllerRenderData.class);
        this.currentVertexSize = 0;
        this.useGPU = false;
        this.mode = AlignMode.Screen;
        this.renderables = new Array<>();
        this.renderablePool = new RenderablePool();
        this.blendingAttribute = blendingAttribute2;
        this.depthTestAttribute = depthTestAttribute2;
        if (blendingAttribute2 == null) {
            this.blendingAttribute = new BlendingAttribute(1, GL20.GL_ONE_MINUS_SRC_ALPHA, 1.0f);
        }
        if (this.depthTestAttribute == null) {
            this.depthTestAttribute = new DepthTestAttribute(GL20.GL_LEQUAL, false);
        }
        allocIndices();
        initRenderData();
        ensureCapacity(i);
        setUseGpu(z);
        setAlignMode(alignMode);
    }

    private void allocIndices() {
        this.indices = new short[49146];
        int i = 0;
        int i2 = 0;
        while (i < 49146) {
            short[] sArr = this.indices;
            short s = (short) i2;
            sArr[i] = s;
            sArr[i + 1] = (short) (i2 + 1);
            short s2 = (short) (i2 + 2);
            sArr[i + 2] = s2;
            sArr[i + 3] = s2;
            sArr[i + 4] = (short) (i2 + 3);
            sArr[i + 5] = s;
            i += 6;
            i2 += 4;
        }
    }

    private void allocRenderables(int i) {
        int ceil = MathUtils.ceil((float) (i / MAX_PARTICLES_PER_MESH));
        int free = this.renderablePool.getFree();
        if (free < ceil) {
            int i2 = ceil - free;
            for (int i3 = 0; i3 < i2; i3++) {
                RenderablePool renderablePool2 = this.renderablePool;
                renderablePool2.free(renderablePool2.newObject());
            }
        }
    }

    private void allocShader() {
        Renderable allocRenderable = allocRenderable();
        Shader shader2 = getShader(allocRenderable);
        allocRenderable.shader = shader2;
        this.shader = shader2;
        this.renderablePool.free(allocRenderable);
    }

    private void clearRenderablesPool() {
        this.renderablePool.freeAll(this.renderables);
        int free = this.renderablePool.getFree();
        for (int i = 0; i < free; i++) {
            ((Renderable) this.renderablePool.obtain()).meshPart.mesh.dispose();
        }
        this.renderables.clear();
    }

    private void fillVerticesGPU(int[] iArr) {
        ArrayIterator it = this.renderData.iterator();
        int i = 0;
        while (it.hasNext()) {
            BillboardControllerRenderData billboardControllerRenderData = (BillboardControllerRenderData) it.next();
            FloatChannel floatChannel = billboardControllerRenderData.scaleChannel;
            FloatChannel floatChannel2 = billboardControllerRenderData.regionChannel;
            FloatChannel floatChannel3 = billboardControllerRenderData.positionChannel;
            FloatChannel floatChannel4 = billboardControllerRenderData.colorChannel;
            FloatChannel floatChannel5 = billboardControllerRenderData.rotationChannel;
            int i2 = billboardControllerRenderData.controller.particles.size;
            int i3 = 0;
            while (i3 < i2) {
                int i4 = iArr[i] * this.currentVertexSize * 4;
                float f2 = floatChannel.data[floatChannel.strideSize * i3];
                int i5 = floatChannel2.strideSize * i3;
                int i6 = floatChannel3.strideSize * i3;
                int i7 = floatChannel4.strideSize * i3;
                int i8 = floatChannel5.strideSize * i3;
                ArrayIterator arrayIterator = it;
                float[] fArr = floatChannel3.data;
                float f3 = fArr[i6 + 0];
                float f4 = fArr[i6 + 1];
                float f5 = fArr[i6 + 2];
                float[] fArr2 = floatChannel2.data;
                float f6 = fArr2[i5 + 0];
                float f7 = fArr2[i5 + 1];
                float f8 = fArr2[i5 + 2];
                float f9 = fArr2[i5 + 3];
                int i9 = i2;
                float f10 = fArr2[i5 + 4] * f2;
                float f11 = fArr2[i5 + 5] * f2;
                float[] fArr3 = floatChannel4.data;
                float f12 = fArr3[i7 + 0];
                float f13 = fArr3[i7 + 1];
                float f14 = fArr3[i7 + 2];
                float f15 = fArr3[i7 + 3];
                float[] fArr4 = floatChannel5.data;
                float f16 = fArr4[i8 + 0];
                float f17 = fArr4[i8 + 1];
                float f18 = -f11;
                float f19 = -f10;
                putVertex(this.vertices, i4, f3, f4, f5, f6, f9, f19, f18, f16, f17, f12, f13, f14, f15);
                int i10 = i4 + this.currentVertexSize;
                float f20 = f3;
                float f21 = f4;
                float f22 = f5;
                float f23 = f8;
                float f24 = f10;
                float f25 = f16;
                float f26 = f17;
                float f27 = f12;
                float f28 = f13;
                float f29 = f14;
                float f30 = f15;
                putVertex(this.vertices, i10, f20, f21, f22, f23, f9, f24, f18, f25, f26, f27, f28, f29, f30);
                int i11 = i10 + this.currentVertexSize;
                float f31 = f7;
                float f32 = f11;
                putVertex(this.vertices, i11, f20, f21, f22, f23, f31, f24, f32, f25, f26, f27, f28, f29, f30);
                putVertex(this.vertices, i11 + this.currentVertexSize, f20, f21, f22, f6, f31, f19, f32, f25, f26, f27, f28, f29, f30);
                i3++;
                i++;
                it = arrayIterator;
                i2 = i9;
            }
        }
    }

    private void fillVerticesToScreenCPU(int[] iArr) {
        Vector3 vector3;
        Vector3 vector32;
        Vector3 vector33 = TMP_V3;
        vector33.set(this.camera.direction);
        vector33.scl(-1.0f);
        Vector3 vector34 = TMP_V4;
        vector34.set(this.camera.up);
        vector34.crs(vector33);
        Vector3 nor = vector34.nor();
        Vector3 vector35 = this.camera.up;
        ArrayIterator it = this.renderData.iterator();
        int i = 0;
        while (it.hasNext()) {
            BillboardControllerRenderData billboardControllerRenderData = (BillboardControllerRenderData) it.next();
            FloatChannel floatChannel = billboardControllerRenderData.scaleChannel;
            FloatChannel floatChannel2 = billboardControllerRenderData.regionChannel;
            FloatChannel floatChannel3 = billboardControllerRenderData.positionChannel;
            FloatChannel floatChannel4 = billboardControllerRenderData.colorChannel;
            FloatChannel floatChannel5 = billboardControllerRenderData.rotationChannel;
            int i2 = billboardControllerRenderData.controller.particles.size;
            int i3 = 0;
            while (i3 < i2) {
                int i4 = iArr[i] * this.currentVertexSize * 4;
                float f2 = floatChannel.data[floatChannel.strideSize * i3];
                int i5 = floatChannel2.strideSize * i3;
                ArrayIterator arrayIterator = it;
                int i6 = floatChannel3.strideSize * i3;
                int i7 = i2;
                int i8 = floatChannel4.strideSize * i3;
                FloatChannel floatChannel6 = floatChannel;
                int i9 = floatChannel5.strideSize * i3;
                int i10 = i;
                float[] fArr = floatChannel3.data;
                FloatChannel floatChannel7 = floatChannel3;
                float f3 = fArr[i6 + 0];
                int i11 = i3;
                float f4 = fArr[i6 + 1];
                float f5 = fArr[i6 + 2];
                float[] fArr2 = floatChannel2.data;
                float f6 = fArr2[i5 + 0];
                float f7 = fArr2[i5 + 1];
                float f8 = fArr2[i5 + 2];
                float f9 = fArr2[i5 + 3];
                FloatChannel floatChannel8 = floatChannel2;
                float f10 = fArr2[i5 + 4] * f2;
                float f11 = fArr2[i5 + 5] * f2;
                float[] fArr3 = floatChannel4.data;
                float f12 = fArr3[i8 + 0];
                float f13 = fArr3[i8 + 1];
                float f14 = fArr3[i8 + 2];
                float f15 = fArr3[i8 + 3];
                float[] fArr4 = floatChannel5.data;
                float f16 = fArr4[i9 + 0];
                float f17 = fArr4[i9 + 1];
                Vector3 vector36 = TMP_V1;
                vector36.set(nor);
                vector36.scl(f10);
                Vector3 vector37 = TMP_V2;
                vector37.set(vector35);
                vector37.scl(f11);
                if (f16 != 1.0f) {
                    TMP_M3.setToRotation(vector33, f16, f17);
                    float[] fArr5 = this.vertices;
                    Vector3 vector38 = TMP_V6;
                    Vector3 vector39 = TMP_V1;
                    Vector3 vector310 = TMP_V2;
                    vector32 = vector33;
                    vector3 = nor;
                    vector38.set((-vector39.x) - vector310.x, (-vector39.y) - vector310.y, (-vector39.z) - vector310.z);
                    vector38.mul(TMP_M3);
                    vector38.add(f3, f4, f5);
                    putVertex(fArr5, i4, vector38, f6, f9, f12, f13, f14, f15);
                    int i12 = i4 + this.currentVertexSize;
                    float[] fArr6 = this.vertices;
                    Vector3 vector311 = TMP_V6;
                    Vector3 vector312 = TMP_V1;
                    float f18 = vector312.x;
                    Vector3 vector313 = TMP_V2;
                    vector311.set(f18 - vector313.x, vector312.y - vector313.y, vector312.z - vector313.z);
                    vector311.mul(TMP_M3);
                    vector311.add(f3, f4, f5);
                    float f19 = f8;
                    float f20 = f12;
                    float f21 = f13;
                    float f22 = f14;
                    float f23 = f15;
                    putVertex(fArr6, i12, vector311, f19, f9, f20, f21, f22, f23);
                    int i13 = i12 + this.currentVertexSize;
                    float[] fArr7 = this.vertices;
                    Vector3 vector314 = TMP_V6;
                    Vector3 vector315 = TMP_V1;
                    float f24 = vector315.x;
                    Vector3 vector316 = TMP_V2;
                    vector314.set(f24 + vector316.x, vector315.y + vector316.y, vector315.z + vector316.z);
                    vector314.mul(TMP_M3);
                    vector314.add(f3, f4, f5);
                    putVertex(fArr7, i13, vector314, f19, f7, f20, f21, f22, f23);
                    int i14 = i13 + this.currentVertexSize;
                    float[] fArr8 = this.vertices;
                    Vector3 vector317 = TMP_V6;
                    Vector3 vector318 = TMP_V1;
                    Vector3 vector319 = TMP_V2;
                    vector317.set((-vector318.x) + vector319.x, (-vector318.y) + vector319.y, (-vector318.z) + vector319.z);
                    vector317.mul(TMP_M3);
                    vector317.add(f3, f4, f5);
                    putVertex(fArr8, i14, vector317, f6, f7, f12, f13, f14, f15);
                } else {
                    vector32 = vector33;
                    vector3 = nor;
                    float[] fArr9 = this.vertices;
                    Vector3 vector320 = TMP_V6;
                    Vector3 vector321 = TMP_V1;
                    Vector3 vector322 = TMP_V2;
                    vector320.set(((-vector321.x) - vector322.x) + f3, ((-vector321.y) - vector322.y) + f4, ((-vector321.z) - vector322.z) + f5);
                    putVertex(fArr9, i4, vector320, f6, f9, f12, f13, f14, f15);
                    int i15 = i4 + this.currentVertexSize;
                    float[] fArr10 = this.vertices;
                    Vector3 vector323 = TMP_V6;
                    Vector3 vector324 = TMP_V1;
                    float f25 = vector324.x;
                    Vector3 vector325 = TMP_V2;
                    vector323.set((f25 - vector325.x) + f3, (vector324.y - vector325.y) + f4, (vector324.z - vector325.z) + f5);
                    float f26 = f8;
                    float f27 = f12;
                    float f28 = f13;
                    float f29 = f14;
                    float f30 = f15;
                    putVertex(fArr10, i15, vector323, f26, f9, f27, f28, f29, f30);
                    int i16 = i15 + this.currentVertexSize;
                    float[] fArr11 = this.vertices;
                    Vector3 vector326 = TMP_V6;
                    Vector3 vector327 = TMP_V1;
                    float f31 = vector327.x;
                    Vector3 vector328 = TMP_V2;
                    vector326.set(f31 + vector328.x + f3, vector327.y + vector328.y + f4, vector327.z + vector328.z + f5);
                    putVertex(fArr11, i16, vector326, f26, f7, f27, f28, f29, f30);
                    int i17 = i16 + this.currentVertexSize;
                    float[] fArr12 = this.vertices;
                    Vector3 vector329 = TMP_V6;
                    Vector3 vector330 = TMP_V1;
                    Vector3 vector331 = TMP_V2;
                    vector329.set((-vector330.x) + vector331.x + f3, (-vector330.y) + vector331.y + f4, (-vector330.z) + vector331.z + f5);
                    putVertex(fArr12, i17, vector329, f6, f7, f12, f13, f14, f15);
                }
                i3 = i11 + 1;
                i = i10 + 1;
                it = arrayIterator;
                i2 = i7;
                floatChannel = floatChannel6;
                floatChannel3 = floatChannel7;
                floatChannel2 = floatChannel8;
                vector33 = vector32;
                nor = vector3;
            }
            int i18 = i;
        }
    }

    private void fillVerticesToViewPointCPU(int[] iArr) {
        ArrayIterator it = this.renderData.iterator();
        int i = 0;
        while (it.hasNext()) {
            BillboardControllerRenderData billboardControllerRenderData = (BillboardControllerRenderData) it.next();
            FloatChannel floatChannel = billboardControllerRenderData.scaleChannel;
            FloatChannel floatChannel2 = billboardControllerRenderData.regionChannel;
            FloatChannel floatChannel3 = billboardControllerRenderData.positionChannel;
            FloatChannel floatChannel4 = billboardControllerRenderData.colorChannel;
            FloatChannel floatChannel5 = billboardControllerRenderData.rotationChannel;
            int i2 = billboardControllerRenderData.controller.particles.size;
            int i3 = 0;
            while (i3 < i2) {
                int i4 = iArr[i] * this.currentVertexSize * 4;
                float f2 = floatChannel.data[floatChannel.strideSize * i3];
                int i5 = floatChannel2.strideSize * i3;
                int i6 = floatChannel3.strideSize * i3;
                int i7 = floatChannel4.strideSize * i3;
                int i8 = floatChannel5.strideSize * i3;
                ArrayIterator arrayIterator = it;
                float[] fArr = floatChannel3.data;
                int i9 = i2;
                float f3 = fArr[i6 + 0];
                FloatChannel floatChannel6 = floatChannel;
                float f4 = fArr[i6 + 1];
                float f5 = fArr[i6 + 2];
                float[] fArr2 = floatChannel2.data;
                float f6 = fArr2[i5 + 0];
                float f7 = fArr2[i5 + 1];
                float f8 = fArr2[i5 + 2];
                float f9 = fArr2[i5 + 3];
                FloatChannel floatChannel7 = floatChannel2;
                float f10 = fArr2[i5 + 4] * f2;
                float f11 = fArr2[i5 + 5] * f2;
                float[] fArr3 = floatChannel4.data;
                float f12 = fArr3[i7 + 0];
                float f13 = fArr3[i7 + 1];
                float f14 = fArr3[i7 + 2];
                float f15 = fArr3[i7 + 3];
                float[] fArr4 = floatChannel5.data;
                float f16 = fArr4[i8 + 0];
                float f17 = fArr4[i8 + 1];
                Vector3 vector3 = TMP_V3;
                vector3.set(this.camera.position);
                vector3.sub(f3, f4, f5);
                Vector3 nor = vector3.nor();
                Vector3 vector32 = TMP_V1;
                FloatChannel floatChannel8 = floatChannel3;
                vector32.set(this.camera.up);
                vector32.crs(nor);
                Vector3 nor2 = vector32.nor();
                Vector3 vector33 = TMP_V2;
                vector33.set(nor);
                vector33.crs(nor2);
                nor2.scl(f10);
                vector33.scl(f11);
                if (f16 != 1.0f) {
                    TMP_M3.setToRotation(nor, f16, f17);
                    float[] fArr5 = this.vertices;
                    Vector3 vector34 = TMP_V6;
                    Vector3 vector35 = TMP_V1;
                    Vector3 vector36 = TMP_V2;
                    vector34.set((-vector35.x) - vector36.x, (-vector35.y) - vector36.y, (-vector35.z) - vector36.z);
                    vector34.mul(TMP_M3);
                    vector34.add(f3, f4, f5);
                    putVertex(fArr5, i4, vector34, f6, f9, f12, f13, f14, f15);
                    int i10 = i4 + this.currentVertexSize;
                    float[] fArr6 = this.vertices;
                    Vector3 vector37 = TMP_V6;
                    Vector3 vector38 = TMP_V1;
                    float f18 = vector38.x;
                    Vector3 vector39 = TMP_V2;
                    vector37.set(f18 - vector39.x, vector38.y - vector39.y, vector38.z - vector39.z);
                    vector37.mul(TMP_M3);
                    vector37.add(f3, f4, f5);
                    float f19 = f8;
                    float f20 = f12;
                    float f21 = f13;
                    float f22 = f14;
                    float f23 = f15;
                    putVertex(fArr6, i10, vector37, f19, f9, f20, f21, f22, f23);
                    int i11 = i10 + this.currentVertexSize;
                    float[] fArr7 = this.vertices;
                    Vector3 vector310 = TMP_V6;
                    Vector3 vector311 = TMP_V1;
                    float f24 = vector311.x;
                    Vector3 vector312 = TMP_V2;
                    vector310.set(f24 + vector312.x, vector311.y + vector312.y, vector311.z + vector312.z);
                    vector310.mul(TMP_M3);
                    vector310.add(f3, f4, f5);
                    putVertex(fArr7, i11, vector310, f19, f7, f20, f21, f22, f23);
                    int i12 = i11 + this.currentVertexSize;
                    float[] fArr8 = this.vertices;
                    Vector3 vector313 = TMP_V6;
                    Vector3 vector314 = TMP_V1;
                    Vector3 vector315 = TMP_V2;
                    vector313.set((-vector314.x) + vector315.x, (-vector314.y) + vector315.y, (-vector314.z) + vector315.z);
                    vector313.mul(TMP_M3);
                    vector313.add(f3, f4, f5);
                    putVertex(fArr8, i12, vector313, f6, f7, f12, f13, f14, f15);
                } else {
                    float[] fArr9 = this.vertices;
                    Vector3 vector316 = TMP_V6;
                    Vector3 vector317 = TMP_V1;
                    Vector3 vector318 = TMP_V2;
                    vector316.set(((-vector317.x) - vector318.x) + f3, ((-vector317.y) - vector318.y) + f4, ((-vector317.z) - vector318.z) + f5);
                    putVertex(fArr9, i4, vector316, f6, f9, f12, f13, f14, f15);
                    int i13 = i4 + this.currentVertexSize;
                    float[] fArr10 = this.vertices;
                    Vector3 vector319 = TMP_V6;
                    Vector3 vector320 = TMP_V1;
                    float f25 = vector320.x;
                    Vector3 vector321 = TMP_V2;
                    vector319.set((f25 - vector321.x) + f3, (vector320.y - vector321.y) + f4, (vector320.z - vector321.z) + f5);
                    float f26 = f8;
                    float f27 = f12;
                    float f28 = f13;
                    float f29 = f14;
                    float f30 = f15;
                    putVertex(fArr10, i13, vector319, f26, f9, f27, f28, f29, f30);
                    int i14 = i13 + this.currentVertexSize;
                    float[] fArr11 = this.vertices;
                    Vector3 vector322 = TMP_V6;
                    Vector3 vector323 = TMP_V1;
                    float f31 = vector323.x;
                    Vector3 vector324 = TMP_V2;
                    vector322.set(f31 + vector324.x + f3, vector323.y + vector324.y + f4, vector323.z + vector324.z + f5);
                    putVertex(fArr11, i14, vector322, f26, f7, f27, f28, f29, f30);
                    int i15 = i14 + this.currentVertexSize;
                    float[] fArr12 = this.vertices;
                    Vector3 vector325 = TMP_V6;
                    Vector3 vector326 = TMP_V1;
                    Vector3 vector327 = TMP_V2;
                    vector325.set((-vector326.x) + vector327.x + f3, (-vector326.y) + vector327.y + f4, (-vector326.z) + vector327.z + f5);
                    putVertex(fArr12, i15, vector325, f6, f7, f12, f13, f14, f15);
                }
                i3++;
                i++;
                it = arrayIterator;
                i2 = i9;
                floatChannel = floatChannel6;
                floatChannel2 = floatChannel7;
                floatChannel3 = floatChannel8;
            }
        }
    }

    private void initRenderData() {
        setVertexData();
        clearRenderablesPool();
        allocShader();
        resetCapacity();
    }

    public static void putVertex(float[] fArr, int i, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14) {
        int i2 = GPU_POSITION_OFFSET;
        fArr[i + i2] = f2;
        fArr[i + i2 + 1] = f3;
        fArr[i2 + i + 2] = f4;
        int i3 = GPU_UV_OFFSET;
        fArr[i + i3] = f5;
        fArr[i3 + i + 1] = f6;
        int i4 = GPU_SIZE_ROTATION_OFFSET;
        fArr[i + i4] = f7;
        fArr[i + i4 + 1] = f8;
        fArr[i + i4 + 2] = f9;
        fArr[i4 + i + 3] = f10;
        int i5 = GPU_COLOR_OFFSET;
        fArr[i + i5] = f11;
        fArr[i + i5 + 1] = f12;
        fArr[i + i5 + 2] = f13;
        fArr[i5 + i + 3] = f14;
    }

    public void allocParticlesData(int i) {
        this.vertices = new float[(this.currentVertexSize * 4 * i)];
        allocRenderables(i);
    }

    public Renderable allocRenderable() {
        Renderable renderable = new Renderable();
        MeshPart meshPart = renderable.meshPart;
        meshPart.primitiveType = 4;
        meshPart.offset = 0;
        renderable.material = new Material(this.blendingAttribute, this.depthTestAttribute, TextureAttribute.createDiffuse(this.texture));
        renderable.meshPart.mesh = new Mesh(false, (int) MAX_VERTICES_PER_MESH, 49146, this.currentAttributes);
        renderable.meshPart.mesh.setIndices(this.indices);
        renderable.shader = this.shader;
        return renderable;
    }

    public void begin() {
        super.begin();
        this.renderablePool.freeAll(this.renderables);
        this.renderables.clear();
    }

    public void flush(int[] iArr) {
        if (this.useGPU) {
            fillVerticesGPU(iArr);
        } else {
            AlignMode alignMode = this.mode;
            if (alignMode == AlignMode.Screen) {
                fillVerticesToScreenCPU(iArr);
            } else if (alignMode == AlignMode.ViewPoint) {
                fillVerticesToViewPointCPU(iArr);
            }
        }
        int i = this.bufferedParticlesCount * 4;
        int i2 = 0;
        while (i2 < i) {
            int min = Math.min(i - i2, MAX_VERTICES_PER_MESH);
            Renderable renderable = (Renderable) this.renderablePool.obtain();
            MeshPart meshPart = renderable.meshPart;
            meshPart.size = (min / 4) * 6;
            Mesh mesh = meshPart.mesh;
            float[] fArr = this.vertices;
            int i3 = this.currentVertexSize;
            mesh.setVertices(fArr, i3 * i2, i3 * min);
            renderable.meshPart.update();
            this.renderables.add(renderable);
            i2 += min;
        }
    }

    public AlignMode getAlignMode() {
        return this.mode;
    }

    public BlendingAttribute getBlendingAttribute() {
        return this.blendingAttribute;
    }

    public void getRenderables(Array<Renderable> array, Pool<Renderable> pool) {
        ArrayIterator it = this.renderables.iterator();
        while (it.hasNext()) {
            array.add(((Renderable) pool.obtain()).set((Renderable) it.next()));
        }
    }

    public Shader getShader(Renderable renderable) {
        Shader particleShader = this.useGPU ? new ParticleShader(renderable, new com.badlogic.gdx.graphics.g3d.particles.ParticleShader.Config(this.mode)) : new DefaultShader(renderable);
        particleShader.init();
        return particleShader;
    }

    public Texture getTexture() {
        return this.texture;
    }

    public boolean isUseGPU() {
        return this.useGPU;
    }

    public void load(AssetManager assetManager, ResourceData resourceData) {
        SaveData saveData = resourceData.getSaveData("billboardBatch");
        if (saveData != null) {
            saveData.loadAsset();
            throw null;
        }
    }

    public void save(AssetManager assetManager, ResourceData resourceData) {
        resourceData.createSaveData("billboardBatch").save("cfg", new Config(this.useGPU, this.mode));
        throw null;
    }

    public void setAlignMode(AlignMode alignMode) {
        if (alignMode != this.mode) {
            this.mode = alignMode;
            if (this.useGPU) {
                initRenderData();
                allocRenderables(this.bufferedParticlesCount);
            }
        }
    }

    public void setTexture(Texture texture2) {
        this.renderablePool.freeAll(this.renderables);
        this.renderables.clear();
        int free = this.renderablePool.getFree();
        for (int i = 0; i < free; i++) {
            ((TextureAttribute) ((Renderable) this.renderablePool.obtain()).material.get(TextureAttribute.Diffuse)).textureDescription.texture = texture2;
        }
        this.texture = texture2;
    }

    public void setUseGpu(boolean z) {
        if (this.useGPU != z) {
            this.useGPU = z;
            initRenderData();
            allocRenderables(this.bufferedParticlesCount);
        }
    }

    public void setVertexData() {
        if (this.useGPU) {
            this.currentAttributes = GPU_ATTRIBUTES;
            this.currentVertexSize = GPU_VERTEX_SIZE;
            return;
        }
        this.currentAttributes = CPU_ATTRIBUTES;
        this.currentVertexSize = CPU_VERTEX_SIZE;
    }

    public static void putVertex(float[] fArr, int i, Vector3 vector3, float f2, float f3, float f4, float f5, float f6, float f7) {
        int i2 = CPU_POSITION_OFFSET;
        fArr[i + i2] = vector3.x;
        fArr[i + i2 + 1] = vector3.y;
        fArr[i2 + i + 2] = vector3.z;
        int i3 = CPU_UV_OFFSET;
        fArr[i + i3] = f2;
        fArr[i3 + i + 1] = f3;
        int i4 = CPU_COLOR_OFFSET;
        fArr[i + i4] = f4;
        fArr[i + i4 + 1] = f5;
        fArr[i + i4 + 2] = f6;
        fArr[i + i4 + 3] = f7;
    }

    public BillboardParticleBatch(AlignMode alignMode, boolean z, int i) {
        this(alignMode, z, i, null, null);
    }

    public BillboardParticleBatch() {
        this(AlignMode.Screen, false, 100);
    }

    public BillboardParticleBatch(int i) {
        this(AlignMode.Screen, false, i);
    }
}
