package com.freshchat.consumer.sdk.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.freshchat.consumer.sdk.b.i;

public class d implements OnClickListener {
    public final /* synthetic */ ConversationDetailActivity be;

    public d(ConversationDetailActivity conversationDetailActivity) {
        this.be = conversationDetailActivity;
    }

    public void onClick(View view) {
        i.c(view);
        this.be.gW();
    }
}
