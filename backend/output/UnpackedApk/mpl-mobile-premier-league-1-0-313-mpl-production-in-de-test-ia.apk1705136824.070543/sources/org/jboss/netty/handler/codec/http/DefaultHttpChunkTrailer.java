package org.jboss.netty.handler.codec.http;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.handler.codec.http.HttpHeaders.Names;

public class DefaultHttpChunkTrailer implements HttpChunkTrailer {
    public final HttpHeaders headers = new HttpHeaders() {
        public void validateHeaderName(String str) {
            super.validateHeaderName(str);
            if (str.equalsIgnoreCase("Content-Length") || str.equalsIgnoreCase(Names.TRANSFER_ENCODING) || str.equalsIgnoreCase(Names.TRAILER)) {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("prohibited trailing header: ", str));
            }
        }
    };

    public void addHeader(String str, Object obj) {
        this.headers.addHeader(str, obj);
    }

    public void clearHeaders() {
        this.headers.clearHeaders();
    }

    public boolean containsHeader(String str) {
        return this.headers.containsHeader(str);
    }

    public ChannelBuffer getContent() {
        return ChannelBuffers.EMPTY_BUFFER;
    }

    public String getHeader(String str) {
        return this.headers.getHeader(str);
    }

    public Set<String> getHeaderNames() {
        return this.headers.getHeaderNames();
    }

    public List<String> getHeaders(String str) {
        return this.headers.getHeaders(str);
    }

    public boolean isLast() {
        return true;
    }

    public void removeHeader(String str) {
        this.headers.removeHeader(str);
    }

    public void setContent(ChannelBuffer channelBuffer) {
        throw new IllegalStateException("read-only");
    }

    public void setHeader(String str, Object obj) {
        this.headers.setHeader(str, obj);
    }

    public List<Entry<String, String>> getHeaders() {
        return this.headers.getHeaders();
    }

    public void setHeader(String str, Iterable<?> iterable) {
        this.headers.setHeader(str, iterable);
    }
}
