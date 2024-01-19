package androidx.core.provider;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

public class RequestExecutor$DefaultThreadFactory implements ThreadFactory {
    public int mPriority;
    public String mThreadName;

    public static class ProcessPriorityThread extends Thread {
        public final int mPriority;

        public ProcessPriorityThread(Runnable runnable, String str, int i) {
            super(runnable, str);
            this.mPriority = i;
        }

        public void run() {
            Process.setThreadPriority(this.mPriority);
            super.run();
        }
    }

    public RequestExecutor$DefaultThreadFactory(String str, int i) {
        this.mThreadName = str;
        this.mPriority = i;
    }

    public Thread newThread(Runnable runnable) {
        return new ProcessPriorityThread(runnable, this.mThreadName, this.mPriority);
    }
}
