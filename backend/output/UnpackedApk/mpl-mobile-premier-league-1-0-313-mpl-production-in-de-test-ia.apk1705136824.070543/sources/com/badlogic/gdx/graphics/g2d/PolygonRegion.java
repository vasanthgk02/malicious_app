package com.badlogic.gdx.graphics.g2d;

public class PolygonRegion {
    public final TextureRegion region;
    public final float[] textureCoords;
    public final short[] triangles;
    public final float[] vertices;

    public PolygonRegion(TextureRegion textureRegion, float[] fArr, short[] sArr) {
        this.region = textureRegion;
        this.vertices = fArr;
        this.triangles = sArr;
        float[] fArr2 = new float[fArr.length];
        this.textureCoords = fArr2;
        float f2 = textureRegion.u;
        float f3 = textureRegion.v;
        float f4 = textureRegion.u2 - f2;
        float f5 = textureRegion.v2 - f3;
        int i = textureRegion.regionWidth;
        int i2 = textureRegion.regionHeight;
        int length = fArr.length;
        for (int i3 = 0; i3 < length; i3 += 2) {
            fArr2[i3] = ((fArr[i3] / ((float) i)) * f4) + f2;
            int i4 = i3 + 1;
            fArr2[i4] = ((1.0f - (fArr[i4] / ((float) i2))) * f5) + f3;
        }
    }

    public TextureRegion getRegion() {
        return this.region;
    }

    public float[] getTextureCoords() {
        return this.textureCoords;
    }

    public short[] getTriangles() {
        return this.triangles;
    }

    public float[] getVertices() {
        return this.vertices;
    }
}
