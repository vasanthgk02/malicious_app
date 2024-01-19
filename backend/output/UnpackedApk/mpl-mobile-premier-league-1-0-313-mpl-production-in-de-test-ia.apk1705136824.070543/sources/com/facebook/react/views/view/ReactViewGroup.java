package com.facebook.react.views.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStructure;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.touch.OnInterceptTouchEventListener;
import com.facebook.react.touch.ReactHitSlopView;
import com.facebook.react.touch.ReactInterceptingViewGroup;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactClippingViewGroup;
import com.facebook.react.uimanager.ReactClippingViewGroupHelper;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.facebook.react.uimanager.ReactZIndexedViewGroup;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.ViewGroupDrawingOrderHelper;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.views.view.ReactViewBackgroundDrawable.BorderRadiusLocation;

public class ReactViewGroup extends ViewGroup implements ReactInterceptingViewGroup, ReactClippingViewGroup, ReactPointerEventsView, ReactHitSlopView, ReactZIndexedViewGroup {
    public static final LayoutParams sDefaultLayoutParam = new LayoutParams(0, 0);
    public static final Rect sHelperRect = new Rect();
    public View[] mAllChildren = null;
    public int mAllChildrenCount;
    public float mBackfaceOpacity = 1.0f;
    public String mBackfaceVisibility = "visible";
    public ChildrenLayoutChangeListener mChildrenLayoutChangeListener;
    public Rect mClippingRect;
    public final ViewGroupDrawingOrderHelper mDrawingOrderHelper;
    public Rect mHitSlopRect;
    public int mLayoutDirection;
    public boolean mNeedsOffscreenAlphaCompositing = false;
    public OnInterceptTouchEventListener mOnInterceptTouchEventListener;
    public String mOverflow;
    public Path mPath;
    public PointerEvents mPointerEvents = PointerEvents.AUTO;
    public ReactViewBackgroundDrawable mReactBackgroundDrawable;
    public boolean mRemoveClippedSubviews = false;

    public static final class ChildrenLayoutChangeListener implements OnLayoutChangeListener {
        public final ReactViewGroup mParent;

        public ChildrenLayoutChangeListener(ReactViewGroup reactViewGroup, AnonymousClass1 r2) {
            this.mParent = reactViewGroup;
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (this.mParent.getRemoveClippedSubviews()) {
                ReactViewGroup reactViewGroup = this.mParent;
                if (reactViewGroup.mRemoveClippedSubviews && reactViewGroup.getParent() != null) {
                    ImageOriginUtils.assertNotNull(reactViewGroup.mClippingRect);
                    ImageOriginUtils.assertNotNull(reactViewGroup.mAllChildren);
                    ReactViewGroup.sHelperRect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                    Rect rect = reactViewGroup.mClippingRect;
                    Rect rect2 = ReactViewGroup.sHelperRect;
                    if (rect.intersects(rect2.left, rect2.top, rect2.right, rect2.bottom) != (view.getParent() != null)) {
                        int i9 = 0;
                        for (int i10 = 0; i10 < reactViewGroup.mAllChildrenCount; i10++) {
                            View[] viewArr = reactViewGroup.mAllChildren;
                            if (viewArr[i10] == view) {
                                reactViewGroup.updateSubviewClipStatus(reactViewGroup.mClippingRect, i10, i9);
                                return;
                            }
                            if (viewArr[i10].getParent() == null) {
                                i9++;
                            }
                        }
                    }
                }
            }
        }
    }

    public ReactViewGroup(Context context) {
        super(context);
        setClipChildren(false);
        this.mDrawingOrderHelper = new ViewGroupDrawingOrderHelper(this);
    }

