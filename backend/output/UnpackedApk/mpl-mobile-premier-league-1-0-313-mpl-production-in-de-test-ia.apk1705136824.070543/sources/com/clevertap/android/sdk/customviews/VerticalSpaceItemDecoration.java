package com.clevertap.android.sdk.customviews;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.State;

public class VerticalSpaceItemDecoration extends ItemDecoration {
    public final int verticalSpaceHeight;

    public VerticalSpaceItemDecoration(int i) {
        this.verticalSpaceHeight = i;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        rect.bottom = this.verticalSpaceHeight;
    }
}
