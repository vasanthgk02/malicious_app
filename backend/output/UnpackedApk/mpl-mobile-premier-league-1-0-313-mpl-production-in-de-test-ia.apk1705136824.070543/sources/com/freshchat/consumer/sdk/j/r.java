package com.freshchat.consumer.sdk.j;

import android.content.Context;
import android.content.res.Resources;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.beans.ChannelResponseTime;
import com.freshchat.consumer.sdk.beans.ChannelResponseTime.ResponseTimeType;
import com.freshchat.consumer.sdk.beans.reqres.ChannelsResponseTimeResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class r {
    public static Map<Long, ChannelResponseTime> hC = new HashMap();
    public static long hD;

    /* renamed from: com.freshchat.consumer.sdk.j.r$1  reason: invalid class name */
    public /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] kw;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            /*
                com.freshchat.consumer.sdk.beans.ChannelResponseTime$ResponseTimeType[] r0 = com.freshchat.consumer.sdk.beans.ChannelResponseTime.ResponseTimeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kw = r0
                r1 = 1
                com.freshchat.consumer.sdk.beans.ChannelResponseTime$ResponseTimeType r2 = com.freshchat.consumer.sdk.beans.ChannelResponseTime.ResponseTimeType.CURRENT_AVG     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = kw     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.freshchat.consumer.sdk.beans.ChannelResponseTime$ResponseTimeType r2 = com.freshchat.consumer.sdk.beans.ChannelResponseTime.ResponseTimeType.LAST_WEEK_AVG     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.j.r.AnonymousClass1.<clinit>():void");
        }
    }

    public enum a {
        UNDER_1_MIN(R.string.freshchat_typically_replies_within_a_minute, R.string.freshchat_currently_replying_in_a_minute),
        UNDER_X_MINS(R.string.freshchat_typically_replies_within_x_minutes, R.string.freshchat_currently_replying_in_x_minutes),
        UNDER_AN_HR(R.string.freshchat_typically_replies_within_an_hour, R.string.freshchat_currently_replying_in_an_hour),
        UNDER_2_HRS(R.string.freshchat_typically_replies_within_2_hours, R.string.freshchat_currently_replying_in_2_hours),
        UNDER_FEW_HRS(R.string.freshchat_typically_replies_within_few_hours, R.string.freshchat_currently_replying_in_few_hours);
        
        public int kC;
        public int kD;

        /* access modifiers changed from: public */
        a(int i, int i2) {
            this.kC = i;
            this.kD = i2;
        }

        public String a(Context context, ResponseTimeType responseTimeType) {
            Resources resources;
            int i;
            if (responseTimeType == null || context == null) {
                return null;
            }
            int i2 = AnonymousClass1.kw[responseTimeType.ordinal()];
            if (i2 == 1) {
                resources = context.getResources();
                i = this.kD;
            } else if (i2 != 2) {
                return null;
            } else {
                resources = context.getResources();
                i = this.kC;
            }
            return resources.getString(i);
        }
    }

    public static String a(Context context, ChannelResponseTime channelResponseTime) {
        if (context == null || channelResponseTime == null) {
            return null;
        }
        if (channelResponseTime.getResponseTimeType() == ResponseTimeType.ALL_MEMBERS_AWAY_RESPONSE) {
            return context.getString(R.string.freshchat_all_members_away_message);
        }
        if (channelResponseTime.getResponseTimeType() == ResponseTimeType.CUSTOM_RESPONSE) {
            return channelResponseTime.getCustomResponseTimeMessage();
        }
        long responseTime = channelResponseTime.getResponseTime();
        ResponseTimeType responseTimeType = channelResponseTime.getResponseTimeType();
        float f2 = ((float) responseTime) / 60.0f;
        if (f2 < 1.0f) {
            return a.UNDER_1_MIN.a(context, responseTimeType);
        }
        if (f2 >= 55.0f) {
            return f2 < 60.0f ? a.UNDER_AN_HR.a(context, responseTimeType) : f2 < 120.0f ? a.UNDER_2_HRS.a(context, responseTimeType) : a.UNDER_FEW_HRS.a(context, responseTimeType);
        }
        try {
            return a.UNDER_X_MINS.a(context, responseTimeType).replace(context.getString(R.string.freshchat_placeholder_minutes), String.valueOf(f2 < 10.0f ? (int) Math.ceil((double) f2) : ((int) Math.ceil((double) (f2 / 5.0f))) * 5));
        } catch (Exception unused) {
            ai.e("FRESHCHAT_WARNING", "Channels response time to String conversation error");
            return null;
        }
    }

    public static void a(Context context, ChannelsResponseTimeResponse channelsResponseTimeResponse) {
        hC.clear();
        if (channelsResponseTimeResponse != null) {
            List<ChannelResponseTime> channelResponseTimesFor7Days = channelsResponseTimeResponse.getChannelResponseTimesFor7Days();
            List<ChannelResponseTime> channelResponseTime = channelsResponseTimeResponse.getChannelResponseTime();
            List<ChannelResponseTime> channelsCustomResponseTimeMessage = channelsResponseTimeResponse.getChannelsCustomResponseTimeMessage();
            List<ChannelResponseTime> channelsWithAllMembersAway = channelsResponseTimeResponse.getChannelsWithAllMembersAway();
            if (k.a(channelResponseTimesFor7Days)) {
                for (ChannelResponseTime next : channelResponseTimesFor7Days) {
                    next.setResponseTimeType(ResponseTimeType.LAST_WEEK_AVG);
                    hC.put(Long.valueOf(next.getChannelId()), next);
                }
            }
            if (k.a(channelResponseTime)) {
                for (ChannelResponseTime next2 : channelResponseTime) {
                    next2.setResponseTimeType(ResponseTimeType.CURRENT_AVG);
                    hC.put(Long.valueOf(next2.getChannelId()), next2);
                }
            }
            if (k.a(channelsCustomResponseTimeMessage)) {
                for (ChannelResponseTime next3 : channelsCustomResponseTimeMessage) {
                    next3.setResponseTimeType(ResponseTimeType.CUSTOM_RESPONSE);
                    if (next3.getCustomResponseTimeMessage() != null && !next3.getCustomResponseTimeMessage().isEmpty()) {
                        hC.put(Long.valueOf(next3.getChannelId()), next3);
                    }
                }
            }
            if (k.a(channelsWithAllMembersAway)) {
                boolean z = false;
                if (context != null) {
                    z = as.a(context.getString(R.string.freshchat_all_members_away_message));
                }
                if (z) {
                    for (ChannelResponseTime next4 : channelsWithAllMembersAway) {
                        next4.setResponseTimeType(ResponseTimeType.ALL_MEMBERS_AWAY_RESPONSE);
                        hC.put(Long.valueOf(next4.getChannelId()), next4);
                    }
                }
            }
            ex();
        }
    }

    public static String d(Context context, long j) {
        if (context == null || j == 0) {
            return null;
        }
        return a(context, r(j));
    }

    public static void ex() {
        hD = System.currentTimeMillis();
    }

    public static long ey() {
        return hD;
    }

    public static ChannelResponseTime r(long j) {
        if (!k.d(hC) || !hC.containsKey(Long.valueOf(j))) {
            return null;
        }
        return hC.get(Long.valueOf(j));
    }
}
