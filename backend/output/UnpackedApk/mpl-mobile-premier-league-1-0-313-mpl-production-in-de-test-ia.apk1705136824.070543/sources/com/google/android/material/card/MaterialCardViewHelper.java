package com.google.android.material.card;

import a.a.a.a.d.b;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.CutCornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel.Builder;

public class MaterialCardViewHelper {
    public static final int[] CHECKED_STATE_SET = {16842912};
    public static final double COS_45 = Math.cos(Math.toRadians(45.0d));
    public final MaterialShapeDrawable bgDrawable;
    public boolean checkable;
    public Drawable checkedIcon;
    public int checkedIconMargin;
    public int checkedIconSize;
    public ColorStateList checkedIconTint;
    public LayerDrawable clickableForegroundDrawable;
    public MaterialShapeDrawable compatRippleDrawable;
    public Drawable fgDrawable;
    public final MaterialShapeDrawable foregroundContentDrawable;
    public MaterialShapeDrawable foregroundShapeDrawable;
    public boolean isBackgroundOverwritten = false;
    public final MaterialCardView materialCardView;
    public ColorStateList rippleColor;
    public Drawable rippleDrawable;
    public ShapeAppearanceModel shapeAppearanceModel;
    public ColorStateList strokeColor;
    public int strokeWidth;
    public final Rect userContentPadding = new Rect();

    public MaterialCardViewHelper(MaterialCardView materialCardView2, AttributeSet attributeSet, int i, int i2) {
        this.materialCardView = materialCardView2;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(materialCardView2.getContext(), attributeSet, i, i2);
        this.bgDrawable = materialShapeDrawable;
        materialShapeDrawable.initializeElevationOverlay(materialCardView2.getContext());
        this.bgDrawable.setShadowColor(-12303292);
        ShapeAppearanceModel shapeAppearanceModel2 = this.bgDrawable.drawableState.shapeAppearanceModel;
        if (shapeAppearanceModel2 != null) {
            Builder builder = new Builder(shapeAppearanceModel2);
            TypedArray obtainStyledAttributes = materialCardView2.getContext().obtainStyledAttributes(attributeSet, R$styleable.CardView, i, R$style.CardView);
            if (obtainStyledAttributes.hasValue(R$styleable.CardView_cardCornerRadius)) {
                builder.setAllCornerSizes(obtainStyledAttributes.getDimension(R$styleable.CardView_cardCornerRadius, 0.0f));
            }
            this.foregroundContentDrawable = new MaterialShapeDrawable();
            setShapeAppearanceModel(builder.build());
            obtainStyledAttributes.recycle();
            return;
        }
        throw null;
    }

