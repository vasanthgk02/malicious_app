package androidx.work.impl.workers;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.ListenableWorker.Result;
import androidx.work.ListenableWorker.Result.Failure;
import androidx.work.ListenableWorker.Result.Retry;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

public class ConstraintTrackingWorker extends ListenableWorker implements WorkConstraintsCallback {
    public static final String TAG = Logger.tagWithPrefix("ConstraintTrkngWrkr");
    public volatile boolean mAreConstraintsUnmet = false;
    public ListenableWorker mDelegate;
    public SettableFuture<Result> mFuture = new SettableFuture<>();
    public final Object mLock = new Object();
    public WorkerParameters mWorkerParameters;

    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.mWorkerParameters = workerParameters;
    }

    public TaskExecutor getTaskExecutor() {
        return WorkManagerImpl.getInstance(getApplicationContext()).mWorkTaskExecutor;
    }

    public boolean isRunInForeground() {
        ListenableWorker listenableWorker = this.mDelegate;
        return listenableWorker != null && listenableWorker.isRunInForeground();
    }

    public void onAllConstraintsMet(List<String> list) {
    }

    public void onAllConstraintsNotMet(List<String> list) {
        Logger.get().debug(TAG, String.format("Constraints changed for %s", new Object[]{list}), new Throwable[0]);
        synchronized (this.mLock) {
            this.mAreConstraintsUnmet = true;
        }
    }

    public void onStopped() {
        super.onStopped();
        ListenableWorker listenableWorker = this.mDelegate;
        if (listenableWorker != null && !listenableWorker.isStopped()) {
            this.mDelegate.stop();
        }
    }

    public void setFutureFailed() {
        this.mFuture.set(new Failure());
    }

    public void setFutureRetry() {
        this.mFuture.set(new Retry());
    }

    public ListenableFuture<Result> startWork() {
        getBackgroundExecutor().execute(new Runnable() {
            public void run() {
                ConstraintTrackingWorker constraintTrackingWorker = ConstraintTrackingWorker.this;
                String string = constraintTrackingWorker.getInputData().getString("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
                if (TextUtils.isEmpty(string)) {
                    Logger.get().error(ConstraintTrackingWorker.TAG, "No worker to delegate to.", new Throwable[0]);
                    constraintTrackingWorker.setFutureFailed();
                    return;
                }
                ListenableWorker createWorkerWithDefaultFallback = constraintTrackingWorker.getWorkerFactory().createWorkerWithDefaultFallback(constraintTrackingWorker.getApplicationContext(), string, constraintTrackingWorker.mWorkerParameters);
                constraintTrackingWorker.mDelegate = createWorkerWithDefaultFallback;
                if (createWorkerWithDefaultFallback == null) {
                    Logger.get().debug(ConstraintTrackingWorker.TAG, "No worker to delegate to.", new Throwable[0]);
                    constraintTrackingWorker.setFutureFailed();
                    return;
                }
                WorkSpec workSpec = ((WorkSpecDao_Impl) WorkManagerImpl.getInstance(constraintTrackingWorker.getApplicationContext()).mWorkDatabase.workSpecDao()).getWorkSpec(constraintTrackingWorker.getId().toString());
                if (workSpec == null) {
                    constraintTrackingWorker.setFutureFailed();
                    return;
                }
                WorkConstraintsTracker workConstraintsTracker = new WorkConstraintsTracker(constraintTrackingWorker.getApplicationContext(), constraintTrackingWorker.getTaskExecutor(), constraintTrackingWorker);
                workConstraintsTracker.replace(Collections.singletonList(workSpec));
                if (workConstraintsTracker.areAllConstraintsMet(constraintTrackingWorker.getId().toString())) {
                    Logger.get().debug(ConstraintTrackingWorker.TAG, String.format("Constraints met for delegate %s", new Object[]{string}), new Throwable[0]);
                    try {
                        ListenableFuture<Result> startWork = constraintTrackingWorker.mDelegate.startWork();
                        startWork.addListener(new Runnable(startWork) {
                            public final /* synthetic */ ListenableFuture val$innerFuture;

                            {
                                this.val$innerFuture = r2;
                            }

                            public void run() {
                                synchronized (ConstraintTrackingWorker.this.mLock) {
                                    if (ConstraintTrackingWorker.this.mAreConstraintsUnmet) {
                                        ConstraintTrackingWorker.this.setFutureRetry();
                                    } else {
                                        ConstraintTrackingWorker.this.mFuture.setFuture(this.val$innerFuture);
                                    }
                                }
                            }
                        }, constraintTrackingWorker.getBackgroundExecutor());
                    } catch (Throwable th) {
                        Logger.get().debug(ConstraintTrackingWorker.TAG, String.format("Delegated worker %s threw exception in startWork.", new Object[]{string}), th);
                        synchronized (constraintTrackingWorker.mLock) {
                            if (constraintTrackingWorker.mAreConstraintsUnmet) {
                                Logger.get().debug(ConstraintTrackingWorker.TAG, "Constraints were unmet, Retrying.", new Throwable[0]);
                                constraintTrackingWorker.setFutureRetry();
                            } else {
                                constraintTrackingWorker.setFutureFailed();
                            }
                        }
                    }
                } else {
                    Logger.get().debug(ConstraintTrackingWorker.TAG, String.format("Constraints not met for delegate %s. Requesting retry.", new Object[]{string}), new Throwable[0]);
                    constraintTrackingWorker.setFutureRetry();
                }
            }
        });
        return this.mFuture;
    }
}
