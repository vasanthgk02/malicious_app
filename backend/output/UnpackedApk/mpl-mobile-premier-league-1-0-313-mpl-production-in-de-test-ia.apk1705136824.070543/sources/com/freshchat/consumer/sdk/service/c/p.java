package com.freshchat.consumer.sdk.service.c;

import android.content.Context;
import android.os.Bundle;
import android.webkit.URLUtil;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.JwtTokenStatus;
import com.freshchat.consumer.sdk.b.a;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.beans.TriggeredRuleId;
import com.freshchat.consumer.sdk.beans.User;
import com.freshchat.consumer.sdk.beans.fragment.CalendarEventFragment;
import com.freshchat.consumer.sdk.beans.fragment.FragmentType;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.beans.reqres.UploadImageResponse;
import com.freshchat.consumer.sdk.c.c;
import com.freshchat.consumer.sdk.c.f;
import com.freshchat.consumer.sdk.c.g;
import com.freshchat.consumer.sdk.exception.DeletedException;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.aj;
import com.freshchat.consumer.sdk.j.al;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.b;
import com.freshchat.consumer.sdk.j.bg;
import com.freshchat.consumer.sdk.j.cm;
import com.freshchat.consumer.sdk.j.cy;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.o;
import com.freshchat.consumer.sdk.j.w;
import com.freshchat.consumer.sdk.service.e.d;
import com.freshchat.consumer.sdk.service.e.q;
import com.freshchat.consumer.sdk.service.e.r;
import com.mpl.payment.paytm.PaytmRequestConstants;
import java.util.ArrayList;
import java.util.Collection;

public class p extends a<q, r> {
    private void C(Message message) {
        if (message != null && cy.aU(message.getAlias())) {
            TriggeredRuleId triggeredRuleId = new TriggeredRuleId();
            long aV = cy.aV(message.getAlias());
            if (aV == 0) {
                triggeredRuleId.setTimeDiffInMillis(1000);
            } else {
                triggeredRuleId.setTimeDiffInMillis(message.getCreatedMillis() - aV);
            }
            Channel e2 = new c(getContext()).e(message.getChannelId());
            if (e2 != null) {
                triggeredRuleId.setFlowId(e2.getFlowId());
                triggeredRuleId.setFlowVersionId(e2.getFlowVersionId());
                triggeredRuleId.setServiceAccountId(e2.getServiceAccountId());
                ArrayList arrayList = new ArrayList();
                arrayList.add(triggeredRuleId);
                message.setTriggeredRuleIds(arrayList);
            }
        }
    }

    private void a(long j, String str) {
        Bundle bundle = new Bundle();
        bundle.putLong(PaytmRequestConstants.PARAMS_CHANNEL_ID, j);
        bundle.putString("MESSAGE_ALIAS", str);
        a.a(getContext(), "com.freshchat.consumer.sdk.actions.MessageStatusChanged", bundle);
    }

    private void a(Message message, Message message2, String str) {
        CalendarEventFragment s = cm.s(message2);
        if (s != null) {
            message.getMessageFragments().set(0, s);
            if (as.a(str)) {
                if (cm.a(s)) {
                    bg.M(getContext(), str);
                } else if (cm.y(message2)) {
                    bg.N(getContext(), str);
                } else {
                    bg.O(getContext(), str);
                }
            }
        }
    }

