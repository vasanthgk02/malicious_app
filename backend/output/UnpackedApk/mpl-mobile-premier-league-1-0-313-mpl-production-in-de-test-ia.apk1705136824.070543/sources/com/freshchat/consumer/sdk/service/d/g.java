package com.freshchat.consumer.sdk.service.d;

import android.content.Context;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.beans.Conversation;
import com.freshchat.consumer.sdk.beans.FlowBusinessHourType;
import com.freshchat.consumer.sdk.beans.config.RemoteConfig;
import com.freshchat.consumer.sdk.c.e;
import com.freshchat.consumer.sdk.j.ab;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.ap;
import com.freshchat.consumer.sdk.j.au;
import com.freshchat.consumer.sdk.j.k;
import java.util.ArrayList;
import java.util.Collection;

public class g {
    public final com.freshchat.consumer.sdk.c.g av;
    public final e eT;

    public g(e eVar, com.freshchat.consumer.sdk.c.g gVar) {
        this.eT = eVar;
        this.av = gVar;
    }

    private boolean f(Channel channel) {
        boolean z = false;
        if (channel == null) {
            return false;
        }
        try {
            if (k.b((Collection<?>) (ArrayList) ab.in().fromJson(channel.getFlowMessagesJson(), new h(this).getType())) > 0) {
                z = true;
            }
        } catch (Exception unused) {
        }
        return z;
    }

    public boolean a(Context context, Channel channel) {
        String str;
        boolean z = false;
        if (channel == null) {
            return false;
        }
        Conversation f2 = this.eT.f(channel.getId());
        if (f2 != null) {
            boolean z2 = f2.getStatus() == 2;
            boolean hasPendingCsat = f2.hasPendingCsat();
            if (!z2) {
                str = "Bot: Conversation Not resolved. shouldDisplayFlowMessages false";
                ai.i("FRESHCHAT", str);
                return false;
            } else if (hasPendingCsat) {
                RemoteConfig bD = ap.bD(context);
                if (!au.a(bD)) {
                    ai.i("FRESHCHAT", "Bot: Conversation Has pending CSAT. shouldDisplayFlowMessages false");
                    return false;
                } else if (!au.a(bD, f2.getCsat())) {
                    ai.i("FRESHCHAT", "Bot: Conversation Has pending CSAT. shouldDisplayFlowMessages false");
                    return false;
                }
            }
        }
        if (this.av.E(channel.getId())) {
            str = "Bot: Has messages to upload. shouldDisplayFlowMessages false";
            ai.i("FRESHCHAT", str);
            return false;
        } else if (!f(channel)) {
            return false;
        } else {
            FlowBusinessHourType flowBusinessHourType = channel.getFlowBusinessHourType();
            if (flowBusinessHourType == FlowBusinessHourType.BUSINESS_HOUR_ALWAYS) {
                return true;
            }
            if (i.r(context, channel.getOperatingHoursId())) {
                if (flowBusinessHourType == FlowBusinessHourType.BUSINESS_HOUR_OUTSIDE) {
                    z = true;
                }
                return z;
            }
            if (flowBusinessHourType == FlowBusinessHourType.BUSINESS_HOUR_INSIDE) {
                z = true;
            }
            return z;
        }
    }
}
