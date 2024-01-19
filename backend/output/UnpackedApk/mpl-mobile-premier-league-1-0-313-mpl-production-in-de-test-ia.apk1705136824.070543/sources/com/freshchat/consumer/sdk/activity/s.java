package com.freshchat.consumer.sdk.activity;

import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.freshchat.consumer.sdk.util.DeepLinkUtils;

public class s implements OnClickListener {
    public final /* synthetic */ Uri lY;
    public final /* synthetic */ h nu;

    public s(h hVar, Uri uri) {
        this.nu = hVar;
        this.lY = uri;
    }

    public void onClick(View view) {
        DeepLinkUtils.b(this.nu.be.getContext(), this.lY);
    }
}
