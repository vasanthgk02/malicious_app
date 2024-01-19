package androidx.constraintlayout.core;

import androidx.constraintlayout.core.SolverVariable.Type;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import java.util.Arrays;
import java.util.HashMap;

public class LinearSystem {
    public static long ARRAY_ROW_CREATION = 0;
    public static int POOL_SIZE = 1000;
    public static boolean USE_DEPENDENCY_ORDERING;
    public static Metrics sMetrics;
    public int TABLE_SIZE;
    public boolean graphOptimizer;
    public boolean hasSimpleDefinition;
    public boolean[] mAlreadyTestedCandidates;
    public final Cache mCache;
    public Row mGoal;
    public int mMaxColumns;
    public int mMaxRows;
    public int mNumColumns;
    public int mNumRows;
    public SolverVariable[] mPoolVariables;
    public int mPoolVariablesCount;
    public ArrayRow[] mRows;
    public Row mTempGoal;
    public HashMap<String, SolverVariable> mVariables;
    public int mVariablesID;
    public boolean newgraphOptimizer;

    public interface Row {
        void addError(SolverVariable solverVariable);

        void clear();

        SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr);

        boolean isEmpty();
    }

    public LinearSystem() {
        this.hasSimpleDefinition = false;
        this.mVariablesID = 0;
        this.mVariables = null;
        this.TABLE_SIZE = 32;
        this.mMaxColumns = 32;
        this.mRows = null;
        this.graphOptimizer = false;
        this.newgraphOptimizer = false;
        this.mAlreadyTestedCandidates = new boolean[32];
        this.mNumColumns = 1;
        this.mNumRows = 0;
        this.mMaxRows = 32;
        this.mPoolVariables = new SolverVariable[POOL_SIZE];
        this.mPoolVariablesCount = 0;
        this.mRows = new ArrayRow[32];
        releaseRows();
        Cache cache = new Cache();
        this.mCache = cache;
        this.mGoal = new PriorityGoalRow(cache);
        this.mTempGoal = new ArrayRow(this.mCache);
    }

    public final SolverVariable acquireSolverVariable(Type type, String str) {
        SolverVariable solverVariable = (SolverVariable) this.mCache.solverVariablePool.acquire();
        if (solverVariable == null) {
            solverVariable = new SolverVariable(type);
            solverVariable.mType = type;
        } else {
            solverVariable.reset();
            solverVariable.mType = type;
        }
        int i = this.mPoolVariablesCount;
        int i2 = POOL_SIZE;
        if (i >= i2) {
            int i3 = i2 * 2;
            POOL_SIZE = i3;
            this.mPoolVariables = (SolverVariable[]) Arrays.copyOf(this.mPoolVariables, i3);
        }
        SolverVariable[] solverVariableArr = this.mPoolVariables;
        int i4 = this.mPoolVariablesCount;
        this.mPoolVariablesCount = i4 + 1;
        solverVariableArr[i4] = solverVariable;
        return solverVariable;
    }

    public void addCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f2, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2, int i3) {
        ArrayRow createRow = createRow();
        if (solverVariable2 == solverVariable3) {
            createRow.variables.put(solverVariable, 1.0f);
            createRow.variables.put(solverVariable4, 1.0f);
            createRow.variables.put(solverVariable2, -2.0f);
        } else if (f2 == 0.5f) {
            createRow.variables.put(solverVariable, 1.0f);
            createRow.variables.put(solverVariable2, -1.0f);
            createRow.variables.put(solverVariable3, -1.0f);
            createRow.variables.put(solverVariable4, 1.0f);
            if (i > 0 || i2 > 0) {
                createRow.constantValue = (float) ((-i) + i2);
            }
        } else if (f2 <= 0.0f) {
            createRow.variables.put(solverVariable, -1.0f);
            createRow.variables.put(solverVariable2, 1.0f);
            createRow.constantValue = (float) i;
        } else if (f2 >= 1.0f) {
            createRow.variables.put(solverVariable4, -1.0f);
            createRow.variables.put(solverVariable3, 1.0f);
            createRow.constantValue = (float) (-i2);
        } else {
            float f3 = 1.0f - f2;
            createRow.variables.put(solverVariable, f3 * 1.0f);
            createRow.variables.put(solverVariable2, f3 * -1.0f);
            createRow.variables.put(solverVariable3, -1.0f * f2);
            createRow.variables.put(solverVariable4, 1.0f * f2);
            if (i > 0 || i2 > 0) {
                createRow.constantValue = (((float) i2) * f2) + (((float) (-i)) * f3);
            }
        }
        if (i3 != 8) {
            createRow.addError(this, i3);
        }
        addConstraint(createRow);
    }

    /* JADX WARNING: Removed duplicated region for block: B:122:0x01fc A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01fd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addConstraint(androidx.constraintlayout.core.ArrayRow r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            int r2 = r0.mNumRows
            r3 = 1
            int r2 = r2 + r3
            int r4 = r0.mMaxRows
            if (r2 >= r4) goto L_0x0013
            int r2 = r0.mNumColumns
            int r2 = r2 + r3
            int r4 = r0.mMaxColumns
            if (r2 < r4) goto L_0x0016
        L_0x0013:
            r16.increaseTableSize()
        L_0x0016:
            boolean r2 = r1.isSimpleDefinition
            if (r2 != 0) goto L_0x01ff
            androidx.constraintlayout.core.ArrayRow[] r2 = r0.mRows
            int r2 = r2.length
            r5 = -1
            if (r2 != 0) goto L_0x0022
            goto L_0x00c1
        L_0x0022:
            r2 = 0
        L_0x0023:
            if (r2 != 0) goto L_0x00b1
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r6 = r1.variables
            int r6 = r6.getCurrentSize()
            r7 = 0
        L_0x002c:
            if (r7 >= r6) goto L_0x0048
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r8 = r1.variables
            androidx.constraintlayout.core.SolverVariable r8 = r8.getVariable(r7)
            int r9 = r8.definitionId
            if (r9 != r5) goto L_0x0040
            boolean r9 = r8.isFinalValue
            if (r9 != 0) goto L_0x0040
            boolean r9 = r8.isSynonym
            if (r9 == 0) goto L_0x0045
        L_0x0040:
            java.util.ArrayList<androidx.constraintlayout.core.SolverVariable> r9 = r1.variablesToUpdate
            r9.add(r8)
        L_0x0045:
            int r7 = r7 + 1
            goto L_0x002c
        L_0x0048:
            java.util.ArrayList<androidx.constraintlayout.core.SolverVariable> r6 = r1.variablesToUpdate
            int r6 = r6.size()
            if (r6 <= 0) goto L_0x00ae
            r7 = 0
        L_0x0051:
            if (r7 >= r6) goto L_0x00a7
            java.util.ArrayList<androidx.constraintlayout.core.SolverVariable> r8 = r1.variablesToUpdate
            java.lang.Object r8 = r8.get(r7)
            androidx.constraintlayout.core.SolverVariable r8 = (androidx.constraintlayout.core.SolverVariable) r8
            boolean r9 = r8.isFinalValue
            if (r9 == 0) goto L_0x0063
            r1.updateFromFinalVariable(r0, r8, r3)
            goto L_0x00a4
        L_0x0063:
            boolean r9 = r8.isSynonym
            if (r9 == 0) goto L_0x009b
            if (r9 != 0) goto L_0x006a
            goto L_0x00a4
        L_0x006a:
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r9 = r1.variables
            float r9 = r9.get(r8)
            float r10 = r1.constantValue
            float r11 = r8.synonymDelta
            float r11 = r11 * r9
            float r11 = r11 + r10
            r1.constantValue = r11
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r10 = r1.variables
            r10.remove(r8, r3)
            r8.removeFromRow(r1)
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r10 = r1.variables
            androidx.constraintlayout.core.Cache r11 = r0.mCache
            androidx.constraintlayout.core.SolverVariable[] r11 = r11.mIndexedVariables
            int r8 = r8.synonym
            r8 = r11[r8]
            r10.add(r8, r9, r3)
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r8 = r1.variables
            int r8 = r8.getCurrentSize()
            if (r8 != 0) goto L_0x00a4
            r1.isSimpleDefinition = r3
            r0.hasSimpleDefinition = r3
            goto L_0x00a4
        L_0x009b:
            androidx.constraintlayout.core.ArrayRow[] r9 = r0.mRows
            int r8 = r8.definitionId
            r8 = r9[r8]
            r1.updateFromRow(r0, r8, r3)
        L_0x00a4:
            int r7 = r7 + 1
            goto L_0x0051
        L_0x00a7:
            java.util.ArrayList<androidx.constraintlayout.core.SolverVariable> r6 = r1.variablesToUpdate
            r6.clear()
            goto L_0x0023
        L_0x00ae:
            r2 = 1
            goto L_0x0023
        L_0x00b1:
            androidx.constraintlayout.core.SolverVariable r2 = r1.variable
            if (r2 == 0) goto L_0x00c1
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r2 = r1.variables
            int r2 = r2.getCurrentSize()
            if (r2 != 0) goto L_0x00c1
            r1.isSimpleDefinition = r3
            r0.hasSimpleDefinition = r3
        L_0x00c1:
            boolean r2 = r17.isEmpty()
            if (r2 == 0) goto L_0x00c8
            return
        L_0x00c8:
            float r2 = r1.constantValue
            r6 = 0
            int r7 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r7 >= 0) goto L_0x00da
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r2 = r2 * r7
            r1.constantValue = r2
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r2 = r1.variables
            r2.invert()
        L_0x00da:
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r2 = r1.variables
            int r2 = r2.getCurrentSize()
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
        L_0x00e7:
            if (r8 >= r2) goto L_0x0144
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r15 = r1.variables
            float r15 = r15.getVariableValue(r8)
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r4 = r1.variables
            androidx.constraintlayout.core.SolverVariable r4 = r4.getVariable(r8)
            androidx.constraintlayout.core.SolverVariable$Type r5 = r4.mType
            androidx.constraintlayout.core.SolverVariable$Type r7 = androidx.constraintlayout.core.SolverVariable.Type.UNRESTRICTED
            if (r5 != r7) goto L_0x011b
            if (r9 != 0) goto L_0x0103
            boolean r5 = r1.isNew(r4)
        L_0x0101:
            r12 = r5
            goto L_0x010c
        L_0x0103:
            int r5 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r5 <= 0) goto L_0x010f
            boolean r5 = r1.isNew(r4)
            goto L_0x0101
        L_0x010c:
            r9 = r4
            r11 = r15
            goto L_0x0140
        L_0x010f:
            if (r12 != 0) goto L_0x0140
            boolean r5 = r1.isNew(r4)
            if (r5 == 0) goto L_0x0140
            r9 = r4
            r11 = r15
            r12 = 1
            goto L_0x0140
        L_0x011b:
            if (r9 != 0) goto L_0x0140
            int r5 = (r15 > r6 ? 1 : (r15 == r6 ? 0 : -1))
            if (r5 >= 0) goto L_0x0140
            if (r10 != 0) goto L_0x0129
            boolean r5 = r1.isNew(r4)
        L_0x0127:
            r14 = r5
            goto L_0x0132
        L_0x0129:
            int r5 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r5 <= 0) goto L_0x0135
            boolean r5 = r1.isNew(r4)
            goto L_0x0127
        L_0x0132:
            r10 = r4
            r13 = r15
            goto L_0x0140
        L_0x0135:
            if (r14 != 0) goto L_0x0140
            boolean r5 = r1.isNew(r4)
            if (r5 == 0) goto L_0x0140
            r10 = r4
            r13 = r15
            r14 = 1
        L_0x0140:
            int r8 = r8 + 1
            r5 = -1
            goto L_0x00e7
        L_0x0144:
            if (r9 == 0) goto L_0x0147
            goto L_0x0148
        L_0x0147:
            r9 = r10
        L_0x0148:
            if (r9 != 0) goto L_0x014c
            r2 = 1
            goto L_0x0150
        L_0x014c:
            r1.pivot(r9)
            r2 = 0
        L_0x0150:
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r4 = r1.variables
            int r4 = r4.getCurrentSize()
            if (r4 != 0) goto L_0x015a
            r1.isSimpleDefinition = r3
        L_0x015a:
            if (r2 == 0) goto L_0x01e7
            int r2 = r0.mNumColumns
            int r2 = r2 + r3
            int r4 = r0.mMaxColumns
            if (r2 < r4) goto L_0x0166
            r16.increaseTableSize()
        L_0x0166:
            androidx.constraintlayout.core.SolverVariable$Type r2 = androidx.constraintlayout.core.SolverVariable.Type.SLACK
            r4 = 0
            androidx.constraintlayout.core.SolverVariable r2 = r0.acquireSolverVariable(r2, r4)
            int r4 = r0.mVariablesID
            int r4 = r4 + r3
            r0.mVariablesID = r4
            int r5 = r0.mNumColumns
            int r5 = r5 + r3
            r0.mNumColumns = r5
            r2.id = r4
            androidx.constraintlayout.core.Cache r5 = r0.mCache
            androidx.constraintlayout.core.SolverVariable[] r5 = r5.mIndexedVariables
            r5[r4] = r2
            r1.variable = r2
            int r4 = r0.mNumRows
            r16.addRow(r17)
            int r5 = r0.mNumRows
            int r4 = r4 + r3
            if (r5 != r4) goto L_0x01e7
            androidx.constraintlayout.core.LinearSystem$Row r4 = r0.mTempGoal
            androidx.constraintlayout.core.ArrayRow r4 = (androidx.constraintlayout.core.ArrayRow) r4
            if (r4 == 0) goto L_0x01e5
            r5 = 0
            r4.variable = r5
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r5 = r4.variables
            r5.clear()
            r5 = 0
        L_0x019a:
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r7 = r1.variables
            int r7 = r7.getCurrentSize()
            if (r5 >= r7) goto L_0x01b6
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r7 = r1.variables
            androidx.constraintlayout.core.SolverVariable r7 = r7.getVariable(r5)
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r8 = r1.variables
            float r8 = r8.getVariableValue(r5)
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r9 = r4.variables
            r9.add(r7, r8, r3)
            int r5 = r5 + 1
            goto L_0x019a
        L_0x01b6:
            androidx.constraintlayout.core.LinearSystem$Row r4 = r0.mTempGoal
            r0.optimize(r4)
            int r4 = r2.definitionId
            r5 = -1
            if (r4 != r5) goto L_0x01e3
            androidx.constraintlayout.core.SolverVariable r4 = r1.variable
            if (r4 != r2) goto L_0x01ce
            r4 = 0
            androidx.constraintlayout.core.SolverVariable r2 = r1.pickPivotInVariables(r4, r2)
            if (r2 == 0) goto L_0x01ce
            r1.pivot(r2)
        L_0x01ce:
            boolean r2 = r1.isSimpleDefinition
            if (r2 != 0) goto L_0x01d7
            androidx.constraintlayout.core.SolverVariable r2 = r1.variable
            r2.updateReferencesWithNewDefinition(r0, r1)
        L_0x01d7:
            androidx.constraintlayout.core.Cache r2 = r0.mCache
            androidx.constraintlayout.core.Pools$SimplePool<androidx.constraintlayout.core.ArrayRow> r2 = r2.arrayRowPool
            r2.release(r1)
            int r2 = r0.mNumRows
            int r2 = r2 - r3
            r0.mNumRows = r2
        L_0x01e3:
            r2 = 1
            goto L_0x01e8
        L_0x01e5:
            r2 = 0
            throw r2
        L_0x01e7:
            r2 = 0
        L_0x01e8:
            androidx.constraintlayout.core.SolverVariable r4 = r1.variable
            if (r4 == 0) goto L_0x01f9
            androidx.constraintlayout.core.SolverVariable$Type r4 = r4.mType
            androidx.constraintlayout.core.SolverVariable$Type r5 = androidx.constraintlayout.core.SolverVariable.Type.UNRESTRICTED
            if (r4 == r5) goto L_0x01fa
            float r4 = r1.constantValue
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 < 0) goto L_0x01f9
            goto L_0x01fa
        L_0x01f9:
            r3 = 0
        L_0x01fa:
            if (r3 != 0) goto L_0x01fd
            return
        L_0x01fd:
            r4 = r2
            goto L_0x0200
        L_0x01ff:
            r4 = 0
        L_0x0200:
            if (r4 != 0) goto L_0x0205
            r16.addRow(r17)
        L_0x0205:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.LinearSystem.addConstraint(androidx.constraintlayout.core.ArrayRow):void");
    }

    public ArrayRow addEquality(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        if (i2 == 8 && solverVariable2.isFinalValue && solverVariable.definitionId == -1) {
            solverVariable.setFinalValue(this, solverVariable2.computedValue + ((float) i));
            return null;
        }
        ArrayRow createRow = createRow();
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            createRow.constantValue = (float) i;
        }
        if (!z) {
            createRow.variables.put(solverVariable, -1.0f);
            createRow.variables.put(solverVariable2, 1.0f);
        } else {
            createRow.variables.put(solverVariable, 1.0f);
            createRow.variables.put(solverVariable2, -1.0f);
        }
        if (i2 != 8) {
            createRow.addError(this, i2);
        }
        addConstraint(createRow);
        return createRow;
    }

    public void addGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i);
        if (i2 != 8) {
            createRow.variables.put(createErrorVariable(i2, null), (float) ((int) (createRow.variables.get(createSlackVariable) * -1.0f)));
        }
        addConstraint(createRow);
    }

    public void addLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i);
        if (i2 != 8) {
            createRow.variables.put(createErrorVariable(i2, null), (float) ((int) (createRow.variables.get(createSlackVariable) * -1.0f)));
        }
        addConstraint(createRow);
    }

    public void addRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f2, int i) {
        ArrayRow createRow = createRow();
        createRow.createRowDimensionRatio(solverVariable, solverVariable2, solverVariable3, solverVariable4, f2);
        if (i != 8) {
            createRow.addError(this, i);
        }
        addConstraint(createRow);
    }

    public final void addRow(ArrayRow arrayRow) {
        int i;
        if (arrayRow.isSimpleDefinition) {
            arrayRow.variable.setFinalValue(this, arrayRow.constantValue);
        } else {
            ArrayRow[] arrayRowArr = this.mRows;
            int i2 = this.mNumRows;
            arrayRowArr[i2] = arrayRow;
            SolverVariable solverVariable = arrayRow.variable;
            solverVariable.definitionId = i2;
            this.mNumRows = i2 + 1;
            solverVariable.updateReferencesWithNewDefinition(this, arrayRow);
        }
        if (this.hasSimpleDefinition) {
            int i3 = 0;
            while (i3 < this.mNumRows) {
                if (this.mRows[i3] == null) {
                    System.out.println("WTF");
                }
                ArrayRow[] arrayRowArr2 = this.mRows;
                if (arrayRowArr2[i3] != null && arrayRowArr2[i3].isSimpleDefinition) {
                    ArrayRow arrayRow2 = arrayRowArr2[i3];
                    arrayRow2.variable.setFinalValue(this, arrayRow2.constantValue);
                    this.mCache.arrayRowPool.release(arrayRow2);
                    this.mRows[i3] = null;
                    int i4 = i3 + 1;
                    int i5 = i4;
                    while (true) {
                        i = this.mNumRows;
                        if (i4 >= i) {
                            break;
                        }
                        ArrayRow[] arrayRowArr3 = this.mRows;
                        int i6 = i4 - 1;
                        arrayRowArr3[i6] = arrayRowArr3[i4];
                        if (arrayRowArr3[i6].variable.definitionId == i4) {
                            arrayRowArr3[i6].variable.definitionId = i6;
                        }
                        i5 = i4;
                        i4++;
                    }
                    if (i5 < i) {
                        this.mRows[i5] = null;
                    }
                    this.mNumRows--;
                    i3--;
                }
                i3++;
            }
            this.hasSimpleDefinition = false;
        }
    }

    public final void computeValues() {
        for (int i = 0; i < this.mNumRows; i++) {
            ArrayRow arrayRow = this.mRows[i];
            arrayRow.variable.computedValue = arrayRow.constantValue;
        }
    }

    public SolverVariable createErrorVariable(int i, String str) {
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(Type.ERROR, str);
        int i2 = this.mVariablesID + 1;
        this.mVariablesID = i2;
        this.mNumColumns++;
        acquireSolverVariable.id = i2;
        acquireSolverVariable.strength = i;
        this.mCache.mIndexedVariables[i2] = acquireSolverVariable;
        this.mGoal.addError(acquireSolverVariable);
        return acquireSolverVariable;
    }

    public SolverVariable createObjectVariable(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.mSolverVariable;
            if (solverVariable == null) {
                constraintAnchor.resetSolverVariable();
                solverVariable = constraintAnchor.mSolverVariable;
            }
            int i = solverVariable.id;
            if (i == -1 || i > this.mVariablesID || this.mCache.mIndexedVariables[i] == null) {
                if (solverVariable.id != -1) {
                    solverVariable.reset();
                }
                int i2 = this.mVariablesID + 1;
                this.mVariablesID = i2;
                this.mNumColumns++;
                solverVariable.id = i2;
                solverVariable.mType = Type.UNRESTRICTED;
                this.mCache.mIndexedVariables[i2] = solverVariable;
            }
        }
        return solverVariable;
    }

    public ArrayRow createRow() {
        ArrayRow arrayRow = (ArrayRow) this.mCache.arrayRowPool.acquire();
        if (arrayRow == null) {
            arrayRow = new ArrayRow(this.mCache);
            ARRAY_ROW_CREATION++;
        } else {
            arrayRow.variable = null;
            arrayRow.variables.clear();
            arrayRow.constantValue = 0.0f;
            arrayRow.isSimpleDefinition = false;
        }
        SolverVariable.uniqueErrorId++;
        return arrayRow;
    }

    public SolverVariable createSlackVariable() {
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(Type.SLACK, null);
        int i = this.mVariablesID + 1;
        this.mVariablesID = i;
        this.mNumColumns++;
        acquireSolverVariable.id = i;
        this.mCache.mIndexedVariables[i] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    public int getObjectVariableValue(Object obj) {
        SolverVariable solverVariable = ((ConstraintAnchor) obj).mSolverVariable;
        if (solverVariable != null) {
            return (int) (solverVariable.computedValue + 0.5f);
        }
        return 0;
    }

    public final void increaseTableSize() {
        int i = this.TABLE_SIZE * 2;
        this.TABLE_SIZE = i;
        this.mRows = (ArrayRow[]) Arrays.copyOf(this.mRows, i);
        Cache cache = this.mCache;
        cache.mIndexedVariables = (SolverVariable[]) Arrays.copyOf(cache.mIndexedVariables, this.TABLE_SIZE);
        int i2 = this.TABLE_SIZE;
        this.mAlreadyTestedCandidates = new boolean[i2];
        this.mMaxColumns = i2;
        this.mMaxRows = i2;
    }

    public void minimize() throws Exception {
        if (this.mGoal.isEmpty()) {
            computeValues();
            return;
        }
        if (this.graphOptimizer || this.newgraphOptimizer) {
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= this.mNumRows) {
                    z = true;
                    break;
                } else if (!this.mRows[i].isSimpleDefinition) {
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                minimizeGoal(this.mGoal);
            } else {
                computeValues();
            }
        } else {
            minimizeGoal(this.mGoal);
        }
    }

    public void minimizeGoal(Row row) throws Exception {
        float f2;
        int i;
        boolean z;
        int i2 = 0;
        while (true) {
            f2 = 0.0f;
            i = 1;
            if (i2 >= this.mNumRows) {
                z = false;
                break;
            }
            ArrayRow[] arrayRowArr = this.mRows;
            if (arrayRowArr[i2].variable.mType != Type.UNRESTRICTED && arrayRowArr[i2].constantValue < 0.0f) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            boolean z2 = false;
            int i3 = 0;
            while (!z2) {
                i3 += i;
                float f3 = Float.MAX_VALUE;
                int i4 = 0;
                int i5 = -1;
                int i6 = -1;
                int i7 = 0;
                while (i4 < this.mNumRows) {
                    ArrayRow arrayRow = this.mRows[i4];
                    if (arrayRow.variable.mType != Type.UNRESTRICTED && !arrayRow.isSimpleDefinition && arrayRow.constantValue < f2) {
                        int currentSize = arrayRow.variables.getCurrentSize();
                        int i8 = 0;
                        while (i8 < currentSize) {
                            SolverVariable variable = arrayRow.variables.getVariable(i8);
                            float f4 = arrayRow.variables.get(variable);
                            if (f4 > f2) {
                                for (int i9 = 0; i9 < 9; i9++) {
                                    float f5 = variable.strengthVector[i9] / f4;
                                    if ((f5 < f3 && i9 == i7) || i9 > i7) {
                                        i6 = variable.id;
                                        i7 = i9;
                                        f3 = f5;
                                        i5 = i4;
                                    }
                                }
                            }
                            i8++;
                            f2 = 0.0f;
                        }
                    }
                    i4++;
                    f2 = 0.0f;
                }
                if (i5 != -1) {
                    ArrayRow arrayRow2 = this.mRows[i5];
                    arrayRow2.variable.definitionId = -1;
                    arrayRow2.pivot(this.mCache.mIndexedVariables[i6]);
                    SolverVariable solverVariable = arrayRow2.variable;
                    solverVariable.definitionId = i5;
                    solverVariable.updateReferencesWithNewDefinition(this, arrayRow2);
                } else {
                    z2 = true;
                }
                if (i3 > this.mNumColumns / 2) {
                    z2 = true;
                }
                f2 = 0.0f;
                i = 1;
            }
        }
        optimize(row);
        computeValues();
    }

    public final int optimize(Row row) {
        for (int i = 0; i < this.mNumColumns; i++) {
            this.mAlreadyTestedCandidates[i] = false;
        }
        boolean z = false;
        int i2 = 0;
        while (!z) {
            i2++;
            if (i2 >= this.mNumColumns * 2) {
                return i2;
            }
            SolverVariable solverVariable = ((ArrayRow) row).variable;
            if (solverVariable != null) {
                this.mAlreadyTestedCandidates[solverVariable.id] = true;
            }
            SolverVariable pivotCandidate = row.getPivotCandidate(this, this.mAlreadyTestedCandidates);
            if (pivotCandidate != null) {
                boolean[] zArr = this.mAlreadyTestedCandidates;
                int i3 = pivotCandidate.id;
                if (zArr[i3]) {
                    return i2;
                }
                zArr[i3] = true;
            }
            if (pivotCandidate != null) {
                float f2 = Float.MAX_VALUE;
                int i4 = -1;
                for (int i5 = 0; i5 < this.mNumRows; i5++) {
                    ArrayRow arrayRow = this.mRows[i5];
                    if (arrayRow.variable.mType != Type.UNRESTRICTED && !arrayRow.isSimpleDefinition && arrayRow.variables.contains(pivotCandidate)) {
                        float f3 = arrayRow.variables.get(pivotCandidate);
                        if (f3 < 0.0f) {
                            float f4 = (-arrayRow.constantValue) / f3;
                            if (f4 < f2) {
                                i4 = i5;
                                f2 = f4;
                            }
                        }
                    }
                }
                if (i4 > -1) {
                    ArrayRow arrayRow2 = this.mRows[i4];
                    arrayRow2.variable.definitionId = -1;
                    arrayRow2.pivot(pivotCandidate);
                    SolverVariable solverVariable2 = arrayRow2.variable;
                    solverVariable2.definitionId = i4;
                    solverVariable2.updateReferencesWithNewDefinition(this, arrayRow2);
                }
            } else {
                z = true;
            }
        }
        return i2;
    }

    public final void releaseRows() {
        for (int i = 0; i < this.mNumRows; i++) {
            ArrayRow arrayRow = this.mRows[i];
            if (arrayRow != null) {
                this.mCache.arrayRowPool.release(arrayRow);
            }
            this.mRows[i] = null;
        }
    }

    public void reset() {
        Cache cache;
        int i = 0;
        while (true) {
            cache = this.mCache;
            SolverVariable[] solverVariableArr = cache.mIndexedVariables;
            if (i >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i];
            if (solverVariable != null) {
                solverVariable.reset();
            }
            i++;
        }
        Pools$SimplePool<SolverVariable> pools$SimplePool = cache.solverVariablePool;
        SolverVariable[] solverVariableArr2 = this.mPoolVariables;
        int i2 = this.mPoolVariablesCount;
        if (pools$SimplePool != null) {
            if (i2 > solverVariableArr2.length) {
                i2 = solverVariableArr2.length;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                SolverVariable solverVariable2 = solverVariableArr2[i3];
                int i4 = pools$SimplePool.mPoolSize;
                Object[] objArr = pools$SimplePool.mPool;
                if (i4 < objArr.length) {
                    objArr[i4] = solverVariable2;
                    pools$SimplePool.mPoolSize = i4 + 1;
                }
            }
            this.mPoolVariablesCount = 0;
            Arrays.fill(this.mCache.mIndexedVariables, null);
            HashMap<String, SolverVariable> hashMap = this.mVariables;
            if (hashMap != null) {
                hashMap.clear();
            }
            this.mVariablesID = 0;
            this.mGoal.clear();
            this.mNumColumns = 1;
            for (int i5 = 0; i5 < this.mNumRows; i5++) {
                ArrayRow[] arrayRowArr = this.mRows;
                if (arrayRowArr[i5] != null) {
                    arrayRowArr[i5].used = false;
                }
            }
            releaseRows();
            this.mNumRows = 0;
            this.mTempGoal = new ArrayRow(this.mCache);
            return;
        }
        throw null;
    }

    public void addEquality(SolverVariable solverVariable, int i) {
        int i2 = solverVariable.definitionId;
        if (i2 == -1) {
            float f2 = (float) i;
            solverVariable.setFinalValue(this, f2);
            for (int i3 = 0; i3 < this.mVariablesID + 1; i3++) {
                SolverVariable solverVariable2 = this.mCache.mIndexedVariables[i3];
                if (solverVariable2 != null && solverVariable2.isSynonym && solverVariable2.synonym == solverVariable.id) {
                    solverVariable2.setFinalValue(this, solverVariable2.synonymDelta + f2);
                }
            }
            return;
        }
        if (i2 != -1) {
            ArrayRow arrayRow = this.mRows[i2];
            if (arrayRow.isSimpleDefinition) {
                arrayRow.constantValue = (float) i;
            } else if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.isSimpleDefinition = true;
                arrayRow.constantValue = (float) i;
            } else {
                ArrayRow createRow = createRow();
                if (i < 0) {
                    createRow.constantValue = (float) (i * -1);
                    createRow.variables.put(solverVariable, 1.0f);
                } else {
                    createRow.constantValue = (float) i;
                    createRow.variables.put(solverVariable, -1.0f);
                }
                addConstraint(createRow);
            }
        } else {
            ArrayRow createRow2 = createRow();
            createRow2.variable = solverVariable;
            float f3 = (float) i;
            solverVariable.computedValue = f3;
            createRow2.constantValue = f3;
            createRow2.isSimpleDefinition = true;
            addConstraint(createRow2);
        }
    }
}
