package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils$2;
import com.google.android.material.internal.ViewUtils$OnApplyWindowInsetsListener;
import com.google.android.material.internal.ViewUtils$RelativePadding;
import com.google.android.material.resources.TextAppearanceConfig;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel.Builder;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class BottomAppBar extends Toolbar implements AttachedBehavior {
    public static final int DEF_STYLE_RES = R$style.Widget_MaterialComponents_BottomAppBar;
    public int animatingModeChangeCounter;
    public Behavior behavior;
    public int bottomInset;
    public int fabAlignmentMode;
    public AnimatorListenerAdapter fabAnimationListener;
    public int fabAnimationMode;
    public boolean fabAttached;
    public final int fabOffsetEndMode;
    public TransformationCallback<FloatingActionButton> fabTransformationCallback;
    public boolean hideOnScroll;
    public int leftInset;
    public final MaterialShapeDrawable materialShapeDrawable;
    public boolean menuAnimatingWithFabAlignmentMode;
    public Animator menuAnimator;
    public Animator modeAnimator;
    public final boolean paddingBottomSystemWindowInsets;
    public final boolean paddingLeftSystemWindowInsets;
    public final boolean paddingRightSystemWindowInsets;
    public int pendingMenuResId;
    public int rightInset;

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        public final Rect fabContentRect = new Rect();
        public final OnLayoutChangeListener fabLayoutListener = new OnLayoutChangeListener() {
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.viewRef.get();
                if (bottomAppBar == null || !(view instanceof FloatingActionButton)) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                Rect rect = Behavior.this.fabContentRect;
                rect.set(0, 0, floatingActionButton.getMeasuredWidth(), floatingActionButton.getMeasuredHeight());
                floatingActionButton.offsetRectWithShadow(rect);
                int height = Behavior.this.fabContentRect.height();
                bottomAppBar.setFabDiameter(height);
                bottomAppBar.setFabCornerSize(floatingActionButton.getShapeAppearanceModel().topLeftCornerSize.getCornerSize(new RectF(Behavior.this.fabContentRect)));
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if (Behavior.this.originalBottomMargin == 0) {
                    layoutParams.bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R$dimen.mtrl_bottomappbar_fab_bottom_margin) - ((floatingActionButton.getMeasuredHeight() - height) / 2));
                    layoutParams.leftMargin = bottomAppBar.getLeftInset();
                    layoutParams.rightMargin = bottomAppBar.getRightInset();
                    if (ImageOriginUtils.isLayoutRtl(floatingActionButton)) {
                        layoutParams.leftMargin += bottomAppBar.fabOffsetEndMode;
                    } else {
                        layoutParams.rightMargin += bottomAppBar.fabOffsetEndMode;
                    }
                }
            }
        };
        public int originalBottomMargin;
        public WeakReference<BottomAppBar> viewRef;

        public Behavior() {
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            this.viewRef = new WeakReference<>(bottomAppBar);
            View access$3100 = bottomAppBar.findDependentView();
            if (access$3100 != null && !ViewCompat.isLaidOut(access$3100)) {
                LayoutParams layoutParams = (LayoutParams) access$3100.getLayoutParams();
                layoutParams.anchorGravity = 49;
                this.originalBottomMargin = layoutParams.bottomMargin;
                if (access$3100 instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) access$3100;
                    floatingActionButton.addOnLayoutChangeListener(this.fabLayoutListener);
                    floatingActionButton.addOnHideAnimationListener(bottomAppBar.fabAnimationListener);
                    floatingActionButton.addOnShowAnimationListener(new AnimatorListenerAdapter() {
                        public void onAnimationStart(Animator animator) {
                            BottomAppBar.this.fabAnimationListener.onAnimationStart(animator);
                            FloatingActionButton findDependentFab = BottomAppBar.this.findDependentFab();
                            if (findDependentFab != null) {
                                findDependentFab.setTranslationX(BottomAppBar.this.getFabTranslationX());
                            }
                        }
                    });
                    floatingActionButton.addTransformationCallback(bottomAppBar.fabTransformationCallback);
                }
                bottomAppBar.setCutoutState();
            }
            coordinatorLayout.onLayoutChild(bottomAppBar, i);
            this.height = bottomAppBar.getMeasuredHeight() + ((MarginLayoutParams) bottomAppBar.getLayoutParams()).bottomMargin;
            return false;
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
            if (((BottomAppBar) view).getHideOnScroll()) {
                if (i == 2) {
                    return true;
                }
            }
            return false;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
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
                return new SavedState(parcel, null);
            }
        };
        public int fabAlignmentMode;
        public boolean fabAttached;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.mSuperState, i);
            parcel.writeInt(this.fabAlignmentMode);
            parcel.writeInt(this.fabAttached ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.fabAlignmentMode = parcel.readInt();
            this.fabAttached = parcel.readInt() != 0;
        }
    }

    public BottomAppBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.bottomAppBarStyle);
    }

    public static void access$1600(BottomAppBar bottomAppBar) {
        bottomAppBar.animatingModeChangeCounter--;
    }

    private ActionMenuView getActionMenuView() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public int getBottomInset() {
        return this.bottomInset;
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().cradleVerticalOffset;
    }

    /* access modifiers changed from: private */
    public int getLeftInset() {
        return this.leftInset;
    }

    /* access modifiers changed from: private */
    public int getRightInset() {
        return this.rightInset;
    }

    /* access modifiers changed from: private */
    public BottomAppBarTopEdgeTreatment getTopEdgeTreatment() {
        return (BottomAppBarTopEdgeTreatment) this.materialShapeDrawable.drawableState.shapeAppearanceModel.topEdge;
    }

    public void createFabDefaultXAnimation(final int i) {
        FloatingActionButton findDependentFab = findDependentFab();
        if (findDependentFab != null && !findDependentFab.isOrWillBeHidden()) {
            this.animatingModeChangeCounter++;
            findDependentFab.hide(new OnVisibilityChangedListener() {
                public void onHidden(FloatingActionButton floatingActionButton) {
                    floatingActionButton.setTranslationX(BottomAppBar.this.getFabTranslationX(i));
                    floatingActionButton.show(new OnVisibilityChangedListener() {
                        public void onShown(FloatingActionButton floatingActionButton) {
                            BottomAppBar.access$1600(BottomAppBar.this);
                        }
                    }, true);
                }
            }, true);
        }
    }

    public final FloatingActionButton findDependentFab() {
        View findDependentView = findDependentView();
        if (findDependentView instanceof FloatingActionButton) {
            return (FloatingActionButton) findDependentView;
        }
        return null;
    }

    public final View findDependentView() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View next : ((CoordinatorLayout) getParent()).getDependents(this)) {
            if (!(next instanceof FloatingActionButton)) {
                if (next instanceof ExtendedFloatingActionButton) {
                }
            }
            return next;
        }
        return null;
    }

    public int getActionMenuViewTranslationX(ActionMenuView actionMenuView, int i, boolean z) {
        if (i != 1 || !z) {
            return 0;
        }
        boolean isLayoutRtl = ImageOriginUtils.isLayoutRtl(this);
        int measuredWidth = isLayoutRtl ? getMeasuredWidth() : 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).gravity & 8388615) == 8388611) {
                if (isLayoutRtl) {
                    measuredWidth = Math.min(measuredWidth, childAt.getLeft());
                } else {
                    measuredWidth = Math.max(measuredWidth, childAt.getRight());
                }
            }
        }
        return measuredWidth - ((isLayoutRtl ? actionMenuView.getRight() : actionMenuView.getLeft()) + (isLayoutRtl ? this.rightInset : -this.leftInset));
    }

    public ColorStateList getBackgroundTint() {
        return this.materialShapeDrawable.drawableState.tintList;
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().cradleVerticalOffset;
    }

    public int getFabAlignmentMode() {
        return this.fabAlignmentMode;
    }

    public int getFabAnimationMode() {
        return this.fabAnimationMode;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().fabMargin;
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().roundedCornerRadius;
    }

    public final float getFabTranslationX(int i) {
        boolean isLayoutRtl = ImageOriginUtils.isLayoutRtl(this);
        int i2 = 1;
        if (i != 1) {
            return 0.0f;
        }
        int measuredWidth = (getMeasuredWidth() / 2) - (this.fabOffsetEndMode + (isLayoutRtl ? this.leftInset : this.rightInset));
        if (isLayoutRtl) {
            i2 = -1;
        }
        return (float) (measuredWidth * i2);
    }

    public boolean getHideOnScroll() {
        return this.hideOnScroll;
    }

    public final boolean isFabVisibleOrWillBeShown() {
        FloatingActionButton findDependentFab = findDependentFab();
        return findDependentFab != null && findDependentFab.isOrWillBeShown();
    }

    public final void maybeAnimateMenuView(final int i, final boolean z) {
        if (!ViewCompat.isLaidOut(this)) {
            this.menuAnimatingWithFabAlignmentMode = false;
            int i2 = this.pendingMenuResId;
            if (i2 != 0) {
                this.pendingMenuResId = 0;
                getMenu().clear();
                inflateMenu(i2);
            }
            return;
        }
        Animator animator = this.menuAnimator;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (!isFabVisibleOrWillBeShown()) {
            i = 0;
            z = false;
        }
        final ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", new float[]{1.0f});
            if (Math.abs(actionMenuView.getTranslationX() - ((float) getActionMenuViewTranslationX(actionMenuView, i, z))) > 1.0f) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", new float[]{0.0f});
                ofFloat2.addListener(new AnimatorListenerAdapter() {
                    public boolean cancelled;

                    public void onAnimationCancel(Animator animator) {
                        this.cancelled = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        if (!this.cancelled) {
                            boolean z = BottomAppBar.this.pendingMenuResId != 0;
                            BottomAppBar bottomAppBar = BottomAppBar.this;
                            int i = bottomAppBar.pendingMenuResId;
                            if (i != 0) {
                                bottomAppBar.pendingMenuResId = 0;
                                bottomAppBar.getMenu().clear();
                                bottomAppBar.inflateMenu(i);
                            }
                            BottomAppBar bottomAppBar2 = BottomAppBar.this;
                            ActionMenuView actionMenuView = actionMenuView;
                            int i2 = i;
                            boolean z2 = z;
                            if (bottomAppBar2 != null) {
                                AnonymousClass8 r3 = new Runnable(actionMenuView, i2, z2) {
                                    public final /* synthetic */ ActionMenuView val$actionMenuView;
                                    public final /* synthetic */ int val$fabAlignmentMode;
                                    public final /* synthetic */ boolean val$fabAttached;

                                    {
                                        this.val$actionMenuView = r2;
                                        this.val$fabAlignmentMode = r3;
                                        this.val$fabAttached = r4;
                                    }

                                    public void run() {
                                        ActionMenuView actionMenuView = this.val$actionMenuView;
                                        actionMenuView.setTranslationX((float) BottomAppBar.this.getActionMenuViewTranslationX(actionMenuView, this.val$fabAlignmentMode, this.val$fabAttached));
                                    }
                                };
                                if (z) {
                                    actionMenuView.post(r3);
                                } else {
                                    r3.run();
                                }
                            } else {
                                throw null;
                            }
                        }
                    }
                });
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(150);
                animatorSet.playSequentially(new Animator[]{ofFloat2, ofFloat});
                arrayList.add(animatorSet);
            } else if (actionMenuView.getAlpha() < 1.0f) {
                arrayList.add(ofFloat);
            }
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(arrayList);
        this.menuAnimator = animatorSet2;
        animatorSet2.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                BottomAppBar.access$1600(BottomAppBar.this);
                BottomAppBar bottomAppBar = BottomAppBar.this;
                bottomAppBar.menuAnimatingWithFabAlignmentMode = false;
                bottomAppBar.menuAnimator = null;
            }

            public void onAnimationStart(Animator animator) {
                BottomAppBar.this.animatingModeChangeCounter++;
            }
        });
        this.menuAnimator.start();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextAppearanceConfig.setParentAbsoluteElevation(this, this.materialShapeDrawable);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            Animator animator = this.menuAnimator;
            if (animator != null) {
                animator.cancel();
            }
            Animator animator2 = this.modeAnimator;
            if (animator2 != null) {
                animator2.cancel();
            }
            setCutoutState();
        }
        setActionMenuViewPosition();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.mSuperState);
        this.fabAlignmentMode = savedState.fabAlignmentMode;
        this.fabAttached = savedState.fabAttached;
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.fabAlignmentMode = this.fabAlignmentMode;
        savedState.fabAttached = this.fabAttached;
        return savedState;
    }

    public final void setActionMenuViewPosition() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null && this.menuAnimator == null) {
            actionMenuView.setAlpha(1.0f);
            if (!isFabVisibleOrWillBeShown()) {
                actionMenuView.setTranslationX((float) getActionMenuViewTranslationX(actionMenuView, 0, false));
            } else {
                actionMenuView.setTranslationX((float) getActionMenuViewTranslationX(actionMenuView, this.fabAlignmentMode, this.fabAttached));
            }
        }
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        this.materialShapeDrawable.setTintList(colorStateList);
    }

    public void setCradleVerticalOffset(float f2) {
        if (f2 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().setCradleVerticalOffset(f2);
            this.materialShapeDrawable.invalidateSelf();
            setCutoutState();
        }
    }

    public final void setCutoutState() {
        getTopEdgeTreatment().horizontalOffset = getFabTranslationX();
        View findDependentView = findDependentView();
        this.materialShapeDrawable.setInterpolation((!this.fabAttached || !isFabVisibleOrWillBeShown()) ? 0.0f : 1.0f);
        if (findDependentView != null) {
            findDependentView.setTranslationY(getFabTranslationY());
            findDependentView.setTranslationX(getFabTranslationX());
        }
    }

    public void setElevation(float f2) {
        MaterialShapeDrawable materialShapeDrawable2 = this.materialShapeDrawable;
        MaterialShapeDrawableState materialShapeDrawableState = materialShapeDrawable2.drawableState;
        if (materialShapeDrawableState.elevation != f2) {
            materialShapeDrawableState.elevation = f2;
            materialShapeDrawable2.updateZ();
        }
        MaterialShapeDrawable materialShapeDrawable3 = this.materialShapeDrawable;
        int shadowOffsetY = materialShapeDrawable3.drawableState.shadowCompatRadius - materialShapeDrawable3.getShadowOffsetY();
        Behavior behavior2 = getBehavior();
        behavior2.additionalHiddenOffsetY = shadowOffsetY;
        if (behavior2.currentState == 1) {
            setTranslationY((float) (behavior2.height + shadowOffsetY));
        }
    }

    public void setFabAlignmentMode(int i) {
        this.pendingMenuResId = 0;
        this.menuAnimatingWithFabAlignmentMode = true;
        maybeAnimateMenuView(i, this.fabAttached);
        if (this.fabAlignmentMode != i && ViewCompat.isLaidOut(this)) {
            Animator animator = this.modeAnimator;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (this.fabAnimationMode == 1) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(findDependentFab(), "translationX", new float[]{getFabTranslationX(i)});
                ofFloat.setDuration(300);
                arrayList.add(ofFloat);
            } else {
                createFabDefaultXAnimation(i);
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.modeAnimator = animatorSet;
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    BottomAppBar.access$1600(BottomAppBar.this);
                    BottomAppBar.this.modeAnimator = null;
                }

                public void onAnimationStart(Animator animator) {
                    BottomAppBar.this.animatingModeChangeCounter++;
                }
            });
            this.modeAnimator.start();
        }
        this.fabAlignmentMode = i;
    }

    public void setFabAnimationMode(int i) {
        this.fabAnimationMode = i;
    }

    public void setFabCornerSize(float f2) {
        if (f2 != getTopEdgeTreatment().fabCornerSize) {
            getTopEdgeTreatment().fabCornerSize = f2;
            this.materialShapeDrawable.invalidateSelf();
        }
    }

    public void setFabCradleMargin(float f2) {
        if (f2 != getFabCradleMargin()) {
            getTopEdgeTreatment().fabMargin = f2;
            this.materialShapeDrawable.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(float f2) {
        if (f2 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().roundedCornerRadius = f2;
            this.materialShapeDrawable.invalidateSelf();
        }
    }

    public boolean setFabDiameter(int i) {
        float f2 = (float) i;
        if (f2 == getTopEdgeTreatment().fabDiameter) {
            return false;
        }
        getTopEdgeTreatment().fabDiameter = f2;
        this.materialShapeDrawable.invalidateSelf();
        return true;
    }

    public void setHideOnScroll(boolean z) {
        this.hideOnScroll = z;
    }

    public void setSubtitle(CharSequence charSequence) {
    }

    public void setTitle(CharSequence charSequence) {
    }

    public BottomAppBar(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        this.materialShapeDrawable = new MaterialShapeDrawable();
        this.animatingModeChangeCounter = 0;
        this.pendingMenuResId = 0;
        this.menuAnimatingWithFabAlignmentMode = false;
        this.fabAttached = true;
        this.fabAnimationListener = new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                BottomAppBar bottomAppBar = BottomAppBar.this;
                if (!bottomAppBar.menuAnimatingWithFabAlignmentMode) {
                    bottomAppBar.maybeAnimateMenuView(bottomAppBar.fabAlignmentMode, bottomAppBar.fabAttached);
                }
            }
        };
        this.fabTransformationCallback = new TransformationCallback<FloatingActionButton>() {
        };
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R$styleable.BottomAppBar, i, DEF_STYLE_RES, new int[0]);
        ColorStateList colorStateList = ImageOriginUtils.getColorStateList(context2, obtainStyledAttributes, R$styleable.BottomAppBar_backgroundTint);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.BottomAppBar_elevation, 0);
        this.fabAlignmentMode = obtainStyledAttributes.getInt(R$styleable.BottomAppBar_fabAlignmentMode, 0);
        this.fabAnimationMode = obtainStyledAttributes.getInt(R$styleable.BottomAppBar_fabAnimationMode, 0);
        this.hideOnScroll = obtainStyledAttributes.getBoolean(R$styleable.BottomAppBar_hideOnScroll, false);
        this.paddingBottomSystemWindowInsets = obtainStyledAttributes.getBoolean(R$styleable.BottomAppBar_paddingBottomSystemWindowInsets, false);
        this.paddingLeftSystemWindowInsets = obtainStyledAttributes.getBoolean(R$styleable.BottomAppBar_paddingLeftSystemWindowInsets, false);
        this.paddingRightSystemWindowInsets = obtainStyledAttributes.getBoolean(R$styleable.BottomAppBar_paddingRightSystemWindowInsets, false);
        obtainStyledAttributes.recycle();
        this.fabOffsetEndMode = getResources().getDimensionPixelOffset(R$dimen.mtrl_bottomappbar_fabOffsetEndMode);
        BottomAppBarTopEdgeTreatment bottomAppBarTopEdgeTreatment = new BottomAppBarTopEdgeTreatment((float) obtainStyledAttributes.getDimensionPixelOffset(R$styleable.BottomAppBar_fabCradleMargin, 0), (float) obtainStyledAttributes.getDimensionPixelOffset(R$styleable.BottomAppBar_fabCradleRoundedCornerRadius, 0), (float) obtainStyledAttributes.getDimensionPixelOffset(R$styleable.BottomAppBar_fabCradleVerticalOffset, 0));
        Builder builder = new Builder();
        builder.topEdge = bottomAppBarTopEdgeTreatment;
        ShapeAppearanceModel build = builder.build();
        MaterialShapeDrawable materialShapeDrawable2 = this.materialShapeDrawable;
        materialShapeDrawable2.drawableState.shapeAppearanceModel = build;
        materialShapeDrawable2.invalidateSelf();
        this.materialShapeDrawable.setShadowCompatibilityMode(2);
        this.materialShapeDrawable.setPaintStyle(Style.FILL);
        MaterialShapeDrawable materialShapeDrawable3 = this.materialShapeDrawable;
        materialShapeDrawable3.drawableState.elevationOverlayProvider = new ElevationOverlayProvider(context2);
        materialShapeDrawable3.updateZ();
        setElevation((float) dimensionPixelSize);
        this.materialShapeDrawable.setTintList(colorStateList);
        ViewCompat.setBackground(this, this.materialShapeDrawable);
        int i2 = DEF_STYLE_RES;
        AnonymousClass3 r1 = new ViewUtils$OnApplyWindowInsetsListener() {
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, ViewUtils$RelativePadding viewUtils$RelativePadding) {
                boolean z;
                BottomAppBar bottomAppBar = BottomAppBar.this;
                if (bottomAppBar.paddingBottomSystemWindowInsets) {
                    bottomAppBar.bottomInset = windowInsetsCompat.getSystemWindowInsetBottom();
                }
                BottomAppBar bottomAppBar2 = BottomAppBar.this;
                boolean z2 = true;
                boolean z3 = false;
                if (bottomAppBar2.paddingLeftSystemWindowInsets) {
                    z = bottomAppBar2.leftInset != windowInsetsCompat.getSystemWindowInsetLeft();
                    BottomAppBar.this.leftInset = windowInsetsCompat.getSystemWindowInsetLeft();
                } else {
                    z = false;
                }
                BottomAppBar bottomAppBar3 = BottomAppBar.this;
                if (bottomAppBar3.paddingRightSystemWindowInsets) {
                    if (bottomAppBar3.rightInset == windowInsetsCompat.getSystemWindowInsetRight()) {
                        z2 = false;
                    }
                    BottomAppBar.this.rightInset = windowInsetsCompat.getSystemWindowInsetRight();
                    z3 = z2;
                }
                if (z || z3) {
                    BottomAppBar bottomAppBar4 = BottomAppBar.this;
                    Animator animator = bottomAppBar4.menuAnimator;
                    if (animator != null) {
                        animator.cancel();
                    }
                    Animator animator2 = bottomAppBar4.modeAnimator;
                    if (animator2 != null) {
                        animator2.cancel();
                    }
                    BottomAppBar.this.setCutoutState();
                    BottomAppBar.this.setActionMenuViewPosition();
                }
                return windowInsetsCompat;
            }
        };
        TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(attributeSet, R$styleable.Insets, i, i2);
        boolean z = obtainStyledAttributes2.getBoolean(R$styleable.Insets_paddingBottomSystemWindowInsets, false);
        boolean z2 = obtainStyledAttributes2.getBoolean(R$styleable.Insets_paddingLeftSystemWindowInsets, false);
        boolean z3 = obtainStyledAttributes2.getBoolean(R$styleable.Insets_paddingRightSystemWindowInsets, false);
        obtainStyledAttributes2.recycle();
        ImageOriginUtils.doOnApplyWindowInsets(this, new ViewUtils$2(z, z2, z3, r1));
    }

    public Behavior getBehavior() {
        if (this.behavior == null) {
            this.behavior = new Behavior();
        }
        return this.behavior;
    }

    /* access modifiers changed from: private */
    public float getFabTranslationX() {
        return getFabTranslationX(this.fabAlignmentMode);
    }
}
