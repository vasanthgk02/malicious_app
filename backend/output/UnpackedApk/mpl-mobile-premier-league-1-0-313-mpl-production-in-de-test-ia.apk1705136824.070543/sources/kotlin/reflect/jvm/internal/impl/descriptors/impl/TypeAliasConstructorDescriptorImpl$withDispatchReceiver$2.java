package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptorImpl.Companion;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* compiled from: TypeAliasConstructorDescriptor.kt */
public final class TypeAliasConstructorDescriptorImpl$withDispatchReceiver$2 extends Lambda implements Function0<TypeAliasConstructorDescriptorImpl> {
    public final /* synthetic */ ClassConstructorDescriptor $underlyingConstructorDescriptor;
    public final /* synthetic */ TypeAliasConstructorDescriptorImpl this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public TypeAliasConstructorDescriptorImpl$withDispatchReceiver$2(TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl, ClassConstructorDescriptor classConstructorDescriptor) {
        // this.this$0 = typeAliasConstructorDescriptorImpl;
        // this.$underlyingConstructorDescriptor = classConstructorDescriptor;
        super(0);
    }

    public Object invoke() {
        TypeSubstitutor typeSubstitutor;
        TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl = this.this$0;
        StorageManager storageManager = typeAliasConstructorDescriptorImpl.storageManager;
        TypeAliasDescriptor typeAliasDescriptor = typeAliasConstructorDescriptorImpl.typeAliasDescriptor;
        ClassConstructorDescriptor classConstructorDescriptor = this.$underlyingConstructorDescriptor;
        Annotations annotations = classConstructorDescriptor.getAnnotations();
        Kind kind = this.$underlyingConstructorDescriptor.getKind();
        Intrinsics.checkNotNullExpressionValue(kind, "underlyingConstructorDescriptor.kind");
        SourceElement source = this.this$0.typeAliasDescriptor.getSource();
        Intrinsics.checkNotNullExpressionValue(source, "typeAliasDescriptor.source");
        TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl2 = new TypeAliasConstructorDescriptorImpl(storageManager, typeAliasDescriptor, classConstructorDescriptor, typeAliasConstructorDescriptorImpl, annotations, kind, source);
        TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl3 = this.this$0;
        ClassConstructorDescriptor classConstructorDescriptor2 = this.$underlyingConstructorDescriptor;
        Companion companion = TypeAliasConstructorDescriptorImpl.Companion;
        TypeAliasDescriptor typeAliasDescriptor2 = typeAliasConstructorDescriptorImpl3.typeAliasDescriptor;
        if (typeAliasDescriptor2.getClassDescriptor() == null) {
            typeSubstitutor = null;
        } else {
            typeSubstitutor = TypeSubstitutor.create((KotlinType) typeAliasDescriptor2.getExpandedType());
        }
        if (typeSubstitutor == null) {
            return null;
        }
        ReceiverParameterDescriptor dispatchReceiverParameter = classConstructorDescriptor2.getDispatchReceiverParameter();
        ReceiverParameterDescriptor substitute = dispatchReceiverParameter == null ? null : dispatchReceiverParameter.substitute(typeSubstitutor);
        List<TypeParameterDescriptor> declaredTypeParameters = typeAliasConstructorDescriptorImpl3.typeAliasDescriptor.getDeclaredTypeParameters();
        List<ValueParameterDescriptor> valueParameters = typeAliasConstructorDescriptorImpl3.getValueParameters();
        KotlinType kotlinType = typeAliasConstructorDescriptorImpl3.unsubstitutedReturnType;
        Intrinsics.checkNotNull(kotlinType);
        typeAliasConstructorDescriptorImpl2.initialize(null, substitute, declaredTypeParameters, valueParameters, kotlinType, Modality.FINAL, typeAliasConstructorDescriptorImpl3.typeAliasDescriptor.getVisibility());
        return typeAliasConstructorDescriptorImpl2;
    }
}
