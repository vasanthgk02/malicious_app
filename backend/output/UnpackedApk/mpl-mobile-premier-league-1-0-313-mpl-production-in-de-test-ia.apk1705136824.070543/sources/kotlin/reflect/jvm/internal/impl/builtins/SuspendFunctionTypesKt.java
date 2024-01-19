package kotlin.reflect.jvm.internal.impl.builtins;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.MutableClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: suspendFunctionTypes.kt */
public final class SuspendFunctionTypesKt {
    public static final MutableClassDescriptor FAKE_CONTINUATION_CLASS_DESCRIPTOR_EXPERIMENTAL;
    public static final MutableClassDescriptor FAKE_CONTINUATION_CLASS_DESCRIPTOR_RELEASE;

    static {
        ModuleDescriptor errorModule = ErrorUtils.getErrorModule();
        Intrinsics.checkNotNullExpressionValue(errorModule, "getErrorModule()");
        MutableClassDescriptor mutableClassDescriptor = new MutableClassDescriptor(new EmptyPackageFragmentDescriptor(errorModule, StandardNames.COROUTINES_PACKAGE_FQ_NAME_EXPERIMENTAL), ClassKind.INTERFACE, false, false, StandardNames.CONTINUATION_INTERFACE_FQ_NAME_EXPERIMENTAL.shortName(), SourceElement.NO_SOURCE, LockBasedStorageManager.NO_LOCKS);
        Modality modality = Modality.ABSTRACT;
        if (modality != null) {
            mutableClassDescriptor.modality = modality;
            DescriptorVisibility descriptorVisibility = DescriptorVisibilities.PUBLIC;
            if (descriptorVisibility != null) {
                mutableClassDescriptor.visibility = descriptorVisibility;
                if (Annotations.Companion != null) {
                    mutableClassDescriptor.setTypeParameterDescriptors(TweetUtils.listOf(TypeParameterDescriptorImpl.createWithDefaultBound(mutableClassDescriptor, Companion.EMPTY, false, Variance.IN_VARIANCE, Name.identifier("T"), 0, LockBasedStorageManager.NO_LOCKS)));
                    mutableClassDescriptor.createTypeConstructor();
                    FAKE_CONTINUATION_CLASS_DESCRIPTOR_EXPERIMENTAL = mutableClassDescriptor;
                    ModuleDescriptor errorModule2 = ErrorUtils.getErrorModule();
                    Intrinsics.checkNotNullExpressionValue(errorModule2, "getErrorModule()");
                    MutableClassDescriptor mutableClassDescriptor2 = new MutableClassDescriptor(new EmptyPackageFragmentDescriptor(errorModule2, StandardNames.COROUTINES_PACKAGE_FQ_NAME_RELEASE), ClassKind.INTERFACE, false, false, StandardNames.CONTINUATION_INTERFACE_FQ_NAME_RELEASE.shortName(), SourceElement.NO_SOURCE, LockBasedStorageManager.NO_LOCKS);
                    Modality modality2 = Modality.ABSTRACT;
                    if (modality2 != null) {
                        mutableClassDescriptor2.modality = modality2;
                        DescriptorVisibility descriptorVisibility2 = DescriptorVisibilities.PUBLIC;
                        if (descriptorVisibility2 != null) {
                            mutableClassDescriptor2.visibility = descriptorVisibility2;
                            if (Annotations.Companion != null) {
                                mutableClassDescriptor2.setTypeParameterDescriptors(TweetUtils.listOf(TypeParameterDescriptorImpl.createWithDefaultBound(mutableClassDescriptor2, Companion.EMPTY, false, Variance.IN_VARIANCE, Name.identifier("T"), 0, LockBasedStorageManager.NO_LOCKS)));
                                mutableClassDescriptor2.createTypeConstructor();
                                FAKE_CONTINUATION_CLASS_DESCRIPTOR_RELEASE = mutableClassDescriptor2;
                                return;
                            }
                            throw null;
                        }
                        MutableClassDescriptor.$$$reportNull$$$0(9);
                        throw null;
                    }
                    MutableClassDescriptor.$$$reportNull$$$0(6);
                    throw null;
                }
                throw null;
            }
            MutableClassDescriptor.$$$reportNull$$$0(9);
            throw null;
        }
        MutableClassDescriptor.$$$reportNull$$$0(6);
        throw null;
    }

    public static final boolean isContinuation(FqName fqName, boolean z) {
        if (z) {
            return Intrinsics.areEqual(fqName, StandardNames.CONTINUATION_INTERFACE_FQ_NAME_RELEASE);
        }
        return Intrinsics.areEqual(fqName, StandardNames.CONTINUATION_INTERFACE_FQ_NAME_EXPERIMENTAL);
    }

    public static final SimpleType transformSuspendFunctionToRuntimeFunctionType(KotlinType kotlinType, boolean z) {
        TypeConstructor typeConstructor;
        Intrinsics.checkNotNullParameter(kotlinType, "suspendFunType");
        boolean isSuspendFunctionType = FunctionTypesKt.isSuspendFunctionType(kotlinType);
        if (!_Assertions.ENABLED || isSuspendFunctionType) {
            KotlinBuiltIns builtIns = TypeUtilsKt.getBuiltIns(kotlinType);
            Annotations annotations = kotlinType.getAnnotations();
            KotlinType receiverTypeFromFunctionType = FunctionTypesKt.getReceiverTypeFromFunctionType(kotlinType);
            List<TypeProjection> valueParameterTypesFromFunctionType = FunctionTypesKt.getValueParameterTypesFromFunctionType(kotlinType);
            ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(valueParameterTypesFromFunctionType, 10));
            for (TypeProjection type : valueParameterTypesFromFunctionType) {
                arrayList.add(type.getType());
            }
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            if (Annotations.Companion != null) {
                Annotations annotations2 = Companion.EMPTY;
                if (z) {
                    typeConstructor = FAKE_CONTINUATION_CLASS_DESCRIPTOR_RELEASE.getTypeConstructor();
                } else {
                    typeConstructor = FAKE_CONTINUATION_CLASS_DESCRIPTOR_EXPERIMENTAL.getTypeConstructor();
                }
                TypeConstructor typeConstructor2 = typeConstructor;
                Intrinsics.checkNotNullExpressionValue(typeConstructor2, "if (isReleaseCoroutines) FAKE_CONTINUATION_CLASS_DESCRIPTOR_RELEASE.typeConstructor\n                    else FAKE_CONTINUATION_CLASS_DESCRIPTOR_EXPERIMENTAL.typeConstructor");
                List plus = ArraysKt___ArraysJvmKt.plus((Collection<? extends T>) arrayList, KotlinTypeFactory.simpleType$default(annotations2, typeConstructor2, TweetUtils.listOf(TypeUtilsKt.asTypeProjection(FunctionTypesKt.getReturnTypeFromFunctionType(kotlinType))), false, null, 16));
                SimpleType nullableAnyType = TypeUtilsKt.getBuiltIns(kotlinType).getNullableAnyType();
                Intrinsics.checkNotNullExpressionValue(nullableAnyType, "suspendFunType.builtIns.nullableAnyType");
                return FunctionTypesKt.createFunctionType(builtIns, annotations, receiverTypeFromFunctionType, plus, null, nullableAnyType, false).makeNullableAsSpecified(kotlinType.isMarkedNullable());
            }
            throw null;
        }
        throw new AssertionError(Intrinsics.stringPlus("This type should be suspend function type: ", kotlinType));
    }
}
