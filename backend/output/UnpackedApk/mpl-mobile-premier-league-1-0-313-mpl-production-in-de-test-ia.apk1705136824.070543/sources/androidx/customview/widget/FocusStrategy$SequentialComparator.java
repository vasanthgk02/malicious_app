package androidx.customview.widget;

import android.graphics.Rect;
import androidx.customview.widget.ExploreByTouchHelper.AnonymousClass1;
import java.util.Comparator;

public class FocusStrategy$SequentialComparator<T> implements Comparator<T> {
    public final FocusStrategy$BoundsAdapter<T> mAdapter;
    public final boolean mIsLayoutRtl;
    public final Rect mTemp1 = new Rect();
    public final Rect mTemp2 = new Rect();

    public FocusStrategy$SequentialComparator(boolean z, FocusStrategy$BoundsAdapter<T> focusStrategy$BoundsAdapter) {
        this.mIsLayoutRtl = z;
        this.mAdapter = focusStrategy$BoundsAdapter;
    }

    public int compare(T t, T t2) {
        Rect rect = this.mTemp1;
        Rect rect2 = this.mTemp2;
        ((AnonymousClass1) this.mAdapter).obtainBounds(t, rect);
        ((AnonymousClass1) this.mAdapter).obtainBounds(t2, rect2);
        int i = rect.top;
        int i2 = rect2.top;
        int i3 = -1;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        int i4 = rect.left;
        int i5 = rect2.left;
        if (i4 < i5) {
            if (this.mIsLayoutRtl) {
                i3 = 1;
            }
            return i3;
        } else if (i4 > i5) {
            if (!this.mIsLayoutRtl) {
                i3 = 1;
            }
            return i3;
        } else {
            int i6 = rect.bottom;
            int i7 = rect2.bottom;
            if (i6 < i7) {
                return -1;
            }
            if (i6 > i7) {
                return 1;
            }
            int i8 = rect.right;
            int i9 = rect2.right;
            if (i8 < i9) {
                if (this.mIsLayoutRtl) {
                    i3 = 1;
                }
                return i3;
            } else if (i8 <= i9) {
                return 0;
            } else {
                if (!this.mIsLayoutRtl) {
                    i3 = 1;
                }
                return i3;
            }
        }
    }
}
