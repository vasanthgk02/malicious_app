package com.badlogic.gdx.graphics.g2d;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.facebook.imagepipeline.common.RotationOptions;

public class NinePatch {
    public static final int BOTTOM_CENTER = 7;
    public static final int BOTTOM_LEFT = 6;
    public static final int BOTTOM_RIGHT = 8;
    public static final int MIDDLE_CENTER = 4;
    public static final int MIDDLE_LEFT = 3;
    public static final int MIDDLE_RIGHT = 5;
    public static final int TOP_CENTER = 1;
    public static final int TOP_LEFT = 0;
    public static final int TOP_RIGHT = 2;
    public static final Color tmpDrawColor = new Color();
    public int bottomCenter;
    public float bottomHeight;
    public int bottomLeft;
    public int bottomRight;
    public final Color color;
    public int idx;
    public float leftWidth;
    public int middleCenter;
    public float middleHeight;
    public int middleLeft;
    public int middleRight;
    public float middleWidth;
    public float padBottom;
    public float padLeft;
    public float padRight;
    public float padTop;
    public float rightWidth;
    public Texture texture;
    public int topCenter;
    public float topHeight;
    public int topLeft;
    public int topRight;
    public float[] vertices;

    public NinePatch(Texture texture2, int i, int i2, int i3, int i4) {
        this(new TextureRegion(texture2), i, i2, i3, i4);
    }

    private int add(TextureRegion textureRegion, boolean z, boolean z2) {
        Texture texture2 = this.texture;
        if (texture2 == null) {
            this.texture = textureRegion.getTexture();
        } else if (texture2 != textureRegion.getTexture()) {
            throw new IllegalArgumentException("All regions must be from the same texture.");
        }
        float f2 = textureRegion.u;
        float f3 = textureRegion.v2;
        float f4 = textureRegion.u2;
        float f5 = textureRegion.v;
        if (this.texture.getMagFilter() == TextureFilter.Linear || this.texture.getMinFilter() == TextureFilter.Linear) {
            if (z) {
                float width = 0.5f / ((float) this.texture.getWidth());
                f2 += width;
                f4 -= width;
            }
            if (z2) {
                float height = 0.5f / ((float) this.texture.getHeight());
                f3 -= height;
                f5 += height;
            }
        }
        float[] fArr = this.vertices;
        int i = this.idx;
        fArr[i + 3] = f2;
        fArr[i + 4] = f3;
        fArr[i + 8] = f2;
        fArr[i + 9] = f5;
        fArr[i + 13] = f4;
        fArr[i + 14] = f5;
        fArr[i + 18] = f4;
        fArr[i + 19] = f3;
        this.idx = i + 20;
        return i;
    }

