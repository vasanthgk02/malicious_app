package com.freshchat.consumer.sdk.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.freshchat.consumer.sdk.FreshchatImageLoader;
import com.freshchat.consumer.sdk.FreshchatImageLoaderRequest;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.beans.ICategory;
import com.freshchat.consumer.sdk.j.af;
import com.freshchat.consumer.sdk.j.ah;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.aw;
import java.util.List;

public class b<T extends ICategory> extends Adapter<ViewHolder> {
    public final List<T> ah;
    public final boolean ch;
    public final boolean ci;
    public final a cj;
    public final Context context;

    public interface a {
        void a(View view, int i);
    }

    /* renamed from: com.freshchat.consumer.sdk.a.b$b  reason: collision with other inner class name */
    public static class C0023b extends ViewHolder {
        public final View cm;
        public final TextView cn;

        /* renamed from: co  reason: collision with root package name */
        public final TextView f1712co;
        public final ImageView cp;
        public final TextView cq;

        public C0023b(View view, boolean z) {
            super(view);
            this.cm = view;
            this.cn = (TextView) view.findViewById(R.id.freshchat_category_name);
            this.cp = (ImageView) view.findViewById(R.id.freshchat_category_icon);
            this.cq = (TextView) view.findViewById(R.id.freshchat_category_icon_alt_text);
            this.f1712co = z ? (TextView) view.findViewById(R.id.freshchat_category_desc) : null;
        }

        public TextView aN() {
            return this.cn;
        }

        public TextView aO() {
            return this.f1712co;
        }

        public ImageView aP() {
            return this.cp;
        }

        public TextView aQ() {
            return this.cq;
        }

        public View getRootView() {
            return this.cm;
        }
    }

    public b(Context context2, List<T> list, boolean z, a aVar) {
        this.cj = aVar;
        this.context = context2;
        this.ah = list;
        this.ch = z;
        this.ci = !z;
    }

    public int getItemCount() {
        List<T> list = this.ah;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        String str;
        TextView textView;
        int i2;
        TextView textView2;
        ICategory iCategory = (ICategory) this.ah.get(i);
        C0023b bVar = (C0023b) viewHolder;
        bVar.aN().setText(iCategory.getTitle());
        if (aw.eX()) {
            if (this.ch) {
                textView2 = bVar.aN();
                i2 = 4;
            } else {
                textView2 = bVar.aN();
                i2 = 5;
            }
            textView2.setTextAlignment(i2);
            bVar.aN().setTextDirection(ah.getTextDirection());
        }
        if (this.ci) {
            if (!TextUtils.isEmpty(iCategory.getDescription())) {
                textView = bVar.aO();
                str = iCategory.getDescription();
            } else {
                textView = bVar.aO();
                str = "";
            }
            textView.setText(str);
        }
        if (!as.isEmpty(iCategory.getIconUrl()) || !as.a(iCategory.getTitle())) {
            bVar.aP().setVisibility(0);
            bVar.aQ().setVisibility(8);
            int dimensionPixelSize = this.context.getResources().getDimensionPixelSize(R.dimen.freshchat_category_icon_size);
            FreshchatImageLoaderRequest dM = new com.freshchat.consumer.sdk.FreshchatImageLoaderRequest.a(iCategory.getIconUrl()).a(dimensionPixelSize, dimensionPixelSize).dM();
            FreshchatImageLoader eK = af.eK();
            if (eK != null) {
                eK.load(dM, bVar.aP());
            }
        } else {
            bVar.aP().setVisibility(8);
            bVar.aQ().setVisibility(0);
            bVar.aQ().setText(iCategory.getTitle().substring(0, 1).toUpperCase(ah.bb(this.context)));
        }
        bVar.getRootView().setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                b.this.cj.a(view, i);
            }
        });
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        int i2 = R.layout.freshchat_listitem_category;
        if (this.ch) {
            i2 = R.layout.freshchat_listitem_category_for_grid;
        }
        return new C0023b(LayoutInflater.from(viewGroup.getContext()).inflate(i2, viewGroup, false), this.ci);
    }
}
