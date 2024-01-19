package androidx.work.impl;

import android.content.Context;
import android.os.PowerManager.WakeLock;
import androidx.core.content.ContextCompat;
import androidx.work.Configuration;
import androidx.work.ForegroundInfo;
import androidx.work.ListenableWorker;
import androidx.work.ListenableWorker.Result;
import androidx.work.Logger;
import androidx.work.WorkerParameters.RuntimeExtras;
import androidx.work.impl.WorkerWrapper.Builder;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class Processor implements ExecutionListener, ForegroundProcessor {
    public static final String TAG = Logger.tagWithPrefix("Processor");
    public Context mAppContext;
    public Set<String> mCancelledIds;
    public Configuration mConfiguration;
    public Map<String, WorkerWrapper> mEnqueuedWorkMap = new HashMap();
    public WakeLock mForegroundLock;
    public Map<String, WorkerWrapper> mForegroundWorkMap = new HashMap();
    public final Object mLock;
    public final List<ExecutionListener> mOuterListeners;
    public List<Scheduler> mSchedulers;
    public WorkDatabase mWorkDatabase;
    public TaskExecutor mWorkTaskExecutor;

    public static class FutureListener implements Runnable {
        public ExecutionListener mExecutionListener;
        public ListenableFuture<Boolean> mFuture;
        public String mWorkSpecId;

        public FutureListener(ExecutionListener executionListener, String str, ListenableFuture<Boolean> listenableFuture) {
            this.mExecutionListener = executionListener;
            this.mWorkSpecId = str;
            this.mFuture = listenableFuture;
        }

        public void run() {
            boolean z;
            try {
                z = ((Boolean) this.mFuture.get()).booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                z = true;
            }
            this.mExecutionListener.onExecuted(this.mWorkSpecId, z);
        }
    }

    public Processor(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, List<Scheduler> list) {
        this.mAppContext = context;
        this.mConfiguration = configuration;
        this.mWorkTaskExecutor = taskExecutor;
        this.mWorkDatabase = workDatabase;
        this.mSchedulers = list;
        this.mCancelledIds = new HashSet();
        this.mOuterListeners = new ArrayList();
        this.mForegroundLock = null;
        this.mLock = new Object();
    }

    public static boolean interrupt(String str, WorkerWrapper workerWrapper) {
        boolean z;
        if (workerWrapper != null) {
            workerWrapper.mInterrupted = true;
            workerWrapper.tryCheckForInterruptionAndResolve();
            ListenableFuture<Result> listenableFuture = workerWrapper.mInnerFuture;
            if (listenableFuture != null) {
                z = listenableFuture.isDone();
                workerWrapper.mInnerFuture.cancel(true);
            } else {
                z = false;
            }
            ListenableWorker listenableWorker = workerWrapper.mWorker;
            if (listenableWorker == null || z) {
                Logger.get().debug(WorkerWrapper.TAG, String.format("WorkSpec %s is already done. Not interrupting.", new Object[]{workerWrapper.mWorkSpec}), new Throwable[0]);
            } else {
                listenableWorker.stop();
            }
            Logger.get().debug(TAG, String.format("WorkerWrapper interrupted for %s", new Object[]{str}), new Throwable[0]);
            return true;
        }
        Logger.get().debug(TAG, String.format("WorkerWrapper could not be found for %s", new Object[]{str}), new Throwable[0]);
        return false;
    }

    public void addExecutionListener(ExecutionListener executionListener) {
        synchronized (this.mLock) {
            this.mOuterListeners.add(executionListener);
        }
    }

    public boolean isEnqueued(String str) {
        boolean z;
        synchronized (this.mLock) {
            if (!this.mEnqueuedWorkMap.containsKey(str)) {
                if (!this.mForegroundWorkMap.containsKey(str)) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public void onExecuted(String str, boolean z) {
        synchronized (this.mLock) {
            this.mEnqueuedWorkMap.remove(str);
            Logger.get().debug(TAG, String.format("%s %s executed; reschedule = %s", new Object[]{getClass().getSimpleName(), str, Boolean.valueOf(z)}), new Throwable[0]);
            for (ExecutionListener onExecuted : this.mOuterListeners) {
                onExecuted.onExecuted(str, z);
            }
        }
    }

    public void removeExecutionListener(ExecutionListener executionListener) {
        synchronized (this.mLock) {
            this.mOuterListeners.remove(executionListener);
        }
    }

    public void startForeground(String str, ForegroundInfo foregroundInfo) {
        synchronized (this.mLock) {
            Logger.get().info(TAG, String.format("Moving WorkSpec (%s) to the foreground", new Object[]{str}), new Throwable[0]);
            WorkerWrapper remove = this.mEnqueuedWorkMap.remove(str);
            if (remove != null) {
                if (this.mForegroundLock == null) {
                    WakeLock newWakeLock = WakeLocks.newWakeLock(this.mAppContext, "ProcessorForegroundLck");
                    this.mForegroundLock = newWakeLock;
                    newWakeLock.acquire();
                }
                this.mForegroundWorkMap.put(str, remove);
                ContextCompat.startForegroundService(this.mAppContext, SystemForegroundDispatcher.createStartForegroundIntent(this.mAppContext, str, foregroundInfo));
            }
        }
    }

    public boolean startWork(String str, RuntimeExtras runtimeExtras) {
        synchronized (this.mLock) {
            if (isEnqueued(str)) {
                Logger.get().debug(TAG, String.format("Work %s is already enqueued for processing", new Object[]{str}), new Throwable[0]);
                return false;
            }
            Builder builder = new Builder(this.mAppContext, this.mConfiguration, this.mWorkTaskExecutor, this, this.mWorkDatabase, str);
            builder.mSchedulers = this.mSchedulers;
            if (runtimeExtras != null) {
                builder.mRuntimeExtras = runtimeExtras;
            }
            WorkerWrapper workerWrapper = new WorkerWrapper(builder);
            SettableFuture<Boolean> settableFuture = workerWrapper.mFuture;
            settableFuture.addListener(new FutureListener(this, str, settableFuture), ((WorkManagerTaskExecutor) this.mWorkTaskExecutor).mMainThreadExecutor);
            this.mEnqueuedWorkMap.put(str, workerWrapper);
            ((WorkManagerTaskExecutor) this.mWorkTaskExecutor).mBackgroundExecutor.execute(workerWrapper);
            Logger.get().debug(TAG, String.format("%s: processing %s", new Object[]{Processor.class.getSimpleName(), str}), new Throwable[0]);
            return true;
        }
    }

    public final void stopForegroundService() {
        synchronized (this.mLock) {
            if (!(!this.mForegroundWorkMap.isEmpty())) {
                try {
                    this.mAppContext.startService(SystemForegroundDispatcher.createStopForegroundIntent(this.mAppContext));
                } catch (Throwable th) {
                    Logger.get().error(TAG, "Unable to stop foreground service", th);
                }
                if (this.mForegroundLock != null) {
                    this.mForegroundLock.release();
                    this.mForegroundLock = null;
                }
            }
        }
    }

    public boolean stopForegroundWork(String str) {
        boolean interrupt;
        synchronized (this.mLock) {
            Logger.get().debug(TAG, String.format("Processor stopping foreground work %s", new Object[]{str}), new Throwable[0]);
            interrupt = interrupt(str, this.mForegroundWorkMap.remove(str));
        }
        return interrupt;
    }

    public boolean stopWork(String str) {
        boolean interrupt;
        synchronized (this.mLock) {
            Logger.get().debug(TAG, String.format("Processor stopping background work %s", new Object[]{str}), new Throwable[0]);
            interrupt = interrupt(str, this.mEnqueuedWorkMap.remove(str));
        }
        return interrupt;
    }
}
