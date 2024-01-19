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

public class SpriteBatch implements Batch {
    @Deprecated
    public static VertexDataType defaultVertexDataType = VertexDataType.VertexArray;
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
    public int idx;
    public float invTexHeight;
    public float invTexWidth;
    public Texture lastTexture;
    public int maxSpritesInBatch;
    public Mesh mesh;
    public boolean ownsShader;
    public final Matrix4 projectionMatrix;
    public int renderCalls;
    public final ShaderProgram shader;
    public int totalRenderCalls;
    public final Matrix4 transformMatrix;
    public final float[] vertices;

    public SpriteBatch() {
        this(1000, null);
    }

    public static ShaderProgram createDefaultShader() {
        ShaderProgram shaderProgram = new ShaderProgram((String) "attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\nuniform mat4 u_projTrans;\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main()\n{\n   v_color = a_color;\n   v_color.a = v_color.a * (255.0/254.0);\n   v_texCoords = a_texCoord0;\n   gl_Position =  u_projTrans * a_position;\n}\n", (String) "#ifdef GL_ES\n#define LOWP lowp\nprecision mediump float;\n#else\n#define LOWP \n#endif\nvarying LOWP vec4 v_color;\nvarying vec2 v_texCoords;\nuniform sampler2D u_texture;\nvoid main()\n{\n  gl_FragColor = v_color * texture2D(u_texture, v_texCoords);\n}");
        if (shaderProgram.isCompiled()) {
            return shaderProgram;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error compiling shader: ");
        outline73.append(shaderProgram.getLog());
        throw new IllegalArgumentException(outline73.toString());
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
        throw new IllegalStateException("SpriteBatch.end must be called before begin.");
    }

    public void disableBlending() {
        if (!this.blendingDisabled) {
            flush();
            this.blendingDisabled = true;
        }
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
            float[] fArr = this.vertices;
            if (texture != this.lastTexture) {
                switchTexture(texture);
            } else if (this.idx == fArr.length) {
                flush();
            }
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
            int i7 = this.idx;
            fArr[i7] = f34;
            fArr[i7 + 1] = f35;
            fArr[i7 + 2] = f50;
            fArr[i7 + 3] = f43;
            fArr[i7 + 4] = f45;
            fArr[i7 + 5] = f36;
            fArr[i7 + 6] = f37;
            fArr[i7 + 7] = f50;
            fArr[i7 + 8] = f43;
            fArr[i7 + 9] = f47;
            fArr[i7 + 10] = f38;
            fArr[i7 + 11] = f39;
            fArr[i7 + 12] = f50;
            fArr[i7 + 13] = f46;
            fArr[i7 + 14] = f47;
            fArr[i7 + 15] = f40;
            fArr[i7 + 16] = f41;
            fArr[i7 + 17] = f50;
            fArr[i7 + 18] = f46;
            fArr[i7 + 19] = f45;
            this.idx = i7 + 20;
            return;
        }
        throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
    }

    public void enableBlending() {
        if (this.blendingDisabled) {
            flush();
            this.blendingDisabled = false;
        }
    }

