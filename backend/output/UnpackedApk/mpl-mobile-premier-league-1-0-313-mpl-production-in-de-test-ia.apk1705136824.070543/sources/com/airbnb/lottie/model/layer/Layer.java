package com.airbnb.lottie.model.layer;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.value.Keyframe;
import com.android.tools.r8.GeneratedOutlineSupport;
import in.juspay.hypersdk.core.InflateView;
import java.util.List;
import java.util.Locale;

public class Layer {
    public final LottieComposition composition;
    public final boolean hidden;
    public final List<Keyframe<Float>> inOutKeyframes;
    public final long layerId;
    public final String layerName;
    public final LayerType layerType;
    public final List<Mask> masks;
    public final MatteType matteType;
    public final long parentId;
    public final int preCompHeight;
    public final int preCompWidth;
    public final String refId;
    public final List<ContentModel> shapes;
    public final int solidColor;
    public final int solidHeight;
    public final int solidWidth;
    public final float startFrame;
    public final AnimatableTextFrame text;
    public final AnimatableTextProperties textProperties;
    public final AnimatableFloatValue timeRemapping;
    public final float timeStretch;
    public final AnimatableTransform transform;

    public enum LayerType {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    public enum MatteType {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public Layer(List<ContentModel> list, LottieComposition lottieComposition, String str, long j, LayerType layerType2, long j2, String str2, List<Mask> list2, AnimatableTransform animatableTransform, int i, int i2, int i3, float f2, float f3, int i4, int i5, AnimatableTextFrame animatableTextFrame, AnimatableTextProperties animatableTextProperties, List<Keyframe<Float>> list3, MatteType matteType2, AnimatableFloatValue animatableFloatValue, boolean z) {
        this.shapes = list;
        this.composition = lottieComposition;
        this.layerName = str;
        this.layerId = j;
        this.layerType = layerType2;
        this.parentId = j2;
        this.refId = str2;
        this.masks = list2;
        this.transform = animatableTransform;
        this.solidWidth = i;
        this.solidHeight = i2;
        this.solidColor = i3;
        this.timeStretch = f2;
        this.startFrame = f3;
        this.preCompWidth = i4;
        this.preCompHeight = i5;
        this.text = animatableTextFrame;
        this.textProperties = animatableTextProperties;
        this.inOutKeyframes = list3;
        this.matteType = matteType2;
        this.timeRemapping = animatableFloatValue;
        this.hidden = z;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String str) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73(str);
        outline73.append(this.layerName);
        outline73.append("\n");
        Layer layerModelForId = this.composition.layerModelForId(this.parentId);
        if (layerModelForId != null) {
            outline73.append("\t\tParents: ");
            outline73.append(layerModelForId.layerName);
            Layer layerModelForId2 = this.composition.layerModelForId(layerModelForId.parentId);
            while (layerModelForId2 != null) {
                outline73.append(InflateView.KEYWORD_SPLIT);
                outline73.append(layerModelForId2.layerName);
                layerModelForId2 = this.composition.layerModelForId(layerModelForId2.parentId);
            }
            outline73.append(str);
            outline73.append("\n");
        }
        if (!this.masks.isEmpty()) {
            outline73.append(str);
            outline73.append("\tMasks: ");
            outline73.append(this.masks.size());
            outline73.append("\n");
        }
        if (!(this.solidWidth == 0 || this.solidHeight == 0)) {
            outline73.append(str);
            outline73.append("\tBackground: ");
            outline73.append(String.format(Locale.US, "%dx%d %X\n", new Object[]{Integer.valueOf(this.solidWidth), Integer.valueOf(this.solidHeight), Integer.valueOf(this.solidColor)}));
        }
        if (!this.shapes.isEmpty()) {
            outline73.append(str);
            outline73.append("\tShapes:\n");
            for (ContentModel next : this.shapes) {
                outline73.append(str);
                outline73.append("\t\t");
                outline73.append(next);
                outline73.append("\n");
            }
        }
        return outline73.toString();
    }
}
