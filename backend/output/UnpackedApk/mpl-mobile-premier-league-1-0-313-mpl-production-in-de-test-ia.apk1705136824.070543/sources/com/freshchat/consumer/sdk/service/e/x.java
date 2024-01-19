package com.freshchat.consumer.sdk.service.e;

public class x implements j {
    public long channelId;
    public long conversationId;
    public long readUpto;

    public x(long j, long j2) {
        this.channelId = j;
        this.conversationId = j2;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getConversationId() {
        return this.conversationId;
    }

    public long getReadUpto() {
        return this.readUpto;
    }
}
