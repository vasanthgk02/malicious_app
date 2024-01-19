package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.dt;

public class an {
    public static void a(Context context, dt dtVar) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("need to update local info with: ");
        outline73.append(dtVar.a());
        b.a(outline73.toString());
        String str = (String) dtVar.a().get(Constants.EXTRA_KEY_ACCEPT_TIME);
        if (str != null) {
            MiPushClient.removeAcceptTime(context);
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            if (split.length == 2) {
                MiPushClient.addAcceptTime(context, split[0], split[1]);
                if (!"00:00".equals(split[0]) || !"00:00".equals(split[1])) {
                    a.a(context).a(false);
                } else {
                    a.a(context).a(true);
                }
            }
        }
        String str2 = (String) dtVar.a().get(Constants.EXTRA_KEY_ALIASES);
        if (str2 != null) {
            MiPushClient.removeAllAliases(context);
            if (!"".equals(str2)) {
                for (String addAlias : str2.split(",")) {
                    MiPushClient.addAlias(context, addAlias);
                }
            }
        }
        String str3 = (String) dtVar.a().get(Constants.EXTRA_KEY_TOPICS);
        if (str3 != null) {
            MiPushClient.removeAllTopics(context);
            if (!"".equals(str3)) {
                for (String addTopic : str3.split(",")) {
                    MiPushClient.addTopic(context, addTopic);
                }
            }
        }
        String str4 = (String) dtVar.a().get(Constants.EXTRA_KEY_ACCOUNTS);
        if (str4 != null) {
            MiPushClient.removeAllAccounts(context);
            if (!"".equals(str4)) {
                for (String addAccount : str4.split(",")) {
                    MiPushClient.addAccount(context, addAccount);
                }
            }
        }
    }
}
