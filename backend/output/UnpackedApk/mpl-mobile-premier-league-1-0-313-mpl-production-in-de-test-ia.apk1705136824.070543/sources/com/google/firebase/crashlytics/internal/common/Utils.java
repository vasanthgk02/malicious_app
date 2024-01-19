package com.google.firebase.crashlytics.internal.common;

import android.os.Looper;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.zzw;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Utils {
    public static final ExecutorService TASK_CONTINUATION_EXECUTOR_SERVICE = ExecutorUtils.buildSingleThreadExecutorService("awaitEvenIfOnMainThread task continuation executor");

    public static <T> T awaitEvenIfOnMainThread(Task<T> task) throws InterruptedException, TimeoutException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        task.continueWith(TASK_CONTINUATION_EXECUTOR_SERVICE, new Continuation(countDownLatch) {
            public final /* synthetic */ CountDownLatch f$0;

            {
                this.f$0 = r1;
            }

            public final Object then(Task task) {
                this.f$0.countDown();
                return null;
            }
        });
        if (Looper.getMainLooper() == Looper.myLooper()) {
            countDownLatch.await(4, TimeUnit.SECONDS);
        } else {
            countDownLatch.await();
        }
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (((zzw) task).zzd) {
            throw new CancellationException("Task is already canceled");
        } else if (task.isComplete()) {
            throw new IllegalStateException(task.getException());
        } else {
            throw new TimeoutException();
        }
    }

    public static <T> Task<T> callTask(Executor executor, final Callable<Task<T>> callable) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        executor.execute(new Runnable() {
            public void run() {
                try {
                    ((Task) callable.call()).continueWith(new Continuation<T, Void>() {
                        public Void then(Task<T> task) throws Exception {
                            if (task.isSuccessful()) {
                                TaskCompletionSource taskCompletionSource = taskCompletionSource;
                                taskCompletionSource.zza.zzb(task.getResult());
                            } else {
                                TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                                taskCompletionSource2.zza.zza(task.getException());
                            }
                            return null;
                        }
                    });
                } catch (Exception e2) {
                    taskCompletionSource.zza.zza(e2);
                }
            }
        });
        return taskCompletionSource.zza;
    }

    public static /* synthetic */ Void lambda$race$0(TaskCompletionSource taskCompletionSource, Task task) throws Exception {
        if (task.isSuccessful()) {
            taskCompletionSource.trySetResult(task.getResult());
        } else {
            taskCompletionSource.trySetException((Exception) Objects.requireNonNull(task.getException()));
        }
        return null;
    }

    public static /* synthetic */ Void lambda$race$1(TaskCompletionSource taskCompletionSource, Task task) throws Exception {
        if (task.isSuccessful()) {
            taskCompletionSource.trySetResult(task.getResult());
        } else {
            taskCompletionSource.trySetException((Exception) Objects.requireNonNull(task.getException()));
        }
        return null;
    }

    public static <T> Task<T> race(Task<T> task, Task<T> task2) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        $$Lambda$Utils$4xT4_yNKSLeD8y85S9WWXJK69Lo r1 = new Continuation() {
            public final Object then(Task task) {
                Utils.lambda$race$0(TaskCompletionSource.this, task);
                return null;
            }
        };
        task.continueWith(r1);
        task2.continueWith(r1);
        return taskCompletionSource.zza;
    }

    public static <T> Task<T> race(Executor executor, Task<T> task, Task<T> task2) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        $$Lambda$Utils$AnyPx5Rg9Ilz7CXOvaDoqLySow r1 = new Continuation() {
            public final Object then(Task task) {
                return Utils.lambda$race$1(TaskCompletionSource.this, task);
            }
        };
        task.continueWith(executor, r1);
        task2.continueWith(executor, r1);
        return taskCompletionSource.zza;
    }
}
