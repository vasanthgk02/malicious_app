package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.animation.AnimationUtils;

public class ElasticTabIndicatorInterpolator extends TabIndicatorInterpolator {
    public static float accInterp(float f2) {
        return (float) (1.0d - Math.cos((((double) f2) * 3.141592653589793d) / 2.0d));
    }

    public void setIndicatorBoundsForOffset(TabLayout tabLayout, View view, View view2, float f2, Drawable drawable) {
        float f3;
        float f4;
        RectF calculateIndicatorWidthForTab = TabIndicatorInterpolator.calculateIndicatorWidthForTab(tabLayout, view);
        RectF calculateIndicatorWidthForTab2 = TabIndicatorInterpolator.calculateIndicatorWidthForTab(tabLayout, view2);
        if (calculateIndicatorWidthForTab.left < calculateIndicatorWidthForTab2.left) {
            f4 = accInterp(f2);
            f3 = (float) Math.sin((((double) f2) * 3.141592653589793d) / 2.0d);
        } else {
            f4 = (float) Math.sin((((double) f2) * 3.141592653589793d) / 2.0d);
            f3 = accInterp(f2);
        }
        drawable.setBounds(AnimationUtils.lerp((int) calculateIndicatorWidthForTab.left, (int) calculateIndicatorWidthForTab2.left, f4), drawable.getBounds().top, AnimationUtils.lerp((int) calculateIndicatorWidthForTab.right, (int) calculateIndicatorWidthForTab2.right, f3), drawable.getBounds().bottom);
    }
}
