package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleSubscribeOn<T> extends Single<T> {
    public final Scheduler scheduler;
    public final Single<? extends T> source;

    public static final class SubscribeOnObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {
        public static final long serialVersionUID = 7000911171163930287L;
        public final SingleObserver<? super T> downstream;
        public final Single<? extends T> source;
        public final SequentialDisposable task = new SequentialDisposable();

        public SubscribeOnObserver(SingleObserver<? super T> singleObserver, Single<? extends T> single) {
            this.downstream = singleObserver;
            this.source = single;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
            SequentialDisposable sequentialDisposable = this.task;
            if (sequentialDisposable != null) {
                DisposableHelper.dispose(sequentialDisposable);
                return;
            }
            throw null;
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }

        public void run() {
            this.source.subscribe(this);
        }
    }

    public SingleSubscribeOn(Single<? extends T> single, Scheduler scheduler2) {
        this.source = single;
        this.scheduler = scheduler2;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(singleObserver, this.source);
        singleObserver.onSubscribe(subscribeOnObserver);
        Disposable scheduleDirect = this.scheduler.scheduleDirect(subscribeOnObserver);
        SequentialDisposable sequentialDisposable = subscribeOnObserver.task;
        if (sequentialDisposable != null) {
            DisposableHelper.replace(sequentialDisposable, scheduleDirect);
            return;
        }
        throw null;
    }
}
