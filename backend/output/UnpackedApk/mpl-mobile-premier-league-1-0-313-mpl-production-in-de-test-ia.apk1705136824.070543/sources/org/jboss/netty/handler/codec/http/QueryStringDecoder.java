package org.jboss.netty.handler.codec.http;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class QueryStringDecoder {
    public final Charset charset;
    public Map<String, List<String>> params;
    public String path;
    public final String uri;

    public QueryStringDecoder(String str) {
        this(str, HttpCodecUtil.DEFAULT_CHARSET);
    }

    public static void addParam(Map<String, List<String>> map, String str, String str2) {
        List list = map.get(str);
        if (list == null) {
            list = new ArrayList(1);
            map.put(str, list);
        }
        list.add(str2);
    }

    public static String decodeComponent(String str, Charset charset2) {
        if (str == null) {
            return "";
        }
        try {
            return URLDecoder.decode(str, charset2.name());
        } catch (UnsupportedEncodingException unused) {
            throw new UnsupportedCharsetException(charset2.name());
        }
    }

    private Map<String, List<String>> decodeParams(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 0;
        String str2 = null;
        int i2 = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt == '=' && str2 == null) {
                if (i2 != i) {
                    str2 = decodeComponent(str.substring(i2, i), this.charset);
                }
            } else if (charAt != '&') {
                i++;
            } else if (str2 == null && i2 != i) {
                addParam(linkedHashMap, decodeComponent(str.substring(i2, i), this.charset), "");
            } else if (str2 != null) {
                addParam(linkedHashMap, str2, decodeComponent(str.substring(i2, i), this.charset));
                str2 = null;
            }
            i2 = i + 1;
            i++;
        }
        if (i2 != i) {
            if (str2 == null) {
                addParam(linkedHashMap, decodeComponent(str.substring(i2, i), this.charset), "");
            } else {
                addParam(linkedHashMap, str2, decodeComponent(str.substring(i2, i), this.charset));
            }
        } else if (str2 != null) {
            addParam(linkedHashMap, str2, "");
        }
        return linkedHashMap;
    }

    public Map<String, List<String>> getParameters() {
        if (this.params == null) {
            int length = getPath().length();
            if (this.uri.length() == length) {
                return Collections.emptyMap();
            }
            this.params = decodeParams(this.uri.substring(length + 1));
        }
        return this.params;
    }

    public String getPath() {
        if (this.path == null) {
            int indexOf = this.uri.indexOf(63);
            if (indexOf < 0) {
                this.path = this.uri;
            } else {
                String substring = this.uri.substring(0, indexOf);
                this.path = substring;
                return substring;
            }
        }
        return this.path;
    }

    public QueryStringDecoder(String str, Charset charset2) {
        if (str == null) {
            throw new NullPointerException("uri");
        } else if (charset2 != null) {
            this.uri = str;
            this.charset = charset2;
        } else {
            throw new NullPointerException("charset");
        }
    }

    @Deprecated
    public QueryStringDecoder(String str, String str2) {
        this(str, Charset.forName(str2));
    }

    public QueryStringDecoder(URI uri2) {
        this(uri2, HttpCodecUtil.DEFAULT_CHARSET);
    }

    public QueryStringDecoder(URI uri2, Charset charset2) {
        if (uri2 == null) {
            throw new NullPointerException("uri");
        } else if (charset2 != null) {
            this.uri = uri2.toASCIIString();
            this.charset = charset2;
        } else {
            throw new NullPointerException("charset");
        }
    }

    @Deprecated
    public QueryStringDecoder(URI uri2, String str) {
        this(uri2, Charset.forName(str));
    }
}
