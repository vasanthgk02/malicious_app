package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$MemberKind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement.VersionKind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement.Version;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Package;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.WhenMappings;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor.CoroutinesCompatibilityMode;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedSimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.NonEmptyDeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: MemberDeserializer.kt */
public final class MemberDeserializer {
    public final AnnotationDeserializer annotationDeserializer;

    /* renamed from: c  reason: collision with root package name */
    public final DeserializationContext f5948c;

    public MemberDeserializer(DeserializationContext deserializationContext) {
        Intrinsics.checkNotNullParameter(deserializationContext, "c");
        this.f5948c = deserializationContext;
        DeserializationComponents deserializationComponents = deserializationContext.components;
        this.annotationDeserializer = new AnnotationDeserializer(deserializationComponents.moduleDescriptor, deserializationComponents.notFoundClasses);
    }

    public final ProtoContainer asProtoContainer(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor instanceof PackageFragmentDescriptor) {
            FqName fqName = ((PackageFragmentDescriptor) declarationDescriptor).getFqName();
            DeserializationContext deserializationContext = this.f5948c;
            return new Package(fqName, deserializationContext.nameResolver, deserializationContext.typeTable, deserializationContext.containerSource);
        } else if (declarationDescriptor instanceof DeserializedClassDescriptor) {
            return ((DeserializedClassDescriptor) declarationDescriptor).thisAsProtoContainer;
        } else {
            return null;
        }
    }

    public final CoroutinesCompatibilityMode checkExperimentalCoroutine(DeserializedMemberDescriptor deserializedMemberDescriptor, TypeDeserializer typeDeserializer) {
        CoroutinesCompatibilityMode coroutinesCompatibilityMode;
        if (!versionAndReleaseCoroutinesMismatch(deserializedMemberDescriptor)) {
            return CoroutinesCompatibilityMode.COMPATIBLE;
        }
        for (TypeParameterDescriptor upperBounds : typeDeserializer.getOwnTypeParameters()) {
            upperBounds.getUpperBounds();
        }
        if (typeDeserializer.experimentalSuspendFunctionTypeEncountered) {
            coroutinesCompatibilityMode = CoroutinesCompatibilityMode.INCOMPATIBLE;
        } else {
            coroutinesCompatibilityMode = CoroutinesCompatibilityMode.COMPATIBLE;
        }
        return coroutinesCompatibilityMode;
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x00b1 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor.CoroutinesCompatibilityMode computeExperimentalityModeForFunctions(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor r5, kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r6, java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> r7, java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> r8, kotlin.reflect.jvm.internal.impl.types.KotlinType r9, boolean r10) {
        /*
            r4 = this;
            boolean r0 = r4.versionAndReleaseCoroutinesMismatch(r5)
            if (r0 != 0) goto L_0x0009
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor$CoroutinesCompatibilityMode r5 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE
            return r5
        L_0x0009:
            kotlin.reflect.jvm.internal.impl.name.FqName r5 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.fqNameOrNull(r5)
            kotlin.reflect.jvm.internal.impl.name.FqName r0 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r0)
            if (r5 == 0) goto L_0x0018
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor$CoroutinesCompatibilityMode r5 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE
            return r5
        L_0x0018:
            java.util.ArrayList r5 = new java.util.ArrayList
            r0 = 10
            int r1 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r7, r0)
            r5.<init>(r1)
            java.util.Iterator r7 = r7.iterator()
        L_0x0027:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x003b
            java.lang.Object r1 = r7.next()
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r1
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r1.getType()
            r5.add(r1)
            goto L_0x0027
        L_0x003b:
            r7 = 0
            if (r6 != 0) goto L_0x0040
            r6 = r7
            goto L_0x0044
        L_0x0040:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r6 = r6.getType()
        L_0x0044:
            java.util.List r6 = com.twitter.sdk.android.tweetui.TweetUtils.listOfNotNull(r6)
            java.util.List r5 = kotlin.collections.ArraysKt___ArraysJvmKt.plus(r5, r6)
            if (r9 != 0) goto L_0x0050
            r6 = r7
            goto L_0x0058
        L_0x0050:
            boolean r6 = r4.containsSuspendFunctionType(r9)
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
        L_0x0058:
            java.lang.Boolean r9 = java.lang.Boolean.TRUE
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r9)
            if (r6 == 0) goto L_0x0063
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor$CoroutinesCompatibilityMode r5 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE
            return r5
        L_0x0063:
            boolean r6 = r8 instanceof java.util.Collection
            r9 = 1
            r1 = 0
            if (r6 == 0) goto L_0x0070
            boolean r6 = r8.isEmpty()
            if (r6 == 0) goto L_0x0070
            goto L_0x00b3
        L_0x0070:
            java.util.Iterator r6 = r8.iterator()
        L_0x0074:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x00b3
            java.lang.Object r8 = r6.next()
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r8 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r8
            java.util.List r8 = r8.getUpperBounds()
            java.lang.String r2 = "typeParameter.upperBounds"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r2)
            boolean r2 = r8.isEmpty()
            if (r2 == 0) goto L_0x0091
            goto L_0x00ae
        L_0x0091:
            java.util.Iterator r8 = r8.iterator()
        L_0x0095:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L_0x00ae
            java.lang.Object r2 = r8.next()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r2
            java.lang.String r3 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            boolean r2 = r4.containsSuspendFunctionType(r2)
            if (r2 == 0) goto L_0x0095
            r8 = 1
            goto L_0x00af
        L_0x00ae:
            r8 = 0
        L_0x00af:
            if (r8 == 0) goto L_0x0074
            r6 = 1
            goto L_0x00b4
        L_0x00b3:
            r6 = 0
        L_0x00b4:
            if (r6 == 0) goto L_0x00b9
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor$CoroutinesCompatibilityMode r5 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE
            return r5
        L_0x00b9:
            java.util.ArrayList r6 = new java.util.ArrayList
            int r8 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r5, r0)
            r6.<init>(r8)
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x00c8:
            boolean r8 = r5.hasNext()
            if (r8 == 0) goto L_0x0133
            java.lang.Object r8 = r5.next()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r8 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r8
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
            boolean r0 = kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.isSuspendFunctionType(r8)
            if (r0 == 0) goto L_0x0124
            java.util.List r0 = r8.getArguments()
            int r0 = r0.size()
            r2 = 3
            if (r0 > r2) goto L_0x0124
            java.util.List r8 = r8.getArguments()
            boolean r0 = r8 instanceof java.util.Collection
            if (r0 == 0) goto L_0x00fa
            boolean r0 = r8.isEmpty()
            if (r0 == 0) goto L_0x00fa
            goto L_0x011b
        L_0x00fa:
            java.util.Iterator r8 = r8.iterator()
        L_0x00fe:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x011b
            java.lang.Object r0 = r8.next()
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r0 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r0
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r0.getType()
            java.lang.String r2 = "it.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            boolean r0 = r4.containsSuspendFunctionType(r0)
            if (r0 == 0) goto L_0x00fe
            r8 = 1
            goto L_0x011c
        L_0x011b:
            r8 = 0
        L_0x011c:
            if (r8 == 0) goto L_0x0121
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor$CoroutinesCompatibilityMode r8 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE
            goto L_0x012f
        L_0x0121:
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor$CoroutinesCompatibilityMode r8 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor.CoroutinesCompatibilityMode.NEEDS_WRAPPER
            goto L_0x012f
        L_0x0124:
            boolean r8 = r4.containsSuspendFunctionType(r8)
            if (r8 == 0) goto L_0x012d
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor$CoroutinesCompatibilityMode r8 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE
            goto L_0x012f
        L_0x012d:
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor$CoroutinesCompatibilityMode r8 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE
        L_0x012f:
            r6.add(r8)
            goto L_0x00c8
        L_0x0133:
            java.lang.String r5 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r5)
            java.util.Iterator r5 = r6.iterator()
            boolean r6 = r5.hasNext()
            if (r6 != 0) goto L_0x0143
            goto L_0x015d
        L_0x0143:
            java.lang.Object r6 = r5.next()
            java.lang.Comparable r6 = (java.lang.Comparable) r6
        L_0x0149:
            r7 = r6
        L_0x014a:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x015d
            java.lang.Object r6 = r5.next()
            java.lang.Comparable r6 = (java.lang.Comparable) r6
            int r8 = r7.compareTo(r6)
            if (r8 >= 0) goto L_0x014a
            goto L_0x0149
        L_0x015d:
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor$CoroutinesCompatibilityMode r7 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor.CoroutinesCompatibilityMode) r7
            if (r7 != 0) goto L_0x0163
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor$CoroutinesCompatibilityMode r7 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE
        L_0x0163:
            if (r10 == 0) goto L_0x0168
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor$CoroutinesCompatibilityMode r5 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor.CoroutinesCompatibilityMode.NEEDS_WRAPPER
            goto L_0x016a
        L_0x0168:
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor$CoroutinesCompatibilityMode r5 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE
        L_0x016a:
            java.lang.String r6 = "a"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r6)
            java.lang.String r6 = "b"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r6)
            int r6 = r5.compareTo(r7)
            if (r6 < 0) goto L_0x017b
            r7 = r5
        L_0x017b:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer.computeExperimentalityModeForFunctions(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor, java.util.Collection, java.util.Collection, kotlin.reflect.jvm.internal.impl.types.KotlinType, boolean):kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor$CoroutinesCompatibilityMode");
    }

    public final boolean containsSuspendFunctionType(KotlinType kotlinType) {
        return TypeUtilsKt.contains(kotlinType, MemberDeserializer$containsSuspendFunctionType$1.INSTANCE);
    }

    public final Annotations getAnnotations(MessageLite messageLite, int i, AnnotatedCallableKind annotatedCallableKind) {
        if (Flags.HAS_ANNOTATIONS.get(i).booleanValue()) {
            return new NonEmptyDeserializedAnnotations(this.f5948c.components.storageManager, new MemberDeserializer$getAnnotations$1(this, messageLite, annotatedCallableKind));
        }
        if (Annotations.Companion != null) {
            return Companion.EMPTY;
        }
        throw null;
    }

    public final ReceiverParameterDescriptor getDispatchReceiverParameter() {
        DeclarationDescriptor declarationDescriptor = this.f5948c.containingDeclaration;
        ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
        if (classDescriptor == null) {
            return null;
        }
        return classDescriptor.getThisAsReceiverParameter();
    }

    public final Annotations getPropertyFieldAnnotations(ProtoBuf$Property protoBuf$Property, boolean z) {
        if (Flags.HAS_ANNOTATIONS.get(protoBuf$Property.flags_).booleanValue()) {
            return new NonEmptyDeserializedAnnotations(this.f5948c.components.storageManager, new MemberDeserializer$getPropertyFieldAnnotations$1(this, z, protoBuf$Property));
        }
        if (Annotations.Companion != null) {
            return Companion.EMPTY;
        }
        throw null;
    }

    public final ClassConstructorDescriptor loadConstructor(ProtoBuf$Constructor protoBuf$Constructor, boolean z) {
        DeserializationContext deserializationContext;
        DeserializedClassConstructorDescriptor deserializedClassConstructorDescriptor;
        CoroutinesCompatibilityMode coroutinesCompatibilityMode;
        ProtoBuf$Constructor protoBuf$Constructor2 = protoBuf$Constructor;
        Intrinsics.checkNotNullParameter(protoBuf$Constructor2, "proto");
        ClassDescriptor classDescriptor = (ClassDescriptor) this.f5948c.containingDeclaration;
        Annotations annotations = getAnnotations(protoBuf$Constructor2, protoBuf$Constructor2.flags_, AnnotatedCallableKind.FUNCTION);
        Kind kind = Kind.DECLARATION;
        DeserializationContext deserializationContext2 = this.f5948c;
        DeserializedClassConstructorDescriptor deserializedClassConstructorDescriptor2 = new DeserializedClassConstructorDescriptor(classDescriptor, null, annotations, z, kind, protoBuf$Constructor, deserializationContext2.nameResolver, deserializationContext2.typeTable, deserializationContext2.versionRequirementTable, deserializationContext2.containerSource, null);
        MemberDeserializer memberDeserializer = DeserializationContext.childContext$default(this.f5948c, deserializedClassConstructorDescriptor2, EmptyList.INSTANCE, null, null, null, null, 60).memberDeserializer;
        List<ProtoBuf$ValueParameter> list = protoBuf$Constructor2.valueParameter_;
        Intrinsics.checkNotNullExpressionValue(list, "proto.valueParameterList");
        deserializedClassConstructorDescriptor2.initialize(memberDeserializer.valueParameters(list, protoBuf$Constructor2, AnnotatedCallableKind.FUNCTION), TweetUtils.descriptorVisibility(ProtoEnumFlags.INSTANCE, (ProtoBuf$Visibility) Flags.VISIBILITY.get(protoBuf$Constructor2.flags_)));
        deserializedClassConstructorDescriptor2.setReturnType(classDescriptor.getDefaultType());
        boolean z2 = true;
        deserializedClassConstructorDescriptor2.hasStableParameterNames = !Flags.IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES.get(protoBuf$Constructor2.flags_).booleanValue();
        DeclarationDescriptor declarationDescriptor = this.f5948c.containingDeclaration;
        Boolean bool = null;
        DeserializedClassDescriptor deserializedClassDescriptor = declarationDescriptor instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor) declarationDescriptor : null;
        if (deserializedClassDescriptor == null) {
            deserializationContext = null;
        } else {
            deserializationContext = deserializedClassDescriptor.f5950c;
        }
        if (deserializationContext != null) {
            TypeDeserializer typeDeserializer = deserializationContext.typeDeserializer;
            if (typeDeserializer != null) {
                bool = Boolean.valueOf(typeDeserializer.experimentalSuspendFunctionTypeEncountered);
            }
        }
        if (!Intrinsics.areEqual(bool, Boolean.TRUE) || !versionAndReleaseCoroutinesMismatch(deserializedClassConstructorDescriptor2)) {
            z2 = false;
        }
        if (z2) {
            coroutinesCompatibilityMode = CoroutinesCompatibilityMode.INCOMPATIBLE;
            deserializedClassConstructorDescriptor = deserializedClassConstructorDescriptor2;
        } else {
            List<ValueParameterDescriptor> valueParameters = deserializedClassConstructorDescriptor2.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(valueParameters, "descriptor.valueParameters");
            List<TypeParameterDescriptor> typeParameters = deserializedClassConstructorDescriptor2.getTypeParameters();
            Intrinsics.checkNotNullExpressionValue(typeParameters, "descriptor.typeParameters");
            deserializedClassConstructorDescriptor = deserializedClassConstructorDescriptor2;
            coroutinesCompatibilityMode = computeExperimentalityModeForFunctions(deserializedClassConstructorDescriptor2, null, valueParameters, typeParameters, deserializedClassConstructorDescriptor2.unsubstitutedReturnType, false);
        }
        Intrinsics.checkNotNullParameter(coroutinesCompatibilityMode, "<set-?>");
        deserializedClassConstructorDescriptor.coroutinesExperimentalCompatibilityMode = coroutinesCompatibilityMode;
        return deserializedClassConstructorDescriptor;
    }

    public final SimpleFunctionDescriptor loadFunction(ProtoBuf$Function protoBuf$Function) {
        int i;
        Annotations annotations;
        VersionRequirementTable versionRequirementTable;
        int i2;
        Modality modality;
        ProtoBuf$Function protoBuf$Function2 = protoBuf$Function;
        Intrinsics.checkNotNullParameter(protoBuf$Function2, "proto");
        if ((protoBuf$Function2.bitField0_ & 1) == 1) {
            i = protoBuf$Function2.flags_;
        } else {
            int i3 = protoBuf$Function2.oldFlags_;
            i = ((i3 >> 8) << 6) + (i3 & 63);
        }
        int i4 = i;
        Annotations annotations2 = getAnnotations(protoBuf$Function2, i4, AnnotatedCallableKind.FUNCTION);
        ReceiverParameterDescriptor receiverParameterDescriptor = null;
        if (TweetUtils.hasReceiver(protoBuf$Function)) {
            annotations = new DeserializedAnnotations(this.f5948c.components.storageManager, new MemberDeserializer$getReceiverParameterAnnotations$1(this, protoBuf$Function2, AnnotatedCallableKind.FUNCTION));
        } else if (Annotations.Companion != null) {
            annotations = Companion.EMPTY;
        } else {
            throw null;
        }
        if (Intrinsics.areEqual(DescriptorUtilsKt.getFqNameSafe(this.f5948c.containingDeclaration).child(TweetUtils.getName(this.f5948c.nameResolver, protoBuf$Function2.name_)), SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME)) {
            VersionRequirementTable.Companion companion = VersionRequirementTable.Companion;
            versionRequirementTable = VersionRequirementTable.EMPTY;
        } else {
            versionRequirementTable = this.f5948c.versionRequirementTable;
        }
        VersionRequirementTable versionRequirementTable2 = versionRequirementTable;
        DeserializationContext deserializationContext = this.f5948c;
        DeclarationDescriptor declarationDescriptor = deserializationContext.containingDeclaration;
        Name name = TweetUtils.getName(deserializationContext.nameResolver, protoBuf$Function2.name_);
        Kind memberKind = TweetUtils.memberKind(ProtoEnumFlags.INSTANCE, (ProtoBuf$MemberKind) Flags.MEMBER_KIND.get(i4));
        DeserializationContext deserializationContext2 = this.f5948c;
        DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor = new DeserializedSimpleFunctionDescriptor(declarationDescriptor, null, annotations2, name, memberKind, protoBuf$Function, deserializationContext2.nameResolver, deserializationContext2.typeTable, versionRequirementTable2, deserializationContext2.containerSource, null);
        DeserializationContext deserializationContext3 = this.f5948c;
        List<ProtoBuf$TypeParameter> list = protoBuf$Function2.typeParameter_;
        Intrinsics.checkNotNullExpressionValue(list, "proto.typeParameterList");
        DeserializationContext childContext$default = DeserializationContext.childContext$default(deserializationContext3, deserializedSimpleFunctionDescriptor, list, null, null, null, null, 60);
        ProtoBuf$Type receiverType = TweetUtils.receiverType(protoBuf$Function2, this.f5948c.typeTable);
        if (receiverType != null) {
            KotlinType type = childContext$default.typeDeserializer.type(receiverType);
            if (type != null) {
                receiverParameterDescriptor = TweetUtils.createExtensionReceiverParameterForCallable(deserializedSimpleFunctionDescriptor, type, annotations);
            }
        }
        ReceiverParameterDescriptor receiverParameterDescriptor2 = receiverParameterDescriptor;
        ReceiverParameterDescriptor dispatchReceiverParameter = getDispatchReceiverParameter();
        List<TypeParameterDescriptor> ownTypeParameters = childContext$default.typeDeserializer.getOwnTypeParameters();
        MemberDeserializer memberDeserializer = childContext$default.memberDeserializer;
        List<ProtoBuf$ValueParameter> list2 = protoBuf$Function2.valueParameter_;
        Intrinsics.checkNotNullExpressionValue(list2, "proto.valueParameterList");
        List<ValueParameterDescriptor> valueParameters = memberDeserializer.valueParameters(list2, protoBuf$Function2, AnnotatedCallableKind.FUNCTION);
        KotlinType type2 = childContext$default.typeDeserializer.type(TweetUtils.returnType(protoBuf$Function2, this.f5948c.typeTable));
        ProtoBuf$Modality protoBuf$Modality = (ProtoBuf$Modality) Flags.MODALITY.get(i4);
        if (protoBuf$Modality == null) {
            i2 = -1;
        } else {
            i2 = WhenMappings.$EnumSwitchMapping$0[protoBuf$Modality.ordinal()];
        }
        if (i2 == 1) {
            modality = Modality.FINAL;
        } else if (i2 == 2) {
            modality = Modality.OPEN;
        } else if (i2 == 3) {
            modality = Modality.ABSTRACT;
        } else if (i2 != 4) {
            modality = Modality.FINAL;
        } else {
            modality = Modality.SEALED;
        }
        DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor2 = deserializedSimpleFunctionDescriptor;
        int i5 = i4;
        deserializedSimpleFunctionDescriptor2.initialize(receiverParameterDescriptor2, dispatchReceiverParameter, ownTypeParameters, valueParameters, type2, modality, TweetUtils.descriptorVisibility(ProtoEnumFlags.INSTANCE, (ProtoBuf$Visibility) Flags.VISIBILITY.get(i4)), ArraysKt___ArraysJvmKt.emptyMap(), computeExperimentalityModeForFunctions(deserializedSimpleFunctionDescriptor, receiverParameterDescriptor2, valueParameters, ownTypeParameters, type2, GeneratedOutlineSupport.outline108(Flags.IS_SUSPEND, i4, "IS_SUSPEND.get(flags)")));
        deserializedSimpleFunctionDescriptor2.isOperator = GeneratedOutlineSupport.outline108(Flags.IS_OPERATOR, i5, "IS_OPERATOR.get(flags)");
        deserializedSimpleFunctionDescriptor2.isInfix = GeneratedOutlineSupport.outline108(Flags.IS_INFIX, i5, "IS_INFIX.get(flags)");
        deserializedSimpleFunctionDescriptor2.isExternal = GeneratedOutlineSupport.outline108(Flags.IS_EXTERNAL_FUNCTION, i5, "IS_EXTERNAL_FUNCTION.get(flags)");
        deserializedSimpleFunctionDescriptor2.isInline = GeneratedOutlineSupport.outline108(Flags.IS_INLINE, i5, "IS_INLINE.get(flags)");
        deserializedSimpleFunctionDescriptor2.isTailrec = GeneratedOutlineSupport.outline108(Flags.IS_TAILREC, i5, "IS_TAILREC.get(flags)");
        deserializedSimpleFunctionDescriptor2.isSuspend = GeneratedOutlineSupport.outline108(Flags.IS_SUSPEND, i5, "IS_SUSPEND.get(flags)");
        deserializedSimpleFunctionDescriptor2.isExpect = GeneratedOutlineSupport.outline108(Flags.IS_EXPECT_FUNCTION, i5, "IS_EXPECT_FUNCTION.get(flags)");
        deserializedSimpleFunctionDescriptor2.hasStableParameterNames = !Flags.IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES.get(i5).booleanValue();
        DeserializationContext deserializationContext4 = this.f5948c;
        Pair<UserDataKey<?>, Object> deserializeContractFromFunction = deserializationContext4.components.contractDeserializer.deserializeContractFromFunction(protoBuf$Function2, deserializedSimpleFunctionDescriptor2, deserializationContext4.typeTable, childContext$default.typeDeserializer);
        if (deserializeContractFromFunction != null) {
            deserializedSimpleFunctionDescriptor2.putInUserDataMap((UserDataKey) deserializeContractFromFunction.first, deserializeContractFromFunction.second);
        }
        return deserializedSimpleFunctionDescriptor2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:117:0x0388  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0186  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor loadProperty(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r25) {
        /*
            r24 = this;
            r0 = r24
            r15 = r25
            java.lang.String r1 = "proto"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r1)
            int r1 = r15.bitField0_
            r2 = 1
            r1 = r1 & r2
            if (r1 != r2) goto L_0x0011
            r1 = 1
            goto L_0x0012
        L_0x0011:
            r1 = 0
        L_0x0012:
            if (r1 == 0) goto L_0x0017
            int r1 = r15.flags_
            goto L_0x0020
        L_0x0017:
            int r1 = r15.oldFlags_
            r3 = r1 & 63
            int r1 = r1 >> 8
            int r1 = r1 << 6
            int r1 = r1 + r3
        L_0x0020:
            r5 = r1
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor r4 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r1 = r0.f5948c
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r1 = r1.containingDeclaration
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind r3 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.PROPERTY
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r20 = r0.getAnnotations(r15, r5, r3)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$FlagField<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality> r3 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.MODALITY
            java.lang.Object r3 = r3.get(r5)
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality) r3
            if (r3 != 0) goto L_0x0039
            r3 = -1
            goto L_0x0041
        L_0x0039:
            int[] r6 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.WhenMappings.$EnumSwitchMapping$0
            int r3 = r3.ordinal()
            r3 = r6[r3]
        L_0x0041:
            r6 = 2
            r7 = 3
            r8 = 4
            if (r3 == r2) goto L_0x0058
            if (r3 == r6) goto L_0x0055
            if (r3 == r7) goto L_0x0052
            if (r3 == r8) goto L_0x004f
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r2 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL
            goto L_0x005a
        L_0x004f:
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r2 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.SEALED
            goto L_0x005a
        L_0x0052:
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r2 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.ABSTRACT
            goto L_0x005a
        L_0x0055:
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r2 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.OPEN
            goto L_0x005a
        L_0x0058:
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r2 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL
        L_0x005a:
            r21 = r2
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags r2 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.INSTANCE
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$FlagField<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility> r3 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.VISIBILITY
            java.lang.Object r3 = r3.get(r5)
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility) r3
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r6 = com.twitter.sdk.android.tweetui.TweetUtils.descriptorVisibility(r2, r3)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$BooleanFlagField r2 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_VAR
            java.lang.String r3 = "IS_VAR.get(flags)"
            boolean r7 = com.android.tools.r8.GeneratedOutlineSupport.outline108(r2, r5, r3)
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r2 = r0.f5948c
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r2 = r2.nameResolver
            int r3 = r15.name_
            kotlin.reflect.jvm.internal.impl.name.Name r8 = com.twitter.sdk.android.tweetui.TweetUtils.getName(r2, r3)
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags r2 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.INSTANCE
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$FlagField<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$MemberKind> r3 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.MEMBER_KIND
            java.lang.Object r3 = r3.get(r5)
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$MemberKind r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$MemberKind) r3
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r9 = com.twitter.sdk.android.tweetui.TweetUtils.memberKind(r2, r3)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$BooleanFlagField r2 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_LATEINIT
            java.lang.String r3 = "IS_LATEINIT.get(flags)"
            boolean r10 = com.android.tools.r8.GeneratedOutlineSupport.outline108(r2, r5, r3)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$BooleanFlagField r2 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_CONST
            java.lang.String r3 = "IS_CONST.get(flags)"
            boolean r11 = com.android.tools.r8.GeneratedOutlineSupport.outline108(r2, r5, r3)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$BooleanFlagField r2 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_EXTERNAL_PROPERTY
            java.lang.String r3 = "IS_EXTERNAL_PROPERTY.get(flags)"
            boolean r12 = com.android.tools.r8.GeneratedOutlineSupport.outline108(r2, r5, r3)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$BooleanFlagField r2 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_DELEGATED
            java.lang.String r3 = "IS_DELEGATED.get(flags)"
            boolean r13 = com.android.tools.r8.GeneratedOutlineSupport.outline108(r2, r5, r3)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$BooleanFlagField r2 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_EXPECT_PROPERTY
            java.lang.String r3 = "IS_EXPECT_PROPERTY.get(flags)"
            boolean r14 = com.android.tools.r8.GeneratedOutlineSupport.outline108(r2, r5, r3)
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r2 = r0.f5948c
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r3 = r2.nameResolver
            r16 = r3
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r3 = r2.typeTable
            r17 = r3
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable r3 = r2.versionRequirementTable
            r18 = r3
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource r2 = r2.containerSource
            r19 = r2
            r3 = 0
            r2 = r1
            r1 = r4
            r22 = r4
            r4 = r20
            r23 = r5
            r5 = r21
            r15 = r25
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r6 = r0.f5948c
            r1 = r25
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r8 = r1.typeParameter_
            java.lang.String r2 = "proto.typeParameterList"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r2)
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 60
            r7 = r22
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r2 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext.childContext$default(r6, r7, r8, r9, r10, r11, r12, r13)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$BooleanFlagField r3 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_GETTER
            java.lang.String r4 = "HAS_GETTER.get(flags)"
            r5 = r23
            boolean r3 = com.android.tools.r8.GeneratedOutlineSupport.outline108(r3, r5, r4)
            if (r3 == 0) goto L_0x0110
            boolean r4 = com.twitter.sdk.android.tweetui.TweetUtils.hasReceiver(r25)
            if (r4 == 0) goto L_0x0110
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind r4 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.PROPERTY_GETTER
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations r6 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r7 = r0.f5948c
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r7 = r7.components
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r7 = r7.storageManager
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$getReceiverParameterAnnotations$1 r8 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$getReceiverParameterAnnotations$1
            r8.<init>(r0, r1, r4)
            r6.<init>(r7, r8)
            goto L_0x0116
        L_0x0110:
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion r4 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
            if (r4 == 0) goto L_0x038f
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r6 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.EMPTY
        L_0x0116:
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer r4 = r2.typeDeserializer
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r7 = r0.f5948c
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r7 = r7.typeTable
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r7 = com.twitter.sdk.android.tweetui.TweetUtils.returnType(r1, r7)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = r4.type(r7)
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer r7 = r2.typeDeserializer
            java.util.List r7 = r7.getOwnTypeParameters()
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r8 = r24.getDispatchReceiverParameter()
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r9 = r0.f5948c
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r9 = r9.typeTable
            java.lang.String r10 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r10)
            java.lang.String r10 = "typeTable"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r10)
            boolean r10 = r25.hasReceiverType()
            if (r10 == 0) goto L_0x0146
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r9 = r1.receiverType_
            goto L_0x0154
        L_0x0146:
            boolean r10 = r25.hasReceiverTypeId()
            if (r10 == 0) goto L_0x0153
            int r10 = r1.receiverTypeId_
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r9 = r9.get(r10)
            goto L_0x0154
        L_0x0153:
            r9 = 0
        L_0x0154:
            if (r9 != 0) goto L_0x0157
            goto L_0x015f
        L_0x0157:
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer r10 = r2.typeDeserializer
            kotlin.reflect.jvm.internal.impl.types.KotlinType r9 = r10.type(r9)
            if (r9 != 0) goto L_0x0163
        L_0x015f:
            r6 = 0
            r15 = r22
            goto L_0x0169
        L_0x0163:
            r15 = r22
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r6 = com.twitter.sdk.android.tweetui.TweetUtils.createExtensionReceiverParameterForCallable(r15, r9, r6)
        L_0x0169:
            r15.setType(r4, r7, r8, r6)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$BooleanFlagField r4 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_ANNOTATIONS
            java.lang.String r6 = "HAS_ANNOTATIONS.get(flags)"
            boolean r4 = com.android.tools.r8.GeneratedOutlineSupport.outline108(r4, r5, r6)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$FlagField<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility> r6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.VISIBILITY
            java.lang.Object r6 = r6.get(r5)
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility r6 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility) r6
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$FlagField<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality> r7 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.MODALITY
            java.lang.Object r7 = r7.get(r5)
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality r7 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality) r7
            if (r6 == 0) goto L_0x0388
            if (r7 == 0) goto L_0x0381
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$BooleanFlagField r8 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_ANNOTATIONS
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            int r4 = r8.toFlags(r4)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$FlagField<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality> r8 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.MODALITY
            int r7 = r8.toFlags(r7)
            r4 = r4 | r7
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$FlagField<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility> r7 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.VISIBILITY
            int r6 = r7.toFlags(r6)
            r4 = r4 | r6
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$BooleanFlagField r6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_NOT_DEFAULT
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            int r6 = r6.toFlags(r7)
            r4 = r4 | r6
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$BooleanFlagField r6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_EXTERNAL_ACCESSOR
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            int r6 = r6.toFlags(r7)
            r4 = r4 | r6
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$BooleanFlagField r6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_INLINE_ACCESSOR
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            int r6 = r6.toFlags(r7)
            r4 = r4 | r6
            if (r3 == 0) goto L_0x025d
            int r3 = r1.bitField0_
            r6 = 256(0x100, float:3.59E-43)
            r3 = r3 & r6
            if (r3 != r6) goto L_0x01c6
            r3 = 1
            goto L_0x01c7
        L_0x01c6:
            r3 = 0
        L_0x01c7:
            if (r3 == 0) goto L_0x01cc
            int r3 = r1.getterFlags_
            goto L_0x01cd
        L_0x01cc:
            r3 = r4
        L_0x01cd:
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$BooleanFlagField r6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_NOT_DEFAULT
            java.lang.String r7 = "IS_NOT_DEFAULT.get(getterFlags)"
            boolean r6 = com.android.tools.r8.GeneratedOutlineSupport.outline108(r6, r3, r7)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$BooleanFlagField r7 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_EXTERNAL_ACCESSOR
            java.lang.String r8 = "IS_EXTERNAL_ACCESSOR.get(getterFlags)"
            boolean r12 = com.android.tools.r8.GeneratedOutlineSupport.outline108(r7, r3, r8)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$BooleanFlagField r7 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_INLINE_ACCESSOR
            java.lang.String r8 = "IS_INLINE_ACCESSOR.get(getterFlags)"
            boolean r13 = com.android.tools.r8.GeneratedOutlineSupport.outline108(r7, r3, r8)
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind r7 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.PROPERTY_GETTER
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r8 = r0.getAnnotations(r1, r3, r7)
            if (r6 == 0) goto L_0x0244
            kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl r17 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$FlagField<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality> r7 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.MODALITY
            java.lang.Object r7 = r7.get(r3)
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality r7 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality) r7
            if (r7 != 0) goto L_0x01fb
            r7 = -1
            goto L_0x0203
        L_0x01fb:
            int[] r9 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.WhenMappings.$EnumSwitchMapping$0
            int r7 = r7.ordinal()
            r7 = r9[r7]
        L_0x0203:
            r9 = 1
            if (r7 == r9) goto L_0x021b
            r9 = 2
            if (r7 == r9) goto L_0x0218
            r9 = 3
            if (r7 == r9) goto L_0x0215
            r9 = 4
            if (r7 == r9) goto L_0x0212
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r7 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL
            goto L_0x021d
        L_0x0212:
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r7 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.SEALED
            goto L_0x021d
        L_0x0215:
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r7 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.ABSTRACT
            goto L_0x021d
        L_0x0218:
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r7 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.OPEN
            goto L_0x021d
        L_0x021b:
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r7 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL
        L_0x021d:
            r9 = r7
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags r7 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.INSTANCE
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$FlagField<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility> r10 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.VISIBILITY
            java.lang.Object r3 = r10.get(r3)
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility) r3
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r10 = com.twitter.sdk.android.tweetui.TweetUtils.descriptorVisibility(r7, r3)
            r11 = r6 ^ 1
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r14 = r15.getKind()
            r3 = 0
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r16 = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE
            r18 = 1
            r6 = r17
            r7 = r15
            r19 = r4
            r4 = r15
            r15 = r3
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r3 = r17
            goto L_0x0253
        L_0x0244:
            r19 = r4
            r4 = r15
            r18 = 1
            kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl r3 = com.twitter.sdk.android.tweetui.TweetUtils.createDefaultGetter(r4, r8)
            java.lang.String r6 = "{\n                DescriptorFactory.createDefaultGetter(property, annotations)\n            }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)
        L_0x0253:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r6 = r4.getReturnType()
            r3.initialize(r6)
            r15 = r18
            goto L_0x0264
        L_0x025d:
            r19 = r4
            r4 = r15
            r18 = 1
            r3 = 0
            r15 = 1
        L_0x0264:
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$BooleanFlagField r6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_SETTER
            java.lang.String r7 = "HAS_SETTER.get(flags)"
            boolean r6 = com.android.tools.r8.GeneratedOutlineSupport.outline108(r6, r5, r7)
            if (r6 == 0) goto L_0x0338
            int r6 = r1.bitField0_
            r7 = 512(0x200, float:7.17E-43)
            r6 = r6 & r7
            if (r6 != r7) goto L_0x0277
            r6 = 1
            goto L_0x0278
        L_0x0277:
            r6 = 0
        L_0x0278:
            if (r6 == 0) goto L_0x027d
            int r6 = r1.setterFlags_
            goto L_0x027f
        L_0x027d:
            r6 = r19
        L_0x027f:
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$BooleanFlagField r7 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_NOT_DEFAULT
            java.lang.String r8 = "IS_NOT_DEFAULT.get(setterFlags)"
            boolean r7 = com.android.tools.r8.GeneratedOutlineSupport.outline108(r7, r6, r8)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$BooleanFlagField r8 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_EXTERNAL_ACCESSOR
            java.lang.String r9 = "IS_EXTERNAL_ACCESSOR.get(setterFlags)"
            boolean r12 = com.android.tools.r8.GeneratedOutlineSupport.outline108(r8, r6, r9)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$BooleanFlagField r8 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_INLINE_ACCESSOR
            java.lang.String r9 = "IS_INLINE_ACCESSOR.get(setterFlags)"
            boolean r13 = com.android.tools.r8.GeneratedOutlineSupport.outline108(r8, r6, r9)
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind r8 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.PROPERTY_SETTER
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r8 = r0.getAnnotations(r1, r6, r8)
            if (r7 == 0) goto L_0x0322
            kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl r14 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$FlagField<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality> r9 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.MODALITY
            java.lang.Object r9 = r9.get(r6)
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality r9 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality) r9
            if (r9 != 0) goto L_0x02ad
            r9 = -1
            goto L_0x02b5
        L_0x02ad:
            int[] r10 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.WhenMappings.$EnumSwitchMapping$0
            int r9 = r9.ordinal()
            r9 = r10[r9]
        L_0x02b5:
            if (r9 == r15) goto L_0x02cc
            r10 = 2
            if (r9 == r10) goto L_0x02c9
            r10 = 3
            if (r9 == r10) goto L_0x02c6
            r10 = 4
            if (r9 == r10) goto L_0x02c3
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r9 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL
            goto L_0x02ce
        L_0x02c3:
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r9 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.SEALED
            goto L_0x02ce
        L_0x02c6:
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r9 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.ABSTRACT
            goto L_0x02ce
        L_0x02c9:
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r9 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.OPEN
            goto L_0x02ce
        L_0x02cc:
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r9 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL
        L_0x02ce:
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags r10 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.INSTANCE
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$FlagField<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility> r11 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.VISIBILITY
            java.lang.Object r6 = r11.get(r6)
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility r6 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility) r6
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r10 = com.twitter.sdk.android.tweetui.TweetUtils.descriptorVisibility(r10, r6)
            r11 = r7 ^ 1
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r16 = r4.getKind()
            r17 = 0
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r18 = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE
            r6 = r14
            r7 = r4
            r22 = r14
            r14 = r16
            r23 = r3
            r3 = r15
            r15 = r17
            r16 = r18
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            kotlin.collections.EmptyList r16 = kotlin.collections.EmptyList.INSTANCE
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 60
            r14 = r2
            r15 = r22
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r6 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext.childContext$default(r14, r15, r16, r17, r18, r19, r20, r21)
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer r6 = r6.memberDeserializer
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter r7 = r1.setterValueParameter_
            java.util.List r7 = com.twitter.sdk.android.tweetui.TweetUtils.listOf(r7)
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind r8 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.PROPERTY_SETTER
            java.util.List r6 = r6.valueParameters(r7, r1, r8)
            java.lang.Object r6 = kotlin.collections.ArraysKt___ArraysJvmKt.single(r6)
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r6
            r7 = r22
            r7.initialize(r6)
            r14 = r7
            goto L_0x033c
        L_0x0322:
            r23 = r3
            r3 = r15
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion r6 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
            if (r6 == 0) goto L_0x0336
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r6 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.EMPTY
            kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl r14 = com.twitter.sdk.android.tweetui.TweetUtils.createDefaultSetter(r4, r8, r6)
            java.lang.String r6 = "{\n                DescriptorFactory.createDefaultSetter(\n                    property, annotations,\n                    Annotations.EMPTY /* Otherwise the setter is not default, see DescriptorResolver.resolvePropertySetterDescriptor */\n                )\n            }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r6)
            goto L_0x033c
        L_0x0336:
            r1 = 0
            throw r1
        L_0x0338:
            r23 = r3
            r3 = r15
            r14 = 0
        L_0x033c:
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$BooleanFlagField r6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_CONSTANT
            java.lang.String r7 = "HAS_CONSTANT.get(flags)"
            boolean r5 = com.android.tools.r8.GeneratedOutlineSupport.outline108(r6, r5, r7)
            if (r5 == 0) goto L_0x0358
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r5 = r0.f5948c
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r5 = r5.components
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r5 = r5.storageManager
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$loadProperty$3 r6 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$loadProperty$3
            r6.<init>(r0, r1, r4)
            kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue r5 = r5.createNullableLazyValue(r6)
            r4.setCompileTimeInitializer(r5)
        L_0x0358:
            kotlin.reflect.jvm.internal.impl.descriptors.impl.FieldDescriptorImpl r5 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.FieldDescriptorImpl
            r6 = 0
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r6 = r0.getPropertyFieldAnnotations(r1, r6)
            r5.<init>(r6, r4)
            kotlin.reflect.jvm.internal.impl.descriptors.impl.FieldDescriptorImpl r6 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.FieldDescriptorImpl
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r1 = r0.getPropertyFieldAnnotations(r1, r3)
            r6.<init>(r1, r4)
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer r1 = r2.typeDeserializer
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor$CoroutinesCompatibilityMode r1 = r0.checkExperimentalCoroutine(r4, r1)
            java.lang.String r2 = "isExperimentalCoroutineInReleaseEnvironment"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r3 = r23
            r4.getter = r3
            r4.setter = r14
            r4.backingField = r5
            r4.delegateField = r6
            return r4
        L_0x0381:
            r1 = 11
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.$$$reportNull$$$0(r1)
            r1 = 0
            throw r1
        L_0x0388:
            r1 = 0
            r2 = 10
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.$$$reportNull$$$0(r2)
            throw r1
        L_0x038f:
            r1 = 0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer.loadProperty(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property):kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor");
    }

    public final TypeAliasDescriptor loadTypeAlias(ProtoBuf$TypeAlias protoBuf$TypeAlias) {
        ProtoBuf$Type protoBuf$Type;
        ProtoBuf$Type protoBuf$Type2;
        ProtoBuf$TypeAlias protoBuf$TypeAlias2 = protoBuf$TypeAlias;
        Intrinsics.checkNotNullParameter(protoBuf$TypeAlias2, "proto");
        Companion companion = Annotations.Companion;
        List<ProtoBuf$Annotation> list = protoBuf$TypeAlias2.annotation_;
        Intrinsics.checkNotNullExpressionValue(list, "proto.annotationList");
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(list, 10));
        for (ProtoBuf$Annotation protoBuf$Annotation : list) {
            AnnotationDeserializer annotationDeserializer2 = this.annotationDeserializer;
            Intrinsics.checkNotNullExpressionValue(protoBuf$Annotation, "it");
            arrayList.add(annotationDeserializer2.deserializeAnnotation(protoBuf$Annotation, this.f5948c.nameResolver));
        }
        Annotations create = companion.create(arrayList);
        DescriptorVisibility descriptorVisibility = TweetUtils.descriptorVisibility(ProtoEnumFlags.INSTANCE, (ProtoBuf$Visibility) Flags.VISIBILITY.get(protoBuf$TypeAlias2.flags_));
        DeserializationContext deserializationContext = this.f5948c;
        StorageManager storageManager = deserializationContext.components.storageManager;
        DeclarationDescriptor declarationDescriptor = deserializationContext.containingDeclaration;
        Name name = TweetUtils.getName(deserializationContext.nameResolver, protoBuf$TypeAlias2.name_);
        DeserializationContext deserializationContext2 = this.f5948c;
        DeserializedTypeAliasDescriptor deserializedTypeAliasDescriptor = new DeserializedTypeAliasDescriptor(storageManager, declarationDescriptor, create, name, descriptorVisibility, protoBuf$TypeAlias, deserializationContext2.nameResolver, deserializationContext2.typeTable, deserializationContext2.versionRequirementTable, deserializationContext2.containerSource);
        DeserializationContext deserializationContext3 = this.f5948c;
        List<ProtoBuf$TypeParameter> list2 = protoBuf$TypeAlias2.typeParameter_;
        Intrinsics.checkNotNullExpressionValue(list2, "proto.typeParameterList");
        DeserializedTypeAliasDescriptor deserializedTypeAliasDescriptor2 = deserializedTypeAliasDescriptor;
        DeserializationContext childContext$default = DeserializationContext.childContext$default(deserializationContext3, deserializedTypeAliasDescriptor, list2, null, null, null, null, 60);
        List<TypeParameterDescriptor> ownTypeParameters = childContext$default.typeDeserializer.getOwnTypeParameters();
        TypeDeserializer typeDeserializer = childContext$default.typeDeserializer;
        TypeTable typeTable = this.f5948c.typeTable;
        Intrinsics.checkNotNullParameter(protoBuf$TypeAlias2, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        boolean z = true;
        if (protoBuf$TypeAlias.hasUnderlyingType()) {
            protoBuf$Type = protoBuf$TypeAlias2.underlyingType_;
            Intrinsics.checkNotNullExpressionValue(protoBuf$Type, "underlyingType");
        } else {
            if ((protoBuf$TypeAlias2.bitField0_ & 8) == 8) {
                protoBuf$Type = typeTable.get(protoBuf$TypeAlias2.underlyingTypeId_);
            } else {
                throw new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias".toString());
            }
        }
        SimpleType simpleType = typeDeserializer.simpleType(protoBuf$Type, false);
        TypeDeserializer typeDeserializer2 = childContext$default.typeDeserializer;
        TypeTable typeTable2 = this.f5948c.typeTable;
        Intrinsics.checkNotNullParameter(protoBuf$TypeAlias2, "<this>");
        Intrinsics.checkNotNullParameter(typeTable2, "typeTable");
        if (protoBuf$TypeAlias.hasExpandedType()) {
            protoBuf$Type2 = protoBuf$TypeAlias2.expandedType_;
            Intrinsics.checkNotNullExpressionValue(protoBuf$Type2, "expandedType");
        } else {
            if ((protoBuf$TypeAlias2.bitField0_ & 32) != 32) {
                z = false;
            }
            if (z) {
                protoBuf$Type2 = typeTable2.get(protoBuf$TypeAlias2.expandedTypeId_);
            } else {
                throw new IllegalStateException("No expandedType in ProtoBuf.TypeAlias".toString());
            }
        }
        deserializedTypeAliasDescriptor2.initialize(ownTypeParameters, simpleType, typeDeserializer2.simpleType(protoBuf$Type2, false), checkExperimentalCoroutine(deserializedTypeAliasDescriptor2, childContext$default.typeDeserializer));
        return deserializedTypeAliasDescriptor2;
    }

    public final List<ValueParameterDescriptor> valueParameters(List<ProtoBuf$ValueParameter> list, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        Annotations annotations;
        ProtoBuf$Type protoBuf$Type;
        KotlinType kotlinType;
        CallableDescriptor callableDescriptor = (CallableDescriptor) this.f5948c.containingDeclaration;
        DeclarationDescriptor containingDeclaration = callableDescriptor.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(containingDeclaration, "callableDescriptor.containingDeclaration");
        ProtoContainer asProtoContainer = asProtoContainer(containingDeclaration);
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(list, 10));
        int i = 0;
        for (T next : list) {
            int i2 = i + 1;
            if (i >= 0) {
                ProtoBuf$ValueParameter protoBuf$ValueParameter = (ProtoBuf$ValueParameter) next;
                int i3 = (protoBuf$ValueParameter.bitField0_ & 1) == 1 ? protoBuf$ValueParameter.flags_ : 0;
                if (asProtoContainer != null && GeneratedOutlineSupport.outline108(Flags.HAS_ANNOTATIONS, i3, "HAS_ANNOTATIONS.get(flags)")) {
                    StorageManager storageManager = this.f5948c.components.storageManager;
                    MemberDeserializer$valueParameters$1$annotations$1 memberDeserializer$valueParameters$1$annotations$1 = new MemberDeserializer$valueParameters$1$annotations$1(this, asProtoContainer, messageLite, annotatedCallableKind, i, protoBuf$ValueParameter);
                    annotations = new NonEmptyDeserializedAnnotations(storageManager, memberDeserializer$valueParameters$1$annotations$1);
                } else if (Annotations.Companion != null) {
                    annotations = Companion.EMPTY;
                } else {
                    throw null;
                }
                Name name = TweetUtils.getName(this.f5948c.nameResolver, protoBuf$ValueParameter.name_);
                DeserializationContext deserializationContext = this.f5948c;
                KotlinType type = deserializationContext.typeDeserializer.type(TweetUtils.type(protoBuf$ValueParameter, deserializationContext.typeTable));
                boolean outline108 = GeneratedOutlineSupport.outline108(Flags.DECLARES_DEFAULT_VALUE, i3, "DECLARES_DEFAULT_VALUE.get(flags)");
                boolean outline1082 = GeneratedOutlineSupport.outline108(Flags.IS_CROSSINLINE, i3, "IS_CROSSINLINE.get(flags)");
                boolean outline1083 = GeneratedOutlineSupport.outline108(Flags.IS_NOINLINE, i3, "IS_NOINLINE.get(flags)");
                TypeTable typeTable = this.f5948c.typeTable;
                Intrinsics.checkNotNullParameter(protoBuf$ValueParameter, "<this>");
                Intrinsics.checkNotNullParameter(typeTable, "typeTable");
                if (protoBuf$ValueParameter.hasVarargElementType()) {
                    protoBuf$Type = protoBuf$ValueParameter.varargElementType_;
                } else {
                    protoBuf$Type = (protoBuf$ValueParameter.bitField0_ & 32) == 32 ? typeTable.get(protoBuf$ValueParameter.varargElementTypeId_) : null;
                }
                if (protoBuf$Type == null) {
                    kotlinType = null;
                } else {
                    kotlinType = this.f5948c.typeDeserializer.type(protoBuf$Type);
                }
                SourceElement sourceElement = SourceElement.NO_SOURCE;
                Intrinsics.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
                ArrayList arrayList2 = arrayList;
                ValueParameterDescriptorImpl valueParameterDescriptorImpl = new ValueParameterDescriptorImpl(callableDescriptor, null, i, annotations, name, type, outline108, outline1082, outline1083, kotlinType, sourceElement);
                arrayList2.add(valueParameterDescriptorImpl);
                arrayList = arrayList2;
                i = i2;
            } else {
                TweetUtils.throwIndexOverflow();
                throw null;
            }
        }
        return ArraysKt___ArraysJvmKt.toList(arrayList);
    }

    public final boolean versionAndReleaseCoroutinesMismatch(DeserializedMemberDescriptor deserializedMemberDescriptor) {
        boolean z;
        boolean z2;
        if (!this.f5948c.components.configuration.getReleaseCoroutines()) {
            return false;
        }
        List<VersionRequirement> versionRequirements = deserializedMemberDescriptor.getVersionRequirements();
        if (!(versionRequirements instanceof Collection) || !versionRequirements.isEmpty()) {
            Iterator<T> it = versionRequirements.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                VersionRequirement versionRequirement = (VersionRequirement) it.next();
                if (!Intrinsics.areEqual(versionRequirement.version, new Version(1, 3, 0, 4)) || versionRequirement.kind != VersionKind.LANGUAGE_VERSION) {
                    z2 = false;
                    continue;
                } else {
                    z2 = true;
                    continue;
                }
                if (z2) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            return true;
        }
        return false;
    }
}
