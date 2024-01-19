package io.reactivex.subjects;

import com.twitter.sdk.android.tweetui.TweetUtils;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class PublishSubject<T> extends Subject<T> {
    public static final PublishDisposable[] EMPTY = new PublishDisposable[0];
    public static final PublishDisposable[] TERMINATED = new PublishDisposable[0];
    public Throwable error;
    public final AtomicReference<PublishDisposable<T>[]> subscribers = new AtomicReference<>(EMPTY);

    public static final class PublishDisposable<T> extends AtomicBoolean implements Disposable {
        public static final long serialVersionUID = 3562861878281475070L;
        public final Observer<? super T> downstream;
        public final PublishSubject<T> parent;

        public PublishDisposable(Observer<? super T> observer, PublishSubject<T> publishSubject) {
            this.downstream = observer;
            this.parent = publishSubject;
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.remove(this);
            }
        }
    }

    public void onComplete() {
        PublishDisposable<T>[] publishDisposableArr = this.subscribers.get();
        PublishDisposable<T>[] publishDisposableArr2 = TERMINATED;
        if (publishDisposableArr != publishDisposableArr2) {
            for (PublishDisposable publishDisposable : (PublishDisposable[]) this.subscribers.getAndSet(publishDisposableArr2)) {
                if (!publishDisposable.get()) {
                    publishDisposable.downstream.onComplete();
                }
            }
        }
    }

    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishDisposable<T>[] publishDisposableArr = this.subscribers.get();
        PublishDisposable<T>[] publishDisposableArr2 = TERMINATED;
        if (publishDisposableArr == publishDisposableArr2) {
            TweetUtils.onError(th);
            return;
        }
        this.error = th;
        for (PublishDisposable publishDisposable : (PublishDisposable[]) this.subscribers.getAndSet(publishDisposableArr2)) {
            if (publishDisposable.get()) {
                TweetUtils.onError(th);
            } else {
                publishDisposable.downstream.onError(th);
            }
        }
    }

    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (PublishDisposable publishDisposable : (PublishDisposable[]) this.subscribers.get()) {
            if (!publishDisposable.get()) {
                publishDisposable.downstream.onNext(t);
            }
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (this.subscribers.get() == TERMINATED) {
            disposable.dispose();
        }
    }

    public void remove(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = (PublishDisposable[]) this.subscribers.get();
            if (publishDisposableArr != TERMINATED && publishDisposableArr != EMPTY) {
                int length = publishDisposableArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (publishDisposableArr[i] == publishDisposable) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        publishDisposableArr2 = EMPTY;
                    } else {
                        PublishDisposable[] publishDisposableArr3 = new PublishDisposable[(length - 1)];
                        System.arraycopy(publishDisposableArr, 0, publishDisposableArr3, 0, i);
                        System.arraycopy(publishDisposableArr, i + 1, publishDisposableArr3, i, (length - i) - 1);
                        publishDisposableArr2 = publishDisposableArr3;
                    }
                } else {
                    return;
                }
            }
        } while (!this.subscribers.compareAndSet(publishDisposableArr, publishDisposableArr2));
    }

    public void subscribeActual(Observer<? super T> observer) {
        boolean z;
        PublishDisposable publishDisposable = new PublishDisposable(observer, this);
        observer.onSubscribe(publishDisposable);
        while (true) {
            PublishDisposable[] publishDisposableArr = (PublishDisposable[]) this.subscribers.get();
            z = false;
            if (publishDisposableArr != TERMINATED) {
                int length = publishDisposableArr.length;
                PublishDisposable[] publishDisposableArr2 = new PublishDisposable[(length + 1)];
                System.arraycopy(publishDisposableArr, 0, publishDisposableArr2, 0, length);
                publishDisposableArr2[length] = publishDisposable;
                if (this.subscribers.compareAndSet(publishDisposableArr, publishDisposableArr2)) {
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (!z) {
            Throwable th = this.error;
            if (th != null) {
                observer.onError(th);
            } else {
                observer.onComplete();
            }
        } else if (publishDisposable.get()) {
            remove(publishDisposable);
        }
    }
}
