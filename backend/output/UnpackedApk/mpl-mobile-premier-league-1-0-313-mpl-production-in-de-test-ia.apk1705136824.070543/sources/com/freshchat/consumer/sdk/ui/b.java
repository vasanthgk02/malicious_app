package com.freshchat.consumer.sdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.freshchat.consumer.sdk.util.DeepLinkUtils;

public class b implements OnClickListener {
    public final /* synthetic */ CarouselCardView nP;

    public b(CarouselCardView carouselCardView) {
        this.nP = carouselCardView;
    }

    public void onClick(View view) {
        DeepLinkUtils.b(this.nP.getContext(), this.nP.nO.hq());
        this.nP.nO.hs();
    }
}
