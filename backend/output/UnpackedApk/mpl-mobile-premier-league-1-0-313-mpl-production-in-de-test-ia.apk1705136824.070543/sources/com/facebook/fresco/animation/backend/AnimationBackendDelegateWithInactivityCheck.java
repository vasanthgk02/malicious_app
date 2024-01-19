package com.facebook.fresco.animation.backend;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.common.time.MonotonicClock;
import com.facebook.fresco.animation.backend.AnimationBackend;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AnimationBackendDelegateWithInactivityCheck<T extends AnimationBackend> extends AnimationBackendDelegate<T> {
    public long mInactivityCheckPollingTimeMs = 1000;
    public boolean mInactivityCheckScheduled = false;
    public InactivityListener mInactivityListener;
    public long mInactivityThresholdMs = 2000;
    public final Runnable mIsInactiveCheck = new Runnable() {
        public void run() {
            synchronized (AnimationBackendDelegateWithInactivityCheck.this) {
                boolean z = false;
                AnimationBackendDelegateWithInactivityCheck.this.mInactivityCheckScheduled = false;
                AnimationBackendDelegateWithInactivityCheck animationBackendDelegateWithInactivityCheck = AnimationBackendDelegateWithInactivityCheck.this;
                if (animationBackendDelegateWithInactivityCheck.mMonotonicClock.now() - animationBackendDelegateWithInactivityCheck.mLastDrawnTimeMs > animationBackendDelegateWithInactivityCheck.mInactivityThresholdMs) {
                    z = true;
                }
                if (!z) {
                    AnimationBackendDelegateWithInactivityCheck.this.maybeScheduleInactivityCheck();
                } else if (AnimationBackendDelegateWithInactivityCheck.this.mInactivityListener != null) {
                    AnimationBackendDelegateWithInactivityCheck.this.mInactivityListener.onInactive();
                }
            }
        }
    };
    public long mLastDrawnTimeMs;
    public final MonotonicClock mMonotonicClock;
    public final ScheduledExecutorService mScheduledExecutorServiceForUiThread;

    public interface InactivityListener {
        void onInactive();
    }

    public AnimationBackendDelegateWithInactivityCheck(T t, InactivityListener inactivityListener, MonotonicClock monotonicClock, ScheduledExecutorService scheduledExecutorService) {
        super(t);
        this.mInactivityListener = inactivityListener;
        this.mMonotonicClock = monotonicClock;
        this.mScheduledExecutorServiceForUiThread = scheduledExecutorService;
    }

    public boolean drawFrame(Drawable drawable, Canvas canvas, int i) {
        this.mLastDrawnTimeMs = this.mMonotonicClock.now();
        boolean drawFrame = super.drawFrame(drawable, canvas, i);
        maybeScheduleInactivityCheck();
        return drawFrame;
    }

    public final synchronized void maybeScheduleInactivityCheck() {
        if (!this.mInactivityCheckScheduled) {
            this.mInactivityCheckScheduled = true;
            this.mScheduledExecutorServiceForUiThread.schedule(this.mIsInactiveCheck, this.mInactivityCheckPollingTimeMs, TimeUnit.MILLISECONDS);
        }
    }
}
