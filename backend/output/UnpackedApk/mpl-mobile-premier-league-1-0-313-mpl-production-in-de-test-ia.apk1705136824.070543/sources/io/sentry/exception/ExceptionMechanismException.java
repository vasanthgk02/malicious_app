package io.sentry.exception;

import io.sentry.protocol.Mechanism;
import io.sentry.util.Objects;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class ExceptionMechanismException extends RuntimeException {
    public static final long serialVersionUID = 142345454265713915L;
    public final Mechanism exceptionMechanism;
    public final boolean snapshot;
    public final Thread thread;
    public final Throwable throwable;

    public ExceptionMechanismException(Mechanism mechanism, Throwable th, Thread thread2, boolean z) {
        this.exceptionMechanism = (Mechanism) Objects.requireNonNull(mechanism, "Mechanism is required.");
        this.throwable = (Throwable) Objects.requireNonNull(th, "Throwable is required.");
        this.thread = (Thread) Objects.requireNonNull(thread2, "Thread is required.");
        this.snapshot = z;
    }

    public Mechanism getExceptionMechanism() {
        return this.exceptionMechanism;
    }

    public Thread getThread() {
        return this.thread;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public boolean isSnapshot() {
        return this.snapshot;
    }

    public ExceptionMechanismException(Mechanism mechanism, Throwable th, Thread thread2) {
        this(mechanism, th, thread2, false);
    }
}
