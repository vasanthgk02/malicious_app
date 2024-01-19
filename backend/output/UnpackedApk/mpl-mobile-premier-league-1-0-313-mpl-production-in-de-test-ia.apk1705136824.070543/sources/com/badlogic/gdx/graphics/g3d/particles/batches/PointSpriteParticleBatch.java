package com.badlogic.gdx.graphics.g3d.particles.batches;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.DepthTestAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.model.MeshPart;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleShader;
import com.badlogic.gdx.graphics.g3d.particles.ParticleShader.Config;
import com.badlogic.gdx.graphics.g3d.particles.ParticleShader.ParticleType;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData.SaveData;
import com.badlogic.gdx.graphics.g3d.particles.renderers.PointSpriteControllerRenderData;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Array.ArrayIterator;
import com.badlogic.gdx.utils.Pool;

public class PointSpriteParticleBatch extends BufferedParticleBatch<PointSpriteControllerRenderData> {
    public static final VertexAttributes CPU_ATTRIBUTES;
    public static final int CPU_COLOR_OFFSET = ((short) (CPU_ATTRIBUTES.findByUsage(2).offset / 4));
    public static final int CPU_POSITION_OFFSET;
    public static final int CPU_REGION_OFFSET = ((short) (CPU_ATTRIBUTES.findByUsage(16).offset / 4));
    public static final int CPU_SIZE_AND_ROTATION_OFFSET = ((short) (CPU_ATTRIBUTES.findByUsage(512).offset / 4));
    public static final int CPU_VERTEX_SIZE;
    public static final Vector3 TMP_V1 = new Vector3();
    public static boolean pointSpritesEnabled = false;
    public static final int sizeAndRotationUsage = 512;
    public Renderable renderable;
    public float[] vertices;

    static {
        VertexAttributes vertexAttributes = new VertexAttributes(new VertexAttribute(1, 3, ShaderProgram.POSITION_ATTRIBUTE), new VertexAttribute(2, 4, ShaderProgram.COLOR_ATTRIBUTE), new VertexAttribute(16, 4, "a_region"), new VertexAttribute(512, 3, "a_sizeAndRotation"));
        CPU_ATTRIBUTES = vertexAttributes;
        CPU_VERTEX_SIZE = (short) (vertexAttributes.vertexSize / 4);
        CPU_POSITION_OFFSET = (short) (vertexAttributes.findByUsage(1).offset / 4);
    }

    public PointSpriteParticleBatch() {
        this(1000);
    }

    public static void enablePointSprites() {
        k.gl.glEnable(GL20.GL_VERTEX_PROGRAM_POINT_SIZE);
        if (k.app.getType() == ApplicationType.Desktop) {
            k.gl.glEnable(34913);
        }
        pointSpritesEnabled = true;
    }

    public void allocParticlesData(int i) {
        this.vertices = new float[(CPU_VERTEX_SIZE * i)];
        Mesh mesh = this.renderable.meshPart.mesh;
        if (mesh != null) {
            mesh.dispose();
        }
        this.renderable.meshPart.mesh = new Mesh(false, i, 0, CPU_ATTRIBUTES);
    }

    public void allocRenderable() {
        Renderable renderable2 = new Renderable();
        this.renderable = renderable2;
        MeshPart meshPart = renderable2.meshPart;
        meshPart.primitiveType = 0;
        meshPart.offset = 0;
        renderable2.material = new Material(new BlendingAttribute(1, GL20.GL_ONE_MINUS_SRC_ALPHA, 1.0f), new DepthTestAttribute(GL20.GL_LEQUAL, false), TextureAttribute.createDiffuse((Texture) null));
    }

