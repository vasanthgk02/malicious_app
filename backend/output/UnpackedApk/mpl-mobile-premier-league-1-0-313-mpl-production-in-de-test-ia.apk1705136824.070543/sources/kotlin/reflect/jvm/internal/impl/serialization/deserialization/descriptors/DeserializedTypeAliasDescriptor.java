package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor.CoroutinesCompatibilityMode;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: DeserializedMemberDescriptor.kt */
public final class DeserializedTypeAliasDescriptor extends AbstractTypeAliasDescriptor implements DeserializedMemberDescriptor {
    public final DeserializedContainerSource containerSource;
    public CoroutinesCompatibilityMode coroutinesExperimentalCompatibilityMode = CoroutinesCompatibilityMode.COMPATIBLE;
    public SimpleType defaultTypeImpl;
    public SimpleType expandedType;
    public final NameResolver nameResolver;
    public final ProtoBuf$TypeAlias proto;
    public final StorageManager storageManager;
    public List<? extends TypeParameterDescriptor> typeConstructorParameters;
    public final TypeTable typeTable;
    public SimpleType underlyingType;
    public final VersionRequirementTable versionRequirementTable;

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeserializedTypeAliasDescriptor(kotlin.reflect.jvm.internal.impl.storage.StorageManager r13, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r14, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r15, kotlin.reflect.jvm.internal.impl.name.Name r16, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r17, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias r18, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r19, kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r20, kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable r21, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource r22) {
        /*
            r12 = this;
            r6 = r12
            r7 = r13
            r8 = r18
            r9 = r19
            r10 = r20
            r11 = r21
            java.lang.String r0 = "storageManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "containingDeclaration"
            r1 = r14
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "annotations"
            r2 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "name"
            r3 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "visibility"
            r5 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "proto"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "nameResolver"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "typeTable"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "versionRequirementTable"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r4 = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE
            java.lang.String r0 = "NO_SOURCE"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            r0 = r12
            r0.<init>(r1, r2, r3, r4, r5)
            r6.storageManager = r7
            r6.proto = r8
            r6.nameResolver = r9
            r6.typeTable = r10
            r6.versionRequirementTable = r11
            r0 = r22
            r6.containerSource = r0
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor$CoroutinesCompatibilityMode r0 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE
            r6.coroutinesExperimentalCompatibilityMode = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeAliasDescriptor.<init>(kotlin.reflect.jvm.internal.impl.storage.StorageManager, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations, kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver, kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable, kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource):void");
    }

    public ClassDescriptor getClassDescriptor() {
        if (TweetUtils.isError(getExpandedType())) {
            return null;
        }
        ClassifierDescriptor declarationDescriptor = getExpandedType().getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            return (ClassDescriptor) declarationDescriptor;
        }
        return null;
    }

    public DeserializedContainerSource getContainerSource() {
        return this.containerSource;
    }

    public SimpleType getDefaultType() {
        SimpleType simpleType = this.defaultTypeImpl;
        if (simpleType != null) {
            return simpleType;
        }
        Intrinsics.throwUninitializedPropertyAccessException("defaultTypeImpl");
        throw null;
    }

    public SimpleType getExpandedType() {
        SimpleType simpleType = this.expandedType;
        if (simpleType != null) {
            return simpleType;
        }
        Intrinsics.throwUninitializedPropertyAccessException("expandedType");
        throw null;
    }

    public NameResolver getNameResolver() {
        return this.nameResolver;
    }

    public MessageLite getProto() {
        return this.proto;
    }

    public TypeTable getTypeTable() {
        return this.typeTable;
    }

    public SimpleType getUnderlyingType() {
        SimpleType simpleType = this.underlyingType;
        if (simpleType != null) {
            return simpleType;
        }
        Intrinsics.throwUninitializedPropertyAccessException("underlyingType");
        throw null;
    }

    public VersionRequirementTable getVersionRequirementTable() {
        return this.versionRequirementTable;
    }

    public List<VersionRequirement> getVersionRequirements() {
        return TweetUtils.getVersionRequirements(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0069 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initialize(java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> r25, kotlin.reflect.jvm.internal.impl.types.SimpleType r26, kotlin.reflect.jvm.internal.impl.types.SimpleType r27, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor.CoroutinesCompatibilityMode r28) {
        /*
            r24 = this;
            r8 = r24
            r0 = r25
            r1 = r26
            r2 = r27
            r9 = r28
            java.lang.String r3 = "declaredTypeParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r4 = "underlyingType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
            java.lang.String r4 = "expandedType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r4)
            java.lang.String r4 = "isExperimentalCoroutineInReleaseEnvironment"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            r8.declaredTypeParametersImpl = r0
            r8.underlyingType = r1
            r8.expandedType = r2
            java.util.List r0 = com.twitter.sdk.android.tweetui.TweetUtils.computeConstructorTypeParameters(r24)
            r8.typeConstructorParameters = r0
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = r24.getClassDescriptor()
            r10 = 0
            if (r0 != 0) goto L_0x0037
            r0 = r10
            goto L_0x003b
        L_0x0037:
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r0 = r0.getUnsubstitutedMemberScope()
        L_0x003b:
            if (r0 != 0) goto L_0x003f
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope$Empty r0 = kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty.INSTANCE
        L_0x003f:
            kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor$computeDefaultType$1 r1 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor$computeDefaultType$1
            r1.<init>(r8)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeUnsubstitutedType(r8, r0, r1)
            java.lang.String r1 = "@OptIn(TypeRefinement::class)\n    protected fun computeDefaultType(): SimpleType =\n        TypeUtils.makeUnsubstitutedType(this, classDescriptor?.unsubstitutedMemberScope ?: MemberScope.Empty) { kotlinTypeRefiner ->\n            kotlinTypeRefiner.refineDescriptor(this)?.defaultType\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r8.defaultTypeImpl = r0
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = r24.getClassDescriptor()
            if (r0 != 0) goto L_0x0057
            goto L_0x0143
        L_0x0057:
            java.util.Collection r0 = r0.getConstructors()
            java.lang.String r1 = "classDescriptor.constructors"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.Iterator r12 = r0.iterator()
        L_0x0069:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L_0x0143
            java.lang.Object r0 = r12.next()
            r13 = r0
            kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor r13 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor) r13
            kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptorImpl$Companion r0 = kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptorImpl.Companion
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r1 = r8.storageManager
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r0)
            java.lang.String r0 = "storageManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "typeAliasDescriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "constructor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = r24.getClassDescriptor()
            if (r0 != 0) goto L_0x0098
            r14 = r10
            goto L_0x00a1
        L_0x0098:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = r24.getExpandedType()
            kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor r0 = kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.create(r0)
            r14 = r0
        L_0x00a1:
            if (r14 != 0) goto L_0x00a4
            goto L_0x00e4
        L_0x00a4:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor r15 = r13.substitute(r14)
            if (r15 != 0) goto L_0x00ab
            goto L_0x00e4
        L_0x00ab:
            kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptorImpl r7 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptorImpl
            r4 = 0
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r5 = r13.getAnnotations()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r6 = r13.getKind()
            java.lang.String r0 = "constructor.kind"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r3 = r24.getSource()
            java.lang.String r0 = "typeAliasDescriptor.source"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            r0 = r7
            r2 = r24
            r16 = r3
            r3 = r15
            r25 = r7
            r7 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            java.util.List r3 = r13.getValueParameters()
            if (r3 == 0) goto L_0x013d
            r5 = 0
            r6 = 0
            r7 = 0
            r2 = r25
            r4 = r14
            java.util.List r20 = kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.getSubstitutedValueParameters(r2, r3, r4, r5, r6, r7)
            if (r20 != 0) goto L_0x00e6
        L_0x00e4:
            r7 = r10
            goto L_0x0135
        L_0x00e6:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r15.getReturnType()
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r0 = r0.unwrap()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = com.twitter.sdk.android.tweetui.TweetUtils.lowerIfFlexible(r0)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r1 = r24.getDefaultType()
            java.lang.String r2 = "typeAliasDescriptor.defaultType"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r21 = kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt.withAbbreviation(r0, r1)
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r0 = r13.getDispatchReceiverParameter()
            if (r0 != 0) goto L_0x010b
            r2 = r25
            r17 = r10
            goto L_0x0123
        L_0x010b:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r0.getType()
            kotlin.reflect.jvm.internal.impl.types.Variance r1 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r14.safeSubstitute(r0, r1)
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion r1 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
            if (r1 == 0) goto L_0x013c
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r1 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.EMPTY
            r2 = r25
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r0 = com.twitter.sdk.android.tweetui.TweetUtils.createExtensionReceiverParameterForCallable(r2, r0, r1)
            r17 = r0
        L_0x0123:
            r18 = 0
            java.util.List r19 = r24.getDeclaredTypeParameters()
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r22 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r0 = r8.visibilityImpl
            r16 = r2
            r23 = r0
            r16.initialize(r17, r18, r19, r20, r21, r22, r23)
            r7 = r2
        L_0x0135:
            if (r7 == 0) goto L_0x0069
            r11.add(r7)
            goto L_0x0069
        L_0x013c:
            throw r10
        L_0x013d:
            r0 = 26
            kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.$$$reportNull$$$0(r0)
            throw r10
        L_0x0143:
            r8.coroutinesExperimentalCompatibilityMode = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeAliasDescriptor.initialize(java.util.List, kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor$CoroutinesCompatibilityMode):void");
    }

    public DeclarationDescriptorNonRoot substitute(TypeSubstitutor typeSubstitutor) {
        Intrinsics.checkNotNullParameter(typeSubstitutor, "substitutor");
        if (typeSubstitutor.isEmpty()) {
            return this;
        }
        StorageManager storageManager2 = this.storageManager;
        DeclarationDescriptor containingDeclaration = getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(containingDeclaration, "containingDeclaration");
        Annotations annotations = getAnnotations();
        Intrinsics.checkNotNullExpressionValue(annotations, "annotations");
        Name name = getName();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        DeserializedTypeAliasDescriptor deserializedTypeAliasDescriptor = new DeserializedTypeAliasDescriptor(storageManager2, containingDeclaration, annotations, name, this.visibilityImpl, this.proto, this.nameResolver, this.typeTable, this.versionRequirementTable, this.containerSource);
        List<TypeParameterDescriptor> declaredTypeParameters = getDeclaredTypeParameters();
        KotlinType safeSubstitute = typeSubstitutor.safeSubstitute(getUnderlyingType(), Variance.INVARIANT);
        Intrinsics.checkNotNullExpressionValue(safeSubstitute, "substitutor.safeSubstitute(underlyingType, Variance.INVARIANT)");
        SimpleType asSimpleType = TweetUtils.asSimpleType(safeSubstitute);
        KotlinType safeSubstitute2 = typeSubstitutor.safeSubstitute(getExpandedType(), Variance.INVARIANT);
        Intrinsics.checkNotNullExpressionValue(safeSubstitute2, "substitutor.safeSubstitute(expandedType, Variance.INVARIANT)");
        deserializedTypeAliasDescriptor.initialize(declaredTypeParameters, asSimpleType, TweetUtils.asSimpleType(safeSubstitute2), this.coroutinesExperimentalCompatibilityMode);
        return deserializedTypeAliasDescriptor;
    }
}
