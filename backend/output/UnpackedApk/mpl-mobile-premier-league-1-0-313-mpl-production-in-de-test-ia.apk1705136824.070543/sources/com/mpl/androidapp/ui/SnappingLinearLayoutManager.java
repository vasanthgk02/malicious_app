package com.mpl.androidapp.ui;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.State;

public class SnappingLinearLayoutManager extends LinearLayoutManager {
    public final float scrollValue;

    public SnappingLinearLayoutManager(Context context, int i, boolean z, float f2) {
        super(context, i, z);
        this.scrollValue = f2;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, State state, int i) {
        AnonymousClass1 r2 = new LinearSmoothScroller(recyclerView.getContext()) {
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return SnappingLinearLayoutManager.this.scrollValue / ((float) displayMetrics.densityDpi);
            }

            public PointF computeScrollVectorForPosition(int i) {
                return super.computeScrollVectorForPosition(i);
            }
        };
        r2.setTargetPosition(i);
        startSmoothScroll(r2);
    }
}
