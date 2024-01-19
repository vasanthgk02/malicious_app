package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: methodSignatureMapping.kt */
public final class TypeMappingConfigurationImpl implements TypeMappingConfiguration<JvmType> {
    public static final TypeMappingConfigurationImpl INSTANCE = new TypeMappingConfigurationImpl();

    public KotlinType commonSupertype(Collection<? extends KotlinType> collection) {
        Intrinsics.checkNotNullParameter(collection, "types");
        throw new AssertionError(Intrinsics.stringPlus("There should be no intersection type in existing descriptors, but found: ", ArraysKt___ArraysJvmKt.joinToString$default(collection, null, null, null, 0, null, null, 63)));
    }

    public String getPredefinedFullInternalNameForClass(ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(this, "this");
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        return null;
    }

    public String getPredefinedInternalNameForClass(ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        return null;
    }

    public Object getPredefinedTypeForClass(ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        return null;
    }

    public KotlinType preprocessType(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(this, "this");
        Intrinsics.checkNotNullParameter(kotlinType, "kotlinType");
        return null;
    }

    public void processErrorType(KotlinType kotlinType, ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(kotlinType, "kotlinType");
        Intrinsics.checkNotNullParameter(classDescriptor, "descriptor");
    }

    public boolean releaseCoroutines() {
        Intrinsics.checkNotNullParameter(this, "this");
        return true;
    }
}
