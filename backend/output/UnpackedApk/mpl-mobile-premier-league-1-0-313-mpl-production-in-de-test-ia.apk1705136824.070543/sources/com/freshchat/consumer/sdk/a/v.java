package com.freshchat.consumer.sdk.a;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.a.a.a;
import com.freshchat.consumer.sdk.a.a.b;
import com.freshchat.consumer.sdk.f.e;
import com.freshchat.consumer.sdk.service.Status;

public abstract class v {
    public final e po;
    public final Adapter qU;
    public Status status = Status.INIT_LOADING;

    public v(Adapter adapter, e eVar) {
        this.qU = adapter;
        this.po = eVar;
    }

    private boolean iJ() {
        Status status2 = this.status;
        return status2 == Status.ERROR || status2 == Status.NO_INTERNET || status2 == Status.LOADING_MORE || status2 == Status.SUCCESS;
    }

    public int getItemCount() {
        int iH = iH();
        return iH > 0 ? iH + (iJ() ? 1 : 0) : iH;
    }

    public int getItemViewType(int i) {
        if (i != iH()) {
            return 0;
        }
        Status status2 = this.status;
        return (status2 == Status.ERROR || status2 == Status.NO_INTERNET) ? 2 : 1;
    }

    public abstract int iH();

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        if (viewHolder instanceof a) {
            this.status = Status.LOADING_MORE;
        } else if (viewHolder instanceof b) {
            ((b) viewHolder).a(this.status, this.po);
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return (i == 2 || this.status == Status.NO_INTERNET) ? new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.freshchat_li_pagination_error_with_retry, viewGroup, false)) : new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.freshchat_faq_load_more, viewGroup, false));
    }

    public void setStatus(Status status2) {
        if (this.status != status2) {
            this.status = status2;
            this.qU.notifyDataSetChanged();
        }
    }
}
