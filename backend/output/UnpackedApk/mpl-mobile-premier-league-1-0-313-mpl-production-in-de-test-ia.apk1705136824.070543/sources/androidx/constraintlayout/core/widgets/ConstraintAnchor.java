package androidx.constraintlayout.core.widgets;

import a.a.a.a.d.b;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.analyzer.WidgetGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class ConstraintAnchor {
    public HashSet<ConstraintAnchor> mDependents = null;
    public int mFinalValue;
    public int mGoneMargin = LinearLayoutManager.INVALID_OFFSET;
    public boolean mHasFinalValue;
    public int mMargin = 0;
    public final ConstraintWidget mOwner;
    public SolverVariable mSolverVariable;
    public ConstraintAnchor mTarget;
    public final Type mType;

    public enum Type {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.mOwner = constraintWidget;
        this.mType = type;
    }

    public boolean connect(ConstraintAnchor constraintAnchor, int i, int i2, boolean z) {
        if (constraintAnchor == null) {
            reset();
            return true;
        } else if (!z && !isValidConnection(constraintAnchor)) {
            return false;
        } else {
            this.mTarget = constraintAnchor;
            if (constraintAnchor.mDependents == null) {
                constraintAnchor.mDependents = new HashSet<>();
            }
            HashSet<ConstraintAnchor> hashSet = this.mTarget.mDependents;
            if (hashSet != null) {
                hashSet.add(this);
            }
            this.mMargin = i;
            this.mGoneMargin = i2;
            return true;
        }
    }

    public void findDependents(int i, ArrayList<WidgetGroup> arrayList, WidgetGroup widgetGroup) {
        HashSet<ConstraintAnchor> hashSet = this.mDependents;
        if (hashSet != null) {
            Iterator<ConstraintAnchor> it = hashSet.iterator();
            while (it.hasNext()) {
                b.findDependents(it.next().mOwner, i, arrayList, widgetGroup);
            }
        }
    }

    public int getFinalValue() {
        if (!this.mHasFinalValue) {
            return 0;
        }
        return this.mFinalValue;
    }

    public int getMargin() {
        if (this.mOwner.mVisibility == 8) {
            return 0;
        }
        int i = this.mGoneMargin;
        if (i != Integer.MIN_VALUE) {
            ConstraintAnchor constraintAnchor = this.mTarget;
            if (constraintAnchor != null && constraintAnchor.mOwner.mVisibility == 8) {
                return i;
            }
        }
        return this.mMargin;
    }

    public final ConstraintAnchor getOpposite() {
        switch (this.mType.ordinal()) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
                return this.mOwner.mRight;
            case 2:
                return this.mOwner.mBottom;
            case 3:
                return this.mOwner.mLeft;
            case 4:
                return this.mOwner.mTop;
            default:
                throw new AssertionError(this.mType.name());
        }
    }

    public boolean hasCenteredDependents() {
        HashSet<ConstraintAnchor> hashSet = this.mDependents;
        if (hashSet == null) {
            return false;
        }
        Iterator<ConstraintAnchor> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().getOpposite().isConnected()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasDependents() {
        HashSet<ConstraintAnchor> hashSet = this.mDependents;
        boolean z = false;
        if (hashSet == null) {
            return false;
        }
        if (hashSet.size() > 0) {
            z = true;
        }
        return z;
    }

    public boolean isConnected() {
        return this.mTarget != null;
    }

    public boolean isValidConnection(ConstraintAnchor constraintAnchor) {
        boolean z = false;
        if (constraintAnchor == null) {
            return false;
        }
        Type type = constraintAnchor.mType;
        Type type2 = this.mType;
        if (type != type2) {
            switch (type2.ordinal()) {
                case 0:
                case 7:
                case 8:
                    return false;
                case 1:
                case 3:
                    boolean z2 = type == Type.LEFT || type == Type.RIGHT;
                    if (constraintAnchor.mOwner instanceof Guideline) {
                        if (z2 || type == Type.CENTER_X) {
                            z = true;
                        }
                        z2 = z;
                    }
                    return z2;
                case 2:
                case 4:
                    boolean z3 = type == Type.TOP || type == Type.BOTTOM;
                    if (constraintAnchor.mOwner instanceof Guideline) {
                        if (z3 || type == Type.CENTER_Y) {
                            z = true;
                        }
                        z3 = z;
                    }
                    return z3;
                case 5:
                    if (type == Type.LEFT || type == Type.RIGHT) {
                        return false;
                    }
                    return true;
                case 6:
                    if (!(type == Type.BASELINE || type == Type.CENTER_X || type == Type.CENTER_Y)) {
                        z = true;
                    }
                    return z;
                default:
                    throw new AssertionError(this.mType.name());
            }
        } else if (type2 != Type.BASELINE || (constraintAnchor.mOwner.hasBaseline && this.mOwner.hasBaseline)) {
            return true;
        } else {
            return false;
        }
    }

    public void reset() {
        ConstraintAnchor constraintAnchor = this.mTarget;
        if (constraintAnchor != null) {
            HashSet<ConstraintAnchor> hashSet = constraintAnchor.mDependents;
            if (hashSet != null) {
                hashSet.remove(this);
                if (this.mTarget.mDependents.size() == 0) {
                    this.mTarget.mDependents = null;
                }
            }
        }
        this.mDependents = null;
        this.mTarget = null;
        this.mMargin = 0;
        this.mGoneMargin = LinearLayoutManager.INVALID_OFFSET;
        this.mHasFinalValue = false;
        this.mFinalValue = 0;
    }

    public void resetSolverVariable() {
        SolverVariable solverVariable = this.mSolverVariable;
        if (solverVariable == null) {
            this.mSolverVariable = new SolverVariable(androidx.constraintlayout.core.SolverVariable.Type.UNRESTRICTED);
        } else {
            solverVariable.reset();
        }
    }

    public void setFinalValue(int i) {
        this.mFinalValue = i;
        this.mHasFinalValue = true;
    }

    public void setGoneMargin(int i) {
        if (isConnected()) {
            this.mGoneMargin = i;
        }
    }

    public String toString() {
        return this.mOwner.mDebugName + ":" + this.mType.toString();
    }

    public boolean connect(ConstraintAnchor constraintAnchor, int i) {
        return connect(constraintAnchor, i, LinearLayoutManager.INVALID_OFFSET, false);
    }
}
