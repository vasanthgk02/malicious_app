package com.freshchat.consumer.sdk.beans;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public class Conversation {
    public static final int STATUS_ALL_ASSIGNED = 1;
    public static final int STATUS_ASSIGNED_TO_ME = 3;
    public static final int STATUS_BOT_CONVERSATION = 22;
    public static final int STATUS_OPEN = 0;
    public static final int STATUS_RESOLVED = 2;
    public static final int STATUS_UNDEFINED = -1;
    public long channelId;
    public long conversationId;
    public Csat csat;
    public boolean hasPendingCsat;
    public long logId;
    public List<Message> messages = new ArrayList();
    public List<Participant> participants = new ArrayList();
    public boolean requireDebugLog;
    public long status;

    public Conversation(long j) {
        this.conversationId = j;
    }

    public Conversation(long j, long j2) {
        this.conversationId = j;
        this.status = j2;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getConversationId() {
        return this.conversationId;
    }

    public Csat getCsat() {
        return this.csat;
    }

    public long getLogId() {
        return this.logId;
    }

    public List<Message> getMessages() {
        return this.messages;
    }

    public List<Participant> getParticipants() {
        return this.participants;
    }

    public long getStatus() {
        return this.status;
    }

    public boolean hasPendingCsat() {
        return this.hasPendingCsat;
    }

    public boolean isRequireDebugLog() {
        return this.requireDebugLog;
    }

    public Conversation setChannelId(long j) {
        this.channelId = j;
        return this;
    }

    public Conversation setConversationId(long j) {
        this.conversationId = j;
        return this;
    }

    public Conversation setCsat(Csat csat2) {
        this.csat = csat2;
        return this;
    }

    public Conversation setHasPendingCsat(boolean z) {
        this.hasPendingCsat = z;
        return this;
    }

    public void setLogId(long j) {
        this.logId = j;
    }

    public Conversation setMessages(List<Message> list) {
        this.messages = list;
        return this;
    }

    public void setParticipants(List<Participant> list) {
        this.participants = list;
    }

    public void setRequireDebugLog(boolean z) {
        this.requireDebugLog = z;
    }

    public void setStatus(long j) {
        this.status = j;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Conversation{channelId='");
        outline73.append(this.channelId);
        outline73.append(ExtendedMessageFormat.QUOTE);
        outline73.append(", conversationId=");
        outline73.append(this.conversationId);
        outline73.append(", csat=");
        outline73.append(this.csat);
        outline73.append(", hasPendingCsat=");
        outline73.append(this.hasPendingCsat);
        outline73.append(", requireDebugLog=");
        outline73.append(this.requireDebugLog);
        outline73.append(", logId=");
        outline73.append(this.logId);
        outline73.append('}');
        return outline73.toString();
    }
}
