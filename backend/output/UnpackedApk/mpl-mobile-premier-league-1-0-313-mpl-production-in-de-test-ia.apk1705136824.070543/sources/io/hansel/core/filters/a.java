package io.hansel.core.filters;

import android.content.Context;
import io.hansel.core.json.CoreJSONArray;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import java.util.ArrayList;
import java.util.Set;

public class a {
    public static CoreJSONArray a(Context context) {
        Set<String> keySet = context.getSharedPreferences("_HANSEL_PROMPT_ACTIONS_SP", 0).getAll().keySet();
        CoreJSONArray coreJSONArray = new CoreJSONArray();
        try {
            ArrayList arrayList = new ArrayList(keySet);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                coreJSONArray.put((Object) new CoreJSONObject("{\"name\":\"" + ((String) arrayList.get(i)) + "\"}"));
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
        return coreJSONArray;
    }

    public static void a(Context context, String str) {
        context.getSharedPreferences("_HANSEL_PROMPT_ACTIONS_SP", 0).edit().putString(str, "").apply();
    }
}
