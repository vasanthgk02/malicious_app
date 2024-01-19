package com.freshchat.consumer.sdk.activity;

import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import com.freshchat.consumer.sdk.j.aa;

public class bt extends NetworkCallback {
    public final /* synthetic */ ConversationDetailActivity be;

    public bt(ConversationDetailActivity conversationDetailActivity) {
        this.be = conversationDetailActivity;
    }

    public void onAvailable(Network network) {
        aa.c(this.be.getContext().getApplicationContext(), true);
    }

    public void onLost(Network network) {
        aa.c(this.be.getContext().getApplicationContext(), false);
    }
}
