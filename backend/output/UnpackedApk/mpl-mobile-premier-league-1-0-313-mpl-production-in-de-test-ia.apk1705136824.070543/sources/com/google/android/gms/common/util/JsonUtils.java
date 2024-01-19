package com.google.android.gms.common.util;

import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@KeepForSdk
@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class JsonUtils {
    public static final Pattern zzb = Pattern.compile("[\\\\\"/\b\f\n\r\t]");

    static {
        Pattern.compile("\\\\.");
    }

    @KeepForSdk
    public static String escapeString(String str) {
        if (!TextUtils.isEmpty(str)) {
            Matcher matcher = zzb.matcher(str);
            StringBuffer stringBuffer = null;
            while (matcher.find()) {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer();
                }
                char charAt = matcher.group().charAt(0);
                if (charAt == 12) {
                    matcher.appendReplacement(stringBuffer, "\\\\f");
                } else if (charAt == 13) {
                    matcher.appendReplacement(stringBuffer, "\\\\r");
                } else if (charAt == '\"') {
                    matcher.appendReplacement(stringBuffer, "\\\\\\\"");
                } else if (charAt == '/') {
                    matcher.appendReplacement(stringBuffer, "\\\\/");
                } else if (charAt != '\\') {
                    switch (charAt) {
                        case 8:
                            matcher.appendReplacement(stringBuffer, "\\\\b");
                            break;
                        case 9:
                            matcher.appendReplacement(stringBuffer, "\\\\t");
                            break;
                        case 10:
                            matcher.appendReplacement(stringBuffer, "\\\\n");
                            break;
                    }
                } else {
                    matcher.appendReplacement(stringBuffer, "\\\\\\\\");
                }
            }
            if (stringBuffer == null) {
                return str;
            }
            matcher.appendTail(stringBuffer);
            str = stringBuffer.toString();
        }
        return str;
    }
}
