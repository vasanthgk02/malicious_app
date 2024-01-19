package com.facebook.react.views.text;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;

public class TextAttributes {
    public boolean mAllowFontScaling = true;
    public float mFontSize = Float.NaN;
    public float mHeightOfTallestInlineViewOrImage = Float.NaN;
    public float mLetterSpacing = Float.NaN;
    public float mLineHeight = Float.NaN;
    public float mMaxFontSizeMultiplier = Float.NaN;
    public TextTransform mTextTransform = TextTransform.UNSET;

    public int getEffectiveFontSize() {
        double d2;
        float f2 = !Float.isNaN(this.mFontSize) ? this.mFontSize : 14.0f;
        if (this.mAllowFontScaling) {
            d2 = Math.ceil((double) ImageOriginUtils.toPixelFromSP(f2, getEffectiveMaxFontSizeMultiplier()));
        } else {
            d2 = Math.ceil((double) ImageOriginUtils.toPixelFromDIP(f2));
        }
        return (int) d2;
    }

    public float getEffectiveLetterSpacing() {
        float f2;
        if (Float.isNaN(this.mLetterSpacing)) {
            return Float.NaN;
        }
        if (this.mAllowFontScaling) {
            f2 = ImageOriginUtils.toPixelFromSP(this.mLetterSpacing, getEffectiveMaxFontSizeMultiplier());
        } else {
            f2 = ImageOriginUtils.toPixelFromDIP(this.mLetterSpacing);
        }
        return f2 / ((float) getEffectiveFontSize());
    }

    public float getEffectiveLineHeight() {
        float f2;
        if (Float.isNaN(this.mLineHeight)) {
            return Float.NaN;
        }
        if (this.mAllowFontScaling) {
            f2 = ImageOriginUtils.toPixelFromSP(this.mLineHeight, getEffectiveMaxFontSizeMultiplier());
        } else {
            f2 = ImageOriginUtils.toPixelFromDIP(this.mLineHeight);
        }
        if (!Float.isNaN(this.mHeightOfTallestInlineViewOrImage) && this.mHeightOfTallestInlineViewOrImage > f2) {
            f2 = this.mHeightOfTallestInlineViewOrImage;
        }
        return f2;
    }

    public float getEffectiveMaxFontSizeMultiplier() {
        if (!Float.isNaN(this.mMaxFontSizeMultiplier)) {
            return this.mMaxFontSizeMultiplier;
        }
        return 0.0f;
    }

    public void setMaxFontSizeMultiplier(float f2) {
        if (f2 == 0.0f || f2 >= 1.0f) {
            this.mMaxFontSizeMultiplier = f2;
            return;
        }
        throw new JSApplicationIllegalArgumentException("maxFontSizeMultiplier must be NaN, 0, or >= 1");
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("TextAttributes {\n  getAllowFontScaling(): ");
        outline73.append(this.mAllowFontScaling);
        outline73.append("\n  getFontSize(): ");
        outline73.append(this.mFontSize);
        outline73.append("\n  getEffectiveFontSize(): ");
        outline73.append(getEffectiveFontSize());
        outline73.append("\n  getHeightOfTallestInlineViewOrImage(): ");
        outline73.append(this.mHeightOfTallestInlineViewOrImage);
        outline73.append("\n  getLetterSpacing(): ");
        outline73.append(this.mLetterSpacing);
        outline73.append("\n  getEffectiveLetterSpacing(): ");
        outline73.append(getEffectiveLetterSpacing());
        outline73.append("\n  getLineHeight(): ");
        outline73.append(this.mLineHeight);
        outline73.append("\n  getEffectiveLineHeight(): ");
        outline73.append(getEffectiveLineHeight());
        outline73.append("\n  getTextTransform(): ");
        outline73.append(this.mTextTransform);
        outline73.append("\n  getMaxFontSizeMultiplier(): ");
        outline73.append(this.mMaxFontSizeMultiplier);
        outline73.append("\n  getEffectiveMaxFontSizeMultiplier(): ");
        outline73.append(getEffectiveMaxFontSizeMultiplier());
        outline73.append("\n}");
        return outline73.toString();
    }
}
