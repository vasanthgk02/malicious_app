package org.jboss.netty.handler.codec.http;

import com.razorpay.AnalyticsConstants;
import org.jboss.netty.util.internal.StringUtil;

public class DefaultHttpRequest extends DefaultHttpMessage implements HttpRequest {
    public HttpMethod method;
    public String uri;

    public DefaultHttpRequest(HttpVersion httpVersion, HttpMethod httpMethod, String str) {
        super(httpVersion);
        setMethod(httpMethod);
        setUri(str);
    }

    public HttpMethod getMethod() {
        return this.method;
    }

    public String getUri() {
        return this.uri;
    }

    public void setMethod(HttpMethod httpMethod) {
        if (httpMethod != null) {
            this.method = httpMethod;
            return;
        }
        throw new NullPointerException(AnalyticsConstants.METHOD);
    }

    public void setUri(String str) {
        if (str != null) {
            this.uri = str;
            return;
        }
        throw new NullPointerException("uri");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DefaultHttpRequest.class.getSimpleName());
        sb.append("(chunked: ");
        sb.append(isChunked());
        sb.append(')');
        sb.append(StringUtil.NEWLINE);
        sb.append(getMethod().toString());
        sb.append(' ');
        sb.append(getUri());
        sb.append(' ');
        sb.append(getProtocolVersion().getText());
        sb.append(StringUtil.NEWLINE);
        appendHeaders(sb);
        sb.setLength(sb.length() - StringUtil.NEWLINE.length());
        return sb.toString();
    }
}
