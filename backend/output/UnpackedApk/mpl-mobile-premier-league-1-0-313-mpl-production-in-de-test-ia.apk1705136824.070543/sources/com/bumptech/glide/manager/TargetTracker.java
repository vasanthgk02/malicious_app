package com.bumptech.glide.manager;

import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public final class TargetTracker implements LifecycleListener {
    public final Set<Target<?>> targets = Collections.newSetFromMap(new WeakHashMap());

    public void onDestroy() {
        Iterator it = ((ArrayList) Util.getSnapshot(this.targets)).iterator();
        while (it.hasNext()) {
            ((Target) it.next()).onDestroy();
        }
    }

    public void onStart() {
        Iterator it = ((ArrayList) Util.getSnapshot(this.targets)).iterator();
        while (it.hasNext()) {
            ((Target) it.next()).onStart();
        }
    }

    public void onStop() {
        Iterator it = ((ArrayList) Util.getSnapshot(this.targets)).iterator();
        while (it.hasNext()) {
            ((Target) it.next()).onStop();
        }
    }
}
