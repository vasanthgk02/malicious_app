package com.userexperior.a.a.b.a;

import com.userexperior.a.a.a.c;
import com.userexperior.a.a.b.f;
import com.userexperior.a.a.b.g;
import com.userexperior.a.a.c.a;
import com.userexperior.a.a.e;
import com.userexperior.a.a.u;
import com.userexperior.a.a.v;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class k implements v {

    /* renamed from: a  reason: collision with root package name */
    public final f f3595a;

    /* renamed from: b  reason: collision with root package name */
    public final e f3596b;

    /* renamed from: c  reason: collision with root package name */
    public final g f3597c;

    /* renamed from: d  reason: collision with root package name */
    public final e f3598d;

    public k(f fVar, e eVar, g gVar, e eVar2) {
        this.f3595a = fVar;
        this.f3596b = eVar;
        this.f3597c = gVar;
        this.f3598d = eVar2;
    }

    private List<String> a(Field field) {
        c cVar = (c) field.getAnnotation(c.class);
        if (cVar == null) {
            return Collections.singletonList(this.f3596b.translateName(field));
        }
        String a2 = cVar.a();
        String[] b2 = cVar.b();
        if (b2.length == 0) {
            return Collections.singletonList(a2);
        }
        ArrayList arrayList = new ArrayList(b2.length + 1);
        arrayList.add(a2);
        for (String add : b2) {
            arrayList.add(add);
        }
        return arrayList;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Class<?>, code=java.lang.Class, for r34v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Map<java.lang.String, com.userexperior.a.a.b.a.m> a(com.userexperior.a.a.f r32, com.userexperior.a.a.c.a<?> r33, java.lang.Class r34) {
        /*
            r31 = this;
            r11 = r31
            r12 = r32
            java.util.LinkedHashMap r13 = new java.util.LinkedHashMap
            r13.<init>()
            boolean r0 = r34.isInterface()
            if (r0 == 0) goto L_0x0010
            return r13
        L_0x0010:
            r0 = r33
            java.lang.reflect.Type r14 = r0.f3726b
            r10 = r34
            r15 = r0
        L_0x0017:
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            if (r10 == r0) goto L_0x0142
            java.lang.reflect.Field[] r9 = r10.getDeclaredFields()
            int r8 = r9.length
            r7 = 0
            r6 = 0
        L_0x0022:
            if (r6 >= r8) goto L_0x0127
            r5 = r9[r6]
            r4 = 1
            boolean r0 = r11.a(r5, r4)
            boolean r16 = r11.a(r5, r7)
            if (r0 != 0) goto L_0x0042
            if (r16 == 0) goto L_0x0034
            goto L_0x0042
        L_0x0034:
            r28 = r6
            r22 = r8
            r30 = r9
            r33 = r10
            r25 = r15
            r29 = 0
            goto L_0x00fa
        L_0x0042:
            r5.setAccessible(r4)
            java.lang.reflect.Type r1 = r15.f3726b
            java.lang.reflect.Type r2 = r5.getGenericType()
            java.lang.reflect.Type r17 = com.userexperior.a.a.b.b.a(r1, r10, r2)
            java.util.List r3 = r11.a(r5)
            r18 = 0
            r1 = r18
            r2 = 0
        L_0x0058:
            int r4 = r3.size()
            if (r2 >= r4) goto L_0x00eb
            java.lang.Object r4 = r3.get(r2)
            java.lang.String r4 = (java.lang.String) r4
            if (r2 == 0) goto L_0x0069
            r19 = 0
            goto L_0x006b
        L_0x0069:
            r19 = r0
        L_0x006b:
            com.userexperior.a.a.c.a r0 = com.userexperior.a.a.c.a.a(r17)
            java.lang.Class<? super T> r7 = r0.f3725a
            boolean r20 = com.userexperior.a.a.b.p.a(r7)
            java.lang.Class<com.userexperior.a.a.a.b> r7 = com.userexperior.a.a.a.b.class
            java.lang.annotation.Annotation r7 = r5.getAnnotation(r7)
            com.userexperior.a.a.a.b r7 = (com.userexperior.a.a.a.b) r7
            r21 = r1
            if (r7 == 0) goto L_0x0088
            com.userexperior.a.a.b.f r1 = r11.f3595a
            com.userexperior.a.a.u r1 = com.userexperior.a.a.b.a.e.a(r1, r12, r0, r7)
            goto L_0x008a
        L_0x0088:
            r1 = r18
        L_0x008a:
            if (r1 == 0) goto L_0x008e
            r7 = 1
            goto L_0x008f
        L_0x008e:
            r7 = 0
        L_0x008f:
            if (r1 != 0) goto L_0x0095
            com.userexperior.a.a.u r1 = r12.a(r0)
        L_0x0095:
            r22 = r1
            com.userexperior.a.a.b.a.k$1 r1 = new com.userexperior.a.a.b.a.k$1
            r23 = r0
            r0 = r1
            r12 = r1
            r11 = r21
            r1 = r31
            r21 = r2
            r2 = r4
            r24 = r3
            r3 = r19
            r25 = r15
            r26 = 1
            r15 = r4
            r4 = r16
            r27 = r5
            r28 = r6
            r6 = r7
            r29 = 0
            r7 = r22
            r22 = r8
            r8 = r32
            r30 = r9
            r9 = r23
            r33 = r10
            r10 = r20
            r0.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            java.lang.Object r0 = r13.put(r15, r12)
            r1 = r0
            com.userexperior.a.a.b.a.m r1 = (com.userexperior.a.a.b.a.m) r1
            if (r11 != 0) goto L_0x00d1
            goto L_0x00d2
        L_0x00d1:
            r1 = r11
        L_0x00d2:
            int r2 = r21 + 1
            r11 = r31
            r12 = r32
            r10 = r33
            r0 = r19
            r8 = r22
            r3 = r24
            r15 = r25
            r5 = r27
            r6 = r28
            r9 = r30
            r7 = 0
            goto L_0x0058
        L_0x00eb:
            r11 = r1
            r28 = r6
            r22 = r8
            r30 = r9
            r33 = r10
            r25 = r15
            r29 = 0
            if (r11 != 0) goto L_0x010b
        L_0x00fa:
            int r6 = r28 + 1
            r11 = r31
            r12 = r32
            r10 = r33
            r8 = r22
            r15 = r25
            r9 = r30
            r7 = 0
            goto L_0x0022
        L_0x010b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r14)
            java.lang.String r2 = " declares multiple JSON fields named "
            r1.append(r2)
            java.lang.String r2 = r11.h
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0127:
            r33 = r10
            r0 = r15
            java.lang.reflect.Type r0 = r0.f3726b
            java.lang.reflect.Type r1 = r33.getGenericSuperclass()
            r2 = r33
            java.lang.reflect.Type r0 = com.userexperior.a.a.b.b.a(r0, r2, r1)
            com.userexperior.a.a.c.a r15 = com.userexperior.a.a.c.a.a(r0)
            java.lang.Class<? super T> r10 = r15.f3725a
            r11 = r31
            r12 = r32
            goto L_0x0017
        L_0x0142:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.a.a.b.a.k.a(com.userexperior.a.a.f, com.userexperior.a.a.c.a, java.lang.Class):java.util.Map");
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a5 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.lang.reflect.Field r9, boolean r10) {
        /*
            r8 = this;
            com.userexperior.a.a.b.g r0 = r8.f3597c
            java.lang.Class r1 = r9.getType()
            boolean r1 = r0.a(r1, r10)
            r2 = 0
            if (r1 != 0) goto L_0x00a6
            int r1 = r0.f3682c
            int r3 = r9.getModifiers()
            r1 = r1 & r3
            r3 = 1
            if (r1 == 0) goto L_0x001a
        L_0x0017:
            r9 = 1
            goto L_0x00a3
        L_0x001a:
            double r4 = r0.f3681b
            r6 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 == 0) goto L_0x0039
            java.lang.Class<com.userexperior.a.a.a.d> r1 = com.userexperior.a.a.a.d.class
            java.lang.annotation.Annotation r1 = r9.getAnnotation(r1)
            com.userexperior.a.a.a.d r1 = (com.userexperior.a.a.a.d) r1
            java.lang.Class<com.userexperior.a.a.a.e> r4 = com.userexperior.a.a.a.e.class
            java.lang.annotation.Annotation r4 = r9.getAnnotation(r4)
            com.userexperior.a.a.a.e r4 = (com.userexperior.a.a.a.e) r4
            boolean r1 = r0.a(r1, r4)
            if (r1 != 0) goto L_0x0039
            goto L_0x0017
        L_0x0039:
            boolean r1 = r9.isSynthetic()
            if (r1 == 0) goto L_0x0040
            goto L_0x0017
        L_0x0040:
            boolean r1 = r0.f3684e
            if (r1 == 0) goto L_0x005e
            java.lang.Class<com.userexperior.a.a.a.a> r1 = com.userexperior.a.a.a.a.class
            java.lang.annotation.Annotation r1 = r9.getAnnotation(r1)
            com.userexperior.a.a.a.a r1 = (com.userexperior.a.a.a.a) r1
            if (r1 == 0) goto L_0x0017
            if (r10 == 0) goto L_0x0057
            boolean r1 = r1.a()
            if (r1 != 0) goto L_0x005e
            goto L_0x005d
        L_0x0057:
            boolean r1 = r1.b()
            if (r1 != 0) goto L_0x005e
        L_0x005d:
            goto L_0x0017
        L_0x005e:
            boolean r1 = r0.f3683d
            if (r1 != 0) goto L_0x006d
            java.lang.Class r1 = r9.getType()
            boolean r1 = com.userexperior.a.a.b.g.b(r1)
            if (r1 == 0) goto L_0x006d
            goto L_0x0017
        L_0x006d:
            java.lang.Class r1 = r9.getType()
            boolean r1 = com.userexperior.a.a.b.g.a(r1)
            if (r1 == 0) goto L_0x0078
            goto L_0x0017
        L_0x0078:
            if (r10 == 0) goto L_0x007d
            java.util.List<com.userexperior.a.a.b> r10 = r0.f3685f
            goto L_0x007f
        L_0x007d:
            java.util.List<com.userexperior.a.a.b> r10 = r0.g
        L_0x007f:
            boolean r0 = r10.isEmpty()
            if (r0 != 0) goto L_0x00a2
            com.userexperior.a.a.c r0 = new com.userexperior.a.a.c
            r0.<init>(r9)
            java.util.Iterator r9 = r10.iterator()
        L_0x008e:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x00a2
            java.lang.Object r10 = r9.next()
            com.userexperior.a.a.b r10 = (com.userexperior.a.a.b) r10
            boolean r10 = r10.a()
            if (r10 == 0) goto L_0x008e
            goto L_0x0017
        L_0x00a2:
            r9 = 0
        L_0x00a3:
            if (r9 != 0) goto L_0x00a6
            return r3
        L_0x00a6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.a.a.b.a.k.a(java.lang.reflect.Field, boolean):boolean");
    }

    public final <T> u<T> a(com.userexperior.a.a.f fVar, a<T> aVar) {
        Class<? super T> cls = aVar.f3725a;
        if (!Object.class.isAssignableFrom(cls)) {
            return null;
        }
        return new l(this.f3595a.a(aVar), a(fVar, aVar, cls));
    }
}
