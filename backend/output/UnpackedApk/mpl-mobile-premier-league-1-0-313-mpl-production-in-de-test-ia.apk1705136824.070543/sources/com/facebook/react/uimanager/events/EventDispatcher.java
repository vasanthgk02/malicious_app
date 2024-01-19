package com.facebook.react.uimanager.events;

import android.os.Trace;
import android.util.LongSparseArray;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.modules.core.ChoreographerCompat.FrameCallback;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.core.ReactChoreographer.CallbackType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class EventDispatcher implements LifecycleEventListener {
    public static final Comparator<Event> EVENT_COMPARATOR = new Comparator<Event>() {
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
            if (r5 < 0) goto L_0x000d;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int compare(java.lang.Object r7, java.lang.Object r8) {
            /*
                r6 = this;
                com.facebook.react.uimanager.events.Event r7 = (com.facebook.react.uimanager.events.Event) r7
                com.facebook.react.uimanager.events.Event r8 = (com.facebook.react.uimanager.events.Event) r8
                r0 = 0
                if (r7 != 0) goto L_0x000a
                if (r8 != 0) goto L_0x000a
                goto L_0x0023
            L_0x000a:
                r1 = -1
                if (r7 != 0) goto L_0x000f
            L_0x000d:
                r0 = -1
                goto L_0x0023
            L_0x000f:
                r2 = 1
                if (r8 != 0) goto L_0x0014
            L_0x0012:
                r0 = 1
                goto L_0x0023
            L_0x0014:
                long r3 = r7.mTimestampMs
                long r7 = r8.mTimestampMs
                long r3 = r3 - r7
                r7 = 0
                int r5 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
                if (r5 != 0) goto L_0x0020
                goto L_0x0023
            L_0x0020:
                if (r5 >= 0) goto L_0x0012
                goto L_0x000d
            L_0x0023:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.events.EventDispatcher.AnonymousClass1.compare(java.lang.Object, java.lang.Object):int");
        }
    };
    public final ScheduleDispatchFrameCallback mCurrentFrameCallback = new ScheduleDispatchFrameCallback(null);
    public final DispatchEventsRunnable mDispatchEventsRunnable = new DispatchEventsRunnable(null);
    public final LongSparseArray<Integer> mEventCookieToLastEventIdx = new LongSparseArray<>();
    public final Map<String, Short> mEventNameToEventId = new HashMap();
    public final ArrayList<Event> mEventStaging = new ArrayList<>();
    public final Object mEventsStagingLock = new Object();
    public Event[] mEventsToDispatch = new Event[16];
    public final Object mEventsToDispatchLock = new Object();
    public int mEventsToDispatchSize = 0;
    public volatile boolean mHasDispatchScheduled = false;
    public final AtomicInteger mHasDispatchScheduledCount = new AtomicInteger();
    public final ArrayList<EventDispatcherListener> mListeners = new ArrayList<>();
    public short mNextEventTypeId = 0;
    public final List<BatchEventDispatchedListener> mPostEventDispatchListeners = new ArrayList();
    public final ReactApplicationContext mReactContext;
    public volatile ReactEventEmitter mReactEventEmitter;

    public class DispatchEventsRunnable implements Runnable {
        public DispatchEventsRunnable(AnonymousClass1 r2) {
        }

        public void run() {
            Trace.beginSection("DispatchEventsRunnable");
            try {
                EventDispatcher.this.mHasDispatchScheduledCount.getAndIncrement();
                EventDispatcher.this.mHasDispatchScheduled = false;
                ImageOriginUtils.assertNotNull(EventDispatcher.this.mReactEventEmitter);
                synchronized (EventDispatcher.this.mEventsToDispatchLock) {
                    if (EventDispatcher.this.mEventsToDispatchSize > 0) {
                        if (EventDispatcher.this.mEventsToDispatchSize > 1) {
                            Arrays.sort(EventDispatcher.this.mEventsToDispatch, 0, EventDispatcher.this.mEventsToDispatchSize, EventDispatcher.EVENT_COMPARATOR);
                        }
                        for (int i = 0; i < EventDispatcher.this.mEventsToDispatchSize; i++) {
                            Event event = EventDispatcher.this.mEventsToDispatch[i];
                            if (event != null) {
                                event.getEventName();
                                event.dispatch(EventDispatcher.this.mReactEventEmitter);
                                event.mInitialized = false;
                                event.onDispose();
                            }
                        }
                        EventDispatcher eventDispatcher = EventDispatcher.this;
                        Arrays.fill(eventDispatcher.mEventsToDispatch, 0, eventDispatcher.mEventsToDispatchSize, null);
                        eventDispatcher.mEventsToDispatchSize = 0;
                        EventDispatcher.this.mEventCookieToLastEventIdx.clear();
                    }
                }
                for (BatchEventDispatchedListener onBatchEventDispatched : EventDispatcher.this.mPostEventDispatchListeners) {
                    onBatchEventDispatched.onBatchEventDispatched();
                }
                Trace.endSection();
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
    }

    public class ScheduleDispatchFrameCallback extends FrameCallback {
        public volatile boolean mIsPosted = false;
        public boolean mShouldStop = false;

        public ScheduleDispatchFrameCallback(AnonymousClass1 r2) {
        }

        public void doFrame(long j) {
            UiThreadUtil.assertOnUiThread();
            if (this.mShouldStop) {
                this.mIsPosted = false;
            } else {
                ReactChoreographer.getInstance().postFrameCallback(CallbackType.TIMERS_EVENTS, EventDispatcher.this.mCurrentFrameCallback);
            }
            Trace.beginSection("ScheduleDispatchFrameCallback");
            try {
                EventDispatcher.access$300(EventDispatcher.this);
                if (!EventDispatcher.this.mHasDispatchScheduled) {
                    EventDispatcher.this.mHasDispatchScheduled = true;
                    EventDispatcher.this.mHasDispatchScheduledCount.get();
                    EventDispatcher.this.mReactContext.runOnJSQueueThread(EventDispatcher.this.mDispatchEventsRunnable);
                }
            } finally {
                Trace.endSection();
            }
        }

        public void maybePost() {
            if (!this.mIsPosted) {
                this.mIsPosted = true;
                ReactChoreographer.getInstance().postFrameCallback(CallbackType.TIMERS_EVENTS, EventDispatcher.this.mCurrentFrameCallback);
            }
        }
    }

    public EventDispatcher(ReactApplicationContext reactApplicationContext) {
        this.mReactContext = reactApplicationContext;
        reactApplicationContext.addLifecycleEventListener(this);
        this.mReactEventEmitter = new ReactEventEmitter(this.mReactContext);
    }

    public static void access$300(EventDispatcher eventDispatcher) {
        short s;
        EventDispatcher eventDispatcher2 = eventDispatcher;
        synchronized (eventDispatcher2.mEventsStagingLock) {
            synchronized (eventDispatcher2.mEventsToDispatchLock) {
                for (int i = 0; i < eventDispatcher2.mEventStaging.size(); i++) {
                    Event event = eventDispatcher2.mEventStaging.get(i);
                    if (!event.canCoalesce()) {
                        eventDispatcher2.addEventToEventsToDispatch(event);
                    } else {
                        int i2 = event.mViewTag;
                        String eventName = event.getEventName();
                        short coalescingKey = event.getCoalescingKey();
                        Short sh = eventDispatcher2.mEventNameToEventId.get(eventName);
                        if (sh != null) {
                            s = sh.shortValue();
                        } else {
                            short s2 = eventDispatcher2.mNextEventTypeId;
                            eventDispatcher2.mNextEventTypeId = (short) (s2 + 1);
                            eventDispatcher2.mEventNameToEventId.put(eventName, Short.valueOf(s2));
                            s = s2;
                        }
                        long j = ((((long) s) & 65535) << 32) | ((long) i2) | ((((long) coalescingKey) & 65535) << 48);
                        Integer num = eventDispatcher2.mEventCookieToLastEventIdx.get(j);
                        Event event2 = null;
                        if (num == null) {
                            eventDispatcher2.mEventCookieToLastEventIdx.put(j, Integer.valueOf(eventDispatcher2.mEventsToDispatchSize));
                        } else {
                            Event event3 = eventDispatcher2.mEventsToDispatch[num.intValue()];
                            Event event4 = event.mTimestampMs >= event3.mTimestampMs ? event : event3;
                            if (event4 != event3) {
                                eventDispatcher2.mEventCookieToLastEventIdx.put(j, Integer.valueOf(eventDispatcher2.mEventsToDispatchSize));
                                eventDispatcher2.mEventsToDispatch[num.intValue()] = null;
                                event2 = event3;
                                event = event4;
                            } else {
                                event2 = event;
                                event = null;
                            }
                        }
                        if (event != null) {
                            eventDispatcher2.addEventToEventsToDispatch(event);
                        }
                        if (event2 != null) {
                            event2.mInitialized = false;
                            event2.onDispose();
                        }
                    }
                }
            }
            eventDispatcher2.mEventStaging.clear();
        }
    }

    public final void addEventToEventsToDispatch(Event event) {
        int i = this.mEventsToDispatchSize;
        Event[] eventArr = this.mEventsToDispatch;
        if (i == eventArr.length) {
            this.mEventsToDispatch = (Event[]) Arrays.copyOf(eventArr, eventArr.length * 2);
        }
        Event[] eventArr2 = this.mEventsToDispatch;
        int i2 = this.mEventsToDispatchSize;
        this.mEventsToDispatchSize = i2 + 1;
        eventArr2[i2] = event;
    }

    public void dispatchEvent(Event event) {
        ImageOriginUtils.assertCondition(event.mInitialized, "Dispatched event hasn't been initialized");
        Iterator<EventDispatcherListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onEventDispatch(event);
        }
        synchronized (this.mEventsStagingLock) {
            this.mEventStaging.add(event);
            event.getEventName();
        }
        maybePostFrameCallbackFromNonUI();
    }

    public final void maybePostFrameCallbackFromNonUI() {
        if (this.mReactEventEmitter != null) {
            ScheduleDispatchFrameCallback scheduleDispatchFrameCallback = this.mCurrentFrameCallback;
            if (!scheduleDispatchFrameCallback.mIsPosted) {
                if (EventDispatcher.this.mReactContext.isOnUiQueueThread()) {
                    scheduleDispatchFrameCallback.maybePost();
                } else {
                    EventDispatcher.this.mReactContext.runOnUiQueueThread(new Runnable() {
                        public void run() {
                            ScheduleDispatchFrameCallback.this.maybePost();
                        }
                    });
                }
            }
        }
    }

    public void onHostDestroy() {
        stopFrameCallback();
    }

    public void onHostPause() {
        stopFrameCallback();
    }

    public void onHostResume() {
        maybePostFrameCallbackFromNonUI();
    }

    public final void stopFrameCallback() {
        UiThreadUtil.assertOnUiThread();
        this.mCurrentFrameCallback.mShouldStop = true;
    }
}
