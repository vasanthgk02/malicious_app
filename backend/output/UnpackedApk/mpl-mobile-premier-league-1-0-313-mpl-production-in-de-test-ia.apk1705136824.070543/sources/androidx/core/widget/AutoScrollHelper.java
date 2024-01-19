package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;

public abstract class AutoScrollHelper implements OnTouchListener {
    public static final int DEFAULT_ACTIVATION_DELAY = ViewConfiguration.getTapTimeout();
    public int mActivationDelay;
    public boolean mAlreadyDelayed;
    public boolean mAnimating;
    public final Interpolator mEdgeInterpolator = new AccelerateInterpolator();
    public int mEdgeType;
    public boolean mEnabled;
    public float[] mMaximumEdges = {Float.MAX_VALUE, Float.MAX_VALUE};
    public float[] mMaximumVelocity = {Float.MAX_VALUE, Float.MAX_VALUE};
    public float[] mMinimumVelocity = {0.0f, 0.0f};
    public boolean mNeedsCancel;
    public boolean mNeedsReset;
    public float[] mRelativeEdges = {0.0f, 0.0f};
    public float[] mRelativeVelocity = {0.0f, 0.0f};
    public Runnable mRunnable;
    public final ClampedScroller mScroller = new ClampedScroller();
    public final View mTarget;

    public static class ClampedScroller {
        public long mDeltaTime = 0;
        public int mDeltaX = 0;
        public int mDeltaY = 0;
        public int mEffectiveRampDown;
        public int mRampDownDuration;
        public int mRampUpDuration;
        public long mStartTime = Long.MIN_VALUE;
        public long mStopTime = -1;
        public float mStopValue;
        public float mTargetVelocityX;
        public float mTargetVelocityY;

        public final float getValueAt(long j) {
            if (j < this.mStartTime) {
                return 0.0f;
            }
            long j2 = this.mStopTime;
            if (j2 < 0 || j < j2) {
                return AutoScrollHelper.constrain(((float) (j - this.mStartTime)) / ((float) this.mRampUpDuration), 0.0f, 1.0f) * 0.5f;
            }
            long j3 = j - j2;
            float f2 = this.mStopValue;
            return (AutoScrollHelper.constrain(((float) j3) / ((float) this.mEffectiveRampDown), 0.0f, 1.0f) * f2) + (1.0f - f2);
        }
    }

    public class ScrollAnimationRunnable implements Runnable {
        public ScrollAnimationRunnable() {
        }

        public void run() {
            AutoScrollHelper autoScrollHelper = AutoScrollHelper.this;
            if (autoScrollHelper.mAnimating) {
                if (autoScrollHelper.mNeedsReset) {
                    autoScrollHelper.mNeedsReset = false;
                    ClampedScroller clampedScroller = autoScrollHelper.mScroller;
                    if (clampedScroller != null) {
                        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                        clampedScroller.mStartTime = currentAnimationTimeMillis;
                        clampedScroller.mStopTime = -1;
                        clampedScroller.mDeltaTime = currentAnimationTimeMillis;
                        clampedScroller.mStopValue = 0.5f;
                        clampedScroller.mDeltaX = 0;
                        clampedScroller.mDeltaY = 0;
                    } else {
                        throw null;
                    }
                }
                ClampedScroller clampedScroller2 = AutoScrollHelper.this.mScroller;
                if ((clampedScroller2.mStopTime > 0 && AnimationUtils.currentAnimationTimeMillis() > clampedScroller2.mStopTime + ((long) clampedScroller2.mEffectiveRampDown)) || !AutoScrollHelper.this.shouldAnimate()) {
                    AutoScrollHelper.this.mAnimating = false;
                    return;
                }
                AutoScrollHelper autoScrollHelper2 = AutoScrollHelper.this;
                if (autoScrollHelper2.mNeedsCancel) {
                    autoScrollHelper2.mNeedsCancel = false;
                    if (autoScrollHelper2 != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                        autoScrollHelper2.mTarget.onTouchEvent(obtain);
                        obtain.recycle();
                    } else {
                        throw null;
                    }
                }
                if (clampedScroller2.mDeltaTime != 0) {
                    long currentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                    float valueAt = clampedScroller2.getValueAt(currentAnimationTimeMillis2);
                    clampedScroller2.mDeltaTime = currentAnimationTimeMillis2;
                    float f2 = ((float) (currentAnimationTimeMillis2 - clampedScroller2.mDeltaTime)) * ((valueAt * 4.0f) + (-4.0f * valueAt * valueAt));
                    clampedScroller2.mDeltaX = (int) (clampedScroller2.mTargetVelocityX * f2);
                    int i = (int) (f2 * clampedScroller2.mTargetVelocityY);
                    clampedScroller2.mDeltaY = i;
                    ((ListViewAutoScrollHelper) AutoScrollHelper.this).mTarget.scrollListBy(i);
                    ViewCompat.postOnAnimation(AutoScrollHelper.this.mTarget, this);
                    return;
                }
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
        }
    }

