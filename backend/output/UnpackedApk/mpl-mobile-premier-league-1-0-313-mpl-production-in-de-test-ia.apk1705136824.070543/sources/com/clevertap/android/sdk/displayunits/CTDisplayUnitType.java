package com.clevertap.android.sdk.displayunits;

import android.text.TextUtils;
import com.netcore.android.notification.SMTNotificationConstants;

public enum CTDisplayUnitType {
    SIMPLE("simple"),
    SIMPLE_WITH_IMAGE("simple-image"),
    CAROUSEL(SMTNotificationConstants.NOTIF_CAROUSEL_KEY),
    CAROUSEL_WITH_IMAGE("carousel-image"),
    MESSAGE_WITH_ICON("message-icon"),
    CUSTOM_KEY_VALUE("custom-key-value");
    
    public final String type;

    /* access modifiers changed from: public */
    CTDisplayUnitType(String str) {
        this.type = str;
    }

    public static CTDisplayUnitType type(String str) {
        if (!TextUtils.isEmpty(str)) {
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1799711058:
                    if (str.equals("carousel-image")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1332589953:
                    if (str.equals("message-icon")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -902286926:
                    if (str.equals("simple")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -876980953:
                    if (str.equals("custom-key-value")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 2908512:
                    if (str.equals(SMTNotificationConstants.NOTIF_CAROUSEL_KEY)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1818845568:
                    if (str.equals("simple-image")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                return SIMPLE;
            }
            if (c2 == 1) {
                return SIMPLE_WITH_IMAGE;
            }
            if (c2 == 2) {
                return CAROUSEL;
            }
            if (c2 == 3) {
                return CAROUSEL_WITH_IMAGE;
            }
            if (c2 == 4) {
                return MESSAGE_WITH_ICON;
            }
            if (c2 == 5) {
                return CUSTOM_KEY_VALUE;
            }
        }
        return null;
    }

    public String toString() {
        return this.type;
    }
}
