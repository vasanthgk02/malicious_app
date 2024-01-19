package com.google.android.datatransport.runtime;

import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import java.util.concurrent.Executor;

public class SafeLoggingExecutor implements Executor {
    public final Executor delegate;

    public static class SafeLoggingRunnable implements Runnable {
        public final Runnable delegate;

        public SafeLoggingRunnable(Runnable runnable) {
            this.delegate = runnable;
        }

        public void run() {
            try {
                this.delegate.run();
            } catch (Exception unused) {
                ImageOriginUtils.getTag("Executor");
            }
        }
    }

    public SafeLoggingExecutor(Executor executor) {
        this.delegate = executor;
    }

    public void execute(Runnable runnable) {
        this.delegate.execute(new SafeLoggingRunnable(runnable));
    }
}
