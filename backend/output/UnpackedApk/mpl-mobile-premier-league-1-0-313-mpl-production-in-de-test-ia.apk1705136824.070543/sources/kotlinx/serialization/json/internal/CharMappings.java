package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.pdfbox.filter.ASCII85InputStream;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\bH\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlinx/serialization/json/internal/CharMappings;", "", "()V", "CHAR_TO_TOKEN", "", "ESCAPE_2_CHAR", "", "initC2ESC", "", "c", "", "esc", "", "initC2TC", "cl", "", "initCharToToken", "initEscape", "kotlinx-serialization-json"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AbstractJsonLexer.kt */
public final class CharMappings {
    public static final byte[] CHAR_TO_TOKEN = new byte[126];
    public static final char[] ESCAPE_2_CHAR = new char[117];
    public static final CharMappings INSTANCE;

    static {
        CharMappings charMappings = new CharMappings();
        INSTANCE = charMappings;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            charMappings.initC2ESC(i2, ASCII85InputStream.PADDING_U);
            if (i3 > 31) {
                break;
            }
            i2 = i3;
        }
        charMappings.initC2ESC(8, 'b');
        charMappings.initC2ESC(9, 't');
        charMappings.initC2ESC(10, 'n');
        charMappings.initC2ESC(12, 'f');
        charMappings.initC2ESC(13, 'r');
        charMappings.initC2ESC(47, '/');
        charMappings.initC2ESC(34, StringEscapeUtils.CSV_QUOTE);
        charMappings.initC2ESC(92, '\\');
        if (INSTANCE != null) {
            while (true) {
                int i4 = i + 1;
                byte[] bArr = CHAR_TO_TOKEN;
                bArr[i] = Byte.MAX_VALUE;
                if (i4 > 32) {
                    bArr[9] = 3;
                    bArr[10] = 3;
                    bArr[13] = 3;
                    bArr[32] = 3;
                    bArr[44] = 4;
                    bArr[58] = 5;
                    bArr[123] = 6;
                    bArr[125] = 7;
                    bArr[91] = 8;
                    bArr[93] = 9;
                    bArr[34] = 1;
                    bArr[92] = 2;
                    return;
                }
                i = i4;
            }
        } else {
            throw null;
        }
    }

    public final void initC2ESC(int i, char c2) {
        if (c2 != 'u') {
            ESCAPE_2_CHAR[c2] = (char) i;
        }
    }
}
