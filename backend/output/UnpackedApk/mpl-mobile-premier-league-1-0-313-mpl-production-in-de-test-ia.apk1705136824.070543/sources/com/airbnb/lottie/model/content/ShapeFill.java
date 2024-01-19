package com.airbnb.lottie.model.content;

import android.graphics.Path.FillType;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.FillContent;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.android.tools.r8.GeneratedOutlineSupport;

public class ShapeFill implements ContentModel {
    public final AnimatableColorValue color;
    public final boolean fillEnabled;
    public final FillType fillType;
    public final boolean hidden;
    public final String name;
    public final AnimatableIntegerValue opacity;

    public ShapeFill(String str, boolean z, FillType fillType2, AnimatableColorValue animatableColorValue, AnimatableIntegerValue animatableIntegerValue, boolean z2) {
        this.name = str;
        this.fillEnabled = z;
        this.fillType = fillType2;
        this.color = animatableColorValue;
        this.opacity = animatableIntegerValue;
        this.hidden = z2;
    }

    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new FillContent(lottieDrawable, baseLayer, this);
    }

    public String toString() {
        return GeneratedOutlineSupport.outline65(GeneratedOutlineSupport.outline73("ShapeFill{color=, fillEnabled="), this.fillEnabled, '}');
    }
}
