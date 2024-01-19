package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type.Argument;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: TypeDeserializer.kt */
public final class TypeDeserializer {

    /* renamed from: c  reason: collision with root package name */
    public final DeserializationContext f5949c;
    public final Function1<Integer, ClassifierDescriptor> classifierDescriptors;
    public final String containerPresentableName;
    public final String debugName;
    public boolean experimentalSuspendFunctionTypeEncountered;
    public final TypeDeserializer parent;
    public final Function1<Integer, ClassifierDescriptor> typeAliasDescriptors;
    public final Map<Integer, TypeParameterDescriptor> typeParameterDescriptors;

    /* JADX WARNING: type inference failed for: r2v9, types: [java.util.Map<java.lang.Integer, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor>] */
    /* JADX WARNING: type inference failed for: r2v10, types: [java.util.LinkedHashMap, java.util.HashMap] */
    /* JADX WARNING: type inference failed for: r2v11, types: [java.util.Map] */
    /* JADX WARNING: type inference failed for: r2v12 */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TypeDeserializer(kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r2, kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer r3, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r4, java.lang.String r5, java.lang.String r6, boolean r7, int r8) {
        /*
            r1 = this;
            r8 = r8 & 32
            r0 = 0
            if (r8 == 0) goto L_0x0006
            r7 = 0
        L_0x0006:
            java.lang.String r8 = "c"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r8)
            java.lang.String r8 = "typeParameterProtos"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r8)
            java.lang.String r8 = "debugName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r8)
            java.lang.String r8 = "containerPresentableName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r8)
            r1.<init>()
            r1.f5949c = r2
            r1.parent = r3
            r1.debugName = r5
            r1.containerPresentableName = r6
            r1.experimentalSuspendFunctionTypeEncountered = r7
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r2 = r2.components
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r2 = r2.storageManager
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$classifierDescriptors$1 r3 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$classifierDescriptors$1
            r3.<init>(r1)
            kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable r2 = r2.createMemoizedFunctionWithNullableValues(r3)
            r1.classifierDescriptors = r2
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r2 = r1.f5949c
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r2 = r2.components
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r2 = r2.storageManager
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$typeAliasDescriptors$1 r3 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$typeAliasDescriptors$1
            r3.<init>(r1)
            kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable r2 = r2.createMemoizedFunctionWithNullableValues(r3)
            r1.typeAliasDescriptors = r2
            boolean r2 = r4.isEmpty()
            if (r2 == 0) goto L_0x0053
            java.util.Map r2 = kotlin.collections.ArraysKt___ArraysJvmKt.emptyMap()
            goto L_0x007c
        L_0x0053:
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            java.util.Iterator r3 = r4.iterator()
        L_0x005c:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x007c
            int r4 = r0 + 1
            java.lang.Object r5 = r3.next()
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter r5 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter) r5
            int r6 = r5.id_
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor r7 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r8 = r1.f5949c
            r7.<init>(r8, r5, r0)
            r2.put(r6, r7)
            r0 = r4
            goto L_0x005c
        L_0x007c:
            r1.typeParameterDescriptors = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer.<init>(kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext, kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer, java.util.List, java.lang.String, java.lang.String, boolean, int):void");
    }

    public static final List<Argument> simpleType$collectAllArguments(ProtoBuf$Type protoBuf$Type, TypeDeserializer typeDeserializer) {
        List<Argument> list = protoBuf$Type.argument_;
        Intrinsics.checkNotNullExpressionValue(list, "argumentList");
        ProtoBuf$Type outerType = TweetUtils.outerType(protoBuf$Type, typeDeserializer.f5949c.typeTable);
        Iterable simpleType$collectAllArguments = outerType == null ? null : simpleType$collectAllArguments(outerType, typeDeserializer);
        if (simpleType$collectAllArguments == null) {
            simpleType$collectAllArguments = EmptyList.INSTANCE;
        }
        return ArraysKt___ArraysJvmKt.plus((Collection<? extends T>) list, simpleType$collectAllArguments);
    }

    public static final ClassDescriptor typeConstructor$notFoundClass(TypeDeserializer typeDeserializer, ProtoBuf$Type protoBuf$Type, int i) {
        ClassId classId = TweetUtils.getClassId(typeDeserializer.f5949c.nameResolver, i);
        List mutableList = TypeUtilsKt.toMutableList(TypeUtilsKt.map(TypeUtilsKt.generateSequence(protoBuf$Type, new TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$1(typeDeserializer)), TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$2.INSTANCE));
        int count = TypeUtilsKt.count(TypeUtilsKt.generateSequence(classId, TypeDeserializer$typeConstructor$notFoundClass$classNestingLevel$1.INSTANCE));
        while (true) {
            ArrayList arrayList = (ArrayList) mutableList;
            if (arrayList.size() >= count) {
                return typeDeserializer.f5949c.components.notFoundClasses.getClass(classId, mutableList);
            }
            arrayList.add(Integer.valueOf(0));
        }
    }

    public final SimpleType computeLocalClassifierReplacementType(int i) {
        if (TweetUtils.getClassId(this.f5949c.nameResolver, i).local) {
            return this.f5949c.components.localClassifierTypeSettings.getReplacementTypeForLocalClassifiers();
        }
        return null;
    }

    public final SimpleType createSimpleSuspendFunctionType(KotlinType kotlinType, KotlinType kotlinType2) {
        KotlinBuiltIns builtIns = TypeUtilsKt.getBuiltIns(kotlinType);
        Annotations annotations = kotlinType.getAnnotations();
        KotlinType receiverTypeFromFunctionType = FunctionTypesKt.getReceiverTypeFromFunctionType(kotlinType);
        List<T> dropLast = ArraysKt___ArraysJvmKt.dropLast(FunctionTypesKt.getValueParameterTypesFromFunctionType(kotlinType), 1);
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(dropLast, 10));
        for (T type : dropLast) {
            arrayList.add(type.getType());
        }
        return FunctionTypesKt.createFunctionType(builtIns, annotations, receiverTypeFromFunctionType, arrayList, null, kotlinType2, true).makeNullableAsSpecified(kotlinType.isMarkedNullable());
    }

    public final List<TypeParameterDescriptor> getOwnTypeParameters() {
        return ArraysKt___ArraysJvmKt.toList(this.typeParameterDescriptors.values());
    }

    /* JADX WARNING: Removed duplicated region for block: B:156:0x0371  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0381  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r17, boolean r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            java.lang.String r2 = "proto"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            boolean r2 = r17.hasClassName()
            r3 = 0
            if (r2 == 0) goto L_0x0017
            int r2 = r1.className_
            kotlin.reflect.jvm.internal.impl.types.SimpleType r2 = r0.computeLocalClassifierReplacementType(r2)
            goto L_0x0025
        L_0x0017:
            boolean r2 = r17.hasTypeAliasName()
            if (r2 == 0) goto L_0x0024
            int r2 = r1.typeAliasName_
            kotlin.reflect.jvm.internal.impl.types.SimpleType r2 = r0.computeLocalClassifierReplacementType(r2)
            goto L_0x0025
        L_0x0024:
            r2 = r3
        L_0x0025:
            if (r2 == 0) goto L_0x0028
            return r2
        L_0x0028:
            boolean r2 = r17.hasClassName()
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0051
            kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor> r2 = r0.classifierDescriptors
            int r6 = r1.className_
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object r2 = r2.invoke(r6)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor) r2
            if (r2 != 0) goto L_0x0046
            int r2 = r1.className_
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2 = typeConstructor$notFoundClass(r0, r1, r2)
        L_0x0046:
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r2 = r2.getTypeConstructor()
            java.lang.String r6 = "classifierDescriptors(proto.className) ?: notFoundClass(proto.className)).typeConstructor"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)
            goto L_0x012f
        L_0x0051:
            int r2 = r1.bitField0_
            r6 = 32
            r2 = r2 & r6
            if (r2 != r6) goto L_0x005a
            r2 = 1
            goto L_0x005b
        L_0x005a:
            r2 = 0
        L_0x005b:
            if (r2 == 0) goto L_0x008e
            int r2 = r1.typeParameter_
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r2 = r0.typeParameterTypeConstructor(r2)
            if (r2 != 0) goto L_0x012f
            java.lang.String r2 = "Unknown type parameter "
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            int r6 = r1.typeParameter_
            r2.append(r6)
            java.lang.String r6 = ". Please try recompiling module containing \""
            r2.append(r6)
            java.lang.String r6 = r0.containerPresentableName
            r2.append(r6)
            r6 = 34
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r2 = kotlin.reflect.jvm.internal.impl.types.ErrorUtils.createErrorTypeConstructor(r2)
            java.lang.String r6 = "createErrorTypeConstructor(\n                        \"Unknown type parameter ${proto.typeParameter}. Please try recompiling module containing \\\"$containerPresentableName\\\"\"\n                    )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)
            goto L_0x012f
        L_0x008e:
            int r2 = r1.bitField0_
            r6 = 64
            r2 = r2 & r6
            if (r2 != r6) goto L_0x0097
            r2 = 1
            goto L_0x0098
        L_0x0097:
            r2 = 0
        L_0x0098:
            if (r2 == 0) goto L_0x00fd
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r2 = r0.f5949c
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r6 = r2.containingDeclaration
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r2 = r2.nameResolver
            int r7 = r1.typeParameterName_
            java.lang.String r2 = r2.getString(r7)
            java.util.List r7 = r16.getOwnTypeParameters()
            java.util.Iterator r7 = r7.iterator()
        L_0x00ae:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x00ca
            java.lang.Object r8 = r7.next()
            r9 = r8
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r9 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r9
            kotlin.reflect.jvm.internal.impl.name.Name r9 = r9.getName()
            java.lang.String r9 = r9.asString()
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r2)
            if (r9 == 0) goto L_0x00ae
            goto L_0x00cb
        L_0x00ca:
            r8 = r3
        L_0x00cb:
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r8 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r8
            if (r8 != 0) goto L_0x00d1
            r7 = r3
            goto L_0x00d5
        L_0x00d1:
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r7 = r8.getTypeConstructor()
        L_0x00d5:
            if (r7 != 0) goto L_0x00f5
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Deserialized type parameter "
            r7.append(r8)
            r7.append(r2)
            java.lang.String r2 = " in "
            r7.append(r2)
            r7.append(r6)
            java.lang.String r2 = r7.toString()
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r2 = kotlin.reflect.jvm.internal.impl.types.ErrorUtils.createErrorTypeConstructor(r2)
            goto L_0x00f6
        L_0x00f5:
            r2 = r7
        L_0x00f6:
            java.lang.String r6 = "{\n                val container = c.containingDeclaration\n                val name = c.nameResolver.getString(proto.typeParameterName)\n                val parameter = ownTypeParameters.find { it.name.asString() == name }\n                parameter?.typeConstructor ?: ErrorUtils.createErrorTypeConstructor(\"Deserialized type parameter $name in $container\")\n            }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)
            goto L_0x012f
        L_0x00fd:
            boolean r2 = r17.hasTypeAliasName()
            if (r2 == 0) goto L_0x0124
            kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor> r2 = r0.typeAliasDescriptors
            int r6 = r1.typeAliasName_
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object r2 = r2.invoke(r6)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor) r2
            if (r2 != 0) goto L_0x0119
            int r2 = r1.typeAliasName_
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2 = typeConstructor$notFoundClass(r0, r1, r2)
        L_0x0119:
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r2 = r2.getTypeConstructor()
            java.lang.String r6 = "typeAliasDescriptors(proto.typeAliasName) ?: notFoundClass(proto.typeAliasName)).typeConstructor"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)
            goto L_0x012f
        L_0x0124:
            java.lang.String r2 = "Unknown type"
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r2 = kotlin.reflect.jvm.internal.impl.types.ErrorUtils.createErrorTypeConstructor(r2)
            java.lang.String r6 = "createErrorTypeConstructor(\"Unknown type\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)
        L_0x012f:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r6 = r2.getDeclarationDescriptor()
            boolean r6 = kotlin.reflect.jvm.internal.impl.types.ErrorUtils.isError(r6)
            if (r6 == 0) goto L_0x0147
            java.lang.String r1 = r2.toString()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r1 = kotlin.reflect.jvm.internal.impl.types.ErrorUtils.createErrorTypeWithCustomConstructor(r1, r2)
            java.lang.String r2 = "createErrorTypeWithCustomConstructor(constructor.toString(), constructor)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            return r1
        L_0x0147:
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations r6 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r7 = r0.f5949c
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r7 = r7.components
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r7 = r7.storageManager
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$simpleType$annotations$1 r8 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$simpleType$annotations$1
            r8.<init>(r0, r1)
            r6.<init>(r7, r8)
            java.util.List r7 = simpleType$collectAllArguments(r1, r0)
            java.util.ArrayList r8 = new java.util.ArrayList
            r9 = 10
            int r9 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r7, r9)
            r8.<init>(r9)
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            java.util.Iterator r7 = r7.iterator()
            r9 = 0
        L_0x016d:
            boolean r10 = r7.hasNext()
            java.lang.String r13 = "typeTable"
            java.lang.String r14 = "<this>"
            if (r10 == 0) goto L_0x022d
            java.lang.Object r10 = r7.next()
            int r11 = r9 + 1
            if (r9 < 0) goto L_0x0229
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Argument r10 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type.Argument) r10
            java.util.List r12 = r2.getParameters()
            java.lang.String r15 = "constructor.parameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r15)
            java.lang.Object r9 = kotlin.collections.ArraysKt___ArraysJvmKt.getOrNull(r12, r9)
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r9 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r9
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Argument$Projection r12 = r10.projection_
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Argument$Projection r15 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.Projection.STAR
            if (r12 != r15) goto L_0x01b2
            if (r9 != 0) goto L_0x01aa
            kotlin.reflect.jvm.internal.impl.types.StarProjectionForAbsentTypeParameter r9 = new kotlin.reflect.jvm.internal.impl.types.StarProjectionForAbsentTypeParameter
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r10 = r0.f5949c
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r10 = r10.components
            kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r10 = r10.moduleDescriptor
            kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r10 = r10.getBuiltIns()
            r9.<init>(r10)
            goto L_0x0223
        L_0x01aa:
            kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl r10 = new kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl
            r10.<init>(r9)
            r9 = r10
            goto L_0x0223
        L_0x01b2:
            java.lang.String r9 = "typeArgumentProto.projection"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r9)
            java.lang.String r9 = "projection"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r9)
            int r9 = r12.ordinal()
            if (r9 == 0) goto L_0x01e3
            if (r9 == r4) goto L_0x01e0
            r15 = 2
            if (r9 == r15) goto L_0x01dd
            r1 = 3
            if (r9 == r1) goto L_0x01d1
            kotlin.NoWhenBranchMatchedException r1 = new kotlin.NoWhenBranchMatchedException
            r1.<init>()
            throw r1
        L_0x01d1:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Only IN, OUT and INV are supported. Actual argument: "
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r12)
            r1.<init>(r2)
            throw r1
        L_0x01dd:
            kotlin.reflect.jvm.internal.impl.types.Variance r9 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT
            goto L_0x01e5
        L_0x01e0:
            kotlin.reflect.jvm.internal.impl.types.Variance r9 = kotlin.reflect.jvm.internal.impl.types.Variance.OUT_VARIANCE
            goto L_0x01e5
        L_0x01e3:
            kotlin.reflect.jvm.internal.impl.types.Variance r9 = kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE
        L_0x01e5:
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r12 = r0.f5949c
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r12 = r12.typeTable
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r14)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r13)
            boolean r13 = r10.hasType()
            if (r13 == 0) goto L_0x01f8
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r10 = r10.type_
            goto L_0x020b
        L_0x01f8:
            int r13 = r10.bitField0_
            r14 = 4
            r13 = r13 & r14
            if (r13 != r14) goto L_0x0200
            r13 = 1
            goto L_0x0201
        L_0x0200:
            r13 = 0
        L_0x0201:
            if (r13 == 0) goto L_0x020a
            int r10 = r10.typeId_
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r10 = r12.get(r10)
            goto L_0x020b
        L_0x020a:
            r10 = r3
        L_0x020b:
            if (r10 != 0) goto L_0x0219
            kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl r9 = new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl
            java.lang.String r10 = "No type recorded"
            kotlin.reflect.jvm.internal.impl.types.SimpleType r10 = kotlin.reflect.jvm.internal.impl.types.ErrorUtils.createErrorType(r10)
            r9.<init>(r10)
            goto L_0x0223
        L_0x0219:
            kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl r12 = new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl
            kotlin.reflect.jvm.internal.impl.types.KotlinType r10 = r0.type(r10)
            r12.<init>(r9, r10)
            r9 = r12
        L_0x0223:
            r8.add(r9)
            r9 = r11
            goto L_0x016d
        L_0x0229:
            com.twitter.sdk.android.tweetui.TweetUtils.throwIndexOverflow()
            throw r3
        L_0x022d:
            java.util.List r15 = kotlin.collections.ArraysKt___ArraysJvmKt.toList(r8)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r7 = r2.getDeclarationDescriptor()
            if (r18 == 0) goto L_0x026c
            boolean r8 = r7 instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor
            if (r8 == 0) goto L_0x026c
            kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory r2 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.INSTANCE
            kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor r7 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor) r7
            kotlin.reflect.jvm.internal.impl.types.SimpleType r2 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.computeExpandedType(r7, r15)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r14)
            boolean r7 = kotlin.reflect.jvm.internal.impl.types.TypeUtils.isNullableType(r2)
            if (r7 != 0) goto L_0x0253
            boolean r7 = r1.nullable_
            if (r7 == 0) goto L_0x0251
            goto L_0x0253
        L_0x0251:
            r7 = 0
            goto L_0x0254
        L_0x0253:
            r7 = 1
        L_0x0254:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r7 = r2.makeNullableAsSpecified(r7)
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion r8 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r2 = r2.getAnnotations()
            java.util.List r2 = kotlin.collections.ArraysKt___ArraysJvmKt.plus(r6, r2)
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r2 = r8.create(r2)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r2 = r7.replaceAnnotations(r2)
            goto L_0x0391
        L_0x026c:
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$BooleanFlagField r7 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.SUSPEND_TYPE
            int r8 = r1.flags_
            java.lang.String r9 = "SUSPEND_TYPE.get(proto.flags)"
            boolean r7 = com.android.tools.r8.GeneratedOutlineSupport.outline108(r7, r8, r9)
            if (r7 == 0) goto L_0x0383
            boolean r10 = r1.nullable_
            java.util.List r7 = r2.getParameters()
            int r7 = r7.size()
            int r8 = r15.size()
            int r7 = r7 - r8
            if (r7 == 0) goto L_0x02b4
            if (r7 == r4) goto L_0x028d
            goto L_0x02fb
        L_0x028d:
            int r7 = r15.size()
            int r7 = r7 - r4
            if (r7 < 0) goto L_0x02fb
            kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory r8 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.INSTANCE
            kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r8 = r2.getBuiltIns()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r7 = r8.getSuspendFunction(r7)
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r7 = r7.getTypeConstructor()
            java.lang.String r8 = "functionTypeConstructor.builtIns.getSuspendFunction(arity).typeConstructor"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            r11 = 0
            r12 = 16
            r8 = r15
            r9 = r10
            r10 = r11
            r11 = r12
            kotlin.reflect.jvm.internal.impl.types.SimpleType r6 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleType$default(r6, r7, r8, r9, r10, r11)
            goto L_0x036f
        L_0x02b4:
            kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory r7 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.INSTANCE
            r11 = 0
            r12 = 16
            r7 = r6
            r8 = r2
            r9 = r15
            kotlin.reflect.jvm.internal.impl.types.SimpleType r6 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleType$default(r7, r8, r9, r10, r11, r12)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r14)
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r7 = r6.getConstructor()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r7 = r7.getDeclarationDescriptor()
            if (r7 != 0) goto L_0x02cf
            r7 = r3
            goto L_0x02d3
        L_0x02cf:
            kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind r7 = kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.getFunctionalClassKind(r7)
        L_0x02d3:
            kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind r8 = kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind.Function
            if (r7 != r8) goto L_0x02d9
            r7 = 1
            goto L_0x02da
        L_0x02d9:
            r7 = 0
        L_0x02da:
            if (r7 != 0) goto L_0x02dd
            goto L_0x02fb
        L_0x02dd:
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r7 = r0.f5949c
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r7 = r7.components
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration r7 = r7.configuration
            boolean r7 = r7.getReleaseCoroutines()
            java.util.List r8 = kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.getValueParameterTypesFromFunctionType(r6)
            java.lang.Object r8 = kotlin.collections.ArraysKt___ArraysJvmKt.lastOrNull(r8)
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r8 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r8
            if (r8 != 0) goto L_0x02f5
            r8 = r3
            goto L_0x02f9
        L_0x02f5:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r8 = r8.getType()
        L_0x02f9:
            if (r8 != 0) goto L_0x02fe
        L_0x02fb:
            r6 = r3
            goto L_0x036f
        L_0x02fe:
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r9 = r8.getConstructor()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r9 = r9.getDeclarationDescriptor()
            if (r9 != 0) goto L_0x030a
            r9 = r3
            goto L_0x030e
        L_0x030a:
            kotlin.reflect.jvm.internal.impl.name.FqName r9 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe(r9)
        L_0x030e:
            java.util.List r10 = r8.getArguments()
            int r10 = r10.size()
            if (r10 != r4) goto L_0x036f
            boolean r10 = kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt.isContinuation(r9, r4)
            if (r10 != 0) goto L_0x0325
            boolean r10 = kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt.isContinuation(r9, r5)
            if (r10 != 0) goto L_0x0325
            goto L_0x036f
        L_0x0325:
            java.util.List r8 = r8.getArguments()
            java.lang.Object r8 = kotlin.collections.ArraysKt___ArraysJvmKt.single(r8)
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r8 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r8
            kotlin.reflect.jvm.internal.impl.types.KotlinType r8 = r8.getType()
            java.lang.String r10 = "continuationArgumentType.arguments.single().type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r10)
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r10 = r0.f5949c
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r10 = r10.containingDeclaration
            boolean r11 = r10 instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
            if (r11 != 0) goto L_0x0341
            r10 = r3
        L_0x0341:
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r10 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor) r10
            if (r10 != 0) goto L_0x0347
            r10 = r3
            goto L_0x034b
        L_0x0347:
            kotlin.reflect.jvm.internal.impl.name.FqName r10 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.fqNameOrNull(r10)
        L_0x034b:
            kotlin.reflect.jvm.internal.impl.name.FqName r11 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r11)
            if (r10 == 0) goto L_0x0358
            kotlin.reflect.jvm.internal.impl.types.SimpleType r6 = r0.createSimpleSuspendFunctionType(r6, r8)
            goto L_0x036f
        L_0x0358:
            boolean r10 = r0.experimentalSuspendFunctionTypeEncountered
            if (r10 != 0) goto L_0x0368
            if (r7 == 0) goto L_0x0366
            r7 = r7 ^ r4
            boolean r7 = kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt.isContinuation(r9, r7)
            if (r7 == 0) goto L_0x0366
            goto L_0x0368
        L_0x0366:
            r7 = 0
            goto L_0x0369
        L_0x0368:
            r7 = 1
        L_0x0369:
            r0.experimentalSuspendFunctionTypeEncountered = r7
            kotlin.reflect.jvm.internal.impl.types.SimpleType r6 = r0.createSimpleSuspendFunctionType(r6, r8)
        L_0x036f:
            if (r6 != 0) goto L_0x0381
            java.lang.String r6 = "Bad suspend function in metadata with constructor: "
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r6, r2)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r2 = kotlin.reflect.jvm.internal.impl.types.ErrorUtils.createErrorTypeWithArguments(r2, r15)
            java.lang.String r6 = "createErrorTypeWithArguments(\n            \"Bad suspend function in metadata with constructor: $functionTypeConstructor\",\n            arguments\n        )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)
            goto L_0x0391
        L_0x0381:
            r2 = r6
            goto L_0x0391
        L_0x0383:
            kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory r7 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.INSTANCE
            boolean r10 = r1.nullable_
            r11 = 0
            r12 = 16
            r7 = r6
            r8 = r2
            r9 = r15
            kotlin.reflect.jvm.internal.impl.types.SimpleType r2 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleType$default(r7, r8, r9, r10, r11, r12)
        L_0x0391:
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r6 = r0.f5949c
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r6 = r6.typeTable
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r14)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r13)
            boolean r7 = r17.hasAbbreviatedType()
            if (r7 == 0) goto L_0x03a4
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r3 = r1.abbreviatedType_
            goto L_0x03b5
        L_0x03a4:
            int r7 = r1.bitField0_
            r8 = 2048(0x800, float:2.87E-42)
            r7 = r7 & r8
            if (r7 != r8) goto L_0x03ac
            goto L_0x03ad
        L_0x03ac:
            r4 = 0
        L_0x03ad:
            if (r4 == 0) goto L_0x03b5
            int r3 = r1.abbreviatedTypeId_
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r3 = r6.get(r3)
        L_0x03b5:
            if (r3 != 0) goto L_0x03b8
            goto L_0x03c0
        L_0x03b8:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = r0.simpleType(r3, r5)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r2 = kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt.withAbbreviation(r2, r3)
        L_0x03c0:
            boolean r3 = r17.hasClassName()
            if (r3 == 0) goto L_0x03db
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r3 = r0.f5949c
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r3 = r3.nameResolver
            int r1 = r1.className_
            kotlin.reflect.jvm.internal.impl.name.ClassId r1 = com.twitter.sdk.android.tweetui.TweetUtils.getClassId(r3, r1)
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r3 = r0.f5949c
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r3 = r3.components
            kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentTypeTransformer r3 = r3.platformDependentTypeTransformer
            kotlin.reflect.jvm.internal.impl.types.SimpleType r1 = r3.transformPlatformType(r1, r2)
            return r1
        L_0x03db:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer.simpleType(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type, boolean):kotlin.reflect.jvm.internal.impl.types.SimpleType");
    }

    public String toString() {
        String str = this.debugName;
        TypeDeserializer typeDeserializer = this.parent;
        return Intrinsics.stringPlus(str, typeDeserializer == null ? "" : Intrinsics.stringPlus(". Child of ", typeDeserializer.debugName));
    }

    public final KotlinType type(ProtoBuf$Type protoBuf$Type) {
        ProtoBuf$Type protoBuf$Type2;
        Intrinsics.checkNotNullParameter(protoBuf$Type, "proto");
        boolean z = false;
        if (!((protoBuf$Type.bitField0_ & 2) == 2)) {
            return simpleType(protoBuf$Type, true);
        }
        String string = this.f5949c.nameResolver.getString(protoBuf$Type.flexibleTypeCapabilitiesId_);
        SimpleType simpleType = simpleType(protoBuf$Type, true);
        TypeTable typeTable = this.f5949c.typeTable;
        Intrinsics.checkNotNullParameter(protoBuf$Type, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        if (protoBuf$Type.hasFlexibleUpperBound()) {
            protoBuf$Type2 = protoBuf$Type.flexibleUpperBound_;
        } else {
            if ((protoBuf$Type.bitField0_ & 8) == 8) {
                z = true;
            }
            protoBuf$Type2 = z ? typeTable.get(protoBuf$Type.flexibleUpperBoundId_) : null;
        }
        Intrinsics.checkNotNull(protoBuf$Type2);
        return this.f5949c.components.flexibleTypeDeserializer.create(protoBuf$Type, string, simpleType, simpleType(protoBuf$Type2, true));
    }

    public final TypeConstructor typeParameterTypeConstructor(int i) {
        TypeParameterDescriptor typeParameterDescriptor = this.typeParameterDescriptors.get(Integer.valueOf(i));
        TypeConstructor typeConstructor = typeParameterDescriptor == null ? null : typeParameterDescriptor.getTypeConstructor();
        if (typeConstructor != null) {
            return typeConstructor;
        }
        TypeDeserializer typeDeserializer = this.parent;
        if (typeDeserializer == null) {
            return null;
        }
        return typeDeserializer.typeParameterTypeConstructor(i);
    }
}
