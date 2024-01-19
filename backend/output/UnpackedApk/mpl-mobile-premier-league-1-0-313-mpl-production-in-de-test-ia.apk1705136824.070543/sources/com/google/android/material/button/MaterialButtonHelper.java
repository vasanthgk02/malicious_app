package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import androidx.core.view.ViewCompat;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.google.android.material.R$attr;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;

public class MaterialButtonHelper {
    public boolean backgroundOverwritten = false;
    public ColorStateList backgroundTint;
    public Mode backgroundTintMode;
    public boolean checkable;
    public int cornerRadius;
    public boolean cornerRadiusSet = false;
    public int elevation;
    public int insetBottom;
    public int insetLeft;
    public int insetRight;
    public int insetTop;
    public Drawable maskDrawable;
    public final MaterialButton materialButton;
    public ColorStateList rippleColor;
    public LayerDrawable rippleDrawable;
    public ShapeAppearanceModel shapeAppearanceModel;
    public boolean shouldDrawSurfaceColorStroke = false;
    public ColorStateList strokeColor;
    public int strokeWidth;

    public MaterialButtonHelper(MaterialButton materialButton2, ShapeAppearanceModel shapeAppearanceModel2) {
        this.materialButton = materialButton2;
        this.shapeAppearanceModel = shapeAppearanceModel2;
    }

    public Shapeable getMaskDrawable() {
        LayerDrawable layerDrawable = this.rippleDrawable;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        if (this.rippleDrawable.getNumberOfLayers() > 2) {
            return (Shapeable) this.rippleDrawable.getDrawable(2);
        }
        return (Shapeable) this.rippleDrawable.getDrawable(1);
    }

    public final MaterialShapeDrawable getMaterialShapeDrawable(boolean z) {
        LayerDrawable layerDrawable = this.rippleDrawable;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (MaterialShapeDrawable) ((LayerDrawable) ((InsetDrawable) this.rippleDrawable.getDrawable(0)).getDrawable()).getDrawable(z ^ true ? 1 : 0);
    }

    public final MaterialShapeDrawable getSurfaceColorStrokeDrawable() {
        return getMaterialShapeDrawable(true);
    }

    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel2) {
        this.shapeAppearanceModel = shapeAppearanceModel2;
        if (getMaterialShapeDrawable() != null) {
            MaterialShapeDrawable materialShapeDrawable = getMaterialShapeDrawable();
            materialShapeDrawable.drawableState.shapeAppearanceModel = shapeAppearanceModel2;
            materialShapeDrawable.invalidateSelf();
        }
        if (getSurfaceColorStrokeDrawable() != null) {
            MaterialShapeDrawable surfaceColorStrokeDrawable = getSurfaceColorStrokeDrawable();
            surfaceColorStrokeDrawable.drawableState.shapeAppearanceModel = shapeAppearanceModel2;
            surfaceColorStrokeDrawable.invalidateSelf();
        }
        if (getMaskDrawable() != null) {
            getMaskDrawable().setShapeAppearanceModel(shapeAppearanceModel2);
        }
    }

    public final void setVerticalInsets(int i, int i2) {
        int paddingStart = ViewCompat.getPaddingStart(this.materialButton);
        int paddingTop = this.materialButton.getPaddingTop();
        int paddingEnd = this.materialButton.getPaddingEnd();
        int paddingBottom = this.materialButton.getPaddingBottom();
        int i3 = this.insetTop;
        int i4 = this.insetBottom;
        this.insetBottom = i2;
        this.insetTop = i;
        if (!this.backgroundOverwritten) {
            updateBackground();
        }
        this.materialButton.setPaddingRelative(paddingStart, (paddingTop + i) - i3, paddingEnd, (paddingBottom + i2) - i4);
    }

    public final void updateBackground() {
        MaterialButton materialButton2 = this.materialButton;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.shapeAppearanceModel);
        materialShapeDrawable.initializeElevationOverlay(this.materialButton.getContext());
        materialShapeDrawable.setTintList(this.backgroundTint);
        Mode mode = this.backgroundTintMode;
        if (mode != null) {
            materialShapeDrawable.setTintMode(mode);
        }
        materialShapeDrawable.setStroke((float) this.strokeWidth, this.strokeColor);
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(this.shapeAppearanceModel);
        materialShapeDrawable2.setTint(0);
        materialShapeDrawable2.setStroke((float) this.strokeWidth, this.shouldDrawSurfaceColorStroke ? ImageOriginUtils.getColor(this.materialButton, R$attr.colorSurface) : 0);
        MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(this.shapeAppearanceModel);
        this.maskDrawable = materialShapeDrawable3;
        materialShapeDrawable3.setTint(-1);
        ColorStateList sanitizeRippleDrawableColor = RippleUtils.sanitizeRippleDrawableColor(this.rippleColor);
        InsetDrawable insetDrawable = new InsetDrawable(new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable}), this.insetLeft, this.insetTop, this.insetRight, this.insetBottom);
        RippleDrawable rippleDrawable2 = new RippleDrawable(sanitizeRippleDrawableColor, insetDrawable, this.maskDrawable);
        this.rippleDrawable = rippleDrawable2;
        materialButton2.setInternalBackground(rippleDrawable2);
        MaterialShapeDrawable materialShapeDrawable4 = getMaterialShapeDrawable();
        if (materialShapeDrawable4 != null) {
            materialShapeDrawable4.setElevation((float) this.elevation);
        }
    }

    public final void updateStroke() {
        MaterialShapeDrawable materialShapeDrawable = getMaterialShapeDrawable();
        MaterialShapeDrawable surfaceColorStrokeDrawable = getSurfaceColorStrokeDrawable();
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setStroke((float) this.strokeWidth, this.strokeColor);
            if (surfaceColorStrokeDrawable != null) {
                surfaceColorStrokeDrawable.setStroke((float) this.strokeWidth, this.shouldDrawSurfaceColorStroke ? ImageOriginUtils.getColor(this.materialButton, R$attr.colorSurface) : 0);
            }
        }
    }

    public MaterialShapeDrawable getMaterialShapeDrawable() {
        return getMaterialShapeDrawable(false);
    }
}