    private void load(TextureRegion[] textureRegionArr) {
        if (textureRegionArr[6] != null) {
            this.bottomLeft = add(textureRegionArr[6], false, false);
            this.leftWidth = (float) textureRegionArr[6].getRegionWidth();
            this.bottomHeight = (float) textureRegionArr[6].getRegionHeight();
        } else {
            this.bottomLeft = -1;
        }
        if (textureRegionArr[7] != null) {
            this.bottomCenter = add(textureRegionArr[7], (textureRegionArr[6] == null && textureRegionArr[8] == null) ? false : true, false);
            this.middleWidth = Math.max(this.middleWidth, (float) textureRegionArr[7].getRegionWidth());
            this.bottomHeight = Math.max(this.bottomHeight, (float) textureRegionArr[7].getRegionHeight());
        } else {
            this.bottomCenter = -1;
        }
        if (textureRegionArr[8] != null) {
            this.bottomRight = add(textureRegionArr[8], false, false);
            this.rightWidth = Math.max(this.rightWidth, (float) textureRegionArr[8].getRegionWidth());
            this.bottomHeight = Math.max(this.bottomHeight, (float) textureRegionArr[8].getRegionHeight());
        } else {
            this.bottomRight = -1;
        }
        if (textureRegionArr[3] != null) {
            this.middleLeft = add(textureRegionArr[3], false, (textureRegionArr[0] == null && textureRegionArr[6] == null) ? false : true);
            this.leftWidth = Math.max(this.leftWidth, (float) textureRegionArr[3].getRegionWidth());
            this.middleHeight = Math.max(this.middleHeight, (float) textureRegionArr[3].getRegionHeight());
        } else {
            this.middleLeft = -1;
        }
        if (textureRegionArr[4] != null) {
            this.middleCenter = add(textureRegionArr[4], (textureRegionArr[3] == null && textureRegionArr[5] == null) ? false : true, (textureRegionArr[1] == null && textureRegionArr[7] == null) ? false : true);
            this.middleWidth = Math.max(this.middleWidth, (float) textureRegionArr[4].getRegionWidth());
            this.middleHeight = Math.max(this.middleHeight, (float) textureRegionArr[4].getRegionHeight());
        } else {
            this.middleCenter = -1;
        }
        if (textureRegionArr[5] != null) {
            this.middleRight = add(textureRegionArr[5], false, (textureRegionArr[2] == null && textureRegionArr[8] == null) ? false : true);
            this.rightWidth = Math.max(this.rightWidth, (float) textureRegionArr[5].getRegionWidth());
            this.middleHeight = Math.max(this.middleHeight, (float) textureRegionArr[5].getRegionHeight());
        } else {
            this.middleRight = -1;
        }
        if (textureRegionArr[0] != null) {
            this.topLeft = add(textureRegionArr[0], false, false);
            this.leftWidth = Math.max(this.leftWidth, (float) textureRegionArr[0].getRegionWidth());
            this.topHeight = Math.max(this.topHeight, (float) textureRegionArr[0].getRegionHeight());
        } else {
            this.topLeft = -1;
        }
        if (textureRegionArr[1] != null) {
            this.topCenter = add(textureRegionArr[1], (textureRegionArr[0] == null && textureRegionArr[2] == null) ? false : true, false);
            this.middleWidth = Math.max(this.middleWidth, (float) textureRegionArr[1].getRegionWidth());
            this.topHeight = Math.max(this.topHeight, (float) textureRegionArr[1].getRegionHeight());
        } else {
            this.topCenter = -1;
        }
        if (textureRegionArr[2] != null) {
            this.topRight = add(textureRegionArr[2], false, false);
            this.rightWidth = Math.max(this.rightWidth, (float) textureRegionArr[2].getRegionWidth());
            this.topHeight = Math.max(this.topHeight, (float) textureRegionArr[2].getRegionHeight());
        } else {
            this.topRight = -1;
        }
        int i = this.idx;
        float[] fArr = this.vertices;
        if (i < fArr.length) {
            float[] fArr2 = new float[i];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.vertices = fArr2;
        }
    }

    private void prepareVertices(Batch batch, float f2, float f3, float f4, float f5) {
        float f6 = this.leftWidth;
        float f7 = f2 + f6;
        float f8 = this.bottomHeight;
        float f9 = f3 + f8;
        float f10 = this.rightWidth;
        float f11 = (f4 - f10) - f6;
        float f12 = this.topHeight;
        float f13 = (f5 - f12) - f8;
        float f14 = (f2 + f4) - f10;
        float f15 = (f3 + f5) - f12;
        float floatBits = tmpDrawColor.set(this.color).mul(batch.getColor()).toFloatBits();
        int i = this.bottomLeft;
        if (i != -1) {
            set(i, f2, f3, this.leftWidth, this.bottomHeight, floatBits);
        }
        int i2 = this.bottomCenter;
        if (i2 != -1) {
            set(i2, f7, f3, f11, this.bottomHeight, floatBits);
        }
        int i3 = this.bottomRight;
        if (i3 != -1) {
            set(i3, f14, f3, this.rightWidth, this.bottomHeight, floatBits);
        }
        int i4 = this.middleLeft;
        if (i4 != -1) {
            set(i4, f2, f9, this.leftWidth, f13, floatBits);
        }
        int i5 = this.middleCenter;
        if (i5 != -1) {
            set(i5, f7, f9, f11, f13, floatBits);
        }
        int i6 = this.middleRight;
        if (i6 != -1) {
            set(i6, f14, f9, this.rightWidth, f13, floatBits);
        }
        int i7 = this.topLeft;
        if (i7 != -1) {
            set(i7, f2, f15, this.leftWidth, this.topHeight, floatBits);
        }
        int i8 = this.topCenter;
        if (i8 != -1) {
            set(i8, f7, f15, f11, this.topHeight, floatBits);
        }
        int i9 = this.topRight;
        if (i9 != -1) {
            set(i9, f14, f15, this.rightWidth, this.topHeight, floatBits);
        }
    }

