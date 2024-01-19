package com.google.android.material.floatingactionbutton;

import a.a.a.a.d.b;
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView.ScaleType;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatImageHelper;
import androidx.collection.SimpleArrayMap;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams;
import androidx.core.view.ViewCompat;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.uimanager.BaseViewManager;
import com.google.android.material.R$animator;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomappbar.BottomAppBar.AnonymousClass2;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.expandable.ExpandableWidget;
import com.google.android.material.expandable.ExpandableWidgetHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalTransformationCallback;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalVisibilityChangedListener;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.resources.TextAppearanceConfig;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.stateful.ExtendableSavedState;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FloatingActionButton extends VisibilityAwareImageButton implements ExpandableWidget, Shapeable, AttachedBehavior {
    public static final int DEF_STYLE_RES = R$style.Widget_Design_FloatingActionButton;
    public ColorStateList backgroundTint;
    public Mode backgroundTintMode;
    public int borderWidth;
    public boolean compatPadding;
    public int customSize;
    public final ExpandableWidgetHelper expandableWidgetHelper;
    public final AppCompatImageHelper imageHelper;
    public Mode imageMode;
    public int imagePadding;
    public ColorStateList imageTint;
    public FloatingActionButtonImpl impl;
    public int maxImageSize;
    public ColorStateList rippleColor;
    public final Rect shadowPadding;
    public int size;
    public final Rect touchArea;

    public static class BaseBehavior<T extends FloatingActionButton> extends androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior<T> {
        public boolean autoHideEnabled;
        public Rect tmpRect;

        public BaseBehavior() {
            this.autoHideEnabled = true;
        }

        public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            return getInsetDodgeRect((FloatingActionButton) view, rect);
        }

        public void onAttachedToLayoutParams(LayoutParams layoutParams) {
            if (layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view2, floatingActionButton);
            } else {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof LayoutParams ? ((LayoutParams) layoutParams).mBehavior instanceof BottomSheetBehavior : false) {
                    updateFabVisibilityForBottomSheet(view2, floatingActionButton);
                }
            }
            return false;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
            int i2;
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            List<View> dependencies = coordinatorLayout.getDependencies(floatingActionButton);
            int size = dependencies.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                View view2 = dependencies.get(i4);
                if (!(view2 instanceof AppBarLayout)) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if ((layoutParams instanceof LayoutParams ? ((LayoutParams) layoutParams).mBehavior instanceof BottomSheetBehavior : false) && updateFabVisibilityForBottomSheet(view2, floatingActionButton)) {
                        break;
                    }
                } else if (updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view2, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.onLayoutChild(floatingActionButton, i);
            Rect rect = floatingActionButton.shadowPadding;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                LayoutParams layoutParams2 = (LayoutParams) floatingActionButton.getLayoutParams();
                if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - layoutParams2.rightMargin) {
                    i2 = rect.right;
                } else {
                    i2 = floatingActionButton.getLeft() <= layoutParams2.leftMargin ? -rect.left : 0;
                }
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - layoutParams2.bottomMargin) {
                    i3 = rect.bottom;
                } else if (floatingActionButton.getTop() <= layoutParams2.topMargin) {
                    i3 = -rect.top;
                }
                if (i3 != 0) {
                    ViewCompat.offsetTopAndBottom(floatingActionButton, i3);
                }
                if (i2 != 0) {
                    ViewCompat.offsetLeftAndRight(floatingActionButton, i2);
                }
            }
            return true;
        }

        public final boolean shouldUpdateVisibility(View view, FloatingActionButton floatingActionButton) {
            LayoutParams layoutParams = (LayoutParams) floatingActionButton.getLayoutParams();
            if (this.autoHideEnabled && layoutParams.mAnchorId == view.getId() && floatingActionButton.getUserSetVisibility() == 0) {
                return true;
            }
            return false;
        }

        public final boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!shouldUpdateVisibility(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.tmpRect == null) {
                this.tmpRect = new Rect();
            }
            Rect rect = this.tmpRect;
            DescendantOffsetUtils.getDescendantRect(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.hide(null, false);
            } else {
                floatingActionButton.show(null, false);
            }
            return true;
        }

        public final boolean updateFabVisibilityForBottomSheet(View view, FloatingActionButton floatingActionButton) {
            if (!shouldUpdateVisibility(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((LayoutParams) floatingActionButton.getLayoutParams()).topMargin) {
                floatingActionButton.hide(null, false);
            } else {
                floatingActionButton.show(null, false);
            }
            return true;
        }

        public boolean getInsetDodgeRect(FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.shadowPadding;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FloatingActionButton_Behavior_Layout);
            this.autoHideEnabled = obtainStyledAttributes.getBoolean(R$styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            obtainStyledAttributes.recycle();
        }
    }

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static abstract class OnVisibilityChangedListener {
        public void onHidden(FloatingActionButton floatingActionButton) {
        }

        public void onShown(FloatingActionButton floatingActionButton) {
        }
    }

    public class ShadowDelegateImpl implements ShadowViewDelegate {
        public ShadowDelegateImpl() {
        }
    }

    public class TransformationCallbackWrapper<T extends FloatingActionButton> implements InternalTransformationCallback {
        public final TransformationCallback<T> listener;

        public TransformationCallbackWrapper(TransformationCallback<T> transformationCallback) {
            this.listener = transformationCallback;
        }

        public boolean equals(Object obj) {
            return (obj instanceof TransformationCallbackWrapper) && ((TransformationCallbackWrapper) obj).listener.equals(this.listener);
        }

        public int hashCode() {
            return this.listener.hashCode();
        }

        public void onScaleChanged() {
            TransformationCallback<T> transformationCallback = this.listener;
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            AnonymousClass2 r0 = (AnonymousClass2) transformationCallback;
            if (r0 != null) {
                BottomAppBar.this.materialShapeDrawable.setInterpolation(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
                return;
            }
            throw null;
        }

        public void onTranslationChanged() {
            TransformationCallback<T> transformationCallback = this.listener;
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            AnonymousClass2 r0 = (AnonymousClass2) transformationCallback;
            if (r0 != null) {
                float translationX = floatingActionButton.getTranslationX();
                if (BottomAppBar.this.getTopEdgeTreatment().horizontalOffset != translationX) {
                    BottomAppBar.this.getTopEdgeTreatment().horizontalOffset = translationX;
                    BottomAppBar.this.materialShapeDrawable.invalidateSelf();
                }
                float f2 = 0.0f;
                float max = Math.max(0.0f, -floatingActionButton.getTranslationY());
                if (BottomAppBar.this.getTopEdgeTreatment().cradleVerticalOffset != max) {
                    BottomAppBar.this.getTopEdgeTreatment().setCradleVerticalOffset(max);
                    BottomAppBar.this.materialShapeDrawable.invalidateSelf();
                }
                MaterialShapeDrawable materialShapeDrawable = BottomAppBar.this.materialShapeDrawable;
                if (floatingActionButton.getVisibility() == 0) {
                    f2 = floatingActionButton.getScaleY();
                }
                materialShapeDrawable.setInterpolation(f2);
                return;
            }
            throw null;
        }
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.floatingActionButtonStyle);
    }

    private FloatingActionButtonImpl getImpl() {
        if (this.impl == null) {
            this.impl = new FloatingActionButtonImplLollipop(this, new ShadowDelegateImpl());
        }
        return this.impl;
    }

    public static int resolveAdjustedSize(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i, size2);
        }
        if (mode == 0) {
            return i;
        }
        if (mode == 1073741824) {
            return size2;
        }
        throw new IllegalArgumentException();
    }

    public void addOnHideAnimationListener(AnimatorListener animatorListener) {
        FloatingActionButtonImpl impl2 = getImpl();
        if (impl2.hideListeners == null) {
            impl2.hideListeners = new ArrayList<>();
        }
        impl2.hideListeners.add(animatorListener);
    }

    public void addOnShowAnimationListener(AnimatorListener animatorListener) {
        FloatingActionButtonImpl impl2 = getImpl();
        if (impl2.showListeners == null) {
            impl2.showListeners = new ArrayList<>();
        }
        impl2.showListeners.add(animatorListener);
    }

    public void addTransformationCallback(TransformationCallback<? extends FloatingActionButton> transformationCallback) {
        FloatingActionButtonImpl impl2 = getImpl();
        TransformationCallbackWrapper transformationCallbackWrapper = new TransformationCallbackWrapper(transformationCallback);
        if (impl2.transformationCallbacks == null) {
            impl2.transformationCallbacks = new ArrayList<>();
        }
        impl2.transformationCallbacks.add(transformationCallbackWrapper);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().onDrawableStateChanged(getDrawableState());
    }

    public ColorStateList getBackgroundTintList() {
        return this.backgroundTint;
    }

    public Mode getBackgroundTintMode() {
        return this.backgroundTintMode;
    }

    public androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().getElevation();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().hoveredFocusedTranslationZ;
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().pressedTranslationZ;
    }

    public Drawable getContentBackground() {
        return getImpl().contentBackground;
    }

    @Deprecated
    public boolean getContentRect(Rect rect) {
        if (!ViewCompat.isLaidOut(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        offsetRectWithShadow(rect);
        return true;
    }

    public int getCustomSize() {
        return this.customSize;
    }

    public int getExpandedComponentIdHint() {
        return this.expandableWidgetHelper.expandedComponentIdHint;
    }

    public MotionSpec getHideMotionSpec() {
        return getImpl().hideMotionSpec;
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.rippleColor;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.rippleColor;
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        ShapeAppearanceModel shapeAppearanceModel = getImpl().shapeAppearance;
        b.checkNotNull(shapeAppearanceModel);
        return shapeAppearanceModel;
    }

    public MotionSpec getShowMotionSpec() {
        return getImpl().showMotionSpec;
    }

    public int getSize() {
        return this.size;
    }

    public int getSizeDimension() {
        return getSizeDimension(this.size);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.imageTint;
    }

    public Mode getSupportImageTintMode() {
        return this.imageMode;
    }

    public boolean getUseCompatPadding() {
        return this.compatPadding;
    }

    public void hide(final OnVisibilityChangedListener onVisibilityChangedListener, boolean z) {
        AnonymousClass1 r4;
        FloatingActionButtonImpl impl2 = getImpl();
        if (onVisibilityChangedListener == null) {
            r4 = null;
        } else {
            r4 = new InternalVisibilityChangedListener() {
            };
        }
        if (!impl2.isOrWillBeHidden()) {
            Animator animator = impl2.currentAnimator;
            if (animator != null) {
                animator.cancel();
            }
            if (impl2.shouldAnimateVisibilityChange()) {
                MotionSpec motionSpec = impl2.hideMotionSpec;
                if (motionSpec == null) {
                    if (impl2.defaultHideMotionSpec == null) {
                        impl2.defaultHideMotionSpec = MotionSpec.createFromResource(impl2.view.getContext(), R$animator.design_fab_hide_motion_spec);
                    }
                    motionSpec = impl2.defaultHideMotionSpec;
                    b.checkNotNull(motionSpec);
                }
                AnimatorSet createAnimator = impl2.createAnimator(motionSpec, 0.0f, 0.0f, 0.0f);
                createAnimator.addListener(new AnimatorListenerAdapter(z, r4) {
                    public boolean cancelled;
                    public final /* synthetic */ boolean val$fromUser;
                    public final /* synthetic */ InternalVisibilityChangedListener val$listener;

                    {
                        this.val$fromUser = r2;
                        this.val$listener = r3;
                    }

                    public void onAnimationCancel(Animator animator) {
                        this.cancelled = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                        floatingActionButtonImpl.animState = 0;
                        floatingActionButtonImpl.currentAnimator = null;
                        if (!this.cancelled) {
                            floatingActionButtonImpl.view.internalSetVisibility(this.val$fromUser ? 8 : 4, this.val$fromUser);
                            InternalVisibilityChangedListener internalVisibilityChangedListener = this.val$listener;
                            if (internalVisibilityChangedListener != null) {
                                com.google.android.material.floatingactionbutton.FloatingActionButton.AnonymousClass1 r3 = (com.google.android.material.floatingactionbutton.FloatingActionButton.AnonymousClass1) internalVisibilityChangedListener;
                                r5.onHidden(FloatingActionButton.this);
                            }
                        }
                    }

                    public void onAnimationStart(Animator animator) {
                        FloatingActionButtonImpl.this.view.internalSetVisibility(0, this.val$fromUser);
                        FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                        floatingActionButtonImpl.animState = 1;
                        floatingActionButtonImpl.currentAnimator = animator;
                        this.cancelled = false;
                    }
                });
                ArrayList<AnimatorListener> arrayList = impl2.hideListeners;
                if (arrayList != null) {
                    Iterator<AnimatorListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        createAnimator.addListener(it.next());
                    }
                }
                createAnimator.start();
                return;
            }
            impl2.view.internalSetVisibility(z ? 8 : 4, z);
            if (r4 != null) {
                r5.onHidden(FloatingActionButton.this);
            }
        }
    }

    public boolean isExpanded() {
        return this.expandableWidgetHelper.expanded;
    }

    public boolean isOrWillBeHidden() {
        return getImpl().isOrWillBeHidden();
    }

    public boolean isOrWillBeShown() {
        return getImpl().isOrWillBeShown();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().jumpDrawableToCurrentState();
    }

    public final void offsetRectWithShadow(Rect rect) {
        int i = rect.left;
        Rect rect2 = this.shadowPadding;
        rect.left = i + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    public final void onApplySupportImageTint() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            ColorStateList colorStateList = this.imageTint;
            if (colorStateList == null) {
                b.clearColorFilter(drawable);
                return;
            }
            int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
            Mode mode = this.imageMode;
            if (mode == null) {
                mode = Mode.SRC_IN;
            }
            drawable.mutate().setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(colorForState, mode));
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        FloatingActionButtonImpl impl2 = getImpl();
        MaterialShapeDrawable materialShapeDrawable = impl2.shapeDrawable;
        if (materialShapeDrawable != null) {
            TextAppearanceConfig.setParentAbsoluteElevation(impl2.view, materialShapeDrawable);
        }
        if (impl2.requirePreDrawListener()) {
            ViewTreeObserver viewTreeObserver = impl2.view.getViewTreeObserver();
            if (impl2.preDrawListener == null) {
                impl2.preDrawListener = new OnPreDrawListener() {
                    public boolean onPreDraw() {
                        FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                        float rotation = floatingActionButtonImpl.view.getRotation();
                        if (floatingActionButtonImpl.rotation != rotation) {
                            floatingActionButtonImpl.rotation = rotation;
                            floatingActionButtonImpl.updateFromViewRotation();
                        }
                        return true;
                    }
                };
            }
            viewTreeObserver.addOnPreDrawListener(impl2.preDrawListener);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FloatingActionButtonImpl impl2 = getImpl();
        ViewTreeObserver viewTreeObserver = impl2.view.getViewTreeObserver();
        OnPreDrawListener onPreDrawListener = impl2.preDrawListener;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            impl2.preDrawListener = null;
        }
    }

    public void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.imagePadding = (sizeDimension - this.maxImageSize) / 2;
        getImpl().updatePadding();
        int min = Math.min(resolveAdjustedSize(sizeDimension, i), resolveAdjustedSize(sizeDimension, i2));
        Rect rect = this.shadowPadding;
        setMeasuredDimension(rect.left + min + rect.right, min + rect.top + rect.bottom);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.mSuperState);
        ExpandableWidgetHelper expandableWidgetHelper2 = this.expandableWidgetHelper;
        Object orDefault = extendableSavedState.extendableStates.getOrDefault("expandableWidgetHelper", null);
        b.checkNotNull(orDefault);
        Bundle bundle = (Bundle) orDefault;
        if (expandableWidgetHelper2 != null) {
            expandableWidgetHelper2.expanded = bundle.getBoolean(BaseViewManager.STATE_EXPANDED, false);
            expandableWidgetHelper2.expandedComponentIdHint = bundle.getInt("expandedComponentIdHint", 0);
            if (expandableWidgetHelper2.expanded) {
                ViewParent parent = expandableWidgetHelper2.widget.getParent();
                if (parent instanceof CoordinatorLayout) {
                    ((CoordinatorLayout) parent).dispatchDependentViewsChanged(expandableWidgetHelper2.widget);
                }
            }
            return;
        }
        throw null;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (onSaveInstanceState == null) {
            onSaveInstanceState = new Bundle();
        }
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(onSaveInstanceState);
        SimpleArrayMap<String, Bundle> simpleArrayMap = extendableSavedState.extendableStates;
        ExpandableWidgetHelper expandableWidgetHelper2 = this.expandableWidgetHelper;
        if (expandableWidgetHelper2 != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(BaseViewManager.STATE_EXPANDED, expandableWidgetHelper2.expanded);
            bundle.putInt("expandedComponentIdHint", expandableWidgetHelper2.expandedComponentIdHint);
            simpleArrayMap.put("expandableWidgetHelper", bundle);
            return extendableSavedState;
        }
        throw null;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || !getContentRect(this.touchArea) || this.touchArea.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setBackgroundColor(int i) {
    }

    public void setBackgroundDrawable(Drawable drawable) {
    }

    public void setBackgroundResource(int i) {
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.backgroundTint != colorStateList) {
            this.backgroundTint = colorStateList;
            FloatingActionButtonImpl impl2 = getImpl();
            MaterialShapeDrawable materialShapeDrawable = impl2.shapeDrawable;
            if (materialShapeDrawable != null) {
                materialShapeDrawable.setTintList(colorStateList);
            }
            BorderDrawable borderDrawable = impl2.borderDrawable;
            if (borderDrawable != null) {
                borderDrawable.setBorderTint(colorStateList);
            }
        }
    }

    public void setBackgroundTintMode(Mode mode) {
        if (this.backgroundTintMode != mode) {
            this.backgroundTintMode = mode;
            MaterialShapeDrawable materialShapeDrawable = getImpl().shapeDrawable;
            if (materialShapeDrawable != null) {
                materialShapeDrawable.setTintMode(mode);
            }
        }
    }

    public void setCompatElevation(float f2) {
        FloatingActionButtonImpl impl2 = getImpl();
        if (impl2.elevation != f2) {
            impl2.elevation = f2;
            impl2.onElevationsChanged(f2, impl2.hoveredFocusedTranslationZ, impl2.pressedTranslationZ);
        }
    }

    public void setCompatElevationResource(int i) {
        setCompatElevation(getResources().getDimension(i));
    }

    public void setCompatHoveredFocusedTranslationZ(float f2) {
        FloatingActionButtonImpl impl2 = getImpl();
        if (impl2.hoveredFocusedTranslationZ != f2) {
            impl2.hoveredFocusedTranslationZ = f2;
            impl2.onElevationsChanged(impl2.elevation, f2, impl2.pressedTranslationZ);
        }
    }

    public void setCompatHoveredFocusedTranslationZResource(int i) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i));
    }

    public void setCompatPressedTranslationZ(float f2) {
        FloatingActionButtonImpl impl2 = getImpl();
        if (impl2.pressedTranslationZ != f2) {
            impl2.pressedTranslationZ = f2;
            impl2.onElevationsChanged(impl2.elevation, impl2.hoveredFocusedTranslationZ, f2);
        }
    }

    public void setCompatPressedTranslationZResource(int i) {
        setCompatPressedTranslationZ(getResources().getDimension(i));
    }

    public void setCustomSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        } else if (i != this.customSize) {
            this.customSize = i;
            requestLayout();
        }
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        getImpl().updateShapeElevation(f2);
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        if (z != getImpl().ensureMinTouchTargetSize) {
            getImpl().ensureMinTouchTargetSize = z;
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i) {
        this.expandableWidgetHelper.expandedComponentIdHint = i;
    }

    public void setHideMotionSpec(MotionSpec motionSpec) {
        getImpl().hideMotionSpec = motionSpec;
    }

    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(MotionSpec.createFromResource(getContext(), i));
    }

    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            FloatingActionButtonImpl impl2 = getImpl();
            impl2.setImageMatrixScale(impl2.imageMatrixScale);
            if (this.imageTint != null) {
                onApplySupportImageTint();
            }
        }
    }

    public void setImageResource(int i) {
        this.imageHelper.setImageResource(i);
        onApplySupportImageTint();
    }

    public void setRippleColor(int i) {
        setRippleColor(ColorStateList.valueOf(i));
    }

    public void setScaleX(float f2) {
        super.setScaleX(f2);
        getImpl().onScaleChanged();
    }

    public void setScaleY(float f2) {
        super.setScaleY(f2);
        getImpl().onScaleChanged();
    }

    public void setShadowPaddingEnabled(boolean z) {
        FloatingActionButtonImpl impl2 = getImpl();
        impl2.shadowPaddingEnabled = z;
        impl2.updatePadding();
    }

    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        getImpl().setShapeAppearance(shapeAppearanceModel);
    }

    public void setShowMotionSpec(MotionSpec motionSpec) {
        getImpl().showMotionSpec = motionSpec;
    }

    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(MotionSpec.createFromResource(getContext(), i));
    }

    public void setSize(int i) {
        this.customSize = 0;
        if (i != this.size) {
            this.size = i;
            requestLayout();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.imageTint != colorStateList) {
            this.imageTint = colorStateList;
            onApplySupportImageTint();
        }
    }

    public void setSupportImageTintMode(Mode mode) {
        if (this.imageMode != mode) {
            this.imageMode = mode;
            onApplySupportImageTint();
        }
    }

    public void setTranslationX(float f2) {
        super.setTranslationX(f2);
        getImpl().onTranslationChanged();
    }

    public void setTranslationY(float f2) {
        super.setTranslationY(f2);
        getImpl().onTranslationChanged();
    }

    public void setTranslationZ(float f2) {
        super.setTranslationZ(f2);
        getImpl().onTranslationChanged();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.compatPadding != z) {
            this.compatPadding = z;
            getImpl().onCompatShadowChanged();
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void show(final OnVisibilityChangedListener onVisibilityChangedListener, boolean z) {
        AnonymousClass1 r5;
        FloatingActionButtonImpl impl2 = getImpl();
        if (onVisibilityChangedListener == null) {
            r5 = null;
        } else {
            r5 = new InternalVisibilityChangedListener() {
            };
        }
        if (!impl2.isOrWillBeShown()) {
            Animator animator = impl2.currentAnimator;
            if (animator != null) {
                animator.cancel();
            }
            if (impl2.shouldAnimateVisibilityChange()) {
                if (impl2.view.getVisibility() != 0) {
                    impl2.view.setAlpha(0.0f);
                    impl2.view.setScaleY(0.0f);
                    impl2.view.setScaleX(0.0f);
                    impl2.setImageMatrixScale(0.0f);
                }
                MotionSpec motionSpec = impl2.showMotionSpec;
                if (motionSpec == null) {
                    if (impl2.defaultShowMotionSpec == null) {
                        impl2.defaultShowMotionSpec = MotionSpec.createFromResource(impl2.view.getContext(), R$animator.design_fab_show_motion_spec);
                    }
                    motionSpec = impl2.defaultShowMotionSpec;
                    b.checkNotNull(motionSpec);
                }
                AnimatorSet createAnimator = impl2.createAnimator(motionSpec, 1.0f, 1.0f, 1.0f);
                createAnimator.addListener(new AnimatorListenerAdapter(z, r5) {
                    public final /* synthetic */ boolean val$fromUser;
                    public final /* synthetic */ InternalVisibilityChangedListener val$listener;

                    {
                        this.val$fromUser = r2;
                        this.val$listener = r3;
                    }

                    public void onAnimationEnd(Animator animator) {
                        FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                        floatingActionButtonImpl.animState = 0;
                        floatingActionButtonImpl.currentAnimator = null;
                        InternalVisibilityChangedListener internalVisibilityChangedListener = this.val$listener;
                        if (internalVisibilityChangedListener != null) {
                            com.google.android.material.floatingactionbutton.FloatingActionButton.AnonymousClass1 r2 = (com.google.android.material.floatingactionbutton.FloatingActionButton.AnonymousClass1) internalVisibilityChangedListener;
                            onVisibilityChangedListener.onShown(FloatingActionButton.this);
                        }
                    }

                    public void onAnimationStart(Animator animator) {
                        FloatingActionButtonImpl.this.view.internalSetVisibility(0, this.val$fromUser);
                        FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                        floatingActionButtonImpl.animState = 2;
                        floatingActionButtonImpl.currentAnimator = animator;
                    }
                });
                ArrayList<AnimatorListener> arrayList = impl2.showListeners;
                if (arrayList != null) {
                    Iterator<AnimatorListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        createAnimator.addListener(it.next());
                    }
                }
                createAnimator.start();
                return;
            }
            impl2.view.internalSetVisibility(0, z);
            impl2.view.setAlpha(1.0f);
            impl2.view.setScaleY(1.0f);
            impl2.view.setScaleX(1.0f);
            impl2.setImageMatrixScale(1.0f);
            if (r5 != null) {
                onVisibilityChangedListener.onShown(FloatingActionButton.this);
            }
        }
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        this.shadowPadding = new Rect();
        this.touchArea = new Rect();
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R$styleable.FloatingActionButton, i, DEF_STYLE_RES, new int[0]);
        this.backgroundTint = ImageOriginUtils.getColorStateList(context2, obtainStyledAttributes, R$styleable.FloatingActionButton_backgroundTint);
        this.backgroundTintMode = ImageOriginUtils.parseTintMode(obtainStyledAttributes.getInt(R$styleable.FloatingActionButton_backgroundTintMode, -1), null);
        this.rippleColor = ImageOriginUtils.getColorStateList(context2, obtainStyledAttributes, R$styleable.FloatingActionButton_rippleColor);
        this.size = obtainStyledAttributes.getInt(R$styleable.FloatingActionButton_fabSize, -1);
        this.customSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FloatingActionButton_fabCustomSize, 0);
        this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FloatingActionButton_borderWidth, 0);
        float dimension = obtainStyledAttributes.getDimension(R$styleable.FloatingActionButton_elevation, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(R$styleable.FloatingActionButton_hoveredFocusedTranslationZ, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(R$styleable.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.compatPadding = obtainStyledAttributes.getBoolean(R$styleable.FloatingActionButton_useCompatPadding, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.mtrl_fab_min_touch_target);
        this.maxImageSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FloatingActionButton_maxImageSize, 0);
        MotionSpec createFromAttribute = MotionSpec.createFromAttribute(context2, obtainStyledAttributes, R$styleable.FloatingActionButton_showMotionSpec);
        MotionSpec createFromAttribute2 = MotionSpec.createFromAttribute(context2, obtainStyledAttributes, R$styleable.FloatingActionButton_hideMotionSpec);
        ShapeAppearanceModel build = ShapeAppearanceModel.builder(context2, attributeSet, i, DEF_STYLE_RES, ShapeAppearanceModel.PILL).build();
        boolean z = obtainStyledAttributes.getBoolean(R$styleable.FloatingActionButton_ensureMinTouchTargetSize, false);
        setEnabled(obtainStyledAttributes.getBoolean(R$styleable.FloatingActionButton_android_enabled, true));
        obtainStyledAttributes.recycle();
        AppCompatImageHelper appCompatImageHelper = new AppCompatImageHelper(this);
        this.imageHelper = appCompatImageHelper;
        appCompatImageHelper.loadFromAttributes(attributeSet, i);
        this.expandableWidgetHelper = new ExpandableWidgetHelper(this);
        getImpl().setShapeAppearance(build);
        getImpl().initializeBackgroundDrawable(this.backgroundTint, this.backgroundTintMode, this.rippleColor, this.borderWidth);
        getImpl().minTouchTargetSize = dimensionPixelSize;
        FloatingActionButtonImpl impl2 = getImpl();
        if (impl2.elevation != dimension) {
            impl2.elevation = dimension;
            impl2.onElevationsChanged(dimension, impl2.hoveredFocusedTranslationZ, impl2.pressedTranslationZ);
        }
        FloatingActionButtonImpl impl3 = getImpl();
        if (impl3.hoveredFocusedTranslationZ != dimension2) {
            impl3.hoveredFocusedTranslationZ = dimension2;
            impl3.onElevationsChanged(impl3.elevation, dimension2, impl3.pressedTranslationZ);
        }
        FloatingActionButtonImpl impl4 = getImpl();
        if (impl4.pressedTranslationZ != dimension3) {
            impl4.pressedTranslationZ = dimension3;
            impl4.onElevationsChanged(impl4.elevation, impl4.hoveredFocusedTranslationZ, dimension3);
        }
        FloatingActionButtonImpl impl5 = getImpl();
        int i2 = this.maxImageSize;
        if (impl5.maxImageSize != i2) {
            impl5.maxImageSize = i2;
            impl5.setImageMatrixScale(impl5.imageMatrixScale);
        }
        getImpl().showMotionSpec = createFromAttribute;
        getImpl().hideMotionSpec = createFromAttribute2;
        getImpl().ensureMinTouchTargetSize = z;
        setScaleType(ScaleType.MATRIX);
    }

    public final int getSizeDimension(int i) {
        int i2;
        int i3 = this.customSize;
        if (i3 != 0) {
            return i3;
        }
        Resources resources = getResources();
        if (i == -1) {
            if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
                i2 = getSizeDimension(1);
            } else {
                i2 = getSizeDimension(0);
            }
            return i2;
        } else if (i != 1) {
            return resources.getDimensionPixelSize(R$dimen.design_fab_size_normal);
        } else {
            return resources.getDimensionPixelSize(R$dimen.design_fab_size_mini);
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.rippleColor != colorStateList) {
            this.rippleColor = colorStateList;
            getImpl().setRippleColor(this.rippleColor);
        }
    }
}
