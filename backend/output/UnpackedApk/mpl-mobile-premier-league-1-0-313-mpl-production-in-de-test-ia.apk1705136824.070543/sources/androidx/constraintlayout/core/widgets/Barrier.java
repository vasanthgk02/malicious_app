package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.ArrayRow;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor.Type;
import androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.HashMap;

public class Barrier extends HelperWidget {
    public boolean mAllowsGoneWidget = true;
    public int mBarrierType = 0;
    public int mMargin = 0;
    public boolean resolved = false;

    public void addToSolver(LinearSystem linearSystem, boolean z) {
        ConstraintAnchor[] constraintAnchorArr;
        boolean z2;
        ConstraintAnchor[] constraintAnchorArr2 = this.mListAnchors;
        constraintAnchorArr2[0] = this.mLeft;
        constraintAnchorArr2[2] = this.mTop;
        constraintAnchorArr2[1] = this.mRight;
        constraintAnchorArr2[3] = this.mBottom;
        int i = 0;
        while (true) {
            constraintAnchorArr = this.mListAnchors;
            if (i >= constraintAnchorArr.length) {
                break;
            }
            constraintAnchorArr[i].mSolverVariable = linearSystem.createObjectVariable(constraintAnchorArr[i]);
            i++;
        }
        int i2 = this.mBarrierType;
        if (i2 >= 0 && i2 < 4) {
            ConstraintAnchor constraintAnchor = constraintAnchorArr[i2];
            if (!this.resolved) {
                allSolved();
            }
            if (this.resolved) {
                this.resolved = false;
                int i3 = this.mBarrierType;
                if (i3 == 0 || i3 == 1) {
                    linearSystem.addEquality(this.mLeft.mSolverVariable, this.mX);
                    linearSystem.addEquality(this.mRight.mSolverVariable, this.mX);
                } else if (i3 == 2 || i3 == 3) {
                    linearSystem.addEquality(this.mTop.mSolverVariable, this.mY);
                    linearSystem.addEquality(this.mBottom.mSolverVariable, this.mY);
                }
                return;
            }
            int i4 = 0;
            while (true) {
                if (i4 >= this.mWidgetsCount) {
                    z2 = false;
                    break;
                }
                ConstraintWidget constraintWidget = this.mWidgets[i4];
                if (this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) {
                    int i5 = this.mBarrierType;
                    if ((i5 != 0 && i5 != 1) || constraintWidget.getHorizontalDimensionBehaviour() != DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.mLeft.mTarget == null || constraintWidget.mRight.mTarget == null) {
                        int i6 = this.mBarrierType;
                        if ((i6 == 2 || i6 == 3) && constraintWidget.getVerticalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget != null) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i4++;
            }
            z2 = true;
            boolean z3 = this.mLeft.hasCenteredDependents() || this.mRight.hasCenteredDependents();
            boolean z4 = this.mTop.hasCenteredDependents() || this.mBottom.hasCenteredDependents();
            boolean z5 = !z2 && ((this.mBarrierType == 0 && z3) || ((this.mBarrierType == 2 && z4) || ((this.mBarrierType == 1 && z3) || (this.mBarrierType == 3 && z4))));
            int i7 = 5;
            if (!z5) {
                i7 = 4;
            }
            for (int i8 = 0; i8 < this.mWidgetsCount; i8++) {
                ConstraintWidget constraintWidget2 = this.mWidgets[i8];
                if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                    SolverVariable createObjectVariable = linearSystem.createObjectVariable(constraintWidget2.mListAnchors[this.mBarrierType]);
                    ConstraintAnchor[] constraintAnchorArr3 = constraintWidget2.mListAnchors;
                    int i9 = this.mBarrierType;
                    constraintAnchorArr3[i9].mSolverVariable = createObjectVariable;
                    int i10 = (constraintAnchorArr3[i9].mTarget == null || constraintAnchorArr3[i9].mTarget.mOwner != this) ? 0 : constraintAnchorArr3[i9].mMargin + 0;
                    int i11 = this.mBarrierType;
                    if (i11 == 0 || i11 == 2) {
                        ArrayRow createRow = linearSystem.createRow();
                        SolverVariable createSlackVariable = linearSystem.createSlackVariable();
                        createSlackVariable.strength = 0;
                        createRow.createRowLowerThan(constraintAnchor.mSolverVariable, createObjectVariable, createSlackVariable, this.mMargin - i10);
                        linearSystem.addConstraint(createRow);
                    } else {
                        ArrayRow createRow2 = linearSystem.createRow();
                        SolverVariable createSlackVariable2 = linearSystem.createSlackVariable();
                        createSlackVariable2.strength = 0;
                        createRow2.createRowGreaterThan(constraintAnchor.mSolverVariable, createObjectVariable, createSlackVariable2, this.mMargin + i10);
                        linearSystem.addConstraint(createRow2);
                    }
                    linearSystem.addEquality(constraintAnchor.mSolverVariable, createObjectVariable, this.mMargin + i10, i7);
                }
            }
            int i12 = this.mBarrierType;
            if (i12 == 0) {
                linearSystem.addEquality(this.mRight.mSolverVariable, this.mLeft.mSolverVariable, 0, 8);
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 4);
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 0);
            } else if (i12 == 1) {
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mRight.mSolverVariable, 0, 8);
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 4);
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 0);
            } else if (i12 == 2) {
                linearSystem.addEquality(this.mBottom.mSolverVariable, this.mTop.mSolverVariable, 0, 8);
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 4);
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 0);
            } else if (i12 == 3) {
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mBottom.mSolverVariable, 0, 8);
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 4);
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 0);
            }
        }
    }

    public boolean allSolved() {
        int i;
        int i2 = 0;
        boolean z = true;
        while (true) {
            i = this.mWidgetsCount;
            if (i2 >= i) {
                break;
            }
            ConstraintWidget constraintWidget = this.mWidgets[i2];
            if (this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) {
                int i3 = this.mBarrierType;
                if (!(i3 == 0 || i3 == 1) || constraintWidget.isResolvedHorizontally()) {
                    int i4 = this.mBarrierType;
                    if (i4 != 2) {
                        if (i4 != 3) {
                        }
                    }
                    if (constraintWidget.isResolvedVertically()) {
                    }
                }
                z = false;
            }
            i2++;
        }
        if (!z || i <= 0) {
            return false;
        }
        int i5 = 0;
        boolean z2 = false;
        for (int i6 = 0; i6 < this.mWidgetsCount; i6++) {
            ConstraintWidget constraintWidget2 = this.mWidgets[i6];
            if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                if (!z2) {
                    int i7 = this.mBarrierType;
                    if (i7 == 0) {
                        i5 = constraintWidget2.getAnchor(Type.LEFT).getFinalValue();
                    } else if (i7 == 1) {
                        i5 = constraintWidget2.getAnchor(Type.RIGHT).getFinalValue();
                    } else if (i7 == 2) {
                        i5 = constraintWidget2.getAnchor(Type.TOP).getFinalValue();
                    } else if (i7 == 3) {
                        i5 = constraintWidget2.getAnchor(Type.BOTTOM).getFinalValue();
                    }
                    z2 = true;
                }
                int i8 = this.mBarrierType;
                if (i8 == 0) {
                    i5 = Math.min(i5, constraintWidget2.getAnchor(Type.LEFT).getFinalValue());
                } else if (i8 == 1) {
                    i5 = Math.max(i5, constraintWidget2.getAnchor(Type.RIGHT).getFinalValue());
                } else if (i8 == 2) {
                    i5 = Math.min(i5, constraintWidget2.getAnchor(Type.TOP).getFinalValue());
                } else if (i8 == 3) {
                    i5 = Math.max(i5, constraintWidget2.getAnchor(Type.BOTTOM).getFinalValue());
                }
            }
        }
        int i9 = i5 + this.mMargin;
        int i10 = this.mBarrierType;
        if (i10 == 0 || i10 == 1) {
            setFinalHorizontal(i9, i9);
        } else {
            setFinalVertical(i9, i9);
        }
        this.resolved = true;
        return true;
    }

    public boolean allowedInBarrier() {
        return true;
    }

    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        Barrier barrier = (Barrier) constraintWidget;
        this.mBarrierType = barrier.mBarrierType;
        this.mAllowsGoneWidget = barrier.mAllowsGoneWidget;
        this.mMargin = barrier.mMargin;
    }

    public int getOrientation() {
        int i = this.mBarrierType;
        if (i == 0 || i == 1) {
            return 0;
        }
        return (i == 2 || i == 3) ? 1 : -1;
    }

    public boolean isResolvedHorizontally() {
        return this.resolved;
    }

    public boolean isResolvedVertically() {
        return this.resolved;
    }

    public String toString() {
        String outline62 = GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73("[Barrier] "), this.mDebugName, " {");
        for (int i = 0; i < this.mWidgetsCount; i++) {
            ConstraintWidget constraintWidget = this.mWidgets[i];
            if (i > 0) {
                outline62 = GeneratedOutlineSupport.outline50(outline62, ", ");
            }
            StringBuilder outline73 = GeneratedOutlineSupport.outline73(outline62);
            outline73.append(constraintWidget.mDebugName);
            outline62 = outline73.toString();
        }
        return GeneratedOutlineSupport.outline50(outline62, "}");
    }
}
