package org.jboss.netty.handler.codec.http;

public class HttpRequestDecoder extends HttpMessageDecoder {
    public HttpRequestDecoder() {
    }

    public HttpMessage createMessage(String[] strArr) throws Exception {
        return new DefaultHttpRequest(HttpVersion.valueOf(strArr[2]), HttpMethod.valueOf(strArr[0]), strArr[1]);
    }

    public boolean isDecodingRequest() {
        return true;
    }

    public HttpRequestDecoder(int i, int i2, int i3) {
        super(i, i2, i3);
    }
}
