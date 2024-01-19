package com.badlogic.gdx.graphics.g2d;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.android.AndroidGraphics;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.IntArray;
import java.nio.FloatBuffer;

public class SpriteCache implements Disposable {
    public static final float[] tempVertices = new float[30];
    public Array<Cache> caches;
    public final Color color;
    public float colorPacked;
    public final Matrix4 combinedMatrix;
    public final IntArray counts;
    public Cache currentCache;
    public ShaderProgram customShader;
    public boolean drawing;
    public final Mesh mesh;
    public final Matrix4 projectionMatrix;
    public int renderCalls;
    public final ShaderProgram shader;
    public final Array<Texture> textures;
    public int totalRenderCalls;
    public final Matrix4 transformMatrix;

    public static class Cache {
        public int[] counts;
        public final int id;
        public int maxCount;
        public final int offset;
        public int textureCount;
        public Texture[] textures;

        public Cache(int i, int i2) {
            this.id = i;
            this.offset = i2;
        }
    }

    public SpriteCache() {
        this(1000, false);
    }

    public static ShaderProgram createDefaultShader() {
        ShaderProgram shaderProgram = new ShaderProgram((String) "attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\nuniform mat4 u_projectionViewMatrix;\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main()\n{\n   v_color = a_color;\n   v_color.a = v_color.a * (255.0/254.0);\n   v_texCoords = a_texCoord0;\n   gl_Position =  u_projectionViewMatrix * a_position;\n}\n", (String) "#ifdef GL_ES\nprecision mediump float;\n#endif\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\nuniform sampler2D u_texture;\nvoid main()\n{\n  gl_FragColor = v_color * texture2D(u_texture, v_texCoords);\n}");
        if (shaderProgram.isCompiled()) {
            return shaderProgram;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error compiling shader: ");
        outline73.append(shaderProgram.getLog());
        throw new IllegalArgumentException(outline73.toString());
    }

    public void add(Texture texture, float[] fArr, int i, int i2) {
        if (this.currentCache != null) {
            int i3 = (i2 / ((this.mesh.getNumIndices() > 0 ? 4 : 6) * 5)) * 6;
            Array<Texture> array = this.textures;
            int i4 = array.size - 1;
            if (i4 < 0 || array.get(i4) != texture) {
                this.textures.add(texture);
                this.counts.add(i3);
            } else {
                IntArray intArray = this.counts;
                if (i4 < intArray.size) {
                    int[] iArr = intArray.items;
                    iArr[i4] = iArr[i4] + i3;
                } else {
                    StringBuilder outline74 = GeneratedOutlineSupport.outline74("index can't be >= size: ", i4, " >= ");
                    outline74.append(intArray.size);
                    throw new IndexOutOfBoundsException(outline74.toString());
                }
            }
            this.mesh.getVerticesBuffer().put(fArr, i, i2);
            return;
        }
        throw new IllegalStateException("beginCache must be called before add.");
    }

    public void begin() {
        if (this.drawing) {
            throw new IllegalStateException("end must be called before begin.");
        } else if (this.currentCache == null) {
            this.renderCalls = 0;
            Matrix4 matrix4 = this.combinedMatrix;
            matrix4.set(this.projectionMatrix);
            matrix4.mul(this.transformMatrix);
            k.gl20.glDepthMask(false);
            ShaderProgram shaderProgram = this.customShader;
            if (shaderProgram != null) {
                shaderProgram.bind();
                this.customShader.setUniformMatrix((String) "u_proj", this.projectionMatrix);
                this.customShader.setUniformMatrix((String) "u_trans", this.transformMatrix);
                this.customShader.setUniformMatrix((String) "u_projTrans", this.combinedMatrix);
                this.customShader.setUniformi((String) "u_texture", 0);
                this.mesh.bind(this.customShader);
            } else {
                this.shader.bind();
                this.shader.setUniformMatrix((String) "u_projectionViewMatrix", this.combinedMatrix);
                this.shader.setUniformi((String) "u_texture", 0);
                this.mesh.bind(this.shader);
            }
            this.drawing = true;
        } else {
            throw new IllegalStateException("endCache must be called before begin");
        }
    }

    public void beginCache() {
        if (this.drawing) {
            throw new IllegalStateException("end must be called before beginCache");
        } else if (this.currentCache == null) {
            int numIndices = this.mesh.getNumIndices();
            Cache cache = new Cache(this.caches.size, this.mesh.getVerticesBuffer().limit());
            this.currentCache = cache;
            this.caches.add(cache);
            this.mesh.getVerticesBuffer().compact();
        } else {
            throw new IllegalStateException("endCache must be called before begin.");
        }
    }

    public void clear() {
        this.caches.clear();
        this.mesh.getVerticesBuffer().clear().flip();
    }

    public void dispose() {
        this.mesh.dispose();
        ShaderProgram shaderProgram = this.shader;
        if (shaderProgram != null) {
            shaderProgram.dispose();
        }
    }

    public void draw(int i) {
        if (this.drawing) {
            Cache cache = (Cache) this.caches.get(i);
            int i2 = (cache.offset / ((this.mesh.getNumIndices() > 0 ? 4 : 6) * 5)) * 6;
            Texture[] textureArr = cache.textures;
            int[] iArr = cache.counts;
            int i3 = cache.textureCount;
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = iArr[i4];
                textureArr[i4].bind();
                ShaderProgram shaderProgram = this.customShader;
                if (shaderProgram != null) {
                    this.mesh.render(shaderProgram, 4, i2, i5);
                } else {
                    this.mesh.render(this.shader, 4, i2, i5);
                }
                i2 += i5;
            }
            this.renderCalls += i3;
            this.totalRenderCalls += i3;
            return;
        }
        throw new IllegalStateException("SpriteCache.begin must be called before draw.");
    }

