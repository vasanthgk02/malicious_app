package com.freshchat.consumer.sdk.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.freshchat.consumer.sdk.k.e;

public class i implements OnClickListener {
    public final /* synthetic */ ConversationDetailActivity be;
    public final /* synthetic */ e ny;

    public i(ConversationDetailActivity conversationDetailActivity, e eVar) {
        this.be = conversationDetailActivity;
        this.ny = eVar;
    }

    public void onClick(View view) {
        this.be.g(this.ny.hb());
    }
}
