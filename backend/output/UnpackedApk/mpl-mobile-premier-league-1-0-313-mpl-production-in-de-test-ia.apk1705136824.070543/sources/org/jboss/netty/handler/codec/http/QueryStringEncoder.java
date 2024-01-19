package org.jboss.netty.handler.codec.http;

import com.facebook.react.bridge.ColorPropConverter;
import in.juspay.hypersdk.core.InflateView;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.List;

public class QueryStringEncoder {
    public final Charset charset;
    public final List<Param> params;
    public final String uri;

    public static final class Param {
        public final String name;
        public final String value;

        public Param(String str, String str2) {
            this.value = str2;
            this.name = str;
        }
    }

    public QueryStringEncoder(String str) {
        this(str, HttpCodecUtil.DEFAULT_CHARSET);
    }

    public static String encodeComponent(String str, Charset charset2) {
        try {
            return URLEncoder.encode(str, charset2.name()).replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException unused) {
            throw new UnsupportedCharsetException(charset2.name());
        }
    }

    public void addParam(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("name");
        } else if (str2 != null) {
            this.params.add(new Param(str, str2));
        } else {
            throw new NullPointerException(HSLCriteriaBuilder.VALUE);
        }
    }

    public String toString() {
        if (this.params.isEmpty()) {
            return this.uri;
        }
        StringBuilder sb = new StringBuilder(this.uri);
        sb.append(ColorPropConverter.PREFIX_ATTR);
        for (int i = 0; i < this.params.size(); i++) {
            Param param = this.params.get(i);
            sb.append(encodeComponent(param.name, this.charset));
            sb.append(InflateView.SETTER_EQUALS);
            sb.append(encodeComponent(param.value, this.charset));
            if (i != this.params.size() - 1) {
                sb.append("&");
            }
        }
        return sb.toString();
    }

    public URI toUri() throws URISyntaxException {
        return new URI(toString());
    }

    public QueryStringEncoder(String str, Charset charset2) {
        this.params = new ArrayList();
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
    public QueryStringEncoder(String str, String str2) {
        this(str, Charset.forName(str2));
    }
}
