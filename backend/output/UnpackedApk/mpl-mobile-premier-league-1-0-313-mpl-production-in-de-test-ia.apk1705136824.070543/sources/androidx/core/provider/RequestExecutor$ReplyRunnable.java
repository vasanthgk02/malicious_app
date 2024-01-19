package androidx.core.provider;

import android.os.Handler;
import androidx.core.util.Consumer;
import java.util.concurrent.Callable;

public class RequestExecutor$ReplyRunnable<T> implements Runnable {
    public Callable<T> mCallable;
    public Consumer<T> mConsumer;
    public Handler mHandler;

    public RequestExecutor$ReplyRunnable(Handler handler, Callable<T> callable, Consumer<T> consumer) {
        this.mCallable = callable;
        this.mConsumer = consumer;
        this.mHandler = handler;
    }

    public void run() {
        final T t;
        try {
            t = this.mCallable.call();
        } catch (Exception unused) {
            t = null;
        }
        final Consumer<T> consumer = this.mConsumer;
        this.mHandler.post(new Runnable(this) {
            public void run() {
                consumer.accept(t);
            }
        });
    }
}
