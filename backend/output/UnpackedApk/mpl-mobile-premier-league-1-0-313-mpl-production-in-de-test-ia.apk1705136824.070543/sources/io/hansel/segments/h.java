package io.hansel.segments;

import android.content.Context;
import android.util.Pair;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.event.SMTEventId;
import io.hansel.core.filters.HSLFiltersInternal;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.userjourney.p;
import io.hansel.userjourney.prompts.h0;
import java.util.HashMap;

public class h {
    public static Pair<HashMap<String, Object>, HashMap<String, Object>> a(Context context, CoreJSONObject coreJSONObject, String str, String str2) {
        return Pair.create(new HashMap(a((String) SMTEventId.EVENT_NH_PROMPT_DISMISS, coreJSONObject, str, str2)), a(context, coreJSONObject, str, str2, h0.a(coreJSONObject)));
    }

    public static HashMap<String, Object> a(Context context, CoreJSONObject coreJSONObject, String str, String str2, Boolean bool) {
        String[] split = str.split("___");
        String str3 = split[0];
        String str4 = split[1];
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("Interaction_Map_Name", p.l(context, str));
        hashMap.put("Nudge_Name", coreJSONObject.optString("prompt_name"));
        hashMap.put("Nudge_Type", coreJSONObject.optString("prompt_template_name"));
        hashMap.put("App_Id", str2);
        hashMap.put("User_Id", HSLFiltersInternal.getInstance().getUniqueId());
        hashMap.put("prompt_lis_enabled_key", bool);
        hashMap.put("nudge_id", str3 + str4);
        return hashMap;
    }

    public static HashMap<String, String> a(String str, CoreJSONObject coreJSONObject, String str2, String str3) {
        String[] split = str2.split("___");
        String str4 = split[0];
        String str5 = split[1];
        HashMap<String, String> outline87 = GeneratedOutlineSupport.outline87("event_name", str);
        outline87.put("prompt_name", coreJSONObject.optString("prompt_name"));
        outline87.put("prompt_template", coreJSONObject.optString("prompt_template"));
        outline87.put("app_id", str3);
        outline87.put("hsl_data", GeneratedOutlineSupport.outline63(new StringBuilder(), str4, str5, ","));
        outline87.put("journey_hash", str4);
        outline87.put("node_path", str5);
        outline87.put("hsl_counter", "1");
        outline87.put("_hsl_vendor", "hsl");
        return outline87;
    }

    public static Pair<HashMap<String, String>, HashMap<String, Object>> b(Context context, CoreJSONObject coreJSONObject, String str, String str2) {
        return Pair.create(a((String) SMTEventId.EVENT_NH_PROMPT_DISMISS, coreJSONObject, str, str2), a(context, coreJSONObject, str, str2, h0.a(coreJSONObject)));
    }
}
