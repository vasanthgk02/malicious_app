package org.jboss.netty.handler.codec.http;

import com.smartfoxserver.v2.protocol.serialization.DefaultObjectDumpFormatter;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import org.apache.commons.lang.StringEscapeUtils;

public class CookieEncoder {
    public final Set<Cookie> cookies = new TreeSet();
    public final boolean server;

    public CookieEncoder(boolean z) {
        this.server = z;
    }

    public static void add(StringBuilder sb, String str, String str2) {
        if (str2 == null) {
            addQuoted(sb, str, "");
            return;
        }
        int i = 0;
        while (i < str2.length()) {
            char charAt = str2.charAt(i);
            if (!(charAt == 9 || charAt == ' ' || charAt == '\"' || charAt == ',' || charAt == '/' || charAt == '{' || charAt == '}' || charAt == '(' || charAt == ')')) {
                switch (charAt) {
                    case ':':
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                    case '?':
                    case '@':
                        break;
                    default:
                        switch (charAt) {
                            case '[':
                            case '\\':
                            case ']':
                                break;
                            default:
                                i++;
                        }
                }
            }
            addQuoted(sb, str, str2);
            return;
        }
        addUnquoted(sb, str, str2);
    }

    public static void addQuoted(StringBuilder sb, String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str);
        sb.append('=');
        sb.append(StringEscapeUtils.CSV_QUOTE);
        sb.append(str2.replace("\\", "\\\\").replace("\"", "\\\""));
        sb.append(StringEscapeUtils.CSV_QUOTE);
        sb.append(DefaultObjectDumpFormatter.TOKEN_DIVIDER);
    }

    public static void addUnquoted(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append('=');
        sb.append(str2);
        sb.append(DefaultObjectDumpFormatter.TOKEN_DIVIDER);
    }

    private String encodeClientSide() {
        StringBuilder sb = new StringBuilder();
        for (Cookie next : this.cookies) {
            if (next.getVersion() >= 1) {
                add(sb, (String) "$Version", 1);
            }
            add(sb, next.getName(), next.getValue());
            if (next.getPath() != null) {
                add(sb, (String) "$Path", next.getPath());
            }
            if (next.getDomain() != null) {
                add(sb, (String) "$Domain", next.getDomain());
            }
            if (next.getVersion() >= 1 && !next.getPorts().isEmpty()) {
                sb.append('$');
                sb.append(CookieHeaderNames.PORT);
                sb.append('=');
                sb.append(StringEscapeUtils.CSV_QUOTE);
                for (Integer intValue : next.getPorts()) {
                    sb.append(intValue.intValue());
                    sb.append(',');
                }
                sb.setCharAt(sb.length() - 1, StringEscapeUtils.CSV_QUOTE);
                sb.append(DefaultObjectDumpFormatter.TOKEN_DIVIDER);
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    private String encodeServerSide() {
        StringBuilder sb = new StringBuilder();
        for (Cookie next : this.cookies) {
            add(sb, next.getName(), next.getValue());
            if (next.getMaxAge() >= 0) {
                if (next.getVersion() == 0) {
                    addUnquoted(sb, "Expires", new CookieDateFormat().format(new Date((((long) next.getMaxAge()) * 1000) + System.currentTimeMillis())));
                } else {
                    add(sb, (String) CookieHeaderNames.MAX_AGE, next.getMaxAge());
                }
            }
            if (next.getPath() != null) {
                if (next.getVersion() > 0) {
                    add(sb, (String) CookieHeaderNames.PATH, next.getPath());
                } else {
                    addUnquoted(sb, CookieHeaderNames.PATH, next.getPath());
                }
            }
            if (next.getDomain() != null) {
                if (next.getVersion() > 0) {
                    add(sb, (String) CookieHeaderNames.DOMAIN, next.getDomain());
                } else {
                    addUnquoted(sb, CookieHeaderNames.DOMAIN, next.getDomain());
                }
            }
            if (next.isSecure()) {
                sb.append(CookieHeaderNames.SECURE);
                sb.append(DefaultObjectDumpFormatter.TOKEN_DIVIDER);
            }
            if (next.isHttpOnly()) {
                sb.append(CookieHeaderNames.HTTPONLY);
                sb.append(DefaultObjectDumpFormatter.TOKEN_DIVIDER);
            }
            if (next.getVersion() >= 1) {
                if (next.getComment() != null) {
                    add(sb, (String) "Comment", next.getComment());
                }
                add(sb, (String) "Version", 1);
                if (next.getCommentUrl() != null) {
                    addQuoted(sb, CookieHeaderNames.COMMENTURL, next.getCommentUrl());
                }
                if (!next.getPorts().isEmpty()) {
                    sb.append(CookieHeaderNames.PORT);
                    sb.append('=');
                    sb.append(StringEscapeUtils.CSV_QUOTE);
                    for (Integer intValue : next.getPorts()) {
                        sb.append(intValue.intValue());
                        sb.append(',');
                    }
                    sb.setCharAt(sb.length() - 1, StringEscapeUtils.CSV_QUOTE);
                    sb.append(DefaultObjectDumpFormatter.TOKEN_DIVIDER);
                }
                if (next.isDiscard()) {
                    sb.append(CookieHeaderNames.DISCARD);
                    sb.append(DefaultObjectDumpFormatter.TOKEN_DIVIDER);
                }
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public void addCookie(String str, String str2) {
        this.cookies.add(new DefaultCookie(str, str2));
    }

    public String encode() {
        String str;
        if (this.server) {
            str = encodeServerSide();
        } else {
            str = encodeClientSide();
        }
        this.cookies.clear();
        return str;
    }

    public void addCookie(Cookie cookie) {
        this.cookies.add(cookie);
    }

    public static void add(StringBuilder sb, String str, int i) {
        sb.append(str);
        sb.append('=');
        sb.append(i);
        sb.append(DefaultObjectDumpFormatter.TOKEN_DIVIDER);
    }
}
