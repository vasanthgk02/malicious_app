package androidx.constraintlayout.core;

public class Cache {
    public Pools$SimplePool<ArrayRow> arrayRowPool = new Pools$SimplePool<>(256);
    public SolverVariable[] mIndexedVariables = new SolverVariable[32];
    public Pools$SimplePool<ArrayRow> optimizedArrayRowPool = new Pools$SimplePool<>(256);
    public Pools$SimplePool<SolverVariable> solverVariablePool = new Pools$SimplePool<>(256);
}
