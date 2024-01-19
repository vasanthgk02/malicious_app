package com.freshchat.consumer.sdk.activity;

public class bl implements Runnable {
    public final /* synthetic */ ConversationDetailActivity be;
    public final /* synthetic */ int sr;

    public bl(ConversationDetailActivity conversationDetailActivity, int i) {
        this.be = conversationDetailActivity;
        this.sr = i;
    }

    public void run() {
        if (this.be.aH != null && this.be.aH.getVisibility() == 0) {
            this.be.aH.setMax(this.sr);
        }
    }
}
