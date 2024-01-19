package a.a.a.a.a;

import a.a.a.a.d.a;
import com.mpl.MLog;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;

public final class b extends ThreadPoolExecutor {

    /* renamed from: a  reason: collision with root package name */
    public static final RejectedExecutionHandler f2392a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static b f2393b;

    public b() {
        super(2, Integer.MAX_VALUE, 60, a.f2410a, new SynchronousQueue(), new g("MPL_HIGH", false), f2392a);
        MLog.d("NetworkLib: HighPriorityThreadExecutor", "HighPriorityThreadExecutor() called");
    }
}