    public void end() {
        if (this.drawing) {
            this.drawing = false;
            k.gl20.glDepthMask(true);
            ShaderProgram shaderProgram = this.customShader;
            if (shaderProgram != null) {
                this.mesh.unbind(shaderProgram);
            } else {
                this.mesh.unbind(this.shader);
            }
        } else {
            throw new IllegalStateException("begin must be called before end.");
        }
    }

    public int endCache() {
        Cache cache = this.currentCache;
        if (cache != null) {
            int position = this.mesh.getVerticesBuffer().position() - cache.offset;
            Texture[] textureArr = cache.textures;
            if (textureArr == null) {
                cache.maxCount = position;
                Array<Texture> array = this.textures;
                cache.textureCount = array.size;
                cache.textures = (Texture[]) array.toArray(Texture.class);
                cache.counts = new int[cache.textureCount];
                int i = this.counts.size;
                for (int i2 = 0; i2 < i; i2++) {
                    cache.counts[i2] = this.counts.get(i2);
                }
                this.mesh.getVerticesBuffer().flip();
            } else if (position <= cache.maxCount) {
                int i3 = this.textures.size;
                cache.textureCount = i3;
                if (textureArr.length < i3) {
                    cache.textures = new Texture[i3];
                }
                int i4 = cache.textureCount;
                for (int i5 = 0; i5 < i4; i5++) {
                    cache.textures[i5] = (Texture) this.textures.get(i5);
                }
                int length = cache.counts.length;
                int i6 = cache.textureCount;
                if (length < i6) {
                    cache.counts = new int[i6];
                }
                int i7 = cache.textureCount;
                for (int i8 = 0; i8 < i7; i8++) {
                    cache.counts[i8] = this.counts.get(i8);
                }
                FloatBuffer verticesBuffer = this.mesh.getVerticesBuffer();
                verticesBuffer.position(0);
                Array<Cache> array2 = this.caches;
                Cache cache2 = (Cache) array2.get(array2.size - 1);
                verticesBuffer.limit(cache2.offset + cache2.maxCount);
            } else {
                throw new GdxRuntimeException(GeneratedOutlineSupport.outline57(GeneratedOutlineSupport.outline74("If a cache is not the last created, it cannot be redefined with more entries than when it was first created: ", position, " ("), cache.maxCount, " max)"));
            }
            this.currentCache = null;
            this.textures.clear();
            this.counts.size = 0;
            return cache.id;
        }
        throw new IllegalStateException("beginCache must be called before endCache.");
    }

