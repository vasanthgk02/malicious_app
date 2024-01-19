package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Network;
import android.net.Uri;
import androidx.annotation.Keep;
import androidx.work.Data;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.WorkInfo$State;
import androidx.work.impl.Processor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkProgress;
import androidx.work.impl.model.WorkProgressDao_Impl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.utils.WorkForegroundUpdater;
import androidx.work.impl.utils.WorkForegroundUpdater.AnonymousClass1;
import androidx.work.impl.utils.WorkProgressUpdater;
import androidx.work.impl.utils.futures.AbstractFuture.Cancellation;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

public abstract class ListenableWorker {
    public Context mAppContext;
    public boolean mRunInForeground;
    public volatile boolean mStopped;
    public boolean mUsed;
    public WorkerParameters mWorkerParams;

    public static abstract class Result {

        public static final class Failure extends Result {
            public final Data mOutputData = Data.EMPTY;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || Failure.class != obj.getClass()) {
                    return false;
                }
                return this.mOutputData.equals(((Failure) obj).mOutputData);
            }

            public int hashCode() {
                return this.mOutputData.hashCode() + 846803280;
            }

            public String toString() {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Failure {mOutputData=");
                outline73.append(this.mOutputData);
                outline73.append('}');
                return outline73.toString();
            }
        }

        public static final class Retry extends Result {
            public boolean equals(Object obj) {
                boolean z = true;
                if (this == obj) {
                    return true;
                }
                if (obj == null || Retry.class != obj.getClass()) {
                    z = false;
                }
                return z;
            }

            public int hashCode() {
                return 25945934;
            }

            public String toString() {
                return "Retry";
            }
        }

        public static final class Success extends Result {
            public final Data mOutputData;

            public Success() {
                this.mOutputData = Data.EMPTY;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || Success.class != obj.getClass()) {
                    return false;
                }
                return this.mOutputData.equals(((Success) obj).mOutputData);
            }

            public int hashCode() {
                return this.mOutputData.hashCode() - 1876823561;
            }

