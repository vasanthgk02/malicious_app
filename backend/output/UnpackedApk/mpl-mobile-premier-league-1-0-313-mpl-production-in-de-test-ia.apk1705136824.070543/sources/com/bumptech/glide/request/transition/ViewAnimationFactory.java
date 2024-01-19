package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.ViewTransition.ViewTransitionAnimationFactory;

public class ViewAnimationFactory<R> implements TransitionFactory<R> {
    public Transition<R> transition;
    public final ViewTransitionAnimationFactory viewTransitionAnimationFactory;

    public static class ResourceViewTransitionAnimationFactory implements ViewTransitionAnimationFactory {
        public final int animationId;

        public ResourceViewTransitionAnimationFactory(int i) {
            this.animationId = i;
        }
    }

    public ViewAnimationFactory(int i) {
        this.viewTransitionAnimationFactory = new ResourceViewTransitionAnimationFactory(i);
    }

    public Transition<R> build(DataSource dataSource, boolean z) {
        if (dataSource == DataSource.MEMORY_CACHE || !z) {
            return NoTransition.NO_ANIMATION;
        }
        if (this.transition == null) {
            this.transition = new ViewTransition(this.viewTransitionAnimationFactory);
        }
        return this.transition;
    }
}
