package in.juspay.hypersdk.mystique;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.annotation.Keep;

@Keep
public class AccordionLayout extends FrameLayout {
    public static final int COLLAPSE = 0;
    public static final int EXPAND = 1;
    public float alphaDelta = 1.0f;
    public int animationDuration = 300;
    public ValueAnimator animator;
    public Context context;
    public float delta = 1.0f;
    public float parallaxDelta = 0.6f;
    public int parentScrollViewId = -1;
    public boolean postLayout = false;
    public float target = 1.0f;

    public AccordionLayout(Context context2) {
        super(context2);
        this.context = context2;
    }

    public AccordionLayout(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        this.context = context2;
    }

    public AccordionLayout(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.context = context2;
    }

    public AccordionLayout(Context context2, AttributeSet attributeSet, int i, int i2) {
        super(context2, attributeSet, i, i2);
        this.context = context2;
    }

    private int getRelativeTop(View view, ScrollView scrollView) {
        ViewParent parent = view.getParent();
        return (parent == scrollView || !(parent instanceof View)) ? view.getTop() : view.getTop() + getRelativeTop((View) parent, scrollView);
    }

    /* access modifiers changed from: private */
    public void scrollParent() {
        if (this.target == 1.0f && this.parentScrollViewId != -1 && (getContext() instanceof Activity)) {
            ScrollView scrollView = (ScrollView) ((Activity) getContext()).findViewById(this.parentScrollViewId);
            if (scrollView != null) {
                int scrollY = scrollView.getScrollY();
                int height = scrollView.getHeight() + scrollY;
                int relativeTop = getRelativeTop(this, scrollView);
                int height2 = getHeight() + relativeTop;
                if (relativeTop < scrollY || height2 > height) {
                    scrollView.scrollTo(0, scrollView.getScrollY() + (relativeTop < scrollY ? relativeTop - scrollY : height2 - height));
                }
            }
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredHeight = getMeasuredHeight();
        int i3 = (int) (this.delta * ((float) measuredHeight));
        if (i3 < 0) {
            i3 = 0;
        }
        setVisibility((i3 == 0 && this.target == 0.0f) ? 8 : 0);
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            childAt.setTranslationY((float) ((int) (((float) (i3 - measuredHeight)) * this.parallaxDelta)));
            float f2 = this.alphaDelta;
            if (f2 != 0.0f) {
                childAt.setAlpha(this.delta * f2);
                if (this.target == 1.0f && this.delta == 1.0f) {
                    childAt.setAlpha(1.0f);
                }
            }
        }
        setMeasuredDimension(getMeasuredWidth(), i3);
        this.postLayout = true;
    }

    public void setDefaultExpand(boolean z) {
        float f2 = z ? 1.0f : 0.0f;
        this.target = f2;
        this.delta = f2;
        if (f2 == 0.0f) {
            setVisibility(8);
        }
    }

    public void setExpand(boolean z) {
        float f2 = z ? 1.0f : 0.0f;
        if (this.target != f2) {
            this.target = f2;
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                ValueAnimator valueAnimator = this.animator;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                if (this.target == 1.0f) {
                    setVisibility(0);
                }
                float f3 = this.target;
                float f4 = this.delta;
                int i = (int) ((f3 - f4 < 0.0f ? f4 - f3 : f3 - f4) * ((float) this.animationDuration));
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.delta, this.target});
                this.animator = ofFloat;
                ofFloat.setDuration((long) i);
                this.animator.setInterpolator(new AccelerateDecelerateInterpolator());
                this.postLayout = false;
                this.animator.addUpdateListener(new AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AccordionLayout.this.delta = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (AccordionLayout.this.postLayout) {
                            AccordionLayout.this.scrollParent();
                        }
                        AccordionLayout.this.requestLayout();
                    }
                });
                this.animator.start();
            } else if (z) {
                setVisibility(0);
                this.delta = f2;
                scrollParent();
            } else {
                setVisibility(8);
            }
        }
    }

    public void setExpandAlpha(float f2) {
        this.alphaDelta = f2;
    }

    public void setExpandDuration(int i) {
        this.animationDuration = i;
    }

    public void setExpandParallax(float f2) {
        this.parallaxDelta = f2;
    }

    public void setScrollParent(int i) {
        this.parentScrollViewId = i;
    }
}