    private ReactViewBackgroundDrawable getOrCreateReactViewBackground() {
        if (this.mReactBackgroundDrawable == null) {
            this.mReactBackgroundDrawable = new ReactViewBackgroundDrawable(getContext());
            Drawable background = getBackground();
            super.setBackground(null);
            if (background == null) {
                super.setBackground(this.mReactBackgroundDrawable);
            } else {
                super.setBackground(new LayerDrawable(new Drawable[]{this.mReactBackgroundDrawable, background}));
            }
            boolean isRTL = I18nUtil.getInstance().isRTL(getContext());
            this.mLayoutDirection = isRTL ? 1 : 0;
            ReactViewBackgroundDrawable reactViewBackgroundDrawable = this.mReactBackgroundDrawable;
            if (reactViewBackgroundDrawable.mLayoutDirection != isRTL) {
                reactViewBackgroundDrawable.mLayoutDirection = isRTL;
            }
        }
        return this.mReactBackgroundDrawable;
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        ViewGroupDrawingOrderHelper viewGroupDrawingOrderHelper = this.mDrawingOrderHelper;
        if (viewGroupDrawingOrderHelper != null) {
            if (ViewGroupManager.getViewZIndex(view) != null) {
                viewGroupDrawingOrderHelper.mNumberOfChildrenWithZIndex++;
            }
            viewGroupDrawingOrderHelper.mDrawingOrderIndices = null;
            setChildrenDrawingOrderEnabled(this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder());
            super.addView(view, i, layoutParams);
            return;
        }
        throw null;
    }

