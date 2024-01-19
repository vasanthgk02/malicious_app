package a.a.a.a.a;

import com.mpl.MLog;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.fontbox.cmap.CMapParser;

public final class a implements RejectedExecutionHandler {
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        MLog.d("NetworkLib: HighPriorityThreadExecutor", "rejectedExecution() called with: r = [" + runnable + "], executor = [" + threadPoolExecutor + CMapParser.MARK_END_OF_ARRAY);
    }
}
