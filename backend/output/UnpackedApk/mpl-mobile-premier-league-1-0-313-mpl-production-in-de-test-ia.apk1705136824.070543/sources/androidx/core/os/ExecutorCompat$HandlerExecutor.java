package androidx.core.os;

import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public class ExecutorCompat$HandlerExecutor implements Executor {
    public final Handler mHandler;

    public ExecutorCompat$HandlerExecutor(Handler handler) {
        if (handler != null) {
            this.mHandler = handler;
            return;
        }
        throw null;
    }

    public void execute(Runnable runnable) {
        Handler handler = this.mHandler;
        if (runnable == null) {
            throw null;
        } else if (!handler.post(runnable)) {
            throw new RejectedExecutionException(this.mHandler + " is shutting down");
        }
    }
}
