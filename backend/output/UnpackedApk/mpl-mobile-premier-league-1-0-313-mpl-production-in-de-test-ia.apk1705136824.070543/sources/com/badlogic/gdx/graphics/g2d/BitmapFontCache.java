package com.badlogic.gdx.graphics.g2d;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData;
import com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph;
import com.badlogic.gdx.graphics.g2d.GlyphLayout.GlyphRun;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.Pools;

public class BitmapFontCache {
    public static final Color tempColor = new Color(1.0f, 1.0f, 1.0f, 1.0f);
    public final Color color;
    public float currentTint;
    public final BitmapFont font;
    public int glyphCount;
    public int[] idx;
    public boolean integer;
    public final Array<GlyphLayout> layouts;
    public IntArray[] pageGlyphIndices;
    public float[][] pageVertices;
    public final Array<GlyphLayout> pooledLayouts;
    public int[] tempGlyphCount;
    public float x;
    public float y;

    public BitmapFontCache(BitmapFont bitmapFont) {
        this(bitmapFont, bitmapFont.usesIntegerPositions());
    }

    private void addGlyph(Glyph glyph, float f2, float f3, float f4) {
        BitmapFontData bitmapFontData = this.font.data;
        float f5 = bitmapFontData.scaleX;
        float f6 = bitmapFontData.scaleY;
        float f7 = (((float) glyph.xoffset) * f5) + f2;
        float f8 = (((float) glyph.yoffset) * f6) + f3;
        float f9 = ((float) glyph.width) * f5;
        float f10 = ((float) glyph.height) * f6;
        float f11 = glyph.u;
        float f12 = glyph.u2;
        float f13 = glyph.v;
        float f14 = glyph.v2;
        if (this.integer) {
            f7 = (float) Math.round(f7);
            f8 = (float) Math.round(f8);
            f9 = (float) Math.round(f9);
            f10 = (float) Math.round(f10);
        }
        float f15 = f9 + f7;
        float f16 = f10 + f8;
        int i = glyph.page;
        int[] iArr = this.idx;
        int i2 = iArr[i];
        iArr[i] = iArr[i] + 20;
        IntArray[] intArrayArr = this.pageGlyphIndices;
        if (intArrayArr != null) {
            IntArray intArray = intArrayArr[i];
            int i3 = this.glyphCount;
            this.glyphCount = i3 + 1;
            intArray.add(i3);
        }
        float[] fArr = this.pageVertices[i];
        int i4 = i2 + 1;
        fArr[i2] = f7;
        int i5 = i4 + 1;
        fArr[i4] = f8;
        int i6 = i5 + 1;
        fArr[i5] = f4;
        int i7 = i6 + 1;
        fArr[i6] = f11;
        int i8 = i7 + 1;
        fArr[i7] = f13;
        int i9 = i8 + 1;
        fArr[i8] = f7;
        int i10 = i9 + 1;
        fArr[i9] = f16;
        int i11 = i10 + 1;
        fArr[i10] = f4;
        int i12 = i11 + 1;
        fArr[i11] = f11;
        int i13 = i12 + 1;
        fArr[i12] = f14;
        int i14 = i13 + 1;
        fArr[i13] = f15;
        int i15 = i14 + 1;
        fArr[i14] = f16;
        int i16 = i15 + 1;
        fArr[i15] = f4;
        int i17 = i16 + 1;
        fArr[i16] = f12;
        int i18 = i17 + 1;
        fArr[i17] = f14;
        int i19 = i18 + 1;
        fArr[i18] = f15;
        int i20 = i19 + 1;
        fArr[i19] = f8;
        int i21 = i20 + 1;
        fArr[i20] = f4;
        fArr[i21] = f12;
        fArr[i21 + 1] = f13;
    }

