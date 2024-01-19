package androidx.startup;

import android.content.Context;
import android.os.Trace;
import androidx.core.widget.CompoundButtonCompat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class AppInitializer {
    public static volatile AppInitializer sInstance;
    public static final Object sLock = new Object();
    public final Context mContext;
    public final Set<Class<? extends Initializer<?>>> mDiscovered = new HashSet();
    public final Map<Class<?>, Object> mInitialized = new HashMap();

    public AppInitializer(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public <T> T doInitialize(Class<? extends Initializer<?>> cls, Set<Class<?>> set) {
        T t;
        synchronized (sLock) {
            if (CompoundButtonCompat.isEnabled()) {
                try {
                    Trace.beginSection(cls.getSimpleName());
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            }
            if (!set.contains(cls)) {
                if (!this.mInitialized.containsKey(cls)) {
                    set.add(cls);
                    Initializer initializer = (Initializer) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    List<Class<? extends Initializer<?>>> dependencies = initializer.dependencies();
                    if (!dependencies.isEmpty()) {
                        for (Class next : dependencies) {
                            if (!this.mInitialized.containsKey(next)) {
                                doInitialize(next, set);
                            }
                        }
                    }
                    t = initializer.create(this.mContext);
                    set.remove(cls);
                    this.mInitialized.put(cls, t);
                } else {
                    t = this.mInitialized.get(cls);
                }
                Trace.endSection();
            } else {
                throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", new Object[]{cls.getName()}));
            }
        }
        return t;
    }
}
