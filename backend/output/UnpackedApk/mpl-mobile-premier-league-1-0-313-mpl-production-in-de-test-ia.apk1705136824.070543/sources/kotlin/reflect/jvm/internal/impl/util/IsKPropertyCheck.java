package kotlin.reflect.jvm.internal.impl.util;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.Companion;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: modifierChecks.kt */
public final class IsKPropertyCheck implements Check {
    public static final IsKPropertyCheck INSTANCE = new IsKPropertyCheck();

    public boolean check(FunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        ValueParameterDescriptor valueParameterDescriptor = functionDescriptor.getValueParameters().get(1);
        Companion companion = ReflectionTypes.Companion;
        Intrinsics.checkNotNullExpressionValue(valueParameterDescriptor, "secondParameter");
        ModuleDescriptor module = DescriptorUtilsKt.getModule(valueParameterDescriptor);
        Intrinsics.checkNotNullParameter(module, "module");
        ClassDescriptor findClassAcrossModuleDependencies = TweetUtils.findClassAcrossModuleDependencies(module, FqNames.kProperty);
        SimpleType simpleType = null;
        if (findClassAcrossModuleDependencies != null) {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            if (Annotations.Companion != null) {
                Annotations annotations = Annotations.Companion.EMPTY;
                List<TypeParameterDescriptor> parameters = findClassAcrossModuleDependencies.getTypeConstructor().getParameters();
                Intrinsics.checkNotNullExpressionValue(parameters, "kPropertyClass.typeConstructor.parameters");
                Object single = ArraysKt___ArraysJvmKt.single(parameters);
                Intrinsics.checkNotNullExpressionValue(single, "kPropertyClass.typeConstructor.parameters.single()");
                simpleType = KotlinTypeFactory.simpleNotNullType(annotations, findClassAcrossModuleDependencies, TweetUtils.listOf(new StarProjectionImpl((TypeParameterDescriptor) single)));
            } else {
                throw null;
            }
        }
        if (simpleType == null) {
            return false;
        }
        KotlinType type = valueParameterDescriptor.getType();
        Intrinsics.checkNotNullExpressionValue(type, "secondParameter.type");
        KotlinType makeNotNullable = TypeUtilsKt.makeNotNullable(type);
        Intrinsics.checkNotNullParameter(simpleType, "<this>");
        Intrinsics.checkNotNullParameter(makeNotNullable, "superType");
        return KotlinTypeChecker.DEFAULT.isSubtypeOf(simpleType, makeNotNullable);
    }

    public String getDescription() {
        return "second parameter must be of type KProperty<*> or its supertype";
    }

    public String invoke(FunctionDescriptor functionDescriptor) {
        return TypeUtilsKt.invoke(this, functionDescriptor);
    }
}
