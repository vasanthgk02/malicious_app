package com.google.android.material.datepicker;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.State;

public class SmoothCalendarLayoutManager extends LinearLayoutManager {
    public SmoothCalendarLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, State state, int i) {
        AnonymousClass1 r2 = new LinearSmoothScroller(this, recyclerView.getContext()) {
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 100.0f / ((float) displayMetrics.densityDpi);
            }
        };
        r2.setTargetPosition(i);
        startSmoothScroll(r2);
    }
}
