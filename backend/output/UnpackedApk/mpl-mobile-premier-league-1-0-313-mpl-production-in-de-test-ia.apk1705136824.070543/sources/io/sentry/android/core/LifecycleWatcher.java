package io.sentry.android.core;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.razorpay.AnalyticsConstants;
import io.sentry.Breadcrumb;
import io.sentry.IHub;
import io.sentry.SentryLevel;
import io.sentry.transport.CurrentDateProvider;
import io.sentry.transport.ICurrentDateProvider;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public final class LifecycleWatcher implements DefaultLifecycleObserver {
    public final ICurrentDateProvider currentDateProvider;
    public final boolean enableAppLifecycleBreadcrumbs;
    public final boolean enableSessionTracking;
    public final IHub hub;
    public final AtomicLong lastUpdatedSession;
    public final AtomicBoolean runningSession;
    public final long sessionIntervalMillis;
    public final Timer timer;
    public TimerTask timerTask;

    public LifecycleWatcher(IHub iHub, long j, boolean z, boolean z2) {
        this(iHub, j, z, z2, CurrentDateProvider.getInstance());
    }

    private void addAppBreadcrumb(String str) {
        if (this.enableAppLifecycleBreadcrumbs) {
            Breadcrumb breadcrumb = new Breadcrumb();
            breadcrumb.setType(NotificationCompat.CATEGORY_NAVIGATION);
            breadcrumb.setData("state", str);
            breadcrumb.setCategory("app.lifecycle");
            breadcrumb.setLevel(SentryLevel.INFO);
            this.hub.addBreadcrumb(breadcrumb);
        }
    }

    /* access modifiers changed from: private */
    public void addSessionBreadcrumb(String str) {
        Breadcrumb breadcrumb = new Breadcrumb();
        breadcrumb.setType("session");
        breadcrumb.setData("state", str);
        breadcrumb.setCategory("app.lifecycle");
        breadcrumb.setLevel(SentryLevel.INFO);
        this.hub.addBreadcrumb(breadcrumb);
    }

    private void cancelTask() {
        TimerTask timerTask2 = this.timerTask;
        if (timerTask2 != null) {
            timerTask2.cancel();
            this.timerTask = null;
        }
    }

    private void scheduleEndSession() {
        cancelTask();
        AnonymousClass1 r0 = new TimerTask() {
            public void run() {
                LifecycleWatcher.this.addSessionBreadcrumb(AnalyticsConstants.END);
                LifecycleWatcher.this.hub.endSession();
                LifecycleWatcher.this.runningSession.set(false);
            }
        };
        this.timerTask = r0;
        this.timer.schedule(r0, this.sessionIntervalMillis);
    }

    private void startSession() {
        if (this.enableSessionTracking) {
            cancelTask();
            long currentTimeMillis = this.currentDateProvider.getCurrentTimeMillis();
            long j = this.lastUpdatedSession.get();
            if (j == 0 || j + this.sessionIntervalMillis <= currentTimeMillis) {
                addSessionBreadcrumb(AnalyticsConstants.START);
                this.hub.startSession();
                this.runningSession.set(true);
            }
            this.lastUpdatedSession.set(currentTimeMillis);
        }
    }

    public TimerTask getTimerTask() {
        return this.timerTask;
    }

    public AtomicBoolean isRunningSession() {
        return this.runningSession;
    }

    public void onCreate(LifecycleOwner lifecycleOwner) {
    }

    public void onDestroy(LifecycleOwner lifecycleOwner) {
    }

    public void onPause(LifecycleOwner lifecycleOwner) {
    }

    public void onResume(LifecycleOwner lifecycleOwner) {
    }

    public void onStart(LifecycleOwner lifecycleOwner) {
        startSession();
        addAppBreadcrumb("foreground");
    }

    public void onStop(LifecycleOwner lifecycleOwner) {
        if (this.enableSessionTracking) {
            this.lastUpdatedSession.set(this.currentDateProvider.getCurrentTimeMillis());
            scheduleEndSession();
        }
        addAppBreadcrumb("background");
    }

    public LifecycleWatcher(IHub iHub, long j, boolean z, boolean z2, ICurrentDateProvider iCurrentDateProvider) {
        this.lastUpdatedSession = new AtomicLong(0);
        this.timer = new Timer(true);
        this.runningSession = new AtomicBoolean();
        this.sessionIntervalMillis = j;
        this.enableSessionTracking = z;
        this.enableAppLifecycleBreadcrumbs = z2;
        this.hub = iHub;
        this.currentDateProvider = iCurrentDateProvider;
    }
}
