package com.google.android.material.navigationrail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.R$attr;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;

public class NavigationRailView extends NavigationBarView {
    public View headerView;
    public final int topMargin;

    public NavigationRailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.navigationRailStyle);
    }

    private NavigationRailMenuView getNavigationRailMenuView() {
        return (NavigationRailMenuView) getMenuView();
    }

    public NavigationBarMenuView createNavigationBarMenuView(Context context) {
        return new NavigationRailMenuView(context);
    }

    public View getHeaderView() {
        return this.headerView;
    }

    public int getMaxItemCount() {
        return 7;
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        NavigationRailMenuView navigationRailMenuView = getNavigationRailMenuView();
        View view = this.headerView;
        boolean z2 = true;
        int i5 = 0;
        if ((view == null || view.getVisibility() == 8) ? false : true) {
            int bottom = this.headerView.getBottom() + this.topMargin;
            int top = navigationRailMenuView.getTop();
            if (top < bottom) {
                i5 = bottom - top;
            }
        } else {
            if ((navigationRailMenuView.layoutParams.gravity & 112) != 48) {
                z2 = false;
            }
            if (z2) {
                i5 = this.topMargin;
            }
        }
        if (i5 > 0) {
            navigationRailMenuView.layout(navigationRailMenuView.getLeft(), navigationRailMenuView.getTop() + i5, navigationRailMenuView.getRight(), navigationRailMenuView.getBottom() + i5);
        }
    }

    public void onMeasure(int i, int i2) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        if (MeasureSpec.getMode(i) != 1073741824 && suggestedMinimumWidth > 0) {
            i = MeasureSpec.makeMeasureSpec(Math.min(MeasureSpec.getSize(i), getPaddingRight() + getPaddingLeft() + suggestedMinimumWidth), 1073741824);
        }
        super.onMeasure(i, i2);
        View view = this.headerView;
        if ((view == null || view.getVisibility() == 8) ? false : true) {
            measureChild(getNavigationRailMenuView(), i, MeasureSpec.makeMeasureSpec((getMeasuredHeight() - this.headerView.getMeasuredHeight()) - this.topMargin, LinearLayoutManager.INVALID_OFFSET));
        }
    }

    public void setMenuGravity(int i) {
        getNavigationRailMenuView().setMenuGravity(i);
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public NavigationRailView(android.content.Context r7, android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = com.google.android.material.R$style.Widget_MaterialComponents_NavigationRailView
            r6.<init>(r7, r8, r9, r4)
            android.content.res.Resources r7 = r6.getResources()
            int r0 = com.google.android.material.R$dimen.mtrl_navigation_rail_margin
            int r7 = r7.getDimensionPixelSize(r0)
            r6.topMargin = r7
            android.content.Context r0 = r6.getContext()
            int[] r2 = com.google.android.material.R$styleable.NavigationRailView
            r7 = 0
            int[] r5 = new int[r7]
            r1 = r8
            r3 = r9
            androidx.appcompat.widget.TintTypedArray r8 = com.google.android.material.internal.ThemeEnforcement.obtainTintedStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r9 = com.google.android.material.R$styleable.NavigationRailView_headerLayout
            int r9 = r8.getResourceId(r9, r7)
            r0 = 49
            if (r9 == 0) goto L_0x0051
            android.content.Context r1 = r6.getContext()
            android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r1)
            android.view.View r9 = r1.inflate(r9, r6, r7)
            android.view.View r1 = r6.headerView
            if (r1 == 0) goto L_0x0040
            r6.removeView(r1)
            r1 = 0
            r6.headerView = r1
        L_0x0040:
            r6.headerView = r9
            android.widget.FrameLayout$LayoutParams r1 = new android.widget.FrameLayout$LayoutParams
            r2 = -2
            r1.<init>(r2, r2)
            r1.gravity = r0
            int r2 = r6.topMargin
            r1.topMargin = r2
            r6.addView(r9, r7, r1)
        L_0x0051:
            int r7 = com.google.android.material.R$styleable.NavigationRailView_menuGravity
            int r7 = r8.getInt(r7, r0)
            r6.setMenuGravity(r7)
            android.content.res.TypedArray r7 = r8.mWrapped
            r7.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigationrail.NavigationRailView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
