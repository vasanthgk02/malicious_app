package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;
import java.util.HashMap;

public class MotionHelper extends ConstraintHelper implements TransitionListener {
    public float mProgress;
    public boolean mUseOnHide = false;
    public boolean mUseOnShow = false;
    public View[] views;

    public MotionHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public float getProgress() {
        return this.mProgress;
    }

    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.MotionHelper);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R$styleable.MotionHelper_onShow) {
                    this.mUseOnShow = obtainStyledAttributes.getBoolean(index, this.mUseOnShow);
                } else if (index == R$styleable.MotionHelper_onHide) {
                    this.mUseOnHide = obtainStyledAttributes.getBoolean(index, this.mUseOnHide);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public boolean isDecorator() {
        return false;
    }

    public void onFinishedMotionScene() {
    }

    public void onPostDraw() {
    }

    public void onPreDraw() {
    }

    public void onPreSetup(MotionLayout motionLayout, HashMap<View, MotionController> hashMap) {
    }

    public void onTransitionChange(MotionLayout motionLayout, int i, int i2, float f2) {
    }

    public void onTransitionCompleted(MotionLayout motionLayout, int i) {
    }

    public void onTransitionStarted(MotionLayout motionLayout, int i, int i2) {
    }

    public void onTransitionTrigger(MotionLayout motionLayout, int i, boolean z, float f2) {
    }

    public void setProgress() {
    }

    public void setProgress(float f2) {
        this.mProgress = f2;
        int i = 0;
        if (this.mCount > 0) {
            this.views = getViews((ConstraintLayout) getParent());
            while (i < this.mCount) {
                View view = this.views[i];
                setProgress();
                i++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i < childCount) {
            if (!(viewGroup.getChildAt(i) instanceof MotionHelper)) {
                setProgress();
            }
            i++;
        }
    }

    public MotionHelper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }
}
