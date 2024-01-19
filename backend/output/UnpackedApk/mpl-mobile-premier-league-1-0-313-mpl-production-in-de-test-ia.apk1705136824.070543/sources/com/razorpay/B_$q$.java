package com.razorpay;

import android.content.Context;
import java.lang.Thread.UncaughtExceptionHandler;

public final class B_$q$ implements UncaughtExceptionHandler {
    public UncaughtExceptionHandler Q_$2$;
    public Context R$$r_;

    public B_$q$(Context context, UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.Q_$2$ = uncaughtExceptionHandler;
        this.R$$r_ = context;
    }

    public final void uncaughtException(Thread thread, final Throwable th) {
        new Thread() {
            public final void run() {
                AnalyticsUtil.reportUncaughtException(th);
                AnalyticsUtil.saveEventsToPreferences(B_$q$.this.R$$r_);
            }
        }.start();
        UncaughtExceptionHandler uncaughtExceptionHandler = this.Q_$2$;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
