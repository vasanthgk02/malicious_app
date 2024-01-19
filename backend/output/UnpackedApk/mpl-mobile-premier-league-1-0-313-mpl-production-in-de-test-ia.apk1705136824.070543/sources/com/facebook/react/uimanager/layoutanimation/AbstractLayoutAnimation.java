package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.BaseInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.IllegalViewOperationException;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;
import java.util.Map;

public abstract class AbstractLayoutAnimation {
    public static final Map<InterpolatorType, BaseInterpolator> INTERPOLATOR = ImageOriginUtils.of(InterpolatorType.LINEAR, new LinearInterpolator(), InterpolatorType.EASE_IN, new AccelerateInterpolator(), InterpolatorType.EASE_OUT, new DecelerateInterpolator(), InterpolatorType.EASE_IN_EASE_OUT, new AccelerateDecelerateInterpolator());
    public AnimatedPropertyType mAnimatedProperty;
    public int mDelayMs;
    public int mDurationMs;
    public Interpolator mInterpolator;

    public final Animation createAnimation(View view, int i, int i2, int i3, int i4) {
        if (!isValid()) {
            return null;
        }
        Animation createAnimationImpl = createAnimationImpl(view, i, i2, i3, i4);
        if (createAnimationImpl != null) {
            createAnimationImpl.setDuration((long) (this.mDurationMs * 1));
            createAnimationImpl.setStartOffset((long) (this.mDelayMs * 1));
            createAnimationImpl.setInterpolator(this.mInterpolator);
        }
        return createAnimationImpl;
    }

    public abstract Animation createAnimationImpl(View view, int i, int i2, int i3, int i4);

    public void initializeFromConfig(ReadableMap readableMap, int i) {
        Interpolator interpolator;
        this.mAnimatedProperty = readableMap.hasKey("property") ? AnimatedPropertyType.fromString(readableMap.getString("property")) : null;
        if (readableMap.hasKey(InlineAnimation.DURATION)) {
            i = readableMap.getInt(InlineAnimation.DURATION);
        }
        this.mDurationMs = i;
        this.mDelayMs = readableMap.hasKey(InlineAnimation.DELAY) ? readableMap.getInt(InlineAnimation.DELAY) : 0;
        if (readableMap.hasKey("type")) {
            InterpolatorType fromString = InterpolatorType.fromString(readableMap.getString("type"));
            if (fromString.equals(InterpolatorType.SPRING)) {
                new SimpleSpringInterpolator(readableMap.getType("springDamping").equals(ReadableType.Number) ? (float) readableMap.getDouble("springDamping") : 0.5f);
            } else {
                interpolator = INTERPOLATOR.get(fromString);
            }
            if (interpolator != null) {
                this.mInterpolator = interpolator;
                if (!isValid()) {
                    throw new IllegalViewOperationException("Invalid layout animation : " + readableMap);
                }
                return;
            }
            throw new IllegalArgumentException("Missing interpolator for type : " + fromString);
        }
        throw new IllegalArgumentException("Missing interpolation type.");
    }

    public abstract boolean isValid();

    public void reset() {
        this.mAnimatedProperty = null;
        this.mDurationMs = 0;
        this.mDelayMs = 0;
        this.mInterpolator = null;
    }
}
