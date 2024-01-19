package com.swmansion.rnscreens.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00142\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u0014B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/swmansion/rnscreens/events/ScreenTransitionProgressEvent;", "Lcom/facebook/react/uimanager/events/Event;", "Lcom/swmansion/rnscreens/events/ScreenAppearEvent;", "viewId", "", "mProgress", "", "mClosing", "", "mGoingForward", "mCoalescingKey", "", "(IFZZS)V", "dispatch", "", "rctEventEmitter", "Lcom/facebook/react/uimanager/events/RCTEventEmitter;", "getCoalescingKey", "getEventName", "", "Companion", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ScreenTransitionProgressEvent.kt */
public final class ScreenTransitionProgressEvent extends Event<ScreenAppearEvent> {
    public final boolean mClosing;
    public final short mCoalescingKey;
    public final boolean mGoingForward;
    public final float mProgress;

    public ScreenTransitionProgressEvent(int i, float f2, boolean z, boolean z2, short s) {
        super(i);
        this.mProgress = f2;
        this.mClosing = z;
        this.mGoingForward = z2;
        this.mCoalescingKey = s;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        Intrinsics.checkNotNullParameter(rCTEventEmitter, "rctEventEmitter");
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("progress", (double) this.mProgress);
        createMap.putInt("closing", this.mClosing ? 1 : 0);
        createMap.putInt("goingForward", this.mGoingForward ? 1 : 0);
        rCTEventEmitter.receiveEvent(this.mViewTag, "topTransitionProgress", createMap);
    }

    public short getCoalescingKey() {
        return this.mCoalescingKey;
    }

    public String getEventName() {
        return "topTransitionProgress";
    }
}
