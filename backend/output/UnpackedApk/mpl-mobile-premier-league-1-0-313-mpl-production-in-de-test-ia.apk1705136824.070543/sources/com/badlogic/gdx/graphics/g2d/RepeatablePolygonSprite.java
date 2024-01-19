package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.EarClippingTriangulator;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ShortArray;

public class RepeatablePolygonSprite {
    public Color color = Color.WHITE;
    public int cols;
    public float density;
    public boolean dirty = true;
    public float gridHeight;
    public float gridWidth;
    public Array<short[]> indices = new Array<>();
    public Vector2 offset = new Vector2();
    public Array<float[]> parts = new Array<>();
    public TextureRegion region;
    public int rows;
    public Array<float[]> vertices = new Array<>();
    public float x = 0.0f;
    public float y = 0.0f;

    private void buildVertices() {
        this.vertices.clear();
        int i = 0;
        while (true) {
            Array<float[]> array = this.parts;
            if (i < array.size) {
                float[] fArr = (float[]) array.get(i);
                if (fArr != null) {
                    float[] fArr2 = new float[((fArr.length * 5) / 2)];
                    int i2 = this.rows;
                    int i3 = i / i2;
                    int i4 = i % i2;
                    int i5 = 0;
                    int i6 = 0;
                    while (i5 < fArr.length) {
                        int i7 = i6 + 1;
                        float f2 = fArr[i5];
                        Vector2 vector2 = this.offset;
                        fArr2[i6] = f2 + vector2.x + this.x;
                        int i8 = i7 + 1;
                        int i9 = i5 + 1;
                        fArr2[i7] = fArr[i9] + vector2.y + this.y;
                        int i10 = i8 + 1;
                        fArr2[i8] = this.color.toFloatBits();
                        float f3 = fArr[i5];
                        float f4 = this.gridWidth;
                        float f5 = (f3 % f4) / f4;
                        float f6 = fArr[i9];
                        float f7 = this.gridHeight;
                        float f8 = (f6 % f7) / f7;
                        if (fArr[i5] == ((float) i3) * f4) {
                            f5 = 0.0f;
                        }
                        float f9 = 1.0f;
                        if (fArr[i5] == ((float) (i3 + 1)) * this.gridWidth) {
                            f5 = 1.0f;
                        }
                        if (fArr[i9] == ((float) i4) * this.gridHeight) {
                            f8 = 0.0f;
                        }
                        if (fArr[i9] != ((float) (i4 + 1)) * this.gridHeight) {
                            f9 = f8;
                        }
                        float u2 = ((this.region.getU2() - this.region.getU()) * f5) + this.region.getU();
                        float v2 = ((this.region.getV2() - this.region.getV()) * f9) + this.region.getV();
                        int i11 = i10 + 1;
                        fArr2[i10] = u2;
                        fArr2[i11] = v2;
                        i5 += 2;
                        i6 = i11 + 1;
                    }
                    this.vertices.add(fArr2);
                }
                i++;
            } else {
                this.dirty = false;
                return;
            }
        }
    }

    private float[] offset(float[] fArr) {
        Vector2 vector2 = this.offset;
        float f2 = fArr[0];
        float f3 = fArr[1];
        vector2.x = f2;
        vector2.y = f3;
        for (int i = 0; i < fArr.length - 1; i += 2) {
            Vector2 vector22 = this.offset;
            if (vector22.x > fArr[i]) {
                vector22.x = fArr[i];
            }
            Vector2 vector23 = this.offset;
            int i2 = i + 1;
            if (vector23.y > fArr[i2]) {
                vector23.y = fArr[i2];
            }
        }
        for (int i3 = 0; i3 < fArr.length; i3 += 2) {
            float f4 = fArr[i3];
            Vector2 vector24 = this.offset;
            fArr[i3] = f4 - vector24.x;
            int i4 = i3 + 1;
            fArr[i4] = fArr[i4] - vector24.y;
        }
        return fArr;
    }

    private float[] snapToGrid(float[] fArr) {
        for (int i = 0; i < fArr.length; i += 2) {
            float f2 = (fArr[i] / this.gridWidth) % 1.0f;
            int i2 = i + 1;
            float f3 = (fArr[i2] / this.gridHeight) % 1.0f;
            if (f2 > 0.99f || f2 < 0.01f) {
                float f4 = this.gridWidth;
                fArr[i] = f4 * ((float) Math.round(fArr[i] / f4));
            }
            if (f3 > 0.99f || f3 < 0.01f) {
                float f5 = this.gridHeight;
                fArr[i2] = f5 * ((float) Math.round(fArr[i2] / f5));
            }
        }
        return fArr;
    }

