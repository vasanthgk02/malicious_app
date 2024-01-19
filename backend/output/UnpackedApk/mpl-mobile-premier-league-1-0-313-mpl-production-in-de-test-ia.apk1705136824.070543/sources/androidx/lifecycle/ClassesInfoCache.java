package androidx.lifecycle;

import androidx.lifecycle.Lifecycle.Event;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class ClassesInfoCache {
    public static ClassesInfoCache sInstance = new ClassesInfoCache();
    public final Map<Class<?>, CallbackInfo> mCallbackMap = new HashMap();
    public final Map<Class<?>, Boolean> mHasLifecycleMethods = new HashMap();

    public static class CallbackInfo {
        public final Map<Event, List<MethodReference>> mEventToHandlers = new HashMap();
        public final Map<MethodReference, Event> mHandlerToEvent;

        public CallbackInfo(Map<MethodReference, Event> map) {
            this.mHandlerToEvent = map;
            for (Entry next : map.entrySet()) {
                Event event = (Event) next.getValue();
                List list = this.mEventToHandlers.get(event);
                if (list == null) {
                    list = new ArrayList();
                    this.mEventToHandlers.put(event, list);
                }
                list.add(next.getKey());
            }
        }

        public static void invokeMethodsForEvent(List<MethodReference> list, LifecycleOwner lifecycleOwner, Event event, Object obj) {
            if (list != null) {
                int size = list.size() - 1;
                while (size >= 0) {
                    MethodReference methodReference = list.get(size);
                    if (methodReference != null) {
                        try {
                            int i = methodReference.mCallType;
                            if (i == 0) {
                                methodReference.mMethod.invoke(obj, new Object[0]);
                            } else if (i == 1) {
                                methodReference.mMethod.invoke(obj, new Object[]{lifecycleOwner});
                            } else if (i == 2) {
                                methodReference.mMethod.invoke(obj, new Object[]{lifecycleOwner, event});
                            }
                            size--;
                        } catch (InvocationTargetException e2) {
                            throw new RuntimeException("Failed to call observer method", e2.getCause());
                        } catch (IllegalAccessException e3) {
                            throw new RuntimeException(e3);
                        }
                    } else {
                        throw null;
                    }
                }
            }
        }
    }

    public static final class MethodReference {
        public final int mCallType;
        public final Method mMethod;

        public MethodReference(int i, Method method) {
            this.mCallType = i;
            this.mMethod = method;
            method.setAccessible(true);
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MethodReference)) {
                return false;
            }
            MethodReference methodReference = (MethodReference) obj;
            if (this.mCallType != methodReference.mCallType || !this.mMethod.getName().equals(methodReference.mMethod.getName())) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return this.mMethod.getName().hashCode() + (this.mCallType * 31);
        }
    }

    public final CallbackInfo createInfo(Class<?> cls, Method[] methodArr) {
        int i;
        Class<? super T> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null) {
            CallbackInfo info = getInfo(superclass);
            if (info != null) {
                hashMap.putAll(info.mHandlerToEvent);
            }
        }
        for (Class info2 : cls.getInterfaces()) {
            for (Entry next : getInfo(info2).mHandlerToEvent.entrySet()) {
                verifyAndPutHandler(hashMap, (MethodReference) next.getKey(), (Event) next.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e2) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
            }
        }
        boolean z = false;
        for (Method method : methodArr) {
            OnLifecycleEvent onLifecycleEvent = (OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class);
            if (onLifecycleEvent != null) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (parameterTypes[0].isAssignableFrom(LifecycleOwner.class)) {
                    i = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                Event value = onLifecycleEvent.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(Event.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (value == Event.ON_ANY) {
                        i = 2;
                    } else {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (parameterTypes.length <= 2) {
                    verifyAndPutHandler(hashMap, new MethodReference(i, method), value, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        CallbackInfo callbackInfo = new CallbackInfo(hashMap);
        this.mCallbackMap.put(cls, callbackInfo);
        this.mHasLifecycleMethods.put(cls, Boolean.valueOf(z));
        return callbackInfo;
    }

    public CallbackInfo getInfo(Class<?> cls) {
        CallbackInfo callbackInfo = this.mCallbackMap.get(cls);
        if (callbackInfo != null) {
            return callbackInfo;
        }
        return createInfo(cls, null);
    }

    public final void verifyAndPutHandler(Map<MethodReference, Event> map, MethodReference methodReference, Event event, Class<?> cls) {
        Event event2 = map.get(methodReference);
        if (event2 != null && event != event2) {
            Method method = methodReference.mMethod;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Method ");
            outline73.append(method.getName());
            outline73.append(" in ");
            outline73.append(cls.getName());
            outline73.append(" already declared with different @OnLifecycleEvent value: previous value ");
            outline73.append(event2);
            outline73.append(", new value ");
            outline73.append(event);
            throw new IllegalArgumentException(outline73.toString());
        } else if (event2 == null) {
            map.put(methodReference, event);
        }
    }
}
