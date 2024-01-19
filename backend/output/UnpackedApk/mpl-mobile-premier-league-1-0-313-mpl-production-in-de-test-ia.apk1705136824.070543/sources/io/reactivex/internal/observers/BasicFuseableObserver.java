package io.reactivex.internal.observers;

import com.twitter.sdk.android.tweetui.TweetUtils;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;

public abstract class BasicFuseableObserver<T, R> implements Observer<T>, QueueDisposable<R> {
    public boolean done;
    public final Observer<? super R> downstream;
    public QueueDisposable<T> qd;
    public int sourceMode;
    public Disposable upstream;

    public BasicFuseableObserver(Observer<? super R> observer) {
        this.downstream = observer;
    }

    public void clear() {
        this.qd.clear();
    }

    public void dispose() {
        this.upstream.dispose();
    }

    public boolean isEmpty() {
        return this.qd.isEmpty();
    }

    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable th) {
        if (this.done) {
            TweetUtils.onError(th);
            return;
        }
        this.done = true;
        this.downstream.onError(th);
    }

    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.upstream, disposable)) {
            this.upstream = disposable;
            if (disposable instanceof QueueDisposable) {
                this.qd = (QueueDisposable) disposable;
            }
            this.downstream.onSubscribe(this);
        }
    }
}
