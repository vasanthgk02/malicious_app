package com.freshchat.consumer.sdk.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.beans.fragment.QuickReplyButtonFragment;
import com.freshchat.consumer.sdk.j.k;
import java.util.Collection;
import java.util.List;

public class e extends Adapter<b> {
    public final Context context;
    public final LayoutInflater cr;
    public final List<MessageFragment> mX;
    public final a mY;
    public final long originalMessageId;

    public interface a {
        void a(QuickReplyButtonFragment quickReplyButtonFragment, long j);
    }

    public class b extends ViewHolder {
        public final TextView nb;

        public b(View view) {
            super(view);
            this.nb = (TextView) view.findViewById(R.id.drop_down_list_item_text);
        }

        /* access modifiers changed from: private */
        public TextView gX() {
            return this.nb;
        }
    }

    public e(Context context2, List<MessageFragment> list, a aVar, long j) {
        this.mX = list;
        this.mY = aVar;
        this.cr = LayoutInflater.from(context2);
        this.originalMessageId = j;
        this.context = context2;
    }

    private MessageFragment F(int i) {
        if (k.isEmpty(this.mX)) {
            return null;
        }
        return this.mX.get(i);
    }

    /* renamed from: a */
    public void onBindViewHolder(b bVar, int i) {
        TextView a2 = bVar.gX();
        MessageFragment F = F(i);
        if (F instanceof QuickReplyButtonFragment) {
            com.freshchat.consumer.sdk.k.e eVar = new com.freshchat.consumer.sdk.k.e(this.context);
            eVar.b((QuickReplyButtonFragment) F);
            a2.setText(eVar.jL());
            bVar.gX().setOnClickListener(new f(this, F));
        }
    }

    /* renamed from: b */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new b(this.cr.inflate(R.layout.freshchat_listitem_dropdown, viewGroup, false));
    }

    public int getItemCount() {
        return k.b((Collection<?>) this.mX);
    }
}
