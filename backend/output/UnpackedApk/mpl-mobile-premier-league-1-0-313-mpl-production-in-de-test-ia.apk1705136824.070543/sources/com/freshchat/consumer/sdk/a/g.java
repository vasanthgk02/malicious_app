package com.freshchat.consumer.sdk.a;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.freshchat.consumer.sdk.beans.fragment.CarouselCardDefaultFragment;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.ui.CarouselCardView;
import java.util.Collection;
import java.util.List;

public class g extends Adapter<a> {
    public final Context context;
    public final List<MessageFragment> fragments;
    public final com.freshchat.consumer.sdk.ui.CarouselCardView.a lR;

    public class a extends ViewHolder {
        public final CarouselCardView lT;

        public a(CarouselCardView carouselCardView) {
            super(carouselCardView);
            this.lT = carouselCardView;
        }
    }

    public g(Context context2, List<MessageFragment> list, com.freshchat.consumer.sdk.ui.CarouselCardView.a aVar) {
        this.context = context2;
        this.fragments = list;
        this.lR = aVar;
    }

    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        aVar.lT.setData((CarouselCardDefaultFragment) this.fragments.get(i));
    }

    /* renamed from: c */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        a aVar = new a(new CarouselCardView(this.context));
        aVar.lT.setListener(this.lR);
        return aVar;
    }

    public int getItemCount() {
        return k.b((Collection<?>) this.fragments);
    }
}
