package com.facebook.react.views.scroll;

import android.os.SystemClock;
import androidx.recyclerview.widget.LinearLayoutManager;

public class OnScrollDispatchHelper {
    public long mLastScrollEventTimeMs = -11;
    public int mPrevX = LinearLayoutManager.INVALID_OFFSET;
    public int mPrevY = LinearLayoutManager.INVALID_OFFSET;
    public float mXFlingVelocity = 0.0f;
    public float mYFlingVelocity = 0.0f;

    public boolean onScrollChanged(int i, int i2) {
        long uptimeMillis = SystemClock.uptimeMillis();
        boolean z = (uptimeMillis - this.mLastScrollEventTimeMs <= 10 && this.mPrevX == i && this.mPrevY == i2) ? false : true;
        long j = this.mLastScrollEventTimeMs;
        if (uptimeMillis - j != 0) {
            this.mXFlingVelocity = ((float) (i - this.mPrevX)) / ((float) (uptimeMillis - j));
            this.mYFlingVelocity = ((float) (i2 - this.mPrevY)) / ((float) (uptimeMillis - j));
        }
        this.mLastScrollEventTimeMs = uptimeMillis;
        this.mPrevX = i;
        this.mPrevY = i2;
        return z;
    }
}
