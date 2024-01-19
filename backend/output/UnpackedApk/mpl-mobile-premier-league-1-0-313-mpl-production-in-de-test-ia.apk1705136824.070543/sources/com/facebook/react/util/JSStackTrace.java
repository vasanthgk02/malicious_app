package com.facebook.react.util;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.PromiseImpl;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import java.util.regex.Pattern;

public class JSStackTrace {
    public static final Pattern FILE_ID_PATTERN = Pattern.compile("\\b((?:seg-\\d+(?:_\\d+)?|\\d+)\\.js)");

    public static String format(String str, ReadableArray readableArray) {
        String str2;
        StringBuilder outline77 = GeneratedOutlineSupport.outline77(str, ", stack:\n");
        for (int i = 0; i < readableArray.size(); i++) {
            ReadableMap map = readableArray.getMap(i);
            outline77.append(map.getString(PromiseImpl.STACK_FRAME_KEY_METHOD_NAME));
            outline77.append(ColorPropConverter.PREFIX_RESOURCE);
            if (map.hasKey("file") && !map.isNull("file") && map.getType("file") == ReadableType.String) {
                String string = map.getString("file");
                if (string != null) {
                    if (FILE_ID_PATTERN.matcher(string).find()) {
                        str2 = r2.group(1) + ":";
                        outline77.append(str2);
                        if (map.hasKey(PromiseImpl.STACK_FRAME_KEY_LINE_NUMBER) || map.isNull(PromiseImpl.STACK_FRAME_KEY_LINE_NUMBER) || map.getType(PromiseImpl.STACK_FRAME_KEY_LINE_NUMBER) != ReadableType.Number) {
                            outline77.append(-1);
                        } else {
                            outline77.append(map.getInt(PromiseImpl.STACK_FRAME_KEY_LINE_NUMBER));
                        }
                        if (map.hasKey("column") && !map.isNull("column") && map.getType("column") == ReadableType.Number) {
                            outline77.append(":");
                            outline77.append(map.getInt("column"));
                        }
                        outline77.append("\n");
                    }
                }
            }
            str2 = "";
            outline77.append(str2);
            if (map.hasKey(PromiseImpl.STACK_FRAME_KEY_LINE_NUMBER)) {
            }
            outline77.append(-1);
            outline77.append(":");
            outline77.append(map.getInt("column"));
            outline77.append("\n");
        }
        return outline77.toString();
    }
}
