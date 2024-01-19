package com.netcore.android.workmgr;

import android.content.Context;
import androidx.work.ListenableWorker.Result;
import androidx.work.ListenableWorker.Result.Failure;
import androidx.work.ListenableWorker.Result.Success;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.netcore.android.SMTActivityLifecycleCallback;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.utility.SMTCommonUtility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/netcore/android/workmgr/BackgroundSyncWorker;", "Landroidx/work/Worker;", "Landroidx/work/ListenableWorker$Result;", "doWork", "()Landroidx/work/ListenableWorker$Result;", "", "onStopped", "()V", "", "a", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "Landroidx/work/WorkerParameters;", "param", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: BackgroundSyncWorker.kt */
public final class BackgroundSyncWorker extends Worker {

    /* renamed from: a  reason: collision with root package name */
    public final String f1325a;
    public Context context;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public BackgroundSyncWorker(Context context2, WorkerParameters workerParameters) {
        // Intrinsics.checkNotNullParameter(context2, "context");
        // Intrinsics.checkNotNullParameter(workerParameters, "param");
        super(context2, workerParameters);
        String simpleName = BackgroundSyncWorker.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "BackgroundSyncWorker::class.java.simpleName");
        this.f1325a = simpleName;
    }

    public Result doWork() {
        try {
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
            this.context = applicationContext;
            boolean isAppInForeground = SMTActivityLifecycleCallback.Companion.getInstance().isAppInForeground();
            SMTCommonUtility sMTCommonUtility = SMTCommonUtility.INSTANCE;
            Context context2 = this.context;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                throw null;
            } else if (!sMTCommonUtility.checkPanelAndSDKActiveStatus(context2)) {
                SMTLogger.INSTANCE.w(this.f1325a, "SDK / Panel is inactive");
                SMTWorkerScheduler instance = SMTWorkerScheduler.Companion.getInstance();
                Context context3 = this.context;
                if (context3 != null) {
                    instance.cancelBackgroundSyncWorker(context3);
                    Failure failure = new Failure();
                    Intrinsics.checkNotNullExpressionValue(failure, "Result.failure()");
                    return failure;
                }
                Intrinsics.throwUninitializedPropertyAccessException("context");
                throw null;
            } else {
                if (!isAppInForeground) {
                    SMTLogger.INSTANCE.i(this.f1325a, "EventSync worker started.");
                    SMTWorkerScheduler instance2 = SMTWorkerScheduler.Companion.getInstance();
                    Context context4 = this.context;
                    if (context4 != null) {
                        instance2.scheduleEventWorker(context4);
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("context");
                        throw null;
                    }
                }
                Success success = new Success();
                Intrinsics.checkNotNullExpressionValue(success, "Result.success()");
                return success;
            }
        } catch (Exception e2) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str = this.f1325a;
            String localizedMessage = e2.getLocalizedMessage();
            Intrinsics.checkNotNullExpressionValue(localizedMessage, "e.localizedMessage");
            sMTLogger.v(str, localizedMessage);
        }
    }

    public final Context getContext() {
        Context context2 = this.context;
        if (context2 != null) {
            return context2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("context");
        throw null;
    }

    public final String getTAG() {
        return this.f1325a;
    }

    public void onStopped() {
        super.onStopped();
        SMTLogger.INSTANCE.v(this.f1325a, "Background sync worker stopped");
    }

    public final void setContext(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        this.context = context2;
    }
}
