package de.greenrobot.event;

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

public class EventBus {
    public static final EventBusBuilder DEFAULT_BUILDER = new EventBusBuilder();
    public static String TAG = "EventBus";
    public static volatile EventBus defaultInstance;
    public static final Map<Class<?>, List<Class<?>>> eventTypesCache = new HashMap();
    public final AsyncPoster asyncPoster;
    public final BackgroundPoster backgroundPoster;
    public final ThreadLocal<PostingThreadState> currentPostingThreadState;
    public final boolean eventInheritance;
    public final ExecutorService executorService;
    public final boolean logNoSubscriberMessages;
    public final boolean logSubscriberExceptions;
    public final HandlerPoster mainThreadPoster;
    public final boolean sendNoSubscriberEvent;
    public final boolean sendSubscriberExceptionEvent;
    public final Map<Class<?>, Object> stickyEvents;
    public final SubscriberMethodFinder subscriberMethodFinder;
    public final Map<Class<?>, CopyOnWriteArrayList<Subscription>> subscriptionsByEventType;
    public final boolean throwSubscriberException;
    public final Map<Object, List<Class<?>>> typesBySubscriber;

    /* renamed from: de.greenrobot.event.EventBus$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$de$greenrobot$event$ThreadMode;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001d */
        static {
            /*
                de.greenrobot.event.ThreadMode[] r0 = de.greenrobot.event.ThreadMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$de$greenrobot$event$ThreadMode = r0
                r1 = 1
                de.greenrobot.event.ThreadMode r2 = de.greenrobot.event.ThreadMode.PostThread     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = $SwitchMap$de$greenrobot$event$ThreadMode     // Catch:{ NoSuchFieldError -> 0x0016 }
                de.greenrobot.event.ThreadMode r3 = de.greenrobot.event.ThreadMode.MainThread     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = $SwitchMap$de$greenrobot$event$ThreadMode     // Catch:{ NoSuchFieldError -> 0x001d }
                de.greenrobot.event.ThreadMode r3 = de.greenrobot.event.ThreadMode.BackgroundThread     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$de$greenrobot$event$ThreadMode     // Catch:{ NoSuchFieldError -> 0x0024 }
                de.greenrobot.event.ThreadMode r2 = de.greenrobot.event.ThreadMode.Async     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: de.greenrobot.event.EventBus.AnonymousClass2.<clinit>():void");
        }
    }

    public interface PostCallback {
        void onPostCompleted(List<SubscriberExceptionEvent> list);
    }

    public static final class PostingThreadState {
        public boolean canceled;
        public Object event;
        public final List<Object> eventQueue = new ArrayList();
        public boolean isMainThread;
        public boolean isPosting;
        public Subscription subscription;
    }

    public EventBus() {
        this(DEFAULT_BUILDER);
    }

    public static void addInterfaces(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                addInterfaces(list, cls.getInterfaces());
            }
        }
    }

    public static EventBusBuilder builder() {
        return new EventBusBuilder();
    }

    private void checkPostStickyEventToSubscription(Subscription subscription, Object obj) {
        if (obj != null) {
            postToSubscription(subscription, obj, Looper.getMainLooper() == Looper.myLooper());
        }
    }

    public static void clearCaches() {
        SubscriberMethodFinder.clearCaches();
        eventTypesCache.clear();
    }

    public static EventBus getDefault() {
        if (defaultInstance == null) {
            synchronized (EventBus.class) {
                try {
                    if (defaultInstance == null) {
                        defaultInstance = new EventBus();
                    }
                }
            }
        }
        return defaultInstance;
    }

    private void handleSubscriberException(Subscription subscription, Object obj, Throwable th) {
        if (obj instanceof SubscriberExceptionEvent) {
            if (this.logSubscriberExceptions) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("SubscriberExceptionEvent subscriber ");
                outline73.append(subscription.subscriber.getClass());
                outline73.append(" threw an exception");
                outline73.toString();
                SubscriberExceptionEvent subscriberExceptionEvent = (SubscriberExceptionEvent) obj;
                StringBuilder outline732 = GeneratedOutlineSupport.outline73("Initial event ");
                outline732.append(subscriberExceptionEvent.causingEvent);
                outline732.append(" caused exception in ");
                outline732.append(subscriberExceptionEvent.causingSubscriber);
                outline732.toString();
            }
        } else if (!this.throwSubscriberException) {
            if (this.logSubscriberExceptions) {
                StringBuilder outline733 = GeneratedOutlineSupport.outline73("Could not dispatch event: ");
                outline733.append(obj.getClass());
                outline733.append(" to subscribing class ");
                outline733.append(subscription.subscriber.getClass());
                outline733.toString();
            }
            if (this.sendSubscriberExceptionEvent) {
                post(new SubscriberExceptionEvent(this, th, obj, subscription.subscriber));
            }
        } else {
            throw new EventBusException("Invoking subscriber failed", th);
        }
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Class<?>, code=java.lang.Class, for r5v0, types: [java.lang.Class<?>, java.lang.Class, java.lang.Object] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<java.lang.Class<?>> lookupAllEventTypes(java.lang.Class r5) {
        /*
            r4 = this;
            java.util.Map<java.lang.Class<?>, java.util.List<java.lang.Class<?>>> r0 = eventTypesCache
            monitor-enter(r0)
            java.util.Map<java.lang.Class<?>, java.util.List<java.lang.Class<?>>> r1 = eventTypesCache     // Catch:{ all -> 0x002b }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x002b }
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x002b }
            if (r1 != 0) goto L_0x0029
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x002b }
            r1.<init>()     // Catch:{ all -> 0x002b }
            r2 = r5
        L_0x0013:
            if (r2 == 0) goto L_0x0024
            r1.add(r2)     // Catch:{ all -> 0x002b }
            java.lang.Class[] r3 = r2.getInterfaces()     // Catch:{ all -> 0x002b }
            addInterfaces(r1, r3)     // Catch:{ all -> 0x002b }
            java.lang.Class r2 = r2.getSuperclass()     // Catch:{ all -> 0x002b }
            goto L_0x0013
        L_0x0024:
            java.util.Map<java.lang.Class<?>, java.util.List<java.lang.Class<?>>> r2 = eventTypesCache     // Catch:{ all -> 0x002b }
            r2.put(r5, r1)     // Catch:{ all -> 0x002b }
        L_0x0029:
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return r1
        L_0x002b:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: de.greenrobot.event.EventBus.lookupAllEventTypes(java.lang.Class):java.util.List");
    }

    private void postSingleEvent(Object obj, PostingThreadState postingThreadState) throws Error {
        boolean z;
        Class<?> cls = obj.getClass();
        if (this.eventInheritance) {
            List<Class<?>> lookupAllEventTypes = lookupAllEventTypes(cls);
            int size = lookupAllEventTypes.size();
            z = false;
            for (int i = 0; i < size; i++) {
                z |= postSingleEventForEventType(obj, postingThreadState, lookupAllEventTypes.get(i));
            }
        } else {
            z = postSingleEventForEventType(obj, postingThreadState, cls);
        }
        if (!z) {
            if (this.logNoSubscriberMessages) {
                "No subscribers registered for event " + cls;
            }
            if (this.sendNoSubscriberEvent && cls != NoSubscriberEvent.class && cls != SubscriberExceptionEvent.class) {
                post(new NoSubscriberEvent(this, obj));
            }
        }
    }

    private boolean postSingleEventForEventType(Object obj, PostingThreadState postingThreadState, Class<?> cls) {
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
            postingThreadState.subscription = subscription;
            try {
                postToSubscription(subscription, obj, postingThreadState.isMainThread);
                if (postingThreadState.canceled) {
                    break;
                }
            } finally {
                postingThreadState.event = null;
                postingThreadState.subscription = null;
                postingThreadState.canceled = false;
            }
        }
        return true;
    }

    private void postToSubscription(Subscription subscription, Object obj, boolean z) {
        int ordinal = subscription.subscriberMethod.threadMode.ordinal();
        if (ordinal == 0) {
            invokeSubscriber(subscription, obj);
        } else if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal == 3) {
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

    private void subscribe(Object obj, SubscriberMethod subscriberMethod) {
        Class<?> cls = subscriberMethod.eventType;
        CopyOnWriteArrayList copyOnWriteArrayList = this.subscriptionsByEventType.get(cls);
        Subscription subscription = new Subscription(obj, subscriberMethod);
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
        synchronized (copyOnWriteArrayList) {
            int size = copyOnWriteArrayList.size();
            int i = 0;
            while (true) {
                if (i > size) {
                    break;
                } else if (i == size) {
                    break;
                } else if (subscriberMethod.priority > ((Subscription) copyOnWriteArrayList.get(i)).subscriberMethod.priority) {
                    break;
                } else {
                    i++;
                }
            }
            copyOnWriteArrayList.add(i, subscription);
        }
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
                    checkPostStickyEventToSubscription(subscription, next.getValue());
                }
            }
            return;
        }
        checkPostStickyEventToSubscription(subscription, this.stickyEvents.get(cls));
    }

    private void unubscribeByEventType(Object obj, Class<?> cls) {
        List list = this.subscriptionsByEventType.get(cls);
        if (list != null) {
            synchronized (list) {
                int size = list.size();
                int i = 0;
                while (i < size) {
                    Subscription subscription = (Subscription) list.get(i);
                    if (subscription.subscriber == obj) {
                        subscription.active = false;
                        list.remove(i);
                        i--;
                        size--;
                    }
                    i++;
                }
            }
        }
    }

    public void cancelEventDelivery(Object obj) {
        PostingThreadState postingThreadState = this.currentPostingThreadState.get();
        if (!postingThreadState.isPosting) {
            throw new EventBusException((String) "This method may only be called from inside event handling methods on the posting thread");
        } else if (obj == null) {
            throw new EventBusException((String) "Event may not be null");
        } else if (postingThreadState.event != obj) {
            throw new EventBusException((String) "Only the currently handled event may be aborted");
        } else if (postingThreadState.subscription.subscriberMethod.threadMode == ThreadMode.PostThread) {
            postingThreadState.canceled = true;
        } else {
            throw new EventBusException((String) " event handlers may only abort the incoming event");
        }
    }

    public ExecutorService getExecutorService() {
        return this.executorService;
    }

    public <T> T getStickyEvent(Class<T> cls) {
        T cast;
        synchronized (this.stickyEvents) {
            cast = cls.cast(this.stickyEvents.get(cls));
        }
        return cast;
    }

    public boolean hasSubscriberForEvent(Class<?> cls) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        List<Class<?>> lookupAllEventTypes = lookupAllEventTypes(cls);
        if (lookupAllEventTypes != null) {
            int size = lookupAllEventTypes.size();
            for (int i = 0; i < size; i++) {
                Class cls2 = lookupAllEventTypes.get(i);
                synchronized (this) {
                    copyOnWriteArrayList = this.subscriptionsByEventType.get(cls2);
                }
                if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void invokeSubscriber(PendingPost pendingPost) {
        Object obj = pendingPost.event;
        Subscription subscription = pendingPost.subscription;
        PendingPost.releasePendingPost(pendingPost);
        if (subscription.active) {
            invokeSubscriber(subscription, obj);
        }
    }

    public synchronized boolean isRegistered(Object obj) {
        return this.typesBySubscriber.containsKey(obj);
    }

    public void post(Object obj) {
        PostingThreadState postingThreadState = this.currentPostingThreadState.get();
        List<Object> list = postingThreadState.eventQueue;
        list.add(obj);
        if (!postingThreadState.isPosting) {
            postingThreadState.isMainThread = Looper.getMainLooper() == Looper.myLooper();
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
            throw new EventBusException((String) "Internal error. Abort state was not reset");
        }
    }

    public void postSticky(Object obj) {
        synchronized (this.stickyEvents) {
            this.stickyEvents.put(obj.getClass(), obj);
        }
        post(obj);
    }

    public void register(Object obj) {
        Class<?> cls = obj.getClass();
        for (SubscriberMethod subscribe : this.subscriberMethodFinder.findSubscriberMethods(cls, cls.isAnonymousClass())) {
            subscribe(obj, subscribe);
        }
    }

    public void removeAllStickyEvents() {
        synchronized (this.stickyEvents) {
            this.stickyEvents.clear();
        }
    }

    public <T> T removeStickyEvent(Class<T> cls) {
        T cast;
        synchronized (this.stickyEvents) {
            cast = cls.cast(this.stickyEvents.remove(cls));
        }
        return cast;
    }

    public synchronized void unregister(Object obj) {
        List<Class> list = this.typesBySubscriber.get(obj);
        if (list != null) {
            for (Class unubscribeByEventType : list) {
                unubscribeByEventType(obj, unubscribeByEventType);
            }
            this.typesBySubscriber.remove(obj);
        } else {
            "Subscriber to unregister was not registered before: " + obj.getClass();
        }
    }

    public EventBus(EventBusBuilder eventBusBuilder) {
        this.currentPostingThreadState = new ThreadLocal<PostingThreadState>() {
            public PostingThreadState initialValue() {
                return new PostingThreadState();
            }
        };
        this.subscriptionsByEventType = new HashMap();
        this.typesBySubscriber = new HashMap();
        this.stickyEvents = new ConcurrentHashMap();
        this.mainThreadPoster = new HandlerPoster(this, Looper.getMainLooper(), 10);
        this.backgroundPoster = new BackgroundPoster(this);
        this.asyncPoster = new AsyncPoster(this);
        this.subscriberMethodFinder = new SubscriberMethodFinder(false);
        this.logSubscriberExceptions = eventBusBuilder.logSubscriberExceptions;
        this.logNoSubscriberMessages = eventBusBuilder.logNoSubscriberMessages;
        this.sendSubscriberExceptionEvent = eventBusBuilder.sendSubscriberExceptionEvent;
        this.sendNoSubscriberEvent = eventBusBuilder.sendNoSubscriberEvent;
        this.throwSubscriberException = eventBusBuilder.throwSubscriberException;
        this.eventInheritance = eventBusBuilder.eventInheritance;
        this.executorService = eventBusBuilder.executorService;
    }

    public boolean removeStickyEvent(Object obj) {
        synchronized (this.stickyEvents) {
            Class<?> cls = obj.getClass();
            if (!obj.equals(this.stickyEvents.get(cls))) {
                return false;
            }
            this.stickyEvents.remove(cls);
            return true;
        }
    }

    public void invokeSubscriber(Subscription subscription, Object obj) {
        try {
            subscription.subscriberMethod.method.invoke(subscription.subscriber, new Object[]{obj});
        } catch (InvocationTargetException e2) {
            handleSubscriberException(subscription, obj, e2.getCause());
        } catch (IllegalAccessException e3) {
            throw new IllegalStateException("Unexpected exception", e3);
        }
    }
}
