package com.google.android.material.internal;

import a.a.a.a.d.b;
import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.Gravity;
import android.view.View;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl;
import androidx.core.view.ViewCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException;
import com.google.android.material.resources.CancelableFontCallback;
import com.google.android.material.resources.CancelableFontCallback.ApplyFont;
import com.google.android.material.resources.TextAppearance;

public final class CollapsingTextHelper {
    public static final Paint DEBUG_DRAW_PAINT = null;
    public boolean boundsChanged;
    public final Rect collapsedBounds;
    public float collapsedDrawX;
    public float collapsedDrawY;
    public CancelableFontCallback collapsedFontCallback;
    public float collapsedLetterSpacing;
    public ColorStateList collapsedShadowColor;
    public float collapsedShadowDx;
    public float collapsedShadowDy;
    public float collapsedShadowRadius;
    public float collapsedTextBlend;
    public ColorStateList collapsedTextColor;
    public int collapsedTextGravity = 16;
    public float collapsedTextSize = 15.0f;
    public Typeface collapsedTypeface;
    public final RectF currentBounds;
    public float currentDrawX;
    public float currentDrawY;
    public int currentOffsetY;
    public float currentTextSize;
    public Typeface currentTypeface;
    public boolean drawTitle;
    public final Rect expandedBounds;
    public float expandedDrawX;
    public float expandedDrawY;
    public float expandedFirstLineDrawX;
    public CancelableFontCallback expandedFontCallback;
    public float expandedFraction;
    public float expandedLetterSpacing;
    public ColorStateList expandedShadowColor;
    public float expandedShadowDx;
    public float expandedShadowDy;
    public float expandedShadowRadius;
    public float expandedTextBlend;
    public ColorStateList expandedTextColor;
    public int expandedTextGravity = 16;
    public float expandedTextSize = 15.0f;
    public Bitmap expandedTitleTexture;
    public Typeface expandedTypeface;
    public boolean fadeModeEnabled;
    public float fadeModeStartFraction;
    public float fadeModeThresholdFraction;
    public int hyphenationFrequency = StaticLayoutBuilderCompat.DEFAULT_HYPHENATION_FREQUENCY;
    public boolean isRtl;
    public boolean isRtlTextDirectionHeuristicsEnabled = true;
    public float lineSpacingAdd = 0.0f;
    public float lineSpacingMultiplier = 1.0f;
    public int maxLines = 1;
    public TimeInterpolator positionInterpolator;
    public float scale;
    public int[] state;
    public CharSequence text;
    public StaticLayout textLayout;
    public final TextPaint textPaint;
    public TimeInterpolator textSizeInterpolator;
    public CharSequence textToDraw;
    public CharSequence textToDrawCollapsed;
    public Paint texturePaint;
    public final TextPaint tmpPaint;
    public boolean useTexture;
    public final View view;

    static {
        Paint paint = null;
        if (paint != null) {
            paint.setAntiAlias(true);
            DEBUG_DRAW_PAINT.setColor(-65281);
        }
    }

    public CollapsingTextHelper(View view2) {
        this.view = view2;
        this.textPaint = new TextPaint(129);
        this.tmpPaint = new TextPaint(this.textPaint);
        this.collapsedBounds = new Rect();
        this.expandedBounds = new Rect();
        this.currentBounds = new RectF();
        float f2 = this.fadeModeStartFraction;
        this.fadeModeThresholdFraction = GeneratedOutlineSupport.outline3(1.0f, f2, 0.5f, f2);
    }

