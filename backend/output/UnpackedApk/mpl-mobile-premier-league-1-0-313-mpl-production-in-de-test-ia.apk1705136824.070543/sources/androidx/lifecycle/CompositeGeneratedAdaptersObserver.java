package androidx.lifecycle;

import androidx.lifecycle.Lifecycle.Event;

public class CompositeGeneratedAdaptersObserver implements LifecycleEventObserver {
    public final GeneratedAdapter[] mGeneratedAdapters;

    public CompositeGeneratedAdaptersObserver(GeneratedAdapter[] generatedAdapterArr) {
        this.mGeneratedAdapters = generatedAdapterArr;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Event event) {
        MethodCallsLogger methodCallsLogger = new MethodCallsLogger();
        for (GeneratedAdapter callMethods : this.mGeneratedAdapters) {
            callMethods.callMethods(lifecycleOwner, event, false, methodCallsLogger);
        }
        for (GeneratedAdapter callMethods2 : this.mGeneratedAdapters) {
            callMethods2.callMethods(lifecycleOwner, event, true, methodCallsLogger);
        }
    }
}
