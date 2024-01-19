package com.bumptech.glide.request.transition;

import android.view.animation.AnimationUtils;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.request.transition.Transition.ViewAdapter;
import com.bumptech.glide.request.transition.ViewAnimationFactory.ResourceViewTransitionAnimationFactory;

public class ViewTransition<R> implements Transition<R> {
    public final ViewTransitionAnimationFactory viewTransitionAnimationFactory;

    public interface ViewTransitionAnimationFactory {
    }

    public ViewTransition(ViewTransitionAnimationFactory viewTransitionAnimationFactory2) {
        this.viewTransitionAnimationFactory = viewTransitionAnimationFactory2;
    }

    public boolean transition(R r, ViewAdapter viewAdapter) {
        T t = ((ViewTarget) viewAdapter).view;
        if (t != null) {
            t.clearAnimation();
            t.startAnimation(AnimationUtils.loadAnimation(t.getContext(), ((ResourceViewTransitionAnimationFactory) this.viewTransitionAnimationFactory).animationId));
        }
        return false;
    }
}
