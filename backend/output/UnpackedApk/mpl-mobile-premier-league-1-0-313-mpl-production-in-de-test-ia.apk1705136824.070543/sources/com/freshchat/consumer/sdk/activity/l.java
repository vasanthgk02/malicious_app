package com.freshchat.consumer.sdk.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.freshchat.consumer.sdk.beans.fragment.CallbackButtonFragment;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;

public class l implements OnClickListener {
    public final /* synthetic */ ConversationDetailActivity be;
    public final /* synthetic */ MessageFragment sk;

    public l(ConversationDetailActivity conversationDetailActivity, MessageFragment messageFragment) {
        this.be = conversationDetailActivity;
        this.sk = messageFragment;
    }

    public void onClick(View view) {
        this.be.lz.a(this.be.aM, (CallbackButtonFragment) this.sk);
        this.be.a(this.be.b((CallbackButtonFragment) this.sk));
    }
}