    private void set(int i, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f4 + f2;
        float f8 = f5 + f3;
        float[] fArr = this.vertices;
        fArr[i] = f2;
        fArr[i + 1] = f3;
        fArr[i + 2] = f6;
        fArr[i + 5] = f2;
        fArr[i + 6] = f8;
        fArr[i + 7] = f6;
        fArr[i + 10] = f7;
        fArr[i + 11] = f8;
        fArr[i + 12] = f6;
        fArr[i + 15] = f7;
        fArr[i + 16] = f3;
        fArr[i + 17] = f6;
    }

    public void draw(Batch batch, float f2, float f3, float f4, float f5) {
        prepareVertices(batch, f2, f3, f4, f5);
        batch.draw(this.texture, this.vertices, 0, this.idx);
    }

    public float getBottomHeight() {
        return this.bottomHeight;
    }

    public Color getColor() {
        return this.color;
    }

    public float getLeftWidth() {
        return this.leftWidth;
    }

    public float getMiddleHeight() {
        return this.middleHeight;
    }

    public float getMiddleWidth() {
        return this.middleWidth;
    }

    public float getPadBottom() {
        float f2 = this.padBottom;
        return f2 == -1.0f ? getBottomHeight() : f2;
    }

    public float getPadLeft() {
        float f2 = this.padLeft;
        return f2 == -1.0f ? getLeftWidth() : f2;
    }

    public float getPadRight() {
        float f2 = this.padRight;
        return f2 == -1.0f ? getRightWidth() : f2;
    }

    public float getPadTop() {
        float f2 = this.padTop;
        return f2 == -1.0f ? getTopHeight() : f2;
    }

    public float getRightWidth() {
        return this.rightWidth;
    }

    public Texture getTexture() {
        return this.texture;
    }

    public float getTopHeight() {
        return this.topHeight;
    }

    public float getTotalHeight() {
        return this.topHeight + this.middleHeight + this.bottomHeight;
    }

    public float getTotalWidth() {
        return this.leftWidth + this.middleWidth + this.rightWidth;
    }

    public void scale(float f2, float f3) {
        this.leftWidth *= f2;
        this.rightWidth *= f2;
        this.topHeight *= f3;
        this.bottomHeight *= f3;
        this.middleWidth *= f2;
        this.middleHeight *= f3;
        float f4 = this.padLeft;
        if (f4 != -1.0f) {
            this.padLeft = f4 * f2;
        }
        float f5 = this.padRight;
        if (f5 != -1.0f) {
            this.padRight = f5 * f2;
        }
        float f6 = this.padTop;
        if (f6 != -1.0f) {
            this.padTop = f6 * f3;
        }
        float f7 = this.padBottom;
        if (f7 != -1.0f) {
            this.padBottom = f7 * f3;
        }
    }

    public void setBottomHeight(float f2) {
        this.bottomHeight = f2;
    }

    public void setColor(Color color2) {
        this.color.set(color2);
    }

    public void setLeftWidth(float f2) {
        this.leftWidth = f2;
    }

    public void setMiddleHeight(float f2) {
        this.middleHeight = f2;
    }

    public void setMiddleWidth(float f2) {
        this.middleWidth = f2;
    }

    public void setPadBottom(float f2) {
        this.padBottom = f2;
    }

    public void setPadLeft(float f2) {
        this.padLeft = f2;
    }

    public void setPadRight(float f2) {
        this.padRight = f2;
    }

    public void setPadTop(float f2) {
        this.padTop = f2;
    }

    public void setPadding(float f2, float f3, float f4, float f5) {
        this.padLeft = f2;
        this.padRight = f3;
        this.padTop = f4;
        this.padBottom = f5;
    }

    public void setRightWidth(float f2) {
        this.rightWidth = f2;
    }

    public void setTopHeight(float f2) {
        this.topHeight = f2;
    }