            public String toString() {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Success {mOutputData=");
                outline73.append(this.mOutputData);
                outline73.append('}');
                return outline73.toString();
            }

            public Success(Data data) {
                this.mOutputData = data;
            }
        }
    }

    @SuppressLint({"BanKeepAnnotation"})
    @Keep
    public ListenableWorker(Context context, WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        } else if (workerParameters != null) {
            this.mAppContext = context;
            this.mWorkerParams = workerParameters;
        } else {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
    }

    public final Context getApplicationContext() {
        return this.mAppContext;
    }

    public Executor getBackgroundExecutor() {
        return this.mWorkerParams.mBackgroundExecutor;
    }

    public final UUID getId() {
        return this.mWorkerParams.mId;
    }

    public final Data getInputData() {
        return this.mWorkerParams.mInputData;
    }

    public final Network getNetwork() {
        return this.mWorkerParams.mRuntimeExtras.network;
    }

    public final int getRunAttemptCount() {
        return this.mWorkerParams.mRunAttemptCount;
    }

    public final Set<String> getTags() {
        return this.mWorkerParams.mTags;
    }

    public TaskExecutor getTaskExecutor() {
        return this.mWorkerParams.mWorkTaskExecutor;
    }

    public final List<String> getTriggeredContentAuthorities() {
        return this.mWorkerParams.mRuntimeExtras.triggeredContentAuthorities;
    }

    public final List<Uri> getTriggeredContentUris() {
        return this.mWorkerParams.mRuntimeExtras.triggeredContentUris;
    }

    public WorkerFactory getWorkerFactory() {
        return this.mWorkerParams.mWorkerFactory;
    }

    public boolean isRunInForeground() {
        return this.mRunInForeground;
    }

    public final boolean isStopped() {
        return this.mStopped;
    }

    public final boolean isUsed() {
        return this.mUsed;
    }

    public void onStopped() {
    }

    public final ListenableFuture<Void> setForegroundAsync(ForegroundInfo foregroundInfo) {
        this.mRunInForeground = true;
        ForegroundUpdater foregroundUpdater = this.mWorkerParams.mForegroundUpdater;
        Context applicationContext = getApplicationContext();
        UUID id = getId();
        WorkForegroundUpdater workForegroundUpdater = (WorkForegroundUpdater) foregroundUpdater;
        if (workForegroundUpdater != null) {
            SettableFuture settableFuture = new SettableFuture();
            TaskExecutor taskExecutor = workForegroundUpdater.mTaskExecutor;
            AnonymousClass1 r1 = new Runnable(settableFuture, id, foregroundInfo, applicationContext) {
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ ForegroundInfo val$foregroundInfo;
                public final /* synthetic */ SettableFuture val$future;
                public final /* synthetic */ UUID val$id;

                {
                    this.val$future = r2;
                    this.val$id = r3;
                    this.val$foregroundInfo = r4;
                    this.val$context = r5;
                }

                public void run() {
                    try {
                        if (!(this.val$future.value instanceof Cancellation)) {
                            String uuid = this.val$id.toString();
                            WorkInfo$State state = ((WorkSpecDao_Impl) WorkForegroundUpdater.this.mWorkSpecDao).getState(uuid);
                            if (state == null || state.isFinished()) {
                                throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                            }
                            ((Processor) WorkForegroundUpdater.this.mForegroundProcessor).startForeground(uuid, this.val$foregroundInfo);
                            this.val$context.startService(SystemForegroundDispatcher.createNotifyIntent(this.val$context, uuid, this.val$foregroundInfo));
                        }
                        this.val$future.set(null);
                    } catch (Throwable th) {
                        this.val$future.setException(th);
                    }
                }
            };
            ((WorkManagerTaskExecutor) taskExecutor).mBackgroundExecutor.execute(r1);
            return settableFuture;
        }
        throw null;
    }

    public final ListenableFuture<Void> setProgressAsync(Data data) {
        ProgressUpdater progressUpdater = this.mWorkerParams.mProgressUpdater;
        getApplicationContext();
        UUID id = getId();
        WorkProgressUpdater workProgressUpdater = (WorkProgressUpdater) progressUpdater;
        if (workProgressUpdater != null) {
            SettableFuture settableFuture = new SettableFuture();
            TaskExecutor taskExecutor = workProgressUpdater.mTaskExecutor;
            ((WorkManagerTaskExecutor) taskExecutor).mBackgroundExecutor.execute(new Runnable(id, data, settableFuture) {
                public final /* synthetic */ Data val$data;
                public final /* synthetic */ SettableFuture val$future;
                public final /* synthetic */ UUID val$id;

                {
                    this.val$id = r2;
                    this.val$data = r3;
                    this.val$future = r4;
                }

                public void run() {
                    WorkProgressDao_Impl workProgressDao_Impl;
                    String uuid = this.val$id.toString();
                    Logger.get().debug(WorkProgressUpdater.TAG, String.format("Updating progress for %s (%s)", new Object[]{this.val$id, this.val$data}), new Throwable[0]);
                    WorkProgressUpdater.this.mWorkDatabase.beginTransaction();
                    try {
                        WorkSpec workSpec = ((WorkSpecDao_Impl) WorkProgressUpdater.this.mWorkDatabase.workSpecDao()).getWorkSpec(uuid);
                        if (workSpec != null) {
                            if (workSpec.state == WorkInfo$State.RUNNING) {
                                WorkProgress workProgress = new WorkProgress(uuid, this.val$data);
                                workProgressDao_Impl = (WorkProgressDao_Impl) WorkProgressUpdater.this.mWorkDatabase.workProgressDao();
                                workProgressDao_Impl.__db.assertNotSuspendingTransaction();
                                workProgressDao_Impl.__db.beginTransaction();
                                workProgressDao_Impl.__insertionAdapterOfWorkProgress.insert(workProgress);
                                workProgressDao_Impl.__db.setTransactionSuccessful();
                                workProgressDao_Impl.__db.endTransaction();
                            } else {
                                Logger.get().warning(WorkProgressUpdater.TAG, String.format("Ignoring setProgressAsync(...). WorkSpec (%s) is not in a RUNNING state.", new Object[]{uuid}), new Throwable[0]);
                            }
                            this.val$future.set(null);
                            WorkProgressUpdater.this.mWorkDatabase.setTransactionSuccessful();
                            WorkProgressUpdater.this.mWorkDatabase.endTransaction();
                            return;
                        }
                        throw new IllegalStateException("Calls to setProgressAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                    } catch (Throwable th) {
                        try {
                            Logger.get().error(WorkProgressUpdater.TAG, "Error updating Worker progress", th);
                            this.val$future.setException(th);
                        } catch (Throwable th2) {
                            WorkProgressUpdater.this.mWorkDatabase.endTransaction();
                            throw th2;
                        }
                    }
                }
            });
            return settableFuture;
        }
        throw null;
    }

    public final void setUsed() {
        this.mUsed = true;
    }

    public abstract ListenableFuture<Result> startWork();

    public final void stop() {
        this.mStopped = true;
        onStopped();
    }
}
