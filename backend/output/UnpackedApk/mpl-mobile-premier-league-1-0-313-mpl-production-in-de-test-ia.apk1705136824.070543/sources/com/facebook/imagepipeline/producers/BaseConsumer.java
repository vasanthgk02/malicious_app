package com.facebook.imagepipeline.producers;

import com.facebook.common.logging.FLog;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;

public abstract class BaseConsumer<T> implements Consumer<T> {
    public boolean mIsFinished = false;

    public static boolean isLast(int i) {
        return (i & 1) == 1;
    }

    public static boolean isNotLast(int i) {
        return !isLast(i);
    }

    public static int simpleStatusForIsLast(boolean z) {
        return z ? 1 : 0;
    }

    public static boolean statusHasAnyFlag(int i, int i2) {
        return (i & i2) != 0;
    }

    public static boolean statusHasFlag(int i, int i2) {
        return (i & i2) == i2;
    }

    public static int turnOffStatusFlag(int i, int i2) {
        return i & (~i2);
    }

    public static int turnOnStatusFlag(int i, int i2) {
        return i | i2;
    }

    public synchronized void onCancellation() {
        if (!this.mIsFinished) {
            this.mIsFinished = true;
            try {
                onCancellationImpl();
            } catch (Exception e2) {
                onUnhandledException(e2);
            }
        } else {
            return;
        }
        return;
    }

    public abstract void onCancellationImpl();

    public synchronized void onFailure(Throwable th) {
        if (!this.mIsFinished) {
            this.mIsFinished = true;
            try {
                onFailureImpl(th);
            } catch (Exception e2) {
                onUnhandledException(e2);
            }
        } else {
            return;
        }
        return;
    }

    public abstract void onFailureImpl(Throwable th);

    public synchronized void onNewResult(T t, int i) {
        if (!this.mIsFinished) {
            this.mIsFinished = isLast(i);
            try {
                onNewResultImpl(t, i);
            } catch (Exception e2) {
                onUnhandledException(e2);
            }
        } else {
            return;
        }
        return;
    }

    public abstract void onNewResultImpl(T t, int i);

    public synchronized void onProgressUpdate(float f2) {
        if (!this.mIsFinished) {
            try {
                onProgressUpdateImpl(f2);
            } catch (Exception e2) {
                onUnhandledException(e2);
            }
        } else {
            return;
        }
    }

    public void onProgressUpdateImpl(float f2) {
    }

    public void onUnhandledException(Exception exc) {
        Class<?> cls = getClass();
        if (((FLogDefaultLoggingDelegate) FLog.sHandler).isLoggable(6)) {
            ((FLogDefaultLoggingDelegate) FLog.sHandler).println(6, cls.getSimpleName(), "unhandled exception", exc);
        }
    }
}
