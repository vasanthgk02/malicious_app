package io.hansel.visualizer.d;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.json.CoreJSONArray;
import io.hansel.core.json.CoreJSONException;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.visualizer.b.c;
import io.hansel.visualizer.d.b.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final Map<Class<?>, Method> f5846a = new IdentityHashMap();

    private CoreJSONArray a(Object obj, String str) {
        CoreJSONArray coreJSONArray = new CoreJSONArray();
        Iterator it = ((List) obj).iterator();
        while (it.hasNext()) {
            Object next = it.next();
            coreJSONArray.put(next != null ? a(next, next.getClass(), str) : null);
        }
        return coreJSONArray;
    }

    private CoreJSONObject a(Object obj) {
        CoreJSONObject coreJSONObject = new CoreJSONObject();
        Field[] fields = obj.getClass().getFields();
        for (Field field : fields) {
            if (!Modifier.isStatic(field.getModifiers())) {
                io.hansel.visualizer.d.b.a aVar = (io.hansel.visualizer.d.b.a) field.getAnnotation(io.hansel.visualizer.d.b.a.class);
                if (aVar != null) {
                    Object obj2 = field.get(obj);
                    Class<?> type = field.getType();
                    if (obj2 != null) {
                        type = obj2.getClass();
                    }
                    String name = field.getName();
                    if (aVar.required() && obj2 == null) {
                        obj2 = CoreJSONObject.NULL;
                    } else if (obj2 != CoreJSONObject.NULL) {
                        obj2 = a(obj2, type, name);
                    }
                    coreJSONObject.put(name, obj2);
                }
            }
        }
        return coreJSONObject;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.Class<? extends java.lang.Enum>, java.lang.Class] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Enum a(java.lang.String r2, java.lang.Class<? extends java.lang.Enum> r3) {
        /*
            r1 = this;
            java.lang.reflect.Method r0 = r1.b(r3)
            if (r0 == 0) goto L_0x000b
            java.lang.Enum r2 = r1.a(r2, r3, r0)
            return r2
        L_0x000b:
            java.lang.Enum r2 = java.lang.Enum.valueOf(r3, r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.visualizer.d.a.a(java.lang.String, java.lang.Class):java.lang.Enum");
    }

    private Enum a(String str, Class<? extends Enum> cls, Method method) {
        Enum[] enumArr = (Enum[]) cls.getEnumConstants();
        int i = 0;
        while (i < enumArr.length) {
            Enum enumR = enumArr[i];
            try {
                Object invoke = method.invoke(enumR, new Object[0]);
                if (invoke != null && invoke.toString().equals(str)) {
                    return enumR;
                }
                i++;
            } catch (Exception e2) {
                throw new IllegalArgumentException(e2);
            }
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("No enum constant ");
        outline73.append(cls.getName());
        outline73.append(".");
        outline73.append(str);
        throw new IllegalArgumentException(outline73.toString());
    }

    private <T> T a(CoreJSONObject coreJSONObject, Class<T> cls) {
        Constructor<T> declaredConstructor = cls.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        T newInstance = declaredConstructor.newInstance(new Object[0]);
        Field[] fields = cls.getFields();
        for (Field field : fields) {
            if (!Modifier.isStatic(field.getModifiers())) {
                Object a2 = a(field, coreJSONObject.opt(field.getName()));
                try {
                    field.set(newInstance, a2);
                } catch (IllegalArgumentException e2) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Class: ");
                    outline73.append(cls.getSimpleName());
                    outline73.append(" Field: ");
                    outline73.append(field.getName());
                    outline73.append(" type ");
                    outline73.append(a2 != null ? a2.getClass().getName() : "null");
                    throw new IllegalArgumentException(outline73.toString(), e2);
                }
            }
        }
        return newInstance;
    }

    private Object a(Object obj, Class<?> cls, String str) {
        if (obj == null) {
            return null;
        }
        if (List.class.isAssignableFrom(cls)) {
            return a(obj, str);
        }
        Method b2 = b(cls);
        if (b2 != null) {
            return b2.invoke(obj, new Object[0]);
        }
        if (!a((Class) cls)) {
            return a(obj, CoreJSONObject.class);
        }
        if (cls.equals(Double.class) || cls.equals(Float.class)) {
            double doubleValue = ((Number) obj).doubleValue();
            if (Double.isNaN(doubleValue)) {
                return "NaN";
            }
            if (doubleValue == Double.POSITIVE_INFINITY) {
                return "Infinity";
            }
            if (doubleValue == Double.NEGATIVE_INFINITY) {
                obj = "-Infinity";
            }
        }
        return obj;
    }

    private Object a(Field field, Object obj) {
        if (obj != null) {
            try {
                if (obj == CoreJSONObject.NULL) {
                    return null;
                }
                if (obj.getClass() == field.getType()) {
                    return obj;
                }
                if (obj instanceof CoreJSONObject) {
                    return a(obj, field.getType());
                }
                if (field.getType().isEnum()) {
                    return a((String) obj, field.getType().asSubclass(Enum.class));
                }
                if (obj instanceof CoreJSONArray) {
                    return a(field, (CoreJSONArray) obj);
                }
                if (obj instanceof Number) {
                    Number number = (Number) obj;
                    Class<?> type = field.getType();
                    if (type != Integer.class) {
                        if (type != Integer.TYPE) {
                            if (type != Long.class) {
                                if (type != Long.TYPE) {
                                    if (type != Double.class) {
                                        if (type != Double.TYPE) {
                                            if (type != Float.class) {
                                                if (type != Float.TYPE) {
                                                    if (type != Byte.class) {
                                                        if (type != Byte.TYPE) {
                                                            if (type != Short.class) {
                                                                if (type != Short.TYPE) {
                                                                    throw new IllegalArgumentException("Not setup to handle class " + type.getName());
                                                                }
                                                            }
                                                            return Short.valueOf(number.shortValue());
                                                        }
                                                    }
                                                    return Byte.valueOf(number.byteValue());
                                                }
                                            }
                                            return Float.valueOf(number.floatValue());
                                        }
                                    }
                                    return Double.valueOf(number.doubleValue());
                                }
                            }
                            return Long.valueOf(number.longValue());
                        }
                    }
                    return Integer.valueOf(number.intValue());
                }
            } catch (IllegalAccessException e2) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unable to set value for field ");
                outline73.append(field.getName());
                throw new IllegalArgumentException(outline73.toString(), e2);
            }
        }
        return obj;
    }

    private List<Object> a(Field field, CoreJSONArray coreJSONArray) {
        Object obj;
        if (List.class.isAssignableFrom(field.getType())) {
            Type[] actualTypeArguments = ((ParameterizedType) field.getGenericType()).getActualTypeArguments();
            if (actualTypeArguments.length == 1) {
                Class cls = (Class) actualTypeArguments[0];
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < coreJSONArray.length(); i++) {
                    if (cls.isEnum()) {
                        obj = a(coreJSONArray.getString(i), cls);
                    } else if (a(cls)) {
                        obj = coreJSONArray.get(i);
                    } else {
                        CoreJSONObject jSONObject = coreJSONArray.getJSONObject(i);
                        obj = jSONObject == null ? null : a((Object) jSONObject, cls);
                    }
                    arrayList.add(obj);
                }
                return arrayList;
            }
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Only able to handle a single type in a list ");
            outline73.append(field.getName());
            throw new IllegalArgumentException(outline73.toString());
        }
        StringBuilder outline732 = GeneratedOutlineSupport.outline73("only know how to deserialize List<?> on field ");
        outline732.append(field.getName());
        throw new IllegalArgumentException(outline732.toString());
    }

    public static boolean a(Class cls) {
        return d(cls) || cls.equals(String.class);
    }

    private Method b(Class<?> cls) {
        Method method;
        synchronized (this.f5846a) {
            method = this.f5846a.get(cls);
            if (method == null && !this.f5846a.containsKey(cls)) {
                method = c(cls);
                this.f5846a.put(cls, method);
            }
        }
        return method;
    }

    public static Method c(Class<?> cls) {
        Method[] methods = cls.getMethods();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getAnnotation(b.class) != null) {
                return methods[i];
            }
        }
        return null;
    }

    public static boolean d(Class<?> cls) {
        return cls.isPrimitive() || cls.equals(Boolean.class) || cls.equals(Integer.class) || cls.equals(Character.class) || cls.equals(Byte.class) || cls.equals(Short.class) || cls.equals(Double.class) || cls.equals(Long.class) || cls.equals(Float.class);
    }

    public <T> T a(Object obj, Class<T> cls) {
        if (obj == null) {
            return null;
        }
        if (cls != Object.class && cls.isAssignableFrom(obj.getClass())) {
            return obj;
        }
        try {
            if (obj instanceof CoreJSONObject) {
                return a((CoreJSONObject) obj, cls);
            }
            if (cls == CoreJSONObject.class) {
                return a(obj);
            }
            throw new IllegalArgumentException("Expecting either fromValue or toValueType to be a CoreJSONObject");
        } catch (NoSuchMethodException e2) {
            throw new IllegalArgumentException(e2);
        } catch (IllegalAccessException e3) {
            throw new IllegalArgumentException(e3);
        } catch (InstantiationException e4) {
            throw new IllegalArgumentException(e4);
        } catch (CoreJSONException e5) {
            throw new IllegalArgumentException(e5);
        } catch (InvocationTargetException e6) {
            c.a(e6.getCause());
            throw null;
        }
    }
}
