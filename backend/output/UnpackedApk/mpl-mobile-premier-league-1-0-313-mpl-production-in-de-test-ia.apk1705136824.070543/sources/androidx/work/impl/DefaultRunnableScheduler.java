package androidx.work.impl;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;

public class DefaultRunnableScheduler {
    public final Handler mHandler;

    public DefaultRunnableScheduler() {
        Handler handler;
        Handler handler2;
        Looper mainLooper = Looper.getMainLooper();
        if (VERSION.SDK_INT >= 28) {
            handler = Handler.createAsync(mainLooper);
        } else {
            Class<Handler> cls = Handler.class;
            try {
                handler2 = cls.getDeclaredConstructor(new Class[]{Looper.class, Callback.class, Boolean.TYPE}).newInstance(new Object[]{mainLooper, null, Boolean.TRUE});
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
                handler2 = new Handler(mainLooper);
            } catch (InvocationTargetException e2) {
                Throwable cause = e2.getCause();
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                } else if (cause instanceof Error) {
                    throw ((Error) cause);
                } else {
                    throw new RuntimeException(cause);
                }
            }
            handler = handler2;
        }
        this.mHandler = handler;
    }
}
