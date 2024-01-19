package com.appsflyer.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.appsflyer.AFLogger;
import com.mpl.androidapp.updater.util.UpdaterConstant.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.jboss.netty.channel.ChannelPipelineCoverage;

public final class y {
    public final String[] AFInAppEventParameterName;

    public y() {
    }

    public static Map<String, String> AFInAppEventType(Context context) {
        HashMap hashMap = new HashMap();
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            hashMap.put("x_px", String.valueOf(displayMetrics.widthPixels));
            hashMap.put("y_px", String.valueOf(displayMetrics.heightPixels));
            hashMap.put("d_dpi", String.valueOf(displayMetrics.densityDpi));
            hashMap.put(Response.SIZE, String.valueOf(context.getResources().getConfiguration().screenLayout & 15));
            hashMap.put("xdp", String.valueOf(displayMetrics.xdpi));
            hashMap.put("ydp", String.valueOf(displayMetrics.ydpi));
        } catch (Throwable th) {
            AFLogger.valueOf("Couldn't aggregate screen stats: ", th);
        }
        return hashMap;
    }

    public y(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            this.AFInAppEventParameterName = null;
            return;
        }
        Pattern compile = Pattern.compile("[\\w]{1,45}");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (str == null || !compile.matcher(str).matches()) {
                AFLogger.AppsFlyer2dXConversionCallback("Invalid partner name: ".concat(String.valueOf(str)));
            } else {
                arrayList.add(str.toLowerCase());
            }
        }
        if (arrayList.contains(ChannelPipelineCoverage.ALL)) {
            this.AFInAppEventParameterName = new String[]{ChannelPipelineCoverage.ALL};
        } else if (!arrayList.isEmpty()) {
            this.AFInAppEventParameterName = (String[]) arrayList.toArray(new String[0]);
        } else {
            this.AFInAppEventParameterName = null;
        }
    }
}
