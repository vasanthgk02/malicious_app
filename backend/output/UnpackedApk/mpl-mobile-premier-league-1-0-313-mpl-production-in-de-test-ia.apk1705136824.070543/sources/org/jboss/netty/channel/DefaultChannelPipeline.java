package org.jboss.netty.channel;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;

public class DefaultChannelPipeline implements ChannelPipeline {
    public static final ChannelSink discardingSink = new DiscardingChannelSink();
    public static final InternalLogger logger = InternalLoggerFactory.getInstance(DefaultChannelPipeline.class);
    public volatile Channel channel;
    public volatile DefaultChannelHandlerContext head;
    public final Map<String, DefaultChannelHandlerContext> name2ctx = new HashMap(4);
    public volatile ChannelSink sink;
    public volatile DefaultChannelHandlerContext tail;

    public final class DefaultChannelHandlerContext implements ChannelHandlerContext {
        public volatile Object attachment;
        public final boolean canHandleDownstream;
        public final boolean canHandleUpstream;
        public final ChannelHandler handler;
        public final String name;
        public volatile DefaultChannelHandlerContext next;
        public volatile DefaultChannelHandlerContext prev;

        public DefaultChannelHandlerContext(DefaultChannelHandlerContext defaultChannelHandlerContext, DefaultChannelHandlerContext defaultChannelHandlerContext2, String str, ChannelHandler channelHandler) {
            if (str == null) {
                throw new NullPointerException("name");
            } else if (channelHandler != null) {
                boolean z = channelHandler instanceof ChannelUpstreamHandler;
                this.canHandleUpstream = z;
                boolean z2 = channelHandler instanceof ChannelDownstreamHandler;
                this.canHandleDownstream = z2;
                if (z || z2) {
                    this.prev = defaultChannelHandlerContext;
                    this.next = defaultChannelHandlerContext2;
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
            return DefaultChannelPipeline.this;
        }

        public void sendDownstream(ChannelEvent channelEvent) {
            DefaultChannelHandlerContext actualDownstreamContext = DefaultChannelPipeline.this.getActualDownstreamContext(this.prev);
            if (actualDownstreamContext == null) {
                try {
                    DefaultChannelPipeline.this.getSink().eventSunk(DefaultChannelPipeline.this, channelEvent);
                } catch (Throwable th) {
                    DefaultChannelPipeline.this.notifyHandlerException(channelEvent, th);
                }
            } else {
                DefaultChannelPipeline.this.sendDownstream(actualDownstreamContext, channelEvent);
            }
        }

        public void sendUpstream(ChannelEvent channelEvent) {
            DefaultChannelHandlerContext actualUpstreamContext = DefaultChannelPipeline.this.getActualUpstreamContext(this.next);
            if (actualUpstreamContext != null) {
                DefaultChannelPipeline.this.sendUpstream(actualUpstreamContext, channelEvent);
            }
        }

        public void setAttachment(Object obj) {
            this.attachment = obj;
        }
    }

    public static final class DiscardingChannelSink implements ChannelSink {
        public void eventSunk(ChannelPipeline channelPipeline, ChannelEvent channelEvent) {
            InternalLogger internalLogger = DefaultChannelPipeline.logger;
            internalLogger.warn("Not attached yet; discarding: " + channelEvent);
        }

        public void exceptionCaught(ChannelPipeline channelPipeline, ChannelEvent channelEvent, ChannelPipelineException channelPipelineException) throws Exception {
            throw channelPipelineException;
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

    private void checkDuplicateName(String str) {
        if (this.name2ctx.containsKey(str)) {
            throw new IllegalArgumentException("Duplicate handler name.");
        }
    }

    private DefaultChannelHandlerContext getContextOrDie(String str) {
        DefaultChannelHandlerContext defaultChannelHandlerContext = (DefaultChannelHandlerContext) getContext(str);
        if (defaultChannelHandlerContext != null) {
            return defaultChannelHandlerContext;
        }
        throw new NoSuchElementException(str);
    }

    private void init(String str, ChannelHandler channelHandler) {
        DefaultChannelHandlerContext defaultChannelHandlerContext = new DefaultChannelHandlerContext(null, null, str, channelHandler);
        callBeforeAdd(defaultChannelHandlerContext);
        this.tail = defaultChannelHandlerContext;
        this.head = defaultChannelHandlerContext;
        this.name2ctx.clear();
        this.name2ctx.put(str, defaultChannelHandlerContext);
        callAfterAdd(defaultChannelHandlerContext);
    }

    public synchronized void addAfter(String str, String str2, ChannelHandler channelHandler) {
        DefaultChannelHandlerContext contextOrDie = getContextOrDie(str);
        if (contextOrDie == this.tail) {
            addLast(str2, channelHandler);
        } else {
            checkDuplicateName(str2);
            DefaultChannelHandlerContext defaultChannelHandlerContext = new DefaultChannelHandlerContext(contextOrDie, contextOrDie.next, str2, channelHandler);
            callBeforeAdd(defaultChannelHandlerContext);
            contextOrDie.next.prev = defaultChannelHandlerContext;
            contextOrDie.next = defaultChannelHandlerContext;
            this.name2ctx.put(str2, defaultChannelHandlerContext);
            callAfterAdd(defaultChannelHandlerContext);
        }
    }

    public synchronized void addBefore(String str, String str2, ChannelHandler channelHandler) {
        DefaultChannelHandlerContext contextOrDie = getContextOrDie(str);
        if (contextOrDie == this.head) {
            addFirst(str2, channelHandler);
        } else {
            checkDuplicateName(str2);
            DefaultChannelHandlerContext defaultChannelHandlerContext = new DefaultChannelHandlerContext(contextOrDie.prev, contextOrDie, str2, channelHandler);
            callBeforeAdd(defaultChannelHandlerContext);
            contextOrDie.prev.next = defaultChannelHandlerContext;
            contextOrDie.prev = defaultChannelHandlerContext;
            this.name2ctx.put(str2, defaultChannelHandlerContext);
            callAfterAdd(defaultChannelHandlerContext);
        }
    }

    public synchronized void addFirst(String str, ChannelHandler channelHandler) {
        if (this.name2ctx.isEmpty()) {
            init(str, channelHandler);
        } else {
            checkDuplicateName(str);
            DefaultChannelHandlerContext defaultChannelHandlerContext = this.head;
            DefaultChannelHandlerContext defaultChannelHandlerContext2 = new DefaultChannelHandlerContext(null, defaultChannelHandlerContext, str, channelHandler);
            callBeforeAdd(defaultChannelHandlerContext2);
            defaultChannelHandlerContext.prev = defaultChannelHandlerContext2;
            this.head = defaultChannelHandlerContext2;
            this.name2ctx.put(str, defaultChannelHandlerContext2);
            callAfterAdd(defaultChannelHandlerContext2);
        }
    }

    public synchronized void addLast(String str, ChannelHandler channelHandler) {
        if (this.name2ctx.isEmpty()) {
            init(str, channelHandler);
        } else {
            checkDuplicateName(str);
            DefaultChannelHandlerContext defaultChannelHandlerContext = this.tail;
            DefaultChannelHandlerContext defaultChannelHandlerContext2 = new DefaultChannelHandlerContext(defaultChannelHandlerContext, null, str, channelHandler);
            callBeforeAdd(defaultChannelHandlerContext2);
            defaultChannelHandlerContext.next = defaultChannelHandlerContext2;
            this.tail = defaultChannelHandlerContext2;
            this.name2ctx.put(str, defaultChannelHandlerContext2);
            callAfterAdd(defaultChannelHandlerContext2);
        }
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

    public synchronized ChannelHandler get(String str) {
        DefaultChannelHandlerContext defaultChannelHandlerContext = this.name2ctx.get(str);
        if (defaultChannelHandlerContext == null) {
            return null;
        }
        return defaultChannelHandlerContext.getHandler();
    }

    public DefaultChannelHandlerContext getActualDownstreamContext(DefaultChannelHandlerContext defaultChannelHandlerContext) {
        if (defaultChannelHandlerContext == null) {
            return null;
        }
        while (!defaultChannelHandlerContext.canHandleDownstream()) {
            defaultChannelHandlerContext = defaultChannelHandlerContext.prev;
            if (defaultChannelHandlerContext == null) {
                return null;
            }
        }
        return defaultChannelHandlerContext;
    }

    public DefaultChannelHandlerContext getActualUpstreamContext(DefaultChannelHandlerContext defaultChannelHandlerContext) {
        if (defaultChannelHandlerContext == null) {
            return null;
        }
        while (!defaultChannelHandlerContext.canHandleUpstream()) {
            defaultChannelHandlerContext = defaultChannelHandlerContext.next;
            if (defaultChannelHandlerContext == null) {
                return null;
            }
        }
        return defaultChannelHandlerContext;
    }

    public Channel getChannel() {
        return this.channel;
    }

    public synchronized ChannelHandlerContext getContext(String str) {
        if (str != null) {
        } else {
            throw new NullPointerException("name");
        }
        return this.name2ctx.get(str);
    }

    public synchronized ChannelHandler getFirst() {
        DefaultChannelHandlerContext defaultChannelHandlerContext = this.head;
        if (defaultChannelHandlerContext == null) {
            return null;
        }
        return defaultChannelHandlerContext.getHandler();
    }

    public synchronized ChannelHandler getLast() {
        DefaultChannelHandlerContext defaultChannelHandlerContext = this.tail;
        if (defaultChannelHandlerContext == null) {
            return null;
        }
        return defaultChannelHandlerContext.getHandler();
    }

    public ChannelSink getSink() {
        ChannelSink channelSink = this.sink;
        return channelSink == null ? discardingSink : channelSink;
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

    public synchronized void remove(ChannelHandler channelHandler) {
        remove(getContextOrDie(channelHandler));
    }

    public synchronized ChannelHandler removeFirst() {
        DefaultChannelHandlerContext defaultChannelHandlerContext;
        if (!this.name2ctx.isEmpty()) {
            defaultChannelHandlerContext = this.head;
            if (defaultChannelHandlerContext != null) {
                callBeforeRemove(defaultChannelHandlerContext);
                if (defaultChannelHandlerContext.next == null) {
                    this.tail = null;
                    this.head = null;
                    this.name2ctx.clear();
                } else {
                    defaultChannelHandlerContext.next.prev = null;
                    this.head = defaultChannelHandlerContext.next;
                    this.name2ctx.remove(defaultChannelHandlerContext.getName());
                }
                callAfterRemove(defaultChannelHandlerContext);
            } else {
                throw new NoSuchElementException();
            }
        } else {
            throw new NoSuchElementException();
        }
        return defaultChannelHandlerContext.getHandler();
    }

    public synchronized ChannelHandler removeLast() {
        DefaultChannelHandlerContext defaultChannelHandlerContext;
        if (!this.name2ctx.isEmpty()) {
            defaultChannelHandlerContext = this.tail;
            if (defaultChannelHandlerContext != null) {
                callBeforeRemove(defaultChannelHandlerContext);
                if (defaultChannelHandlerContext.prev == null) {
                    this.tail = null;
                    this.head = null;
                    this.name2ctx.clear();
                } else {
                    defaultChannelHandlerContext.prev.next = null;
                    this.tail = defaultChannelHandlerContext.prev;
                    this.name2ctx.remove(defaultChannelHandlerContext.getName());
                }
                callBeforeRemove(defaultChannelHandlerContext);
            } else {
                throw new NoSuchElementException();
            }
        } else {
            throw new NoSuchElementException();
        }
        return defaultChannelHandlerContext.getHandler();
    }

    public synchronized void replace(ChannelHandler channelHandler, String str, ChannelHandler channelHandler2) {
        replace(getContextOrDie(channelHandler), str, channelHandler2);
    }

    public void sendDownstream(ChannelEvent channelEvent) {
        DefaultChannelHandlerContext actualDownstreamContext = getActualDownstreamContext(this.tail);
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
        DefaultChannelHandlerContext actualUpstreamContext = getActualUpstreamContext(this.head);
        if (actualUpstreamContext == null) {
            InternalLogger internalLogger = logger;
            internalLogger.warn("The pipeline contains no upstream handlers; discarding: " + channelEvent);
            return;
        }
        sendUpstream(actualUpstreamContext, channelEvent);
    }

    public Map<String, ChannelHandler> toMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.name2ctx.isEmpty()) {
            return linkedHashMap;
        }
        DefaultChannelHandlerContext defaultChannelHandlerContext = this.head;
        do {
            linkedHashMap.put(defaultChannelHandlerContext.getName(), defaultChannelHandlerContext.getHandler());
            defaultChannelHandlerContext = defaultChannelHandlerContext.next;
        } while (defaultChannelHandlerContext != null);
        return linkedHashMap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('{');
        DefaultChannelHandlerContext defaultChannelHandlerContext = this.head;
        while (true) {
            sb.append('(');
            sb.append(defaultChannelHandlerContext.getName());
            sb.append(" = ");
            sb.append(defaultChannelHandlerContext.getHandler().getClass().getName());
            sb.append(')');
            defaultChannelHandlerContext = defaultChannelHandlerContext.next;
            if (defaultChannelHandlerContext == null) {
                sb.append('}');
                return sb.toString();
            }
            sb.append(", ");
        }
    }

    private DefaultChannelHandlerContext getContextOrDie(ChannelHandler channelHandler) {
        DefaultChannelHandlerContext defaultChannelHandlerContext = (DefaultChannelHandlerContext) getContext(channelHandler);
        if (defaultChannelHandlerContext != null) {
            return defaultChannelHandlerContext;
        }
        throw new NoSuchElementException(channelHandler.getClass().getName());
    }

    public synchronized ChannelHandlerContext getContext(ChannelHandler channelHandler) {
        if (channelHandler == null) {
            throw new NullPointerException("handler");
        } else if (this.name2ctx.isEmpty()) {
            return null;
        } else {
            DefaultChannelHandlerContext defaultChannelHandlerContext = this.head;
            while (defaultChannelHandlerContext.getHandler() != channelHandler) {
                defaultChannelHandlerContext = defaultChannelHandlerContext.next;
                if (defaultChannelHandlerContext == null) {
                    return null;
                }
            }
            return defaultChannelHandlerContext;
        }
    }

    public synchronized ChannelHandler remove(String str) {
        return remove(getContextOrDie(str)).getHandler();
    }

    public synchronized ChannelHandler replace(String str, String str2, ChannelHandler channelHandler) {
        return replace(getContextOrDie(str), str2, channelHandler);
    }

    public synchronized <T extends ChannelHandler> T get(Class<T> cls) {
        ChannelHandlerContext context = getContext(cls);
        if (context == null) {
            return null;
        }
        return context.getHandler();
    }

    public synchronized <T extends ChannelHandler> T remove(Class<T> cls) {
        return remove(getContextOrDie(cls)).getHandler();
    }

    public synchronized <T extends ChannelHandler> T replace(Class<T> cls, String str, ChannelHandler channelHandler) {
        return replace(getContextOrDie(cls), str, channelHandler);
    }

    public void sendUpstream(DefaultChannelHandlerContext defaultChannelHandlerContext, ChannelEvent channelEvent) {
        try {
            ((ChannelUpstreamHandler) defaultChannelHandlerContext.getHandler()).handleUpstream(defaultChannelHandlerContext, channelEvent);
        } catch (Throwable th) {
            notifyHandlerException(channelEvent, th);
        }
    }

    private DefaultChannelHandlerContext getContextOrDie(Class<? extends ChannelHandler> cls) {
        DefaultChannelHandlerContext defaultChannelHandlerContext = (DefaultChannelHandlerContext) getContext(cls);
        if (defaultChannelHandlerContext != null) {
            return defaultChannelHandlerContext;
        }
        throw new NoSuchElementException(cls.getName());
    }

    private DefaultChannelHandlerContext remove(DefaultChannelHandlerContext defaultChannelHandlerContext) {
        if (this.head == this.tail) {
            this.tail = null;
            this.head = null;
            this.name2ctx.clear();
        } else if (defaultChannelHandlerContext == this.head) {
            removeFirst();
        } else if (defaultChannelHandlerContext == this.tail) {
            removeLast();
        } else {
            callBeforeRemove(defaultChannelHandlerContext);
            DefaultChannelHandlerContext defaultChannelHandlerContext2 = defaultChannelHandlerContext.prev;
            DefaultChannelHandlerContext defaultChannelHandlerContext3 = defaultChannelHandlerContext.next;
            defaultChannelHandlerContext2.next = defaultChannelHandlerContext3;
            defaultChannelHandlerContext3.prev = defaultChannelHandlerContext2;
            this.name2ctx.remove(defaultChannelHandlerContext.getName());
            callAfterRemove(defaultChannelHandlerContext);
        }
        return defaultChannelHandlerContext;
    }

    private ChannelHandler replace(DefaultChannelHandlerContext defaultChannelHandlerContext, String str, ChannelHandler channelHandler) {
        RuntimeException runtimeException;
        boolean z;
        if (defaultChannelHandlerContext == this.head) {
            removeFirst();
            addFirst(str, channelHandler);
        } else if (defaultChannelHandlerContext == this.tail) {
            removeLast();
            addLast(str, channelHandler);
        } else {
            boolean equals = defaultChannelHandlerContext.getName().equals(str);
            if (!equals) {
                checkDuplicateName(str);
            }
            DefaultChannelHandlerContext defaultChannelHandlerContext2 = defaultChannelHandlerContext.prev;
            DefaultChannelHandlerContext defaultChannelHandlerContext3 = defaultChannelHandlerContext.next;
            DefaultChannelHandlerContext defaultChannelHandlerContext4 = new DefaultChannelHandlerContext(defaultChannelHandlerContext2, defaultChannelHandlerContext3, str, channelHandler);
            callBeforeRemove(defaultChannelHandlerContext);
            callBeforeAdd(defaultChannelHandlerContext4);
            defaultChannelHandlerContext2.next = defaultChannelHandlerContext4;
            defaultChannelHandlerContext3.prev = defaultChannelHandlerContext4;
            if (!equals) {
                this.name2ctx.remove(defaultChannelHandlerContext.getName());
                this.name2ctx.put(str, defaultChannelHandlerContext4);
            }
            boolean z2 = true;
            ChannelHandlerLifeCycleException e2 = null;
            try {
                callAfterRemove(defaultChannelHandlerContext);
                z = true;
                runtimeException = null;
            } catch (ChannelHandlerLifeCycleException e3) {
                runtimeException = e3;
                z = false;
            }
            try {
                callAfterAdd(defaultChannelHandlerContext4);
            } catch (ChannelHandlerLifeCycleException e4) {
                e2 = e4;
                z2 = false;
            }
            if (!z && !z2) {
                logger.warn(runtimeException.getMessage(), runtimeException);
                logger.warn(e2.getMessage(), e2);
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Both ");
                outline73.append(defaultChannelHandlerContext.getHandler().getClass().getName());
                outline73.append(".afterRemove() and ");
                outline73.append(defaultChannelHandlerContext4.getHandler().getClass().getName());
                outline73.append(".afterAdd() failed; see logs.");
                throw new ChannelHandlerLifeCycleException(outline73.toString());
            } else if (!z) {
                throw runtimeException;
            } else if (!z2) {
                throw e2;
            }
        }
        return defaultChannelHandlerContext.getHandler();
    }

    public void sendDownstream(DefaultChannelHandlerContext defaultChannelHandlerContext, ChannelEvent channelEvent) {
        try {
            ((ChannelDownstreamHandler) defaultChannelHandlerContext.getHandler()).handleDownstream(defaultChannelHandlerContext, channelEvent);
        } catch (Throwable th) {
            notifyHandlerException(channelEvent, th);
        }
    }

    public synchronized ChannelHandlerContext getContext(Class<? extends ChannelHandler> cls) {
        if (cls == null) {
            throw new NullPointerException("handlerType");
        } else if (this.name2ctx.isEmpty()) {
            return null;
        } else {
            DefaultChannelHandlerContext defaultChannelHandlerContext = this.head;
            while (!cls.isAssignableFrom(defaultChannelHandlerContext.getHandler().getClass())) {
                defaultChannelHandlerContext = defaultChannelHandlerContext.next;
                if (defaultChannelHandlerContext == null) {
                    return null;
                }
            }
            return defaultChannelHandlerContext;
        }
    }
}
