package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

public interface PropertyDescriptor extends CallableMemberDescriptor, VariableDescriptor {
    List<PropertyAccessorDescriptor> getAccessors();

    FieldDescriptor getBackingField();

    FieldDescriptor getDelegateField();

    PropertyGetterDescriptor getGetter();

    PropertyDescriptor getOriginal();

    Collection<? extends PropertyDescriptor> getOverriddenDescriptors();

    PropertySetterDescriptor getSetter();

    boolean isDelegated();

    PropertyDescriptor substitute(TypeSubstitutor typeSubstitutor);
}
