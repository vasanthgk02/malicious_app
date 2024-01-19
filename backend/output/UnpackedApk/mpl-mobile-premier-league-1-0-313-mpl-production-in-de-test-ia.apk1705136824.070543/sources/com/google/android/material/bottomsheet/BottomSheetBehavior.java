package com.google.android.material.bottomsheet;

import a.a.a.a.d.b;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import androidx.customview.widget.ViewDragHelper.Callback;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.ViewUtils$OnApplyWindowInsetsListener;
import com.google.android.material.internal.ViewUtils$RelativePadding;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BottomSheetBehavior<V extends View> extends Behavior<V> {
    public static final int DEF_STYLE_RES = R$style.Widget_Design_BottomSheet_Modal;
    public int activePointerId;
    public final ArrayList<BottomSheetCallback> callbacks = new ArrayList<>();
    public int childHeight;
    public int collapsedOffset;
    public final Callback dragCallback = new Callback() {
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            return view.getLeft();
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            int expandedOffset = BottomSheetBehavior.this.getExpandedOffset();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return b.clamp(i, expandedOffset, bottomSheetBehavior.hideable ? bottomSheetBehavior.parentHeight : bottomSheetBehavior.collapsedOffset);
        }

        public int getViewVerticalDragRange(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (bottomSheetBehavior.hideable) {
                return bottomSheetBehavior.parentHeight;
            }
            return bottomSheetBehavior.collapsedOffset;
        }

        public void onViewDragStateChanged(int i) {
            if (i == 1) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.draggable) {
                    bottomSheetBehavior.setStateInternal(1);
                }
            }
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            BottomSheetBehavior.this.dispatchOnSlide(i2);
        }

        public void onViewReleased(View view, float f2, float f3) {
            int i;
            int i2;
            int i3 = 4;
            if (f3 < 0.0f) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.fitToContents) {
                    i = bottomSheetBehavior.fitToContentsOffset;
                } else {
                    int top = view.getTop();
                    BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                    int i4 = bottomSheetBehavior2.halfExpandedOffset;
                    if (top > i4) {
                        i2 = i4;
                        i3 = 6;
                        BottomSheetBehavior.this.startSettlingAnimation(view, i3, i, true);
                    }
                    i = bottomSheetBehavior2.getExpandedOffset();
                }
            } else {
                BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                if (bottomSheetBehavior3.hideable && bottomSheetBehavior3.shouldHide(view, f3)) {
                    if (Math.abs(f2) >= Math.abs(f3) || f3 <= 500.0f) {
                        int top2 = view.getTop();
                        BottomSheetBehavior bottomSheetBehavior4 = BottomSheetBehavior.this;
                        if (!(top2 > (bottomSheetBehavior4.getExpandedOffset() + bottomSheetBehavior4.parentHeight) / 2)) {
                            BottomSheetBehavior bottomSheetBehavior5 = BottomSheetBehavior.this;
                            if (bottomSheetBehavior5.fitToContents) {
                                i = bottomSheetBehavior5.fitToContentsOffset;
                            } else if (Math.abs(view.getTop() - BottomSheetBehavior.this.getExpandedOffset()) < Math.abs(view.getTop() - BottomSheetBehavior.this.halfExpandedOffset)) {
                                i = BottomSheetBehavior.this.getExpandedOffset();
                            } else {
                                i2 = BottomSheetBehavior.this.halfExpandedOffset;
                                i3 = 6;
                                BottomSheetBehavior.this.startSettlingAnimation(view, i3, i, true);
                            }
                        }
                    }
                    i = BottomSheetBehavior.this.parentHeight;
                    i3 = 5;
                    BottomSheetBehavior.this.startSettlingAnimation(view, i3, i, true);
                } else if (f3 == 0.0f || Math.abs(f2) > Math.abs(f3)) {
                    int top3 = view.getTop();
                    BottomSheetBehavior bottomSheetBehavior6 = BottomSheetBehavior.this;
                    if (!bottomSheetBehavior6.fitToContents) {
                        int i5 = bottomSheetBehavior6.halfExpandedOffset;
                        if (top3 < i5) {
                            if (top3 < Math.abs(top3 - bottomSheetBehavior6.collapsedOffset)) {
                                i = BottomSheetBehavior.this.getExpandedOffset();
                            } else {
                                i2 = BottomSheetBehavior.this.halfExpandedOffset;
                            }
                        } else if (Math.abs(top3 - i5) < Math.abs(top3 - BottomSheetBehavior.this.collapsedOffset)) {
                            i2 = BottomSheetBehavior.this.halfExpandedOffset;
                        } else {
                            i = BottomSheetBehavior.this.collapsedOffset;
                            BottomSheetBehavior.this.startSettlingAnimation(view, i3, i, true);
                        }
                        i3 = 6;
                        BottomSheetBehavior.this.startSettlingAnimation(view, i3, i, true);
                    } else if (Math.abs(top3 - bottomSheetBehavior6.fitToContentsOffset) < Math.abs(top3 - BottomSheetBehavior.this.collapsedOffset)) {
                        i = BottomSheetBehavior.this.fitToContentsOffset;
                    } else {
                        i = BottomSheetBehavior.this.collapsedOffset;
                        BottomSheetBehavior.this.startSettlingAnimation(view, i3, i, true);
                    }
                } else {
                    BottomSheetBehavior bottomSheetBehavior7 = BottomSheetBehavior.this;
                    if (bottomSheetBehavior7.fitToContents) {
                        i = bottomSheetBehavior7.collapsedOffset;
                    } else {
                        int top4 = view.getTop();
                        if (Math.abs(top4 - BottomSheetBehavior.this.halfExpandedOffset) < Math.abs(top4 - BottomSheetBehavior.this.collapsedOffset)) {
                            i2 = BottomSheetBehavior.this.halfExpandedOffset;
                            i3 = 6;
                        } else {
                            i = BottomSheetBehavior.this.collapsedOffset;
                        }
                    }
                    BottomSheetBehavior.this.startSettlingAnimation(view, i3, i, true);
                }
            }
            i3 = 3;
            BottomSheetBehavior.this.startSettlingAnimation(view, i3, i, true);
        }

        public boolean tryCaptureView(View view, int i) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i2 = bottomSheetBehavior.state;
            boolean z = false;
            if (i2 == 1 || bottomSheetBehavior.touchingScrollingChild) {
                return false;
            }
            if (i2 == 3 && bottomSheetBehavior.activePointerId == i) {
                WeakReference<View> weakReference = bottomSheetBehavior.nestedScrollingChildRef;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.viewRef;
            if (weakReference2 != null && weakReference2.get() == view) {
                z = true;
            }
            return z;
        }
    };
    public boolean draggable = true;
    public float elevation = -1.0f;
    public int expandHalfwayActionId = -1;
    public int expandedOffset;
    public boolean fitToContents = true;
    public int fitToContentsOffset;
    public int gestureInsetBottom;
    public boolean gestureInsetBottomIgnored;
    public int halfExpandedOffset;
    public float halfExpandedRatio = 0.5f;
    public boolean hideable;
    public boolean ignoreEvents;
    public Map<View, Integer> importantForAccessibilityMap;
    public int initialY;
    public int insetBottom;
    public int insetTop;
    public ValueAnimator interpolatorAnimator;
    public boolean isShapeExpanded;
    public int lastNestedScrollDy;
    public MaterialShapeDrawable materialShapeDrawable;
    public int maxWidth = -1;
    public float maximumVelocity;
    public boolean nestedScrolled;
    public WeakReference<View> nestedScrollingChildRef;
    public boolean paddingBottomSystemWindowInsets;
    public boolean paddingLeftSystemWindowInsets;
    public boolean paddingRightSystemWindowInsets;
    public boolean paddingTopSystemWindowInsets;
    public int parentHeight;
    public int parentWidth;
    public int peekHeight;
    public boolean peekHeightAuto;
    public int peekHeightGestureInsetBuffer;
    public int peekHeightMin;
    public int saveFlags = 0;
    public SettleRunnable settleRunnable = null;
    public ShapeAppearanceModel shapeAppearanceModelDefault;
    public boolean shapeThemingEnabled;
    public boolean skipCollapsed;
    public int state = 4;
    public boolean touchingScrollingChild;
    public boolean updateImportantForAccessibilityOnSiblings = false;
    public VelocityTracker velocityTracker;
    public ViewDragHelper viewDragHelper;
    public WeakReference<V> viewRef;

    public static abstract class BottomSheetCallback {
        public abstract void onSlide(View view, float f2);

        public abstract void onStateChanged(View view, int i);
    }

    public static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new ClassLoaderCreator<SavedState>() {
            public Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public Object[] newArray(int i) {
                return new SavedState[i];
            }

            public Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        };
        public boolean fitToContents;
        public boolean hideable;
        public int peekHeight;
        public boolean skipCollapsed;
        public final int state;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
            this.peekHeight = parcel.readInt();
            boolean z = false;
            this.fitToContents = parcel.readInt() == 1;
            this.hideable = parcel.readInt() == 1;
            this.skipCollapsed = parcel.readInt() == 1 ? true : z;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.mSuperState, i);
            parcel.writeInt(this.state);
            parcel.writeInt(this.peekHeight);
            parcel.writeInt(this.fitToContents ? 1 : 0);
            parcel.writeInt(this.hideable ? 1 : 0);
            parcel.writeInt(this.skipCollapsed ? 1 : 0);
        }

        public SavedState(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.state = bottomSheetBehavior.state;
            this.peekHeight = bottomSheetBehavior.peekHeight;
            this.fitToContents = bottomSheetBehavior.fitToContents;
            this.hideable = bottomSheetBehavior.hideable;
            this.skipCollapsed = bottomSheetBehavior.skipCollapsed;
        }
    }

    public class SettleRunnable implements Runnable {
        public boolean isPosted;
        public int targetState;
        public final View view;

        public SettleRunnable(View view2, int i) {
            this.view = view2;
            this.targetState = i;
        }

        public void run() {
            ViewDragHelper viewDragHelper = BottomSheetBehavior.this.viewDragHelper;
            if (viewDragHelper == null || !viewDragHelper.continueSettling(true)) {
                BottomSheetBehavior.this.setStateInternal(this.targetState);
            } else {
                ViewCompat.postOnAnimation(this.view, this);
            }
            this.isPosted = false;
        }
    }

    public BottomSheetBehavior() {
    }

    public static <V extends View> BottomSheetBehavior<V> from(V v) {
        LayoutParams layoutParams = v.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).mBehavior;
            if (behavior instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) behavior;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    public void addBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        if (!this.callbacks.contains(bottomSheetCallback)) {
            this.callbacks.add(bottomSheetCallback);
        }
    }

    public final void calculateCollapsedOffset() {
        int calculatePeekHeight = calculatePeekHeight();
        if (this.fitToContents) {
            this.collapsedOffset = Math.max(this.parentHeight - calculatePeekHeight, this.fitToContentsOffset);
        } else {
            this.collapsedOffset = this.parentHeight - calculatePeekHeight;
        }
    }

    public final int calculatePeekHeight() {
        if (this.peekHeightAuto) {
            return Math.min(Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16)), this.childHeight) + this.insetBottom;
        }
        if (!this.gestureInsetBottomIgnored && !this.paddingBottomSystemWindowInsets) {
            int i = this.gestureInsetBottom;
            if (i > 0) {
                return Math.max(this.peekHeight, i + this.peekHeightGestureInsetBuffer);
            }
        }
        return this.peekHeight + this.insetBottom;
    }

    public final void createMaterialShapeDrawable(Context context, AttributeSet attributeSet, boolean z, ColorStateList colorStateList) {
        if (this.shapeThemingEnabled) {
            this.shapeAppearanceModelDefault = ShapeAppearanceModel.builder(context, attributeSet, R$attr.bottomSheetStyle, DEF_STYLE_RES).build();
            MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(this.shapeAppearanceModelDefault);
            this.materialShapeDrawable = materialShapeDrawable2;
            materialShapeDrawable2.drawableState.elevationOverlayProvider = new ElevationOverlayProvider(context);
            materialShapeDrawable2.updateZ();
            if (!z || colorStateList == null) {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(16842801, typedValue, true);
                this.materialShapeDrawable.setTint(typedValue.data);
                return;
            }
            this.materialShapeDrawable.setFillColor(colorStateList);
        }
    }

    public void dispatchOnSlide(int i) {
        float f2;
        float f3;
        View view = (View) this.viewRef.get();
        if (view != null && !this.callbacks.isEmpty()) {
            int i2 = this.collapsedOffset;
            if (i > i2 || i2 == getExpandedOffset()) {
                int i3 = this.collapsedOffset;
                f2 = (float) (i3 - i);
                f3 = (float) (this.parentHeight - i3);
            } else {
                int i4 = this.collapsedOffset;
                f2 = (float) (i4 - i);
                f3 = (float) (i4 - getExpandedOffset());
            }
            float f4 = f2 / f3;
            for (int i5 = 0; i5 < this.callbacks.size(); i5++) {
                this.callbacks.get(i5).onSlide(view, f4);
            }
        }
    }

    public View findScrollingChild(View view) {
        if (ViewCompat.isNestedScrollingEnabled(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View findScrollingChild = findScrollingChild(viewGroup.getChildAt(i));
                if (findScrollingChild != null) {
                    return findScrollingChild;
                }
            }
        }
        return null;
    }

    public int getExpandedOffset() {
        if (this.fitToContents) {
            return this.fitToContentsOffset;
        }
        return Math.max(this.expandedOffset, this.paddingTopSystemWindowInsets ? 0 : this.insetTop);
    }

    public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    public void onDetachedFromLayoutParams() {
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = false;
        if (!v.isShown() || !this.draggable) {
            this.ignoreEvents = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        View view = null;
        if (actionMasked == 0) {
            this.activePointerId = -1;
            VelocityTracker velocityTracker2 = this.velocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.velocityTracker = null;
            }
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.initialY = (int) motionEvent.getY();
            if (this.state != 2) {
                WeakReference<View> weakReference = this.nestedScrollingChildRef;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && coordinatorLayout.isPointInChildBounds(view2, x, this.initialY)) {
                    this.activePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.touchingScrollingChild = true;
                }
            }
            this.ignoreEvents = this.activePointerId == -1 && !coordinatorLayout.isPointInChildBounds(v, x, this.initialY);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.touchingScrollingChild = false;
            this.activePointerId = -1;
            if (this.ignoreEvents) {
                this.ignoreEvents = false;
                return false;
            }
        }
        if (!this.ignoreEvents) {
            ViewDragHelper viewDragHelper2 = this.viewDragHelper;
            if (viewDragHelper2 != null && viewDragHelper2.shouldInterceptTouchEvent(motionEvent)) {
                return true;
            }
        }
        WeakReference<View> weakReference2 = this.nestedScrollingChildRef;
        if (weakReference2 != null) {
            view = (View) weakReference2.get();
        }
        if (actionMasked == 2 && view != null && !this.ignoreEvents && this.state != 1 && !coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY()) && this.viewDragHelper != null && Math.abs(((float) this.initialY) - motionEvent.getY()) > ((float) this.viewDragHelper.mTouchSlop)) {
            z = true;
        }
        return z;
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, final V v, int i) {
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !v.getFitsSystemWindows()) {
            v.setFitsSystemWindows(true);
        }
        if (this.viewRef == null) {
            this.peekHeightMin = coordinatorLayout.getResources().getDimensionPixelSize(R$dimen.design_bottom_sheet_peek_height_min);
            final boolean z = VERSION.SDK_INT >= 29 && !this.gestureInsetBottomIgnored && !this.peekHeightAuto;
            if (this.paddingBottomSystemWindowInsets || this.paddingLeftSystemWindowInsets || this.paddingRightSystemWindowInsets || z) {
                ImageOriginUtils.doOnApplyWindowInsets(v, new ViewUtils$OnApplyWindowInsetsListener() {
                    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, ViewUtils$RelativePadding viewUtils$RelativePadding) {
                        BottomSheetBehavior.this.insetTop = windowInsetsCompat.getSystemWindowInsetTop();
                        boolean isLayoutRtl = ImageOriginUtils.isLayoutRtl(view);
                        int paddingBottom = view.getPaddingBottom();
                        int paddingLeft = view.getPaddingLeft();
                        int paddingRight = view.getPaddingRight();
                        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                        if (bottomSheetBehavior.paddingBottomSystemWindowInsets) {
                            bottomSheetBehavior.insetBottom = windowInsetsCompat.getSystemWindowInsetBottom();
                            paddingBottom = viewUtils$RelativePadding.bottom + BottomSheetBehavior.this.insetBottom;
                        }
                        if (BottomSheetBehavior.this.paddingLeftSystemWindowInsets) {
                            paddingLeft = (isLayoutRtl ? viewUtils$RelativePadding.end : viewUtils$RelativePadding.start) + windowInsetsCompat.getSystemWindowInsetLeft();
                        }
                        if (BottomSheetBehavior.this.paddingRightSystemWindowInsets) {
                            paddingRight = windowInsetsCompat.getSystemWindowInsetRight() + (isLayoutRtl ? viewUtils$RelativePadding.start : viewUtils$RelativePadding.end);
                        }
                        view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
                        if (z) {
                            BottomSheetBehavior.this.gestureInsetBottom = windowInsetsCompat.mImpl.getMandatorySystemGestureInsets().bottom;
                        }
                        if (BottomSheetBehavior.this.paddingBottomSystemWindowInsets || z) {
                            BottomSheetBehavior.this.updatePeekHeight(false);
                        }
                        return windowInsetsCompat;
                    }
                });
            }
            this.viewRef = new WeakReference<>(v);
            if (this.shapeThemingEnabled) {
                MaterialShapeDrawable materialShapeDrawable2 = this.materialShapeDrawable;
                if (materialShapeDrawable2 != null) {
                    v.setBackground(materialShapeDrawable2);
                }
            }
            MaterialShapeDrawable materialShapeDrawable3 = this.materialShapeDrawable;
            if (materialShapeDrawable3 != null) {
                float f2 = this.elevation;
                if (f2 == -1.0f) {
                    f2 = v.getElevation();
                }
                materialShapeDrawable3.setElevation(f2);
                boolean z2 = this.state == 3;
                this.isShapeExpanded = z2;
                this.materialShapeDrawable.setInterpolation(z2 ? 0.0f : 1.0f);
            }
            updateAccessibilityActions();
            if (v.getImportantForAccessibility() == 0) {
                v.setImportantForAccessibility(1);
            }
            int measuredWidth = v.getMeasuredWidth();
            int i2 = this.maxWidth;
            if (measuredWidth > i2 && i2 != -1) {
                final LayoutParams layoutParams = v.getLayoutParams();
                layoutParams.width = this.maxWidth;
                v.post(new Runnable(this) {
                    public void run() {
                        v.setLayoutParams(layoutParams);
                    }
                });
            }
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = new ViewDragHelper(coordinatorLayout.getContext(), coordinatorLayout, this.dragCallback);
        }
        int top = v.getTop();
        coordinatorLayout.onLayoutChild(v, i);
        this.parentWidth = coordinatorLayout.getWidth();
        this.parentHeight = coordinatorLayout.getHeight();
        int height = v.getHeight();
        this.childHeight = height;
        int i3 = this.parentHeight;
        int i4 = i3 - height;
        int i5 = this.insetTop;
        if (i4 < i5) {
            if (this.paddingTopSystemWindowInsets) {
                this.childHeight = i3;
            } else {
                this.childHeight = i3 - i5;
            }
        }
        this.fitToContentsOffset = Math.max(0, this.parentHeight - this.childHeight);
        this.halfExpandedOffset = (int) ((1.0f - this.halfExpandedRatio) * ((float) this.parentHeight));
        calculateCollapsedOffset();
        int i6 = this.state;
        if (i6 == 3) {
            ViewCompat.offsetTopAndBottom(v, getExpandedOffset());
        } else if (i6 == 6) {
            ViewCompat.offsetTopAndBottom(v, this.halfExpandedOffset);
        } else if (!this.hideable || i6 != 5) {
            int i7 = this.state;
            if (i7 == 4) {
                ViewCompat.offsetTopAndBottom(v, this.collapsedOffset);
            } else if (i7 == 1 || i7 == 2) {
                ViewCompat.offsetTopAndBottom(v, top - v.getTop());
            }
        } else {
            ViewCompat.offsetTopAndBottom(v, this.parentHeight);
        }
        this.nestedScrollingChildRef = new WeakReference<>(findScrollingChild(v));
        return true;
    }

    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3) {
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (weakReference == null || view != weakReference.get() || this.state == 3) {
            return false;
        }
        return true;
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
        if (i3 != 1) {
            WeakReference<View> weakReference = this.nestedScrollingChildRef;
            if (view == (weakReference != null ? (View) weakReference.get() : null)) {
                int top = v.getTop();
                int i4 = top - i2;
                if (i2 > 0) {
                    if (i4 < getExpandedOffset()) {
                        iArr[1] = top - getExpandedOffset();
                        ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                        setStateInternal(3);
                    } else if (this.draggable) {
                        iArr[1] = i2;
                        ViewCompat.offsetTopAndBottom(v, -i2);
                        setStateInternal(1);
                    } else {
                        return;
                    }
                } else if (i2 < 0 && !view.canScrollVertically(-1)) {
                    int i5 = this.collapsedOffset;
                    if (i4 > i5 && !this.hideable) {
                        iArr[1] = top - i5;
                        ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                        setStateInternal(4);
                    } else if (this.draggable) {
                        iArr[1] = i2;
                        ViewCompat.offsetTopAndBottom(v, -i2);
                        setStateInternal(1);
                    } else {
                        return;
                    }
                }
                dispatchOnSlide(v.getTop());
                this.lastNestedScrollDy = i2;
                this.nestedScrolled = true;
            }
        }
    }

    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
    }

    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        int i = this.saveFlags;
        if (i != 0) {
            if (i == -1 || (i & 1) == 1) {
                this.peekHeight = savedState.peekHeight;
            }
            int i2 = this.saveFlags;
            if (i2 == -1 || (i2 & 2) == 2) {
                this.fitToContents = savedState.fitToContents;
            }
            int i3 = this.saveFlags;
            if (i3 == -1 || (i3 & 4) == 4) {
                this.hideable = savedState.hideable;
            }
            int i4 = this.saveFlags;
            if (i4 == -1 || (i4 & 8) == 8) {
                this.skipCollapsed = savedState.skipCollapsed;
            }
        }
        int i5 = savedState.state;
        if (i5 == 1 || i5 == 2) {
            this.state = 4;
        } else {
            this.state = i5;
        }
    }

    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState((Parcelable) BaseSavedState.EMPTY_STATE, this);
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        if ((i & 2) != 0) {
            return true;
        }
        return false;
    }

    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
        int i2;
        int i3;
        float f2;
        int i4 = 3;
        if (v.getTop() == getExpandedOffset()) {
            setStateInternal(3);
            return;
        }
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (weakReference != null && view == weakReference.get() && this.nestedScrolled) {
            if (this.lastNestedScrollDy > 0) {
                if (this.fitToContents) {
                    i2 = this.fitToContentsOffset;
                } else {
                    int top = v.getTop();
                    int i5 = this.halfExpandedOffset;
                    if (top > i5) {
                        i2 = i5;
                    } else {
                        i2 = getExpandedOffset();
                    }
                }
                startSettlingAnimation(v, i4, i2, false);
                this.nestedScrolled = false;
            } else {
                if (this.hideable) {
                    VelocityTracker velocityTracker2 = this.velocityTracker;
                    if (velocityTracker2 == null) {
                        f2 = 0.0f;
                    } else {
                        velocityTracker2.computeCurrentVelocity(1000, this.maximumVelocity);
                        f2 = this.velocityTracker.getYVelocity(this.activePointerId);
                    }
                    if (shouldHide(v, f2)) {
                        i2 = this.parentHeight;
                        i4 = 5;
                        startSettlingAnimation(v, i4, i2, false);
                        this.nestedScrolled = false;
                    }
                }
                if (this.lastNestedScrollDy == 0) {
                    int top2 = v.getTop();
                    if (!this.fitToContents) {
                        int i6 = this.halfExpandedOffset;
                        if (top2 < i6) {
                            if (top2 < Math.abs(top2 - this.collapsedOffset)) {
                                i2 = getExpandedOffset();
                                startSettlingAnimation(v, i4, i2, false);
                                this.nestedScrolled = false;
                            } else {
                                i2 = this.halfExpandedOffset;
                            }
                        } else if (Math.abs(top2 - i6) < Math.abs(top2 - this.collapsedOffset)) {
                            i2 = this.halfExpandedOffset;
                        } else {
                            i3 = this.collapsedOffset;
                        }
                    } else if (Math.abs(top2 - this.fitToContentsOffset) < Math.abs(top2 - this.collapsedOffset)) {
                        i2 = this.fitToContentsOffset;
                        startSettlingAnimation(v, i4, i2, false);
                        this.nestedScrolled = false;
                    } else {
                        i3 = this.collapsedOffset;
                    }
                } else if (this.fitToContents) {
                    i3 = this.collapsedOffset;
                } else {
                    int top3 = v.getTop();
                    if (Math.abs(top3 - this.halfExpandedOffset) < Math.abs(top3 - this.collapsedOffset)) {
                        i2 = this.halfExpandedOffset;
                    } else {
                        i3 = this.collapsedOffset;
                    }
                }
                i4 = 4;
                startSettlingAnimation(v, i4, i2, false);
                this.nestedScrolled = false;
            }
            i4 = 6;
            startSettlingAnimation(v, i4, i2, false);
            this.nestedScrolled = false;
        }
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.state == 1 && actionMasked == 0) {
            return true;
        }
        ViewDragHelper viewDragHelper2 = this.viewDragHelper;
        if (viewDragHelper2 != null) {
            viewDragHelper2.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            this.activePointerId = -1;
            VelocityTracker velocityTracker2 = this.velocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.velocityTracker = null;
            }
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (this.viewDragHelper != null && actionMasked == 2 && !this.ignoreEvents) {
            float abs = Math.abs(((float) this.initialY) - motionEvent.getY());
            ViewDragHelper viewDragHelper3 = this.viewDragHelper;
            if (abs > ((float) viewDragHelper3.mTouchSlop)) {
                viewDragHelper3.captureChildView(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.ignoreEvents;
    }

    public final void replaceAccessibilityActionForState(V v, AccessibilityActionCompat accessibilityActionCompat, final int i) {
        ViewCompat.replaceAccessibilityAction(v, accessibilityActionCompat, null, new AccessibilityViewCommand() {
            public boolean perform(View view, CommandArguments commandArguments) {
                BottomSheetBehavior.this.setState(6);
                return true;
            }
        });
    }

    public void setHalfExpandedRatio(float f2) {
        if (f2 <= 0.0f || f2 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.halfExpandedRatio = f2;
        if (this.viewRef != null) {
            this.halfExpandedOffset = (int) ((1.0f - f2) * ((float) this.parentHeight));
        }
    }

    public void setHideable(boolean z) {
        if (this.hideable != z) {
            this.hideable = z;
            if (!z && this.state == 5) {
                setState(4);
            }
            updateAccessibilityActions();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setPeekHeight(int r4) {
        /*
            r3 = this;
            r0 = 1
            r1 = -1
            r2 = 0
            if (r4 != r1) goto L_0x000c
            boolean r4 = r3.peekHeightAuto
            if (r4 != 0) goto L_0x0015
            r3.peekHeightAuto = r0
            goto L_0x001f
        L_0x000c:
            boolean r1 = r3.peekHeightAuto
            if (r1 != 0) goto L_0x0017
            int r1 = r3.peekHeight
            if (r1 == r4) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r0 = 0
            goto L_0x001f
        L_0x0017:
            r3.peekHeightAuto = r2
            int r4 = java.lang.Math.max(r2, r4)
            r3.peekHeight = r4
        L_0x001f:
            if (r0 == 0) goto L_0x0024
            r3.updatePeekHeight(r2)
        L_0x0024:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.setPeekHeight(int):void");
    }

    public void setState(int i) {
        if (i != this.state) {
            if (this.viewRef == null) {
                if (i == 4 || i == 3 || i == 6 || (this.hideable && i == 5)) {
                    this.state = i;
                }
                return;
            }
            settleToStatePendingLayout(i);
        }
    }

    public void setStateInternal(int i) {
        if (this.state != i) {
            this.state = i;
            WeakReference<V> weakReference = this.viewRef;
            if (weakReference != null) {
                View view = (View) weakReference.get();
                if (view != null) {
                    if (i == 3) {
                        updateImportantForAccessibility(true);
                    } else if (i == 6 || i == 5 || i == 4) {
                        updateImportantForAccessibility(false);
                    }
                    updateDrawableForTargetState(i);
                    for (int i2 = 0; i2 < this.callbacks.size(); i2++) {
                        this.callbacks.get(i2).onStateChanged(view, i);
                    }
                    updateAccessibilityActions();
                }
            }
        }
    }

    public void settleToState(View view, int i) {
        int i2;
        if (i == 4) {
            i2 = this.collapsedOffset;
        } else if (i == 6) {
            i2 = this.halfExpandedOffset;
            if (this.fitToContents) {
                int i3 = this.fitToContentsOffset;
                if (i2 <= i3) {
                    i = 3;
                    i2 = i3;
                }
            }
        } else if (i == 3) {
            i2 = getExpandedOffset();
        } else if (!this.hideable || i != 5) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("Illegal state argument: ", i));
        } else {
            i2 = this.parentHeight;
        }
        startSettlingAnimation(view, i, i2, false);
    }

    public final void settleToStatePendingLayout(final int i) {
        final View view = (View) this.viewRef.get();
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent == null || !parent.isLayoutRequested() || !ViewCompat.isAttachedToWindow(view)) {
                settleToState(view, i);
            } else {
                view.post(new Runnable() {
                    public void run() {
                        BottomSheetBehavior.this.settleToState(view, i);
                    }
                });
            }
        }
    }

    public boolean shouldHide(View view, float f2) {
        boolean z = true;
        if (this.skipCollapsed) {
            return true;
        }
        if (view.getTop() < this.collapsedOffset) {
            return false;
        }
        if (Math.abs(((f2 * 0.1f) + ((float) view.getTop())) - ((float) this.collapsedOffset)) / ((float) calculatePeekHeight()) <= 0.5f) {
            z = false;
        }
        return z;
    }

    public void startSettlingAnimation(View view, int i, int i2, boolean z) {
        ViewDragHelper viewDragHelper2 = this.viewDragHelper;
        if (viewDragHelper2 != null && (!z ? viewDragHelper2.smoothSlideViewTo(view, view.getLeft(), i2) : viewDragHelper2.settleCapturedViewAt(view.getLeft(), i2))) {
            setStateInternal(2);
            updateDrawableForTargetState(i);
            if (this.settleRunnable == null) {
                this.settleRunnable = new SettleRunnable<>(view, i);
            }
            SettleRunnable settleRunnable2 = this.settleRunnable;
            if (!settleRunnable2.isPosted) {
                settleRunnable2.targetState = i;
                ViewCompat.postOnAnimation(view, settleRunnable2);
                this.settleRunnable.isPosted = true;
                return;
            }
            settleRunnable2.targetState = i;
            return;
        }
        setStateInternal(i);
    }

    public final void updateAccessibilityActions() {
        int i;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            if (view != null) {
                ViewCompat.removeAccessibilityAction(view, 524288);
                ViewCompat.removeAccessibilityAction(view, 262144);
                ViewCompat.removeAccessibilityAction(view, 1048576);
                int i2 = this.expandHalfwayActionId;
                if (i2 != -1) {
                    ViewCompat.removeAccessibilityAction(view, i2);
                }
                int i3 = 6;
                if (!this.fitToContents && this.state != 6) {
                    String string = view.getResources().getString(R$string.bottomsheet_action_expand_halfway);
                    AnonymousClass6 r9 = new AccessibilityViewCommand(6) {
                        public boolean perform(View view, CommandArguments commandArguments) {
                            BottomSheetBehavior.this.setState(6);
                            return true;
                        }
                    };
                    List<AccessibilityActionCompat> actionList = ViewCompat.getActionList(view);
                    int i4 = 0;
                    while (true) {
                        if (i4 >= actionList.size()) {
                            int i5 = -1;
                            int i6 = 0;
                            while (true) {
                                int[] iArr = ViewCompat.ACCESSIBILITY_ACTIONS_RESOURCE_IDS;
                                if (i6 >= iArr.length || i5 != -1) {
                                    i = i5;
                                } else {
                                    int i7 = iArr[i6];
                                    boolean z = true;
                                    for (int i8 = 0; i8 < actionList.size(); i8++) {
                                        z &= actionList.get(i8).getId() != i7;
                                    }
                                    if (z) {
                                        i5 = i7;
                                    }
                                    i6++;
                                }
                            }
                            i = i5;
                        } else if (TextUtils.equals(string, actionList.get(i4).getLabel())) {
                            i = actionList.get(i4).getId();
                            break;
                        } else {
                            i4++;
                        }
                    }
                    if (i != -1) {
                        AccessibilityActionCompat accessibilityActionCompat = new AccessibilityActionCompat(null, i, string, r9, null);
                        ViewCompat.addAccessibilityAction(view, accessibilityActionCompat);
                    }
                    this.expandHalfwayActionId = i;
                }
                if (this.hideable && this.state != 5) {
                    replaceAccessibilityActionForState(view, AccessibilityActionCompat.ACTION_DISMISS, 5);
                }
                int i9 = this.state;
                if (i9 == 3) {
                    if (this.fitToContents) {
                        i3 = 4;
                    }
                    replaceAccessibilityActionForState(view, AccessibilityActionCompat.ACTION_COLLAPSE, i3);
                } else if (i9 == 4) {
                    if (this.fitToContents) {
                        i3 = 3;
                    }
                    replaceAccessibilityActionForState(view, AccessibilityActionCompat.ACTION_EXPAND, i3);
                } else if (i9 == 6) {
                    replaceAccessibilityActionForState(view, AccessibilityActionCompat.ACTION_COLLAPSE, 4);
                    replaceAccessibilityActionForState(view, AccessibilityActionCompat.ACTION_EXPAND, 3);
                }
            }
        }
    }

    public final void updateDrawableForTargetState(int i) {
        if (i != 2) {
            boolean z = i == 3;
            if (this.isShapeExpanded != z) {
                this.isShapeExpanded = z;
                if (this.materialShapeDrawable != null) {
                    ValueAnimator valueAnimator = this.interpolatorAnimator;
                    if (valueAnimator != null) {
                        if (valueAnimator.isRunning()) {
                            this.interpolatorAnimator.reverse();
                        } else {
                            float f2 = z ? 0.0f : 1.0f;
                            this.interpolatorAnimator.setFloatValues(new float[]{1.0f - f2, f2});
                            this.interpolatorAnimator.start();
                        }
                    }
                }
            }
        }
    }

    public final void updateImportantForAccessibility(boolean z) {
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference != null) {
            ViewParent parent = ((View) weakReference.get()).getParent();
            if (parent instanceof CoordinatorLayout) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
                int childCount = coordinatorLayout.getChildCount();
                if (z) {
                    if (this.importantForAccessibilityMap == null) {
                        this.importantForAccessibilityMap = new HashMap(childCount);
                    } else {
                        return;
                    }
                }
                for (int i = 0; i < childCount; i++) {
                    View childAt = coordinatorLayout.getChildAt(i);
                    if (childAt != this.viewRef.get()) {
                        if (z) {
                            this.importantForAccessibilityMap.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                            if (this.updateImportantForAccessibilityOnSiblings) {
                                ViewCompat.setImportantForAccessibility(childAt, 4);
                            }
                        } else if (this.updateImportantForAccessibilityOnSiblings) {
                            Map<View, Integer> map = this.importantForAccessibilityMap;
                            if (map != null && map.containsKey(childAt)) {
                                ViewCompat.setImportantForAccessibility(childAt, this.importantForAccessibilityMap.get(childAt).intValue());
                            }
                        }
                    }
                }
                if (!z) {
                    this.importantForAccessibilityMap = null;
                } else if (this.updateImportantForAccessibilityOnSiblings) {
                    ((View) this.viewRef.get()).sendAccessibilityEvent(8);
                }
            }
        }
    }

    public final void updatePeekHeight(boolean z) {
        if (this.viewRef != null) {
            calculateCollapsedOffset();
            if (this.state == 4) {
                View view = (View) this.viewRef.get();
                if (view == null) {
                    return;
                }
                if (z) {
                    settleToStatePendingLayout(this.state);
                } else {
                    view.requestLayout();
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0158  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BottomSheetBehavior(android.content.Context r10, android.util.AttributeSet r11) {
        /*
            r9 = this;
            r9.<init>(r10, r11)
            r0 = 0
            r9.saveFlags = r0
            r1 = 1
            r9.fitToContents = r1
            r9.updateImportantForAccessibilityOnSiblings = r0
            r2 = -1
            r9.maxWidth = r2
            r3 = 0
            r9.settleRunnable = r3
            r4 = 1056964608(0x3f000000, float:0.5)
            r9.halfExpandedRatio = r4
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            r9.elevation = r5
            r9.draggable = r1
            r6 = 4
            r9.state = r6
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r9.callbacks = r6
            r9.expandHalfwayActionId = r2
            com.google.android.material.bottomsheet.BottomSheetBehavior$5 r6 = new com.google.android.material.bottomsheet.BottomSheetBehavior$5
            r6.<init>()
            r9.dragCallback = r6
            android.content.res.Resources r6 = r10.getResources()
            int r7 = com.google.android.material.R$dimen.mtrl_min_touch_target_size
            int r6 = r6.getDimensionPixelSize(r7)
            r9.peekHeightGestureInsetBuffer = r6
            int[] r6 = com.google.android.material.R$styleable.BottomSheetBehavior_Layout
            android.content.res.TypedArray r6 = r10.obtainStyledAttributes(r11, r6)
            int r7 = com.google.android.material.R$styleable.BottomSheetBehavior_Layout_shapeAppearance
            boolean r7 = r6.hasValue(r7)
            r9.shapeThemingEnabled = r7
            int r7 = com.google.android.material.R$styleable.BottomSheetBehavior_Layout_backgroundTint
            boolean r7 = r6.hasValue(r7)
            if (r7 == 0) goto L_0x005a
            int r3 = com.google.android.material.R$styleable.BottomSheetBehavior_Layout_backgroundTint
            android.content.res.ColorStateList r3 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getColorStateList(r10, r6, r3)
            r9.createMaterialShapeDrawable(r10, r11, r7, r3)
            goto L_0x005d
        L_0x005a:
            r9.createMaterialShapeDrawable(r10, r11, r7, r3)
        L_0x005d:
            r11 = 2
            float[] r11 = new float[r11]
            r11 = {0, 1065353216} // fill-array
            android.animation.ValueAnimator r11 = android.animation.ValueAnimator.ofFloat(r11)
            r9.interpolatorAnimator = r11
            r7 = 500(0x1f4, double:2.47E-321)
            r11.setDuration(r7)
            android.animation.ValueAnimator r11 = r9.interpolatorAnimator
            com.google.android.material.bottomsheet.BottomSheetBehavior$3 r3 = new com.google.android.material.bottomsheet.BottomSheetBehavior$3
            r3.<init>()
            r11.addUpdateListener(r3)
            int r11 = com.google.android.material.R$styleable.BottomSheetBehavior_Layout_android_elevation
            float r11 = r6.getDimension(r11, r5)
            r9.elevation = r11
            int r11 = com.google.android.material.R$styleable.BottomSheetBehavior_Layout_android_maxWidth
            boolean r11 = r6.hasValue(r11)
            if (r11 == 0) goto L_0x0090
            int r11 = com.google.android.material.R$styleable.BottomSheetBehavior_Layout_android_maxWidth
            int r11 = r6.getDimensionPixelSize(r11, r2)
            r9.maxWidth = r11
        L_0x0090:
            int r11 = com.google.android.material.R$styleable.BottomSheetBehavior_Layout_behavior_peekHeight
            android.util.TypedValue r11 = r6.peekValue(r11)
            if (r11 == 0) goto L_0x00a0
            int r11 = r11.data
            if (r11 != r2) goto L_0x00a0
            r9.setPeekHeight(r11)
            goto L_0x00a9
        L_0x00a0:
            int r11 = com.google.android.material.R$styleable.BottomSheetBehavior_Layout_behavior_peekHeight
            int r11 = r6.getDimensionPixelSize(r11, r2)
            r9.setPeekHeight(r11)
        L_0x00a9:
            int r11 = com.google.android.material.R$styleable.BottomSheetBehavior_Layout_behavior_hideable
            boolean r11 = r6.getBoolean(r11, r0)
            r9.setHideable(r11)
            int r11 = com.google.android.material.R$styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored
            boolean r11 = r6.getBoolean(r11, r0)
            r9.gestureInsetBottomIgnored = r11
            int r11 = com.google.android.material.R$styleable.BottomSheetBehavior_Layout_behavior_fitToContents
            boolean r11 = r6.getBoolean(r11, r1)
            boolean r2 = r9.fitToContents
            if (r2 != r11) goto L_0x00c5
            goto L_0x00e1
        L_0x00c5:
            r9.fitToContents = r11
            java.lang.ref.WeakReference<V> r11 = r9.viewRef
            if (r11 == 0) goto L_0x00ce
            r9.calculateCollapsedOffset()
        L_0x00ce:
            boolean r11 = r9.fitToContents
            if (r11 == 0) goto L_0x00d9
            int r11 = r9.state
            r2 = 6
            if (r11 != r2) goto L_0x00d9
            r11 = 3
            goto L_0x00db
        L_0x00d9:
            int r11 = r9.state
        L_0x00db:
            r9.setStateInternal(r11)
            r9.updateAccessibilityActions()
        L_0x00e1:
            int r11 = com.google.android.material.R$styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed
            boolean r11 = r6.getBoolean(r11, r0)
            r9.skipCollapsed = r11
            int r11 = com.google.android.material.R$styleable.BottomSheetBehavior_Layout_behavior_draggable
            boolean r11 = r6.getBoolean(r11, r1)
            r9.draggable = r11
            int r11 = com.google.android.material.R$styleable.BottomSheetBehavior_Layout_behavior_saveFlags
            int r11 = r6.getInt(r11, r0)
            r9.saveFlags = r11
            int r11 = com.google.android.material.R$styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio
            float r11 = r6.getFloat(r11, r4)
            r9.setHalfExpandedRatio(r11)
            int r11 = com.google.android.material.R$styleable.BottomSheetBehavior_Layout_behavior_expandedOffset
            android.util.TypedValue r11 = r6.peekValue(r11)
            java.lang.String r2 = "offset must be greater than or equal to 0"
            if (r11 == 0) goto L_0x011f
            int r3 = r11.type
            r4 = 16
            if (r3 != r4) goto L_0x011f
            int r11 = r11.data
            if (r11 < 0) goto L_0x0119
            r9.expandedOffset = r11
            goto L_0x0129
        L_0x0119:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            r10.<init>(r2)
            throw r10
        L_0x011f:
            int r11 = com.google.android.material.R$styleable.BottomSheetBehavior_Layout_behavior_expandedOffset
            int r11 = r6.getDimensionPixelOffset(r11, r0)
            if (r11 < 0) goto L_0x0158
            r9.expandedOffset = r11
        L_0x0129:
            int r11 = com.google.android.material.R$styleable.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets
            boolean r11 = r6.getBoolean(r11, r0)
            r9.paddingBottomSystemWindowInsets = r11
            int r11 = com.google.android.material.R$styleable.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets
            boolean r11 = r6.getBoolean(r11, r0)
            r9.paddingLeftSystemWindowInsets = r11
            int r11 = com.google.android.material.R$styleable.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets
            boolean r11 = r6.getBoolean(r11, r0)
            r9.paddingRightSystemWindowInsets = r11
            int r11 = com.google.android.material.R$styleable.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets
            boolean r11 = r6.getBoolean(r11, r1)
            r9.paddingTopSystemWindowInsets = r11
            r6.recycle()
            android.view.ViewConfiguration r10 = android.view.ViewConfiguration.get(r10)
            int r10 = r10.getScaledMaximumFlingVelocity()
            float r10 = (float) r10
            r9.maximumVelocity = r10
            return
        L_0x0158:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            r10.<init>(r2)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.<init>(android.content.Context, android.util.AttributeSet):void");
    }
}
