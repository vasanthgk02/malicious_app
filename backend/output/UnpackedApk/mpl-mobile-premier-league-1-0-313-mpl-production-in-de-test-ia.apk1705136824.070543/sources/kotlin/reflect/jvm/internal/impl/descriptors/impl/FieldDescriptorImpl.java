package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* compiled from: FieldDescriptorImpl.kt */
public final class FieldDescriptorImpl extends AnnotatedImpl implements FieldDescriptor {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public FieldDescriptorImpl(Annotations annotations, PropertyDescriptor propertyDescriptor) {
        // Intrinsics.checkNotNullParameter(annotations, "annotations");
        // Intrinsics.checkNotNullParameter(propertyDescriptor, "correspondingProperty");
        super(annotations);
    }
}
