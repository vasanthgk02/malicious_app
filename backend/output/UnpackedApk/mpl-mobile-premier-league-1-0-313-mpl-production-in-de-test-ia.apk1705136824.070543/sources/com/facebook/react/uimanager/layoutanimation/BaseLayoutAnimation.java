package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.uimanager.IllegalViewOperationException;

public abstract class BaseLayoutAnimation extends AbstractLayoutAnimation {
    public Animation createAnimationImpl(View view, int i, int i2, int i3, int i4) {
        AnimatedPropertyType animatedPropertyType = this.mAnimatedProperty;
        if (animatedPropertyType != null) {
            int ordinal = animatedPropertyType.ordinal();
            float f2 = 0.0f;
            if (ordinal == 0) {
                float alpha = isReverse() ? view.getAlpha() : 0.0f;
                if (!isReverse()) {
                    f2 = view.getAlpha();
                }
                return new OpacityAnimation(view, alpha, f2);
            } else if (ordinal == 1) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(isReverse() ? 1.0f : 0.0f, isReverse() ? 0.0f : 1.0f, 1.0f, 1.0f, 1, 0.5f, 1, 0.0f);
                return scaleAnimation;
            } else if (ordinal == 2) {
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 1.0f, isReverse() ? 1.0f : 0.0f, isReverse() ? 0.0f : 1.0f, 1, 0.0f, 1, 0.5f);
                return scaleAnimation2;
            } else if (ordinal == 3) {
                float f3 = isReverse() ? 1.0f : 0.0f;
                float f4 = isReverse() ? 0.0f : 1.0f;
                ScaleAnimation scaleAnimation3 = new ScaleAnimation(f3, f4, f3, f4, 1, 0.5f, 1, 0.5f);
                return scaleAnimation3;
            } else {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Missing animation for property : ");
                outline73.append(this.mAnimatedProperty);
                throw new IllegalViewOperationException(outline73.toString());
            }
        } else {
            throw new IllegalViewOperationException("Missing animated property from animation config");
        }
    }

    public abstract boolean isReverse();

    public boolean isValid() {
        return this.mDurationMs > 0 && this.mAnimatedProperty != null;
    }
}
