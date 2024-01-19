package com.freshchat.consumer.sdk.service.a;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.beans.MarketingMessageStatus;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.service.a;
import com.freshchat.consumer.sdk.service.d.d;
import com.freshchat.consumer.sdk.service.e.aa;

public class k extends d {
    public static final String TAG = "com.freshchat.consumer.sdk.service.a.k";

    public k(Context context, a aVar) {
        super(context, aVar);
    }

    public void ds() {
        try {
            ai.d(TAG, "Processing backlog - marketing message status");
            final a dt = dt();
            final MarketingMessageStatus marketingMessageStatus = (MarketingMessageStatus) ch().fromJson(dt.getMeta().get("fc_marketing_metrics"), MarketingMessageStatus.class);
            aa aaVar = new aa();
            aaVar.a(marketingMessageStatus);
            d.c(getContext(), aaVar, new a() {
                public void a(com.freshchat.consumer.sdk.service.e.k kVar) {
                    if (kVar != null && kVar.isSuccess()) {
                        String str = k.TAG;
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Marketing message status update from backlog successful ");
                        outline73.append(marketingMessageStatus);
                        ai.d(str, outline73.toString());
                        com.freshchat.consumer.sdk.j.aa.l(k.this.getContext(), dt.dr());
                    }
                }
            });
        } catch (Exception e2) {
            q.a(e2);
        }
    }
}
