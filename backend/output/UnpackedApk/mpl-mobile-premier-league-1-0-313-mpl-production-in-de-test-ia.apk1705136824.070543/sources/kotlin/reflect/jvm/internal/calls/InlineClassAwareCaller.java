package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.UtilKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0000\u0018\u0000*\f\b\u0000\u0010\u0001 \u0001*\u0004\u0018\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001cB#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0016¢\u0006\u0002\u0010\u001bR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "caller", "isDefault", "", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;Lkotlin/reflect/jvm/internal/calls/Caller;Z)V", "data", "Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "member", "getMember", "()Ljava/lang/reflect/Member;", "parameterTypes", "", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "BoxUnboxData", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
/* compiled from: InlineClassAwareCaller.kt */
public final class InlineClassAwareCaller<M extends Member> implements Caller<M> {
    public final Caller<M> caller;
    public final BoxUnboxData data;
    public final boolean isDefault;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003H\u0002J\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0002¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "", "argumentRange", "Lkotlin/ranges/IntRange;", "unbox", "", "Ljava/lang/reflect/Method;", "box", "(Lkotlin/ranges/IntRange;[Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getArgumentRange", "()Lkotlin/ranges/IntRange;", "getBox", "()Ljava/lang/reflect/Method;", "getUnbox", "()[Ljava/lang/reflect/Method;", "[Ljava/lang/reflect/Method;", "component1", "component2", "component3", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    /* compiled from: InlineClassAwareCaller.kt */
    public static final class BoxUnboxData {
        public final IntRange argumentRange;
        public final Method box;
        public final Method[] unbox;

