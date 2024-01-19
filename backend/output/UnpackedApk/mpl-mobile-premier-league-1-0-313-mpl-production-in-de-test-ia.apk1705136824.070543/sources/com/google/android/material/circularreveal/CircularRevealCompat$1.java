package com.google.android.material.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public final class CircularRevealCompat$1 extends AnimatorListenerAdapter {
    public final /* synthetic */ CircularRevealWidget val$view;

    public CircularRevealCompat$1(CircularRevealWidget circularRevealWidget) {
        this.val$view = circularRevealWidget;
    }

    public void onAnimationEnd(Animator animator) {
        this.val$view.destroyCircularRevealCache();
    }

    public void onAnimationStart(Animator animator) {
        this.val$view.buildCircularRevealCache();
    }
}
