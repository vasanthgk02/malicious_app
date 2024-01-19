package org.jboss.netty.handler.codec.http;

import java.util.Queue;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.handler.codec.embedder.EncoderEmbedder;
import org.jboss.netty.util.internal.LinkedTransferQueue;

public abstract class HttpContentEncoder extends SimpleChannelHandler {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public final Queue<String> acceptEncodingQueue = new LinkedTransferQueue();
    public volatile EncoderEmbedder<ChannelBuffer> encoder;

    private ChannelBuffer encode(ChannelBuffer channelBuffer) {
        this.encoder.offer(channelBuffer);
        return ChannelBuffers.wrappedBuffer((ChannelBuffer[]) this.encoder.pollAll(new ChannelBuffer[this.encoder.size()]));
    }

    private ChannelBuffer finishEncode() {
        ChannelBuffer channelBuffer;
        if (this.encoder.finish()) {
            channelBuffer = ChannelBuffers.wrappedBuffer((ChannelBuffer[]) this.encoder.pollAll(new ChannelBuffer[this.encoder.size()]));
        } else {
            channelBuffer = ChannelBuffers.EMPTY_BUFFER;
        }
        this.encoder = null;
        return channelBuffer;
    }

    public abstract String getTargetContentEncoding(String str) throws Exception;

    public void messageReceived(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) throws Exception {
        Object message = messageEvent.getMessage();
        if (!(message instanceof HttpMessage)) {
            channelHandlerContext.sendUpstream(messageEvent);
            return;
        }
        String header = ((HttpMessage) message).getHeader("Accept-Encoding");
        if (header == null) {
            header = "identity";
        }
        this.acceptEncodingQueue.offer(header);
        channelHandlerContext.sendUpstream(messageEvent);
    }

    public abstract EncoderEmbedder<ChannelBuffer> newContentEncoder(String str) throws Exception;

    public void writeRequested(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) throws Exception {
        Object message = messageEvent.getMessage();
        if (message instanceof HttpMessage) {
            HttpMessage httpMessage = (HttpMessage) message;
            this.encoder = null;
            String poll = this.acceptEncodingQueue.poll();
            if (poll != null) {
                EncoderEmbedder<ChannelBuffer> newContentEncoder = newContentEncoder(poll);
                this.encoder = newContentEncoder;
                if (newContentEncoder != null) {
                    httpMessage.setHeader((String) "Content-Encoding", (Object) getTargetContentEncoding(poll));
                    if (!httpMessage.isChunked()) {
                        ChannelBuffer wrappedBuffer = ChannelBuffers.wrappedBuffer(encode(httpMessage.getContent()), finishEncode());
                        httpMessage.setContent(wrappedBuffer);
                        if (httpMessage.containsHeader("Content-Length")) {
                            httpMessage.setHeader((String) "Content-Length", (Object) Integer.toString(wrappedBuffer.readableBytes()));
                        }
                    }
                }
                channelHandlerContext.sendDownstream(messageEvent);
                return;
            }
            throw new IllegalStateException("cannot send more responses than requests");
        } else if (message instanceof HttpChunk) {
            HttpChunk httpChunk = (HttpChunk) message;
            ChannelBuffer content = httpChunk.getContent();
            if (this.encoder == null) {
                channelHandlerContext.sendDownstream(messageEvent);
            } else if (!httpChunk.isLast()) {
                ChannelBuffer encode = encode(content);
                if (encode.readable()) {
                    httpChunk.setContent(encode);
                    channelHandlerContext.sendDownstream(messageEvent);
                }
            } else {
                ChannelBuffer finishEncode = finishEncode();
                if (finishEncode.readable()) {
                    Channels.write(channelHandlerContext, Channels.succeededFuture(messageEvent.getChannel()), new DefaultHttpChunk(finishEncode), messageEvent.getRemoteAddress());
                }
                channelHandlerContext.sendDownstream(messageEvent);
            }
        } else {
            channelHandlerContext.sendDownstream(messageEvent);
        }
    }
}
