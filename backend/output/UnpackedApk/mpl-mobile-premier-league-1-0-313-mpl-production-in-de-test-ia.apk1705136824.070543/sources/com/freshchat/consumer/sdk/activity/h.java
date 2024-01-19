package com.freshchat.consumer.sdk.activity;

import android.net.Uri;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.l.c.b;

public class h implements b {
    public final /* synthetic */ ConversationDetailActivity be;

    public h(ConversationDetailActivity conversationDetailActivity) {
        this.be = conversationDetailActivity;
    }

    public void hu() {
        i.c(this.be.bp);
    }

    public void o(Message message) {
        String z = this.be.lz.z(message);
        Uri w = this.be.lz.w(message);
        if (!as.a(z) || w == null) {
            i.c(this.be.bp);
            return;
        }
        this.be.bq.setText(z);
        this.be.bp.setOnClickListener(new s(this, w));
        i.b(this.be.bp);
    }
}