    public Color getColor() {
        return this.color;
    }

    public ShaderProgram getCustomShader() {
        return this.customShader;
    }

    public float getPackedColor() {
        return this.colorPacked;
    }

    public Matrix4 getProjectionMatrix() {
        return this.projectionMatrix;
    }

    public Matrix4 getTransformMatrix() {
        return this.transformMatrix;
    }

    public boolean isDrawing() {
        return this.drawing;
    }

    public void setColor(Color color2) {
        this.color.set(color2);
        this.colorPacked = color2.toFloatBits();
    }

    public void setPackedColor(float f2) {
        Color.abgr8888ToColor(this.color, f2);
        this.colorPacked = f2;
    }

    public void setProjectionMatrix(Matrix4 matrix4) {
        if (!this.drawing) {
            this.projectionMatrix.set(matrix4);
            return;
        }
        throw new IllegalStateException("Can't set the matrix within begin/end.");
    }

    public void setShader(ShaderProgram shaderProgram) {
        this.customShader = shaderProgram;
    }

    public void setTransformMatrix(Matrix4 matrix4) {
        if (!this.drawing) {
            this.transformMatrix.set(matrix4);
            return;
        }
        throw new IllegalStateException("Can't set the matrix within begin/end.");
    }

    public SpriteCache(int i, boolean z) {
        this(i, createDefaultShader(), z);
    }

    public SpriteCache(int i, ShaderProgram shaderProgram, boolean z) {
        this.transformMatrix = new Matrix4();
        this.projectionMatrix = new Matrix4();
        this.caches = new Array<>();
        this.combinedMatrix = new Matrix4();
        this.textures = new Array<>(true, 8);
        this.counts = new IntArray(8);
        this.color = new Color(1.0f, 1.0f, 1.0f, 1.0f);
        this.colorPacked = Color.WHITE_FLOAT_BITS;
        this.customShader = null;
        int i2 = 0;
        this.renderCalls = 0;
        this.totalRenderCalls = 0;
        this.shader = shaderProgram;
        if (!z || i <= 8191) {
            Mesh mesh2 = new Mesh(true, (z ? 4 : 6) * i, z ? i * 6 : 0, new VertexAttribute(1, 2, ShaderProgram.POSITION_ATTRIBUTE), new VertexAttribute(4, 4, ShaderProgram.COLOR_ATTRIBUTE), new VertexAttribute(16, 2, "a_texCoord0"));
            this.mesh = mesh2;
            mesh2.setAutoBind(false);
            if (z) {
                int i3 = i * 6;
                short[] sArr = new short[i3];
                short s = 0;
                while (i2 < i3) {
                    sArr[i2 + 0] = s;
                    sArr[i2 + 1] = (short) (s + 1);
                    short s2 = (short) (s + 2);
                    sArr[i2 + 2] = s2;
                    sArr[i2 + 3] = s2;
                    sArr[i2 + 4] = (short) (s + 3);
                    sArr[i2 + 5] = s;
                    i2 += 6;
                    s = (short) (s + 4);
                }
                this.mesh.setIndices(sArr);
            }
            Matrix4 matrix4 = this.projectionMatrix;
            Graphics graphics = k.graphics;
            matrix4.setToOrtho2D(0.0f, 0.0f, (float) ((AndroidGraphics) graphics).width, (float) ((AndroidGraphics) graphics).height);
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("Can't have more than 8191 sprites per batch: ", i));
    }

