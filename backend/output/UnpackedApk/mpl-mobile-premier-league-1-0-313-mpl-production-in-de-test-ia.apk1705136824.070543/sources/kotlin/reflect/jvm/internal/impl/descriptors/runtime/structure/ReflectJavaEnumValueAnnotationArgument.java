package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import io.hansel.core.criteria.HSLCriteriaBuilder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaAnnotationArguments.kt */
public final class ReflectJavaEnumValueAnnotationArgument extends ReflectJavaAnnotationArgument implements JavaEnumValueAnnotationArgument {
    public final Enum<?> value;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ReflectJavaEnumValueAnnotationArgument(Name name, Enum<?> enumR) {
        // Intrinsics.checkNotNullParameter(enumR, HSLCriteriaBuilder.VALUE);
        super(name);
        this.value = enumR;
    }

    public Name getEntryName() {
        return Name.identifier(this.value.name());
    }

    public ClassId getEnumClassId() {
        Class<?> cls = this.value.getClass();
        if (!cls.isEnum()) {
            cls = cls.getEnclosingClass();
        }
        Intrinsics.checkNotNullExpressionValue(cls, "enumClass");
        return ReflectClassUtilKt.getClassId(cls);
    }
}
