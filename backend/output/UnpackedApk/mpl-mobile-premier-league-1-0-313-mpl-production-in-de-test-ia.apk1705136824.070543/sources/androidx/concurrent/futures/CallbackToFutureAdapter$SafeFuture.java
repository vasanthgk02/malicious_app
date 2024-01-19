package androidx.concurrent.futures;

import androidx.concurrent.futures.AbstractResolvableFuture.Cancellation;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.fontbox.cmap.CMapParser;

public final class CallbackToFutureAdapter$SafeFuture<T> implements ListenableFuture<T> {
    public final WeakReference<CallbackToFutureAdapter$Completer<T>> completerWeakReference;
    public final AbstractResolvableFuture<T> delegate = new AbstractResolvableFuture<T>() {
        public String pendingToString() {
            CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = (CallbackToFutureAdapter$Completer) CallbackToFutureAdapter$SafeFuture.this.completerWeakReference.get();
            if (callbackToFutureAdapter$Completer == null) {
                return "Completer object has been garbage collected, future will fail soon";
            }
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("tag=[");
            outline73.append(callbackToFutureAdapter$Completer.tag);
            outline73.append(CMapParser.MARK_END_OF_ARRAY);
            return outline73.toString();
        }
    };

    public CallbackToFutureAdapter$SafeFuture(CallbackToFutureAdapter$Completer<T> callbackToFutureAdapter$Completer) {
        this.completerWeakReference = new WeakReference<>(callbackToFutureAdapter$Completer);
    }

    public void addListener(Runnable runnable, Executor executor) {
        this.delegate.addListener(runnable, executor);
    }

    public boolean cancel(boolean z) {
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = (CallbackToFutureAdapter$Completer) this.completerWeakReference.get();
        boolean cancel = this.delegate.cancel(z);
        if (cancel && callbackToFutureAdapter$Completer != null) {
            callbackToFutureAdapter$Completer.tag = null;
            callbackToFutureAdapter$Completer.future = null;
            callbackToFutureAdapter$Completer.cancellationFuture.set(null);
        }
        return cancel;
    }

    public T get() throws InterruptedException, ExecutionException {
        return this.delegate.get();
    }

    public boolean isCancelled() {
        return this.delegate.value instanceof Cancellation;
    }

    public boolean isDone() {
        return this.delegate.isDone();
    }

    public String toString() {
        return this.delegate.toString();
    }

    public T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.delegate.get(j, timeUnit);
    }
}