    public void flush(int[] iArr) {
        ArrayIterator it = this.renderData.iterator();
        int i = 0;
        while (it.hasNext()) {
            PointSpriteControllerRenderData pointSpriteControllerRenderData = (PointSpriteControllerRenderData) it.next();
            FloatChannel floatChannel = pointSpriteControllerRenderData.scaleChannel;
            FloatChannel floatChannel2 = pointSpriteControllerRenderData.regionChannel;
            FloatChannel floatChannel3 = pointSpriteControllerRenderData.positionChannel;
            FloatChannel floatChannel4 = pointSpriteControllerRenderData.colorChannel;
            FloatChannel floatChannel5 = pointSpriteControllerRenderData.rotationChannel;
            int i2 = 0;
            while (i2 < pointSpriteControllerRenderData.controller.particles.size) {
                int i3 = iArr[i] * CPU_VERTEX_SIZE;
                int i4 = floatChannel2.strideSize * i2;
                int i5 = floatChannel3.strideSize * i2;
                int i6 = floatChannel4.strideSize * i2;
                int i7 = floatChannel5.strideSize * i2;
                float[] fArr = this.vertices;
                int i8 = CPU_POSITION_OFFSET;
                ArrayIterator arrayIterator = it;
                float[] fArr2 = floatChannel3.data;
                fArr[i3 + i8] = fArr2[i5 + 0];
                fArr[i3 + i8 + 1] = fArr2[i5 + 1];
                fArr[i3 + i8 + 2] = fArr2[i5 + 2];
                int i9 = CPU_COLOR_OFFSET;
                PointSpriteControllerRenderData pointSpriteControllerRenderData2 = pointSpriteControllerRenderData;
                float[] fArr3 = floatChannel4.data;
                fArr[i3 + i9] = fArr3[i6 + 0];
                fArr[i3 + i9 + 1] = fArr3[i6 + 1];
                fArr[i3 + i9 + 2] = fArr3[i6 + 2];
                fArr[i9 + i3 + 3] = fArr3[i6 + 3];
                int i10 = CPU_SIZE_AND_ROTATION_OFFSET;
                fArr[i3 + i10] = floatChannel.data[floatChannel.strideSize * i2];
                float[] fArr4 = floatChannel5.data;
                fArr[i3 + i10 + 1] = fArr4[i7 + 0];
                fArr[i10 + i3 + 2] = fArr4[i7 + 1];
                int i11 = CPU_REGION_OFFSET;
                float[] fArr5 = floatChannel2.data;
                fArr[i3 + i11] = fArr5[i4 + 0];
                fArr[i3 + i11 + 1] = fArr5[i4 + 1];
                fArr[i3 + i11 + 2] = fArr5[i4 + 2];
                fArr[i3 + i11 + 3] = fArr5[i4 + 3];
                i2++;
                i++;
                pointSpriteControllerRenderData = pointSpriteControllerRenderData2;
                it = arrayIterator;
            }
        }
        MeshPart meshPart = this.renderable.meshPart;
        int i12 = this.bufferedParticlesCount;
        meshPart.size = i12;
        meshPart.mesh.setVertices(this.vertices, 0, i12 * CPU_VERTEX_SIZE);
        this.renderable.meshPart.update();
    }

    public void getRenderables(Array<Renderable> array, Pool<Renderable> pool) {
        if (this.bufferedParticlesCount > 0) {
            array.add(((Renderable) pool.obtain()).set(this.renderable));
        }
    }

    public Texture getTexture() {
        return (Texture) ((TextureAttribute) this.renderable.material.get(TextureAttribute.Diffuse)).textureDescription.texture;
    }

    public void load(AssetManager assetManager, ResourceData resourceData) {
        SaveData saveData = resourceData.getSaveData("pointSpriteBatch");
        if (saveData != null) {
            saveData.loadAsset();
            throw null;
        }
    }

    public void save(AssetManager assetManager, ResourceData resourceData) {
        resourceData.createSaveData("pointSpriteBatch");
        getTexture();
        throw null;
    }

    public void setTexture(Texture texture) {
        ((TextureAttribute) this.renderable.material.get(TextureAttribute.Diffuse)).textureDescription.texture = texture;
    }

    public PointSpriteParticleBatch(int i) {
        this(i, new Config(ParticleType.Point));
    }

    public PointSpriteParticleBatch(int i, Config config) {
        super(PointSpriteControllerRenderData.class);
        if (!pointSpritesEnabled) {
            enablePointSprites();
        }
        allocRenderable();
        ensureCapacity(i);
        this.renderable.shader = new ParticleShader(this.renderable, config);
        this.renderable.shader.init();
    }
}