    public AutoScrollHelper(View view) {
        this.mTarget = view;
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        float[] fArr = this.mMaximumVelocity;
        float f3 = ((float) ((int) ((1575.0f * f2) + 0.5f))) / 1000.0f;
        fArr[0] = f3;
        fArr[1] = f3;
        float[] fArr2 = this.mMinimumVelocity;
        float f4 = ((float) ((int) ((f2 * 315.0f) + 0.5f))) / 1000.0f;
        fArr2[0] = f4;
        fArr2[1] = f4;
        this.mEdgeType = 1;
        float[] fArr3 = this.mMaximumEdges;
        fArr3[0] = Float.MAX_VALUE;
        fArr3[1] = Float.MAX_VALUE;
        float[] fArr4 = this.mRelativeEdges;
        fArr4[0] = 0.2f;
        fArr4[1] = 0.2f;
        float[] fArr5 = this.mRelativeVelocity;
        fArr5[0] = 0.001f;
        fArr5[1] = 0.001f;
        this.mActivationDelay = DEFAULT_ACTIVATION_DELAY;
        ClampedScroller clampedScroller = this.mScroller;
        clampedScroller.mRampUpDuration = 500;
        clampedScroller.mRampDownDuration = 500;
    }

    public static float constrain(float f2, float f3, float f4) {
        return f2 > f4 ? f4 : f2 < f3 ? f3 : f2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final float computeTargetVelocity(int r4, float r5, float r6, float r7) {
        /*
            r3 = this;
            float[] r0 = r3.mRelativeEdges
            r0 = r0[r4]
            float[] r1 = r3.mMaximumEdges
            r1 = r1[r4]
            float r0 = r0 * r6
            r2 = 0
            float r0 = constrain(r0, r2, r1)
            float r1 = r3.constrainEdgeValue(r5, r0)
            float r6 = r6 - r5
            float r5 = r3.constrainEdgeValue(r6, r0)
            float r5 = r5 - r1
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 >= 0) goto L_0x0026
            android.view.animation.Interpolator r6 = r3.mEdgeInterpolator
            float r5 = -r5
            float r5 = r6.getInterpolation(r5)
            float r5 = -r5
            goto L_0x0030
        L_0x0026:
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 <= 0) goto L_0x0039
            android.view.animation.Interpolator r6 = r3.mEdgeInterpolator
            float r5 = r6.getInterpolation(r5)
        L_0x0030:
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            float r5 = constrain(r5, r6, r0)
            goto L_0x003a
        L_0x0039:
            r5 = 0
        L_0x003a:
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x003f
            return r2
        L_0x003f:
            float[] r0 = r3.mRelativeVelocity
            r0 = r0[r4]
            float[] r1 = r3.mMinimumVelocity
            r1 = r1[r4]
            float[] r2 = r3.mMaximumVelocity
            r4 = r2[r4]
            float r0 = r0 * r7
            if (r6 <= 0) goto L_0x0056
            float r5 = r5 * r0
            float r4 = constrain(r5, r1, r4)
            return r4
        L_0x0056:
            float r5 = -r5
            float r5 = r5 * r0
            float r4 = constrain(r5, r1, r4)
            float r4 = -r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.AutoScrollHelper.computeTargetVelocity(int, float, float, float):float");
    }

    public final float constrainEdgeValue(float f2, float f3) {
        if (f3 == 0.0f) {
            return 0.0f;
        }
        int i = this.mEdgeType;
        if (i == 0 || i == 1) {
            if (f2 < f3) {
                if (f2 >= 0.0f) {
                    return 1.0f - (f2 / f3);
                }
                return (!this.mAnimating || this.mEdgeType != 1) ? 0.0f : 1.0f;
            }
        } else if (i == 2 && f2 < 0.0f) {
            return f2 / (-f3);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r0 != 3) goto L_0x007d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.mEnabled
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L_0x001a
            if (r0 == r2) goto L_0x0016
            r3 = 2
            if (r0 == r3) goto L_0x001e
            r6 = 3
            if (r0 == r6) goto L_0x0016
            goto L_0x007d
        L_0x0016:
            r5.requestStop()
            goto L_0x007d
        L_0x001a:
            r5.mNeedsCancel = r2
            r5.mAlreadyDelayed = r1
        L_0x001e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.mTarget
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.computeTargetVelocity(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.mTarget
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.computeTargetVelocity(r2, r7, r6, r3)
            androidx.core.widget.AutoScrollHelper$ClampedScroller r7 = r5.mScroller
            r7.mTargetVelocityX = r0
            r7.mTargetVelocityY = r6
            boolean r6 = r5.mAnimating
            if (r6 != 0) goto L_0x007d
            boolean r6 = r5.shouldAnimate()
            if (r6 == 0) goto L_0x007d
            java.lang.Runnable r6 = r5.mRunnable
            if (r6 != 0) goto L_0x0061
            androidx.core.widget.AutoScrollHelper$ScrollAnimationRunnable r6 = new androidx.core.widget.AutoScrollHelper$ScrollAnimationRunnable
            r6.<init>()
            r5.mRunnable = r6
        L_0x0061:
            r5.mAnimating = r2
            r5.mNeedsReset = r2
            boolean r6 = r5.mAlreadyDelayed
            if (r6 != 0) goto L_0x0076
            int r6 = r5.mActivationDelay
            if (r6 <= 0) goto L_0x0076
            android.view.View r7 = r5.mTarget
            java.lang.Runnable r0 = r5.mRunnable
            long r3 = (long) r6
            androidx.core.view.ViewCompat.postOnAnimationDelayed(r7, r0, r3)
            goto L_0x007b
        L_0x0076:
            java.lang.Runnable r6 = r5.mRunnable
            r6.run()
        L_0x007b:
            r5.mAlreadyDelayed = r2
        L_0x007d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.AutoScrollHelper.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public final void requestStop() {
        int i = 0;
        if (this.mNeedsReset) {
            this.mAnimating = false;
            return;
        }
        ClampedScroller clampedScroller = this.mScroller;
        if (clampedScroller != null) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            int i2 = (int) (currentAnimationTimeMillis - clampedScroller.mStartTime);
            int i3 = clampedScroller.mRampDownDuration;
            if (i2 > i3) {
                i = i3;
            } else if (i2 >= 0) {
                i = i2;
            }
            clampedScroller.mEffectiveRampDown = i;
            clampedScroller.mStopValue = clampedScroller.getValueAt(currentAnimationTimeMillis);
            clampedScroller.mStopTime = currentAnimationTimeMillis;
            return;
        }
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean shouldAnimate() {
        /*
            r9 = this;
            androidx.core.widget.AutoScrollHelper$ClampedScroller r0 = r9.mScroller
            float r1 = r0.mTargetVelocityY
            float r2 = java.lang.Math.abs(r1)
            float r1 = r1 / r2
            int r1 = (int) r1
            float r0 = r0.mTargetVelocityX
            float r2 = java.lang.Math.abs(r0)
            float r0 = r0 / r2
            int r0 = (int) r0
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0053
            r4 = r9
            androidx.core.widget.ListViewAutoScrollHelper r4 = (androidx.core.widget.ListViewAutoScrollHelper) r4
            android.widget.ListView r4 = r4.mTarget
            int r5 = r4.getCount()
            if (r5 != 0) goto L_0x0023
        L_0x0021:
            r1 = 0
            goto L_0x0051
        L_0x0023:
            int r6 = r4.getChildCount()
            int r7 = r4.getFirstVisiblePosition()
            int r8 = r7 + r6
            if (r1 <= 0) goto L_0x0041
            if (r8 < r5) goto L_0x0050
            int r6 = r6 - r2
            android.view.View r1 = r4.getChildAt(r6)
            int r1 = r1.getBottom()
            int r4 = r4.getHeight()
            if (r1 > r4) goto L_0x0050
            goto L_0x0021
        L_0x0041:
            if (r1 >= 0) goto L_0x0021
            if (r7 > 0) goto L_0x0050
            android.view.View r1 = r4.getChildAt(r3)
            int r1 = r1.getTop()
            if (r1 < 0) goto L_0x0050
            goto L_0x0021
        L_0x0050:
            r1 = 1
        L_0x0051:
            if (r1 != 0) goto L_0x0054
        L_0x0053:
            r2 = 0
        L_0x0054:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.AutoScrollHelper.shouldAnimate():boolean");
    }
}
