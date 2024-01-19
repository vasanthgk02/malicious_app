package com.freshchat.consumer.sdk.activity;

import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.j.cj.a;

public class bu implements a {
    public final /* synthetic */ ConversationDetailActivity be;

    public bu(ConversationDetailActivity conversationDetailActivity) {
        this.be = conversationDetailActivity;
    }

    public void p(Message message) {
        this.be.lz.A(message);
        this.be.n(message);
    }

    public void q(Message message) {
        this.be.a(this.be.lz.x(message));
    }
}
