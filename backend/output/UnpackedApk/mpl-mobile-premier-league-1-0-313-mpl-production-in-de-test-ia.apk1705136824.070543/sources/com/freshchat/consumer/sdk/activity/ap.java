package com.freshchat.consumer.sdk.activity;

import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.k.t;
import java.util.Collection;

public class ap extends SpanSizeLookup {
    public final /* synthetic */ int pG;
    public final /* synthetic */ FAQCategoriesActivity pv;

    public ap(FAQCategoriesActivity fAQCategoriesActivity, int i) {
        this.pv = fAQCategoriesActivity;
        this.pG = i;
    }

    public int getSpanSize(int i) {
        if (i < k.b((Collection<?>) ((t) this.pv.pe).jt())) {
            return 1;
        }
        return this.pG;
    }
}
