package com.freshchat.consumer.sdk.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.beans.Article;
import java.util.List;

public class a extends BaseAdapter {
    public final LayoutInflater ce;
    public List<Article> cf;
    public final Context context;

    /* renamed from: com.freshchat.consumer.sdk.a.a$a  reason: collision with other inner class name */
    public static class C0022a {
        public TextView cg;
    }

    public a(Context context2, List<Article> list) {
        this.context = context2;
        this.cf = list;
        this.ce = LayoutInflater.from(context2);
    }

    /* renamed from: d */
    public Article getItem(int i) {
        List<Article> list = this.cf;
        if (list != null) {
            return list.get(i);
        }
        return null;
    }

    public int getCount() {
        List<Article> list = this.cf;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public long getItemId(int i) {
        return Long.parseLong(this.cf.get(i).getId());
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        C0022a aVar;
        if (view == null) {
            aVar = new C0022a();
            view2 = this.ce.inflate(R.layout.freshchat_listitem_article, viewGroup, false);
            aVar.cg = (TextView) view2.findViewById(R.id.freshchat_article_listitem_title);
            view2.setTag(aVar);
        } else {
            view2 = view;
            aVar = (C0022a) view.getTag();
        }
        aVar.cg.setText(this.cf.get(i).getTitle());
        return view2;
    }
}
