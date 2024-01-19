package com.freshchat.consumer.sdk.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.freshchat.consumer.sdk.beans.fragment.CallbackButtonFragment;

public class bh implements OnClickListener {
    public final /* synthetic */ BotFaqDetailsActivity jk;
    public final /* synthetic */ CallbackButtonFragment jl;

    public bh(BotFaqDetailsActivity botFaqDetailsActivity, CallbackButtonFragment callbackButtonFragment) {
        this.jk = botFaqDetailsActivity;
        this.jl = callbackButtonFragment;
    }

    public void onClick(View view) {
        this.jk.a(this.jl);
    }
}
