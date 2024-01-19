package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Collection;
import java.util.Iterator;
import kotlin._Assertions;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* compiled from: ClassicBuiltinSpecialProperties.kt */
public final class ClassicBuiltinSpecialProperties {
    public static final ClassicBuiltinSpecialProperties INSTANCE = new ClassicBuiltinSpecialProperties();

    public final String getBuiltinSpecialPropertyGetterName(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "<this>");
        boolean isBuiltIn = KotlinBuiltIns.isBuiltIn(callableMemberDescriptor);
        if (!_Assertions.ENABLED || isBuiltIn) {
            CallableMemberDescriptor firstOverridden$default = DescriptorUtilsKt.firstOverridden$default(DescriptorUtilsKt.getPropertyIfAccessor(callableMemberDescriptor), false, new ClassicBuiltinSpecialProperties$getBuiltinSpecialPropertyGetterName$descriptor$1(this), 1);
            String str = null;
            if (firstOverridden$default == null) {
                return null;
            }
            BuiltinSpecialProperties builtinSpecialProperties = BuiltinSpecialProperties.INSTANCE;
            Name name = BuiltinSpecialProperties.PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP.get(DescriptorUtilsKt.getFqNameSafe(firstOverridden$default));
            if (name != null) {
                str = name.asString();
            }
            return str;
        }
        throw new AssertionError("This method is defined only for builtin members, but " + callableMemberDescriptor + " found");
    }

    public final boolean hasBuiltinSpecialPropertyFqName(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "callableMemberDescriptor");
        BuiltinSpecialProperties builtinSpecialProperties = BuiltinSpecialProperties.INSTANCE;
        boolean z = false;
        if (!BuiltinSpecialProperties.SPECIAL_SHORT_NAMES.contains(callableMemberDescriptor.getName())) {
            return false;
        }
        BuiltinSpecialProperties builtinSpecialProperties2 = BuiltinSpecialProperties.INSTANCE;
        if (ArraysKt___ArraysJvmKt.contains(BuiltinSpecialProperties.SPECIAL_FQ_NAMES, DescriptorUtilsKt.fqNameOrNull(callableMemberDescriptor)) && callableMemberDescriptor.getValueParameters().isEmpty()) {
            z = true;
        } else if (KotlinBuiltIns.isBuiltIn(callableMemberDescriptor)) {
            Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
            Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "overriddenDescriptors");
            if (!overriddenDescriptors.isEmpty()) {
                Iterator<T> it = overriddenDescriptors.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    CallableMemberDescriptor callableMemberDescriptor2 = (CallableMemberDescriptor) it.next();
                    Intrinsics.checkNotNullExpressionValue(callableMemberDescriptor2, "it");
                    if (hasBuiltinSpecialPropertyFqName(callableMemberDescriptor2)) {
                        break;
                    }
                }
                z = true;
            }
        }
        return z;
    }
}
