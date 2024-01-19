package io.reactivex.internal.operators.single;

import com.twitter.sdk.android.tweetui.TweetUtils;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.RunnableDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

public final class SingleFromCallable<T> extends Single<T> {
    public final Callable<? extends T> callable;

    public SingleFromCallable(Callable<? extends T> callable2) {
        this.callable = callable2;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        Runnable runnable = Functions.EMPTY_RUNNABLE;
        ObjectHelper.requireNonNull(runnable, "run is null");
        RunnableDisposable runnableDisposable = new RunnableDisposable(runnable);
        singleObserver.onSubscribe(runnableDisposable);
        if (!runnableDisposable.isDisposed()) {
            try {
                Object call = this.callable.call();
                ObjectHelper.requireNonNull(call, "The callable returned a null value");
                if (!runnableDisposable.isDisposed()) {
                    singleObserver.onSuccess(call);
                }
            } catch (Throwable th) {
                TweetUtils.throwIfFatal(th);
                if (!runnableDisposable.isDisposed()) {
                    singleObserver.onError(th);
                } else {
                    TweetUtils.onError(th);
                }
            }
        }
    }
}
