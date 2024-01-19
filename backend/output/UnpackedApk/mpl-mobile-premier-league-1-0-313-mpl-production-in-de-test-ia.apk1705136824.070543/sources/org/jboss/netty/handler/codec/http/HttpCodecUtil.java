package org.jboss.netty.handler.codec.http;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.nio.charset.Charset;
import java.util.List;
import org.jboss.netty.handler.codec.http.HttpHeaders.Names;
import org.jboss.netty.handler.codec.http.HttpHeaders.Values;
import org.jboss.netty.util.CharsetUtil;

public class HttpCodecUtil {
    public static final byte COLON = 58;
    public static final byte COMMA = 44;
    public static final byte CR = 13;
    public static final byte[] CRLF = {13, 10};
    public static final Charset DEFAULT_CHARSET = CharsetUtil.UTF_8;
    public static final byte DOUBLE_QUOTE = 34;
    public static final byte EQUALS = 61;
    public static final byte HT = 9;
    public static final byte LF = 10;
    public static final byte SEMICOLON = 59;
    public static final byte SP = 32;

    public static boolean isTransferEncodingChunked(HttpMessage httpMessage) {
        List<String> headers = httpMessage.getHeaders(Names.TRANSFER_ENCODING);
        if (headers.isEmpty()) {
            return false;
        }
        for (String equalsIgnoreCase : headers) {
            if (equalsIgnoreCase.equalsIgnoreCase(Values.CHUNKED)) {
                return true;
            }
        }
        return false;
    }

    public static void validateHeaderName(String str) {
        if (str != null) {
            int i = 0;
            while (i < str.length()) {
                char charAt = str.charAt(i);
                if (charAt <= 127) {
                    if (!(charAt == ' ' || charAt == ',' || charAt == '=' || charAt == ':' || charAt == ';')) {
                        switch (charAt) {
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                                break;
                            default:
                                i++;
                        }
                    }
                    throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("name contains one of the following prohibited characters: =,;: \\t\\r\\n\\v\\f: ", str));
                }
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("name contains non-ascii character: ", str));
            }
            return;
        }
        throw new NullPointerException("name");
    }

    public static void validateHeaderValue(String str) {
        if (str != null) {
            int i = 0;
            char c2 = 0;
            while (i < str.length()) {
                char charAt = str.charAt(i);
                if (charAt == 11) {
                    throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("value contains a prohibited character '\\v': ", str));
                } else if (charAt != 12) {
                    if (c2 != 0) {
                        if (c2 != 1) {
                            if (c2 != 2) {
                                continue;
                            } else if (charAt == 9 || charAt == ' ') {
                                c2 = 0;
                            } else {
                                throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("Only ' ' and '\\t' are allowed after '\\n': ", str));
                            }
                            i++;
                        } else if (charAt != 10) {
                            throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("Only '\\n' is allowed after '\\r': ", str));
                        }
                    } else if (charAt != 10) {
                        if (charAt == 13) {
                            c2 = 1;
                        }
                        i++;
                    }
                    c2 = 2;
                    i++;
                } else {
                    throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("value contains a prohibited character '\\f': ", str));
                }
            }
            if (c2 != 0) {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("value must not end with '\\r' or '\\n':", str));
            }
            return;
        }
        throw new NullPointerException(HSLCriteriaBuilder.VALUE);
    }
}
