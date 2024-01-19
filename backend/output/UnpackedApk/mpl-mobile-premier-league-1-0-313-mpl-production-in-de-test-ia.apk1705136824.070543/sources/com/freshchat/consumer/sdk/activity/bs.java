package com.freshchat.consumer.sdk.activity;

public class bs implements Runnable {
    public final /* synthetic */ ConversationDetailActivity be;

    public bs(ConversationDetailActivity conversationDetailActivity) {
        this.be = conversationDetailActivity;
    }

    public void run() {
        this.be.I().notifyDataSetChanged();
    }
}
