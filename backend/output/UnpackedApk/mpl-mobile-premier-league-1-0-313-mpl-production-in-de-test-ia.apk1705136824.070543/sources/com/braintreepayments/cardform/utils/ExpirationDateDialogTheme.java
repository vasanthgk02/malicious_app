package com.braintreepayments.cardform.utils;

import android.app.Activity;
import co.hyperverge.hypersnapsdk.c.k;
import com.braintreepayments.cardform.R$color;

public enum ExpirationDateDialogTheme {
    LIGHT(R$color.bt_black_87, R$color.bt_white_87, R$color.bt_black_38),
    DARK(R$color.bt_white_87, R$color.bt_black_87, R$color.bt_white_38);
    
    public final int mItemDisabledTextColor;
    public final int mItemInverseTextColor;
    public final int mItemTextColor;
    public int mResolvedItemDisabledTextColor;
    public int mResolvedItemInverseTextColor;
    public int mResolvedItemTextColor;
    public int mResolvedSelectedItemBackground;

    /* access modifiers changed from: public */
    ExpirationDateDialogTheme(int i, int i2, int i3) {
        this.mItemTextColor = i;
        this.mItemInverseTextColor = i2;
        this.mItemDisabledTextColor = i3;
    }

    public static ExpirationDateDialogTheme detectTheme(Activity activity) {
        ExpirationDateDialogTheme expirationDateDialogTheme;
        if (k.isDarkBackground(activity)) {
            expirationDateDialogTheme = DARK;
        } else {
            expirationDateDialogTheme = LIGHT;
        }
        expirationDateDialogTheme.mResolvedItemTextColor = activity.getResources().getColor(expirationDateDialogTheme.mItemTextColor);
        expirationDateDialogTheme.mResolvedItemInverseTextColor = k.getColor(activity, "textColorPrimaryInverse", expirationDateDialogTheme.mItemInverseTextColor);
        expirationDateDialogTheme.mResolvedItemDisabledTextColor = activity.getResources().getColor(expirationDateDialogTheme.mItemDisabledTextColor);
        expirationDateDialogTheme.mResolvedSelectedItemBackground = k.getColor(activity, "colorAccent", R$color.bt_blue);
        return expirationDateDialogTheme;
    }

    public int getItemDisabledTextColor() {
        return this.mResolvedItemDisabledTextColor;
    }

    public int getItemInvertedTextColor() {
        return this.mResolvedItemInverseTextColor;
    }

    public int getItemTextColor() {
        return this.mResolvedItemTextColor;
    }

    public int getSelectedItemBackground() {
        return this.mResolvedSelectedItemBackground;
    }
}
