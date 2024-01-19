package com.freshchat.consumer.sdk.activity;

import com.freshchat.consumer.sdk.a.e.a;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.beans.fragment.QuickReplyButtonFragment;
import com.freshchat.consumer.sdk.j.bg;

public class e implements a {
    public final /* synthetic */ ConversationDetailActivity be;

    public e(ConversationDetailActivity conversationDetailActivity) {
        this.be = conversationDetailActivity;
    }

    public void a(QuickReplyButtonFragment quickReplyButtonFragment, long j) {
        this.be.ao();
        Message a2 = this.be.lz.a(this.be.G().bj(), (MessageFragment) quickReplyButtonFragment, this.be.af(), this.be.channelId, j);
        if (a2 != null) {
            this.be.a(a2);
            bg.a(this.be.getContext(), quickReplyButtonFragment);
        }
    }
}
