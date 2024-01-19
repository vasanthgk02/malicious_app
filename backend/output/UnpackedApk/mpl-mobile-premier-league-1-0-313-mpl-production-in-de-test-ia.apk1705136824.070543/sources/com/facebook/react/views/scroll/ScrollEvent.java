package com.facebook.react.views.scroll;

import android.os.SystemClock;
import androidx.core.util.Pools$SynchronizedPool;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;

public class ScrollEvent extends Event<ScrollEvent> {
    public static final Pools$SynchronizedPool<ScrollEvent> EVENTS_POOL = new Pools$SynchronizedPool<>(3);
    public int mContentHeight;
    public int mContentWidth;
    public ScrollEventType mScrollEventType;
    public int mScrollViewHeight;
    public int mScrollViewWidth;
    public int mScrollX;
    public int mScrollY;
    public double mXVelocity;
    public double mYVelocity;

    public static ScrollEvent obtain(int i, ScrollEventType scrollEventType, int i2, int i3, float f2, float f3, int i4, int i5, int i6, int i7) {
        ScrollEvent scrollEvent = (ScrollEvent) EVENTS_POOL.acquire();
        if (scrollEvent == null) {
            scrollEvent = new ScrollEvent();
        }
        scrollEvent.mViewTag = i;
        scrollEvent.mTimestampMs = SystemClock.uptimeMillis();
        scrollEvent.mInitialized = true;
        scrollEvent.mScrollEventType = scrollEventType;
        scrollEvent.mScrollX = i2;
        scrollEvent.mScrollY = i3;
        scrollEvent.mXVelocity = (double) f2;
        scrollEvent.mYVelocity = (double) f3;
        scrollEvent.mContentWidth = i4;
        scrollEvent.mContentHeight = i5;
        scrollEvent.mScrollViewWidth = i6;
        scrollEvent.mScrollViewHeight = i7;
        return scrollEvent;
    }

    public boolean canCoalesce() {
        return this.mScrollEventType == ScrollEventType.SCROLL;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        int i = this.mViewTag;
        String eventName = getEventName();
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble(RNGestureHandlerModule.KEY_HIT_SLOP_TOP, 0.0d);
        createMap.putDouble(RNGestureHandlerModule.KEY_HIT_SLOP_BOTTOM, 0.0d);
        createMap.putDouble(RNGestureHandlerModule.KEY_HIT_SLOP_LEFT, 0.0d);
        createMap.putDouble(RNGestureHandlerModule.KEY_HIT_SLOP_RIGHT, 0.0d);
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putDouble("x", (double) ImageOriginUtils.toDIPFromPixel((float) this.mScrollX));
        createMap2.putDouble("y", (double) ImageOriginUtils.toDIPFromPixel((float) this.mScrollY));
        WritableMap createMap3 = Arguments.createMap();
        createMap3.putDouble("width", (double) ImageOriginUtils.toDIPFromPixel((float) this.mContentWidth));
        createMap3.putDouble("height", (double) ImageOriginUtils.toDIPFromPixel((float) this.mContentHeight));
        WritableMap createMap4 = Arguments.createMap();
        createMap4.putDouble("width", (double) ImageOriginUtils.toDIPFromPixel((float) this.mScrollViewWidth));
        createMap4.putDouble("height", (double) ImageOriginUtils.toDIPFromPixel((float) this.mScrollViewHeight));
        WritableMap createMap5 = Arguments.createMap();
        createMap5.putDouble("x", this.mXVelocity);
        createMap5.putDouble("y", this.mYVelocity);
        WritableMap createMap6 = Arguments.createMap();
        createMap6.putMap("contentInset", createMap);
        createMap6.putMap("contentOffset", createMap2);
        createMap6.putMap("contentSize", createMap3);
        createMap6.putMap("layoutMeasurement", createMap4);
        createMap6.putMap("velocity", createMap5);
        createMap6.putInt("target", this.mViewTag);
        createMap6.putBoolean("responderIgnoreScroll", true);
        rCTEventEmitter.receiveEvent(i, eventName, createMap6);
    }

    public short getCoalescingKey() {
        return 0;
    }

    public String getEventName() {
        ScrollEventType scrollEventType = this.mScrollEventType;
        ImageOriginUtils.assertNotNull(scrollEventType);
        return ScrollEventType.getJSEventName(scrollEventType);
    }

    public void onDispose() {
        EVENTS_POOL.release(this);
    }
}
