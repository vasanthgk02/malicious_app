package com.freshchat.consumer.sdk.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.freshchat.consumer.sdk.beans.fragment.CallbackButtonFragment;

public class bg implements OnClickListener {
    public final /* synthetic */ CallbackButtonFragment jj;
    public final /* synthetic */ BotFaqDetailsActivity jk;

    public bg(BotFaqDetailsActivity botFaqDetailsActivity, CallbackButtonFragment callbackButtonFragment) {
        this.jk = botFaqDetailsActivity;
        this.jj = callbackButtonFragment;
    }

    public void onClick(View view) {
        this.jk.a(this.jj);
    }
}
