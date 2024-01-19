package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Collection;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* compiled from: IntegerValueTypeConstructor.kt */
public final class IntegerValueTypeConstructor implements TypeConstructor {
    public KotlinBuiltIns getBuiltIns() {
        throw null;
    }

    public ClassifierDescriptor getDeclarationDescriptor() {
        return null;
    }

    public List<TypeParameterDescriptor> getParameters() {
        return EmptyList.INSTANCE;
    }

    public Collection<KotlinType> getSupertypes() {
        return null;
    }

    public boolean isDenotable() {
        return false;
    }

    public String toString() {
        return "IntegerValueType(0)";
    }
}
