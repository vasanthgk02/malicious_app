package androidx.concurrent.futures;

public final class CallbackToFutureAdapter$FutureGarbageCollectedException extends Throwable {
    public CallbackToFutureAdapter$FutureGarbageCollectedException(String str) {
        super(str);
    }

    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
