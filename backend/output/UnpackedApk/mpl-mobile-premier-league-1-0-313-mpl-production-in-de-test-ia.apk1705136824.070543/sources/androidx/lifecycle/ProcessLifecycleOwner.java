package androidx.lifecycle;

import android.os.Handler;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.ReportFragment.ActivityInitializationListener;

public class ProcessLifecycleOwner implements LifecycleOwner {
    public static final ProcessLifecycleOwner sInstance = new ProcessLifecycleOwner();
    public Runnable mDelayedPauseRunnable = new Runnable() {
        public void run() {
            ProcessLifecycleOwner processLifecycleOwner = ProcessLifecycleOwner.this;
            if (processLifecycleOwner.mResumedCounter == 0) {
                processLifecycleOwner.mPauseSent = true;
                processLifecycleOwner.mRegistry.handleLifecycleEvent(Event.ON_PAUSE);
            }
            ProcessLifecycleOwner processLifecycleOwner2 = ProcessLifecycleOwner.this;
            if (processLifecycleOwner2.mStartedCounter == 0 && processLifecycleOwner2.mPauseSent) {
                processLifecycleOwner2.mRegistry.handleLifecycleEvent(Event.ON_STOP);
                processLifecycleOwner2.mStopSent = true;
            }
        }
    };
    public Handler mHandler;
    public ActivityInitializationListener mInitializationListener = new ActivityInitializationListener() {
    };
    public boolean mPauseSent = true;
    public final LifecycleRegistry mRegistry = new LifecycleRegistry(this);
    public int mResumedCounter = 0;
    public int mStartedCounter = 0;
    public boolean mStopSent = true;

    public void activityResumed() {
        int i = this.mResumedCounter + 1;
        this.mResumedCounter = i;
        if (i != 1) {
            return;
        }
        if (this.mPauseSent) {
            this.mRegistry.handleLifecycleEvent(Event.ON_RESUME);
            this.mPauseSent = false;
            return;
        }
        this.mHandler.removeCallbacks(this.mDelayedPauseRunnable);
    }

    public void activityStarted() {
        int i = this.mStartedCounter + 1;
        this.mStartedCounter = i;
        if (i == 1 && this.mStopSent) {
            this.mRegistry.handleLifecycleEvent(Event.ON_START);
            this.mStopSent = false;
        }
    }

    public Lifecycle getLifecycle() {
        return this.mRegistry;
    }
}
