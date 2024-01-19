package com.freshchat.consumer.sdk.l;

import android.content.Context;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.beans.reqres.AgentAvailabilityResponse;
import com.freshchat.consumer.sdk.j.al;
import com.freshchat.consumer.sdk.j.be;
import com.freshchat.consumer.sdk.j.w;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

public class c extends b {

    public interface a {
        void a(AgentAvailabilityResponse agentAvailabilityResponse);

        void hU();
    }

    public interface b {
        void hu();

        void o(Message message);
    }

    /* access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar != null) {
            a(new i(this, bVar));
        }
    }

    public void a(Context context, long j, b bVar) {
        if (bVar != null) {
            if (j <= 0) {
                a(bVar);
                return;
            }
            WeakReference weakReference = new WeakReference(context);
            Executor gx = be.eC().gx();
            g gVar = new g(this, weakReference, bVar, j);
            gx.execute(gVar);
        }
    }

    public void a(Context context, String str, a aVar) {
        if (!w.ay(context) || str == null || !al.aS(context)) {
            aVar.hU();
        } else {
            be.eC().gZ().execute(new d(this, context, str, aVar));
        }
    }
}
