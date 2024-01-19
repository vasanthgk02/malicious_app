package okhttp3.internal.concurrent;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.logging.Level;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"okhttp3/internal/concurrent/TaskRunner$runnable$1", "Ljava/lang/Runnable;", "run", "", "okhttp"}, k = 1, mv = {1, 4, 0})
/* compiled from: TaskRunner.kt */
public final class TaskRunner$runnable$1 implements Runnable {
    public final /* synthetic */ TaskRunner this$0;

    public TaskRunner$runnable$1(TaskRunner taskRunner) {
        this.this$0 = taskRunner;
    }

    public void run() {
        Task awaitTaskToRun;
        while (true) {
            synchronized (this.this$0) {
                awaitTaskToRun = this.this$0.awaitTaskToRun();
            }
            if (awaitTaskToRun != null) {
                TaskQueue queue$okhttp = awaitTaskToRun.getQueue$okhttp();
                Intrinsics.checkNotNull(queue$okhttp);
                long j = -1;
                boolean isLoggable = TaskRunner.Companion.getLogger().isLoggable(Level.FINE);
                if (isLoggable) {
                    j = queue$okhttp.getTaskRunner$okhttp().getBackend().nanoTime();
                    TaskLoggerKt.log(awaitTaskToRun, queue$okhttp, "starting");
                }
                try {
                    this.this$0.runTask(awaitTaskToRun);
                    if (isLoggable) {
                        long nanoTime = queue$okhttp.getTaskRunner$okhttp().getBackend().nanoTime() - j;
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("finished run in ");
                        outline73.append(TaskLoggerKt.formatDuration(nanoTime));
                        TaskLoggerKt.log(awaitTaskToRun, queue$okhttp, outline73.toString());
                    }
                } catch (Throwable th) {
                    if (isLoggable) {
                        long nanoTime2 = queue$okhttp.getTaskRunner$okhttp().getBackend().nanoTime() - j;
                        StringBuilder outline732 = GeneratedOutlineSupport.outline73("failed a run in ");
                        outline732.append(TaskLoggerKt.formatDuration(nanoTime2));
                        TaskLoggerKt.log(awaitTaskToRun, queue$okhttp, outline732.toString());
                    }
                    throw th;
                }
            } else {
                return;
            }
        }
    }
}