    private r.a b(q qVar) {
        if (!c(qVar)) {
            return r.a.Failed;
        }
        Context context = getContext();
        Message dL = qVar.dL();
        C(dL);
        e i = e.i(context);
        if (!i.bl()) {
            ai.w("FRESHCHAT", "Cannot proceed because the user was not created. Backlog created for message");
            b.a(context, (User) null, true);
            com.freshchat.consumer.sdk.service.a.c.d(getContext(), dL);
            return r.a.UserNotCreated;
        } else if (!al.aS(context)) {
            com.freshchat.consumer.sdk.service.a.c.d(getContext(), dL);
            return r.a.NoInternet;
        } else if (c(getContext(), dL)) {
            g(dL);
            return r.a.Failed;
        } else if (e(dL)) {
            return r.a.Failed;
        } else {
            g gVar = new g(context);
            try {
                dL.setRead(true);
                Message h = h(dL);
                if (as.isEmpty(h.getMessageUserAlias())) {
                    h.setMessageUserAlias(i.bj());
                }
                Message d2 = new com.freshchat.consumer.sdk.e.a(context).d(h);
                ai.d("FRESHCHAT", "Message created " + d2.getAlias());
                h.setUploadState(1);
                h.setCreatedMillis(d2.getCreatedMillis());
                h.setReplyTo(d2.getReplyTo());
                h.setId(d2.getId());
                String t = cm.t(h);
                h.setInternalMeta(d2.getInternalMeta());
                a(h, d2, t);
                gVar.b(h);
                if (h.getConversationId() == 0) {
                    aa.a(context, h.getChannelId(), d2.getConversationId(), 7, d.a.IMMEDIATE, false);
                }
                if (k.a(h.getTriggeredRuleIds())) {
                    long aV = cy.aV(h.getAlias());
                    int aW = cy.aW(h.getAlias());
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < aW; i2++) {
                        arrayList.add(cy.a(aV, i2));
                    }
                    gVar.J(arrayList);
                }
                fO();
                ai.d("FRESHCHAT", "Saved conversation to DB " + d2.getConversationId());
                return r.a.Success;
            } catch (DeletedException e2) {
                com.freshchat.consumer.sdk.j.q.a(e2);
                return r.a.Failed;
            } catch (Exception e3) {
                a(dL.getChannelId(), dL.getAlias());
                com.freshchat.consumer.sdk.j.q.a(e3);
                com.freshchat.consumer.sdk.service.a.c.d(getContext(), dL);
                ai.d("FRESHCHAT", "Failed to send message !");
                return r.a.Failed;
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r8v4 */
    /* JADX WARNING: type inference failed for: r8v5 */
    /* JADX WARNING: type inference failed for: r8v8 */
    /* JADX WARNING: type inference failed for: r8v10 */
    /* JADX WARNING: type inference failed for: r8v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean c(android.content.Context r8, com.freshchat.consumer.sdk.beans.Message r9) {
        /*
            r0 = 0
            r1 = 1
            r2 = 0
            java.util.List r3 = r9.getMessageFragments()     // Catch:{ Exception -> 0x0065 }
            int r4 = com.freshchat.consumer.sdk.j.k.b(r3)     // Catch:{ Exception -> 0x0065 }
            r5 = 0
        L_0x000c:
            if (r5 >= r4) goto L_0x003c
            java.lang.Object r6 = r3.get(r5)     // Catch:{ Exception -> 0x0065 }
            com.freshchat.consumer.sdk.beans.fragment.MessageFragment r6 = (com.freshchat.consumer.sdk.beans.fragment.MessageFragment) r6     // Catch:{ Exception -> 0x0065 }
            boolean r7 = com.freshchat.consumer.sdk.j.aj.a(r6)     // Catch:{ Exception -> 0x0065 }
            if (r7 == 0) goto L_0x0039
            java.lang.String r6 = r6.getContent()     // Catch:{ Exception -> 0x0065 }
            boolean r7 = com.freshchat.consumer.sdk.j.as.a(r6)     // Catch:{ Exception -> 0x0065 }
            if (r7 == 0) goto L_0x0028
            java.io.InputStream r2 = com.freshchat.consumer.sdk.j.ad.aE(r6)     // Catch:{ Exception -> 0x0065 }
        L_0x0028:
            if (r2 != 0) goto L_0x0032
            java.io.Closeable[] r8 = new java.io.Closeable[r1]
            r8[r0] = r2
            com.freshchat.consumer.sdk.j.ad.a(r8)
            return r1
        L_0x0032:
            java.io.Closeable[] r6 = new java.io.Closeable[r1]     // Catch:{ Exception -> 0x0065 }
            r6[r0] = r2     // Catch:{ Exception -> 0x0065 }
            com.freshchat.consumer.sdk.j.ad.a(r6)     // Catch:{ Exception -> 0x0065 }
        L_0x0039:
            int r5 = r5 + 1
            goto L_0x000c
        L_0x003c:
            java.lang.String r9 = r9.getAlias()     // Catch:{ Exception -> 0x0065 }
            boolean r3 = com.freshchat.consumer.sdk.service.a.c.f(r8, r9)     // Catch:{ Exception -> 0x0065 }
            if (r3 == 0) goto L_0x0059
            com.freshchat.consumer.sdk.c.g r3 = new com.freshchat.consumer.sdk.c.g     // Catch:{ Exception -> 0x0065 }
            r3.<init>(r8)     // Catch:{ Exception -> 0x0065 }
            com.freshchat.consumer.sdk.beans.Message r8 = r3.X(r9)     // Catch:{ Exception -> 0x0065 }
            if (r8 == 0) goto L_0x0059
            boolean r8 = r8.isUploaded()     // Catch:{ Exception -> 0x0065 }
            if (r8 == 0) goto L_0x0059
            r8 = 1
            goto L_0x005a
        L_0x0059:
            r8 = 0
        L_0x005a:
            java.io.Closeable[] r9 = new java.io.Closeable[r1]
            r9[r0] = r2
            com.freshchat.consumer.sdk.j.ad.a(r9)
            r0 = r8
            goto L_0x0070
        L_0x0063:
            r8 = move-exception
            goto L_0x0071
        L_0x0065:
            r8 = move-exception
            com.freshchat.consumer.sdk.j.q.a(r8)     // Catch:{ all -> 0x0063 }
            java.io.Closeable[] r8 = new java.io.Closeable[r1]
            r8[r0] = r2
            com.freshchat.consumer.sdk.j.ad.a(r8)
        L_0x0070:
            return r0
        L_0x0071:
            java.io.Closeable[] r9 = new java.io.Closeable[r1]
            r9[r0] = r2
            com.freshchat.consumer.sdk.j.ad.a(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.service.c.p.c(android.content.Context, com.freshchat.consumer.sdk.beans.Message):boolean");
    }

    private boolean e(Message message) {
        boolean z = false;
        if (!o.bB(getContext())) {
            return false;
        }
        if (o.bz(getContext()) != JwtTokenStatus.TOKEN_VALID) {
            z = true;
        }
        if (z) {
            com.freshchat.consumer.sdk.service.a.c.d(getContext(), message);
        }
        return z;
    }

    private void fO() {
        a.f(getContext());
    }

    private void g(Message message) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Deleting backlog ");
        outline73.append(message.getAlias());
        ai.d("FRESHCHAT", outline73.toString());
        aa.l(getContext(), message.getAlias());
    }

    private Message h(Message message) throws DeletedException {
        f fVar = new f(getContext());
        ArrayList arrayList = new ArrayList(message.getMessageFragments());
        int b2 = k.b((Collection<?>) arrayList);
        for (int i = 0; i < b2; i++) {
            MessageFragment messageFragment = (MessageFragment) arrayList.get(i);
            boolean isNetworkUrl = URLUtil.isNetworkUrl(messageFragment.getContent());
            if (aj.a(messageFragment) && !isNetworkUrl) {
                if (messageFragment.getFragmentType() != FragmentType.AUDIO.asInt() && messageFragment.getFragmentType() == FragmentType.IMAGE.asInt()) {
                    UploadImageResponse a2 = new com.freshchat.consumer.sdk.e.a(getContext()).a(messageFragment, i);
                    fVar.b(a2.getImage(), message.getAlias(), i, 1);
                    messageFragment = a2.getImage();
                }
                arrayList.set(i, messageFragment);
            }
        }
        message.setMessageFragments(arrayList);
        return message;
    }

    /* renamed from: a */
    public r b(q qVar) {
        r.a b2 = b(qVar);
        return new r(b2 == r.a.Success, b2);
    }

    public boolean c(q qVar) {
        return w.ay(getContext()) && w.aA(getContext());
    }
}
