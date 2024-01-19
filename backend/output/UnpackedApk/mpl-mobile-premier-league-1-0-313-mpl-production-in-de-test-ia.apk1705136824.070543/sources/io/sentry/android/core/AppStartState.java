package io.sentry.android.core;

import android.os.SystemClock;
import java.util.Date;

public final class AppStartState {
    public static AppStartState instance = new AppStartState();
    public Long appStartEndMillis;
    public Long appStartMillis;
    public Date appStartTime;
    public boolean coldStart;

    public static AppStartState getInstance() {
        return instance;
    }

    public synchronized Long getAppStartInterval() {
        if (this.appStartMillis != null) {
            if (this.appStartEndMillis != null) {
                return Long.valueOf(this.appStartEndMillis.longValue() - this.appStartMillis.longValue());
            }
        }
        return null;
    }

    public Date getAppStartTime() {
        return this.appStartTime;
    }

    public boolean isColdStart() {
        return this.coldStart;
    }

    public void resetInstance() {
        instance = new AppStartState();
    }

    public synchronized void setAppStartEnd() {
        setAppStartEnd(SystemClock.uptimeMillis());
    }

    public synchronized void setAppStartTime(long j, Date date) {
        if (this.appStartTime == null || this.appStartMillis == null) {
            this.appStartTime = date;
            this.appStartMillis = Long.valueOf(j);
        }
    }

    public synchronized void setColdStart(boolean z) {
        this.coldStart = z;
    }

    public void setAppStartEnd(long j) {
        this.appStartEndMillis = Long.valueOf(j);
    }
}
