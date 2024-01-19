package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import kotlin._Assertions;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.CopyConfiguration;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* compiled from: TypeAliasConstructorDescriptor.kt */
public final class TypeAliasConstructorDescriptorImpl extends FunctionDescriptorImpl implements TypeAliasConstructorDescriptor {
    public static final Companion Companion = new Companion(null);
    public final StorageManager storageManager;
    public final TypeAliasDescriptor typeAliasDescriptor;
    public ClassConstructorDescriptor underlyingConstructorDescriptor;

    /* compiled from: TypeAliasConstructorDescriptor.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(TypeAliasConstructorDescriptorImpl.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;"));
    }

    public TypeAliasConstructorDescriptorImpl(StorageManager storageManager2, TypeAliasDescriptor typeAliasDescriptor2, ClassConstructorDescriptor classConstructorDescriptor, TypeAliasConstructorDescriptor typeAliasConstructorDescriptor, Annotations annotations, Kind kind, SourceElement sourceElement) {
        super(typeAliasDescriptor2, typeAliasConstructorDescriptor, annotations, Name.special("<init>"), kind, sourceElement);
        this.storageManager = storageManager2;
        this.typeAliasDescriptor = typeAliasDescriptor2;
        this.isActual = typeAliasDescriptor2.isActual();
        this.storageManager.createNullableLazyValue(new TypeAliasConstructorDescriptorImpl$withDispatchReceiver$2(this, classConstructorDescriptor));
        this.underlyingConstructorDescriptor = classConstructorDescriptor;
    }

    public FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, Kind kind, Name name, Annotations annotations, SourceElement sourceElement) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "newOwner");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(sourceElement, DefaultSettingsSpiCall.SOURCE_PARAM);
        boolean z = true;
        boolean z2 = kind == Kind.DECLARATION || kind == Kind.SYNTHESIZED;
        if (!_Assertions.ENABLED || z2) {
            if (name != null) {
                z = false;
            }
            if (!_Assertions.ENABLED || z) {
                TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl = new TypeAliasConstructorDescriptorImpl(this.storageManager, this.typeAliasDescriptor, this.underlyingConstructorDescriptor, this, annotations, Kind.DECLARATION, sourceElement);
                return typeAliasConstructorDescriptorImpl;
            }
            throw new AssertionError(Intrinsics.stringPlus("Renaming type alias constructor: ", this));
        }
        throw new AssertionError("Creating a type alias constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + declarationDescriptor + "\nkind: " + kind);
    }

    public ClassDescriptor getConstructedClass() {
        ClassDescriptor constructedClass = this.underlyingConstructorDescriptor.getConstructedClass();
        Intrinsics.checkNotNullExpressionValue(constructedClass, "underlyingConstructorDescriptor.constructedClass");
        return constructedClass;
    }

    public ClassifierDescriptorWithTypeParameters getContainingDeclaration() {
        return this.typeAliasDescriptor;
    }

    public KotlinType getReturnType() {
        KotlinType kotlinType = this.unsubstitutedReturnType;
        Intrinsics.checkNotNull(kotlinType);
        return kotlinType;
    }

    public ClassConstructorDescriptor getUnderlyingConstructorDescriptor() {
        return this.underlyingConstructorDescriptor;
    }

    public boolean isPrimary() {
        return this.underlyingConstructorDescriptor.isPrimary();
    }

    /* renamed from: getContainingDeclaration  reason: collision with other method in class */
    public DeclarationDescriptor m904getContainingDeclaration() {
        return this.typeAliasDescriptor;
    }

    public TypeAliasConstructorDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility descriptorVisibility, Kind kind, boolean z) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "newOwner");
        Intrinsics.checkNotNullParameter(modality, "modality");
        Intrinsics.checkNotNullParameter(descriptorVisibility, "visibility");
        Intrinsics.checkNotNullParameter(kind, "kind");
        CopyConfiguration copyConfiguration = (CopyConfiguration) newCopyBuilder();
        copyConfiguration.setOwner(declarationDescriptor);
        copyConfiguration.setModality(modality);
        copyConfiguration.setVisibility(descriptorVisibility);
        copyConfiguration.setKind(kind);
        copyConfiguration.setCopyOverrides(z);
        FunctionDescriptor build = copyConfiguration.build();
        if (build != null) {
            return (TypeAliasConstructorDescriptor) build;
        }
        throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
    }

    public TypeAliasConstructorDescriptor substitute(TypeSubstitutor typeSubstitutor) {
        Intrinsics.checkNotNullParameter(typeSubstitutor, "substitutor");
        FunctionDescriptor substitute = super.substitute(typeSubstitutor);
        if (substitute != null) {
            TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl = (TypeAliasConstructorDescriptorImpl) substitute;
            KotlinType kotlinType = typeAliasConstructorDescriptorImpl.unsubstitutedReturnType;
            Intrinsics.checkNotNull(kotlinType);
            TypeSubstitutor create = TypeSubstitutor.create(kotlinType);
            Intrinsics.checkNotNullExpressionValue(create, "create(substitutedTypeAliasConstructor.returnType)");
            ClassConstructorDescriptor substitute2 = this.underlyingConstructorDescriptor.getOriginal().substitute(create);
            if (substitute2 == null) {
                return null;
            }
            typeAliasConstructorDescriptorImpl.underlyingConstructorDescriptor = substitute2;
            return typeAliasConstructorDescriptorImpl;
        }
        throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
    }

    public TypeAliasConstructorDescriptor getOriginal() {
        return (TypeAliasConstructorDescriptor) super.getOriginal();
    }
}
