package com.freshchat.consumer.sdk.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;

public class br implements OnShowListener {
    public final /* synthetic */ ConversationDetailActivity be;
    public final /* synthetic */ boolean so;

    public br(ConversationDetailActivity conversationDetailActivity, boolean z) {
        this.be = conversationDetailActivity;
        this.so = z;
    }

    public void onShow(DialogInterface dialogInterface) {
        Button button = ((AlertDialog) dialogInterface).getButton(-1);
        if (button != null && this.so) {
            button.setEnabled(false);
        }
    }
}
