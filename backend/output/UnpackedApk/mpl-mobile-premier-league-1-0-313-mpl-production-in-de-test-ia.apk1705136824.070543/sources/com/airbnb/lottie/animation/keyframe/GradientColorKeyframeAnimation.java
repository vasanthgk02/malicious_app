package com.airbnb.lottie.animation.keyframe;

import co.hyperverge.hypersnapsdk.c.k;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.List;

public class GradientColorKeyframeAnimation extends KeyframeAnimation<GradientColor> {
    public final GradientColor gradientColor;

    public GradientColorKeyframeAnimation(List<Keyframe<GradientColor>> list) {
        super(list);
        int i = 0;
        GradientColor gradientColor2 = (GradientColor) list.get(0).startValue;
        i = gradientColor2 != null ? gradientColor2.colors.length : i;
        this.gradientColor = new GradientColor(new float[i], new int[i]);
    }

    public Object getValue(Keyframe keyframe, float f2) {
        GradientColor gradientColor2 = this.gradientColor;
        GradientColor gradientColor3 = (GradientColor) keyframe.startValue;
        GradientColor gradientColor4 = (GradientColor) keyframe.endValue;
        if (gradientColor2 == null) {
            throw null;
        } else if (gradientColor3.colors.length == gradientColor4.colors.length) {
            for (int i = 0; i < gradientColor3.colors.length; i++) {
                gradientColor2.positions[i] = MiscUtils.lerp(gradientColor3.positions[i], gradientColor4.positions[i], f2);
                gradientColor2.colors[i] = k.evaluate(f2, gradientColor3.colors[i], gradientColor4.colors[i]);
            }
            return this.gradientColor;
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Cannot interpolate between gradients. Lengths vary (");
            outline73.append(gradientColor3.colors.length);
            outline73.append(" vs ");
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline57(outline73, gradientColor4.colors.length, ")"));
        }
    }
}
