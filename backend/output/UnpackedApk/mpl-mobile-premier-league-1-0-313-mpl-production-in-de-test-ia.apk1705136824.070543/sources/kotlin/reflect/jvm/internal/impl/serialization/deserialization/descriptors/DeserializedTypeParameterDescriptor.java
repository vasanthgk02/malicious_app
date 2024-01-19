package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractLazyTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: DeserializedTypeParameterDescriptor.kt */
public final class DeserializedTypeParameterDescriptor extends AbstractLazyTypeParameterDescriptor {
    public final DeserializedAnnotations annotations;

    /* renamed from: c  reason: collision with root package name */
    public final DeserializationContext f5952c;
    public final ProtoBuf$TypeParameter proto;

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeserializedTypeParameterDescriptor(kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r11, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter r12, int r13) {
        /*
            r10 = this;
            java.lang.String r0 = "c"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "proto"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r0 = r11.components
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r2 = r0.storageManager
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r3 = r11.containingDeclaration
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r0 = r11.nameResolver
            int r1 = r12.name_
            kotlin.reflect.jvm.internal.impl.name.Name r4 = com.twitter.sdk.android.tweetui.TweetUtils.getName(r0, r1)
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter$Variance r0 = r12.variance_
            java.lang.String r1 = "proto.variance"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.String r1 = "variance"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            int r0 = r0.ordinal()
            if (r0 == 0) goto L_0x003d
            r1 = 1
            if (r0 == r1) goto L_0x003a
            r1 = 2
            if (r0 != r1) goto L_0x0034
            kotlin.reflect.jvm.internal.impl.types.Variance r0 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT
            goto L_0x003f
        L_0x0034:
            kotlin.NoWhenBranchMatchedException r11 = new kotlin.NoWhenBranchMatchedException
            r11.<init>()
            throw r11
        L_0x003a:
            kotlin.reflect.jvm.internal.impl.types.Variance r0 = kotlin.reflect.jvm.internal.impl.types.Variance.OUT_VARIANCE
            goto L_0x003f
        L_0x003d:
            kotlin.reflect.jvm.internal.impl.types.Variance r0 = kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE
        L_0x003f:
            r5 = r0
            boolean r6 = r12.reified_
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r8 = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE
            kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker$EMPTY r9 = kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker.EMPTY.INSTANCE
            r1 = r10
            r7 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            r10.f5952c = r11
            r10.proto = r12
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations r11 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r12 = r10.f5952c
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r12 = r12.components
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r12 = r12.storageManager
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor$annotations$1 r13 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor$annotations$1
            r13.<init>(r10)
            r11.<init>(r12, r13)
            r10.annotations = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor.<init>(kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter, int):void");
    }

    public Annotations getAnnotations() {
        return this.annotations;
    }

    public void reportSupertypeLoopError(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        throw new IllegalStateException(Intrinsics.stringPlus("There should be no cycles for deserialized type parameters, but found for: ", this));
    }

    /* JADX WARNING: type inference failed for: r2v2, types: [java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type>, java.util.Collection] */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r2v4, types: [java.util.List, java.lang.Iterable] */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> resolveUpperBounds() {
        /*
            r6 = this;
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter r0 = r6.proto
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r1 = r6.f5952c
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r1 = r1.typeTable
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            java.lang.String r2 = "typeTable"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r2 = r0.upperBound_
            boolean r3 = r2.isEmpty()
            r3 = r3 ^ 1
            if (r3 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r2 = 0
        L_0x001d:
            r3 = 10
            if (r2 != 0) goto L_0x0053
            java.util.List<java.lang.Integer> r0 = r0.upperBoundId_
            java.lang.String r2 = "upperBoundIdList"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            int r4 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r0, r3)
            r2.<init>(r4)
            java.util.Iterator r0 = r0.iterator()
        L_0x0036:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0053
            java.lang.Object r4 = r0.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            java.lang.String r5 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            int r4 = r4.intValue()
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r4 = r1.get(r4)
            r2.add(r4)
            goto L_0x0036
        L_0x0053:
            boolean r0 = r2.isEmpty()
            if (r0 == 0) goto L_0x0066
            kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r0 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getBuiltIns(r6)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = r0.getDefaultBound()
            java.util.List r0 = com.twitter.sdk.android.tweetui.TweetUtils.listOf(r0)
            return r0
        L_0x0066:
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r0 = r6.f5952c
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer r0 = r0.typeDeserializer
            java.util.ArrayList r1 = new java.util.ArrayList
            int r3 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r2, r3)
            r1.<init>(r3)
            java.util.Iterator r2 = r2.iterator()
        L_0x0077:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x008b
            java.lang.Object r3 = r2.next()
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type) r3
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = r0.type(r3)
            r1.add(r3)
            goto L_0x0077
        L_0x008b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor.resolveUpperBounds():java.util.List");
    }
}
