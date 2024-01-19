package androidx.slidingpanelayout.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import androidx.customview.widget.ViewDragHelper.Callback;
import androidx.slidingpanelayout.widget.FoldingFeatureObserver.OnFoldingFeatureChangeListener;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.FoldingFeature.Orientation;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.Job;

public class SlidingPaneLayout extends ViewGroup {
    public static boolean sEdgeSizeUsingSystemGestureInsets = (VERSION.SDK_INT >= 29);
    public boolean mCanSlide;
    public int mCoveredFadeColor;
    public final ViewDragHelper mDragHelper;
    public boolean mFirstLayout;
    public FoldingFeature mFoldingFeature;
    public FoldingFeatureObserver mFoldingFeatureObserver;
    public float mInitialMotionX;
    public float mInitialMotionY;
    public boolean mIsUnableToDrag;
    public int mLockMode;
    public OnFoldingFeatureChangeListener mOnFoldingFeatureChangeListener;
    public PanelSlideListener mPanelSlideListener;
    public final List<PanelSlideListener> mPanelSlideListeners;
    public int mParallaxBy;
    public float mParallaxOffset;
    public final ArrayList<DisableLayerRunnable> mPostedRunnables;
    public boolean mPreservedOpenState;
    public Drawable mShadowDrawableLeft;
    public Drawable mShadowDrawableRight;
    public float mSlideOffset;
    public int mSlideRange;
    public View mSlideableView;
    public int mSliderFadeColor;
    public final Rect mTmpRect;

    public class AccessibilityDelegate extends AccessibilityDelegateCompat {
        public final Rect mTmpRect = new Rect();

        public AccessibilityDelegate() {
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.mOriginalDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName("androidx.slidingpanelayout.widget.SlidingPaneLayout");
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(accessibilityNodeInfoCompat.mInfo);
            this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, obtain);
            Rect rect = this.mTmpRect;
            obtain.getBoundsInScreen(rect);
            accessibilityNodeInfoCompat.mInfo.setBoundsInScreen(rect);
            accessibilityNodeInfoCompat.mInfo.setVisibleToUser(obtain.isVisibleToUser());
            accessibilityNodeInfoCompat.mInfo.setPackageName(obtain.getPackageName());
            accessibilityNodeInfoCompat.mInfo.setClassName(obtain.getClassName());
            accessibilityNodeInfoCompat.mInfo.setContentDescription(obtain.getContentDescription());
            accessibilityNodeInfoCompat.mInfo.setEnabled(obtain.isEnabled());
            accessibilityNodeInfoCompat.mInfo.setClickable(obtain.isClickable());
            accessibilityNodeInfoCompat.mInfo.setFocusable(obtain.isFocusable());
            accessibilityNodeInfoCompat.mInfo.setFocused(obtain.isFocused());
            accessibilityNodeInfoCompat.mInfo.setAccessibilityFocused(obtain.isAccessibilityFocused());
            accessibilityNodeInfoCompat.mInfo.setSelected(obtain.isSelected());
            accessibilityNodeInfoCompat.mInfo.setLongClickable(obtain.isLongClickable());
            accessibilityNodeInfoCompat.mInfo.addAction(obtain.getActions());
            accessibilityNodeInfoCompat.mInfo.setMovementGranularities(obtain.getMovementGranularities());
            obtain.recycle();
            accessibilityNodeInfoCompat.mInfo.setClassName("androidx.slidingpanelayout.widget.SlidingPaneLayout");
            accessibilityNodeInfoCompat.mVirtualDescendantId = -1;
            accessibilityNodeInfoCompat.mInfo.setSource(view);
            ViewParent parentForAccessibility = ViewCompat.getParentForAccessibility(view);
            if (parentForAccessibility instanceof View) {
                accessibilityNodeInfoCompat.setParent((View) parentForAccessibility);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i);
                if (!SlidingPaneLayout.this.isDimmed(childAt) && childAt.getVisibility() == 0) {
                    childAt.setImportantForAccessibility(1);
                    accessibilityNodeInfoCompat.mInfo.addChild(childAt);
                }
            }
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (!SlidingPaneLayout.this.isDimmed(view)) {
                return this.mOriginalDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    public class DisableLayerRunnable implements Runnable {
        public void run() {
            throw null;
        }
    }

    public class DragHelperCallback extends Callback {
        public DragHelperCallback() {
        }

        public int clampViewPositionHorizontal(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) SlidingPaneLayout.this.mSlideableView.getLayoutParams();
            if (SlidingPaneLayout.this.isLayoutRtlSupport()) {
                int width = SlidingPaneLayout.this.getWidth() - (SlidingPaneLayout.this.mSlideableView.getWidth() + (SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin));
                return Math.max(Math.min(i, width), width - SlidingPaneLayout.this.mSlideRange);
            }
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + layoutParams.leftMargin;
            return Math.min(Math.max(i, paddingLeft), SlidingPaneLayout.this.mSlideRange + paddingLeft);
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return view.getTop();
        }

        public int getViewHorizontalDragRange(View view) {
            return SlidingPaneLayout.this.mSlideRange;
        }

        public final boolean isDraggable() {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            if (slidingPaneLayout.mIsUnableToDrag || slidingPaneLayout.getLockMode() == 3) {
                return false;
            }
            if (SlidingPaneLayout.this.isOpen() && SlidingPaneLayout.this.getLockMode() == 1) {
                return false;
            }
            if (SlidingPaneLayout.this.isOpen() || SlidingPaneLayout.this.getLockMode() != 2) {
                return true;
            }
            return false;
        }

        public void onEdgeDragStarted(int i, int i2) {
            if (isDraggable()) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                slidingPaneLayout.mDragHelper.captureChildView(slidingPaneLayout.mSlideableView, i2);
            }
        }

