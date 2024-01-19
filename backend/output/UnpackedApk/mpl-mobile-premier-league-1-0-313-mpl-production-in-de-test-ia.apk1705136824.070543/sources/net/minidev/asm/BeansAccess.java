package net.minidev.asm;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BeansAccess<T> {
    public static ConcurrentHashMap<Class<?>, BeansAccess<?>> cache = new ConcurrentHashMap<>();
    public Accessor[] accs;
    public HashMap<String, Accessor> map;

    public static void addAlias(BeansAccess<?> beansAccess, HashMap<String, String> hashMap) {
        if (hashMap != null) {
            HashMap hashMap2 = new HashMap();
            for (Entry next : hashMap.entrySet()) {
                Accessor accessor = beansAccess.map.get(next.getValue());
                if (accessor != null) {
                    hashMap2.put((String) next.getValue(), accessor);
                }
            }
            beansAccess.map.putAll(hashMap2);
        }
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Class<P>, code=java.lang.Class, for r27v0, types: [java.lang.Class, java.lang.Class<P>] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <P> net.minidev.asm.BeansAccess<P> get(java.lang.Class r27, net.minidev.asm.FieldFilter r28) {
        /*
            r0 = r27
            java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
            java.util.concurrent.ConcurrentHashMap<java.lang.Class<?>, net.minidev.asm.BeansAccess<?>> r2 = cache
            java.lang.Object r2 = r2.get(r0)
            net.minidev.asm.BeansAccess r2 = (net.minidev.asm.BeansAccess) r2
            if (r2 == 0) goto L_0x000f
            return r2
        L_0x000f:
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r3 = r0
        L_0x0015:
            r4 = 0
            r5 = 1
            if (r3 != r1) goto L_0x056a
            java.util.Collection r3 = r2.values()
            int r2 = r2.size()
            net.minidev.asm.Accessor[] r2 = new net.minidev.asm.Accessor[r2]
            java.lang.Object[] r2 = r3.toArray(r2)
            net.minidev.asm.Accessor[] r2 = (net.minidev.asm.Accessor[]) r2
            java.lang.String r3 = r27.getName()
            java.lang.String r6 = "java.util."
            boolean r6 = r3.startsWith(r6)
            java.lang.String r7 = "AccAccess"
            if (r6 == 0) goto L_0x003e
            java.lang.String r6 = "net.minidev.asm."
            java.lang.String r3 = com.android.tools.r8.GeneratedOutlineSupport.outline51(r6, r3, r7)
            goto L_0x0042
        L_0x003e:
            java.lang.String r3 = r3.concat(r7)
        L_0x0042:
            net.minidev.asm.DynamicClassLoader r6 = new net.minidev.asm.DynamicClassLoader
            java.lang.ClassLoader r7 = r27.getClassLoader()
            r6.<init>(r7)
            r7 = 0
            java.lang.Class r7 = r6.loadClass(r3)     // Catch:{ ClassNotFoundException -> 0x0050 }
        L_0x0050:
            java.util.LinkedList r8 = new java.util.LinkedList
            r8.<init>()
            r9 = r0
        L_0x0056:
            if (r9 == 0) goto L_0x0077
            boolean r10 = r9.equals(r1)
            if (r10 == 0) goto L_0x005f
            goto L_0x0077
        L_0x005f:
            r8.addLast(r9)
            java.lang.Class[] r10 = r9.getInterfaces()
            int r11 = r10.length
            r12 = 0
        L_0x0068:
            if (r12 < r11) goto L_0x006f
            java.lang.Class r9 = r9.getSuperclass()
            goto L_0x0056
        L_0x006f:
            r13 = r10[r12]
            r8.addLast(r13)
            int r12 = r12 + 1
            goto L_0x0068
        L_0x0077:
            r8.addLast(r1)
            if (r7 != 0) goto L_0x0508
            net.minidev.asm.BeansAccessBuilder r9 = new net.minidev.asm.BeansAccessBuilder
            r9.<init>(r0, r2, r6)
            java.util.Iterator r6 = r8.iterator()
        L_0x0085:
            boolean r7 = r6.hasNext()
            if (r7 != 0) goto L_0x049c
            org.objectweb.asm.ClassWriter r1 = new org.objectweb.asm.ClassWriter
            r1.<init>(r5)
            net.minidev.asm.Accessor[] r6 = r9.accs
            int r6 = r6.length
            r7 = 10
            if (r6 <= r7) goto L_0x0099
            r6 = 1
            goto L_0x009a
        L_0x0099:
            r6 = 0
        L_0x009a:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r10 = "Lnet/minidev/asm/BeansAccess<L"
            r7.<init>(r10)
            java.lang.String r10 = r9.classNameInternal
            java.lang.String r11 = ";>;"
            java.lang.String r14 = com.android.tools.r8.GeneratedOutlineSupport.outline62(r7, r10, r11)
            r11 = 50
            r12 = 33
            java.lang.String r13 = r9.accessClassNameInternal
            java.lang.String r15 = net.minidev.asm.BeansAccessBuilder.METHOD_ACCESS_NAME
            r7 = 0
            r16 = 0
            r10 = r1
            r10.visit(r11, r12, r13, r14, r15, r16)
            r11 = 1
            r14 = 0
            r15 = 0
            java.lang.String r12 = "<init>"
            java.lang.String r13 = "()V"
            org.objectweb.asm.MethodVisitor r10 = r10.visitMethod(r11, r12, r13, r14, r15)
            r11 = 25
            r10.visitVarInsn(r11, r4)
            java.lang.String r11 = net.minidev.asm.BeansAccessBuilder.METHOD_ACCESS_NAME
            java.lang.String r15 = "<init>"
            java.lang.String r14 = "()V"
            r12 = 183(0xb7, float:2.56E-43)
            r10.visitMethodInsn(r12, r11, r15, r14)
            r11 = 177(0xb1, float:2.48E-43)
            r10.visitInsn(r11)
            r10.visitMaxs(r5, r5)
            r11 = 1
            java.lang.String r12 = "set"
            java.lang.String r13 = "(Ljava/lang/Object;ILjava/lang/Object;)V"
            r10 = r1
            r17 = r14
            r14 = r7
            r7 = r15
            r15 = r16
            org.objectweb.asm.MethodVisitor r10 = r10.visitMethod(r11, r12, r13, r14, r15)
            net.minidev.asm.Accessor[] r11 = r9.accs
            int r12 = r11.length
            r13 = 14
            r14 = 21
            r15 = 2
            if (r12 == 0) goto L_0x016f
            int r12 = r11.length
            if (r12 <= r13) goto L_0x013b
            r10.visitVarInsn(r14, r15)
            net.minidev.asm.Accessor[] r11 = r9.accs
            int r11 = r11.length
            org.objectweb.asm.Label[] r12 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.newLabels(r11)
            org.objectweb.asm.Label r13 = new org.objectweb.asm.Label
            r13.<init>()
            int r11 = r12.length
            int r11 = r11 - r5
            r10.visitTableSwitchInsn(r4, r11, r13, r12)
            net.minidev.asm.Accessor[] r4 = r9.accs
            int r5 = r4.length
            r11 = 0
            r14 = 0
        L_0x0111:
            if (r11 < r5) goto L_0x0117
            r10.visitLabel(r13)
            goto L_0x016f
        L_0x0117:
            r15 = r4[r11]
            int r16 = r14 + 1
            r14 = r12[r14]
            r10.visitLabel(r14)
            java.lang.reflect.Field r14 = r15.field
            if (r14 != 0) goto L_0x012a
            java.lang.reflect.Method r14 = r15.getter
            if (r14 != 0) goto L_0x012a
            r14 = 0
            goto L_0x012b
        L_0x012a:
            r14 = 1
        L_0x012b:
            if (r14 != 0) goto L_0x0133
            r14 = 177(0xb1, float:2.48E-43)
            r10.visitInsn(r14)
            goto L_0x0136
        L_0x0133:
            r9.internalSetFiled(r10, r15)
        L_0x0136:
            int r11 = r11 + 1
            r14 = r16
            goto L_0x0111
        L_0x013b:
            int r4 = r11.length
            org.objectweb.asm.Label[] r4 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.newLabels(r4)
            net.minidev.asm.Accessor[] r5 = r9.accs
            int r11 = r5.length
            r12 = 0
            r13 = 0
        L_0x0145:
            if (r12 < r11) goto L_0x0148
            goto L_0x016f
        L_0x0148:
            r14 = r5[r12]
            r16 = r5
            r5 = r4[r13]
            r9.ifNotEqJmp(r10, r15, r13, r5)
            r9.internalSetFiled(r10, r14)
            r5 = r4[r13]
            r10.visitLabel(r5)
            r19 = 3
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r18 = r10
            r18.visitFrame(r19, r20, r21, r22, r23)
            int r13 = r13 + 1
            int r12 = r12 + 1
            r5 = r16
            goto L_0x0145
        L_0x016f:
            java.lang.Class<? extends java.lang.Exception> r4 = r9.exeptionClass
            if (r4 == 0) goto L_0x0177
            r9.throwExIntParam(r10, r4)
            goto L_0x017c
        L_0x0177:
            r4 = 177(0xb1, float:2.48E-43)
            r10.visitInsn(r4)
        L_0x017c:
            r4 = 0
            r10.visitMaxs(r4, r4)
            r11 = 1
            r14 = 0
            r15 = 0
            java.lang.String r12 = "get"
            java.lang.String r13 = "(Ljava/lang/Object;I)Ljava/lang/Object;"
            r5 = 21
            r10 = 14
            r4 = 14
            r10 = r1
            org.objectweb.asm.MethodVisitor r10 = r10.visitMethod(r11, r12, r13, r14, r15)
            net.minidev.asm.Accessor[] r11 = r9.accs
            int r12 = r11.length
            r13 = 176(0xb0, float:2.47E-43)
            if (r12 != 0) goto L_0x01aa
            r19 = 3
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r18 = r10
            r18.visitFrame(r19, r20, r21, r22, r23)
            goto L_0x0276
        L_0x01aa:
            int r12 = r11.length
            if (r12 <= r4) goto L_0x026a
            r4 = 2
            r10.visitVarInsn(r5, r4)
            net.minidev.asm.Accessor[] r4 = r9.accs
            int r4 = r4.length
            org.objectweb.asm.Label[] r4 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.newLabels(r4)
            org.objectweb.asm.Label r5 = new org.objectweb.asm.Label
            r5.<init>()
            int r11 = r4.length
            int r11 = r11 + -1
            r12 = 0
            r10.visitTableSwitchInsn(r12, r11, r5, r4)
            net.minidev.asm.Accessor[] r12 = r9.accs
            int r14 = r12.length
            r11 = 0
            r15 = 0
        L_0x01c9:
            if (r11 < r14) goto L_0x01df
            r10.visitLabel(r5)
            r19 = 3
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r18 = r10
            r18.visitFrame(r19, r20, r21, r22, r23)
            goto L_0x0276
        L_0x01df:
            r28 = r5
            r5 = r12[r11]
            int r16 = r15 + 1
            r15 = r4[r15]
            r10.visitLabel(r15)
            r19 = 3
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r18 = r10
            r18.visitFrame(r19, r20, r21, r22, r23)
            java.lang.reflect.Field r15 = r5.field
            if (r15 != 0) goto L_0x0203
            java.lang.reflect.Method r15 = r5.getter
            if (r15 != 0) goto L_0x0203
            r15 = 0
            goto L_0x0204
        L_0x0203:
            r15 = 1
        L_0x0204:
            if (r15 != 0) goto L_0x0212
            r5 = 1
            r10.visitInsn(r5)
            r10.visitInsn(r13)
            r18 = r4
            r19 = r12
            goto L_0x025c
        L_0x0212:
            r13 = 25
            r15 = 1
            r10.visitVarInsn(r13, r15)
            java.lang.String r13 = r9.classNameInternal
            r15 = 192(0xc0, float:2.69E-43)
            r10.visitTypeInsn(r15, r13)
            java.lang.Class<?> r13 = r5.type
            org.objectweb.asm.Type r13 = org.objectweb.asm.Type.getType(r13)
            boolean r15 = r5.isPublic()
            if (r15 == 0) goto L_0x023d
            java.lang.String r15 = r9.classNameInternal
            java.lang.String r5 = r5.fieldName
            r18 = r4
            java.lang.String r4 = r13.getDescriptor()
            r19 = r12
            r12 = 180(0xb4, float:2.52E-43)
            r10.visitFieldInsn(r12, r15, r5, r4)
            goto L_0x0254
        L_0x023d:
            r18 = r4
            r19 = r12
            java.lang.reflect.Method r4 = r5.getter
            java.lang.String r4 = org.objectweb.asm.Type.getMethodDescriptor(r4)
            java.lang.String r12 = r9.classNameInternal
            java.lang.reflect.Method r5 = r5.getter
            java.lang.String r5 = r5.getName()
            r15 = 182(0xb6, float:2.55E-43)
            r10.visitMethodInsn(r15, r12, r5, r4)
        L_0x0254:
            kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.autoBoxing(r10, r13)
            r4 = 176(0xb0, float:2.47E-43)
            r10.visitInsn(r4)
        L_0x025c:
            int r11 = r11 + 1
            r13 = 176(0xb0, float:2.47E-43)
            r5 = r28
            r15 = r16
            r4 = r18
            r12 = r19
            goto L_0x01c9
        L_0x026a:
            int r4 = r11.length
            org.objectweb.asm.Label[] r4 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.newLabels(r4)
            net.minidev.asm.Accessor[] r5 = r9.accs
            int r11 = r5.length
            r12 = 0
            r13 = 0
        L_0x0274:
            if (r12 < r11) goto L_0x03fe
        L_0x0276:
            java.lang.Class<? extends java.lang.Exception> r4 = r9.exeptionClass
            if (r4 == 0) goto L_0x027e
            r9.throwExIntParam(r10, r4)
            goto L_0x0287
        L_0x027e:
            r4 = 1
            r10.visitInsn(r4)
            r4 = 176(0xb0, float:2.47E-43)
            r10.visitInsn(r4)
        L_0x0287:
            r4 = 0
            r10.visitMaxs(r4, r4)
            java.lang.String r4 = "(Ljava/lang/Object;)Z"
            java.lang.String r5 = "equals"
            java.lang.String r15 = "java/lang/String"
            if (r6 != 0) goto L_0x0308
            r11 = 1
            r14 = 0
            r16 = 0
            java.lang.String r12 = "set"
            java.lang.String r13 = "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)V"
            r10 = r1
            r28 = r3
            r3 = r15
            r15 = r16
            org.objectweb.asm.MethodVisitor r10 = r10.visitMethod(r11, r12, r13, r14, r15)
            net.minidev.asm.Accessor[] r11 = r9.accs
            int r11 = r11.length
            org.objectweb.asm.Label[] r11 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.newLabels(r11)
            net.minidev.asm.Accessor[] r12 = r9.accs
            int r13 = r12.length
            r14 = 0
            r15 = 0
        L_0x02b1:
            if (r14 < r13) goto L_0x02c7
            java.lang.Class<? extends java.lang.Exception> r11 = r9.exeptionClass
            if (r11 == 0) goto L_0x02bb
            r9.throwExStrParam(r10, r11)
            goto L_0x02c0
        L_0x02bb:
            r11 = 177(0xb1, float:2.48E-43)
            r10.visitInsn(r11)
        L_0x02c0:
            r11 = 0
            r10.visitMaxs(r11, r11)
            r25 = r8
            goto L_0x030d
        L_0x02c7:
            r16 = r13
            r13 = r12[r14]
            r24 = r12
            r12 = 25
            r25 = r8
            r8 = 2
            r10.visitVarInsn(r12, r8)
            java.lang.String r8 = r13.fieldName
            r10.visitLdcInsn(r8)
            r8 = 182(0xb6, float:2.55E-43)
            r10.visitMethodInsn(r8, r3, r5, r4)
            r8 = r11[r15]
            r12 = 153(0x99, float:2.14E-43)
            r10.visitJumpInsn(r12, r8)
            r9.internalSetFiled(r10, r13)
            r8 = r11[r15]
            r10.visitLabel(r8)
            r19 = 3
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r18 = r10
            r18.visitFrame(r19, r20, r21, r22, r23)
            int r15 = r15 + 1
            int r14 = r14 + 1
            r13 = r16
            r12 = r24
            r8 = r25
            goto L_0x02b1
        L_0x0308:
            r28 = r3
            r25 = r8
            r3 = r15
        L_0x030d:
            if (r6 != 0) goto L_0x03c5
            r11 = 1
            r14 = 0
            r15 = 0
            java.lang.String r12 = "get"
            java.lang.String r13 = "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;"
            r10 = r1
            org.objectweb.asm.MethodVisitor r6 = r10.visitMethod(r11, r12, r13, r14, r15)
            net.minidev.asm.Accessor[] r8 = r9.accs
            int r8 = r8.length
            org.objectweb.asm.Label[] r8 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.newLabels(r8)
            net.minidev.asm.Accessor[] r10 = r9.accs
            int r11 = r10.length
            r12 = 0
            r13 = 0
        L_0x0327:
            if (r12 < r11) goto L_0x0340
            java.lang.Class<? extends java.lang.Exception> r3 = r9.exeptionClass
            if (r3 == 0) goto L_0x0331
            r9.throwExStrParam(r6, r3)
            goto L_0x033a
        L_0x0331:
            r3 = 1
            r6.visitInsn(r3)
            r3 = 176(0xb0, float:2.47E-43)
            r6.visitInsn(r3)
        L_0x033a:
            r3 = 0
            r6.visitMaxs(r3, r3)
            goto L_0x03c5
        L_0x0340:
            r14 = r10[r12]
            r15 = 2
            r16 = r10
            r10 = 25
            r6.visitVarInsn(r10, r15)
            java.lang.String r15 = r14.fieldName
            r6.visitLdcInsn(r15)
            r15 = 182(0xb6, float:2.55E-43)
            r6.visitMethodInsn(r15, r3, r5, r4)
            r15 = r8[r13]
            r10 = 153(0x99, float:2.14E-43)
            r6.visitJumpInsn(r10, r15)
            r10 = 1
            r15 = 25
            r6.visitVarInsn(r15, r10)
            java.lang.String r10 = r9.classNameInternal
            r15 = 192(0xc0, float:2.69E-43)
            r6.visitTypeInsn(r15, r10)
            java.lang.Class<?> r10 = r14.type
            org.objectweb.asm.Type r10 = org.objectweb.asm.Type.getType(r10)
            boolean r15 = r14.isPublic()
            if (r15 == 0) goto L_0x0386
            java.lang.String r15 = r9.classNameInternal
            java.lang.String r14 = r14.fieldName
            r24 = r3
            java.lang.String r3 = r10.getDescriptor()
            r26 = r4
            r4 = 180(0xb4, float:2.52E-43)
            r6.visitFieldInsn(r4, r15, r14, r3)
            goto L_0x039d
        L_0x0386:
            r24 = r3
            r26 = r4
            java.lang.reflect.Method r3 = r14.getter
            java.lang.String r3 = org.objectweb.asm.Type.getMethodDescriptor(r3)
            java.lang.String r4 = r9.classNameInternal
            java.lang.reflect.Method r14 = r14.getter
            java.lang.String r14 = r14.getName()
            r15 = 182(0xb6, float:2.55E-43)
            r6.visitMethodInsn(r15, r4, r14, r3)
        L_0x039d:
            kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.autoBoxing(r6, r10)
            r3 = 176(0xb0, float:2.47E-43)
            r6.visitInsn(r3)
            r3 = r8[r13]
            r6.visitLabel(r3)
            r19 = 3
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r18 = r6
            r18.visitFrame(r19, r20, r21, r22, r23)
            int r13 = r13 + 1
            int r12 = r12 + 1
            r10 = r16
            r3 = r24
            r4 = r26
            goto L_0x0327
        L_0x03c5:
            r11 = 1
            r14 = 0
            r15 = 0
            java.lang.String r12 = "newInstance"
            java.lang.String r13 = "()Ljava/lang/Object;"
            r3 = 176(0xb0, float:2.47E-43)
            r10 = r1
            org.objectweb.asm.MethodVisitor r4 = r10.visitMethod(r11, r12, r13, r14, r15)
            r5 = 187(0xbb, float:2.62E-43)
            java.lang.String r6 = r9.classNameInternal
            r4.visitTypeInsn(r5, r6)
            r5 = 89
            r4.visitInsn(r5)
            java.lang.String r5 = r9.classNameInternal
            r6 = 183(0xb7, float:2.56E-43)
            r8 = r17
            r4.visitMethodInsn(r6, r5, r7, r8)
            r4.visitInsn(r3)
            r3 = 2
            r5 = 1
            r4.visitMaxs(r3, r5)
            byte[] r1 = r1.toByteArray()
            net.minidev.asm.DynamicClassLoader r3 = r9.loader
            java.lang.String r4 = r9.accessClassName
            java.lang.Class r7 = r3.defineClass(r4, r1)
            goto L_0x050c
        L_0x03fe:
            r28 = r3
            r25 = r8
            r8 = r17
            r3 = 2
            r14 = r5[r12]
            r15 = r4[r13]
            r9.ifNotEqJmp(r10, r3, r13, r15)
            r3 = 25
            r15 = 1
            r10.visitVarInsn(r3, r15)
            java.lang.String r3 = r9.classNameInternal
            r15 = 192(0xc0, float:2.69E-43)
            r10.visitTypeInsn(r15, r3)
            java.lang.Class<?> r3 = r14.type
            org.objectweb.asm.Type r3 = org.objectweb.asm.Type.getType(r3)
            boolean r15 = r14.isPublic()
            if (r15 == 0) goto L_0x0437
            java.lang.String r15 = r9.classNameInternal
            java.lang.String r14 = r14.fieldName
            r16 = r1
            java.lang.String r1 = r3.getDescriptor()
            r17 = r5
            r5 = 180(0xb4, float:2.52E-43)
            r10.visitFieldInsn(r5, r15, r14, r1)
            goto L_0x0450
        L_0x0437:
            r16 = r1
            r17 = r5
            java.lang.reflect.Method r1 = r14.getter
            if (r1 == 0) goto L_0x047c
            java.lang.String r1 = org.objectweb.asm.Type.getMethodDescriptor(r1)
            java.lang.String r5 = r9.classNameInternal
            java.lang.reflect.Method r14 = r14.getter
            java.lang.String r14 = r14.getName()
            r15 = 182(0xb6, float:2.55E-43)
            r10.visitMethodInsn(r15, r5, r14, r1)
        L_0x0450:
            kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.autoBoxing(r10, r3)
            r1 = 176(0xb0, float:2.47E-43)
            r10.visitInsn(r1)
            r1 = r4[r13]
            r10.visitLabel(r1)
            r19 = 3
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r18 = r10
            r18.visitFrame(r19, r20, r21, r22, r23)
            int r13 = r13 + 1
            int r12 = r12 + 1
            r3 = r28
            r1 = r16
            r5 = r17
            r17 = r8
            r8 = r25
            goto L_0x0274
        L_0x047c:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "no Getter for field "
            r1.<init>(r2)
            java.lang.String r2 = r14.fieldName
            r1.append(r2)
            java.lang.String r2 = " in class "
            r1.append(r2)
            java.lang.String r2 = r9.className
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x049c:
            r28 = r3
            r25 = r8
            java.lang.Object r3 = r6.next()
            java.lang.Class r3 = (java.lang.Class) r3
            java.util.HashMap<java.lang.Class<?>, java.util.LinkedHashSet<java.lang.Class<?>>> r4 = net.minidev.asm.BeansAccessConfig.classMapper
            java.lang.Object r3 = r4.get(r3)
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            if (r3 != 0) goto L_0x04b1
            goto L_0x04bb
        L_0x04b1:
            java.util.Iterator r3 = r3.iterator()
        L_0x04b5:
            boolean r4 = r3.hasNext()
            if (r4 != 0) goto L_0x04c3
        L_0x04bb:
            r4 = 0
            r5 = 1
            r3 = r28
            r8 = r25
            goto L_0x0085
        L_0x04c3:
            java.lang.Object r4 = r3.next()
            java.lang.Class r4 = (java.lang.Class) r4
            if (r4 != 0) goto L_0x04cc
            goto L_0x04b5
        L_0x04cc:
            java.lang.reflect.Method[] r4 = r4.getMethods()
            int r5 = r4.length
            r7 = 0
        L_0x04d2:
            if (r7 < r5) goto L_0x04d5
            goto L_0x04b5
        L_0x04d5:
            r8 = r4[r7]
            int r10 = r8.getModifiers()
            r10 = r10 & 8
            if (r10 != 0) goto L_0x04e0
            goto L_0x0505
        L_0x04e0:
            java.lang.Class[] r10 = r8.getParameterTypes()
            int r11 = r10.length
            r12 = 1
            if (r11 == r12) goto L_0x04e9
            goto L_0x0505
        L_0x04e9:
            r11 = 0
            r10 = r10[r11]
            boolean r10 = r10.equals(r1)
            if (r10 != 0) goto L_0x04f3
            goto L_0x0505
        L_0x04f3:
            java.lang.Class r10 = r8.getReturnType()
            java.lang.Class r11 = java.lang.Void.TYPE
            boolean r11 = r10.equals(r11)
            if (r11 == 0) goto L_0x0500
            goto L_0x0505
        L_0x0500:
            java.util.HashMap<java.lang.Class<?>, java.lang.reflect.Method> r11 = r9.convMtds
            r11.put(r10, r8)
        L_0x0505:
            int r7 = r7 + 1
            goto L_0x04d2
        L_0x0508:
            r28 = r3
            r25 = r8
        L_0x050c:
            r1 = 0
            java.lang.Object r3 = r7.newInstance()     // Catch:{ Exception -> 0x0553 }
            net.minidev.asm.BeansAccess r3 = (net.minidev.asm.BeansAccess) r3     // Catch:{ Exception -> 0x0553 }
            r3.accs = r2     // Catch:{ Exception -> 0x0553 }
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ Exception -> 0x0553 }
            r4.<init>()     // Catch:{ Exception -> 0x0553 }
            r3.map = r4     // Catch:{ Exception -> 0x0553 }
            int r4 = r2.length     // Catch:{ Exception -> 0x0553 }
            r5 = 0
        L_0x051e:
            if (r5 < r4) goto L_0x0542
            java.util.concurrent.ConcurrentHashMap<java.lang.Class<?>, net.minidev.asm.BeansAccess<?>> r1 = cache     // Catch:{ Exception -> 0x0553 }
            r1.putIfAbsent(r0, r3)     // Catch:{ Exception -> 0x0553 }
            java.util.Iterator r0 = r25.iterator()     // Catch:{ Exception -> 0x0553 }
        L_0x0529:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x0553 }
            if (r1 != 0) goto L_0x0530
            return r3
        L_0x0530:
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x0553 }
            java.lang.Class r1 = (java.lang.Class) r1     // Catch:{ Exception -> 0x0553 }
            java.util.HashMap<java.lang.Class<?>, java.util.HashMap<java.lang.String, java.lang.String>> r2 = net.minidev.asm.BeansAccessConfig.classFiledNameMapper     // Catch:{ Exception -> 0x0553 }
            java.lang.Object r1 = r2.get(r1)     // Catch:{ Exception -> 0x0553 }
            java.util.HashMap r1 = (java.util.HashMap) r1     // Catch:{ Exception -> 0x0553 }
            addAlias(r3, r1)     // Catch:{ Exception -> 0x0553 }
            goto L_0x0529
        L_0x0542:
            r6 = r2[r5]     // Catch:{ Exception -> 0x0553 }
            int r7 = r1 + 1
            r6.index = r1     // Catch:{ Exception -> 0x0553 }
            java.util.HashMap<java.lang.String, net.minidev.asm.Accessor> r1 = r3.map     // Catch:{ Exception -> 0x0553 }
            java.lang.String r8 = r6.fieldName     // Catch:{ Exception -> 0x0553 }
            r1.put(r8, r6)     // Catch:{ Exception -> 0x0553 }
            int r5 = r5 + 1
            r1 = r7
            goto L_0x051e
        L_0x0553:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Error constructing accessor class: "
            r2.<init>(r3)
            r3 = r28
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2, r0)
            throw r1
        L_0x056a:
            java.lang.reflect.Field[] r4 = r3.getDeclaredFields()
            int r5 = r4.length
            r6 = 0
        L_0x0570:
            if (r6 < r5) goto L_0x0578
            java.lang.Class r3 = r3.getSuperclass()
            goto L_0x0015
        L_0x0578:
            r7 = r4[r6]
            java.lang.String r8 = r7.getName()
            boolean r9 = r2.containsKey(r8)
            if (r9 == 0) goto L_0x0587
            r10 = r28
            goto L_0x05a3
        L_0x0587:
            net.minidev.asm.Accessor r9 = new net.minidev.asm.Accessor
            r10 = r28
            r9.<init>(r3, r7, r10)
            java.lang.reflect.Field r7 = r9.field
            if (r7 != 0) goto L_0x059c
            java.lang.reflect.Method r7 = r9.getter
            if (r7 != 0) goto L_0x059c
            java.lang.reflect.Method r7 = r9.setter
            if (r7 != 0) goto L_0x059c
            r7 = 0
            goto L_0x059d
        L_0x059c:
            r7 = 1
        L_0x059d:
            if (r7 != 0) goto L_0x05a0
            goto L_0x05a3
        L_0x05a0:
            r2.put(r8, r9)
        L_0x05a3:
            int r6 = r6 + 1
            goto L_0x0570
        */
        throw new UnsupportedOperationException("Method not decompiled: net.minidev.asm.BeansAccess.get(java.lang.Class, net.minidev.asm.FieldFilter):net.minidev.asm.BeansAccess");
    }

    public abstract Object get(T t, int i);
}
