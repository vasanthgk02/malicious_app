package com.facebook.react.uimanager;

import android.view.MotionEvent;
import android.view.ViewGroup;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.TouchEvent;
import com.facebook.react.uimanager.events.TouchEventCoalescingKeyHelper;
import com.facebook.react.uimanager.events.TouchEventType;
import sfs2x.client.entities.invitation.InvitationReply;

public class JSTouchDispatcher {
    public boolean mChildIsHandlingNativeGesture = false;
    public long mGestureStartTime = Long.MIN_VALUE;
    public final ViewGroup mRootViewGroup;
    public final float[] mTargetCoordinates = new float[2];
    public int mTargetTag = -1;
    public final TouchEventCoalescingKeyHelper mTouchEventCoalescingKeyHelper = new TouchEventCoalescingKeyHelper();

    public JSTouchDispatcher(ViewGroup viewGroup) {
        this.mRootViewGroup = viewGroup;
    }

    public final void dispatchCancelEvent(MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        if (this.mTargetTag == -1) {
            FLog.w((String) "ReactNative", (String) "Can't cancel already finished gesture. Is a child View trying to start a gesture from an UP/CANCEL event?");
            return;
        }
        ImageOriginUtils.assertCondition(!this.mChildIsHandlingNativeGesture, "Expected to not have already sent a cancel for this gesture");
        ImageOriginUtils.assertNotNull(eventDispatcher);
        int i = this.mTargetTag;
        TouchEventType touchEventType = TouchEventType.CANCEL;
        long j = this.mGestureStartTime;
        float[] fArr = this.mTargetCoordinates;
        eventDispatcher.dispatchEvent(TouchEvent.obtain(i, touchEventType, motionEvent, j, fArr[0], fArr[1], this.mTouchEventCoalescingKeyHelper));
    }

    public final int findTargetTagAndSetCoordinates(MotionEvent motionEvent) {
        return TouchTargetHelper.findTargetTagAndCoordinatesForTouch(motionEvent.getX(), motionEvent.getY(), this.mRootViewGroup, this.mTargetCoordinates, null);
    }

    public void handleTouchEvent(MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        EventDispatcher eventDispatcher2 = eventDispatcher;
        int action = motionEvent.getAction() & InvitationReply.EXPIRED;
        boolean z = true;
        if (action == 0) {
            if (this.mTargetTag != -1) {
                FLog.e((String) "ReactNative", (String) "Got DOWN touch before receiving UP or CANCEL from last gesture");
            }
            this.mChildIsHandlingNativeGesture = false;
            this.mGestureStartTime = motionEvent.getEventTime();
            int findTargetTagAndSetCoordinates = findTargetTagAndSetCoordinates(motionEvent);
            this.mTargetTag = findTargetTagAndSetCoordinates;
            TouchEventType touchEventType = TouchEventType.START;
            long j = this.mGestureStartTime;
            float[] fArr = this.mTargetCoordinates;
            eventDispatcher2.dispatchEvent(TouchEvent.obtain(findTargetTagAndSetCoordinates, touchEventType, motionEvent, j, fArr[0], fArr[1], this.mTouchEventCoalescingKeyHelper));
        } else if (!this.mChildIsHandlingNativeGesture) {
            int i = this.mTargetTag;
            if (i == -1) {
                FLog.e((String) "ReactNative", (String) "Unexpected state: received touch event but didn't get starting ACTION_DOWN for this gesture before");
            } else if (action == 1) {
                findTargetTagAndSetCoordinates(motionEvent);
                int i2 = this.mTargetTag;
                TouchEventType touchEventType2 = TouchEventType.END;
                long j2 = this.mGestureStartTime;
                float[] fArr2 = this.mTargetCoordinates;
                eventDispatcher2.dispatchEvent(TouchEvent.obtain(i2, touchEventType2, motionEvent, j2, fArr2[0], fArr2[1], this.mTouchEventCoalescingKeyHelper));
                this.mTargetTag = -1;
                this.mGestureStartTime = Long.MIN_VALUE;
            } else if (action == 2) {
                findTargetTagAndSetCoordinates(motionEvent);
                int i3 = this.mTargetTag;
                TouchEventType touchEventType3 = TouchEventType.MOVE;
                long j3 = this.mGestureStartTime;
                float[] fArr3 = this.mTargetCoordinates;
                eventDispatcher2.dispatchEvent(TouchEvent.obtain(i3, touchEventType3, motionEvent, j3, fArr3[0], fArr3[1], this.mTouchEventCoalescingKeyHelper));
            } else if (action == 5) {
                TouchEventType touchEventType4 = TouchEventType.START;
                long j4 = this.mGestureStartTime;
                float[] fArr4 = this.mTargetCoordinates;
                eventDispatcher2.dispatchEvent(TouchEvent.obtain(i, touchEventType4, motionEvent, j4, fArr4[0], fArr4[1], this.mTouchEventCoalescingKeyHelper));
            } else if (action == 6) {
                TouchEventType touchEventType5 = TouchEventType.END;
                long j5 = this.mGestureStartTime;
                float[] fArr5 = this.mTargetCoordinates;
                eventDispatcher2.dispatchEvent(TouchEvent.obtain(i, touchEventType5, motionEvent, j5, fArr5[0], fArr5[1], this.mTouchEventCoalescingKeyHelper));
            } else if (action == 3) {
                if (this.mTouchEventCoalescingKeyHelper.mDownTimeToCoalescingKey.get((int) motionEvent.getDownTime(), -1) == -1) {
                    z = false;
                }
                if (z) {
                    dispatchCancelEvent(motionEvent, eventDispatcher);
                } else {
                    FLog.e((String) "ReactNative", (String) "Received an ACTION_CANCEL touch event for which we have no corresponding ACTION_DOWN");
                }
                this.mTargetTag = -1;
                this.mGestureStartTime = Long.MIN_VALUE;
            } else {
                StringBuilder outline74 = GeneratedOutlineSupport.outline74("Warning : touch event was ignored. Action=", action, " Target=");
                outline74.append(this.mTargetTag);
                FLog.w((String) "ReactNative", outline74.toString());
            }
        }
    }
}