    public NinePatch(TextureRegion textureRegion, int i, int i2, int i3, int i4) {
        this.vertices = new float[RotationOptions.ROTATE_180];
        this.color = new Color(Color.WHITE);
        this.padLeft = -1.0f;
        this.padRight = -1.0f;
        this.padTop = -1.0f;
        this.padBottom = -1.0f;
        if (textureRegion != null) {
            int regionWidth = (textureRegion.getRegionWidth() - i) - i2;
            int regionHeight = (textureRegion.getRegionHeight() - i3) - i4;
            TextureRegion[] textureRegionArr = new TextureRegion[9];
            if (i3 > 0) {
                if (i > 0) {
                    TextureRegion textureRegion2 = new TextureRegion(textureRegion, 0, 0, i, i3);
                    textureRegionArr[0] = textureRegion2;
                }
                if (regionWidth > 0) {
                    TextureRegion textureRegion3 = new TextureRegion(textureRegion, i, 0, regionWidth, i3);
                    textureRegionArr[1] = textureRegion3;
                }
                if (i2 > 0) {
                    TextureRegion textureRegion4 = new TextureRegion(textureRegion, i + regionWidth, 0, i2, i3);
                    textureRegionArr[2] = textureRegion4;
                }
            }
            if (regionHeight > 0) {
                if (i > 0) {
                    TextureRegion textureRegion5 = new TextureRegion(textureRegion, 0, i3, i, regionHeight);
                    textureRegionArr[3] = textureRegion5;
                }
                if (regionWidth > 0) {
                    TextureRegion textureRegion6 = new TextureRegion(textureRegion, i, i3, regionWidth, regionHeight);
                    textureRegionArr[4] = textureRegion6;
                }
                if (i2 > 0) {
                    TextureRegion textureRegion7 = new TextureRegion(textureRegion, i + regionWidth, i3, i2, regionHeight);
                    textureRegionArr[5] = textureRegion7;
                }
            }
            if (i4 > 0) {
                if (i > 0) {
                    TextureRegion textureRegion8 = new TextureRegion(textureRegion, 0, i3 + regionHeight, i, i4);
                    textureRegionArr[6] = textureRegion8;
                }
                if (regionWidth > 0) {
                    TextureRegion textureRegion9 = new TextureRegion(textureRegion, i, i3 + regionHeight, regionWidth, i4);
                    textureRegionArr[7] = textureRegion9;
                }
                if (i2 > 0) {
                    TextureRegion textureRegion10 = new TextureRegion(textureRegion, i + regionWidth, i3 + regionHeight, i2, i4);
                    textureRegionArr[8] = textureRegion10;
                }
            }
            if (i == 0 && regionWidth == 0) {
                textureRegionArr[1] = textureRegionArr[2];
                textureRegionArr[4] = textureRegionArr[5];
                textureRegionArr[7] = textureRegionArr[8];
                textureRegionArr[2] = null;
                textureRegionArr[5] = null;
                textureRegionArr[8] = null;
            }
            if (i3 == 0 && regionHeight == 0) {
                textureRegionArr[3] = textureRegionArr[6];
                textureRegionArr[4] = textureRegionArr[7];
                textureRegionArr[5] = textureRegionArr[8];
                textureRegionArr[6] = null;
                textureRegionArr[7] = null;
                textureRegionArr[8] = null;
            }
            load(textureRegionArr);
            return;
        }
        throw new IllegalArgumentException("region cannot be null.");
    }

    public void draw(Batch batch, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        float f11 = f8;
        float f12 = f9;
        prepareVertices(batch, f2, f3, f6, f7);
        float f13 = f2 + f4;
        float f14 = f3 + f5;
        int i = this.idx;
        float[] fArr = this.vertices;
        if (f10 != 0.0f) {
            for (int i2 = 0; i2 < i; i2 += 5) {
                float f15 = (fArr[i2] - f13) * f11;
                int i3 = i2 + 1;
                float f16 = (fArr[i3] - f14) * f12;
                float cosDeg = MathUtils.cosDeg(f10);
                float sinDeg = MathUtils.sinDeg(f10);
                fArr[i2] = ((cosDeg * f15) - (sinDeg * f16)) + f13;
                fArr[i3] = GeneratedOutlineSupport.outline4(cosDeg, f16, sinDeg * f15, f14);
            }
        } else if (!(f11 == 1.0f && f12 == 1.0f)) {
            for (int i4 = 0; i4 < i; i4 += 5) {
                fArr[i4] = GeneratedOutlineSupport.outline3(fArr[i4], f13, f11, f13);
                int i5 = i4 + 1;
                fArr[i5] = GeneratedOutlineSupport.outline3(fArr[i5], f14, f12, f14);
            }
        }
        batch.draw(this.texture, fArr, 0, i);
    }

    public NinePatch(Texture texture2, Color color2) {
        this(texture2);
        setColor(color2);
    }

    public NinePatch(Texture texture2) {
        this(new TextureRegion(texture2));
    }

    public NinePatch(TextureRegion textureRegion, Color color2) {
        this(textureRegion);
        setColor(color2);
    }

