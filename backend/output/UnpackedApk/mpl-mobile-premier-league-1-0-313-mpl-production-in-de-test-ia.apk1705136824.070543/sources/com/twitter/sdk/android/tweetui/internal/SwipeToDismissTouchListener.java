package com.twitter.sdk.android.tweetui.internal;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;

public class SwipeToDismissTouchListener implements OnTouchListener {
    public Callback callback;
    public final float closeThreshold;
    public float initialY;
    public boolean isMoving;
    public float lastX;
    public float lastY;
    public final float maxTranslate;
    public int pointerIndex;
    public int touchSlop;

    public interface Callback {
        void onDismiss();

        void onMove(float f2);
    }

    public interface SwipeableViewProvider {
        boolean canBeSwiped();
    }

    public SwipeToDismissTouchListener(Callback callback2, int i, float f2) {
        this.callback = callback2;
        this.touchSlop = i;
        this.maxTranslate = f2;
        this.closeThreshold = 0.2f * f2;
    }

    public static SwipeToDismissTouchListener createFromView(View view, Callback callback2) {
        return new SwipeToDismissTouchListener(callback2, ViewConfiguration.get(view.getContext()).getScaledTouchSlop(), ((float) view.getContext().getResources().getDisplayMetrics().heightPixels) * 0.5f);
    }

    public /* synthetic */ void lambda$settleView$0$SwipeToDismissTouchListener(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        Callback callback2 = this.callback;
        if (callback2 != null) {
            callback2.onMove(floatValue);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x007c, code lost:
        if ((java.lang.Math.abs(r6) > java.lang.Math.abs(r5)) != false) goto L_0x007e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:71:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r12, android.view.MotionEvent r13) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener.SwipeableViewProvider
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0017
            r0 = r12
            com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener$SwipeableViewProvider r0 = (com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener.SwipeableViewProvider) r0
            boolean r0 = r0.canBeSwiped()
            if (r0 != 0) goto L_0x0017
            boolean r0 = r11.isMoving
            if (r0 == 0) goto L_0x0014
            goto L_0x0017
        L_0x0014:
            r0 = 0
            goto L_0x010e
        L_0x0017:
            int r0 = r13.getActionMasked()
            if (r0 == 0) goto L_0x00f1
            if (r0 == r1) goto L_0x00bd
            r3 = 2
            if (r0 == r3) goto L_0x0032
            r3 = 3
            if (r0 == r3) goto L_0x00bd
            r3 = 5
            if (r0 == r3) goto L_0x0029
            goto L_0x0014
        L_0x0029:
            r11.settleView(r12)
            r11.isMoving = r2
            r0 = -1
            r11.pointerIndex = r0
            goto L_0x0014
        L_0x0032:
            float r0 = r13.getRawX()
            float r3 = r13.getRawY()
            float r4 = r11.initialY
            float r4 = r3 - r4
            float r5 = r11.lastX
            float r5 = r0 - r5
            float r6 = r11.lastY
            float r6 = r3 - r6
            r11.lastX = r0
            r11.lastY = r3
            int r0 = r11.pointerIndex
            if (r0 < 0) goto L_0x0056
            int r0 = r13.getPointerCount()
            if (r0 != r1) goto L_0x0056
            r0 = 1
            goto L_0x0057
        L_0x0056:
            r0 = 0
        L_0x0057:
            if (r0 == 0) goto L_0x0014
            boolean r0 = r11.isMoving
            if (r0 != 0) goto L_0x007e
            float r0 = java.lang.Math.abs(r4)
            int r3 = r11.touchSlop
            float r3 = (float) r3
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x006a
            r0 = 1
            goto L_0x006b
        L_0x006a:
            r0 = 0
        L_0x006b:
            if (r0 == 0) goto L_0x0014
            float r0 = java.lang.Math.abs(r6)
            float r3 = java.lang.Math.abs(r5)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x007b
            r0 = 1
            goto L_0x007c
        L_0x007b:
            r0 = 0
        L_0x007c:
            if (r0 == 0) goto L_0x0014
        L_0x007e:
            r11.isMoving = r1
            float r0 = r12.getTranslationY()
            double r3 = (double) r6
            float r5 = java.lang.Math.abs(r0)
            float r6 = r11.closeThreshold
            r7 = 1073741824(0x40000000, float:2.0)
            float r6 = r6 * r7
            double r7 = (double) r5
            r9 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r7 = java.lang.Math.pow(r7, r9)
            double r5 = (double) r6
            double r5 = java.lang.Math.pow(r5, r9)
            double r7 = r7 / r5
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r5 = r5 - r7
            double r5 = r5 * r3
            float r3 = (float) r5
            float r0 = r0 + r3
            float r3 = r11.maxTranslate
            float r4 = -r3
            int r5 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r5 >= 0) goto L_0x00ac
            r0 = r4
            goto L_0x00b1
        L_0x00ac:
            int r4 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r4 <= 0) goto L_0x00b1
            r0 = r3
        L_0x00b1:
            r12.setTranslationY(r0)
            com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener$Callback r3 = r11.callback
            if (r3 == 0) goto L_0x0014
            r3.onMove(r0)
            goto L_0x0014
        L_0x00bd:
            int r0 = r11.pointerIndex
            if (r0 < 0) goto L_0x00c9
            int r0 = r13.getPointerCount()
            if (r0 != r1) goto L_0x00c9
            r0 = 1
            goto L_0x00ca
        L_0x00c9:
            r0 = 0
        L_0x00ca:
            if (r0 == 0) goto L_0x00ed
            boolean r0 = r11.isMoving
            if (r0 == 0) goto L_0x00ed
            float r0 = r12.getTranslationY()
            float r3 = r11.closeThreshold
            int r4 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r4 > 0) goto L_0x00e4
            float r3 = -r3
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x00e0
            goto L_0x00e4
        L_0x00e0:
            r11.settleView(r12)
            goto L_0x00ed
        L_0x00e4:
            com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener$Callback r0 = r11.callback
            if (r0 == 0) goto L_0x00eb
            r0.onDismiss()
        L_0x00eb:
            r0 = 1
            goto L_0x00ee
        L_0x00ed:
            r0 = 0
        L_0x00ee:
            r11.isMoving = r2
            goto L_0x010e
        L_0x00f1:
            float r0 = r13.getRawX()
            r11.lastX = r0
            float r0 = r13.getRawY()
            r11.lastY = r0
            r11.initialY = r0
            r11.isMoving = r2
            int r0 = r13.getPointerCount()
            int r0 = r0 - r1
            int r0 = r13.getPointerId(r0)
            r11.pointerIndex = r0
            goto L_0x0014
        L_0x010e:
            if (r0 != 0) goto L_0x0118
            boolean r12 = r12.onTouchEvent(r13)
            if (r12 == 0) goto L_0x0117
            goto L_0x0118
        L_0x0117:
            r1 = 0
        L_0x0118:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void settleView(View view) {
        if (view.getTranslationY() != 0.0f) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, new float[]{0.0f}).setDuration(100);
            duration.addUpdateListener(new AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    SwipeToDismissTouchListener.this.lambda$settleView$0$SwipeToDismissTouchListener(valueAnimator);
                }
            });
            duration.start();
        }
    }
}
