package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.Texture;
import java.lang.reflect.Array;

public class TextureRegion {
    public int regionHeight;
    public int regionWidth;
    public Texture texture;
    public float u;
    public float u2;
    public float v;
    public float v2;

    public TextureRegion() {
    }

    public void flip(boolean z, boolean z2) {
        if (z) {
            float f2 = this.u;
            this.u = this.u2;
            this.u2 = f2;
        }
        if (z2) {
            float f3 = this.v;
            this.v = this.v2;
            this.v2 = f3;
        }
    }

    public int getRegionHeight() {
        return this.regionHeight;
    }

    public int getRegionWidth() {
        return this.regionWidth;
    }

    public int getRegionX() {
        return Math.round(this.u * ((float) this.texture.getWidth()));
    }

    public int getRegionY() {
        return Math.round(this.v * ((float) this.texture.getHeight()));
    }

    public Texture getTexture() {
        return this.texture;
    }

    public float getU() {
        return this.u;
    }

    public float getU2() {
        return this.u2;
    }

    public float getV() {
        return this.v;
    }

    public float getV2() {
        return this.v2;
    }

    public boolean isFlipX() {
        return this.u > this.u2;
    }

    public boolean isFlipY() {
        return this.v > this.v2;
    }

    public void scroll(float f2, float f3) {
        if (f2 != 0.0f) {
            float width = (this.u2 - this.u) * ((float) this.texture.getWidth());
            float f4 = (this.u + f2) % 1.0f;
            this.u = f4;
            this.u2 = (width / ((float) this.texture.getWidth())) + f4;
        }
        if (f3 != 0.0f) {
            float height = (this.v2 - this.v) * ((float) this.texture.getHeight());
            float f5 = (this.v + f3) % 1.0f;
            this.v = f5;
            this.v2 = (height / ((float) this.texture.getHeight())) + f5;
        }
    }

    public void setRegion(Texture texture2) {
        this.texture = texture2;
        setRegion(0, 0, texture2.getWidth(), texture2.getHeight());
    }

    public void setRegionHeight(int i) {
        if (isFlipY()) {
            setV((((float) i) / ((float) this.texture.getHeight())) + this.v2);
            return;
        }
        setV2((((float) i) / ((float) this.texture.getHeight())) + this.v);
    }

    public void setRegionWidth(int i) {
        if (isFlipX()) {
            setU((((float) i) / ((float) this.texture.getWidth())) + this.u2);
            return;
        }
        setU2((((float) i) / ((float) this.texture.getWidth())) + this.u);
    }

    public void setRegionX(int i) {
        setU(((float) i) / ((float) this.texture.getWidth()));
    }

    public void setRegionY(int i) {
        setV(((float) i) / ((float) this.texture.getHeight()));
    }

    public void setTexture(Texture texture2) {
        this.texture = texture2;
    }

    public void setU(float f2) {
        this.u = f2;
        this.regionWidth = Math.round(Math.abs(this.u2 - f2) * ((float) this.texture.getWidth()));
    }

    public void setU2(float f2) {
        this.u2 = f2;
        this.regionWidth = Math.round(Math.abs(f2 - this.u) * ((float) this.texture.getWidth()));
    }

    public void setV(float f2) {
        this.v = f2;
        this.regionHeight = Math.round(Math.abs(this.v2 - f2) * ((float) this.texture.getHeight()));
    }

    public void setV2(float f2) {
        this.v2 = f2;
        this.regionHeight = Math.round(Math.abs(f2 - this.v) * ((float) this.texture.getHeight()));
    }

    public TextureRegion[][] split(int i, int i2) {
        int regionX = getRegionX();
        int regionY = getRegionY();
        int i3 = this.regionWidth;
        int i4 = this.regionHeight / i2;
        int i5 = i3 / i;
        int[] iArr = new int[2];
        iArr[1] = i5;
        iArr[0] = i4;
        TextureRegion[][] textureRegionArr = (TextureRegion[][]) Array.newInstance(TextureRegion.class, iArr);
        int i6 = regionY;
        int i7 = 0;
        while (i7 < i4) {
            int i8 = regionX;
            int i9 = 0;
            while (i9 < i5) {
                TextureRegion[] textureRegionArr2 = textureRegionArr[i7];
                TextureRegion textureRegion = new TextureRegion(this.texture, i8, i6, i, i2);
                textureRegionArr2[i9] = textureRegion;
                i9++;
                i8 += i;
            }
            i7++;
            i6 += i2;
        }
        return textureRegionArr;
    }

    public TextureRegion(Texture texture2) {
        if (texture2 != null) {
            this.texture = texture2;
            setRegion(0, 0, texture2.getWidth(), texture2.getHeight());
            return;
        }
        throw new IllegalArgumentException("texture cannot be null.");
    }

    public void setRegion(int i, int i2, int i3, int i4) {
        float width = 1.0f / ((float) this.texture.getWidth());
        float height = 1.0f / ((float) this.texture.getHeight());
        setRegion(((float) i) * width, ((float) i2) * height, ((float) (i + i3)) * width, ((float) (i2 + i4)) * height);
        this.regionWidth = Math.abs(i3);
        this.regionHeight = Math.abs(i4);
    }

    public TextureRegion(Texture texture2, int i, int i2) {
        this.texture = texture2;
        setRegion(0, 0, i, i2);
    }

    public void setRegion(float f2, float f3, float f4, float f5) {
        int width = this.texture.getWidth();
        int height = this.texture.getHeight();
        float f6 = (float) width;
        this.regionWidth = Math.round(Math.abs(f4 - f2) * f6);
        float f7 = (float) height;
        int round = Math.round(Math.abs(f5 - f3) * f7);
        this.regionHeight = round;
        if (this.regionWidth == 1 && round == 1) {
            float f8 = 0.25f / f6;
            f2 += f8;
            f4 -= f8;
            float f9 = 0.25f / f7;
            f3 += f9;
            f5 -= f9;
        }
        this.u = f2;
        this.v = f3;
        this.u2 = f4;
        this.v2 = f5;
    }

    public TextureRegion(Texture texture2, int i, int i2, int i3, int i4) {
        this.texture = texture2;
        setRegion(i, i2, i3, i4);
    }

    public static TextureRegion[][] split(Texture texture2, int i, int i2) {
        return new TextureRegion(texture2).split(i, i2);
    }

    public TextureRegion(Texture texture2, float f2, float f3, float f4, float f5) {
        this.texture = texture2;
        setRegion(f2, f3, f4, f5);
    }

    public TextureRegion(TextureRegion textureRegion) {
        setRegion(textureRegion);
    }

    public void setRegion(TextureRegion textureRegion) {
        this.texture = textureRegion.texture;
        setRegion(textureRegion.u, textureRegion.v, textureRegion.u2, textureRegion.v2);
    }

    public TextureRegion(TextureRegion textureRegion, int i, int i2, int i3, int i4) {
        setRegion(textureRegion, i, i2, i3, i4);
    }

    public void setRegion(TextureRegion textureRegion, int i, int i2, int i3, int i4) {
        this.texture = textureRegion.texture;
        setRegion(textureRegion.getRegionX() + i, textureRegion.getRegionY() + i2, i3, i4);
    }
}
