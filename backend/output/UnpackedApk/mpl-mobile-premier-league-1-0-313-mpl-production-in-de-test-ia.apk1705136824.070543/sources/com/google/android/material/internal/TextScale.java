package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import java.util.Map;

public class TextScale extends Transition {
    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public final void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (view instanceof TextView) {
            transitionValues.values.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ValueAnimator valueAnimator = null;
        if (!(transitionValues == null || transitionValues2 == null || !(transitionValues.view instanceof TextView))) {
            View view = transitionValues2.view;
            if (view instanceof TextView) {
                final TextView textView = (TextView) view;
                Map<String, Object> map = transitionValues.values;
                Map<String, Object> map2 = transitionValues2.values;
                float f2 = 1.0f;
                float floatValue = map.get("android:textscale:scale") != null ? ((Float) map.get("android:textscale:scale")).floatValue() : 1.0f;
                if (map2.get("android:textscale:scale") != null) {
                    f2 = ((Float) map2.get("android:textscale:scale")).floatValue();
                }
                if (floatValue == f2) {
                    return null;
                }
                valueAnimator = ValueAnimator.ofFloat(new float[]{floatValue, f2});
                valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        textView.setScaleX(floatValue);
                        textView.setScaleY(floatValue);
                    }
                });
            }
        }
        return valueAnimator;
    }
}