    public void setColor(float f2, float f3, float f4, float f5) {
        this.color.set(f2, f3, f4, f5);
        this.colorPacked = this.color.toFloatBits();
    }

    public void beginCache(int i) {
        if (this.drawing) {
            throw new IllegalStateException("end must be called before beginCache");
        } else if (this.currentCache == null) {
            Array<Cache> array = this.caches;
            if (i == array.size - 1) {
                this.mesh.getVerticesBuffer().limit(((Cache) array.removeIndex(i)).offset);
                beginCache();
                return;
            }
            this.currentCache = (Cache) array.get(i);
            this.mesh.getVerticesBuffer().position(this.currentCache.offset);
        } else {
            throw new IllegalStateException("endCache must be called before begin.");
        }
    }

    public void add(Texture texture, float f2, float f3) {
        float width = ((float) texture.getWidth()) + f2;
        float height = ((float) texture.getHeight()) + f3;
        float[] fArr = tempVertices;
        fArr[0] = f2;
        fArr[1] = f3;
        float f4 = this.colorPacked;
        fArr[2] = f4;
        fArr[3] = 0.0f;
        fArr[4] = 1.0f;
        fArr[5] = f2;
        fArr[6] = height;
        fArr[7] = f4;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = width;
        fArr[11] = height;
        fArr[12] = f4;
        fArr[13] = 1.0f;
        fArr[14] = 0.0f;
        if (this.mesh.getNumIndices() > 0) {
            float[] fArr2 = tempVertices;
            fArr2[15] = width;
            fArr2[16] = f3;
            fArr2[17] = this.colorPacked;
            fArr2[18] = 1.0f;
            fArr2[19] = 1.0f;
            add(texture, fArr2, 0, 20);
            return;
        }
        float[] fArr3 = tempVertices;
        fArr3[15] = width;
        fArr3[16] = height;
        float f5 = this.colorPacked;
        fArr3[17] = f5;
        fArr3[18] = 1.0f;
        fArr3[19] = 0.0f;
        fArr3[20] = width;
        fArr3[21] = f3;
        fArr3[22] = f5;
        fArr3[23] = 1.0f;
        fArr3[24] = 1.0f;
        fArr3[25] = f2;
        fArr3[26] = f3;
        fArr3[27] = f5;
        fArr3[28] = 0.0f;
        fArr3[29] = 1.0f;
        add(texture, fArr3, 0, 30);
    }

    public void draw(int i, int i2, int i3) {
        int i4;
        int i5;
        if (this.drawing) {
            Cache cache = (Cache) this.caches.get(i);
            int i6 = (i2 * 6) + ((cache.offset / ((this.mesh.getNumIndices() > 0 ? 4 : 6) * 5)) * 6);
            int i7 = i3 * 6;
            Texture[] textureArr = cache.textures;
            int[] iArr = cache.counts;
            int i8 = cache.textureCount;
            int i9 = 0;
            while (i9 < i8) {
                textureArr[i9].bind();
                int i10 = iArr[i9];
                if (i10 > i7) {
                    i5 = i7;
                    i4 = i8;
                } else {
                    int i11 = i9;
                    i5 = i7 - i10;
                    i7 = i10;
                    i4 = i11;
                }
                ShaderProgram shaderProgram = this.customShader;
                if (shaderProgram != null) {
                    this.mesh.render(shaderProgram, 4, i6, i7);
                } else {
                    this.mesh.render(this.shader, 4, i6, i7);
                }
                i6 += i7;
                int i12 = i5;
                i9 = i4 + 1;
                i7 = i12;
            }
            this.renderCalls += cache.textureCount;
            this.totalRenderCalls += i8;
            return;
        }
        throw new IllegalStateException("SpriteCache.begin must be called before draw.");
    }

