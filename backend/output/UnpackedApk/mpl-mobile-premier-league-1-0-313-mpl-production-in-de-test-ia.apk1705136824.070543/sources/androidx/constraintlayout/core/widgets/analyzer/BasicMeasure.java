package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;

public class BasicMeasure {
    public ConstraintWidgetContainer constraintWidgetContainer;
    public Measure mMeasure = new Measure();
    public final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList<>();

    public static class Measure {
        public DimensionBehaviour horizontalBehavior;
        public int horizontalDimension;
        public int measureStrategy;
        public int measuredBaseline;
        public boolean measuredHasBaseline;
        public int measuredHeight;
        public boolean measuredNeedsSolverPass;
        public int measuredWidth;
        public DimensionBehaviour verticalBehavior;
        public int verticalDimension;
    }

    public interface Measurer {
    }

    public BasicMeasure(ConstraintWidgetContainer constraintWidgetContainer2) {
        this.constraintWidgetContainer = constraintWidgetContainer2;
    }

    public final boolean measure(Measurer measurer, ConstraintWidget constraintWidget, int i) {
        this.mMeasure.horizontalBehavior = constraintWidget.getHorizontalDimensionBehaviour();
        this.mMeasure.verticalBehavior = constraintWidget.getVerticalDimensionBehaviour();
        this.mMeasure.horizontalDimension = constraintWidget.getWidth();
        this.mMeasure.verticalDimension = constraintWidget.getHeight();
        Measure measure = this.mMeasure;
        measure.measuredNeedsSolverPass = false;
        measure.measureStrategy = i;
        boolean z = measure.horizontalBehavior == DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z2 = this.mMeasure.verticalBehavior == DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z3 = z && constraintWidget.mDimensionRatio > 0.0f;
        boolean z4 = z2 && constraintWidget.mDimensionRatio > 0.0f;
        if (z3 && constraintWidget.mResolvedMatchConstraintDefault[0] == 4) {
            this.mMeasure.horizontalBehavior = DimensionBehaviour.FIXED;
        }
        if (z4 && constraintWidget.mResolvedMatchConstraintDefault[1] == 4) {
            this.mMeasure.verticalBehavior = DimensionBehaviour.FIXED;
        }
        ((androidx.constraintlayout.widget.ConstraintLayout.Measurer) measurer).measure(constraintWidget, this.mMeasure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        Measure measure2 = this.mMeasure;
        constraintWidget.hasBaseline = measure2.measuredHasBaseline;
        constraintWidget.setBaselineDistance(measure2.measuredBaseline);
        Measure measure3 = this.mMeasure;
        measure3.measureStrategy = 0;
        return measure3.measuredNeedsSolverPass;
    }

    public final void solveLinearSystem(ConstraintWidgetContainer constraintWidgetContainer2, int i, int i2, int i3) {
        int i4 = constraintWidgetContainer2.mMinWidth;
        int i5 = constraintWidgetContainer2.mMinHeight;
        constraintWidgetContainer2.setMinWidth(0);
        constraintWidgetContainer2.setMinHeight(0);
        constraintWidgetContainer2.mWidth = i2;
        int i6 = constraintWidgetContainer2.mMinWidth;
        if (i2 < i6) {
            constraintWidgetContainer2.mWidth = i6;
        }
        constraintWidgetContainer2.mHeight = i3;
        int i7 = constraintWidgetContainer2.mMinHeight;
        if (i3 < i7) {
            constraintWidgetContainer2.mHeight = i7;
        }
        constraintWidgetContainer2.setMinWidth(i4);
        constraintWidgetContainer2.setMinHeight(i5);
        ConstraintWidgetContainer constraintWidgetContainer3 = this.constraintWidgetContainer;
        constraintWidgetContainer3.pass = i;
        constraintWidgetContainer3.layout();
    }

    public void updateHierarchy(ConstraintWidgetContainer constraintWidgetContainer2) {
        this.mVariableDimensionsWidgets.clear();
        int size = constraintWidgetContainer2.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = constraintWidgetContainer2.mChildren.get(i);
            if (constraintWidget.getHorizontalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.getVerticalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT) {
                this.mVariableDimensionsWidgets.add(constraintWidget);
            }
        }
        constraintWidgetContainer2.invalidateGraph();
    }
}
