package a.a.a.a.a;

import com.mpl.MLog;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class g implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicInteger f2404a = new AtomicInteger(0);

    /* renamed from: b  reason: collision with root package name */
    public final String f2405b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f2406c;

    public g(String str, boolean z) {
        this.f2405b = str;
        this.f2406c = z;
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName(this.f2405b + "_" + this.f2404a.incrementAndGet());
        thread.setDaemon(this.f2406c);
        MLog.d("NetworkLib: PriorityThreadFactory", thread);
        return thread;
    }
}
