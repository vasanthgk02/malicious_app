package org.jboss.netty.channel;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;
import org.jboss.netty.util.internal.ConversionUtil;

public class StaticChannelPipeline implements ChannelPipeline {
    public static final InternalLogger logger = InternalLoggerFactory.getInstance(StaticChannelPipeline.class);
    public volatile Channel channel;
    public final StaticChannelHandlerContext[] contexts;
    public final int lastIndex;
    public final Map<String, StaticChannelHandlerContext> name2ctx = new HashMap(4);
    public volatile ChannelSink sink;

    public final class StaticChannelHandlerContext implements ChannelHandlerContext {
        public volatile Object attachment;
        public final boolean canHandleDownstream;
        public final boolean canHandleUpstream;
        public final ChannelHandler handler;
        public final int index;
        public final String name;

        public StaticChannelHandlerContext(int i, String str, ChannelHandler channelHandler) {
            if (str == null) {
                throw new NullPointerException("name");
            } else if (channelHandler != null) {
                boolean z = channelHandler instanceof ChannelUpstreamHandler;
                this.canHandleUpstream = z;
                boolean z2 = channelHandler instanceof ChannelDownstreamHandler;
                this.canHandleDownstream = z2;
                if (z || z2) {
                    this.index = i;
                    this.name = str;
                    this.handler = channelHandler;
                    return;
                }
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("handler must be either ");
                outline73.append(ChannelUpstreamHandler.class.getName());
                outline73.append(" or ");
                outline73.append(ChannelDownstreamHandler.class.getName());
                outline73.append('.');
                throw new IllegalArgumentException(outline73.toString());
            } else {
                throw new NullPointerException("handler");
            }
        }

        public boolean canHandleDownstream() {
            return this.canHandleDownstream;
        }

        public boolean canHandleUpstream() {
            return this.canHandleUpstream;
        }

        public Object getAttachment() {
            return this.attachment;
        }

        public Channel getChannel() {
            return getPipeline().getChannel();
        }

        public ChannelHandler getHandler() {
            return this.handler;
        }

        public String getName() {
            return this.name;
        }

        public ChannelPipeline getPipeline() {
            return StaticChannelPipeline.this;
        }

        public void sendDownstream(ChannelEvent channelEvent) {
            StaticChannelHandlerContext actualDownstreamContext = StaticChannelPipeline.this.getActualDownstreamContext(this.index - 1);
            if (actualDownstreamContext == null) {
                try {
                    StaticChannelPipeline.this.getSink().eventSunk(StaticChannelPipeline.this, channelEvent);
                } catch (Throwable th) {
                    StaticChannelPipeline.this.notifyHandlerException(channelEvent, th);
                }
            } else {
                StaticChannelPipeline.this.sendDownstream(actualDownstreamContext, channelEvent);
            }
        }

        public void sendUpstream(ChannelEvent channelEvent) {
            StaticChannelHandlerContext actualUpstreamContext = StaticChannelPipeline.this.getActualUpstreamContext(this.index + 1);
            if (actualUpstreamContext != null) {
                StaticChannelPipeline.this.sendUpstream(actualUpstreamContext, channelEvent);
            }
        }

        public void setAttachment(Object obj) {
            this.attachment = obj;
        }
    }

