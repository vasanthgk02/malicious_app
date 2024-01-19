package com.freshchat.consumer.sdk.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.freshchat.consumer.sdk.j.ay;

public class o implements OnClickListener {
    public final /* synthetic */ ConversationDetailActivity be;

    public o(ConversationDetailActivity conversationDetailActivity) {
        this.be = conversationDetailActivity;
    }

    public void onClick(View view) {
        this.be.g(this.be.bm.getText().toString());
        ay.c(this.be.getContext(), this.be.aM);
    }
}
