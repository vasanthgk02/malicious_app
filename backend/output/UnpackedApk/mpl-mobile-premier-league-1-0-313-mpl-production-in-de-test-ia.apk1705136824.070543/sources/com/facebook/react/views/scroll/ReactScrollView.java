package com.facebook.react.views.scroll;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.view.ViewCompat;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.ReactClippingViewGroup;
import com.facebook.react.uimanager.ReactClippingViewGroupHelper;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.views.view.ReactViewBackgroundManager;
import java.lang.reflect.Field;
import java.util.List;
import sfs2x.client.entities.invitation.InvitationReply;

public class ReactScrollView extends ScrollView implements ReactClippingViewGroup, OnHierarchyChangeListener, OnLayoutChangeListener {
    public static Field sScrollerField;
    public static boolean sTriedToGetScrollerField;
    public boolean mActivelyScrolling;
    public Rect mClippingRect;
    public View mContentView;
    public float mDecelerationRate = 0.985f;
    public boolean mDisableIntervalMomentum = false;
    public boolean mDragging;
    public Drawable mEndBackground;
    public int mEndFillColor = 0;
    public FpsListener mFpsListener = null;
    public final OnScrollDispatchHelper mOnScrollDispatchHelper = new OnScrollDispatchHelper();
    public String mOverflow = "hidden";
    public boolean mPagingEnabled = false;
    public Runnable mPostTouchRunnable;
    public ReactViewBackgroundManager mReactBackgroundManager;
    public final Rect mRect = new Rect();
    public boolean mRemoveClippedSubviews;
    public boolean mScrollEnabled = true;
    public String mScrollPerfTag;
    public final OverScroller mScroller;
    public boolean mSendMomentumEvents;
    public int mSnapInterval = 0;
    public List<Integer> mSnapOffsets;
    public boolean mSnapToEnd = true;
    public boolean mSnapToStart = true;
    public StateWrapper mStateWrapper;
    public final VelocityHelper mVelocityHelper = new VelocityHelper();
    public int pendingContentOffsetX = -1;
    public int pendingContentOffsetY = -1;

    public ReactScrollView(ReactContext reactContext, FpsListener fpsListener) {
        super(reactContext);
        this.mFpsListener = fpsListener;
        this.mReactBackgroundManager = new ReactViewBackgroundManager(this);
        this.mScroller = getOverScrollerFromParent();
        setOnHierarchyChangeListener(this);
        setScrollBarStyle(33554432);
    }

