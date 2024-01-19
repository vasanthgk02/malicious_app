package androidx.lifecycle;

import android.os.Handler;
import androidx.lifecycle.Lifecycle.Event;

public class ServiceLifecycleDispatcher {
    public final Handler mHandler = new Handler();
    public DispatchRunnable mLastDispatchRunnable;
    public final LifecycleRegistry mRegistry;

    public static class DispatchRunnable implements Runnable {
        public final Event mEvent;
        public final LifecycleRegistry mRegistry;
        public boolean mWasExecuted = false;

        public DispatchRunnable(LifecycleRegistry lifecycleRegistry, Event event) {
            this.mRegistry = lifecycleRegistry;
            this.mEvent = event;
        }

        public void run() {
            if (!this.mWasExecuted) {
                this.mRegistry.handleLifecycleEvent(this.mEvent);
                this.mWasExecuted = true;
            }
        }
    }

    public ServiceLifecycleDispatcher(LifecycleOwner lifecycleOwner) {
        this.mRegistry = new LifecycleRegistry(lifecycleOwner);
    }

    public final void postDispatchRunnable(Event event) {
        DispatchRunnable dispatchRunnable = this.mLastDispatchRunnable;
        if (dispatchRunnable != null) {
            dispatchRunnable.run();
        }
        DispatchRunnable dispatchRunnable2 = new DispatchRunnable(this.mRegistry, event);
        this.mLastDispatchRunnable = dispatchRunnable2;
        this.mHandler.postAtFrontOfQueue(dispatchRunnable2);
    }
}
