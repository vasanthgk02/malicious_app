package com.google.android.material.card;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.core.view.ViewCompat;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.TextAppearanceConfig;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class MaterialCardView extends CardView implements Checkable, Shapeable {
    public static final int[] CHECKABLE_STATE_SET = {16842911};
    public static final int[] CHECKED_STATE_SET = {16842912};
    public static final int DEF_STYLE_RES = R$style.Widget_MaterialComponents_CardView;
    public static final int[] DRAGGED_STATE_SET = {R$attr.state_dragged};
    public final MaterialCardViewHelper cardViewHelper;
    public boolean checked;
    public boolean dragged;
    public boolean isParentCardViewDoneInitializing;
    public OnCheckedChangeListener onCheckedChangeListener;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(MaterialCardView materialCardView, boolean z);
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialCardViewStyle);
    }

    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.cardViewHelper.bgDrawable.getBounds());
        return rectF;
    }

    public final void forceRippleRedrawIfNeeded() {
        if (VERSION.SDK_INT > 26) {
            MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
            Drawable drawable = materialCardViewHelper.rippleDrawable;
            if (drawable != null) {
                Rect bounds = drawable.getBounds();
                int i = bounds.bottom;
                materialCardViewHelper.rippleDrawable.setBounds(bounds.left, bounds.top, bounds.right, i - 1);
                materialCardViewHelper.rippleDrawable.setBounds(bounds.left, bounds.top, bounds.right, i);
            }
        }
    }

    public ColorStateList getCardBackgroundColor() {
        return this.cardViewHelper.bgDrawable.drawableState.fillColor;
    }

    public ColorStateList getCardForegroundColor() {
        return this.cardViewHelper.foregroundContentDrawable.drawableState.fillColor;
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        return this.cardViewHelper.checkedIcon;
    }

    public int getCheckedIconMargin() {
        return this.cardViewHelper.checkedIconMargin;
    }

    public int getCheckedIconSize() {
        return this.cardViewHelper.checkedIconSize;
    }

    public ColorStateList getCheckedIconTint() {
        return this.cardViewHelper.checkedIconTint;
    }

    public int getContentPaddingBottom() {
        return this.cardViewHelper.userContentPadding.bottom;
    }

    public int getContentPaddingLeft() {
        return this.cardViewHelper.userContentPadding.left;
    }

    public int getContentPaddingRight() {
        return this.cardViewHelper.userContentPadding.right;
    }

    public int getContentPaddingTop() {
        return this.cardViewHelper.userContentPadding.top;
    }

    public float getProgress() {
        return this.cardViewHelper.bgDrawable.drawableState.interpolation;
    }

    public float getRadius() {
        return this.cardViewHelper.bgDrawable.getTopLeftCornerResolvedSize();
    }

    public ColorStateList getRippleColor() {
        return this.cardViewHelper.rippleColor;
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.cardViewHelper.shapeAppearanceModel;
    }

    @Deprecated
    public int getStrokeColor() {
        ColorStateList colorStateList = this.cardViewHelper.strokeColor;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.cardViewHelper.strokeColor;
    }

    public int getStrokeWidth() {
        return this.cardViewHelper.strokeWidth;
    }

    public boolean isCheckable() {
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        return materialCardViewHelper != null && materialCardViewHelper.checkable;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextAppearanceConfig.setParentAbsoluteElevation(this, this.cardViewHelper.bgDrawable);
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 3);
        if (isCheckable()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, CHECKABLE_STATE_SET);
        }
        if (isChecked()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        if (this.dragged) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, DRAGGED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(isChecked());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        super.onMeasure(i, i2);
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (materialCardViewHelper.clickableForegroundDrawable != null) {
            int i5 = materialCardViewHelper.checkedIconMargin;
            int i6 = materialCardViewHelper.checkedIconSize;
            int i7 = (measuredWidth - i5) - i6;
            int i8 = (measuredHeight - i5) - i6;
            if (materialCardViewHelper.materialCardView.getUseCompatPadding()) {
                i8 -= (int) Math.ceil((double) (materialCardViewHelper.calculateVerticalBackgroundPadding() * 2.0f));
                i7 -= (int) Math.ceil((double) (materialCardViewHelper.calculateHorizontalBackgroundPadding() * 2.0f));
            }
            int i9 = i8;
            int i10 = materialCardViewHelper.checkedIconMargin;
            if (ViewCompat.getLayoutDirection(materialCardViewHelper.materialCardView) == 1) {
                i3 = i7;
                i4 = i10;
            } else {
                i4 = i7;
                i3 = i10;
            }
            materialCardViewHelper.clickableForegroundDrawable.setLayerInset(2, i4, materialCardViewHelper.checkedIconMargin, i3, i9);
        }
    }

    public void setAncestorContentPadding(int i, int i2, int i3, int i4) {
        super.setContentPadding(i, i2, i3, i4);
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.isParentCardViewDoneInitializing) {
            MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
            if (!materialCardViewHelper.isBackgroundOverwritten) {
                materialCardViewHelper.isBackgroundOverwritten = true;
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setCardBackgroundColor(int i) {
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        materialCardViewHelper.bgDrawable.setFillColor(ColorStateList.valueOf(i));
    }

    public void setCardElevation(float f2) {
        super.setCardElevation(f2);
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        materialCardViewHelper.bgDrawable.setElevation(materialCardViewHelper.materialCardView.getCardElevation());
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = this.cardViewHelper.foregroundContentDrawable;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        materialShapeDrawable.setFillColor(colorStateList);
    }

    public void setCheckable(boolean z) {
        this.cardViewHelper.checkable = z;
    }

    public void setChecked(boolean z) {
        if (this.checked != z) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        this.cardViewHelper.setCheckedIcon(drawable);
    }

    public void setCheckedIconMargin(int i) {
        this.cardViewHelper.checkedIconMargin = i;
    }

    public void setCheckedIconMarginResource(int i) {
        if (i != -1) {
            this.cardViewHelper.checkedIconMargin = getResources().getDimensionPixelSize(i);
        }
    }

    public void setCheckedIconResource(int i) {
        this.cardViewHelper.setCheckedIcon(AppCompatResources.getDrawable(getContext(), i));
    }

    public void setCheckedIconSize(int i) {
        this.cardViewHelper.checkedIconSize = i;
    }

    public void setCheckedIconSizeResource(int i) {
        if (i != 0) {
            this.cardViewHelper.checkedIconSize = getResources().getDimensionPixelSize(i);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        materialCardViewHelper.checkedIconTint = colorStateList;
        Drawable drawable = materialCardViewHelper.checkedIcon;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        }
    }

    public void setClickable(boolean z) {
        super.setClickable(z);
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        if (materialCardViewHelper != null) {
            Drawable drawable = materialCardViewHelper.fgDrawable;
            Drawable clickableForeground = materialCardViewHelper.materialCardView.isClickable() ? materialCardViewHelper.getClickableForeground() : materialCardViewHelper.foregroundContentDrawable;
            materialCardViewHelper.fgDrawable = clickableForeground;
            if (drawable == clickableForeground) {
                return;
            }
            if (VERSION.SDK_INT < 23 || !(materialCardViewHelper.materialCardView.getForeground() instanceof InsetDrawable)) {
                materialCardViewHelper.materialCardView.setForeground(materialCardViewHelper.insetDrawable(clickableForeground));
            } else {
                ((InsetDrawable) materialCardViewHelper.materialCardView.getForeground()).setDrawable(clickableForeground);
            }
        }
    }

    public void setContentPadding(int i, int i2, int i3, int i4) {
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        materialCardViewHelper.userContentPadding.set(i, i2, i3, i4);
        materialCardViewHelper.updateContentPadding();
    }

    public void setDragged(boolean z) {
        if (this.dragged != z) {
            this.dragged = z;
            refreshDrawableState();
            forceRippleRedrawIfNeeded();
            invalidate();
        }
    }

    public void setMaxCardElevation(float f2) {
        super.setMaxCardElevation(f2);
        this.cardViewHelper.updateInsets();
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener2) {
        this.onCheckedChangeListener = onCheckedChangeListener2;
    }

    public void setPreventCornerOverlap(boolean z) {
        super.setPreventCornerOverlap(z);
        this.cardViewHelper.updateInsets();
        this.cardViewHelper.updateContentPadding();
    }

    public void setProgress(float f2) {
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        materialCardViewHelper.bgDrawable.setInterpolation(f2);
        MaterialShapeDrawable materialShapeDrawable = materialCardViewHelper.foregroundContentDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setInterpolation(f2);
        }
        MaterialShapeDrawable materialShapeDrawable2 = materialCardViewHelper.foregroundShapeDrawable;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setInterpolation(f2);
        }
    }

    public void setRadius(float f2) {
        super.setRadius(f2);
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        materialCardViewHelper.setShapeAppearanceModel(materialCardViewHelper.shapeAppearanceModel.withCornerSize(f2));
        materialCardViewHelper.fgDrawable.invalidateSelf();
        if (materialCardViewHelper.shouldAddCornerPaddingOutsideCardBackground() || materialCardViewHelper.shouldAddCornerPaddingInsideCardBackground()) {
            materialCardViewHelper.updateContentPadding();
        }
        if (materialCardViewHelper.shouldAddCornerPaddingOutsideCardBackground()) {
            materialCardViewHelper.updateInsets();
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        materialCardViewHelper.rippleColor = colorStateList;
        materialCardViewHelper.updateRippleColor();
    }

    public void setRippleColorResource(int i) {
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        materialCardViewHelper.rippleColor = AppCompatResources.getColorStateList(getContext(), i);
        materialCardViewHelper.updateRippleColor();
    }

    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        setClipToOutline(shapeAppearanceModel.isRoundRect(getBoundsAsRectF()));
        this.cardViewHelper.setShapeAppearanceModel(shapeAppearanceModel);
    }

    public void setStrokeColor(int i) {
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        ColorStateList valueOf = ColorStateList.valueOf(i);
        if (materialCardViewHelper.strokeColor != valueOf) {
            materialCardViewHelper.strokeColor = valueOf;
            materialCardViewHelper.updateStroke();
        }
    }

    public void setStrokeWidth(int i) {
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        if (i != materialCardViewHelper.strokeWidth) {
            materialCardViewHelper.strokeWidth = i;
            materialCardViewHelper.updateStroke();
        }
    }

    public void setUseCompatPadding(boolean z) {
        super.setUseCompatPadding(z);
        this.cardViewHelper.updateInsets();
        this.cardViewHelper.updateContentPadding();
    }

    public void toggle() {
        if (isCheckable() && isEnabled()) {
            this.checked = !this.checked;
            refreshDrawableState();
            forceRippleRedrawIfNeeded();
            OnCheckedChangeListener onCheckedChangeListener2 = this.onCheckedChangeListener;
            if (onCheckedChangeListener2 != null) {
                onCheckedChangeListener2.onCheckedChanged(this, this.checked);
            }
        }
    }

    public MaterialCardView(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        this.checked = false;
        this.dragged = false;
        this.isParentCardViewDoneInitializing = true;
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(getContext(), attributeSet, R$styleable.MaterialCardView, i, DEF_STYLE_RES, new int[0]);
        MaterialCardViewHelper materialCardViewHelper = new MaterialCardViewHelper(this, attributeSet, i, DEF_STYLE_RES);
        this.cardViewHelper = materialCardViewHelper;
        materialCardViewHelper.bgDrawable.setFillColor(super.getCardBackgroundColor());
        MaterialCardViewHelper materialCardViewHelper2 = this.cardViewHelper;
        materialCardViewHelper2.userContentPadding.set(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        materialCardViewHelper2.updateContentPadding();
        MaterialCardViewHelper materialCardViewHelper3 = this.cardViewHelper;
        ColorStateList colorStateList = ImageOriginUtils.getColorStateList(materialCardViewHelper3.materialCardView.getContext(), obtainStyledAttributes, R$styleable.MaterialCardView_strokeColor);
        materialCardViewHelper3.strokeColor = colorStateList;
        if (colorStateList == null) {
            materialCardViewHelper3.strokeColor = ColorStateList.valueOf(-1);
        }
        materialCardViewHelper3.strokeWidth = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialCardView_strokeWidth, 0);
        boolean z = obtainStyledAttributes.getBoolean(R$styleable.MaterialCardView_android_checkable, false);
        materialCardViewHelper3.checkable = z;
        materialCardViewHelper3.materialCardView.setLongClickable(z);
        materialCardViewHelper3.checkedIconTint = ImageOriginUtils.getColorStateList(materialCardViewHelper3.materialCardView.getContext(), obtainStyledAttributes, R$styleable.MaterialCardView_checkedIconTint);
        materialCardViewHelper3.setCheckedIcon(ImageOriginUtils.getDrawable1(materialCardViewHelper3.materialCardView.getContext(), obtainStyledAttributes, R$styleable.MaterialCardView_checkedIcon));
        materialCardViewHelper3.checkedIconSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialCardView_checkedIconSize, 0);
        materialCardViewHelper3.checkedIconMargin = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialCardView_checkedIconMargin, 0);
        ColorStateList colorStateList2 = ImageOriginUtils.getColorStateList(materialCardViewHelper3.materialCardView.getContext(), obtainStyledAttributes, R$styleable.MaterialCardView_rippleColor);
        materialCardViewHelper3.rippleColor = colorStateList2;
        if (colorStateList2 == null) {
            materialCardViewHelper3.rippleColor = ColorStateList.valueOf(ImageOriginUtils.getColor(materialCardViewHelper3.materialCardView, R$attr.colorControlHighlight));
        }
        materialCardViewHelper3.foregroundContentDrawable.setFillColor(ImageOriginUtils.getColorStateList(materialCardViewHelper3.materialCardView.getContext(), obtainStyledAttributes, R$styleable.MaterialCardView_cardForegroundColor) == null ? ColorStateList.valueOf(0) : ImageOriginUtils.getColorStateList(materialCardViewHelper3.materialCardView.getContext(), obtainStyledAttributes, R$styleable.MaterialCardView_cardForegroundColor));
        materialCardViewHelper3.updateRippleColor();
        materialCardViewHelper3.bgDrawable.setElevation(materialCardViewHelper3.materialCardView.getCardElevation());
        materialCardViewHelper3.updateStroke();
        materialCardViewHelper3.materialCardView.setBackgroundInternal(materialCardViewHelper3.insetDrawable(materialCardViewHelper3.bgDrawable));
        Drawable clickableForeground = materialCardViewHelper3.materialCardView.isClickable() ? materialCardViewHelper3.getClickableForeground() : materialCardViewHelper3.foregroundContentDrawable;
        materialCardViewHelper3.fgDrawable = clickableForeground;
        materialCardViewHelper3.materialCardView.setForeground(materialCardViewHelper3.insetDrawable(clickableForeground));
        obtainStyledAttributes.recycle();
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.cardViewHelper.bgDrawable.setFillColor(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        if (materialCardViewHelper.strokeColor != colorStateList) {
            materialCardViewHelper.strokeColor = colorStateList;
            materialCardViewHelper.updateStroke();
        }
    }
}
