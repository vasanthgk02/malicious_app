package org.jboss.netty.handler.codec.http;

import org.jboss.netty.buffer.ChannelBuffer;

public class HttpRequestEncoder extends HttpMessageEncoder {
    public void encodeInitialLine(ChannelBuffer channelBuffer, HttpMessage httpMessage) throws Exception {
        HttpRequest httpRequest = (HttpRequest) httpMessage;
        channelBuffer.writeBytes(httpRequest.getMethod().toString().getBytes("ASCII"));
        channelBuffer.writeByte(32);
        channelBuffer.writeBytes(httpRequest.getUri().getBytes("ASCII"));
        channelBuffer.writeByte(32);
        channelBuffer.writeBytes(httpRequest.getProtocolVersion().toString().getBytes("ASCII"));
        channelBuffer.writeByte(13);
        channelBuffer.writeByte(10);
    }
}
