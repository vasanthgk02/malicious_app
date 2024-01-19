package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;

public class NavigationRailMenuView extends NavigationBarMenuView {
    public final LayoutParams layoutParams;

    public NavigationRailMenuView(Context context) {
        super(context);
        LayoutParams layoutParams2 = new LayoutParams(-1, -2);
        this.layoutParams = layoutParams2;
        layoutParams2.gravity = 49;
        setLayoutParams(layoutParams2);
    }

    public NavigationBarItemView createNavigationBarItemView(Context context) {
        return new NavigationRailItemView(context);
    }

    public int getMenuGravity() {
        return this.layoutParams.gravity;
    }

    public final int makeSharedHeightSpec(int i, int i2, int i3) {
        return MeasureSpec.makeMeasureSpec(Math.min(MeasureSpec.getSize(i), i2 / Math.max(1, i3)), 0);
    }

    public final int measureSharedChildHeights(int i, int i2, int i3, View view) {
        int i4;
        int i5;
        makeSharedHeightSpec(i, i2, i3);
        if (view == null) {
            i4 = makeSharedHeightSpec(i, i2, i3);
        } else {
            i4 = MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0);
        }
        int childCount = getChildCount();
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt != view) {
                if (childAt.getVisibility() != 8) {
                    childAt.measure(i, i4);
                    i5 = childAt.getMeasuredHeight();
                } else {
                    i5 = 0;
                }
                i6 += i5;
            }
        }
        return i6;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                int measuredHeight = childAt.getMeasuredHeight() + i6;
                childAt.layout(0, i6, i5, measuredHeight);
                i6 = measuredHeight;
            }
        }
    }

    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int size = MeasureSpec.getSize(i2);
        int size2 = getMenu().getVisibleItems().size();
        if (size2 <= 1 || !isShifting(getLabelVisibilityMode(), size2)) {
            i3 = measureSharedChildHeights(i, size, size2, null);
        } else {
            View childAt = getChildAt(getSelectedItemPosition());
            if (childAt != null) {
                int makeSharedHeightSpec = makeSharedHeightSpec(i, size, size2);
                if (childAt.getVisibility() != 8) {
                    childAt.measure(i, makeSharedHeightSpec);
                    i4 = childAt.getMeasuredHeight();
                } else {
                    i4 = 0;
                }
                size -= i4;
                size2--;
            } else {
                i4 = 0;
            }
            i3 = measureSharedChildHeights(i, size, size2, childAt) + i4;
        }
        setMeasuredDimension(View.resolveSizeAndState(MeasureSpec.getSize(i), i, 0), View.resolveSizeAndState(i3, i2, 0));
    }

    public void setMenuGravity(int i) {
        LayoutParams layoutParams2 = this.layoutParams;
        if (layoutParams2.gravity != i) {
            layoutParams2.gravity = i;
            setLayoutParams(layoutParams2);
        }
    }
}
