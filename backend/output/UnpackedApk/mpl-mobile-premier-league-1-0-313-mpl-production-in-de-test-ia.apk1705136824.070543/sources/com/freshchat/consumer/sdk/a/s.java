package com.freshchat.consumer.sdk.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.beans.FAQ;
import com.freshchat.consumer.sdk.f.e;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.service.Status;
import java.util.List;

public class s extends Adapter<ViewHolder> {
    public final v qO;
    public final List<FAQ> qQ;
    public final b qR;

    public static class a extends ViewHolder {
        public TextView cg;

        public a(View view) {
            super(view);
            this.cg = (TextView) view.findViewById(R.id.freshchat_article_listitem_title);
        }

        public TextView iI() {
            return this.cg;
        }
    }

    public interface b {
        void d(View view, int i);
    }

    public s(List<FAQ> list, b bVar, e eVar) {
        this.qQ = list;
        this.qR = bVar;
        this.qO = new t(this, this, eVar, list);
    }

    private FAQ W(int i) {
        if (k.a(this.qQ)) {
            return this.qQ.get(i);
        }
        return null;
    }

    public int getItemCount() {
        return this.qO.getItemCount();
    }

    public int getItemViewType(int i) {
        return this.qO.getItemViewType(i);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        if (viewHolder instanceof a) {
            FAQ W = W(i);
            if (W != null) {
                a aVar = (a) viewHolder;
                aVar.iI().setText(W.getTitle());
                aVar.iI().setOnClickListener(new u(this, i));
                return;
            }
            return;
        }
        this.qO.onBindViewHolder(viewHolder, i);
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 0 ? new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.freshchat_listitem_article, viewGroup, false)) : this.qO.onCreateViewHolder(viewGroup, i);
    }

    public void setStatus(Status status) {
        this.qO.setStatus(status);
    }
}
