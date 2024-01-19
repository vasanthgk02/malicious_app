package com.freshchat.consumer.sdk.service.a;

import android.content.Context;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.b;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.service.a;
import com.freshchat.consumer.sdk.service.e.k;

public class n extends d {
    public n(Context context, a aVar) {
        super(context, aVar);
    }

    public void ds() {
        try {
            b.a(getContext(), (a) new a() {
                public void a(k kVar) {
                    if (kVar != null && kVar.isSuccess()) {
                        aa.l(n.this.getContext(), n.this.dt().dr());
                    }
                }
            });
        } catch (Throwable th) {
            q.a(th);
        }
    }
}
