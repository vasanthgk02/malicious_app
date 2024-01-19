package io.hansel.userjourney;

import android.content.Context;
import io.hansel.core.HSLBuildConfig;
import io.hansel.core.base.utils.HSLInternalUtils;

public class o {
    public static String a(Context context) {
        String h = p.h(context);
        if (h == null) {
            h = HSLBuildConfig.getUJMServerUrl(context) + "/ujm/v1/data/<os>/<app_id>/<rv>/";
        }
        String z = p.z(context, "GET_DATA");
        if (z != null && (z.isEmpty() || z.trim().isEmpty())) {
            z = "0";
        }
        return HSLInternalUtils.addQueryParamsToGetDataUrl(context, HSLInternalUtils.getUrlFromFormat(context, h, z));
    }
}
