package com.badlogic.gdx.graphics.g3d.decals;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Decal {
    public static final int C1 = 3;
    public static final int C2 = 9;
    public static final int C3 = 15;
    public static final int C4 = 21;
    public static final int SIZE = 24;
    public static final int U1 = 4;
    public static final int U2 = 10;
    public static final int U3 = 16;
    public static final int U4 = 22;
    public static final int V1 = 5;
    public static final int V2 = 11;
    public static final int V3 = 17;
    public static final int V4 = 23;
    public static final int VERTEX_SIZE = 6;
    public static final int X1 = 0;
    public static final int X2 = 6;
    public static final int X3 = 12;
    public static final int X4 = 18;
    public static final int Y1 = 1;
    public static final int Y2 = 7;
    public static final int Y3 = 13;
    public static final int Y4 = 19;
    public static final int Z1 = 2;
    public static final int Z2 = 8;
    public static final int Z3 = 14;
    public static final int Z4 = 20;
    public static final Vector3 dir = new Vector3();
    public static Quaternion rotator = new Quaternion(0.0f, 0.0f, 0.0f, 0.0f);
    public static Vector3 tmp = new Vector3();
    public static Vector3 tmp2 = new Vector3();
    public Color color;
    public Vector2 dimensions;
    public DecalMaterial material;
    public Vector3 position;
    public Quaternion rotation;
    public Vector2 scale;
    public Vector2 transformationOffset;
    public boolean updated;
    public int value;
    public float[] vertices;

    public Decal() {
        this.vertices = new float[24];
        this.position = new Vector3();
        this.rotation = new Quaternion();
        this.scale = new Vector2(1.0f, 1.0f);
        this.color = new Color();
        this.transformationOffset = null;
        this.dimensions = new Vector2();
        this.updated = false;
        this.material = new DecalMaterial();
    }

    public static Decal newDecal(TextureRegion textureRegion) {
        return newDecal((float) textureRegion.getRegionWidth(), (float) textureRegion.getRegionHeight(), textureRegion, -1, -1);
    }

    public Color getColor() {
        return this.color;
    }

    public float getHeight() {
        return this.dimensions.y;
    }

    public DecalMaterial getMaterial() {
        return this.material;
    }

    public Vector3 getPosition() {
        return this.position;
    }

    public Quaternion getRotation() {
        return this.rotation;
    }

    public float getScaleX() {
        return this.scale.x;
    }

    public float getScaleY() {
        return this.scale.y;
    }

    public TextureRegion getTextureRegion() {
        return this.material.textureRegion;
    }

    public float[] getVertices() {
        update();
        return this.vertices;
    }

    public float getWidth() {
        return this.dimensions.x;
    }

    public float getX() {
        return this.position.x;
    }

    public float getY() {
        return this.position.y;
    }

    public float getZ() {
        return this.position.z;
    }

    public void lookAt(Vector3 vector3, Vector3 vector32) {
        Vector3 vector33 = dir;
        vector33.set(vector3);
        vector33.sub(this.position);
        vector33.nor();
        setRotation(dir, vector32);
    }

    public void resetVertices() {
        Vector2 vector2 = this.dimensions;
        float f2 = vector2.x;
        float f3 = (-f2) / 2.0f;
        float f4 = f2 + f3;
        float f5 = vector2.y;
        float f6 = f5 / 2.0f;
        float f7 = f6 - f5;
        float[] fArr = this.vertices;
        fArr[0] = f3;
        fArr[1] = f6;
        fArr[2] = 0.0f;
        fArr[6] = f4;
        fArr[7] = f6;
        fArr[8] = 0.0f;
        fArr[12] = f3;
        fArr[13] = f7;
        fArr[14] = 0.0f;
        fArr[18] = f4;
        fArr[19] = f7;
        fArr[20] = 0.0f;
        this.updated = false;
    }

    public void rotateX(float f2) {
        Quaternion quaternion = rotator;
        Vector3 vector3 = Vector3.X;
        if (quaternion != null) {
            quaternion.setFromAxis(vector3.x, vector3.y, vector3.z, f2);
            this.rotation.mul(rotator);
            this.updated = false;
            return;
        }
        throw null;
    }

    public void rotateY(float f2) {
        Quaternion quaternion = rotator;
        Vector3 vector3 = Vector3.Y;
        if (quaternion != null) {
            quaternion.setFromAxis(vector3.x, vector3.y, vector3.z, f2);
            this.rotation.mul(rotator);
            this.updated = false;
            return;
        }
        throw null;
    }

    public void rotateZ(float f2) {
        Quaternion quaternion = rotator;
        Vector3 vector3 = Vector3.Z;
        if (quaternion != null) {
            quaternion.setFromAxis(vector3.x, vector3.y, vector3.z, f2);
            this.rotation.mul(rotator);
            this.updated = false;
            return;
        }
        throw null;
    }

    public void setBlending(int i, int i2) {
        DecalMaterial decalMaterial = this.material;
        decalMaterial.srcBlendFactor = i;
        decalMaterial.dstBlendFactor = i2;
    }

    public void setColor(float f2, float f3, float f4, float f5) {
        this.color.set(f2, f3, f4, f5);
        int i = ((int) (f3 * 255.0f)) << 8;
        int i2 = (int) (f2 * 255.0f);
        float intToFloatColor = k.intToFloatColor(i2 | i | (((int) (f4 * 255.0f)) << 16) | (((int) (f5 * 255.0f)) << 24));
        float[] fArr = this.vertices;
        fArr[3] = intToFloatColor;
        fArr[9] = intToFloatColor;
        fArr[15] = intToFloatColor;
        fArr[21] = intToFloatColor;
    }

    public void setDimensions(float f2, float f3) {
        Vector2 vector2 = this.dimensions;
        vector2.x = f2;
        vector2.y = f3;
        this.updated = false;
    }

    public void setHeight(float f2) {
        this.dimensions.y = f2;
        this.updated = false;
    }

    public void setMaterial(DecalMaterial decalMaterial) {
        this.material = decalMaterial;
    }

    public void setPackedColor(float f2) {
        Color.abgr8888ToColor(this.color, f2);
        float[] fArr = this.vertices;
        fArr[3] = f2;
        fArr[9] = f2;
        fArr[15] = f2;
        fArr[21] = f2;
    }

    public void setPosition(float f2, float f3, float f4) {
        Vector3 vector3 = this.position;
        vector3.x = f2;
        vector3.y = f3;
        vector3.z = f4;
        this.updated = false;
    }

    public void setRotation(float f2, float f3, float f4) {
        Quaternion quaternion = this.rotation;
        if (quaternion != null) {
            double d2 = (double) (f4 * 0.017453292f * 0.5f);
            float sin = (float) Math.sin(d2);
            float cos = (float) Math.cos(d2);
            double d3 = (double) (f3 * 0.017453292f * 0.5f);
            float sin2 = (float) Math.sin(d3);
            float cos2 = (float) Math.cos(d3);
            double d4 = (double) (f2 * 0.017453292f * 0.5f);
            float sin3 = (float) Math.sin(d4);
            float cos3 = (float) Math.cos(d4);
            float f5 = cos3 * sin2;
            float f6 = sin3 * cos2;
            float f7 = cos3 * cos2;
            float f8 = sin3 * sin2;
            quaternion.x = (f6 * sin) + (f5 * cos);
            quaternion.y = (f6 * cos) - (f5 * sin);
            quaternion.z = (f7 * sin) - (f8 * cos);
            quaternion.w = (f8 * sin) + (f7 * cos);
            this.updated = false;
            return;
        }
        throw null;
    }

    public void setRotationX(float f2) {
        Quaternion quaternion = this.rotation;
        Vector3 vector3 = Vector3.X;
        if (quaternion != null) {
            quaternion.setFromAxis(vector3.x, vector3.y, vector3.z, f2);
            this.updated = false;
            return;
        }
        throw null;
    }

    public void setRotationY(float f2) {
        Quaternion quaternion = this.rotation;
        Vector3 vector3 = Vector3.Y;
        if (quaternion != null) {
            quaternion.setFromAxis(vector3.x, vector3.y, vector3.z, f2);
            this.updated = false;
            return;
        }
        throw null;
    }

    public void setRotationZ(float f2) {
        Quaternion quaternion = this.rotation;
        Vector3 vector3 = Vector3.Z;
        if (quaternion != null) {
            quaternion.setFromAxis(vector3.x, vector3.y, vector3.z, f2);
            this.updated = false;
            return;
        }
        throw null;
    }

    public void setScale(float f2, float f3) {
        Vector2 vector2 = this.scale;
        vector2.x = f2;
        vector2.y = f3;
        this.updated = false;
    }

    public void setScaleX(float f2) {
        this.scale.x = f2;
        this.updated = false;
    }

    public void setScaleY(float f2) {
        this.scale.y = f2;
        this.updated = false;
    }

    public void setTextureRegion(TextureRegion textureRegion) {
        this.material.textureRegion = textureRegion;
        updateUVs();
    }

    public void setWidth(float f2) {
        this.dimensions.x = f2;
        this.updated = false;
    }

    public void setX(float f2) {
        this.position.x = f2;
        this.updated = false;
    }

    public void setY(float f2) {
        this.position.y = f2;
        this.updated = false;
    }

    public void setZ(float f2) {
        this.position.z = f2;
        this.updated = false;
    }

    public void transformVertices() {
        float f2;
        float f3;
        Vector2 vector2 = this.transformationOffset;
        if (vector2 != null) {
            f2 = -vector2.x;
            f3 = -vector2.y;
        } else {
            f2 = 0.0f;
            f3 = 0.0f;
        }
        float[] fArr = this.vertices;
        Vector2 vector22 = this.scale;
        float f4 = (fArr[0] + f2) * vector22.x;
        float f5 = (fArr[1] + f3) * vector22.y;
        float f6 = fArr[2];
        Quaternion quaternion = this.rotation;
        float f7 = quaternion.w;
        float f8 = quaternion.y;
        float f9 = quaternion.z;
        fArr[0] = ((f8 * f6) + (f7 * f4)) - (f9 * f5);
        float f10 = quaternion.x;
        fArr[1] = ((f9 * f4) + (f7 * f5)) - (f10 * f6);
        fArr[2] = ((f10 * f5) + (f7 * f6)) - (f8 * f4);
        float f11 = (((-f10) * f4) - (f8 * f5)) - (f9 * f6);
        quaternion.conjugate();
        float[] fArr2 = this.vertices;
        float f12 = fArr2[0];
        float f13 = fArr2[1];
        float f14 = fArr2[2];
        Quaternion quaternion2 = this.rotation;
        float f15 = quaternion2.x;
        float f16 = quaternion2.w;
        float f17 = quaternion2.z;
        float f18 = (f13 * f17) + (f12 * f16) + (f11 * f15);
        float f19 = quaternion2.y;
        fArr2[0] = f18 - (f14 * f19);
        fArr2[1] = ((f14 * f15) + ((f13 * f16) + (f11 * f19))) - (f12 * f17);
        float f20 = f12 * f19;
        fArr2[2] = (f20 + ((f14 * f16) + (f11 * f17))) - (f13 * f15);
        quaternion2.conjugate();
        float[] fArr3 = this.vertices;
        float f21 = fArr3[0];
        Vector3 vector3 = this.position;
        fArr3[0] = (vector3.x - f2) + f21;
        fArr3[1] = (vector3.y - f3) + fArr3[1];
        fArr3[2] = fArr3[2] + vector3.z;
        Vector2 vector23 = this.scale;
        float f22 = (fArr3[6] + f2) * vector23.x;
        float f23 = (fArr3[7] + f3) * vector23.y;
        float f24 = fArr3[8];
        Quaternion quaternion3 = this.rotation;
        float f25 = quaternion3.w;
        float f26 = quaternion3.y;
        float f27 = quaternion3.z;
        fArr3[6] = ((f26 * f24) + (f25 * f22)) - (f27 * f23);
        float f28 = quaternion3.x;
        fArr3[7] = ((f27 * f22) + (f25 * f23)) - (f28 * f24);
        fArr3[8] = ((f28 * f23) + (f25 * f24)) - (f26 * f22);
        float f29 = (((-f28) * f22) - (f26 * f23)) - (f27 * f24);
        quaternion3.conjugate();
        float[] fArr4 = this.vertices;
        float f30 = fArr4[6];
        float f31 = fArr4[7];
        float f32 = fArr4[8];
        Quaternion quaternion4 = this.rotation;
        float f33 = quaternion4.x;
        float f34 = quaternion4.w;
        float f35 = quaternion4.z;
        float f36 = quaternion4.y;
        fArr4[6] = ((f31 * f35) + ((f30 * f34) + (f29 * f33))) - (f32 * f36);
        fArr4[7] = ((f32 * f33) + ((f31 * f34) + (f29 * f36))) - (f30 * f35);
        float f37 = f30 * f36;
        fArr4[8] = (f37 + ((f32 * f34) + (f29 * f35))) - (f31 * f33);
        quaternion4.conjugate();
        float[] fArr5 = this.vertices;
        float f38 = fArr5[6];
        Vector3 vector32 = this.position;
        fArr5[6] = (vector32.x - f2) + f38;
        fArr5[7] = (vector32.y - f3) + fArr5[7];
        fArr5[8] = fArr5[8] + vector32.z;
        Vector2 vector24 = this.scale;
        float f39 = (fArr5[12] + f2) * vector24.x;
        float f40 = (fArr5[13] + f3) * vector24.y;
        float f41 = fArr5[14];
        Quaternion quaternion5 = this.rotation;
        float f42 = quaternion5.w;
        float f43 = quaternion5.y;
        float f44 = quaternion5.z;
        fArr5[12] = ((f43 * f41) + (f42 * f39)) - (f44 * f40);
        float f45 = quaternion5.x;
        fArr5[13] = ((f44 * f39) + (f42 * f40)) - (f45 * f41);
        fArr5[14] = ((f45 * f40) + (f42 * f41)) - (f43 * f39);
        float f46 = (((-f45) * f39) - (f43 * f40)) - (f44 * f41);
        quaternion5.conjugate();
        float[] fArr6 = this.vertices;
        float f47 = fArr6[12];
        float f48 = fArr6[13];
        float f49 = fArr6[14];
        Quaternion quaternion6 = this.rotation;
        float f50 = quaternion6.x;
        float f51 = quaternion6.w;
        float f52 = quaternion6.z;
        float f53 = (f48 * f52) + (f47 * f51) + (f46 * f50);
        float f54 = quaternion6.y;
        fArr6[12] = f53 - (f49 * f54);
        fArr6[13] = ((f49 * f50) + ((f48 * f51) + (f46 * f54))) - (f47 * f52);
        float f55 = f47 * f54;
        fArr6[14] = (f55 + ((f49 * f51) + (f46 * f52))) - (f48 * f50);
        quaternion6.conjugate();
        float[] fArr7 = this.vertices;
        float f56 = fArr7[12];
        Vector3 vector33 = this.position;
        fArr7[12] = (vector33.x - f2) + f56;
        fArr7[13] = (vector33.y - f3) + fArr7[13];
        fArr7[14] = fArr7[14] + vector33.z;
        Vector2 vector25 = this.scale;
        float f57 = (fArr7[18] + f2) * vector25.x;
        float f58 = (fArr7[19] + f3) * vector25.y;
        float f59 = fArr7[20];
        Quaternion quaternion7 = this.rotation;
        float f60 = quaternion7.w;
        float f61 = quaternion7.y;
        float f62 = quaternion7.z;
        fArr7[18] = ((f61 * f59) + (f60 * f57)) - (f62 * f58);
        float f63 = quaternion7.x;
        fArr7[19] = ((f62 * f57) + (f60 * f58)) - (f63 * f59);
        fArr7[20] = ((f63 * f58) + (f60 * f59)) - (f61 * f57);
        float f64 = (((-f63) * f57) - (f61 * f58)) - (f62 * f59);
        quaternion7.conjugate();
        float[] fArr8 = this.vertices;
        float f65 = fArr8[18];
        float f66 = fArr8[19];
        float f67 = fArr8[20];
        Quaternion quaternion8 = this.rotation;
        float f68 = quaternion8.x;
        float f69 = quaternion8.w;
        float f70 = quaternion8.z;
        float f71 = (f66 * f70) + (f65 * f69) + (f64 * f68);
        float f72 = quaternion8.y;
        fArr8[18] = f71 - (f67 * f72);
        fArr8[19] = ((f67 * f68) + ((f66 * f69) + (f64 * f72))) - (f65 * f70);
        float f73 = f65 * f72;
        fArr8[20] = (f73 + ((f67 * f69) + (f64 * f70))) - (f66 * f68);
        quaternion8.conjugate();
        float[] fArr9 = this.vertices;
        float f74 = fArr9[18];
        Vector3 vector34 = this.position;
        fArr9[18] = (vector34.x - f2) + f74;
        fArr9[19] = (vector34.y - f3) + fArr9[19];
        fArr9[20] = fArr9[20] + vector34.z;
        this.updated = true;
    }

    public void translate(float f2, float f3, float f4) {
        this.position.add(f2, f3, f4);
        this.updated = false;
    }

    public void translateX(float f2) {
        this.position.x += f2;
        this.updated = false;
    }

    public void translateY(float f2) {
        this.position.y += f2;
        this.updated = false;
    }

    public void translateZ(float f2) {
        this.position.z += f2;
        this.updated = false;
    }

    public void update() {
        if (!this.updated) {
            resetVertices();
            transformVertices();
        }
    }

    public void updateUVs() {
        TextureRegion textureRegion = this.material.textureRegion;
        this.vertices[4] = textureRegion.getU();
        this.vertices[5] = textureRegion.getV();
        this.vertices[10] = textureRegion.getU2();
        this.vertices[11] = textureRegion.getV();
        this.vertices[16] = textureRegion.getU();
        this.vertices[17] = textureRegion.getV2();
        this.vertices[22] = textureRegion.getU2();
        this.vertices[23] = textureRegion.getV2();
    }

    public static Decal newDecal(TextureRegion textureRegion, boolean z) {
        float regionWidth = (float) textureRegion.getRegionWidth();
        float regionHeight = (float) textureRegion.getRegionHeight();
        int i = -1;
        int i2 = z ? GL20.GL_SRC_ALPHA : -1;
        if (z) {
            i = GL20.GL_ONE_MINUS_SRC_ALPHA;
        }
        return newDecal(regionWidth, regionHeight, textureRegion, i2, i);
    }

    public static Decal newDecal(float f2, float f3, TextureRegion textureRegion) {
        return newDecal(f2, f3, textureRegion, -1, -1);
    }

    public void translate(Vector3 vector3) {
        this.position.add(vector3);
        this.updated = false;
    }

    public static Decal newDecal(float f2, float f3, TextureRegion textureRegion, boolean z) {
        int i = -1;
        int i2 = z ? GL20.GL_SRC_ALPHA : -1;
        if (z) {
            i = GL20.GL_ONE_MINUS_SRC_ALPHA;
        }
        return newDecal(f2, f3, textureRegion, i2, i);
    }

    public static Decal newDecal(float f2, float f3, TextureRegion textureRegion, int i, int i2) {
        Decal decal = new Decal();
        decal.setTextureRegion(textureRegion);
        decal.setBlending(i, i2);
        Vector2 vector2 = decal.dimensions;
        vector2.x = f2;
        vector2.y = f3;
        decal.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        return decal;
    }

    public void setScale(float f2) {
        Vector2 vector2 = this.scale;
        vector2.x = f2;
        vector2.y = f2;
        this.updated = false;
    }

    public void setPosition(Vector3 vector3) {
        this.position.set(vector3);
        this.updated = false;
    }

    public void setColor(Color color2) {
        this.color.set(color2);
        float floatBits = color2.toFloatBits();
        float[] fArr = this.vertices;
        fArr[3] = floatBits;
        fArr[9] = floatBits;
        fArr[15] = floatBits;
        fArr[21] = floatBits;
    }

    public Decal(DecalMaterial decalMaterial) {
        this.vertices = new float[24];
        this.position = new Vector3();
        this.rotation = new Quaternion();
        this.scale = new Vector2(1.0f, 1.0f);
        this.color = new Color();
        this.transformationOffset = null;
        this.dimensions = new Vector2();
        this.updated = false;
        this.material = decalMaterial;
    }

    public static Decal newDecal(float f2, float f3, TextureRegion textureRegion, int i, int i2, DecalMaterial decalMaterial) {
        Decal decal = new Decal(decalMaterial);
        decal.setTextureRegion(textureRegion);
        decal.setBlending(i, i2);
        Vector2 vector2 = decal.dimensions;
        vector2.x = f2;
        vector2.y = f3;
        decal.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        return decal;
    }

    public void setRotation(Vector3 vector3, Vector3 vector32) {
        Vector3 vector33 = tmp;
        vector33.set(vector32);
        vector33.crs(vector3);
        vector33.nor();
        Vector3 vector34 = tmp2;
        vector34.set(vector3);
        vector34.crs(tmp);
        vector34.nor();
        Quaternion quaternion = this.rotation;
        Vector3 vector35 = tmp;
        float f2 = vector35.x;
        Vector3 vector36 = tmp2;
        quaternion.setFromAxes(false, f2, vector36.x, vector3.x, vector35.y, vector36.y, vector3.y, vector35.z, vector36.z, vector3.z);
        this.updated = false;
    }

    public void setRotation(Quaternion quaternion) {
        this.rotation.set(quaternion);
        this.updated = false;
    }
}
