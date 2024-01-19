package co.hyperverge.hypersnapsdk.c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: FaceCoordinateObjsManager */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static List<a> f3097a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public static int f3098b = 5;

    /* compiled from: FaceCoordinateObjsManager */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public List<Float> f3099a;

        /* renamed from: b  reason: collision with root package name */
        public long f3100b;

        /* renamed from: c  reason: collision with root package name */
        public long f3101c;

        public a(long j) {
            this.f3100b = j;
        }

        public boolean g() {
            return this.f3101c + 1500 < System.currentTimeMillis() || this.f3100b + 1700 < System.currentTimeMillis();
        }
    }

    public static synchronized void a(a aVar) {
        synchronized (e.class) {
            Iterator<a> it = f3097a.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next.g()) {
                    it.remove();
                } else if (next.f3100b > aVar.f3100b) {
                    break;
                } else {
                    i++;
                }
            }
            f3097a.add(i, aVar);
            if (f3097a.size() > f3098b) {
                f3097a.remove(0);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        if (r3 == false) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized co.hyperverge.hypersnapsdk.c.e.a a() {
        /*
            java.lang.Class<co.hyperverge.hypersnapsdk.c.e> r0 = co.hyperverge.hypersnapsdk.c.e.class
            monitor-enter(r0)
            java.util.List<co.hyperverge.hypersnapsdk.c.e$a> r1 = f3097a     // Catch:{ all -> 0x0025 }
            int r1 = r1.size()     // Catch:{ all -> 0x0025 }
            r2 = 0
            if (r1 != 0) goto L_0x000e
            monitor-exit(r0)
            return r2
        L_0x000e:
            java.util.List<co.hyperverge.hypersnapsdk.c.e$a> r1 = f3097a     // Catch:{ all -> 0x0025 }
            int r3 = r1.size()     // Catch:{ all -> 0x0025 }
            int r3 = r3 + -1
            java.lang.Object r1 = r1.get(r3)     // Catch:{ all -> 0x0025 }
            co.hyperverge.hypersnapsdk.c.e$a r1 = (co.hyperverge.hypersnapsdk.c.e.a) r1     // Catch:{ all -> 0x0025 }
            boolean r3 = r1.g()     // Catch:{ all -> 0x0025 }
            monitor-exit(r0)
            if (r3 == 0) goto L_0x0024
            return r2
        L_0x0024:
            return r1
        L_0x0025:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hypersnapsdk.c.e.a():co.hyperverge.hypersnapsdk.c.e$a");
    }
}
