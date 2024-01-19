package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: constantValues.kt */
public final class FloatValue extends ConstantValue<Float> {
    public FloatValue(float f2) {
        super(Float.valueOf(f2));
    }

    public KotlinType getType(ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        KotlinBuiltIns builtIns = moduleDescriptor.getBuiltIns();
        if (builtIns != null) {
            SimpleType primitiveKotlinType = builtIns.getPrimitiveKotlinType(PrimitiveType.FLOAT);
            if (primitiveKotlinType != null) {
                Intrinsics.checkNotNullExpressionValue(primitiveKotlinType, "module.builtIns.floatType");
                return primitiveKotlinType;
            }
            KotlinBuiltIns.$$$reportNull$$$0(59);
            throw null;
        }
        throw null;
    }

    public String toString() {
        return ((Number) this.value).floatValue() + ".toFloat()";
    }
}
