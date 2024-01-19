package com.paynimo.android.payment.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.paynimo.android.payment.model.response.k.g;
import java.util.ArrayList;

public class b extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f1345a;

    /* renamed from: b  reason: collision with root package name */
    public LayoutInflater f1346b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<g> f1347c;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f1348a;
    }

    public b(Context context, int i, ArrayList<g> arrayList) {
        this.f1345a = context;
        this.f1346b = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f1347c = arrayList;
    }

    public int getCount() {
        return this.f1347c.size();
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        View dropDownView = super.getDropDownView(i, view, viewGroup);
        TextView textView = (TextView) dropDownView.findViewById(this.f1345a.getResources().getIdentifier("paynimo_txt_bank_name", "id", this.f1345a.getPackageName()));
        if (this.f1347c.get(i).isHeader()) {
            textView.setTextColor(-7829368);
        } else {
            textView.setTextColor(-16777216);
        }
        return dropDownView;
    }

    public Object getItem(int i) {
        return this.f1347c.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            a aVar2 = new a();
            View inflate = this.f1346b.inflate(this.f1345a.getResources().getIdentifier("paynimo_spinner_bank_row", "layout", this.f1345a.getPackageName()), null);
            aVar2.f1348a = (TextView) inflate.findViewById(this.f1345a.getResources().getIdentifier("paynimo_txt_bank_name", "id", this.f1345a.getPackageName()));
            inflate.setTag(aVar2);
            View view2 = inflate;
            aVar = aVar2;
            view = view2;
        } else {
            aVar = (a) view.getTag();
            view.setTag(aVar);
        }
        aVar.f1348a.setText(this.f1347c.get(i).getBankName());
        return view;
    }

    public boolean isEnabled(int i) {
        return !this.f1347c.get(i).isHeader();
    }
}
