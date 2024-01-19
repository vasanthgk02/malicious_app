package com.paynimo.android.payment.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.paynimo.android.payment.model.request.t;
import java.util.ArrayList;
import java.util.List;

public class g extends Adapter<a> {

    /* renamed from: a  reason: collision with root package name */
    public List<t> f1397a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final b f1398b;

    public class a extends ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f1399a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f1400b;

        /* renamed from: com.paynimo.android.payment.a.g$a$a  reason: collision with other inner class name */
        public class C0017a implements OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f1401a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ t f1402b;

            public C0017a(a aVar, b bVar, t tVar) {
                this.f1401a = bVar;
                this.f1402b = tVar;
            }

            public void onClick(View view) {
                this.f1401a.onItemClick(this.f1402b);
            }
        }

        public a(g gVar, View view, Context context) {
            super(view);
            this.f1399a = (TextView) view.findViewById(context.getResources().getIdentifier("paynimo_txt_app_name", "id", context.getPackageName()));
            this.f1400b = (ImageView) view.findViewById(context.getResources().getIdentifier("paynimo_img_icon", "id", context.getPackageName()));
        }

        public void bind(t tVar, b bVar) {
            this.f1399a.setText(tVar.getName());
            this.f1400b.setImageDrawable(tVar.getDrawable());
            this.itemView.setOnClickListener(new C0017a(this, bVar, tVar));
        }
    }

    public interface b {
        void onItemClick(t tVar);
    }

    public g(Context context, List<t> list, b bVar) {
        this.f1397a = list;
        this.f1398b = bVar;
    }

    public int getItemCount() {
        return this.f1397a.size();
    }

    public long getItemId(int i) {
        return 0;
    }

    public void onBindViewHolder(a aVar, int i) {
        aVar.bind(this.f1397a.get(i), this.f1398b);
        aVar.f1399a.setText(this.f1397a.get(i).getName());
        aVar.f1400b.setImageDrawable(this.f1397a.get(i).getDrawable());
    }

    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        return new a(this, LayoutInflater.from(context).inflate(context.getResources().getIdentifier("paynimo_upi_list_row", "layout", context.getPackageName()), viewGroup, false), context);
    }
}
