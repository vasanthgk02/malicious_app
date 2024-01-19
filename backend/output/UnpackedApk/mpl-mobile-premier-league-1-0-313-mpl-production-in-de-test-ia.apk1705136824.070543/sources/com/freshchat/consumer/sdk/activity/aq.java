package com.freshchat.consumer.sdk.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.freshchat.consumer.sdk.k.u;

public class aq implements OnClickListener {
    public final /* synthetic */ FAQDetailsActivity pI;

    public aq(FAQDetailsActivity fAQDetailsActivity) {
        this.pI = fAQDetailsActivity;
    }

    public void onClick(View view) {
        if (((u) this.pI.pe).jD()) {
            this.pI.finish();
        } else {
            ((u) this.pI.pe).jg();
        }
    }
}
