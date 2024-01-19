package com.freshchat.consumer.sdk.a;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.freshchat.consumer.sdk.a.b.C0023b;
import com.freshchat.consumer.sdk.a.b.a;
import com.freshchat.consumer.sdk.beans.ICategory;
import com.freshchat.consumer.sdk.f.e;
import com.freshchat.consumer.sdk.service.Status;
import java.util.List;

public class q<T extends ICategory> extends b<T> {
    public final v qO;

    public q(Context context, List<T> list, boolean z, a aVar, e eVar) {
        super(context, list, z, aVar);
        this.qO = new r(this, this, eVar);
    }

    public int getItemCount() {
        return this.qO.getItemCount();
    }

    public int getItemViewType(int i) {
        return this.qO.getItemViewType(i);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        if (viewHolder instanceof C0023b) {
            super.onBindViewHolder(viewHolder, i);
        } else {
            this.qO.onBindViewHolder(viewHolder, i);
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 0 ? super.onCreateViewHolder(viewGroup, i) : this.qO.onCreateViewHolder(viewGroup, i);
    }

    public void setStatus(Status status) {
        this.qO.setStatus(status);
    }
}