    public final float calculateActualCornerPadding() {
        float calculateCornerPaddingForCornerTreatment = calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.topLeftCorner, this.bgDrawable.getTopLeftCornerResolvedSize());
        CornerTreatment cornerTreatment = this.shapeAppearanceModel.topRightCorner;
        MaterialShapeDrawable materialShapeDrawable = this.bgDrawable;
        float max = Math.max(calculateCornerPaddingForCornerTreatment, calculateCornerPaddingForCornerTreatment(cornerTreatment, materialShapeDrawable.drawableState.shapeAppearanceModel.topRightCornerSize.getCornerSize(materialShapeDrawable.getBoundsAsRectF())));
        CornerTreatment cornerTreatment2 = this.shapeAppearanceModel.bottomRightCorner;
        MaterialShapeDrawable materialShapeDrawable2 = this.bgDrawable;
        float calculateCornerPaddingForCornerTreatment2 = calculateCornerPaddingForCornerTreatment(cornerTreatment2, materialShapeDrawable2.drawableState.shapeAppearanceModel.bottomRightCornerSize.getCornerSize(materialShapeDrawable2.getBoundsAsRectF()));
        CornerTreatment cornerTreatment3 = this.shapeAppearanceModel.bottomLeftCorner;
        MaterialShapeDrawable materialShapeDrawable3 = this.bgDrawable;
        return Math.max(max, Math.max(calculateCornerPaddingForCornerTreatment2, calculateCornerPaddingForCornerTreatment(cornerTreatment3, materialShapeDrawable3.drawableState.shapeAppearanceModel.bottomLeftCornerSize.getCornerSize(materialShapeDrawable3.getBoundsAsRectF()))));
    }

    public final float calculateCornerPaddingForCornerTreatment(CornerTreatment cornerTreatment, float f2) {
        if (cornerTreatment instanceof RoundedCornerTreatment) {
            return (float) ((1.0d - COS_45) * ((double) f2));
        }
        if (cornerTreatment instanceof CutCornerTreatment) {
            return f2 / 2.0f;
        }
        return 0.0f;
    }

    public final float calculateHorizontalBackgroundPadding() {
        return this.materialCardView.getMaxCardElevation() + (shouldAddCornerPaddingOutsideCardBackground() ? calculateActualCornerPadding() : 0.0f);
    }

    public final float calculateVerticalBackgroundPadding() {
        return (this.materialCardView.getMaxCardElevation() * 1.5f) + (shouldAddCornerPaddingOutsideCardBackground() ? calculateActualCornerPadding() : 0.0f);
    }

    public final Drawable getClickableForeground() {
        if (this.rippleDrawable == null) {
            boolean z = RippleUtils.USE_FRAMEWORK_RIPPLE;
            this.foregroundShapeDrawable = new MaterialShapeDrawable(this.shapeAppearanceModel);
            this.rippleDrawable = new RippleDrawable(this.rippleColor, null, this.foregroundShapeDrawable);
        }
        if (this.clickableForegroundDrawable == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable = this.checkedIcon;
            if (drawable != null) {
                stateListDrawable.addState(CHECKED_STATE_SET, drawable);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.rippleDrawable, this.foregroundContentDrawable, stateListDrawable});
            this.clickableForegroundDrawable = layerDrawable;
            layerDrawable.setId(2, R$id.mtrl_card_checked_layer_id);
        }
        return this.clickableForegroundDrawable;
    }

    public final Drawable insetDrawable(Drawable drawable) {
        int i;
        int i2;
        if (0 != 0 || this.materialCardView.getUseCompatPadding()) {
            i = (int) Math.ceil((double) calculateVerticalBackgroundPadding());
            i2 = (int) Math.ceil((double) calculateHorizontalBackgroundPadding());
        } else {
            i2 = 0;
            i = 0;
        }
        AnonymousClass1 r2 = new InsetDrawable(this, drawable, i2, i, i2, i) {
            public int getMinimumHeight() {
                return -1;
            }

            public int getMinimumWidth() {
                return -1;
            }

            public boolean getPadding(Rect rect) {
                return false;
            }
        };
        return r2;
    }

    public void setCheckedIcon(Drawable drawable) {
        this.checkedIcon = drawable;
        if (drawable != null) {
            Drawable wrap = b.wrap(drawable.mutate());
            this.checkedIcon = wrap;
            wrap.setTintList(this.checkedIconTint);
        }
        if (this.clickableForegroundDrawable != null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable2 = this.checkedIcon;
            if (drawable2 != null) {
                stateListDrawable.addState(CHECKED_STATE_SET, drawable2);
            }
            this.clickableForegroundDrawable.setDrawableByLayerId(R$id.mtrl_card_checked_layer_id, stateListDrawable);
        }
    }

    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel2) {
        this.shapeAppearanceModel = shapeAppearanceModel2;
        MaterialShapeDrawable materialShapeDrawable = this.bgDrawable;
        materialShapeDrawable.drawableState.shapeAppearanceModel = shapeAppearanceModel2;
        materialShapeDrawable.invalidateSelf();
        MaterialShapeDrawable materialShapeDrawable2 = this.bgDrawable;
        materialShapeDrawable2.shadowBitmapDrawingEnable = !materialShapeDrawable2.isRoundRect();
        MaterialShapeDrawable materialShapeDrawable3 = this.foregroundContentDrawable;
        if (materialShapeDrawable3 != null) {
            materialShapeDrawable3.drawableState.shapeAppearanceModel = shapeAppearanceModel2;
            materialShapeDrawable3.invalidateSelf();
        }
        MaterialShapeDrawable materialShapeDrawable4 = this.foregroundShapeDrawable;
        if (materialShapeDrawable4 != null) {
            materialShapeDrawable4.drawableState.shapeAppearanceModel = shapeAppearanceModel2;
            materialShapeDrawable4.invalidateSelf();
        }
        MaterialShapeDrawable materialShapeDrawable5 = this.compatRippleDrawable;
        if (materialShapeDrawable5 != null) {
            materialShapeDrawable5.drawableState.shapeAppearanceModel = shapeAppearanceModel2;
            materialShapeDrawable5.invalidateSelf();
        }
    }

    public final boolean shouldAddCornerPaddingInsideCardBackground() {
        return this.materialCardView.getPreventCornerOverlap() && !this.bgDrawable.isRoundRect();
    }

    public final boolean shouldAddCornerPaddingOutsideCardBackground() {
        return this.materialCardView.getPreventCornerOverlap() && this.bgDrawable.isRoundRect() && this.materialCardView.getUseCompatPadding();
    }

    public void updateContentPadding() {
        float f2 = 0.0f;
        float calculateActualCornerPadding = shouldAddCornerPaddingInsideCardBackground() || shouldAddCornerPaddingOutsideCardBackground() ? calculateActualCornerPadding() : 0.0f;
        if (this.materialCardView.getPreventCornerOverlap() && this.materialCardView.getUseCompatPadding()) {
            f2 = (float) ((1.0d - COS_45) * ((double) this.materialCardView.getCardViewRadius()));
        }
        int i = (int) (calculateActualCornerPadding - f2);
        MaterialCardView materialCardView2 = this.materialCardView;
        Rect rect = this.userContentPadding;
        materialCardView2.setAncestorContentPadding(rect.left + i, rect.top + i, rect.right + i, rect.bottom + i);
    }

    public void updateInsets() {
        if (!this.isBackgroundOverwritten) {
            this.materialCardView.setBackgroundInternal(insetDrawable(this.bgDrawable));
        }
        this.materialCardView.setForeground(insetDrawable(this.fgDrawable));
    }

    public final void updateRippleColor() {
        boolean z = RippleUtils.USE_FRAMEWORK_RIPPLE;
        Drawable drawable = this.rippleDrawable;
        if (drawable != null) {
            ((RippleDrawable) drawable).setColor(this.rippleColor);
            return;
        }
        MaterialShapeDrawable materialShapeDrawable = this.compatRippleDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setFillColor(this.rippleColor);
        }
    }

    public void updateStroke() {
        this.foregroundContentDrawable.setStroke((float) this.strokeWidth, this.strokeColor);
    }
}
