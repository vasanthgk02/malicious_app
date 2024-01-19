package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import com.google.android.material.navigation.NavigationBarItemView;

public final class NavigationRailItemView extends NavigationBarItemView {
    public NavigationRailItemView(Context context) {
        super(context);
    }

    public int getItemDefaultMarginResId() {
        return R$dimen.mtrl_navigation_rail_icon_margin;
    }

    public int getItemLayoutResId() {
        return R$layout.mtrl_navigation_rail_item;
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (MeasureSpec.getMode(i2) == 0) {
            setMeasuredDimension(getMeasuredWidthAndState(), View.resolveSizeAndState(Math.max(getMeasuredHeight(), MeasureSpec.getSize(i2)), i2, 0));
        }
    }
}
