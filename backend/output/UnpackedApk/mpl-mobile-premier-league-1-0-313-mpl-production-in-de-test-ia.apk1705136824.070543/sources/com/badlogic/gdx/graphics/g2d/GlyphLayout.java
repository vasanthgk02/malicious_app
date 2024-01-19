package com.badlogic.gdx.graphics.g2d;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Colors;
import com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData;
import com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pool.Poolable;
import com.badlogic.gdx.utils.Pools;
import sfs2x.client.entities.invitation.InvitationReply;

public class GlyphLayout implements Poolable {
    public static final Pool<Color> colorPool = Pools.get(Color.class);
    public static final Array<Color> colorStack = new Array<>(true, 4);
    public static final float epsilon = 1.0E-4f;
    public static final Pool<GlyphRun> glyphRunPool = Pools.get(GlyphRun.class);
    public float height;
    public final Array<GlyphRun> runs = new Array<>(true, 1);
    public float width;

    public static class GlyphRun implements Poolable {
        public final Color color = new Color();
        public Array<Glyph> glyphs = new Array<>();
        public float width;
        public float x;
        public FloatArray xAdvances = new FloatArray();
        public float y;

        public void reset() {
            this.glyphs.clear();
            this.xAdvances.size = 0;
            this.width = 0.0f;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(this.glyphs.size + 32);
            Array<Glyph> array = this.glyphs;
            int i = array.size;
            for (int i2 = 0; i2 < i; i2++) {
                sb.append((char) ((Glyph) array.get(i2)).id);
            }
            sb.append(", #");
            sb.append(this.color);
            sb.append(", ");
            sb.append(this.x);
            sb.append(", ");
            sb.append(this.y);
            sb.append(", ");
            sb.append(this.width);
            return sb.toString();
        }
    }

    public GlyphLayout() {
    }

    private void adjustLastGlyph(BitmapFontData bitmapFontData, GlyphRun glyphRun) {
        Glyph glyph = (Glyph) glyphRun.glyphs.peek();
        if (!glyph.fixedWidth) {
            float f2 = (((float) (glyph.width + glyph.xoffset)) * bitmapFontData.scaleX) - bitmapFontData.padRight;
            FloatArray floatArray = glyphRun.xAdvances;
            floatArray.items[floatArray.size - 1] = f2;
        }
    }

    private int parseColorMarkup(CharSequence charSequence, int i, int i2, Pool<Color> pool) {
        int i3;
        int i4;
        if (i == i2) {
            return -1;
        }
        char charAt = charSequence.charAt(i);
        if (charAt == '#') {
            int i5 = i + 1;
            int i6 = 0;
            while (true) {
                if (i5 >= i2) {
                    break;
                }
                char charAt2 = charSequence.charAt(i5);
                if (charAt2 != ']') {
                    if (charAt2 >= '0' && charAt2 <= '9') {
                        i3 = i6 * 16;
                        i4 = charAt2 - '0';
                    } else if (charAt2 < 'a' || charAt2 > 'f') {
                        if (charAt2 < 'A' || charAt2 > 'F') {
                            break;
                        }
                        i3 = i6 * 16;
                        i4 = charAt2 - '7';
                    } else {
                        i3 = i6 * 16;
                        i4 = charAt2 - 'W';
                    }
                    i6 = i4 + i3;
                    i5++;
                } else if (i5 >= i + 2 && i5 <= i + 9) {
                    int i7 = i5 - i;
                    if (i7 <= 7) {
                        for (int i8 = 0; i8 < 9 - i7; i8++) {
                            i6 <<= 4;
                        }
                        i6 |= InvitationReply.EXPIRED;
                    }
                    Color color = (Color) pool.obtain();
                    colorStack.add(color);
                    Color.rgba8888ToColor(color, i6);
                    return i7;
                }
            }
            return -1;
        } else if (charAt == '[') {
            return -2;
        } else {
            if (charAt != ']') {
                int i9 = i + 1;
                while (i9 < i2) {
                    if (charSequence.charAt(i9) != ']') {
                        i9++;
                    } else {
                        Color color2 = Colors.get(charSequence.subSequence(i, i9).toString());
                        if (color2 == null) {
                            return -1;
                        }
                        Color color3 = (Color) pool.obtain();
                        colorStack.add(color3);
                        color3.set(color2);
                        return i9 - i;
                    }
                }
                return -1;
            }
            Array<Color> array = colorStack;
            if (array.size > 1) {
                pool.free(array.pop());
            }
            return 0;
        }
    }

