package io.reactivex.internal.functions;

public final class Functions {
    public static final Runnable EMPTY_RUNNABLE = new EmptyRunnable();

    public static final class EmptyRunnable implements Runnable {
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }
}
