package com.userexperior.a.a.b.a;

import com.userexperior.a.a.c.a;
import com.userexperior.a.a.d.c;
import com.userexperior.a.a.f;
import com.userexperior.a.a.u;
import com.userexperior.a.a.v;
import java.io.IOException;
import java.util.ArrayList;

public final class j extends u<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final v f3592a = new v() {
        public final <T> u<T> a(f fVar, a<T> aVar) {
            if (aVar.f3725a == Object.class) {
                return new j(fVar);
            }
            return null;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final f f3593b;

    /* renamed from: com.userexperior.a.a.b.a.j$2  reason: invalid class name */
    public final /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3594a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|7|8|9|11|12|13|14|(3:15|16|18)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0026 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            /*
                com.userexperior.a.a.d.b[] r0 = com.userexperior.a.a.d.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3594a = r0
                com.userexperior.a.a.d.b r1 = com.userexperior.a.a.d.b.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x000f }
                r1 = 0
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = f3594a     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.userexperior.a.a.d.b r1 = com.userexperior.a.a.d.b.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x0016 }
                r1 = 2
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r0 = 5
                int[] r1 = f3594a     // Catch:{ NoSuchFieldError -> 0x001e }
                com.userexperior.a.a.d.b r2 = com.userexperior.a.a.d.b.STRING     // Catch:{ NoSuchFieldError -> 0x001e }
                r2 = 3
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x001e }
            L_0x001e:
                r1 = 6
                int[] r2 = f3594a     // Catch:{ NoSuchFieldError -> 0x0026 }
                com.userexperior.a.a.d.b r3 = com.userexperior.a.a.d.b.NUMBER     // Catch:{ NoSuchFieldError -> 0x0026 }
                r3 = 4
                r2[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0026 }
            L_0x0026:
                int[] r2 = f3594a     // Catch:{ NoSuchFieldError -> 0x002d }
                com.userexperior.a.a.d.b r3 = com.userexperior.a.a.d.b.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x002d }
                r3 = 7
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x002d }
            L_0x002d:
                int[] r0 = f3594a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.userexperior.a.a.d.b r2 = com.userexperior.a.a.d.b.NULL     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 8
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.userexperior.a.a.b.a.j.AnonymousClass2.<clinit>():void");
        }
    }

    public j(f fVar) {
        this.f3593b = fVar;
    }

    public final Object a(com.userexperior.a.a.d.a aVar) throws IOException {
        switch (AnonymousClass2.f3594a[aVar.f().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    arrayList.add(a(aVar));
                }
                aVar.b();
                return arrayList;
            case 2:
                com.userexperior.a.a.b.j jVar = new com.userexperior.a.a.b.j();
                aVar.c();
                while (aVar.e()) {
                    jVar.put(aVar.h(), a(aVar));
                }
                aVar.d();
                return jVar;
            case 3:
                return aVar.i();
            case 4:
                return Double.valueOf(aVar.l());
            case 5:
                return Boolean.valueOf(aVar.j());
            case 6:
                aVar.k();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    public final void a(c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.e();
            return;
        }
        u<?> a2 = this.f3593b.a(obj.getClass());
        if (a2 instanceof j) {
            cVar.c();
            cVar.d();
            return;
        }
        a2.a(cVar, obj);
    }
}
