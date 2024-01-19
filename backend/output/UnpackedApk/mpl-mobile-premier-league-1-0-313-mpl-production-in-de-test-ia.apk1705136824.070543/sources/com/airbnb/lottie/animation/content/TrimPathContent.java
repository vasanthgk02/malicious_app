package com.airbnb.lottie.animation.content;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.content.ShapeTrimPath.Type;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

public class TrimPathContent implements Content, AnimationListener {
    public final BaseKeyframeAnimation<?, Float> endAnimation;
    public final boolean hidden;
    public final List<AnimationListener> listeners = new ArrayList();
    public final String name;
    public final BaseKeyframeAnimation<?, Float> offsetAnimation;
    public final BaseKeyframeAnimation<?, Float> startAnimation;
    public final Type type;

    public TrimPathContent(BaseLayer baseLayer, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.name;
        this.hidden = shapeTrimPath.hidden;
        this.type = shapeTrimPath.type;
        this.startAnimation = shapeTrimPath.start.createAnimation();
        this.endAnimation = shapeTrimPath.end.createAnimation();
        this.offsetAnimation = shapeTrimPath.offset.createAnimation();
        baseLayer.addAnimation(this.startAnimation);
        baseLayer.addAnimation(this.endAnimation);
        baseLayer.addAnimation(this.offsetAnimation);
        this.startAnimation.listeners.add(this);
        this.endAnimation.listeners.add(this);
        this.offsetAnimation.listeners.add(this);
    }

    public String getName() {
        return this.name;
    }

    public void onValueChanged() {
        for (int i = 0; i < this.listeners.size(); i++) {
            this.listeners.get(i).onValueChanged();
        }
    }

    public void setContents(List<Content> list, List<Content> list2) {
    }
}
