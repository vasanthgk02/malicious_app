package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.tasks.zzj;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.messaging.WithinAppServiceBinder.IntentHandler;
import com.google.firebase.messaging.threads.ThreadPriority;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SuppressLint({"UnwrappedWakefulBroadcastReceiver"})
public abstract class EnhancedIntentService extends Service {
    public static final String TAG = "EnhancedIntentService";
    public Binder binder;
    public final ExecutorService executor;
    public int lastStartId;
    public final Object lock = new Object();
    public int runningTasks = 0;

    public EnhancedIntentService() {
        NamedThreadFactory namedThreadFactory = new NamedThreadFactory("Firebase-Messaging-Intent-Handle");
        ThreadPriority threadPriority = ThreadPriority.HIGH_SPEED;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), namedThreadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.executor = Executors.unconfigurableExecutorService(threadPoolExecutor);
    }

    private void finishTask(Intent intent) {
        if (intent != null) {
            synchronized (WakeLockHolder.syncObject) {
                if (WakeLockHolder.wakeLock != null && intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false)) {
                    intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
                    WakeLockHolder.wakeLock.release();
                }
            }
        }
        synchronized (this.lock) {
            int i = this.runningTasks - 1;
            this.runningTasks = i;
            if (i == 0) {
                stopSelfResultHook(this.lastStartId);
            }
        }
    }

    /* access modifiers changed from: private */
    public Task<Void> processIntent(Intent intent) {
        if (handleIntentOnMainThread(intent)) {
            return Tasks.forResult(null);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.executor.execute(new Runnable(intent, taskCompletionSource) {
            public final /* synthetic */ Intent f$1;
            public final /* synthetic */ TaskCompletionSource f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                EnhancedIntentService.this.lambda$processIntent$0$EnhancedIntentService(this.f$1, this.f$2);
            }
        });
        return taskCompletionSource.zza;
    }

    public Intent getStartCommandIntent(Intent intent) {
        return intent;
    }

    public abstract void handleIntent(Intent intent);

    public boolean handleIntentOnMainThread(Intent intent) {
        return false;
    }

    public /* synthetic */ void lambda$onStartCommand$1$EnhancedIntentService(Intent intent, Task task) {
        finishTask(intent);
    }

    public void lambda$processIntent$0$EnhancedIntentService(Intent intent, TaskCompletionSource taskCompletionSource) {
        try {
            handleIntent(intent);
        } finally {
            taskCompletionSource.zza.zzb(null);
        }
    }

    public final synchronized IBinder onBind(Intent intent) {
        boolean isLoggable = Log.isLoggable(TAG, 3);
        if (this.binder == null) {
            this.binder = new WithinAppServiceBinder(new IntentHandler() {
            });
        }
        return this.binder;
    }

    public void onDestroy() {
        this.executor.shutdown();
        super.onDestroy();
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this.lock) {
            this.lastStartId = i2;
            this.runningTasks++;
        }
        Intent startCommandIntent = getStartCommandIntent(intent);
        if (startCommandIntent == null) {
            finishTask(intent);
            return 2;
        }
        Task<Void> processIntent = processIntent(startCommandIntent);
        if (processIntent.isComplete()) {
            finishTask(intent);
            return 2;
        }
        zzw zzw = (zzw) processIntent;
        zzw.zzb.zza(new zzj($$Lambda$_14QHG018Z6p13d3hzJuGTWnNeo.INSTANCE, new OnCompleteListener(intent) {
            public final /* synthetic */ Intent f$1;

            {
                this.f$1 = r2;
            }

            public final void onComplete(Task task) {
                EnhancedIntentService.this.lambda$onStartCommand$1$EnhancedIntentService(this.f$1, task);
            }
        }));
        zzw.zzi();
        return 3;
    }

    public boolean stopSelfResultHook(int i) {
        return stopSelfResult(i);
    }
}
