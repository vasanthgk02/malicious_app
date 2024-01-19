package com.freshchat.consumer.sdk.j.b;

import com.freshchat.consumer.sdk.j.q;

public class b implements Runnable {
    public void run() {
        try {
            a aVar = new a();
            if (aVar.c((String) "pool.ntp.org", 10000)) {
                c.a(aVar);
            }
        } catch (Exception e2) {
            q.a(e2);
        }
    }
}
