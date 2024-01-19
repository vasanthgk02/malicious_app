package com.netcore.android.workmgr;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.PeriodicWorkRequest.Builder;
import androidx.work.WorkRequest;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.utils.CancelWorkRunnable;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import com.netcore.android.SMTWorkManagerConst;
import com.netcore.android.utility.SMTCommonUtility;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0006J\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u0006J\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\u0006J\u0015\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u0006R\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/netcore/android/workmgr/SMTWorkerScheduler;", "", "Landroid/content/Context;", "context", "", "scheduleEventWorker", "(Landroid/content/Context;)V", "checkStatusAndScheduleEventWorker", "scheduleInProgressEventWorker", "scheduleBackgroundSyncWorker", "schedulePushAmp", "ctx", "cancelBackgroundSyncWorker", "cancelInProressSyncWorker", "", "a", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "<init>", "()V", "Companion", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTWorkerScheduler.kt */
public final class SMTWorkerScheduler {
    public static final Companion Companion = new Companion(null);

    /* renamed from: b  reason: collision with root package name */
    public static volatile SMTWorkerScheduler f1330b;

    /* renamed from: a  reason: collision with root package name */
    public final String f1331a;

    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/netcore/android/workmgr/SMTWorkerScheduler$Companion;", "", "Lcom/netcore/android/workmgr/SMTWorkerScheduler;", "buildInstance", "()Lcom/netcore/android/workmgr/SMTWorkerScheduler;", "getInstance", "INSTANCE", "Lcom/netcore/android/workmgr/SMTWorkerScheduler;", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: SMTWorkerScheduler.kt */
    public static final class Companion {
        public Companion() {
        }

        private final SMTWorkerScheduler buildInstance() {
            return new SMTWorkerScheduler(null);
        }

        public final SMTWorkerScheduler getInstance() {
            SMTWorkerScheduler access$getINSTANCE$cp;
            SMTWorkerScheduler access$getINSTANCE$cp2 = SMTWorkerScheduler.f1330b;
            if (access$getINSTANCE$cp2 != null) {
                return access$getINSTANCE$cp2;
            }
            synchronized (SMTWorkerScheduler.class) {
                try {
                    access$getINSTANCE$cp = SMTWorkerScheduler.f1330b;
                    if (access$getINSTANCE$cp == null) {
                        access$getINSTANCE$cp = SMTWorkerScheduler.Companion.buildInstance();
                        SMTWorkerScheduler.f1330b = access$getINSTANCE$cp;
                    }
                }
            }
            return access$getINSTANCE$cp;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SMTWorkerScheduler() {
        String simpleName = SMTWorkerScheduler.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "SMTWorkerScheduler::class.java.simpleName");
        this.f1331a = simpleName;
    }

    public static final SMTWorkerScheduler getInstance() {
        return Companion.getInstance();
    }

    public final void cancelBackgroundSyncWorker(Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        WorkManagerImpl instance = WorkManagerImpl.getInstance(context);
        if (instance != null) {
            ((WorkManagerTaskExecutor) instance.mWorkTaskExecutor).mBackgroundExecutor.execute(new CancelWorkRunnable(SMTWorkManagerConst.SMT_BACKGROUND_WORKER_TAG) {
                public final /* synthetic */ String val$tag;

                {
                    this.val$tag = r2;
                }

                /* JADX INFO: finally extract failed */
                public void runInternal() {
                    WorkDatabase workDatabase = WorkManagerImpl.this.mWorkDatabase;
                    workDatabase.beginTransaction();
                    try {
                        Iterator it = ((ArrayList) ((WorkSpecDao_Impl) workDatabase.workSpecDao()).getUnfinishedWorkWithTag(this.val$tag)).iterator();
                        while (it.hasNext()) {
                            cancel(WorkManagerImpl.this, (String) it.next());
                        }
                        workDatabase.setTransactionSuccessful();
                        workDatabase.endTransaction();
                        reschedulePendingWorkers(WorkManagerImpl.this);
                    } catch (Throwable th) {
                        workDatabase.endTransaction();
                        throw th;
                    }
                }
            });
            return;
        }
        throw null;
    }

