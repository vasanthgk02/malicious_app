package androidx.concurrent.futures;

import com.android.tools.r8.GeneratedOutlineSupport;

public final class CallbackToFutureAdapter$Completer<T> {
    public boolean attemptedSetting;
    public ResolvableFuture<Void> cancellationFuture = new ResolvableFuture<>();
    public CallbackToFutureAdapter$SafeFuture<T> future;
    public Object tag;

    public void finalize() {
        CallbackToFutureAdapter$SafeFuture<T> callbackToFutureAdapter$SafeFuture = this.future;
        if (callbackToFutureAdapter$SafeFuture != null && !callbackToFutureAdapter$SafeFuture.isDone()) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("The completer object was garbage collected - this future would otherwise never complete. The tag was: ");
            outline73.append(this.tag);
            callbackToFutureAdapter$SafeFuture.delegate.setException(new CallbackToFutureAdapter$FutureGarbageCollectedException(outline73.toString()));
        }
        if (!this.attemptedSetting) {
            ResolvableFuture<Void> resolvableFuture = this.cancellationFuture;
            if (resolvableFuture != null) {
                resolvableFuture.set(null);
            }
        }
    }

    public boolean set(T t) {
        boolean z = true;
        this.attemptedSetting = true;
        CallbackToFutureAdapter$SafeFuture<T> callbackToFutureAdapter$SafeFuture = this.future;
        if (callbackToFutureAdapter$SafeFuture == null || !callbackToFutureAdapter$SafeFuture.delegate.set(t)) {
            z = false;
        }
        if (z) {
            this.tag = null;
            this.future = null;
            this.cancellationFuture = null;
        }
        return z;
    }

    public boolean setException(Throwable th) {
        boolean z = true;
        this.attemptedSetting = true;
        CallbackToFutureAdapter$SafeFuture<T> callbackToFutureAdapter$SafeFuture = this.future;
        if (callbackToFutureAdapter$SafeFuture == null || !callbackToFutureAdapter$SafeFuture.delegate.setException(th)) {
            z = false;
        }
        if (z) {
            this.tag = null;
            this.future = null;
            this.cancellationFuture = null;
        }
        return z;
    }
}