        public BoxUnboxData(IntRange intRange, Method[] methodArr, Method method) {
            Intrinsics.checkNotNullParameter(intRange, "argumentRange");
            Intrinsics.checkNotNullParameter(methodArr, "unbox");
            this.argumentRange = intRange;
            this.unbox = methodArr;
            this.box = method;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x008e, code lost:
        if ((r9 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller) != false) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ab, code lost:
        r5 = 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public InlineClassAwareCaller(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r8, kotlin.reflect.jvm.internal.calls.Caller<? extends M> r9, boolean r10) {
        /*
            r7 = this;
            java.lang.String r0 = "descriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r1 = "caller"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
            r7.<init>()
            r7.caller = r9
            r7.isDefault = r10
            kotlin.reflect.jvm.internal.impl.types.KotlinType r9 = r8.getReturnType()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            java.lang.String r10 = "descriptor.returnType!!"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            java.lang.Class r9 = com.twitter.sdk.android.tweetui.TweetUtils.toInlineClass(r9)
            r10 = 1
            r1 = 0
            r2 = 0
            if (r9 == 0) goto L_0x006a
            java.lang.String r3 = "$this$getBoxMethod"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "box-impl"
            java.lang.Class[] r3 = new java.lang.Class[r10]     // Catch:{ NoSuchMethodException -> 0x0046 }
            java.lang.reflect.Method r4 = com.twitter.sdk.android.tweetui.TweetUtils.getUnboxMethod(r9, r8)     // Catch:{ NoSuchMethodException -> 0x0046 }
            java.lang.Class r4 = r4.getReturnType()     // Catch:{ NoSuchMethodException -> 0x0046 }
            r3[r1] = r4     // Catch:{ NoSuchMethodException -> 0x0046 }
            java.lang.reflect.Method r0 = r9.getDeclaredMethod(r0, r3)     // Catch:{ NoSuchMethodException -> 0x0046 }
            java.lang.String r3 = "getDeclaredMethod(\"box\" …d(descriptor).returnType)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)     // Catch:{ NoSuchMethodException -> 0x0046 }
            goto L_0x006b
        L_0x0046:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r10 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "No box method found in inline class: "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r9 = " (calling "
            r0.append(r9)
            r0.append(r8)
            r8 = 41
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r10.<init>(r8)
            throw r10
        L_0x006a:
            r0 = r2
        L_0x006b:
            boolean r9 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isGetterOfUnderlyingPropertyOfInlineClass(r8)
            if (r9 == 0) goto L_0x007e
            kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData r8 = new kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData
            kotlin.ranges.IntRange r9 = kotlin.ranges.IntRange.Companion
            kotlin.ranges.IntRange r9 = kotlin.ranges.IntRange.EMPTY
            java.lang.reflect.Method[] r10 = new java.lang.reflect.Method[r1]
            r8.<init>(r9, r10, r0)
            goto L_0x0186
        L_0x007e:
            kotlin.reflect.jvm.internal.calls.Caller<M> r9 = r7.caller
            boolean r3 = r9 instanceof kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundStatic
            java.lang.String r4 = "descriptor.containingDeclaration"
            r5 = -1
            if (r3 == 0) goto L_0x0088
            goto L_0x00ae
        L_0x0088:
            boolean r3 = r8 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
            if (r3 == 0) goto L_0x0091
            boolean r9 = r9 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller
            if (r9 == 0) goto L_0x00ad
            goto L_0x00ae
        L_0x0091:
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r9 = r8.getDispatchReceiverParameter()
            if (r9 == 0) goto L_0x00ad
            kotlin.reflect.jvm.internal.calls.Caller<M> r9 = r7.caller
            boolean r9 = r9 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller
            if (r9 != 0) goto L_0x00ad
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r9 = r8.getContainingDeclaration()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r4)
            boolean r9 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isInlineClass(r9)
            if (r9 == 0) goto L_0x00ab
            goto L_0x00ad
        L_0x00ab:
            r5 = 1
            goto L_0x00ae
        L_0x00ad:
            r5 = 0
        L_0x00ae:
            boolean r9 = r7.isDefault
            if (r9 == 0) goto L_0x00b4
            r9 = 2
            goto L_0x00b5
        L_0x00b4:
            r9 = 0
        L_0x00b5:
            boolean r3 = r8 instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
            if (r3 == 0) goto L_0x00c3
            r3 = r8
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r3
            boolean r3 = r3.isSuspend()
            if (r3 == 0) goto L_0x00c3
            goto L_0x00c4
        L_0x00c3:
            r10 = 0
        L_0x00c4:
            int r9 = r9 + r10
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r3 = r8.getExtensionReceiverParameter()
            if (r3 == 0) goto L_0x00d5
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = r3.getType()
            goto L_0x00d6
        L_0x00d5:
            r3 = r2
        L_0x00d6:
            if (r3 == 0) goto L_0x00dc
            r10.add(r3)
            goto L_0x0124
        L_0x00dc:
            boolean r3 = r8 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
            if (r3 == 0) goto L_0x010a
            r3 = r8
            kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor) r3
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r3 = r3.getConstructedClass()
            java.lang.String r4 = "descriptor.constructedClass"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            boolean r4 = r3.isInner()
            if (r4 == 0) goto L_0x0124
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r3 = r3.getContainingDeclaration()
            if (r3 == 0) goto L_0x0102
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r3
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = r3.getDefaultType()
            r10.add(r3)
            goto L_0x0124
        L_0x0102:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            java.lang.String r9 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor"
            r8.<init>(r9)
            throw r8
        L_0x010a:
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r3 = r8.getContainingDeclaration()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            boolean r4 = r3 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r4 == 0) goto L_0x0124
            boolean r4 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isInlineClass(r3)
            if (r4 == 0) goto L_0x0124
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r3
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = r3.getDefaultType()
            r10.add(r3)
        L_0x0124:
            java.util.List r3 = r8.getValueParameters()
            java.lang.String r4 = "descriptor.valueParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            java.util.Iterator r3 = r3.iterator()
        L_0x0131:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0145
            java.lang.Object r4 = r3.next()
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r4
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = r4.getType()
            r10.add(r4)
            goto L_0x0131
        L_0x0145:
            int r3 = r10.size()
            int r3 = r3 + r5
            int r3 = r3 + r9
            int r9 = com.twitter.sdk.android.tweetui.TweetUtils.getArity(r7)
            if (r9 != r3) goto L_0x0189
            int r9 = java.lang.Math.max(r5, r1)
            int r4 = r10.size()
            int r4 = r4 + r5
            kotlin.ranges.IntRange r9 = kotlin.ranges.RangesKt___RangesKt.until(r9, r4)
            java.lang.reflect.Method[] r4 = new java.lang.reflect.Method[r3]
        L_0x0160:
            if (r1 >= r3) goto L_0x0181
            boolean r6 = r9.contains(r1)
            if (r6 == 0) goto L_0x017b
            int r6 = r1 - r5
            java.lang.Object r6 = r10.get(r6)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r6 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r6
            java.lang.Class r6 = com.twitter.sdk.android.tweetui.TweetUtils.toInlineClass(r6)
            if (r6 == 0) goto L_0x017b
            java.lang.reflect.Method r6 = com.twitter.sdk.android.tweetui.TweetUtils.getUnboxMethod(r6, r8)
            goto L_0x017c
        L_0x017b:
            r6 = r2
        L_0x017c:
            r4[r1] = r6
            int r1 = r1 + 1
            goto L_0x0160
        L_0x0181:
            kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData r8 = new kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData
            r8.<init>(r9, r4, r0)
        L_0x0186:
            r7.data = r8
            return
        L_0x0189:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r9 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.String r10 = "Inconsistent number of parameters in the descriptor and Java reflection object: "
            java.lang.StringBuilder r10 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r10)
            int r0 = com.twitter.sdk.android.tweetui.TweetUtils.getArity(r7)
            r10.append(r0)
            java.lang.String r0 = " != "
            r10.append(r0)
            r10.append(r3)
            r0 = 10
            r10.append(r0)
            java.lang.String r1 = "Calling: "
            r10.append(r1)
            r10.append(r8)
            r10.append(r0)
            java.lang.String r8 = "Parameter types: "
            r10.append(r8)
            java.util.List r8 = r7.getParameterTypes()
            r10.append(r8)
            java.lang.String r8 = ")\n"
            r10.append(r8)
            java.lang.String r8 = "Default: "
            r10.append(r8)
            boolean r8 = r7.isDefault
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r9.<init>(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller.<init>(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.calls.Caller, boolean):void");
    }

    public Object call(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "args");
        BoxUnboxData boxUnboxData = this.data;
        IntRange intRange = boxUnboxData.argumentRange;
        Method[] methodArr = boxUnboxData.unbox;
        Method method = boxUnboxData.box;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        int i = intRange.first;
        int i2 = intRange.last;
        if (i <= i2) {
            while (true) {
                Method method2 = methodArr[i];
                Object obj = objArr[i];
                if (method2 != null) {
                    if (obj != null) {
                        obj = method2.invoke(obj, new Object[0]);
                    } else {
                        Class<?> returnType = method2.getReturnType();
                        Intrinsics.checkNotNullExpressionValue(returnType, "method.returnType");
                        obj = UtilKt.defaultPrimitiveValue(returnType);
                    }
                }
                copyOf[i] = obj;
                if (i == i2) {
                    break;
                }
                i++;
            }
        }
        Object call = this.caller.call(copyOf);
        if (method == null) {
            return call;
        }
        Object invoke = method.invoke(null, new Object[]{call});
        return invoke != null ? invoke : call;
    }

    public M getMember() {
        return this.caller.getMember();
    }

    public List<Type> getParameterTypes() {
        return this.caller.getParameterTypes();
    }

    public Type getReturnType() {
        return this.caller.getReturnType();
    }
}
