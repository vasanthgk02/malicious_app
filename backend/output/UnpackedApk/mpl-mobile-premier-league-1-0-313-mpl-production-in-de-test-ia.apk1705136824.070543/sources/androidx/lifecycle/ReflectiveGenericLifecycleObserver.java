package androidx.lifecycle;

import androidx.lifecycle.ClassesInfoCache.CallbackInfo;
import androidx.lifecycle.Lifecycle.Event;

public class ReflectiveGenericLifecycleObserver implements LifecycleEventObserver {
    public final CallbackInfo mInfo;
    public final Object mWrapped;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.mWrapped = obj;
        this.mInfo = ClassesInfoCache.sInstance.getInfo(obj.getClass());
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Event event) {
        CallbackInfo callbackInfo = this.mInfo;
        Object obj = this.mWrapped;
        CallbackInfo.invokeMethodsForEvent(callbackInfo.mEventToHandlers.get(event), lifecycleOwner, event, obj);
        CallbackInfo.invokeMethodsForEvent(callbackInfo.mEventToHandlers.get(Event.ON_ANY), lifecycleOwner, event, obj);
    }
}
