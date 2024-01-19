package org.jboss.netty.handler.codec.http;

import java.io.UnsupportedEncodingException;
import java.util.Map.Entry;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;
import org.jboss.netty.util.CharsetUtil;

public abstract class HttpMessageEncoder extends OneToOneEncoder {
    public static final ChannelBuffer LAST_CHUNK = ChannelBuffers.copiedBuffer((CharSequence) "0\r\n\r\n", CharsetUtil.US_ASCII);
    public volatile boolean chunked;

    private void encodeHeader(ChannelBuffer channelBuffer, String str, String str2) throws UnsupportedEncodingException {
        channelBuffer.writeBytes(str.getBytes("ASCII"));
        channelBuffer.writeByte(58);
        channelBuffer.writeByte(32);
        channelBuffer.writeBytes(str2.getBytes("ASCII"));
        channelBuffer.writeByte(13);
        channelBuffer.writeByte(10);
    }

    private void encodeHeaders(ChannelBuffer channelBuffer, HttpMessage httpMessage) {
        try {
            for (Entry next : httpMessage.getHeaders()) {
                encodeHeader(channelBuffer, (String) next.getKey(), (String) next.getValue());
            }
        } catch (UnsupportedEncodingException e2) {
            throw ((Error) new Error().initCause(e2));
        }
    }

    private void encodeTrailingHeaders(ChannelBuffer channelBuffer, HttpChunkTrailer httpChunkTrailer) {
        try {
            for (Entry next : httpChunkTrailer.getHeaders()) {
                encodeHeader(channelBuffer, (String) next.getKey(), (String) next.getValue());
            }
        } catch (UnsupportedEncodingException e2) {
            throw ((Error) new Error().initCause(e2));
        }
    }

    public Object encode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) throws Exception {
        if (obj instanceof HttpMessage) {
            HttpMessage httpMessage = (HttpMessage) obj;
            boolean isTransferEncodingChunked = HttpCodecUtil.isTransferEncodingChunked(httpMessage);
            this.chunked = isTransferEncodingChunked;
            ChannelBuffer dynamicBuffer = ChannelBuffers.dynamicBuffer(channel.getConfig().getBufferFactory());
            encodeInitialLine(dynamicBuffer, httpMessage);
            encodeHeaders(dynamicBuffer, httpMessage);
            dynamicBuffer.writeByte(13);
            dynamicBuffer.writeByte(10);
            ChannelBuffer content = httpMessage.getContent();
            if (!content.readable()) {
                return dynamicBuffer;
            }
            if (!isTransferEncodingChunked) {
                return ChannelBuffers.wrappedBuffer(dynamicBuffer, content);
            }
            throw new IllegalArgumentException("HttpMessage.content must be empty if Transfer-Encoding is chunked.");
        } else if (!(obj instanceof HttpChunk)) {
            return obj;
        } else {
            HttpChunk httpChunk = (HttpChunk) obj;
            if (this.chunked) {
                if (httpChunk.isLast()) {
                    this.chunked = false;
                    if (!(httpChunk instanceof HttpChunkTrailer)) {
                        return LAST_CHUNK.duplicate();
                    }
                    ChannelBuffer dynamicBuffer2 = ChannelBuffers.dynamicBuffer(channel.getConfig().getBufferFactory());
                    dynamicBuffer2.writeByte(48);
                    dynamicBuffer2.writeByte(13);
                    dynamicBuffer2.writeByte(10);
                    encodeTrailingHeaders(dynamicBuffer2, (HttpChunkTrailer) httpChunk);
                    dynamicBuffer2.writeByte(13);
                    dynamicBuffer2.writeByte(10);
                    return dynamicBuffer2;
                }
                ChannelBuffer content2 = httpChunk.getContent();
                int readableBytes = content2.readableBytes();
                return ChannelBuffers.wrappedBuffer(ChannelBuffers.copiedBuffer((CharSequence) Integer.toHexString(readableBytes), CharsetUtil.US_ASCII), ChannelBuffers.wrappedBuffer(HttpCodecUtil.CRLF), content2.slice(content2.readerIndex(), readableBytes), ChannelBuffers.wrappedBuffer(HttpCodecUtil.CRLF));
            } else if (httpChunk.isLast()) {
                return null;
            } else {
                return httpChunk.getContent();
            }
        }
    }

    public abstract void encodeInitialLine(ChannelBuffer channelBuffer, HttpMessage httpMessage) throws Exception;
}
