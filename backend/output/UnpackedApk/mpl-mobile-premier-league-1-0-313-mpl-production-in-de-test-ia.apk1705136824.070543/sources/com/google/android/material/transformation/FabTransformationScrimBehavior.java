package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {
    public final MotionTiming collapseTiming = new MotionTiming(0, 150);
    public final MotionTiming expandTiming = new MotionTiming(75, 150);

    public FabTransformationScrimBehavior() {
    }

    public final void createScrimAnimation(View view, boolean z, boolean z2, List list) {
        ObjectAnimator objectAnimator;
        MotionTiming motionTiming = z ? this.expandTiming : this.collapseTiming;
        if (z) {
            if (!z2) {
                view.setAlpha(0.0f);
            }
            objectAnimator = ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{1.0f});
        } else {
            objectAnimator = ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{0.0f});
        }
        motionTiming.apply(objectAnimator);
        list.add(objectAnimator);
    }

    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 instanceof FloatingActionButton;
    }

    public AnimatorSet onCreateExpandedStateChangeAnimation(View view, final View view2, final boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        new ArrayList();
        createScrimAnimation(view2, z, z2, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        ImageOriginUtils.playTogether(animatorSet, arrayList);
        animatorSet.addListener(new AnimatorListenerAdapter(this) {
            public void onAnimationEnd(Animator animator) {
                if (!z) {
                    view2.setVisibility(4);
                }
            }

            public void onAnimationStart(Animator animator) {
                if (z) {
                    view2.setVisibility(0);
                }
            }
        });
        return animatorSet;
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        return false;
    }

    public FabTransformationScrimBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
