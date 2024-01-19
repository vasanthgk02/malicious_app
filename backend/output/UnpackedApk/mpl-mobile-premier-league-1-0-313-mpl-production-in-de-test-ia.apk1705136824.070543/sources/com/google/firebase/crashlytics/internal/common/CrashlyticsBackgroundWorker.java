package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public class CrashlyticsBackgroundWorker {
    public final Executor executor;
    public final ThreadLocal<Boolean> isExecutorThread = new ThreadLocal<>();
    public Task<Void> tail = Tasks.forResult(null);
    public final Object tailLock = new Object();

    public CrashlyticsBackgroundWorker(Executor executor2) {
        this.executor = executor2;
        executor2.execute(new Runnable() {
            public void run() {
                CrashlyticsBackgroundWorker.this.isExecutorThread.set(Boolean.TRUE);
            }
        });
    }

    private <T> Task<Void> ignoreResult(Task<T> task) {
        return task.continueWith(this.executor, new Continuation<T, Void>() {
            public Void then(Task<T> task) throws Exception {
                return null;
            }
        });
    }

    private boolean isRunningOnThread() {
        return Boolean.TRUE.equals(this.isExecutorThread.get());
    }

    private <T> Continuation<Void, T> newContinuation(final Callable<T> callable) {
        return new Continuation<Void, T>() {
            public T then(Task<Void> task) throws Exception {
                return callable.call();
            }
        };
    }

    public void checkRunningOnThread() {
        if (!isRunningOnThread()) {
            throw new IllegalStateException("Not running on background worker thread as intended.");
        }
    }

    public Executor getExecutor() {
        return this.executor;
    }

    public Task<Void> submit(final Runnable runnable) {
        return submit((Callable<T>) new Callable<Void>() {
            public Void call() throws Exception {
                runnable.run();
                return null;
            }
        });
    }

    public <T> Task<T> submitTask(Callable<Task<T>> callable) {
        Task<T> continueWithTask;
        synchronized (this.tailLock) {
            try {
                continueWithTask = this.tail.continueWithTask(this.executor, newContinuation(callable));
                this.tail = ignoreResult(continueWithTask);
            }
        }
        return continueWithTask;
    }

    public <T> Task<T> submit(Callable<T> callable) {
        Task<T> continueWith;
        synchronized (this.tailLock) {
            try {
                continueWith = this.tail.continueWith(this.executor, newContinuation(callable));
                this.tail = ignoreResult(continueWith);
            }
        }
        return continueWith;
    }
}
