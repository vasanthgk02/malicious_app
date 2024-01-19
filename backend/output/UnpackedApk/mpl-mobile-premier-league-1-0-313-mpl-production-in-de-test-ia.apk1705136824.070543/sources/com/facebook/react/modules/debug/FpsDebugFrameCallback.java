package com.facebook.react.modules.debug;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.ChoreographerCompat;
import com.facebook.react.modules.core.ChoreographerCompat.FrameCallback;
import com.facebook.react.uimanager.UIManagerModule;
import java.util.TreeMap;

public class FpsDebugFrameCallback extends FrameCallback {
    public int m4PlusFrameStutters = 0;
    public ChoreographerCompat mChoreographer;
    public final DidJSUpdateUiDuringFrameDetector mDidJSUpdateUiDuringFrameDetector;
    public int mExpectedNumFramesPrev = 0;
    public long mFirstFrameTime = -1;
    public boolean mIsRecordingFpsInfoAtEachFrame = false;
    public long mLastFrameTime = -1;
    public int mNumFrameCallbacks = 0;
    public int mNumFrameCallbacksWithBatchDispatches = 0;
    public final ReactContext mReactContext;
    public boolean mShouldStop = false;
    public TreeMap<Long, FpsInfo> mTimeToFps;
    public final UIManagerModule mUIManagerModule;

    public static class FpsInfo {
        public final double fps;
        public final double jsFps;
        public final int totalExpectedFrames;
        public final int totalFrames;
        public final int totalJsFrames;
        public final int totalTimeMs;

        public FpsInfo(int i, int i2, int i3, int i4, double d2, double d3, int i5) {
            this.totalFrames = i;
            this.totalJsFrames = i2;
            this.totalExpectedFrames = i3;
            this.fps = d2;
            this.jsFps = d3;
            this.totalTimeMs = i5;
        }
    }

