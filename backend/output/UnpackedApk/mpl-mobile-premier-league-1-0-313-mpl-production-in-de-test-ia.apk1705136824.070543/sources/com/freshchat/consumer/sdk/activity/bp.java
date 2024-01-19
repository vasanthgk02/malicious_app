package com.freshchat.consumer.sdk.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.freshchat.consumer.sdk.beans.Csat;
import com.freshchat.consumer.sdk.j.bg;

public class bp implements OnCancelListener {
    public final /* synthetic */ ConversationDetailActivity be;
    public final /* synthetic */ boolean kJ;
    public final /* synthetic */ Csat tb;

    public bp(ConversationDetailActivity conversationDetailActivity, Csat csat, boolean z) {
        this.be = conversationDetailActivity;
        this.tb = csat;
        this.kJ = z;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.be.a(this.tb, this.kJ);
        bg.a(this.be.getContext(), this.be.channelId, this.kJ, 0, null);
        this.be.aY();
    }
}
