package com.freshchat.consumer.sdk.service.a;

import android.content.Context;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.service.a;
import com.freshchat.consumer.sdk.service.d.d;
import com.freshchat.consumer.sdk.service.e.k;
import com.freshchat.consumer.sdk.service.e.v;

public class h extends d {
    public h(Context context, a aVar) {
        super(context, aVar);
    }

    public void ds() {
        v vVar = new v();
        final String dr = dt().dr();
        vVar.t(dr);
        d.c(getContext(), vVar, new a() {
            public void a(k kVar) {
                if (kVar != null && kVar.isSuccess()) {
                    aa.l(h.this.getContext(), dr);
                }
            }
        });
    }
}
