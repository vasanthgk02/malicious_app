package com.freshchat.consumer.sdk.k;

import android.content.Context;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.av;
import com.freshchat.consumer.sdk.l.j;

public class k extends a {
    public final j qb = new j();
    public String qc;

    public k(Context context) {
        super(context);
    }

    public boolean aK(String str) {
        if (as.isEmpty(str)) {
            return false;
        }
        return av.aK(str.trim());
    }

    public String bi() {
        if (as.isEmpty(this.qc)) {
            this.qc = this.qb.ce(getContext());
        }
        return this.qc;
    }

    public void bq(String str) {
        this.qc = str.trim();
        this.qb.D(getContext(), this.qc);
    }
}
