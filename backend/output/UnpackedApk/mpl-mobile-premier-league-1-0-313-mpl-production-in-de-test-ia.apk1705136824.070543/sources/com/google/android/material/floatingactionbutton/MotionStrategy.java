package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.OnChangedCallback;

public interface MotionStrategy {
    AnimatorSet createAnimator();

    int getDefaultMotionSpecResource();

    void onAnimationCancel();

    void onAnimationEnd();

    void onAnimationStart(Animator animator);

    void onChange(OnChangedCallback onChangedCallback);

    void performNow();

    boolean shouldCancel();
}