    private void truncate(BitmapFontData bitmapFontData, GlyphRun glyphRun, float f2, String str, int i, Pool<GlyphRun> pool) {
        GlyphRun glyphRun2 = (GlyphRun) pool.obtain();
        bitmapFontData.getGlyphs(glyphRun2, str, 0, str.length(), null);
        float f3 = 0.0f;
        if (glyphRun2.xAdvances.size > 0) {
            adjustLastGlyph(bitmapFontData, glyphRun2);
            FloatArray floatArray = glyphRun2.xAdvances;
            float[] fArr = floatArray.items;
            int i2 = floatArray.size;
            for (int i3 = 1; i3 < i2; i3++) {
                f3 += fArr[i3];
            }
        }
        float f4 = f2 - f3;
        float f5 = glyphRun.x;
        float[] fArr2 = glyphRun.xAdvances.items;
        int i4 = 0;
        while (i4 < glyphRun.xAdvances.size) {
            f5 += fArr2[i4];
            if (f5 > f4) {
                break;
            }
            i4++;
        }
        if (i4 > 1) {
            glyphRun.glyphs.truncate(i4 - 1);
            glyphRun.xAdvances.truncate(i4);
            adjustLastGlyph(bitmapFontData, glyphRun);
            FloatArray floatArray2 = glyphRun2.xAdvances;
            int i5 = floatArray2.size;
            if (i5 > 0) {
                glyphRun.xAdvances.addAll(floatArray2, 1, i5 - 1);
            }
        } else {
            glyphRun.glyphs.clear();
            FloatArray floatArray3 = glyphRun.xAdvances;
            floatArray3.size = 0;
            FloatArray floatArray4 = glyphRun2.xAdvances;
            floatArray3.addAll(floatArray4.items, 0, floatArray4.size);
        }
        glyphRun.glyphs.addAll(glyphRun2.glyphs);
        pool.free(glyphRun2);
    }

    private GlyphRun wrap(BitmapFontData bitmapFontData, GlyphRun glyphRun, int i, int i2) {
        Array<Glyph> array = glyphRun.glyphs;
        int i3 = array.size;
        FloatArray floatArray = glyphRun.xAdvances;
        int i4 = i;
        while (i4 > 0 && bitmapFontData.isWhitespace((char) ((Glyph) array.get(i4 - 1)).id)) {
            i4--;
        }
        while (i < i3 && bitmapFontData.isWhitespace((char) ((Glyph) array.get(i)).id)) {
            i++;
        }
        GlyphRun glyphRun2 = null;
        if (i < i3) {
            GlyphRun glyphRun3 = (GlyphRun) glyphRunPool.obtain();
            glyphRun3.color.set(glyphRun.color);
            Array<Glyph> array2 = glyphRun3.glyphs;
            if (array2 == null) {
                throw null;
            } else if (i4 + 0 <= array.size) {
                array2.addAll(array.items, 0, i4);
                array.removeRange(0, i - 1);
                glyphRun.glyphs = array2;
                glyphRun3.glyphs = array;
                FloatArray floatArray2 = glyphRun3.xAdvances;
                floatArray2.addAll(floatArray, 0, i4 + 1);
                floatArray.removeRange(1, i);
                floatArray.items[0] = (((float) (-((Glyph) array.first()).xoffset)) * bitmapFontData.scaleX) - bitmapFontData.padLeft;
                glyphRun.xAdvances = floatArray2;
                glyphRun3.xAdvances = floatArray;
                glyphRun2 = glyphRun3;
            } else {
                StringBuilder outline75 = GeneratedOutlineSupport.outline75("start + count must be <= size: ", 0, " + ", i4, " <= ");
                outline75.append(array.size);
                throw new IllegalArgumentException(outline75.toString());
            }
        } else {
            array.truncate(i4);
            floatArray.truncate(i4 + 1);
        }
        if (i4 == 0) {
            glyphRunPool.free(glyphRun);
            this.runs.pop();
        } else {
            adjustLastGlyph(bitmapFontData, glyphRun);
        }
        return glyphRun2;
    }