    public StaticChannelPipeline(ChannelHandler... channelHandlerArr) {
        if (channelHandlerArr == null) {
            throw new NullPointerException("handlers");
        } else if (channelHandlerArr.length != 0) {
            int length = channelHandlerArr.length;
            StaticChannelHandlerContext[] staticChannelHandlerContextArr = new StaticChannelHandlerContext[length];
            int i = 0;
            while (i < length && channelHandlerArr[i] != null) {
                i++;
            }
            if (i == length) {
                this.contexts = staticChannelHandlerContextArr;
                this.lastIndex = length - 1;
            } else {
                staticChannelHandlerContextArr = new StaticChannelHandlerContext[i];
                this.contexts = staticChannelHandlerContextArr;
                this.lastIndex = i - 1;
            }
            for (int i2 = 0; i2 < i; i2++) {
                ChannelHandler channelHandler = channelHandlerArr[i2];
                String conversionUtil = ConversionUtil.toString(i2);
                StaticChannelHandlerContext staticChannelHandlerContext = new StaticChannelHandlerContext(i2, conversionUtil, channelHandler);
                staticChannelHandlerContextArr[i2] = staticChannelHandlerContext;
                this.name2ctx.put(conversionUtil, staticChannelHandlerContext);
            }
            for (StaticChannelHandlerContext staticChannelHandlerContext2 : staticChannelHandlerContextArr) {
                callBeforeAdd(staticChannelHandlerContext2);
                callAfterAdd(staticChannelHandlerContext2);
            }
        } else {
            throw new IllegalArgumentException("no handlers specified");
        }
    }

    private void callAfterAdd(ChannelHandlerContext channelHandlerContext) {
        LifeCycleAwareChannelHandler lifeCycleAwareChannelHandler;
        boolean z;
        if (channelHandlerContext.getHandler() instanceof LifeCycleAwareChannelHandler) {
            lifeCycleAwareChannelHandler = (LifeCycleAwareChannelHandler) channelHandlerContext.getHandler();
            try {
                lifeCycleAwareChannelHandler.afterAdd(channelHandlerContext);
                return;
            } catch (Throwable th) {
                InternalLogger internalLogger = logger;
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Failed to remove a handler: ");
                outline73.append(channelHandlerContext.getName());
                internalLogger.warn(outline73.toString(), th);
            }
        } else {
            return;
        }
        if (z) {
            throw new ChannelHandlerLifeCycleException(lifeCycleAwareChannelHandler.getClass().getName() + ".afterAdd() has thrown an exception; removed.", th);
        }
        throw new ChannelHandlerLifeCycleException(lifeCycleAwareChannelHandler.getClass().getName() + ".afterAdd() has thrown an exception; also failed to remove.", th);
    }

    private void callAfterRemove(ChannelHandlerContext channelHandlerContext) {
        if (channelHandlerContext.getHandler() instanceof LifeCycleAwareChannelHandler) {
            LifeCycleAwareChannelHandler lifeCycleAwareChannelHandler = (LifeCycleAwareChannelHandler) channelHandlerContext.getHandler();
            try {
                lifeCycleAwareChannelHandler.afterRemove(channelHandlerContext);
            } catch (Throwable th) {
                throw new ChannelHandlerLifeCycleException(lifeCycleAwareChannelHandler.getClass().getName() + ".afterRemove() has thrown an exception.", th);
            }
        }
    }

    private void callBeforeAdd(ChannelHandlerContext channelHandlerContext) {
        if (channelHandlerContext.getHandler() instanceof LifeCycleAwareChannelHandler) {
            LifeCycleAwareChannelHandler lifeCycleAwareChannelHandler = (LifeCycleAwareChannelHandler) channelHandlerContext.getHandler();
            try {
                lifeCycleAwareChannelHandler.beforeAdd(channelHandlerContext);
            } catch (Throwable th) {
                throw new ChannelHandlerLifeCycleException(lifeCycleAwareChannelHandler.getClass().getName() + ".beforeAdd() has thrown an exception; not adding.", th);
            }
        }
    }

    private void callBeforeRemove(ChannelHandlerContext channelHandlerContext) {
        if (channelHandlerContext.getHandler() instanceof LifeCycleAwareChannelHandler) {
            LifeCycleAwareChannelHandler lifeCycleAwareChannelHandler = (LifeCycleAwareChannelHandler) channelHandlerContext.getHandler();
            try {
                lifeCycleAwareChannelHandler.beforeRemove(channelHandlerContext);
            } catch (Throwable th) {
                throw new ChannelHandlerLifeCycleException(lifeCycleAwareChannelHandler.getClass().getName() + ".beforeRemove() has thrown an exception; not removing.", th);
            }
        }
    }

