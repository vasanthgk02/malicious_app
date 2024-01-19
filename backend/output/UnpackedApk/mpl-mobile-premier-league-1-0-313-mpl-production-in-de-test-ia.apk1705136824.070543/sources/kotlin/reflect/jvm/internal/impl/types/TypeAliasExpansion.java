package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* compiled from: TypeAliasExpansion.kt */
public final class TypeAliasExpansion {
    public final List<TypeProjection> arguments;
    public final TypeAliasDescriptor descriptor;
    public final Map<TypeParameterDescriptor, TypeProjection> mapping;
    public final TypeAliasExpansion parent;

    public TypeAliasExpansion(TypeAliasExpansion typeAliasExpansion, TypeAliasDescriptor typeAliasDescriptor, List list, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this.parent = typeAliasExpansion;
        this.descriptor = typeAliasDescriptor;
        this.arguments = list;
        this.mapping = map;
    }

    public final boolean isRecursion(TypeAliasDescriptor typeAliasDescriptor) {
        Intrinsics.checkNotNullParameter(typeAliasDescriptor, "descriptor");
        if (!Intrinsics.areEqual(this.descriptor, typeAliasDescriptor)) {
            TypeAliasExpansion typeAliasExpansion = this.parent;
            if (!(typeAliasExpansion == null ? false : typeAliasExpansion.isRecursion(typeAliasDescriptor))) {
                return false;
            }
        }
        return true;
    }
}
