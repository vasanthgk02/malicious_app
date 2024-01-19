package com.mpl.androidapp.utils.encryptedPrefs;

import kotlin.Metadata;
import kotlin.text.CharsKt__CharKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¨\u0006\u0004"}, d2 = {"isInteger", "", "str", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: MEncryptedPrefs.kt */
public final class MEncryptedPrefsKt {
    public static final boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        Integer intOrNull = CharsKt__CharKt.toIntOrNull(str);
        if (intOrNull == null) {
            return false;
        }
        intOrNull.intValue();
        return true;
    }
}
