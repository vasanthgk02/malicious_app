package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ConfigCacheClient {
    public static final Executor DIRECT_EXECUTOR = $$Lambda$_14QHG018Z6p13d3hzJuGTWnNeo.INSTANCE;
    public static final Map<String, ConfigCacheClient> clientInstances = new HashMap();
    public Task<ConfigContainer> cachedContainerTask = null;
    public final ExecutorService executorService;
    public final ConfigStorageClient storageClient;

    public static class AwaitListener<TResult> implements OnSuccessListener<TResult>, OnFailureListener, OnCanceledListener {
        public final CountDownLatch latch = new CountDownLatch(1);

        public AwaitListener(AnonymousClass1 r2) {
        }

        public void onCanceled() {
            this.latch.countDown();
        }

        public void onFailure(Exception exc) {
            this.latch.countDown();
        }

        public void onSuccess(TResult tresult) {
            this.latch.countDown();
        }
    }

    public ConfigCacheClient(ExecutorService executorService2, ConfigStorageClient configStorageClient) {
        this.executorService = executorService2;
        this.storageClient = configStorageClient;
    }

    public static <TResult> TResult await(Task<TResult> task, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        AwaitListener awaitListener = new AwaitListener(null);
        task.addOnSuccessListener(DIRECT_EXECUTOR, (OnSuccessListener<? super TResult>) awaitListener);
        task.addOnFailureListener(DIRECT_EXECUTOR, awaitListener);
        task.addOnCanceledListener(DIRECT_EXECUTOR, awaitListener);
        if (!awaitListener.latch.await(j, timeUnit)) {
            throw new TimeoutException("Task await timed out.");
        } else if (task.isSuccessful()) {
            return task.getResult();
        } else {
            throw new ExecutionException(task.getException());
        }
    }

    public static synchronized ConfigCacheClient getInstance(ExecutorService executorService2, ConfigStorageClient configStorageClient) {
        ConfigCacheClient configCacheClient;
        synchronized (ConfigCacheClient.class) {
            try {
                String str = configStorageClient.fileName;
                if (!clientInstances.containsKey(str)) {
                    clientInstances.put(str, new ConfigCacheClient(executorService2, configStorageClient));
                }
                configCacheClient = clientInstances.get(str);
            }
        }
        return configCacheClient;
    }

    public synchronized Task<ConfigContainer> get() {
        try {
            if (this.cachedContainerTask == null || (this.cachedContainerTask.isComplete() && !this.cachedContainerTask.isSuccessful())) {
                ExecutorService executorService2 = this.executorService;
                ConfigStorageClient configStorageClient = this.storageClient;
                Objects.requireNonNull(configStorageClient);
                this.cachedContainerTask = Tasks.call(executorService2, new Callable() {
                    public final Object call() {
                        return ConfigStorageClient.this.read();
                    }
                });
            }
        }
        return this.cachedContainerTask;
    }

    public Void lambda$put$0$ConfigCacheClient(ConfigContainer configContainer) throws Exception {
        ConfigStorageClient configStorageClient = this.storageClient;
        synchronized (configStorageClient) {
            FileOutputStream openFileOutput = configStorageClient.context.openFileOutput(configStorageClient.fileName, 0);
            try {
                openFileOutput.write(configContainer.toString().getBytes("UTF-8"));
            } finally {
                openFileOutput.close();
            }
        }
        return null;
    }

    public /* synthetic */ Task lambda$put$1$ConfigCacheClient(boolean z, ConfigContainer configContainer, Void voidR) throws Exception {
        if (z) {
            updateInMemoryConfigContainer(configContainer);
        }
        return Tasks.forResult(configContainer);
    }

    public Task<ConfigContainer> put(ConfigContainer configContainer) {
        return Tasks.call(this.executorService, new Callable(configContainer) {
            public final /* synthetic */ ConfigContainer f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return ConfigCacheClient.this.lambda$put$0$ConfigCacheClient(this.f$1);
            }
        }).onSuccessTask(this.executorService, new SuccessContinuation(true, configContainer) {
            public final /* synthetic */ boolean f$1;
            public final /* synthetic */ ConfigContainer f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Task then(Object obj) {
                return ConfigCacheClient.this.lambda$put$1$ConfigCacheClient(this.f$1, this.f$2, (Void) obj);
            }
        });
    }

    public final synchronized void updateInMemoryConfigContainer(ConfigContainer configContainer) {
        this.cachedContainerTask = Tasks.forResult(configContainer);
    }
}
