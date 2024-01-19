package com.badlogic.gdx.scenes.scene2d.ui;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.StringBuilder;

public class Label extends Widget {
    public static final GlyphLayout prefSizeLayout = new GlyphLayout();
    public static final Color tempColor = new Color();
    public BitmapFontCache cache;
    public boolean fontScaleChanged;
    public float fontScaleX;
    public float fontScaleY;
    public int intValue;
    public int labelAlign;
    public float lastPrefHeight;
    public final GlyphLayout layout = new GlyphLayout();
    public int lineAlign;
    public final Vector2 prefSize = new Vector2();
    public boolean prefSizeInvalid;
    public LabelStyle style;
    public final StringBuilder text;
    public boolean wrap;

    public static class LabelStyle {
        public Drawable background;
        public BitmapFont font;
        public Color fontColor;

        public LabelStyle() {
        }

        public LabelStyle(BitmapFont bitmapFont, Color color) {
            this.font = bitmapFont;
            this.fontColor = color;
        }
    }

    public Label(CharSequence charSequence, LabelStyle labelStyle) {
        StringBuilder stringBuilder = new StringBuilder();
        this.text = stringBuilder;
        this.intValue = LinearLayoutManager.INVALID_OFFSET;
        this.labelAlign = 8;
        this.lineAlign = 8;
        this.prefSizeInvalid = true;
        this.fontScaleX = 1.0f;
        this.fontScaleY = 1.0f;
        this.fontScaleChanged = false;
        if (charSequence != null) {
            stringBuilder.append(charSequence);
        }
        setStyle(labelStyle);
        if (charSequence != null && charSequence.length() > 0) {
            setSize(getPrefWidth(), getPrefHeight());
        }
    }

    public void draw(Batch batch, float f2) {
        validate();
        Color color = tempColor.set(this.color);
        float f3 = color.f3306a * f2;
        color.f3306a = f3;
        if (this.style.background != null) {
            batch.setColor(color.r, color.g, color.f3307b, f3);
            this.style.background.draw(batch, this.x, this.y, this.width, this.height);
        }
        Color color2 = this.style.fontColor;
        if (color2 != null) {
            color.mul(color2);
        }
        this.cache.tint(color);
        this.cache.setPosition(this.x, this.y);
        this.cache.draw(batch);
    }

    public float getPrefHeight() {
        if (this.prefSizeInvalid) {
            scaleAndComputePrefSize();
        }
        float f2 = 1.0f;
        if (this.fontScaleChanged) {
            f2 = this.fontScaleY / this.style.font.getScaleY();
        }
        float descent = this.prefSize.y - ((this.style.font.getDescent() * f2) * 2.0f);
        Drawable drawable = this.style.background;
        if (drawable == null) {
            return descent;
        }
        return Math.max(drawable.getBottomHeight() + drawable.getTopHeight() + descent, drawable.getMinHeight());
    }

    public float getPrefWidth() {
        if (this.wrap) {
            return 0.0f;
        }
        if (this.prefSizeInvalid) {
            scaleAndComputePrefSize();
        }
        float f2 = this.prefSize.x;
        Drawable drawable = this.style.background;
        if (drawable != null) {
            f2 = Math.max(drawable.getRightWidth() + drawable.getLeftWidth() + f2, drawable.getMinWidth());
        }
        return f2;
    }

