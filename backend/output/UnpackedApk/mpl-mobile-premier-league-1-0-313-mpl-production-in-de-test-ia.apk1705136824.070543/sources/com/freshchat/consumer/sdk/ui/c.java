package com.freshchat.consumer.sdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.freshchat.consumer.sdk.beans.fragment.CarouselCardDefaultFragment;

public class c implements OnClickListener {
    public final /* synthetic */ CarouselCardView nP;

    public c(CarouselCardView carouselCardView) {
        this.nP = carouselCardView;
    }

    public void onClick(View view) {
        CarouselCardDefaultFragment hn = this.nP.nO.hn();
        if (this.nP.lR != null && hn != null) {
            this.nP.lR.a(hn);
        }
    }
}
