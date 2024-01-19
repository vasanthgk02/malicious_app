package androidx.transition;

import a.a.a.a.d.b;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;

public class Fade extends Visibility {

    public static class FadeAnimatorListener extends AnimatorListenerAdapter {
        public boolean mLayerTypeChanged = false;
        public final View mView;

        public FadeAnimatorListener(View view) {
            this.mView = view;
        }

        public void onAnimationEnd(Animator animator) {
            ViewUtils.IMPL.setTransitionAlpha(this.mView, 1.0f);
            if (this.mLayerTypeChanged) {
                this.mView.setLayerType(0, null);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (ViewCompat.hasOverlappingRendering(this.mView) && this.mView.getLayerType() == 0) {
                this.mLayerTypeChanged = true;
                this.mView.setLayerType(2, null);
            }
        }
    }

    public Fade(int i) {
        setMode(i);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
        transitionValues.values.put("android:fade:transitionAlpha", Float.valueOf(ViewUtils.getTransitionAlpha(transitionValues.view)));
    }

    public final Animator createAnimation(final View view, float f2, float f3) {
        if (f2 == f3) {
            return null;
        }
        ViewUtils.IMPL.setTransitionAlpha(view, f2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, ViewUtils.TRANSITION_ALPHA, new float[]{f3});
        ofFloat.addListener(new FadeAnimatorListener(view));
        addListener(new TransitionListenerAdapter() {
            public void onTransitionEnd(Transition transition) {
                ViewUtils.IMPL.setTransitionAlpha(view, 1.0f);
                ViewUtils.IMPL.clearNonTransitionAlpha(view);
                transition.removeListener(this);
            }
        });
        return ofFloat;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x001c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator onAppear(android.view.ViewGroup r2, android.view.View r3, androidx.transition.TransitionValues r4, androidx.transition.TransitionValues r5) {
        /*
            r1 = this;
            r2 = 0
            if (r4 == 0) goto L_0x0014
            java.util.Map<java.lang.String, java.lang.Object> r4 = r4.values
            java.lang.String r5 = "android:fade:transitionAlpha"
            java.lang.Object r4 = r4.get(r5)
            java.lang.Float r4 = (java.lang.Float) r4
            if (r4 == 0) goto L_0x0014
            float r4 = r4.floatValue()
            goto L_0x0015
        L_0x0014:
            r4 = 0
        L_0x0015:
            r5 = 1065353216(0x3f800000, float:1.0)
            int r0 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r0 != 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r2 = r4
        L_0x001d:
            android.animation.Animator r2 = r1.createAnimation(r3, r2, r5)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Fade.onAppear(android.view.ViewGroup, android.view.View, androidx.transition.TransitionValues, androidx.transition.TransitionValues):android.animation.Animator");
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ViewUtils.IMPL.saveNonTransitionAlpha(view);
        Float f2 = (Float) transitionValues.values.get("android:fade:transitionAlpha");
        return createAnimation(view, f2 != null ? f2.floatValue() : 1.0f, 0.0f);
    }

    public Fade() {
    }

    @SuppressLint({"RestrictedApi"})
    public Fade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.FADE);
        setMode(b.getNamedInt(obtainStyledAttributes, (XmlResourceParser) attributeSet, "fadingMode", 0, this.mMode));
        obtainStyledAttributes.recycle();
    }
}
