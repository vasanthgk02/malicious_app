package org.jboss.netty.handler.codec.http;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.util.internal.StringUtil;

public class DefaultHttpMessage implements HttpMessage {
    public boolean chunked;
    public ChannelBuffer content = ChannelBuffers.EMPTY_BUFFER;
    public final HttpHeaders headers = new HttpHeaders();
    public HttpVersion version;

    public DefaultHttpMessage(HttpVersion httpVersion) {
        setProtocolVersion(httpVersion);
    }

    public void addHeader(String str, Object obj) {
        this.headers.addHeader(str, obj);
    }

    public void appendHeaders(StringBuilder sb) {
        for (Entry next : getHeaders()) {
            sb.append((String) next.getKey());
            sb.append(": ");
            sb.append((String) next.getValue());
            sb.append(StringUtil.NEWLINE);
        }
    }

    public void clearHeaders() {
        this.headers.clearHeaders();
    }

    public boolean containsHeader(String str) {
        return this.headers.containsHeader(str);
    }

    public ChannelBuffer getContent() {
        return this.content;
    }

    @Deprecated
    public long getContentLength() {
        return HttpHeaders.getContentLength(this);
    }

    public String getHeader(String str) {
        List<String> headers2 = getHeaders(str);
        if (headers2.size() > 0) {
            return headers2.get(0);
        }
        return null;
    }

    public Set<String> getHeaderNames() {
        return this.headers.getHeaderNames();
    }

    public List<String> getHeaders(String str) {
        return this.headers.getHeaders(str);
    }

    public HttpVersion getProtocolVersion() {
        return this.version;
    }

    public boolean isChunked() {
        if (this.chunked) {
            return true;
        }
        return HttpCodecUtil.isTransferEncodingChunked(this);
    }

    @Deprecated
    public boolean isKeepAlive() {
        return HttpHeaders.isKeepAlive(this);
    }

    public void removeHeader(String str) {
        this.headers.removeHeader(str);
    }

    public void setChunked(boolean z) {
        this.chunked = z;
        if (z) {
            setContent(ChannelBuffers.EMPTY_BUFFER);
        }
    }

    public void setContent(ChannelBuffer channelBuffer) {
        if (channelBuffer == null) {
            channelBuffer = ChannelBuffers.EMPTY_BUFFER;
        }
        if (!channelBuffer.readable() || !isChunked()) {
            this.content = channelBuffer;
            return;
        }
        throw new IllegalArgumentException("non-empty content disallowed if this.chunked == true");
    }

    public void setHeader(String str, Object obj) {
        this.headers.setHeader(str, obj);
    }

    public void setProtocolVersion(HttpVersion httpVersion) {
        if (httpVersion != null) {
            this.version = httpVersion;
            return;
        }
        throw new NullPointerException("version");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(version: ");
        sb.append(getProtocolVersion().getText());
        sb.append(", keepAlive: ");
        sb.append(isKeepAlive());
        sb.append(", chunked: ");
        sb.append(isChunked());
        sb.append(')');
        sb.append(StringUtil.NEWLINE);
        appendHeaders(sb);
        sb.setLength(sb.length() - StringUtil.NEWLINE.length());
        return sb.toString();
    }

    @Deprecated
    public long getContentLength(long j) {
        return HttpHeaders.getContentLength(this, j);
    }

    public List<Entry<String, String>> getHeaders() {
        return this.headers.getHeaders();
    }

    public void setHeader(String str, Iterable<?> iterable) {
        this.headers.setHeader(str, iterable);
    }
}
