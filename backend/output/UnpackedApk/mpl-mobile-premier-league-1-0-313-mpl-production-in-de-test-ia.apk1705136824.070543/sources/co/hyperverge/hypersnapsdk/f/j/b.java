package co.hyperverge.hypersnapsdk.f.j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ThreadExecutor */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeUnit f3186a = TimeUnit.SECONDS;

    /* renamed from: b  reason: collision with root package name */
    public static final BlockingQueue<Runnable> f3187b = new LinkedBlockingQueue();

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f3188c;

    /* renamed from: d  reason: collision with root package name */
    public ThreadPoolExecutor f3189d;

    public b() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 120, f3186a, f3187b);
        this.f3189d = threadPoolExecutor;
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            try {
                if (f3188c == null) {
                    f3188c = new b();
                }
                bVar = f3188c;
            }
        }
        return bVar;
    }
}
