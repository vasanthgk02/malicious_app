package io.reactivex;

import com.twitter.sdk.android.tweetui.TweetUtils;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableDebounceTimed;
import io.reactivex.internal.operators.observable.ObservableObserveOn;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

public abstract class Observable<T> {
    public final Observable<T> debounce(long j, TimeUnit timeUnit) {
        Scheduler scheduler = Schedulers.COMPUTATION;
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        ObservableDebounceTimed observableDebounceTimed = new ObservableDebounceTimed(this, j, timeUnit, scheduler);
        return observableDebounceTimed;
    }

    public final Observable<T> observeOn(Scheduler scheduler) {
        int i = Flowable.BUFFER_SIZE;
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        if (i > 0) {
            return new ObservableObserveOn(this, scheduler, false, i);
        }
        throw new IllegalArgumentException("bufferSize" + " > 0 required but it was " + i);
    }

    public final void subscribe(Observer<? super T> observer) {
        ObjectHelper.requireNonNull(observer, "observer is null");
        try {
            ObjectHelper.requireNonNull(observer, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            subscribeActual(observer);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            TweetUtils.throwIfFatal(th);
            TweetUtils.onError(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public abstract void subscribeActual(Observer<? super T> observer);
}
