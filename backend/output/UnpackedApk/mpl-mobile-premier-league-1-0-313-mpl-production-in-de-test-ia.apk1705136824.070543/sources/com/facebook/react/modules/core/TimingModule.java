package com.facebook.react.modules.core;

import com.facebook.fbreact.specs.NativeTimingSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.jstasks.HeadlessJsTaskContext;
import com.facebook.react.jstasks.HeadlessJsTaskEventListener;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.JavaTimerManager.Timer;
import com.facebook.react.modules.core.ReactChoreographer.CallbackType;
import java.util.Iterator;

@ReactModule(name = "Timing")
public final class TimingModule extends NativeTimingSpec implements LifecycleEventListener, HeadlessJsTaskEventListener {
    public static final String NAME = "Timing";
    public final JavaTimerManager mJavaTimerManager;

    public class BridgeTimerManager implements JavaScriptTimerManager {
        public BridgeTimerManager() {
        }
    }

    public TimingModule(ReactApplicationContext reactApplicationContext, DevSupportManager devSupportManager) {
        super(reactApplicationContext);
        this.mJavaTimerManager = new JavaTimerManager(reactApplicationContext, new BridgeTimerManager(), ReactChoreographer.getInstance(), devSupportManager);
    }

    public void createTimer(double d2, double d3, double d4, boolean z) {
        int i = (int) d2;
        int i2 = (int) d3;
        JavaTimerManager javaTimerManager = this.mJavaTimerManager;
        if (javaTimerManager != null) {
            Class cls = JSTimers.class;
            long currentTimeMillis = System.currentTimeMillis();
            long j = (long) d4;
            if (javaTimerManager.mDevSupportManager.getDevSupportEnabled() && Math.abs(j - currentTimeMillis) > 60000) {
                ReactApplicationContext access$200 = TimingModule.this.getReactApplicationContextIfActiveOrWarn();
                if (access$200 != null) {
                    ((JSTimers) access$200.getJSModule(cls)).emitTimeDriftWarning("Debugger and device times have drifted by more than 60s. Please correct this by running adb shell \"date `date +%m%d%H%M%Y.%S`\" on your debugger machine.");
                }
            }
            long max = Math.max(0, (j - currentTimeMillis) + ((long) i2));
            if (i2 != 0 || z) {
                javaTimerManager.createTimer(i, max, z);
                return;
            }
            WritableArray createArray = Arguments.createArray();
            createArray.pushInt(i);
            ReactApplicationContext access$000 = TimingModule.this.getReactApplicationContextIfActiveOrWarn();
            if (access$000 != null) {
                ((JSTimers) access$000.getJSModule(cls)).callTimers(createArray);
                return;
            }
            return;
        }
        throw null;
    }

    public void deleteTimer(double d2) {
        this.mJavaTimerManager.deleteTimer((int) d2);
    }

    public String getName() {
        return NAME;
    }

    public boolean hasActiveTimersInRange(long j) {
        boolean z;
        JavaTimerManager javaTimerManager = this.mJavaTimerManager;
        synchronized (javaTimerManager.mTimerGuard) {
            Timer peek = javaTimerManager.mTimers.peek();
            if (peek != null) {
                if (!peek.mRepeat && ((long) peek.mInterval) < j) {
                    return true;
                }
                Iterator<Timer> it = javaTimerManager.mTimers.iterator();
                while (it.hasNext()) {
                    Timer next = it.next();
                    if (next.mRepeat || ((long) next.mInterval) >= j) {
                        z = false;
                        continue;
                    } else {
                        z = true;
                        continue;
                    }
                    if (z) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public void initialize() {
        getReactApplicationContext().addLifecycleEventListener(this);
        HeadlessJsTaskContext.getInstance(getReactApplicationContext()).mHeadlessJsTaskEventListeners.add(this);
    }

    public void onCatalystInstanceDestroy() {
        HeadlessJsTaskContext.getInstance(getReactApplicationContext()).mHeadlessJsTaskEventListeners.remove(this);
        JavaTimerManager javaTimerManager = this.mJavaTimerManager;
        javaTimerManager.clearFrameCallback();
        if (javaTimerManager.mFrameIdleCallbackPosted) {
            javaTimerManager.mReactChoreographer.removeFrameCallback(CallbackType.IDLE_EVENT, javaTimerManager.mIdleFrameCallback);
            javaTimerManager.mFrameIdleCallbackPosted = false;
        }
    }

    public void onHeadlessJsTaskFinish(int i) {
        this.mJavaTimerManager.onHeadlessJsTaskFinish();
    }

    public void onHeadlessJsTaskStart(int i) {
        this.mJavaTimerManager.onHeadlessJsTaskStart();
    }

    public void onHostDestroy() {
        JavaTimerManager javaTimerManager = this.mJavaTimerManager;
        javaTimerManager.clearFrameCallback();
        javaTimerManager.maybeIdleCallback();
    }

    public void onHostPause() {
        JavaTimerManager javaTimerManager = this.mJavaTimerManager;
        javaTimerManager.isPaused.set(true);
        javaTimerManager.clearFrameCallback();
        javaTimerManager.maybeIdleCallback();
    }

    public void onHostResume() {
        JavaTimerManager javaTimerManager = this.mJavaTimerManager;
        javaTimerManager.isPaused.set(false);
        if (!javaTimerManager.mFrameCallbackPosted) {
            javaTimerManager.mReactChoreographer.postFrameCallback(CallbackType.TIMERS_EVENTS, javaTimerManager.mTimerFrameCallback);
            javaTimerManager.mFrameCallbackPosted = true;
        }
        javaTimerManager.maybeSetChoreographerIdleCallback();
    }

    public void setSendIdleEvents(boolean z) {
        this.mJavaTimerManager.setSendIdleEvents(z);
    }
}
