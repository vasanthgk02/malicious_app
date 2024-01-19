package com.google.android.material.floatingactionbutton;

import a.a.a.a.d.b;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.google.android.material.R$color;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.ArrayList;

public class FloatingActionButtonImplLollipop extends FloatingActionButtonImpl {

    public static class AlwaysStatefulMaterialShapeDrawable extends MaterialShapeDrawable {
        public AlwaysStatefulMaterialShapeDrawable(ShapeAppearanceModel shapeAppearanceModel) {
            super(shapeAppearanceModel);
        }

        public boolean isStateful() {
            return true;
        }
    }

    public FloatingActionButtonImplLollipop(FloatingActionButton floatingActionButton, ShadowViewDelegate shadowViewDelegate) {
        super(floatingActionButton, shadowViewDelegate);
    }

    public final Animator createElevationAnimator(float f2, float f3) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.view, "elevation", new float[]{f2}).setDuration(0)).with(ObjectAnimator.ofFloat(this.view, View.TRANSLATION_Z, new float[]{f3}).setDuration(100));
        animatorSet.setInterpolator(FloatingActionButtonImpl.ELEVATION_ANIM_INTERPOLATOR);
        return animatorSet;
    }

    public float getElevation() {
        return this.view.getElevation();
    }

    public void getPadding(Rect rect) {
        if (FloatingActionButton.this.compatPadding) {
            super.getPadding(rect);
        } else if (!shouldExpandBoundsForA11y()) {
            int sizeDimension = (this.minTouchTargetSize - this.view.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        } else {
            rect.set(0, 0, 0, 0);
        }
    }

    public void initializeBackgroundDrawable(ColorStateList colorStateList, Mode mode, ColorStateList colorStateList2, int i) {
        Drawable drawable;
        ShapeAppearanceModel shapeAppearanceModel = this.shapeAppearance;
        b.checkNotNull(shapeAppearanceModel);
        AlwaysStatefulMaterialShapeDrawable alwaysStatefulMaterialShapeDrawable = new AlwaysStatefulMaterialShapeDrawable(shapeAppearanceModel);
        this.shapeDrawable = alwaysStatefulMaterialShapeDrawable;
        alwaysStatefulMaterialShapeDrawable.setTintList(colorStateList);
        if (mode != null) {
            this.shapeDrawable.setTintMode(mode);
        }
        this.shapeDrawable.initializeElevationOverlay(this.view.getContext());
        if (i > 0) {
            Context context = this.view.getContext();
            ShapeAppearanceModel shapeAppearanceModel2 = this.shapeAppearance;
            b.checkNotNull(shapeAppearanceModel2);
            BorderDrawable borderDrawable = new BorderDrawable(shapeAppearanceModel2);
            int color = ContextCompat.getColor(context, R$color.design_fab_stroke_top_outer_color);
            int color2 = ContextCompat.getColor(context, R$color.design_fab_stroke_top_inner_color);
            int color3 = ContextCompat.getColor(context, R$color.design_fab_stroke_end_inner_color);
            int color4 = ContextCompat.getColor(context, R$color.design_fab_stroke_end_outer_color);
            borderDrawable.topOuterStrokeColor = color;
            borderDrawable.topInnerStrokeColor = color2;
            borderDrawable.bottomOuterStrokeColor = color3;
            borderDrawable.bottomInnerStrokeColor = color4;
            float f2 = (float) i;
            if (borderDrawable.borderWidth != f2) {
                borderDrawable.borderWidth = f2;
                borderDrawable.paint.setStrokeWidth(f2 * 1.3333f);
                borderDrawable.invalidateShader = true;
                borderDrawable.invalidateSelf();
            }
            borderDrawable.setBorderTint(colorStateList);
            this.borderDrawable = borderDrawable;
            BorderDrawable borderDrawable2 = this.borderDrawable;
            b.checkNotNull(borderDrawable2);
            MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
            b.checkNotNull(materialShapeDrawable);
            drawable = new LayerDrawable(new Drawable[]{borderDrawable2, materialShapeDrawable});
        } else {
            this.borderDrawable = null;
            drawable = this.shapeDrawable;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(colorStateList2), drawable, null);
        this.rippleDrawable = rippleDrawable;
        this.contentBackground = rippleDrawable;
    }

    public void jumpDrawableToCurrentState() {
    }

    public void onCompatShadowChanged() {
        updatePadding();
    }

    public void onDrawableStateChanged(int[] iArr) {
    }

    public void onElevationsChanged(float f2, float f3, float f4) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(FloatingActionButtonImpl.PRESSED_ENABLED_STATE_SET, createElevationAnimator(f2, f4));
        stateListAnimator.addState(FloatingActionButtonImpl.HOVERED_FOCUSED_ENABLED_STATE_SET, createElevationAnimator(f2, f3));
        stateListAnimator.addState(FloatingActionButtonImpl.FOCUSED_ENABLED_STATE_SET, createElevationAnimator(f2, f3));
        stateListAnimator.addState(FloatingActionButtonImpl.HOVERED_ENABLED_STATE_SET, createElevationAnimator(f2, f3));
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this.view, "elevation", new float[]{f2}).setDuration(0));
        if (VERSION.SDK_INT <= 24) {
            FloatingActionButton floatingActionButton = this.view;
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, View.TRANSLATION_Z, new float[]{floatingActionButton.getTranslationZ()}).setDuration(100));
        }
        arrayList.add(ObjectAnimator.ofFloat(this.view, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100));
        animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
        animatorSet.setInterpolator(FloatingActionButtonImpl.ELEVATION_ANIM_INTERPOLATOR);
        stateListAnimator.addState(FloatingActionButtonImpl.ENABLED_STATE_SET, animatorSet);
        stateListAnimator.addState(FloatingActionButtonImpl.EMPTY_STATE_SET, createElevationAnimator(0.0f, 0.0f));
        this.view.setStateListAnimator(stateListAnimator);
        if (shouldAddPadding()) {
            updatePadding();
        }
    }

    public boolean requirePreDrawListener() {
        return false;
    }

    public void setRippleColor(ColorStateList colorStateList) {
        Drawable drawable = this.rippleDrawable;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(RippleUtils.sanitizeRippleDrawableColor(colorStateList));
        } else if (drawable != null) {
            drawable.setTintList(RippleUtils.sanitizeRippleDrawableColor(colorStateList));
        }
    }

    public boolean shouldAddPadding() {
        return FloatingActionButton.this.compatPadding || !shouldExpandBoundsForA11y();
    }

    public void updateFromViewRotation() {
    }
}
