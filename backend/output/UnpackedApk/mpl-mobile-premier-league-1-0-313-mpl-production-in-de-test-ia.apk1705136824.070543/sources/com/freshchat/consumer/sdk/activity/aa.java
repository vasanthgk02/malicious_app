package com.freshchat.consumer.sdk.activity;

import android.view.View;
import android.view.View.OnClickListener;

public class aa implements OnClickListener {
    public final /* synthetic */ ArticleDetailActivity F;

    public aa(ArticleDetailActivity articleDetailActivity) {
        this.F = articleDetailActivity;
    }

    public void onClick(View view) {
        if (this.F.y) {
            this.F.finish();
        } else {
            this.F.r().aE();
        }
        this.F.l();
    }
}
