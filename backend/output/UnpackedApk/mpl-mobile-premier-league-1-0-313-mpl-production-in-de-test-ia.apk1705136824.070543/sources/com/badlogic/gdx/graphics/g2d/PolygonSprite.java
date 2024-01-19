package com.badlogic.gdx.graphics.g2d;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class PolygonSprite {
    public Rectangle bounds = new Rectangle();
    public final Color color = new Color(1.0f, 1.0f, 1.0f, 1.0f);
    public boolean dirty;
    public float height;
    public float originX;
    public float originY;
    public PolygonRegion region;
    public float rotation;
    public float scaleX = 1.0f;
    public float scaleY = 1.0f;
    public float[] vertices;
    public float width;
    public float x;
    public float y;

    public PolygonSprite(PolygonRegion polygonRegion) {
        setRegion(polygonRegion);
        TextureRegion textureRegion = polygonRegion.region;
        setSize((float) textureRegion.regionWidth, (float) textureRegion.regionHeight);
        setOrigin(this.width / 2.0f, this.height / 2.0f);
    }

    public void draw(PolygonSpriteBatch polygonSpriteBatch) {
        PolygonRegion polygonRegion = this.region;
        Texture texture = polygonRegion.region.texture;
        float[] vertices2 = getVertices();
        int length = this.vertices.length;
        short[] sArr = polygonRegion.triangles;
        polygonSpriteBatch.draw(texture, vertices2, 0, length, sArr, 0, sArr.length);
    }

    public Rectangle getBoundingRectangle() {
        float[] vertices2 = getVertices();
        float f2 = vertices2[0];
        float f3 = vertices2[1];
        float f4 = vertices2[0];
        float f5 = vertices2[1];
        for (int i = 5; i < vertices2.length; i += 5) {
            float f6 = vertices2[i];
            float f7 = vertices2[i + 1];
            if (f2 > f6) {
                f2 = f6;
            }
            if (f4 < f6) {
                f4 = f6;
            }
            if (f3 > f7) {
                f3 = f7;
            }
            if (f5 < f7) {
                f5 = f7;
            }
        }
        Rectangle rectangle = this.bounds;
        rectangle.x = f2;
        rectangle.y = f3;
        rectangle.width = f4 - f2;
        rectangle.height = f5 - f3;
        return rectangle;
    }

    public Color getColor() {
        return this.color;
    }

    public float getHeight() {
        return this.height;
    }

    public float getOriginX() {
        return this.originX;
    }

    public float getOriginY() {
        return this.originY;
    }

    public Color getPackedColor() {
        Color.abgr8888ToColor(this.color, this.vertices[2]);
        return this.color;
    }

    public PolygonRegion getRegion() {
        return this.region;
    }

    public float getRotation() {
        return this.rotation;
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public float[] getVertices() {
        if (!this.dirty) {
            return this.vertices;
        }
        int i = 0;
        this.dirty = false;
        float f2 = this.originX;
        float f3 = this.originY;
        float f4 = this.scaleX;
        float f5 = this.scaleY;
        PolygonRegion polygonRegion = this.region;
        float[] fArr = this.vertices;
        float[] fArr2 = polygonRegion.vertices;
        float f6 = this.x + f2;
        float f7 = this.y + f3;
        float regionWidth = this.width / ((float) polygonRegion.region.getRegionWidth());
        float regionHeight = this.height / ((float) polygonRegion.region.getRegionHeight());
        float cosDeg = MathUtils.cosDeg(this.rotation);
        float sinDeg = MathUtils.sinDeg(this.rotation);
        int length = fArr2.length;
        int i2 = 0;
        while (i < length) {
            float f8 = ((fArr2[i] * regionWidth) - f2) * f4;
            float f9 = ((fArr2[i + 1] * regionHeight) - f3) * f5;
            fArr[i2] = ((cosDeg * f8) - (sinDeg * f9)) + f6;
            fArr[i2 + 1] = GeneratedOutlineSupport.outline4(f9, cosDeg, f8 * sinDeg, f7);
            i += 2;
            i2 += 5;
            f2 = f2;
        }
        return fArr;
    }

    public float getWidth() {
        return this.width;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public void rotate(float f2) {
        this.rotation += f2;
        this.dirty = true;
    }

    public void scale(float f2) {
        this.scaleX += f2;
        this.scaleY += f2;
        this.dirty = true;
    }

    public void set(PolygonSprite polygonSprite) {
        if (polygonSprite != null) {
            setRegion(polygonSprite.region);
            this.x = polygonSprite.x;
            this.y = polygonSprite.y;
            this.width = polygonSprite.width;
            this.height = polygonSprite.height;
            this.originX = polygonSprite.originX;
            this.originY = polygonSprite.originY;
            this.rotation = polygonSprite.rotation;
            this.scaleX = polygonSprite.scaleX;
            this.scaleY = polygonSprite.scaleY;
            this.color.set(polygonSprite.color);
            return;
        }
        throw new IllegalArgumentException("sprite cannot be null.");
    }

    public void setBounds(float f2, float f3, float f4, float f5) {
        this.x = f2;
        this.y = f3;
        this.width = f4;
        this.height = f5;
        this.dirty = true;
    }

    public void setColor(Color color2) {
        this.color.set(color2);
        float floatBits = color2.toFloatBits();
        float[] fArr = this.vertices;
        for (int i = 2; i < fArr.length; i += 5) {
            fArr[i] = floatBits;
        }
    }

    public void setOrigin(float f2, float f3) {
        this.originX = f2;
        this.originY = f3;
        this.dirty = true;
    }

    public void setPosition(float f2, float f3) {
        translate(f2 - this.x, f3 - this.y);
    }

    public void setRegion(PolygonRegion polygonRegion) {
        this.region = polygonRegion;
        float[] fArr = polygonRegion.vertices;
        float[] fArr2 = polygonRegion.textureCoords;
        int length = (fArr.length / 2) * 5;
        float[] fArr3 = this.vertices;
        if (fArr3 == null || fArr3.length != length) {
            this.vertices = new float[length];
        }
        float floatBits = this.color.toFloatBits();
        float[] fArr4 = this.vertices;
        int i = 0;
        for (int i2 = 2; i2 < length; i2 += 5) {
            fArr4[i2] = floatBits;
            fArr4[i2 + 1] = fArr2[i];
            fArr4[i2 + 2] = fArr2[i + 1];
            i += 2;
        }
        this.dirty = true;
    }

    public void setRotation(float f2) {
        this.rotation = f2;
        this.dirty = true;
    }

    public void setScale(float f2) {
        this.scaleX = f2;
        this.scaleY = f2;
        this.dirty = true;
    }

    public void setSize(float f2, float f3) {
        this.width = f2;
        this.height = f3;
        this.dirty = true;
    }

    public void setX(float f2) {
        translateX(f2 - this.x);
    }

    public void setY(float f2) {
        translateY(f2 - this.y);
    }

    public void translate(float f2, float f3) {
        this.x += f2;
        this.y += f3;
        if (!this.dirty) {
            float[] fArr = this.vertices;
            for (int i = 0; i < fArr.length; i += 5) {
                fArr[i] = fArr[i] + f2;
                int i2 = i + 1;
                fArr[i2] = fArr[i2] + f3;
            }
        }
    }

    public void translateX(float f2) {
        this.x += f2;
        if (!this.dirty) {
            float[] fArr = this.vertices;
            for (int i = 0; i < fArr.length; i += 5) {
                fArr[i] = fArr[i] + f2;
            }
        }
    }

    public void translateY(float f2) {
        this.y += f2;
        if (!this.dirty) {
            float[] fArr = this.vertices;
            for (int i = 1; i < fArr.length; i += 5) {
                fArr[i] = fArr[i] + f2;
            }
        }
    }

    public void draw(PolygonSpriteBatch polygonSpriteBatch, float f2) {
        Color color2 = getColor();
        float f3 = color2.f3306a;
        color2.f3306a = f2 * f3;
        setColor(color2);
        draw(polygonSpriteBatch);
        color2.f3306a = f3;
        setColor(color2);
    }

    public void setScale(float f2, float f3) {
        this.scaleX = f2;
        this.scaleY = f3;
        this.dirty = true;
    }

    public void setColor(float f2, float f3, float f4, float f5) {
        this.color.set(f2, f3, f4, f5);
        float floatBits = this.color.toFloatBits();
        float[] fArr = this.vertices;
        for (int i = 2; i < fArr.length; i += 5) {
            fArr[i] = floatBits;
        }
    }

    public PolygonSprite(PolygonSprite polygonSprite) {
        set(polygonSprite);
    }
}
