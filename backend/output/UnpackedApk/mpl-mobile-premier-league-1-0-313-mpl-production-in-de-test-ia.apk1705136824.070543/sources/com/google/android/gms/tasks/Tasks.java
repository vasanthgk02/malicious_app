package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
public final class Tasks {
    public static <TResult> TResult await(Task<TResult> task) throws ExecutionException, InterruptedException {
        Preconditions.checkNotMainThread("Must not be called on the main application thread");
        Preconditions.checkNotNull(task, "Task must not be null");
        if (task.isComplete()) {
            return zza(task);
        }
        zzad zzad = new zzad(null);
        zzb(task, zzad);
        zzad.zza.await();
        return zza(task);
    }

    @Deprecated
    public static <TResult> Task<TResult> call(Executor executor, Callable<TResult> callable) {
        Preconditions.checkNotNull(executor, "Executor must not be null");
        Preconditions.checkNotNull(callable, "Callback must not be null");
        zzw zzw = new zzw();
        executor.execute(new zzz(zzw, callable));
        return zzw;
    }

    public static <TResult> Task<TResult> forException(Exception exc) {
        zzw zzw = new zzw();
        zzw.zza(exc);
        return zzw;
    }

    public static <TResult> Task<TResult> forResult(TResult tresult) {
        zzw zzw = new zzw();
        zzw.zzb(tresult);
        return zzw;
    }

    public static Task<Void> whenAll(Collection<? extends Task<?>> collection) {
        if (collection == null || collection.isEmpty()) {
            return forResult(null);
        }
        for (Task task : collection) {
            if (task == null) {
                throw new NullPointerException("null tasks are not accepted");
            }
        }
        zzw zzw = new zzw();
        zzaf zzaf = new zzaf(collection.size(), zzw);
        for (Task zzb : collection) {
            zzb(zzb, zzaf);
        }
        return zzw;
    }

    public static Task<List<Task<?>>> whenAllComplete(Task<?>... taskArr) {
        Task<List<Task<?>>> task;
        if (taskArr.length == 0) {
            return forResult(Collections.emptyList());
        }
        List asList = Arrays.asList(taskArr);
        if (asList == null || asList.isEmpty()) {
            task = forResult(Collections.emptyList());
        } else {
            task = whenAll(asList).continueWithTask(TaskExecutors.MAIN_THREAD, new zzab(asList));
        }
        return task;
    }

    public static Object zza(Task task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (((zzw) task).zzd) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(task.getException());
    }

    public static void zzb(Task task, zzae zzae) {
        task.addOnSuccessListener(TaskExecutors.zza, (OnSuccessListener<? super TResult>) zzae);
        task.addOnFailureListener(TaskExecutors.zza, zzae);
        task.addOnCanceledListener(TaskExecutors.zza, zzae);
    }

    public static <TResult> TResult await(Task<TResult> task, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        Preconditions.checkNotMainThread("Must not be called on the main application thread");
        Preconditions.checkNotNull(task, "Task must not be null");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        if (task.isComplete()) {
            return zza(task);
        }
        zzad zzad = new zzad(null);
        zzb(task, zzad);
        if (zzad.zza.await(j, timeUnit)) {
            return zza(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }
}
