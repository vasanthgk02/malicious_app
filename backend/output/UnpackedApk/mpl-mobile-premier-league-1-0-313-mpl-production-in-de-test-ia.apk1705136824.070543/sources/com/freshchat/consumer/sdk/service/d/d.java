package com.freshchat.consumer.sdk.service.d;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.service.FreshchatService;
import com.freshchat.consumer.sdk.service.a;
import com.freshchat.consumer.sdk.service.e.j;
import com.freshchat.consumer.sdk.service.e.k;

public class d {
    public static void b(Context context, final j jVar) {
        FreshchatService.a(context.getApplicationContext(), jVar, new a() {
            public void a(k kVar) {
                if (kVar == null || !kVar.isSuccess()) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unhandled failed response for ");
                    outline73.append(j.this);
                    ai.d("Response", outline73.toString());
                }
            }
        });
    }

    public static void bl(Context context) {
        FreshchatService.bk(context);
    }

    public static void c(Context context, j jVar, a aVar) {
        FreshchatService.a(context.getApplicationContext(), jVar, aVar);
    }
}
