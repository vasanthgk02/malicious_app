package com.paynimo.android.payment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.viewpager.widget.ViewPager;

public class CustomPager extends ViewPager {
    public View mCurrentView;

    public CustomPager(Context context) {
        super(context);
    }

    public void measureCurrentView(View view) {
        this.mCurrentView = view;
        requestLayout();
    }

    public int measureFragment(View view) {
        if (view == null) {
            return 0;
        }
        view.measure(0, 0);
        return view.getMeasuredHeight();
    }

    public void onMeasure(int i, int i2) {
        View view = this.mCurrentView;
        if (view == null) {
            super.onMeasure(i, i2);
            return;
        }
        int i3 = 0;
        view.measure(i, MeasureSpec.makeMeasureSpec(0, 0));
        int measuredHeight = this.mCurrentView.getMeasuredHeight();
        if (measuredHeight > 0) {
            i3 = measuredHeight;
        }
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(i3, 1073741824));
    }

    public CustomPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
