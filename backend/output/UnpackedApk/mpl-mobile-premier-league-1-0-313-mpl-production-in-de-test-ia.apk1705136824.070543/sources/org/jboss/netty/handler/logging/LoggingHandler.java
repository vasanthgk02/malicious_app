package org.jboss.netty.handler.logging;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.ChannelDownstreamHandler;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelHandler.Sharable;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelUpstreamHandler;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.logging.InternalLogLevel;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;

@Sharable
public class LoggingHandler implements ChannelUpstreamHandler, ChannelDownstreamHandler {
    public static final InternalLogLevel DEFAULT_LEVEL = InternalLogLevel.DEBUG;
    public final boolean hexDump;
    public final InternalLogLevel level;
    public final InternalLogger logger;

    public LoggingHandler() {
        this(true);
    }

    public InternalLogLevel getLevel() {
        return this.level;
    }

    public InternalLogger getLogger() {
        return this.logger;
    }

    public void handleDownstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) throws Exception {
        log(channelEvent);
        channelHandlerContext.sendDownstream(channelEvent);
    }

    public void handleUpstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) throws Exception {
        log(channelEvent);
        channelHandlerContext.sendUpstream(channelEvent);
    }

    public void log(ChannelEvent channelEvent) {
        if (getLogger().isEnabled(this.level)) {
            String obj = channelEvent.toString();
            if (this.hexDump && (channelEvent instanceof MessageEvent)) {
                MessageEvent messageEvent = (MessageEvent) channelEvent;
                if (messageEvent.getMessage() instanceof ChannelBuffer) {
                    StringBuilder outline78 = GeneratedOutlineSupport.outline78(obj, " - (HEXDUMP: ");
                    outline78.append(ChannelBuffers.hexDump((ChannelBuffer) messageEvent.getMessage()));
                    outline78.append(')');
                    obj = outline78.toString();
                }
            }
            if (channelEvent instanceof ExceptionEvent) {
                getLogger().log(this.level, obj, ((ExceptionEvent) channelEvent).getCause());
            } else {
                getLogger().log(this.level, obj);
            }
        }
    }

    public LoggingHandler(InternalLogLevel internalLogLevel) {
        this(internalLogLevel, true);
    }

    public LoggingHandler(boolean z) {
        this(DEFAULT_LEVEL, z);
    }

    public LoggingHandler(InternalLogLevel internalLogLevel, boolean z) {
        if (internalLogLevel != null) {
            this.logger = InternalLoggerFactory.getInstance(LoggingHandler.class);
            this.level = internalLogLevel;
            this.hexDump = z;
            return;
        }
        throw new NullPointerException("level");
    }

    public LoggingHandler(Class<?> cls) {
        this(cls, true);
    }

    public LoggingHandler(Class<?> cls, boolean z) {
        this(cls, DEFAULT_LEVEL, z);
    }

    public LoggingHandler(Class<?> cls, InternalLogLevel internalLogLevel) {
        this(cls, internalLogLevel, true);
    }

    public LoggingHandler(Class<?> cls, InternalLogLevel internalLogLevel, boolean z) {
        if (cls == null) {
            throw new NullPointerException("clazz");
        } else if (internalLogLevel != null) {
            this.logger = InternalLoggerFactory.getInstance(cls);
            this.level = internalLogLevel;
            this.hexDump = z;
        } else {
            throw new NullPointerException("level");
        }
    }

    public LoggingHandler(String str) {
        this(str, true);
    }

    public LoggingHandler(String str, boolean z) {
        this(str, DEFAULT_LEVEL, z);
    }

    public LoggingHandler(String str, InternalLogLevel internalLogLevel, boolean z) {
        if (str == null) {
            throw new NullPointerException("name");
        } else if (internalLogLevel != null) {
            this.logger = InternalLoggerFactory.getInstance(str);
            this.level = internalLogLevel;
            this.hexDump = z;
        } else {
            throw new NullPointerException("level");
        }
    }
}