    public NinePatch(TextureRegion textureRegion) {
        this.vertices = new float[RotationOptions.ROTATE_180];
        this.color = new Color(Color.WHITE);
        this.padLeft = -1.0f;
        this.padRight = -1.0f;
        this.padTop = -1.0f;
        this.padBottom = -1.0f;
        load(new TextureRegion[]{null, null, null, null, textureRegion, null, null, null, null});
    }

    public NinePatch(TextureRegion... textureRegionArr) {
        this.vertices = new float[RotationOptions.ROTATE_180];
        this.color = new Color(Color.WHITE);
        this.padLeft = -1.0f;
        this.padRight = -1.0f;
        this.padTop = -1.0f;
        this.padBottom = -1.0f;
        if (textureRegionArr == null || textureRegionArr.length != 9) {
            throw new IllegalArgumentException("NinePatch needs nine TextureRegions");
        }
        load(textureRegionArr);
        if ((textureRegionArr[0] != null && ((float) textureRegionArr[0].getRegionWidth()) != this.leftWidth) || ((textureRegionArr[3] != null && ((float) textureRegionArr[3].getRegionWidth()) != this.leftWidth) || (textureRegionArr[6] != null && ((float) textureRegionArr[6].getRegionWidth()) != this.leftWidth))) {
            throw new GdxRuntimeException((String) "Left side patches must have the same width");
        } else if ((textureRegionArr[2] != null && ((float) textureRegionArr[2].getRegionWidth()) != this.rightWidth) || ((textureRegionArr[5] != null && ((float) textureRegionArr[5].getRegionWidth()) != this.rightWidth) || (textureRegionArr[8] != null && ((float) textureRegionArr[8].getRegionWidth()) != this.rightWidth))) {
            throw new GdxRuntimeException((String) "Right side patches must have the same width");
        } else if ((textureRegionArr[6] != null && ((float) textureRegionArr[6].getRegionHeight()) != this.bottomHeight) || ((textureRegionArr[7] != null && ((float) textureRegionArr[7].getRegionHeight()) != this.bottomHeight) || (textureRegionArr[8] != null && ((float) textureRegionArr[8].getRegionHeight()) != this.bottomHeight))) {
            throw new GdxRuntimeException((String) "Bottom side patches must have the same height");
        } else if ((textureRegionArr[0] != null && ((float) textureRegionArr[0].getRegionHeight()) != this.topHeight) || ((textureRegionArr[1] != null && ((float) textureRegionArr[1].getRegionHeight()) != this.topHeight) || (textureRegionArr[2] != null && ((float) textureRegionArr[2].getRegionHeight()) != this.topHeight))) {
            throw new GdxRuntimeException((String) "Top side patches must have the same height");
        }
    }

    public NinePatch(NinePatch ninePatch) {
        this(ninePatch, ninePatch.color);
    }

    public NinePatch(NinePatch ninePatch, Color color2) {
        this.vertices = new float[RotationOptions.ROTATE_180];
        this.color = new Color(Color.WHITE);
        this.padLeft = -1.0f;
        this.padRight = -1.0f;
        this.padTop = -1.0f;
        this.padBottom = -1.0f;
        this.texture = ninePatch.texture;
        this.bottomLeft = ninePatch.bottomLeft;
        this.bottomCenter = ninePatch.bottomCenter;
        this.bottomRight = ninePatch.bottomRight;
        this.middleLeft = ninePatch.middleLeft;
        this.middleCenter = ninePatch.middleCenter;
        this.middleRight = ninePatch.middleRight;
        this.topLeft = ninePatch.topLeft;
        this.topCenter = ninePatch.topCenter;
        this.topRight = ninePatch.topRight;
        this.leftWidth = ninePatch.leftWidth;
        this.rightWidth = ninePatch.rightWidth;
        this.middleWidth = ninePatch.middleWidth;
        this.middleHeight = ninePatch.middleHeight;
        this.topHeight = ninePatch.topHeight;
        this.bottomHeight = ninePatch.bottomHeight;
        this.padLeft = ninePatch.padLeft;
        this.padTop = ninePatch.padTop;
        this.padBottom = ninePatch.padBottom;
        this.padRight = ninePatch.padRight;
        float[] fArr = new float[ninePatch.vertices.length];
        this.vertices = fArr;
        float[] fArr2 = ninePatch.vertices;
        System.arraycopy(fArr2, 0, fArr, 0, fArr2.length);
        this.idx = ninePatch.idx;
        this.color.set(color2);
    }
}
