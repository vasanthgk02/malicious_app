package com.freshchat.consumer.sdk.service.c;

import android.content.Context;
import com.freshchat.consumer.sdk.beans.Conversation;
import com.freshchat.consumer.sdk.beans.Csat;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.beans.config.RefreshIntervals;
import com.freshchat.consumer.sdk.beans.config.RemoteConfig;
import com.freshchat.consumer.sdk.beans.reqres.ConversationsResponse;
import com.freshchat.consumer.sdk.c.e;
import com.freshchat.consumer.sdk.c.g;
import com.freshchat.consumer.sdk.exception.DeletedException;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.al;
import com.freshchat.consumer.sdk.j.ap;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.au;
import com.freshchat.consumer.sdk.j.b;
import com.freshchat.consumer.sdk.j.bg;
import com.freshchat.consumer.sdk.j.cm;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.j.w;
import com.freshchat.consumer.sdk.service.e.d;
import com.freshchat.consumer.sdk.service.e.d.a;
import com.freshchat.consumer.sdk.service.e.h;
import com.freshchat.consumer.sdk.service.e.k;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class f extends a<d, k> {
    private long a(a aVar) {
        RefreshIntervals refreshIntervals = ap.bD(getContext()).getRefreshIntervals();
        if (aVar == a.IMMEDIATE) {
            return 0;
        }
        if (aVar == a.NORMAL) {
            return refreshIntervals.getMsgFetchIntervalNormal();
        }
        if (aVar == a.LAID_BACK) {
            return refreshIntervals.getMsgFetchIntervalLaidback();
        }
        return 0;
    }

    private void a(Set<Integer> set, List<Message> list) {
        if (!com.freshchat.consumer.sdk.j.k.isEmpty(set) && !com.freshchat.consumer.sdk.j.k.isEmpty(list)) {
            Iterator<Message> it = list.iterator();
            while (it.hasNext()) {
                if (set.contains(Integer.valueOf(it.next().getMessageType()))) {
                    it.remove();
                }
            }
        }
    }

    private List<Message> s(List<Message> list) {
        for (Message uploadState : list) {
            uploadState.setUploadState(1);
        }
        return list;
    }

    private List<Message> y(List<Message> list) {
        for (Message next : list) {
            if (next.isUserMessage()) {
                next.setRead(true);
            }
        }
        return list;
    }

    /* renamed from: a */
    public k b(d dVar) {
        Context context;
        h hVar = new h(true);
        try {
            ai.d("FreshchatTest", "FetchMessagesRequest");
            Context applicationContext = getContext().getApplicationContext();
            if (b(dVar)) {
                if (al.aS(applicationContext)) {
                    g gVar = new g(applicationContext);
                    int gr = gVar.gr();
                    e eVar = new e(applicationContext);
                    com.freshchat.consumer.sdk.b.e dw = dw();
                    String valueOf = String.valueOf(gVar.cD());
                    boolean isEmpty = as.isEmpty(dw.bJ());
                    ai.d("FRESHCHAT", "Messages firstTimeFetch:" + isEmpty);
                    if (dw().fi()) {
                        valueOf = "0";
                        dw().D(false);
                    }
                    ConversationsResponse a2 = new com.freshchat.consumer.sdk.e.a(applicationContext).a(valueOf, dVar.dE());
                    ai.d("FreshchatTest", "Message fetch");
                    List<Conversation> conversations = a2.getConversations();
                    if (conversations != null) {
                        if (conversations.size() != 0) {
                            ai.d("FreshchatTest", "Message fetch - has updates");
                            eVar.f(conversations);
                            Set<Integer> jP = ap.jP();
                            boolean z = false;
                            for (Conversation next : conversations) {
                                long conversationId = next.getConversationId();
                                if (next.hasPendingCsat()) {
                                    boolean z2 = eVar.g(conversationId) == null;
                                    Csat csat = next.getCsat();
                                    if (z2 && csat != null) {
                                        RemoteConfig bD = ap.bD(getContext());
                                        if (!(au.a(bD) && au.a(bD, csat))) {
                                            eVar.a(conversationId, csat);
                                        } else {
                                            context = applicationContext;
                                            bg.c(getContext(), next.getChannelId(), conversationId);
                                        }
                                    }
                                    context = applicationContext;
                                } else {
                                    context = applicationContext;
                                    eVar.t(conversationId);
                                }
                                if (next.isRequireDebugLog()) {
                                    dw.d(next.getLogId());
                                    b.R(getContext());
                                }
                                a(jP, next.getMessages());
                                List<Message> messages = next.getMessages();
                                if (com.freshchat.consumer.sdk.j.k.isEmpty(messages)) {
                                    applicationContext = context;
                                } else {
                                    cm.a(getContext(), messages, next.getChannelId());
                                    gVar.a(y(s(messages)), next.getChannelId());
                                    gVar.F(next.getChannelId());
                                    applicationContext = context;
                                    z = true;
                                }
                            }
                            Context context2 = applicationContext;
                            if (z) {
                                com.freshchat.consumer.sdk.b.a.g(context2);
                                com.freshchat.consumer.sdk.b.a.f(context2);
                                com.freshchat.consumer.sdk.b.a.aJ(context2);
                            }
                            if (gVar.gr() > gr) {
                                bg.bK(getContext());
                            }
                            dw.bK();
                            return hVar;
                        }
                    }
                    hVar.setSuccess(false);
                    if (!(a2.getStatusCode() == 412 || a2.getStatusCode() == 428)) {
                        dw.bK();
                    }
                }
            }
            return hVar;
        } catch (DeletedException | Exception e2) {
            q.a(e2);
            hVar.setSuccess(false);
            return hVar;
        }
    }

    public boolean b(d dVar) {
        if (!w.ay(getContext()) || !w.aA(getContext()) || !dw().bl()) {
            return false;
        }
        String bJ = dw().bJ();
        if (as.isEmpty(bJ)) {
            return true;
        }
        return System.currentTimeMillis() - Long.parseLong(bJ) > a(dVar.dD());
    }
}