    public void add(Texture texture, float f2, float f3, int i, int i2, float f4, float f5, float f6, float f7, float f8) {
        Texture texture2 = texture;
        float f9 = ((float) i) + f2;
        float f10 = ((float) i2) + f3;
        float[] fArr = tempVertices;
        fArr[0] = f2;
        fArr[1] = f3;
        fArr[2] = f8;
        fArr[3] = f4;
        fArr[4] = f5;
        fArr[5] = f2;
        fArr[6] = f10;
        fArr[7] = f8;
        fArr[8] = f4;
        fArr[9] = f7;
        fArr[10] = f9;
        fArr[11] = f10;
        fArr[12] = f8;
        fArr[13] = f6;
        fArr[14] = f7;
        if (this.mesh.getNumIndices() > 0) {
            float[] fArr2 = tempVertices;
            fArr2[15] = f9;
            fArr2[16] = f3;
            fArr2[17] = f8;
            fArr2[18] = f6;
            fArr2[19] = f5;
            add(texture, fArr2, 0, 20);
            return;
        }
        float[] fArr3 = tempVertices;
        fArr3[15] = f9;
        fArr3[16] = f10;
        fArr3[17] = f8;
        fArr3[18] = f6;
        fArr3[19] = f7;
        fArr3[20] = f9;
        fArr3[21] = f3;
        fArr3[22] = f8;
        fArr3[23] = f6;
        fArr3[24] = f5;
        fArr3[25] = f2;
        fArr3[26] = f3;
        fArr3[27] = f8;
        fArr3[28] = f4;
        fArr3[29] = f5;
        add(texture, fArr3, 0, 30);
    }

    public void add(Texture texture, float f2, float f3, int i, int i2, int i3, int i4) {
        Texture texture2 = texture;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        float width = 1.0f / ((float) texture.getWidth());
        float height = 1.0f / ((float) texture.getHeight());
        float f4 = ((float) i5) * width;
        float f5 = ((float) (i6 + i8)) * height;
        float f6 = ((float) (i5 + i7)) * width;
        float f7 = ((float) i6) * height;
        float f8 = f2 + ((float) i7);
        float f9 = f3 + ((float) i8);
        float[] fArr = tempVertices;
        fArr[0] = f2;
        fArr[1] = f3;
        float f10 = this.colorPacked;
        fArr[2] = f10;
        fArr[3] = f4;
        fArr[4] = f5;
        fArr[5] = f2;
        fArr[6] = f9;
        fArr[7] = f10;
        fArr[8] = f4;
        fArr[9] = f7;
        fArr[10] = f8;
        fArr[11] = f9;
        fArr[12] = f10;
        fArr[13] = f6;
        fArr[14] = f7;
        if (this.mesh.getNumIndices() > 0) {
            float[] fArr2 = tempVertices;
            fArr2[15] = f8;
            fArr2[16] = f3;
            fArr2[17] = this.colorPacked;
            fArr2[18] = f6;
            fArr2[19] = f5;
            add(texture2, fArr2, 0, 20);
            return;
        }
        float[] fArr3 = tempVertices;
        fArr3[15] = f8;
        fArr3[16] = f9;
        float f11 = this.colorPacked;
        fArr3[17] = f11;
        fArr3[18] = f6;
        fArr3[19] = f7;
        fArr3[20] = f8;
        fArr3[21] = f3;
        fArr3[22] = f11;
        fArr3[23] = f6;
        fArr3[24] = f5;
        fArr3[25] = f2;
        fArr3[26] = f3;
        fArr3[27] = f11;
        fArr3[28] = f4;
        fArr3[29] = f5;
        add(texture2, fArr3, 0, 30);
    }

