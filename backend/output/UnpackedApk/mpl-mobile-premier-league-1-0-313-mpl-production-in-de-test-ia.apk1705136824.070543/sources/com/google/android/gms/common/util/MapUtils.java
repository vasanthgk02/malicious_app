package com.google.android.gms.common.util;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.HashMap;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public class MapUtils {
    @KeepForSdk
    public static void writeStringMapToJson(StringBuilder sb, HashMap<String, String> hashMap) {
        sb.append("{");
        boolean z = true;
        for (String next : hashMap.keySet()) {
            if (!z) {
                sb.append(",");
            }
            String str = hashMap.get(next);
            GeneratedOutlineSupport.outline102(sb, "\"", next, "\":");
            if (str == null) {
                sb.append("null");
            } else {
                GeneratedOutlineSupport.outline102(sb, "\"", str, "\"");
            }
            z = false;
        }
        sb.append("}");
    }
}
