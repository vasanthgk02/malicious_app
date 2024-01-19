package io.hansel.visualizer.f;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.HSLBuildConfig;

public class c {
    public static String a(Context context) {
        return HSLBuildConfig.getServerBaseUrl(context) + "/" + "dashboard/visualizer/request_session";
    }

    public static String a(String str, Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(HSLBuildConfig.getServerSocketUrl(context));
        sb.append(":");
        sb.append("443");
        sb.append("/");
        sb.append("socket");
        return GeneratedOutlineSupport.outline63(sb, "/", str, "?source=device");
    }
}
