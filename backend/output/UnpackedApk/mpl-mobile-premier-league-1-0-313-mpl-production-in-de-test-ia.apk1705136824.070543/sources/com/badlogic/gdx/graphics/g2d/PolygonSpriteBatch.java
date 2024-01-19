package com.badlogic.gdx.graphics.g2d;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.android.AndroidGraphics;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Mesh.VertexDataType;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Affine2;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;

public class PolygonSpriteBatch implements PolygonBatch {
    public int blendDstFunc;
    public int blendDstFuncAlpha;
    public int blendSrcFunc;
    public int blendSrcFuncAlpha;
    public boolean blendingDisabled;
    public final Color color;
    public float colorPacked;
    public final Matrix4 combinedMatrix;
    public ShaderProgram customShader;
    public boolean drawing;
    public float invTexHeight;
    public float invTexWidth;
    public Texture lastTexture;
    public int maxTrianglesInBatch;
    public Mesh mesh;
    public boolean ownsShader;
    public final Matrix4 projectionMatrix;
    public int renderCalls;
    public final ShaderProgram shader;
    public int totalRenderCalls;
    public final Matrix4 transformMatrix;
    public int triangleIndex;
    public final short[] triangles;
    public int vertexIndex;
    public final float[] vertices;

    public PolygonSpriteBatch() {
        this(2000, null);
    }

    private void switchTexture(Texture texture) {
        flush();
        this.lastTexture = texture;
        this.invTexWidth = 1.0f / ((float) texture.getWidth());
        this.invTexHeight = 1.0f / ((float) texture.getHeight());
    }

    public void begin() {
        if (!this.drawing) {
            this.renderCalls = 0;
            k.gl.glDepthMask(false);
            ShaderProgram shaderProgram = this.customShader;
            if (shaderProgram != null) {
                shaderProgram.bind();
            } else {
                this.shader.bind();
            }
            setupMatrices();
            this.drawing = true;
            return;
        }
        throw new IllegalStateException("PolygonSpriteBatch.end must be called before begin.");
    }

    public void disableBlending() {
        flush();
        this.blendingDisabled = true;
    }

    public void dispose() {
        this.mesh.dispose();
        if (this.ownsShader) {
            ShaderProgram shaderProgram = this.shader;
            if (shaderProgram != null) {
                shaderProgram.dispose();
            }
        }
    }

    public void draw(PolygonRegion polygonRegion, float f2, float f3) {
        if (this.drawing) {
            short[] sArr = this.triangles;
            short[] sArr2 = polygonRegion.triangles;
            int length = sArr2.length;
            float[] fArr = polygonRegion.vertices;
            int length2 = fArr.length;
            Texture texture = polygonRegion.region.texture;
            if (texture != this.lastTexture) {
                switchTexture(texture);
            } else if (this.triangleIndex + length > sArr.length || GeneratedOutlineSupport.outline8(length2, 5, 2, this.vertexIndex) > this.vertices.length) {
                flush();
            }
            int i = this.triangleIndex;
            int i2 = this.vertexIndex;
            int i3 = i2 / 5;
            int i4 = 0;
            int i5 = 0;
            while (i5 < length) {
                sArr[i] = (short) (sArr2[i5] + i3);
                i5++;
                i++;
            }
            this.triangleIndex = i;
            float[] fArr2 = this.vertices;
            float f4 = this.colorPacked;
            float[] fArr3 = polygonRegion.textureCoords;
            while (i4 < length2) {
                int i6 = i2 + 1;
                fArr2[i2] = fArr[i4] + f2;
                int i7 = i6 + 1;
                int i8 = i4 + 1;
                fArr2[i6] = fArr[i8] + f3;
                int i9 = i7 + 1;
                fArr2[i7] = f4;
                int i10 = i9 + 1;
                fArr2[i9] = fArr3[i4];
                fArr2[i10] = fArr3[i8];
                i4 += 2;
                i2 = i10 + 1;
            }
            this.vertexIndex = i2;
            return;
        }
        throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
    }

    public void enableBlending() {
        flush();
        this.blendingDisabled = false;
    }

    public void end() {
        if (this.drawing) {
            if (this.vertexIndex > 0) {
                flush();
            }
            this.lastTexture = null;
            this.drawing = false;
            GL20 gl20 = k.gl;
            gl20.glDepthMask(true);
            if (isBlendingEnabled()) {
                gl20.glDisable(GL20.GL_BLEND);
                return;
            }
            return;
        }
        throw new IllegalStateException("PolygonSpriteBatch.begin must be called before end.");
    }

    public void flush() {
        if (this.vertexIndex != 0) {
            this.renderCalls++;
            this.totalRenderCalls++;
            int i = this.triangleIndex;
            if (i > this.maxTrianglesInBatch) {
                this.maxTrianglesInBatch = i;
            }
            this.lastTexture.bind();
            Mesh mesh2 = this.mesh;
            mesh2.setVertices(this.vertices, 0, this.vertexIndex);
            mesh2.setIndices(this.triangles, 0, i);
            if (this.blendingDisabled) {
                k.gl.glDisable(GL20.GL_BLEND);
            } else {
                k.gl.glEnable(GL20.GL_BLEND);
                int i2 = this.blendSrcFunc;
                if (i2 != -1) {
                    k.gl.glBlendFuncSeparate(i2, this.blendDstFunc, this.blendSrcFuncAlpha, this.blendDstFuncAlpha);
                }
            }
            ShaderProgram shaderProgram = this.customShader;
            if (shaderProgram == null) {
                shaderProgram = this.shader;
            }
            mesh2.render(shaderProgram, 4, 0, i);
            this.vertexIndex = 0;
            this.triangleIndex = 0;
        }
    }

    public int getBlendDstFunc() {
        return this.blendDstFunc;
    }

    public int getBlendDstFuncAlpha() {
        return this.blendDstFuncAlpha;
    }

    public int getBlendSrcFunc() {
        return this.blendSrcFunc;
    }

