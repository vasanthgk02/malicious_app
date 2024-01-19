package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zaac implements OnCompleteListener {
    public final /* synthetic */ TaskCompletionSource zaa;
    public final /* synthetic */ zaad zab;

    public zaac(zaad zaad, TaskCompletionSource taskCompletionSource) {
        this.zab = zaad;
        this.zaa = taskCompletionSource;
    }

    public final void onComplete(Task task) {
        this.zab.zab.remove(this.zaa);
    }
}