        public void onEdgeTouched(int i, int i2) {
            if (isDraggable()) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                slidingPaneLayout.mDragHelper.captureChildView(slidingPaneLayout.mSlideableView, i2);
            }
        }

        public void onViewCaptured(View view, int i) {
            SlidingPaneLayout.this.setAllChildrenVisible();
        }

        public void onViewDragStateChanged(int i) {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            if (slidingPaneLayout.mDragHelper.mDragState != 0) {
                return;
            }
            if (slidingPaneLayout.mSlideOffset == 1.0f) {
                slidingPaneLayout.updateObscuredViewsVisibility(slidingPaneLayout.mSlideableView);
                SlidingPaneLayout slidingPaneLayout2 = SlidingPaneLayout.this;
                View view = slidingPaneLayout2.mSlideableView;
                for (PanelSlideListener onPanelClosed : slidingPaneLayout2.mPanelSlideListeners) {
                    onPanelClosed.onPanelClosed(view);
                }
                slidingPaneLayout2.sendAccessibilityEvent(32);
                SlidingPaneLayout.this.mPreservedOpenState = false;
                return;
            }
            View view2 = slidingPaneLayout.mSlideableView;
            for (PanelSlideListener onPanelOpened : slidingPaneLayout.mPanelSlideListeners) {
                onPanelOpened.onPanelOpened(view2);
            }
            slidingPaneLayout.sendAccessibilityEvent(32);
            SlidingPaneLayout.this.mPreservedOpenState = true;
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            if (slidingPaneLayout.mSlideableView == null) {
                slidingPaneLayout.mSlideOffset = 0.0f;
            } else {
                boolean isLayoutRtlSupport = slidingPaneLayout.isLayoutRtlSupport();
                LayoutParams layoutParams = (LayoutParams) slidingPaneLayout.mSlideableView.getLayoutParams();
                int width = slidingPaneLayout.mSlideableView.getWidth();
                if (isLayoutRtlSupport) {
                    i = (slidingPaneLayout.getWidth() - i) - width;
                }
                float paddingRight = ((float) (i - ((isLayoutRtlSupport ? slidingPaneLayout.getPaddingRight() : slidingPaneLayout.getPaddingLeft()) + (isLayoutRtlSupport ? layoutParams.rightMargin : layoutParams.leftMargin)))) / ((float) slidingPaneLayout.mSlideRange);
                slidingPaneLayout.mSlideOffset = paddingRight;
                if (slidingPaneLayout.mParallaxBy != 0) {
                    slidingPaneLayout.parallaxOtherViews(paddingRight);
                }
                View view2 = slidingPaneLayout.mSlideableView;
                for (PanelSlideListener onPanelSlide : slidingPaneLayout.mPanelSlideListeners) {
                    onPanelSlide.onPanelSlide(view2, slidingPaneLayout.mSlideOffset);
                }
            }
            SlidingPaneLayout.this.invalidate();
        }

        public void onViewReleased(View view, float f2, float f3) {
            int i;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (SlidingPaneLayout.this.isLayoutRtlSupport()) {
                int paddingRight = SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin;
                if (f2 < 0.0f || (f2 == 0.0f && SlidingPaneLayout.this.mSlideOffset > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.mSlideRange;
                }
                i = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.mSlideableView.getWidth();
            } else {
                i = layoutParams.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                if (i2 > 0 || (i2 == 0 && SlidingPaneLayout.this.mSlideOffset > 0.5f)) {
                    i += SlidingPaneLayout.this.mSlideRange;
                }
            }
            SlidingPaneLayout.this.mDragHelper.settleCapturedViewAt(i, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        public boolean tryCaptureView(View view, int i) {
            if (!isDraggable()) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).slideable;
        }
    }

    public static class LayoutParams extends MarginLayoutParams {
        public static final int[] ATTRS = {16843137};
        public boolean dimWhenOffset;
        public boolean slideable;
        public float weight = 0.0f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
            this.weight = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    public interface PanelSlideListener {
        void onPanelClosed(View view);

        void onPanelOpened(View view);

        void onPanelSlide(View view, float f2);
    }

    public static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new ClassLoaderCreator<SavedState>() {
            public Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, null);
            }

            public Object[] newArray(int i) {
                return new SavedState[i];
            }

            public Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        };
        public boolean isOpen;
        public int mLockMode;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.mSuperState, i);
            parcel.writeInt(this.isOpen ? 1 : 0);
            parcel.writeInt(this.mLockMode);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, null);
            this.isOpen = parcel.readInt() != 0;
            this.mLockMode = parcel.readInt();
        }
    }

    public static class TouchBlocker extends FrameLayout {
        public TouchBlocker(View view) {
            super(view.getContext());
            addView(view);
        }

        public boolean onGenericMotionEvent(MotionEvent motionEvent) {
            return true;
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static int getMinimumWidth(View view) {
        if (view instanceof TouchBlocker) {
            return ViewCompat.getMinimumWidth(((TouchBlocker) view).getChildAt(0));
        }
        return ViewCompat.getMinimumWidth(view);
    }

    private Insets getSystemGestureInsets() {
        if (sEdgeSizeUsingSystemGestureInsets) {
            WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(this);
            if (rootWindowInsets != null) {
                return rootWindowInsets.mImpl.getSystemGestureInsets();
            }
        }
        return null;
    }

    private void setFoldingFeatureObserver(FoldingFeatureObserver foldingFeatureObserver) {
        this.mFoldingFeatureObserver = foldingFeatureObserver;
        OnFoldingFeatureChangeListener onFoldingFeatureChangeListener = this.mOnFoldingFeatureChangeListener;
        if (foldingFeatureObserver != null) {
            Intrinsics.checkNotNullParameter(onFoldingFeatureChangeListener, "onFoldingFeatureChangeListener");
            foldingFeatureObserver.onFoldingFeatureChangeListener = onFoldingFeatureChangeListener;
            return;
        }
        throw null;
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() == 1) {
            super.addView(new TouchBlocker(view), i, layoutParams);
        } else {
            super.addView(view, i, layoutParams);
        }
    }

    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public final boolean closePane(int i) {
        if (!this.mCanSlide) {
            this.mPreservedOpenState = false;
        }
        if (!this.mFirstLayout && !smoothSlideTo(1.0f)) {
            return false;
        }
        this.mPreservedOpenState = false;
        return true;
    }

    public void computeScroll() {
        if (this.mDragHelper.continueSettling(true)) {
            if (!this.mCanSlide) {
                this.mDragHelper.abort();
                return;
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        int i;
        int i2;
        super.draw(canvas);
        if (isLayoutRtlSupport()) {
            drawable = this.mShadowDrawableRight;
        } else {
            drawable = this.mShadowDrawableLeft;
        }
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (isLayoutRtlSupport()) {
                i2 = childAt.getRight();
                i = intrinsicWidth + i2;
            } else {
                int left = childAt.getLeft();
                int i3 = left - intrinsicWidth;
                i = left;
                i2 = i3;
            }
            drawable.setBounds(i2, top, i, bottom);
            drawable.draw(canvas);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        if (isLayoutRtlSupport() ^ isOpen()) {
            this.mDragHelper.mTrackingEdges = 1;
            Insets systemGestureInsets = getSystemGestureInsets();
            if (systemGestureInsets != null) {
                ViewDragHelper viewDragHelper = this.mDragHelper;
                viewDragHelper.mEdgeSize = Math.max(viewDragHelper.mDefaultEdgeSize, systemGestureInsets.left);
            }
        } else {
            this.mDragHelper.mTrackingEdges = 2;
            Insets systemGestureInsets2 = getSystemGestureInsets();
            if (systemGestureInsets2 != null) {
                ViewDragHelper viewDragHelper2 = this.mDragHelper;
                viewDragHelper2.mEdgeSize = Math.max(viewDragHelper2.mDefaultEdgeSize, systemGestureInsets2.right);
            }
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save();
        if (this.mCanSlide && !layoutParams.slideable && this.mSlideableView != null) {
            canvas.getClipBounds(this.mTmpRect);
            if (isLayoutRtlSupport()) {
                Rect rect = this.mTmpRect;
                rect.left = Math.max(rect.left, this.mSlideableView.getRight());
            } else {
                Rect rect2 = this.mTmpRect;
                rect2.right = Math.min(rect2.right, this.mSlideableView.getLeft());
            }
            canvas.clipRect(this.mTmpRect);
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        return drawChild;
    }

    public android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    @Deprecated
    public int getCoveredFadeColor() {
        return this.mCoveredFadeColor;
    }

    public final int getLockMode() {
        return this.mLockMode;
    }

    public int getParallaxDistance() {
        return this.mParallaxBy;
    }

    @Deprecated
    public int getSliderFadeColor() {
        return this.mSliderFadeColor;
    }

    public boolean isDimmed(View view) {
        boolean z = false;
        if (view == null) {
            return false;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (this.mCanSlide && layoutParams.dimWhenOffset && this.mSlideOffset > 0.0f) {
            z = true;
        }
        return z;
    }

    public boolean isLayoutRtlSupport() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    public boolean isOpen() {
        return !this.mCanSlide || this.mSlideOffset == 0.0f;
    }

    public void onAttachedToWindow() {
        Activity activity;
        super.onAttachedToWindow();
        this.mFirstLayout = true;
        if (this.mFoldingFeatureObserver != null) {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    activity = null;
                    break;
                } else if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                } else {
                    context = ((ContextWrapper) context).getBaseContext();
                }
            }
            if (activity != null) {
                FoldingFeatureObserver foldingFeatureObserver = this.mFoldingFeatureObserver;
                if (foldingFeatureObserver != null) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    Job job = foldingFeatureObserver.job;
                    if (job != null) {
                        TypeUtilsKt.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    }
                    foldingFeatureObserver.job = TypeUtilsKt.launch$default(TypeUtilsKt.CoroutineScope(TypeUtilsKt.from(foldingFeatureObserver.executor)), null, null, new FoldingFeatureObserver$registerLayoutStateChangeCallback$1(foldingFeatureObserver, activity, null), 3, null);
                    return;
                }
                throw null;
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
        FoldingFeatureObserver foldingFeatureObserver = this.mFoldingFeatureObserver;
        if (foldingFeatureObserver != null) {
            Job job = foldingFeatureObserver.job;
            if (job != null) {
                TypeUtilsKt.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
        }
        if (this.mPostedRunnables.size() <= 0) {
            this.mPostedRunnables.clear();
        } else if (this.mPostedRunnables.get(0) != null) {
            throw null;
        } else {
            throw null;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int actionMasked = motionEvent.getActionMasked();
        boolean z2 = true;
        if (!this.mCanSlide && actionMasked == 0 && getChildCount() > 1) {
            View childAt = getChildAt(1);
            if (childAt != null) {
                this.mPreservedOpenState = this.mDragHelper.isViewUnder(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
            }
        }
        if (!this.mCanSlide || (this.mIsUnableToDrag && actionMasked != 0)) {
            this.mDragHelper.cancel();
            return super.onInterceptTouchEvent(motionEvent);
        } else if (actionMasked == 3 || actionMasked == 1) {
            this.mDragHelper.cancel();
            return false;
        } else {
            if (actionMasked == 0) {
                this.mIsUnableToDrag = false;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.mInitialMotionX = x;
                this.mInitialMotionY = y;
                if (this.mDragHelper.isViewUnder(this.mSlideableView, (int) x, (int) y) && isDimmed(this.mSlideableView)) {
                    z = true;
                    if (!this.mDragHelper.shouldInterceptTouchEvent(motionEvent) && !z) {
                        z2 = false;
                    }
                    return z2;
                }
            } else if (actionMasked == 2) {
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                float abs = Math.abs(x2 - this.mInitialMotionX);
                float abs2 = Math.abs(y2 - this.mInitialMotionY);
                ViewDragHelper viewDragHelper = this.mDragHelper;
                if (abs > ((float) viewDragHelper.mTouchSlop) && abs2 > abs) {
                    viewDragHelper.cancel();
                    this.mIsUnableToDrag = true;
                    return false;
                }
            }
            z = false;
            z2 = false;
            return z2;
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        int i9 = i3 - i;
        int paddingRight = isLayoutRtlSupport ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = isLayoutRtlSupport ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.mFirstLayout) {
            this.mSlideOffset = (!this.mCanSlide || !this.mPreservedOpenState) ? 1.0f : 0.0f;
        }
        int i10 = paddingRight;
        int i11 = 0;
        while (i11 < childCount) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() == 8) {
                i5 = i10;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.slideable) {
                    int i12 = i9 - paddingLeft;
                    int min = (Math.min(paddingRight, i12) - i10) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.mSlideRange = min;
                    int i13 = isLayoutRtlSupport ? layoutParams.rightMargin : layoutParams.leftMargin;
                    layoutParams.dimWhenOffset = (measuredWidth / 2) + ((i10 + i13) + min) > i12;
                    int i14 = (int) (((float) min) * this.mSlideOffset);
                    i5 = i13 + i14 + i10;
                    this.mSlideOffset = ((float) i14) / ((float) this.mSlideRange);
                    i6 = 0;
                } else {
                    if (this.mCanSlide) {
                        int i15 = this.mParallaxBy;
                        if (i15 != 0) {
                            i6 = (int) ((1.0f - this.mSlideOffset) * ((float) i15));
                            i5 = paddingRight;
                        }
                    }
                    i5 = paddingRight;
                    i6 = 0;
                }
                if (isLayoutRtlSupport) {
                    i7 = (i9 - i5) + i6;
                    i8 = i7 - measuredWidth;
                } else {
                    i8 = i5 - i6;
                    i7 = i8 + measuredWidth;
                }
                childAt.layout(i8, paddingTop, i7, childAt.getMeasuredHeight() + paddingTop);
                FoldingFeature foldingFeature = this.mFoldingFeature;
                paddingRight = Math.abs((foldingFeature == null || foldingFeature.getOrientation() != Orientation.VERTICAL || !this.mFoldingFeature.isSeparating()) ? 0 : this.mFoldingFeature.getBounds().width()) + childAt.getWidth() + paddingRight;
            }
            i11++;
            i10 = i5;
        }
        if (this.mFirstLayout) {
            if (this.mCanSlide && this.mParallaxBy != 0) {
                parallaxOtherViews(this.mSlideOffset);
            }
            updateObscuredViewsVisibility(this.mSlideableView);
        }
        this.mFirstLayout = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x026f  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x019d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0188  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r22, int r23) {
        /*
            r21 = this;
            r0 = r21
            r1 = r23
            int r2 = android.view.View.MeasureSpec.getMode(r22)
            int r3 = android.view.View.MeasureSpec.getSize(r22)
            int r4 = android.view.View.MeasureSpec.getMode(r23)
            int r5 = android.view.View.MeasureSpec.getSize(r23)
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = 1073741824(0x40000000, float:2.0)
            r8 = 0
            if (r4 == r6) goto L_0x002c
            if (r4 == r7) goto L_0x0020
            r5 = 0
            r9 = 0
            goto L_0x0038
        L_0x0020:
            int r9 = r21.getPaddingTop()
            int r5 = r5 - r9
            int r9 = r21.getPaddingBottom()
            int r5 = r5 - r9
            r9 = r5
            goto L_0x0038
        L_0x002c:
            int r9 = r21.getPaddingTop()
            int r5 = r5 - r9
            int r9 = r21.getPaddingBottom()
            int r5 = r5 - r9
            r9 = r5
            r5 = 0
        L_0x0038:
            int r10 = r21.getPaddingLeft()
            int r10 = r3 - r10
            int r11 = r21.getPaddingRight()
            int r10 = r10 - r11
            int r10 = java.lang.Math.max(r10, r8)
            int r11 = r21.getChildCount()
            r12 = 2
            r13 = 0
            r0.mSlideableView = r13
            r13 = r10
            r15 = 0
            r16 = 0
            r17 = 0
        L_0x0055:
            r12 = 8
            if (r15 >= r11) goto L_0x00ea
            android.view.View r6 = r0.getChildAt(r15)
            android.view.ViewGroup$LayoutParams r18 = r6.getLayoutParams()
            r7 = r18
            androidx.slidingpanelayout.widget.SlidingPaneLayout$LayoutParams r7 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) r7
            int r14 = r6.getVisibility()
            if (r14 != r12) goto L_0x006f
            r7.dimWhenOffset = r8
            goto L_0x00e1
        L_0x006f:
            float r12 = r7.weight
            r14 = 0
            int r19 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r19 <= 0) goto L_0x007e
            float r17 = r17 + r12
            int r12 = r7.width
            if (r12 != 0) goto L_0x007e
            goto L_0x00e1
        L_0x007e:
            int r12 = r7.leftMargin
            int r14 = r7.rightMargin
            int r12 = r12 + r14
            int r12 = r10 - r12
            int r12 = java.lang.Math.max(r12, r8)
            int r14 = r7.width
            r8 = -2
            if (r14 != r8) goto L_0x0099
            if (r2 != 0) goto L_0x0092
            r8 = r2
            goto L_0x0094
        L_0x0092:
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x0094:
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r12, r8)
            goto L_0x00a8
        L_0x0099:
            r8 = -1
            if (r14 != r8) goto L_0x00a1
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r12, r2)
            goto L_0x00a8
        L_0x00a1:
            r8 = 1073741824(0x40000000, float:2.0)
            int r12 = android.view.View.MeasureSpec.makeMeasureSpec(r14, r8)
            r8 = r12
        L_0x00a8:
            int r12 = r21.getPaddingTop()
            int r14 = r21.getPaddingBottom()
            int r14 = r14 + r12
            int r12 = r7.height
            int r12 = android.view.ViewGroup.getChildMeasureSpec(r1, r14, r12)
            r6.measure(r8, r12)
            int r8 = r6.getMeasuredWidth()
            int r12 = r6.getMeasuredHeight()
            if (r12 <= r5) goto L_0x00d0
            r14 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r4 != r14) goto L_0x00cd
            int r5 = java.lang.Math.min(r12, r9)
            goto L_0x00d0
        L_0x00cd:
            if (r4 != 0) goto L_0x00d0
            r5 = r12
        L_0x00d0:
            int r13 = r13 - r8
            if (r15 != 0) goto L_0x00d4
            goto L_0x00e1
        L_0x00d4:
            if (r13 >= 0) goto L_0x00d8
            r8 = 1
            goto L_0x00d9
        L_0x00d8:
            r8 = 0
        L_0x00d9:
            r7.slideable = r8
            r16 = r16 | r8
            if (r8 == 0) goto L_0x00e1
            r0.mSlideableView = r6
        L_0x00e1:
            int r15 = r15 + 1
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = 1073741824(0x40000000, float:2.0)
            r8 = 0
            goto L_0x0055
        L_0x00ea:
            if (r16 != 0) goto L_0x00f1
            r2 = 0
            int r6 = (r17 > r2 ? 1 : (r17 == r2 ? 0 : -1))
            if (r6 <= 0) goto L_0x01a5
        L_0x00f1:
            r2 = 0
        L_0x00f2:
            if (r2 >= r11) goto L_0x01a5
            android.view.View r6 = r0.getChildAt(r2)
            int r7 = r6.getVisibility()
            if (r7 != r12) goto L_0x0104
            r20 = r13
            r18 = 0
            goto L_0x019d
        L_0x0104:
            android.view.ViewGroup$LayoutParams r7 = r6.getLayoutParams()
            androidx.slidingpanelayout.widget.SlidingPaneLayout$LayoutParams r7 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) r7
            int r8 = r7.width
            if (r8 != 0) goto L_0x0117
            float r8 = r7.weight
            r14 = 0
            int r8 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r8 <= 0) goto L_0x0117
            r8 = 1
            goto L_0x0118
        L_0x0117:
            r8 = 0
        L_0x0118:
            if (r8 == 0) goto L_0x011c
            r8 = 0
            goto L_0x0120
        L_0x011c:
            int r8 = r6.getMeasuredWidth()
        L_0x0120:
            if (r16 == 0) goto L_0x0130
            int r14 = r7.leftMargin
            int r7 = r7.rightMargin
            int r14 = r14 + r7
            int r7 = r10 - r14
            r14 = 1073741824(0x40000000, float:2.0)
            int r15 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r14)
            goto L_0x014e
        L_0x0130:
            float r14 = r7.weight
            r15 = 0
            int r14 = (r14 > r15 ? 1 : (r14 == r15 ? 0 : -1))
            if (r14 <= 0) goto L_0x014c
            r14 = 0
            int r15 = java.lang.Math.max(r14, r13)
            float r7 = r7.weight
            float r14 = (float) r15
            float r7 = r7 * r14
            float r7 = r7 / r17
            int r7 = (int) r7
            int r7 = r7 + r8
            r14 = 1073741824(0x40000000, float:2.0)
            int r15 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r14)
            goto L_0x014e
        L_0x014c:
            r7 = r8
            r15 = 0
        L_0x014e:
            int r14 = r21.getPaddingTop()
            int r20 = r21.getPaddingBottom()
            int r14 = r20 + r14
            android.view.ViewGroup$LayoutParams r20 = r6.getLayoutParams()
            r12 = r20
            androidx.slidingpanelayout.widget.SlidingPaneLayout$LayoutParams r12 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) r12
            r20 = r13
            int r13 = r12.width
            if (r13 != 0) goto L_0x0170
            float r13 = r12.weight
            r18 = 0
            int r13 = (r13 > r18 ? 1 : (r13 == r18 ? 0 : -1))
            if (r13 <= 0) goto L_0x0172
            r13 = 1
            goto L_0x0173
        L_0x0170:
            r18 = 0
        L_0x0172:
            r13 = 0
        L_0x0173:
            if (r13 == 0) goto L_0x017c
            int r12 = r12.height
            int r12 = android.view.ViewGroup.getChildMeasureSpec(r1, r14, r12)
            goto L_0x0186
        L_0x017c:
            int r12 = r6.getMeasuredHeight()
            r13 = 1073741824(0x40000000, float:2.0)
            int r12 = android.view.View.MeasureSpec.makeMeasureSpec(r12, r13)
        L_0x0186:
            if (r8 == r7) goto L_0x019d
            r6.measure(r15, r12)
            int r6 = r6.getMeasuredHeight()
            if (r6 <= r5) goto L_0x019d
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r4 != r7) goto L_0x019a
            int r5 = java.lang.Math.min(r6, r9)
            goto L_0x019d
        L_0x019a:
            if (r4 != 0) goto L_0x019d
            r5 = r6
        L_0x019d:
            int r2 = r2 + 1
            r13 = r20
            r12 = 8
            goto L_0x00f2
        L_0x01a5:
            androidx.window.layout.FoldingFeature r1 = r0.mFoldingFeature
            if (r1 == 0) goto L_0x01ba
            boolean r1 = r1.isSeparating()
            if (r1 != 0) goto L_0x01b0
            goto L_0x01ba
        L_0x01b0:
            androidx.window.layout.FoldingFeature r1 = r0.mFoldingFeature
            android.graphics.Rect r1 = r1.getBounds()
            int r1 = r1.left
            if (r1 != 0) goto L_0x01bd
        L_0x01ba:
            r6 = 0
            goto L_0x0267
        L_0x01bd:
            androidx.window.layout.FoldingFeature r1 = r0.mFoldingFeature
            android.graphics.Rect r1 = r1.getBounds()
            int r1 = r1.top
            if (r1 != 0) goto L_0x01ba
            androidx.window.layout.FoldingFeature r1 = r0.mFoldingFeature
            r2 = 2
            int[] r4 = new int[r2]
            r0.getLocationInWindow(r4)
            android.graphics.Rect r2 = new android.graphics.Rect
            r6 = 0
            r7 = r4[r6]
            r8 = 1
            r9 = r4[r8]
            r12 = r4[r6]
            int r6 = r21.getWidth()
            int r6 = r6 + r12
            r12 = r4[r8]
            int r8 = r21.getWidth()
            int r8 = r8 + r12
            r2.<init>(r7, r9, r6, r8)
            android.graphics.Rect r6 = new android.graphics.Rect
            android.graphics.Rect r1 = r1.getBounds()
            r6.<init>(r1)
            boolean r1 = r6.intersect(r2)
            int r2 = r6.width()
            if (r2 != 0) goto L_0x0201
            int r2 = r6.height()
            if (r2 == 0) goto L_0x0203
        L_0x0201:
            if (r1 != 0) goto L_0x0205
        L_0x0203:
            r6 = 0
            goto L_0x0210
        L_0x0205:
            r1 = 0
            r2 = r4[r1]
            int r1 = -r2
            r2 = 1
            r4 = r4[r2]
            int r2 = -r4
            r6.offset(r1, r2)
        L_0x0210:
            if (r6 != 0) goto L_0x0213
            goto L_0x01ba
        L_0x0213:
            android.graphics.Rect r1 = new android.graphics.Rect
            int r2 = r21.getPaddingLeft()
            int r4 = r21.getPaddingTop()
            int r7 = r21.getPaddingLeft()
            int r8 = r6.left
            int r7 = java.lang.Math.max(r7, r8)
            int r8 = r21.getHeight()
            int r9 = r21.getPaddingBottom()
            int r8 = r8 - r9
            r1.<init>(r2, r4, r7, r8)
            int r2 = r21.getWidth()
            int r4 = r21.getPaddingRight()
            int r2 = r2 - r4
            android.graphics.Rect r4 = new android.graphics.Rect
            int r6 = r6.right
            int r6 = java.lang.Math.min(r2, r6)
            int r7 = r21.getPaddingTop()
            int r8 = r21.getHeight()
            int r9 = r21.getPaddingBottom()
            int r8 = r8 - r9
            r4.<init>(r6, r7, r2, r8)
            java.util.ArrayList r13 = new java.util.ArrayList
            r2 = 2
            android.graphics.Rect[] r2 = new android.graphics.Rect[r2]
            r6 = 0
            r2[r6] = r1
            r1 = 1
            r2[r1] = r4
            java.util.List r1 = java.util.Arrays.asList(r2)
            r13.<init>(r1)
            goto L_0x0268
        L_0x0267:
            r13 = 0
        L_0x0268:
            if (r13 == 0) goto L_0x02ea
            if (r16 != 0) goto L_0x02ea
            r8 = 0
        L_0x026d:
            if (r8 >= r11) goto L_0x02ea
            android.view.View r1 = r0.getChildAt(r8)
            int r2 = r1.getVisibility()
            r4 = 8
            if (r2 != r4) goto L_0x0280
            r12 = 1073741824(0x40000000, float:2.0)
            r14 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x02de
        L_0x0280:
            java.lang.Object r2 = r13.get(r8)
            android.graphics.Rect r2 = (android.graphics.Rect) r2
            android.view.ViewGroup$LayoutParams r6 = r1.getLayoutParams()
            androidx.slidingpanelayout.widget.SlidingPaneLayout$LayoutParams r6 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) r6
            int r7 = r6.leftMargin
            int r9 = r6.rightMargin
            int r7 = r7 + r9
            int r9 = r1.getMeasuredHeight()
            r12 = 1073741824(0x40000000, float:2.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r12)
            int r12 = r2.width()
            r14 = -2147483648(0xffffffff80000000, float:-0.0)
            int r12 = android.view.View.MeasureSpec.makeMeasureSpec(r12, r14)
            r1.measure(r12, r9)
            int r12 = r1.getMeasuredWidthAndState()
            r15 = 16777216(0x1000000, float:2.3509887E-38)
            r12 = r12 & r15
            r15 = 1
            if (r12 == r15) goto L_0x02d1
            int r12 = getMinimumWidth(r1)
            if (r12 == 0) goto L_0x02c3
            int r12 = r2.width()
            int r15 = getMinimumWidth(r1)
            if (r12 >= r15) goto L_0x02c3
            goto L_0x02d1
        L_0x02c3:
            int r2 = r2.width()
            r12 = 1073741824(0x40000000, float:2.0)
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r12)
            r1.measure(r2, r9)
            goto L_0x02de
        L_0x02d1:
            r12 = 1073741824(0x40000000, float:2.0)
            int r2 = r10 - r7
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r12)
            r1.measure(r2, r9)
            if (r8 != 0) goto L_0x02e0
        L_0x02de:
            r2 = 1
            goto L_0x02e7
        L_0x02e0:
            r2 = 1
            r6.slideable = r2
            r0.mSlideableView = r1
            r16 = 1
        L_0x02e7:
            int r8 = r8 + 1
            goto L_0x026d
        L_0x02ea:
            r1 = r16
            int r2 = r21.getPaddingTop()
            int r2 = r2 + r5
            int r4 = r21.getPaddingBottom()
            int r4 = r4 + r2
            r0.setMeasuredDimension(r3, r4)
            r0.mCanSlide = r1
            androidx.customview.widget.ViewDragHelper r2 = r0.mDragHelper
            int r3 = r2.mDragState
            if (r3 == 0) goto L_0x0306
            if (r1 != 0) goto L_0x0306
            r2.abort()
        L_0x0306:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.onMeasure(int, int):void");
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.mSuperState);
        if (savedState.isOpen) {
            if (!this.mCanSlide) {
                this.mPreservedOpenState = true;
            }
            if (this.mFirstLayout || smoothSlideTo(0.0f)) {
                this.mPreservedOpenState = true;
            }
        } else {
            closePane(0);
        }
        this.mPreservedOpenState = savedState.isOpen;
        setLockMode(savedState.mLockMode);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.isOpen = this.mCanSlide ? isOpen() : this.mPreservedOpenState;
        savedState.mLockMode = this.mLockMode;
        return savedState;
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.mFirstLayout = true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mCanSlide) {
            return super.onTouchEvent(motionEvent);
        }
        this.mDragHelper.processTouchEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.mInitialMotionX = x;
            this.mInitialMotionY = y;
        } else if (actionMasked == 1 && isDimmed(this.mSlideableView)) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            float f2 = x2 - this.mInitialMotionX;
            float f3 = y2 - this.mInitialMotionY;
            ViewDragHelper viewDragHelper = this.mDragHelper;
            int i = viewDragHelper.mTouchSlop;
            if ((f3 * f3) + (f2 * f2) < ((float) (i * i)) && viewDragHelper.isViewUnder(this.mSlideableView, (int) x2, (int) y2)) {
                closePane(0);
            }
        }
        return true;
    }

    public final void parallaxOtherViews(float f2) {
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != this.mSlideableView) {
                int i2 = this.mParallaxBy;
                this.mParallaxOffset = f2;
                int i3 = ((int) ((1.0f - this.mParallaxOffset) * ((float) i2))) - ((int) ((1.0f - f2) * ((float) i2)));
                if (isLayoutRtlSupport) {
                    i3 = -i3;
                }
                childAt.offsetLeftAndRight(i3);
            }
        }
    }

    public void removeView(View view) {
        if (view.getParent() instanceof TouchBlocker) {
            super.removeView((View) view.getParent());
        } else {
            super.removeView(view);
        }
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.mCanSlide) {
            this.mPreservedOpenState = view == this.mSlideableView;
        }
    }

    public void setAllChildrenVisible() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    @Deprecated
    public void setCoveredFadeColor(int i) {
        this.mCoveredFadeColor = i;
    }

    public final void setLockMode(int i) {
        this.mLockMode = i;
    }

    @Deprecated
    public void setPanelSlideListener(PanelSlideListener panelSlideListener) {
        PanelSlideListener panelSlideListener2 = this.mPanelSlideListener;
        if (panelSlideListener2 != null) {
            this.mPanelSlideListeners.remove(panelSlideListener2);
        }
        if (panelSlideListener != null) {
            this.mPanelSlideListeners.add(panelSlideListener);
        }
        this.mPanelSlideListener = panelSlideListener;
    }

    public void setParallaxDistance(int i) {
        this.mParallaxBy = i;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.mShadowDrawableLeft = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.mShadowDrawableRight = drawable;
    }

    @Deprecated
    public void setShadowResource(int i) {
        setShadowDrawableLeft(getResources().getDrawable(i));
    }

    public void setShadowResourceLeft(int i) {
        setShadowDrawableLeft(ContextCompat.getDrawable(getContext(), i));
    }

    public void setShadowResourceRight(int i) {
        setShadowDrawableRight(ContextCompat.getDrawable(getContext(), i));
    }

    @Deprecated
    public void setSliderFadeColor(int i) {
        this.mSliderFadeColor = i;
    }

    public boolean smoothSlideTo(float f2) {
        int i;
        if (!this.mCanSlide) {
            return false;
        }
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        LayoutParams layoutParams = (LayoutParams) this.mSlideableView.getLayoutParams();
        if (isLayoutRtlSupport) {
            int paddingRight = getPaddingRight() + layoutParams.rightMargin;
            int width = this.mSlideableView.getWidth();
            i = (int) (((float) getWidth()) - (((f2 * ((float) this.mSlideRange)) + ((float) paddingRight)) + ((float) width)));
        } else {
            i = (int) ((f2 * ((float) this.mSlideRange)) + ((float) (getPaddingLeft() + layoutParams.leftMargin)));
        }
        ViewDragHelper viewDragHelper = this.mDragHelper;
        View view = this.mSlideableView;
        if (!viewDragHelper.smoothSlideViewTo(view, i, view.getTop())) {
            return false;
        }
        setAllChildrenVisible();
        postInvalidateOnAnimation();
        return true;
    }

    public void updateObscuredViewsVisibility(View view) {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z;
        View view2 = view;
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        int width = isLayoutRtlSupport ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = isLayoutRtlSupport ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !view.isOpaque()) {
            i4 = 0;
            i3 = 0;
            i2 = 0;
            i = 0;
        } else {
            i4 = view.getLeft();
            i3 = view.getRight();
            i2 = view.getTop();
            i = view.getBottom();
        }
        int childCount = getChildCount();
        int i5 = 0;
        while (true) {
            if (i5 < childCount) {
                View childAt = getChildAt(i5);
                if (childAt != view2) {
                    if (childAt.getVisibility() == 8) {
                        z = isLayoutRtlSupport;
                    } else {
                        z = isLayoutRtlSupport;
                        childAt.setVisibility((Math.max(isLayoutRtlSupport ? paddingLeft : width, childAt.getLeft()) < i4 || Math.max(paddingTop, childAt.getTop()) < i2 || Math.min(isLayoutRtlSupport ? width : paddingLeft, childAt.getRight()) > i3 || Math.min(height, childAt.getBottom()) > i) ? 0 : 4);
                    }
                    i5++;
                    view2 = view;
                    isLayoutRtlSupport = z;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:17|18|19|(1:21)(2:22|(1:24))|(2:26|(1:28))|29|30) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x009f, code lost:
        r7 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ae, code lost:
        r0 = r7;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00af */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0077  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SlidingPaneLayout(android.content.Context r6, android.util.AttributeSet r7, int r8) {
        /*
            r5 = this;
            r5.<init>(r6, r7, r8)
            r7 = 0
            r5.mSliderFadeColor = r7
            r8 = 1065353216(0x3f800000, float:1.0)
            r5.mSlideOffset = r8
            java.util.concurrent.CopyOnWriteArrayList r8 = new java.util.concurrent.CopyOnWriteArrayList
            r8.<init>()
            r5.mPanelSlideListeners = r8
            r8 = 1
            r5.mFirstLayout = r8
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r5.mTmpRect = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r5.mPostedRunnables = r0
            androidx.slidingpanelayout.widget.SlidingPaneLayout$1 r0 = new androidx.slidingpanelayout.widget.SlidingPaneLayout$1
            r0.<init>()
            r5.mOnFoldingFeatureChangeListener = r0
            android.content.res.Resources r0 = r6.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            float r0 = r0.density
            r5.setWillNotDraw(r7)
            androidx.slidingpanelayout.widget.SlidingPaneLayout$AccessibilityDelegate r1 = new androidx.slidingpanelayout.widget.SlidingPaneLayout$AccessibilityDelegate
            r1.<init>()
            androidx.core.view.ViewCompat.setAccessibilityDelegate(r5, r1)
            r5.setImportantForAccessibility(r8)
            r8 = 1056964608(0x3f000000, float:0.5)
            androidx.slidingpanelayout.widget.SlidingPaneLayout$DragHelperCallback r1 = new androidx.slidingpanelayout.widget.SlidingPaneLayout$DragHelperCallback
            r1.<init>()
            androidx.customview.widget.ViewDragHelper r8 = androidx.customview.widget.ViewDragHelper.create(r5, r8, r1)
            r5.mDragHelper = r8
            r1 = 1137180672(0x43c80000, float:400.0)
            float r0 = r0 * r1
            r8.mMinVelocity = r0
            androidx.window.layout.WindowInfoTracker$Companion r8 = androidx.window.layout.WindowInfoTracker.Companion
            r0 = 0
            if (r8 == 0) goto L_0x00dc
            java.lang.String r8 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r8)
            androidx.window.layout.WindowInfoTrackerImpl r1 = new androidx.window.layout.WindowInfoTrackerImpl
            androidx.window.layout.WindowMetricsCalculatorCompat r2 = androidx.window.layout.WindowMetricsCalculatorCompat.INSTANCE
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r8)
            androidx.window.layout.SafeWindowLayoutComponentProvider r3 = androidx.window.layout.SafeWindowLayoutComponentProvider.INSTANCE     // Catch:{ all -> 0x0074 }
            androidx.window.extensions.layout.WindowLayoutComponent r3 = r3.getWindowLayoutComponent()     // Catch:{ all -> 0x0074 }
            if (r3 != 0) goto L_0x006e
            goto L_0x0074
        L_0x006e:
            androidx.window.layout.ExtensionWindowLayoutInfoBackend r4 = new androidx.window.layout.ExtensionWindowLayoutInfoBackend     // Catch:{ all -> 0x0074 }
            r4.<init>(r3)     // Catch:{ all -> 0x0074 }
            goto L_0x0075
        L_0x0074:
            r4 = r0
        L_0x0075:
            if (r4 != 0) goto L_0x00c6
            androidx.window.layout.SidecarWindowBackend r3 = androidx.window.layout.SidecarWindowBackend.Companion
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r8)
            androidx.window.layout.SidecarWindowBackend r3 = androidx.window.layout.SidecarWindowBackend.globalInstance
            if (r3 != 0) goto L_0x00c1
            java.util.concurrent.locks.ReentrantLock r3 = androidx.window.layout.SidecarWindowBackend.globalLock
            r3.lock()
            androidx.window.layout.SidecarWindowBackend r4 = androidx.window.layout.SidecarWindowBackend.globalInstance     // Catch:{ all -> 0x00bc }
            if (r4 != 0) goto L_0x00b8
            androidx.window.layout.SidecarWindowBackend r4 = androidx.window.layout.SidecarWindowBackend.Companion     // Catch:{ all -> 0x00bc }
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r8)     // Catch:{ all -> 0x00bc }
            androidx.window.core.Version r8 = androidx.window.layout.SidecarCompat.getSidecarVersion()     // Catch:{ all -> 0x00af }
            if (r8 != 0) goto L_0x0095
            goto L_0x00a0
        L_0x0095:
            androidx.window.core.Version$Companion r4 = androidx.window.core.Version.Companion     // Catch:{ all -> 0x00af }
            androidx.window.core.Version r4 = androidx.window.core.Version.VERSION_0_1     // Catch:{ all -> 0x00af }
            int r8 = r8.compareTo(r4)     // Catch:{ all -> 0x00af }
            if (r8 < 0) goto L_0x00a0
            r7 = 1
        L_0x00a0:
            if (r7 == 0) goto L_0x00af
            androidx.window.layout.SidecarCompat r7 = new androidx.window.layout.SidecarCompat     // Catch:{ all -> 0x00af }
            r7.<init>(r6)     // Catch:{ all -> 0x00af }
            boolean r8 = r7.validateExtensionInterface()     // Catch:{ all -> 0x00af }
            if (r8 != 0) goto L_0x00ae
            goto L_0x00af
        L_0x00ae:
            r0 = r7
        L_0x00af:
            androidx.window.layout.SidecarWindowBackend r7 = androidx.window.layout.SidecarWindowBackend.Companion     // Catch:{ all -> 0x00bc }
            androidx.window.layout.SidecarWindowBackend r7 = new androidx.window.layout.SidecarWindowBackend     // Catch:{ all -> 0x00bc }
            r7.<init>(r0)     // Catch:{ all -> 0x00bc }
            androidx.window.layout.SidecarWindowBackend.globalInstance = r7     // Catch:{ all -> 0x00bc }
        L_0x00b8:
            r3.unlock()
            goto L_0x00c1
        L_0x00bc:
            r6 = move-exception
            r3.unlock()
            throw r6
        L_0x00c1:
            androidx.window.layout.SidecarWindowBackend r4 = androidx.window.layout.SidecarWindowBackend.globalInstance
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
        L_0x00c6:
            r1.<init>(r2, r4)
            androidx.window.layout.WindowInfoTrackerDecorator r7 = androidx.window.layout.WindowInfoTracker.Companion.decorator
            androidx.window.layout.WindowInfoTracker r7 = r7.decorate(r1)
            java.util.concurrent.Executor r6 = androidx.core.content.ContextCompat.getMainExecutor(r6)
            androidx.slidingpanelayout.widget.FoldingFeatureObserver r8 = new androidx.slidingpanelayout.widget.FoldingFeatureObserver
            r8.<init>(r7, r6)
            r5.setFoldingFeatureObserver(r8)
            return
        L_0x00dc:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
