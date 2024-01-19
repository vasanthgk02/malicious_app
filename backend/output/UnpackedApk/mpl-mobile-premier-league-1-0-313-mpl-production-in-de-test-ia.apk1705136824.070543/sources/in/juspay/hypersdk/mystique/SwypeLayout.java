package in.juspay.hypersdk.mystique;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;

@Keep
public class SwypeLayout extends FrameLayout {
    public static final String TAG = "SwypeLayout";
    public static SwypeLayout activeLayout;
    public static SwypeLayout partialSwype;
    public boolean didDisplace = false;
    public int leftEdge = 0;
    public View mContent = null;
    public float mDisplaceX = 0.0f;
    public boolean mEnabled = false;
    public View mLeftOption = null;
    public View mRightOption = null;
    public float mX = 0.0f;
    public int rightEdge = 250;

    public SwypeLayout(Context context) {
        super(context);
    }

    @Keep
    public static void clear() {
        SwypeLayout swypeLayout = activeLayout;
        if (swypeLayout != null) {
            swypeLayout.reset();
            activeLayout = null;
        }
        SwypeLayout swypeLayout2 = partialSwype;
        if (swypeLayout2 != null) {
            swypeLayout2.reset();
            partialSwype = null;
        }
    }

    private void handleSwype(float f2, boolean z) {
        if (this.leftEdge != 0 || this.rightEdge != 0) {
            float f3 = (float) this.leftEdge;
            boolean z2 = false;
            float f4 = this.mDisplaceX + (f2 - this.mX);
            if (f4 < 0.0f) {
                f3 = (float) this.rightEdge;
                f4 *= -1.0f;
                z2 = true;
            }
            if (f4 > f3) {
                f4 = f3;
            }
            if (z) {
                if (((double) (f4 / f3)) <= 0.4d) {
                    f3 = 0.0f;
                }
                f4 = f3;
            }
            SwypeLayout swypeLayout = partialSwype;
            if (!(swypeLayout == null || swypeLayout == this)) {
                swypeLayout.reset();
            }
            partialSwype = this;
            if (z2) {
                f4 *= -1.0f;
            }
            float f5 = this.mDisplaceX;
            if (f5 - f4 > 20.0f || f5 - f4 < -20.0f) {
                this.didDisplace = true;
                SwypeLayout swypeLayout2 = activeLayout;
                if (!(swypeLayout2 == null || swypeLayout2 == this)) {
                    swypeLayout2.reset();
                    activeLayout = null;
                }
            }
            if (z) {
                this.mDisplaceX = f4;
                this.mContent.animate().setDuration(150).setInterpolator(new FastOutLinearInInterpolator()).translationX(f4);
                if (f4 != 0.0f) {
                    activeLayout = this;
                }
                partialSwype = null;
            } else {
                this.mContent.setTranslationX(f4);
            }
        }
    }

    private void processClick(MotionEvent motionEvent) {
        View view;
        float measuredWidth = (float) getMeasuredWidth();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        if (((float) getMeasuredHeight()) >= y && y >= 0.0f && x >= 0.0f && x <= measuredWidth) {
            float f2 = this.mDisplaceX;
            if (f2 == 0.0f) {
                view = this.mContent;
            } else if (f2 < 0.0f && x >= measuredWidth - ((float) this.rightEdge)) {
                view = this.mRightOption;
            } else if (this.mDisplaceX <= 0.0f || x > ((float) this.leftEdge)) {
                reset();
                return;
            } else {
                view = this.mLeftOption;
            }
            view.callOnClick();
        }
    }

    private boolean tagChildren() {
        if (getChildCount() != 3) {
            return false;
        }
        View childAt = getChildAt(0);
        View childAt2 = getChildAt(1);
        View childAt3 = getChildAt(2);
        if (!(childAt == this.mContent && childAt2 == this.mLeftOption && childAt3 == this.mRightOption)) {
            this.mContent = childAt;
            this.mLeftOption = childAt2;
            this.mRightOption = childAt3;
            reset();
        }
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.mEnabled;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mContent != null || tagChildren()) {
            int i5 = i3 - i;
            View view = this.mContent;
            view.layout(0, 0, view.getMeasuredWidth(), this.mContent.getMeasuredHeight());
            View view2 = this.mLeftOption;
            view2.layout(0, 0, view2.getMeasuredWidth(), this.mContent.getMeasuredHeight());
            View view3 = this.mRightOption;
            view3.layout(i5 - view3.getMeasuredWidth(), 0, i5, this.mRightOption.getMeasuredWidth());
            this.mContent.bringToFront();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mX = motionEvent.getX();
        } else if (actionMasked == 1) {
            handleSwype(motionEvent.getX(), true);
            this.mX = 0.0f;
            if (this.didDisplace) {
                this.didDisplace = false;
                return false;
            }
            processClick(motionEvent);
        } else if (actionMasked == 2) {
            handleSwype(motionEvent.getX(), false);
        }
        return true;
    }

    public void reset() {
        this.mDisplaceX = 0.0f;
        this.leftEdge = this.mLeftOption.getMeasuredWidth();
        this.rightEdge = this.mRightOption.getMeasuredWidth();
        this.mContent.setTranslationZ(2.0f);
        this.mContent.animate().setDuration(150).translationX(0.0f);
    }

    public void setSwypeEnabled(boolean z) {
        boolean z2 = this.mEnabled;
        if (z2 != z && z2) {
            reset();
        }
        this.mEnabled = z;
    }
}
