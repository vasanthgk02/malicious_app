package kotlin.reflect.jvm.internal.impl.resolve.constants;

import io.hansel.core.criteria.HSLCriteriaBuilder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: constantValues.kt */
public final class AnnotationValue extends ConstantValue<AnnotationDescriptor> {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public AnnotationValue(AnnotationDescriptor annotationDescriptor) {
        // Intrinsics.checkNotNullParameter(annotationDescriptor, HSLCriteriaBuilder.VALUE);
        super(annotationDescriptor);
    }

    public KotlinType getType(ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        return ((AnnotationDescriptor) this.value).getType();
    }
}
