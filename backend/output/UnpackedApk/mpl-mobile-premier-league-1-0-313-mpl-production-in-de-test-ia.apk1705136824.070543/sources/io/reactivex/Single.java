package io.reactivex;

import com.twitter.sdk.android.tweetui.TweetUtils;
import io.reactivex.internal.functions.ObjectHelper;

public abstract class Single<T> {
    public final void subscribe(SingleObserver<? super T> singleObserver) {
        ObjectHelper.requireNonNull(singleObserver, "subscriber is null");
        ObjectHelper.requireNonNull(singleObserver, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            subscribeActual(singleObserver);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            TweetUtils.throwIfFatal(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public abstract void subscribeActual(SingleObserver<? super T> singleObserver);
}