    public void draw(PolygonSpriteBatch polygonSpriteBatch) {
        if (this.dirty) {
            buildVertices();
        }
        for (int i = 0; i < this.vertices.size; i++) {
            polygonSpriteBatch.draw(this.region.getTexture(), (float[]) this.vertices.get(i), 0, ((float[]) this.vertices.get(i)).length, (short[]) this.indices.get(i), 0, ((short[]) this.indices.get(i)).length);
        }
    }

    public void setColor(Color color2) {
        this.color = color2;
        this.dirty = true;
    }

    public void setPolygon(TextureRegion textureRegion, float[] fArr) {
        setPolygon(textureRegion, fArr, -1.0f);
    }

    public void setPosition(float f2, float f3) {
        this.x = f2;
        this.y = f3;
        this.dirty = true;
    }

    public void setPolygon(TextureRegion textureRegion, float[] fArr, float f2) {
        this.region = textureRegion;
        Polygon polygon = new Polygon(offset(fArr));
        Polygon polygon2 = new Polygon();
        Polygon polygon3 = new Polygon();
        EarClippingTriangulator earClippingTriangulator = new EarClippingTriangulator();
        float[] transformedVertices = polygon.getTransformedVertices();
        float f3 = transformedVertices[0];
        char c2 = 1;
        float f4 = transformedVertices[1];
        float f5 = transformedVertices[0];
        float f6 = transformedVertices[1];
        int length = transformedVertices.length;
        for (int i = 2; i < length; i += 2) {
            if (f3 > transformedVertices[i]) {
                f3 = transformedVertices[i];
            }
            int i2 = i + 1;
            if (f4 > transformedVertices[i2]) {
                f4 = transformedVertices[i2];
            }
            if (f5 < transformedVertices[i]) {
                f5 = transformedVertices[i];
            }
            if (f6 < transformedVertices[i2]) {
                f6 = transformedVertices[i2];
            }
        }
        if (polygon.bounds == null) {
            polygon.bounds = new Rectangle();
        }
        Rectangle rectangle = polygon.bounds;
        rectangle.x = f3;
        rectangle.y = f4;
        rectangle.width = f5 - f3;
        rectangle.height = f6 - f4;
        float width = f2 == -1.0f ? rectangle.getWidth() / ((float) textureRegion.getRegionWidth()) : f2;
        float regionHeight = ((float) textureRegion.getRegionHeight()) / ((float) textureRegion.getRegionWidth());
        this.cols = (int) Math.ceil((double) width);
        float width2 = rectangle.getWidth() / width;
        this.gridWidth = width2;
        this.gridHeight = regionHeight * width2;
        this.rows = (int) Math.ceil((double) (rectangle.getHeight() / this.gridHeight));
        int i3 = 0;
        while (i3 < this.cols) {
            int i4 = 0;
            while (i4 < this.rows) {
                float[] fArr2 = new float[8];
                float f7 = this.gridWidth;
                float f8 = ((float) i3) * f7;
                fArr2[0] = f8;
                float f9 = this.gridHeight;
                float f10 = ((float) i4) * f9;
                fArr2[c2] = f10;
                fArr2[2] = f8;
                i4++;
                float f11 = ((float) i4) * f9;
                fArr2[3] = f11;
                float f12 = ((float) (i3 + 1)) * f7;
                fArr2[4] = f12;
                fArr2[5] = f11;
                fArr2[6] = f12;
                fArr2[7] = f10;
                polygon2.setVertices(fArr2);
                Intersector.intersectPolygons(polygon, polygon2, polygon3);
                float[] fArr3 = polygon3.localVertices;
                if (fArr3.length > 0) {
                    this.parts.add(snapToGrid(fArr3));
                    ShortArray computeTriangles = earClippingTriangulator.computeTriangles(fArr3);
                    Array<short[]> array = this.indices;
                    int i5 = computeTriangles.size;
                    short[] sArr = new short[i5];
                    System.arraycopy(computeTriangles.items, 0, sArr, 0, i5);
                    array.add(sArr);
                } else {
                    this.parts.add(null);
                }
                c2 = 1;
            }
            i3++;
            c2 = 1;
        }
        buildVertices();
    }
}
