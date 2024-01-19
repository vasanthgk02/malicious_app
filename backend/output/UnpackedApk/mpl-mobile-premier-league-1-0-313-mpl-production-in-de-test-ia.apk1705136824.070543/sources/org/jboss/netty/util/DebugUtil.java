package org.jboss.netty.util;

import org.apache.pdfbox.pdmodel.interactive.measurement.PDNumberFormatDictionary;
import org.jboss.netty.util.internal.SystemPropertyUtil;

public class DebugUtil {
    public static boolean isDebugEnabled() {
        String str;
        try {
            str = SystemPropertyUtil.get("org.jboss.netty.debug");
        } catch (Exception unused) {
            str = null;
        }
        boolean z = false;
        if (str == null) {
            return false;
        }
        String upperCase = str.trim().toUpperCase();
        if (!upperCase.startsWith("N") && !upperCase.startsWith(PDNumberFormatDictionary.FRACTIONAL_DISPLAY_FRACTION) && !upperCase.equals("0")) {
            z = true;
        }
        return z;
    }
}
