package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer;
import androidx.constraintlayout.widget.ConstraintLayout;

public class VirtualLayout extends HelperWidget {
    public Measure mMeasure = new Measure();
    public int mMeasuredHeight = 0;
    public int mMeasuredWidth = 0;
    public Measurer mMeasurer = null;
    public boolean mNeedsCallFromSolver = false;
    public int mPaddingBottom = 0;
    public int mPaddingEnd = 0;
    public int mPaddingStart = 0;
    public int mPaddingTop = 0;
    public int mResolvedPaddingLeft = 0;
    public int mResolvedPaddingRight = 0;

    public void captureWidgets() {
        for (int i = 0; i < this.mWidgetsCount; i++) {
            ConstraintWidget constraintWidget = this.mWidgets[i];
            if (constraintWidget != null) {
                constraintWidget.mInVirtualLayout = true;
            }
        }
    }

    public void measure(int i, int i2, int i3, int i4) {
    }

    public void measure(ConstraintWidget constraintWidget, DimensionBehaviour dimensionBehaviour, int i, DimensionBehaviour dimensionBehaviour2, int i2) {
        while (this.mMeasurer == null) {
            ConstraintWidget constraintWidget2 = this.mParent;
            if (constraintWidget2 == null) {
                break;
            }
            this.mMeasurer = ((ConstraintWidgetContainer) constraintWidget2).mMeasurer;
        }
        Measure measure = this.mMeasure;
        measure.horizontalBehavior = dimensionBehaviour;
        measure.verticalBehavior = dimensionBehaviour2;
        measure.horizontalDimension = i;
        measure.verticalDimension = i2;
        ((ConstraintLayout.Measurer) this.mMeasurer).measure(constraintWidget, measure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        Measure measure2 = this.mMeasure;
        constraintWidget.hasBaseline = measure2.measuredHasBaseline;
        constraintWidget.setBaselineDistance(measure2.measuredBaseline);
    }

    public void updateConstraints(ConstraintWidgetContainer constraintWidgetContainer) {
        captureWidgets();
    }
}
