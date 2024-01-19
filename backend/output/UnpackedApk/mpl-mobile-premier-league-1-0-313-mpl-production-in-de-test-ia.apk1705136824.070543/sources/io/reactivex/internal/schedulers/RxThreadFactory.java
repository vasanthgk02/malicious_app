package io.reactivex.internal.schedulers;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.fontbox.cmap.CMapParser;

public final class RxThreadFactory extends AtomicLong implements ThreadFactory {
    public static final long serialVersionUID = -7789753024099756196L;
    public final boolean nonBlocking;
    public final String prefix;
    public final int priority;

    public static final class RxCustomThread extends Thread {
        public RxCustomThread(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public RxThreadFactory(String str) {
        this.prefix = str;
        this.priority = 5;
        this.nonBlocking = false;
    }

    public Thread newThread(Runnable runnable) {
        String str = this.prefix + '-' + incrementAndGet();
        Thread rxCustomThread = this.nonBlocking ? new RxCustomThread(runnable, str) : new Thread(runnable, str);
        rxCustomThread.setPriority(this.priority);
        rxCustomThread.setDaemon(true);
        return rxCustomThread;
    }

    public String toString() {
        return GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73("RxThreadFactory["), this.prefix, CMapParser.MARK_END_OF_ARRAY);
    }

    public RxThreadFactory(String str, int i) {
        this.prefix = str;
        this.priority = i;
        this.nonBlocking = false;
    }

    public RxThreadFactory(String str, int i, boolean z) {
        this.prefix = str;
        this.priority = i;
        this.nonBlocking = z;
    }
}
