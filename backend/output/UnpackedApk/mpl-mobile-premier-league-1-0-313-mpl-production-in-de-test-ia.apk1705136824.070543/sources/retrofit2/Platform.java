package retrofit2;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public class Platform {
    public static final Platform PLATFORM;
    public final boolean hasJava8Types;
    public final Constructor<Lookup> lookupConstructor;

    public static final class Android extends Platform {

        public static final class MainThreadExecutor implements Executor {
            public final Handler handler = new Handler(Looper.getMainLooper());

            public void execute(Runnable runnable) {
                this.handler.post(runnable);
            }
        }

        public Android() {
            super(VERSION.SDK_INT >= 24);
        }

        public Executor defaultCallbackExecutor() {
            return new MainThreadExecutor();
        }

        public Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
            if (VERSION.SDK_INT >= 26) {
                return Platform.super.invokeDefaultMethod(method, cls, obj, objArr);
            }
            throw new UnsupportedOperationException("Calling default methods on API 24 and 25 is not supported");
        }
    }

    static {
        Platform platform;
        if ("Dalvik".equals(System.getProperty("java.vm.name"))) {
            platform = new Android();
        } else {
            platform = new Platform(true);
        }
        PLATFORM = platform;
    }

    public Platform(boolean z) {
        this.hasJava8Types = z;
        Constructor<Lookup> constructor = null;
        if (z) {
            Class<Lookup> cls = Lookup.class;
            try {
                constructor = cls.getDeclaredConstructor(new Class[]{Class.class, Integer.TYPE});
                constructor.setAccessible(true);
            } catch (NoClassDefFoundError | NoSuchMethodException unused) {
            }
        }
        this.lookupConstructor = constructor;
    }

    public Executor defaultCallbackExecutor() {
        return null;
    }

    @IgnoreJRERequirement
    public Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
        Lookup lookup;
        Constructor<Lookup> constructor = this.lookupConstructor;
        if (constructor != null) {
            lookup = constructor.newInstance(new Object[]{cls, Integer.valueOf(-1)});
        } else {
            lookup = MethodHandles.lookup();
        }
        return lookup.unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
    }
}
