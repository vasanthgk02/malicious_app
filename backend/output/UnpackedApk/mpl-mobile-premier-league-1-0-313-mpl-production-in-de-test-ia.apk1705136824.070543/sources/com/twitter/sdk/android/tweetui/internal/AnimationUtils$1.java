package com.twitter.sdk.android.tweetui.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

public final class AnimationUtils$1 extends AnimatorListenerAdapter {
    public final /* synthetic */ View val$from;

    public AnimationUtils$1(View view) {
        this.val$from = view;
    }

    public void onAnimationEnd(Animator animator) {
        this.val$from.setVisibility(4);
        this.val$from.setAlpha(1.0f);
    }
}