    public void reset() {
        Pools.get(GlyphRun.class).freeAll(this.runs);
        this.runs.clear();
        this.width = 0.0f;
        this.height = 0.0f;
    }

    public void setText(BitmapFont bitmapFont, CharSequence charSequence) {
        setText(bitmapFont, charSequence, 0, charSequence.length(), bitmapFont.getColor(), 0.0f, 8, false, null);
    }

    public String toString() {
        if (this.runs.size == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append(this.width);
        sb.append('x');
        sb.append(this.height);
        sb.append(10);
        int i = this.runs.size;
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(((GlyphRun) this.runs.get(i2)).toString());
            sb.append(10);
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public void setText(BitmapFont bitmapFont, CharSequence charSequence, Color color, float f2, int i, boolean z) {
        setText(bitmapFont, charSequence, 0, charSequence.length(), color, f2, i, z, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:139:0x033a  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setText(com.badlogic.gdx.graphics.g2d.BitmapFont r24, java.lang.CharSequence r25, int r26, int r27, com.badlogic.gdx.graphics.Color r28, float r29, int r30, boolean r31, java.lang.String r32) {
        /*
            r23 = this;
            r7 = r23
            r6 = r25
            r8 = r27
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.GlyphLayout$GlyphRun> r9 = r7.runs
            com.badlogic.gdx.utils.Pool<com.badlogic.gdx.graphics.g2d.GlyphLayout$GlyphRun> r0 = glyphRunPool
            r0.freeAll(r9)
            r9.clear()
            r0 = r24
            com.badlogic.gdx.graphics.g2d.BitmapFont$BitmapFontData r10 = r0.data
            r11 = 0
            r0 = r26
            if (r0 != r8) goto L_0x0020
            r7.width = r11
            float r0 = r10.capHeight
            r7.height = r0
            return
        L_0x0020:
            if (r32 == 0) goto L_0x0024
            r14 = 1
            goto L_0x0032
        L_0x0024:
            float r1 = r10.spaceXadvance
            r2 = 1077936128(0x40400000, float:3.0)
            float r1 = r1 * r2
            int r1 = (r29 > r1 ? 1 : (r29 == r1 ? 0 : -1))
            if (r1 > 0) goto L_0x0030
            r14 = 0
            goto L_0x0032
        L_0x0030:
            r14 = r31
        L_0x0032:
            boolean r15 = r10.markupEnabled
            if (r15 == 0) goto L_0x0058
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.Color> r1 = colorStack
            int r1 = r1.size
            r2 = 1
        L_0x003b:
            if (r2 >= r1) goto L_0x004b
            com.badlogic.gdx.utils.Pool<com.badlogic.gdx.graphics.Color> r3 = colorPool
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.Color> r4 = colorStack
            java.lang.Object r4 = r4.get(r2)
            r3.free(r4)
            int r2 = r2 + 1
            goto L_0x003b
        L_0x004b:
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.Color> r1 = colorStack
            r1.clear()
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.Color> r1 = colorStack
            r2 = r28
            r1.add(r2)
            goto L_0x005a
        L_0x0058:
            r2 = r28
        L_0x005a:
            float r5 = r10.down
            r16 = 0
            r4 = r0
            r1 = r2
            r3 = r16
            r17 = 0
        L_0x0064:
            if (r0 != r8) goto L_0x0070
            if (r4 != r8) goto L_0x006a
            goto L_0x017f
        L_0x006a:
            r12 = r0
            r20 = r1
            r13 = r8
            r0 = -1
            goto L_0x00a8
        L_0x0070:
            int r12 = r0 + 1
            char r0 = r6.charAt(r0)
            r13 = 10
            if (r0 == r13) goto L_0x00ab
            r13 = 91
            if (r0 == r13) goto L_0x007f
            goto L_0x00a4
        L_0x007f:
            if (r15 == 0) goto L_0x00a4
            com.badlogic.gdx.utils.Pool<com.badlogic.gdx.graphics.Color> r0 = colorPool
            int r0 = r7.parseColorMarkup(r6, r12, r8, r0)
            if (r0 < 0) goto L_0x009e
            int r1 = r12 + -1
            int r0 = r0 + 1
            int r0 = r0 + r12
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.Color> r12 = colorStack
            java.lang.Object r12 = r12.peek()
            com.badlogic.gdx.graphics.Color r12 = (com.badlogic.gdx.graphics.Color) r12
            r13 = r1
            r20 = r12
            r21 = 0
            r12 = r0
            r0 = -1
            goto L_0x00b3
        L_0x009e:
            r13 = -2
            if (r0 != r13) goto L_0x00a4
            int r0 = r12 + 1
            goto L_0x0064
        L_0x00a4:
            r20 = r1
            r0 = -1
            r13 = -1
        L_0x00a8:
            r21 = 0
            goto L_0x00b3
        L_0x00ab:
            int r0 = r12 + -1
            r13 = r0
            r20 = r1
            r0 = -1
            r21 = 1
        L_0x00b3:
            if (r13 == r0) goto L_0x033a
            if (r13 == r4) goto L_0x031c
            com.badlogic.gdx.utils.Pool<com.badlogic.gdx.graphics.g2d.GlyphLayout$GlyphRun> r0 = glyphRunPool
            java.lang.Object r0 = r0.obtain()
            r1 = r0
            com.badlogic.gdx.graphics.g2d.GlyphLayout$GlyphRun r1 = (com.badlogic.gdx.graphics.g2d.GlyphLayout.GlyphRun) r1
            com.badlogic.gdx.graphics.Color r0 = r1.color
            r0.set(r2)
            r0 = r10
            r2 = r1
            r6 = r2
            r2 = r25
            r26 = r3
            r3 = r4
            r28 = r12
            r12 = r4
            r4 = r13
            r22 = r5
            r5 = r26
            r0.getGlyphs(r1, r2, r3, r4, r5)
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph> r0 = r6.glyphs
            int r0 = r0.size
            if (r0 != 0) goto L_0x00e7
            com.badlogic.gdx.utils.Pool<com.badlogic.gdx.graphics.g2d.GlyphLayout$GlyphRun> r0 = glyphRunPool
            r0.free(r6)
            r3 = r26
            goto L_0x0307
        L_0x00e7:
            r3 = r26
            if (r3 == 0) goto L_0x0106
            boolean r0 = r3.fixedWidth
            if (r0 == 0) goto L_0x00f7
            int r0 = r3.xadvance
            float r0 = (float) r0
            float r1 = r10.scaleX
            float r0 = r0 * r1
            goto L_0x0104
        L_0x00f7:
            int r0 = r3.width
            int r1 = r3.xoffset
            int r0 = r0 + r1
            float r0 = (float) r0
            float r1 = r10.scaleX
            float r0 = r0 * r1
            float r1 = r10.padRight
            float r0 = r0 - r1
        L_0x0104:
            float r17 = r17 - r0
        L_0x0106:
            r0 = r17
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph> r1 = r6.glyphs
            java.lang.Object r1 = r1.peek()
            r3 = r1
            com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph r3 = (com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph) r3
            r6.x = r0
            r6.y = r11
            if (r21 != 0) goto L_0x0119
            if (r13 != r8) goto L_0x011c
        L_0x0119:
            r7.adjustLastGlyph(r10, r6)
        L_0x011c:
            r9.add(r6)
            com.badlogic.gdx.utils.FloatArray r1 = r6.xAdvances
            int r2 = r1.size
            float[] r1 = r1.items
            if (r14 == 0) goto L_0x030b
            if (r2 != 0) goto L_0x012b
            goto L_0x030b
        L_0x012b:
            r4 = 0
            r5 = r1[r4]
            r4 = 1
            r17 = r1[r4]
            float r5 = r5 + r17
            float r5 = r5 + r0
            r0 = 2
            r17 = r5
            r5 = 2
        L_0x0138:
            if (r5 >= r2) goto L_0x0307
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph> r0 = r6.glyphs
            int r4 = r5 + -1
            java.lang.Object r0 = r0.get(r4)
            com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph r0 = (com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph) r0
            r26 = r2
            int r2 = r0.width
            int r0 = r0.xoffset
            int r2 = r2 + r0
            float r0 = (float) r2
            float r2 = r10.scaleX
            float r0 = r0 * r2
            float r2 = r10.padRight
            float r0 = r0 - r2
            float r0 = r0 + r17
            r2 = 953267991(0x38d1b717, float:1.0E-4)
            float r0 = r0 - r2
            int r0 = (r0 > r29 ? 1 : (r0 == r29 ? 0 : -1))
            if (r0 > 0) goto L_0x016f
            r0 = r1[r5]
            float r17 = r17 + r0
            r2 = r26
            r0 = r3
            r18 = r17
            r3 = 0
            r4 = 0
            r17 = r11
            r11 = r6
            r6 = r5
            r5 = 1
            goto L_0x02fd
        L_0x016f:
            if (r32 == 0) goto L_0x0236
            com.badlogic.gdx.utils.Pool<com.badlogic.gdx.graphics.g2d.GlyphLayout$GlyphRun> r8 = glyphRunPool
            r0 = r23
            r1 = r10
            r2 = r6
            r3 = r29
            r4 = r32
            r6 = r8
            r0.truncate(r1, r2, r3, r4, r5, r6)
        L_0x017f:
            float r0 = r10.capHeight
            float r1 = java.lang.Math.abs(r11)
            float r1 = r1 + r0
            r7.height = r1
            T[] r0 = r9.items
            int r1 = r9.size
            r2 = 0
            r3 = 0
        L_0x018e:
            if (r3 >= r1) goto L_0x01d2
            r4 = r0[r3]
            com.badlogic.gdx.graphics.g2d.GlyphLayout$GlyphRun r4 = (com.badlogic.gdx.graphics.g2d.GlyphLayout.GlyphRun) r4
            com.badlogic.gdx.utils.FloatArray r5 = r4.xAdvances
            float[] r5 = r5.items
            r6 = 0
            r8 = r5[r6]
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph> r6 = r4.glyphs
            T[] r9 = r6.items
            int r6 = r6.size
            r11 = r8
            r8 = 0
            r12 = 0
        L_0x01a4:
            if (r12 >= r6) goto L_0x01c2
            r13 = r9[r12]
            com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph r13 = (com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph) r13
            int r14 = r13.width
            int r13 = r13.xoffset
            int r14 = r14 + r13
            float r13 = (float) r14
            float r14 = r10.scaleX
            float r13 = r13 * r14
            float r14 = r10.padRight
            float r13 = r13 - r14
            float r13 = r13 + r11
            float r8 = java.lang.Math.max(r8, r13)
            int r12 = r12 + 1
            r13 = r5[r12]
            float r11 = r11 + r13
            goto L_0x01a4
        L_0x01c2:
            float r5 = java.lang.Math.max(r11, r8)
            r4.width = r5
            float r4 = r4.x
            float r4 = r4 + r5
            float r2 = java.lang.Math.max(r2, r4)
            int r3 = r3 + 1
            goto L_0x018e
        L_0x01d2:
            r7.width = r2
            r2 = r30 & 8
            if (r2 != 0) goto L_0x0235
            r2 = 1
            r3 = r30 & 1
            if (r3 == 0) goto L_0x01df
            r13 = 1
            goto L_0x01e0
        L_0x01df:
            r13 = 0
        L_0x01e0:
            r2 = -822083584(0xffffffffcf000000, float:-2.1474836E9)
            r11 = 0
            r12 = 0
            r19 = 0
        L_0x01e6:
            r3 = 1073741824(0x40000000, float:2.0)
            if (r12 >= r1) goto L_0x0220
            r4 = r0[r12]
            com.badlogic.gdx.graphics.g2d.GlyphLayout$GlyphRun r4 = (com.badlogic.gdx.graphics.g2d.GlyphLayout.GlyphRun) r4
            float r5 = r4.y
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x0213
            float r2 = r29 - r11
            if (r13 == 0) goto L_0x01f9
            float r2 = r2 / r3
        L_0x01f9:
            r3 = r19
            if (r3 >= r12) goto L_0x0209
            int r19 = r3 + 1
            r3 = r0[r3]
            com.badlogic.gdx.graphics.g2d.GlyphLayout$GlyphRun r3 = (com.badlogic.gdx.graphics.g2d.GlyphLayout.GlyphRun) r3
            float r6 = r3.x
            float r6 = r6 + r2
            r3.x = r6
            goto L_0x01f9
        L_0x0209:
            float r2 = r4.x
            float r4 = r4.width
            float r2 = r2 + r4
            r11 = r2
            r19 = r3
            r2 = r5
            goto L_0x021d
        L_0x0213:
            float r3 = r4.x
            float r4 = r4.width
            float r3 = r3 + r4
            float r3 = java.lang.Math.max(r11, r3)
            r11 = r3
        L_0x021d:
            int r12 = r12 + 1
            goto L_0x01e6
        L_0x0220:
            float r2 = r29 - r11
            if (r13 == 0) goto L_0x0225
            float r2 = r2 / r3
        L_0x0225:
            r3 = r19
            if (r3 >= r1) goto L_0x0235
            int r19 = r3 + 1
            r3 = r0[r3]
            com.badlogic.gdx.graphics.g2d.GlyphLayout$GlyphRun r3 = (com.badlogic.gdx.graphics.g2d.GlyphLayout.GlyphRun) r3
            float r4 = r3.x
            float r4 = r4 + r2
            r3.x = r4
            goto L_0x0225
        L_0x0235:
            return
        L_0x0236:
            float r11 = r11 + r22
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph> r0 = r6.glyphs
            int r0 = r10.getWrapIndex(r0, r5)
            if (r0 != 0) goto L_0x0247
            float r2 = r6.x
            r3 = 0
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x024f
        L_0x0247:
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph> r2 = r6.glyphs
            int r2 = r2.size
            if (r0 < r2) goto L_0x024e
            goto L_0x024f
        L_0x024e:
            r4 = r0
        L_0x024f:
            if (r4 != 0) goto L_0x02cd
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph> r0 = r6.glyphs
            int r0 = r0.size
        L_0x0255:
            if (r4 >= r0) goto L_0x026c
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph> r2 = r6.glyphs
            java.lang.Object r2 = r2.get(r4)
            com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph r2 = (com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph) r2
            int r2 = r2.id
            char r2 = (char) r2
            boolean r2 = r10.isWhitespace(r2)
            if (r2 != 0) goto L_0x0269
            goto L_0x026c
        L_0x0269:
            int r4 = r4 + 1
            goto L_0x0255
        L_0x026c:
            if (r4 <= 0) goto L_0x027c
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph> r0 = r6.glyphs
            int r2 = r4 + -1
            r3 = 0
            r0.removeRange(r3, r2)
            com.badlogic.gdx.utils.FloatArray r0 = r6.xAdvances
            r2 = 1
            r0.removeRange(r2, r4)
        L_0x027c:
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph> r0 = r6.glyphs
            java.lang.Object r0 = r0.first()
            com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph r0 = (com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph) r0
            int r0 = r0.xoffset
            int r0 = -r0
            float r0 = (float) r0
            float r2 = r10.scaleX
            float r0 = r0 * r2
            float r2 = r10.padLeft
            float r0 = r0 - r2
            r2 = 0
            r1[r2] = r0
            int r0 = r9.size
            r1 = 1
            if (r0 <= r1) goto L_0x02df
            int r0 = r0 + -2
            java.lang.Object r0 = r9.get(r0)
            com.badlogic.gdx.graphics.g2d.GlyphLayout$GlyphRun r0 = (com.badlogic.gdx.graphics.g2d.GlyphLayout.GlyphRun) r0
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph> r2 = r0.glyphs
            int r2 = r2.size
            int r2 = r2 - r1
        L_0x02a4:
            if (r2 <= 0) goto L_0x02bb
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph> r1 = r0.glyphs
            java.lang.Object r1 = r1.get(r2)
            com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph r1 = (com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph) r1
            int r1 = r1.id
            char r1 = (char) r1
            boolean r1 = r10.isWhitespace(r1)
            if (r1 != 0) goto L_0x02b8
            goto L_0x02bb
        L_0x02b8:
            int r2 = r2 + -1
            goto L_0x02a4
        L_0x02bb:
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph> r1 = r0.glyphs
            int r3 = r2 + 1
            r1.truncate(r3)
            com.badlogic.gdx.utils.FloatArray r1 = r0.xAdvances
            int r2 = r2 + 2
            r1.truncate(r2)
            r7.adjustLastGlyph(r10, r0)
            goto L_0x02df
        L_0x02cd:
            com.badlogic.gdx.graphics.g2d.GlyphLayout$GlyphRun r0 = r7.wrap(r10, r6, r4, r5)
            if (r0 != 0) goto L_0x02db
            r3 = r16
            r4 = 0
            r5 = 1
            r6 = 0
            r17 = 0
            goto L_0x0324
        L_0x02db:
            r9.add(r0)
            r6 = r0
        L_0x02df:
            com.badlogic.gdx.utils.FloatArray r0 = r6.xAdvances
            int r1 = r0.size
            float[] r0 = r0.items
            r4 = 0
            r2 = r0[r4]
            r5 = 1
            if (r1 <= r5) goto L_0x02ee
            r3 = r0[r5]
            float r2 = r2 + r3
        L_0x02ee:
            r3 = 0
            r6.x = r3
            r6.y = r11
            r18 = r2
            r17 = r11
            r2 = r1
            r11 = r6
            r6 = 1
            r1 = r0
            r0 = r16
        L_0x02fd:
            int r6 = r6 + r5
            r3 = r0
            r5 = r6
            r6 = r11
            r11 = r17
            r17 = r18
            goto L_0x0138
        L_0x0307:
            r4 = 0
            r5 = 1
            r6 = 0
            goto L_0x0324
        L_0x030b:
            r4 = 0
            r5 = 1
            r6 = 0
            r17 = r0
            if (r15 == 0) goto L_0x0324
            r0 = 0
        L_0x0313:
            if (r0 >= r2) goto L_0x0324
            r18 = r1[r0]
            float r17 = r17 + r18
            int r0 = r0 + 1
            goto L_0x0313
        L_0x031c:
            r22 = r5
            r28 = r12
            r5 = 1
            r6 = 0
            r12 = r4
            r4 = 0
        L_0x0324:
            if (r21 == 0) goto L_0x0335
            if (r13 != r12) goto L_0x032f
            float r0 = r10.blankLineScale
            float r0 = r0 * r22
            float r0 = r0 + r11
            r11 = r0
            goto L_0x0331
        L_0x032f:
            float r11 = r11 + r22
        L_0x0331:
            r3 = r16
            r17 = 0
        L_0x0335:
            r12 = r28
            r2 = r20
            goto L_0x0342
        L_0x033a:
            r22 = r5
            r28 = r12
            r5 = 1
            r6 = 0
            r12 = r4
            r4 = 0
        L_0x0342:
            r6 = r25
            r0 = r28
            r4 = r12
            r1 = r20
            r5 = r22
            goto L_0x0064
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.g2d.GlyphLayout.setText(com.badlogic.gdx.graphics.g2d.BitmapFont, java.lang.CharSequence, int, int, com.badlogic.gdx.graphics.Color, float, int, boolean, java.lang.String):void");
    }

    public GlyphLayout(BitmapFont bitmapFont, CharSequence charSequence) {
        setText(bitmapFont, charSequence);
    }

    public GlyphLayout(BitmapFont bitmapFont, CharSequence charSequence, Color color, float f2, int i, boolean z) {
        setText(bitmapFont, charSequence, color, f2, i, z);
    }

    public GlyphLayout(BitmapFont bitmapFont, CharSequence charSequence, int i, int i2, Color color, float f2, int i3, boolean z, String str) {
        setText(bitmapFont, charSequence, i, i2, color, f2, i3, z, str);
    }
}
