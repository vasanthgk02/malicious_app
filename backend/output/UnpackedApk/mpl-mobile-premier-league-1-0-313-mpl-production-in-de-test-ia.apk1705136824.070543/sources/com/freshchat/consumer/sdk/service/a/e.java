package com.freshchat.consumer.sdk.service.a;

import android.content.Context;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.service.d.d;
import com.freshchat.consumer.sdk.service.e.a;
import java.util.Map;

public class e extends d {
    public e(Context context, a aVar) {
        super(context, aVar);
    }

    public void ds() {
        try {
            final a dt = dt();
            Map<String, String> meta = dt.getMeta();
            d.c(getContext(), (a) ch().fromJson(k.d(meta) ? meta.get("fc_create_or_update_user") : "{}", a.class), new com.freshchat.consumer.sdk.service.a() {
                public void a(com.freshchat.consumer.sdk.service.e.k kVar) {
                    if (kVar != null && kVar.isSuccess()) {
                        aa.l(e.this.getContext(), dt.dr());
                    }
                }
            });
        } catch (Exception e2) {
            q.a(e2);
        }
    }
}
