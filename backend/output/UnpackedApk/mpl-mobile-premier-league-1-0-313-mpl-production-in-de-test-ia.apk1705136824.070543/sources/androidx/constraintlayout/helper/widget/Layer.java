package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.constraintlayout.widget.R$styleable;

public class Layer extends ConstraintHelper {
    public boolean mApplyElevationOnAttach;
    public boolean mApplyVisibilityOnAttach;
    public float mComputedCenterX = Float.NaN;
    public float mComputedCenterY = Float.NaN;
    public float mComputedMaxX = Float.NaN;
    public float mComputedMaxY = Float.NaN;
    public float mComputedMinX = Float.NaN;
    public float mComputedMinY = Float.NaN;
    public ConstraintLayout mContainer;
    public float mGroupRotateAngle = Float.NaN;
    public boolean mNeedBounds = true;
    public float mRotationCenterX = Float.NaN;
    public float mRotationCenterY = Float.NaN;
    public float mScaleX = 1.0f;
    public float mScaleY = 1.0f;
    public float mShiftX = 0.0f;
    public float mShiftY = 0.0f;
    public View[] mViews = null;

    public Layer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void applyLayoutFeaturesInConstraintSet(ConstraintLayout constraintLayout) {
        applyLayoutFeatures(constraintLayout);
    }

    public void calcCenters() {
        if (this.mContainer != null) {
            if (this.mNeedBounds || Float.isNaN(this.mComputedCenterX) || Float.isNaN(this.mComputedCenterY)) {
                if (Float.isNaN(this.mRotationCenterX) || Float.isNaN(this.mRotationCenterY)) {
                    View[] views = getViews(this.mContainer);
                    int left = views[0].getLeft();
                    int top = views[0].getTop();
                    int right = views[0].getRight();
                    int bottom = views[0].getBottom();
                    for (int i = 0; i < this.mCount; i++) {
                        View view = views[i];
                        left = Math.min(left, view.getLeft());
                        top = Math.min(top, view.getTop());
                        right = Math.max(right, view.getRight());
                        bottom = Math.max(bottom, view.getBottom());
                    }
                    this.mComputedMaxX = (float) right;
                    this.mComputedMaxY = (float) bottom;
                    this.mComputedMinX = (float) left;
                    this.mComputedMinY = (float) top;
                    if (Float.isNaN(this.mRotationCenterX)) {
                        this.mComputedCenterX = (float) ((left + right) / 2);
                    } else {
                        this.mComputedCenterX = this.mRotationCenterX;
                    }
                    if (Float.isNaN(this.mRotationCenterY)) {
                        this.mComputedCenterY = (float) ((top + bottom) / 2);
                    } else {
                        this.mComputedCenterY = this.mRotationCenterY;
                    }
                } else {
                    this.mComputedCenterY = this.mRotationCenterY;
                    this.mComputedCenterX = this.mRotationCenterX;
                }
            }
        }
    }

    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.mUseViewMeasure = false;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R$styleable.ConstraintLayout_Layout_android_visibility) {
                    this.mApplyVisibilityOnAttach = true;
                } else if (index == R$styleable.ConstraintLayout_Layout_android_elevation) {
                    this.mApplyElevationOnAttach = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mContainer = (ConstraintLayout) getParent();
        if (this.mApplyVisibilityOnAttach || this.mApplyElevationOnAttach) {
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i = 0; i < this.mCount; i++) {
                View viewById = this.mContainer.getViewById(this.mIds[i]);
                if (viewById != null) {
                    if (this.mApplyVisibilityOnAttach) {
                        viewById.setVisibility(visibility);
                    }
                    if (this.mApplyElevationOnAttach && elevation > 0.0f) {
                        viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    public final void reCacheViews() {
        if (this.mContainer != null) {
            int i = this.mCount;
            if (i != 0) {
                View[] viewArr = this.mViews;
                if (viewArr == null || viewArr.length != i) {
                    this.mViews = new View[this.mCount];
                }
                for (int i2 = 0; i2 < this.mCount; i2++) {
                    this.mViews[i2] = this.mContainer.getViewById(this.mIds[i2]);
                }
            }
        }
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        applyLayoutFeatures();
    }

    public void setPivotX(float f2) {
        this.mRotationCenterX = f2;
        transform();
    }

    public void setPivotY(float f2) {
        this.mRotationCenterY = f2;
        transform();
    }

    public void setRotation(float f2) {
        this.mGroupRotateAngle = f2;
        transform();
    }

    public void setScaleX(float f2) {
        this.mScaleX = f2;
        transform();
    }

    public void setScaleY(float f2) {
        this.mScaleY = f2;
        transform();
    }

    public void setTranslationX(float f2) {
        this.mShiftX = f2;
        transform();
    }

    public void setTranslationY(float f2) {
        this.mShiftY = f2;
        transform();
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        applyLayoutFeatures();
    }

    public final void transform() {
        if (this.mContainer != null) {
            if (this.mViews == null) {
                reCacheViews();
            }
            calcCenters();
            double radians = Float.isNaN(this.mGroupRotateAngle) ? 0.0d : Math.toRadians((double) this.mGroupRotateAngle);
            float sin = (float) Math.sin(radians);
            float cos = (float) Math.cos(radians);
            float f2 = this.mScaleX;
            float f3 = f2 * cos;
            float f4 = this.mScaleY;
            float f5 = (-f4) * sin;
            float f6 = f2 * sin;
            float f7 = f4 * cos;
            for (int i = 0; i < this.mCount; i++) {
                View view = this.mViews[i];
                int left = view.getLeft();
                int top = view.getTop();
                float right = ((float) ((view.getRight() + left) / 2)) - this.mComputedCenterX;
                float bottom = ((float) ((view.getBottom() + top) / 2)) - this.mComputedCenterY;
                view.setTranslationX((((f5 * bottom) + (f3 * right)) - right) + this.mShiftX);
                view.setTranslationY((((f7 * bottom) + (right * f6)) - bottom) + this.mShiftY);
                view.setScaleY(this.mScaleY);
                view.setScaleX(this.mScaleX);
                if (!Float.isNaN(this.mGroupRotateAngle)) {
                    view.setRotation(this.mGroupRotateAngle);
                }
            }
        }
    }

    public void updatePostLayout(ConstraintLayout constraintLayout) {
        reCacheViews();
        this.mComputedCenterX = Float.NaN;
        this.mComputedCenterY = Float.NaN;
        ConstraintWidget constraintWidget = ((LayoutParams) getLayoutParams()).widget;
        constraintWidget.setWidth(0);
        constraintWidget.setHeight(0);
        calcCenters();
        layout(((int) this.mComputedMinX) - getPaddingLeft(), ((int) this.mComputedMinY) - getPaddingTop(), getPaddingRight() + ((int) this.mComputedMaxX), getPaddingBottom() + ((int) this.mComputedMaxY));
        transform();
    }

    public void updatePreDraw(ConstraintLayout constraintLayout) {
        this.mContainer = constraintLayout;
        float rotation = getRotation();
        if (rotation != 0.0f) {
            this.mGroupRotateAngle = rotation;
        } else if (!Float.isNaN(this.mGroupRotateAngle)) {
            this.mGroupRotateAngle = rotation;
        }
    }

    public Layer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