    public int getBlendSrcFuncAlpha() {
        return this.blendSrcFuncAlpha;
    }

    public Color getColor() {
        return this.color;
    }

    public float getPackedColor() {
        return this.colorPacked;
    }

    public Matrix4 getProjectionMatrix() {
        return this.projectionMatrix;
    }

    public ShaderProgram getShader() {
        ShaderProgram shaderProgram = this.customShader;
        return shaderProgram == null ? this.shader : shaderProgram;
    }

    public Matrix4 getTransformMatrix() {
        return this.transformMatrix;
    }

    public boolean isBlendingEnabled() {
        return !this.blendingDisabled;
    }

    public boolean isDrawing() {
        return this.drawing;
    }

    public void setBlendFunction(int i, int i2) {
        setBlendFunctionSeparate(i, i2, i, i2);
    }

    public void setBlendFunctionSeparate(int i, int i2, int i3, int i4) {
        if (this.blendSrcFunc != i || this.blendDstFunc != i2 || this.blendSrcFuncAlpha != i3 || this.blendDstFuncAlpha != i4) {
            flush();
            this.blendSrcFunc = i;
            this.blendDstFunc = i2;
            this.blendSrcFuncAlpha = i3;
            this.blendDstFuncAlpha = i4;
        }
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
        if (this.drawing) {
            flush();
        }
        this.projectionMatrix.set(matrix4);
        if (this.drawing) {
            setupMatrices();
        }
    }

    public void setShader(ShaderProgram shaderProgram) {
        if (this.drawing) {
            flush();
        }
        this.customShader = shaderProgram;
        if (this.drawing) {
            if (shaderProgram != null) {
                shaderProgram.bind();
            } else {
                this.shader.bind();
            }
            setupMatrices();
        }
    }

    public void setTransformMatrix(Matrix4 matrix4) {
        if (this.drawing) {
            flush();
        }
        this.transformMatrix.set(matrix4);
        if (this.drawing) {
            setupMatrices();
        }
    }

    public void setupMatrices() {
        Matrix4 matrix4 = this.combinedMatrix;
        matrix4.set(this.projectionMatrix);
        matrix4.mul(this.transformMatrix);
        ShaderProgram shaderProgram = this.customShader;
        if (shaderProgram != null) {
            shaderProgram.setUniformMatrix((String) "u_projTrans", this.combinedMatrix);
            this.customShader.setUniformi((String) "u_texture", 0);
            return;
        }
        this.shader.setUniformMatrix((String) "u_projTrans", this.combinedMatrix);
        this.shader.setUniformi((String) "u_texture", 0);
    }

    public PolygonSpriteBatch(int i) {
        this(i, i * 2, null);
    }

    public PolygonSpriteBatch(int i, ShaderProgram shaderProgram) {
        this(i, i * 2, shaderProgram);
    }

    public void setColor(float f2, float f3, float f4, float f5) {
        this.color.set(f2, f3, f4, f5);
        this.colorPacked = this.color.toFloatBits();
    }

    public PolygonSpriteBatch(int i, int i2, ShaderProgram shaderProgram) {
        this.invTexWidth = 0.0f;
        this.invTexHeight = 0.0f;
        this.transformMatrix = new Matrix4();
        this.projectionMatrix = new Matrix4();
        this.combinedMatrix = new Matrix4();
        this.blendSrcFunc = GL20.GL_SRC_ALPHA;
        this.blendDstFunc = GL20.GL_ONE_MINUS_SRC_ALPHA;
        this.blendSrcFuncAlpha = GL20.GL_SRC_ALPHA;
        this.blendDstFuncAlpha = GL20.GL_ONE_MINUS_SRC_ALPHA;
        this.color = new Color(1.0f, 1.0f, 1.0f, 1.0f);
        this.colorPacked = Color.WHITE_FLOAT_BITS;
        this.renderCalls = 0;
        this.totalRenderCalls = 0;
        this.maxTrianglesInBatch = 0;
        if (i <= 32767) {
            int i3 = i2 * 3;
            Mesh mesh2 = new Mesh(k.gl30 != null ? VertexDataType.VertexBufferObjectWithVAO : VertexDataType.VertexArray, false, i, i3, new VertexAttribute(1, 2, ShaderProgram.POSITION_ATTRIBUTE), new VertexAttribute(4, 4, ShaderProgram.COLOR_ATTRIBUTE), new VertexAttribute(16, 2, "a_texCoord0"));
            this.mesh = mesh2;
            this.vertices = new float[(i * 5)];
            this.triangles = new short[i3];
            if (shaderProgram == null) {
                this.shader = SpriteBatch.createDefaultShader();
                this.ownsShader = true;
            } else {
                this.shader = shaderProgram;
            }
            Matrix4 matrix4 = this.projectionMatrix;
            Graphics graphics = k.graphics;
            matrix4.setToOrtho2D(0.0f, 0.0f, (float) ((AndroidGraphics) graphics).width, (float) ((AndroidGraphics) graphics).height);
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("Can't have more than 32767 vertices per batch: ", i));
    }

