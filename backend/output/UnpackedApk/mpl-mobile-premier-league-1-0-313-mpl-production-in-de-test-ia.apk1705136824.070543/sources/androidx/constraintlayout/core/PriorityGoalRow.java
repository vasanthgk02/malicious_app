package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow.ArrayRowVariables;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Arrays;
import java.util.Comparator;
import org.apache.fontbox.cmap.CMap;

public class PriorityGoalRow extends ArrayRow {
    public int TABLE_SIZE = 128;
    public GoalVariableAccessor accessor = new GoalVariableAccessor(this);
    public SolverVariable[] arrayGoals = new SolverVariable[128];
    public int numGoals = 0;
    public SolverVariable[] sortArray = new SolverVariable[128];

    public class GoalVariableAccessor {
        public SolverVariable variable;

        public GoalVariableAccessor(PriorityGoalRow priorityGoalRow) {
        }

        public String toString() {
            String str = "[ ";
            if (this.variable != null) {
                for (int i = 0; i < 9; i++) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73(str);
                    outline73.append(this.variable.goalStrengthVector[i]);
                    outline73.append(CMap.SPACE);
                    str = outline73.toString();
                }
            }
            StringBuilder outline78 = GeneratedOutlineSupport.outline78(str, "] ");
            outline78.append(this.variable);
            return outline78.toString();
        }
    }

    public PriorityGoalRow(Cache cache) {
        super(cache);
    }

    public void addError(SolverVariable solverVariable) {
        this.accessor.variable = solverVariable;
        Arrays.fill(solverVariable.goalStrengthVector, 0.0f);
        solverVariable.goalStrengthVector[solverVariable.strength] = 1.0f;
        addToGoal(solverVariable);
    }

    public final void addToGoal(SolverVariable solverVariable) {
        int i;
        int i2 = this.numGoals + 1;
        SolverVariable[] solverVariableArr = this.arrayGoals;
        if (i2 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.arrayGoals = solverVariableArr2;
            this.sortArray = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.arrayGoals;
        int i3 = this.numGoals;
        solverVariableArr3[i3] = solverVariable;
        int i4 = i3 + 1;
        this.numGoals = i4;
        if (i4 > 1 && solverVariableArr3[i4 - 1].id > solverVariable.id) {
            int i5 = 0;
            while (true) {
                i = this.numGoals;
                if (i5 >= i) {
                    break;
                }
                this.sortArray[i5] = this.arrayGoals[i5];
                i5++;
            }
            Arrays.sort(this.sortArray, 0, i, new Comparator<SolverVariable>(this) {
                public int compare(Object obj, Object obj2) {
                    return ((SolverVariable) obj).id - ((SolverVariable) obj2).id;
                }
            });
            for (int i6 = 0; i6 < this.numGoals; i6++) {
                this.arrayGoals[i6] = this.sortArray[i6];
            }
        }
        solverVariable.inGoal = true;
        solverVariable.addToRow(this);
    }

    public void clear() {
        this.numGoals = 0;
        this.constantValue = 0.0f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0035, code lost:
        r7 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0053, code lost:
        if (r8 < r4) goto L_0x0057;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.constraintlayout.core.SolverVariable getPivotCandidate(androidx.constraintlayout.core.LinearSystem r11, boolean[] r12) {
        /*
            r10 = this;
            r11 = 0
            r0 = -1
            r1 = 0
            r2 = -1
        L_0x0004:
            int r3 = r10.numGoals
            r4 = 0
            if (r1 >= r3) goto L_0x005e
            androidx.constraintlayout.core.SolverVariable[] r3 = r10.arrayGoals
            r5 = r3[r1]
            int r6 = r5.id
            boolean r6 = r12[r6]
            if (r6 == 0) goto L_0x0014
            goto L_0x005a
        L_0x0014:
            androidx.constraintlayout.core.PriorityGoalRow$GoalVariableAccessor r6 = r10.accessor
            r6.variable = r5
            r5 = 8
            r7 = 1
            if (r2 != r0) goto L_0x003a
            if (r6 == 0) goto L_0x0039
        L_0x001f:
            if (r5 < 0) goto L_0x0035
            androidx.constraintlayout.core.SolverVariable r3 = r6.variable
            float[] r3 = r3.goalStrengthVector
            r3 = r3[r5]
            r4 = 0
            int r8 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r8 <= 0) goto L_0x002d
            goto L_0x0035
        L_0x002d:
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x0032
            goto L_0x0036
        L_0x0032:
            int r5 = r5 + -1
            goto L_0x001f
        L_0x0035:
            r7 = 0
        L_0x0036:
            if (r7 == 0) goto L_0x005a
            goto L_0x0059
        L_0x0039:
            throw r4
        L_0x003a:
            r3 = r3[r2]
            if (r6 == 0) goto L_0x005d
        L_0x003e:
            if (r5 < 0) goto L_0x0056
            float[] r4 = r3.goalStrengthVector
            r4 = r4[r5]
            androidx.constraintlayout.core.SolverVariable r8 = r6.variable
            float[] r8 = r8.goalStrengthVector
            r8 = r8[r5]
            int r9 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r9 != 0) goto L_0x0051
            int r5 = r5 + -1
            goto L_0x003e
        L_0x0051:
            int r3 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x0056
            goto L_0x0057
        L_0x0056:
            r7 = 0
        L_0x0057:
            if (r7 == 0) goto L_0x005a
        L_0x0059:
            r2 = r1
        L_0x005a:
            int r1 = r1 + 1
            goto L_0x0004
        L_0x005d:
            throw r4
        L_0x005e:
            if (r2 != r0) goto L_0x0061
            return r4
        L_0x0061:
            androidx.constraintlayout.core.SolverVariable[] r11 = r10.arrayGoals
            r11 = r11[r2]
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.PriorityGoalRow.getPivotCandidate(androidx.constraintlayout.core.LinearSystem, boolean[]):androidx.constraintlayout.core.SolverVariable");
    }

    public boolean isEmpty() {
        return this.numGoals == 0;
    }

    public final void removeGoal(SolverVariable solverVariable) {
        int i = 0;
        while (i < this.numGoals) {
            if (this.arrayGoals[i] == solverVariable) {
                while (true) {
                    int i2 = this.numGoals;
                    if (i < i2 - 1) {
                        SolverVariable[] solverVariableArr = this.arrayGoals;
                        int i3 = i + 1;
                        solverVariableArr[i] = solverVariableArr[i3];
                        i = i3;
                    } else {
                        this.numGoals = i2 - 1;
                        solverVariable.inGoal = false;
                        return;
                    }
                }
            } else {
                i++;
            }
        }
    }

    public String toString() {
        StringBuilder outline78 = GeneratedOutlineSupport.outline78("", " goal -> (");
        outline78.append(this.constantValue);
        outline78.append(") : ");
        String sb = outline78.toString();
        for (int i = 0; i < this.numGoals; i++) {
            this.accessor.variable = this.arrayGoals[i];
            StringBuilder outline73 = GeneratedOutlineSupport.outline73(sb);
            outline73.append(this.accessor);
            outline73.append(CMap.SPACE);
            sb = outline73.toString();
        }
        return sb;
    }

    public void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z) {
        ArrayRow arrayRow2 = arrayRow;
        SolverVariable solverVariable = arrayRow2.variable;
        if (solverVariable != null) {
            ArrayRowVariables arrayRowVariables = arrayRow2.variables;
            int currentSize = arrayRowVariables.getCurrentSize();
            for (int i = 0; i < currentSize; i++) {
                SolverVariable variable = arrayRowVariables.getVariable(i);
                float variableValue = arrayRowVariables.getVariableValue(i);
                GoalVariableAccessor goalVariableAccessor = this.accessor;
                goalVariableAccessor.variable = variable;
                boolean z2 = true;
                if (variable.inGoal) {
                    for (int i2 = 0; i2 < 9; i2++) {
                        float[] fArr = goalVariableAccessor.variable.goalStrengthVector;
                        fArr[i2] = (solverVariable.goalStrengthVector[i2] * variableValue) + fArr[i2];
                        if (Math.abs(fArr[i2]) < 1.0E-4f) {
                            goalVariableAccessor.variable.goalStrengthVector[i2] = 0.0f;
                        } else {
                            z2 = false;
                        }
                    }
                    if (z2) {
                        PriorityGoalRow.this.removeGoal(goalVariableAccessor.variable);
                    }
                    z2 = false;
                } else {
                    for (int i3 = 0; i3 < 9; i3++) {
                        float f2 = solverVariable.goalStrengthVector[i3];
                        if (f2 != 0.0f) {
                            float f3 = f2 * variableValue;
                            if (Math.abs(f3) < 1.0E-4f) {
                                f3 = 0.0f;
                            }
                            goalVariableAccessor.variable.goalStrengthVector[i3] = f3;
                        } else {
                            goalVariableAccessor.variable.goalStrengthVector[i3] = 0.0f;
                        }
                    }
                }
                if (z2) {
                    addToGoal(variable);
                }
                this.constantValue = (arrayRow2.constantValue * variableValue) + this.constantValue;
            }
            removeGoal(solverVariable);
        }
    }
}