    private void addToCache(GlyphLayout glyphLayout, float f2, float f3) {
        int i;
        int i2 = this.font.regions.size;
        float[][] fArr = this.pageVertices;
        if (fArr.length < i2) {
            float[][] fArr2 = new float[i2][];
            System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
            this.pageVertices = fArr2;
            int[] iArr = new int[i2];
            int[] iArr2 = this.idx;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            this.idx = iArr;
            IntArray[] intArrayArr = new IntArray[i2];
            IntArray[] intArrayArr2 = this.pageGlyphIndices;
            if (intArrayArr2 != null) {
                i = intArrayArr2.length;
                System.arraycopy(intArrayArr2, 0, intArrayArr, 0, intArrayArr2.length);
            } else {
                i = 0;
            }
            while (i < i2) {
                intArrayArr[i] = new IntArray();
                i++;
            }
            this.pageGlyphIndices = intArrayArr;
            this.tempGlyphCount = new int[i2];
        }
        this.layouts.add(glyphLayout);
        requireGlyphs(glyphLayout);
        int i3 = glyphLayout.runs.size;
        for (int i4 = 0; i4 < i3; i4++) {
            GlyphRun glyphRun = (GlyphRun) glyphLayout.runs.get(i4);
            Array<Glyph> array = glyphRun.glyphs;
            FloatArray floatArray = glyphRun.xAdvances;
            float floatBits = glyphRun.color.toFloatBits();
            float f4 = glyphRun.x + f2;
            float f5 = glyphRun.y + f3;
            int i5 = array.size;
            for (int i6 = 0; i6 < i5; i6++) {
                f4 += floatArray.get(i6);
                addGlyph((Glyph) array.get(i6), f4, f5, floatBits);
            }
        }
        this.currentTint = Color.WHITE_FLOAT_BITS;
    }