    public void addAfter(String str, String str2, ChannelHandler channelHandler) {
        throw new UnsupportedOperationException();
    }

    public void addBefore(String str, String str2, ChannelHandler channelHandler) {
        throw new UnsupportedOperationException();
    }

    public void addFirst(String str, ChannelHandler channelHandler) {
        throw new UnsupportedOperationException();
    }

    public void addLast(String str, ChannelHandler channelHandler) {
        throw new UnsupportedOperationException();
    }

    public void attach(Channel channel2, ChannelSink channelSink) {
        if (channel2 == null) {
            throw new NullPointerException("channel");
        } else if (channelSink == null) {
            throw new NullPointerException("sink");
        } else if (this.channel == null && this.sink == null) {
            this.channel = channel2;
            this.sink = channelSink;
        } else {
            throw new IllegalStateException("attached already");
        }
    }

    public ChannelHandler get(String str) {
        StaticChannelHandlerContext staticChannelHandlerContext = this.name2ctx.get(str);
        if (staticChannelHandlerContext == null) {
            return null;
        }
        return staticChannelHandlerContext.getHandler();
    }

    public StaticChannelHandlerContext getActualDownstreamContext(int i) {
        while (i >= 0) {
            StaticChannelHandlerContext staticChannelHandlerContext = this.contexts[i];
            if (staticChannelHandlerContext.canHandleDownstream()) {
                return staticChannelHandlerContext;
            }
            i--;
        }
        return null;
    }

    public StaticChannelHandlerContext getActualUpstreamContext(int i) {
        while (true) {
            StaticChannelHandlerContext[] staticChannelHandlerContextArr = this.contexts;
            if (i >= staticChannelHandlerContextArr.length) {
                return null;
            }
            StaticChannelHandlerContext staticChannelHandlerContext = staticChannelHandlerContextArr[i];
            if (staticChannelHandlerContext.canHandleUpstream()) {
                return staticChannelHandlerContext;
            }
            i++;
        }
    }

    public Channel getChannel() {
        return this.channel;
    }

    public ChannelHandlerContext getContext(String str) {
        if (str != null) {
            return this.name2ctx.get(str);
        }
        throw new NullPointerException("name");
    }

    public ChannelHandler getFirst() {
        return this.contexts[0].getHandler();
    }

    public ChannelHandler getLast() {
        StaticChannelHandlerContext[] staticChannelHandlerContextArr = this.contexts;
        return staticChannelHandlerContextArr[staticChannelHandlerContextArr.length - 1].getHandler();
    }

    public ChannelSink getSink() {
        ChannelSink channelSink = this.sink;
        return channelSink == null ? DefaultChannelPipeline.discardingSink : channelSink;
    }

    public boolean isAttached() {
        return this.sink != null;
    }

    public void notifyHandlerException(ChannelEvent channelEvent, Throwable th) {
        ChannelPipelineException channelPipelineException;
        if (channelEvent instanceof ExceptionEvent) {
            InternalLogger internalLogger = logger;
            internalLogger.warn("An exception was thrown by a user handler while handling an exception event (" + channelEvent + ")", th);
            return;
        }
        if (th instanceof ChannelPipelineException) {
            channelPipelineException = (ChannelPipelineException) th;
        } else {
            channelPipelineException = new ChannelPipelineException(th);
        }
        try {
            this.sink.exceptionCaught(this, channelEvent, channelPipelineException);
        } catch (Exception e2) {
            logger.warn("An exception was thrown by an exception handler.", e2);
        }
    }

    public void remove(ChannelHandler channelHandler) {
        throw new UnsupportedOperationException();
    }

    public ChannelHandler removeFirst() {
        throw new UnsupportedOperationException();
    }

    public ChannelHandler removeLast() {
        throw new UnsupportedOperationException();
    }

    public void replace(ChannelHandler channelHandler, String str, ChannelHandler channelHandler2) {
        throw new UnsupportedOperationException();
    }

