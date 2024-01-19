package androidx.transition;

import android.view.ViewGroup;

public abstract class TransitionPropagation {
    public abstract long getStartDelay(ViewGroup viewGroup, Transition transition, TransitionValues transitionValues, TransitionValues transitionValues2);
}
