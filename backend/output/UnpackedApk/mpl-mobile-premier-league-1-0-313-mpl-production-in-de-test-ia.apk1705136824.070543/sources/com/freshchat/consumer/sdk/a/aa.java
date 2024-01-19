package com.freshchat.consumer.sdk.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.beans.fragment.QuickReplyButtonFragment;
import com.freshchat.consumer.sdk.j.k;
import java.util.List;

public class aa extends Adapter<b> {
    public final Context context;
    public final List<MessageFragment> sB;
    public final a sC;

    public interface a {
        void bL(String str);
    }

    public class b extends ViewHolder {
        public final Button sF;
        public final FrameLayout sH;

        public b(View view) {
            super(view);
            this.sH = (FrameLayout) view.findViewById(R.id.freshchat_quick_action_button_parent_view);
            this.sF = (Button) view.findViewById(R.id.freshchat_quick_action_button);
        }

        /* access modifiers changed from: private */
        public FrameLayout ks() {
            return this.sH;
        }

        /* access modifiers changed from: private */
        public Button kt() {
            return this.sF;
        }
    }

    public aa(Context context2, List<MessageFragment> list, a aVar) {
        this.sB = list;
        this.sC = aVar;
        this.context = context2;
    }

    /* renamed from: a */
    public void onBindViewHolder(b bVar, int i) {
        Button a2 = bVar.kt();
        if (k.a(this.sB)) {
            MessageFragment messageFragment = this.sB.get(i);
            if (messageFragment instanceof QuickReplyButtonFragment) {
                String label = ((QuickReplyButtonFragment) messageFragment).getLabel();
                if (label.length() > 30) {
                    a2.setText(label.substring(0, 30) + "...");
                } else {
                    a2.setText(label);
                }
                bVar.ks().setOnClickListener(new ab(this, label));
            }
        }
    }

    /* renamed from: d */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(this.context).inflate(R.layout.freshchat_quick_actions_button, viewGroup, false));
    }

    public int getItemCount() {
        if (k.a(this.sB)) {
            return this.sB.size();
        }
        return 0;
    }
}
