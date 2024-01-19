package com.facebook.fresco.animation.drawable;

import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.drawable.base.DrawableWithCaches;
import com.facebook.drawee.drawable.DrawableProperties;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.frame.DropFramesFrameScheduler;

public class AnimatedDrawable2 extends Drawable implements Animatable, DrawableWithCaches {
    public static final BaseAnimationListener NO_OP_LISTENER = new BaseAnimationListener();
    public static final Class<?> TAG = AnimatedDrawable2.class;
    public AnimationBackend mAnimationBackend;
    public volatile BaseAnimationListener mAnimationListener;
    public volatile DrawListener mDrawListener;
    public DrawableProperties mDrawableProperties;
    public int mDroppedFrames;
    public long mExpectedRenderTimeMs;
    public DropFramesFrameScheduler mFrameScheduler;
    public long mFrameSchedulingDelayMs;
    public long mFrameSchedulingOffsetMs;
    public final Runnable mInvalidateRunnable;
    public volatile boolean mIsRunning;
    public int mLastDrawnFrameNumber;
    public long mLastFrameAnimationTimeMs;
    public long mStartTimeMs;

    public interface DrawListener {
        void onDraw(AnimatedDrawable2 animatedDrawable2, DropFramesFrameScheduler dropFramesFrameScheduler, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
    }

