package io.sentry.android.core;

import io.sentry.util.Objects;

public final class ApplicationNotResponding extends RuntimeException {
    public static final long serialVersionUID = 252541144579117016L;
    public final Thread thread;

    public ApplicationNotResponding(String str, Thread thread2) {
        super(str);
        Thread thread3 = (Thread) Objects.requireNonNull(thread2, "Thread must be provided.");
        this.thread = thread3;
        setStackTrace(thread3.getStackTrace());
    }

    public Thread getThread() {
        return this.thread;
    }
}
