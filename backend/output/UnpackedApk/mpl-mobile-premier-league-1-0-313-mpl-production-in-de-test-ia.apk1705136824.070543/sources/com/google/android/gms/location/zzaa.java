package com.google.android.gms.location;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final /* synthetic */ class zzaa implements Continuation {
    public final TaskCompletionSource zza;

    public zzaa(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final Object then(Task task) {
        TaskCompletionSource taskCompletionSource = this.zza;
        if (!task.isSuccessful()) {
            if (task.getException() != null) {
                Exception exception = task.getException();
                if (exception != null) {
                    taskCompletionSource.zza.zza(exception);
                }
            } else {
                taskCompletionSource.trySetResult(null);
            }
        }
        return taskCompletionSource.zza;
    }
}
