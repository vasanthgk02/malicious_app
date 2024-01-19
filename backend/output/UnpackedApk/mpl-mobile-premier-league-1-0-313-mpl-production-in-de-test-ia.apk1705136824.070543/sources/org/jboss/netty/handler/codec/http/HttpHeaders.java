package org.jboss.netty.handler.codec.http;

import in.juspay.hypersdk.core.InflateView;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class HttpHeaders {
    public static final int BUCKET_SIZE = 17;
    public final Entry[] entries = new Entry[17];
    public final Entry head;

    public static final class Entry implements java.util.Map.Entry<String, String> {
        public Entry after;
        public Entry before;
        public final int hash;
        public final String key;
        public Entry next;
        public String value;

        public Entry(int i, String str, String str2) {
            this.hash = i;
            this.key = str;
            this.value = str2;
        }

        public void addBefore(Entry entry) {
            this.after = entry;
            Entry entry2 = entry.before;
            this.before = entry2;
            entry2.after = this;
            this.after.before = this;
        }

        public void remove() {
            Entry entry = this.before;
            entry.after = this.after;
            this.after.before = entry;
        }

        public String toString() {
            return this.key + InflateView.SETTER_EQUALS + this.value;
        }

        public String getKey() {
            return this.key;
        }

        public String getValue() {
            return this.value;
        }

        public String setValue(String str) {
            if (str != null) {
                HttpCodecUtil.validateHeaderValue(str);
                String str2 = this.value;
                this.value = str;
                return str2;
            }
            throw new NullPointerException(HSLCriteriaBuilder.VALUE);
        }
    }

    public static final class Names {
        public static final String ACCEPT = "Accept";
        public static final String ACCEPT_CHARSET = "Accept-Charset";
        public static final String ACCEPT_ENCODING = "Accept-Encoding";
        public static final String ACCEPT_LANGUAGE = "Accept-Language";
        public static final String ACCEPT_PATCH = "Accept-Patch";
        public static final String ACCEPT_RANGES = "Accept-Ranges";
        public static final String AGE = "Age";
        public static final String ALLOW = "Allow";
        public static final String AUTHORIZATION = "Authorization";
        public static final String CACHE_CONTROL = "Cache-Control";
        public static final String CONNECTION = "Connection";
        public static final String CONTENT_BASE = "Content-Base";
        public static final String CONTENT_ENCODING = "Content-Encoding";
        public static final String CONTENT_LANGUAGE = "Content-Language";
        public static final String CONTENT_LENGTH = "Content-Length";
        public static final String CONTENT_LOCATION = "Content-Location";
        public static final String CONTENT_MD5 = "Content-MD5";
        public static final String CONTENT_RANGE = "Content-Range";
        public static final String CONTENT_TRANSFER_ENCODING = "Content-Transfer-Encoding";
        public static final String CONTENT_TYPE = "Content-Type";
        public static final String COOKIE = "Cookie";
        public static final String DATE = "Date";
        public static final String ETAG = "ETag";
        public static final String EXPECT = "Expect";
        public static final String EXPIRES = "Expires";
        public static final String FROM = "From";
        public static final String HOST = "Host";
        public static final String IF_MATCH = "If-Match";
        public static final String IF_MODIFIED_SINCE = "If-Modified-Since";
        public static final String IF_NONE_MATCH = "If-None-Match";
        public static final String IF_RANGE = "If-Range";
        public static final String IF_UNMODIFIED_SINCE = "If-Unmodified-Since";
        public static final String LAST_MODIFIED = "Last-Modified";
        public static final String LOCATION = "Location";
        public static final String MAX_FORWARDS = "Max-Forwards";
        public static final String ORIGIN = "Origin";
        public static final String PRAGMA = "Pragma";
        public static final String PROXY_AUTHENTICATE = "Proxy-Authenticate";
        public static final String PROXY_AUTHORIZATION = "Proxy-Authorization";
        public static final String RANGE = "Range";
        public static final String REFERER = "Referer";
        public static final String RETRY_AFTER = "Retry-After";
        public static final String SEC_WEBSOCKET_KEY1 = "Sec-WebSocket-Key1";
        public static final String SEC_WEBSOCKET_KEY2 = "Sec-WebSocket-Key2";
        public static final String SEC_WEBSOCKET_LOCATION = "Sec-WebSocket-Location";
        public static final String SEC_WEBSOCKET_ORIGIN = "Sec-WebSocket-Origin";
        public static final String SEC_WEBSOCKET_PROTOCOL = "Sec-WebSocket-Protocol";
        public static final String SERVER = "Server";
        public static final String SET_COOKIE = "Set-Cookie";
        public static final String SET_COOKIE2 = "Set-Cookie2";
        public static final String TE = "TE";
        public static final String TRAILER = "Trailer";
        public static final String TRANSFER_ENCODING = "Transfer-Encoding";
        public static final String UPGRADE = "Upgrade";
        public static final String USER_AGENT = "User-Agent";
        public static final String VARY = "Vary";
        public static final String VIA = "Via";
        public static final String WARNING = "Warning";
        public static final String WEBSOCKET_LOCATION = "WebSocket-Location";
        public static final String WEBSOCKET_ORIGIN = "WebSocket-Origin";
        public static final String WEBSOCKET_PROTOCOL = "WebSocket-Protocol";
        public static final String WWW_AUTHENTICATE = "WWW-Authenticate";
    }

    public static final class Values {
        public static final String BASE64 = "base64";
        public static final String BINARY = "binary";
        public static final String BYTES = "bytes";
        public static final String CHARSET = "charset";
        public static final String CHUNKED = "chunked";
        public static final String CLOSE = "close";
        public static final String COMPRESS = "compress";
        public static final String CONTINUE = "100-continue";
        public static final String DEFLATE = "deflate";
        public static final String GZIP = "gzip";
        public static final String IDENTITY = "identity";
        public static final String KEEP_ALIVE = "keep-alive";
        public static final String MAX_AGE = "max-age";
        public static final String MAX_STALE = "max-stale";
        public static final String MIN_FRESH = "min-fresh";
        public static final String MUST_REVALIDATE = "must-revalidate";
        public static final String NONE = "none";
        public static final String NO_CACHE = "no-cache";
        public static final String NO_STORE = "no-store";
        public static final String NO_TRANSFORM = "no-transform";
        public static final String ONLY_IF_CACHED = "only-if-cached";
        public static final String PRIVATE = "private";
        public static final String PROXY_REVALIDATE = "proxy-revalidate";
        public static final String PUBLIC = "public";
        public static final String QUOTED_PRINTABLE = "quoted-printable";
        public static final String S_MAXAGE = "s-maxage";
        public static final String TRAILERS = "trailers";
        public static final String UPGRADE = "Upgrade";
        public static final String WEBSOCKET = "WebSocket";
    }

    public HttpHeaders() {
        Entry entry = new Entry(-1, null, null);
        this.head = entry;
        entry.after = entry;
        entry.before = entry;
    }

    public static void addHeader(HttpMessage httpMessage, String str, Object obj) {
        httpMessage.addHeader(str, obj);
    }

    private void addHeader0(int i, int i2, String str, String str2) {
        Entry[] entryArr = this.entries;
        Entry entry = entryArr[i2];
        Entry entry2 = new Entry(i, str, str2);
        entryArr[i2] = entry2;
        entry2.next = entry;
        entry2.addBefore(this.head);
    }

    public static void addIntHeader(HttpMessage httpMessage, String str, int i) {
        httpMessage.addHeader(str, Integer.valueOf(i));
    }

    public static boolean eq(String str, String str2) {
        int length = str.length();
        if (length != str2.length()) {
            return false;
        }
        for (int i = length - 1; i >= 0; i--) {
            char charAt = str.charAt(i);
            char charAt2 = str2.charAt(i);
            if (charAt != charAt2) {
                if (charAt >= 'A' && charAt <= 'Z') {
                    charAt = (char) (charAt + ' ');
                }
                if (charAt2 >= 'A' && charAt2 <= 'Z') {
                    charAt2 = (char) (charAt2 + ' ');
                }
                if (charAt != charAt2) {
                    return false;
                }
            }
        }
        return true;
    }

    public static long getContentLength(HttpMessage httpMessage) {
        return getContentLength(httpMessage, 0);
    }

    public static String getHeader(HttpMessage httpMessage, String str) {
        return httpMessage.getHeader(str);
    }

    public static String getHost(HttpMessage httpMessage) {
        return httpMessage.getHeader("Host");
    }

    public static int getIntHeader(HttpMessage httpMessage, String str) {
        String header = getHeader(httpMessage, str);
        if (header != null) {
            return Integer.parseInt(header);
        }
        throw new NumberFormatException("null");
    }

    public static int hash(String str) {
        int i = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            char charAt = str.charAt(length);
            if (charAt >= 'A' && charAt <= 'Z') {
                charAt = (char) (charAt + ' ');
            }
            i = (i * 31) + charAt;
        }
        if (i > 0) {
            return i;
        }
        if (i == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return -i;
    }

    public static int index(int i) {
        return i % 17;
    }

    public static boolean isKeepAlive(HttpMessage httpMessage) {
        String header = httpMessage.getHeader("Connection");
        if ("close".equalsIgnoreCase(header)) {
            return false;
        }
        if (httpMessage.getProtocolVersion().isKeepAliveDefault()) {
            return !"close".equalsIgnoreCase(header);
        }
        return "keep-alive".equalsIgnoreCase(header);
    }

    private void removeHeader0(int i, int i2, String str) {
        Entry entry = this.entries[i2];
        if (entry != null) {
            while (entry.hash == i && eq(str, entry.key)) {
                entry.remove();
                entry = entry.next;
                if (entry != null) {
                    this.entries[i2] = entry;
                } else {
                    this.entries[i2] = null;
                    return;
                }
            }
            while (true) {
                Entry entry2 = entry.next;
                if (entry2 != null) {
                    if (entry2.hash != i || !eq(str, entry2.key)) {
                        entry = entry2;
                    } else {
                        entry.next = entry2.next;
                        entry2.remove();
                    }
                } else {
                    return;
                }
            }
        }
    }

    public static void setContentLength(HttpMessage httpMessage, long j) {
        httpMessage.setHeader((String) "Content-Length", (Object) Long.valueOf(j));
    }

    public static void setHeader(HttpMessage httpMessage, String str, Object obj) {
        httpMessage.setHeader(str, obj);
    }

    public static void setHost(HttpMessage httpMessage, String str) {
        httpMessage.setHeader((String) "Host", (Object) str);
    }

    public static void setIntHeader(HttpMessage httpMessage, String str, int i) {
        httpMessage.setHeader(str, (Object) Integer.valueOf(i));
    }

    public static void setKeepAlive(HttpMessage httpMessage, boolean z) {
        if (httpMessage.getProtocolVersion().isKeepAliveDefault()) {
            if (z) {
                httpMessage.removeHeader("Connection");
            } else {
                httpMessage.setHeader((String) "Connection", (Object) "close");
            }
        } else if (z) {
            httpMessage.setHeader((String) "Connection", (Object) "keep-alive");
        } else {
            httpMessage.removeHeader("Connection");
        }
    }

    public static String toString(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public void clearHeaders() {
        int i = 0;
        while (true) {
            Entry[] entryArr = this.entries;
            if (i < entryArr.length) {
                entryArr[i] = null;
                i++;
            } else {
                Entry entry = this.head;
                entry.after = entry;
                entry.before = entry;
                return;
            }
        }
    }

    public boolean containsHeader(String str) {
        return getHeader(str) != null;
    }

    public Set<String> getHeaderNames() {
        TreeSet treeSet = new TreeSet(CaseIgnoringComparator.INSTANCE);
        for (Entry entry = this.head.after; entry != this.head; entry = entry.after) {
            treeSet.add(entry.key);
        }
        return treeSet;
    }

    public List<String> getHeaders(String str) {
        if (str != null) {
            LinkedList linkedList = new LinkedList();
            int hash = hash(str);
            for (Entry entry = this.entries[index(hash)]; entry != null; entry = entry.next) {
                if (entry.hash == hash && eq(str, entry.key)) {
                    linkedList.addFirst(entry.value);
                }
            }
            return linkedList;
        }
        throw new NullPointerException("name");
    }

    public void removeHeader(String str) {
        if (str != null) {
            int hash = hash(str);
            removeHeader0(hash, index(hash), str);
            return;
        }
        throw new NullPointerException("name");
    }

    public void validateHeaderName(String str) {
        HttpCodecUtil.validateHeaderName(str);
    }

    public static long getContentLength(HttpMessage httpMessage, long j) {
        String header = httpMessage.getHeader("Content-Length");
        if (header != null) {
            return Long.parseLong(header);
        }
        if (httpMessage instanceof HttpRequest) {
            HttpRequest httpRequest = (HttpRequest) httpMessage;
            if (HttpMethod.GET.equals(httpRequest.getMethod()) && httpRequest.containsHeader(Names.SEC_WEBSOCKET_KEY1) && httpRequest.containsHeader(Names.SEC_WEBSOCKET_KEY2)) {
                return 8;
            }
        } else if (httpMessage instanceof HttpResponse) {
            HttpResponse httpResponse = (HttpResponse) httpMessage;
            if (httpResponse.getStatus().getCode() == 101 && httpResponse.containsHeader(Names.SEC_WEBSOCKET_ORIGIN) && httpResponse.containsHeader(Names.SEC_WEBSOCKET_LOCATION)) {
                return 16;
            }
        }
        return j;
    }

    public static String getHeader(HttpMessage httpMessage, String str, String str2) {
        String header = httpMessage.getHeader(str);
        return header == null ? str2 : header;
    }

    public static String getHost(HttpMessage httpMessage, String str) {
        return getHeader(httpMessage, "Host", str);
    }

    public static void setHeader(HttpMessage httpMessage, String str, Iterable<?> iterable) {
        httpMessage.setHeader(str, iterable);
    }

    public static void setIntHeader(HttpMessage httpMessage, String str, Iterable<Integer> iterable) {
        httpMessage.setHeader(str, iterable);
    }

    public void addHeader(String str, Object obj) {
        validateHeaderName(str);
        String httpHeaders = toString(obj);
        HttpCodecUtil.validateHeaderValue(httpHeaders);
        int hash = hash(str);
        addHeader0(hash, index(hash), str, httpHeaders);
    }

    public String getHeader(String str) {
        if (str != null) {
            int hash = hash(str);
            for (Entry entry = this.entries[index(hash)]; entry != null; entry = entry.next) {
                if (entry.hash == hash && eq(str, entry.key)) {
                    return entry.value;
                }
            }
            return null;
        }
        throw new NullPointerException("name");
    }

    public void setHeader(String str, Object obj) {
        validateHeaderName(str);
        String httpHeaders = toString(obj);
        HttpCodecUtil.validateHeaderValue(httpHeaders);
        int hash = hash(str);
        int index = index(hash);
        removeHeader0(hash, index, str);
        addHeader0(hash, index, str, httpHeaders);
    }

    public static int getIntHeader(HttpMessage httpMessage, String str, int i) {
        String header = getHeader(httpMessage, str);
        if (header == null) {
            return i;
        }
        try {
            return Integer.parseInt(header);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public List<java.util.Map.Entry<String, String>> getHeaders() {
        LinkedList linkedList = new LinkedList();
        for (Entry entry = this.head.after; entry != this.head; entry = entry.after) {
            linkedList.add(entry);
        }
        return linkedList;
    }

    public void setHeader(String str, Iterable<?> iterable) {
        if (iterable != null) {
            validateHeaderName(str);
            int hash = hash(str);
            int index = index(hash);
            removeHeader0(hash, index, str);
            for (Object next : iterable) {
                if (next != null) {
                    String httpHeaders = toString(next);
                    HttpCodecUtil.validateHeaderValue(httpHeaders);
                    addHeader0(hash, index, str, httpHeaders);
                } else {
                    return;
                }
            }
            return;
        }
        throw new NullPointerException("values");
    }
}
