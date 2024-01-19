package androidx.work;

import android.content.Context;
import androidx.work.ListenableWorker.Result;
import androidx.work.impl.utils.futures.AbstractFuture.Cancellation;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0016\u001a\u00020\u000fH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0006\u0010\u0018\u001a\u00020\u0019J\u0019\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 H@ø\u0001\u0000¢\u0006\u0002\u0010!J\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0#R\u001c\u0010\u0007\u001a\u00020\b8\u0016X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Landroidx/work/CoroutineWorker;", "Landroidx/work/ListenableWorker;", "appContext", "Landroid/content/Context;", "params", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "coroutineContext", "Lkotlinx/coroutines/CoroutineDispatcher;", "getCoroutineContext$annotations", "()V", "getCoroutineContext", "()Lkotlinx/coroutines/CoroutineDispatcher;", "future", "Landroidx/work/impl/utils/futures/SettableFuture;", "Landroidx/work/ListenableWorker$Result;", "getFuture$work_runtime_ktx_release", "()Landroidx/work/impl/utils/futures/SettableFuture;", "job", "Lkotlinx/coroutines/CompletableJob;", "getJob$work_runtime_ktx_release", "()Lkotlinx/coroutines/CompletableJob;", "doWork", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onStopped", "", "setForeground", "foregroundInfo", "Landroidx/work/ForegroundInfo;", "(Landroidx/work/ForegroundInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setProgress", "data", "Landroidx/work/Data;", "(Landroidx/work/Data;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startWork", "Lcom/google/common/util/concurrent/ListenableFuture;", "work-runtime-ktx_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: CoroutineWorker.kt */
public abstract class CoroutineWorker extends ListenableWorker {
    public final CoroutineDispatcher coroutineContext;
    public final SettableFuture<Result> future;
    public final CompletableJob job = new JobImpl(null);

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public CoroutineWorker(Context context, WorkerParameters workerParameters) {
        // Intrinsics.checkNotNullParameter(context, "appContext");
        // Intrinsics.checkNotNullParameter(workerParameters, CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY);
        super(context, workerParameters);
        SettableFuture<Result> settableFuture = new SettableFuture<>();
        Intrinsics.checkNotNullExpressionValue(settableFuture, "SettableFuture.create()");
        this.future = settableFuture;
        AnonymousClass1 r4 = new Runnable(this) {
            public final /* synthetic */ CoroutineWorker this$0;

            {
                this.this$0 = r1;
            }

            public final void run() {
                if (this.this$0.getFuture$work_runtime_ktx_release().value instanceof Cancellation) {
                    TypeUtilsKt.cancel$default((Job) this.this$0.getJob$work_runtime_ktx_release(), (CancellationException) null, 1, (Object) null);
                }
            }
        };
        TaskExecutor taskExecutor = getTaskExecutor();
        Intrinsics.checkNotNullExpressionValue(taskExecutor, "taskExecutor");
        settableFuture.addListener(r4, ((WorkManagerTaskExecutor) taskExecutor).mBackgroundExecutor);
        this.coroutineContext = Dispatchers.Default;
    }

    public static /* synthetic */ void getCoroutineContext$annotations() {
    }

    public abstract Object doWork(Continuation<? super Result> continuation);

    public CoroutineDispatcher getCoroutineContext() {
        return this.coroutineContext;
    }

    public final SettableFuture<Result> getFuture$work_runtime_ktx_release() {
        return this.future;
    }

    public final CompletableJob getJob$work_runtime_ktx_release() {
        return this.job;
    }

    public final void onStopped() {
        super.onStopped();
        this.future.cancel(false);
    }

    /* JADX WARNING: type inference failed for: r5v2, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r4v6, types: [java.lang.Throwable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setForeground(androidx.work.ForegroundInfo r4, kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r3 = this;
            com.google.common.util.concurrent.ListenableFuture r4 = r3.setForegroundAsync(r4)
            java.lang.String r0 = "setForegroundAsync(foregroundInfo)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            boolean r0 = r4.isDone()
            if (r0 == 0) goto L_0x001d
            java.lang.Object r4 = r4.get()     // Catch:{ ExecutionException -> 0x0014 }
            goto L_0x0041
        L_0x0014:
            r4 = move-exception
            java.lang.Throwable r5 = r4.getCause()
            if (r5 == 0) goto L_0x001c
            r4 = r5
        L_0x001c:
            throw r4
        L_0x001d:
            kotlinx.coroutines.CancellableContinuationImpl r0 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r1 = com.twitter.sdk.android.tweetui.TweetUtils.intercepted(r5)
            r2 = 1
            r0.<init>(r1, r2)
            r0.initCancellability()
            androidx.work.CoroutineWorker$await$$inlined$suspendCancellableCoroutine$lambda$2 r1 = new androidx.work.CoroutineWorker$await$$inlined$suspendCancellableCoroutine$lambda$2
            r1.<init>(r0, r4)
            androidx.work.DirectExecutor r2 = androidx.work.DirectExecutor.INSTANCE
            r4.addListener(r1, r2)
            java.lang.Object r4 = r0.getResult()
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r4 != r0) goto L_0x0041
            java.lang.String r0 = "frame"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
        L_0x0041:
            kotlin.coroutines.intrinsics.CoroutineSingletons r5 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r4 != r5) goto L_0x0046
            return r4
        L_0x0046:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.CoroutineWorker.setForeground(androidx.work.ForegroundInfo, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r5v2, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r4v6, types: [java.lang.Throwable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setProgress(androidx.work.Data r4, kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r3 = this;
            com.google.common.util.concurrent.ListenableFuture r4 = r3.setProgressAsync(r4)
            java.lang.String r0 = "setProgressAsync(data)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            boolean r0 = r4.isDone()
            if (r0 == 0) goto L_0x001d
            java.lang.Object r4 = r4.get()     // Catch:{ ExecutionException -> 0x0014 }
            goto L_0x0041
        L_0x0014:
            r4 = move-exception
            java.lang.Throwable r5 = r4.getCause()
            if (r5 == 0) goto L_0x001c
            r4 = r5
        L_0x001c:
            throw r4
        L_0x001d:
            kotlinx.coroutines.CancellableContinuationImpl r0 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r1 = com.twitter.sdk.android.tweetui.TweetUtils.intercepted(r5)
            r2 = 1
            r0.<init>(r1, r2)
            r0.initCancellability()
            androidx.work.CoroutineWorker$await$$inlined$suspendCancellableCoroutine$lambda$1 r1 = new androidx.work.CoroutineWorker$await$$inlined$suspendCancellableCoroutine$lambda$1
            r1.<init>(r0, r4)
            androidx.work.DirectExecutor r2 = androidx.work.DirectExecutor.INSTANCE
            r4.addListener(r1, r2)
            java.lang.Object r4 = r0.getResult()
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r4 != r0) goto L_0x0041
            java.lang.String r0 = "frame"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
        L_0x0041:
            kotlin.coroutines.intrinsics.CoroutineSingletons r5 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r4 != r5) goto L_0x0046
            return r4
        L_0x0046:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.CoroutineWorker.setProgress(androidx.work.Data, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final ListenableFuture<Result> startWork() {
        TypeUtilsKt.launch$default(TypeUtilsKt.CoroutineScope(getCoroutineContext().plus(this.job)), null, null, new CoroutineWorker$startWork$1(this, null), 3, null);
        return this.future;
    }
}
