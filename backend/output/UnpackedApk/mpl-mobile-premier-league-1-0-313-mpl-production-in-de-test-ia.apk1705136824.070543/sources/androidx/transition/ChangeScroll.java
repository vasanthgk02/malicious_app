package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class ChangeScroll extends Transition {
    public static final String[] PROPERTIES = {"android:changeScroll:x", "android:changeScroll:y"};

    public ChangeScroll() {
    }

    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public final void captureValues(TransitionValues transitionValues) {
        transitionValues.values.put("android:changeScroll:x", Integer.valueOf(transitionValues.view.getScrollX()));
        transitionValues.values.put("android:changeScroll:y", Integer.valueOf(transitionValues.view.getScrollY()));
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        Animator animator;
        ObjectAnimator objectAnimator = null;
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        View view = transitionValues2.view;
        int intValue = ((Integer) transitionValues.values.get("android:changeScroll:x")).intValue();
        int intValue2 = ((Integer) transitionValues2.values.get("android:changeScroll:x")).intValue();
        int intValue3 = ((Integer) transitionValues.values.get("android:changeScroll:y")).intValue();
        int intValue4 = ((Integer) transitionValues2.values.get("android:changeScroll:y")).intValue();
        if (intValue != intValue2) {
            view.setScrollX(intValue);
            animator = ObjectAnimator.ofInt(view, "scrollX", new int[]{intValue, intValue2});
        } else {
            animator = null;
        }
        if (intValue3 != intValue4) {
            view.setScrollY(intValue3);
            objectAnimator = ObjectAnimator.ofInt(view, "scrollY", new int[]{intValue3, intValue4});
        }
        return TransitionUtils.mergeAnimators(animator, objectAnimator);
    }

    public String[] getTransitionProperties() {
        return PROPERTIES;
    }

    public ChangeScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
