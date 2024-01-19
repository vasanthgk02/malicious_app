package com.google.firebase.installations.remote;

import com.google.firebase.installations.Utils;
import java.util.concurrent.TimeUnit;

public class RequestLimiter {
    public static final long MAXIMUM_BACKOFF_DURATION_FOR_CONFIGURATION_ERRORS = TimeUnit.HOURS.toMillis(24);
    public static final long MAXIMUM_BACKOFF_DURATION_FOR_SERVER_ERRORS = TimeUnit.MINUTES.toMillis(30);
    public int attemptCount;
    public long nextRequestTime;
    public final Utils utils = Utils.getInstance();

    public synchronized boolean isRequestAllowed() {
        return this.attemptCount == 0 || this.utils.currentTimeInMillis() > this.nextRequestTime;
    }

    public synchronized void setNextRequestTime(int i) {
        long j;
        boolean z = false;
        if ((i >= 200 && i < 300) || i == 401 || i == 404) {
            synchronized (this) {
                this.attemptCount = 0;
            }
            return;
        }
        this.attemptCount++;
        synchronized (this) {
            if (i == 429 || (i >= 500 && i < 600)) {
                z = true;
            }
            if (!z) {
                j = MAXIMUM_BACKOFF_DURATION_FOR_CONFIGURATION_ERRORS;
            } else {
                double pow = Math.pow(2.0d, (double) this.attemptCount);
                if (this.utils != null) {
                    j = (long) Math.min(pow + ((double) ((long) (Math.random() * 1000.0d))), (double) MAXIMUM_BACKOFF_DURATION_FOR_SERVER_ERRORS);
                } else {
                    throw null;
                }
            }
        }
        this.nextRequestTime = this.utils.currentTimeInMillis() + j;
    }
}
