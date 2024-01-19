package com.facebook.react.modules.core;

import android.view.Choreographer;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.modules.core.ChoreographerCompat.FrameCallback;
import java.util.ArrayDeque;

public class ReactChoreographer {
    public static ReactChoreographer sInstance;
    public final ArrayDeque<FrameCallback>[] mCallbackQueues;
    public final Object mCallbackQueuesLock = new Object();
    public volatile ChoreographerCompat mChoreographer;
    public boolean mHasPostedCallback;
    public final ReactChoreographerDispatcher mReactChoreographerDispatcher;
    public int mTotalCallbacks;

    public enum CallbackType {
        PERF_MARKERS(0),
        DISPATCH_UI(1),
        NATIVE_ANIMATED_MODULE(2),
        TIMERS_EVENTS(3),
        IDLE_EVENT(4);
        
        public final int mOrder;

        /* access modifiers changed from: public */
        CallbackType(int i) {
            this.mOrder = i;
        }

        public int getOrder() {
            return this.mOrder;
        }
    }

    public class ReactChoreographerDispatcher extends FrameCallback {
        public ReactChoreographerDispatcher(AnonymousClass1 r2) {
        }

        public void doFrame(long j) {
            synchronized (ReactChoreographer.this.mCallbackQueuesLock) {
                ReactChoreographer.this.mHasPostedCallback = false;
                for (ArrayDeque<FrameCallback> arrayDeque : ReactChoreographer.this.mCallbackQueues) {
                    int size = arrayDeque.size();
                    for (int i = 0; i < size; i++) {
                        FrameCallback pollFirst = arrayDeque.pollFirst();
                        if (pollFirst != null) {
                            pollFirst.doFrame(j);
                            ReactChoreographer reactChoreographer = ReactChoreographer.this;
                            reactChoreographer.mTotalCallbacks--;
                        } else {
                            FLog.e((String) "ReactNative", (String) "Tried to execute non-existent frame callback");
                        }
                    }
                }
                ReactChoreographer.this.maybeRemoveFrameCallback();
            }
        }
    }

    public ReactChoreographer() {
        int i = 0;
        this.mTotalCallbacks = 0;
        this.mHasPostedCallback = false;
        this.mReactChoreographerDispatcher = new ReactChoreographerDispatcher(null);
        this.mCallbackQueues = new ArrayDeque[CallbackType.values().length];
        while (true) {
            ArrayDeque<FrameCallback>[] arrayDequeArr = this.mCallbackQueues;
            if (i < arrayDequeArr.length) {
                arrayDequeArr[i] = new ArrayDeque<>();
                i++;
            } else {
                UiThreadUtil.runOnUiThread(new Runnable(null) {
                    public void run() {
                        synchronized (ReactChoreographer.class) {
                            if (ReactChoreographer.this.mChoreographer == null) {
                                ReactChoreographer reactChoreographer = ReactChoreographer.this;
                                UiThreadUtil.assertOnUiThread();
                                if (ChoreographerCompat.sInstance == null) {
                                    ChoreographerCompat.sInstance = new ChoreographerCompat();
                                }
                                reactChoreographer.mChoreographer = ChoreographerCompat.sInstance;
                            }
                        }
                        Runnable runnable = r3;
                        if (runnable != null) {
                            runnable.run();
                        }
                    }
                });
                return;
            }
        }
    }

    public static ReactChoreographer getInstance() {
        ImageOriginUtils.assertNotNull(sInstance, "ReactChoreographer needs to be initialized.");
        return sInstance;
    }

    public final void maybeRemoveFrameCallback() {
        ImageOriginUtils.assertCondition(this.mTotalCallbacks >= 0);
        if (this.mTotalCallbacks == 0 && this.mHasPostedCallback) {
            if (this.mChoreographer != null) {
                ChoreographerCompat choreographerCompat = this.mChoreographer;
                ReactChoreographerDispatcher reactChoreographerDispatcher = this.mReactChoreographerDispatcher;
                if (choreographerCompat != null) {
                    if (reactChoreographerDispatcher.mFrameCallback == null) {
                        reactChoreographerDispatcher.mFrameCallback = new Choreographer.FrameCallback() {
                            public void doFrame(long j) {
                                FrameCallback.this.doFrame(j);
                            }
                        };
                    }
                    choreographerCompat.mChoreographer.removeFrameCallback(reactChoreographerDispatcher.mFrameCallback);
                } else {
                    throw null;
                }
            }
            this.mHasPostedCallback = false;
        }
    }

    public void postFrameCallback(CallbackType callbackType, FrameCallback frameCallback) {
        synchronized (this.mCallbackQueuesLock) {
            this.mCallbackQueues[callbackType.getOrder()].addLast(frameCallback);
            int i = this.mTotalCallbacks + 1;
            this.mTotalCallbacks = i;
            ImageOriginUtils.assertCondition(i > 0);
            if (!this.mHasPostedCallback) {
                if (this.mChoreographer == null) {
                    final AnonymousClass1 r3 = new Runnable() {
                        public void run() {
                            ReactChoreographer reactChoreographer = ReactChoreographer.this;
                            reactChoreographer.mChoreographer.postFrameCallback(reactChoreographer.mReactChoreographerDispatcher);
                            reactChoreographer.mHasPostedCallback = true;
                        }
                    };
                    UiThreadUtil.runOnUiThread(new Runnable() {
                        public void run() {
                            synchronized (ReactChoreographer.class) {
                                if (ReactChoreographer.this.mChoreographer == null) {
                                    ReactChoreographer reactChoreographer = ReactChoreographer.this;
                                    UiThreadUtil.assertOnUiThread();
                                    if (ChoreographerCompat.sInstance == null) {
                                        ChoreographerCompat.sInstance = new ChoreographerCompat();
                                    }
                                    reactChoreographer.mChoreographer = ChoreographerCompat.sInstance;
                                }
                            }
                            Runnable runnable = r3;
                            if (runnable != null) {
                                runnable.run();
                            }
                        }
                    });
                } else {
                    this.mChoreographer.postFrameCallback(this.mReactChoreographerDispatcher);
                    this.mHasPostedCallback = true;
                }
            }
        }
    }

    public void removeFrameCallback(CallbackType callbackType, FrameCallback frameCallback) {
        synchronized (this.mCallbackQueuesLock) {
            if (this.mCallbackQueues[callbackType.getOrder()].removeFirstOccurrence(frameCallback)) {
                this.mTotalCallbacks--;
                maybeRemoveFrameCallback();
            } else {
                FLog.e((String) "ReactNative", (String) "Tried to remove non-existent frame callback");
            }
        }
    }
}
