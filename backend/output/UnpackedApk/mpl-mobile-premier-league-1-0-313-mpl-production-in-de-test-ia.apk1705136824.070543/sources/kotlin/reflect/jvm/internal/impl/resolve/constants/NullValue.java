package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: constantValues.kt */
public final class NullValue extends ConstantValue<Void> {
    public NullValue() {
        super(null);
    }

    public KotlinType getType(ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        SimpleType makeNullableAsSpecified = moduleDescriptor.getBuiltIns().getNothingType().makeNullableAsSpecified(true);
        if (makeNullableAsSpecified != null) {
            Intrinsics.checkNotNullExpressionValue(makeNullableAsSpecified, "module.builtIns.nullableNothingType");
            return makeNullableAsSpecified;
        }
        KotlinBuiltIns.$$$reportNull$$$0(48);
        throw null;
    }
}
