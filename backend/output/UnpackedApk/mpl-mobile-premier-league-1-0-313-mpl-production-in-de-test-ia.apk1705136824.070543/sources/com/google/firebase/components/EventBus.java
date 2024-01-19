package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

public class EventBus implements Subscriber, Publisher {
    public final Executor defaultExecutor;
    public final Map<Class<?>, ConcurrentHashMap<EventHandler<Object>, Executor>> handlerMap = new HashMap();
    public Queue<Event<?>> pendingEvents = new ArrayDeque();

    public EventBus(Executor executor) {
        this.defaultExecutor = executor;
    }

    public synchronized <T> void subscribe(Class<T> cls, Executor executor, EventHandler<? super T> eventHandler) {
        if (cls == null) {
            throw null;
        } else if (eventHandler == null) {
            throw null;
        } else if (executor != null) {
            if (!this.handlerMap.containsKey(cls)) {
                this.handlerMap.put(cls, new ConcurrentHashMap());
            }
            this.handlerMap.get(cls).put(eventHandler, executor);
        } else {
            throw null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized <T> void unsubscribe(java.lang.Class<T> r2, com.google.firebase.events.EventHandler<? super T> r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r3 == 0) goto L_0x0025
            java.util.Map<java.lang.Class<?>, java.util.concurrent.ConcurrentHashMap<com.google.firebase.events.EventHandler<java.lang.Object>, java.util.concurrent.Executor>> r0 = r1.handlerMap     // Catch:{ all -> 0x0027 }
            boolean r0 = r0.containsKey(r2)     // Catch:{ all -> 0x0027 }
            if (r0 != 0) goto L_0x000d
            monitor-exit(r1)
            return
        L_0x000d:
            java.util.Map<java.lang.Class<?>, java.util.concurrent.ConcurrentHashMap<com.google.firebase.events.EventHandler<java.lang.Object>, java.util.concurrent.Executor>> r0 = r1.handlerMap     // Catch:{ all -> 0x0027 }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x0027 }
            java.util.concurrent.ConcurrentHashMap r0 = (java.util.concurrent.ConcurrentHashMap) r0     // Catch:{ all -> 0x0027 }
            r0.remove(r3)     // Catch:{ all -> 0x0027 }
            boolean r3 = r0.isEmpty()     // Catch:{ all -> 0x0027 }
            if (r3 == 0) goto L_0x0023
            java.util.Map<java.lang.Class<?>, java.util.concurrent.ConcurrentHashMap<com.google.firebase.events.EventHandler<java.lang.Object>, java.util.concurrent.Executor>> r3 = r1.handlerMap     // Catch:{ all -> 0x0027 }
            r3.remove(r2)     // Catch:{ all -> 0x0027 }
        L_0x0023:
            monitor-exit(r1)
            return
        L_0x0025:
            r2 = 0
            throw r2     // Catch:{ all -> 0x0027 }
        L_0x0027:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.components.EventBus.unsubscribe(java.lang.Class, com.google.firebase.events.EventHandler):void");
    }

    public <T> void subscribe(Class<T> cls, EventHandler<? super T> eventHandler) {
        subscribe(cls, this.defaultExecutor, eventHandler);
    }
}
