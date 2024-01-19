package com.freshchat.consumer.sdk.activity;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.freshchat.consumer.sdk.k.w;

public class bc implements OnFocusChangeListener {
    public final /* synthetic */ FAQSearchActivity qL;

    public bc(FAQSearchActivity fAQSearchActivity) {
        this.qL = fAQSearchActivity;
    }

    public void onFocusChange(View view, boolean z) {
        this.qL.rE = z;
        if (((w) this.qL.pe).jK()) {
            FAQSearchActivity fAQSearchActivity = this.qL;
            fAQSearchActivity.bv(fAQSearchActivity.hV());
        }
    }
}