    private int getMaxScrollY() {
        return Math.max(0, this.mContentView.getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
    }

    private OverScroller getOverScrollerFromParent() {
        if (!sTriedToGetScrollerField) {
            sTriedToGetScrollerField = true;
            try {
                Field declaredField = ScrollView.class.getDeclaredField("mScroller");
                sScrollerField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                FLog.w((String) "ReactNative", (String) "Failed to get mScroller field for ScrollView! This app will exhibit the bounce-back scrolling bug :(");
            }
        }
        Field field = sScrollerField;
        if (field == null) {
            return null;
        }
        try {
            Object obj = field.get(this);
            if (obj instanceof OverScroller) {
                return (OverScroller) obj;
            }
            FLog.w((String) "ReactNative", (String) "Failed to cast mScroller field in ScrollView (probably due to OEM changes to AOSP)! This app will exhibit the bounce-back scrolling bug :(");
            return null;
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Failed to get mScroller from ScrollView!", e2);
        }
    }

    private int getSnapInterval() {
        int i = this.mSnapInterval;
        if (i != 0) {
            return i;
        }
        return getHeight();
    }

    public void draw(Canvas canvas) {
        char c2 = 0;
        if (this.mEndFillColor != 0) {
            View childAt = getChildAt(0);
            if (!(this.mEndBackground == null || childAt == null || childAt.getBottom() >= getHeight())) {
                this.mEndBackground.setBounds(0, childAt.getBottom(), getWidth(), getHeight());
                this.mEndBackground.draw(canvas);
            }
        }
        getDrawingRect(this.mRect);
        String str = this.mOverflow;
        if (str.hashCode() != 466743410 || !str.equals("visible")) {
            c2 = 65535;
        }
        if (c2 != 0) {
            canvas.clipRect(this.mRect);
        }
        super.draw(canvas);
    }

    public final void enableFpsListener() {
        if (isScrollPerfLoggingEnabled()) {
            ImageOriginUtils.assertNotNull(this.mFpsListener);
            ImageOriginUtils.assertNotNull(this.mScrollPerfTag);
            this.mFpsListener.enable(this.mScrollPerfTag);
        }
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (this.mScrollEnabled || (keyCode != 19 && keyCode != 20)) {
            return super.executeKeyEvent(keyEvent);
        }
        return false;
    }

    public void flashScrollIndicators() {
        awakenScrollBars();
    }

    public void fling(int i) {
        float signum = Math.signum(this.mOnScrollDispatchHelper.mYFlingVelocity);
        if (signum == 0.0f) {
            signum = Math.signum((float) i);
        }
        int abs = (int) (((float) Math.abs(i)) * signum);
        if (this.mPagingEnabled) {
            flingAndSnap(abs);
        } else if (this.mScroller != null) {
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            this.mScroller.fling(getScrollX(), getScrollY(), 0, abs, 0, 0, 0, Integer.MAX_VALUE, 0, height / 2);
            ViewCompat.postInvalidateOnAnimation(this);
        } else {
            super.fling(abs);
        }
        handlePostTouchScrolling(0, abs);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00fb, code lost:
        if (getScrollY() >= r7) goto L_0x010f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0163  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void flingAndSnap(int r18) {
        /*
            r17 = this;
            r0 = r17
            int r1 = r17.getChildCount()
            if (r1 > 0) goto L_0x0009
            return
        L_0x0009:
            int r1 = r0.mSnapInterval
            r2 = 1
            if (r1 != 0) goto L_0x0066
            java.util.List<java.lang.Integer> r1 = r0.mSnapOffsets
            if (r1 != 0) goto L_0x0066
            int r1 = r17.getSnapInterval()
            double r3 = (double) r1
            int r1 = r17.getScrollY()
            double r5 = (double) r1
            int r1 = r17.predictFinalScrollPosition(r18)
            double r7 = (double) r1
            double r9 = r5 / r3
            double r11 = java.lang.Math.floor(r9)
            int r1 = (int) r11
            double r11 = java.lang.Math.ceil(r9)
            int r11 = (int) r11
            long r9 = java.lang.Math.round(r9)
            int r10 = (int) r9
            double r7 = r7 / r3
            long r7 = java.lang.Math.round(r7)
            int r8 = (int) r7
            if (r18 <= 0) goto L_0x003f
            if (r11 != r1) goto L_0x003f
            int r11 = r11 + 1
            goto L_0x0045
        L_0x003f:
            if (r18 >= 0) goto L_0x0045
            if (r1 != r11) goto L_0x0045
            int r1 = r1 + -1
        L_0x0045:
            if (r18 <= 0) goto L_0x004d
            if (r10 >= r11) goto L_0x004d
            if (r8 <= r1) goto L_0x004d
            r10 = r11
            goto L_0x0054
        L_0x004d:
            if (r18 >= 0) goto L_0x0054
            if (r10 <= r1) goto L_0x0054
            if (r8 >= r11) goto L_0x0054
            r10 = r1
        L_0x0054:
            double r7 = (double) r10
            double r7 = r7 * r3
            int r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x0065
            r0.mActivelyScrolling = r2
            int r1 = r17.getScrollX()
            int r2 = (int) r7
            r0.reactSmoothScrollTo(r1, r2)
        L_0x0065:
            return
        L_0x0066:
            int r1 = r17.getMaxScrollY()
            int r3 = r17.predictFinalScrollPosition(r18)
            boolean r4 = r0.mDisableIntervalMomentum
            if (r4 == 0) goto L_0x0076
            int r3 = r17.getScrollY()
        L_0x0076:
            int r4 = r17.getHeight()
            int r5 = r17.getPaddingBottom()
            int r4 = r4 - r5
            int r5 = r17.getPaddingTop()
            int r4 = r4 - r5
            java.util.List<java.lang.Integer> r5 = r0.mSnapOffsets
            r6 = 0
            if (r5 == 0) goto L_0x00cb
            java.lang.Object r5 = r5.get(r6)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.util.List<java.lang.Integer> r7 = r0.mSnapOffsets
            java.lang.Object r7 = com.android.tools.r8.GeneratedOutlineSupport.outline30(r7, r2)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r8 = 0
            r9 = 0
            r10 = r1
        L_0x00a2:
            java.util.List<java.lang.Integer> r11 = r0.mSnapOffsets
            int r11 = r11.size()
            if (r8 >= r11) goto L_0x00e8
            java.util.List<java.lang.Integer> r11 = r0.mSnapOffsets
            java.lang.Object r11 = r11.get(r8)
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            if (r11 > r3) goto L_0x00bf
            int r12 = r3 - r11
            int r13 = r3 - r9
            if (r12 >= r13) goto L_0x00bf
            r9 = r11
        L_0x00bf:
            if (r11 < r3) goto L_0x00c8
            int r12 = r11 - r3
            int r13 = r10 - r3
            if (r12 >= r13) goto L_0x00c8
            r10 = r11
        L_0x00c8:
            int r8 = r8 + 1
            goto L_0x00a2
        L_0x00cb:
            int r5 = r17.getSnapInterval()
            double r7 = (double) r5
            double r9 = (double) r3
            double r9 = r9 / r7
            double r11 = java.lang.Math.floor(r9)
            double r11 = r11 * r7
            int r5 = (int) r11
            double r9 = java.lang.Math.ceil(r9)
            double r9 = r9 * r7
            int r7 = (int) r9
            int r10 = java.lang.Math.min(r7, r1)
            r7 = 0
            r7 = r1
            r9 = r5
            r5 = 0
        L_0x00e8:
            int r8 = r3 - r9
            int r11 = r10 - r3
            if (r8 >= r11) goto L_0x00f0
            r12 = r9
            goto L_0x00f1
        L_0x00f0:
            r12 = r10
        L_0x00f1:
            boolean r13 = r0.mSnapToEnd
            if (r13 != 0) goto L_0x0101
            if (r3 < r7) goto L_0x0101
            int r5 = r17.getScrollY()
            if (r5 < r7) goto L_0x00fe
            goto L_0x010f
        L_0x00fe:
            r3 = r18
            goto L_0x012a
        L_0x0101:
            boolean r7 = r0.mSnapToStart
            if (r7 != 0) goto L_0x0111
            if (r3 > r5) goto L_0x0111
            int r7 = r17.getScrollY()
            if (r7 > r5) goto L_0x010e
            goto L_0x010f
        L_0x010e:
            r3 = r5
        L_0x010f:
            r7 = r3
            goto L_0x00fe
        L_0x0111:
            r13 = 4621819117588971520(0x4024000000000000, double:10.0)
            if (r18 <= 0) goto L_0x011d
            double r7 = (double) r11
            double r7 = r7 * r13
            int r3 = (int) r7
            int r3 = r18 + r3
            r7 = r10
            goto L_0x012a
        L_0x011d:
            if (r18 >= 0) goto L_0x0127
            double r7 = (double) r8
            double r7 = r7 * r13
            int r3 = (int) r7
            int r3 = r18 - r3
            r7 = r9
            goto L_0x012a
        L_0x0127:
            r3 = r18
            r7 = r12
        L_0x012a:
            int r5 = java.lang.Math.max(r6, r7)
            int r14 = java.lang.Math.min(r5, r1)
            android.widget.OverScroller r6 = r0.mScroller
            if (r6 == 0) goto L_0x0163
            r0.mActivelyScrolling = r2
            int r7 = r17.getScrollX()
            int r8 = r17.getScrollY()
            r9 = 0
            if (r3 == 0) goto L_0x0144
            goto L_0x014a
        L_0x0144:
            int r2 = r17.getScrollY()
            int r3 = r14 - r2
        L_0x014a:
            r10 = r3
            r11 = 0
            r12 = 0
            r15 = 0
            if (r14 == 0) goto L_0x0157
            if (r14 != r1) goto L_0x0153
            goto L_0x0157
        L_0x0153:
            r1 = 0
            r16 = 0
            goto L_0x015b
        L_0x0157:
            int r4 = r4 / 2
            r16 = r4
        L_0x015b:
            r13 = r14
            r6.fling(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r17.postInvalidateOnAnimation()
            goto L_0x016a
        L_0x0163:
            int r1 = r17.getScrollX()
            r0.reactSmoothScrollTo(r1, r14)
        L_0x016a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.scroll.ReactScrollView.flingAndSnap(int):void");
    }

    public boolean getChildVisibleRect(View view, Rect rect, Point point) {
        return super.getChildVisibleRect(view, rect, point);
    }

    public void getClippingRect(Rect rect) {
        Rect rect2 = this.mClippingRect;
        ImageOriginUtils.assertNotNull(rect2);
        rect.set(rect2);
    }

    public boolean getRemoveClippedSubviews() {
        return this.mRemoveClippedSubviews;
    }

    public final void handlePostTouchScrolling(int i, int i2) {
        if ((this.mSendMomentumEvents || this.mPagingEnabled || isScrollPerfLoggingEnabled()) && this.mPostTouchRunnable == null) {
            if (this.mSendMomentumEvents) {
                enableFpsListener();
                ImageOriginUtils.emitScrollEvent(this, ScrollEventType.MOMENTUM_BEGIN, (float) i, (float) i2);
            }
            this.mActivelyScrolling = false;
            AnonymousClass1 r3 = new Runnable() {
                public boolean mSnappingToPage = false;

                public void run() {
                    ReactScrollView reactScrollView = ReactScrollView.this;
                    if (reactScrollView.mActivelyScrolling) {
                        reactScrollView.mActivelyScrolling = false;
                        ViewCompat.postOnAnimationDelayed(reactScrollView, this, 20);
                        return;
                    }
                    reactScrollView.updateStateOnScroll(reactScrollView.getScrollX(), ReactScrollView.this.getScrollY());
                    ReactScrollView reactScrollView2 = ReactScrollView.this;
                    if (!reactScrollView2.mPagingEnabled || this.mSnappingToPage) {
                        ReactScrollView reactScrollView3 = ReactScrollView.this;
                        if (reactScrollView3.mSendMomentumEvents) {
                            ImageOriginUtils.emitScrollEvent(reactScrollView3, ScrollEventType.MOMENTUM_END, 0.0f, 0.0f);
                        }
                        ReactScrollView reactScrollView4 = ReactScrollView.this;
                        reactScrollView4.mPostTouchRunnable = null;
                        if (reactScrollView4.isScrollPerfLoggingEnabled()) {
                            ImageOriginUtils.assertNotNull(reactScrollView4.mFpsListener);
                            ImageOriginUtils.assertNotNull(reactScrollView4.mScrollPerfTag);
                            reactScrollView4.mFpsListener.disable(reactScrollView4.mScrollPerfTag);
                            return;
                        }
                        return;
                    }
                    this.mSnappingToPage = true;
                    reactScrollView2.flingAndSnap(0);
                    ViewCompat.postOnAnimationDelayed(ReactScrollView.this, this, 20);
                }
            };
            this.mPostTouchRunnable = r3;
            ViewCompat.postOnAnimationDelayed(this, r3, 20);
        }
    }

    public final boolean isScrollPerfLoggingEnabled() {
        if (this.mFpsListener != null) {
            String str = this.mScrollPerfTag;
            if (str != null && !str.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mRemoveClippedSubviews) {
            updateClippingRect();
        }
    }

    public void onChildViewAdded(View view, View view2) {
        this.mContentView = view2;
        view2.addOnLayoutChangeListener(this);
    }

    public void onChildViewRemoved(View view, View view2) {
        this.mContentView.removeOnLayoutChangeListener(this);
        this.mContentView = null;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.mScrollEnabled) {
            return false;
        }
        try {
            if (super.onInterceptTouchEvent(motionEvent)) {
                ImageOriginUtils.notifyNativeGestureStarted(this, motionEvent);
                ImageOriginUtils.emitScrollEvent(this, ScrollEventType.BEGIN_DRAG, 0.0f, 0.0f);
                this.mDragging = true;
                enableFpsListener();
                return true;
            }
        } catch (IllegalArgumentException e2) {
            FLog.w((String) "ReactNative", (String) "Error intercepting touch event.", (Throwable) e2);
        }
        return false;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = this.pendingContentOffsetX;
        if (i5 == -1) {
            i5 = getScrollX();
        }
        int i6 = this.pendingContentOffsetY;
        if (i6 == -1) {
            i6 = getScrollY();
        }
        reactScrollTo(i5, i6);
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (this.mContentView != null) {
            int scrollY = getScrollY();
            int maxScrollY = getMaxScrollY();
            if (scrollY > maxScrollY) {
                reactScrollTo(getScrollX(), maxScrollY);
            }
        }
    }

    public void onMeasure(int i, int i2) {
        ImageOriginUtils.assertExplicitMeasureSpec(i, i2);
        setMeasuredDimension(MeasureSpec.getSize(i), MeasureSpec.getSize(i2));
    }

    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        OverScroller overScroller = this.mScroller;
        if (!(overScroller == null || this.mContentView == null || overScroller.isFinished() || this.mScroller.getCurrY() == this.mScroller.getFinalY())) {
            int maxScrollY = getMaxScrollY();
            if (i2 >= maxScrollY) {
                this.mScroller.abortAnimation();
                i2 = maxScrollY;
            }
        }
        super.onOverScrolled(i, i2, z, z2);
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        this.mActivelyScrolling = true;
        if (this.mOnScrollDispatchHelper.onScrollChanged(i, i2)) {
            if (this.mRemoveClippedSubviews) {
                updateClippingRect();
            }
            OnScrollDispatchHelper onScrollDispatchHelper = this.mOnScrollDispatchHelper;
            ImageOriginUtils.emitScrollEvent(this, ScrollEventType.SCROLL, onScrollDispatchHelper.mXFlingVelocity, onScrollDispatchHelper.mYFlingVelocity);
        }
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.mRemoveClippedSubviews) {
            updateClippingRect();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mScrollEnabled) {
            return false;
        }
        this.mVelocityHelper.calculateVelocity(motionEvent);
        if ((motionEvent.getAction() & InvitationReply.EXPIRED) == 1 && this.mDragging) {
            updateStateOnScroll(getScrollX(), getScrollY());
            VelocityHelper velocityHelper = this.mVelocityHelper;
            float f2 = velocityHelper.mXVelocity;
            float f3 = velocityHelper.mYVelocity;
            ImageOriginUtils.emitScrollEvent(this, ScrollEventType.END_DRAG, f2, f3);
            this.mDragging = false;
            handlePostTouchScrolling(Math.round(f2), Math.round(f3));
        }
        return super.onTouchEvent(motionEvent);
    }

    public final int predictFinalScrollPosition(int i) {
        OverScroller overScroller = new OverScroller(getContext());
        overScroller.setFriction(1.0f - this.mDecelerationRate);
        int maxScrollY = getMaxScrollY();
        int height = ((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2;
        overScroller.fling(getScrollX(), getScrollY(), 0, i, 0, 0, 0, maxScrollY, 0, height);
        return overScroller.getFinalY();
    }

    public void reactScrollTo(int i, int i2) {
        scrollTo(i, i2);
        updateStateOnScroll(i, i2);
        setPendingContentOffsets(i, i2);
    }

    public void reactSmoothScrollTo(int i, int i2) {
        smoothScrollTo(i, i2);
        updateStateOnScroll(i, i2);
        setPendingContentOffsets(i, i2);
    }

    public void requestChildFocus(View view, View view2) {
        if (view2 != null) {
            Rect rect = new Rect();
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
            if (computeScrollDeltaToGetChildRectOnScreen != 0) {
                scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            }
        }
        super.requestChildFocus(view, view2);
    }

    public void setBackgroundColor(int i) {
        this.mReactBackgroundManager.setBackgroundColor(i);
    }

    public void setBorderRadius(float f2) {
        this.mReactBackgroundManager.setBorderRadius(f2);
    }

    public void setBorderStyle(String str) {
        this.mReactBackgroundManager.getOrCreateReactViewBackground().setBorderStyle(str);
    }

    public void setDecelerationRate(float f2) {
        this.mDecelerationRate = f2;
        OverScroller overScroller = this.mScroller;
        if (overScroller != null) {
            overScroller.setFriction(1.0f - f2);
        }
    }

    public void setDisableIntervalMomentum(boolean z) {
        this.mDisableIntervalMomentum = z;
    }

    public void setEndFillColor(int i) {
        if (i != this.mEndFillColor) {
            this.mEndFillColor = i;
            this.mEndBackground = new ColorDrawable(this.mEndFillColor);
        }
    }

    public void setOverflow(String str) {
        this.mOverflow = str;
        invalidate();
    }

    public void setPagingEnabled(boolean z) {
        this.mPagingEnabled = z;
    }

    public final void setPendingContentOffsets(int i, int i2) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getWidth() == 0 || childAt.getHeight() == 0) {
            this.pendingContentOffsetX = i;
            this.pendingContentOffsetY = i2;
            return;
        }
        this.pendingContentOffsetX = -1;
        this.pendingContentOffsetY = -1;
    }

    public void setRemoveClippedSubviews(boolean z) {
        if (z && this.mClippingRect == null) {
            this.mClippingRect = new Rect();
        }
        this.mRemoveClippedSubviews = z;
        updateClippingRect();
    }

    public void setScrollEnabled(boolean z) {
        this.mScrollEnabled = z;
    }

    public void setScrollPerfTag(String str) {
        this.mScrollPerfTag = str;
    }

    public void setSendMomentumEvents(boolean z) {
        this.mSendMomentumEvents = z;
    }

    public void setSnapInterval(int i) {
        this.mSnapInterval = i;
    }

    public void setSnapOffsets(List<Integer> list) {
        this.mSnapOffsets = list;
    }

    public void setSnapToEnd(boolean z) {
        this.mSnapToEnd = z;
    }

    public void setSnapToStart(boolean z) {
        this.mSnapToStart = z;
    }

    public void updateClippingRect() {
        if (this.mRemoveClippedSubviews) {
            ImageOriginUtils.assertNotNull(this.mClippingRect);
            ReactClippingViewGroupHelper.calculateClippingRect(this, this.mClippingRect);
            View childAt = getChildAt(0);
            if (childAt instanceof ReactClippingViewGroup) {
                ((ReactClippingViewGroup) childAt).updateClippingRect();
            }
        }
    }

    public final void updateStateOnScroll(int i, int i2) {
        if (this.mStateWrapper != null) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putDouble("contentOffsetLeft", (double) ImageOriginUtils.toDIPFromPixel((float) i));
            writableNativeMap.putDouble("contentOffsetTop", (double) ImageOriginUtils.toDIPFromPixel((float) i2));
            this.mStateWrapper.updateState(writableNativeMap);
        }
    }
}
