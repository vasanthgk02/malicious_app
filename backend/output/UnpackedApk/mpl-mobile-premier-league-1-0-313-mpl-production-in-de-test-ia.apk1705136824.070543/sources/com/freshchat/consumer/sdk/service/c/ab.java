package com.freshchat.consumer.sdk.service.c;

import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.e.a;
import com.freshchat.consumer.sdk.exception.DeletedException;
import com.freshchat.consumer.sdk.j.am;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.service.e.ae;
import com.freshchat.consumer.sdk.service.e.h;

public class ab extends b<ae, h> {
    /* renamed from: a */
    public h b(ae aeVar) {
        e dw = dw();
        boolean z = false;
        try {
            if (dw.ce() > 0) {
                if (am.aV(getContext())) {
                    z = new a(getContext()).q(dw.ce());
                }
                dw.cf();
            }
        } catch (DeletedException | Exception e2) {
            q.a(e2);
        }
        return new h(z);
    }
}
