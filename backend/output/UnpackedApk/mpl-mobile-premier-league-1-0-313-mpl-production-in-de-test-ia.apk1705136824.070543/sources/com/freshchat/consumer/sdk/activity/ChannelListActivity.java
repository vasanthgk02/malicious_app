package com.freshchat.consumer.sdk.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import androidx.loader.app.LoaderManager.LoaderCallbacks;
import androidx.loader.content.Loader;
import com.freshchat.consumer.sdk.ConversationOptions;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.a.c;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.g.h;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.al;
import com.freshchat.consumer.sdk.j.ap;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.c.a;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.o;
import com.freshchat.consumer.sdk.k.b;
import com.inca.security.Proxy.iIiIiIiIii;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChannelListActivity extends b {
    public static e aq;
    public ListView P;
    public View Q;
    public b aP;
    public ProgressBar am;
    public ConversationOptions an = new ConversationOptions();
    public List<Channel> ao = new ArrayList();
    public Map<Long, Integer> ap = new HashMap();
    public c ar;
    public OnItemClickListener as = new OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ChannelListActivity.this.a((Channel) ChannelListActivity.this.ao.get(i));
        }
    };
    public LoaderCallbacks<List<Channel>> at = new LoaderCallbacks<List<Channel>>() {
        /* renamed from: a */
        public void onLoadFinished(Loader<List<Channel>> loader, List<Channel> list) {
            if (k.b((Collection<?>) list) != 1 || list.get(0) == null) {
                ChannelListActivity.this.ao.clear();
                ChannelListActivity.this.ao.addAll(list);
                if (loader instanceof h) {
                    ChannelListActivity.this.ap.clear();
                    ChannelListActivity.this.ap.putAll(((h) loader).iT());
                }
                ChannelListActivity.this.dH = true;
                ChannelListActivity.this.gb();
                ChannelListActivity.this.ar.notifyDataSetChanged();
                return;
            }
            ChannelListActivity.this.a(list.get(0));
            ChannelListActivity.this.finish();
        }

        public Loader<List<Channel>> onCreateLoader(int i, Bundle bundle) {
            h hVar;
            if (bundle != null) {
                hVar = new h(ChannelListActivity.this.getApplicationContext(), bundle.getBoolean("EXTRA_FORCE_CLEAN_UP_EXPIRED_CSAT"), bundle.getStringArrayList("TAGS"));
                return hVar;
            }
            hVar = new h(ChannelListActivity.this.getApplicationContext(), false);
            return hVar;
        }

        public void onLoaderReset(Loader<List<Channel>> loader) {
            ChannelListActivity.this.ao.clear();
            ChannelListActivity.this.ar.notifyDataSetChanged();
        }
    };
    public boolean dH = false;

    /* access modifiers changed from: 0000 */
    public void F() {
        Bundle bundle = new Bundle();
        if (k.a(this.an.getTags())) {
            bundle.putStringArrayList("TAGS", new ArrayList(this.an.getTags()));
        }
        bundle.putBoolean("EXTRA_FORCE_CLEAN_UP_EXPIRED_CSAT", true);
        getSupportLoaderManager().restartLoader(0, bundle, this.at);
    }

    /* access modifiers changed from: 0000 */
    public e G() {
        if (aq == null) {
            aq = e.i(getApplicationContext());
        }
        return aq;
    }

    public void a(Context context, Intent intent) {
        String action = intent.getAction();
        if ("com.freshchat.consumer.sdk.actions.ChannelsUpdated".equalsIgnoreCase(action)) {
            F();
        } else if ("com.freshchat.consumer.sdk.actions.JwtIdTokenStateChanged".equalsIgnoreCase(action) || "com.freshchat.consumer.sdk.actions.RemoteConfigUpdated".equalsIgnoreCase(action) || ("com.freshchat.consumer.sdk.actions.JwtModeEnabledForAccount".equalsIgnoreCase(action) && ap.aZ(getContext()) && o.bB(getContext()))) {
            gb();
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(Channel channel) {
        if (channel != null) {
            aa.a(getContext(), this.an).c(channel);
        } else {
            i.a((Context) this, com.freshchat.consumer.sdk.b.c.CHANNEL_INFO_NOT_AVAILABLE);
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(a aVar) {
        int i = g.ld[aVar.ordinal()];
        if (i == 1) {
            boolean z = !al.aS(getContext());
            boolean isEmpty = as.isEmpty(G().bG());
            if (!z || !isEmpty) {
                ge();
                return;
            }
        } else if (i != 2) {
            if (i == 3) {
                al();
                return;
            }
            return;
        } else if (!k.isEmpty(this.ao)) {
            gc();
            return;
        }
        gd();
    }

    public String[] a() {
        return new String[]{"com.freshchat.consumer.sdk.actions.JwtModeEnabledForAccount", "com.freshchat.consumer.sdk.actions.ChannelsUpdated", "com.freshchat.consumer.sdk.actions.JwtIdTokenStateChanged", "com.freshchat.consumer.sdk.actions.TokenWaitTimeout", "com.freshchat.consumer.sdk.actions.RemoteConfigUpdated"};
    }

    /* access modifiers changed from: 0000 */
    public void ga() {
        this.aP = new b(getContext());
    }

    /* access modifiers changed from: 0000 */
    public void gb() {
        a gq = this.aP.gq();
        if (gq != a.EXIT_WITH_MESSAGE && !this.dH) {
            gq = a.SHOW_PROGRESS;
        }
        a(gq);
    }

    /* access modifiers changed from: 0000 */
    public void gc() {
        i.c(this.am);
        i.b(this.P);
        i.c(this.Q);
    }

    /* access modifiers changed from: 0000 */
    public void gd() {
        i.c(this.am);
        i.c(this.P);
        i.b(this.Q);
    }

    /* access modifiers changed from: 0000 */
    public void ge() {
        i.b(this.am);
        i.c(this.P);
        i.c(this.Q);
    }

    /* access modifiers changed from: 0000 */
    public ListView getListView() {
        if (this.P == null) {
            this.P = (ListView) findViewById(R.id.freshchat_activity_channel_list_listview);
        }
        return this.P;
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, -253500305, bundle);
    }

    public void onResume() {
        iIiIiIiIii.IiiiIiiiII(this, 1290865883, new Object[0]);
    }

    /* access modifiers changed from: 0000 */
    public void u() {
        this.Q = findViewById(R.id.freshchat_activity_channel_list_empty_view);
        this.am = (ProgressBar) findViewById(R.id.freshchat_activity_channel_list_progressbar);
        this.ar = new c(this, this.ao, this.ap);
        getListView().setAdapter(this.ar);
        getListView().setOnItemClickListener(this.as);
    }
}
