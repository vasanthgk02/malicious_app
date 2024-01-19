package androidx.work.impl.utils.futures;

import androidx.work.impl.utils.futures.AbstractFuture.Cancellation;
import androidx.work.impl.utils.futures.AbstractFuture.Failure;
import androidx.work.impl.utils.futures.AbstractFuture.SetFuture;
import com.google.common.util.concurrent.ListenableFuture;

public final class SettableFuture<V> extends AbstractFuture<V> {
    public boolean set(V v) {
        if (v == null) {
            v = AbstractFuture.NULL;
        }
        if (!AbstractFuture.ATOMIC_HELPER.casValue(this, null, v)) {
            return false;
        }
        AbstractFuture.complete(this);
        return true;
    }

    public boolean setException(Throwable th) {
        if (th != null) {
            if (!AbstractFuture.ATOMIC_HELPER.casValue(this, null, new Failure(th))) {
                return false;
            }
            AbstractFuture.complete(this);
            return true;
        }
        throw null;
    }

    public boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        SetFuture setFuture;
        Failure failure;
        if (listenableFuture != null) {
            Object obj = this.value;
            if (obj == null) {
                if (listenableFuture.isDone()) {
                    if (!AbstractFuture.ATOMIC_HELPER.casValue(this, null, AbstractFuture.getFutureValue(listenableFuture))) {
                        return false;
                    }
                    AbstractFuture.complete(this);
                } else {
                    setFuture = new SetFuture(this, listenableFuture);
                    if (AbstractFuture.ATOMIC_HELPER.casValue(this, null, setFuture)) {
                        try {
                            listenableFuture.addListener(setFuture, DirectExecutor.INSTANCE);
                        } catch (Throwable unused) {
                            failure = Failure.FALLBACK_INSTANCE;
                        }
                    } else {
                        obj = this.value;
                    }
                }
                return true;
            }
            if (!(obj instanceof Cancellation)) {
                return false;
            }
            listenableFuture.cancel(((Cancellation) obj).wasInterrupted);
            return false;
        }
        throw null;
        AbstractFuture.ATOMIC_HELPER.casValue(this, setFuture, failure);
        return true;
    }
}
