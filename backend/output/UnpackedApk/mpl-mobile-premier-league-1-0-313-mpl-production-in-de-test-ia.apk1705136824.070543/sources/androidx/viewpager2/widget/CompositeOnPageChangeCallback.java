package androidx.viewpager2.widget;

import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public final class CompositeOnPageChangeCallback extends OnPageChangeCallback {
    public final List<OnPageChangeCallback> mCallbacks;

    public CompositeOnPageChangeCallback(int i) {
        this.mCallbacks = new ArrayList(i);
    }

    public void onPageScrollStateChanged(int i) {
        try {
            for (OnPageChangeCallback onPageScrollStateChanged : this.mCallbacks) {
                onPageScrollStateChanged.onPageScrollStateChanged(i);
            }
        } catch (ConcurrentModificationException e2) {
            throwCallbackListModifiedWhileInUse(e2);
            throw null;
        }
    }

    public void onPageScrolled(int i, float f2, int i2) {
        try {
            for (OnPageChangeCallback onPageScrolled : this.mCallbacks) {
                onPageScrolled.onPageScrolled(i, f2, i2);
            }
        } catch (ConcurrentModificationException e2) {
            throwCallbackListModifiedWhileInUse(e2);
            throw null;
        }
    }

    public void onPageSelected(int i) {
        try {
            for (OnPageChangeCallback onPageSelected : this.mCallbacks) {
                onPageSelected.onPageSelected(i);
            }
        } catch (ConcurrentModificationException e2) {
            throwCallbackListModifiedWhileInUse(e2);
            throw null;
        }
    }

    public final void throwCallbackListModifiedWhileInUse(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }
}