    public void sendDownstream(ChannelEvent channelEvent) {
        StaticChannelHandlerContext actualDownstreamContext = getActualDownstreamContext(this.lastIndex);
        if (actualDownstreamContext == null) {
            try {
                getSink().eventSunk(this, channelEvent);
            } catch (Throwable th) {
                notifyHandlerException(channelEvent, th);
            }
        } else {
            sendDownstream(actualDownstreamContext, channelEvent);
        }
    }

    public void sendUpstream(ChannelEvent channelEvent) {
        StaticChannelHandlerContext actualUpstreamContext = getActualUpstreamContext(0);
        if (actualUpstreamContext == null) {
            InternalLogger internalLogger = logger;
            internalLogger.warn("The pipeline contains no upstream handlers; discarding: " + channelEvent);
            return;
        }
        sendUpstream(actualUpstreamContext, channelEvent);
    }

    public Map<String, ChannelHandler> toMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (StaticChannelHandlerContext staticChannelHandlerContext : this.contexts) {
            linkedHashMap.put(staticChannelHandlerContext.getName(), staticChannelHandlerContext.getHandler());
        }
        return linkedHashMap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StaticChannelPipeline.class.getSimpleName());
        sb.append('{');
        for (StaticChannelHandlerContext staticChannelHandlerContext : this.contexts) {
            sb.append('(');
            sb.append(staticChannelHandlerContext.getName());
            sb.append(" = ");
            sb.append(staticChannelHandlerContext.getHandler().getClass().getName());
            sb.append(')');
            sb.append(", ");
        }
        sb.replace(sb.length() - 2, sb.length(), "}");
        return sb.toString();
    }

    public ChannelHandler remove(String str) {
        throw new UnsupportedOperationException();
    }

    public ChannelHandler replace(String str, String str2, ChannelHandler channelHandler) {
        throw new UnsupportedOperationException();
    }

    public <T extends ChannelHandler> T get(Class<T> cls) {
        ChannelHandlerContext context = getContext(cls);
        if (context == null) {
            return null;
        }
        return context.getHandler();
    }

    public ChannelHandlerContext getContext(ChannelHandler channelHandler) {
        if (channelHandler != null) {
            for (StaticChannelHandlerContext staticChannelHandlerContext : this.contexts) {
                if (staticChannelHandlerContext.getHandler() == channelHandler) {
                    return staticChannelHandlerContext;
                }
            }
            return null;
        }
        throw new NullPointerException("handler");
    }

    public <T extends ChannelHandler> T remove(Class<T> cls) {
        throw new UnsupportedOperationException();
    }

    public <T extends ChannelHandler> T replace(Class<T> cls, String str, ChannelHandler channelHandler) {
        throw new UnsupportedOperationException();
    }

    public void sendUpstream(StaticChannelHandlerContext staticChannelHandlerContext, ChannelEvent channelEvent) {
        try {
            ((ChannelUpstreamHandler) staticChannelHandlerContext.getHandler()).handleUpstream(staticChannelHandlerContext, channelEvent);
        } catch (Throwable th) {
            notifyHandlerException(channelEvent, th);
        }
    }

    public void sendDownstream(StaticChannelHandlerContext staticChannelHandlerContext, ChannelEvent channelEvent) {
        try {
            ((ChannelDownstreamHandler) staticChannelHandlerContext.getHandler()).handleDownstream(staticChannelHandlerContext, channelEvent);
        } catch (Throwable th) {
            notifyHandlerException(channelEvent, th);
        }
    }

    public ChannelHandlerContext getContext(Class<? extends ChannelHandler> cls) {
        if (cls != null) {
            for (StaticChannelHandlerContext staticChannelHandlerContext : this.contexts) {
                if (cls.isAssignableFrom(staticChannelHandlerContext.getHandler().getClass())) {
                    return staticChannelHandlerContext;
                }
            }
            return null;
        }
        throw new NullPointerException("handlerType");
    }
}
