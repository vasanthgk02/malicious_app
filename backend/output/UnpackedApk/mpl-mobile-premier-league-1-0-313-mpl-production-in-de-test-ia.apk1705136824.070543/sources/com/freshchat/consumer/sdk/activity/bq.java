package com.freshchat.consumer.sdk.activity;

import android.widget.Button;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;

public class bq implements OnRatingBarChangeListener {
    public final /* synthetic */ ConversationDetailActivity be;
    public final /* synthetic */ boolean so;

    public bq(ConversationDetailActivity conversationDetailActivity, boolean z) {
        this.be = conversationDetailActivity;
        this.so = z;
    }

    public void onRatingChanged(RatingBar ratingBar, float f2, boolean z) {
        Button button = this.be.aU.getButton(-1);
        boolean z2 = f2 > 0.0f;
        if (button != null && this.so) {
            button.setEnabled(z2);
        }
    }
}