    public final void cancelInProressSyncWorker(Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        WorkManagerImpl instance = WorkManagerImpl.getInstance(context);
        if (instance != null) {
            ((WorkManagerTaskExecutor) instance.mWorkTaskExecutor).mBackgroundExecutor.execute(new CancelWorkRunnable(SMTWorkManagerConst.SMT_INPROGRESS_WORKER_TAG) {
                public final /* synthetic */ String val$tag;

                {
                    this.val$tag = r2;
                }

                /* JADX INFO: finally extract failed */
                public void runInternal() {
                    WorkDatabase workDatabase = WorkManagerImpl.this.mWorkDatabase;
                    workDatabase.beginTransaction();
                    try {
                        Iterator it = ((ArrayList) ((WorkSpecDao_Impl) workDatabase.workSpecDao()).getUnfinishedWorkWithTag(this.val$tag)).iterator();
                        while (it.hasNext()) {
                            cancel(WorkManagerImpl.this, (String) it.next());
                        }
                        workDatabase.setTransactionSuccessful();
                        workDatabase.endTransaction();
                        reschedulePendingWorkers(WorkManagerImpl.this);
                    } catch (Throwable th) {
                        workDatabase.endTransaction();
                        throw th;
                    }
                }
            });
            return;
        }
        throw null;
    }

    public final void checkStatusAndScheduleEventWorker(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        scheduleEventWorker(context);
    }

    public final String getTAG() {
        return this.f1331a;
    }

    public final void scheduleBackgroundSyncWorker(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Builder builder = new Builder(BackgroundSyncWorker.class, 15, TimeUnit.MINUTES);
        builder.mTags.add(SMTWorkManagerConst.SMT_BACKGROUND_WORKER_TAG);
        WorkRequest build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "PeriodicWorkRequestBuild…ROUND_WORKER_TAG).build()");
        WorkManagerImpl.getInstance(context).enqueueUniquePeriodicWork(SMTWorkManagerConst.SMT_BACKGROUND_WORKER_TAG, ExistingPeriodicWorkPolicy.REPLACE, (PeriodicWorkRequest) build);
    }

    public final void scheduleEventWorker(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        OneTimeWorkRequest.Builder builder = new OneTimeWorkRequest.Builder(EventSyncWorker.class);
        builder.mTags.add(SMTWorkManagerConst.SMT_EVENTSYNC_WORKER_TAG);
        WorkRequest build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "OneTimeWorkRequestBuilde…TSYNC_WORKER_TAG).build()");
        OneTimeWorkRequest oneTimeWorkRequest = (OneTimeWorkRequest) build;
        WorkManagerImpl instance = WorkManagerImpl.getInstance(context);
        ExistingWorkPolicy existingWorkPolicy = ExistingWorkPolicy.KEEP;
        if (instance != null) {
            new WorkContinuationImpl(instance, SMTWorkManagerConst.SMT_EVENTSYNC_WORKER_TAG, existingWorkPolicy, Collections.singletonList(oneTimeWorkRequest)).enqueue();
            return;
        }
        throw null;
    }

    public final void scheduleInProgressEventWorker(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (SMTCommonUtility.INSTANCE.checkIfTrackingAllowed$smartech_release(context)) {
            OneTimeWorkRequest.Builder builder = new OneTimeWorkRequest.Builder(InProgressEventWorker.class);
            builder.mTags.add(SMTWorkManagerConst.SMT_INPROGRESS_WORKER_TAG);
            WorkRequest build = builder.build();
            Intrinsics.checkNotNullExpressionValue(build, "OneTimeWorkRequestBuilde…GRESS_WORKER_TAG).build()");
            OneTimeWorkRequest oneTimeWorkRequest = (OneTimeWorkRequest) build;
            WorkManagerImpl instance = WorkManagerImpl.getInstance(context);
            ExistingWorkPolicy existingWorkPolicy = ExistingWorkPolicy.KEEP;
            if (instance != null) {
                new WorkContinuationImpl(instance, SMTWorkManagerConst.SMT_INPROGRESS_WORKER_TAG, existingWorkPolicy, Collections.singletonList(oneTimeWorkRequest)).enqueue();
                return;
            }
            throw null;
        }
    }

    public final void schedulePushAmp(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SMTWorkerScheduler(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
