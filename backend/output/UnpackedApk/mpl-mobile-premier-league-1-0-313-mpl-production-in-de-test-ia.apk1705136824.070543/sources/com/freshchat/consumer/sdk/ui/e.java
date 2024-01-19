package com.freshchat.consumer.sdk.ui;

import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.State;

public class e extends ItemDecoration {
    public final f pO;
    public int pP;

    public e(f fVar) {
        this.pO = fVar;
    }

    private View a(int i, RecyclerView recyclerView) {
        View inflate = LayoutInflater.from(recyclerView.getContext()).inflate(this.pO.N(i), recyclerView, false);
        this.pO.c(inflate, i);
        return inflate;
    }

    private View a(RecyclerView recyclerView, int i, int i2) {
        int i3 = 0;
        while (i3 < recyclerView.getChildCount()) {
            View childAt = recyclerView.getChildAt(i3);
            if ((childAt.getTop() > 0 ? childAt.getBottom() + ((i2 == i3 || !this.pO.O(recyclerView.getChildAdapterPosition(childAt))) ? 0 : this.pP - childAt.getHeight()) : childAt.getBottom()) > i && childAt.getTop() <= i) {
                return childAt;
            }
            i3++;
        }
        return null;
    }

    private void a(Canvas canvas, View view) {
        canvas.save();
        canvas.translate(0.0f, 0.0f);
        view.draw(canvas);
        canvas.restore();
    }

    private void a(Canvas canvas, View view, View view2) {
        canvas.save();
        canvas.translate(0.0f, (float) (view2.getTop() - view.getHeight()));
        view.draw(canvas);
        canvas.restore();
    }

    private void a(ViewGroup viewGroup, View view) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), 1073741824);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(viewGroup.getHeight(), 0);
        view.measure(ViewGroup.getChildMeasureSpec(makeMeasureSpec, viewGroup.getPaddingRight() + viewGroup.getPaddingLeft(), view.getLayoutParams().width), ViewGroup.getChildMeasureSpec(makeMeasureSpec2, viewGroup.getPaddingBottom() + viewGroup.getPaddingTop(), view.getLayoutParams().height));
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        this.pP = measuredHeight;
        view.layout(0, 0, measuredWidth, measuredHeight);
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, State state) {
        super.onDrawOver(canvas, recyclerView, state);
        View childAt = recyclerView.getChildAt(0);
        if (childAt != null) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
            if (childAdapterPosition != -1) {
                int M = this.pO.M(childAdapterPosition);
                View a2 = a(M, recyclerView);
                a((ViewGroup) recyclerView, a2);
                View a3 = a(recyclerView, a2.getBottom(), M);
                if (a3 == null || !this.pO.O(recyclerView.getChildAdapterPosition(a3))) {
                    a(canvas, a2);
                } else {
                    a(canvas, a2, a3);
                }
            }
        }
    }
}
