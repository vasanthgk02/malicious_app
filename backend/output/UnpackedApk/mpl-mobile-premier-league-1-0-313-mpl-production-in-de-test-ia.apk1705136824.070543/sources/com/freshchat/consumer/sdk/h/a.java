package com.freshchat.consumer.sdk.h;

import android.content.Intent;
import com.freshchat.consumer.sdk.j.ag;
import com.mpl.androidapp.updater.downloadmanager.utils.Constants;
import com.netcore.android.notification.SMTNotificationConstants;
import org.jboss.netty.channel.local.LocalAddress;

public class a {
    public long channelId;
    public long conversationId;
    public String ej;
    public int fb;
    public String fc;
    public String fd;
    public boolean fe;
    public String ff;
    public String fg;
    public String fh;
    public long marketingId;
    public long timestamp;

    public a(Intent intent) {
        o(ag.e(intent, "notif_type"));
        ai(ag.b(intent, SMTNotificationConstants.NOTIF_BODY_KEY));
        aj(ag.b(intent, "img_url"));
        setTimestamp(ag.d(intent, "timestamp"));
        l(ag.c(intent, LocalAddress.EPHEMERAL));
        setChannelId(ag.d(intent, Constants.CHANNEL_ID));
        setConversationId(ag.d(intent, "conv_id"));
        setMarketingId(ag.d(intent, "marketing_id"));
        ak(ag.b(intent, "msg_alias"));
        al(ag.b(intent, "target_user_alias"));
        am(ag.b(intent, "user_name"));
        an(ag.b(intent, "link_uri_1"));
    }

    public void ai(String str) {
        this.fc = str;
    }

    public void aj(String str) {
        this.fd = str;
    }

    public void ak(String str) {
        this.ej = str;
    }

    public void al(String str) {
        this.ff = str;
    }

    public void am(String str) {
        this.fg = str;
    }

    public void an(String str) {
        this.fh = str;
    }

    public String dl() {
        return this.fd;
    }

    public boolean dm() {
        return this.fe;
    }

    public String dn() {
        return this.ej;
    }

    /* renamed from: do  reason: not valid java name */
    public String m91do() {
        return this.ff;
    }

    public int fK() {
        return this.fb;
    }

    public String getBody() {
        return this.fc;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getConversationId() {
        return this.conversationId;
    }

    public long getMarketingId() {
        return this.marketingId;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void l(boolean z) {
        this.fe = z;
    }

    public void o(int i) {
        this.fb = i;
    }

    public void setChannelId(long j) {
        this.channelId = j;
    }

    public void setConversationId(long j) {
        this.conversationId = j;
    }

    public void setMarketingId(long j) {
        this.marketingId = j;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }
}
