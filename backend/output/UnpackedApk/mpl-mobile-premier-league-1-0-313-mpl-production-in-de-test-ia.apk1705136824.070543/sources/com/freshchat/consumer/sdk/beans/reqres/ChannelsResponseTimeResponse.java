package com.freshchat.consumer.sdk.beans.reqres;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.beans.ChannelResponseTime;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ChannelsResponseTimeResponse {
    public List<ChannelResponseTime> channelResponseTime;
    public List<ChannelResponseTime> channelResponseTimesFor7Days;
    @SerializedName("channelCustomResponse")
    public List<ChannelResponseTime> channelsCustomResponseTimeMessage;
    public List<ChannelResponseTime> channelsWithAllMembersAway;

    public List<ChannelResponseTime> getChannelResponseTime() {
        return this.channelResponseTime;
    }

    public List<ChannelResponseTime> getChannelResponseTimesFor7Days() {
        return this.channelResponseTimesFor7Days;
    }

    public List<ChannelResponseTime> getChannelsCustomResponseTimeMessage() {
        return this.channelsCustomResponseTimeMessage;
    }

    public List<ChannelResponseTime> getChannelsWithAllMembersAway() {
        return this.channelsWithAllMembersAway;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ChannelsResponseTimeResponse{channelResponseTime=");
        outline73.append(this.channelResponseTime);
        outline73.append(", channelResponseTimesFor7Days=");
        outline73.append(this.channelResponseTimesFor7Days);
        outline73.append(", channelsCustomResponseTimeMessage=");
        outline73.append(this.channelsCustomResponseTimeMessage);
        outline73.append(", channelsWithAllMembersAway=");
        outline73.append(this.channelsWithAllMembersAway);
        outline73.append('}');
        return outline73.toString();
    }
}
