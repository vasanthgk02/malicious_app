package com.bumptech.glide.load.model;

import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public final class LazyHeaders implements Headers {
    public volatile Map<String, String> combinedHeaders;
    public final Map<String, List<LazyHeaderFactory>> headers;

    public static final class Builder {
        public static final Map<String, List<LazyHeaderFactory>> DEFAULT_HEADERS;
        public static final String DEFAULT_USER_AGENT;
        public boolean copyOnModify = true;
        public Map<String, List<LazyHeaderFactory>> headers = DEFAULT_HEADERS;
        public boolean isUserAgentDefault = true;

        static {
            String property = System.getProperty("http.agent");
            if (!TextUtils.isEmpty(property)) {
                int length = property.length();
                StringBuilder sb = new StringBuilder(property.length());
                for (int i = 0; i < length; i++) {
                    char charAt = property.charAt(i);
                    if ((charAt > 31 || charAt == 9) && charAt < 127) {
                        sb.append(charAt);
                    } else {
                        sb.append('?');
                    }
                }
                property = sb.toString();
            }
            DEFAULT_USER_AGENT = property;
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(DEFAULT_USER_AGENT)) {
                hashMap.put("User-Agent", Collections.singletonList(new StringHeaderFactory(DEFAULT_USER_AGENT)));
            }
            DEFAULT_HEADERS = Collections.unmodifiableMap(hashMap);
        }

        public final void copyIfNecessary() {
            if (this.copyOnModify) {
                this.copyOnModify = false;
                HashMap hashMap = new HashMap(this.headers.size());
                for (Entry next : this.headers.entrySet()) {
                    hashMap.put(next.getKey(), new ArrayList((Collection) next.getValue()));
                }
                this.headers = hashMap;
            }
        }
    }

    public static final class StringHeaderFactory implements LazyHeaderFactory {
        public final String value;

        public StringHeaderFactory(String str) {
            this.value = str;
        }

        public String buildHeader() {
            return this.value;
        }

        public boolean equals(Object obj) {
            if (obj instanceof StringHeaderFactory) {
                return this.value.equals(((StringHeaderFactory) obj).value);
            }
            return false;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return GeneratedOutlineSupport.outline60(GeneratedOutlineSupport.outline73("StringHeaderFactory{value='"), this.value, ExtendedMessageFormat.QUOTE, '}');
        }
    }

    public LazyHeaders(Map<String, List<LazyHeaderFactory>> map) {
        this.headers = Collections.unmodifiableMap(map);
    }

    public boolean equals(Object obj) {
        if (obj instanceof LazyHeaders) {
            return this.headers.equals(((LazyHeaders) obj).headers);
        }
        return false;
    }

    public final Map<String, String> generateHeaders() {
        HashMap hashMap = new HashMap();
        for (Entry next : this.headers.entrySet()) {
            List list = (List) next.getValue();
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                String buildHeader = ((LazyHeaderFactory) list.get(i)).buildHeader();
                if (!TextUtils.isEmpty(buildHeader)) {
                    sb.append(buildHeader);
                    if (i != list.size() - 1) {
                        sb.append(',');
                    }
                }
            }
            String sb2 = sb.toString();
            if (!TextUtils.isEmpty(sb2)) {
                hashMap.put(next.getKey(), sb2);
            }
        }
        return hashMap;
    }

    public Map<String, String> getHeaders() {
        if (this.combinedHeaders == null) {
            synchronized (this) {
                if (this.combinedHeaders == null) {
                    this.combinedHeaders = Collections.unmodifiableMap(generateHeaders());
                }
            }
        }
        return this.combinedHeaders;
    }

    public int hashCode() {
        return this.headers.hashCode();
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("LazyHeaders{headers=");
        outline73.append(this.headers);
        outline73.append('}');
        return outline73.toString();
    }
}
