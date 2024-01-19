package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* compiled from: JavaToKotlinClassMapper.kt */
public final class JavaToKotlinClassMapper {
    public static final JavaToKotlinClassMapper INSTANCE = new JavaToKotlinClassMapper();

    public static ClassDescriptor mapJavaToKotlin$default(JavaToKotlinClassMapper javaToKotlinClassMapper, FqName fqName, KotlinBuiltIns kotlinBuiltIns, Integer num, int i) {
        int i2 = i & 4;
        if (javaToKotlinClassMapper != null) {
            Intrinsics.checkNotNullParameter(fqName, "fqName");
            Intrinsics.checkNotNullParameter(kotlinBuiltIns, "builtIns");
            ClassId mapJavaToKotlin = JavaToKotlinClassMap.INSTANCE.mapJavaToKotlin(fqName);
            if (mapJavaToKotlin != null) {
                return kotlinBuiltIns.getBuiltInClassByFqName(mapJavaToKotlin.asSingleFqName());
            }
            return null;
        }
        throw null;
    }

    public final ClassDescriptor convertReadOnlyToMutable(ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "readOnly");
        FqNameUnsafe fqName = DescriptorUtils.getFqName(classDescriptor);
        JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
        FqName fqName2 = JavaToKotlinClassMap.readOnlyToMutable.get(fqName);
        if (fqName2 != null) {
            ClassDescriptor builtInClassByFqName = DescriptorUtilsKt.getBuiltIns(classDescriptor).getBuiltInClassByFqName(fqName2);
            Intrinsics.checkNotNullExpressionValue(builtInClassByFqName, "descriptor.builtIns.getBuiltInClassByFqName(oppositeClassFqName)");
            return builtInClassByFqName;
        }
        throw new IllegalArgumentException("Given class " + classDescriptor + " is not a " + "read-only" + " collection");
    }

    public final boolean isMutable(ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "mutable");
        JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
        FqNameUnsafe fqName = DescriptorUtils.getFqName(classDescriptor);
        HashMap<FqNameUnsafe, FqName> hashMap = JavaToKotlinClassMap.mutableToReadOnly;
        if (hashMap != null) {
            return hashMap.containsKey(fqName);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    }

    public final boolean isReadOnly(ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "readOnly");
        JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
        FqNameUnsafe fqName = DescriptorUtils.getFqName(classDescriptor);
        HashMap<FqNameUnsafe, FqName> hashMap = JavaToKotlinClassMap.readOnlyToMutable;
        if (hashMap != null) {
            return hashMap.containsKey(fqName);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    }
}
