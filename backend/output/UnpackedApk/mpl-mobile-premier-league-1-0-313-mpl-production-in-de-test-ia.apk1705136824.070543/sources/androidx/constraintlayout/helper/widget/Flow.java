package androidx.constraintlayout.helper.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View.MeasureSpec;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.constraintlayout.widget.ConstraintSet.Constraint;
import androidx.constraintlayout.widget.R$styleable;
import androidx.constraintlayout.widget.VirtualLayout;

public class Flow extends VirtualLayout {
    public androidx.constraintlayout.core.widgets.Flow mFlow;

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.mFlow = new androidx.constraintlayout.core.widgets.Flow();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R$styleable.ConstraintLayout_Layout_android_orientation) {
                    this.mFlow.mOrientation = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_padding) {
                    androidx.constraintlayout.core.widgets.Flow flow = this.mFlow;
                    int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                    flow.mPaddingTop = dimensionPixelSize;
                    flow.mPaddingBottom = dimensionPixelSize;
                    flow.mPaddingStart = dimensionPixelSize;
                    flow.mPaddingEnd = dimensionPixelSize;
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingStart) {
                    androidx.constraintlayout.core.widgets.Flow flow2 = this.mFlow;
                    int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                    flow2.mPaddingStart = dimensionPixelSize2;
                    flow2.mResolvedPaddingLeft = dimensionPixelSize2;
                    flow2.mResolvedPaddingRight = dimensionPixelSize2;
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingEnd) {
                    this.mFlow.mPaddingEnd = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingLeft) {
                    this.mFlow.mResolvedPaddingLeft = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingTop) {
                    this.mFlow.mPaddingTop = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingRight) {
                    this.mFlow.mResolvedPaddingRight = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingBottom) {
                    this.mFlow.mPaddingBottom = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_wrapMode) {
                    this.mFlow.mWrapMode = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_horizontalStyle) {
                    this.mFlow.mHorizontalStyle = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_verticalStyle) {
                    this.mFlow.mVerticalStyle = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_firstHorizontalStyle) {
                    this.mFlow.mFirstHorizontalStyle = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_lastHorizontalStyle) {
                    this.mFlow.mLastHorizontalStyle = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_firstVerticalStyle) {
                    this.mFlow.mFirstVerticalStyle = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_lastVerticalStyle) {
                    this.mFlow.mLastVerticalStyle = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_horizontalBias) {
                    this.mFlow.mHorizontalBias = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_firstHorizontalBias) {
                    this.mFlow.mFirstHorizontalBias = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_lastHorizontalBias) {
                    this.mFlow.mLastHorizontalBias = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_firstVerticalBias) {
                    this.mFlow.mFirstVerticalBias = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_lastVerticalBias) {
                    this.mFlow.mLastVerticalBias = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_verticalBias) {
                    this.mFlow.mVerticalBias = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_horizontalAlign) {
                    this.mFlow.mHorizontalAlign = obtainStyledAttributes.getInt(index, 2);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_verticalAlign) {
                    this.mFlow.mVerticalAlign = obtainStyledAttributes.getInt(index, 2);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_horizontalGap) {
                    this.mFlow.mHorizontalGap = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_verticalGap) {
                    this.mFlow.mVerticalGap = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_maxElementsWrap) {
                    this.mFlow.mMaxElementsWrap = obtainStyledAttributes.getInt(index, -1);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.mHelperWidget = this.mFlow;
        validateParams();
    }

    public void loadParameters(Constraint constraint, HelperWidget helperWidget, LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        super.loadParameters(constraint, helperWidget, layoutParams, sparseArray);
        if (helperWidget instanceof androidx.constraintlayout.core.widgets.Flow) {
            androidx.constraintlayout.core.widgets.Flow flow = (androidx.constraintlayout.core.widgets.Flow) helperWidget;
            int i = layoutParams.orientation;
            if (i != -1) {
                flow.mOrientation = i;
            }
        }
    }

    @SuppressLint({"WrongCall"})
    public void onMeasure(int i, int i2) {
        onMeasure(this.mFlow, i, i2);
    }

    public void resolveRtl(ConstraintWidget constraintWidget, boolean z) {
        androidx.constraintlayout.core.widgets.Flow flow = this.mFlow;
        if (flow.mPaddingStart <= 0 && flow.mPaddingEnd <= 0) {
            return;
        }
        if (z) {
            flow.mResolvedPaddingLeft = flow.mPaddingEnd;
            flow.mResolvedPaddingRight = flow.mPaddingStart;
            return;
        }
        flow.mResolvedPaddingLeft = flow.mPaddingStart;
        flow.mResolvedPaddingRight = flow.mPaddingEnd;
    }

    public void setFirstHorizontalBias(float f2) {
        this.mFlow.mFirstHorizontalBias = f2;
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i) {
        this.mFlow.mFirstHorizontalStyle = i;
        requestLayout();
    }

    public void setFirstVerticalBias(float f2) {
        this.mFlow.mFirstVerticalBias = f2;
        requestLayout();
    }

    public void setFirstVerticalStyle(int i) {
        this.mFlow.mFirstVerticalStyle = i;
        requestLayout();
    }

    public void setHorizontalAlign(int i) {
        this.mFlow.mHorizontalAlign = i;
        requestLayout();
    }

    public void setHorizontalBias(float f2) {
        this.mFlow.mHorizontalBias = f2;
        requestLayout();
    }

    public void setHorizontalGap(int i) {
        this.mFlow.mHorizontalGap = i;
        requestLayout();
    }

    public void setHorizontalStyle(int i) {
        this.mFlow.mHorizontalStyle = i;
        requestLayout();
    }

    public void setLastHorizontalBias(float f2) {
        this.mFlow.mLastHorizontalBias = f2;
        requestLayout();
    }

    public void setLastHorizontalStyle(int i) {
        this.mFlow.mLastHorizontalStyle = i;
        requestLayout();
    }

    public void setLastVerticalBias(float f2) {
        this.mFlow.mLastVerticalBias = f2;
        requestLayout();
    }

    public void setLastVerticalStyle(int i) {
        this.mFlow.mLastVerticalStyle = i;
        requestLayout();
    }

    public void setMaxElementsWrap(int i) {
        this.mFlow.mMaxElementsWrap = i;
        requestLayout();
    }

    public void setOrientation(int i) {
        this.mFlow.mOrientation = i;
        requestLayout();
    }

    public void setPadding(int i) {
        androidx.constraintlayout.core.widgets.Flow flow = this.mFlow;
        flow.mPaddingTop = i;
        flow.mPaddingBottom = i;
        flow.mPaddingStart = i;
        flow.mPaddingEnd = i;
        requestLayout();
    }

    public void setPaddingBottom(int i) {
        this.mFlow.mPaddingBottom = i;
        requestLayout();
    }

    public void setPaddingLeft(int i) {
        this.mFlow.mResolvedPaddingLeft = i;
        requestLayout();
    }

    public void setPaddingRight(int i) {
        this.mFlow.mResolvedPaddingRight = i;
        requestLayout();
    }

    public void setPaddingTop(int i) {
        this.mFlow.mPaddingTop = i;
        requestLayout();
    }

    public void setVerticalAlign(int i) {
        this.mFlow.mVerticalAlign = i;
        requestLayout();
    }

    public void setVerticalBias(float f2) {
        this.mFlow.mVerticalBias = f2;
        requestLayout();
    }

    public void setVerticalGap(int i) {
        this.mFlow.mVerticalGap = i;
        requestLayout();
    }

    public void setVerticalStyle(int i) {
        this.mFlow.mVerticalStyle = i;
        requestLayout();
    }

    public void setWrapMode(int i) {
        this.mFlow.mWrapMode = i;
        requestLayout();
    }

    public Flow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onMeasure(androidx.constraintlayout.core.widgets.VirtualLayout virtualLayout, int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (virtualLayout != null) {
            virtualLayout.measure(mode, size, mode2, size2);
            setMeasuredDimension(virtualLayout.mMeasuredWidth, virtualLayout.mMeasuredHeight);
            return;
        }
        setMeasuredDimension(0, 0);
    }
}
