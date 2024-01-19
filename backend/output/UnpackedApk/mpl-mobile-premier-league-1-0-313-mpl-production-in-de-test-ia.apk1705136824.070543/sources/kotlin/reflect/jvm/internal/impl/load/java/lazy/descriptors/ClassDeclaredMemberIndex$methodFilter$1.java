package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;

/* compiled from: DeclaredMemberIndex.kt */
public final class ClassDeclaredMemberIndex$methodFilter$1 extends Lambda implements Function1<JavaMethod, Boolean> {
    public final /* synthetic */ ClassDeclaredMemberIndex this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ClassDeclaredMemberIndex$methodFilter$1(ClassDeclaredMemberIndex classDeclaredMemberIndex) {
        // this.this$0 = classDeclaredMemberIndex;
        super(1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004a, code lost:
        if (r0.equals("hashCode") == false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0098, code lost:
        if (r0.equals("toString") == false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009c, code lost:
        r6 = r6.getValueParameters().isEmpty();
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ab  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke(java.lang.Object r6) {
        /*
            r5 = this;
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod r6 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod) r6
            java.lang.String r0 = "m"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.ClassDeclaredMemberIndex r0 = r5.this$0
            kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember, java.lang.Boolean> r0 = r0.memberFilter
            java.lang.Object r0 = r0.invoke(r6)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x00ac
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r0 = r6.getContainingClass()
            boolean r0 = r0.isInterface()
            if (r0 == 0) goto L_0x00a8
            kotlin.reflect.jvm.internal.impl.name.Name r0 = r6.getName()
            java.lang.String r0 = r0.asString()
            int r3 = r0.hashCode()
            r4 = -1776922004(0xffffffff9616526c, float:-1.2142911E-25)
            if (r3 == r4) goto L_0x0091
            r4 = -1295482945(0xffffffffb2c87fbf, float:-2.3341157E-8)
            if (r3 == r4) goto L_0x004d
            r4 = 147696667(0x8cdac1b, float:1.23784505E-33)
            if (r3 == r4) goto L_0x0044
            goto L_0x009a
        L_0x0044:
            java.lang.String r3 = "hashCode"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x009c
            goto L_0x009a
        L_0x004d:
            java.lang.String r3 = "equals"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0056
            goto L_0x009a
        L_0x0056:
            java.util.List r6 = r6.getValueParameters()
            java.lang.Object r6 = kotlin.collections.ArraysKt___ArraysJvmKt.singleOrNull(r6)
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter r6 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter) r6
            r0 = 0
            if (r6 != 0) goto L_0x0065
            r6 = r0
            goto L_0x0069
        L_0x0065:
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType r6 = r6.getType()
        L_0x0069:
            boolean r3 = r6 instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
            if (r3 == 0) goto L_0x0070
            r0 = r6
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType r0 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType) r0
        L_0x0070:
            if (r0 != 0) goto L_0x0073
            goto L_0x009a
        L_0x0073:
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier r6 = r0.getClassifier()
            boolean r0 = r6 instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
            if (r0 == 0) goto L_0x009a
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r6 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass) r6
            kotlin.reflect.jvm.internal.impl.name.FqName r6 = r6.getFqName()
            if (r6 == 0) goto L_0x009a
            java.lang.String r6 = r6.asString()
            java.lang.String r0 = "java.lang.Object"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r0)
            if (r6 == 0) goto L_0x009a
            r6 = 1
            goto L_0x00a4
        L_0x0091:
            java.lang.String r3 = "toString"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x009c
        L_0x009a:
            r6 = 0
            goto L_0x00a4
        L_0x009c:
            java.util.List r6 = r6.getValueParameters()
            boolean r6 = r6.isEmpty()
        L_0x00a4:
            if (r6 == 0) goto L_0x00a8
            r6 = 1
            goto L_0x00a9
        L_0x00a8:
            r6 = 0
        L_0x00a9:
            if (r6 != 0) goto L_0x00ac
            r1 = 1
        L_0x00ac:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.ClassDeclaredMemberIndex$methodFilter$1.invoke(java.lang.Object):java.lang.Object");
    }
}
