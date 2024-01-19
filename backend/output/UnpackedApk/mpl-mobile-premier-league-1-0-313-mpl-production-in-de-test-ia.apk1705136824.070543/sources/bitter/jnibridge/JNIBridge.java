package bitter.jnibridge;

import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JNIBridge {

    public static class a implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        public Object f2788a = new Object[0];

        /* renamed from: b  reason: collision with root package name */
        public long f2789b;

        /* renamed from: c  reason: collision with root package name */
        public Constructor f2790c;

        public a(long j) {
            this.f2789b = j;
            Class<Lookup> cls = Lookup.class;
            try {
                Constructor<Lookup> declaredConstructor = cls.getDeclaredConstructor(new Class[]{Class.class, Integer.TYPE});
                this.f2790c = declaredConstructor;
                declaredConstructor.setAccessible(true);
            } catch (NoClassDefFoundError unused) {
                this.f2790c = null;
            } catch (NoSuchMethodException unused2) {
                this.f2790c = null;
            }
        }

        private Object a(Object obj, Method method, Object[] objArr) {
            if (objArr == null) {
                objArr = new Object[0];
            }
            Class<?> declaringClass = method.getDeclaringClass();
            return ((Lookup) this.f2790c.newInstance(new Object[]{declaringClass, Integer.valueOf(2)})).in(declaringClass).unreflectSpecial(method, declaringClass).bindTo(obj).invokeWithArguments(objArr);
        }

        public final void a() {
            synchronized (this.f2788a) {
                this.f2789b = 0;
            }
        }

        public final void finalize() {
            synchronized (this.f2788a) {
                if (this.f2789b != 0) {
                    JNIBridge.delete(this.f2789b);
                }
            }
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            synchronized (this.f2788a) {
                if (this.f2789b == 0) {
                    return null;
                }
                try {
                    Object invoke = JNIBridge.invoke(this.f2789b, method.getDeclaringClass(), method, objArr);
                    return invoke;
                } catch (NoSuchMethodError e2) {
                    if (this.f2790c == null) {
                        System.err.println("JNIBridge error: Java interface default methods are only supported since Android Oreo");
                        throw e2;
                    } else if ((method.getModifiers() & 1024) == 0) {
                        return a(obj, method, objArr);
                    } else {
                        throw e2;
                    }
                }
            }
        }
    }

    public static native void delete(long j);

    public static void disableInterfaceProxy(Object obj) {
        if (obj != null) {
            ((a) Proxy.getInvocationHandler(obj)).a();
        }
    }

    public static native Object invoke(long j, Class cls, Method method, Object[] objArr);

    public static Object newInterfaceProxy(long j, Class[] clsArr) {
        return Proxy.newProxyInstance(JNIBridge.class.getClassLoader(), clsArr, new a(j));
    }
}
