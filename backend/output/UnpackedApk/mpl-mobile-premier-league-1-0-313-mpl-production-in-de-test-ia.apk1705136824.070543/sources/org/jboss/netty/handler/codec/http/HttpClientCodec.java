package org.jboss.netty.handler.codec.http;

import java.util.Queue;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelDownstreamHandler;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelUpstreamHandler;
import org.jboss.netty.handler.codec.http.HttpMessageDecoder.State;
import org.jboss.netty.util.internal.LinkedTransferQueue;

public class HttpClientCodec implements ChannelUpstreamHandler, ChannelDownstreamHandler {
    public final HttpResponseDecoder decoder;
    public volatile boolean done;
    public final HttpRequestEncoder encoder;
    public final Queue<HttpMethod> queue;

    public final class Decoder extends HttpResponseDecoder {
        public Decoder(int i, int i2, int i3) {
            super(i, i2, i3);
        }

        public boolean isContentAlwaysEmpty(HttpMessage httpMessage) {
            HttpMethod poll = HttpClientCodec.this.queue.poll();
            char charAt = poll.getName().charAt(0);
            if (charAt != 'C') {
                if (charAt == 'H' && HttpMethod.HEAD.equals(poll)) {
                    return !httpMessage.isChunked();
                }
            } else if (((HttpResponse) httpMessage).getStatus().getCode() == 200 && HttpMethod.CONNECT.equals(poll)) {
                HttpClientCodec.this.done = true;
                HttpClientCodec.this.queue.clear();
                return true;
            }
            return super.isContentAlwaysEmpty(httpMessage);
        }

        public Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, State state) throws Exception {
            if (HttpClientCodec.this.done) {
                return channelBuffer.readBytes(actualReadableBytes());
            }
            return super.decode(channelHandlerContext, channel, channelBuffer, state);
        }
    }

    public final class Encoder extends HttpRequestEncoder {
        public Encoder() {
        }

        public Object encode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) throws Exception {
            if ((obj instanceof HttpRequest) && !HttpClientCodec.this.done) {
                HttpClientCodec.this.queue.offer(((HttpRequest) obj).getMethod());
            }
            return super.encode(channelHandlerContext, channel, obj);
        }
    }

    public HttpClientCodec() {
        this(4096, 8192, 8192);
    }

    public void handleDownstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) throws Exception {
        this.encoder.handleDownstream(channelHandlerContext, channelEvent);
    }

    public void handleUpstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) throws Exception {
        this.decoder.handleUpstream(channelHandlerContext, channelEvent);
    }

    public HttpClientCodec(int i, int i2, int i3) {
        this.queue = new LinkedTransferQueue();
        this.encoder = new Encoder();
        this.decoder = new Decoder(i, i2, i3);
    }
}
