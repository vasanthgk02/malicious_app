package kotlin.reflect.jvm.internal.impl.types.model;

/* compiled from: TypeSystemContext.kt */
public enum TypeVariance {
    IN("in"),
    OUT("out"),
    INV("");
    
    public final String presentation;

    /* access modifiers changed from: public */
    TypeVariance(String str) {
        this.presentation = str;
    }

    public String toString() {
        return this.presentation;
    }
}
