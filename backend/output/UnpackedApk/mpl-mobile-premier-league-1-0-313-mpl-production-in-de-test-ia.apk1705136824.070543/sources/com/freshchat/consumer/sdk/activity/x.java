package com.freshchat.consumer.sdk.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.service.d.d;
import com.freshchat.consumer.sdk.service.e.n;
import com.freshchat.consumer.sdk.service.e.n.a;

public class x implements OnClickListener {
    public final /* synthetic */ ArticleDetailActivity F;

    public x(ArticleDetailActivity articleDetailActivity) {
        this.F = articleDetailActivity;
    }

    public void onClick(View view) {
        a aVar = view.getId() == R.id.freshchat_upvote ? a.Upvote : a.Downvote;
        ArticleDetailActivity.z = this.F.v;
        d.c(this.F.getContext(), new n(this.F.categoryId, this.F.v, aVar), new y(this));
        if (view.getId() != R.id.freshchat_downvote || !this.F.g.shouldShowContactUsOnFaqNotHelpful()) {
            this.F.n();
        } else {
            this.F.o.bringToFront();
            this.F.o.setVisibility(0);
            this.F.n.setVisibility(8);
        }
        this.F.a(aVar);
    }
}