    public void add(Texture texture, float f2, float f3, float f4, float f5, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        Texture texture2 = texture;
        int i5 = i;
        int i6 = i2;
        float width = 1.0f / ((float) texture.getWidth());
        float height = 1.0f / ((float) texture.getHeight());
        float f6 = ((float) i5) * width;
        float f7 = ((float) (i6 + i4)) * height;
        float f8 = ((float) (i5 + i3)) * width;
        float f9 = ((float) i6) * height;
        float f10 = f2 + f4;
        float f11 = f3 + f5;
        if (!z) {
            float f12 = f6;
            f6 = f8;
            f8 = f12;
        }
        if (z2) {
            float f13 = f7;
            f7 = f9;
            f9 = f13;
        }
        float[] fArr = tempVertices;
        fArr[0] = f2;
        fArr[1] = f3;
        float f14 = this.colorPacked;
        fArr[2] = f14;
        fArr[3] = f8;
        fArr[4] = f7;
        fArr[5] = f2;
        fArr[6] = f11;
        fArr[7] = f14;
        fArr[8] = f8;
        fArr[9] = f9;
        fArr[10] = f10;
        fArr[11] = f11;
        fArr[12] = f14;
        fArr[13] = f6;
        fArr[14] = f9;
        if (this.mesh.getNumIndices() > 0) {
            float[] fArr2 = tempVertices;
            fArr2[15] = f10;
            fArr2[16] = f3;
            fArr2[17] = this.colorPacked;
            fArr2[18] = f6;
            fArr2[19] = f7;
            add(texture2, fArr2, 0, 20);
            return;
        }
        float[] fArr3 = tempVertices;
        fArr3[15] = f10;
        fArr3[16] = f11;
        float f15 = this.colorPacked;
        fArr3[17] = f15;
        fArr3[18] = f6;
        fArr3[19] = f9;
        fArr3[20] = f10;
        fArr3[21] = f3;
        fArr3[22] = f15;
        fArr3[23] = f6;
        fArr3[24] = f7;
        fArr3[25] = f2;
        fArr3[26] = f3;
        fArr3[27] = f15;
        fArr3[28] = f8;
        fArr3[29] = f7;
        add(texture2, fArr3, 0, 30);
    }

    public void add(Texture texture, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        Texture texture2 = texture;
        float f18 = f4;
        float f19 = f5;
        int i5 = i;
        int i6 = i2;
        float f20 = f2 + f18;
        float f21 = f3 + f19;
        float f22 = -f18;
        float f23 = -f19;
        float f24 = f6 - f18;
        float f25 = f7 - f19;
        if (!(f8 == 1.0f && f9 == 1.0f)) {
            f22 *= f8;
            f23 *= f9;
            f24 *= f8;
            f25 *= f9;
        }
        if (f10 != 0.0f) {
            float cosDeg = MathUtils.cosDeg(f10);
            float sinDeg = MathUtils.sinDeg(f10);
            float f26 = cosDeg * f22;
            f11 = f26 - (sinDeg * f23);
            float f27 = f22 * sinDeg;
            float f28 = (f23 * cosDeg) + f27;
            float f29 = sinDeg * f25;
            f12 = f26 - f29;
            float f30 = f25 * cosDeg;
            f16 = f27 + f30;
            float f31 = (cosDeg * f24) - f29;
            float f32 = f30 + (sinDeg * f24);
            f13 = f32 - (f16 - f28);
            float f33 = f32;
            f17 = (f31 - f12) + f11;
            f24 = f31;
            f14 = f28;
            f15 = f33;
        } else {
            f12 = f22;
            f11 = f12;
            f14 = f23;
            f13 = f14;
            f16 = f25;
            f15 = f16;
            f17 = f24;
        }
        float f34 = f11 + f20;
        float f35 = f14 + f21;
        float f36 = f12 + f20;
        float f37 = f16 + f21;
        float f38 = f24 + f20;
        float f39 = f15 + f21;
        float f40 = f17 + f20;
        float f41 = f13 + f21;
        float width = 1.0f / ((float) texture.getWidth());
        float height = 1.0f / ((float) texture.getHeight());
        float f42 = ((float) i5) * width;
        float f43 = ((float) (i6 + i4)) * height;
        float f44 = ((float) (i5 + i3)) * width;
        float f45 = ((float) i6) * height;
        if (z) {
            float f46 = f42;
            f42 = f44;
            f44 = f46;
        }
        if (z2) {
            float f47 = f43;
            f43 = f45;
            f45 = f47;
        }
        float[] fArr = tempVertices;
        fArr[0] = f34;
        fArr[1] = f35;
        float f48 = this.colorPacked;
        fArr[2] = f48;
        fArr[3] = f42;
        fArr[4] = f43;
        fArr[5] = f36;
        fArr[6] = f37;
        fArr[7] = f48;
        fArr[8] = f42;
        fArr[9] = f45;
        fArr[10] = f38;
        fArr[11] = f39;
        fArr[12] = f48;
        fArr[13] = f44;
        fArr[14] = f45;
        if (this.mesh.getNumIndices() > 0) {
            float[] fArr2 = tempVertices;
            fArr2[15] = f40;
            fArr2[16] = f41;
            fArr2[17] = this.colorPacked;
            fArr2[18] = f44;
            fArr2[19] = f43;
            add(texture2, fArr2, 0, 20);
            return;
        }
        float[] fArr3 = tempVertices;
        fArr3[15] = f38;
        fArr3[16] = f39;
        float f49 = this.colorPacked;
        fArr3[17] = f49;
        fArr3[18] = f44;
        fArr3[19] = f45;
        fArr3[20] = f40;
        fArr3[21] = f41;
        fArr3[22] = f49;
        fArr3[23] = f44;
        fArr3[24] = f43;
        fArr3[25] = f34;
        fArr3[26] = f35;
        fArr3[27] = f49;
        fArr3[28] = f42;
        fArr3[29] = f43;
        add(texture2, fArr3, 0, 30);
    }

