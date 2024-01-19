package androidx.room;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$execute$4$job$1", f = "CoroutinesRoom.kt", l = {}, m = "invokeSuspend")
/* compiled from: CoroutinesRoom.kt */
public final class CoroutinesRoom$Companion$execute$4$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Callable<R> $callable;
    public final /* synthetic */ CancellableContinuation<R> $continuation;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public CoroutinesRoom$Companion$execute$4$job$1(Callable<R> callable, CancellableContinuation<? super R> cancellableContinuation, Continuation<? super CoroutinesRoom$Companion$execute$4$job$1> continuation) {
        // this.$callable = callable;
        // this.$continuation = cancellableContinuation;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CoroutinesRoom$Companion$execute$4$job$1(this.$callable, this.$continuation, continuation);
    }

    public Object invoke(Object obj, Object obj2) {
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        return new CoroutinesRoom$Companion$execute$4$job$1(this.$callable, this.$continuation, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        TweetUtils.throwOnFailure(obj);
        try {
            this.$continuation.resumeWith(this.$callable.call());
        } catch (Throwable th) {
            this.$continuation.resumeWith(TweetUtils.createFailure(th));
        }
        return Unit.INSTANCE;
    }
}
