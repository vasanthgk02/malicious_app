package com.freshchat.consumer.sdk.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.freshchat.consumer.sdk.FreshchatImageLoader;
import com.freshchat.consumer.sdk.FreshchatImageLoaderRequest;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.j.af;
import com.freshchat.consumer.sdk.j.ah;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.at;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.n;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class c extends BaseAdapter {
    public final List<Channel> ao;
    public final Map<Long, Integer> ap;
    public final Context context;
    public final LayoutInflater cr;

    public static class a {
        public final TextView cs;
        public final ImageView ct;
        public final TextView cu;
        public final TextView cv;
        public final TextView cw;
        public final TextView cx;

        public a(View view) {
            this.cs = (TextView) view.findViewById(R.id.freshchat_channel_name);
            this.ct = (ImageView) view.findViewById(R.id.freshchat_channel_icon);
            this.cu = (TextView) view.findViewById(R.id.freshchat_channel_icon_alt_text);
            this.cw = (TextView) view.findViewById(R.id.freshchat_channel_desc);
            this.cv = (TextView) view.findViewById(R.id.freshchat_channel_unread_count);
            this.cx = (TextView) view.findViewById(R.id.freshchat_channel_last_updated);
        }

        public TextView aR() {
            return this.cs;
        }

        public ImageView aS() {
            return this.ct;
        }

        public TextView aT() {
            return this.cu;
        }

        public TextView aU() {
            return this.cw;
        }

        public TextView aV() {
            return this.cv;
        }

        public TextView aW() {
            return this.cx;
        }
    }

    public c(Context context2, List<Channel> list, Map<Long, Integer> map) {
        this.context = context2;
        this.ao = list;
        this.ap = map;
        this.cr = LayoutInflater.from(context2);
    }

    /* renamed from: e */
    public Channel getItem(int i) {
        List<Channel> list = this.ao;
        if (list != null) {
            return list.get(i);
        }
        return null;
    }

    public int getCount() {
        return k.b((Collection<?>) this.ao);
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        Map<Long, Integer> map;
        TextView textView;
        if (view == null) {
            view = this.cr.inflate(R.layout.freshchat_listitem_channel, viewGroup, false);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        Channel e2 = getItem(i);
        aVar.aR().setText(e2.getName());
        aVar.aT().setVisibility(8);
        aVar.aS().setVisibility(8);
        if (as.a(e2.getIconUrl())) {
            aVar.aS().setVisibility(0);
            FreshchatImageLoaderRequest dM = new com.freshchat.consumer.sdk.FreshchatImageLoaderRequest.a(e2.getIconUrl()).dM();
            FreshchatImageLoader eK = af.eK();
            if (eK != null) {
                eK.load(dM, aVar.aS());
            }
        } else if (as.a(e2.getName())) {
            aVar.aT().setVisibility(0);
            aVar.aT().setText(e2.getName().substring(0, 1).toUpperCase(ah.bb(this.context)));
        } else {
            aVar.aT().setVisibility(4);
        }
        Message latestOrWelcomeMessage = e2.getLatestOrWelcomeMessage();
        if (latestOrWelcomeMessage != null) {
            aVar.aU().setText(as.fromHtml(com.freshchat.consumer.sdk.service.d.c.f(this.context, latestOrWelcomeMessage)).toString());
            aVar.aW().setVisibility(0);
            if (com.freshchat.consumer.sdk.service.d.c.i(latestOrWelcomeMessage) || latestOrWelcomeMessage.getCreatedMillis() == 0 || !as.isEmpty(latestOrWelcomeMessage.getFlowStepId())) {
                textView = aVar.aW();
            } else {
                aVar.aW().setText(n.a(this.context, latestOrWelcomeMessage.getCreatedMillis(), false));
                map = this.ap;
                if (map != null || !map.containsKey(Long.valueOf(e2.getId()))) {
                    aVar.aV().setVisibility(8);
                } else {
                    int intValue = this.ap.get(Long.valueOf(e2.getId())).intValue();
                    aVar.aV().setVisibility(0);
                    aVar.aV().setText(at.n(this.context, intValue));
                }
                return view;
            }
        } else {
            aVar.aW().setVisibility(8);
            textView = aVar.aU();
        }
        textView.setText("");
        map = this.ap;
        if (map != null) {
        }
        aVar.aV().setVisibility(8);
        return view;
    }
}
