package com.facebook.react.bridge;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.util.TypedValue;
import androidx.core.content.res.ResourcesCompat;

public class ColorPropConverter {
    public static final String ATTR = "attr";
    public static final String ATTR_SEGMENT = "attr/";
    public static final String JSON_KEY = "resource_paths";
    public static final String PACKAGE_DELIMITER = ":";
    public static final String PATH_DELIMITER = "/";
    public static final String PREFIX_ATTR = "?";
    public static final String PREFIX_RESOURCE = "@";

    public static Integer getColor(Object obj, Context context) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Double) {
            return Integer.valueOf(((Double) obj).intValue());
        }
        if (context == null) {
            throw new RuntimeException("Context may not be null.");
        } else if (obj instanceof ReadableMap) {
            ReadableArray array = ((ReadableMap) obj).getArray(JSON_KEY);
            if (array != null) {
                for (int i = 0; i < array.size(); i++) {
                    String string = array.getString(i);
                    if (string != null && !string.isEmpty()) {
                        boolean startsWith = string.startsWith(PREFIX_RESOURCE);
                        boolean startsWith2 = string.startsWith(PREFIX_ATTR);
                        String substring = string.substring(1);
                        if (startsWith) {
                            try {
                                return Integer.valueOf(resolveResource(context, substring));
                            } catch (NotFoundException unused) {
                            }
                        } else if (startsWith2) {
                            return Integer.valueOf(resolveThemeAttribute(context, substring));
                        }
                    }
                }
                throw new JSApplicationCausedNativeException("ColorValue: None of the paths in the `resource_paths` array resolved to a color resource.");
            }
            throw new JSApplicationCausedNativeException("ColorValue: The `resource_paths` must be an array of color resource path strings.");
        } else {
            throw new JSApplicationCausedNativeException("ColorValue: the value must be a number or Object.");
        }
    }

    public static int resolveResource(Context context, String str) {
        String[] split = str.split(":");
        String packageName = context.getPackageName();
        if (split.length > 1) {
            packageName = split[0];
            str = split[1];
        }
        String[] split2 = str.split("/");
        String str2 = split2[0];
        return ResourcesCompat.getColor(context.getResources(), context.getResources().getIdentifier(split2[1], str2, packageName), context.getTheme());
    }

    public static int resolveThemeAttribute(Context context, String str) {
        String replaceAll = str.replaceAll(ATTR_SEGMENT, "");
        String[] split = replaceAll.split(":");
        String packageName = context.getPackageName();
        if (split.length > 1) {
            packageName = split[0];
            replaceAll = split[1];
        }
        int identifier = context.getResources().getIdentifier(replaceAll, ATTR, packageName);
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(identifier, typedValue, true)) {
            return typedValue.data;
        }
        throw new NotFoundException();
    }
}
