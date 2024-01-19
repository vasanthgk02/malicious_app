package com.mpl.androidapp.miniprofile.extensions;

import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.netcore.android.notification.SMTNotificationConstants;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u001a\u0010\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u001a\u0010\b\u001a\u00020\u00012\b\u0010\t\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\u0001H\u0002\u001a\u0012\u0010\u000b\u001a\u00020\f*\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001\u001a\n\u0010\u000e\u001a\u00020\f*\u00020\u0001\u001a\n\u0010\u000f\u001a\u00020\f*\u00020\u0001\u001a\n\u0010\u0010\u001a\u00020\f*\u00020\u0001\u001a\n\u0010\u0011\u001a\u00020\f*\u00020\u0001\u001a\n\u0010\u0012\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0013\u001a\u00020\u0001*\u00020\u0001\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0014"}, d2 = {"EMPTY", "", "Lkotlin/String$Companion;", "getEMPTY", "(Lkotlin/jvm/internal/StringCompanionObject;)Ljava/lang/String;", "bytes2Hex", "bts", "", "encrypt", "string", "type", "equalsIgnoreCase", "", "other", "isEmail", "isIdcard", "isNumeric", "isPhone", "md5", "sha1", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: StringExt.kt */
public final class StringExtKt {
    public static final String bytes2Hex(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "bts");
        int length = bArr.length;
        String str = "";
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            String hexString = Integer.toHexString(bArr[i] & 255);
            Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(bts[i].toInt() and 0xFF)");
            if (hexString.length() == 1) {
                str = Intrinsics.stringPlus(str, "0");
            }
            str = Intrinsics.stringPlus(str, hexString);
            i = i2;
        }
        return str;
    }

    public static final String encrypt(String str, String str2) {
        MessageDigest instance = MessageDigest.getInstance(str2);
        Intrinsics.checkNotNull(str);
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] digest = instance.digest(bytes);
        Intrinsics.checkNotNullExpressionValue(digest, "bytes");
        return bytes2Hex(digest);
    }

    public static final boolean equalsIgnoreCase(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, SMTNotificationConstants.NOTIF_ATTRIBUTION_OTHER);
        String lowerCase = str.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        String lowerCase2 = str2.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
        return lowerCase.contentEquals(lowerCase2);
    }

    public static final String getEMPTY(StringCompanionObject stringCompanionObject) {
        Intrinsics.checkNotNullParameter(stringCompanionObject, "<this>");
        return "";
    }

    public static final boolean isEmail(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new Regex((String) "^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)$").matches(str);
    }

    public static final boolean isIdcard(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new Regex((String) "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$").matches(str) || new Regex((String) "^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}[0-9Xx]$").matches(str);
    }

    public static final boolean isNumeric(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new Regex((String) "^[0-9]+$").matches(str);
    }

    public static final boolean isPhone(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new Regex((String) "^1([34578])\\d{9}$").matches(str);
    }

    public static final String md5(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return encrypt(str, "MD5");
    }

    public static final String sha1(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return encrypt(str, CommonUtils.SHA1_INSTANCE);
    }
}
