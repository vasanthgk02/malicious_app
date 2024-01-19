package io.sentry;

import io.sentry.exception.ExceptionMechanismException;
import io.sentry.protocol.Mechanism;
import io.sentry.protocol.SentryException;
import io.sentry.protocol.SentryStackFrame;
import io.sentry.protocol.SentryStackTrace;
import io.sentry.util.Objects;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;

public final class SentryExceptionFactory {
    public final SentryStackTraceFactory sentryStackTraceFactory;

    public SentryExceptionFactory(SentryStackTraceFactory sentryStackTraceFactory2) {
        this.sentryStackTraceFactory = (SentryStackTraceFactory) Objects.requireNonNull(sentryStackTraceFactory2, "The SentryStackTraceFactory is required.");
    }

    private SentryException getSentryException(Throwable th, Mechanism mechanism, Thread thread, boolean z) {
        Package packageR = th.getClass().getPackage();
        String name = th.getClass().getName();
        SentryException sentryException = new SentryException();
        String message = th.getMessage();
        if (packageR != null) {
            name = name.replace(packageR.getName() + ".", "");
        }
        String name2 = packageR != null ? packageR.getName() : null;
        List<SentryStackFrame> stackFrames = this.sentryStackTraceFactory.getStackFrames(th.getStackTrace());
        if (stackFrames != null && !stackFrames.isEmpty()) {
            SentryStackTrace sentryStackTrace = new SentryStackTrace(stackFrames);
            if (z) {
                sentryStackTrace.setSnapshot(Boolean.TRUE);
            }
            sentryException.setStacktrace(sentryStackTrace);
        }
        if (thread != null) {
            sentryException.setThreadId(Long.valueOf(thread.getId()));
        }
        sentryException.setType(name);
        sentryException.setMechanism(mechanism);
        sentryException.setModule(name2);
        sentryException.setValue(message);
        return sentryException;
    }

    public Deque<SentryException> extractExceptionQueue(Throwable th) {
        Thread thread;
        boolean z;
        Mechanism mechanism;
        ArrayDeque arrayDeque = new ArrayDeque();
        HashSet hashSet = new HashSet();
        while (th != null && hashSet.add(th)) {
            if (th instanceof ExceptionMechanismException) {
                ExceptionMechanismException exceptionMechanismException = (ExceptionMechanismException) th;
                mechanism = exceptionMechanismException.getExceptionMechanism();
                Throwable throwable = exceptionMechanismException.getThrowable();
                thread = exceptionMechanismException.getThread();
                Throwable th2 = throwable;
                z = exceptionMechanismException.isSnapshot();
                th = th2;
            } else {
                thread = Thread.currentThread();
                mechanism = null;
                z = false;
            }
            arrayDeque.addFirst(getSentryException(th, mechanism, thread, z));
            th = th.getCause();
        }
        return arrayDeque;
    }

    public List<SentryException> getSentryExceptions(Throwable th) {
        return getSentryExceptions(extractExceptionQueue(th));
    }

    private List<SentryException> getSentryExceptions(Deque<SentryException> deque) {
        return new ArrayList(deque);
    }
}
