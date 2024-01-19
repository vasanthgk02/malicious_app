package io.hansel.segments;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.network.NetworkingModule;
import io.hansel.core.filters.HSLFiltersInternal;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.utils.HSLUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class j {
    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("_PROMPT_FILTERS_SP", 0);
    }

    public static String a(String str, String str2, String str3, boolean z) {
        return GeneratedOutlineSupport.outline63(GeneratedOutlineSupport.outline78(str, str2), z ? HSLFiltersInternal.getInstance().getUniqueId() : "", ".", str3);
    }

    public static void a(Context context, CoreJSONObject coreJSONObject) {
        CoreJSONObject optJSONObject = coreJSONObject.has("textVariables") ? coreJSONObject.optJSONObject("textVariables") : null;
        if (optJSONObject != null) {
            ArrayList arrayList = new ArrayList(optJSONObject.keySet());
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                CoreJSONObject optJSONObject2 = optJSONObject.optJSONObject((String) arrayList.get(i));
                String optString = optJSONObject2.optString("type", "");
                String optString2 = optJSONObject2.optString("vendor");
                String optString3 = optJSONObject2.optString("eventName");
                String optString4 = optJSONObject2.optString("propName");
                if ("event".equals(optString) && HSLUtils.isValueSet(optString4) && HSLUtils.isSet(optString3) && HSLUtils.isSet(optString2)) {
                    a(context, optString3, optString2, optString4);
                }
            }
        }
    }

    public static void a(Context context, String str, Object obj) {
        String str2;
        Editor editor;
        if (obj != null) {
            SharedPreferences b2 = b(context);
            if (obj instanceof Integer) {
                editor = b2.edit();
                str2 = "int";
            } else if (obj instanceof Double) {
                editor = b2.edit();
                str2 = "double";
            } else if (obj instanceof Long) {
                editor = b2.edit();
                str2 = "long";
            } else {
                boolean z = obj instanceof Boolean;
                editor = b2.edit();
                str2 = z ? "boolean" : NetworkingModule.REQUEST_BODY_KEY_STRING;
            }
            editor.putString(str, str2).apply();
        }
    }

    public static void a(Context context, String str, String str2, CoreJSONObject coreJSONObject) {
        SharedPreferences a2 = a(context);
        Editor edit = a2.edit();
        Set<String> stringSet = a2.getStringSet("HSL_PROMPT_FILTERS_SP", null);
        if (stringSet != null) {
            ArrayList arrayList = new ArrayList(coreJSONObject.keySet());
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                String str3 = (String) arrayList.get(i);
                String optString = coreJSONObject.optString(str3);
                Object opt = coreJSONObject.opt(str3);
                if (HSLUtils.isSet(optString) && stringSet.contains(a(str, str2, str3, false))) {
                    a(context, a(str, str2, str3, true), opt);
                    edit.putString(a(str, str2, str3, true), optString);
                }
            }
            edit.apply();
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        SharedPreferences a2 = a(context);
        Collection stringSet = a2.getStringSet("HSL_PROMPT_FILTERS_SP", new HashSet());
        if (stringSet == null) {
            stringSet = new HashSet();
        }
        HashSet hashSet = new HashSet(stringSet);
        hashSet.add(a(str, str2, str3, false));
        a2.edit().putStringSet("HSL_PROMPT_FILTERS_SP", hashSet).apply();
    }

    public static SharedPreferences b(Context context) {
        return context.getSharedPreferences("HSL_PROMPT_FILTERS_TYPE_SP", 0);
    }

    public static Object b(Context context, String str, String str2, String str3) {
        String a2 = a(str, str2, str3, true);
        String string = a(context).getString(a2, "");
        if (string == null) {
            return null;
        }
        String string2 = b(context).getString(a2, NetworkingModule.REQUEST_BODY_KEY_STRING);
        if (string2 == null) {
            return null;
        }
        string2.hashCode();
        char c2 = 65535;
        switch (string2.hashCode()) {
            case -1325958191:
                if (string2.equals("double")) {
                    c2 = 0;
                    break;
                }
                break;
            case 104431:
                if (string2.equals("int")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3327612:
                if (string2.equals("long")) {
                    c2 = 2;
                    break;
                }
                break;
            case 64711720:
                if (string2.equals("boolean")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        return c2 != 0 ? c2 != 1 ? c2 != 2 ? c2 != 3 ? string : Boolean.valueOf(string) : Long.valueOf(string) : Integer.valueOf(string) : Double.valueOf(string);
    }
}
