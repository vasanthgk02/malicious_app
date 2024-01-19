package com.freshchat.consumer.sdk.service.a;

import android.content.Context;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.service.d.d;
import com.freshchat.consumer.sdk.service.e.y;

public class j extends d {
    public static final String TAG = "com.freshchat.consumer.sdk.service.a.j";

    public j(Context context, a aVar) {
        super(context, aVar);
    }

    public void ds() {
        a dt = dt();
        try {
            String dr = dt.dr();
            if (!e.i(getContext()).bl()) {
                String str = TAG;
                ai.d(str, "The user is not registered yet. Backlogging GCM device token to be processed later " + dt);
                return;
            }
            y yVar = new y();
            yVar.K(dr);
            d.b(getContext(), yVar);
        } catch (Exception e2) {
            q.a(e2);
        }
    }
}
