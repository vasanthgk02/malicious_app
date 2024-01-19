package com.freshchat.consumer.sdk.activity;

public class ab implements Runnable {
    public final /* synthetic */ ArticleDetailActivity F;

    public ab(ArticleDetailActivity articleDetailActivity) {
        this.F = articleDetailActivity;
    }

    public void run() {
        this.F.k.scrollBy(0, 1);
    }
}
