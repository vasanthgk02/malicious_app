package org.jboss.netty.handler.codec.http;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.List;
import java.util.Map.Entry;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.handler.codec.frame.TooLongFrameException;
import org.jboss.netty.handler.codec.http.HttpHeaders.Names;
import org.jboss.netty.handler.codec.http.HttpHeaders.Values;

public class HttpChunkAggregator extends SimpleChannelUpstreamHandler {
    public HttpMessage currentMessage;
    public final int maxContentLength;

    public HttpChunkAggregator(int i) {
        if (i > 0) {
            this.maxContentLength = i;
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("maxContentLength must be a positive integer: ", i));
    }

    public void messageReceived(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) throws Exception {
        Object message = messageEvent.getMessage();
        HttpMessage httpMessage = this.currentMessage;
        if (message instanceof HttpMessage) {
            HttpMessage httpMessage2 = (HttpMessage) message;
            if (httpMessage2.isChunked()) {
                List<String> headers = httpMessage2.getHeaders(Names.TRANSFER_ENCODING);
                headers.remove(Values.CHUNKED);
                if (headers.isEmpty()) {
                    httpMessage2.removeHeader(Names.TRANSFER_ENCODING);
                }
                httpMessage2.setChunked(false);
                httpMessage2.setContent(ChannelBuffers.dynamicBuffer(messageEvent.getChannel().getConfig().getBufferFactory()));
                this.currentMessage = httpMessage2;
                return;
            }
            this.currentMessage = null;
            channelHandlerContext.sendUpstream(messageEvent);
        } else if (!(message instanceof HttpChunk)) {
            channelHandlerContext.sendUpstream(messageEvent);
        } else if (httpMessage != null) {
            HttpChunk httpChunk = (HttpChunk) message;
            ChannelBuffer content = httpMessage.getContent();
            if (content.readableBytes() <= this.maxContentLength - httpChunk.getContent().readableBytes()) {
                content.writeBytes(httpChunk.getContent());
                if (httpChunk.isLast()) {
                    this.currentMessage = null;
                    if (httpChunk instanceof HttpChunkTrailer) {
                        for (Entry next : ((HttpChunkTrailer) httpChunk).getHeaders()) {
                            httpMessage.setHeader((String) next.getKey(), next.getValue());
                        }
                    }
                    httpMessage.setHeader((String) "Content-Length", (Object) String.valueOf(content.readableBytes()));
                    Channels.fireMessageReceived(channelHandlerContext, (Object) httpMessage, messageEvent.getRemoteAddress());
                    return;
                }
                return;
            }
            throw new TooLongFrameException(GeneratedOutlineSupport.outline57(GeneratedOutlineSupport.outline73("HTTP content length exceeded "), this.maxContentLength, " bytes."));
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("received ");
            outline73.append(HttpChunk.class.getSimpleName());
            outline73.append(" without ");
            outline73.append(HttpMessage.class.getSimpleName());
            throw new IllegalStateException(outline73.toString());
        }
    }
}
