package kotlin.reflect.jvm.internal.impl.types;

/* compiled from: Variance.kt */
public enum Variance {
    INVARIANT("", true, true, 0),
    IN_VARIANCE("in", true, false, -1),
    OUT_VARIANCE("out", false, true, 1);
    
    public final boolean allowsInPosition;
    public final boolean allowsOutPosition;
    public final String label;
    public final int superpositionFactor;

    /* access modifiers changed from: public */
    Variance(String str, boolean z, boolean z2, int i) {
        this.label = str;
        this.allowsInPosition = z;
        this.allowsOutPosition = z2;
        this.superpositionFactor = i;
    }

    public final boolean getAllowsOutPosition() {
        return this.allowsOutPosition;
    }

    public final String getLabel() {
        return this.label;
    }

    public String toString() {
        return this.label;
    }
}
