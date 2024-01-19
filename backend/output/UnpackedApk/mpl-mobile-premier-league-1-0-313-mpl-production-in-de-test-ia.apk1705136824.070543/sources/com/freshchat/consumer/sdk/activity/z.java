package com.freshchat.consumer.sdk.activity;

import android.widget.Toast;
import com.freshchat.consumer.sdk.R;

public class z implements Runnable {
    public final /* synthetic */ y I;

    public z(y yVar) {
        this.I = yVar;
    }

    public void run() {
        Toast.makeText(this.I.H.F, R.string.freshchat_faq_vote_successful, 1).show();
    }
}
