package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Method;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: ReflectJavaClass.kt */
public final class ReflectJavaClass$methods$1 extends Lambda implements Function1<Method, Boolean> {
    public final /* synthetic */ ReflectJavaClass this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ReflectJavaClass$methods$1(ReflectJavaClass reflectJavaClass) {
        // this.this$0 = reflectJavaClass;
        super(1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0050, code lost:
        if (r5 == false) goto L_0x0057;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.reflect.Method r5 = (java.lang.reflect.Method) r5
            boolean r0 = r5.isSynthetic()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x000b
            goto L_0x0053
        L_0x000b:
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass r0 = r4.this$0
            boolean r0 = r0.isEnum()
            if (r0 == 0) goto L_0x0057
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass r0 = r4.this$0
            java.lang.String r3 = "method"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r3)
            if (r0 == 0) goto L_0x0055
            java.lang.String r0 = r5.getName()
            java.lang.String r3 = "values"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x0037
            java.lang.Class[] r5 = r5.getParameterTypes()
            java.lang.String r0 = "method.parameterTypes"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            int r5 = r5.length
            if (r5 != 0) goto L_0x004f
            r5 = 1
            goto L_0x0050
        L_0x0037:
            java.lang.String r3 = "valueOf"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r0 == 0) goto L_0x004f
            java.lang.Class[] r5 = r5.getParameterTypes()
            java.lang.Class[] r0 = new java.lang.Class[r1]
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r0[r2] = r3
            boolean r5 = java.util.Arrays.equals(r5, r0)
            goto L_0x0050
        L_0x004f:
            r5 = 0
        L_0x0050:
            if (r5 != 0) goto L_0x0053
            goto L_0x0057
        L_0x0053:
            r1 = 0
            goto L_0x0057
        L_0x0055:
            r5 = 0
            throw r5
        L_0x0057:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass$methods$1.invoke(java.lang.Object):java.lang.Object");
    }
}
