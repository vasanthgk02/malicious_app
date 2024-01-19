package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer;

public class Direct {
    public static int hcount;
    public static Measure measure = new Measure();
    public static int vcount;

    public static boolean canMeasure(int i, ConstraintWidget constraintWidget) {
        DimensionBehaviour horizontalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
        DimensionBehaviour verticalDimensionBehaviour = constraintWidget.getVerticalDimensionBehaviour();
        ConstraintWidget constraintWidget2 = constraintWidget.mParent;
        ConstraintWidgetContainer constraintWidgetContainer = constraintWidget2 != null ? (ConstraintWidgetContainer) constraintWidget2 : null;
        if (constraintWidgetContainer != null) {
            DimensionBehaviour horizontalDimensionBehaviour2 = constraintWidgetContainer.getHorizontalDimensionBehaviour();
            DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        }
        if (constraintWidgetContainer != null) {
            DimensionBehaviour verticalDimensionBehaviour2 = constraintWidgetContainer.getVerticalDimensionBehaviour();
            DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.FIXED;
        }
        boolean z = false;
        boolean z2 = horizontalDimensionBehaviour == DimensionBehaviour.FIXED || constraintWidget.isResolvedHorizontally() || horizontalDimensionBehaviour == DimensionBehaviour.WRAP_CONTENT || (horizontalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultWidth == 0 && constraintWidget.mDimensionRatio == 0.0f && constraintWidget.hasDanglingDimension(0)) || (horizontalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultWidth == 1 && constraintWidget.hasResolvedTargets(0, constraintWidget.getWidth()));
        boolean z3 = verticalDimensionBehaviour == DimensionBehaviour.FIXED || constraintWidget.isResolvedVertically() || verticalDimensionBehaviour == DimensionBehaviour.WRAP_CONTENT || (verticalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultHeight == 0 && constraintWidget.mDimensionRatio == 0.0f && constraintWidget.hasDanglingDimension(1)) || (horizontalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultHeight == 1 && constraintWidget.hasResolvedTargets(1, constraintWidget.getHeight()));
        if (constraintWidget.mDimensionRatio > 0.0f && (z2 || z3)) {
            return true;
        }
        if (z2 && z3) {
            z = true;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x016e, code lost:
        if (r12.mHasFinalValue != false) goto L_0x017e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x017c, code lost:
        if (r12.mHasFinalValue != false) goto L_0x017e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x017e, code lost:
        r12 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b2, code lost:
        if (r5.mHasFinalValue != false) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00c0, code lost:
        if (r5.mHasFinalValue != false) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00c2, code lost:
        r5 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void horizontalSolvingPass(int r16, androidx.constraintlayout.core.widgets.ConstraintWidget r17, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer r18, boolean r19) {
        /*
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r0.horizontalSolvingPass
            if (r3 == 0) goto L_0x000b
            return
        L_0x000b:
            int r3 = hcount
            r4 = 1
            int r3 = r3 + r4
            hcount = r3
            boolean r3 = r0 instanceof androidx.constraintlayout.core.widgets.ConstraintWidgetContainer
            r5 = 0
            if (r3 != 0) goto L_0x002c
            boolean r3 = r17.isMeasureRequested()
            if (r3 == 0) goto L_0x002c
            int r3 = r16 + 1
            boolean r6 = canMeasure(r3, r0)
            if (r6 == 0) goto L_0x002c
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r6 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r6.<init>()
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.measure(r3, r0, r1, r6, r5)
        L_0x002c:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r0.getAnchor(r3)
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r0.getAnchor(r6)
            int r7 = r3.getFinalValue()
            int r8 = r6.getFinalValue()
            java.util.HashSet<androidx.constraintlayout.core.widgets.ConstraintAnchor> r9 = r3.mDependents
            r10 = 0
            r11 = 8
            if (r9 == 0) goto L_0x012a
            boolean r3 = r3.mHasFinalValue
            if (r3 == 0) goto L_0x012a
            java.util.Iterator r3 = r9.iterator()
        L_0x004f:
            boolean r9 = r3.hasNext()
            if (r9 == 0) goto L_0x012a
            java.lang.Object r9 = r3.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r9
            androidx.constraintlayout.core.widgets.ConstraintWidget r12 = r9.mOwner
            int r13 = r16 + 1
            boolean r14 = canMeasure(r13, r12)
            boolean r15 = r12.isMeasureRequested()
            if (r15 == 0) goto L_0x0073
            if (r14 == 0) goto L_0x0073
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r15 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r15.<init>()
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.measure(r13, r12, r1, r15, r5)
        L_0x0073:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r15 = r12.getHorizontalDimensionBehaviour()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r15 != r5) goto L_0x00d1
            if (r14 == 0) goto L_0x007e
            goto L_0x00d1
        L_0x007e:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = r12.getHorizontalDimensionBehaviour()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 != r14) goto L_0x0127
            int r5 = r12.mMatchConstraintMaxWidth
            if (r5 < 0) goto L_0x0127
            int r5 = r12.mMatchConstraintMinWidth
            if (r5 < 0) goto L_0x0127
            int r5 = r12.mVisibility
            if (r5 == r11) goto L_0x009c
            int r5 = r12.mMatchConstraintDefaultWidth
            if (r5 != 0) goto L_0x0127
            float r5 = r12.mDimensionRatio
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 != 0) goto L_0x0127
        L_0x009c:
            boolean r5 = r12.isInHorizontalChain()
            if (r5 != 0) goto L_0x0127
            boolean r5 = r12.mInVirtualLayout
            if (r5 != 0) goto L_0x0127
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r12.mLeft
            if (r9 != r5) goto L_0x00b4
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r12.mRight
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 == 0) goto L_0x00b4
            boolean r5 = r5.mHasFinalValue
            if (r5 != 0) goto L_0x00c2
        L_0x00b4:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r12.mRight
            if (r9 != r5) goto L_0x00c4
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r12.mLeft
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 == 0) goto L_0x00c4
            boolean r5 = r5.mHasFinalValue
            if (r5 == 0) goto L_0x00c4
        L_0x00c2:
            r5 = 1
            goto L_0x00c5
        L_0x00c4:
            r5 = 0
        L_0x00c5:
            if (r5 == 0) goto L_0x0127
            boolean r5 = r12.isInHorizontalChain()
            if (r5 != 0) goto L_0x0127
            solveHorizontalMatchConstraint(r13, r0, r1, r12, r2)
            goto L_0x0127
        L_0x00d1:
            boolean r5 = r12.isMeasureRequested()
            if (r5 == 0) goto L_0x00d8
            goto L_0x0127
        L_0x00d8:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r12.mLeft
            if (r9 != r5) goto L_0x00f3
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r12.mRight
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r14.mTarget
            if (r14 != 0) goto L_0x00f3
            int r5 = r5.getMargin()
            int r5 = r5 + r7
            int r9 = r12.getWidth()
            int r9 = r9 + r5
            r12.setFinalHorizontal(r5, r9)
            horizontalSolvingPass(r13, r12, r1, r2)
            goto L_0x0127
        L_0x00f3:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r12.mRight
            if (r9 != r5) goto L_0x0110
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r12.mLeft
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r14.mTarget
            if (r14 != 0) goto L_0x0110
            int r5 = r5.getMargin()
            int r5 = r7 - r5
            int r9 = r12.getWidth()
            int r9 = r5 - r9
            r12.setFinalHorizontal(r9, r5)
            horizontalSolvingPass(r13, r12, r1, r2)
            goto L_0x0127
        L_0x0110:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r12.mLeft
            if (r9 != r5) goto L_0x0127
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r12.mRight
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 == 0) goto L_0x0127
            boolean r5 = r5.mHasFinalValue
            if (r5 == 0) goto L_0x0127
            boolean r5 = r12.isInHorizontalChain()
            if (r5 != 0) goto L_0x0127
            solveHorizontalCenterConstraints(r13, r1, r12, r2)
        L_0x0127:
            r5 = 0
            goto L_0x004f
        L_0x012a:
            boolean r3 = r0 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r3 == 0) goto L_0x012f
            return
        L_0x012f:
            java.util.HashSet<androidx.constraintlayout.core.widgets.ConstraintAnchor> r3 = r6.mDependents
            if (r3 == 0) goto L_0x0210
            boolean r5 = r6.mHasFinalValue
            if (r5 == 0) goto L_0x0210
            java.util.Iterator r3 = r3.iterator()
        L_0x013b:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0210
            java.lang.Object r5 = r3.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r5.mOwner
            int r7 = r16 + 1
            boolean r9 = canMeasure(r7, r6)
            boolean r12 = r6.isMeasureRequested()
            if (r12 == 0) goto L_0x0161
            if (r9 == 0) goto L_0x0161
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r12 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r12.<init>()
            r13 = 0
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.measure(r7, r6, r1, r12, r13)
            goto L_0x0162
        L_0x0161:
            r13 = 0
        L_0x0162:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r6.mLeft
            if (r5 != r12) goto L_0x0170
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r6.mRight
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r12.mTarget
            if (r12 == 0) goto L_0x0170
            boolean r12 = r12.mHasFinalValue
            if (r12 != 0) goto L_0x017e
        L_0x0170:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r6.mRight
            if (r5 != r12) goto L_0x0180
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r6.mLeft
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r12.mTarget
            if (r12 == 0) goto L_0x0180
            boolean r12 = r12.mHasFinalValue
            if (r12 == 0) goto L_0x0180
        L_0x017e:
            r12 = 1
            goto L_0x0181
        L_0x0180:
            r12 = 0
        L_0x0181:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r14 = r6.getHorizontalDimensionBehaviour()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r14 != r15) goto L_0x01c1
            if (r9 == 0) goto L_0x018c
            goto L_0x01c1
        L_0x018c:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = r6.getHorizontalDimensionBehaviour()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 != r9) goto L_0x013b
            int r5 = r6.mMatchConstraintMaxWidth
            if (r5 < 0) goto L_0x013b
            int r5 = r6.mMatchConstraintMinWidth
            if (r5 < 0) goto L_0x013b
            int r5 = r6.mVisibility
            if (r5 == r11) goto L_0x01aa
            int r5 = r6.mMatchConstraintDefaultWidth
            if (r5 != 0) goto L_0x013b
            float r5 = r6.mDimensionRatio
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 != 0) goto L_0x013b
        L_0x01aa:
            boolean r5 = r6.isInHorizontalChain()
            if (r5 != 0) goto L_0x013b
            boolean r5 = r6.mInVirtualLayout
            if (r5 != 0) goto L_0x013b
            if (r12 == 0) goto L_0x013b
            boolean r5 = r6.isInHorizontalChain()
            if (r5 != 0) goto L_0x013b
            solveHorizontalMatchConstraint(r7, r0, r1, r6, r2)
            goto L_0x013b
        L_0x01c1:
            boolean r9 = r6.isMeasureRequested()
            if (r9 == 0) goto L_0x01c9
            goto L_0x013b
        L_0x01c9:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r6.mLeft
            if (r5 != r9) goto L_0x01e5
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r6.mRight
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r14.mTarget
            if (r14 != 0) goto L_0x01e5
            int r5 = r9.getMargin()
            int r5 = r5 + r8
            int r9 = r6.getWidth()
            int r9 = r9 + r5
            r6.setFinalHorizontal(r5, r9)
            horizontalSolvingPass(r7, r6, r1, r2)
            goto L_0x013b
        L_0x01e5:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r6.mRight
            if (r5 != r9) goto L_0x0203
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r6.mLeft
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 != 0) goto L_0x0203
            int r5 = r9.getMargin()
            int r5 = r8 - r5
            int r9 = r6.getWidth()
            int r9 = r5 - r9
            r6.setFinalHorizontal(r9, r5)
            horizontalSolvingPass(r7, r6, r1, r2)
            goto L_0x013b
        L_0x0203:
            if (r12 == 0) goto L_0x013b
            boolean r5 = r6.isInHorizontalChain()
            if (r5 != 0) goto L_0x013b
            solveHorizontalCenterConstraints(r7, r1, r6, r2)
            goto L_0x013b
        L_0x0210:
            r0.horizontalSolvingPass = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.Direct.horizontalSolvingPass(int, androidx.constraintlayout.core.widgets.ConstraintWidget, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer, boolean):void");
    }

    public static void solveHorizontalCenterConstraints(int i, Measurer measurer, ConstraintWidget constraintWidget, boolean z) {
        float f2 = constraintWidget.mHorizontalBiasPercent;
        int finalValue = constraintWidget.mLeft.mTarget.getFinalValue();
        int finalValue2 = constraintWidget.mRight.mTarget.getFinalValue();
        int margin = constraintWidget.mLeft.getMargin() + finalValue;
        int margin2 = finalValue2 - constraintWidget.mRight.getMargin();
        if (finalValue == finalValue2) {
            f2 = 0.5f;
        } else {
            finalValue = margin;
            finalValue2 = margin2;
        }
        int width = constraintWidget.getWidth();
        int i2 = (finalValue2 - finalValue) - width;
        if (finalValue > finalValue2) {
            i2 = (finalValue - finalValue2) - width;
        }
        int i3 = ((int) (i2 > 0 ? (f2 * ((float) i2)) + 0.5f : f2 * ((float) i2))) + finalValue;
        int i4 = i3 + width;
        if (finalValue > finalValue2) {
            i4 = i3 - width;
        }
        constraintWidget.setFinalHorizontal(i3, i4);
        horizontalSolvingPass(i + 1, constraintWidget, measurer, z);
    }

    public static void solveHorizontalMatchConstraint(int i, ConstraintWidget constraintWidget, Measurer measurer, ConstraintWidget constraintWidget2, boolean z) {
        int i2;
        float f2 = constraintWidget2.mHorizontalBiasPercent;
        int margin = constraintWidget2.mLeft.getMargin() + constraintWidget2.mLeft.mTarget.getFinalValue();
        int finalValue = constraintWidget2.mRight.mTarget.getFinalValue() - constraintWidget2.mRight.getMargin();
        if (finalValue >= margin) {
            int width = constraintWidget2.getWidth();
            if (constraintWidget2.mVisibility != 8) {
                int i3 = constraintWidget2.mMatchConstraintDefaultWidth;
                if (i3 == 2) {
                    if (constraintWidget instanceof ConstraintWidgetContainer) {
                        i2 = constraintWidget.getWidth();
                    } else {
                        i2 = constraintWidget.mParent.getWidth();
                    }
                    width = (int) (constraintWidget2.mHorizontalBiasPercent * 0.5f * ((float) i2));
                } else if (i3 == 0) {
                    width = finalValue - margin;
                }
                width = Math.max(constraintWidget2.mMatchConstraintMinWidth, width);
                int i4 = constraintWidget2.mMatchConstraintMaxWidth;
                if (i4 > 0) {
                    width = Math.min(i4, width);
                }
            }
            int i5 = margin + ((int) ((f2 * ((float) ((finalValue - margin) - width))) + 0.5f));
            constraintWidget2.setFinalHorizontal(i5, width + i5);
            horizontalSolvingPass(i + 1, constraintWidget2, measurer, z);
        }
    }

    public static void solveVerticalCenterConstraints(int i, Measurer measurer, ConstraintWidget constraintWidget) {
        float f2 = constraintWidget.mVerticalBiasPercent;
        int finalValue = constraintWidget.mTop.mTarget.getFinalValue();
        int finalValue2 = constraintWidget.mBottom.mTarget.getFinalValue();
        int margin = constraintWidget.mTop.getMargin() + finalValue;
        int margin2 = finalValue2 - constraintWidget.mBottom.getMargin();
        if (finalValue == finalValue2) {
            f2 = 0.5f;
        } else {
            finalValue = margin;
            finalValue2 = margin2;
        }
        int height = constraintWidget.getHeight();
        int i2 = (finalValue2 - finalValue) - height;
        if (finalValue > finalValue2) {
            i2 = (finalValue - finalValue2) - height;
        }
        int i3 = (int) (i2 > 0 ? (f2 * ((float) i2)) + 0.5f : f2 * ((float) i2));
        int i4 = finalValue + i3;
        int i5 = i4 + height;
        if (finalValue > finalValue2) {
            i4 = finalValue - i3;
            i5 = i4 - height;
        }
        constraintWidget.setFinalVertical(i4, i5);
        verticalSolvingPass(i + 1, constraintWidget, measurer);
    }

    public static void solveVerticalMatchConstraint(int i, ConstraintWidget constraintWidget, Measurer measurer, ConstraintWidget constraintWidget2) {
        int i2;
        float f2 = constraintWidget2.mVerticalBiasPercent;
        int margin = constraintWidget2.mTop.getMargin() + constraintWidget2.mTop.mTarget.getFinalValue();
        int finalValue = constraintWidget2.mBottom.mTarget.getFinalValue() - constraintWidget2.mBottom.getMargin();
        if (finalValue >= margin) {
            int height = constraintWidget2.getHeight();
            if (constraintWidget2.mVisibility != 8) {
                int i3 = constraintWidget2.mMatchConstraintDefaultHeight;
                if (i3 == 2) {
                    if (constraintWidget instanceof ConstraintWidgetContainer) {
                        i2 = constraintWidget.getHeight();
                    } else {
                        i2 = constraintWidget.mParent.getHeight();
                    }
                    height = (int) (f2 * 0.5f * ((float) i2));
                } else if (i3 == 0) {
                    height = finalValue - margin;
                }
                height = Math.max(constraintWidget2.mMatchConstraintMinHeight, height);
                int i4 = constraintWidget2.mMatchConstraintMaxHeight;
                if (i4 > 0) {
                    height = Math.min(i4, height);
                }
            }
            int i5 = margin + ((int) ((f2 * ((float) ((finalValue - margin) - height))) + 0.5f));
            constraintWidget2.setFinalVertical(i5, height + i5);
            verticalSolvingPass(i + 1, constraintWidget2, measurer);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0172, code lost:
        if (r12.mHasFinalValue != false) goto L_0x0174;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0174, code lost:
        r12 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b0, code lost:
        if (r13.mHasFinalValue != false) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00be, code lost:
        if (r8.mHasFinalValue != false) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00c0, code lost:
        r8 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0164, code lost:
        if (r12.mHasFinalValue != false) goto L_0x0174;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void verticalSolvingPass(int r16, androidx.constraintlayout.core.widgets.ConstraintWidget r17, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer r18) {
        /*
            r0 = r17
            r1 = r18
            boolean r2 = r0.verticalSolvingPass
            if (r2 == 0) goto L_0x0009
            return
        L_0x0009:
            int r2 = vcount
            r3 = 1
            int r2 = r2 + r3
            vcount = r2
            boolean r2 = r0 instanceof androidx.constraintlayout.core.widgets.ConstraintWidgetContainer
            r4 = 0
            if (r2 != 0) goto L_0x002a
            boolean r2 = r17.isMeasureRequested()
            if (r2 == 0) goto L_0x002a
            int r2 = r16 + 1
            boolean r5 = canMeasure(r2, r0)
            if (r5 == 0) goto L_0x002a
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r5 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r5.<init>()
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.measure(r2, r0, r1, r5, r4)
        L_0x002a:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r0.getAnchor(r2)
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r0.getAnchor(r5)
            int r6 = r2.getFinalValue()
            int r7 = r5.getFinalValue()
            java.util.HashSet<androidx.constraintlayout.core.widgets.ConstraintAnchor> r8 = r2.mDependents
            r9 = 0
            r10 = 8
            if (r8 == 0) goto L_0x0123
            boolean r2 = r2.mHasFinalValue
            if (r2 == 0) goto L_0x0123
            java.util.Iterator r2 = r8.iterator()
        L_0x004d:
            boolean r8 = r2.hasNext()
            if (r8 == 0) goto L_0x0123
            java.lang.Object r8 = r2.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r8
            androidx.constraintlayout.core.widgets.ConstraintWidget r11 = r8.mOwner
            int r12 = r16 + 1
            boolean r13 = canMeasure(r12, r11)
            boolean r14 = r11.isMeasureRequested()
            if (r14 == 0) goto L_0x0071
            if (r13 == 0) goto L_0x0071
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r14 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r14.<init>()
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.measure(r12, r11, r1, r14, r4)
        L_0x0071:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r14 = r11.getVerticalDimensionBehaviour()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r14 != r15) goto L_0x00d0
            if (r13 == 0) goto L_0x007c
            goto L_0x00d0
        L_0x007c:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = r11.getVerticalDimensionBehaviour()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r13 != r14) goto L_0x004d
            int r13 = r11.mMatchConstraintMaxHeight
            if (r13 < 0) goto L_0x004d
            int r13 = r11.mMatchConstraintMinHeight
            if (r13 < 0) goto L_0x004d
            int r13 = r11.mVisibility
            if (r13 == r10) goto L_0x009a
            int r13 = r11.mMatchConstraintDefaultHeight
            if (r13 != 0) goto L_0x004d
            float r13 = r11.mDimensionRatio
            int r13 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
            if (r13 != 0) goto L_0x004d
        L_0x009a:
            boolean r13 = r11.isInVerticalChain()
            if (r13 != 0) goto L_0x004d
            boolean r13 = r11.mInVirtualLayout
            if (r13 != 0) goto L_0x004d
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r11.mTop
            if (r8 != r13) goto L_0x00b2
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r11.mBottom
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r13.mTarget
            if (r13 == 0) goto L_0x00b2
            boolean r13 = r13.mHasFinalValue
            if (r13 != 0) goto L_0x00c0
        L_0x00b2:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r11.mBottom
            if (r8 != r13) goto L_0x00c2
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r11.mTop
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r8.mTarget
            if (r8 == 0) goto L_0x00c2
            boolean r8 = r8.mHasFinalValue
            if (r8 == 0) goto L_0x00c2
        L_0x00c0:
            r8 = 1
            goto L_0x00c3
        L_0x00c2:
            r8 = 0
        L_0x00c3:
            if (r8 == 0) goto L_0x004d
            boolean r8 = r11.isInVerticalChain()
            if (r8 != 0) goto L_0x004d
            solveVerticalMatchConstraint(r12, r0, r1, r11)
            goto L_0x004d
        L_0x00d0:
            boolean r13 = r11.isMeasureRequested()
            if (r13 == 0) goto L_0x00d8
            goto L_0x004d
        L_0x00d8:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r11.mTop
            if (r8 != r13) goto L_0x00f4
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r11.mBottom
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r14.mTarget
            if (r14 != 0) goto L_0x00f4
            int r8 = r13.getMargin()
            int r8 = r8 + r6
            int r13 = r11.getHeight()
            int r13 = r13 + r8
            r11.setFinalVertical(r8, r13)
            verticalSolvingPass(r12, r11, r1)
            goto L_0x004d
        L_0x00f4:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r11.mBottom
            if (r8 != r13) goto L_0x0110
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r13.mTarget
            if (r14 != 0) goto L_0x0110
            int r8 = r13.getMargin()
            int r8 = r6 - r8
            int r13 = r11.getHeight()
            int r13 = r8 - r13
            r11.setFinalVertical(r13, r8)
            verticalSolvingPass(r12, r11, r1)
            goto L_0x004d
        L_0x0110:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r11.mTop
            if (r8 != r13) goto L_0x004d
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r11.mBottom
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r8.mTarget
            if (r8 == 0) goto L_0x004d
            boolean r8 = r8.mHasFinalValue
            if (r8 == 0) goto L_0x004d
            solveVerticalCenterConstraints(r12, r1, r11)
            goto L_0x004d
        L_0x0123:
            boolean r2 = r0 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r2 == 0) goto L_0x0128
            return
        L_0x0128:
            java.util.HashSet<androidx.constraintlayout.core.widgets.ConstraintAnchor> r2 = r5.mDependents
            if (r2 == 0) goto L_0x0206
            boolean r5 = r5.mHasFinalValue
            if (r5 == 0) goto L_0x0206
            java.util.Iterator r2 = r2.iterator()
        L_0x0134:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x0206
            java.lang.Object r5 = r2.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r5.mOwner
            int r8 = r16 + 1
            boolean r11 = canMeasure(r8, r6)
            boolean r12 = r6.isMeasureRequested()
            if (r12 == 0) goto L_0x0158
            if (r11 == 0) goto L_0x0158
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r12 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r12.<init>()
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.measure(r8, r6, r1, r12, r4)
        L_0x0158:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r6.mTop
            if (r5 != r12) goto L_0x0166
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r6.mBottom
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r12.mTarget
            if (r12 == 0) goto L_0x0166
            boolean r12 = r12.mHasFinalValue
            if (r12 != 0) goto L_0x0174
        L_0x0166:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r6.mBottom
            if (r5 != r12) goto L_0x0176
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r6.mTop
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r12.mTarget
            if (r12 == 0) goto L_0x0176
            boolean r12 = r12.mHasFinalValue
            if (r12 == 0) goto L_0x0176
        L_0x0174:
            r12 = 1
            goto L_0x0177
        L_0x0176:
            r12 = 0
        L_0x0177:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = r6.getVerticalDimensionBehaviour()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r13 != r14) goto L_0x01b7
            if (r11 == 0) goto L_0x0182
            goto L_0x01b7
        L_0x0182:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = r6.getVerticalDimensionBehaviour()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 != r11) goto L_0x0134
            int r5 = r6.mMatchConstraintMaxHeight
            if (r5 < 0) goto L_0x0134
            int r5 = r6.mMatchConstraintMinHeight
            if (r5 < 0) goto L_0x0134
            int r5 = r6.mVisibility
            if (r5 == r10) goto L_0x01a0
            int r5 = r6.mMatchConstraintDefaultHeight
            if (r5 != 0) goto L_0x0134
            float r5 = r6.mDimensionRatio
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 != 0) goto L_0x0134
        L_0x01a0:
            boolean r5 = r6.isInVerticalChain()
            if (r5 != 0) goto L_0x0134
            boolean r5 = r6.mInVirtualLayout
            if (r5 != 0) goto L_0x0134
            if (r12 == 0) goto L_0x0134
            boolean r5 = r6.isInVerticalChain()
            if (r5 != 0) goto L_0x0134
            solveVerticalMatchConstraint(r8, r0, r1, r6)
            goto L_0x0134
        L_0x01b7:
            boolean r11 = r6.isMeasureRequested()
            if (r11 == 0) goto L_0x01bf
            goto L_0x0134
        L_0x01bf:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r6.mTop
            if (r5 != r11) goto L_0x01db
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r6.mBottom
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r13.mTarget
            if (r13 != 0) goto L_0x01db
            int r5 = r11.getMargin()
            int r5 = r5 + r7
            int r11 = r6.getHeight()
            int r11 = r11 + r5
            r6.setFinalVertical(r5, r11)
            verticalSolvingPass(r8, r6, r1)
            goto L_0x0134
        L_0x01db:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r6.mBottom
            if (r5 != r11) goto L_0x01f9
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r6.mTop
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 != 0) goto L_0x01f9
            int r5 = r11.getMargin()
            int r5 = r7 - r5
            int r11 = r6.getHeight()
            int r11 = r5 - r11
            r6.setFinalVertical(r11, r5)
            verticalSolvingPass(r8, r6, r1)
            goto L_0x0134
        L_0x01f9:
            if (r12 == 0) goto L_0x0134
            boolean r5 = r6.isInVerticalChain()
            if (r5 != 0) goto L_0x0134
            solveVerticalCenterConstraints(r8, r1, r6)
            goto L_0x0134
        L_0x0206:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r0.getAnchor(r2)
            java.util.HashSet<androidx.constraintlayout.core.widgets.ConstraintAnchor> r5 = r2.mDependents
            if (r5 == 0) goto L_0x0283
            boolean r5 = r2.mHasFinalValue
            if (r5 == 0) goto L_0x0283
            int r5 = r2.getFinalValue()
            java.util.HashSet<androidx.constraintlayout.core.widgets.ConstraintAnchor> r2 = r2.mDependents
            java.util.Iterator r2 = r2.iterator()
        L_0x021e:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x0283
            java.lang.Object r6 = r2.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r6
            androidx.constraintlayout.core.widgets.ConstraintWidget r7 = r6.mOwner
            int r8 = r16 + 1
            boolean r9 = canMeasure(r8, r7)
            boolean r10 = r7.isMeasureRequested()
            if (r10 == 0) goto L_0x0242
            if (r9 == 0) goto L_0x0242
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r10 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r10.<init>()
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.measure(r8, r7, r1, r10, r4)
        L_0x0242:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r10 = r7.getVerticalDimensionBehaviour()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r10 != r11) goto L_0x024c
            if (r9 == 0) goto L_0x021e
        L_0x024c:
            boolean r9 = r7.isMeasureRequested()
            if (r9 == 0) goto L_0x0253
            goto L_0x021e
        L_0x0253:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r7.mBaseline
            if (r6 != r9) goto L_0x021e
            int r6 = r6.getMargin()
            int r6 = r6 + r5
            boolean r9 = r7.hasBaseline
            if (r9 != 0) goto L_0x0261
            goto L_0x027c
        L_0x0261:
            int r9 = r7.mBaselineDistance
            int r9 = r6 - r9
            int r10 = r7.mHeight
            int r10 = r10 + r9
            r7.mY = r9
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r7.mTop
            r11.setFinalValue(r9)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r7.mBottom
            r9.setFinalValue(r10)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r7.mBaseline
            r9.mFinalValue = r6
            r9.mHasFinalValue = r3
            r7.resolvedVertical = r3
        L_0x027c:
            verticalSolvingPass(r8, r7, r1)     // Catch:{ all -> 0x0280 }
            goto L_0x021e
        L_0x0280:
            r0 = move-exception
            r1 = r0
            throw r1
        L_0x0283:
            r0.verticalSolvingPass = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.Direct.verticalSolvingPass(int, androidx.constraintlayout.core.widgets.ConstraintWidget, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer):void");
    }
}
