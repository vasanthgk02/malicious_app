package com.badlogic.gdx.graphics.g2d;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Affine2;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class CpuSpriteBatch extends SpriteBatch {
    public final Affine2 adjustAffine;
    public boolean adjustNeeded;
    public boolean haveIdentityRealMatrix;
    public final Affine2 tmpAffine;
    public final Matrix4 virtualMatrix;

    public CpuSpriteBatch() {
        this(1000);
    }

    public static boolean checkEqual(Matrix4 matrix4, Affine2 affine2) {
        float[] fArr = matrix4.val;
        if (fArr[0] == affine2.m00 && fArr[1] == affine2.m10 && fArr[4] == affine2.m01 && fArr[5] == affine2.m11 && fArr[12] == affine2.m02 && fArr[13] == affine2.m12) {
            return true;
        }
        return false;
    }

    public static boolean checkIdt(Matrix4 matrix4) {
        float[] fArr = matrix4.val;
        if (fArr[0] == 1.0f && fArr[1] == 0.0f && fArr[4] == 0.0f && fArr[5] == 1.0f && fArr[12] == 0.0f && fArr[13] == 0.0f) {
            return true;
        }
        return false;
    }

    private void drawAdjusted(TextureRegion textureRegion, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        TextureRegion textureRegion2 = textureRegion;
        drawAdjustedUV(textureRegion2.texture, f2, f3, f4, f5, f6, f7, f8, f9, f10, textureRegion2.u, textureRegion2.v2, textureRegion2.u2, textureRegion2.v, false, false);
    }

    private void drawAdjustedUV(Texture texture, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, boolean z, boolean z2) {
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        float f20;
        float f21;
        float f22;
        float f23;
        float f24;
        float f25;
        float f26 = f4;
        float f27 = f5;
        if (this.drawing) {
            if (texture != this.lastTexture) {
                switchTexture(texture);
            } else if (this.idx == this.vertices.length) {
                super.flush();
            }
            float f28 = f2 + f26;
            float f29 = f3 + f27;
            float f30 = -f26;
            float f31 = -f27;
            float f32 = f6 - f26;
            float f33 = f7 - f27;
            if (!(f8 == 1.0f && f9 == 1.0f)) {
                f30 *= f8;
                f31 *= f9;
                f32 *= f8;
                f33 *= f9;
            }
            if (f10 != 0.0f) {
                float cosDeg = MathUtils.cosDeg(f10);
                float sinDeg = MathUtils.sinDeg(f10);
                float f34 = cosDeg * f30;
                f15 = f34 - (sinDeg * f31);
                float f35 = f30 * sinDeg;
                float f36 = (f31 * cosDeg) + f35;
                float f37 = sinDeg * f33;
                f16 = f34 - f37;
                float f38 = f33 * cosDeg;
                f20 = f35 + f38;
                float f39 = (cosDeg * f32) - f37;
                float f40 = f38 + (sinDeg * f32);
                f17 = f40 - (f20 - f36);
                float f41 = f40;
                f21 = (f39 - f16) + f15;
                f32 = f39;
                f18 = f36;
                f19 = f41;
            } else {
                f16 = f30;
                f15 = f16;
                f18 = f31;
                f17 = f18;
                f20 = f33;
                f19 = f20;
                f21 = f32;
            }
            float f42 = f15 + f28;
            float f43 = f18 + f29;
            float f44 = f16 + f28;
            float f45 = f20 + f29;
            float f46 = f32 + f28;
            float f47 = f19 + f29;
            float f48 = f21 + f28;
            float f49 = f17 + f29;
            if (z) {
                f23 = f11;
                f22 = f13;
            } else {
                f22 = f11;
                f23 = f13;
            }
            if (z2) {
                f24 = f12;
                f25 = f14;
            } else {
                f25 = f12;
                f24 = f14;
            }
            Affine2 affine2 = this.adjustAffine;
            float[] fArr = this.vertices;
            int i = this.idx;
            float f50 = f49;
            float f51 = affine2.m00;
            float f52 = f48;
            float f53 = affine2.m01;
            float f54 = f23;
            float f55 = affine2.m02;
            fArr[i + 0] = (f53 * f43) + (f51 * f42) + f55;
            float f56 = f47;
            float f57 = affine2.m10;
            float f58 = f46;
            float f59 = affine2.m11;
            float f60 = (f43 * f59) + (f42 * f57);
            float f61 = affine2.m12;
            fArr[i + 1] = f60 + f61;
            float f62 = this.colorPacked;
            fArr[i + 2] = f62;
            fArr[i + 3] = f22;
            fArr[i + 4] = f25;
            fArr[i + 5] = GeneratedOutlineSupport.outline4(f53, f45, f51 * f44, f55);
            fArr[i + 6] = GeneratedOutlineSupport.outline4(f45, f59, f44 * f57, f61);
            fArr[i + 7] = f62;
            fArr[i + 8] = f22;
            fArr[i + 9] = f24;
            float f63 = f56;
            fArr[i + 10] = GeneratedOutlineSupport.outline4(f53, f63, f51 * f58, f55);
            fArr[i + 11] = GeneratedOutlineSupport.outline4(f59, f63, f57 * f58, f61);
            fArr[i + 12] = f62;
            fArr[i + 13] = f54;
            fArr[i + 14] = f24;
            float f64 = f50;
            fArr[i + 15] = GeneratedOutlineSupport.outline4(f53, f64, f51 * f52, f55);
            fArr[i + 16] = GeneratedOutlineSupport.outline4(f59, f64, f57 * f52, f61);
            fArr[i + 17] = f62;
            fArr[i + 18] = f54;
            fArr[i + 19] = f25;
            this.idx = i + 20;
            return;
        }
        throw new IllegalStateException("CpuSpriteBatch.begin must be called before draw.");
    }

    public void draw(Texture texture, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        if (!this.adjustNeeded) {
            super.draw(texture, f2, f3, f4, f5, f6, f7, f8, f9, f10, i, i2, i3, i4, z, z2);
        } else {
            drawAdjusted(texture, f2, f3, f4, f5, f6, f7, f8, f9, f10, i, i2, i3, i4, z, z2);
        }
    }

    public void flushAndSyncTransformMatrix() {
        flush();
        if (this.adjustNeeded) {
            boolean checkIdt = checkIdt(this.virtualMatrix);
            this.haveIdentityRealMatrix = checkIdt;
            if (!checkIdt) {
                float[] fArr = this.virtualMatrix.val;
                if ((fArr[0] * fArr[5] * fArr[10] * fArr[15]) + ((((((fArr[2] * fArr[4]) * fArr[9]) * fArr[15]) + ((((fArr[1] * fArr[6]) * fArr[8]) * fArr[15]) + ((((((fArr[1] * fArr[4]) * fArr[11]) * fArr[14]) + ((((fArr[0] * fArr[7]) * fArr[9]) * fArr[14]) + ((((((fArr[3] * fArr[5]) * fArr[8]) * fArr[14]) + ((((fArr[0] * fArr[6]) * fArr[11]) * fArr[13]) + ((((((fArr[3] * fArr[4]) * fArr[10]) * fArr[13]) + ((((fArr[2] * fArr[7]) * fArr[8]) * fArr[13]) + ((((((fArr[2] * fArr[5]) * fArr[11]) * fArr[12]) + ((((fArr[1] * fArr[7]) * fArr[10]) * fArr[12]) + (((((fArr[3] * fArr[6]) * fArr[9]) * fArr[12]) - (((fArr[2] * fArr[7]) * fArr[9]) * fArr[12])) - (((fArr[3] * fArr[5]) * fArr[10]) * fArr[12])))) - (((fArr[1] * fArr[6]) * fArr[11]) * fArr[12])) - (((fArr[3] * fArr[6]) * fArr[8]) * fArr[13])))) - (((fArr[0] * fArr[7]) * fArr[10]) * fArr[13])) - (((fArr[2] * fArr[4]) * fArr[11]) * fArr[13])))) - (((fArr[1] * fArr[7]) * fArr[8]) * fArr[14])) - (((fArr[3] * fArr[4]) * fArr[9]) * fArr[14])))) - (((fArr[0] * fArr[5]) * fArr[11]) * fArr[14])) - (((fArr[2] * fArr[5]) * fArr[8]) * fArr[15])))) - (((fArr[0] * fArr[6]) * fArr[9]) * fArr[15])) - (((fArr[1] * fArr[4]) * fArr[10]) * fArr[15])) == 0.0f) {
                    throw new GdxRuntimeException((String) "Transform matrix is singular, can't sync");
                }
            }
            this.adjustNeeded = false;
            super.setTransformMatrix(this.virtualMatrix);
        }
    }

    public Matrix4 getTransformMatrix() {
        return this.adjustNeeded ? this.virtualMatrix : super.getTransformMatrix();
    }

    public void setTransformMatrix(Matrix4 matrix4) {
        Matrix4 transformMatrix = super.getTransformMatrix();
        if (checkEqual(transformMatrix, matrix4)) {
            this.adjustNeeded = false;
        } else if (isDrawing()) {
            this.virtualMatrix.setAsAffine(matrix4);
            this.adjustNeeded = true;
            if (this.haveIdentityRealMatrix) {
                this.adjustAffine.set(matrix4);
                return;
            }
            this.tmpAffine.set(matrix4);
            Affine2 affine2 = this.adjustAffine;
            affine2.set(transformMatrix);
            affine2.inv();
            affine2.mul(this.tmpAffine);
        } else {
            transformMatrix.setAsAffine(matrix4);
            this.haveIdentityRealMatrix = checkIdt(transformMatrix);
        }
    }

    public CpuSpriteBatch(int i) {
        this(i, null);
    }

    private void drawAdjusted(Texture texture, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int i5 = i;
        int i6 = i2;
        float width = 1.0f / ((float) texture.getWidth());
        float height = 1.0f / ((float) texture.getHeight());
        drawAdjustedUV(texture, f2, f3, f4, f5, f6, f7, f8, f9, f10, ((float) i5) * width, ((float) (i6 + i4)) * height, width * ((float) (i5 + i3)), height * ((float) i6), z, z2);
    }

    public CpuSpriteBatch(int i, ShaderProgram shaderProgram) {
        super(i, shaderProgram);
        this.virtualMatrix = new Matrix4();
        this.adjustAffine = new Affine2();
        this.haveIdentityRealMatrix = true;
        this.tmpAffine = new Affine2();
    }

    public static boolean checkEqual(Matrix4 matrix4, Matrix4 matrix42) {
        boolean z = true;
        if (matrix4 == matrix42) {
            return true;
        }
        float[] fArr = matrix4.val;
        float f2 = fArr[0];
        float[] fArr2 = matrix42.val;
        if (!(f2 == fArr2[0] && fArr[1] == fArr2[1] && fArr[4] == fArr2[4] && fArr[5] == fArr2[5] && fArr[12] == fArr2[12] && fArr[13] == fArr2[13])) {
            z = false;
        }
        return z;
    }

    public void draw(Texture texture, float f2, float f3, float f4, float f5, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        if (!this.adjustNeeded) {
            super.draw(texture, f2, f3, f4, f5, i, i2, i3, i4, z, z2);
        } else {
            drawAdjusted(texture, f2, f3, 0.0f, 0.0f, f4, f5, 1.0f, 1.0f, 0.0f, i, i2, i3, i4, z, z2);
        }
    }

    private void drawAdjusted(TextureRegion textureRegion, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, boolean z) {
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
            Texture texture = textureRegion2.texture;
            if (texture != this.lastTexture) {
                switchTexture(texture);
            } else if (this.idx == this.vertices.length) {
                super.flush();
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
            Affine2 affine2 = this.adjustAffine;
            float[] fArr = this.vertices;
            int i = this.idx;
            float f46 = f45;
            float f47 = affine2.m00;
            float f48 = f44;
            float f49 = affine2.m01;
            float f50 = f21;
            float f51 = affine2.m02;
            fArr[i + 0] = (f49 * f39) + (f47 * f38) + f51;
            float f52 = f43;
            float f53 = affine2.m10;
            float f54 = f42;
            float f55 = affine2.m11;
            float f56 = (f39 * f55) + (f38 * f53);
            float f57 = affine2.m12;
            fArr[i + 1] = f56 + f57;
            float f58 = this.colorPacked;
            fArr[i + 2] = f58;
            fArr[i + 3] = f20;
            fArr[i + 4] = f19;
            fArr[i + 5] = GeneratedOutlineSupport.outline4(f49, f41, f47 * f40, f51);
            fArr[i + 6] = GeneratedOutlineSupport.outline4(f41, f55, f40 * f53, f57);
            fArr[i + 7] = f58;
            fArr[i + 8] = f18;
            fArr[i + 9] = f19;
            float f59 = f52;
            fArr[i + 10] = GeneratedOutlineSupport.outline4(f49, f59, f47 * f54, f51);
            fArr[i + 11] = GeneratedOutlineSupport.outline4(f55, f59, f53 * f54, f57);
            fArr[i + 12] = f58;
            fArr[i + 13] = f18;
            fArr[i + 14] = f50;
            float f60 = f46;
            fArr[i + 15] = GeneratedOutlineSupport.outline4(f49, f60, f47 * f48, f51);
            fArr[i + 16] = GeneratedOutlineSupport.outline4(f55, f60, f53 * f48, f57);
            fArr[i + 17] = f58;
            fArr[i + 18] = f20;
            fArr[i + 19] = f50;
            this.idx = i + 20;
            return;
        }
        throw new IllegalStateException("CpuSpriteBatch.begin must be called before draw.");
    }

    public void draw(Texture texture, float f2, float f3, int i, int i2, int i3, int i4) {
        if (!this.adjustNeeded) {
            super.draw(texture, f2, f3, i, i2, i3, i4);
            return;
        }
        int i5 = i3;
        drawAdjusted(texture, f2, f3, 0.0f, 0.0f, (float) i5, (float) i4, 1.0f, 1.0f, 0.0f, i, i2, i5, i4, false, false);
    }

    public void draw(Texture texture, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        if (!this.adjustNeeded) {
            super.draw(texture, f2, f3, f4, f5, f6, f7, f8, f9);
        } else {
            drawAdjustedUV(texture, f2, f3, 0.0f, 0.0f, f4, f5, 1.0f, 1.0f, 0.0f, f6, f7, f8, f9, false, false);
        }
    }

    public void draw(Texture texture, float f2, float f3) {
        if (!this.adjustNeeded) {
            super.draw(texture, f2, f3);
            return;
        }
        drawAdjusted(texture, f2, f3, 0.0f, 0.0f, (float) texture.getWidth(), (float) texture.getHeight(), 1.0f, 1.0f, 0.0f, 0, 1, 1, 0, false, false);
    }

    public void setTransformMatrix(Affine2 affine2) {
        Matrix4 transformMatrix = super.getTransformMatrix();
        if (checkEqual(transformMatrix, affine2)) {
            this.adjustNeeded = false;
            return;
        }
        this.virtualMatrix.setAsAffine(affine2);
        if (isDrawing()) {
            this.adjustNeeded = true;
            if (this.haveIdentityRealMatrix) {
                Affine2 affine22 = this.adjustAffine;
                if (affine22 != null) {
                    affine22.m00 = affine2.m00;
                    affine22.m01 = affine2.m01;
                    affine22.m02 = affine2.m02;
                    affine22.m10 = affine2.m10;
                    affine22.m11 = affine2.m11;
                    affine22.m12 = affine2.m12;
                    return;
                }
                throw null;
            }
            Affine2 affine23 = this.adjustAffine;
            affine23.set(transformMatrix);
            affine23.inv();
            affine23.mul(affine2);
            return;
        }
        transformMatrix.setAsAffine(affine2);
        this.haveIdentityRealMatrix = checkIdt(transformMatrix);
    }

    public void draw(Texture texture, float f2, float f3, float f4, float f5) {
        if (!this.adjustNeeded) {
            super.draw(texture, f2, f3, f4, f5);
        } else {
            drawAdjusted(texture, f2, f3, 0.0f, 0.0f, f4, f5, 1.0f, 1.0f, 0.0f, 0, 1, 1, 0, false, false);
        }
    }

    public void draw(TextureRegion textureRegion, float f2, float f3) {
        if (!this.adjustNeeded) {
            super.draw(textureRegion, f2, f3);
            return;
        }
        drawAdjusted(textureRegion, f2, f3, 0.0f, 0.0f, (float) textureRegion.getRegionWidth(), (float) textureRegion.getRegionHeight(), 1.0f, 1.0f, 0.0f);
    }

    public void draw(TextureRegion textureRegion, float f2, float f3, float f4, float f5) {
        if (!this.adjustNeeded) {
            super.draw(textureRegion, f2, f3, f4, f5);
        } else {
            drawAdjusted(textureRegion, f2, f3, 0.0f, 0.0f, f4, f5, 1.0f, 1.0f, 0.0f);
        }
    }

    public void draw(TextureRegion textureRegion, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        if (!this.adjustNeeded) {
            super.draw(textureRegion, f2, f3, f4, f5, f6, f7, f8, f9, f10);
        } else {
            drawAdjusted(textureRegion, f2, f3, f4, f5, f6, f7, f8, f9, f10);
        }
    }

    public void draw(TextureRegion textureRegion, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, boolean z) {
        if (!this.adjustNeeded) {
            super.draw(textureRegion, f2, f3, f4, f5, f6, f7, f8, f9, f10, z);
        } else {
            drawAdjusted(textureRegion, f2, f3, f4, f5, f6, f7, f8, f9, f10, z);
        }
    }

    public void draw(Texture texture, float[] fArr, int i, int i2) {
        if (i2 % 20 != 0) {
            throw new GdxRuntimeException((String) "invalid vertex count");
        } else if (!this.adjustNeeded) {
            super.draw(texture, fArr, i, i2);
        } else {
            drawAdjusted(texture, fArr, i, i2);
        }
    }

    public void draw(TextureRegion textureRegion, float f2, float f3, Affine2 affine2) {
        if (!this.adjustNeeded) {
            super.draw(textureRegion, f2, f3, affine2);
        } else {
            drawAdjusted(textureRegion, f2, f3, affine2);
        }
    }

    private void drawAdjusted(TextureRegion textureRegion, float f2, float f3, Affine2 affine2) {
        TextureRegion textureRegion2 = textureRegion;
        float f4 = f3;
        Affine2 affine22 = affine2;
        if (this.drawing) {
            Texture texture = textureRegion2.texture;
            if (texture != this.lastTexture) {
                switchTexture(texture);
            } else if (this.idx == this.vertices.length) {
                super.flush();
            }
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
            float f13 = textureRegion2.u;
            float f14 = textureRegion2.v2;
            float f15 = textureRegion2.u2;
            float f16 = textureRegion2.v;
            Affine2 affine23 = this.adjustAffine;
            float[] fArr = this.vertices;
            int i = this.idx;
            float f17 = (f12 * f2) + f6;
            float f18 = affine23.m00;
            float f19 = (f11 * f2) + f5;
            float f20 = affine23.m01;
            float f21 = f15;
            float f22 = affine23.m02;
            fArr[i + 0] = (f20 * f6) + (f18 * f5) + f22;
            float f23 = outline42;
            float f24 = affine23.m10;
            float f25 = outline4;
            float f26 = affine23.m11;
            float f27 = (f6 * f26) + (f5 * f24);
            float f28 = affine23.m12;
            fArr[i + 1] = f27 + f28;
            float f29 = this.colorPacked;
            fArr[i + 2] = f29;
            fArr[i + 3] = f13;
            fArr[i + 4] = f14;
            fArr[i + 5] = GeneratedOutlineSupport.outline4(f20, f10, f18 * f8, f22);
            fArr[i + 6] = GeneratedOutlineSupport.outline4(f10, f26, f8 * f24, f28);
            fArr[i + 7] = f29;
            fArr[i + 8] = f13;
            fArr[i + 9] = f16;
            float f30 = f23;
            fArr[i + 10] = GeneratedOutlineSupport.outline4(f20, f30, f18 * f25, f22);
            fArr[i + 11] = GeneratedOutlineSupport.outline4(f26, f30, f24 * f25, f28);
            fArr[i + 12] = f29;
            fArr[i + 13] = f21;
            fArr[i + 14] = f16;
            float f31 = f17;
            fArr[i + 15] = GeneratedOutlineSupport.outline4(f20, f31, f18 * f19, f22);
            fArr[i + 16] = GeneratedOutlineSupport.outline4(f26, f31, f24 * f19, f28);
            fArr[i + 17] = f29;
            fArr[i + 18] = f21;
            fArr[i + 19] = f14;
            this.idx = i + 20;
            return;
        }
        throw new IllegalStateException("CpuSpriteBatch.begin must be called before draw.");
    }

    private void drawAdjusted(Texture texture, float[] fArr, int i, int i2) {
        if (this.drawing) {
            if (texture != this.lastTexture) {
                switchTexture(texture);
            }
            Affine2 affine2 = this.adjustAffine;
            int min = Math.min(this.vertices.length - this.idx, i2);
            do {
                i2 -= min;
                while (min > 0) {
                    float f2 = fArr[i];
                    float f3 = fArr[i + 1];
                    float[] fArr2 = this.vertices;
                    int i3 = this.idx;
                    fArr2[i3] = (affine2.m01 * f3) + (affine2.m00 * f2) + affine2.m02;
                    fArr2[i3 + 1] = (affine2.m11 * f3) + (affine2.m10 * f2) + affine2.m12;
                    fArr2[i3 + 2] = fArr[i + 2];
                    fArr2[i3 + 3] = fArr[i + 3];
                    fArr2[i3 + 4] = fArr[i + 4];
                    this.idx = i3 + 5;
                    i += 5;
                    min -= 5;
                }
                if (i2 > 0) {
                    super.flush();
                    min = Math.min(this.vertices.length, i2);
                    continue;
                }
            } while (i2 > 0);
            return;
        }
        throw new IllegalStateException("CpuSpriteBatch.begin must be called before draw.");
    }
}
