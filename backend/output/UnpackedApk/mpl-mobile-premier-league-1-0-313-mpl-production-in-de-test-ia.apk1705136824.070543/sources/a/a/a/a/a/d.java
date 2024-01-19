package a.a.a.a.a;

import a.a.a.a.d.a;
import com.mpl.MLog;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;

public final class d extends ThreadPoolExecutor {

    /* renamed from: a  reason: collision with root package name */
    public static final RejectedExecutionHandler f2394a = new c();

    /* renamed from: b  reason: collision with root package name */
    public static ThreadPoolExecutor f2395b;

    public d() {
        super(2, Integer.MAX_VALUE, 60, a.f2410a, new SynchronousQueue(true), new g("MPL_LOW", false), f2394a);
        MLog.d("NetworkLib: LowPriorityThreadExecutor", "LowPriorityThreadExecutor() called");
    }
}
