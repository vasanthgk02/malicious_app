package com.freshchat.consumer.sdk.activity;

import androidx.appcompat.widget.SearchView.OnQueryTextListener;
import com.freshchat.consumer.sdk.k.w;

public class bd implements OnQueryTextListener {
    public final /* synthetic */ FAQSearchActivity qL;

    public bd(FAQSearchActivity fAQSearchActivity) {
        this.qL = fAQSearchActivity;
    }

    public boolean onQueryTextChange(String str) {
        if (this.qL.dH()) {
            this.qL.onUserInteraction();
        }
        ((w) this.qL.pe).bC(str);
        this.qL.bw(str);
        return true;
    }

    public boolean onQueryTextSubmit(String str) {
        return true;
    }
}
