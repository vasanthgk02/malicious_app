package com.freshchat.consumer.sdk.g;

import android.content.Context;
import com.freshchat.consumer.sdk.c.i;
import java.util.List;

public class a extends c<String> {
    public final i eL;
    public List<String> eM;

    public a(Context context, List<String> list) {
        super(context);
        this.eL = new i(context);
        if (list != null && list.size() > 0) {
            this.eM = list;
        }
    }

    public List<String> dd() {
        return this.eL.h(this.eM);
    }
}
