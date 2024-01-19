package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: constantValues.kt */
public final class DoubleValue extends ConstantValue<Double> {
    public DoubleValue(double d2) {
        super(Double.valueOf(d2));
    }

    public KotlinType getType(ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        KotlinBuiltIns builtIns = moduleDescriptor.getBuiltIns();
        if (builtIns != null) {
            SimpleType primitiveKotlinType = builtIns.getPrimitiveKotlinType(PrimitiveType.DOUBLE);
            if (primitiveKotlinType != null) {
                Intrinsics.checkNotNullExpressionValue(primitiveKotlinType, "module.builtIns.doubleType");
                return primitiveKotlinType;
            }
            KotlinBuiltIns.$$$reportNull$$$0(60);
            throw null;
        }
        throw null;
    }

    public String toString() {
        return ((Number) this.value).doubleValue() + ".toDouble()";
    }
}