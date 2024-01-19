package com.facebook.react.views.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;

public class CustomStyleSpan extends MetricAffectingSpan implements ReactSpan {
    public final AssetManager mAssetManager;
    public final String mFeatureSettings;
    public final String mFontFamily;
    public final int mStyle;
    public final int mWeight;

    public CustomStyleSpan(int i, int i2, String str, String str2, AssetManager assetManager) {
        this.mStyle = i;
        this.mWeight = i2;
        this.mFeatureSettings = str;
        this.mFontFamily = str2;
        this.mAssetManager = assetManager;
    }

    public void updateDrawState(TextPaint textPaint) {
        int i = this.mStyle;
        int i2 = this.mWeight;
        String str = this.mFeatureSettings;
        Typeface applyStyles = ImageOriginUtils.applyStyles(textPaint.getTypeface(), i, i2, this.mFontFamily, this.mAssetManager);
        textPaint.setFontFeatureSettings(str);
        textPaint.setTypeface(applyStyles);
        textPaint.setSubpixelText(true);
    }

    public void updateMeasureState(TextPaint textPaint) {
        int i = this.mStyle;
        int i2 = this.mWeight;
        String str = this.mFeatureSettings;
        Typeface applyStyles = ImageOriginUtils.applyStyles(textPaint.getTypeface(), i, i2, this.mFontFamily, this.mAssetManager);
        textPaint.setFontFeatureSettings(str);
        textPaint.setTypeface(applyStyles);
        textPaint.setSubpixelText(true);
    }
}
