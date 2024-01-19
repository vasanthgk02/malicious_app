package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: ConstantValueFactory.kt */
public final class ConstantValueFactory$createArrayValue$3 extends Lambda implements Function1<ModuleDescriptor, KotlinType> {
    public final /* synthetic */ PrimitiveType $componentType;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ConstantValueFactory$createArrayValue$3(PrimitiveType primitiveType) {
        // this.$componentType = primitiveType;
        super(1);
    }

    public Object invoke(Object obj) {
        ModuleDescriptor moduleDescriptor = (ModuleDescriptor) obj;
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        SimpleType primitiveArrayKotlinType = moduleDescriptor.getBuiltIns().getPrimitiveArrayKotlinType(this.$componentType);
        Intrinsics.checkNotNullExpressionValue(primitiveArrayKotlinType, "module.builtIns.getPrimitiveArrayKotlinType(componentType)");
        return primitiveArrayKotlinType;
    }
}
