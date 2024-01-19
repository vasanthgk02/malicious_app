package kotlin.reflect.jvm.internal.impl.load.java;

import io.hansel.core.criteria.HSLCriteriaBuilder;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: utils.kt */
public final class Constant extends JavaDefaultValue {
    public final Object value;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public Constant(Object obj) {
        // Intrinsics.checkNotNullParameter(obj, HSLCriteriaBuilder.VALUE);
        super(null);
        this.value = obj;
    }
}
