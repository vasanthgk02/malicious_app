package kotlin.reflect.jvm.internal.calls;

import com.twitter.sdk.android.tweetui.TweetUtils;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002 !B?\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006¢\u0006\u0002\u0010\u000eJ\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00102\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001eH\u0016¢\u0006\u0002\u0010\u001fR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\""}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "", "jClass", "Ljava/lang/Class;", "parameterNames", "", "", "callMode", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "origin", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "methods", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/List;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;Ljava/util/List;)V", "defaultValues", "", "erasedParameterTypes", "member", "getMember", "()Ljava/lang/Void;", "parameterTypes", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "CallMode", "Origin", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
/* compiled from: AnnotationConstructorCaller.kt */
public final class AnnotationConstructorCaller implements Caller {
    public final CallMode callMode;
    public final List<Object> defaultValues;
    public final List<Class<?>> erasedParameterTypes;
    public final Class<?> jClass;
    public final List<Method> methods;
    public final List<String> parameterNames;
    public final List<Type> parameterTypes;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "", "(Ljava/lang/String;I)V", "CALL_BY_NAME", "POSITIONAL_CALL", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    /* compiled from: AnnotationConstructorCaller.kt */
    public enum CallMode {
        CALL_BY_NAME,
        POSITIONAL_CALL
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "", "(Ljava/lang/String;I)V", "JAVA", "KOTLIN", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    /* compiled from: AnnotationConstructorCaller.kt */
    public enum Origin {
        JAVA,
        KOTLIN
    }

