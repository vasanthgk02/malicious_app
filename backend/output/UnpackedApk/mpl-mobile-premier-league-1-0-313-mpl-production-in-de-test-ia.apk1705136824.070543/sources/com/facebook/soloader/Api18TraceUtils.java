package com.facebook.soloader;

import android.annotation.TargetApi;
import android.os.Trace;
import com.android.tools.r8.GeneratedOutlineSupport;

@DoNotOptimize
@TargetApi(18)
public class Api18TraceUtils {
    public static void beginTraceSection(String str, String str2, String str3) {
        String outline52 = GeneratedOutlineSupport.outline52(str, str2, str3);
        if (outline52.length() > 127 && str2 != null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73(str);
            outline73.append(str2.substring(0, (127 - str.length()) - str3.length()));
            outline73.append(str3);
            outline52 = outline73.toString();
        }
        Trace.beginSection(outline52);
    }
}
