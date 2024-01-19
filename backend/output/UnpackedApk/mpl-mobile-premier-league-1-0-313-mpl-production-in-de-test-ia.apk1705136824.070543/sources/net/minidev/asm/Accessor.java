package net.minidev.asm;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Accessor {
    public Field field;
    public String fieldName;
    public Method getter;
    public int index;
    public Method setter;
    public Class<?> type;

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0082, code lost:
        r5 = (char) (r5 - ' ');
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003e, code lost:
        r6 = (char) (r6 - ' ');
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Accessor(java.lang.Class<?> r13, java.lang.reflect.Field r14, net.minidev.asm.FieldFilter r15) {
        /*
            r12 = this;
            r12.<init>()
            java.lang.String r0 = r14.getName()
            r12.fieldName = r0
            int r0 = r14.getModifiers()
            r1 = r0 & 136(0x88, float:1.9E-43)
            if (r1 <= 0) goto L_0x0012
            return
        L_0x0012:
            r1 = 1
            r0 = r0 & r1
            if (r0 <= 0) goto L_0x0018
            r12.field = r14
        L_0x0018:
            java.lang.String r0 = r14.getName()
            int r2 = r0.length()
            int r3 = r2 + 3
            char[] r3 = new char[r3]
            r4 = 0
            r5 = 115(0x73, float:1.61E-43)
            r3[r4] = r5
            r6 = 101(0x65, float:1.42E-43)
            r3[r1] = r6
            r6 = 116(0x74, float:1.63E-43)
            r7 = 2
            r3[r7] = r6
            char r6 = r0.charAt(r4)
            r8 = 122(0x7a, float:1.71E-43)
            r9 = 97
            if (r6 < r9) goto L_0x0041
            if (r6 > r8) goto L_0x0041
            int r6 = r6 + -32
            char r6 = (char) r6
        L_0x0041:
            r10 = 3
            r3[r10] = r6
            r6 = 1
        L_0x0045:
            if (r6 < r2) goto L_0x0101
            java.lang.String r0 = new java.lang.String
            r0.<init>(r3)
            java.lang.Class[] r2 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x005b }
            java.lang.Class r3 = r14.getType()     // Catch:{ Exception -> 0x005b }
            r2[r4] = r3     // Catch:{ Exception -> 0x005b }
            java.lang.reflect.Method r0 = r13.getDeclaredMethod(r0, r2)     // Catch:{ Exception -> 0x005b }
            r12.setter = r0     // Catch:{ Exception -> 0x005b }
            goto L_0x005c
        L_0x005b:
        L_0x005c:
            java.lang.Class r0 = r14.getType()
            java.lang.Class r2 = java.lang.Boolean.TYPE
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x009a
            java.lang.String r2 = r14.getName()
            int r3 = r2.length()
            int r6 = r3 + 2
            char[] r6 = new char[r6]
            r10 = 105(0x69, float:1.47E-43)
            r6[r4] = r10
            r6[r1] = r5
            char r5 = r2.charAt(r4)
            if (r5 < r9) goto L_0x0085
            if (r5 > r8) goto L_0x0085
            int r5 = r5 + -32
            char r5 = (char) r5
        L_0x0085:
            r6[r7] = r5
        L_0x0087:
            if (r1 < r3) goto L_0x008f
            java.lang.String r1 = new java.lang.String
            r1.<init>(r6)
            goto L_0x00a2
        L_0x008f:
            int r5 = r1 + 2
            char r7 = r2.charAt(r1)
            r6[r5] = r7
            int r1 = r1 + 1
            goto L_0x0087
        L_0x009a:
            java.lang.String r1 = r14.getName()
            java.lang.String r1 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.getGetterName(r1)
        L_0x00a2:
            java.lang.Class[] r2 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x00ab }
            java.lang.reflect.Method r1 = r13.getDeclaredMethod(r1, r2)     // Catch:{ Exception -> 0x00ab }
            r12.getter = r1     // Catch:{ Exception -> 0x00ab }
            goto L_0x00ac
        L_0x00ab:
        L_0x00ac:
            java.lang.reflect.Method r1 = r12.getter
            if (r1 != 0) goto L_0x00c4
            if (r0 == 0) goto L_0x00c4
            java.lang.String r0 = r14.getName()     // Catch:{ Exception -> 0x00c3 }
            java.lang.String r0 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.getGetterName(r0)     // Catch:{ Exception -> 0x00c3 }
            java.lang.Class[] r1 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x00c3 }
            java.lang.reflect.Method r13 = r13.getDeclaredMethod(r0, r1)     // Catch:{ Exception -> 0x00c3 }
            r12.getter = r13     // Catch:{ Exception -> 0x00c3 }
            goto L_0x00c4
        L_0x00c3:
        L_0x00c4:
            java.lang.reflect.Field r13 = r12.field
            if (r13 != 0) goto L_0x00d1
            java.lang.reflect.Method r13 = r12.getter
            if (r13 != 0) goto L_0x00d1
            java.lang.reflect.Method r13 = r12.setter
            if (r13 != 0) goto L_0x00d1
            return
        L_0x00d1:
            java.lang.reflect.Method r13 = r12.getter
            r0 = 0
            if (r13 == 0) goto L_0x00de
            boolean r13 = r15.canUse(r14, r13)
            if (r13 != 0) goto L_0x00de
            r12.getter = r0
        L_0x00de:
            java.lang.reflect.Method r13 = r12.setter
            if (r13 == 0) goto L_0x00ea
            boolean r13 = r15.canUse(r14, r13)
            if (r13 != 0) goto L_0x00ea
            r12.setter = r0
        L_0x00ea:
            java.lang.reflect.Method r13 = r12.getter
            if (r13 != 0) goto L_0x00f7
            java.lang.reflect.Method r13 = r12.setter
            if (r13 != 0) goto L_0x00f7
            java.lang.reflect.Field r13 = r12.field
            if (r13 != 0) goto L_0x00f7
            return
        L_0x00f7:
            java.lang.Class r13 = r14.getType()
            r12.type = r13
            r14.getGenericType()
            return
        L_0x0101:
            int r10 = r6 + 3
            char r11 = r0.charAt(r6)
            r3[r10] = r11
            int r6 = r6 + 1
            goto L_0x0045
        */
        throw new UnsupportedOperationException("Method not decompiled: net.minidev.asm.Accessor.<init>(java.lang.Class, java.lang.reflect.Field, net.minidev.asm.FieldFilter):void");
    }

    public boolean isPublic() {
        return this.setter == null;
    }
}
