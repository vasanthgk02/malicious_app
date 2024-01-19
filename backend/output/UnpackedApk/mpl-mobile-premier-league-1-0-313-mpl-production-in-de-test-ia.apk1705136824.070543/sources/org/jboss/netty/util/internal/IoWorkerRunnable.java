package org.jboss.netty.util.internal;

public class IoWorkerRunnable implements Runnable {
    public static final ThreadLocal<Boolean> IN_IO_THREAD = new ThreadLocalBoolean();
    public final Runnable runnable;

    public IoWorkerRunnable(Runnable runnable2) {
        if (runnable2 != null) {
            this.runnable = runnable2;
            return;
        }
        throw new NullPointerException("runnable");
    }

    public void run() {
        IN_IO_THREAD.set(Boolean.TRUE);
        try {
            this.runnable.run();
        } finally {
            IN_IO_THREAD.remove();
        }
    }
}
