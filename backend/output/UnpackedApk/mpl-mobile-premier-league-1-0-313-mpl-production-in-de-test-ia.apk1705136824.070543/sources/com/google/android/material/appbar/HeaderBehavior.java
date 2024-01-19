package com.google.android.material.appbar;

import a.a.a.a.d.b;
import android.content.Context;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.appbar.AppBarLayout.BaseBehavior;

public abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    public int activePointerId = -1;
    public Runnable flingRunnable;
    public boolean isBeingDragged;
    public int lastMotionY;
    public OverScroller scroller;
    public int touchSlop = -1;
    public VelocityTracker velocityTracker;

    public class FlingRunnable implements Runnable {
        public final V layout;
        public final CoordinatorLayout parent;

        public FlingRunnable(CoordinatorLayout coordinatorLayout, V v) {
            this.parent = coordinatorLayout;
            this.layout = v;
        }

        public void run() {
            if (this.layout != null) {
                OverScroller overScroller = HeaderBehavior.this.scroller;
                if (overScroller == null) {
                    return;
                }
                if (overScroller.computeScrollOffset()) {
                    HeaderBehavior headerBehavior = HeaderBehavior.this;
                    headerBehavior.setHeaderTopBottomOffset(this.parent, this.layout, headerBehavior.scroller.getCurrY());
                    this.layout.postOnAnimation(this);
                    return;
                }
                HeaderBehavior headerBehavior2 = HeaderBehavior.this;
                CoordinatorLayout coordinatorLayout = this.parent;
                V v = this.layout;
                BaseBehavior baseBehavior = (BaseBehavior) headerBehavior2;
                if (baseBehavior != null) {
                    AppBarLayout appBarLayout = (AppBarLayout) v;
                    baseBehavior.snapToChildIfNeeded(coordinatorLayout, appBarLayout);
                    if (appBarLayout.liftOnScroll) {
                        appBarLayout.setLiftedState(appBarLayout.shouldLift(baseBehavior.findFirstScrollingChild(coordinatorLayout)));
                        return;
                    }
                    return;
                }
                throw null;
            }
        }
    }

    public HeaderBehavior() {
    }

    public int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset();
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0083  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout r8, V r9, android.view.MotionEvent r10) {
        /*
            r7 = this;
            int r0 = r7.touchSlop
            if (r0 >= 0) goto L_0x0012
            android.content.Context r0 = r8.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r7.touchSlop = r0
        L_0x0012:
            int r0 = r10.getActionMasked()
            r1 = 2
            r2 = -1
            r3 = 0
            r4 = 1
            if (r0 != r1) goto L_0x0040
            boolean r0 = r7.isBeingDragged
            if (r0 == 0) goto L_0x0040
            int r0 = r7.activePointerId
            if (r0 != r2) goto L_0x0025
            return r3
        L_0x0025:
            int r0 = r10.findPointerIndex(r0)
            if (r0 != r2) goto L_0x002c
            return r3
        L_0x002c:
            float r0 = r10.getY(r0)
            int r0 = (int) r0
            int r1 = r7.lastMotionY
            int r1 = r0 - r1
            int r1 = java.lang.Math.abs(r1)
            int r5 = r7.touchSlop
            if (r1 <= r5) goto L_0x0040
            r7.lastMotionY = r0
            return r4
        L_0x0040:
            int r0 = r10.getActionMasked()
            if (r0 != 0) goto L_0x00a5
            r7.activePointerId = r2
            float r0 = r10.getX()
            int r0 = (int) r0
            float r1 = r10.getY()
            int r1 = (int) r1
            r5 = r7
            com.google.android.material.appbar.AppBarLayout$BaseBehavior r5 = (com.google.android.material.appbar.AppBarLayout.BaseBehavior) r5
            r6 = r9
            com.google.android.material.appbar.AppBarLayout r6 = (com.google.android.material.appbar.AppBarLayout) r6
            java.lang.ref.WeakReference<android.view.View> r5 = r5.lastNestedScrollingChildRef
            if (r5 == 0) goto L_0x0073
            java.lang.Object r5 = r5.get()
            android.view.View r5 = (android.view.View) r5
            if (r5 == 0) goto L_0x0071
            boolean r6 = r5.isShown()
            if (r6 == 0) goto L_0x0071
            boolean r2 = r5.canScrollVertically(r2)
            if (r2 != 0) goto L_0x0071
            goto L_0x0073
        L_0x0071:
            r2 = 0
            goto L_0x0074
        L_0x0073:
            r2 = 1
        L_0x0074:
            if (r2 == 0) goto L_0x007e
            boolean r8 = r8.isPointInChildBounds(r9, r0, r1)
            if (r8 == 0) goto L_0x007e
            r8 = 1
            goto L_0x007f
        L_0x007e:
            r8 = 0
        L_0x007f:
            r7.isBeingDragged = r8
            if (r8 == 0) goto L_0x00a5
            r7.lastMotionY = r1
            int r8 = r10.getPointerId(r3)
            r7.activePointerId = r8
            android.view.VelocityTracker r8 = r7.velocityTracker
            if (r8 != 0) goto L_0x0095
            android.view.VelocityTracker r8 = android.view.VelocityTracker.obtain()
            r7.velocityTracker = r8
        L_0x0095:
            android.widget.OverScroller r8 = r7.scroller
            if (r8 == 0) goto L_0x00a5
            boolean r8 = r8.isFinished()
            if (r8 != 0) goto L_0x00a5
            android.widget.OverScroller r8 = r7.scroller
            r8.abortAnimation()
            return r4
        L_0x00a5:
            android.view.VelocityTracker r8 = r7.velocityTracker
            if (r8 == 0) goto L_0x00ac
            r8.addMovement(r10)
        L_0x00ac:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.HeaderBehavior.onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout r21, V r22, android.view.MotionEvent r23) {
        /*
            r20 = this;
            r6 = r20
            r1 = r21
            r2 = r22
            r7 = r23
            int r0 = r23.getActionMasked()
            r8 = 1
            r9 = 0
            r3 = 0
            r4 = -1
            if (r0 == r8) goto L_0x005e
            r5 = 2
            if (r0 == r5) goto L_0x0036
            r1 = 3
            if (r0 == r1) goto L_0x00d5
            r1 = 6
            if (r0 == r1) goto L_0x001c
            goto L_0x005b
        L_0x001c:
            int r0 = r23.getActionIndex()
            if (r0 != 0) goto L_0x0024
            r0 = 1
            goto L_0x0025
        L_0x0024:
            r0 = 0
        L_0x0025:
            int r1 = r7.getPointerId(r0)
            r6.activePointerId = r1
            float r0 = r7.getY(r0)
            r1 = 1056964608(0x3f000000, float:0.5)
            float r0 = r0 + r1
            int r0 = (int) r0
            r6.lastMotionY = r0
            goto L_0x005b
        L_0x0036:
            int r0 = r6.activePointerId
            int r0 = r7.findPointerIndex(r0)
            if (r0 != r4) goto L_0x003f
            return r9
        L_0x003f:
            float r0 = r7.getY(r0)
            int r0 = (int) r0
            int r3 = r6.lastMotionY
            int r3 = r3 - r0
            r6.lastMotionY = r0
            r0 = r2
            com.google.android.material.appbar.AppBarLayout r0 = (com.google.android.material.appbar.AppBarLayout) r0
            int r0 = r0.getDownNestedScrollRange()
            int r4 = -r0
            r5 = 0
            r0 = r20
            r1 = r21
            r2 = r22
            r0.scroll(r1, r2, r3, r4, r5)
        L_0x005b:
            r0 = 0
            goto L_0x00e3
        L_0x005e:
            android.view.VelocityTracker r0 = r6.velocityTracker
            if (r0 == 0) goto L_0x00d5
            r0.addMovement(r7)
            android.view.VelocityTracker r0 = r6.velocityTracker
            r5 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r5)
            android.view.VelocityTracker r0 = r6.velocityTracker
            int r5 = r6.activePointerId
            float r0 = r0.getYVelocity(r5)
            r5 = r2
            com.google.android.material.appbar.AppBarLayout r5 = (com.google.android.material.appbar.AppBarLayout) r5
            int r10 = r5.getTotalScrollRange()
            int r10 = -r10
            r19 = 0
            java.lang.Runnable r11 = r6.flingRunnable
            if (r11 == 0) goto L_0x0087
            r2.removeCallbacks(r11)
            r6.flingRunnable = r3
        L_0x0087:
            android.widget.OverScroller r11 = r6.scroller
            if (r11 != 0) goto L_0x0096
            android.widget.OverScroller r11 = new android.widget.OverScroller
            android.content.Context r12 = r22.getContext()
            r11.<init>(r12)
            r6.scroller = r11
        L_0x0096:
            android.widget.OverScroller r11 = r6.scroller
            r12 = 0
            int r13 = r20.getTopAndBottomOffset()
            r14 = 0
            int r15 = java.lang.Math.round(r0)
            r16 = 0
            r17 = 0
            r18 = r10
            r11.fling(r12, r13, r14, r15, r16, r17, r18, r19)
            android.widget.OverScroller r0 = r6.scroller
            boolean r0 = r0.computeScrollOffset()
            if (r0 == 0) goto L_0x00be
            com.google.android.material.appbar.HeaderBehavior$FlingRunnable r0 = new com.google.android.material.appbar.HeaderBehavior$FlingRunnable
            r0.<init>(r1, r2)
            r6.flingRunnable = r0
            androidx.core.view.ViewCompat.postOnAnimation(r2, r0)
            goto L_0x00d3
        L_0x00be:
            r0 = r6
            com.google.android.material.appbar.AppBarLayout$BaseBehavior r0 = (com.google.android.material.appbar.AppBarLayout.BaseBehavior) r0
            r0.snapToChildIfNeeded(r1, r5)
            boolean r2 = r5.liftOnScroll
            if (r2 == 0) goto L_0x00d3
            android.view.View r0 = r0.findFirstScrollingChild(r1)
            boolean r0 = r5.shouldLift(r0)
            r5.setLiftedState(r0)
        L_0x00d3:
            r0 = 1
            goto L_0x00d6
        L_0x00d5:
            r0 = 0
        L_0x00d6:
            r6.isBeingDragged = r9
            r6.activePointerId = r4
            android.view.VelocityTracker r1 = r6.velocityTracker
            if (r1 == 0) goto L_0x00e3
            r1.recycle()
            r6.velocityTracker = r3
        L_0x00e3:
            android.view.VelocityTracker r1 = r6.velocityTracker
            if (r1 == 0) goto L_0x00ea
            r1.addMovement(r7)
        L_0x00ea:
            boolean r1 = r6.isBeingDragged
            if (r1 != 0) goto L_0x00f2
            if (r0 == 0) goto L_0x00f1
            goto L_0x00f2
        L_0x00f1:
            r8 = 0
        L_0x00f2:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.HeaderBehavior.onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public final int scroll(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return setHeaderTopBottomOffset(coordinatorLayout, v, getTopBottomOffsetForScrollingSibling() - i, i2, i3);
    }

    public int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, V v, int i) {
        return setHeaderTopBottomOffset(coordinatorLayout, v, i, LinearLayoutManager.INVALID_OFFSET, Integer.MAX_VALUE);
    }

    public int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        int topAndBottomOffset = getTopAndBottomOffset();
        if (i2 != 0 && topAndBottomOffset >= i2 && topAndBottomOffset <= i3) {
            int clamp = b.clamp(i, i2, i3);
            if (topAndBottomOffset != clamp) {
                setTopAndBottomOffset(clamp);
                return topAndBottomOffset - clamp;
            }
        }
        return 0;
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
