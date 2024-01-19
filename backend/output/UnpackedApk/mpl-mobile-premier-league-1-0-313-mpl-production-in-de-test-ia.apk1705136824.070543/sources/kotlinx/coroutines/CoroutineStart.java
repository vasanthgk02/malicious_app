package kotlinx.coroutines;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JC\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\n2\u001c\u0010\u000b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\n0\rH\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\\\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\u0011\"\u0004\b\u0001\u0010\n2'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0012¢\u0006\u0002\b\u00132\u0006\u0010\u0014\u001a\u0002H\u00112\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\n0\rH\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0015R\u001a\u0010\u0003\u001a\u00020\u00048FX\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0007j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/CoroutineStart;", "", "(Ljava/lang/String;I)V", "isLazy", "", "isLazy$annotations", "()V", "()Z", "invoke", "", "T", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "completion", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "DEFAULT", "LAZY", "ATOMIC", "UNDISPATCHED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CoroutineStart.kt */
public enum CoroutineStart {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    public final <T> void invoke(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        CoroutineContext context;
        Object updateThreadContext;
        int ordinal = ordinal();
        if (ordinal == 0) {
            try {
                DispatchedContinuationKt.resumeCancellableWith$default(TweetUtils.intercepted(TweetUtils.createCoroutineUnintercepted(function1, continuation)), Unit.INSTANCE, null, 2);
            } catch (Throwable th) {
                TypeUtilsKt.dispatcherFailure(continuation, th);
                throw null;
            }
        } else if (ordinal == 1) {
        } else {
            if (ordinal == 2) {
                Intrinsics.checkNotNullParameter(function1, "<this>");
                Intrinsics.checkNotNullParameter(continuation, "completion");
                TweetUtils.intercepted(TweetUtils.createCoroutineUnintercepted(function1, continuation)).resumeWith(Unit.INSTANCE);
            } else if (ordinal == 3) {
                Intrinsics.checkNotNullParameter(continuation, "completion");
                try {
                    context = continuation.getContext();
                    updateThreadContext = ThreadContextKt.updateThreadContext(context, null);
                    TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1);
                    Object invoke = function1.invoke(continuation);
                    ThreadContextKt.restoreThreadContext(context, updateThreadContext);
                    if (invoke != CoroutineSingletons.COROUTINE_SUSPENDED) {
                        continuation.resumeWith(invoke);
                    }
                } catch (Throwable th2) {
                    continuation.resumeWith(TweetUtils.createFailure(th2));
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public final boolean isLazy() {
        return this == LAZY;
    }

    public final <R, T> void invoke(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        CoroutineContext context;
        Object updateThreadContext;
        int ordinal = ordinal();
        if (ordinal == 0) {
            TypeUtilsKt.startCoroutineCancellable$default(function2, r, continuation, null, 4);
        } else if (ordinal == 1) {
        } else {
            if (ordinal == 2) {
                Intrinsics.checkNotNullParameter(function2, "<this>");
                Intrinsics.checkNotNullParameter(continuation, "completion");
                TweetUtils.intercepted(TweetUtils.createCoroutineUnintercepted(function2, r, continuation)).resumeWith(Unit.INSTANCE);
            } else if (ordinal == 3) {
                Intrinsics.checkNotNullParameter(continuation, "completion");
                try {
                    context = continuation.getContext();
                    updateThreadContext = ThreadContextKt.updateThreadContext(context, null);
                    TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2);
                    Object invoke = function2.invoke(r, continuation);
                    ThreadContextKt.restoreThreadContext(context, updateThreadContext);
                    if (invoke != CoroutineSingletons.COROUTINE_SUSPENDED) {
                        continuation.resumeWith(invoke);
                    }
                } catch (Throwable th) {
                    continuation.resumeWith(TweetUtils.createFailure(th));
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }
}
