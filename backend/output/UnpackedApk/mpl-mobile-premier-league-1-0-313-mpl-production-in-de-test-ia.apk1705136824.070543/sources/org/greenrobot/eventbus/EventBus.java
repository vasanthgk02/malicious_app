package org.greenrobot.eventbus;

import android.os.Looper;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import org.apache.fontbox.cmap.CMapParser;
import org.greenrobot.eventbus.Logger.SystemOutLogger;
import org.greenrobot.eventbus.android.AndroidComponents;
import org.greenrobot.eventbus.android.DefaultAndroidMainThreadSupport;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;

public class EventBus {
    public static final EventBusBuilder DEFAULT_BUILDER = new EventBusBuilder();
    public static volatile EventBus defaultInstance;
    public static final Map<Class<?>, List<Class<?>>> eventTypesCache = new HashMap();
    public final AsyncPoster asyncPoster;
    public final BackgroundPoster backgroundPoster;
    public final ThreadLocal<PostingThreadState> currentPostingThreadState = new ThreadLocal<PostingThreadState>(this) {
        public Object initialValue() {
            return new PostingThreadState();
        }
    };
    public final boolean eventInheritance;
    public final ExecutorService executorService;
    public final int indexCount;
    public final boolean logNoSubscriberMessages;
    public final boolean logSubscriberExceptions;
    public final Logger logger;
    public final Poster mainThreadPoster;
    public final DefaultAndroidMainThreadSupport mainThreadSupport;
    public final boolean sendNoSubscriberEvent;
    public final boolean sendSubscriberExceptionEvent;
    public final Map<Class<?>, Object> stickyEvents;
    public final SubscriberMethodFinder subscriberMethodFinder;
    public final Map<Class<?>, CopyOnWriteArrayList<Subscription>> subscriptionsByEventType;
    public final boolean throwSubscriberException;
    public final Map<Object, List<Class<?>>> typesBySubscriber;

    public static final class PostingThreadState {
        public boolean canceled;
        public Object event;
        public final List<Object> eventQueue = new ArrayList();
        public boolean isMainThread;
        public boolean isPosting;
    }

    public EventBus() {
        Logger logger2;
        EventBusBuilder eventBusBuilder = DEFAULT_BUILDER;
        HandlerPoster handlerPoster = null;
        if (eventBusBuilder != null) {
            boolean z = true;
            int i = 0;
            if (AndroidComponents.implementation != null) {
                logger2 = AndroidComponents.implementation.logger;
            } else {
                logger2 = new SystemOutLogger();
            }
            this.logger = logger2;
            this.subscriptionsByEventType = new HashMap();
            this.typesBySubscriber = new HashMap();
            this.stickyEvents = new ConcurrentHashMap();
            DefaultAndroidMainThreadSupport defaultAndroidMainThreadSupport = AndroidComponents.implementation == null ? false : z ? AndroidComponents.implementation.defaultMainThreadSupport : null;
            this.mainThreadSupport = defaultAndroidMainThreadSupport;
            this.mainThreadPoster = defaultAndroidMainThreadSupport != null ? new HandlerPoster(this, Looper.getMainLooper(), 10) : handlerPoster;
            this.backgroundPoster = new BackgroundPoster(this);
            this.asyncPoster = new AsyncPoster(this);
            List<SubscriberInfoIndex> list = eventBusBuilder.subscriberInfoIndexes;
            this.indexCount = list != null ? list.size() : i;
            this.subscriberMethodFinder = new SubscriberMethodFinder(eventBusBuilder.subscriberInfoIndexes, eventBusBuilder.strictMethodVerification, eventBusBuilder.ignoreGeneratedIndex);
            this.logSubscriberExceptions = eventBusBuilder.logSubscriberExceptions;
            this.logNoSubscriberMessages = eventBusBuilder.logNoSubscriberMessages;
            this.sendSubscriberExceptionEvent = eventBusBuilder.sendSubscriberExceptionEvent;
            this.sendNoSubscriberEvent = eventBusBuilder.sendNoSubscriberEvent;
            this.throwSubscriberException = eventBusBuilder.throwSubscriberException;
            this.eventInheritance = eventBusBuilder.eventInheritance;
            this.executorService = eventBusBuilder.executorService;
            return;
        }
        throw null;
    }

