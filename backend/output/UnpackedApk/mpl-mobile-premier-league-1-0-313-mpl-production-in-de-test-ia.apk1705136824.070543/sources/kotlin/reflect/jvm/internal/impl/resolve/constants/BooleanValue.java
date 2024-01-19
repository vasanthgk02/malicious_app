package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: constantValues.kt */
public final class BooleanValue extends ConstantValue<Boolean> {
    public BooleanValue(boolean z) {
        super(Boolean.valueOf(z));
    }

    public KotlinType getType(ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        KotlinBuiltIns builtIns = moduleDescriptor.getBuiltIns();
        if (builtIns != null) {
            SimpleType primitiveKotlinType = builtIns.getPrimitiveKotlinType(PrimitiveType.BOOLEAN);
            if (primitiveKotlinType != null) {
                Intrinsics.checkNotNullExpressionValue(primitiveKotlinType, "module.builtIns.booleanType");
                return primitiveKotlinType;
            }
            KotlinBuiltIns.$$$reportNull$$$0(62);
            throw null;
        }
        throw null;
    }
}