    private void requireGlyphs(GlyphLayout glyphLayout) {
        if (this.pageVertices.length == 1) {
            int i = glyphLayout.runs.size;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                i2 += ((GlyphRun) glyphLayout.runs.get(i3)).glyphs.size;
            }
            requirePageGlyphs(0, i2);
            return;
        }
        int[] iArr = this.tempGlyphCount;
        int length = iArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            iArr[i4] = 0;
        }
        int i5 = glyphLayout.runs.size;
        for (int i6 = 0; i6 < i5; i6++) {
            Array<Glyph> array = ((GlyphRun) glyphLayout.runs.get(i6)).glyphs;
            int i7 = array.size;
            for (int i8 = 0; i8 < i7; i8++) {
                int i9 = ((Glyph) array.get(i8)).page;
                iArr[i9] = iArr[i9] + 1;
            }
        }
        int length2 = iArr.length;
        for (int i10 = 0; i10 < length2; i10++) {
            requirePageGlyphs(i10, iArr[i10]);
        }
    }

    private void requirePageGlyphs(int i, int i2) {
        IntArray[] intArrayArr = this.pageGlyphIndices;
        if (intArrayArr != null && i2 > intArrayArr[i].items.length) {
            intArrayArr[i].ensureCapacity(i2 - intArrayArr[i].size);
        }
        int[] iArr = this.idx;
        int i3 = (i2 * 20) + iArr[i];
        float[][] fArr = this.pageVertices;
        float[] fArr2 = fArr[i];
        if (fArr2 == null) {
            fArr[i] = new float[i3];
        } else if (fArr2.length < i3) {
            float[] fArr3 = new float[i3];
            System.arraycopy(fArr2, 0, fArr3, 0, iArr[i]);
            this.pageVertices[i] = fArr3;
        }
    }

    public GlyphLayout addText(CharSequence charSequence, float f2, float f3) {
        return addText(charSequence, f2, f3, 0, charSequence.length(), 0.0f, 8, false, null);
    }

    public void clear() {
        this.x = 0.0f;
        this.y = 0.0f;
        Pools.freeAll(this.pooledLayouts, true);
        this.pooledLayouts.clear();
        this.layouts.clear();
        int length = this.idx.length;
        for (int i = 0; i < length; i++) {
            IntArray[] intArrayArr = this.pageGlyphIndices;
            if (intArrayArr != null) {
                intArrayArr[i].size = 0;
            }
            this.idx[i] = 0;
        }
    }

    public void draw(Batch batch) {
        Array<TextureRegion> regions = this.font.getRegions();
        int length = this.pageVertices.length;
        for (int i = 0; i < length; i++) {
            if (this.idx[i] > 0) {
                batch.draw(((TextureRegion) regions.get(i)).getTexture(), this.pageVertices[i], 0, this.idx[i]);
            }
        }
    }

    public Color getColor() {
        return this.color;
    }

    public BitmapFont getFont() {
        return this.font;
    }

    public Array<GlyphLayout> getLayouts() {
        return this.layouts;
    }

    public int getVertexCount(int i) {
        return this.idx[i];
    }

    public float[] getVertices() {
        return getVertices(0);
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public void setAlphas(float f2) {
        int i = ((int) (f2 * 254.0f)) << 24;
        int length = this.pageVertices.length;
        float f3 = 0.0f;
        float f4 = 0.0f;
        for (int i2 = 0; i2 < length; i2++) {
            float[] fArr = this.pageVertices[i2];
            int i3 = this.idx[i2];
            for (int i4 = 2; i4 < i3; i4 += 5) {
                float f5 = fArr[i4];
                if (f5 != f3 || i4 == 2) {
                    f4 = k.intToFloatColor((k.floatToIntColor(f5) & 16777215) | i);
                    fArr[i4] = f4;
                    f3 = f5;
                } else {
                    fArr[i4] = f4;
                }
            }
        }
    }

    public void setColor(Color color2) {
        this.color.set(color2);
    }

    public void setColors(float f2) {
        int length = this.pageVertices.length;
        for (int i = 0; i < length; i++) {
            float[] fArr = this.pageVertices[i];
            int i2 = this.idx[i];
            for (int i3 = 2; i3 < i2; i3 += 5) {
                fArr[i3] = f2;
            }
        }
    }

    public void setPosition(float f2, float f3) {
        translate(f2 - this.x, f3 - this.y);
    }

    public GlyphLayout setText(CharSequence charSequence, float f2, float f3) {
        clear();
        return addText(charSequence, f2, f3, 0, charSequence.length(), 0.0f, 8, false);
    }

    public void setUseIntegerPositions(boolean z) {
        this.integer = z;
    }

    public void tint(Color color2) {
        float floatBits = color2.toFloatBits();
        if (this.currentTint != floatBits) {
            this.currentTint = floatBits;
            int[] iArr = this.tempGlyphCount;
            int length = iArr.length;
            for (int i = 0; i < length; i++) {
                iArr[i] = 0;
            }
            int i2 = this.layouts.size;
            for (int i3 = 0; i3 < i2; i3++) {
                GlyphLayout glyphLayout = (GlyphLayout) this.layouts.get(i3);
                int i4 = glyphLayout.runs.size;
                for (int i5 = 0; i5 < i4; i5++) {
                    GlyphRun glyphRun = (GlyphRun) glyphLayout.runs.get(i5);
                    Array<Glyph> array = glyphRun.glyphs;
                    float floatBits2 = tempColor.set(glyphRun.color).mul(color2).toFloatBits();
                    int i6 = array.size;
                    for (int i7 = 0; i7 < i6; i7++) {
                        int i8 = ((Glyph) array.get(i7)).page;
                        int i9 = (iArr[i8] * 20) + 2;
                        iArr[i8] = iArr[i8] + 1;
                        float[] fArr = this.pageVertices[i8];
                        for (int i10 = 0; i10 < 20; i10 += 5) {
                            fArr[i9 + i10] = floatBits2;
                        }
                    }
                }
                Color color3 = color2;
            }
        }
    }

    public void translate(float f2, float f3) {
        if (f2 != 0.0f || f3 != 0.0f) {
            if (this.integer) {
                f2 = (float) Math.round(f2);
                f3 = (float) Math.round(f3);
            }
            this.x += f2;
            this.y += f3;
            float[][] fArr = this.pageVertices;
            int length = fArr.length;
            for (int i = 0; i < length; i++) {
                float[] fArr2 = fArr[i];
                int i2 = this.idx[i];
                for (int i3 = 0; i3 < i2; i3 += 5) {
                    fArr2[i3] = fArr2[i3] + f2;
                    int i4 = i3 + 1;
                    fArr2[i4] = fArr2[i4] + f3;
                }
            }
        }
    }

    public boolean usesIntegerPositions() {
        return this.integer;
    }

    public BitmapFontCache(BitmapFont bitmapFont, boolean z) {
        this.layouts = new Array<>();
        this.pooledLayouts = new Array<>();
        this.color = new Color(1.0f, 1.0f, 1.0f, 1.0f);
        this.font = bitmapFont;
        this.integer = z;
        int i = bitmapFont.regions.size;
        if (i != 0) {
            this.pageVertices = new float[i][];
            this.idx = new int[i];
            if (i > 1) {
                IntArray[] intArrayArr = new IntArray[i];
                this.pageGlyphIndices = intArrayArr;
                int length = intArrayArr.length;
                for (int i2 = 0; i2 < length; i2++) {
                    this.pageGlyphIndices[i2] = new IntArray();
                }
            }
            this.tempGlyphCount = new int[i];
            return;
        }
        throw new IllegalArgumentException("The specified font must contain at least one texture page.");
    }

    public GlyphLayout addText(CharSequence charSequence, float f2, float f3, float f4, int i, boolean z) {
        return addText(charSequence, f2, f3, 0, charSequence.length(), f4, i, z, null);
    }

    public float[] getVertices(int i) {
        return this.pageVertices[i];
    }

    public void setColor(float f2, float f3, float f4, float f5) {
        this.color.set(f2, f3, f4, f5);
    }

    public GlyphLayout addText(CharSequence charSequence, float f2, float f3, int i, int i2, float f4, int i3, boolean z) {
        return addText(charSequence, f2, f3, i, i2, f4, i3, z, null);
    }

    public GlyphLayout setText(CharSequence charSequence, float f2, float f3, float f4, int i, boolean z) {
        clear();
        return addText(charSequence, f2, f3, 0, charSequence.length(), f4, i, z);
    }

    public GlyphLayout addText(CharSequence charSequence, float f2, float f3, int i, int i2, float f4, int i3, boolean z, String str) {
        GlyphLayout glyphLayout = (GlyphLayout) Pools.obtain(GlyphLayout.class);
        this.pooledLayouts.add(glyphLayout);
        glyphLayout.setText(this.font, charSequence, i, i2, this.color, f4, i3, z, str);
        float f5 = f2;
        float f6 = f3;
        addText(glyphLayout, f2, f3);
        return glyphLayout;
    }

    public void setColors(Color color2) {
        setColors(color2.toFloatBits());
    }

    public GlyphLayout setText(CharSequence charSequence, float f2, float f3, int i, int i2, float f4, int i3, boolean z) {
        clear();
        return addText(charSequence, f2, f3, i, i2, f4, i3, z);
    }

    public void draw(Batch batch, int i, int i2) {
        if (this.pageVertices.length == 1) {
            batch.draw(this.font.getRegion().getTexture(), this.pageVertices[0], i * 20, (i2 - i) * 20);
            return;
        }
        Array<TextureRegion> regions = this.font.getRegions();
        int length = this.pageVertices.length;
        for (int i3 = 0; i3 < length; i3++) {
            IntArray intArray = this.pageGlyphIndices[i3];
            int i4 = intArray.size;
            int i5 = -1;
            int i6 = 0;
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = intArray.get(i7);
                if (i8 >= i2) {
                    break;
                }
                if (i5 == -1 && i8 >= i) {
                    i5 = i7;
                }
                if (i8 >= i) {
                    i6++;
                }
            }
            if (!(i5 == -1 || i6 == 0)) {
                batch.draw(((TextureRegion) regions.get(i3)).getTexture(), this.pageVertices[i3], i5 * 20, i6 * 20);
            }
        }
    }

    public void setColors(float f2, float f3, float f4, float f5) {
        int i = ((int) (f3 * 255.0f)) << 8;
        int i2 = (int) (f2 * 255.0f);
        setColors(k.intToFloatColor(i2 | i | (((int) (f4 * 255.0f)) << 16) | (((int) (f5 * 255.0f)) << 24)));
    }

    public void setColors(Color color2, int i, int i2) {
        setColors(color2.toFloatBits(), i, i2);
    }

    public GlyphLayout setText(CharSequence charSequence, float f2, float f3, int i, int i2, float f4, int i3, boolean z, String str) {
        clear();
        return addText(charSequence, f2, f3, i, i2, f4, i3, z, str);
    }

    public void addText(GlyphLayout glyphLayout, float f2, float f3) {
        addToCache(glyphLayout, f2, f3 + this.font.data.ascent);
    }

    public void setColors(float f2, int i, int i2) {
        float[][] fArr = this.pageVertices;
        if (fArr.length == 1) {
            float[] fArr2 = fArr[0];
            int min = Math.min(i2 * 20, this.idx[0]);
            for (int i3 = (i * 20) + 2; i3 < min; i3 += 5) {
                fArr2[i3] = f2;
            }
            return;
        }
        int length = fArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            float[] fArr3 = this.pageVertices[i4];
            IntArray intArray = this.pageGlyphIndices[i4];
            int i5 = intArray.size;
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = intArray.items[i6];
                if (i7 >= i2) {
                    break;
                }
                if (i7 >= i) {
                    for (int i8 = 0; i8 < 20; i8 += 5) {
                        fArr3[GeneratedOutlineSupport.outline7(i6, 20, 2, i8)] = f2;
                    }
                }
            }
        }
    }

    public void setText(GlyphLayout glyphLayout, float f2, float f3) {
        clear();
        addText(glyphLayout, f2, f3);
    }

    public void draw(Batch batch, float f2) {
        if (f2 == 1.0f) {
            draw(batch);
            return;
        }
        Color color2 = getColor();
        float f3 = color2.f3306a;
        color2.f3306a = f2 * f3;
        setColors(color2);
        draw(batch);
        color2.f3306a = f3;
        setColors(color2);
    }
}
