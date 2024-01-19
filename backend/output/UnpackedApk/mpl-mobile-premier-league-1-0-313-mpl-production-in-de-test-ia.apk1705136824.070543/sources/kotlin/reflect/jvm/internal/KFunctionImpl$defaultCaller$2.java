package kotlin.reflect.jvm.internal;

import java.lang.reflect.Member;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.calls.Caller;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: KFunctionImpl.kt */
public final class KFunctionImpl$defaultCaller$2 extends Lambda implements Function0<Caller<? extends Member>> {
    public final /* synthetic */ KFunctionImpl this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public KFunctionImpl$defaultCaller$2(KFunctionImpl kFunctionImpl) {
        // this.this$0 = kFunctionImpl;
        super(0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x019e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke() {
        /*
            r13 = this;
            kotlin.reflect.jvm.internal.RuntimeTypeMapper r0 = kotlin.reflect.jvm.internal.RuntimeTypeMapper.INSTANCE
            kotlin.reflect.jvm.internal.KFunctionImpl r0 = r13.this$0
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r0 = r0.getDescriptor()
            kotlin.reflect.jvm.internal.JvmFunctionSignature r0 = kotlin.reflect.jvm.internal.RuntimeTypeMapper.mapSignature(r0)
            boolean r1 = r0 instanceof kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction
            java.lang.String r2 = "desc"
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0085
            kotlin.reflect.jvm.internal.KFunctionImpl r1 = r13.this$0
            kotlin.reflect.jvm.internal.KDeclarationContainerImpl r5 = r1.container
            kotlin.reflect.jvm.internal.JvmFunctionSignature$KotlinFunction r0 = (kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction) r0
            kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature$Method r0 = r0.signature
            java.lang.String r6 = r0.name
            java.lang.String r0 = r0.desc
            kotlin.reflect.jvm.internal.calls.Caller r1 = r1.getCaller()
            java.lang.reflect.Member r1 = r1.getMember()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = r1.getModifiers()
            boolean r1 = java.lang.reflect.Modifier.isStatic(r1)
            r10 = r1 ^ 1
            if (r5 == 0) goto L_0x0084
            java.lang.String r1 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            java.lang.String r1 = "<init>"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r1)
            if (r1 == 0) goto L_0x0049
            goto L_0x0137
        L_0x0049:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            if (r10 == 0) goto L_0x0057
            java.lang.Class r2 = r5.getJClass()
            r1.add(r2)
        L_0x0057:
            r2 = 0
            r5.addParametersAndMasks(r1, r0, r2)
            java.lang.Class r7 = r5.getMethodOwner()
            java.lang.String r8 = "$default"
            java.lang.String r8 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r6, r8)
            java.lang.Class[] r2 = new java.lang.Class[r2]
            java.lang.Object[] r1 = r1.toArray(r2)
            if (r1 == 0) goto L_0x007c
            java.lang.Class[] r1 = (java.lang.Class[]) r1
            java.lang.Class r9 = r5.loadReturnType(r0)
            r6 = r7
            r7 = r8
            r8 = r1
            java.lang.reflect.Method r0 = r5.lookupMethod(r6, r7, r8, r9, r10)
            goto L_0x0138
        L_0x007c:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<T>"
            r0.<init>(r1)
            throw r0
        L_0x0084:
            throw r3
        L_0x0085:
            boolean r1 = r0 instanceof kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinConstructor
            r5 = 10
            if (r1 == 0) goto L_0x00f5
            kotlin.reflect.jvm.internal.KFunctionImpl r1 = r13.this$0
            boolean r1 = r1.isAnnotationConstructor()
            if (r1 == 0) goto L_0x00d4
            kotlin.reflect.jvm.internal.KFunctionImpl r0 = r13.this$0
            kotlin.reflect.jvm.internal.KDeclarationContainerImpl r0 = r0.container
            java.lang.Class r7 = r0.getJClass()
            kotlin.reflect.jvm.internal.KFunctionImpl r0 = r13.this$0
            java.util.List r0 = r0.getParameters()
            java.util.ArrayList r8 = new java.util.ArrayList
            int r1 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r0, r5)
            r8.<init>(r1)
            java.util.Iterator r0 = r0.iterator()
        L_0x00ae:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00c5
            java.lang.Object r1 = r0.next()
            kotlin.reflect.KParameter r1 = (kotlin.reflect.KParameter) r1
            java.lang.String r1 = r1.getName()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r8.add(r1)
            goto L_0x00ae
        L_0x00c5:
            kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller$CallMode r9 = kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.CallMode.CALL_BY_NAME
            kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller$Origin r10 = kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.Origin.KOTLIN
            r11 = 0
            r12 = 16
            kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller r0 = new kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12)
            goto L_0x01a9
        L_0x00d4:
            kotlin.reflect.jvm.internal.KFunctionImpl r1 = r13.this$0
            kotlin.reflect.jvm.internal.KDeclarationContainerImpl r1 = r1.container
            kotlin.reflect.jvm.internal.JvmFunctionSignature$KotlinConstructor r0 = (kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinConstructor) r0
            kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature$Method r0 = r0.signature
            java.lang.String r0 = r0.desc
            if (r1 == 0) goto L_0x00f4
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            java.lang.Class r2 = r1.getJClass()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r1.addParametersAndMasks(r5, r0, r4)
            java.lang.reflect.Constructor r0 = r1.tryGetConstructor(r2, r5)
            goto L_0x0138
        L_0x00f4:
            throw r3
        L_0x00f5:
            boolean r1 = r0 instanceof kotlin.reflect.jvm.internal.JvmFunctionSignature.FakeJavaAnnotationConstructor
            if (r1 == 0) goto L_0x0137
            kotlin.reflect.jvm.internal.JvmFunctionSignature$FakeJavaAnnotationConstructor r0 = (kotlin.reflect.jvm.internal.JvmFunctionSignature.FakeJavaAnnotationConstructor) r0
            java.util.List<java.lang.reflect.Method> r11 = r0.methods
            kotlin.reflect.jvm.internal.KFunctionImpl r0 = r13.this$0
            kotlin.reflect.jvm.internal.KDeclarationContainerImpl r0 = r0.container
            java.lang.Class r7 = r0.getJClass()
            java.util.ArrayList r8 = new java.util.ArrayList
            int r0 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r11, r5)
            r8.<init>(r0)
            java.util.Iterator r0 = r11.iterator()
        L_0x0112:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x012b
            java.lang.Object r1 = r0.next()
            java.lang.reflect.Method r1 = (java.lang.reflect.Method) r1
            java.lang.String r2 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.String r1 = r1.getName()
            r8.add(r1)
            goto L_0x0112
        L_0x012b:
            kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller$CallMode r9 = kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.CallMode.CALL_BY_NAME
            kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller$Origin r10 = kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.Origin.JAVA
            kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller r0 = new kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11)
            goto L_0x01a9
        L_0x0137:
            r0 = r3
        L_0x0138:
            boolean r1 = r0 instanceof java.lang.reflect.Constructor
            if (r1 == 0) goto L_0x0149
            kotlin.reflect.jvm.internal.KFunctionImpl r1 = r13.this$0
            java.lang.reflect.Constructor r0 = (java.lang.reflect.Constructor) r0
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r2 = r1.getDescriptor()
            kotlin.reflect.jvm.internal.calls.CallerImpl r0 = kotlin.reflect.jvm.internal.KFunctionImpl.access$createConstructorCaller(r1, r0, r2)
            goto L_0x019c
        L_0x0149:
            boolean r1 = r0 instanceof java.lang.reflect.Method
            if (r1 == 0) goto L_0x019b
            kotlin.reflect.jvm.internal.KFunctionImpl r1 = r13.this$0
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r1 = r1.getDescriptor()
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r1 = r1.getAnnotations()
            kotlin.reflect.jvm.internal.impl.name.FqName r2 = kotlin.reflect.jvm.internal.UtilKt.JVM_STATIC
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor r1 = r1.findAnnotation(r2)
            if (r1 == 0) goto L_0x0192
            kotlin.reflect.jvm.internal.KFunctionImpl r1 = r13.this$0
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r1 = r1.getDescriptor()
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r1 = r1.getContainingDeclaration()
            if (r1 == 0) goto L_0x018a
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r1
            boolean r1 = r1.isCompanionObject()
            if (r1 != 0) goto L_0x0192
            kotlin.reflect.jvm.internal.KFunctionImpl r1 = r13.this$0
            java.lang.reflect.Method r0 = (java.lang.reflect.Method) r0
            boolean r1 = r1.isBound()
            if (r1 == 0) goto L_0x0183
            kotlin.reflect.jvm.internal.calls.CallerImpl$Method$BoundJvmStaticInObject r1 = new kotlin.reflect.jvm.internal.calls.CallerImpl$Method$BoundJvmStaticInObject
            r1.<init>(r0)
            goto L_0x0188
        L_0x0183:
            kotlin.reflect.jvm.internal.calls.CallerImpl$Method$JvmStaticInObject r1 = new kotlin.reflect.jvm.internal.calls.CallerImpl$Method$JvmStaticInObject
            r1.<init>(r0)
        L_0x0188:
            r0 = r1
            goto L_0x019c
        L_0x018a:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor"
            r0.<init>(r1)
            throw r0
        L_0x0192:
            kotlin.reflect.jvm.internal.KFunctionImpl r1 = r13.this$0
            java.lang.reflect.Method r0 = (java.lang.reflect.Method) r0
            kotlin.reflect.jvm.internal.calls.CallerImpl$Method r0 = kotlin.reflect.jvm.internal.KFunctionImpl.access$createStaticMethodCaller(r1, r0)
            goto L_0x019c
        L_0x019b:
            r0 = r3
        L_0x019c:
            if (r0 == 0) goto L_0x01a8
            kotlin.reflect.jvm.internal.KFunctionImpl r1 = r13.this$0
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r1 = r1.getDescriptor()
            kotlin.reflect.jvm.internal.calls.Caller r3 = com.twitter.sdk.android.tweetui.TweetUtils.createInlineClassAwareCallerIfNeeded(r0, r1, r4)
        L_0x01a8:
            r0 = r3
        L_0x01a9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KFunctionImpl$defaultCaller$2.invoke():java.lang.Object");
    }
}