    public void addViewWithSubviewClippingEnabled1(View view, int i) {
        ImageOriginUtils.assertCondition(this.mRemoveClippedSubviews);
        ImageOriginUtils.assertNotNull(this.mClippingRect);
        ImageOriginUtils.assertNotNull(this.mAllChildren);
        View[] viewArr = this.mAllChildren;
        ImageOriginUtils.assertNotNull(viewArr);
        int i2 = this.mAllChildrenCount;
        int length = viewArr.length;
        if (i == i2) {
            if (length == i2) {
                View[] viewArr2 = new View[(length + 12)];
                this.mAllChildren = viewArr2;
                System.arraycopy(viewArr, 0, viewArr2, 0, length);
                viewArr = this.mAllChildren;
            }
            int i3 = this.mAllChildrenCount;
            this.mAllChildrenCount = i3 + 1;
            viewArr[i3] = view;
        } else if (i < i2) {
            if (length == i2) {
                View[] viewArr3 = new View[(length + 12)];
                this.mAllChildren = viewArr3;
                System.arraycopy(viewArr, 0, viewArr3, 0, i);
                System.arraycopy(viewArr, i, this.mAllChildren, i + 1, i2 - i);
                viewArr = this.mAllChildren;
            } else {
                System.arraycopy(viewArr, i, viewArr, i + 1, i2 - i);
            }
            viewArr[i] = view;
            this.mAllChildrenCount++;
        } else {
            throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline43("index=", i, " count=", i2));
        }
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            if (this.mAllChildren[i5].getParent() == null) {
                i4++;
            }
        }
        updateSubviewClipStatus(this.mClippingRect, i, i4);
        view.addOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
    }

    public void dispatchDraw(Canvas canvas) {
        try {
            dispatchOverflowDraw(canvas);
            super.dispatchDraw(canvas);
        } catch (NullPointerException e2) {
            FLog.e((String) "ReactNative", (String) "NullPointerException when executing ViewGroup.dispatchDraw method", (Throwable) e2);
        } catch (StackOverflowError e3) {
            RootView rootView = ImageOriginUtils.getRootView(this);
            if (rootView != null) {
                rootView.handleException(e3);
            } else if (getContext() instanceof ReactContext) {
                ((ReactContext) getContext()).handleException(new IllegalViewOperationException("StackOverflowException", this, e3));
            } else {
                throw e3;
            }
        }
    }

    public final void dispatchOverflowDraw(Canvas canvas) {
        float f2;
        boolean z;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        Canvas canvas2 = canvas;
        String str = this.mOverflow;
        if (str != null) {
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1217487446) {
                if (hashCode == 466743410 && str.equals("visible")) {
                    c2 = 0;
                }
            } else if (str.equals("hidden")) {
                c2 = 1;
            }
            if (c2 == 0) {
                Path path = this.mPath;
                if (path != null) {
                    path.rewind();
                }
            } else if (c2 == 1) {
                float width = (float) getWidth();
                float height = (float) getHeight();
                ReactViewBackgroundDrawable reactViewBackgroundDrawable = this.mReactBackgroundDrawable;
                if (reactViewBackgroundDrawable != null) {
                    RectF directionAwareBorderInsets = reactViewBackgroundDrawable.getDirectionAwareBorderInsets();
                    if (directionAwareBorderInsets.top > 0.0f || directionAwareBorderInsets.left > 0.0f || directionAwareBorderInsets.bottom > 0.0f || directionAwareBorderInsets.right > 0.0f) {
                        f4 = directionAwareBorderInsets.left + 0.0f;
                        f2 = directionAwareBorderInsets.top + 0.0f;
                        width -= directionAwareBorderInsets.right;
                        height -= directionAwareBorderInsets.bottom;
                    } else {
                        f4 = 0.0f;
                        f2 = 0.0f;
                    }
                    ReactViewBackgroundDrawable reactViewBackgroundDrawable2 = this.mReactBackgroundDrawable;
                    float f8 = ImageOriginUtils.isUndefined(reactViewBackgroundDrawable2.mBorderRadius) ? 0.0f : reactViewBackgroundDrawable2.mBorderRadius;
                    float borderRadiusOrDefaultTo = this.mReactBackgroundDrawable.getBorderRadiusOrDefaultTo(f8, BorderRadiusLocation.TOP_LEFT);
                    float borderRadiusOrDefaultTo2 = this.mReactBackgroundDrawable.getBorderRadiusOrDefaultTo(f8, BorderRadiusLocation.TOP_RIGHT);
                    float borderRadiusOrDefaultTo3 = this.mReactBackgroundDrawable.getBorderRadiusOrDefaultTo(f8, BorderRadiusLocation.BOTTOM_LEFT);
                    float borderRadiusOrDefaultTo4 = this.mReactBackgroundDrawable.getBorderRadiusOrDefaultTo(f8, BorderRadiusLocation.BOTTOM_RIGHT);
                    boolean z2 = this.mLayoutDirection == 1;
                    float borderRadius = this.mReactBackgroundDrawable.getBorderRadius(BorderRadiusLocation.TOP_START);
                    float borderRadius2 = this.mReactBackgroundDrawable.getBorderRadius(BorderRadiusLocation.TOP_END);
                    float borderRadius3 = this.mReactBackgroundDrawable.getBorderRadius(BorderRadiusLocation.BOTTOM_START);
                    float f9 = borderRadiusOrDefaultTo4;
                    float borderRadius4 = this.mReactBackgroundDrawable.getBorderRadius(BorderRadiusLocation.BOTTOM_END);
                    float f10 = borderRadiusOrDefaultTo;
                    if (I18nUtil.getInstance().doLeftAndRightSwapInRTL(getContext())) {
                        f5 = ImageOriginUtils.isUndefined(borderRadius) ? f10 : borderRadius;
                        if (!ImageOriginUtils.isUndefined(borderRadius2)) {
                            borderRadiusOrDefaultTo2 = borderRadius2;
                        }
                        if (!ImageOriginUtils.isUndefined(borderRadius3)) {
                            borderRadiusOrDefaultTo3 = borderRadius3;
                        }
                        if (ImageOriginUtils.isUndefined(borderRadius4)) {
                            borderRadius4 = f9;
                        }
                        f7 = z2 ? borderRadiusOrDefaultTo2 : f5;
                        if (!z2) {
                            f5 = borderRadiusOrDefaultTo2;
                        }
                        f6 = z2 ? borderRadius4 : borderRadiusOrDefaultTo3;
                        if (z2) {
                            borderRadius4 = borderRadiusOrDefaultTo3;
                        }
                    } else {
                        float f11 = z2 ? borderRadius2 : borderRadius;
                        if (!z2) {
                            borderRadius = borderRadius2;
                        }
                        float f12 = z2 ? borderRadius4 : borderRadius3;
                        if (!z2) {
                            borderRadius3 = borderRadius4;
                        }
                        if (ImageOriginUtils.isUndefined(f11)) {
                            f11 = f10;
                        }
                        if (!ImageOriginUtils.isUndefined(borderRadius)) {
                            borderRadiusOrDefaultTo2 = borderRadius;
                        }
                        if (!ImageOriginUtils.isUndefined(f12)) {
                            borderRadiusOrDefaultTo3 = f12;
                        }
                        if (!ImageOriginUtils.isUndefined(borderRadius3)) {
                            borderRadius4 = borderRadius3;
                            f7 = f11;
                            f5 = borderRadiusOrDefaultTo2;
                            f6 = borderRadiusOrDefaultTo3;
                        } else {
                            f7 = f11;
                            f5 = borderRadiusOrDefaultTo2;
                            f6 = borderRadiusOrDefaultTo3;
                            borderRadius4 = f9;
                        }
                    }
                    if (f7 > 0.0f || f5 > 0.0f || borderRadius4 > 0.0f || f6 > 0.0f) {
                        if (this.mPath == null) {
                            this.mPath = new Path();
                        }
                        this.mPath.rewind();
                        this.mPath.addRoundRect(new RectF(f4, f2, width, height), new float[]{Math.max(f7 - directionAwareBorderInsets.left, 0.0f), Math.max(f7 - directionAwareBorderInsets.top, 0.0f), Math.max(f5 - directionAwareBorderInsets.right, 0.0f), Math.max(f5 - directionAwareBorderInsets.top, 0.0f), Math.max(borderRadius4 - directionAwareBorderInsets.right, 0.0f), Math.max(borderRadius4 - directionAwareBorderInsets.bottom, 0.0f), Math.max(f6 - directionAwareBorderInsets.left, 0.0f), Math.max(f6 - directionAwareBorderInsets.bottom, 0.0f)}, Direction.CW);
                        canvas2.clipPath(this.mPath);
                        f3 = f4;
                        z = true;
                    } else {
                        f3 = f4;
                        z = false;
                    }
                } else {
                    f3 = 0.0f;
                    z = false;
                    f2 = 0.0f;
                }
                if (!z) {
                    canvas2.clipRect(new RectF(f3, f2, width, height));
                }
            }
        }
    }

    @TargetApi(23)
    public void dispatchProvideStructure(ViewStructure viewStructure) {
        try {
            super.dispatchProvideStructure(viewStructure);
        } catch (NullPointerException e2) {
            FLog.e((String) "ReactNative", (String) "NullPointerException when executing dispatchProvideStructure", (Throwable) e2);
        }
    }

    public void dispatchSetPressed(boolean z) {
    }

    public int getAllChildrenCount() {
        return this.mAllChildrenCount;
    }

    public int getBackgroundColor() {
        if (getBackground() != null) {
            return ((ReactViewBackgroundDrawable) getBackground()).mColor;
        }
        return 0;
    }

    public int getChildDrawingOrder(int i, int i2) {
        return this.mDrawingOrderHelper.getChildDrawingOrder(i, i2);
    }

    public boolean getChildVisibleRect(View view, Rect rect, Point point) {
        return super.getChildVisibleRect(view, rect, point);
    }

    public void getClippingRect(Rect rect) {
        rect.set(this.mClippingRect);
    }

    public Rect getHitSlopRect() {
        return this.mHitSlopRect;
    }

    public String getOverflow() {
        return this.mOverflow;
    }

    public PointerEvents getPointerEvents() {
        return this.mPointerEvents;
    }

    public boolean getRemoveClippedSubviews() {
        return this.mRemoveClippedSubviews;
    }

    public int getZIndexMappedChildIndex(int i) {
        return this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder() ? this.mDrawingOrderHelper.getChildDrawingOrder(getChildCount(), i) : i;
    }

    public boolean hasOverlappingRendering() {
        return this.mNeedsOffscreenAlphaCompositing;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mRemoveClippedSubviews) {
            updateClippingRect();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        OnInterceptTouchEventListener onInterceptTouchEventListener = this.mOnInterceptTouchEventListener;
        if (onInterceptTouchEventListener != null) {
            int i = ((JSResponderHandler) onInterceptTouchEventListener).mCurrentJSResponder;
            boolean z = false;
            if (!(i == -1 || motionEvent.getAction() == 1 || getId() != i)) {
                z = true;
            }
            if (z) {
                return true;
            }
        }
        PointerEvents pointerEvents = this.mPointerEvents;
        if (pointerEvents == PointerEvents.NONE || pointerEvents == PointerEvents.BOX_ONLY) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public void onMeasure(int i, int i2) {
        ImageOriginUtils.assertExplicitMeasureSpec(i, i2);
        setMeasuredDimension(MeasureSpec.getSize(i), MeasureSpec.getSize(i2));
    }

    public void onRtlPropertiesChanged(int i) {
        ReactViewBackgroundDrawable reactViewBackgroundDrawable = this.mReactBackgroundDrawable;
        if (reactViewBackgroundDrawable != null) {
            int i2 = this.mLayoutDirection;
            if (reactViewBackgroundDrawable.mLayoutDirection != i2) {
                reactViewBackgroundDrawable.mLayoutDirection = i2;
            }
        }
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.mRemoveClippedSubviews) {
            updateClippingRect();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        PointerEvents pointerEvents = this.mPointerEvents;
        return (pointerEvents == PointerEvents.NONE || pointerEvents == PointerEvents.BOX_NONE) ? false : true;
    }

    public void removeView(View view) {
        UiThreadUtil.assertOnUiThread();
        ViewGroupDrawingOrderHelper viewGroupDrawingOrderHelper = this.mDrawingOrderHelper;
        if (viewGroupDrawingOrderHelper != null) {
            if (ViewGroupManager.getViewZIndex(view) != null) {
                viewGroupDrawingOrderHelper.mNumberOfChildrenWithZIndex--;
            }
            viewGroupDrawingOrderHelper.mDrawingOrderIndices = null;
            setChildrenDrawingOrderEnabled(this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder());
            super.removeView(view);
            return;
        }
        throw null;
    }

    public void removeViewAt(int i) {
        UiThreadUtil.assertOnUiThread();
        ViewGroupDrawingOrderHelper viewGroupDrawingOrderHelper = this.mDrawingOrderHelper;
        View childAt = getChildAt(i);
        if (viewGroupDrawingOrderHelper != null) {
            if (ViewGroupManager.getViewZIndex(childAt) != null) {
                viewGroupDrawingOrderHelper.mNumberOfChildrenWithZIndex--;
            }
            viewGroupDrawingOrderHelper.mDrawingOrderIndices = null;
            setChildrenDrawingOrderEnabled(this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder());
            super.removeViewAt(i);
            return;
        }
        throw null;
    }

    public void removeViewWithSubviewClippingEnabled(View view) {
        UiThreadUtil.assertOnUiThread();
        ImageOriginUtils.assertCondition(this.mRemoveClippedSubviews);
        ImageOriginUtils.assertNotNull(this.mClippingRect);
        ImageOriginUtils.assertNotNull(this.mAllChildren);
        view.removeOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
        int i = this.mAllChildrenCount;
        View[] viewArr = this.mAllChildren;
        ImageOriginUtils.assertNotNull(viewArr);
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                i2 = -1;
                break;
            } else if (viewArr[i2] == view) {
                break;
            } else {
                i2++;
            }
        }
        if (this.mAllChildren[i2].getParent() != null) {
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                if (this.mAllChildren[i4].getParent() == null) {
                    i3++;
                }
            }
            super.removeViewsInLayout(i2 - i3, 1);
        }
        View[] viewArr2 = this.mAllChildren;
        ImageOriginUtils.assertNotNull(viewArr2);
        int i5 = this.mAllChildrenCount;
        int i6 = i5 - 1;
        if (i2 == i6) {
            this.mAllChildrenCount = i6;
            viewArr2[i6] = null;
        } else if (i2 < 0 || i2 >= i5) {
            throw new IndexOutOfBoundsException();
        } else {
            System.arraycopy(viewArr2, i2 + 1, viewArr2, i2, (i5 - i2) - 1);
            int i7 = this.mAllChildrenCount - 1;
            this.mAllChildrenCount = i7;
            viewArr2[i7] = null;
        }
    }

    @SuppressLint({"MissingSuperCall"})
    public void requestLayout() {
    }

    public void setBackfaceVisibility(String str) {
        this.mBackfaceVisibility = str;
        setBackfaceVisibilityDependantOpacity();
    }

    public void setBackfaceVisibilityDependantOpacity() {
        if (this.mBackfaceVisibility.equals("visible")) {
            setAlpha(this.mBackfaceOpacity);
            return;
        }
        float rotationX = getRotationX();
        float rotationY = getRotationY();
        if (rotationX >= -90.0f && rotationX < 90.0f && rotationY >= -90.0f && rotationY < 90.0f) {
            setAlpha(this.mBackfaceOpacity);
        } else {
            setAlpha(0.0f);
        }
    }

    public void setBackground(Drawable drawable) {
        throw new UnsupportedOperationException("This method is not supported for ReactViewGroup instances");
    }

    public void setBackgroundColor(int i) {
        if (i != 0 || this.mReactBackgroundDrawable != null) {
            ReactViewBackgroundDrawable orCreateReactViewBackground = getOrCreateReactViewBackground();
            orCreateReactViewBackground.mColor = i;
            orCreateReactViewBackground.invalidateSelf();
        }
    }

    public void setBorderColor(int i, float f2, float f3) {
        getOrCreateReactViewBackground().setBorderColor(i, f2, f3);
    }

    public void setBorderRadius(float f2) {
        ReactViewBackgroundDrawable orCreateReactViewBackground = getOrCreateReactViewBackground();
        if (!ImageOriginUtils.floatsEqual(orCreateReactViewBackground.mBorderRadius, f2)) {
            orCreateReactViewBackground.mBorderRadius = f2;
            orCreateReactViewBackground.mNeedUpdatePathForBorderRadius = true;
            orCreateReactViewBackground.invalidateSelf();
        }
    }

    public void setBorderStyle(String str) {
        getOrCreateReactViewBackground().setBorderStyle(str);
    }

    public void setBorderWidth(int i, float f2) {
        getOrCreateReactViewBackground().setBorderWidth(i, f2);
    }

    public void setHitSlopRect(Rect rect) {
        this.mHitSlopRect = rect;
    }

    public void setNeedsOffscreenAlphaCompositing(boolean z) {
        this.mNeedsOffscreenAlphaCompositing = z;
    }

    public void setOnInterceptTouchEventListener(OnInterceptTouchEventListener onInterceptTouchEventListener) {
        this.mOnInterceptTouchEventListener = onInterceptTouchEventListener;
    }

    public void setOpacityIfPossible(float f2) {
        this.mBackfaceOpacity = f2;
        setBackfaceVisibilityDependantOpacity();
    }

    public void setOverflow(String str) {
        this.mOverflow = str;
        invalidate();
    }

    public void setPointerEvents(PointerEvents pointerEvents) {
        this.mPointerEvents = pointerEvents;
    }

    public void setRemoveClippedSubviews(boolean z) {
        if (z != this.mRemoveClippedSubviews) {
            this.mRemoveClippedSubviews = z;
            if (z) {
                Rect rect = new Rect();
                this.mClippingRect = rect;
                ReactClippingViewGroupHelper.calculateClippingRect(this, rect);
                int childCount = getChildCount();
                this.mAllChildrenCount = childCount;
                this.mAllChildren = new View[Math.max(12, childCount)];
                this.mChildrenLayoutChangeListener = new ChildrenLayoutChangeListener(this, null);
                for (int i = 0; i < this.mAllChildrenCount; i++) {
                    View childAt = getChildAt(i);
                    this.mAllChildren[i] = childAt;
                    childAt.addOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
                }
                updateClippingRect();
            } else {
                ImageOriginUtils.assertNotNull(this.mClippingRect);
                ImageOriginUtils.assertNotNull(this.mAllChildren);
                ImageOriginUtils.assertNotNull(this.mChildrenLayoutChangeListener);
                for (int i2 = 0; i2 < this.mAllChildrenCount; i2++) {
                    this.mAllChildren[i2].removeOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
                }
                getDrawingRect(this.mClippingRect);
                updateClippingToRect(this.mClippingRect);
                this.mAllChildren = null;
                this.mClippingRect = null;
                this.mAllChildrenCount = 0;
                this.mChildrenLayoutChangeListener = null;
            }
        }
    }

    public void setTranslucentBackgroundDrawable(Drawable drawable) {
        super.setBackground(null);
        if (this.mReactBackgroundDrawable != null && drawable != null) {
            super.setBackground(new LayerDrawable(new Drawable[]{this.mReactBackgroundDrawable, drawable}));
        } else if (drawable != null) {
            super.setBackground(drawable);
        }
    }

    public void updateClippingRect() {
        if (this.mRemoveClippedSubviews) {
            ImageOriginUtils.assertNotNull(this.mClippingRect);
            ImageOriginUtils.assertNotNull(this.mAllChildren);
            ReactClippingViewGroupHelper.calculateClippingRect(this, this.mClippingRect);
            updateClippingToRect(this.mClippingRect);
        }
    }

    public final void updateClippingToRect(Rect rect) {
        ImageOriginUtils.assertNotNull(this.mAllChildren);
        int i = 0;
        for (int i2 = 0; i2 < this.mAllChildrenCount; i2++) {
            updateSubviewClipStatus(rect, i2, i);
            if (this.mAllChildren[i2].getParent() == null) {
                i++;
            }
        }
    }

    public void updateDrawingOrder() {
        ViewGroupDrawingOrderHelper viewGroupDrawingOrderHelper = this.mDrawingOrderHelper;
        viewGroupDrawingOrderHelper.mNumberOfChildrenWithZIndex = 0;
        for (int i = 0; i < viewGroupDrawingOrderHelper.mViewGroup.getChildCount(); i++) {
            if (ViewGroupManager.getViewZIndex(viewGroupDrawingOrderHelper.mViewGroup.getChildAt(i)) != null) {
                viewGroupDrawingOrderHelper.mNumberOfChildrenWithZIndex++;
            }
        }
        viewGroupDrawingOrderHelper.mDrawingOrderIndices = null;
        setChildrenDrawingOrderEnabled(this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder());
        invalidate();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0061, code lost:
        if (r7 != false) goto L_0x0063;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateSubviewClipStatus(android.graphics.Rect r7, int r8, int r9) {
        /*
            r6 = this;
            com.facebook.react.bridge.UiThreadUtil.assertOnUiThread()
            android.view.View[] r0 = r6.mAllChildren
            com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.assertNotNull(r0)
            android.view.View[] r0 = (android.view.View[]) r0
            r0 = r0[r8]
            android.graphics.Rect r1 = sHelperRect
            int r2 = r0.getLeft()
            int r3 = r0.getTop()
            int r4 = r0.getRight()
            int r5 = r0.getBottom()
            r1.set(r2, r3, r4, r5)
            android.graphics.Rect r1 = sHelperRect
            int r2 = r1.left
            int r3 = r1.top
            int r4 = r1.right
            int r1 = r1.bottom
            boolean r7 = r7.intersects(r2, r3, r4, r1)
            android.view.animation.Animation r1 = r0.getAnimation()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x003f
            boolean r1 = r1.hasEnded()
            if (r1 != 0) goto L_0x003f
            r1 = 1
            goto L_0x0040
        L_0x003f:
            r1 = 0
        L_0x0040:
            if (r7 != 0) goto L_0x004f
            android.view.ViewParent r4 = r0.getParent()
            if (r4 == 0) goto L_0x004f
            if (r1 != 0) goto L_0x004f
            int r8 = r8 - r9
            super.removeViewsInLayout(r8, r3)
            goto L_0x0063
        L_0x004f:
            if (r7 == 0) goto L_0x0061
            android.view.ViewParent r1 = r0.getParent()
            if (r1 != 0) goto L_0x0061
            int r8 = r8 - r9
            android.view.ViewGroup$LayoutParams r7 = sDefaultLayoutParam
            super.addViewInLayout(r0, r8, r7, r3)
            r6.invalidate()
            goto L_0x0063
        L_0x0061:
            if (r7 == 0) goto L_0x0064
        L_0x0063:
            r2 = 1
        L_0x0064:
            if (r2 == 0) goto L_0x0075
            boolean r7 = r0 instanceof com.facebook.react.uimanager.ReactClippingViewGroup
            if (r7 == 0) goto L_0x0075
            com.facebook.react.uimanager.ReactClippingViewGroup r0 = (com.facebook.react.uimanager.ReactClippingViewGroup) r0
            boolean r7 = r0.getRemoveClippedSubviews()
            if (r7 == 0) goto L_0x0075
            r0.updateClippingRect()
        L_0x0075:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.view.ReactViewGroup.updateSubviewClipStatus(android.graphics.Rect, int, int):void");
    }

    public void setBorderRadius(float f2, int i) {
        getOrCreateReactViewBackground().setRadius(f2, i);
    }
}
