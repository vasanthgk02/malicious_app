package com.freshchat.consumer.sdk.f;

import android.app.Activity;
import android.app.Application;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.e.f;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.cc;
import java.util.HashSet;
import java.util.Set;

public class c extends cc {
    public static c mR;
    public boolean mS;
    public Set<Integer> mT = new HashSet();
    public volatile boolean mU;

    public c(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    public static synchronized c a(Application application) {
        c cVar;
        synchronized (c.class) {
            if (mR == null) {
                synchronized (c.class) {
                    mR = new c(application);
                }
            }
            cVar = mR;
        }
        return cVar;
    }

    private void c(Activity activity) {
        boolean z = !this.mT.isEmpty() || activity.isChangingConfigurations();
        this.mS = z;
        if (z && this.mU) {
            f.bV(activity.getApplicationContext());
            this.mU = false;
        }
    }

    public boolean cE() {
        return this.mS;
    }

    public void m(boolean z) {
        ai.i("AppStateListener", " FreshchatInitApiDeferred called - is init Deferred : " + z);
        this.mU = z;
    }

    public void onActivityStarted(Activity activity) {
        this.mT.add(Integer.valueOf(System.identityHashCode(activity)));
        c(activity);
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("onActivityStarted for activity : ");
        outline73.append(activity.getLocalClassName());
        outline73.append(" isForegound : ");
        outline73.append(cE());
        ai.i("AppStateListener", outline73.toString());
    }

    public void onActivityStopped(Activity activity) {
        this.mT.remove(Integer.valueOf(System.identityHashCode(activity)));
        c(activity);
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("onActivityStopped for activity : ");
        outline73.append(activity.getLocalClassName());
        outline73.append(" isForegound : ");
        outline73.append(cE());
        ai.i("AppStateListener", outline73.toString());
    }
}
