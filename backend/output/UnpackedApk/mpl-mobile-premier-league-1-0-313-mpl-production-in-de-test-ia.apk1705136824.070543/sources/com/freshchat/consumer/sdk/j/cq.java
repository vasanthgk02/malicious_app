package com.freshchat.consumer.sdk.j;

import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView.Adapter;

public abstract class cq implements ListUpdateCallback {
    public final Adapter lo;

    public cq(Adapter adapter) {
        this.lo = adapter;
    }

    public abstract void ht();

    public void onChanged(int i, int i2, Object obj) {
        this.lo.notifyItemRangeChanged(i, i2, obj);
        ht();
    }

    public void onInserted(int i, int i2) {
        this.lo.notifyItemRangeInserted(i, i2);
        ht();
    }

    public void onMoved(int i, int i2) {
        this.lo.notifyItemMoved(i, i2);
        ht();
    }

    public void onRemoved(int i, int i2) {
        this.lo.notifyItemRangeRemoved(i, i2);
        ht();
    }
}
