package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer.ClassKey;

/* compiled from: ClassDeserializer.kt */
public final class ClassDeserializer$classes$1 extends Lambda implements Function1<ClassKey, ClassDescriptor> {
    public final /* synthetic */ ClassDeserializer this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ClassDeserializer$classes$1(ClassDeserializer classDeserializer) {
        // this.this$0 = classDeserializer;
        super(1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f2 A[EDGE_INSN: B:51:0x00f2->B:43:0x00f2 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke(java.lang.Object r17) {
        /*
            r16 = this;
            r0 = r17
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer$ClassKey r0 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer.ClassKey) r0
            java.lang.String r1 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r1 = r16
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer r2 = r1.this$0
            r3 = 0
            if (r2 == 0) goto L_0x0126
            kotlin.reflect.jvm.internal.impl.name.ClassId r4 = r0.classId
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r5 = r2.components
            java.lang.Iterable<kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory> r5 = r5.fictitiousClassDescriptorFactories
            java.util.Iterator r5 = r5.iterator()
        L_0x001a:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0030
            java.lang.Object r6 = r5.next()
            kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory r6 = (kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory) r6
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r6 = r6.createClass(r4)
            if (r6 != 0) goto L_0x002d
            goto L_0x001a
        L_0x002d:
            r3 = r6
            goto L_0x0125
        L_0x0030:
            java.util.Set<kotlin.reflect.jvm.internal.impl.name.ClassId> r5 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer.BLACK_LIST
            boolean r5 = r5.contains(r4)
            if (r5 == 0) goto L_0x003a
            goto L_0x0125
        L_0x003a:
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassData r0 = r0.classData
            if (r0 != 0) goto L_0x004a
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r0 = r2.components
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder r0 = r0.classDataFinder
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassData r0 = r0.findClassData(r4)
            if (r0 != 0) goto L_0x004a
            goto L_0x0125
        L_0x004a:
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r12 = r0.nameResolver
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r13 = r0.classProto
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion r14 = r0.metadataVersion
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r0 = r0.sourceElement
            kotlin.reflect.jvm.internal.impl.name.ClassId r5 = r4.getOuterClassId()
            java.lang.String r6 = "name"
            java.lang.String r7 = "classId.shortClassName"
            if (r5 == 0) goto L_0x0099
            r8 = 2
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer.deserializeClass$default(r2, r5, r3, r8)
            boolean r5 = r2 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor
            if (r5 == 0) goto L_0x0068
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor r2 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor) r2
            goto L_0x0069
        L_0x0068:
            r2 = r3
        L_0x0069:
            if (r2 != 0) goto L_0x006d
            goto L_0x0125
        L_0x006d:
            kotlin.reflect.jvm.internal.impl.name.Name r4 = r4.getShortClassName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r6)
            kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass<kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope> r5 = r2.memberScopeHolder
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r6 = r2.f5950c
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r6 = r6.components
            kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker r6 = r6.kotlinTypeChecker
            kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner r6 = r6.getKotlinTypeRefiner()
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r5 = r5.getScope(r6)
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope r5 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassMemberScope) r5
            java.util.Set r5 = r5.getClassNames$deserialization()
            boolean r4 = r5.contains(r4)
            if (r4 != 0) goto L_0x0095
            goto L_0x0125
        L_0x0095:
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r2 = r2.f5950c
            goto L_0x011a
        L_0x0099:
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r5 = r2.components
            kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider r5 = r5.packageFragmentProvider
            kotlin.reflect.jvm.internal.impl.name.FqName r8 = r4.getPackageFqName()
            java.lang.String r9 = "classId.packageFqName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            java.util.List r5 = com.twitter.sdk.android.tweetui.TweetUtils.packageFragments(r5, r8)
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x00b0:
            boolean r8 = r5.hasNext()
            if (r8 == 0) goto L_0x00f1
            java.lang.Object r8 = r5.next()
            r9 = r8
            kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor r9 = (kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) r9
            boolean r10 = r9 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment
            r15 = 1
            if (r10 == 0) goto L_0x00ed
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment r9 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment) r9
            kotlin.reflect.jvm.internal.impl.name.Name r10 = r4.getShortClassName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r7)
            if (r9 == 0) goto L_0x00ec
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r6)
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r9 = r9.getMemberScope()
            boolean r11 = r9 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
            if (r11 == 0) goto L_0x00e6
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope r9 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope) r9
            java.util.Set r9 = r9.getClassNames$deserialization()
            boolean r9 = r9.contains(r10)
            if (r9 == 0) goto L_0x00e6
            r9 = 1
            goto L_0x00e7
        L_0x00e6:
            r9 = 0
        L_0x00e7:
            if (r9 == 0) goto L_0x00ea
            goto L_0x00ed
        L_0x00ea:
            r11 = 0
            goto L_0x00ee
        L_0x00ec:
            throw r3
        L_0x00ed:
            r11 = 1
        L_0x00ee:
            if (r11 == 0) goto L_0x00b0
            goto L_0x00f2
        L_0x00f1:
            r8 = r3
        L_0x00f2:
            r6 = r8
            kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) r6
            if (r6 != 0) goto L_0x00f8
            goto L_0x0125
        L_0x00f8:
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r5 = r2.components
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r8 = new kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r2 = r13.typeTable_
            java.lang.String r3 = "classProto.typeTable"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r8.<init>(r2)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable$Companion r2 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable.Companion
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable r3 = r13.versionRequirementTable_
            java.lang.String r4 = "classProto.versionRequirementTable"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable r9 = r2.create(r3)
            r11 = 0
            r7 = r12
            r10 = r14
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r2 = r5.createContext(r6, r7, r8, r9, r10, r11)
        L_0x011a:
            r6 = r2
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor r3 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor
            r5 = r3
            r7 = r13
            r8 = r12
            r9 = r14
            r10 = r0
            r5.<init>(r6, r7, r8, r9, r10)
        L_0x0125:
            return r3
        L_0x0126:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer$classes$1.invoke(java.lang.Object):java.lang.Object");
    }
}
