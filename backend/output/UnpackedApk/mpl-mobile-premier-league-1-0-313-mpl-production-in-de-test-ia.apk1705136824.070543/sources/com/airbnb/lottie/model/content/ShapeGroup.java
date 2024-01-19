package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Arrays;
import java.util.List;

public class ShapeGroup implements ContentModel {
    public final boolean hidden;
    public final List<ContentModel> items;
    public final String name;

    public ShapeGroup(String str, List<ContentModel> list, boolean z) {
        this.name = str;
        this.items = list;
        this.hidden = z;
    }

    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new ContentGroup(lottieDrawable, baseLayer, this);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ShapeGroup{name='");
        outline73.append(this.name);
        outline73.append("' Shapes: ");
        outline73.append(Arrays.toString(this.items.toArray()));
        outline73.append('}');
        return outline73.toString();
    }
}