    public AnnotationConstructorCaller(Class<?> cls, List<String> list, CallMode callMode2, Origin origin, List<Method> list2) {
        Intrinsics.checkNotNullParameter(cls, "jClass");
        Intrinsics.checkNotNullParameter(list, "parameterNames");
        Intrinsics.checkNotNullParameter(callMode2, "callMode");
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(list2, "methods");
        this.jClass = cls;
        this.parameterNames = list;
        this.callMode = callMode2;
        this.methods = list2;
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(list2, 10));
        for (Method genericReturnType : list2) {
            arrayList.add(genericReturnType.getGenericReturnType());
        }
        this.parameterTypes = arrayList;
        List<Method> list3 = this.methods;
        ArrayList arrayList2 = new ArrayList(TweetUtils.collectionSizeOrDefault(list3, 10));
        for (Method returnType : list3) {
            Class<?> returnType2 = returnType.getReturnType();
            Intrinsics.checkNotNullExpressionValue(returnType2, "it");
            Class<?> wrapperByPrimitive = ReflectClassUtilKt.getWrapperByPrimitive(returnType2);
            if (wrapperByPrimitive != null) {
                returnType2 = wrapperByPrimitive;
            }
            arrayList2.add(returnType2);
        }
        this.erasedParameterTypes = arrayList2;
        List<Method> list4 = this.methods;
        ArrayList arrayList3 = new ArrayList(TweetUtils.collectionSizeOrDefault(list4, 10));
        for (Method defaultValue : list4) {
            arrayList3.add(defaultValue.getDefaultValue());
        }
        this.defaultValues = arrayList3;
        if (this.callMode == CallMode.POSITIONAL_CALL && origin == Origin.JAVA) {
            List<String> list5 = this.parameterNames;
            Intrinsics.checkNotNullParameter(list5, "<this>");
            ArrayList arrayList4 = new ArrayList(TweetUtils.collectionSizeOrDefault(list5, 10));
            Iterator<T> it = list5.iterator();
            boolean z = false;
            while (true) {
                boolean z2 = true;
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                if (!z && Intrinsics.areEqual(next, HSLCriteriaBuilder.VALUE)) {
                    z = true;
                    z2 = false;
                }
                if (z2) {
                    arrayList4.add(next);
                }
            }
            if (!arrayList4.isEmpty()) {
                throw new UnsupportedOperationException("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead.");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008c, code lost:
        if (r7.isInstance(r5) != false) goto L_0x0090;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object call(java.lang.Object[] r14) {
        /*
            r13 = this;
            java.lang.String r0 = "args"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            com.twitter.sdk.android.tweetui.TweetUtils.checkArguments(r13, r14)
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r14.length
            r0.<init>(r1)
            int r1 = r14.length
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x0015:
            if (r3 >= r1) goto L_0x0148
            r5 = r14[r3]
            int r6 = r4 + 1
            if (r5 != 0) goto L_0x002b
            kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller$CallMode r7 = r13.callMode
            kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller$CallMode r8 = kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.CallMode.CALL_BY_NAME
            if (r7 != r8) goto L_0x002b
            java.util.List<java.lang.Object> r5 = r13.defaultValues
            java.lang.Object r5 = r5.get(r4)
            goto L_0x0090
        L_0x002b:
            java.util.List<java.lang.Class<?>> r7 = r13.erasedParameterTypes
            java.lang.Object r7 = r7.get(r4)
            java.lang.Class r7 = (java.lang.Class) r7
            boolean r8 = r5 instanceof java.lang.Class
            r9 = 0
            if (r8 == 0) goto L_0x0039
            goto L_0x008f
        L_0x0039:
            boolean r8 = r5 instanceof kotlin.reflect.KClass
            if (r8 == 0) goto L_0x0044
            kotlin.reflect.KClass r5 = (kotlin.reflect.KClass) r5
            java.lang.Class r5 = com.twitter.sdk.android.tweetui.TweetUtils.getJavaClass(r5)
            goto L_0x0088
        L_0x0044:
            boolean r8 = r5 instanceof java.lang.Object[]
            if (r8 == 0) goto L_0x0088
            r8 = r5
            java.lang.Object[] r8 = (java.lang.Object[]) r8
            boolean r10 = r8 instanceof java.lang.Class[]
            if (r10 == 0) goto L_0x0050
            goto L_0x008f
        L_0x0050:
            boolean r10 = r8 instanceof kotlin.reflect.KClass[]
            if (r10 == 0) goto L_0x0087
            if (r5 == 0) goto L_0x007f
            kotlin.reflect.KClass[] r5 = (kotlin.reflect.KClass[]) r5
            java.util.ArrayList r8 = new java.util.ArrayList
            int r10 = r5.length
            r8.<init>(r10)
            int r10 = r5.length
            r11 = 0
        L_0x0060:
            if (r11 >= r10) goto L_0x006e
            r12 = r5[r11]
            java.lang.Class r12 = com.twitter.sdk.android.tweetui.TweetUtils.getJavaClass(r12)
            r8.add(r12)
            int r11 = r11 + 1
            goto L_0x0060
        L_0x006e:
            java.lang.Class[] r5 = new java.lang.Class[r2]
            java.lang.Object[] r5 = r8.toArray(r5)
            if (r5 == 0) goto L_0x0077
            goto L_0x0088
        L_0x0077:
            java.lang.NullPointerException r14 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Array<T>"
            r14.<init>(r0)
            throw r14
        L_0x007f:
            java.lang.NullPointerException r14 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>"
            r14.<init>(r0)
            throw r14
        L_0x0087:
            r5 = r8
        L_0x0088:
            boolean r7 = r7.isInstance(r5)
            if (r7 == 0) goto L_0x008f
            goto L_0x0090
        L_0x008f:
            r5 = r9
        L_0x0090:
            if (r5 == 0) goto L_0x009a
            r0.add(r5)
            int r3 = r3 + 1
            r4 = r6
            goto L_0x0015
        L_0x009a:
            java.util.List<java.lang.String> r14 = r13.parameterNames
            java.lang.Object r14 = r14.get(r4)
            java.lang.String r14 = (java.lang.String) r14
            java.util.List<java.lang.Class<?>> r0 = r13.erasedParameterTypes
            java.lang.Object r0 = r0.get(r4)
            java.lang.Class r0 = (java.lang.Class) r0
            java.lang.Class<java.lang.Class> r1 = java.lang.Class.class
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r1 == 0) goto L_0x00b9
            java.lang.Class<kotlin.reflect.KClass> r0 = kotlin.reflect.KClass.class
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            goto L_0x00d6
        L_0x00b9:
            boolean r1 = r0.isArray()
            if (r1 == 0) goto L_0x00d2
            java.lang.Class r1 = r0.getComponentType()
            java.lang.Class<java.lang.Class> r2 = java.lang.Class.class
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
            if (r1 == 0) goto L_0x00d2
            java.lang.Class<kotlin.reflect.KClass[]> r0 = kotlin.reflect.KClass[].class
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            goto L_0x00d6
        L_0x00d2:
            kotlin.reflect.KClass r0 = com.twitter.sdk.android.tweetui.TweetUtils.getKotlinClass(r0)
        L_0x00d6:
            java.lang.String r1 = r0.getQualifiedName()
            java.lang.Class<java.lang.Object[]> r2 = java.lang.Object[].class
            kotlin.reflect.KClass r2 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r2)
            java.lang.String r2 = r2.getQualifiedName()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
            if (r1 == 0) goto L_0x011d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r0.getQualifiedName()
            r1.append(r2)
            r2 = 60
            r1.append(r2)
            java.lang.Class r0 = com.twitter.sdk.android.tweetui.TweetUtils.getJavaClass(r0)
            java.lang.Class r0 = r0.getComponentType()
            java.lang.String r2 = "kotlinClass.java.componentType"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            kotlin.reflect.KClass r0 = com.twitter.sdk.android.tweetui.TweetUtils.getKotlinClass(r0)
            java.lang.String r0 = r0.getQualifiedName()
            r1.append(r0)
            r0 = 62
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x0121
        L_0x011d:
            java.lang.String r0 = r0.getQualifiedName()
        L_0x0121:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Argument #"
            r2.append(r3)
            r2.append(r4)
            r3 = 32
            r2.append(r3)
            r2.append(r14)
            java.lang.String r14 = " is not of the required type "
            r2.append(r14)
            r2.append(r0)
            java.lang.String r14 = r2.toString()
            r1.<init>(r14)
            throw r1
        L_0x0148:
            java.lang.Class<?> r14 = r13.jClass
            java.util.List<java.lang.String> r1 = r13.parameterNames
            java.util.List r0 = kotlin.collections.ArraysKt___ArraysJvmKt.zip(r1, r0)
            java.util.Map r0 = kotlin.collections.ArraysKt___ArraysJvmKt.toMap(r0)
            java.util.List<java.lang.reflect.Method> r1 = r13.methods
            java.lang.Object r14 = com.twitter.sdk.android.tweetui.TweetUtils.createAnnotationInstance(r14, r0, r1)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.call(java.lang.Object[]):java.lang.Object");
    }

    public Member getMember() {
        return null;
    }

    public List<Type> getParameterTypes() {
        return this.parameterTypes;
    }

    public Type getReturnType() {
        return this.jClass;
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public /* synthetic */ AnnotationConstructorCaller(Class cls, List<String> list, CallMode callMode2, Origin origin, List list2, int i) {
        ArrayList arrayList;
        // if ((i & 16) != 0) {
            // arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(list, 10));
            for (String declaredMethod : list) {
                // arrayList.add(cls.getDeclaredMethod(declaredMethod, new Class[0]));
            }
        // } else {
            // arrayList = null;
        // }
        this(cls, list, callMode2, origin, arrayList);
    }
}