    public void draw(PolygonRegion polygonRegion, float f2, float f3, float f4, float f5) {
        PolygonRegion polygonRegion2 = polygonRegion;
        if (this.drawing) {
            short[] sArr = this.triangles;
            short[] sArr2 = polygonRegion2.triangles;
            int length = sArr2.length;
            float[] fArr = polygonRegion2.vertices;
            int length2 = fArr.length;
            TextureRegion textureRegion = polygonRegion2.region;
            Texture texture = textureRegion.texture;
            if (texture != this.lastTexture) {
                switchTexture(texture);
            } else if (this.triangleIndex + length > sArr.length || GeneratedOutlineSupport.outline8(length2, 5, 2, this.vertexIndex) > this.vertices.length) {
                flush();
            }
            int i = this.triangleIndex;
            int i2 = this.vertexIndex;
            int i3 = i2 / 5;
            int length3 = sArr2.length;
            int i4 = 0;
            int i5 = 0;
            while (i5 < length3) {
                sArr[i] = (short) (sArr2[i5] + i3);
                i5++;
                i++;
            }
            this.triangleIndex = i;
            float[] fArr2 = this.vertices;
            float f6 = this.colorPacked;
            float[] fArr3 = polygonRegion2.textureCoords;
            float f7 = f4 / ((float) textureRegion.regionWidth);
            float f8 = f5 / ((float) textureRegion.regionHeight);
            while (i4 < length2) {
                int i6 = i2 + 1;
                fArr2[i2] = (fArr[i4] * f7) + f2;
                int i7 = i6 + 1;
                int i8 = i4 + 1;
                fArr2[i6] = (fArr[i8] * f8) + f3;
                int i9 = i7 + 1;
                fArr2[i7] = f6;
                int i10 = i9 + 1;
                fArr2[i9] = fArr3[i4];
                fArr2[i10] = fArr3[i8];
                i4 += 2;
                i2 = i10 + 1;
            }
            this.vertexIndex = i2;
            return;
        }
        throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
    }

    public void draw(PolygonRegion polygonRegion, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        PolygonRegion polygonRegion2 = polygonRegion;
        if (this.drawing) {
            short[] sArr = this.triangles;
            short[] sArr2 = polygonRegion2.triangles;
            int length = sArr2.length;
            float[] fArr = polygonRegion2.vertices;
            int length2 = fArr.length;
            TextureRegion textureRegion = polygonRegion2.region;
            Texture texture = textureRegion.texture;
            if (texture != this.lastTexture) {
                switchTexture(texture);
            } else if (this.triangleIndex + length > sArr.length || GeneratedOutlineSupport.outline8(length2, 5, 2, this.vertexIndex) > this.vertices.length) {
                flush();
            }
            int i = this.triangleIndex;
            int i2 = this.vertexIndex;
            int i3 = i2 / 5;
            int i4 = 0;
            int i5 = 0;
            while (i5 < length) {
                sArr[i] = (short) (sArr2[i5] + i3);
                i5++;
                i++;
            }
            this.triangleIndex = i;
            float[] fArr2 = this.vertices;
            float f11 = this.colorPacked;
            float[] fArr3 = polygonRegion2.textureCoords;
            float f12 = f2 + f4;
            float f13 = f3 + f5;
            float f14 = f6 / ((float) textureRegion.regionWidth);
            float f15 = f7 / ((float) textureRegion.regionHeight);
            float cosDeg = MathUtils.cosDeg(f10);
            float sinDeg = MathUtils.sinDeg(f10);
            while (i4 < length2) {
                float f16 = ((fArr[i4] * f14) - f4) * f8;
                int i6 = i4 + 1;
                float[] fArr4 = fArr;
                float f17 = ((fArr[i6] * f15) - f5) * f9;
                int i7 = i2 + 1;
                fArr2[i2] = ((cosDeg * f16) - (sinDeg * f17)) + f12;
                int i8 = i7 + 1;
                fArr2[i7] = GeneratedOutlineSupport.outline4(f17, cosDeg, f16 * sinDeg, f13);
                int i9 = i8 + 1;
                fArr2[i8] = f11;
                int i10 = i9 + 1;
                fArr2[i9] = fArr3[i4];
                fArr2[i10] = fArr3[i6];
                i4 += 2;
                i2 = i10 + 1;
                fArr = fArr4;
            }
            this.vertexIndex = i2;
            return;
        }
        throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
    }

    public void draw(Texture texture, float[] fArr, int i, int i2, short[] sArr, int i3, int i4) {
        if (this.drawing) {
            short[] sArr2 = this.triangles;
            float[] fArr2 = this.vertices;
            if (texture != this.lastTexture) {
                switchTexture(texture);
            } else if (this.triangleIndex + i4 > sArr2.length || this.vertexIndex + i2 > fArr2.length) {
                flush();
            }
            int i5 = this.triangleIndex;
            int i6 = this.vertexIndex;
            int i7 = i6 / 5;
            int i8 = i4 + i3;
            while (i3 < i8) {
                sArr2[i5] = (short) (sArr[i3] + i7);
                i3++;
                i5++;
            }
            this.triangleIndex = i5;
            System.arraycopy(fArr, i, fArr2, i6, i2);
            this.vertexIndex += i2;
            return;
        }
        throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
    }

    public void draw(Texture texture, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18 = f4;
        float f19 = f5;
        int i5 = i;
        int i6 = i2;
        if (this.drawing) {
            short[] sArr = this.triangles;
            float[] fArr = this.vertices;
            if (texture != this.lastTexture) {
                switchTexture(texture);
            } else if (this.triangleIndex + 6 > sArr.length || this.vertexIndex + 20 > fArr.length) {
                flush();
            }
            int i7 = this.triangleIndex;
            int i8 = this.vertexIndex / 5;
            int i9 = i7 + 1;
            short s = (short) i8;
            sArr[i7] = s;
            int i10 = i9 + 1;
            sArr[i9] = (short) (i8 + 1);
            int i11 = i10 + 1;
            short s2 = (short) (i8 + 2);
            sArr[i10] = s2;
            int i12 = i11 + 1;
            sArr[i11] = s2;
            int i13 = i12 + 1;
            sArr[i12] = (short) (i8 + 3);
            sArr[i13] = s;
            this.triangleIndex = i13 + 1;
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
            float f42 = this.invTexWidth;
            float f43 = ((float) i5) * f42;
            float f44 = this.invTexHeight;
            float f45 = ((float) (i6 + i4)) * f44;
            float f46 = ((float) (i5 + i3)) * f42;
            float f47 = ((float) i6) * f44;
            if (z) {
                float f48 = f43;
                f43 = f46;
                f46 = f48;
            }
            if (z2) {
                float f49 = f45;
                f45 = f47;
                f47 = f49;
            }
            float f50 = this.colorPacked;
            int i14 = this.vertexIndex;
            int i15 = i14 + 1;
            fArr[i14] = f34;
            int i16 = i15 + 1;
            fArr[i15] = f35;
            int i17 = i16 + 1;
            fArr[i16] = f50;
            int i18 = i17 + 1;
            fArr[i17] = f43;
            int i19 = i18 + 1;
            fArr[i18] = f45;
            int i20 = i19 + 1;
            fArr[i19] = f36;
            int i21 = i20 + 1;
            fArr[i20] = f37;
            int i22 = i21 + 1;
            fArr[i21] = f50;
            int i23 = i22 + 1;
            fArr[i22] = f43;
            int i24 = i23 + 1;
            fArr[i23] = f47;
            int i25 = i24 + 1;
            fArr[i24] = f38;
            int i26 = i25 + 1;
            fArr[i25] = f39;
            int i27 = i26 + 1;
            fArr[i26] = f50;
            int i28 = i27 + 1;
            fArr[i27] = f46;
            int i29 = i28 + 1;
            fArr[i28] = f47;
            int i30 = i29 + 1;
            fArr[i29] = f40;
            int i31 = i30 + 1;
            fArr[i30] = f41;
            int i32 = i31 + 1;
            fArr[i31] = f50;
            int i33 = i32 + 1;
            fArr[i32] = f46;
            fArr[i33] = f45;
            this.vertexIndex = i33 + 1;
            return;
        }
        throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
    }

