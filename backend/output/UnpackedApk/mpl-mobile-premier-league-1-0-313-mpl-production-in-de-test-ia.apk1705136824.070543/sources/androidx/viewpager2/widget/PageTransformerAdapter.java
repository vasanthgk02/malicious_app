package androidx.viewpager2.widget;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback;
import androidx.viewpager2.widget.ViewPager2.PageTransformer;
import java.util.Locale;

public final class PageTransformerAdapter extends OnPageChangeCallback {
    public final LinearLayoutManager mLayoutManager;
    public PageTransformer mPageTransformer;

    public PageTransformerAdapter(LinearLayoutManager linearLayoutManager) {
        this.mLayoutManager = linearLayoutManager;
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f2, int i2) {
        if (this.mPageTransformer != null) {
            float f3 = -f2;
            int i3 = 0;
            while (i3 < this.mLayoutManager.getChildCount()) {
                View childAt = this.mLayoutManager.getChildAt(i3);
                if (childAt != null) {
                    this.mPageTransformer.transformPage(childAt, ((float) (this.mLayoutManager.getPosition(childAt) - i)) + f3);
                    i3++;
                } else {
                    throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", new Object[]{Integer.valueOf(i3), Integer.valueOf(this.mLayoutManager.getChildCount())}));
                }
            }
        }
    }

    public void onPageSelected(int i) {
    }
}
