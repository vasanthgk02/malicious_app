package com.bumptech.glide;

import co.hyperverge.hypersnapsdk.c.k;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.NoTransition;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.request.transition.ViewAnimationFactory;
import com.bumptech.glide.request.transition.ViewPropertyAnimationFactory;
import com.bumptech.glide.request.transition.ViewPropertyTransition.Animator;

public abstract class TransitionOptions<CHILD extends TransitionOptions<CHILD, TranscodeType>, TranscodeType> implements Cloneable {
    public TransitionFactory<? super TranscodeType> transitionFactory = NoTransition.NO_ANIMATION_FACTORY;

    private CHILD self() {
        return this;
    }

    public final CHILD dontTransition() {
        return transition(NoTransition.NO_ANIMATION_FACTORY);
    }

    public final TransitionFactory<? super TranscodeType> getTransitionFactory() {
        return this.transitionFactory;
    }

    public final CHILD transition(TransitionFactory<? super TranscodeType> transitionFactory2) {
        k.checkNotNull(transitionFactory2, (String) "Argument must not be null");
        this.transitionFactory = transitionFactory2;
        return self();
    }

    public final CHILD clone() {
        try {
            return (TransitionOptions) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final CHILD transition(int i) {
        return transition((TransitionFactory<? super TranscodeType>) new ViewAnimationFactory<Object>(i));
    }

    public final CHILD transition(Animator animator) {
        return transition((TransitionFactory<? super TranscodeType>) new ViewPropertyAnimationFactory<Object>(animator));
    }
}
