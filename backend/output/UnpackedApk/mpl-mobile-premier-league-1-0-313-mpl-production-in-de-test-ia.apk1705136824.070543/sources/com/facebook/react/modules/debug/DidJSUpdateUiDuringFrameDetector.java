package com.facebook.react.modules.debug;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.common.LongArray;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;

public class DidJSUpdateUiDuringFrameDetector implements NotThreadSafeBridgeIdleDebugListener, NotThreadSafeViewHierarchyUpdateDebugListener {
    public final LongArray mTransitionToBusyEvents = new LongArray(20);
    public final LongArray mTransitionToIdleEvents = new LongArray(20);
    public final LongArray mViewHierarchyUpdateEnqueuedEvents = new LongArray(20);
    public final LongArray mViewHierarchyUpdateFinishedEvents = new LongArray(20);
    public volatile boolean mWasIdleAtEndOfLastFrame = true;

    public static void cleanUp(LongArray longArray, long j) {
        int i = longArray.mLength;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            if (longArray.get(i4) < j) {
                i3++;
            }
        }
        if (i3 > 0) {
            while (i2 < i - i3) {
                long j2 = longArray.get(i2 + i3);
                if (i2 < longArray.mLength) {
                    longArray.mArray[i2] = j2;
                    i2++;
                } else {
                    StringBuilder outline74 = GeneratedOutlineSupport.outline74("", i2, " >= ");
                    outline74.append(longArray.mLength);
                    throw new IndexOutOfBoundsException(outline74.toString());
                }
            }
            int i5 = longArray.mLength;
            if (i3 <= i5) {
                longArray.mLength = i5 - i3;
                return;
            }
            StringBuilder outline742 = GeneratedOutlineSupport.outline74("Trying to drop ", i3, " items from array of length ");
            outline742.append(longArray.mLength);
            throw new IndexOutOfBoundsException(outline742.toString());
        }
    }

    public static long getLastEventBetweenTimestamps(LongArray longArray, long j, long j2) {
        long j3 = -1;
        for (int i = 0; i < longArray.mLength; i++) {
            long j4 = longArray.get(i);
            if (j4 >= j && j4 < j2) {
                j3 = j4;
            } else if (j4 >= j2) {
                break;
            }
        }
        return j3;
    }

    public static boolean hasEventBetweenTimestamps(LongArray longArray, long j, long j2) {
        for (int i = 0; i < longArray.mLength; i++) {
            long j3 = longArray.get(i);
            if (j3 >= j && j3 < j2) {
                return true;
            }
        }
        return false;
    }

    public synchronized void onBridgeDestroyed() {
    }

    public synchronized void onTransitionToBridgeBusy() {
        this.mTransitionToBusyEvents.add(System.nanoTime());
    }

    public synchronized void onTransitionToBridgeIdle() {
        this.mTransitionToIdleEvents.add(System.nanoTime());
    }

    public synchronized void onViewHierarchyUpdateEnqueued() {
        this.mViewHierarchyUpdateEnqueuedEvents.add(System.nanoTime());
    }

    public synchronized void onViewHierarchyUpdateFinished() {
        this.mViewHierarchyUpdateFinishedEvents.add(System.nanoTime());
    }
}
