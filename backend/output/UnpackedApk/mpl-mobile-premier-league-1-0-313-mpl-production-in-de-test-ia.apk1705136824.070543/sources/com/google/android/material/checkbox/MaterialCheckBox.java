package com.google.android.material.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class MaterialCheckBox extends AppCompatCheckBox {
    public static final int DEF_STYLE_RES = R$style.Widget_MaterialComponents_CompoundButton_CheckBox;
    public static final int[][] ENABLED_CHECKED_STATES = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};
    public ColorStateList materialThemeColorsTintList;
    public boolean useMaterialThemeColors;

    public MaterialCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.checkboxStyle);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.materialThemeColorsTintList == null) {
            int[] iArr = new int[ENABLED_CHECKED_STATES.length];
            int color = ImageOriginUtils.getColor(this, R$attr.colorControlActivated);
            int color2 = ImageOriginUtils.getColor(this, R$attr.colorSurface);
            int color3 = ImageOriginUtils.getColor(this, R$attr.colorOnSurface);
            iArr[0] = ImageOriginUtils.layer(color2, color, 1.0f);
            iArr[1] = ImageOriginUtils.layer(color2, color3, 0.54f);
            iArr[2] = ImageOriginUtils.layer(color2, color3, 0.38f);
            iArr[3] = ImageOriginUtils.layer(color2, color3, 0.38f);
            this.materialThemeColorsTintList = new ColorStateList(ENABLED_CHECKED_STATES, iArr);
        }
        return this.materialThemeColorsTintList;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.useMaterialThemeColors && getButtonTintList() == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.useMaterialThemeColors = z;
        if (z) {
            setButtonTintList(getMaterialThemeColorsTintList());
        } else {
            setButtonTintList(null);
        }
    }

    public MaterialCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R$styleable.MaterialCheckBox, i, DEF_STYLE_RES, new int[0]);
        if (obtainStyledAttributes.hasValue(R$styleable.MaterialCheckBox_buttonTint)) {
            setButtonTintList(ImageOriginUtils.getColorStateList(context2, obtainStyledAttributes, R$styleable.MaterialCheckBox_buttonTint));
        }
        this.useMaterialThemeColors = obtainStyledAttributes.getBoolean(R$styleable.MaterialCheckBox_useMaterialThemeColors, false);
        obtainStyledAttributes.recycle();
    }
}
