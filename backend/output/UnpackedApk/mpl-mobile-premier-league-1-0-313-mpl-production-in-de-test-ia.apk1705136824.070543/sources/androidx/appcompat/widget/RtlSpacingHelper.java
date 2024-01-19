package androidx.appcompat.widget;

import androidx.recyclerview.widget.LinearLayoutManager;

public class RtlSpacingHelper {
    public int mEnd = LinearLayoutManager.INVALID_OFFSET;
    public int mExplicitLeft = 0;
    public int mExplicitRight = 0;
    public boolean mIsRelative = false;
    public boolean mIsRtl = false;
    public int mLeft = 0;
    public int mRight = 0;
    public int mStart = LinearLayoutManager.INVALID_OFFSET;

    public void setRelative(int i, int i2) {
        this.mStart = i;
        this.mEnd = i2;
        this.mIsRelative = true;
        if (this.mIsRtl) {
            if (i2 != Integer.MIN_VALUE) {
                this.mLeft = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.mRight = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.mLeft = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.mRight = i2;
        }
    }
}
