package kotlinx.serialization.json.internal;

import io.hansel.core.criteria.HSLCriteriaBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.pdfbox.pdfparser.BaseParser;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\u0018\u0010\u0011\u001a\u00020\u0012*\u00060\u0013j\u0002`\u00142\u0006\u0010\u0015\u001a\u00020\bH\u0000\u001a\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017*\u00020\bH\u0000¢\u0006\u0002\u0010\u0018\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"&\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00078\u0000X\u0004¢\u0006\u0010\n\u0002\u0010\f\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"ESCAPE_MARKERS", "", "getESCAPE_MARKERS$annotations", "()V", "getESCAPE_MARKERS", "()[B", "ESCAPE_STRINGS", "", "", "getESCAPE_STRINGS$annotations", "getESCAPE_STRINGS", "()[Ljava/lang/String;", "[Ljava/lang/String;", "toHexChar", "", "i", "", "printQuoted", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "value", "toBooleanStrictOrNull", "", "(Ljava/lang/String;)Ljava/lang/Boolean;", "kotlinx-serialization-json"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: StringOps.kt */
public final class StringOpsKt {
    public static final byte[] ESCAPE_MARKERS;
    public static final String[] ESCAPE_STRINGS;

    static {
        String[] strArr = new String[93];
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            char hexChar = toHexChar(i2 >> 12);
            char hexChar2 = toHexChar(i2 >> 8);
            char hexChar3 = toHexChar(i2 >> 4);
            char hexChar4 = toHexChar(i2);
            strArr[i2] = "\\u" + hexChar + hexChar2 + hexChar3 + hexChar4;
            if (i3 > 31) {
                break;
            }
            i2 = i3;
        }
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        ESCAPE_STRINGS = strArr;
        byte[] bArr = new byte[93];
        while (true) {
            int i4 = i + 1;
            bArr[i] = 1;
            if (i4 > 31) {
                bArr[34] = (byte) 34;
                bArr[92] = (byte) 92;
                bArr[9] = (byte) 116;
                bArr[8] = (byte) 98;
                bArr[10] = (byte) 110;
                bArr[13] = (byte) 114;
                bArr[12] = (byte) 102;
                ESCAPE_MARKERS = bArr;
                return;
            }
            i = i4;
        }
    }

    public static final void printQuoted(StringBuilder sb, String str) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(str, HSLCriteriaBuilder.VALUE);
        sb.append(StringEscapeUtils.CSV_QUOTE);
        int length = str.length() - 1;
        int i = 0;
        if (length >= 0) {
            int i2 = 0;
            while (true) {
                int i3 = i + 1;
                char charAt = str.charAt(i);
                String[] strArr = ESCAPE_STRINGS;
                if (charAt < strArr.length && strArr[charAt] != null) {
                    sb.append(str, i2, i);
                    sb.append(ESCAPE_STRINGS[charAt]);
                    i2 = i3;
                }
                if (i3 > length) {
                    break;
                }
                i = i3;
            }
            i = i2;
        }
        if (i != 0) {
            sb.append(str, i, str.length());
        } else {
            sb.append(str);
        }
        sb.append(StringEscapeUtils.CSV_QUOTE);
    }

    public static final Boolean toBooleanStrictOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (CharsKt__CharKt.equals(str, (String) BaseParser.TRUE, true)) {
            return Boolean.TRUE;
        }
        if (CharsKt__CharKt.equals(str, (String) BaseParser.FALSE, true)) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static final char toHexChar(int i) {
        int i2 = i & 15;
        return (char) (i2 < 10 ? i2 + 48 : (i2 - 10) + 97);
    }
}