    public void add(TextureRegion textureRegion, float f2, float f3) {
        add(textureRegion, f2, f3, (float) textureRegion.getRegionWidth(), (float) textureRegion.getRegionHeight());
    }

    public void add(TextureRegion textureRegion, float f2, float f3, float f4, float f5) {
        TextureRegion textureRegion2 = textureRegion;
        float f6 = f2 + f4;
        float f7 = f3 + f5;
        float f8 = textureRegion2.u;
        float f9 = textureRegion2.v2;
        float f10 = textureRegion2.u2;
        float f11 = textureRegion2.v;
        float[] fArr = tempVertices;
        fArr[0] = f2;
        fArr[1] = f3;
        float f12 = this.colorPacked;
        fArr[2] = f12;
        fArr[3] = f8;
        fArr[4] = f9;
        fArr[5] = f2;
        fArr[6] = f7;
        fArr[7] = f12;
        fArr[8] = f8;
        fArr[9] = f11;
        fArr[10] = f6;
        fArr[11] = f7;
        fArr[12] = f12;
        fArr[13] = f10;
        fArr[14] = f11;
        if (this.mesh.getNumIndices() > 0) {
            float[] fArr2 = tempVertices;
            fArr2[15] = f6;
            fArr2[16] = f3;
            fArr2[17] = this.colorPacked;
            fArr2[18] = f10;
            fArr2[19] = f9;
            add(textureRegion2.texture, fArr2, 0, 20);
            return;
        }
        float[] fArr3 = tempVertices;
        fArr3[15] = f6;
        fArr3[16] = f7;
        float f13 = this.colorPacked;
        fArr3[17] = f13;
        fArr3[18] = f10;
        fArr3[19] = f11;
        fArr3[20] = f6;
        fArr3[21] = f3;
        fArr3[22] = f13;
        fArr3[23] = f10;
        fArr3[24] = f9;
        fArr3[25] = f2;
        fArr3[26] = f3;
        fArr3[27] = f13;
        fArr3[28] = f8;
        fArr3[29] = f9;
        add(textureRegion2.texture, fArr3, 0, 30);
    }

