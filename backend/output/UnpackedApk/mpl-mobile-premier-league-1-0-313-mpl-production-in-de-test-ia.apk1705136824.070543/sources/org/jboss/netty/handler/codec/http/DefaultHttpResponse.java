package org.jboss.netty.handler.codec.http;

import org.jboss.netty.util.internal.StringUtil;

public class DefaultHttpResponse extends DefaultHttpMessage implements HttpResponse {
    public HttpResponseStatus status;

    public DefaultHttpResponse(HttpVersion httpVersion, HttpResponseStatus httpResponseStatus) {
        super(httpVersion);
        setStatus(httpResponseStatus);
    }

    public HttpResponseStatus getStatus() {
        return this.status;
    }

    public void setStatus(HttpResponseStatus httpResponseStatus) {
        if (httpResponseStatus != null) {
            this.status = httpResponseStatus;
            return;
        }
        throw new NullPointerException("status");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DefaultHttpResponse.class.getSimpleName());
        sb.append("(chunked: ");
        sb.append(isChunked());
        sb.append(')');
        sb.append(StringUtil.NEWLINE);
        sb.append(getProtocolVersion().getText());
        sb.append(' ');
        sb.append(getStatus().toString());
        sb.append(StringUtil.NEWLINE);
        appendHeaders(sb);
        sb.setLength(sb.length() - StringUtil.NEWLINE.length());
        return sb.toString();
    }
}
