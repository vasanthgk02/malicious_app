package io.reactivex.internal.util;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.io.Serializable;
import org.apache.fontbox.cmap.CMapParser;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public enum NotificationLite {
    COMPLETE;

    public static final class DisposableNotification implements Serializable {
        public static final long serialVersionUID = -7482590109178395495L;
        public final Disposable upstream;

        public DisposableNotification(Disposable disposable) {
            this.upstream = disposable;
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("NotificationLite.Disposable[");
            outline73.append(this.upstream);
            outline73.append(CMapParser.MARK_END_OF_ARRAY);
            return outline73.toString();
        }
    }

    public static final class ErrorNotification implements Serializable {
        public static final long serialVersionUID = -8759979445933046293L;

        /* renamed from: e  reason: collision with root package name */
        public final Throwable f5935e;

        public ErrorNotification(Throwable th) {
            this.f5935e = th;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ErrorNotification)) {
                return false;
            }
            Throwable th = this.f5935e;
            Throwable th2 = ((ErrorNotification) obj).f5935e;
            if (th == th2 || (th != null && th.equals(th2))) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.f5935e.hashCode();
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("NotificationLite.Error[");
            outline73.append(this.f5935e);
            outline73.append(CMapParser.MARK_END_OF_ARRAY);
            return outline73.toString();
        }
    }

    public static final class SubscriptionNotification implements Serializable {
        public static final long serialVersionUID = -1322257508628817540L;
        public final Subscription upstream;

        public SubscriptionNotification(Subscription subscription) {
            this.upstream = subscription;
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("NotificationLite.Subscription[");
            outline73.append(this.upstream);
            outline73.append(CMapParser.MARK_END_OF_ARRAY);
            return outline73.toString();
        }
    }

    public static <T> boolean accept(Object obj, Subscriber<? super T> subscriber) {
        if (obj == COMPLETE) {
            subscriber.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            subscriber.onError(((ErrorNotification) obj).f5935e);
            return true;
        } else {
            subscriber.onNext(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, Subscriber<? super T> subscriber) {
        if (obj == COMPLETE) {
            subscriber.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            subscriber.onError(((ErrorNotification) obj).f5935e);
            return true;
        } else if (obj instanceof SubscriptionNotification) {
            subscriber.onSubscribe(((SubscriptionNotification) obj).upstream);
            return false;
        } else {
            subscriber.onNext(obj);
            return false;
        }
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object disposable(Disposable disposable) {
        return new DisposableNotification(disposable);
    }

    public static Object error(Throwable th) {
        return new ErrorNotification(th);
    }

    public static Disposable getDisposable(Object obj) {
        return ((DisposableNotification) obj).upstream;
    }

    public static Throwable getError(Object obj) {
        return ((ErrorNotification) obj).f5935e;
    }

    public static Subscription getSubscription(Object obj) {
        return ((SubscriptionNotification) obj).upstream;
    }

    public static <T> T getValue(Object obj) {
        return obj;
    }

    public static boolean isComplete(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean isDisposable(Object obj) {
        return obj instanceof DisposableNotification;
    }

    public static boolean isError(Object obj) {
        return obj instanceof ErrorNotification;
    }

    public static boolean isSubscription(Object obj) {
        return obj instanceof SubscriptionNotification;
    }

    public static <T> Object next(T t) {
        return t;
    }

    public static Object subscription(Subscription subscription) {
        return new SubscriptionNotification(subscription);
    }

    public String toString() {
        return "NotificationLite.Complete";
    }

    public static <T> boolean accept(Object obj, Observer<? super T> observer) {
        if (obj == COMPLETE) {
            observer.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            observer.onError(((ErrorNotification) obj).f5935e);
            return true;
        } else {
            observer.onNext(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, Observer<? super T> observer) {
        if (obj == COMPLETE) {
            observer.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            observer.onError(((ErrorNotification) obj).f5935e);
            return true;
        } else if (obj instanceof DisposableNotification) {
            observer.onSubscribe(((DisposableNotification) obj).upstream);
            return false;
        } else {
            observer.onNext(obj);
            return false;
        }
    }
}
