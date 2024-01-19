package io.hansel.core;

import io.hansel.core.logger.HSLLogger;
import io.hansel.pebbletracesdk.EndGame;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.ref.WeakReference;

public class c implements UncaughtExceptionHandler {

    /* renamed from: b  reason: collision with root package name */
    public static WeakReference<EndGame> f5118b;

    /* renamed from: a  reason: collision with root package name */
    public UncaughtExceptionHandler f5119a = Thread.getDefaultUncaughtExceptionHandler();

    public static void a(EndGame endGame) {
        f5118b = new WeakReference<>(endGame);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        try {
            WeakReference<EndGame> weakReference = f5118b;
            if (!(weakReference == null || weakReference.get() == null)) {
                ((EndGame) f5118b.get()).lastMove(th);
            }
        } catch (Exception e2) {
            HSLLogger.printStackTrace(e2);
        }
        this.f5119a.uncaughtException(thread, th);
    }
}
