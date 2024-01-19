package com.facebook.react.views.imagehelper;

import android.content.Context;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Map;

public class ResourceDrawableIdHelper {
    public static volatile ResourceDrawableIdHelper sResourceDrawableIdHelper;
    public Map<String, Integer> mResourceDrawableIdMap = new HashMap();

    public static ResourceDrawableIdHelper getInstance() {
        if (sResourceDrawableIdHelper == null) {
            synchronized (ResourceDrawableIdHelper.class) {
                try {
                    if (sResourceDrawableIdHelper == null) {
                        sResourceDrawableIdHelper = new ResourceDrawableIdHelper();
                    }
                }
            }
        }
        return sResourceDrawableIdHelper;
    }

    public int getResourceDrawableId(Context context, String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        String replace = str.toLowerCase().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "_");
        try {
            return Integer.parseInt(replace);
        } catch (NumberFormatException unused) {
            synchronized (this) {
                if (this.mResourceDrawableIdMap.containsKey(replace)) {
                    return this.mResourceDrawableIdMap.get(replace).intValue();
                }
                int identifier = context.getResources().getIdentifier(replace, "drawable", context.getPackageName());
                this.mResourceDrawableIdMap.put(replace, Integer.valueOf(identifier));
                return identifier;
            }
        }
    }
}
