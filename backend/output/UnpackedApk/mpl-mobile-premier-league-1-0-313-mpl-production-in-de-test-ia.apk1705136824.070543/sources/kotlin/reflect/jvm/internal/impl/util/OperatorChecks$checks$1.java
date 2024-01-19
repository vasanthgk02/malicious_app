package kotlin.reflect.jvm.internal.impl.util;

import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* compiled from: modifierChecks.kt */
public final class OperatorChecks$checks$1 extends Lambda implements Function1<FunctionDescriptor, String> {
    public static final OperatorChecks$checks$1 INSTANCE = new OperatorChecks$checks$1();

    public OperatorChecks$checks$1() {
        super(1);
    }

    public Object invoke(Object obj) {
        Object obj2;
        FunctionDescriptor functionDescriptor = (FunctionDescriptor) obj;
        Intrinsics.checkNotNullParameter(functionDescriptor, "<this>");
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "valueParameters");
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) ArraysKt___ArraysJvmKt.lastOrNull(valueParameters);
        if (valueParameterDescriptor == null) {
            obj2 = null;
        } else {
            obj2 = Boolean.valueOf(!DescriptorUtilsKt.declaresOrInheritsDefaultValue(valueParameterDescriptor) && valueParameterDescriptor.getVarargElementType() == null);
        }
        boolean areEqual = Intrinsics.areEqual(obj2, Boolean.TRUE);
        OperatorChecks operatorChecks = OperatorChecks.INSTANCE;
        if (!areEqual) {
            return "last parameter should not have a default value or be a vararg";
        }
        return null;
    }
}
