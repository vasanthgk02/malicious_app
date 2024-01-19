package com.freshchat.consumer.sdk.activity;

import android.widget.LinearLayout.LayoutParams;
import com.freshchat.consumer.sdk.R;

public class m implements Runnable {
    public final /* synthetic */ ConversationDetailActivity be;
    public final /* synthetic */ float sl;

    public m(ConversationDetailActivity conversationDetailActivity, float f2) {
        this.be = conversationDetailActivity;
        this.sl = f2;
    }

    public void run() {
        float height = (float) this.be.findViewById(R.id.freshchat_message_container).getHeight();
        LayoutParams layoutParams = (LayoutParams) this.be.bf.getLayoutParams();
        float f2 = this.sl;
        layoutParams.height = ((float) this.be.bf.getHeight()) / height > f2 ? (int) (height * f2) : -2;
        this.be.bf.setLayoutParams(layoutParams);
        this.be.gB();
    }
}
