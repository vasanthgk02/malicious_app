package com.freshchat.consumer.sdk.activity;

public class bn implements Runnable {
    public final /* synthetic */ ConversationDetailActivity be;
    public final /* synthetic */ String sG;

    public bn(ConversationDetailActivity conversationDetailActivity, String str) {
        this.be = conversationDetailActivity;
        this.sG = str;
    }

    public void run() {
        if (this.be.aI != null && this.be.aI.getVisibility() == 0) {
            this.be.aI.setText(this.sG);
        }
    }
}
