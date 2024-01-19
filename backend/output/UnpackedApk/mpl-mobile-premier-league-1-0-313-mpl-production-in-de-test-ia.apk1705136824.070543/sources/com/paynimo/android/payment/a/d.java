package com.paynimo.android.payment.a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.paynimo.android.payment.model.response.k.c;
import java.util.ArrayList;

public class d extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Activity f1357a;

    /* renamed from: b  reason: collision with root package name */
    public int f1358b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<c> f1359c;

    /* renamed from: d  reason: collision with root package name */
    public LayoutInflater f1360d = null;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f1361a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f1362b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f1363c;
    }

    public d(Activity activity, int i, ArrayList<c> arrayList) {
        this.f1357a = activity;
        this.f1358b = i;
        this.f1359c = arrayList;
        this.f1360d = (LayoutInflater) activity.getSystemService("layout_inflater");
    }

    public int getCount() {
        return this.f1359c.size();
    }

    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.f1360d.inflate(this.f1358b, null);
            aVar = new a();
            aVar.f1361a = (TextView) view.findViewById(this.f1357a.getResources().getIdentifier("paynimo_list_card_bankname_label", "id", this.f1357a.getPackageName()));
            aVar.f1362b = (TextView) view.findViewById(this.f1357a.getResources().getIdentifier("paynimo_list_card_cardno_label", "id", this.f1357a.getPackageName()));
            aVar.f1363c = (ImageView) view.findViewById(this.f1357a.getResources().getIdentifier("paynimo_list_card_icon", "id", this.f1357a.getPackageName()));
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        c cVar = this.f1359c.get(i);
        if (cVar != null) {
            String aliasName = cVar.getAliasName();
            String maskedCardNo = cVar.getMaskedCardNo();
            if (aliasName != null && !aliasName.isEmpty() && maskedCardNo != null && !maskedCardNo.isEmpty()) {
                aVar.f1361a.setText(aliasName);
                aVar.f1362b.setText(maskedCardNo);
                ImageView imageView = aVar.f1363c;
                GeneratedOutlineSupport.outline92(this.f1357a, this.f1357a.getResources(), "paynimo_imps_icon", "drawable", imageView);
            }
        }
        return view;
    }
}
