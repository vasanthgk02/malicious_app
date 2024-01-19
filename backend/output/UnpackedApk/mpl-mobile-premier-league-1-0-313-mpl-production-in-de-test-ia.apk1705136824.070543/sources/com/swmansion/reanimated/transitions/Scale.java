package com.swmansion.reanimated.transitions;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import androidx.transition.TransitionValues;
import androidx.transition.Visibility;

public class Scale extends Visibility {
    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
        transitionValues.values.put("scale:scaleX", Float.valueOf(transitionValues.view.getScaleX()));
        transitionValues.values.put("scale:scaleY", Float.valueOf(transitionValues.view.getScaleY()));
    }

    public final Animator createAnimation(final View view, float f2, float f3, TransitionValues transitionValues) {
        final float scaleX = view.getScaleX();
        final float scaleY = view.getScaleY();
        float f4 = scaleX * f2;
        float f5 = scaleX * f3;
        float f6 = f2 * scaleY;
        float f7 = f3 * scaleY;
        if (transitionValues != null) {
            Float f8 = (Float) transitionValues.values.get("scale:scaleX");
            Float f9 = (Float) transitionValues.values.get("scale:scaleY");
            if (!(f8 == null || f8.floatValue() == scaleX)) {
                f4 = f8.floatValue();
            }
            if (!(f9 == null || f9.floatValue() == scaleY)) {
                f6 = f9.floatValue();
            }
        }
        view.setScaleX(f4);
        view.setScaleY(f6);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(view, View.SCALE_X, new float[]{f4, f5}), ObjectAnimator.ofFloat(view, View.SCALE_Y, new float[]{f6, f7})});
        addListener(new TransitionListenerAdapter() {
            public void onTransitionEnd(Transition transition) {
                view.setScaleX(scaleX);
                view.setScaleY(scaleY);
                transition.removeListener(this);
            }
        });
        return animatorSet;
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return createAnimation(view, 0.0f, 1.0f, transitionValues);
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return createAnimation(view, 1.0f, 0.0f, transitionValues);
    }
}