    public void add(TextureRegion textureRegion, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        TextureRegion textureRegion2 = textureRegion;
        float f18 = f4;
        float f19 = f5;
        float f20 = f2 + f18;
        float f21 = f3 + f19;
        float f22 = -f18;
        float f23 = -f19;
        float f24 = f6 - f18;
        float f25 = f7 - f19;
        if (!(f8 == 1.0f && f9 == 1.0f)) {
            f22 *= f8;
            f23 *= f9;
            f24 *= f8;
            f25 *= f9;
        }
        if (f10 != 0.0f) {
            float cosDeg = MathUtils.cosDeg(f10);
            float sinDeg = MathUtils.sinDeg(f10);
            float f26 = cosDeg * f22;
            f11 = f26 - (sinDeg * f23);
            float f27 = f22 * sinDeg;
            float f28 = (f23 * cosDeg) + f27;
            float f29 = sinDeg * f25;
            f12 = f26 - f29;
            float f30 = f25 * cosDeg;
            f16 = f27 + f30;
            float f31 = (cosDeg * f24) - f29;
            float f32 = f30 + (sinDeg * f24);
            f13 = f32 - (f16 - f28);
            float f33 = f32;
            f17 = (f31 - f12) + f11;
            f24 = f31;
            f14 = f28;
            f15 = f33;
        } else {
            f12 = f22;
            f11 = f12;
            f14 = f23;
            f13 = f14;
            f16 = f25;
            f15 = f16;
            f17 = f24;
        }
        float f34 = f11 + f20;
        float f35 = f14 + f21;
        float f36 = f12 + f20;
        float f37 = f16 + f21;
        float f38 = f24 + f20;
        float f39 = f15 + f21;
        float f40 = f17 + f20;
        float f41 = f13 + f21;
        float f42 = textureRegion2.u;
        float f43 = textureRegion2.v2;
        float f44 = textureRegion2.u2;
        float f45 = textureRegion2.v;
        float[] fArr = tempVertices;
        fArr[0] = f34;
        fArr[1] = f35;
        float f46 = this.colorPacked;
        fArr[2] = f46;
        fArr[3] = f42;
        fArr[4] = f43;
        fArr[5] = f36;
        fArr[6] = f37;
        fArr[7] = f46;
        fArr[8] = f42;
        fArr[9] = f45;
        fArr[10] = f38;
        fArr[11] = f39;
        fArr[12] = f46;
        fArr[13] = f44;
        fArr[14] = f45;
        if (this.mesh.getNumIndices() > 0) {
            float[] fArr2 = tempVertices;
            fArr2[15] = f40;
            fArr2[16] = f41;
            fArr2[17] = this.colorPacked;
            fArr2[18] = f44;
            fArr2[19] = f43;
            add(textureRegion2.texture, fArr2, 0, 20);
            return;
        }
        float[] fArr3 = tempVertices;
        fArr3[15] = f38;
        fArr3[16] = f39;
        float f47 = this.colorPacked;
        fArr3[17] = f47;
        fArr3[18] = f44;
        fArr3[19] = f45;
        fArr3[20] = f40;
        fArr3[21] = f41;
        fArr3[22] = f47;
        fArr3[23] = f44;
        fArr3[24] = f43;
        fArr3[25] = f34;
        fArr3[26] = f35;
        fArr3[27] = f47;
        fArr3[28] = f42;
        fArr3[29] = f43;
        add(textureRegion2.texture, fArr3, 0, 30);
    }

    public void add(Sprite sprite) {
        if (this.mesh.getNumIndices() > 0) {
            add(sprite.getTexture(), sprite.getVertices(), 0, 20);
            return;
        }
        float[] vertices = sprite.getVertices();
        System.arraycopy(vertices, 0, tempVertices, 0, 15);
        System.arraycopy(vertices, 10, tempVertices, 15, 5);
        System.arraycopy(vertices, 15, tempVertices, 20, 5);
        System.arraycopy(vertices, 0, tempVertices, 25, 5);
        add(sprite.getTexture(), tempVertices, 0, 30);
    }
}
