package com.freshchat.consumer.sdk.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.loader.app.LoaderManager;
import androidx.loader.app.LoaderManager.LoaderCallbacks;
import androidx.loader.content.Loader;
import com.freshchat.consumer.sdk.ConversationOptions;
import com.freshchat.consumer.sdk.FaqOptions;
import com.freshchat.consumer.sdk.FaqOptions.FilterType;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.g.a;
import com.freshchat.consumer.sdk.g.e;
import com.freshchat.consumer.sdk.g.h;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.m;
import com.freshchat.consumer.sdk.j.v;
import com.freshchat.consumer.sdk.j.y;
import com.inca.security.Proxy.iIiIiIiIii;
import java.util.ArrayList;
import java.util.List;

public class InterstitialActivity extends b {
    public ConversationOptions an = new ConversationOptions();
    public LoaderCallbacks<List<String>> bM = new LoaderCallbacks<List<String>>() {
        /* renamed from: a */
        public void onLoadFinished(Loader<List<String>> loader, List<String> list) {
            InterstitialActivity.this.a(list);
        }

        public Loader<List<String>> onCreateLoader(int i, Bundle bundle) {
            if (bundle == null || !bundle.containsKey("TAGS")) {
                return null;
            }
            return new e(InterstitialActivity.this.getApplicationContext(), bundle.getStringArrayList("TAGS"));
        }

        public void onLoaderReset(Loader<List<String>> loader) {
        }
    };
    public LoaderCallbacks<List<String>> bN = new LoaderCallbacks<List<String>>() {
        /* renamed from: a */
        public void onLoadFinished(Loader<List<String>> loader, List<String> list) {
            InterstitialActivity.this.b(list);
        }

        public Loader<List<String>> onCreateLoader(int i, Bundle bundle) {
            if (bundle == null || !bundle.containsKey("TAGS")) {
                return null;
            }
            return new a(InterstitialActivity.this.getApplicationContext(), bundle.getStringArrayList("TAGS"));
        }

        public void onLoaderReset(Loader<List<String>> loader) {
        }
    };
    public LoaderCallbacks<List<Channel>> bO = new LoaderCallbacks<List<Channel>>() {
        /* renamed from: a */
        public void onLoadFinished(Loader<List<Channel>> loader, List<Channel> list) {
            InterstitialActivity.this.c(list);
        }

        public Loader<List<Channel>> onCreateLoader(int i, Bundle bundle) {
            if (bundle == null || !bundle.containsKey("TAGS")) {
                return null;
            }
            return new h(InterstitialActivity.this.getApplicationContext(), false, bundle.getStringArrayList("TAGS"));
        }

        public void onLoaderReset(Loader<List<Channel>> loader) {
        }
    };
    public FaqOptions g = new FaqOptions();
    public boolean qM = false;
    public boolean qN;

    public void a(Context context, Intent intent) {
        if (as.o(intent.getAction(), "com.freshchat.consumer.sdk.actions.RemoteConfigUpdated") && this.g != null) {
            aD();
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(List<String> list) {
        r().w(list);
        finish();
    }

    public String[] a() {
        return this.qN ? new String[]{"com.freshchat.consumer.sdk.actions.RemoteConfigUpdated"} : new String[0];
    }

    /* access modifiers changed from: 0000 */
    public void aC() {
        if (!this.qM) {
            if (getSupportActionBar() != null) {
                getSupportActionBar().hide();
            }
            RelativeLayout relativeLayout = new RelativeLayout(this);
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            ProgressBar progressBar = new ProgressBar(this);
            progressBar.setIndeterminate(true);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(13, -1);
            relativeLayout.addView(progressBar, layoutParams2);
            setContentView(relativeLayout, layoutParams);
            this.qM = true;
        }
    }

    /* access modifiers changed from: 0000 */
    public void aD() {
        LoaderManager supportLoaderManager;
        LoaderCallbacks<List<String>> loaderCallbacks;
        if (k.isEmpty(this.g.getTags())) {
            r().eu();
        } else if (y.cp(getContext())) {
            r().iY();
        } else {
            ArrayList arrayList = new ArrayList(this.g.getTags());
            aC();
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("TAGS", arrayList);
            if (this.g.getFilterType() == FilterType.ARTICLE) {
                supportLoaderManager = getSupportLoaderManager();
                loaderCallbacks = this.bN;
            } else {
                if (this.g.getFilterType() == FilterType.CATEGORY) {
                    supportLoaderManager = getSupportLoaderManager();
                    loaderCallbacks = this.bM;
                }
                return;
            }
            supportLoaderManager.restartLoader(0, bundle, loaderCallbacks);
            return;
        }
        finish();
    }

    /* access modifiers changed from: 0000 */
    public void aE() {
        if (k.isEmpty(this.an.getTags())) {
            aF().eu();
            finish();
            return;
        }
        ArrayList arrayList = new ArrayList(this.an.getTags());
        aC();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("TAGS", arrayList);
        getSupportLoaderManager().restartLoader(0, bundle, this.bO);
    }

    /* access modifiers changed from: 0000 */
    public m aF() {
        return aa.a((Context) this, this.an);
    }

    /* access modifiers changed from: 0000 */
    public void b(List<String> list) {
        r().x(list);
        finish();
    }

    /* access modifiers changed from: 0000 */
    public void c(List<Channel> list) {
        aF().u(list);
        finish();
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, 956211446, bundle);
    }

    /* access modifiers changed from: 0000 */
    public v r() {
        return aa.a((Context) this, this.g);
    }
}