    public void draw(Texture texture, float f2, float f3, float f4, float f5, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int i5 = i;
        int i6 = i2;
        if (this.drawing) {
            short[] sArr = this.triangles;
            float[] fArr = this.vertices;
            if (texture != this.lastTexture) {
                switchTexture(texture);
            } else if (this.triangleIndex + 6 > sArr.length || this.vertexIndex + 20 > fArr.length) {
                flush();
            }
            int i7 = this.triangleIndex;
            int i8 = this.vertexIndex / 5;
            int i9 = i7 + 1;
            short s = (short) i8;
            sArr[i7] = s;
            int i10 = i9 + 1;
            sArr[i9] = (short) (i8 + 1);
            int i11 = i10 + 1;
            short s2 = (short) (i8 + 2);
            sArr[i10] = s2;
            int i12 = i11 + 1;
            sArr[i11] = s2;
            int i13 = i12 + 1;
            sArr[i12] = (short) (i8 + 3);
            sArr[i13] = s;
            this.triangleIndex = i13 + 1;
            float f6 = this.invTexWidth;
            float f7 = ((float) i5) * f6;
            float f8 = this.invTexHeight;
            float f9 = ((float) (i6 + i4)) * f8;
            float f10 = ((float) (i5 + i3)) * f6;
            float f11 = ((float) i6) * f8;
            float f12 = f2 + f4;
            float f13 = f3 + f5;
            if (z) {
                float f14 = f7;
                f7 = f10;
                f10 = f14;
            }
            if (z2) {
                float f15 = f9;
                f9 = f11;
                f11 = f15;
            }
            float f16 = this.colorPacked;
            int i14 = this.vertexIndex;
            int i15 = i14 + 1;
            fArr[i14] = f2;
            int i16 = i15 + 1;
            fArr[i15] = f3;
            int i17 = i16 + 1;
            fArr[i16] = f16;
            int i18 = i17 + 1;
            fArr[i17] = f7;
            int i19 = i18 + 1;
            fArr[i18] = f9;
            int i20 = i19 + 1;
            fArr[i19] = f2;
            int i21 = i20 + 1;
            fArr[i20] = f13;
            int i22 = i21 + 1;
            fArr[i21] = f16;
            int i23 = i22 + 1;
            fArr[i22] = f7;
            int i24 = i23 + 1;
            fArr[i23] = f11;
            int i25 = i24 + 1;
            fArr[i24] = f12;
            int i26 = i25 + 1;
            fArr[i25] = f13;
            int i27 = i26 + 1;
            fArr[i26] = f16;
            int i28 = i27 + 1;
            fArr[i27] = f10;
            int i29 = i28 + 1;
            fArr[i28] = f11;
            int i30 = i29 + 1;
            fArr[i29] = f12;
            int i31 = i30 + 1;
            fArr[i30] = f3;
            int i32 = i31 + 1;
            fArr[i31] = f16;
            int i33 = i32 + 1;
            fArr[i32] = f10;
            fArr[i33] = f9;
            this.vertexIndex = i33 + 1;
            return;
        }
        throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
    }

    public void draw(Texture texture, float f2, float f3, int i, int i2, int i3, int i4) {
        if (this.drawing) {
            short[] sArr = this.triangles;
            float[] fArr = this.vertices;
            if (texture != this.lastTexture) {
                switchTexture(texture);
            } else if (this.triangleIndex + 6 > sArr.length || this.vertexIndex + 20 > fArr.length) {
                flush();
            }
            int i5 = this.triangleIndex;
            int i6 = this.vertexIndex;
            int i7 = i6 / 5;
            int i8 = i5 + 1;
            short s = (short) i7;
            sArr[i5] = s;
            int i9 = i8 + 1;
            sArr[i8] = (short) (i7 + 1);
            int i10 = i9 + 1;
            short s2 = (short) (i7 + 2);
            sArr[i9] = s2;
            int i11 = i10 + 1;
            sArr[i10] = s2;
            int i12 = i11 + 1;
            sArr[i11] = (short) (i7 + 3);
            sArr[i12] = s;
            this.triangleIndex = i12 + 1;
            float f4 = this.invTexWidth;
            float f5 = ((float) i) * f4;
            float f6 = this.invTexHeight;
            float f7 = ((float) (i2 + i4)) * f6;
            float f8 = ((float) (i + i3)) * f4;
            float f9 = ((float) i2) * f6;
            float f10 = ((float) i3) + f2;
            float f11 = ((float) i4) + f3;
            float f12 = this.colorPacked;
            int i13 = i6 + 1;
            fArr[i6] = f2;
            int i14 = i13 + 1;
            fArr[i13] = f3;
            int i15 = i14 + 1;
            fArr[i14] = f12;
            int i16 = i15 + 1;
            fArr[i15] = f5;
            int i17 = i16 + 1;
            fArr[i16] = f7;
            int i18 = i17 + 1;
            fArr[i17] = f2;
            int i19 = i18 + 1;
            fArr[i18] = f11;
            int i20 = i19 + 1;
            fArr[i19] = f12;
            int i21 = i20 + 1;
            fArr[i20] = f5;
            int i22 = i21 + 1;
            fArr[i21] = f9;
            int i23 = i22 + 1;
            fArr[i22] = f10;
            int i24 = i23 + 1;
            fArr[i23] = f11;
            int i25 = i24 + 1;
            fArr[i24] = f12;
            int i26 = i25 + 1;
            fArr[i25] = f8;
            int i27 = i26 + 1;
            fArr[i26] = f9;
            int i28 = i27 + 1;
            fArr[i27] = f10;
            int i29 = i28 + 1;
            fArr[i28] = f3;
            int i30 = i29 + 1;
            fArr[i29] = f12;
            int i31 = i30 + 1;
            fArr[i30] = f8;
            fArr[i31] = f7;
            this.vertexIndex = i31 + 1;
            return;
        }
        throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
    }

