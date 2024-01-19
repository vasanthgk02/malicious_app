package com.freshchat.consumer.sdk.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.beans.fragment.QuickReplyButtonFragment;

public class f implements OnClickListener {
    public final /* synthetic */ MessageFragment mZ;
    public final /* synthetic */ e na;

    public f(e eVar, MessageFragment messageFragment) {
        this.na = eVar;
        this.mZ = messageFragment;
    }

    public void onClick(View view) {
        this.na.mY.a((QuickReplyButtonFragment) this.mZ, this.na.originalMessageId);
    }
}
