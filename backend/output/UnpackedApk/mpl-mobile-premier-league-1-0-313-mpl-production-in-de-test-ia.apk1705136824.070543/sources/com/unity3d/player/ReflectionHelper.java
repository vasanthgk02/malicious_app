package com.unity3d.player;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.pdfbox.pdmodel.interactive.measurement.PDNumberFormatDictionary;

public final class ReflectionHelper {
    public static boolean LOG;
    public static final boolean LOGV = false;

    /* renamed from: a  reason: collision with root package name */
    public static a[] f3387a = new a[4096];

    /* renamed from: b  reason: collision with root package name */
    public static long f3388b;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public volatile Member f3394a;

        /* renamed from: b  reason: collision with root package name */
        public final Class f3395b;

        /* renamed from: c  reason: collision with root package name */
        public final String f3396c;

        /* renamed from: d  reason: collision with root package name */
        public final String f3397d;

        /* renamed from: e  reason: collision with root package name */
        public final int f3398e;

        public a(Class cls, String str, String str2) {
            this.f3395b = cls;
            this.f3396c = str;
            this.f3397d = str2;
            this.f3398e = this.f3397d.hashCode() + GeneratedOutlineSupport.outline11(this.f3396c, (cls.hashCode() + 527) * 31, 31);
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f3398e == aVar.f3398e && this.f3397d.equals(aVar.f3397d) && this.f3396c.equals(aVar.f3396c) && this.f3395b.equals(aVar.f3395b);
            }
        }

        public final int hashCode() {
            return this.f3398e;
        }
    }

    public interface b extends InvocationHandler {
        void a(long j, boolean z);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:8|9|(2:11|12)|13|14|(2:16|17)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x001e */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static float a(java.lang.Class r1, java.lang.Class r2) {
        /*
            boolean r0 = r1.equals(r2)
            if (r0 == 0) goto L_0x0009
            r1 = 1065353216(0x3f800000, float:1.0)
            return r1
        L_0x0009:
            boolean r0 = r1.isPrimitive()
            if (r0 != 0) goto L_0x0028
            boolean r0 = r2.isPrimitive()
            if (r0 != 0) goto L_0x0028
            java.lang.Class r0 = r1.asSubclass(r2)     // Catch:{ ClassCastException -> 0x001e }
            if (r0 == 0) goto L_0x001e
            r1 = 1056964608(0x3f000000, float:0.5)
            return r1
        L_0x001e:
            java.lang.Class r1 = r2.asSubclass(r1)     // Catch:{ ClassCastException -> 0x0028 }
            if (r1 == 0) goto L_0x0028
            r1 = 1036831949(0x3dcccccd, float:0.1)
            return r1
        L_0x0028:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.ReflectionHelper.a(java.lang.Class, java.lang.Class):float");
    }

    public static float a(Class cls, Class[] clsArr, Class[] clsArr2) {
        if (clsArr2.length == 0) {
            return 0.1f;
        }
        int i = 0;
        if ((clsArr == null ? 0 : clsArr.length) + 1 != clsArr2.length) {
            return 0.0f;
        }
        float f2 = 1.0f;
        if (clsArr != null) {
            int length = clsArr.length;
            int i2 = 0;
            float f3 = 1.0f;
            while (i < length) {
                f3 *= a(clsArr[i], clsArr2[i2]);
                i++;
                i2++;
            }
            f2 = f3;
        }
        return a(cls, clsArr2[clsArr2.length - 1]) * f2;
    }

    public static Class a(String str, int[] iArr) {
        while (true) {
            if (iArr[0] >= str.length()) {
                break;
            }
            int i = iArr[0];
            iArr[0] = i + 1;
            char charAt = str.charAt(i);
            if (charAt != '(' && charAt != ')') {
                if (charAt == 'L') {
                    int indexOf = str.indexOf(59, iArr[0]);
                    if (indexOf != -1) {
                        String substring = str.substring(iArr[0], indexOf);
                        iArr[0] = indexOf + 1;
                        try {
                            return Class.forName(substring.replace('/', '.'));
                        } catch (ClassNotFoundException unused) {
                        }
                    }
                } else if (charAt == 'Z') {
                    return Boolean.TYPE;
                } else {
                    if (charAt == 'I') {
                        return Integer.TYPE;
                    }
                    if (charAt == 'F') {
                        return Float.TYPE;
                    }
                    if (charAt == 'V') {
                        return Void.TYPE;
                    }
                    if (charAt == 'B') {
                        return Byte.TYPE;
                    }
                    if (charAt == 'C') {
                        return Character.TYPE;
                    }
                    if (charAt == 'S') {
                        return Short.TYPE;
                    }
                    if (charAt == 'J') {
                        return Long.TYPE;
                    }
                    if (charAt == 'D') {
                        return Double.TYPE;
                    }
                    if (charAt == '[') {
                        return Array.newInstance(a(str, iArr), 0).getClass();
                    }
                    f.Log(5, "! parseType; " + charAt + " is not known!");
                }
            }
        }
        return null;
    }

    public static synchronized void a(a aVar, Member member) {
        synchronized (ReflectionHelper.class) {
            aVar.f3394a = member;
            f3387a[aVar.hashCode() & (f3387a.length - 1)] = aVar;
        }
    }

    public static synchronized boolean a(a aVar) {
        synchronized (ReflectionHelper.class) {
            a aVar2 = f3387a[aVar.hashCode() & (f3387a.length - 1)];
            if (!aVar.equals(aVar2)) {
                return false;
            }
            aVar.f3394a = aVar2.f3394a;
            return true;
        }
    }

    public static Class[] a(String str) {
        int i = 0;
        int[] iArr = {0};
        ArrayList arrayList = new ArrayList();
        while (iArr[0] < str.length()) {
            Class a2 = a(str, iArr);
            if (a2 == null) {
                break;
            }
            arrayList.add(a2);
        }
        Class[] clsArr = new Class[arrayList.size()];
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            clsArr[i] = (Class) it.next();
            i++;
        }
        return clsArr;
    }

    public static void endUnityLaunch() {
        f3388b++;
    }

    public static Constructor getConstructorID(Class cls, String str) {
        Constructor constructor;
        a aVar = new a(cls, "", str);
        if (a(aVar)) {
            constructor = (Constructor) aVar.f3394a;
        } else {
            Class[] a2 = a(str);
            float f2 = 0.0f;
            Constructor constructor2 = null;
            for (Constructor constructor3 : cls.getConstructors()) {
                float a3 = a(Void.TYPE, constructor3.getParameterTypes(), a2);
                if (a3 > f2) {
                    constructor2 = constructor3;
                    if (a3 == 1.0f) {
                        break;
                    }
                    f2 = a3;
                }
            }
            a(aVar, (Member) constructor2);
            constructor = constructor2;
        }
        if (constructor != null) {
            return constructor;
        }
        StringBuilder sb = new StringBuilder("<init>");
        sb.append(str);
        sb.append(" in class ");
        throw new NoSuchMethodError(GeneratedOutlineSupport.outline35(cls, sb));
    }

    public static Field getFieldID(Class cls, String str, String str2, boolean z) {
        Field field;
        String str3 = str;
        String str4 = str2;
        boolean z2 = z;
        Class cls2 = cls;
        a aVar = new a(cls2, str3, str4);
        if (a(aVar)) {
            field = (Field) aVar.f3394a;
        } else {
            Class[] a2 = a(str2);
            float f2 = 0.0f;
            Field field2 = null;
            while (cls2 != null) {
                Field[] declaredFields = cls2.getDeclaredFields();
                int length = declaredFields.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    Field field3 = declaredFields[i];
                    if (z2 == Modifier.isStatic(field3.getModifiers()) && field3.getName().compareTo(str3) == 0) {
                        float a3 = a((Class) field3.getType(), (Class[]) null, a2);
                        if (a3 > f2) {
                            field2 = field3;
                            if (a3 == 1.0f) {
                                f2 = a3;
                                break;
                            }
                            f2 = a3;
                        } else {
                            continue;
                        }
                    }
                    i++;
                }
                if (f2 == 1.0f || cls2.isPrimitive() || cls2.isInterface() || cls2.equals(Object.class) || cls2.equals(Void.TYPE)) {
                    break;
                }
                cls2 = cls2.getSuperclass();
            }
            a(aVar, (Member) field2);
            field = field2;
        }
        if (field != null) {
            return field;
        }
        Object[] objArr = new Object[4];
        objArr[0] = z2 ? "static" : "non-static";
        objArr[1] = str3;
        objArr[2] = str4;
        objArr[3] = cls2.getName();
        throw new NoSuchFieldError(String.format("no %s field with name='%s' signature='%s' in class L%s;", objArr));
    }

    public static String getFieldSignature(Field field) {
        Class<?> type = field.getType();
        if (type.isPrimitive()) {
            String name = type.getName();
            if ("boolean".equals(name)) {
                return "Z";
            }
            if ("byte".equals(name)) {
                return "B";
            }
            if ("char".equals(name)) {
                return "C";
            }
            if ("double".equals(name)) {
                return "D";
            }
            if ("float".equals(name)) {
                return PDNumberFormatDictionary.FRACTIONAL_DISPLAY_FRACTION;
            }
            if ("int".equals(name)) {
                return "I";
            }
            if ("long".equals(name)) {
                return "J";
            }
            if ("short".equals(name)) {
                name = "S";
            }
            return name;
        } else if (type.isArray()) {
            return type.getName().replace('.', '/');
        } else {
            return "L" + type.getName().replace('.', '/') + ";";
        }
    }

    public static Method getMethodID(Class cls, String str, String str2, boolean z) {
        Method method;
        String str3 = str;
        String str4 = str2;
        boolean z2 = z;
        Class cls2 = cls;
        a aVar = new a(cls2, str3, str4);
        if (a(aVar)) {
            method = (Method) aVar.f3394a;
        } else {
            Class[] a2 = a(str2);
            float f2 = 0.0f;
            Method method2 = null;
            while (cls2 != null) {
                Method[] declaredMethods = cls2.getDeclaredMethods();
                int length = declaredMethods.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    Method method3 = declaredMethods[i];
                    if (z2 == Modifier.isStatic(method3.getModifiers()) && method3.getName().compareTo(str3) == 0) {
                        float a3 = a((Class) method3.getReturnType(), method3.getParameterTypes(), a2);
                        if (a3 > f2) {
                            if (a3 == 1.0f) {
                                f2 = a3;
                                method2 = method3;
                                break;
                            }
                            f2 = a3;
                            method2 = method3;
                        } else {
                            continue;
                        }
                    }
                    i++;
                }
                if (f2 == 1.0f || cls2.isPrimitive() || cls2.isInterface() || cls2.equals(Object.class) || cls2.equals(Void.TYPE)) {
                    break;
                }
                cls2 = z2 ? null : cls2.getSuperclass();
            }
            a(aVar, (Member) method2);
            method = method2;
        }
        if (method != null) {
            return method;
        }
        Object[] objArr = new Object[4];
        objArr[0] = z2 ? "static" : "non-static";
        objArr[1] = str3;
        objArr[2] = str4;
        objArr[3] = cls2.getName();
        throw new NoSuchMethodError(String.format("no %s method with name='%s' signature='%s' in class L%s;", objArr));
    }

    public static native void nativeProxyFinalize(long j);

    public static native Object nativeProxyInvoke(long j, String str, Object[] objArr);

    public static native void nativeProxyLogJNIInvokeException(long j);

    public static Object newProxyInstance(long j, Class cls) {
        return newProxyInstance(j, new Class[]{cls});
    }

    public static Object newProxyInstance(final long j, final Class[] clsArr) {
        return Proxy.newProxyInstance(ReflectionHelper.class.getClassLoader(), clsArr, new b() {

            /* renamed from: c  reason: collision with root package name */
            public long f3391c = ReflectionHelper.f3388b;

            /* renamed from: d  reason: collision with root package name */
            public long f3392d;

            /* renamed from: e  reason: collision with root package name */
            public boolean f3393e;

            private Object a(Object obj, Method method, Object[] objArr) {
                if (objArr == null) {
                    try {
                        objArr = new Object[0];
                    } catch (NoClassDefFoundError unused) {
                        f.Log(6, String.format("Java interface default methods are only supported since Android Oreo", new Object[0]));
                        ReflectionHelper.nativeProxyLogJNIInvokeException(this.f3392d);
                        return null;
                    }
                }
                Class<?> declaringClass = method.getDeclaringClass();
                Constructor<Lookup> declaredConstructor = Lookup.class.getDeclaredConstructor(new Class[]{Class.class, Integer.TYPE});
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(new Object[]{declaringClass, Integer.valueOf(2)}).in(declaringClass).unreflectSpecial(method, declaringClass).bindTo(obj).invokeWithArguments(objArr);
            }

            public final void a(long j, boolean z) {
                this.f3392d = j;
                this.f3393e = z;
            }

            public final void finalize() {
                try {
                    if (this.f3391c == ReflectionHelper.f3388b) {
                        ReflectionHelper.nativeProxyFinalize(j);
                    }
                } finally {
                    super.finalize();
                }
            }

            /* JADX WARNING: Code restructure failed: missing block: B:12:0x003b, code lost:
                if (r6 != 0) goto L_0x003d;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invoke(java.lang.Object r6, java.lang.reflect.Method r7, java.lang.Object[] r8) {
                /*
                    r5 = this;
                    long r0 = r5.f3391c
                    long r2 = com.unity3d.player.ReflectionHelper.f3388b
                    int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r4 == 0) goto L_0x0012
                    r6 = 6
                    java.lang.String r7 = "Scripting proxy object was destroyed, because Unity player was unloaded."
                    com.unity3d.player.f.Log(r6, r7)
                    r6 = 0
                    return r6
                L_0x0012:
                    r0 = 0
                    r5.f3392d = r0
                    r2 = 0
                    r5.f3393e = r2
                    long r2 = r2
                    java.lang.String r4 = r7.getName()
                    java.lang.Object r2 = com.unity3d.player.ReflectionHelper.nativeProxyInvoke(r2, r4, r8)
                    boolean r3 = r5.f3393e
                    if (r3 == 0) goto L_0x0037
                    int r0 = r7.getModifiers()
                    r0 = r0 & 1024(0x400, float:1.435E-42)
                    if (r0 != 0) goto L_0x0034
                    java.lang.Object r6 = r5.a(r6, r7, r8)
                    return r6
                L_0x0034:
                    long r6 = r5.f3392d
                    goto L_0x003d
                L_0x0037:
                    long r6 = r5.f3392d
                    int r8 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
                    if (r8 == 0) goto L_0x0040
                L_0x003d:
                    com.unity3d.player.ReflectionHelper.nativeProxyLogJNIInvokeException(r6)
                L_0x0040:
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.ReflectionHelper.AnonymousClass1.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
            }
        });
    }

    public static void setNativeExceptionOnProxy(Object obj, long j, boolean z) {
        ((b) Proxy.getInvocationHandler(obj)).a(j, z);
    }
}
