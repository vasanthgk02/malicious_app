package com.freshchat.consumer.sdk.g;

import android.content.Context;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.beans.Message.MessageType;
import com.freshchat.consumer.sdk.beans.Participant;
import com.freshchat.consumer.sdk.c.c;
import com.freshchat.consumer.sdk.c.e;
import com.freshchat.consumer.sdk.c.g;
import com.freshchat.consumer.sdk.c.h;
import com.freshchat.consumer.sdk.j.ab;
import com.freshchat.consumer.sdk.j.ap;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.cy;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class i extends c<Message> {
    public boolean aO = false;
    public final g av;
    public final long channelId;
    public final e eT;
    public final c eU;
    public final h eW;
    public final long eX;
    public final com.freshchat.consumer.sdk.service.d.g jL;
    public final boolean jM;
    public final List<Message> jN;
    public final HashMap<String, Message> jO = new HashMap<>();
    public List<Participant> participants;

    public i(Context context, long j, List<Message> list, boolean z) {
        super(context);
        this.channelId = j;
        this.av = new g(context);
        this.eW = new h(context);
        this.eU = new c(context);
        this.eT = new e(context);
        this.eX = ap.bD(context).getConversationConfig().getActiveConvWindow();
        this.jN = list;
        this.jL = new com.freshchat.consumer.sdk.service.d.g(this.eT, this.av);
        this.jM = z;
        fn();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.freshchat.consumer.sdk.beans.Channel r8, java.util.List<com.freshchat.consumer.sdk.beans.Message> r9, java.util.List<com.freshchat.consumer.sdk.beans.Message> r10) {
        /*
            r7 = this;
            boolean r0 = com.freshchat.consumer.sdk.j.k.isEmpty(r9)
            if (r0 != 0) goto L_0x005c
            if (r8 != 0) goto L_0x0009
            goto L_0x005c
        L_0x0009:
            int r0 = com.freshchat.consumer.sdk.j.k.b(r9)
            r1 = 1
            r2 = 0
            if (r0 <= 0) goto L_0x0038
            java.lang.Object r3 = r9.get(r2)
            com.freshchat.consumer.sdk.beans.Message r3 = (com.freshchat.consumer.sdk.beans.Message) r3
            java.lang.String r3 = r3.getAlias()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            long r5 = r8.getId()
            r4.append(r5)
            java.lang.String r8 = "_welcome_message"
            r4.append(r8)
            java.lang.String r8 = r4.toString()
            boolean r8 = com.freshchat.consumer.sdk.j.as.o(r3, r8)
            if (r8 == 0) goto L_0x0038
            r8 = 1
            goto L_0x0039
        L_0x0038:
            r8 = 0
        L_0x0039:
            if (r8 == 0) goto L_0x005c
            if (r0 != r1) goto L_0x0047
            boolean r8 = com.freshchat.consumer.sdk.j.k.a(r10)
            if (r8 == 0) goto L_0x0047
        L_0x0043:
            r9.remove(r2)
            goto L_0x005c
        L_0x0047:
            if (r0 <= r1) goto L_0x005c
            java.lang.Object r8 = r9.get(r1)
            com.freshchat.consumer.sdk.beans.Message r8 = (com.freshchat.consumer.sdk.beans.Message) r8
            int r8 = r8.getMessageType()
            com.freshchat.consumer.sdk.beans.Message$MessageType r10 = com.freshchat.consumer.sdk.beans.Message.MessageType.FREDDY_BOT
            int r10 = r10.getIntValue()
            if (r8 != r10) goto L_0x005c
            goto L_0x0043
        L_0x005c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.g.i.a(com.freshchat.consumer.sdk.beans.Channel, java.util.List, java.util.List):void");
    }

    private boolean d(Channel channel) {
        if (this.jM || channel == null || channel.getFlowBusinessHourType() == null) {
            return false;
        }
        return this.jL.a(getContext(), channel);
    }

    private List<Message> e(Channel channel) {
        if (channel == null) {
            return null;
        }
        String flowMessagesJson = channel.getFlowMessagesJson();
        if (as.isEmpty(flowMessagesJson)) {
            return null;
        }
        ArrayList arrayList = (ArrayList) ab.in().fromJson(flowMessagesJson, new l(this).getType());
        ArrayList arrayList2 = new ArrayList();
        if (k.a(arrayList)) {
            int i = 0;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Message message = (Message) it.next();
                Message r = r(message);
                if (r != null) {
                    arrayList2.add(r);
                } else {
                    message.setMessageType(MessageType.FREDDY_BOT.getIntValue());
                    message.setMessageUserType(4);
                    message.setMessageUserAlias(String.valueOf(channel.getServiceAccountId()));
                    message.setCreatedMillis(n.fP() + ((long) i));
                    message.setAlias(cy.aS(message.getFlowStepId()));
                    message.setChannelId(this.channelId);
                    arrayList2.add(message);
                    i++;
                }
            }
        }
        return arrayList2;
    }

    private void fn() {
        this.jO.clear();
        for (Message next : this.jN) {
            this.jO.put(next.getAlias(), next);
        }
    }

    private Message r(Message message) {
        if (k.c((Map<?, ?>) this.jO) || message == null || as.isEmpty(message.getFlowStepId())) {
            return null;
        }
        return this.jO.get(cy.aS(message.getFlowStepId()));
    }

    public List<Message> dd() {
        Channel e2 = this.eU.e(this.channelId);
        List<Message> k = this.av.k(this.channelId);
        this.participants = this.eW.cH();
        this.aO = this.av.a(this.channelId, this.eX);
        List<Message> e3 = d(e2) ? e(e2) : null;
        a(e2, k, e3);
        if (k.a(e3)) {
            k.addAll(e3);
        }
        return k;
    }

    public boolean di() {
        return this.aO;
    }

    public List<Participant> getParticipants() {
        return this.participants;
    }
}
