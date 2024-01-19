package io.reactivex.android.schedulers;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.Scheduler;
import io.reactivex.internal.util.ExceptionHelper;

public final class AndroidSchedulers {
    public static final Scheduler MAIN_THREAD;

    public static final class MainHolder {
        public static final Scheduler DEFAULT = new HandlerScheduler(new Handler(Looper.getMainLooper()), false);
    }

    static {
        try {
            Scheduler scheduler = MainHolder.DEFAULT;
            if (scheduler != null) {
                MAIN_THREAD = scheduler;
                return;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }
}