    public FpsDebugFrameCallback(ReactContext reactContext) {
        this.mReactContext = reactContext;
        this.mUIManagerModule = (UIManagerModule) reactContext.getNativeModule(UIManagerModule.class);
        this.mDidJSUpdateUiDuringFrameDetector = new DidJSUpdateUiDuringFrameDetector();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004b, code lost:
        if (com.facebook.react.modules.debug.DidJSUpdateUiDuringFrameDetector.hasEventBetweenTimestamps(r8.mViewHierarchyUpdateEnqueuedEvents, r4, r2) == false) goto L_0x004d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doFrame(long r26) {
        /*
            r25 = this;
            r1 = r25
            r2 = r26
            boolean r0 = r1.mShouldStop
            if (r0 == 0) goto L_0x0009
            return
        L_0x0009:
            long r4 = r1.mFirstFrameTime
            r6 = -1
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x0013
            r1.mFirstFrameTime = r2
        L_0x0013:
            long r4 = r1.mLastFrameTime
            r1.mLastFrameTime = r2
            com.facebook.react.modules.debug.DidJSUpdateUiDuringFrameDetector r8 = r1.mDidJSUpdateUiDuringFrameDetector
            monitor-enter(r8)
            com.facebook.react.common.LongArray r0 = r8.mViewHierarchyUpdateFinishedEvents     // Catch:{ all -> 0x0104 }
            boolean r0 = com.facebook.react.modules.debug.DidJSUpdateUiDuringFrameDetector.hasEventBetweenTimestamps(r0, r4, r2)     // Catch:{ all -> 0x0104 }
            com.facebook.react.common.LongArray r9 = r8.mTransitionToIdleEvents     // Catch:{ all -> 0x0104 }
            long r9 = com.facebook.react.modules.debug.DidJSUpdateUiDuringFrameDetector.getLastEventBetweenTimestamps(r9, r4, r2)     // Catch:{ all -> 0x0104 }
            com.facebook.react.common.LongArray r11 = r8.mTransitionToBusyEvents     // Catch:{ all -> 0x0104 }
            long r11 = com.facebook.react.modules.debug.DidJSUpdateUiDuringFrameDetector.getLastEventBetweenTimestamps(r11, r4, r2)     // Catch:{ all -> 0x0104 }
            r13 = 0
            r14 = 1
            int r15 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r15 != 0) goto L_0x0039
            int r15 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r15 != 0) goto L_0x0039
            boolean r6 = r8.mWasIdleAtEndOfLastFrame     // Catch:{ all -> 0x0104 }
            goto L_0x0040
        L_0x0039:
            int r6 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r6 <= 0) goto L_0x003f
            r6 = 1
            goto L_0x0040
        L_0x003f:
            r6 = 0
        L_0x0040:
            if (r0 == 0) goto L_0x0043
            goto L_0x004d
        L_0x0043:
            if (r6 == 0) goto L_0x004e
            com.facebook.react.common.LongArray r0 = r8.mViewHierarchyUpdateEnqueuedEvents     // Catch:{ all -> 0x0104 }
            boolean r0 = com.facebook.react.modules.debug.DidJSUpdateUiDuringFrameDetector.hasEventBetweenTimestamps(r0, r4, r2)     // Catch:{ all -> 0x0104 }
            if (r0 != 0) goto L_0x004e
        L_0x004d:
            r13 = 1
        L_0x004e:
            com.facebook.react.common.LongArray r0 = r8.mTransitionToIdleEvents     // Catch:{ all -> 0x0104 }
            com.facebook.react.modules.debug.DidJSUpdateUiDuringFrameDetector.cleanUp(r0, r2)     // Catch:{ all -> 0x0104 }
            com.facebook.react.common.LongArray r0 = r8.mTransitionToBusyEvents     // Catch:{ all -> 0x0104 }
            com.facebook.react.modules.debug.DidJSUpdateUiDuringFrameDetector.cleanUp(r0, r2)     // Catch:{ all -> 0x0104 }
            com.facebook.react.common.LongArray r0 = r8.mViewHierarchyUpdateEnqueuedEvents     // Catch:{ all -> 0x0104 }
            com.facebook.react.modules.debug.DidJSUpdateUiDuringFrameDetector.cleanUp(r0, r2)     // Catch:{ all -> 0x0104 }
            com.facebook.react.common.LongArray r0 = r8.mViewHierarchyUpdateFinishedEvents     // Catch:{ all -> 0x0104 }
            com.facebook.react.modules.debug.DidJSUpdateUiDuringFrameDetector.cleanUp(r0, r2)     // Catch:{ all -> 0x0104 }
            r8.mWasIdleAtEndOfLastFrame = r6     // Catch:{ all -> 0x0104 }
            monitor-exit(r8)
            if (r13 == 0) goto L_0x006c
            int r0 = r1.mNumFrameCallbacksWithBatchDispatches
            int r0 = r0 + r14
            r1.mNumFrameCallbacksWithBatchDispatches = r0
        L_0x006c:
            int r0 = r1.mNumFrameCallbacks
            int r0 = r0 + r14
            r1.mNumFrameCallbacks = r0
            long r2 = r1.mLastFrameTime
            double r2 = (double) r2
            long r4 = r1.mFirstFrameTime
            double r4 = (double) r4
            double r2 = r2 - r4
            int r0 = (int) r2
            r2 = 1000000(0xf4240, float:1.401298E-39)
            int r0 = r0 / r2
            double r3 = (double) r0
            r5 = 4625450144788538982(0x4030e66666666666, double:16.9)
            double r3 = r3 / r5
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r3 = r3 + r5
            int r0 = (int) r3
            int r3 = r1.mExpectedNumFramesPrev
            int r3 = r0 - r3
            int r3 = r3 - r14
            r4 = 4
            if (r3 < r4) goto L_0x0095
            int r3 = r1.m4PlusFrameStutters
            int r3 = r3 + r14
            r1.m4PlusFrameStutters = r3
        L_0x0095:
            boolean r3 = r1.mIsRecordingFpsInfoAtEachFrame
            if (r3 == 0) goto L_0x00fa
            java.util.TreeMap<java.lang.Long, com.facebook.react.modules.debug.FpsDebugFrameCallback$FpsInfo> r3 = r1.mTimeToFps
            com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.assertNotNull(r3)
            com.facebook.react.modules.debug.FpsDebugFrameCallback$FpsInfo r3 = new com.facebook.react.modules.debug.FpsDebugFrameCallback$FpsInfo
            int r4 = r1.mNumFrameCallbacks
            int r4 = r4 + -1
            int r5 = r1.mNumFrameCallbacksWithBatchDispatches
            int r17 = r5 + -1
            int r5 = r1.m4PlusFrameStutters
            long r6 = r1.mLastFrameTime
            long r8 = r1.mFirstFrameTime
            r10 = 0
            r12 = 4741671816366391296(0x41cdcd6500000000, double:1.0E9)
            int r14 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r14 != 0) goto L_0x00bc
            r20 = r10
            goto L_0x00c4
        L_0x00bc:
            double r14 = (double) r4
            double r14 = r14 * r12
            long r6 = r6 - r8
            double r6 = (double) r6
            double r14 = r14 / r6
            r20 = r14
        L_0x00c4:
            long r6 = r1.mLastFrameTime
            long r8 = r1.mFirstFrameTime
            int r14 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r14 != 0) goto L_0x00cd
            goto L_0x00d7
        L_0x00cd:
            int r10 = r1.mNumFrameCallbacksWithBatchDispatches
            int r10 = r10 + -1
            double r10 = (double) r10
            double r10 = r10 * r12
            long r6 = r6 - r8
            double r6 = (double) r6
            double r10 = r10 / r6
        L_0x00d7:
            r22 = r10
            long r6 = r1.mLastFrameTime
            double r6 = (double) r6
            long r8 = r1.mFirstFrameTime
            double r8 = (double) r8
            double r6 = r6 - r8
            int r6 = (int) r6
            int r24 = r6 / r2
            r15 = r3
            r16 = r4
            r18 = r0
            r19 = r5
            r15.<init>(r16, r17, r18, r19, r20, r22, r24)
            java.util.TreeMap<java.lang.Long, com.facebook.react.modules.debug.FpsDebugFrameCallback$FpsInfo> r2 = r1.mTimeToFps
            long r4 = java.lang.System.currentTimeMillis()
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r2.put(r4, r3)
        L_0x00fa:
            r1.mExpectedNumFramesPrev = r0
            com.facebook.react.modules.core.ChoreographerCompat r0 = r1.mChoreographer
            if (r0 == 0) goto L_0x0103
            r0.postFrameCallback(r1)
        L_0x0103:
            return
        L_0x0104:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.debug.FpsDebugFrameCallback.doFrame(long):void");
    }

    public void stop() {
        this.mShouldStop = true;
        this.mReactContext.getCatalystInstance().removeBridgeIdleDebugListener(this.mDidJSUpdateUiDuringFrameDetector);
        this.mUIManagerModule.setViewHierarchyUpdateDebugListener(null);
    }
}
