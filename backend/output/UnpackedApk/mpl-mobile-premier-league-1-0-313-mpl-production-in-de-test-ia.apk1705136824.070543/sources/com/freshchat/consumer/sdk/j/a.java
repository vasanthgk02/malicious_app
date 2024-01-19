package com.freshchat.consumer.sdk.j;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.beans.FCLocale;
import in.juspay.hypersdk.core.InflateView;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class a {
    public static final Set<String> qx = new HashSet(Arrays.asList(new String[]{"msdk.freshchat.com", "msdk.us2.freshchat.com", "msdk.in.freshchat.com", "msdk.eu.freshchat.com", "msdk.au.freshchat.com"}));

    public static String A(Context context) {
        e i = e.i(context);
        String bB = i.bB();
        String bc = ah.bc(context);
        FCLocale bC = i.bC();
        String a2 = a(a(a("{{app_domain}}/app/services/app/{{app_alias}}/channel/v2?t={{app_key}}&locale={{locale}}", i).replace("{{locale}}", bc), (String) "since", bB), (String) "lastLocaleId", bC != null ? String.valueOf(bC.getLocaleId()) : null);
        ai.d("FRESHCHAT", "getChannelsURL ==> " + a2);
        return a2;
    }

    public static String B(Context context) {
        return a("{{app_domain}}/app/services/app/{{app_alias}}/user/{{user_alias}}/conversation/read?t={{app_key}}", e.i(context));
    }

    public static String D(Context context) {
        return a("{{app_domain}}/app/services/app/{{app_alias}}/user/{{user_alias}}/session?t={{app_key}}", e.i(context));
    }

    public static String E(Context context) {
        return a("{{app_domain}}/app/services/app/{{app_alias}}/user/{{user_alias}}/heartbeat?t={{app_key}}", e.i(context));
    }

    public static String F(Context context) {
        return a("{{app_domain}}/app/services/app/{{app_alias}}/user/{{user_alias}}/activity?source=MOBILE&t={{app_key}}", e.i(context));
    }

    public static String G(Context context) {
        return a("{{app_domain}}/app/services/app/{{app_alias}}/user?t={{app_key}}", e.i(context));
    }

    public static String G(Context context, String str) {
        return a("{{app_domain}}/app/services/app/{{app_alias}}/user/{{user_alias_str}}/events/multi?t={{app_key}}", e.i(context)).replace("{{user_alias_str}}", str);
    }

    public static String H(Context context) {
        return a("{{app_domain}}/app/services/app/{{app_alias}}/user/{{user_alias}}?t={{app_key}}", e.i(context));
    }

    public static String H(Context context, String str) {
        return a("{{app_domain}}/app/services/app/{{app_alias}}/agent/{{agent_alias}}/calendar/availability?t={{app_key}}", e.i(context)).replace("{{agent_alias}}", str);
    }

    public static String I(Context context) {
        return a("{{app_domain}}/app/services/app/{{app_alias}}/user/{{user_alias}}/feedback/message/v2?t={{app_key}}", e.i(context));
    }

    public static String J(Context context) {
        return a("{{app_domain}}/app/services/app/{{app_alias}}/user/{{user_alias}}/image?t={{app_key}}", e.i(context));
    }

    public static String K(Context context) {
        return a("{{app_domain}}/app/services/app/{{app_alias}}/channels/response_time?t={{app_key}}&locale={{locale}}", e.i(context)).replace("{{locale}}", ah.bc(context));
    }

    public static String a(Context context, int i, String str, List<String> list) {
        String a2 = k.a(list) ? as.a((String[]) list.toArray(new String[0]), ",") : null;
        String replace = a("{{app_domain}}/app/services/app/sdk/{{app_alias}}/omni/faq/category/{{category_id}}/articles?platform=android&page={{page_id}}&locale={{locale}}&t={{app_key}}", e.i(context)).replace("{{page_id}}", String.valueOf(i)).replace("{{category_id}}", str).replace("{{locale}}", ah.bc(context));
        return as.a(a2) ? a(replace, (String) "tags", a2) : replace;
    }

    public static String a(Context context, int i, List<String> list) {
        String a2 = k.a(list) ? as.a((String[]) list.toArray(new String[0]), ",") : null;
        String replace = a("{{app_domain}}/app/services/app/sdk/{{app_alias}}/omni/faq/categories?platform=android&page={{page_id}}&locale={{locale}}&t={{app_key}}", e.i(context)).replace("{{page_id}}", String.valueOf(i)).replace("{{locale}}", ah.bc(context));
        return a2 != null ? a(replace, (String) "tags", a2) : replace;
    }

    public static String a(Context context, String str, int i) {
        return a("{{app_domain}}/app/translation/services/app/{{app_alias}}/user/{{user_alias}}/conversations?t={{app_key}}&messageAfter={{message_after}}&src={{src}}&sendStatusMessages={{send_status_messages}}", e.i(context)).replace("{{message_after}}", str).replace("{{src}}", String.valueOf(i)).replace("{{send_status_messages}}", String.valueOf(true));
    }

    public static String a(Context context, String str, String str2) {
        e i = e.i(context);
        String replace = a("{{app_domain}}/app/services/app/{{app_alias}}/sdk/faq/v2/category/{{category_id}}/article/{{article_id}}?platform=android&t={{app_key}}", i).replace("{{category_id}}", str).replace("{{article_id}}", str2);
        FCLocale bu = i.bu();
        return bu != null ? a(replace, (String) "localeId", bu.getLocaleId()) : replace;
    }

    public static String a(Context context, String str, String str2, String str3, String str4) {
        return a("{{app_domain}}/app/services/app/{{app_alias}}/user/{{user_alias}}/message/marketing/{{marketing_id}}/status?t={{app_key}}&delivered={{delivered}}&clicked={{clicked}}&seen={{seen}}", e.i(context)).replace("{{marketing_id}}", str).replace("{{delivered}}", str2).replace("{{clicked}}", str3).replace("{{seen}}", str4);
    }

    public static String a(String str, e eVar) {
        if (eVar == null || as.isEmpty(eVar.getAppKey())) {
            throw new RuntimeException("API access token missing !");
        }
        String aJ = as.aJ(as.a(eVar.getDomain()) ? eVar.getDomain() : "msdk.freshchat.com");
        return ("https://" + str).replace("{{app_domain}}", aJ).replace("{{app_alias}}", eVar.getAppId()).replace("{{app_key}}", eVar.getAppKey()).replace("{{user_alias}}", eVar.bj());
    }

    public static String a(String str, String str2, long j) {
        return j == 0 ? str : a(str, str2, String.valueOf(j));
    }

    public static String a(String str, String str2, String str3) {
        return (as.isEmpty(str) || as.isEmpty(str2) || as.isEmpty(str3)) ? str : GeneratedOutlineSupport.outline54(str, "&", str2, InflateView.SETTER_EQUALS, str3);
    }

    public static String b(Context context, int i, String str, List<String> list) {
        String a2 = k.a(list) ? as.a((String[]) list.toArray(new String[0]), ",") : null;
        String replace = a("{{app_domain}}/app/services/app/sdk/{{app_alias}}/omni/faq/articles/search?term={{search_term}}&platform=android&page={{page_id}}&locale={{locale}}&t={{app_key}}", e.i(context)).replace("{{page_id}}", String.valueOf(i)).replace("{{search_term}}", str).replace("{{locale}}", ah.bc(context));
        return as.a(a2) ? a(replace, (String) "tags", a2) : replace;
    }

    public static String b(Context context, long j) {
        return a("{{app_domain}}/app/services/app/{{app_alias}}/user/{{user_alias}}/debuglogs/{{log_id}}?t={{app_key}}", e.i(context)).replace("{{log_id}}", String.valueOf(j));
    }

    public static String b(Context context, String str, String str2) {
        return a("{{app_domain}}/app/services/app/{{app_alias}}/user/{{user_alias}}/conversation/{{conversationId}}/csat/{{csatId}}/response?t={{app_key}}", e.i(context)).replace("{{conversationId}}", str).replace("{{csatId}}", str2);
    }

    public static String b(Context context, String str, String str2, String str3, String str4) {
        return a("{{app_domain}}/app/services/app/sdk/{{app_alias}}/omni/faq/category/{{category_id}}/article/{{article_id}}/analytics/{{vote}}?platform=android&articleLocale={{article_locale}}&t={{app_key}}", e.i(context)).replace("{{category_id}}", str).replace("{{article_id}}", str2).replace("{{article_locale}}", str4).replace("{{vote}}", str3);
    }

    public static String bv(Context context) {
        return a("{{app_domain}}/app/services/app/{{app_alias}}/jwt/validate?t={{app_key}}", e.i(context));
    }

    public static String bw(Context context) {
        return a("{{app_domain}}/app/services/app/{{app_alias}}/user/renew-by-jwt?t={{app_key}}", e.i(context));
    }

    public static String e(Context context, String str, String str2) {
        return a("{{app_domain}}/app/services/app/{{app_alias}}/user/restore?externalId={{externalId}}&restoreId={{restoreId}}&t={{app_key}}", e.i(context)).replace("{{externalId}}", str).replace("{{restoreId}}", str2);
    }

    public static String g(Context context, String str) {
        return a("{{app_domain}}/app/services/app/{{app_alias}}/user/{{user_alias}}/notification?t={{app_key}}&notification_id={{device_token}}&notification_type=1", e.i(context)).replace("{{device_token}}", str);
    }

    public static String g(Context context, String str, String str2) {
        return a("{{app_domain}}/app/services/app/sdk/{{app_alias}}/omni/faq/category/{{category_id}}/article/{{article_id}}?platform=android&locale={{locale}}&t={{app_key}}&viewed=true", e.i(context)).replace("{{article_id}}", str).replace("{{category_id}}", str2).replace("{{locale}}", ah.bc(context));
    }

    public static String h(Context context, String str) {
        return a("{{app_domain}}/app/services/app/{{app_alias}}/user/{{prev_user_alias}}/uninstalled?t={{app_key}}", e.i(context)).replace("{{prev_user_alias}}", str);
    }

    public static String i(Context context, String str, String str2) {
        return a("{{app_domain}}/app/services/app/{{app_alias}}/template/content/{{reference_id}}?placeholderReferenceId={{placeholder_reference_id}}&t={{app_key}}", e.i(context)).replace("{{reference_id}}", str).replace("{{placeholder_reference_id}}", str2);
    }

    public static String j(Context context, String str, String str2) {
        e i = e.i(context);
        boolean a2 = as.a(str2);
        String replace = a(!a2 ? "{{app_domain}}/app/services/app/{{app_alias}}/message/{{message_alias}}/postback?t={{app_key}}" : "{{app_domain}}/app/services/app/{{app_alias}}/message/{{message_alias}}/{{reference_id}}/postback?t={{app_key}}", i).replace("{{message_alias}}", str);
        return a2 ? replace.replace("{{reference_id}}", str2) : replace;
    }

    public static String y(Context context) {
        String a2 = a("config-{{app_domain}}/app/services/app/config/mobile/{{app_alias}}?t={{app_key}}", e.i(context));
        return (!as.a(a2) || a2.toLowerCase().contains(".freshchat.com")) ? a2 : a2.replace("config-", "");
    }

    public static String z(Context context) {
        e i = e.i(context);
        String a2 = a(a(a("{{app_domain}}/app/services/app/{{app_alias}}/sdk/faq/v2/category?t={{app_key}}&platform=android", i), (String) "since", i.bt()), (String) "locale", ah.bc(context));
        FCLocale bu = i.bu();
        if (bu != null) {
            a2 = a(a2, (String) "lastLocaleId", bu.getLocaleId());
        }
        ai.d("FRESHCHAT", "getSolutionsURL ==> " + a2);
        return a2;
    }
}
