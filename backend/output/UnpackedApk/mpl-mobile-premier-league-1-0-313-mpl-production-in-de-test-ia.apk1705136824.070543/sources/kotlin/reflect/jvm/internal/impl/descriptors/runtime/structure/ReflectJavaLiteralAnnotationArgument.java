package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import io.hansel.core.criteria.HSLCriteriaBuilder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLiteralAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaAnnotationArguments.kt */
public final class ReflectJavaLiteralAnnotationArgument extends ReflectJavaAnnotationArgument implements JavaLiteralAnnotationArgument {
    public final Object value;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ReflectJavaLiteralAnnotationArgument(Name name, Object obj) {
        // Intrinsics.checkNotNullParameter(obj, HSLCriteriaBuilder.VALUE);
        super(name);
        this.value = obj;
    }

    public Object getValue() {
        return this.value;
    }
}
