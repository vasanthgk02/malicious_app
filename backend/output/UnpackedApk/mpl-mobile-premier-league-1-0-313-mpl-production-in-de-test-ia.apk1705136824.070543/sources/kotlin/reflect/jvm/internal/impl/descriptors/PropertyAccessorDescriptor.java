package kotlin.reflect.jvm.internal.impl.descriptors;

public interface PropertyAccessorDescriptor extends FunctionDescriptor {
    PropertyDescriptor getCorrespondingProperty();

    boolean isDefault();
}
