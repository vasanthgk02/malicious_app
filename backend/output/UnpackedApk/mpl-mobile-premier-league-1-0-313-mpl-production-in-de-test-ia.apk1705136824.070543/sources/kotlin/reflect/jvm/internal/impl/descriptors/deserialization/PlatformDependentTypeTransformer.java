package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: PlatformDependentTypeTransformer.kt */
public interface PlatformDependentTypeTransformer {

    /* compiled from: PlatformDependentTypeTransformer.kt */
    public static final class None implements PlatformDependentTypeTransformer {
        public static final None INSTANCE = new None();

        public SimpleType transformPlatformType(ClassId classId, SimpleType simpleType) {
            Intrinsics.checkNotNullParameter(classId, "classId");
            Intrinsics.checkNotNullParameter(simpleType, "computedType");
            return simpleType;
        }
    }

    SimpleType transformPlatformType(ClassId classId, SimpleType simpleType);
}
