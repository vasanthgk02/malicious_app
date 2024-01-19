package com.freshchat.consumer.sdk.a;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class y extends ArrayAdapter {
    public Context context;
    public List<String> st;
    public List<String> su;
    public int sv;
    public int sw;
    public Filter sx;
    public boolean sy;
    public int sz;

    public class a extends Filter {
        public a() {
        }

        public FilterResults performFiltering(CharSequence charSequence) {
            int size;
            FilterResults filterResults = new FilterResults();
            if (y.this.sy) {
                ArrayList arrayList = new ArrayList();
                if (charSequence != null && charSequence.charAt(0) == '/') {
                    if (charSequence.length() == 1) {
                        List<String> list = y.this.st;
                        filterResults.values = list;
                        size = list.size();
                    } else if (charSequence.length() > 1) {
                        CharSequence subSequence = charSequence.subSequence(1, charSequence.length());
                        for (String next : y.this.st) {
                            if (next.toLowerCase().contains(subSequence.toString().toLowerCase())) {
                                arrayList.add(next);
                            }
                        }
                        filterResults.values = arrayList;
                        size = arrayList.size();
                    }
                    filterResults.count = size;
                    return filterResults;
                }
            }
            return filterResults;
        }

        public void publishResults(CharSequence charSequence, FilterResults filterResults) {
            Object obj = filterResults.values;
            if (obj != null) {
                y yVar = y.this;
                yVar.su = (ArrayList) obj;
                yVar.clear();
                y yVar2 = y.this;
                yVar2.addAll(yVar2.su);
            }
        }
    }

    public y(Context context2, int i, int i2, List<String> list, boolean z) {
        super(context2, i, i2, list);
        this.context = context2;
        this.sv = i;
        this.sw = i2;
        this.st = new ArrayList(list);
        this.su = new ArrayList(list);
        this.sy = z;
        this.sz = (int) TypedValue.applyDimension(1, 4.0f, context2.getResources().getDisplayMetrics());
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return getView(i, view, viewGroup);
    }

    public Filter getFilter() {
        if (this.sx == null) {
            this.sx = new a();
        }
        return this.sx;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(this.sv, null);
        }
        TextView textView = (TextView) view.findViewById(this.sw);
        List<String> list = this.su;
        if (list != null && !list.isEmpty()) {
            String str = this.su.get(i);
            if (i == 1) {
                viewGroup.setPadding(0, this.sz, 0, 0);
            }
            if (i == this.su.size() - 1) {
                viewGroup.setPadding(0, 0, 0, this.sz);
            }
            if (textView != null) {
                textView.setText(str);
            }
        }
        return view;
    }
}
