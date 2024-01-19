package com.google.firebase.messaging;

import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;

public class RequestDeduplicator {
    public final Executor executor;
    public final Map<String, Task<String>> getTokenRequests = new ArrayMap();

    public RequestDeduplicator(Executor executor2) {
        this.executor = executor2;
    }

    public /* synthetic */ Task lambda$getOrStartGetTokenRequest$0$RequestDeduplicator(String str, Task task) throws Exception {
        synchronized (this) {
            try {
                this.getTokenRequests.remove(str);
            }
        }
        return task;
    }
}
