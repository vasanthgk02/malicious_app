package com.freshchat.consumer.sdk.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.freshchat.consumer.sdk.R;

public class u implements OnClickListener {
    public final /* synthetic */ ConversationDetailActivity be;

    public u(ConversationDetailActivity conversationDetailActivity) {
        this.be = conversationDetailActivity;
    }

    public void onClick(View view) {
        ConversationDetailActivity conversationDetailActivity;
        boolean z;
        if (view.getId() == R.id.freshchat_chat_resolution_positive_btn) {
            conversationDetailActivity = this.be;
            z = true;
        } else if (view.getId() == R.id.freshchat_chat_resolution_negative_btn) {
            conversationDetailActivity = this.be;
            z = false;
        } else {
            return;
        }
        conversationDetailActivity.b(z);
    }
}
