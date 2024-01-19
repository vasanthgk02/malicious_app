package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$animator;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.List;

public class ExtendedFloatingActionButton extends MaterialButton implements AttachedBehavior {
    public static final int DEF_STYLE_RES = R$style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
    public static final Property<View, Float> HEIGHT;
    public static final Property<View, Float> PADDING_END;
    public static final Property<View, Float> PADDING_START;
    public static final Property<View, Float> WIDTH;
    public int animState;
    public boolean animateShowBeforeLayout;
    public final Behavior<ExtendedFloatingActionButton> behavior;
    public final AnimatorTracker changeVisibilityTracker;
    public final int collapsedSize;
    public final MotionStrategy extendStrategy;
    public int extendedPaddingEnd;
    public int extendedPaddingStart;
    public final MotionStrategy hideStrategy;
    public boolean isExtended;
    public boolean isTransforming;
    public ColorStateList originalTextCsl;
    public final MotionStrategy showStrategy;
    public final MotionStrategy shrinkStrategy;

    public class ChangeSizeStrategy extends BaseMotionStrategy {
        public final boolean extending;
        public final Size size;

        public ChangeSizeStrategy(AnimatorTracker animatorTracker, Size size2, boolean z) {
            super(ExtendedFloatingActionButton.this, animatorTracker);
            this.size = size2;
            this.extending = z;
        }

        public AnimatorSet createAnimator() {
            MotionSpec currentMotionSpec = getCurrentMotionSpec();
            if (currentMotionSpec.hasPropertyValues("width")) {
                PropertyValuesHolder[] propertyValues = currentMotionSpec.getPropertyValues("width");
                propertyValues[0].setFloatValues(new float[]{(float) ExtendedFloatingActionButton.this.getWidth(), (float) this.size.getWidth()});
                currentMotionSpec.propertyValues.put("width", propertyValues);
            }
            if (currentMotionSpec.hasPropertyValues("height")) {
                PropertyValuesHolder[] propertyValues2 = currentMotionSpec.getPropertyValues("height");
                propertyValues2[0].setFloatValues(new float[]{(float) ExtendedFloatingActionButton.this.getHeight(), (float) this.size.getHeight()});
                currentMotionSpec.propertyValues.put("height", propertyValues2);
            }
            if (currentMotionSpec.hasPropertyValues("paddingStart")) {
                PropertyValuesHolder[] propertyValues3 = currentMotionSpec.getPropertyValues("paddingStart");
                propertyValues3[0].setFloatValues(new float[]{(float) ViewCompat.getPaddingStart(ExtendedFloatingActionButton.this), (float) this.size.getPaddingStart()});
                currentMotionSpec.propertyValues.put("paddingStart", propertyValues3);
            }
            if (currentMotionSpec.hasPropertyValues("paddingEnd")) {
                PropertyValuesHolder[] propertyValues4 = currentMotionSpec.getPropertyValues("paddingEnd");
                propertyValues4[0].setFloatValues(new float[]{(float) ViewCompat.getPaddingEnd(ExtendedFloatingActionButton.this), (float) this.size.getPaddingEnd()});
                currentMotionSpec.propertyValues.put("paddingEnd", propertyValues4);
            }
            if (currentMotionSpec.hasPropertyValues("labelOpacity")) {
                PropertyValuesHolder[] propertyValues5 = currentMotionSpec.getPropertyValues("labelOpacity");
                float f2 = 0.0f;
                float f3 = this.extending ? 0.0f : 1.0f;
                if (this.extending) {
                    f2 = 1.0f;
                }
                propertyValues5[0].setFloatValues(new float[]{f3, f2});
                currentMotionSpec.propertyValues.put("labelOpacity", propertyValues5);
            }
            return super.createAnimator(currentMotionSpec);
        }

        public int getDefaultMotionSpecResource() {
            return this.extending ? R$animator.mtrl_extended_fab_change_size_expand_motion_spec : R$animator.mtrl_extended_fab_change_size_collapse_motion_spec;
        }

