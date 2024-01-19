package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintAnchor.Type;

public class Placeholder extends VirtualLayout {
    public void addToSolver(LinearSystem linearSystem, boolean z) {
        super.addToSolver(linearSystem, z);
        if (this.mWidgetsCount > 0) {
            ConstraintWidget constraintWidget = this.mWidgets[0];
            constraintWidget.resetAnchors();
            constraintWidget.mVerticalBiasPercent = 0.5f;
            constraintWidget.mHorizontalBiasPercent = 0.5f;
            Type type = Type.LEFT;
            constraintWidget.connect(type, this, type, 0);
            Type type2 = Type.RIGHT;
            constraintWidget.connect(type2, this, type2, 0);
            Type type3 = Type.TOP;
            constraintWidget.connect(type3, this, type3, 0);
            Type type4 = Type.BOTTOM;
            constraintWidget.connect(type4, this, type4, 0);
        }
    }

    public void measure(int i, int i2, int i3, int i4) {
        boolean z = false;
        int i5 = this.mResolvedPaddingLeft + this.mResolvedPaddingRight + 0;
        int i6 = this.mPaddingTop + this.mPaddingBottom + 0;
        if (this.mWidgetsCount > 0) {
            i5 += this.mWidgets[0].getWidth();
            i6 += this.mWidgets[0].getHeight();
        }
        int max = Math.max(this.mMinWidth, i5);
        int max2 = Math.max(this.mMinHeight, i6);
        if (i != 1073741824) {
            i2 = i == Integer.MIN_VALUE ? Math.min(max, i2) : i == 0 ? max : 0;
        }
        if (i3 != 1073741824) {
            i4 = i3 == Integer.MIN_VALUE ? Math.min(max2, i4) : i3 == 0 ? max2 : 0;
        }
        this.mMeasuredWidth = i2;
        this.mMeasuredHeight = i4;
        setWidth(i2);
        setHeight(i4);
        if (this.mWidgetsCount > 0) {
            z = true;
        }
        this.mNeedsCallFromSolver = z;
    }
}
