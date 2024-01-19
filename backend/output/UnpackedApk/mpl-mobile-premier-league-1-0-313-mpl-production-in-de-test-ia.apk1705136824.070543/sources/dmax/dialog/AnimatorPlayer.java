package dmax.dialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;

public class AnimatorPlayer extends AnimatorListenerAdapter {
    public Animator[] animators;
    public boolean interrupted = false;

    public AnimatorPlayer(Animator[] animatorArr) {
        this.animators = animatorArr;
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.interrupted) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(this.animators);
            animatorSet.addListener(this);
            animatorSet.start();
        }
    }
}