    public void draw(Texture texture, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        if (this.drawing) {
            short[] sArr = this.triangles;
            float[] fArr = this.vertices;
            if (texture != this.lastTexture) {
                switchTexture(texture);
            } else if (this.triangleIndex + 6 > sArr.length || this.vertexIndex + 20 > fArr.length) {
                flush();
            }
            int i = this.triangleIndex;
            int i2 = this.vertexIndex;
            int i3 = i2 / 5;
            int i4 = i + 1;
            short s = (short) i3;
            sArr[i] = s;
            int i5 = i4 + 1;
            sArr[i4] = (short) (i3 + 1);
            int i6 = i5 + 1;
            short s2 = (short) (i3 + 2);
            sArr[i5] = s2;
            int i7 = i6 + 1;
            sArr[i6] = s2;
            int i8 = i7 + 1;
            sArr[i7] = (short) (i3 + 3);
            sArr[i8] = s;
            this.triangleIndex = i8 + 1;
            float f10 = f2 + f4;
            float f11 = f3 + f5;
            float f12 = this.colorPacked;
            int i9 = i2 + 1;
            fArr[i2] = f2;
            int i10 = i9 + 1;
            fArr[i9] = f3;
            int i11 = i10 + 1;
            fArr[i10] = f12;
            int i12 = i11 + 1;
            fArr[i11] = f6;
            int i13 = i12 + 1;
            fArr[i12] = f7;
            int i14 = i13 + 1;
            fArr[i13] = f2;
            int i15 = i14 + 1;
            fArr[i14] = f11;
            int i16 = i15 + 1;
            fArr[i15] = f12;
            int i17 = i16 + 1;
            fArr[i16] = f6;
            int i18 = i17 + 1;
            fArr[i17] = f9;
            int i19 = i18 + 1;
            fArr[i18] = f10;
            int i20 = i19 + 1;
            fArr[i19] = f11;
            int i21 = i20 + 1;
            fArr[i20] = f12;
            int i22 = i21 + 1;
            fArr[i21] = f8;
            int i23 = i22 + 1;
            fArr[i22] = f9;
            int i24 = i23 + 1;
            fArr[i23] = f10;
            int i25 = i24 + 1;
            fArr[i24] = f3;
            int i26 = i25 + 1;
            fArr[i25] = f12;
            int i27 = i26 + 1;
            fArr[i26] = f8;
            fArr[i27] = f7;
            this.vertexIndex = i27 + 1;
            return;
        }
        throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
    }

    public void draw(Texture texture, float f2, float f3) {
        draw(texture, f2, f3, (float) texture.getWidth(), (float) texture.getHeight());
    }

