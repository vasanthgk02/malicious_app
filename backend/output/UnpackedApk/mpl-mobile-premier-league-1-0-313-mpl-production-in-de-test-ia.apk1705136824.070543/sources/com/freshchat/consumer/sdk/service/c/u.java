package com.freshchat.consumer.sdk.service.c;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.beans.ConversationReadStatus;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.c.g;
import com.freshchat.consumer.sdk.exception.DeletedException;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.ab;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.service.a.a;
import com.freshchat.consumer.sdk.service.e.h;
import com.freshchat.consumer.sdk.service.e.k;
import com.freshchat.consumer.sdk.service.e.x;
import java.util.HashMap;

public class u extends a<x, k> {
    private void b(x xVar) {
        HashMap outline87 = GeneratedOutlineSupport.outline87("fc_conv_read_status", new ab().toJson(xVar));
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("7_");
        outline73.append(xVar.getChannelId());
        aa.c(getContext(), new a(7, outline73.toString()).b(outline87));
    }

    /* renamed from: a */
    public k b(x xVar) {
        Context applicationContext = getContext().getApplicationContext();
        boolean z = true;
        try {
            ConversationReadStatus conversationReadStatus = new ConversationReadStatus(xVar.getChannelId(), xVar.getConversationId(), xVar.getReadUpto());
            if (conversationReadStatus.getReadUpto() <= 0) {
                Message l = new g(applicationContext).l(xVar.getChannelId());
                if (l != null) {
                    conversationReadStatus.setReadUpto(l.getCreatedMillis());
                }
                if (conversationReadStatus.getReadUpto() <= 0) {
                    return new h(true);
                }
            }
            new com.freshchat.consumer.sdk.e.a(applicationContext).a(conversationReadStatus);
            try {
                com.freshchat.consumer.sdk.b.a.f(applicationContext);
                com.freshchat.consumer.sdk.b.a.aJ(applicationContext);
            } catch (DeletedException e2) {
                e = e2;
            } catch (Exception e3) {
                e = e3;
                b(xVar);
                q.a(e);
                return new h(z);
            }
        } catch (DeletedException e4) {
            e = e4;
            z = false;
            q.a(e);
            return new h(z);
        } catch (Exception e5) {
            e = e5;
            z = false;
            b(xVar);
            q.a(e);
            return new h(z);
        }
        return new h(z);
    }
}
