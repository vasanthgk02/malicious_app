package com.freshchat.consumer.sdk.service.b;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.service.a;
import com.freshchat.consumer.sdk.service.c.j;
import com.freshchat.consumer.sdk.service.e.k;

public class b {
    private j a(Context context, com.freshchat.consumer.sdk.service.e.j jVar) {
        j a2 = a.a(jVar);
        if (a2 != null) {
            a2.a(e.i(context));
            a2.setContext(context);
        } else {
            jVar.getClass().getSimpleName();
        }
        return a2;
    }

    public void b(Context context, com.freshchat.consumer.sdk.service.e.j jVar, a aVar) {
        if (jVar != null) {
            j a2 = a(context, jVar);
            if (a2 != null) {
                k kVar = null;
                long currentTimeMillis = System.currentTimeMillis();
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Now Processing ");
                outline73.append(jVar.getClass().getSimpleName());
                ai.i("FRESHCHAT_SERVICE", outline73.toString());
                try {
                    kVar = a2.b(jVar);
                } catch (Exception e2) {
                    ai.e("ERROR", "Exception occured", e2);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                StringBuilder outline732 = GeneratedOutlineSupport.outline73("Time taken to process ");
                outline732.append(jVar.getClass().getSimpleName());
                outline732.append(" = ");
                outline732.append(currentTimeMillis2 - currentTimeMillis);
                ai.d("FRESHCHAT_SERVICE", outline732.toString());
                if (aVar != null) {
                    aVar.a(kVar);
                }
            }
        }
    }
}
