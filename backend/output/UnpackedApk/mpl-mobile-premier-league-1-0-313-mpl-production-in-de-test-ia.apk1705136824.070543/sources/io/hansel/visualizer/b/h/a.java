package io.hansel.visualizer.b.h;

import android.os.Handler;
import android.os.Looper;
import io.hansel.visualizer.b.f;
import io.hansel.visualizer.b.g;

public final class a {

    /* renamed from: io.hansel.visualizer.b.h.a$a  reason: collision with other inner class name */
    public class C0087a extends c<V> {

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f5762d;

        public C0087a(f fVar) {
            this.f5762d = fVar;
        }

        public V b() {
            return this.f5762d.call();
        }
    }

    public class b extends c<Void> {

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Runnable f5763d;

        public b(Runnable runnable) {
            this.f5763d = runnable;
        }

        /* renamed from: c */
        public Void b() {
            this.f5763d.run();
            return null;
        }
    }

    public static abstract class c<V> implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public boolean f5764a;

        /* renamed from: b  reason: collision with root package name */
        public V f5765b;

        /* renamed from: c  reason: collision with root package name */
        public Exception f5766c;

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:1:0x0001 */
        /* JADX WARNING: Removed duplicated region for block: B:1:0x0001 A[LOOP:0: B:1:0x0001->B:12:0x0001, LOOP_START, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void a() {
            /*
                r1 = this;
                monitor-enter(r1)
            L_0x0001:
                boolean r0 = r1.f5764a     // Catch:{ all -> 0x000b }
                if (r0 != 0) goto L_0x0009
                r1.wait()     // Catch:{ InterruptedException -> 0x0001 }
                goto L_0x0001
            L_0x0009:
                monitor-exit(r1)     // Catch:{ all -> 0x000b }
                return
            L_0x000b:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x000b }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.hansel.visualizer.b.h.a.c.a():void");
        }

        public V a(Handler handler) {
            if (handler.post(this)) {
                a();
                if (this.f5766c == null) {
                    return this.f5765b;
                }
                throw new RuntimeException(this.f5766c);
            }
            throw new RuntimeException("Handler.post() returned false");
        }

        public abstract V b();

        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r3 = this;
                r0 = 0
                r1 = 1
                java.lang.Object r2 = r3.b()     // Catch:{ Exception -> 0x0017 }
                r3.f5765b = r2     // Catch:{ Exception -> 0x0017 }
                r3.f5766c = r0     // Catch:{ Exception -> 0x0017 }
                monitor-enter(r3)
                r3.f5764a = r1     // Catch:{ all -> 0x0012 }
                r3.notifyAll()     // Catch:{ all -> 0x0012 }
                monitor-exit(r3)     // Catch:{ all -> 0x0012 }
                goto L_0x0023
            L_0x0012:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0012 }
                throw r0
            L_0x0015:
                r0 = move-exception
                goto L_0x0027
            L_0x0017:
                r2 = move-exception
                r3.f5765b = r0     // Catch:{ all -> 0x0015 }
                r3.f5766c = r2     // Catch:{ all -> 0x0015 }
                monitor-enter(r3)
                r3.f5764a = r1     // Catch:{ all -> 0x0024 }
                r3.notifyAll()     // Catch:{ all -> 0x0024 }
                monitor-exit(r3)     // Catch:{ all -> 0x0024 }
            L_0x0023:
                return
            L_0x0024:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0024 }
                throw r0
            L_0x0027:
                monitor-enter(r3)
                r3.f5764a = r1     // Catch:{ all -> 0x002f }
                r3.notifyAll()     // Catch:{ all -> 0x002f }
                monitor-exit(r3)     // Catch:{ all -> 0x002f }
                throw r0
            L_0x002f:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002f }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.hansel.visualizer.b.h.a.c.run():void");
        }
    }

    public static <V> V a(Handler handler, f<V> fVar) {
        if (!a(handler)) {
            return new C0087a(fVar).a(handler);
        }
        try {
            return fVar.call();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void a(Handler handler, Runnable runnable) {
        if (a(handler)) {
            try {
                runnable.run();
            } catch (RuntimeException e2) {
                throw new RuntimeException(e2);
            }
        } else {
            new b(runnable).a(handler);
        }
    }

    public static boolean a(Handler handler) {
        return Looper.myLooper() == handler.getLooper();
    }

    public static void b(Handler handler) {
        g.b(a(handler));
    }
}
