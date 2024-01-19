package com.freshchat.consumer.sdk.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.beans.fragment.StaticTemplateFragment;
import com.freshchat.consumer.sdk.j.k;
import java.util.Collection;
import java.util.List;

public class w extends Adapter<a> {
    public final List<StaticTemplateFragment> fragments;
    public final b jA;
    public final String jB;

    public static class a extends ViewHolder {
        public final TextView jE;
        public final View jF;

        public a(View view) {
            super(view);
            this.jE = (TextView) view.findViewById(R.id.freshchat_label_text);
            this.jF = view.findViewById(R.id.freshchat_bot_list_view_divider);
        }

        public TextView fg() {
            return this.jE;
        }

        public View fh() {
            return this.jF;
        }
    }

    public interface b {
        void a(View view, StaticTemplateFragment staticTemplateFragment, String str);
    }

    public w(List<StaticTemplateFragment> list, b bVar, String str) {
        this.fragments = list;
        this.jA = bVar;
        this.jB = str;
    }

    private StaticTemplateFragment w(int i) {
        if (k.a(this.fragments)) {
            return this.fragments.get(i);
        }
        return null;
    }

    /* renamed from: a */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.freshchat_list_item_bot_faq, viewGroup, false));
    }

    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        StaticTemplateFragment w = w(i);
        aVar.fg().setText(w.getLabel());
        aVar.itemView.setOnClickListener(new x(this, w));
        if (i == this.fragments.size() - 1) {
            aVar.fh().setVisibility(8);
        }
    }

    public int getItemCount() {
        return k.b((Collection<?>) this.fragments);
    }
}
