package androidx.room;

import android.os.CancellationSignal;
import androidx.core.widget.CompoundButtonCompat;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.GlobalScope;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Landroidx/room/CoroutinesRoom;", "", "()V", "Companion", "room-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CoroutinesRoom.kt */
public final class CoroutinesRoom {
    public static final <R> Object execute(RoomDatabase roomDatabase, boolean z, Callable<R> callable, Continuation<? super R> continuation) {
        if (roomDatabase.isOpen() && roomDatabase.inTransaction()) {
            return callable.call();
        }
        TransactionElement transactionElement = (TransactionElement) continuation.getContext().get(TransactionElement.Key);
        return TypeUtilsKt.withContext(z ? CompoundButtonCompat.getTransactionDispatcher(roomDatabase) : CompoundButtonCompat.getQueryDispatcher(roomDatabase), new CoroutinesRoom$Companion$execute$2(callable, null), continuation);
    }

    public static final <R> Object execute(RoomDatabase roomDatabase, boolean z, CancellationSignal cancellationSignal, Callable<R> callable, Continuation<? super R> continuation) {
        if (roomDatabase.isOpen() && roomDatabase.inTransaction()) {
            return callable.call();
        }
        TransactionElement transactionElement = (TransactionElement) continuation.getContext().get(TransactionElement.Key);
        CoroutineContext transactionDispatcher = z ? CompoundButtonCompat.getTransactionDispatcher(roomDatabase) : CompoundButtonCompat.getQueryDispatcher(roomDatabase);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(TweetUtils.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        cancellableContinuationImpl.invokeOnCancellation(new CoroutinesRoom$Companion$execute$4$1(cancellationSignal, TypeUtilsKt.launch$default(GlobalScope.INSTANCE, transactionDispatcher, null, new CoroutinesRoom$Companion$execute$4$job$1(callable, cancellableContinuationImpl, null), 2, null)));
        Object result = cancellableContinuationImpl.getResult();
        if (result != CoroutineSingletons.COROUTINE_SUSPENDED) {
            return result;
        }
        Intrinsics.checkNotNullParameter(continuation, "frame");
        return result;
    }
}