    public static void addInterfaces(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                addInterfaces(list, cls.getInterfaces());
            }
        }
    }

    public static EventBus getDefault() {
        EventBus eventBus = defaultInstance;
        if (eventBus == null) {
            synchronized (EventBus.class) {
                try {
                    eventBus = defaultInstance;
                    if (eventBus == null) {
                        eventBus = new EventBus();
                        defaultInstance = eventBus;
                    }
                }
            }
        }
        return eventBus;
    }

    public void invokeSubscriber(PendingPost pendingPost) {
        Object obj = pendingPost.event;
        Subscription subscription = pendingPost.subscription;
        pendingPost.event = null;
        pendingPost.subscription = null;
        pendingPost.next = null;
        synchronized (PendingPost.pendingPostPool) {
            if (PendingPost.pendingPostPool.size() < 10000) {
                PendingPost.pendingPostPool.add(pendingPost);
            }
        }
        if (subscription.active) {
            invokeSubscriber(subscription, obj);
        }
    }

    public final boolean isMainThread() {
        DefaultAndroidMainThreadSupport defaultAndroidMainThreadSupport = this.mainThreadSupport;
        if (defaultAndroidMainThreadSupport != null) {
            if (defaultAndroidMainThreadSupport != null) {
                if (!(Looper.getMainLooper() == Looper.myLooper())) {
                    return false;
                }
            } else {
                throw null;
            }
        }
        return true;
    }

    public void post(Object obj) {
        PostingThreadState postingThreadState = this.currentPostingThreadState.get();
        List<Object> list = postingThreadState.eventQueue;
        list.add(obj);
        if (!postingThreadState.isPosting) {
            postingThreadState.isMainThread = isMainThread();
            postingThreadState.isPosting = true;
            if (!postingThreadState.canceled) {
                while (!list.isEmpty()) {
                    try {
                        postSingleEvent(list.remove(0), postingThreadState);
                    } finally {
                        postingThreadState.isPosting = false;
                        postingThreadState.isMainThread = false;
                    }
                }
                return;
            }
            throw new EventBusException("Internal error. Abort state was not reset");
        }
    }

    public final void postSingleEvent(Object obj, PostingThreadState postingThreadState) throws Error {
        boolean z;
        List list;
        Class cls = obj.getClass();
        if (this.eventInheritance) {
            synchronized (eventTypesCache) {
                list = eventTypesCache.get(cls);
                if (list == 0) {
                    ArrayList arrayList = new ArrayList();
                    for (Class cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                        arrayList.add(cls2);
                        addInterfaces(arrayList, cls2.getInterfaces());
                    }
                    eventTypesCache.put(cls, arrayList);
                    list = arrayList;
                }
            }
            int size = list.size();
            z = false;
            for (int i = 0; i < size; i++) {
                z |= postSingleEventForEventType(obj, postingThreadState, (Class) list.get(i));
            }
        } else {
            z = postSingleEventForEventType(obj, postingThreadState, cls);
        }
        if (!z) {
            if (this.logNoSubscriberMessages) {
                Logger logger2 = this.logger;
                Level level = Level.FINE;
                logger2.log(level, "No subscribers registered for event " + cls);
            }
            if (this.sendNoSubscriberEvent && cls != NoSubscriberEvent.class && cls != SubscriberExceptionEvent.class) {
                post(new NoSubscriberEvent(this, obj));
            }
        }
    }

    public final boolean postSingleEventForEventType(Object obj, PostingThreadState postingThreadState, Class<?> cls) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.subscriptionsByEventType.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            Subscription subscription = (Subscription) it.next();
            postingThreadState.event = obj;
            try {
                postToSubscription(subscription, obj, postingThreadState.isMainThread);
                if (postingThreadState.canceled) {
                    break;
                }
            } finally {
                postingThreadState.canceled = false;
            }
        }
        return true;
    }

    public final void postToSubscription(Subscription subscription, Object obj, boolean z) {
        int ordinal = subscription.subscriberMethod.threadMode.ordinal();
        if (ordinal == 0) {
            invokeSubscriber(subscription, obj);
        } else if (ordinal != 1) {
            if (ordinal == 2) {
                Poster poster = this.mainThreadPoster;
                if (poster != null) {
                    poster.enqueue(subscription, obj);
                } else {
                    invokeSubscriber(subscription, obj);
                }
            } else if (ordinal != 3) {
                if (ordinal == 4) {
                    this.asyncPoster.enqueue(subscription, obj);
                    return;
                }
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unknown thread mode: ");
                outline73.append(subscription.subscriberMethod.threadMode);
                throw new IllegalStateException(outline73.toString());
            } else if (z) {
                this.backgroundPoster.enqueue(subscription, obj);
            } else {
                invokeSubscriber(subscription, obj);
            }
        } else if (z) {
            invokeSubscriber(subscription, obj);
        } else {
            this.mainThreadPoster.enqueue(subscription, obj);
        }
    }

    public final void subscribe(Object obj, SubscriberMethod subscriberMethod) {
        Class<?> cls = subscriberMethod.eventType;
        Subscription subscription = new Subscription(obj, subscriberMethod);
        CopyOnWriteArrayList copyOnWriteArrayList = this.subscriptionsByEventType.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.subscriptionsByEventType.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(subscription)) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Subscriber ");
            outline73.append(obj.getClass());
            outline73.append(" already registered to event ");
            outline73.append(cls);
            throw new EventBusException(outline73.toString());
        }
        int size = copyOnWriteArrayList.size();
        int i = 0;
        while (true) {
            if (i > size) {
                break;
            } else if (i == size || subscriberMethod.priority > ((Subscription) copyOnWriteArrayList.get(i)).subscriberMethod.priority) {
                copyOnWriteArrayList.add(i, subscription);
            } else {
                i++;
            }
        }
        copyOnWriteArrayList.add(i, subscription);
        List list = this.typesBySubscriber.get(obj);
        if (list == null) {
            list = new ArrayList();
            this.typesBySubscriber.put(obj, list);
        }
        list.add(cls);
        if (!subscriberMethod.sticky) {
            return;
        }
        if (this.eventInheritance) {
            for (Entry next : this.stickyEvents.entrySet()) {
                if (cls.isAssignableFrom((Class) next.getKey())) {
                    Object value = next.getValue();
                    if (value != null) {
                        postToSubscription(subscription, value, isMainThread());
                    }
                }
            }
            return;
        }
        Object obj2 = this.stickyEvents.get(cls);
        if (obj2 != null) {
            postToSubscription(subscription, obj2, isMainThread());
        }
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("EventBus[indexCount=");
        outline73.append(this.indexCount);
        outline73.append(", eventInheritance=");
        return GeneratedOutlineSupport.outline66(outline73, this.eventInheritance, CMapParser.MARK_END_OF_ARRAY);
    }

    public synchronized void unregister(Object obj) {
        List<Class> list = this.typesBySubscriber.get(obj);
        if (list != null) {
            for (Class cls : list) {
                List list2 = this.subscriptionsByEventType.get(cls);
                if (list2 != null) {
                    int size = list2.size();
                    int i = 0;
                    while (i < size) {
                        Subscription subscription = (Subscription) list2.get(i);
                        if (subscription.subscriber == obj) {
                            subscription.active = false;
                            list2.remove(i);
                            i--;
                            size--;
                        }
                        i++;
                    }
                }
            }
            this.typesBySubscriber.remove(obj);
        } else {
            this.logger.log(Level.WARNING, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    public void invokeSubscriber(Subscription subscription, Object obj) {
        try {
            subscription.subscriberMethod.method.invoke(subscription.subscriber, new Object[]{obj});
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (obj instanceof SubscriberExceptionEvent) {
                if (this.logSubscriberExceptions) {
                    Logger logger2 = this.logger;
                    Level level = Level.SEVERE;
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("SubscriberExceptionEvent subscriber ");
                    outline73.append(subscription.subscriber.getClass());
                    outline73.append(" threw an exception");
                    logger2.log(level, outline73.toString(), cause);
                    SubscriberExceptionEvent subscriberExceptionEvent = (SubscriberExceptionEvent) obj;
                    Logger logger3 = this.logger;
                    Level level2 = Level.SEVERE;
                    StringBuilder outline732 = GeneratedOutlineSupport.outline73("Initial event ");
                    outline732.append(subscriberExceptionEvent.causingEvent);
                    outline732.append(" caused exception in ");
                    outline732.append(subscriberExceptionEvent.causingSubscriber);
                    logger3.log(level2, outline732.toString(), subscriberExceptionEvent.throwable);
                }
            } else if (!this.throwSubscriberException) {
                if (this.logSubscriberExceptions) {
                    Logger logger4 = this.logger;
                    Level level3 = Level.SEVERE;
                    StringBuilder outline733 = GeneratedOutlineSupport.outline73("Could not dispatch event: ");
                    outline733.append(obj.getClass());
                    outline733.append(" to subscribing class ");
                    outline733.append(subscription.subscriber.getClass());
                    logger4.log(level3, outline733.toString(), cause);
                }
                if (this.sendSubscriberExceptionEvent) {
                    post(new SubscriberExceptionEvent(this, cause, obj, subscription.subscriber));
                }
            } else {
                throw new EventBusException("Invoking subscriber failed", cause);
            }
        } catch (IllegalAccessException e3) {
            throw new IllegalStateException("Unexpected exception", e3);
        }
    }
}
