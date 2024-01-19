package com.freshchat.consumer.sdk.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.freshchat.consumer.sdk.service.d.b;
import com.freshchat.consumer.sdk.service.d.b.a;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;

public class af implements OnClickListener {
    public final /* synthetic */ ArticleListActivity ae;

    public af(ArticleListActivity articleListActivity) {
        this.ae = articleListActivity;
    }

    public void onClick(View view) {
        this.ae.r().aE();
        new b(this.ae.getApplicationContext(), a.channels_launch).g(DefaultSettingsSpiCall.SOURCE_PARAM, "contact_us").dB();
    }
}
