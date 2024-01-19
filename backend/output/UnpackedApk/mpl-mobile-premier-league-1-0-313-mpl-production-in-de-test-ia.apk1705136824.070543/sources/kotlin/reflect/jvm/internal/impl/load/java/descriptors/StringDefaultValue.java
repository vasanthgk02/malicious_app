package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import io.hansel.core.criteria.HSLCriteriaBuilder;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnotationDefaultValue.kt */
public final class StringDefaultValue extends AnnotationDefaultValue {
    public final String value;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public StringDefaultValue(String str) {
        // Intrinsics.checkNotNullParameter(str, HSLCriteriaBuilder.VALUE);
        super(null);
        this.value = str;
    }
}
