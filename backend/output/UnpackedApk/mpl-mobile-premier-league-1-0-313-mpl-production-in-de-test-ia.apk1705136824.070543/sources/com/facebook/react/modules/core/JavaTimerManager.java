package com.facebook.react.modules.core;

import android.os.SystemClock;
import android.util.SparseArray;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.jstasks.HeadlessJsTaskContext;
import com.facebook.react.modules.core.ChoreographerCompat.FrameCallback;
import com.facebook.react.modules.core.ReactChoreographer.CallbackType;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class JavaTimerManager {
    public final AtomicBoolean isPaused = new AtomicBoolean(true);
    public final AtomicBoolean isRunningTasks = new AtomicBoolean(false);
    public IdleCallbackRunnable mCurrentIdleCallbackRunnable;
    public final DevSupportManager mDevSupportManager;
    public boolean mFrameCallbackPosted = false;
    public boolean mFrameIdleCallbackPosted = false;
    public final Object mIdleCallbackGuard = new Object();
    public final IdleFrameCallback mIdleFrameCallback = new IdleFrameCallback(null);
    public final JavaScriptTimerManager mJavaScriptTimerManager;
    public final ReactApplicationContext mReactApplicationContext;
    public final ReactChoreographer mReactChoreographer;
    public boolean mSendIdleEvents = false;
    public final TimerFrameCallback mTimerFrameCallback = new TimerFrameCallback(null);
    public final Object mTimerGuard = new Object();
    public final SparseArray<Timer> mTimerIdsToTimers;
    public final PriorityQueue<Timer> mTimers;

    public class IdleCallbackRunnable implements Runnable {
        public volatile boolean mCancelled = false;
        public final long mFrameStartTime;

        public IdleCallbackRunnable(long j) {
            this.mFrameStartTime = j;
        }

        public void run() {
            boolean z;
            if (!this.mCancelled) {
                long uptimeMillis = SystemClock.uptimeMillis() - (this.mFrameStartTime / 1000000);
                long currentTimeMillis = System.currentTimeMillis() - uptimeMillis;
                if (16.666666f - ((float) uptimeMillis) >= 1.0f) {
                    synchronized (JavaTimerManager.this.mIdleCallbackGuard) {
                        z = JavaTimerManager.this.mSendIdleEvents;
                    }
                    if (z) {
                        double d2 = (double) currentTimeMillis;
                        ReactApplicationContext access$100 = TimingModule.this.getReactApplicationContextIfActiveOrWarn();
                        if (access$100 != null) {
                            ((JSTimers) access$100.getJSModule(JSTimers.class)).callIdleCallbacks(d2);
                        }
                    }
                    JavaTimerManager.this.mCurrentIdleCallbackRunnable = null;
                }
            }
        }
    }

    public class IdleFrameCallback extends FrameCallback {
        public IdleFrameCallback(AnonymousClass1 r2) {
        }

        public void doFrame(long j) {
            if (!JavaTimerManager.this.isPaused.get() || JavaTimerManager.this.isRunningTasks.get()) {
                IdleCallbackRunnable idleCallbackRunnable = JavaTimerManager.this.mCurrentIdleCallbackRunnable;
                if (idleCallbackRunnable != null) {
                    idleCallbackRunnable.mCancelled = true;
                }
                JavaTimerManager javaTimerManager = JavaTimerManager.this;
                javaTimerManager.mCurrentIdleCallbackRunnable = new IdleCallbackRunnable(j);
                JavaTimerManager javaTimerManager2 = JavaTimerManager.this;
                javaTimerManager2.mReactApplicationContext.runOnJSQueueThread(javaTimerManager2.mCurrentIdleCallbackRunnable);
                JavaTimerManager.this.mReactChoreographer.postFrameCallback(CallbackType.IDLE_EVENT, this);
            }
        }
    }

    public static class Timer {
        public final int mCallbackID;
        public final int mInterval;
        public final boolean mRepeat;
        public long mTargetTime;

        public Timer(int i, long j, int i2, boolean z, AnonymousClass1 r6) {
            this.mCallbackID = i;
            this.mTargetTime = j;
            this.mInterval = i2;
            this.mRepeat = z;
        }
    }

    public class TimerFrameCallback extends FrameCallback {
        public WritableArray mTimersToCall = null;

        public TimerFrameCallback(AnonymousClass1 r2) {
        }

        public void doFrame(long j) {
            if (!JavaTimerManager.this.isPaused.get() || JavaTimerManager.this.isRunningTasks.get()) {
                long j2 = j / 1000000;
                synchronized (JavaTimerManager.this.mTimerGuard) {
                    while (!JavaTimerManager.this.mTimers.isEmpty() && JavaTimerManager.this.mTimers.peek().mTargetTime < j2) {
                        Timer poll = JavaTimerManager.this.mTimers.poll();
                        if (this.mTimersToCall == null) {
                            this.mTimersToCall = Arguments.createArray();
                        }
                        this.mTimersToCall.pushInt(poll.mCallbackID);
                        if (poll.mRepeat) {
                            poll.mTargetTime = ((long) poll.mInterval) + j2;
                            JavaTimerManager.this.mTimers.add(poll);
                        } else {
                            JavaTimerManager.this.mTimerIdsToTimers.remove(poll.mCallbackID);
                        }
                    }
                }
                WritableArray writableArray = this.mTimersToCall;
                if (writableArray != null) {
                    ReactApplicationContext access$000 = TimingModule.this.getReactApplicationContextIfActiveOrWarn();
                    if (access$000 != null) {
                        ((JSTimers) access$000.getJSModule(JSTimers.class)).callTimers(writableArray);
                    }
                    this.mTimersToCall = null;
                }
                JavaTimerManager.this.mReactChoreographer.postFrameCallback(CallbackType.TIMERS_EVENTS, this);
            }
        }
    }

    public JavaTimerManager(ReactApplicationContext reactApplicationContext, JavaScriptTimerManager javaScriptTimerManager, ReactChoreographer reactChoreographer, DevSupportManager devSupportManager) {
        this.mReactApplicationContext = reactApplicationContext;
        this.mJavaScriptTimerManager = javaScriptTimerManager;
        this.mReactChoreographer = reactChoreographer;
        this.mDevSupportManager = devSupportManager;
        this.mTimers = new PriorityQueue<>(11, new Comparator<Timer>(this) {
            public int compare(Object obj, Object obj2) {
                int i = ((((Timer) obj).mTargetTime - ((Timer) obj2).mTargetTime) > 0 ? 1 : ((((Timer) obj).mTargetTime - ((Timer) obj2).mTargetTime) == 0 ? 0 : -1));
                if (i == 0) {
                    return 0;
                }
                return i < 0 ? -1 : 1;
            }
        });
        this.mTimerIdsToTimers = new SparseArray<>();
    }

    public final void clearFrameCallback() {
        HeadlessJsTaskContext instance = HeadlessJsTaskContext.getInstance(this.mReactApplicationContext);
        if (this.mFrameCallbackPosted && this.isPaused.get()) {
            if (!(instance.mActiveTasks.size() > 0)) {
                this.mReactChoreographer.removeFrameCallback(CallbackType.TIMERS_EVENTS, this.mTimerFrameCallback);
                this.mFrameCallbackPosted = false;
            }
        }
    }

    @DoNotStrip
    public void createTimer(int i, long j, boolean z) {
        Timer timer = new Timer(i, (System.nanoTime() / 1000000) + j, (int) j, z, null);
        synchronized (this.mTimerGuard) {
            this.mTimers.add(timer);
            this.mTimerIdsToTimers.put(i, timer);
        }
    }

    @DoNotStrip
    public void deleteTimer(int i) {
        synchronized (this.mTimerGuard) {
            Timer timer = this.mTimerIdsToTimers.get(i);
            if (timer != null) {
                this.mTimerIdsToTimers.remove(i);
                this.mTimers.remove(timer);
            }
        }
    }

    public final void maybeIdleCallback() {
        if (this.isPaused.get() && !this.isRunningTasks.get()) {
            clearFrameCallback();
        }
    }

    public final void maybeSetChoreographerIdleCallback() {
        synchronized (this.mIdleCallbackGuard) {
            if (this.mSendIdleEvents && !this.mFrameIdleCallbackPosted) {
                this.mReactChoreographer.postFrameCallback(CallbackType.IDLE_EVENT, this.mIdleFrameCallback);
                this.mFrameIdleCallbackPosted = true;
            }
        }
    }

    public void onHeadlessJsTaskFinish() {
        if (!(HeadlessJsTaskContext.getInstance(this.mReactApplicationContext).mActiveTasks.size() > 0)) {
            this.isRunningTasks.set(false);
            clearFrameCallback();
            maybeIdleCallback();
        }
    }

    public void onHeadlessJsTaskStart() {
        if (!this.isRunningTasks.getAndSet(true)) {
            if (!this.mFrameCallbackPosted) {
                this.mReactChoreographer.postFrameCallback(CallbackType.TIMERS_EVENTS, this.mTimerFrameCallback);
                this.mFrameCallbackPosted = true;
            }
            maybeSetChoreographerIdleCallback();
        }
    }

    @DoNotStrip
    public void setSendIdleEvents(final boolean z) {
        synchronized (this.mIdleCallbackGuard) {
            this.mSendIdleEvents = z;
        }
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                synchronized (JavaTimerManager.this.mIdleCallbackGuard) {
                    if (z) {
                        JavaTimerManager javaTimerManager = JavaTimerManager.this;
                        if (!javaTimerManager.mFrameIdleCallbackPosted) {
                            javaTimerManager.mReactChoreographer.postFrameCallback(CallbackType.IDLE_EVENT, javaTimerManager.mIdleFrameCallback);
                            javaTimerManager.mFrameIdleCallbackPosted = true;
                        }
                    } else {
                        JavaTimerManager javaTimerManager2 = JavaTimerManager.this;
                        if (javaTimerManager2.mFrameIdleCallbackPosted) {
                            javaTimerManager2.mReactChoreographer.removeFrameCallback(CallbackType.IDLE_EVENT, javaTimerManager2.mIdleFrameCallback);
                            javaTimerManager2.mFrameIdleCallbackPosted = false;
                        }
                    }
                }
            }
        });
    }
}
