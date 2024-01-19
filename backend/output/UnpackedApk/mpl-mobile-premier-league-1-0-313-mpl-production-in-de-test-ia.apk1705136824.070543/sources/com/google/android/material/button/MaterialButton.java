package com.google.android.material.button;

import a.a.a.a.d.b;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.TextAppearanceConfig;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class MaterialButton extends AppCompatButton implements Checkable, Shapeable {
    public static final int[] CHECKABLE_STATE_SET = {16842911};
    public static final int[] CHECKED_STATE_SET = {16842912};
    public static final int DEF_STYLE_RES = R$style.Widget_MaterialComponents_Button;
    public boolean broadcasting;
    public boolean checked;
    public Drawable icon;
    public int iconGravity;
    public int iconLeft;
    public int iconPadding;
    public int iconSize;
    public ColorStateList iconTint;
    public Mode iconTintMode;
    public int iconTop;
    public final MaterialButtonHelper materialButtonHelper;
    public final LinkedHashSet<OnCheckedChangeListener> onCheckedChangeListeners;
    public OnPressedChangeListener onPressedChangeListenerInternal;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(MaterialButton materialButton, boolean z);
    }

    public interface OnPressedChangeListener {
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
        public boolean checked;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.mSuperState, i);
            parcel.writeInt(this.checked ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                SavedState.class.getClassLoader();
            }
            this.checked = parcel.readInt() != 1 ? false : true;
        }
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialButtonStyle);
    }

    private String getA11yClassName() {
        return (isCheckable() ? CompoundButton.class : Button.class).getName();
    }

    private int getTextHeight() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextWidth() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        return Math.min((int) paint.measureText(charSequence), getLayout().getEllipsizedWidth());
    }

    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    public Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.cornerRadius;
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public int getIconGravity() {
        return this.iconGravity;
    }

    public int getIconPadding() {
        return this.iconPadding;
    }

    public int getIconSize() {
        return this.iconSize;
    }

    public ColorStateList getIconTint() {
        return this.iconTint;
    }

    public Mode getIconTintMode() {
        return this.iconTintMode;
    }

    public int getInsetBottom() {
        return this.materialButtonHelper.insetBottom;
    }

    public int getInsetTop() {
        return this.materialButtonHelper.insetTop;
    }

    public ColorStateList getRippleColor() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.rippleColor;
        }
        return null;
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.shapeAppearanceModel;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.strokeColor;
        }
        return null;
    }

    public int getStrokeWidth() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.strokeWidth;
        }
        return 0;
    }

    public ColorStateList getSupportBackgroundTintList() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.backgroundTint;
        }
        return super.getSupportBackgroundTintList();
    }

    public Mode getSupportBackgroundTintMode() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.backgroundTintMode;
        }
        return super.getSupportBackgroundTintMode();
    }

    public boolean isCheckable() {
        MaterialButtonHelper materialButtonHelper2 = this.materialButtonHelper;
        return materialButtonHelper2 != null && materialButtonHelper2.checkable;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public final boolean isIconEnd() {
        int i = this.iconGravity;
        return i == 3 || i == 4;
    }

    public final boolean isIconStart() {
        int i = this.iconGravity;
        return i == 1 || i == 2;
    }

    public final boolean isIconTop() {
        int i = this.iconGravity;
        return i == 16 || i == 32;
    }

    public final boolean isUsingOriginalBackground() {
        MaterialButtonHelper materialButtonHelper2 = this.materialButtonHelper;
        return materialButtonHelper2 != null && !materialButtonHelper2.backgroundOverwritten;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isUsingOriginalBackground()) {
            TextAppearanceConfig.setParentAbsoluteElevation(this, this.materialButtonHelper.getMaterialShapeDrawable());
        }
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (isCheckable()) {
            Button.mergeDrawableStates(onCreateDrawableState, CHECKABLE_STATE_SET);
        }
        if (isChecked()) {
            Button.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.mSuperState);
        setChecked(savedState.checked);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.checked = this.checked;
        return savedState;
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        updateIconPosition(i, i2);
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
    }

    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    public final void resetIconDrawable() {
        if (isIconStart()) {
            setCompoundDrawablesRelative(this.icon, null, null, null);
        } else if (isIconEnd()) {
            setCompoundDrawablesRelative(null, null, this.icon, null);
        } else if (isIconTop()) {
            setCompoundDrawablesRelative(null, this.icon, null, null);
        }
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundColor(int i) {
        if (isUsingOriginalBackground()) {
            MaterialButtonHelper materialButtonHelper2 = this.materialButtonHelper;
            if (materialButtonHelper2.getMaterialShapeDrawable() != null) {
                materialButtonHelper2.getMaterialShapeDrawable().setTint(i);
                return;
            }
            return;
        }
        super.setBackgroundColor(i);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (!isUsingOriginalBackground()) {
            super.setBackgroundDrawable(drawable);
        } else if (drawable != getBackground()) {
            MaterialButtonHelper materialButtonHelper2 = this.materialButtonHelper;
            materialButtonHelper2.backgroundOverwritten = true;
            materialButtonHelper2.materialButton.setSupportBackgroundTintList(materialButtonHelper2.backgroundTint);
            materialButtonHelper2.materialButton.setSupportBackgroundTintMode(materialButtonHelper2.backgroundTintMode);
            super.setBackgroundDrawable(drawable);
        } else {
            getBackground().setState(drawable.getState());
        }
    }

    public void setBackgroundResource(int i) {
        setBackgroundDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    public void setBackgroundTintMode(Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.checkable = z;
        }
    }

    public void setChecked(boolean z) {
        if (isCheckable() && isEnabled() && this.checked != z) {
            this.checked = z;
            refreshDrawableState();
            if (!this.broadcasting) {
                this.broadcasting = true;
                Iterator it = this.onCheckedChangeListeners.iterator();
                while (it.hasNext()) {
                    ((OnCheckedChangeListener) it.next()).onCheckedChanged(this, this.checked);
                }
                this.broadcasting = false;
            }
        }
    }

    public void setCornerRadius(int i) {
        if (isUsingOriginalBackground()) {
            MaterialButtonHelper materialButtonHelper2 = this.materialButtonHelper;
            if (!materialButtonHelper2.cornerRadiusSet || materialButtonHelper2.cornerRadius != i) {
                materialButtonHelper2.cornerRadius = i;
                materialButtonHelper2.cornerRadiusSet = true;
                materialButtonHelper2.setShapeAppearanceModel(materialButtonHelper2.shapeAppearanceModel.withCornerSize((float) i));
            }
        }
    }

    public void setCornerRadiusResource(int i) {
        if (isUsingOriginalBackground()) {
            setCornerRadius(getResources().getDimensionPixelSize(i));
        }
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        if (isUsingOriginalBackground()) {
            MaterialShapeDrawable materialShapeDrawable = this.materialButtonHelper.getMaterialShapeDrawable();
            MaterialShapeDrawableState materialShapeDrawableState = materialShapeDrawable.drawableState;
            if (materialShapeDrawableState.elevation != f2) {
                materialShapeDrawableState.elevation = f2;
                materialShapeDrawable.updateZ();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.icon != drawable) {
            this.icon = drawable;
            updateIcon(true);
            updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i) {
        if (this.iconGravity != i) {
            this.iconGravity = i;
            updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i) {
        if (this.iconPadding != i) {
            this.iconPadding = i;
            setCompoundDrawablePadding(i);
        }
    }

    public void setIconResource(int i) {
        setIcon(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setIconSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        } else if (this.iconSize != i) {
            this.iconSize = i;
            updateIcon(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.iconTint != colorStateList) {
            this.iconTint = colorStateList;
            updateIcon(false);
        }
    }

    public void setIconTintMode(Mode mode) {
        if (this.iconTintMode != mode) {
            this.iconTintMode = mode;
            updateIcon(false);
        }
    }

    public void setIconTintResource(int i) {
        setIconTint(AppCompatResources.getColorStateList(getContext(), i));
    }

    public void setInsetBottom(int i) {
        MaterialButtonHelper materialButtonHelper2 = this.materialButtonHelper;
        materialButtonHelper2.setVerticalInsets(materialButtonHelper2.insetTop, i);
    }

    public void setInsetTop(int i) {
        MaterialButtonHelper materialButtonHelper2 = this.materialButtonHelper;
        materialButtonHelper2.setVerticalInsets(i, materialButtonHelper2.insetBottom);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(OnPressedChangeListener onPressedChangeListener) {
        this.onPressedChangeListenerInternal = onPressedChangeListener;
    }

    public void setPressed(boolean z) {
        OnPressedChangeListener onPressedChangeListener = this.onPressedChangeListenerInternal;
        if (onPressedChangeListener != null) {
            MaterialButtonToggleGroup.this.invalidate();
        }
        super.setPressed(z);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (isUsingOriginalBackground()) {
            MaterialButtonHelper materialButtonHelper2 = this.materialButtonHelper;
            if (materialButtonHelper2.rippleColor != colorStateList) {
                materialButtonHelper2.rippleColor = colorStateList;
                if (materialButtonHelper2.materialButton.getBackground() instanceof RippleDrawable) {
                    ((RippleDrawable) materialButtonHelper2.materialButton.getBackground()).setColor(RippleUtils.sanitizeRippleDrawableColor(colorStateList));
                }
            }
        }
    }

    public void setRippleColorResource(int i) {
        if (isUsingOriginalBackground()) {
            setRippleColor(AppCompatResources.getColorStateList(getContext(), i));
        }
    }

    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setShapeAppearanceModel(shapeAppearanceModel);
            return;
        }
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    public void setShouldDrawSurfaceColorStroke(boolean z) {
        if (isUsingOriginalBackground()) {
            MaterialButtonHelper materialButtonHelper2 = this.materialButtonHelper;
            materialButtonHelper2.shouldDrawSurfaceColorStroke = z;
            materialButtonHelper2.updateStroke();
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (isUsingOriginalBackground()) {
            MaterialButtonHelper materialButtonHelper2 = this.materialButtonHelper;
            if (materialButtonHelper2.strokeColor != colorStateList) {
                materialButtonHelper2.strokeColor = colorStateList;
                materialButtonHelper2.updateStroke();
            }
        }
    }

    public void setStrokeColorResource(int i) {
        if (isUsingOriginalBackground()) {
            setStrokeColor(AppCompatResources.getColorStateList(getContext(), i));
        }
    }

    public void setStrokeWidth(int i) {
        if (isUsingOriginalBackground()) {
            MaterialButtonHelper materialButtonHelper2 = this.materialButtonHelper;
            if (materialButtonHelper2.strokeWidth != i) {
                materialButtonHelper2.strokeWidth = i;
                materialButtonHelper2.updateStroke();
            }
        }
    }

    public void setStrokeWidthResource(int i) {
        if (isUsingOriginalBackground()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (isUsingOriginalBackground()) {
            MaterialButtonHelper materialButtonHelper2 = this.materialButtonHelper;
            if (materialButtonHelper2.backgroundTint != colorStateList) {
                materialButtonHelper2.backgroundTint = colorStateList;
                if (materialButtonHelper2.getMaterialShapeDrawable() != null) {
                    materialButtonHelper2.getMaterialShapeDrawable().setTintList(materialButtonHelper2.backgroundTint);
                    return;
                }
                return;
            }
            return;
        }
        super.setSupportBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (isUsingOriginalBackground()) {
            MaterialButtonHelper materialButtonHelper2 = this.materialButtonHelper;
            if (materialButtonHelper2.backgroundTintMode != mode) {
                materialButtonHelper2.backgroundTintMode = mode;
                if (materialButtonHelper2.getMaterialShapeDrawable() != null && materialButtonHelper2.backgroundTintMode != null) {
                    materialButtonHelper2.getMaterialShapeDrawable().setTintMode(materialButtonHelper2.backgroundTintMode);
                    return;
                }
                return;
            }
            return;
        }
        super.setSupportBackgroundTintMode(mode);
    }

    public void toggle() {
        setChecked(!this.checked);
    }

    public final void updateIcon(boolean z) {
        Drawable drawable = this.icon;
        if (drawable != null) {
            Drawable mutate = b.wrap(drawable).mutate();
            this.icon = mutate;
            mutate.setTintList(this.iconTint);
            Mode mode = this.iconTintMode;
            if (mode != null) {
                this.icon.setTintMode(mode);
            }
            int i = this.iconSize;
            if (i == 0) {
                i = this.icon.getIntrinsicWidth();
            }
            int i2 = this.iconSize;
            if (i2 == 0) {
                i2 = this.icon.getIntrinsicHeight();
            }
            Drawable drawable2 = this.icon;
            int i3 = this.iconLeft;
            int i4 = this.iconTop;
            drawable2.setBounds(i3, i4, i + i3, i2 + i4);
        }
        if (z) {
            resetIconDrawable();
            return;
        }
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        boolean z2 = false;
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        if ((isIconStart() && drawable3 != this.icon) || ((isIconEnd() && drawable5 != this.icon) || (isIconTop() && drawable4 != this.icon))) {
            z2 = true;
        }
        if (z2) {
            resetIconDrawable();
        }
    }

    public final void updateIconPosition(int i, int i2) {
        if (!(this.icon == null || getLayout() == null)) {
            if (isIconStart() || isIconEnd()) {
                this.iconTop = 0;
                int i3 = this.iconGravity;
                boolean z = true;
                if (i3 == 1 || i3 == 3) {
                    this.iconLeft = 0;
                    updateIcon(false);
                } else {
                    int i4 = this.iconSize;
                    if (i4 == 0) {
                        i4 = this.icon.getIntrinsicWidth();
                    }
                    int textWidth = (((((i - getTextWidth()) - ViewCompat.getPaddingEnd(this)) - i4) - this.iconPadding) - getPaddingStart()) / 2;
                    boolean z2 = ViewCompat.getLayoutDirection(this) == 1;
                    if (this.iconGravity != 4) {
                        z = false;
                    }
                    if (z2 != z) {
                        textWidth = -textWidth;
                    }
                    if (this.iconLeft != textWidth) {
                        this.iconLeft = textWidth;
                        updateIcon(false);
                    }
                }
            } else if (isIconTop()) {
                this.iconLeft = 0;
                if (this.iconGravity == 16) {
                    this.iconTop = 0;
                    updateIcon(false);
                    return;
                }
                int i5 = this.iconSize;
                if (i5 == 0) {
                    i5 = this.icon.getIntrinsicHeight();
                }
                int textHeight = (((((i2 - getTextHeight()) - getPaddingTop()) - i5) - this.iconPadding) - getPaddingBottom()) / 2;
                if (this.iconTop != textHeight) {
                    this.iconTop = textHeight;
                    updateIcon(false);
                }
            }
        }
    }

    public MaterialButton(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        this.onCheckedChangeListeners = new LinkedHashSet<>();
        boolean z = false;
        this.checked = false;
        this.broadcasting = false;
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R$styleable.MaterialButton, i, DEF_STYLE_RES, new int[0]);
        this.iconPadding = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialButton_iconPadding, 0);
        this.iconTintMode = ImageOriginUtils.parseTintMode(obtainStyledAttributes.getInt(R$styleable.MaterialButton_iconTintMode, -1), Mode.SRC_IN);
        this.iconTint = ImageOriginUtils.getColorStateList(getContext(), obtainStyledAttributes, R$styleable.MaterialButton_iconTint);
        this.icon = ImageOriginUtils.getDrawable1(getContext(), obtainStyledAttributes, R$styleable.MaterialButton_icon);
        this.iconGravity = obtainStyledAttributes.getInteger(R$styleable.MaterialButton_iconGravity, 1);
        this.iconSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialButton_iconSize, 0);
        MaterialButtonHelper materialButtonHelper2 = new MaterialButtonHelper(this, ShapeAppearanceModel.builder(context2, attributeSet, i, DEF_STYLE_RES).build());
        this.materialButtonHelper = materialButtonHelper2;
        if (materialButtonHelper2 != null) {
            materialButtonHelper2.insetLeft = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetLeft, 0);
            materialButtonHelper2.insetRight = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetRight, 0);
            materialButtonHelper2.insetTop = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetTop, 0);
            materialButtonHelper2.insetBottom = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetBottom, 0);
            if (obtainStyledAttributes.hasValue(R$styleable.MaterialButton_cornerRadius)) {
                int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialButton_cornerRadius, -1);
                materialButtonHelper2.cornerRadius = dimensionPixelSize;
                materialButtonHelper2.setShapeAppearanceModel(materialButtonHelper2.shapeAppearanceModel.withCornerSize((float) dimensionPixelSize));
                materialButtonHelper2.cornerRadiusSet = true;
            }
            materialButtonHelper2.strokeWidth = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialButton_strokeWidth, 0);
            materialButtonHelper2.backgroundTintMode = ImageOriginUtils.parseTintMode(obtainStyledAttributes.getInt(R$styleable.MaterialButton_backgroundTintMode, -1), Mode.SRC_IN);
            materialButtonHelper2.backgroundTint = ImageOriginUtils.getColorStateList(materialButtonHelper2.materialButton.getContext(), obtainStyledAttributes, R$styleable.MaterialButton_backgroundTint);
            materialButtonHelper2.strokeColor = ImageOriginUtils.getColorStateList(materialButtonHelper2.materialButton.getContext(), obtainStyledAttributes, R$styleable.MaterialButton_strokeColor);
            materialButtonHelper2.rippleColor = ImageOriginUtils.getColorStateList(materialButtonHelper2.materialButton.getContext(), obtainStyledAttributes, R$styleable.MaterialButton_rippleColor);
            materialButtonHelper2.checkable = obtainStyledAttributes.getBoolean(R$styleable.MaterialButton_android_checkable, false);
            materialButtonHelper2.elevation = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialButton_elevation, 0);
            int paddingStart = ViewCompat.getPaddingStart(materialButtonHelper2.materialButton);
            int paddingTop = materialButtonHelper2.materialButton.getPaddingTop();
            int paddingEnd = materialButtonHelper2.materialButton.getPaddingEnd();
            int paddingBottom = materialButtonHelper2.materialButton.getPaddingBottom();
            if (obtainStyledAttributes.hasValue(R$styleable.MaterialButton_android_background)) {
                materialButtonHelper2.backgroundOverwritten = true;
                materialButtonHelper2.materialButton.setSupportBackgroundTintList(materialButtonHelper2.backgroundTint);
                materialButtonHelper2.materialButton.setSupportBackgroundTintMode(materialButtonHelper2.backgroundTintMode);
            } else {
                materialButtonHelper2.updateBackground();
            }
            materialButtonHelper2.materialButton.setPaddingRelative(paddingStart + materialButtonHelper2.insetLeft, paddingTop + materialButtonHelper2.insetTop, paddingEnd + materialButtonHelper2.insetRight, paddingBottom + materialButtonHelper2.insetBottom);
            obtainStyledAttributes.recycle();
            setCompoundDrawablePadding(this.iconPadding);
            updateIcon(this.icon != null ? true : z);
            return;
        }
        throw null;
    }
}