    public void invalidate() {
        this.needsLayout = true;
        this.prefSizeInvalid = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0095, code lost:
        if (r3 == false) goto L_0x0097;
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void layout() {
        /*
            r23 = this;
            r0 = r23
            com.badlogic.gdx.graphics.g2d.BitmapFontCache r1 = r0.cache
            com.badlogic.gdx.graphics.g2d.BitmapFont r1 = r1.getFont()
            float r12 = r1.getScaleX()
            float r13 = r1.getScaleY()
            boolean r2 = r0.fontScaleChanged
            if (r2 == 0) goto L_0x001f
            com.badlogic.gdx.graphics.g2d.BitmapFont$BitmapFontData r2 = r1.getData()
            float r3 = r0.fontScaleX
            float r4 = r0.fontScaleY
            r2.setScale(r3, r4)
        L_0x001f:
            boolean r2 = r0.wrap
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0027
            r14 = 1
            goto L_0x0028
        L_0x0027:
            r14 = 0
        L_0x0028:
            if (r14 == 0) goto L_0x0039
            float r2 = r23.getPrefHeight()
            float r5 = r0.lastPrefHeight
            int r5 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r5 == 0) goto L_0x0039
            r0.lastPrefHeight = r2
            r23.invalidateHierarchy()
        L_0x0039:
            float r2 = r0.width
            float r5 = r0.height
            com.badlogic.gdx.scenes.scene2d.ui.Label$LabelStyle r6 = r0.style
            com.badlogic.gdx.scenes.scene2d.utils.Drawable r6 = r6.background
            if (r6 == 0) goto L_0x0068
            float r7 = r6.getLeftWidth()
            float r8 = r6.getBottomHeight()
            float r9 = r6.getLeftWidth()
            float r10 = r6.getRightWidth()
            float r10 = r10 + r9
            float r2 = r2 - r10
            float r9 = r6.getBottomHeight()
            float r6 = r6.getTopHeight()
            float r6 = r6 + r9
            float r5 = r5 - r6
            r16 = r2
            r17 = r5
            r18 = r7
            r19 = r8
            goto L_0x0070
        L_0x0068:
            r16 = r2
            r17 = r5
            r18 = 0
            r19 = 0
        L_0x0070:
            com.badlogic.gdx.graphics.g2d.GlyphLayout r11 = r0.layout
            r20 = 1073741824(0x40000000, float:2.0)
            if (r14 != 0) goto L_0x00a7
            com.badlogic.gdx.utils.StringBuilder r2 = r0.text
            if (r2 == 0) goto L_0x00a5
            int r5 = r2.length
            int r5 = r5 - r3
            r6 = -1
            if (r5 >= 0) goto L_0x0081
            goto L_0x0097
        L_0x0081:
            java.lang.String r7 = "\n"
            char r7 = r7.charAt(r4)
            r8 = 0
        L_0x0088:
            if (r8 > r5) goto L_0x0094
            char[] r9 = r2.chars
            char r9 = r9[r8]
            if (r9 != r7) goto L_0x0091
            goto L_0x0095
        L_0x0091:
            int r8 = r8 + 1
            goto L_0x0088
        L_0x0094:
            r3 = 0
        L_0x0095:
            if (r3 != 0) goto L_0x0098
        L_0x0097:
            r8 = -1
        L_0x0098:
            if (r8 == r6) goto L_0x009b
            goto L_0x00a7
        L_0x009b:
            com.badlogic.gdx.graphics.g2d.BitmapFont$BitmapFontData r2 = r1.getData()
            float r2 = r2.capHeight
            r15 = r11
            r8 = r16
            goto L_0x00d6
        L_0x00a5:
            r1 = 0
            throw r1
        L_0x00a7:
            com.badlogic.gdx.utils.StringBuilder r4 = r0.text
            r5 = 0
            int r6 = r4.length
            com.badlogic.gdx.graphics.Color r7 = com.badlogic.gdx.graphics.Color.WHITE
            int r9 = r0.lineAlign
            r21 = 0
            r2 = r11
            r3 = r1
            r8 = r16
            r10 = r14
            r15 = r11
            r11 = r21
            r2.setText(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            float r2 = r15.width
            float r3 = r15.height
            int r4 = r0.labelAlign
            r5 = r4 & 8
            if (r5 != 0) goto L_0x00d4
            r4 = r4 & 16
            if (r4 == 0) goto L_0x00ce
            float r16 = r16 - r2
            goto L_0x00d2
        L_0x00ce:
            float r16 = r16 - r2
            float r16 = r16 / r20
        L_0x00d2:
            float r18 = r16 + r18
        L_0x00d4:
            r8 = r2
            r2 = r3
        L_0x00d6:
            r11 = r18
            int r3 = r0.labelAlign
            r4 = r3 & 2
            if (r4 == 0) goto L_0x00fb
            com.badlogic.gdx.graphics.g2d.BitmapFontCache r3 = r0.cache
            com.badlogic.gdx.graphics.g2d.BitmapFont r3 = r3.getFont()
            boolean r3 = r3.isFlipped()
            if (r3 == 0) goto L_0x00ec
            r3 = 0
            goto L_0x00ee
        L_0x00ec:
            float r3 = r17 - r2
        L_0x00ee:
            float r19 = r19 + r3
            com.badlogic.gdx.scenes.scene2d.ui.Label$LabelStyle r3 = r0.style
            com.badlogic.gdx.graphics.g2d.BitmapFont r3 = r3.font
            float r3 = r3.getDescent()
            float r3 = r3 + r19
            goto L_0x0122
        L_0x00fb:
            r3 = r3 & 4
            if (r3 == 0) goto L_0x011c
            com.badlogic.gdx.graphics.g2d.BitmapFontCache r3 = r0.cache
            com.badlogic.gdx.graphics.g2d.BitmapFont r3 = r3.getFont()
            boolean r3 = r3.isFlipped()
            if (r3 == 0) goto L_0x010e
            float r3 = r17 - r2
            goto L_0x010f
        L_0x010e:
            r3 = 0
        L_0x010f:
            float r19 = r19 + r3
            com.badlogic.gdx.scenes.scene2d.ui.Label$LabelStyle r3 = r0.style
            com.badlogic.gdx.graphics.g2d.BitmapFont r3 = r3.font
            float r3 = r3.getDescent()
            float r3 = r19 - r3
            goto L_0x0122
        L_0x011c:
            float r17 = r17 - r2
            float r17 = r17 / r20
            float r3 = r17 + r19
        L_0x0122:
            com.badlogic.gdx.graphics.g2d.BitmapFontCache r4 = r0.cache
            com.badlogic.gdx.graphics.g2d.BitmapFont r4 = r4.getFont()
            boolean r4 = r4.isFlipped()
            if (r4 != 0) goto L_0x012f
            float r3 = r3 + r2
        L_0x012f:
            r10 = r3
            com.badlogic.gdx.utils.StringBuilder r4 = r0.text
            r5 = 0
            int r6 = r4.length
            com.badlogic.gdx.graphics.Color r7 = com.badlogic.gdx.graphics.Color.WHITE
            int r9 = r0.lineAlign
            r16 = 0
            r2 = r15
            r3 = r1
            r22 = r10
            r10 = r14
            r14 = r11
            r11 = r16
            r2.setText(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            com.badlogic.gdx.graphics.g2d.BitmapFontCache r2 = r0.cache
            r3 = r22
            r2.setText(r15, r14, r3)
            boolean r2 = r0.fontScaleChanged
            if (r2 == 0) goto L_0x0158
            com.badlogic.gdx.graphics.g2d.BitmapFont$BitmapFontData r1 = r1.getData()
            r1.setScale(r12, r13)
        L_0x0158:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.scenes.scene2d.ui.Label.layout():void");
    }

    public final void scaleAndComputePrefSize() {
        BitmapFont font = this.cache.getFont();
        float scaleX = font.getScaleX();
        float scaleY = font.getScaleY();
        if (this.fontScaleChanged) {
            font.getData().setScale(this.fontScaleX, this.fontScaleY);
        }
        this.prefSizeInvalid = false;
        GlyphLayout glyphLayout = prefSizeLayout;
        if (this.wrap) {
            float f2 = this.width;
            Drawable drawable = this.style.background;
            if (drawable != null) {
                f2 = (Math.max(f2, drawable.getMinWidth()) - this.style.background.getLeftWidth()) - this.style.background.getRightWidth();
            }
            float f3 = f2;
            glyphLayout.setText(this.cache.getFont(), this.text, Color.WHITE, f3, 8, true);
        } else {
            glyphLayout.setText(this.cache.getFont(), this.text);
        }
        Vector2 vector2 = this.prefSize;
        float f4 = glyphLayout.width;
        float f5 = glyphLayout.height;
        vector2.x = f4;
        vector2.y = f5;
        if (this.fontScaleChanged) {
            font.getData().setScale(scaleX, scaleY);
        }
    }

    public void setAlignment(int i) {
        this.labelAlign = i;
        if ((i & 8) != 0) {
            this.lineAlign = 8;
        } else if ((i & 16) != 0) {
            this.lineAlign = 16;
        } else {
            this.lineAlign = 1;
        }
        invalidate();
    }

    public void setFontScale(float f2) {
        this.fontScaleChanged = true;
        this.fontScaleX = f2;
        this.fontScaleY = f2;
        invalidateHierarchy();
    }

    public void setStyle(LabelStyle labelStyle) {
        if (labelStyle != null) {
            BitmapFont bitmapFont = labelStyle.font;
            if (bitmapFont != null) {
                this.style = labelStyle;
                this.cache = bitmapFont.newFontCache();
                invalidateHierarchy();
                return;
            }
            throw new IllegalArgumentException("Missing LabelStyle font.");
        }
        throw new IllegalArgumentException("style cannot be null.");
    }

    public boolean setText(int i) {
        if (this.intValue == i) {
            return false;
        }
        StringBuilder stringBuilder = this.text;
        stringBuilder.length = 0;
        stringBuilder.append(i);
        this.intValue = i;
        invalidateHierarchy();
        return true;
    }

    public String toString() {
        String str = this.name;
        if (str != null) {
            return str;
        }
        String name = Label.class.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf != -1) {
            name = name.substring(lastIndexOf + 1);
        }
        StringBuilder sb = new StringBuilder();
        GeneratedOutlineSupport.outline102(sb, name.indexOf(36) != -1 ? "Label " : "", name, ": ");
        sb.append(this.text);
        return sb.toString();
    }

    public void setText(CharSequence charSequence) {
        boolean z;
        if (charSequence == null) {
            StringBuilder stringBuilder = this.text;
            if (stringBuilder.length != 0) {
                stringBuilder.length = 0;
            } else {
                return;
            }
        } else if (!(charSequence instanceof StringBuilder)) {
            StringBuilder stringBuilder2 = this.text;
            int i = stringBuilder2.length;
            char[] cArr = stringBuilder2.chars;
            if (i == charSequence.length()) {
                int i2 = 0;
                while (true) {
                    if (i2 >= i) {
                        z = true;
                        break;
                    } else if (cArr[i2] != charSequence.charAt(i2)) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            z = false;
            if (!z) {
                StringBuilder stringBuilder3 = this.text;
                stringBuilder3.length = 0;
                stringBuilder3.append(charSequence);
            } else {
                return;
            }
        } else if (!this.text.equals(charSequence)) {
            StringBuilder stringBuilder4 = this.text;
            stringBuilder4.length = 0;
            StringBuilder stringBuilder5 = (StringBuilder) charSequence;
            stringBuilder4.append0(stringBuilder5.chars, 0, stringBuilder5.length);
        } else {
            return;
        }
        this.intValue = LinearLayoutManager.INVALID_OFFSET;
        invalidateHierarchy();
    }
}
