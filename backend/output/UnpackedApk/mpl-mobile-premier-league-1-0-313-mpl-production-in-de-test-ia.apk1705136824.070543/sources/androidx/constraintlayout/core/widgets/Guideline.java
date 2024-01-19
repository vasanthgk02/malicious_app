package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.ArrayRow;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor.Type;
import androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour;
import java.util.HashMap;

public class Guideline extends ConstraintWidget {
    public ConstraintAnchor mAnchor = this.mTop;
    public int mOrientation;
    public int mRelativeBegin = -1;
    public int mRelativeEnd = -1;
    public float mRelativePercent = -1.0f;
    public boolean resolved;

    public Guideline() {
        this.mOrientation = 0;
        this.mAnchors.clear();
        this.mAnchors.add(this.mAnchor);
        int length = this.mListAnchors.length;
        for (int i = 0; i < length; i++) {
            this.mListAnchors[i] = this.mAnchor;
        }
    }

    public void addToSolver(LinearSystem linearSystem, boolean z) {
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) this.mParent;
        if (constraintWidgetContainer != null) {
            ConstraintAnchor anchor = constraintWidgetContainer.getAnchor(Type.LEFT);
            ConstraintAnchor anchor2 = constraintWidgetContainer.getAnchor(Type.RIGHT);
            ConstraintWidget constraintWidget = this.mParent;
            boolean z2 = true;
            boolean z3 = constraintWidget != null && constraintWidget.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT;
            if (this.mOrientation == 0) {
                anchor = constraintWidgetContainer.getAnchor(Type.TOP);
                anchor2 = constraintWidgetContainer.getAnchor(Type.BOTTOM);
                ConstraintWidget constraintWidget2 = this.mParent;
                if (constraintWidget2 == null || constraintWidget2.mListDimensionBehaviors[1] != DimensionBehaviour.WRAP_CONTENT) {
                    z2 = false;
                }
                z3 = z2;
            }
            if (this.resolved) {
                ConstraintAnchor constraintAnchor = this.mAnchor;
                if (constraintAnchor.mHasFinalValue) {
                    SolverVariable createObjectVariable = linearSystem.createObjectVariable(constraintAnchor);
                    linearSystem.addEquality(createObjectVariable, this.mAnchor.getFinalValue());
                    if (this.mRelativeBegin != -1) {
                        if (z3) {
                            linearSystem.addGreaterThan(linearSystem.createObjectVariable(anchor2), createObjectVariable, 0, 5);
                        }
                    } else if (this.mRelativeEnd != -1 && z3) {
                        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(anchor2);
                        linearSystem.addGreaterThan(createObjectVariable, linearSystem.createObjectVariable(anchor), 0, 5);
                        linearSystem.addGreaterThan(createObjectVariable2, createObjectVariable, 0, 5);
                    }
                    this.resolved = false;
                    return;
                }
            }
            if (this.mRelativeBegin != -1) {
                SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.mAnchor);
                linearSystem.addEquality(createObjectVariable3, linearSystem.createObjectVariable(anchor), this.mRelativeBegin, 8);
                if (z3) {
                    linearSystem.addGreaterThan(linearSystem.createObjectVariable(anchor2), createObjectVariable3, 0, 5);
                }
            } else if (this.mRelativeEnd != -1) {
                SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.mAnchor);
                SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(anchor2);
                linearSystem.addEquality(createObjectVariable4, createObjectVariable5, -this.mRelativeEnd, 8);
                if (z3) {
                    linearSystem.addGreaterThan(createObjectVariable4, linearSystem.createObjectVariable(anchor), 0, 5);
                    linearSystem.addGreaterThan(createObjectVariable5, createObjectVariable4, 0, 5);
                }
            } else if (this.mRelativePercent != -1.0f) {
                SolverVariable createObjectVariable6 = linearSystem.createObjectVariable(this.mAnchor);
                SolverVariable createObjectVariable7 = linearSystem.createObjectVariable(anchor2);
                float f2 = this.mRelativePercent;
                ArrayRow createRow = linearSystem.createRow();
                createRow.variables.put(createObjectVariable6, -1.0f);
                createRow.variables.put(createObjectVariable7, f2);
                linearSystem.addConstraint(createRow);
            }
        }
    }

    public boolean allowedInBarrier() {
        return true;
    }

    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        Guideline guideline = (Guideline) constraintWidget;
        this.mRelativePercent = guideline.mRelativePercent;
        this.mRelativeBegin = guideline.mRelativeBegin;
        this.mRelativeEnd = guideline.mRelativeEnd;
        setOrientation(guideline.mOrientation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000e, code lost:
        if (r3 != 4) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.constraintlayout.core.widgets.ConstraintAnchor getAnchor(androidx.constraintlayout.core.widgets.ConstraintAnchor.Type r3) {
        /*
            r2 = this;
            int r3 = r3.ordinal()
            r0 = 1
            if (r3 == r0) goto L_0x0018
            r1 = 2
            if (r3 == r1) goto L_0x0011
            r1 = 3
            if (r3 == r1) goto L_0x0018
            r0 = 4
            if (r3 == r0) goto L_0x0011
            goto L_0x001f
        L_0x0011:
            int r3 = r2.mOrientation
            if (r3 != 0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r2.mAnchor
            return r3
        L_0x0018:
            int r3 = r2.mOrientation
            if (r3 != r0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r2.mAnchor
            return r3
        L_0x001f:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Guideline.getAnchor(androidx.constraintlayout.core.widgets.ConstraintAnchor$Type):androidx.constraintlayout.core.widgets.ConstraintAnchor");
    }

    public boolean isResolvedHorizontally() {
        return this.resolved;
    }

    public boolean isResolvedVertically() {
        return this.resolved;
    }

    public void setFinalValue(int i) {
        ConstraintAnchor constraintAnchor = this.mAnchor;
        constraintAnchor.mFinalValue = i;
        constraintAnchor.mHasFinalValue = true;
        this.resolved = true;
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            this.mAnchors.clear();
            if (this.mOrientation == 1) {
                this.mAnchor = this.mLeft;
            } else {
                this.mAnchor = this.mTop;
            }
            this.mAnchors.add(this.mAnchor);
            int length = this.mListAnchors.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.mListAnchors[i2] = this.mAnchor;
            }
        }
    }

    public void updateFromSolver(LinearSystem linearSystem, boolean z) {
        if (this.mParent != null) {
            int objectVariableValue = linearSystem.getObjectVariableValue(this.mAnchor);
            if (this.mOrientation == 1) {
                this.mX = objectVariableValue;
                this.mY = 0;
                setHeight(this.mParent.getHeight());
                setWidth(0);
            } else {
                this.mX = 0;
                this.mY = objectVariableValue;
                setWidth(this.mParent.getWidth());
                setHeight(0);
            }
        }
    }
}
