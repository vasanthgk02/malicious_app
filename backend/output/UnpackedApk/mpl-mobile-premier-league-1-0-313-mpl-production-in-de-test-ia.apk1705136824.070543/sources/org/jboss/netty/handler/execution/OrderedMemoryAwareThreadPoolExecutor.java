package org.jboss.netty.handler.execution;

import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelState;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.util.ObjectSizeEstimator;
import org.jboss.netty.util.internal.ConcurrentIdentityWeakKeyHashMap;

public class OrderedMemoryAwareThreadPoolExecutor extends MemoryAwareThreadPoolExecutor {
    public final ConcurrentMap<Object, Executor> childExecutors = newChildExecutorMap();

    public final class ChildExecutor implements Executor, Runnable {
        public final LinkedList<Runnable> tasks = new LinkedList<>();

        public ChildExecutor() {
        }

        public void execute(Runnable runnable) {
            boolean isEmpty;
            synchronized (this.tasks) {
                isEmpty = this.tasks.isEmpty();
                this.tasks.add(runnable);
            }
            if (isEmpty) {
                OrderedMemoryAwareThreadPoolExecutor.this.doUnorderedExecute(this);
            }
        }

        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r5 = this;
                java.lang.Thread r0 = java.lang.Thread.currentThread()
            L_0x0004:
                java.util.LinkedList<java.lang.Runnable> r1 = r5.tasks
                monitor-enter(r1)
                java.util.LinkedList<java.lang.Runnable> r2 = r5.tasks     // Catch:{ all -> 0x0059 }
                java.lang.Object r2 = r2.getFirst()     // Catch:{ all -> 0x0059 }
                java.lang.Runnable r2 = (java.lang.Runnable) r2     // Catch:{ all -> 0x0059 }
                monitor-exit(r1)     // Catch:{ all -> 0x0059 }
                r1 = 0
                org.jboss.netty.handler.execution.OrderedMemoryAwareThreadPoolExecutor r3 = org.jboss.netty.handler.execution.OrderedMemoryAwareThreadPoolExecutor.this
                r3.beforeExecute(r0, r2)
                r2.run()     // Catch:{ RuntimeException -> 0x0039 }
                r1 = 1
                org.jboss.netty.handler.execution.OrderedMemoryAwareThreadPoolExecutor r3 = org.jboss.netty.handler.execution.OrderedMemoryAwareThreadPoolExecutor.this     // Catch:{ RuntimeException -> 0x0039 }
                r4 = 0
                r3.onAfterExecute(r2, r4)     // Catch:{ RuntimeException -> 0x0039 }
                java.util.LinkedList<java.lang.Runnable> r1 = r5.tasks
                monitor-enter(r1)
                java.util.LinkedList<java.lang.Runnable> r2 = r5.tasks     // Catch:{ all -> 0x0034 }
                r2.removeFirst()     // Catch:{ all -> 0x0034 }
                java.util.LinkedList<java.lang.Runnable> r2 = r5.tasks     // Catch:{ all -> 0x0034 }
                boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0034 }
                if (r2 == 0) goto L_0x0032
                monitor-exit(r1)     // Catch:{ all -> 0x0034 }
                goto L_0x0053
            L_0x0032:
                monitor-exit(r1)     // Catch:{ all -> 0x0034 }
                goto L_0x0004
            L_0x0034:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0034 }
                throw r0
            L_0x0037:
                r0 = move-exception
                goto L_0x0042
            L_0x0039:
                r0 = move-exception
                if (r1 != 0) goto L_0x0041
                org.jboss.netty.handler.execution.OrderedMemoryAwareThreadPoolExecutor r1 = org.jboss.netty.handler.execution.OrderedMemoryAwareThreadPoolExecutor.this     // Catch:{ all -> 0x0037 }
                r1.onAfterExecute(r2, r0)     // Catch:{ all -> 0x0037 }
            L_0x0041:
                throw r0     // Catch:{ all -> 0x0037 }
            L_0x0042:
                java.util.LinkedList<java.lang.Runnable> r2 = r5.tasks
                monitor-enter(r2)
                java.util.LinkedList<java.lang.Runnable> r1 = r5.tasks     // Catch:{ all -> 0x0056 }
                r1.removeFirst()     // Catch:{ all -> 0x0056 }
                java.util.LinkedList<java.lang.Runnable> r1 = r5.tasks     // Catch:{ all -> 0x0056 }
                boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0056 }
                if (r1 == 0) goto L_0x0054
                monitor-exit(r2)     // Catch:{ all -> 0x0056 }
            L_0x0053:
                return
            L_0x0054:
                monitor-exit(r2)     // Catch:{ all -> 0x0056 }
                throw r0
            L_0x0056:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0056 }
                throw r0
            L_0x0059:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0059 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.handler.execution.OrderedMemoryAwareThreadPoolExecutor.ChildExecutor.run():void");
        }
    }

    public OrderedMemoryAwareThreadPoolExecutor(int i, long j, long j2) {
        super(i, j, j2);
    }

    private Executor getChildExecutor(ChannelEvent channelEvent) {
        Object childExecutorKey = getChildExecutorKey(channelEvent);
        Executor executor = (Executor) this.childExecutors.get(childExecutorKey);
        if (executor == null) {
            executor = new ChildExecutor();
            Executor putIfAbsent = this.childExecutors.putIfAbsent(childExecutorKey, executor);
            if (putIfAbsent != null) {
                executor = putIfAbsent;
            }
        }
        if (channelEvent instanceof ChannelStateEvent) {
            Channel channel = channelEvent.getChannel();
            if (((ChannelStateEvent) channelEvent).getState() == ChannelState.OPEN && !channel.isOpen()) {
                this.childExecutors.remove(channel);
            }
        }
        return executor;
    }

    public void doExecute(Runnable runnable) {
        if (!(runnable instanceof ChannelEventRunnable)) {
            doUnorderedExecute(runnable);
        } else {
            getChildExecutor(((ChannelEventRunnable) runnable).getEvent()).execute(runnable);
        }
    }

    public Object getChildExecutorKey(ChannelEvent channelEvent) {
        return channelEvent.getChannel();
    }

    public Set<Object> getChildExecutorKeySet() {
        return this.childExecutors.keySet();
    }

    public ConcurrentMap<Object, Executor> newChildExecutorMap() {
        return new ConcurrentIdentityWeakKeyHashMap();
    }

    public void onAfterExecute(Runnable runnable, Throwable th) {
        afterExecute(runnable, th);
    }

    public boolean removeChildExecutor(Object obj) {
        return this.childExecutors.remove(obj) != null;
    }

    public boolean shouldCount(Runnable runnable) {
        if (runnable instanceof ChildExecutor) {
            return false;
        }
        return super.shouldCount(runnable);
    }

    public OrderedMemoryAwareThreadPoolExecutor(int i, long j, long j2, long j3, TimeUnit timeUnit) {
        super(i, j, j2, j3, timeUnit);
    }

    public OrderedMemoryAwareThreadPoolExecutor(int i, long j, long j2, long j3, TimeUnit timeUnit, ThreadFactory threadFactory) {
        super(i, j, j2, j3, timeUnit, threadFactory);
    }

    public OrderedMemoryAwareThreadPoolExecutor(int i, long j, long j2, long j3, TimeUnit timeUnit, ObjectSizeEstimator objectSizeEstimator, ThreadFactory threadFactory) {
        super(i, j, j2, j3, timeUnit, objectSizeEstimator, threadFactory);
    }
}
