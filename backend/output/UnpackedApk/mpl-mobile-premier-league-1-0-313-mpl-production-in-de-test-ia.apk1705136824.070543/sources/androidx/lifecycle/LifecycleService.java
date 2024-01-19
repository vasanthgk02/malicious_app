package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.lifecycle.Lifecycle.Event;

public class LifecycleService extends Service implements LifecycleOwner {
    public final ServiceLifecycleDispatcher mDispatcher = new ServiceLifecycleDispatcher(this);

    public Lifecycle getLifecycle() {
        return this.mDispatcher.mRegistry;
    }

    public IBinder onBind(Intent intent) {
        ServiceLifecycleDispatcher serviceLifecycleDispatcher = this.mDispatcher;
        if (serviceLifecycleDispatcher != null) {
            serviceLifecycleDispatcher.postDispatchRunnable(Event.ON_START);
            return null;
        }
        throw null;
    }

    public void onCreate() {
        ServiceLifecycleDispatcher serviceLifecycleDispatcher = this.mDispatcher;
        if (serviceLifecycleDispatcher != null) {
            serviceLifecycleDispatcher.postDispatchRunnable(Event.ON_CREATE);
            super.onCreate();
            return;
        }
        throw null;
    }

    public void onDestroy() {
        ServiceLifecycleDispatcher serviceLifecycleDispatcher = this.mDispatcher;
        if (serviceLifecycleDispatcher != null) {
            serviceLifecycleDispatcher.postDispatchRunnable(Event.ON_STOP);
            serviceLifecycleDispatcher.postDispatchRunnable(Event.ON_DESTROY);
            super.onDestroy();
            return;
        }
        throw null;
    }

    public void onStart(Intent intent, int i) {
        ServiceLifecycleDispatcher serviceLifecycleDispatcher = this.mDispatcher;
        if (serviceLifecycleDispatcher != null) {
            serviceLifecycleDispatcher.postDispatchRunnable(Event.ON_START);
            super.onStart(intent, i);
            return;
        }
        throw null;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }
}