    public void draw(Texture texture, float f2, float f3, float f4, float f5) {
        if (this.drawing) {
            short[] sArr = this.triangles;
            float[] fArr = this.vertices;
            if (texture != this.lastTexture) {
                switchTexture(texture);
            } else if (this.triangleIndex + 6 > sArr.length || this.vertexIndex + 20 > fArr.length) {
                flush();
            }
            int i = this.triangleIndex;
            int i2 = this.vertexIndex;
            int i3 = i2 / 5;
            int i4 = i + 1;
            short s = (short) i3;
            sArr[i] = s;
            int i5 = i4 + 1;
            sArr[i4] = (short) (i3 + 1);
            int i6 = i5 + 1;
            short s2 = (short) (i3 + 2);
            sArr[i5] = s2;
            int i7 = i6 + 1;
            sArr[i6] = s2;
            int i8 = i7 + 1;
            sArr[i7] = (short) (i3 + 3);
            sArr[i8] = s;
            this.triangleIndex = i8 + 1;
            float f6 = f4 + f2;
            float f7 = f5 + f3;
            float f8 = this.colorPacked;
            int i9 = i2 + 1;
            fArr[i2] = f2;
            int i10 = i9 + 1;
            fArr[i9] = f3;
            int i11 = i10 + 1;
            fArr[i10] = f8;
            int i12 = i11 + 1;
            fArr[i11] = 0.0f;
            int i13 = i12 + 1;
            fArr[i12] = 1.0f;
            int i14 = i13 + 1;
            fArr[i13] = f2;
            int i15 = i14 + 1;
            fArr[i14] = f7;
            int i16 = i15 + 1;
            fArr[i15] = f8;
            int i17 = i16 + 1;
            fArr[i16] = 0.0f;
            int i18 = i17 + 1;
            fArr[i17] = 0.0f;
            int i19 = i18 + 1;
            fArr[i18] = f6;
            int i20 = i19 + 1;
            fArr[i19] = f7;
            int i21 = i20 + 1;
            fArr[i20] = f8;
            int i22 = i21 + 1;
            fArr[i21] = 1.0f;
            int i23 = i22 + 1;
            fArr[i22] = 0.0f;
            int i24 = i23 + 1;
            fArr[i23] = f6;
            int i25 = i24 + 1;
            fArr[i24] = f3;
            int i26 = i25 + 1;
            fArr[i25] = f8;
            int i27 = i26 + 1;
            fArr[i26] = 1.0f;
            fArr[i27] = 1.0f;
            this.vertexIndex = i27 + 1;
            return;
        }
        throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005b A[LOOP:0: B:13:0x0059->B:14:0x005b, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(com.badlogic.gdx.graphics.Texture r9, float[] r10, int r11, int r12) {
        /*
            r8 = this;
            boolean r0 = r8.drawing
            if (r0 == 0) goto L_0x00a1
            short[] r0 = r8.triangles
            float[] r1 = r8.vertices
            int r2 = r12 / 20
            int r2 = r2 * 6
            com.badlogic.gdx.graphics.Texture r3 = r8.lastTexture
            if (r9 == r3) goto L_0x002a
            r8.switchTexture(r9)
            int r9 = r1.length
            int r2 = r1.length
            int r2 = r2 % 20
            int r9 = r9 - r2
            int r9 = java.lang.Math.min(r12, r9)
            int r2 = r0.length
            int r2 = r2 / 6
            int r2 = r2 * 20
            int r9 = java.lang.Math.min(r9, r2)
            int r2 = r9 / 20
        L_0x0027:
            int r2 = r2 * 6
            goto L_0x0051
        L_0x002a:
            int r9 = r8.triangleIndex
            int r9 = r9 + r2
            int r3 = r0.length
            if (r9 > r3) goto L_0x0039
            int r9 = r8.vertexIndex
            int r9 = r9 + r12
            int r3 = r1.length
            if (r9 <= r3) goto L_0x0037
            goto L_0x0039
        L_0x0037:
            r9 = r12
            goto L_0x0051
        L_0x0039:
            r8.flush()
            int r9 = r1.length
            int r2 = r1.length
            int r2 = r2 % 20
            int r9 = r9 - r2
            int r9 = java.lang.Math.min(r12, r9)
            int r2 = r0.length
            int r2 = r2 / 6
            int r2 = r2 * 20
            int r9 = java.lang.Math.min(r9, r2)
            int r2 = r9 / 20
            goto L_0x0027
        L_0x0051:
            int r3 = r8.vertexIndex
            int r4 = r3 / 5
            short r4 = (short) r4
            int r5 = r8.triangleIndex
            int r2 = r2 + r5
        L_0x0059:
            if (r5 >= r2) goto L_0x0080
            r0[r5] = r4
            int r6 = r5 + 1
            int r7 = r4 + 1
            short r7 = (short) r7
            r0[r6] = r7
            int r6 = r5 + 2
            int r7 = r4 + 2
            short r7 = (short) r7
            r0[r6] = r7
            int r6 = r5 + 3
            r0[r6] = r7
            int r6 = r5 + 4
            int r7 = r4 + 3
            short r7 = (short) r7
            r0[r6] = r7
            int r6 = r5 + 5
            r0[r6] = r4
            int r5 = r5 + 6
            int r4 = r4 + 4
            short r4 = (short) r4
            goto L_0x0059
        L_0x0080:
            java.lang.System.arraycopy(r10, r11, r1, r3, r9)
            int r3 = r3 + r9
            r8.vertexIndex = r3
            r8.triangleIndex = r5
            int r12 = r12 - r9
            if (r12 != 0) goto L_0x008c
            return
        L_0x008c:
            int r11 = r11 + r9
            r8.flush()
            r3 = 0
            if (r9 <= r12) goto L_0x0080
            int r9 = r0.length
            int r9 = r9 / 6
            int r9 = r9 * 20
            int r9 = java.lang.Math.min(r12, r9)
            int r2 = r9 / 20
            int r5 = r2 * 6
            goto L_0x0080
        L_0x00a1:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "PolygonSpriteBatch.begin must be called before draw."
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch.draw(com.badlogic.gdx.graphics.Texture, float[], int, int):void");
    }

    public void draw(TextureRegion textureRegion, float f2, float f3) {
        draw(textureRegion, f2, f3, (float) textureRegion.getRegionWidth(), (float) textureRegion.getRegionHeight());
    }

    public void draw(TextureRegion textureRegion, float f2, float f3, float f4, float f5) {
        if (this.drawing) {
            short[] sArr = this.triangles;
            float[] fArr = this.vertices;
            Texture texture = textureRegion.texture;
            if (texture != this.lastTexture) {
                switchTexture(texture);
            } else if (this.triangleIndex + 6 > sArr.length || this.vertexIndex + 20 > fArr.length) {
                flush();
            }
            int i = this.triangleIndex;
            int i2 = this.vertexIndex;
            int i3 = i2 / 5;
            int i4 = i + 1;
            short s = (short) i3;
            sArr[i] = s;
            int i5 = i4 + 1;
            sArr[i4] = (short) (i3 + 1);
            int i6 = i5 + 1;
            short s2 = (short) (i3 + 2);
            sArr[i5] = s2;
            int i7 = i6 + 1;
            sArr[i6] = s2;
            int i8 = i7 + 1;
            sArr[i7] = (short) (i3 + 3);
            sArr[i8] = s;
            this.triangleIndex = i8 + 1;
            float f6 = f4 + f2;
            float f7 = f5 + f3;
            float f8 = textureRegion.u;
            float f9 = textureRegion.v2;
            float f10 = textureRegion.u2;
            float f11 = textureRegion.v;
            float f12 = this.colorPacked;
            int i9 = i2 + 1;
            fArr[i2] = f2;
            int i10 = i9 + 1;
            fArr[i9] = f3;
            int i11 = i10 + 1;
            fArr[i10] = f12;
            int i12 = i11 + 1;
            fArr[i11] = f8;
            int i13 = i12 + 1;
            fArr[i12] = f9;
            int i14 = i13 + 1;
            fArr[i13] = f2;
            int i15 = i14 + 1;
            fArr[i14] = f7;
            int i16 = i15 + 1;
            fArr[i15] = f12;
            int i17 = i16 + 1;
            fArr[i16] = f8;
            int i18 = i17 + 1;
            fArr[i17] = f11;
            int i19 = i18 + 1;
            fArr[i18] = f6;
            int i20 = i19 + 1;
            fArr[i19] = f7;
            int i21 = i20 + 1;
            fArr[i20] = f12;
            int i22 = i21 + 1;
            fArr[i21] = f10;
            int i23 = i22 + 1;
            fArr[i22] = f11;
            int i24 = i23 + 1;
            fArr[i23] = f6;
            int i25 = i24 + 1;
            fArr[i24] = f3;
            int i26 = i25 + 1;
            fArr[i25] = f12;
            int i27 = i26 + 1;
            fArr[i26] = f10;
            fArr[i27] = f9;
            this.vertexIndex = i27 + 1;
            return;
        }
        throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
    }

    public void draw(TextureRegion textureRegion, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
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
        if (this.drawing) {
            short[] sArr = this.triangles;
            float[] fArr = this.vertices;
            Texture texture = textureRegion2.texture;
            if (texture != this.lastTexture) {
                switchTexture(texture);
            } else if (this.triangleIndex + 6 > sArr.length || this.vertexIndex + 20 > fArr.length) {
                flush();
            }
            int i = this.triangleIndex;
            int i2 = this.vertexIndex / 5;
            int i3 = i + 1;
            short s = (short) i2;
            sArr[i] = s;
            int i4 = i3 + 1;
            sArr[i3] = (short) (i2 + 1);
            int i5 = i4 + 1;
            short s2 = (short) (i2 + 2);
            sArr[i4] = s2;
            int i6 = i5 + 1;
            sArr[i5] = s2;
            int i7 = i6 + 1;
            sArr[i6] = (short) (i2 + 3);
            sArr[i7] = s;
            this.triangleIndex = i7 + 1;
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
            float f46 = this.colorPacked;
            int i8 = this.vertexIndex;
            int i9 = i8 + 1;
            fArr[i8] = f34;
            int i10 = i9 + 1;
            fArr[i9] = f35;
            int i11 = i10 + 1;
            fArr[i10] = f46;
            int i12 = i11 + 1;
            fArr[i11] = f42;
            int i13 = i12 + 1;
            fArr[i12] = f43;
            int i14 = i13 + 1;
            fArr[i13] = f36;
            int i15 = i14 + 1;
            fArr[i14] = f37;
            int i16 = i15 + 1;
            fArr[i15] = f46;
            int i17 = i16 + 1;
            fArr[i16] = f42;
            int i18 = i17 + 1;
            fArr[i17] = f45;
            int i19 = i18 + 1;
            fArr[i18] = f38;
            int i20 = i19 + 1;
            fArr[i19] = f39;
            int i21 = i20 + 1;
            fArr[i20] = f46;
            int i22 = i21 + 1;
            fArr[i21] = f44;
            int i23 = i22 + 1;
            fArr[i22] = f45;
            int i24 = i23 + 1;
            fArr[i23] = f40;
            int i25 = i24 + 1;
            fArr[i24] = f41;
            int i26 = i25 + 1;
            fArr[i25] = f46;
            int i27 = i26 + 1;
            fArr[i26] = f44;
            fArr[i27] = f43;
            this.vertexIndex = i27 + 1;
            return;
        }
        throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
    }

    public void draw(TextureRegion textureRegion, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, boolean z) {
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        float f20;
        float f21;
        TextureRegion textureRegion2 = textureRegion;
        float f22 = f4;
        float f23 = f5;
        if (this.drawing) {
            short[] sArr = this.triangles;
            float[] fArr = this.vertices;
            Texture texture = textureRegion2.texture;
            if (texture != this.lastTexture) {
                switchTexture(texture);
            } else if (this.triangleIndex + 6 > sArr.length || this.vertexIndex + 20 > fArr.length) {
                flush();
            }
            int i = this.triangleIndex;
            int i2 = this.vertexIndex / 5;
            int i3 = i + 1;
            short s = (short) i2;
            sArr[i] = s;
            int i4 = i3 + 1;
            sArr[i3] = (short) (i2 + 1);
            int i5 = i4 + 1;
            short s2 = (short) (i2 + 2);
            sArr[i4] = s2;
            int i6 = i5 + 1;
            sArr[i5] = s2;
            int i7 = i6 + 1;
            sArr[i6] = (short) (i2 + 3);
            sArr[i7] = s;
            this.triangleIndex = i7 + 1;
            float f24 = f2 + f22;
            float f25 = f3 + f23;
            float f26 = -f22;
            float f27 = -f23;
            float f28 = f6 - f22;
            float f29 = f7 - f23;
            if (!(f8 == 1.0f && f9 == 1.0f)) {
                f26 *= f8;
                f27 *= f9;
                f28 *= f8;
                f29 *= f9;
            }
            if (f10 != 0.0f) {
                float cosDeg = MathUtils.cosDeg(f10);
                float sinDeg = MathUtils.sinDeg(f10);
                float f30 = cosDeg * f26;
                f11 = f30 - (sinDeg * f27);
                float f31 = f26 * sinDeg;
                float f32 = (f27 * cosDeg) + f31;
                float f33 = sinDeg * f29;
                f12 = f30 - f33;
                float f34 = f29 * cosDeg;
                f16 = f31 + f34;
                float f35 = (cosDeg * f28) - f33;
                float f36 = f34 + (sinDeg * f28);
                f13 = f36 - (f16 - f32);
                float f37 = f36;
                f17 = (f35 - f12) + f11;
                f28 = f35;
                f14 = f32;
                f15 = f37;
            } else {
                f12 = f26;
                f11 = f12;
                f14 = f27;
                f13 = f14;
                f16 = f29;
                f15 = f16;
                f17 = f28;
            }
            float f38 = f11 + f24;
            float f39 = f14 + f25;
            float f40 = f12 + f24;
            float f41 = f16 + f25;
            float f42 = f28 + f24;
            float f43 = f15 + f25;
            float f44 = f17 + f24;
            float f45 = f13 + f25;
            if (z) {
                f20 = textureRegion2.u2;
                f19 = textureRegion2.v2;
                f18 = textureRegion2.u;
                f21 = textureRegion2.v;
            } else {
                f20 = textureRegion2.u;
                f19 = textureRegion2.v;
                f18 = textureRegion2.u2;
                f21 = textureRegion2.v2;
            }
            float f46 = f21;
            float f47 = f19;
            float f48 = f18;
            float f49 = f20;
            float f50 = this.colorPacked;
            float f51 = f49;
            int i8 = this.vertexIndex;
            int i9 = i8 + 1;
            fArr[i8] = f38;
            int i10 = i9 + 1;
            fArr[i9] = f39;
            int i11 = i10 + 1;
            fArr[i10] = f50;
            int i12 = i11 + 1;
            fArr[i11] = f49;
            int i13 = i12 + 1;
            fArr[i12] = f47;
            int i14 = i13 + 1;
            fArr[i13] = f40;
            int i15 = i14 + 1;
            fArr[i14] = f41;
            int i16 = i15 + 1;
            fArr[i15] = f50;
            int i17 = i16 + 1;
            fArr[i16] = f48;
            int i18 = i17 + 1;
            fArr[i17] = f47;
            int i19 = i18 + 1;
            fArr[i18] = f42;
            int i20 = i19 + 1;
            fArr[i19] = f43;
            int i21 = i20 + 1;
            fArr[i20] = f50;
            int i22 = i21 + 1;
            fArr[i21] = f48;
            int i23 = i22 + 1;
            fArr[i22] = f21;
            int i24 = i23 + 1;
            fArr[i23] = f44;
            int i25 = i24 + 1;
            fArr[i24] = f45;
            int i26 = i25 + 1;
            fArr[i25] = f50;
            int i27 = i26 + 1;
            fArr[i26] = f51;
            fArr[i27] = f46;
            this.vertexIndex = i27 + 1;
            return;
        }
        throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
    }

    public void draw(TextureRegion textureRegion, float f2, float f3, Affine2 affine2) {
        TextureRegion textureRegion2 = textureRegion;
        float f4 = f3;
        Affine2 affine22 = affine2;
        if (this.drawing) {
            short[] sArr = this.triangles;
            float[] fArr = this.vertices;
            Texture texture = textureRegion2.texture;
            if (texture != this.lastTexture) {
                switchTexture(texture);
            } else if (this.triangleIndex + 6 > sArr.length || this.vertexIndex + 20 > fArr.length) {
                flush();
            }
            int i = this.triangleIndex;
            int i2 = this.vertexIndex;
            int i3 = i2 / 5;
            int i4 = i + 1;
            short s = (short) i3;
            sArr[i] = s;
            int i5 = i4 + 1;
            sArr[i4] = (short) (i3 + 1);
            int i6 = i5 + 1;
            short s2 = (short) (i3 + 2);
            sArr[i5] = s2;
            int i7 = i6 + 1;
            sArr[i6] = s2;
            int i8 = i7 + 1;
            sArr[i7] = (short) (i3 + 3);
            sArr[i8] = s;
            this.triangleIndex = i8 + 1;
            float f5 = affine22.m02;
            float f6 = affine22.m12;
            float f7 = affine22.m01;
            float f8 = (f7 * f4) + f5;
            float f9 = affine22.m11;
            float f10 = (f9 * f4) + f6;
            float f11 = affine22.m00;
            float outline4 = GeneratedOutlineSupport.outline4(f7, f4, f11 * f2, f5);
            float f12 = affine22.m10;
            float outline42 = GeneratedOutlineSupport.outline4(f9, f4, f12 * f2, f6);
            float f13 = (f11 * f2) + f5;
            float f14 = (f12 * f2) + f6;
            float f15 = textureRegion2.u;
            float f16 = textureRegion2.v2;
            float f17 = textureRegion2.u2;
            float f18 = textureRegion2.v;
            float f19 = this.colorPacked;
            int i9 = i2 + 1;
            fArr[i2] = f5;
            int i10 = i9 + 1;
            fArr[i9] = f6;
            int i11 = i10 + 1;
            fArr[i10] = f19;
            int i12 = i11 + 1;
            fArr[i11] = f15;
            int i13 = i12 + 1;
            fArr[i12] = f16;
            int i14 = i13 + 1;
            fArr[i13] = f8;
            int i15 = i14 + 1;
            fArr[i14] = f10;
            int i16 = i15 + 1;
            fArr[i15] = f19;
            int i17 = i16 + 1;
            fArr[i16] = f15;
            int i18 = i17 + 1;
            fArr[i17] = f18;
            int i19 = i18 + 1;
            fArr[i18] = outline4;
            int i20 = i19 + 1;
            fArr[i19] = outline42;
            int i21 = i20 + 1;
            fArr[i20] = f19;
            int i22 = i21 + 1;
            fArr[i21] = f17;
            int i23 = i22 + 1;
            fArr[i22] = f18;
            int i24 = i23 + 1;
            fArr[i23] = f13;
            int i25 = i24 + 1;
            fArr[i24] = f14;
            int i26 = i25 + 1;
            fArr[i25] = f19;
            int i27 = i26 + 1;
            fArr[i26] = f17;
            fArr[i27] = f16;
            this.vertexIndex = i27 + 1;
            return;
        }
        throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
    }
}
