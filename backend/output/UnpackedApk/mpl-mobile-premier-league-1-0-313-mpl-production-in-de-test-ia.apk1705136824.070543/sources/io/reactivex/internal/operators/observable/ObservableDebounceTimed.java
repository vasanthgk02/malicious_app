package io.reactivex.internal.operators.observable;

import com.twitter.sdk.android.tweetui.TweetUtils;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableDebounceTimed<T> extends AbstractObservableWithUpstream<T, T> {
    public final Scheduler scheduler;
    public final long timeout;
    public final TimeUnit unit;

    public static final class DebounceEmitter<T> extends AtomicReference<Disposable> implements Runnable, Disposable {
        public static final long serialVersionUID = 6812032969491025141L;
        public final long idx;
        public final AtomicBoolean once = new AtomicBoolean();
        public final DebounceTimedObserver<T> parent;
        public final T value;

        public DebounceEmitter(T t, long j, DebounceTimedObserver<T> debounceTimedObserver) {
            this.value = t;
            this.idx = j;
            this.parent = debounceTimedObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public void run() {
            if (this.once.compareAndSet(false, true)) {
                DebounceTimedObserver<T> debounceTimedObserver = this.parent;
                long j = this.idx;
                T t = this.value;
                if (j == debounceTimedObserver.index) {
                    debounceTimedObserver.downstream.onNext(t);
                    DisposableHelper.dispose(this);
                }
            }
        }
    }

    public static final class DebounceTimedObserver<T> implements Observer<T>, Disposable {
        public boolean done;
        public final Observer<? super T> downstream;
        public volatile long index;
        public final long timeout;
        public Disposable timer;
        public final TimeUnit unit;
        public Disposable upstream;
        public final Worker worker;

        public DebounceTimedObserver(Observer<? super T> observer, long j, TimeUnit timeUnit, Worker worker2) {
            this.downstream = observer;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = worker2;
        }

        public void dispose() {
            this.upstream.dispose();
            this.worker.dispose();
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                Disposable disposable = this.timer;
                if (disposable != null) {
                    disposable.dispose();
                }
                DebounceEmitter debounceEmitter = (DebounceEmitter) disposable;
                if (debounceEmitter != null) {
                    debounceEmitter.run();
                }
                this.downstream.onComplete();
                this.worker.dispose();
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                TweetUtils.onError(th);
                return;
            }
            Disposable disposable = this.timer;
            if (disposable != null) {
                disposable.dispose();
            }
            this.done = true;
            this.downstream.onError(th);
            this.worker.dispose();
        }

        public void onNext(T t) {
            if (!this.done) {
                long j = this.index + 1;
                this.index = j;
                Disposable disposable = this.timer;
                if (disposable != null) {
                    disposable.dispose();
                }
                DebounceEmitter debounceEmitter = new DebounceEmitter(t, j, this);
                this.timer = debounceEmitter;
                DisposableHelper.replace(debounceEmitter, this.worker.schedule(debounceEmitter, this.timeout, this.unit));
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableDebounceTimed(Observable<T> observable, long j, TimeUnit timeUnit, Scheduler scheduler2) {
        super(observable);
        this.timeout = j;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        Observable<T> observable = this.source;
        DebounceTimedObserver debounceTimedObserver = new DebounceTimedObserver(new SerializedObserver(observer), this.timeout, this.unit, this.scheduler.createWorker());
        observable.subscribe(debounceTimedObserver);
    }
}