    public static int blendColors(int i, int i2, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((((float) Color.alpha(i2)) * f2) + (((float) Color.alpha(i)) * f3)), (int) ((((float) Color.red(i2)) * f2) + (((float) Color.red(i)) * f3)), (int) ((((float) Color.green(i2)) * f2) + (((float) Color.green(i)) * f3)), (int) ((((float) Color.blue(i2)) * f2) + (((float) Color.blue(i)) * f3)));
    }

    public static float lerp(float f2, float f3, float f4, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f4 = timeInterpolator.getInterpolation(f4);
        }
        return AnimationUtils.lerp(f2, f3, f4);
    }

    public static boolean rectEquals(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }

    public float calculateCollapsedTextWidth() {
        if (this.text == null) {
            return 0.0f;
        }
        TextPaint textPaint2 = this.tmpPaint;
        textPaint2.setTextSize(this.collapsedTextSize);
        textPaint2.setTypeface(this.collapsedTypeface);
        textPaint2.setLetterSpacing(this.collapsedLetterSpacing);
        TextPaint textPaint3 = this.tmpPaint;
        CharSequence charSequence = this.text;
        return textPaint3.measureText(charSequence, 0, charSequence.length());
    }

    public final boolean calculateIsRtl(CharSequence charSequence) {
        boolean z = true;
        if (ViewCompat.getLayoutDirection(this.view) != 1) {
            z = false;
        }
        if (!this.isRtlTextDirectionHeuristicsEnabled) {
            return z;
        }
        return ((TextDirectionHeuristicImpl) (z ? TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL : TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR)).isRtl(charSequence, 0, charSequence.length());
    }

    public final void calculateOffsets(float f2) {
        float f3;
        float f4;
        if (this.fadeModeEnabled) {
            this.currentBounds.set(f2 < this.fadeModeThresholdFraction ? this.expandedBounds : this.collapsedBounds);
        } else {
            this.currentBounds.left = lerp((float) this.expandedBounds.left, (float) this.collapsedBounds.left, f2, this.positionInterpolator);
            this.currentBounds.top = lerp(this.expandedDrawY, this.collapsedDrawY, f2, this.positionInterpolator);
            this.currentBounds.right = lerp((float) this.expandedBounds.right, (float) this.collapsedBounds.right, f2, this.positionInterpolator);
            this.currentBounds.bottom = lerp((float) this.expandedBounds.bottom, (float) this.collapsedBounds.bottom, f2, this.positionInterpolator);
        }
        if (!this.fadeModeEnabled) {
            this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, f2, this.positionInterpolator);
            this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, f2, this.positionInterpolator);
            setInterpolatedTextSize(lerp(this.expandedTextSize, this.collapsedTextSize, f2, this.textSizeInterpolator));
            f3 = f2;
        } else if (f2 < this.fadeModeThresholdFraction) {
            this.currentDrawX = this.expandedDrawX;
            this.currentDrawY = this.expandedDrawY;
            setInterpolatedTextSize(this.expandedTextSize);
            f3 = 0.0f;
        } else {
            this.currentDrawX = this.collapsedDrawX;
            this.currentDrawY = this.collapsedDrawY - ((float) Math.max(0, this.currentOffsetY));
            setInterpolatedTextSize(this.collapsedTextSize);
            f3 = 1.0f;
        }
        this.collapsedTextBlend = 1.0f - lerp(0.0f, 1.0f, 1.0f - f2, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        ViewCompat.postInvalidateOnAnimation(this.view);
        this.expandedTextBlend = lerp(1.0f, 0.0f, f2, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        ViewCompat.postInvalidateOnAnimation(this.view);
        ColorStateList colorStateList = this.collapsedTextColor;
        ColorStateList colorStateList2 = this.expandedTextColor;
        if (colorStateList != colorStateList2) {
            this.textPaint.setColor(blendColors(getCurrentColor(colorStateList2), getCurrentCollapsedTextColor(), f3));
        } else {
            this.textPaint.setColor(getCurrentCollapsedTextColor());
        }
        float f5 = this.collapsedLetterSpacing;
        float f6 = this.expandedLetterSpacing;
        if (f5 != f6) {
            this.textPaint.setLetterSpacing(lerp(f6, f5, f2, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        } else {
            this.textPaint.setLetterSpacing(f5);
        }
        this.textPaint.setShadowLayer(lerp(this.expandedShadowRadius, this.collapsedShadowRadius, f2, null), lerp(this.expandedShadowDx, this.collapsedShadowDx, f2, null), lerp(this.expandedShadowDy, this.collapsedShadowDy, f2, null), blendColors(getCurrentColor(this.expandedShadowColor), getCurrentColor(this.collapsedShadowColor), f2));
        if (this.fadeModeEnabled) {
            float f7 = this.fadeModeThresholdFraction;
            if (f2 <= f7) {
                f4 = AnimationUtils.lerp(1.0f, 0.0f, this.fadeModeStartFraction, f7, f2);
            } else {
                f4 = AnimationUtils.lerp(0.0f, 1.0f, f7, 1.0f, f2);
            }
            this.textPaint.setAlpha((int) (f4 * 255.0f));
        }
        this.view.postInvalidateOnAnimation();
    }

    public final void calculateUsingTextSize(float f2, boolean z) {
        float f3;
        boolean z2;
        StaticLayout staticLayout;
        if (this.text != null) {
            float width = (float) this.collapsedBounds.width();
            float width2 = (float) this.expandedBounds.width();
            int i = 1;
            if (Math.abs(f2 - this.collapsedTextSize) < 0.001f) {
                f3 = this.collapsedTextSize;
                this.scale = 1.0f;
                Typeface typeface = this.currentTypeface;
                Typeface typeface2 = this.collapsedTypeface;
                if (typeface != typeface2) {
                    this.currentTypeface = typeface2;
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                float f4 = this.expandedTextSize;
                Typeface typeface3 = this.currentTypeface;
                Typeface typeface4 = this.expandedTypeface;
                if (typeface3 != typeface4) {
                    this.currentTypeface = typeface4;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (Math.abs(f2 - this.expandedTextSize) < 0.001f) {
                    this.scale = 1.0f;
                } else {
                    this.scale = f2 / this.expandedTextSize;
                }
                float f5 = this.collapsedTextSize / this.expandedTextSize;
                width = (!z && width2 * f5 > width) ? Math.min(width / f5, width2) : width2;
                f3 = f4;
            }
            if (width > 0.0f) {
                z2 = this.currentTextSize != f3 || this.boundsChanged || z2;
                this.currentTextSize = f3;
                this.boundsChanged = false;
            }
            if (this.textToDraw == null || z2) {
                this.textPaint.setTextSize(this.currentTextSize);
                this.textPaint.setTypeface(this.currentTypeface);
                this.textPaint.setLinearText(this.scale != 1.0f);
                this.isRtl = calculateIsRtl(this.text);
                if (shouldDrawMultiline()) {
                    i = this.maxLines;
                }
                boolean z3 = this.isRtl;
                try {
                    StaticLayoutBuilderCompat staticLayoutBuilderCompat = new StaticLayoutBuilderCompat(this.text, this.textPaint, (int) width);
                    staticLayoutBuilderCompat.ellipsize = TruncateAt.END;
                    staticLayoutBuilderCompat.isRtl = z3;
                    staticLayoutBuilderCompat.alignment = Alignment.ALIGN_NORMAL;
                    staticLayoutBuilderCompat.includePad = false;
                    staticLayoutBuilderCompat.maxLines = i;
                    float f6 = this.lineSpacingAdd;
                    float f7 = this.lineSpacingMultiplier;
                    staticLayoutBuilderCompat.lineSpacingAdd = f6;
                    staticLayoutBuilderCompat.lineSpacingMultiplier = f7;
                    staticLayoutBuilderCompat.hyphenationFrequency = this.hyphenationFrequency;
                    staticLayout = staticLayoutBuilderCompat.build();
                } catch (StaticLayoutBuilderCompatException e2) {
                    e2.getCause().getMessage();
                    staticLayout = null;
                }
                b.checkNotNull(staticLayout);
                this.textLayout = staticLayout;
                this.textToDraw = staticLayout.getText();
            }
        }
    }

    public final void clearTexture() {
        Bitmap bitmap = this.expandedTitleTexture;
        if (bitmap != null) {
            bitmap.recycle();
            this.expandedTitleTexture = null;
        }
    }

    public void draw(Canvas canvas) {
        int save = canvas.save();
        if (this.textToDraw != null && this.drawTitle) {
            boolean z = true;
            float lineStart = (this.currentDrawX + (this.maxLines > 1 ? (float) this.textLayout.getLineStart(0) : this.textLayout.getLineLeft(0))) - (this.expandedFirstLineDrawX * 2.0f);
            this.textPaint.setTextSize(this.currentTextSize);
            float f2 = this.currentDrawX;
            float f3 = this.currentDrawY;
            if (!this.useTexture || this.expandedTitleTexture == null) {
                z = false;
            }
            float f4 = this.scale;
            if (f4 != 1.0f && !this.fadeModeEnabled) {
                canvas.scale(f4, f4, f2, f3);
            }
            if (z) {
                canvas.drawBitmap(this.expandedTitleTexture, f2, f3, this.texturePaint);
                canvas.restoreToCount(save);
                return;
            }
            if (!shouldDrawMultiline() || (this.fadeModeEnabled && this.expandedFraction <= this.fadeModeThresholdFraction)) {
                canvas.translate(f2, f3);
                this.textLayout.draw(canvas);
            } else {
                int alpha = this.textPaint.getAlpha();
                canvas.translate(lineStart, f3);
                float f5 = (float) alpha;
                this.textPaint.setAlpha((int) (this.expandedTextBlend * f5));
                this.textLayout.draw(canvas);
                this.textPaint.setAlpha((int) (this.collapsedTextBlend * f5));
                int lineBaseline = this.textLayout.getLineBaseline(0);
                CharSequence charSequence = this.textToDrawCollapsed;
                float f6 = (float) lineBaseline;
                canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f6, this.textPaint);
                if (!this.fadeModeEnabled) {
                    String trim = this.textToDrawCollapsed.toString().trim();
                    if (trim.endsWith("…")) {
                        trim = trim.substring(0, trim.length() - 1);
                    }
                    String str = trim;
                    this.textPaint.setAlpha(alpha);
                    canvas.drawText(str, 0, Math.min(this.textLayout.getLineEnd(0), str.length()), 0.0f, f6, this.textPaint);
                }
            }
            canvas.restoreToCount(save);
        }
    }

    public float getCollapsedTextHeight() {
        TextPaint textPaint2 = this.tmpPaint;
        textPaint2.setTextSize(this.collapsedTextSize);
        textPaint2.setTypeface(this.collapsedTypeface);
        textPaint2.setLetterSpacing(this.collapsedLetterSpacing);
        return -this.tmpPaint.ascent();
    }

    public int getCurrentCollapsedTextColor() {
        return getCurrentColor(this.collapsedTextColor);
    }

    public final int getCurrentColor(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.state;
        if (iArr != null) {
            return colorStateList.getColorForState(iArr, 0);
        }
        return colorStateList.getDefaultColor();
    }

    public void onBoundsChanged() {
        this.drawTitle = this.collapsedBounds.width() > 0 && this.collapsedBounds.height() > 0 && this.expandedBounds.width() > 0 && this.expandedBounds.height() > 0;
    }

    public void recalculate(boolean z) {
        if ((this.view.getHeight() > 0 && this.view.getWidth() > 0) || z) {
            float f2 = this.currentTextSize;
            calculateUsingTextSize(this.collapsedTextSize, z);
            CharSequence charSequence = this.textToDraw;
            if (charSequence != null) {
                StaticLayout staticLayout = this.textLayout;
                if (staticLayout != null) {
                    this.textToDrawCollapsed = TextUtils.ellipsize(charSequence, this.textPaint, (float) staticLayout.getWidth(), TruncateAt.END);
                }
            }
            CharSequence charSequence2 = this.textToDrawCollapsed;
            float f3 = 0.0f;
            float measureText = charSequence2 != null ? this.textPaint.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
            int absoluteGravity = Gravity.getAbsoluteGravity(this.collapsedTextGravity, this.isRtl ? 1 : 0);
            int i = absoluteGravity & 112;
            if (i == 48) {
                this.collapsedDrawY = (float) this.collapsedBounds.top;
            } else if (i != 80) {
                this.collapsedDrawY = ((float) this.collapsedBounds.centerY()) - ((this.textPaint.descent() - this.textPaint.ascent()) / 2.0f);
            } else {
                this.collapsedDrawY = this.textPaint.ascent() + ((float) this.collapsedBounds.bottom);
            }
            int i2 = absoluteGravity & 8388615;
            if (i2 == 1) {
                this.collapsedDrawX = ((float) this.collapsedBounds.centerX()) - (measureText / 2.0f);
            } else if (i2 != 5) {
                this.collapsedDrawX = (float) this.collapsedBounds.left;
            } else {
                this.collapsedDrawX = ((float) this.collapsedBounds.right) - measureText;
            }
            calculateUsingTextSize(this.expandedTextSize, z);
            StaticLayout staticLayout2 = this.textLayout;
            float height = staticLayout2 != null ? (float) staticLayout2.getHeight() : 0.0f;
            CharSequence charSequence3 = this.textToDraw;
            float measureText2 = charSequence3 != null ? this.textPaint.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
            StaticLayout staticLayout3 = this.textLayout;
            if (staticLayout3 != null && this.maxLines > 1) {
                measureText2 = (float) staticLayout3.getWidth();
            }
            StaticLayout staticLayout4 = this.textLayout;
            if (staticLayout4 != null) {
                f3 = this.maxLines > 1 ? (float) staticLayout4.getLineStart(0) : staticLayout4.getLineLeft(0);
            }
            this.expandedFirstLineDrawX = f3;
            int absoluteGravity2 = Gravity.getAbsoluteGravity(this.expandedTextGravity, this.isRtl ? 1 : 0);
            int i3 = absoluteGravity2 & 112;
            if (i3 == 48) {
                this.expandedDrawY = (float) this.expandedBounds.top;
            } else if (i3 != 80) {
                this.expandedDrawY = ((float) this.expandedBounds.centerY()) - (height / 2.0f);
            } else {
                this.expandedDrawY = this.textPaint.descent() + (((float) this.expandedBounds.bottom) - height);
            }
            int i4 = absoluteGravity2 & 8388615;
            if (i4 == 1) {
                this.expandedDrawX = ((float) this.expandedBounds.centerX()) - (measureText2 / 2.0f);
            } else if (i4 != 5) {
                this.expandedDrawX = (float) this.expandedBounds.left;
            } else {
                this.expandedDrawX = ((float) this.expandedBounds.right) - measureText2;
            }
            clearTexture();
            setInterpolatedTextSize(f2);
            calculateOffsets(this.expandedFraction);
        }
    }

    public void setCollapsedTextAppearance(int i) {
        TextAppearance textAppearance = new TextAppearance(this.view.getContext(), i);
        ColorStateList colorStateList = textAppearance.textColor;
        if (colorStateList != null) {
            this.collapsedTextColor = colorStateList;
        }
        float f2 = textAppearance.textSize;
        if (f2 != 0.0f) {
            this.collapsedTextSize = f2;
        }
        ColorStateList colorStateList2 = textAppearance.shadowColor;
        if (colorStateList2 != null) {
            this.collapsedShadowColor = colorStateList2;
        }
        this.collapsedShadowDx = textAppearance.shadowDx;
        this.collapsedShadowDy = textAppearance.shadowDy;
        this.collapsedShadowRadius = textAppearance.shadowRadius;
        this.collapsedLetterSpacing = textAppearance.letterSpacing;
        CancelableFontCallback cancelableFontCallback = this.collapsedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancelled = true;
        }
        AnonymousClass1 r1 = new ApplyFont() {
            public void apply(Typeface typeface) {
                CollapsingTextHelper.this.setCollapsedTypeface(typeface);
            }
        };
        textAppearance.createFallbackFont();
        this.collapsedFontCallback = new CancelableFontCallback(r1, textAppearance.font);
        textAppearance.getFontAsync(this.view.getContext(), this.collapsedFontCallback);
        recalculate(false);
    }

    public void setCollapsedTextColor(ColorStateList colorStateList) {
        if (this.collapsedTextColor != colorStateList) {
            this.collapsedTextColor = colorStateList;
            recalculate(false);
        }
    }

    public void setCollapsedTextGravity(int i) {
        if (this.collapsedTextGravity != i) {
            this.collapsedTextGravity = i;
            recalculate(false);
        }
    }

    public void setCollapsedTypeface(Typeface typeface) {
        CancelableFontCallback cancelableFontCallback = this.collapsedFontCallback;
        boolean z = true;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancelled = true;
        }
        if (this.collapsedTypeface != typeface) {
            this.collapsedTypeface = typeface;
        } else {
            z = false;
        }
        if (z) {
            recalculate(false);
        }
    }

    public void setExpandedTextAppearance(int i) {
        TextAppearance textAppearance = new TextAppearance(this.view.getContext(), i);
        ColorStateList colorStateList = textAppearance.textColor;
        if (colorStateList != null) {
            this.expandedTextColor = colorStateList;
        }
        float f2 = textAppearance.textSize;
        if (f2 != 0.0f) {
            this.expandedTextSize = f2;
        }
        ColorStateList colorStateList2 = textAppearance.shadowColor;
        if (colorStateList2 != null) {
            this.expandedShadowColor = colorStateList2;
        }
        this.expandedShadowDx = textAppearance.shadowDx;
        this.expandedShadowDy = textAppearance.shadowDy;
        this.expandedShadowRadius = textAppearance.shadowRadius;
        this.expandedLetterSpacing = textAppearance.letterSpacing;
        CancelableFontCallback cancelableFontCallback = this.expandedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancelled = true;
        }
        AnonymousClass2 r1 = new ApplyFont() {
            public void apply(Typeface typeface) {
                CollapsingTextHelper.this.setExpandedTypeface(typeface);
            }
        };
        textAppearance.createFallbackFont();
        this.expandedFontCallback = new CancelableFontCallback(r1, textAppearance.font);
        textAppearance.getFontAsync(this.view.getContext(), this.expandedFontCallback);
        recalculate(false);
    }

    public void setExpandedTextColor(ColorStateList colorStateList) {
        if (this.expandedTextColor != colorStateList) {
            this.expandedTextColor = colorStateList;
            recalculate(false);
        }
    }

    public void setExpandedTextGravity(int i) {
        if (this.expandedTextGravity != i) {
            this.expandedTextGravity = i;
            recalculate(false);
        }
    }

    public void setExpandedTypeface(Typeface typeface) {
        CancelableFontCallback cancelableFontCallback = this.expandedFontCallback;
        boolean z = true;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancelled = true;
        }
        if (this.expandedTypeface != typeface) {
            this.expandedTypeface = typeface;
        } else {
            z = false;
        }
        if (z) {
            recalculate(false);
        }
    }

    public void setExpansionFraction(float f2) {
        float clamp = b.clamp(f2, 0.0f, 1.0f);
        if (clamp != this.expandedFraction) {
            this.expandedFraction = clamp;
            calculateOffsets(clamp);
        }
    }

    public final void setInterpolatedTextSize(float f2) {
        calculateUsingTextSize(f2, false);
        this.useTexture = false;
        if (0 != 0 && this.expandedTitleTexture == null && !this.expandedBounds.isEmpty() && !TextUtils.isEmpty(this.textToDraw)) {
            calculateOffsets(0.0f);
            int width = this.textLayout.getWidth();
            int height = this.textLayout.getHeight();
            if (width > 0 && height > 0) {
                this.expandedTitleTexture = Bitmap.createBitmap(width, height, Config.ARGB_8888);
                this.textLayout.draw(new Canvas(this.expandedTitleTexture));
                if (this.texturePaint == null) {
                    this.texturePaint = new Paint(3);
                }
            }
        }
        ViewCompat.postInvalidateOnAnimation(this.view);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001d  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0021 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean setState(int[] r3) {
        /*
            r2 = this;
            r2.state = r3
            android.content.res.ColorStateList r3 = r2.collapsedTextColor
            r0 = 1
            r1 = 0
            if (r3 == 0) goto L_0x000e
            boolean r3 = r3.isStateful()
            if (r3 != 0) goto L_0x0018
        L_0x000e:
            android.content.res.ColorStateList r3 = r2.expandedTextColor
            if (r3 == 0) goto L_0x001a
            boolean r3 = r3.isStateful()
            if (r3 == 0) goto L_0x001a
        L_0x0018:
            r3 = 1
            goto L_0x001b
        L_0x001a:
            r3 = 0
        L_0x001b:
            if (r3 == 0) goto L_0x0021
            r2.recalculate(r1)
            return r0
        L_0x0021:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.internal.CollapsingTextHelper.setState(int[]):boolean");
    }

    public void setText(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.text, charSequence)) {
            this.text = charSequence;
            this.textToDraw = null;
            clearTexture();
            recalculate(false);
        }
    }

    public void setTypefaces(Typeface typeface) {
        boolean z;
        CancelableFontCallback cancelableFontCallback = this.collapsedFontCallback;
        boolean z2 = true;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancelled = true;
        }
        if (this.collapsedTypeface != typeface) {
            this.collapsedTypeface = typeface;
            z = true;
        } else {
            z = false;
        }
        CancelableFontCallback cancelableFontCallback2 = this.expandedFontCallback;
        if (cancelableFontCallback2 != null) {
            cancelableFontCallback2.cancelled = true;
        }
        if (this.expandedTypeface != typeface) {
            this.expandedTypeface = typeface;
        } else {
            z2 = false;
        }
        if (z || z2) {
            recalculate(false);
        }
    }

    public final boolean shouldDrawMultiline() {
        return this.maxLines > 1 && (!this.isRtl || this.fadeModeEnabled) && !this.useTexture;
    }
}
