package kotlinx.coroutines;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.scheduling.Task;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u000e\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u0011J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0010¢\u0006\u0002\b\u0014J\u001f\u0010\u0015\u001a\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u001b\u001a\u00020\fJ\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u000eH ¢\u0006\u0002\b\u001dR\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX \u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/DispatchedTask;", "T", "Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/SchedulerTask;", "resumeMode", "", "(I)V", "delegate", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "cancelCompletedResult", "", "takenState", "", "cause", "", "cancelCompletedResult$kotlinx_coroutines_core", "getExceptionalResult", "state", "getExceptionalResult$kotlinx_coroutines_core", "getSuccessfulResult", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "handleFatalException", "exception", "finallyException", "run", "takeState", "takeState$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DispatchedTask.kt */
public abstract class DispatchedTask<T> extends Task {
    public int resumeMode;

    public DispatchedTask(int i) {
        this.resumeMode = i;
    }

    public void cancelCompletedResult$kotlinx_coroutines_core(Object obj, Throwable th) {
    }

    public abstract Continuation<T> getDelegate$kotlinx_coroutines_core();

    public Throwable getExceptionalResult$kotlinx_coroutines_core(Object obj) {
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        if (completedExceptionally != null) {
            return completedExceptionally.cause;
        }
        return null;
    }

    public <T> T getSuccessfulResult$kotlinx_coroutines_core(Object obj) {
        return obj;
    }

    public final void handleFatalException(Throwable th, Throwable th2) {
        if (th != null || th2 != null) {
            if (!(th == null || th2 == null)) {
                TweetUtils.addSuppressed(th, th2);
            }
            if (th == null) {
                th = th2;
            }
            Intrinsics.checkNotNull(th);
            TypeUtilsKt.handleCoroutineException(getDelegate$kotlinx_coroutines_core().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006d, code lost:
        if (r4.clearThreadContext() != false) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008c, code lost:
        if (r4.clearThreadContext() != false) goto L_0x008e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r10 = this;
            kotlinx.coroutines.scheduling.TaskContext r0 = r10.taskContext
            kotlin.coroutines.Continuation r1 = r10.getDelegate$kotlinx_coroutines_core()     // Catch:{ all -> 0x0092 }
            kotlinx.coroutines.internal.DispatchedContinuation r1 = (kotlinx.coroutines.internal.DispatchedContinuation) r1     // Catch:{ all -> 0x0092 }
            kotlin.coroutines.Continuation<T> r2 = r1.continuation     // Catch:{ all -> 0x0092 }
            java.lang.Object r1 = r1.countOrElement     // Catch:{ all -> 0x0092 }
            kotlin.coroutines.CoroutineContext r3 = r2.getContext()     // Catch:{ all -> 0x0092 }
            java.lang.Object r1 = kotlinx.coroutines.internal.ThreadContextKt.updateThreadContext(r3, r1)     // Catch:{ all -> 0x0092 }
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.internal.ThreadContextKt.NO_THREAD_ELEMENTS     // Catch:{ all -> 0x0092 }
            r5 = 0
            if (r1 == r4) goto L_0x001e
            kotlinx.coroutines.UndispatchedCoroutine r4 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.updateUndispatchedCompletion(r2, r3, r1)     // Catch:{ all -> 0x0092 }
            goto L_0x001f
        L_0x001e:
            r4 = r5
        L_0x001f:
            kotlin.coroutines.CoroutineContext r6 = r2.getContext()     // Catch:{ all -> 0x0085 }
            java.lang.Object r7 = r10.takeState$kotlinx_coroutines_core()     // Catch:{ all -> 0x0085 }
            java.lang.Throwable r8 = r10.getExceptionalResult$kotlinx_coroutines_core(r7)     // Catch:{ all -> 0x0085 }
            if (r8 != 0) goto L_0x003e
            int r9 = r10.resumeMode     // Catch:{ all -> 0x0085 }
            boolean r9 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.isCancellableMode(r9)     // Catch:{ all -> 0x0085 }
            if (r9 == 0) goto L_0x003e
            kotlinx.coroutines.Job$Key r9 = kotlinx.coroutines.Job.Key     // Catch:{ all -> 0x0085 }
            kotlin.coroutines.CoroutineContext$Element r6 = r6.get(r9)     // Catch:{ all -> 0x0085 }
            kotlinx.coroutines.Job r6 = (kotlinx.coroutines.Job) r6     // Catch:{ all -> 0x0085 }
            goto L_0x003f
        L_0x003e:
            r6 = r5
        L_0x003f:
            if (r6 == 0) goto L_0x0056
            boolean r9 = r6.isActive()     // Catch:{ all -> 0x0085 }
            if (r9 != 0) goto L_0x0056
            java.util.concurrent.CancellationException r6 = r6.getCancellationException()     // Catch:{ all -> 0x0085 }
            r10.cancelCompletedResult$kotlinx_coroutines_core(r7, r6)     // Catch:{ all -> 0x0085 }
            java.lang.Object r6 = com.twitter.sdk.android.tweetui.TweetUtils.createFailure(r6)     // Catch:{ all -> 0x0085 }
            r2.resumeWith(r6)     // Catch:{ all -> 0x0085 }
            goto L_0x0067
        L_0x0056:
            if (r8 == 0) goto L_0x0060
            java.lang.Object r6 = com.twitter.sdk.android.tweetui.TweetUtils.createFailure(r8)     // Catch:{ all -> 0x0085 }
            r2.resumeWith(r6)     // Catch:{ all -> 0x0085 }
            goto L_0x0067
        L_0x0060:
            java.lang.Object r6 = r10.getSuccessfulResult$kotlinx_coroutines_core(r7)     // Catch:{ all -> 0x0085 }
            r2.resumeWith(r6)     // Catch:{ all -> 0x0085 }
        L_0x0067:
            if (r4 == 0) goto L_0x006f
            boolean r2 = r4.clearThreadContext()     // Catch:{ all -> 0x0092 }
            if (r2 == 0) goto L_0x0072
        L_0x006f:
            kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(r3, r1)     // Catch:{ all -> 0x0092 }
        L_0x0072:
            r0.afterTask()     // Catch:{ all -> 0x0078 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0078 }
            goto L_0x007d
        L_0x0078:
            r0 = move-exception
            java.lang.Object r0 = com.twitter.sdk.android.tweetui.TweetUtils.createFailure(r0)
        L_0x007d:
            java.lang.Throwable r0 = kotlin.Result.m884exceptionOrNullimpl(r0)
            r10.handleFatalException(r5, r0)
            goto L_0x00a5
        L_0x0085:
            r2 = move-exception
            if (r4 == 0) goto L_0x008e
            boolean r4 = r4.clearThreadContext()     // Catch:{ all -> 0x0092 }
            if (r4 == 0) goto L_0x0091
        L_0x008e:
            kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(r3, r1)     // Catch:{ all -> 0x0092 }
        L_0x0091:
            throw r2     // Catch:{ all -> 0x0092 }
        L_0x0092:
            r1 = move-exception
            r0.afterTask()     // Catch:{ all -> 0x0099 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0099 }
            goto L_0x009e
        L_0x0099:
            r0 = move-exception
            java.lang.Object r0 = com.twitter.sdk.android.tweetui.TweetUtils.createFailure(r0)
        L_0x009e:
            java.lang.Throwable r0 = kotlin.Result.m884exceptionOrNullimpl(r0)
            r10.handleFatalException(r1, r0)
        L_0x00a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.DispatchedTask.run():void");
    }

    public abstract Object takeState$kotlinx_coroutines_core();
}
