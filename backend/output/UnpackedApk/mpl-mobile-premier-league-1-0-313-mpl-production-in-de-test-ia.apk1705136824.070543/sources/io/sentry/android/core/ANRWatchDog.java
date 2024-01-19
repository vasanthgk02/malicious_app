package io.sentry.android.core;

import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.Context;
import android.os.Debug;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public final class ANRWatchDog extends Thread {
    public final ANRListener anrListener;
    public final Context context;
    public final ILogger logger;
    public final boolean reportInDebug;
    public final AtomicBoolean reported;
    public final AtomicLong tick;
    public final Runnable ticker;
    public final long timeoutIntervalMillis;
    public final IHandler uiHandler;

    public interface ANRListener {
        void onAppNotResponding(ApplicationNotResponding applicationNotResponding);
    }

    public ANRWatchDog(long j, boolean z, ANRListener aNRListener, ILogger iLogger, Context context2) {
        this(j, z, aNRListener, iLogger, new MainLooperHandler(), context2);
    }

    public /* synthetic */ void lambda$new$0$ANRWatchDog() {
        this.tick.set(0);
        this.reported.set(false);
    }

    public void run() {
        boolean z;
        setName("|ANR-WatchDog|");
        long j = this.timeoutIntervalMillis;
        while (!isInterrupted()) {
            boolean z2 = this.tick.get() == 0;
            this.tick.addAndGet(j);
            if (z2) {
                this.uiHandler.post(this.ticker);
            }
            try {
                Thread.sleep(j);
                if (this.tick.get() != 0 && !this.reported.get()) {
                    if (this.reportInDebug || (!Debug.isDebuggerConnected() && !Debug.waitingForDebugger())) {
                        ActivityManager activityManager = (ActivityManager) this.context.getSystemService("activity");
                        if (activityManager != null) {
                            List<ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
                            if (processesInErrorState != null) {
                                Iterator<ProcessErrorStateInfo> it = processesInErrorState.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        if (it.next().condition == 2) {
                                            z = true;
                                            break;
                                        }
                                    } else {
                                        z = false;
                                        break;
                                    }
                                }
                                if (!z) {
                                }
                            }
                        }
                        this.logger.log(SentryLevel.INFO, (String) "Raising ANR", new Object[0]);
                        StringBuilder sb = new StringBuilder();
                        sb.append("Application Not Responding for at least ");
                        this.anrListener.onAppNotResponding(new ApplicationNotResponding(GeneratedOutlineSupport.outline58(sb, this.timeoutIntervalMillis, " ms."), this.uiHandler.getThread()));
                        j = this.timeoutIntervalMillis;
                        this.reported.set(true);
                    } else {
                        this.logger.log(SentryLevel.DEBUG, (String) "An ANR was detected but ignored because the debugger is connected.", new Object[0]);
                        this.reported.set(true);
                    }
                }
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                this.logger.log(SentryLevel.WARNING, (String) "Interrupted: %s", e2.getMessage());
                return;
            }
        }
    }

    public ANRWatchDog(long j, boolean z, ANRListener aNRListener, ILogger iLogger, IHandler iHandler, Context context2) {
        this.tick = new AtomicLong(0);
        this.reported = new AtomicBoolean(false);
        this.ticker = new Runnable() {
            public final void run() {
                ANRWatchDog.this.lambda$new$0$ANRWatchDog();
            }
        };
        this.reportInDebug = z;
        this.anrListener = aNRListener;
        this.timeoutIntervalMillis = j;
        this.logger = iLogger;
        this.uiHandler = iHandler;
        this.context = context2;
    }
}
