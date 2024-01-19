package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.android.tools.r8.GeneratedOutlineSupport;

public class ShapeTrimPath implements ContentModel {
    public final AnimatableFloatValue end;
    public final boolean hidden;
    public final String name;
    public final AnimatableFloatValue offset;
    public final AnimatableFloatValue start;
    public final Type type;

    public enum Type {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static Type forId(int i) {
            if (i == 1) {
                return SIMULTANEOUSLY;
            }
            if (i == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("Unknown trim path type ", i));
        }
    }

    public ShapeTrimPath(String str, Type type2, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, AnimatableFloatValue animatableFloatValue3, boolean z) {
        this.name = str;
        this.type = type2;
        this.start = animatableFloatValue;
        this.end = animatableFloatValue2;
        this.offset = animatableFloatValue3;
        this.hidden = z;
    }

    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new TrimPathContent(baseLayer, this);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Trim Path: {start: ");
        outline73.append(this.start);
        outline73.append(", end: ");
        outline73.append(this.end);
        outline73.append(", offset: ");
        outline73.append(this.offset);
        outline73.append("}");
        return outline73.toString();
    }
}
