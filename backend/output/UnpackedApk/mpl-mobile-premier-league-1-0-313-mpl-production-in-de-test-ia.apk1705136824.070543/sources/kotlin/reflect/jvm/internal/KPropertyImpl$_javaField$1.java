package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Field;", "V", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: KPropertyImpl.kt */
public final class KPropertyImpl$_javaField$1 extends Lambda implements Function0<Field> {
    public final /* synthetic */ KPropertyImpl this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public KPropertyImpl$_javaField$1(KPropertyImpl kPropertyImpl) {
        // this.this$0 = kPropertyImpl;
        super(0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007e, code lost:
        if (r4 != false) goto L_0x0082;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b3 A[SYNTHETIC, Splitter:B:38:0x00b3] */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke() {
        /*
            r8 = this;
            kotlin.reflect.jvm.internal.RuntimeTypeMapper r0 = kotlin.reflect.jvm.internal.RuntimeTypeMapper.INSTANCE
            kotlin.reflect.jvm.internal.KPropertyImpl r0 = r8.this$0
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r0 = r0.getDescriptor()
            kotlin.reflect.jvm.internal.JvmPropertySignature r0 = kotlin.reflect.jvm.internal.RuntimeTypeMapper.mapPropertySignature(r0)
            boolean r1 = r0 instanceof kotlin.reflect.jvm.internal.JvmPropertySignature.KotlinProperty
            r2 = 0
            if (r1 == 0) goto L_0x00c2
            kotlin.reflect.jvm.internal.JvmPropertySignature$KotlinProperty r0 = (kotlin.reflect.jvm.internal.JvmPropertySignature.KotlinProperty) r0
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r1 = r0.descriptor
            kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil r3 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil.INSTANCE
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r4 = r0.proto
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r5 = r0.nameResolver
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r6 = r0.typeTable
            r7 = 1
            kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature$Field r3 = r3.getJvmFieldSignature(r4, r5, r6, r7)
            if (r3 == 0) goto L_0x00d4
            r4 = 0
            if (r1 == 0) goto L_0x00be
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r4 = r1.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r5 = kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.FAKE_OVERRIDE
            if (r4 != r5) goto L_0x0030
            goto L_0x0081
        L_0x0030:
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r4 = r1.getContainingDeclaration()
            if (r4 == 0) goto L_0x00ba
            boolean r5 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isCompanionObject(r4)
            if (r5 == 0) goto L_0x0052
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r5 = r4.getContainingDeclaration()
            boolean r5 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isClassOrEnumClass(r5)
            if (r5 == 0) goto L_0x0052
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r4
            kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping r5 = kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping.INSTANCE
            boolean r4 = com.twitter.sdk.android.tweetui.TweetUtils.isMappedIntrinsicCompanionObject(r5, r4)
            if (r4 != 0) goto L_0x0052
            r4 = 1
            goto L_0x0053
        L_0x0052:
            r4 = 0
        L_0x0053:
            if (r4 == 0) goto L_0x0056
            goto L_0x0082
        L_0x0056:
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r4 = r1.getContainingDeclaration()
            boolean r4 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isCompanionObject(r4)
            if (r4 == 0) goto L_0x0081
            kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor r4 = r1.getBackingField()
            if (r4 == 0) goto L_0x0074
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r4 = r4.getAnnotations()
            kotlin.reflect.jvm.internal.impl.name.FqName r5 = kotlin.reflect.jvm.internal.impl.load.java.JvmAbi.JVM_FIELD_ANNOTATION_FQ_NAME
            boolean r4 = r4.hasAnnotation(r5)
            if (r4 == 0) goto L_0x0074
            r4 = 1
            goto L_0x007e
        L_0x0074:
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r4 = r1.getAnnotations()
            kotlin.reflect.jvm.internal.impl.name.FqName r5 = kotlin.reflect.jvm.internal.impl.load.java.JvmAbi.JVM_FIELD_ANNOTATION_FQ_NAME
            boolean r4 = r4.hasAnnotation(r5)
        L_0x007e:
            if (r4 == 0) goto L_0x0081
            goto L_0x0082
        L_0x0081:
            r7 = 0
        L_0x0082:
            if (r7 != 0) goto L_0x00a5
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r0 = r0.proto
            boolean r0 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil.isMovedFromInterfaceCompanion(r0)
            if (r0 == 0) goto L_0x008d
            goto L_0x00a5
        L_0x008d:
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r0 = r1.getContainingDeclaration()
            boolean r1 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r1 == 0) goto L_0x009c
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r0
            java.lang.Class r0 = kotlin.reflect.jvm.internal.UtilKt.toJavaClass(r0)
            goto L_0x00b1
        L_0x009c:
            kotlin.reflect.jvm.internal.KPropertyImpl r0 = r8.this$0
            kotlin.reflect.jvm.internal.KDeclarationContainerImpl r0 = r0.container
            java.lang.Class r0 = r0.getJClass()
            goto L_0x00b1
        L_0x00a5:
            kotlin.reflect.jvm.internal.KPropertyImpl r0 = r8.this$0
            kotlin.reflect.jvm.internal.KDeclarationContainerImpl r0 = r0.container
            java.lang.Class r0 = r0.getJClass()
            java.lang.Class r0 = r0.getEnclosingClass()
        L_0x00b1:
            if (r0 == 0) goto L_0x00d4
            java.lang.String r1 = r3.name     // Catch:{ NoSuchFieldException -> 0x00d4 }
            java.lang.reflect.Field r2 = r0.getDeclaredField(r1)     // Catch:{ NoSuchFieldException -> 0x00d4 }
            goto L_0x00d4
        L_0x00ba:
            com.twitter.sdk.android.tweetui.TweetUtils.$$$reportNull$$$01(r7)
            throw r2
        L_0x00be:
            com.twitter.sdk.android.tweetui.TweetUtils.$$$reportNull$$$01(r4)
            throw r2
        L_0x00c2:
            boolean r1 = r0 instanceof kotlin.reflect.jvm.internal.JvmPropertySignature.JavaField
            if (r1 == 0) goto L_0x00cb
            kotlin.reflect.jvm.internal.JvmPropertySignature$JavaField r0 = (kotlin.reflect.jvm.internal.JvmPropertySignature.JavaField) r0
            java.lang.reflect.Field r2 = r0.field
            goto L_0x00d4
        L_0x00cb:
            boolean r1 = r0 instanceof kotlin.reflect.jvm.internal.JvmPropertySignature.JavaMethodProperty
            if (r1 == 0) goto L_0x00d0
            goto L_0x00d4
        L_0x00d0:
            boolean r0 = r0 instanceof kotlin.reflect.jvm.internal.JvmPropertySignature.MappedKotlinProperty
            if (r0 == 0) goto L_0x00d5
        L_0x00d4:
            return r2
        L_0x00d5:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KPropertyImpl$_javaField$1.invoke():java.lang.Object");
    }
}