        public void onAnimationEnd() {
            super.onAnimationEnd();
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            extendedFloatingActionButton.isTransforming = false;
            extendedFloatingActionButton.setHorizontallyScrolling(false);
            LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = this.size.getLayoutParams().width;
                layoutParams.height = this.size.getLayoutParams().height;
            }
        }

        public void onAnimationStart(Animator animator) {
            AnimatorTracker animatorTracker = this.tracker;
            Animator animator2 = animatorTracker.currentAnimator;
            if (animator2 != null) {
                animator2.cancel();
            }
            animatorTracker.currentAnimator = animator;
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            extendedFloatingActionButton.isExtended = this.extending;
            extendedFloatingActionButton.isTransforming = true;
            extendedFloatingActionButton.setHorizontallyScrolling(true);
        }

        public void onChange(OnChangedCallback onChangedCallback) {
            if (onChangedCallback != null) {
                if (this.extending) {
                    throw null;
                }
                throw null;
            }
        }

        public void performNow() {
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            extendedFloatingActionButton.isExtended = this.extending;
            LayoutParams layoutParams = extendedFloatingActionButton.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = this.size.getLayoutParams().width;
                layoutParams.height = this.size.getLayoutParams().height;
                ViewCompat.setPaddingRelative(ExtendedFloatingActionButton.this, this.size.getPaddingStart(), ExtendedFloatingActionButton.this.getPaddingTop(), this.size.getPaddingEnd(), ExtendedFloatingActionButton.this.getPaddingBottom());
                ExtendedFloatingActionButton.this.requestLayout();
            }
        }

        public boolean shouldCancel() {
            boolean z = this.extending;
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            return z == extendedFloatingActionButton.isExtended || extendedFloatingActionButton.getIcon() == null || TextUtils.isEmpty(ExtendedFloatingActionButton.this.getText());
        }
    }

    public static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends Behavior<T> {
        public boolean autoHideEnabled;
        public boolean autoShrinkEnabled;
        public Rect tmpRect;

        public ExtendedFloatingActionButtonBehavior() {
            this.autoHideEnabled = false;
            this.autoShrinkEnabled = true;
        }

        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            return false;
        }

        public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view2, extendedFloatingActionButton);
            } else {
                LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof CoordinatorLayout.LayoutParams ? ((CoordinatorLayout.LayoutParams) layoutParams).mBehavior instanceof BottomSheetBehavior : false) {
                    updateFabVisibilityForBottomSheet(view2, extendedFloatingActionButton);
                }
            }
            return false;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            List<View> dependencies = coordinatorLayout.getDependencies(extendedFloatingActionButton);
            int size = dependencies.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view2 = dependencies.get(i2);
                if (!(view2 instanceof AppBarLayout)) {
                    LayoutParams layoutParams = view2.getLayoutParams();
                    if ((layoutParams instanceof CoordinatorLayout.LayoutParams ? ((CoordinatorLayout.LayoutParams) layoutParams).mBehavior instanceof BottomSheetBehavior : false) && updateFabVisibilityForBottomSheet(view2, extendedFloatingActionButton)) {
                        break;
                    }
                } else if (updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view2, extendedFloatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.onLayoutChild(extendedFloatingActionButton, i);
            return true;
        }

        public final boolean shouldUpdateVisibility(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams();
            if ((this.autoHideEnabled || this.autoShrinkEnabled) && layoutParams.mAnchorId == view.getId()) {
                return true;
            }
            return false;
        }

        public final boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            MotionStrategy motionStrategy;
            MotionStrategy motionStrategy2;
            if (!shouldUpdateVisibility(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.tmpRect == null) {
                this.tmpRect = new Rect();
            }
            Rect rect = this.tmpRect;
            DescendantOffsetUtils.getDescendantRect(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                if (this.autoShrinkEnabled) {
                    motionStrategy2 = extendedFloatingActionButton.shrinkStrategy;
                } else {
                    motionStrategy2 = extendedFloatingActionButton.hideStrategy;
                }
                ExtendedFloatingActionButton.access$400(extendedFloatingActionButton, motionStrategy2);
            } else {
                if (this.autoShrinkEnabled) {
                    motionStrategy = extendedFloatingActionButton.extendStrategy;
                } else {
                    motionStrategy = extendedFloatingActionButton.showStrategy;
                }
                ExtendedFloatingActionButton.access$400(extendedFloatingActionButton, motionStrategy);
            }
            return true;
        }

        public final boolean updateFabVisibilityForBottomSheet(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            MotionStrategy motionStrategy;
            MotionStrategy motionStrategy2;
            if (!shouldUpdateVisibility(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams()).topMargin) {
                if (this.autoShrinkEnabled) {
                    motionStrategy2 = extendedFloatingActionButton.shrinkStrategy;
                } else {
                    motionStrategy2 = extendedFloatingActionButton.hideStrategy;
                }
                ExtendedFloatingActionButton.access$400(extendedFloatingActionButton, motionStrategy2);
            } else {
                if (this.autoShrinkEnabled) {
                    motionStrategy = extendedFloatingActionButton.extendStrategy;
                } else {
                    motionStrategy = extendedFloatingActionButton.showStrategy;
                }
                ExtendedFloatingActionButton.access$400(extendedFloatingActionButton, motionStrategy);
            }
            return true;
        }

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.autoHideEnabled = obtainStyledAttributes.getBoolean(R$styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.autoShrinkEnabled = obtainStyledAttributes.getBoolean(R$styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            obtainStyledAttributes.recycle();
        }
    }

    public class HideStrategy extends BaseMotionStrategy {
        public boolean isCancelled;

        public HideStrategy(AnimatorTracker animatorTracker) {
            super(ExtendedFloatingActionButton.this, animatorTracker);
        }

        public int getDefaultMotionSpecResource() {
            return R$animator.mtrl_extended_fab_hide_motion_spec;
        }

        public void onAnimationCancel() {
            this.tracker.currentAnimator = null;
            this.isCancelled = true;
        }

        public void onAnimationEnd() {
            super.onAnimationEnd();
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            extendedFloatingActionButton.animState = 0;
            if (!this.isCancelled) {
                extendedFloatingActionButton.setVisibility(8);
            }
        }

        public void onAnimationStart(Animator animator) {
            AnimatorTracker animatorTracker = this.tracker;
            Animator animator2 = animatorTracker.currentAnimator;
            if (animator2 != null) {
                animator2.cancel();
            }
            animatorTracker.currentAnimator = animator;
            this.isCancelled = false;
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.animState = 1;
        }

        public void onChange(OnChangedCallback onChangedCallback) {
            if (onChangedCallback != null) {
                throw null;
            }
        }

        public void performNow() {
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        public boolean shouldCancel() {
            return ExtendedFloatingActionButton.access$1100(ExtendedFloatingActionButton.this);
        }
    }

    public static abstract class OnChangedCallback {
    }

    public class ShowStrategy extends BaseMotionStrategy {
        public ShowStrategy(AnimatorTracker animatorTracker) {
            super(ExtendedFloatingActionButton.this, animatorTracker);
        }

        public int getDefaultMotionSpecResource() {
            return R$animator.mtrl_extended_fab_show_motion_spec;
        }

        public void onAnimationEnd() {
            super.onAnimationEnd();
            ExtendedFloatingActionButton.this.animState = 0;
        }

        public void onAnimationStart(Animator animator) {
            AnimatorTracker animatorTracker = this.tracker;
            Animator animator2 = animatorTracker.currentAnimator;
            if (animator2 != null) {
                animator2.cancel();
            }
            animatorTracker.currentAnimator = animator;
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.animState = 2;
        }

        public void onChange(OnChangedCallback onChangedCallback) {
            if (onChangedCallback != null) {
                throw null;
            }
        }

        public void performNow() {
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.setAlpha(1.0f);
            ExtendedFloatingActionButton.this.setScaleY(1.0f);
            ExtendedFloatingActionButton.this.setScaleX(1.0f);
        }

        public boolean shouldCancel() {
            return ExtendedFloatingActionButton.this.isOrWillBeShown();
        }
    }

    public interface Size {
        int getHeight();

        LayoutParams getLayoutParams();

        int getPaddingEnd();

        int getPaddingStart();

        int getWidth();
    }

    static {
        Class<Float> cls = Float.class;
        WIDTH = new Property<View, Float>(cls, "width") {
            public Object get(Object obj) {
                return Float.valueOf((float) ((View) obj).getLayoutParams().width);
            }

            public void set(Object obj, Object obj2) {
                View view = (View) obj;
                view.getLayoutParams().width = ((Float) obj2).intValue();
                view.requestLayout();
            }
        };
        HEIGHT = new Property<View, Float>(cls, "height") {
            public Object get(Object obj) {
                return Float.valueOf((float) ((View) obj).getLayoutParams().height);
            }

            public void set(Object obj, Object obj2) {
                View view = (View) obj;
                view.getLayoutParams().height = ((Float) obj2).intValue();
                view.requestLayout();
            }
        };
        PADDING_START = new Property<View, Float>(cls, "paddingStart") {
            public Object get(Object obj) {
                return Float.valueOf((float) ViewCompat.getPaddingStart((View) obj));
            }

            public void set(Object obj, Object obj2) {
                View view = (View) obj;
                view.setPaddingRelative(((Float) obj2).intValue(), view.getPaddingTop(), ViewCompat.getPaddingEnd(view), view.getPaddingBottom());
            }
        };
        PADDING_END = new Property<View, Float>(cls, "paddingEnd") {
            public Object get(Object obj) {
                return Float.valueOf((float) ViewCompat.getPaddingEnd((View) obj));
            }

            public void set(Object obj, Object obj2) {
                View view = (View) obj;
                view.setPaddingRelative(ViewCompat.getPaddingStart(view), view.getPaddingTop(), ((Float) obj2).intValue(), view.getPaddingBottom());
            }
        };
    }

    public ExtendedFloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.extendedFloatingActionButtonStyle);
    }

    public static boolean access$1100(ExtendedFloatingActionButton extendedFloatingActionButton) {
        if (extendedFloatingActionButton.getVisibility() == 0) {
            if (extendedFloatingActionButton.animState != 1) {
                return false;
            }
        } else if (extendedFloatingActionButton.animState == 2) {
            return false;
        }
        return true;
    }

    public static void access$400(ExtendedFloatingActionButton extendedFloatingActionButton, final MotionStrategy motionStrategy) {
        if (extendedFloatingActionButton == null) {
            throw null;
        } else if (!motionStrategy.shouldCancel()) {
            if (!((ViewCompat.isLaidOut(extendedFloatingActionButton) || (!extendedFloatingActionButton.isOrWillBeShown() && extendedFloatingActionButton.animateShowBeforeLayout)) && !extendedFloatingActionButton.isInEditMode())) {
                motionStrategy.performNow();
                motionStrategy.onChange(null);
                return;
            }
            extendedFloatingActionButton.measure(0, 0);
            AnimatorSet createAnimator = motionStrategy.createAnimator();
            createAnimator.addListener(new AnimatorListenerAdapter() {
                public boolean cancelled;
                public final /* synthetic */ OnChangedCallback val$callback = null;

                public void onAnimationCancel(Animator animator) {
                    this.cancelled = true;
                    motionStrategy.onAnimationCancel();
                }

                public void onAnimationEnd(Animator animator) {
                    motionStrategy.onAnimationEnd();
                    if (!this.cancelled) {
                        motionStrategy.onChange(null);
                    }
                }

                public void onAnimationStart(Animator animator) {
                    motionStrategy.onAnimationStart(animator);
                    this.cancelled = false;
                }
            });
            for (AnimatorListener addListener : ((BaseMotionStrategy) motionStrategy).listeners) {
                createAnimator.addListener(addListener);
            }
            createAnimator.start();
        }
    }

    public Behavior<ExtendedFloatingActionButton> getBehavior() {
        return this.behavior;
    }

    public int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    public int getCollapsedSize() {
        int i = this.collapsedSize;
        return i < 0 ? (Math.min(ViewCompat.getPaddingStart(this), getPaddingEnd()) * 2) + getIconSize() : i;
    }

    public MotionSpec getExtendMotionSpec() {
        return ((BaseMotionStrategy) this.extendStrategy).motionSpec;
    }

    public MotionSpec getHideMotionSpec() {
        return ((BaseMotionStrategy) this.hideStrategy).motionSpec;
    }

    public MotionSpec getShowMotionSpec() {
        return ((BaseMotionStrategy) this.showStrategy).motionSpec;
    }

    public MotionSpec getShrinkMotionSpec() {
        return ((BaseMotionStrategy) this.shrinkStrategy).motionSpec;
    }

    public final boolean isOrWillBeShown() {
        boolean z = false;
        if (getVisibility() != 0) {
            if (this.animState == 2) {
                z = true;
            }
            return z;
        }
        if (this.animState != 1) {
            z = true;
        }
        return z;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.isExtended && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.isExtended = false;
            this.shrinkStrategy.performNow();
        }
    }

    public final void saveOriginalTextCsl() {
        this.originalTextCsl = getTextColors();
    }

    public void setAnimateShowBeforeLayout(boolean z) {
        this.animateShowBeforeLayout = z;
    }

    public void setExtendMotionSpec(MotionSpec motionSpec) {
        ((BaseMotionStrategy) this.extendStrategy).motionSpec = motionSpec;
    }

    public void setExtendMotionSpecResource(int i) {
        setExtendMotionSpec(MotionSpec.createFromResource(getContext(), i));
    }

    public void setExtended(boolean z) {
        if (this.isExtended != z) {
            MotionStrategy motionStrategy = z ? this.extendStrategy : this.shrinkStrategy;
            if (!motionStrategy.shouldCancel()) {
                motionStrategy.performNow();
            }
        }
    }

    public void setHideMotionSpec(MotionSpec motionSpec) {
        ((BaseMotionStrategy) this.hideStrategy).motionSpec = motionSpec;
    }

    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(MotionSpec.createFromResource(getContext(), i));
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        if (this.isExtended && !this.isTransforming) {
            this.extendedPaddingStart = ViewCompat.getPaddingStart(this);
            this.extendedPaddingEnd = getPaddingEnd();
        }
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
        if (this.isExtended && !this.isTransforming) {
            this.extendedPaddingStart = i;
            this.extendedPaddingEnd = i3;
        }
    }

    public void setShowMotionSpec(MotionSpec motionSpec) {
        ((BaseMotionStrategy) this.showStrategy).motionSpec = motionSpec;
    }

    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(MotionSpec.createFromResource(getContext(), i));
    }

    public void setShrinkMotionSpec(MotionSpec motionSpec) {
        ((BaseMotionStrategy) this.shrinkStrategy).motionSpec = motionSpec;
    }

    public void setShrinkMotionSpecResource(int i) {
        setShrinkMotionSpec(MotionSpec.createFromResource(getContext(), i));
    }

    public void setTextColor(int i) {
        super.setTextColor(i);
        saveOriginalTextCsl();
    }

    public void silentlyUpdateTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
    }

    public ExtendedFloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        this.animState = 0;
        AnimatorTracker animatorTracker = new AnimatorTracker();
        this.changeVisibilityTracker = animatorTracker;
        this.showStrategy = new ShowStrategy(animatorTracker);
        this.hideStrategy = new HideStrategy(this.changeVisibilityTracker);
        this.isExtended = true;
        this.isTransforming = false;
        this.animateShowBeforeLayout = false;
        Context context2 = getContext();
        this.behavior = new ExtendedFloatingActionButtonBehavior(context2, attributeSet);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R$styleable.ExtendedFloatingActionButton, i, DEF_STYLE_RES, new int[0]);
        MotionSpec createFromAttribute = MotionSpec.createFromAttribute(context2, obtainStyledAttributes, R$styleable.ExtendedFloatingActionButton_showMotionSpec);
        MotionSpec createFromAttribute2 = MotionSpec.createFromAttribute(context2, obtainStyledAttributes, R$styleable.ExtendedFloatingActionButton_hideMotionSpec);
        MotionSpec createFromAttribute3 = MotionSpec.createFromAttribute(context2, obtainStyledAttributes, R$styleable.ExtendedFloatingActionButton_extendMotionSpec);
        MotionSpec createFromAttribute4 = MotionSpec.createFromAttribute(context2, obtainStyledAttributes, R$styleable.ExtendedFloatingActionButton_shrinkMotionSpec);
        this.collapsedSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ExtendedFloatingActionButton_collapsedSize, -1);
        this.extendedPaddingStart = ViewCompat.getPaddingStart(this);
        this.extendedPaddingEnd = getPaddingEnd();
        AnimatorTracker animatorTracker2 = new AnimatorTracker();
        this.extendStrategy = new ChangeSizeStrategy(animatorTracker2, new Size() {
            public int getHeight() {
                return ExtendedFloatingActionButton.this.getMeasuredHeight();
            }

            public LayoutParams getLayoutParams() {
                return new LayoutParams(-2, -2);
            }

            public int getPaddingEnd() {
                return ExtendedFloatingActionButton.this.extendedPaddingEnd;
            }

            public int getPaddingStart() {
                return ExtendedFloatingActionButton.this.extendedPaddingStart;
            }

            public int getWidth() {
                int measuredWidth = ExtendedFloatingActionButton.this.getMeasuredWidth() - (ExtendedFloatingActionButton.this.getCollapsedPadding() * 2);
                ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
                return measuredWidth + extendedFloatingActionButton.extendedPaddingStart + extendedFloatingActionButton.extendedPaddingEnd;
            }
        }, true);
        ChangeSizeStrategy changeSizeStrategy = new ChangeSizeStrategy(animatorTracker2, new Size() {
            public int getHeight() {
                return ExtendedFloatingActionButton.this.getCollapsedSize();
            }

            public LayoutParams getLayoutParams() {
                return new LayoutParams(ExtendedFloatingActionButton.this.getCollapsedSize(), ExtendedFloatingActionButton.this.getCollapsedSize());
            }

            public int getPaddingEnd() {
                return ExtendedFloatingActionButton.this.getCollapsedPadding();
            }

            public int getPaddingStart() {
                return ExtendedFloatingActionButton.this.getCollapsedPadding();
            }

            public int getWidth() {
                return ExtendedFloatingActionButton.this.getCollapsedSize();
            }
        }, false);
        this.shrinkStrategy = changeSizeStrategy;
        ((BaseMotionStrategy) this.showStrategy).motionSpec = createFromAttribute;
        ((BaseMotionStrategy) this.hideStrategy).motionSpec = createFromAttribute2;
        ((BaseMotionStrategy) this.extendStrategy).motionSpec = createFromAttribute3;
        changeSizeStrategy.motionSpec = createFromAttribute4;
        obtainStyledAttributes.recycle();
        setShapeAppearanceModel(ShapeAppearanceModel.builder(context2, attributeSet, i, DEF_STYLE_RES, ShapeAppearanceModel.PILL).build());
        saveOriginalTextCsl();
    }

    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        saveOriginalTextCsl();
    }
}