    public AnimatedDrawable2() {
        this(null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0121  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(android.graphics.Canvas r27) {
        /*
            r26 = this;
            r14 = r26
            com.facebook.fresco.animation.backend.AnimationBackend r0 = r14.mAnimationBackend
            if (r0 == 0) goto L_0x0153
            com.facebook.fresco.animation.frame.DropFramesFrameScheduler r0 = r14.mFrameScheduler
            if (r0 != 0) goto L_0x000c
            goto L_0x0153
        L_0x000c:
            long r12 = android.os.SystemClock.uptimeMillis()
            boolean r0 = r14.mIsRunning
            r1 = 0
            if (r0 == 0) goto L_0x001e
            long r3 = r14.mStartTimeMs
            long r3 = r12 - r3
            long r5 = r14.mFrameSchedulingOffsetMs
            long r3 = r3 + r5
            goto L_0x0024
        L_0x001e:
            long r3 = r14.mLastFrameAnimationTimeMs
            long r3 = java.lang.Math.max(r3, r1)
        L_0x0024:
            r8 = r3
            com.facebook.fresco.animation.frame.DropFramesFrameScheduler r0 = r14.mFrameScheduler
            com.facebook.fresco.animation.backend.AnimationInformation r3 = r0.mAnimationInformation
            int r3 = r3.getLoopCount()
            r4 = 1
            if (r3 != 0) goto L_0x0032
            r3 = 1
            goto L_0x0033
        L_0x0032:
            r3 = 0
        L_0x0033:
            if (r3 != 0) goto L_0x0049
            long r10 = r0.getLoopDurationMs()
            long r10 = r8 / r10
            com.facebook.fresco.animation.backend.AnimationInformation r3 = r0.mAnimationInformation
            int r3 = r3.getLoopCount()
            long r1 = (long) r3
            int r3 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r3 < 0) goto L_0x0049
            r3 = -1
            r5 = -1
            goto L_0x0061
        L_0x0049:
            long r1 = r0.getLoopDurationMs()
            long r1 = r8 % r1
            r3 = 0
            r10 = 0
        L_0x0052:
            com.facebook.fresco.animation.backend.AnimationInformation r7 = r0.mAnimationInformation
            int r7 = r7.getFrameDurationMs(r3)
            long r5 = (long) r7
            long r10 = r10 + r5
            int r3 = r3 + r4
            int r5 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r5 >= 0) goto L_0x014d
            r5 = -1
            int r3 = r3 + r5
        L_0x0061:
            r0 = 0
            if (r3 != r5) goto L_0x0075
            com.facebook.fresco.animation.backend.AnimationBackend r1 = r14.mAnimationBackend
            int r1 = r1.getFrameCount()
            int r1 = r1 - r4
            com.facebook.fresco.animation.drawable.BaseAnimationListener r2 = r14.mAnimationListener
            if (r2 == 0) goto L_0x0074
            r6 = 0
            r14.mIsRunning = r6
            r3 = r1
            goto L_0x0088
        L_0x0074:
            throw r0
        L_0x0075:
            r6 = 0
            if (r3 != 0) goto L_0x0088
            int r1 = r14.mLastDrawnFrameNumber
            if (r1 == r5) goto L_0x0088
            long r1 = r14.mExpectedRenderTimeMs
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 < 0) goto L_0x0088
            com.facebook.fresco.animation.drawable.BaseAnimationListener r1 = r14.mAnimationListener
            if (r1 == 0) goto L_0x0087
            goto L_0x0088
        L_0x0087:
            throw r0
        L_0x0088:
            com.facebook.fresco.animation.backend.AnimationBackend r1 = r14.mAnimationBackend
            r7 = r27
            boolean r17 = r1.drawFrame(r14, r7, r3)
            if (r17 == 0) goto L_0x009a
            com.facebook.fresco.animation.drawable.BaseAnimationListener r1 = r14.mAnimationListener
            if (r1 == 0) goto L_0x0099
            r14.mLastDrawnFrameNumber = r3
            goto L_0x009a
        L_0x0099:
            throw r0
        L_0x009a:
            if (r17 != 0) goto L_0x00b5
            int r0 = r14.mDroppedFrames
            int r0 = r0 + r4
            r14.mDroppedFrames = r0
            r0 = 2
            boolean r0 = com.facebook.common.logging.FLog.isLoggable(r0)
            if (r0 == 0) goto L_0x00b5
            java.lang.Class<?> r0 = TAG
            int r1 = r14.mDroppedFrames
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r2 = "Dropped a frame. Count: %s"
            com.facebook.common.logging.FLog.v(r0, r2, r1)
        L_0x00b5:
            long r18 = android.os.SystemClock.uptimeMillis()
            boolean r0 = r14.mIsRunning
            if (r0 == 0) goto L_0x0127
            com.facebook.fresco.animation.frame.DropFramesFrameScheduler r0 = r14.mFrameScheduler
            long r10 = r14.mStartTimeMs
            long r10 = r18 - r10
            long r20 = r0.getLoopDurationMs()
            r15 = 0
            int r5 = (r20 > r15 ? 1 : (r20 == r15 ? 0 : -1))
            if (r5 != 0) goto L_0x00ce
            goto L_0x00eb
        L_0x00ce:
            com.facebook.fresco.animation.backend.AnimationInformation r5 = r0.mAnimationInformation
            int r5 = r5.getLoopCount()
            if (r5 != 0) goto L_0x00d7
            goto L_0x00d8
        L_0x00d7:
            r4 = 0
        L_0x00d8:
            if (r4 != 0) goto L_0x00f0
            long r4 = r0.getLoopDurationMs()
            long r4 = r10 / r4
            com.facebook.fresco.animation.backend.AnimationInformation r7 = r0.mAnimationInformation
            int r7 = r7.getLoopCount()
            long r6 = (long) r7
            int r23 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r23 < 0) goto L_0x00f0
        L_0x00eb:
            r0 = -1
            r15 = -1
            goto L_0x010e
        L_0x00f0:
            long r4 = r10 % r20
            com.facebook.fresco.animation.backend.AnimationInformation r6 = r0.mAnimationInformation
            int r6 = r6.getFrameCount()
            r7 = 0
        L_0x00f9:
            if (r7 >= r6) goto L_0x010a
            int r20 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r20 > 0) goto L_0x010a
            com.facebook.fresco.animation.backend.AnimationInformation r1 = r0.mAnimationInformation
            int r1 = r1.getFrameDurationMs(r7)
            long r1 = (long) r1
            long r15 = r15 + r1
            int r7 = r7 + 1
            goto L_0x00f9
        L_0x010a:
            long r15 = r15 - r4
            long r15 = r15 + r10
            r0 = -1
        L_0x010e:
            int r2 = (r15 > r0 ? 1 : (r15 == r0 ? 0 : -1))
            if (r2 == 0) goto L_0x0121
            long r0 = r14.mFrameSchedulingDelayMs
            long r1 = r15 + r0
            long r4 = r14.mStartTimeMs
            long r4 = r4 + r1
            r14.mExpectedRenderTimeMs = r4
            java.lang.Runnable r0 = r14.mInvalidateRunnable
            r14.scheduleSelf(r0, r4)
            goto L_0x0122
        L_0x0121:
            r1 = r0
        L_0x0122:
            r22 = r1
            r20 = r15
            goto L_0x012d
        L_0x0127:
            r0 = -1
            r20 = r0
            r22 = r20
        L_0x012d:
            com.facebook.fresco.animation.drawable.AnimatedDrawable2$DrawListener r0 = r14.mDrawListener
            if (r0 == 0) goto L_0x0148
            com.facebook.fresco.animation.frame.DropFramesFrameScheduler r2 = r14.mFrameScheduler
            boolean r5 = r14.mIsRunning
            long r6 = r14.mStartTimeMs
            long r10 = r14.mLastFrameAnimationTimeMs
            r1 = r26
            r4 = r17
            r24 = r8
            r14 = r18
            r16 = r20
            r18 = r22
            r0.onDraw(r1, r2, r3, r4, r5, r6, r8, r10, r12, r14, r16, r18)
        L_0x0148:
            r6 = r26
            r6.mLastFrameAnimationTimeMs = r8
            return
        L_0x014d:
            r7 = r27
            r15 = 0
            goto L_0x0052
        L_0x0153:
            r6 = r14
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fresco.animation.drawable.AnimatedDrawable2.draw(android.graphics.Canvas):void");
    }

    public void dropCaches() {
        AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend != null) {
            animationBackend.clear();
        }
    }

    public int getIntrinsicHeight() {
        AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend == null) {
            return super.getIntrinsicHeight();
        }
        return animationBackend.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend == null) {
            return super.getIntrinsicWidth();
        }
        return animationBackend.getIntrinsicWidth();
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend != null) {
            animationBackend.setBounds(rect);
        }
    }

    public boolean onLevelChange(int i) {
        if (this.mIsRunning) {
            return false;
        }
        long j = (long) i;
        if (this.mLastFrameAnimationTimeMs == j) {
            return false;
        }
        this.mLastFrameAnimationTimeMs = j;
        invalidateSelf();
        return true;
    }

    public void setAlpha(int i) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new DrawableProperties();
        }
        this.mDrawableProperties.mAlpha = i;
        AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend != null) {
            animationBackend.setAlpha(i);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new DrawableProperties();
        }
        DrawableProperties drawableProperties = this.mDrawableProperties;
        drawableProperties.mColorFilter = colorFilter;
        drawableProperties.mIsSetColorFilter = true;
        AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend != null) {
            animationBackend.setColorFilter(colorFilter);
        }
    }

    public void start() {
        if (!this.mIsRunning) {
            AnimationBackend animationBackend = this.mAnimationBackend;
            if (animationBackend != null && animationBackend.getFrameCount() > 1) {
                this.mIsRunning = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.mStartTimeMs = uptimeMillis;
                this.mExpectedRenderTimeMs = uptimeMillis;
                this.mLastFrameAnimationTimeMs = -1;
                this.mLastDrawnFrameNumber = -1;
                invalidateSelf();
                if (this.mAnimationListener == null) {
                    throw null;
                }
            }
        }
    }

    public void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mStartTimeMs = 0;
            this.mExpectedRenderTimeMs = 0;
            this.mLastFrameAnimationTimeMs = -1;
            this.mLastDrawnFrameNumber = -1;
            unscheduleSelf(this.mInvalidateRunnable);
            if (this.mAnimationListener == null) {
                throw null;
            }
        }
    }

    public AnimatedDrawable2(AnimationBackend animationBackend) {
        this.mFrameSchedulingDelayMs = 8;
        this.mFrameSchedulingOffsetMs = 0;
        this.mAnimationListener = NO_OP_LISTENER;
        DropFramesFrameScheduler dropFramesFrameScheduler = null;
        this.mDrawListener = null;
        this.mInvalidateRunnable = new Runnable() {
            public void run() {
                AnimatedDrawable2 animatedDrawable2 = AnimatedDrawable2.this;
                animatedDrawable2.unscheduleSelf(animatedDrawable2.mInvalidateRunnable);
                AnimatedDrawable2.this.invalidateSelf();
            }
        };
        this.mAnimationBackend = animationBackend;
        this.mFrameScheduler = animationBackend != null ? new DropFramesFrameScheduler(animationBackend) : dropFramesFrameScheduler;
    }
}
