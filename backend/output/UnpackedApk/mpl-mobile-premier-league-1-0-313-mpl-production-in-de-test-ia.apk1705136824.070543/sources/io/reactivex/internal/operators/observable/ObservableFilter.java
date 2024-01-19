package io.reactivex.internal.operators.observable;

import com.twitter.sdk.android.tweetui.TweetUtils;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.observers.BasicFuseableObserver;

public final class ObservableFilter<T> extends AbstractObservableWithUpstream<T, T> {
    public final Predicate<? super T> predicate;

    public static final class FilterObserver<T> extends BasicFuseableObserver<T, T> {
        public final Predicate<? super T> filter;

        public FilterObserver(Observer<? super T> observer, Predicate<? super T> predicate) {
            super(observer);
            this.filter = predicate;
        }

        public void onNext(T t) {
            if (this.sourceMode == 0) {
                try {
                    if (this.filter.test(t)) {
                        this.downstream.onNext(t);
                    }
                } catch (Throwable th) {
                    TweetUtils.throwIfFatal(th);
                    this.upstream.dispose();
                    onError(th);
                }
            } else {
                this.downstream.onNext(null);
            }
        }

        public T poll() throws Exception {
            T poll;
            do {
                poll = this.qd.poll();
                if (poll == null) {
                    break;
                }
            } while (!this.filter.test(poll));
            return poll;
        }

        public int requestFusion(int i) {
            QueueDisposable<T> queueDisposable = this.qd;
            if (queueDisposable == null || (i & 4) != 0) {
                return 0;
            }
            int requestFusion = queueDisposable.requestFusion(i);
            if (requestFusion == 0) {
                return requestFusion;
            }
            this.sourceMode = requestFusion;
            return requestFusion;
        }
    }

    public ObservableFilter(Observable<T> observable, Predicate<? super T> predicate2) {
        super(observable);
        this.predicate = predicate2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new FilterObserver(observer, this.predicate));
    }
}