    public void end() {
        if (this.drawing) {
            if (this.idx > 0) {
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
        throw new IllegalStateException("SpriteBatch.begin must be called before end.");
    }

    public void flush() {
        int i = this.idx;
        if (i != 0) {
            this.renderCalls++;
            this.totalRenderCalls++;
            int i2 = i / 20;
            if (i2 > this.maxSpritesInBatch) {
                this.maxSpritesInBatch = i2;
            }
            int i3 = i2 * 6;
            this.lastTexture.bind();
            Mesh mesh2 = this.mesh;
            mesh2.setVertices(this.vertices, 0, this.idx);
            mesh2.getIndicesBuffer().position(0);
            mesh2.getIndicesBuffer().limit(i3);
            if (this.blendingDisabled) {
                k.gl.glDisable(GL20.GL_BLEND);
            } else {
                k.gl.glEnable(GL20.GL_BLEND);
                int i4 = this.blendSrcFunc;
                if (i4 != -1) {
                    k.gl.glBlendFuncSeparate(i4, this.blendDstFunc, this.blendSrcFuncAlpha, this.blendDstFuncAlpha);
                }
            }
            ShaderProgram shaderProgram = this.customShader;
            if (shaderProgram == null) {
                shaderProgram = this.shader;
            }
            mesh2.render(shaderProgram, 4, 0, i3);
            this.idx = 0;
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

    public void switchTexture(Texture texture) {
        flush();
        this.lastTexture = texture;
        this.invTexWidth = 1.0f / ((float) texture.getWidth());
        this.invTexHeight = 1.0f / ((float) texture.getHeight());
    }

    public SpriteBatch(int i) {
        this(i, null);
    }

    public SpriteBatch(int i, ShaderProgram shaderProgram) {
        this.idx = 0;
        this.lastTexture = null;
        this.invTexWidth = 0.0f;
        this.invTexHeight = 0.0f;
        this.drawing = false;
        this.transformMatrix = new Matrix4();
        this.projectionMatrix = new Matrix4();
        this.combinedMatrix = new Matrix4();
        this.blendingDisabled = false;
        this.blendSrcFunc = GL20.GL_SRC_ALPHA;
        this.blendDstFunc = GL20.GL_ONE_MINUS_SRC_ALPHA;
        this.blendSrcFuncAlpha = GL20.GL_SRC_ALPHA;
        this.blendDstFuncAlpha = GL20.GL_ONE_MINUS_SRC_ALPHA;
        this.customShader = null;
        this.color = new Color(1.0f, 1.0f, 1.0f, 1.0f);
        this.colorPacked = Color.WHITE_FLOAT_BITS;
        this.renderCalls = 0;
        this.totalRenderCalls = 0;
        this.maxSpritesInBatch = 0;
        if (i <= 8191) {
            int i2 = i * 6;
            Mesh mesh2 = new Mesh(k.gl30 != null ? VertexDataType.VertexBufferObjectWithVAO : defaultVertexDataType, false, i * 4, i2, new VertexAttribute(1, 2, ShaderProgram.POSITION_ATTRIBUTE), new VertexAttribute(4, 4, ShaderProgram.COLOR_ATTRIBUTE), new VertexAttribute(16, 2, "a_texCoord0"));
            this.mesh = mesh2;
            Matrix4 matrix4 = this.projectionMatrix;
            Graphics graphics = k.graphics;
            matrix4.setToOrtho2D(0.0f, 0.0f, (float) ((AndroidGraphics) graphics).width, (float) ((AndroidGraphics) graphics).height);
            this.vertices = new float[(i * 20)];
            short[] sArr = new short[i2];
            int i3 = 0;
            short s = 0;
            while (i3 < i2) {
                sArr[i3] = s;
                sArr[i3 + 1] = (short) (s + 1);
                short s2 = (short) (s + 2);
                sArr[i3 + 2] = s2;
                sArr[i3 + 3] = s2;
                sArr[i3 + 4] = (short) (s + 3);
                sArr[i3 + 5] = s;
                i3 += 6;
                s = (short) (s + 4);
            }
            this.mesh.setIndices(sArr);
            if (shaderProgram == null) {
                this.shader = createDefaultShader();
                this.ownsShader = true;
                return;
            }
            this.shader = shaderProgram;
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("Can't have more than 8191 sprites per batch: ", i));
    }

    public void setColor(float f2, float f3, float f4, float f5) {
        this.color.set(f2, f3, f4, f5);
        this.colorPacked = this.color.toFloatBits();
    }

    public void draw(Texture texture, float f2, float f3, float f4, float f5, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        if (this.drawing) {
            float[] fArr = this.vertices;
            if (texture != this.lastTexture) {
                switchTexture(texture);
            } else if (this.idx == fArr.length) {
                flush();
            }
            float f6 = this.invTexWidth;
            float f7 = ((float) i) * f6;
            float f8 = this.invTexHeight;
            float f9 = ((float) (i4 + i2)) * f8;
            float f10 = ((float) (i + i3)) * f6;
            float f11 = ((float) i2) * f8;
            float f12 = f4 + f2;
            float f13 = f5 + f3;
            if (z) {
                float f14 = f10;
                f10 = f7;
                f7 = f14;
            }
            if (z2) {
                float f15 = f9;
                f9 = f11;
                f11 = f15;
            }
            float f16 = this.colorPacked;
            int i5 = this.idx;
            fArr[i5] = f2;
            fArr[i5 + 1] = f3;
            fArr[i5 + 2] = f16;
            fArr[i5 + 3] = f7;
            fArr[i5 + 4] = f9;
            fArr[i5 + 5] = f2;
            fArr[i5 + 6] = f13;
            fArr[i5 + 7] = f16;
            fArr[i5 + 8] = f7;
            fArr[i5 + 9] = f11;
            fArr[i5 + 10] = f12;
            fArr[i5 + 11] = f13;
            fArr[i5 + 12] = f16;
            fArr[i5 + 13] = f10;
            fArr[i5 + 14] = f11;
            fArr[i5 + 15] = f12;
            fArr[i5 + 16] = f3;
            fArr[i5 + 17] = f16;
            fArr[i5 + 18] = f10;
            fArr[i5 + 19] = f9;
            this.idx = i5 + 20;
            return;
        }
        throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
    }

    public void draw(Texture texture, float f2, float f3, int i, int i2, int i3, int i4) {
        if (this.drawing) {
            float[] fArr = this.vertices;
            if (texture != this.lastTexture) {
                switchTexture(texture);
            } else if (this.idx == fArr.length) {
                flush();
            }
            float f4 = this.invTexWidth;
            float f5 = ((float) i) * f4;
            float f6 = this.invTexHeight;
            float f7 = ((float) (i2 + i4)) * f6;
            float f8 = ((float) (i + i3)) * f4;
            float f9 = ((float) i2) * f6;
            float f10 = ((float) i3) + f2;
            float f11 = ((float) i4) + f3;
            float f12 = this.colorPacked;
            int i5 = this.idx;
            fArr[i5] = f2;
            fArr[i5 + 1] = f3;
            fArr[i5 + 2] = f12;
            fArr[i5 + 3] = f5;
            fArr[i5 + 4] = f7;
            fArr[i5 + 5] = f2;
            fArr[i5 + 6] = f11;
            fArr[i5 + 7] = f12;
            fArr[i5 + 8] = f5;
            fArr[i5 + 9] = f9;
            fArr[i5 + 10] = f10;
            fArr[i5 + 11] = f11;
            fArr[i5 + 12] = f12;
            fArr[i5 + 13] = f8;
            fArr[i5 + 14] = f9;
            fArr[i5 + 15] = f10;
            fArr[i5 + 16] = f3;
            fArr[i5 + 17] = f12;
            fArr[i5 + 18] = f8;
            fArr[i5 + 19] = f7;
            this.idx = i5 + 20;
            return;
        }
        throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
    }

    public void draw(Texture texture, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        if (this.drawing) {
            float[] fArr = this.vertices;
            if (texture != this.lastTexture) {
                switchTexture(texture);
            } else if (this.idx == fArr.length) {
                flush();
            }
            float f10 = f4 + f2;
            float f11 = f5 + f3;
            float f12 = this.colorPacked;
            int i = this.idx;
            fArr[i] = f2;
            fArr[i + 1] = f3;
            fArr[i + 2] = f12;
            fArr[i + 3] = f6;
            fArr[i + 4] = f7;
            fArr[i + 5] = f2;
            fArr[i + 6] = f11;
            fArr[i + 7] = f12;
            fArr[i + 8] = f6;
            fArr[i + 9] = f9;
            fArr[i + 10] = f10;
            fArr[i + 11] = f11;
            fArr[i + 12] = f12;
            fArr[i + 13] = f8;
            fArr[i + 14] = f9;
            fArr[i + 15] = f10;
            fArr[i + 16] = f3;
            fArr[i + 17] = f12;
            fArr[i + 18] = f8;
            fArr[i + 19] = f7;
            this.idx = i + 20;
            return;
        }
        throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
    }

    public void draw(Texture texture, float f2, float f3) {
        draw(texture, f2, f3, (float) texture.getWidth(), (float) texture.getHeight());
    }

    public void draw(Texture texture, float f2, float f3, float f4, float f5) {
        if (this.drawing) {
            float[] fArr = this.vertices;
            if (texture != this.lastTexture) {
                switchTexture(texture);
            } else if (this.idx == fArr.length) {
                flush();
            }
            float f6 = f4 + f2;
            float f7 = f5 + f3;
            float f8 = this.colorPacked;
            int i = this.idx;
            fArr[i] = f2;
            fArr[i + 1] = f3;
            fArr[i + 2] = f8;
            fArr[i + 3] = 0.0f;
            fArr[i + 4] = 1.0f;
            fArr[i + 5] = f2;
            fArr[i + 6] = f7;
            fArr[i + 7] = f8;
            fArr[i + 8] = 0.0f;
            fArr[i + 9] = 0.0f;
            fArr[i + 10] = f6;
            fArr[i + 11] = f7;
            fArr[i + 12] = f8;
            fArr[i + 13] = 1.0f;
            fArr[i + 14] = 0.0f;
            fArr[i + 15] = f6;
            fArr[i + 16] = f3;
            fArr[i + 17] = f8;
            fArr[i + 18] = 1.0f;
            fArr[i + 19] = 1.0f;
            this.idx = i + 20;
            return;
        }
        throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002c A[LOOP:0: B:10:0x0029->B:12:0x002c, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(com.badlogic.gdx.graphics.Texture r4, float[] r5, int r6, int r7) {
        /*
            r3 = this;
            boolean r0 = r3.drawing
            if (r0 == 0) goto L_0x0041
            float[] r0 = r3.vertices
            int r0 = r0.length
            com.badlogic.gdx.graphics.Texture r1 = r3.lastTexture
            if (r4 == r1) goto L_0x000f
            r3.switchTexture(r4)
            goto L_0x0018
        L_0x000f:
            int r4 = r3.idx
            int r4 = r0 - r4
            if (r4 != 0) goto L_0x0019
            r3.flush()
        L_0x0018:
            r4 = r0
        L_0x0019:
            int r4 = java.lang.Math.min(r4, r7)
            float[] r1 = r3.vertices
            int r2 = r3.idx
            java.lang.System.arraycopy(r5, r6, r1, r2, r4)
            int r1 = r3.idx
            int r1 = r1 + r4
            r3.idx = r1
        L_0x0029:
            int r7 = r7 - r4
            if (r7 <= 0) goto L_0x0040
            int r6 = r6 + r4
            r3.flush()
            int r4 = java.lang.Math.min(r0, r7)
            float[] r1 = r3.vertices
            r2 = 0
            java.lang.System.arraycopy(r5, r6, r1, r2, r4)
            int r1 = r3.idx
            int r1 = r1 + r4
            r3.idx = r1
            goto L_0x0029
        L_0x0040:
            return
        L_0x0041:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "SpriteBatch.begin must be called before draw."
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.g2d.SpriteBatch.draw(com.badlogic.gdx.graphics.Texture, float[], int, int):void");
    }

    public void draw(TextureRegion textureRegion, float f2, float f3) {
        draw(textureRegion, f2, f3, (float) textureRegion.getRegionWidth(), (float) textureRegion.getRegionHeight());
    }

    public void draw(TextureRegion textureRegion, float f2, float f3, float f4, float f5) {
        if (this.drawing) {
            float[] fArr = this.vertices;
            Texture texture = textureRegion.texture;
            if (texture != this.lastTexture) {
                switchTexture(texture);
            } else if (this.idx == fArr.length) {
                flush();
            }
            float f6 = f4 + f2;
            float f7 = f5 + f3;
            float f8 = textureRegion.u;
            float f9 = textureRegion.v2;
            float f10 = textureRegion.u2;
            float f11 = textureRegion.v;
            float f12 = this.colorPacked;
            int i = this.idx;
            fArr[i] = f2;
            fArr[i + 1] = f3;
            fArr[i + 2] = f12;
            fArr[i + 3] = f8;
            fArr[i + 4] = f9;
            fArr[i + 5] = f2;
            fArr[i + 6] = f7;
            fArr[i + 7] = f12;
            fArr[i + 8] = f8;
            fArr[i + 9] = f11;
            fArr[i + 10] = f6;
            fArr[i + 11] = f7;
            fArr[i + 12] = f12;
            fArr[i + 13] = f10;
            fArr[i + 14] = f11;
            fArr[i + 15] = f6;
            fArr[i + 16] = f3;
            fArr[i + 17] = f12;
            fArr[i + 18] = f10;
            fArr[i + 19] = f9;
            this.idx = i + 20;
            return;
        }
        throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
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
            float[] fArr = this.vertices;
            Texture texture = textureRegion2.texture;
            if (texture != this.lastTexture) {
                switchTexture(texture);
            } else if (this.idx == fArr.length) {
                flush();
            }
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
            int i = this.idx;
            fArr[i] = f34;
            fArr[i + 1] = f35;
            fArr[i + 2] = f46;
            fArr[i + 3] = f42;
            fArr[i + 4] = f43;
            fArr[i + 5] = f36;
            fArr[i + 6] = f37;
            fArr[i + 7] = f46;
            fArr[i + 8] = f42;
            fArr[i + 9] = f45;
            fArr[i + 10] = f38;
            fArr[i + 11] = f39;
            fArr[i + 12] = f46;
            fArr[i + 13] = f44;
            fArr[i + 14] = f45;
            fArr[i + 15] = f40;
            fArr[i + 16] = f41;
            fArr[i + 17] = f46;
            fArr[i + 18] = f44;
            fArr[i + 19] = f43;
            this.idx = i + 20;
            return;
        }
        throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
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
            float[] fArr = this.vertices;
            Texture texture = textureRegion2.texture;
            if (texture != this.lastTexture) {
                switchTexture(texture);
            } else if (this.idx == fArr.length) {
                flush();
            }
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
            float f46 = f19;
            float f47 = f18;
            float f48 = f20;
            float f49 = this.colorPacked;
            float f50 = f48;
            int i = this.idx;
            fArr[i] = f38;
            fArr[i + 1] = f39;
            fArr[i + 2] = f49;
            fArr[i + 3] = f48;
            fArr[i + 4] = f46;
            fArr[i + 5] = f40;
            fArr[i + 6] = f41;
            fArr[i + 7] = f49;
            fArr[i + 8] = f47;
            fArr[i + 9] = f46;
            fArr[i + 10] = f42;
            fArr[i + 11] = f43;
            fArr[i + 12] = f49;
            fArr[i + 13] = f47;
            fArr[i + 14] = f21;
            fArr[i + 15] = f44;
            fArr[i + 16] = f45;
            fArr[i + 17] = f49;
            fArr[i + 18] = f50;
            fArr[i + 19] = f21;
            this.idx = i + 20;
            return;
        }
        throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
    }

    public void draw(TextureRegion textureRegion, float f2, float f3, Affine2 affine2) {
        if (this.drawing) {
            float[] fArr = this.vertices;
            Texture texture = textureRegion.texture;
            if (texture != this.lastTexture) {
                switchTexture(texture);
            } else if (this.idx == fArr.length) {
                flush();
            }
            float f4 = affine2.m02;
            float f5 = affine2.m12;
            float f6 = affine2.m01;
            float f7 = (f6 * f3) + f4;
            float f8 = affine2.m11;
            float f9 = affine2.m00;
            float outline4 = GeneratedOutlineSupport.outline4(f6, f3, f9 * f2, f4);
            float f10 = affine2.m10;
            float outline42 = GeneratedOutlineSupport.outline4(f8, f3, f10 * f2, f5);
            float f11 = (f9 * f2) + f4;
            float f12 = textureRegion.u;
            float f13 = textureRegion.v2;
            float f14 = textureRegion.u2;
            float f15 = textureRegion.v;
            float f16 = this.colorPacked;
            int i = this.idx;
            fArr[i] = f4;
            fArr[i + 1] = f5;
            fArr[i + 2] = f16;
            fArr[i + 3] = f12;
            fArr[i + 4] = f13;
            fArr[i + 5] = f7;
            fArr[i + 6] = (f8 * f3) + f5;
            fArr[i + 7] = f16;
            fArr[i + 8] = f12;
            fArr[i + 9] = f15;
            fArr[i + 10] = outline4;
            fArr[i + 11] = outline42;
            fArr[i + 12] = f16;
            fArr[i + 13] = f14;
            fArr[i + 14] = f15;
            fArr[i + 15] = f11;
            fArr[i + 16] = (f10 * f2) + f5;
            fArr[i + 17] = f16;
            fArr[i + 18] = f14;
            fArr[i + 19] = f13;
            this.idx = i + 20;
            return;
        }
        throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
    }
}
