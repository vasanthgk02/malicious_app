package org.apache.commons.lang;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;
import org.apache.fontbox.cmap.CMap;
import org.apache.pdfbox.pdmodel.interactive.measurement.PDNumberFormatDictionary;

public class ClassUtils {
    public static final String INNER_CLASS_SEPARATOR = String.valueOf('$');
    public static final char INNER_CLASS_SEPARATOR_CHAR = '$';
    public static final String PACKAGE_SEPARATOR = String.valueOf('.');
    public static final char PACKAGE_SEPARATOR_CHAR = '.';
    public static Map abbreviationMap = new HashMap();
    public static /* synthetic */ Class class$java$lang$Boolean;
    public static /* synthetic */ Class class$java$lang$Byte;
    public static /* synthetic */ Class class$java$lang$Character;
    public static /* synthetic */ Class class$java$lang$Double;
    public static /* synthetic */ Class class$java$lang$Float;
    public static /* synthetic */ Class class$java$lang$Integer;
    public static /* synthetic */ Class class$java$lang$Long;
    public static /* synthetic */ Class class$java$lang$Short;
    public static /* synthetic */ Class class$org$apache$commons$lang$ClassUtils;
    public static Map primitiveWrapperMap;
    public static Map reverseAbbreviationMap = new HashMap();
    public static Map wrapperPrimitiveMap = new HashMap();

    static {
        HashMap hashMap = new HashMap();
        primitiveWrapperMap = hashMap;
        Class cls = Boolean.TYPE;
        Class cls2 = class$java$lang$Boolean;
        if (cls2 == null) {
            cls2 = class$("java.lang.Boolean");
            class$java$lang$Boolean = cls2;
        }
        hashMap.put(cls, cls2);
        Map map = primitiveWrapperMap;
        Class cls3 = Byte.TYPE;
        Class cls4 = class$java$lang$Byte;
        if (cls4 == null) {
            cls4 = class$("java.lang.Byte");
            class$java$lang$Byte = cls4;
        }
        map.put(cls3, cls4);
        Map map2 = primitiveWrapperMap;
        Class cls5 = Character.TYPE;
        Class cls6 = class$java$lang$Character;
        if (cls6 == null) {
            cls6 = class$("java.lang.Character");
            class$java$lang$Character = cls6;
        }
        map2.put(cls5, cls6);
        Map map3 = primitiveWrapperMap;
        Class cls7 = Short.TYPE;
        Class cls8 = class$java$lang$Short;
        if (cls8 == null) {
            cls8 = class$("java.lang.Short");
            class$java$lang$Short = cls8;
        }
        map3.put(cls7, cls8);
        Map map4 = primitiveWrapperMap;
        Class cls9 = Integer.TYPE;
        Class cls10 = class$java$lang$Integer;
        if (cls10 == null) {
            cls10 = class$("java.lang.Integer");
            class$java$lang$Integer = cls10;
        }
        map4.put(cls9, cls10);
        Map map5 = primitiveWrapperMap;
        Class cls11 = Long.TYPE;
        Class cls12 = class$java$lang$Long;
        if (cls12 == null) {
            cls12 = class$("java.lang.Long");
            class$java$lang$Long = cls12;
        }
        map5.put(cls11, cls12);
        Map map6 = primitiveWrapperMap;
        Class cls13 = Double.TYPE;
        Class cls14 = class$java$lang$Double;
        if (cls14 == null) {
            cls14 = class$("java.lang.Double");
            class$java$lang$Double = cls14;
        }
        map6.put(cls13, cls14);
        Map map7 = primitiveWrapperMap;
        Class cls15 = Float.TYPE;
        Class cls16 = class$java$lang$Float;
        if (cls16 == null) {
            cls16 = class$("java.lang.Float");
            class$java$lang$Float = cls16;
        }
        map7.put(cls15, cls16);
        Map map8 = primitiveWrapperMap;
        Class cls17 = Void.TYPE;
        map8.put(cls17, cls17);
        for (Class cls18 : primitiveWrapperMap.keySet()) {
            Class cls19 = (Class) primitiveWrapperMap.get(cls18);
            if (!cls18.equals(cls19)) {
                wrapperPrimitiveMap.put(cls19, cls18);
            }
        }
        addAbbreviation("int", "I");
        addAbbreviation("boolean", "Z");
        addAbbreviation("float", PDNumberFormatDictionary.FRACTIONAL_DISPLAY_FRACTION);
        addAbbreviation("long", "J");
        addAbbreviation("short", "S");
        addAbbreviation("byte", "B");
        addAbbreviation("double", "D");
        addAbbreviation("char", "C");
    }

    public static void addAbbreviation(String str, String str2) {
        abbreviationMap.put(str, str2);
        reverseAbbreviationMap.put(str2, str);
    }

    public static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public static List convertClassNamesToClasses(List<String> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String cls : list) {
            try {
                arrayList.add(Class.forName(cls));
            } catch (Exception unused) {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public static List convertClassesToClassNames(List<Class> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (Class cls : list) {
            if (cls == null) {
                arrayList.add(null);
            } else {
                arrayList.add(cls.getName());
            }
        }
        return arrayList;
    }

    public static List getAllInterfaces(Class<? super T> cls) {
        if (cls == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (cls != null) {
            Class[] interfaces = cls.getInterfaces();
            for (int i = 0; i < interfaces.length; i++) {
                if (!arrayList.contains(interfaces[i])) {
                    arrayList.add(interfaces[i]);
                }
                for (Class cls2 : getAllInterfaces(interfaces[i])) {
                    if (!arrayList.contains(cls2)) {
                        arrayList.add(cls2);
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return arrayList;
    }

    public static List getAllSuperclasses(Class cls) {
        if (cls == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Class<? super T> superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            arrayList.add(superclass);
        }
        return arrayList;
    }

    public static String getCanonicalName(String str) {
        String deleteWhitespace = StringUtils.deleteWhitespace(str);
        if (deleteWhitespace == null) {
            return null;
        }
        int i = 0;
        while (deleteWhitespace.startsWith("[")) {
            i++;
            deleteWhitespace = deleteWhitespace.substring(1);
        }
        if (i < 1) {
            return deleteWhitespace;
        }
        if (deleteWhitespace.startsWith("L")) {
            deleteWhitespace = deleteWhitespace.substring(1, deleteWhitespace.endsWith(";") ? deleteWhitespace.length() - 1 : deleteWhitespace.length());
        } else if (deleteWhitespace.length() > 0) {
            deleteWhitespace = (String) reverseAbbreviationMap.get(deleteWhitespace.substring(0, 1));
        }
        StringBuffer stringBuffer = new StringBuffer(deleteWhitespace);
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
        return stringBuffer.toString();
    }

    public static Class getClass(ClassLoader classLoader, String str, boolean z) throws ClassNotFoundException {
        if (!abbreviationMap.containsKey(str)) {
            return Class.forName(toCanonicalName(str), z, classLoader);
        }
        StringBuffer outline71 = GeneratedOutlineSupport.outline71("[");
        outline71.append(abbreviationMap.get(str));
        return Class.forName(outline71.toString(), z, classLoader).getComponentType();
    }

    public static String getPackageCanonicalName(Object obj, String str) {
        return obj == null ? str : getPackageCanonicalName(obj.getClass().getName());
    }

    public static String getPackageName(Object obj, String str) {
        return obj == null ? str : getPackageName(obj.getClass().getName());
    }

    public static Method getPublicMethod(Class cls, String str, Class[] clsArr) throws SecurityException, NoSuchMethodException {
        Method method = cls.getMethod(str, clsArr);
        if (Modifier.isPublic(method.getDeclaringClass().getModifiers())) {
            return method;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(getAllInterfaces(cls));
        arrayList.addAll(getAllSuperclasses(cls));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Class cls2 = (Class) it.next();
            if (Modifier.isPublic(cls2.getModifiers())) {
                try {
                    Method method2 = cls2.getMethod(str, clsArr);
                    if (Modifier.isPublic(method2.getDeclaringClass().getModifiers())) {
                        return method2;
                    }
                } catch (NoSuchMethodException unused) {
                    continue;
                }
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Can't find a public method for ");
        stringBuffer.append(str);
        stringBuffer.append(CMap.SPACE);
        stringBuffer.append(ArrayUtils.toString(clsArr));
        throw new NoSuchMethodException(stringBuffer.toString());
    }

    public static String getShortCanonicalName(Object obj, String str) {
        return obj == null ? str : getShortCanonicalName(obj.getClass().getName());
    }

    public static String getShortClassName(Object obj, String str) {
        return obj == null ? str : getShortClassName(obj.getClass().getName());
    }

    public static boolean isAssignable(Class[] clsArr, Class[] clsArr2) {
        if (!ArrayUtils.isSameLength((Object[]) clsArr, (Object[]) clsArr2)) {
            return false;
        }
        if (clsArr == null) {
            clsArr = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        if (clsArr2 == null) {
            clsArr2 = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        for (int i = 0; i < clsArr.length; i++) {
            if (!isAssignable(clsArr[i], clsArr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean isInnerClass(Class cls) {
        boolean z = false;
        if (cls == null) {
            return false;
        }
        if (cls.getName().indexOf(36) >= 0) {
            z = true;
        }
        return z;
    }

    public static Class primitiveToWrapper(Class cls) {
        return (cls == null || !cls.isPrimitive()) ? cls : (Class) primitiveWrapperMap.get(cls);
    }

    public static Class[] primitivesToWrappers(Class[] clsArr) {
        if (clsArr == null) {
            return null;
        }
        if (clsArr.length == 0) {
            return clsArr;
        }
        Class[] clsArr2 = new Class[clsArr.length];
        for (int i = 0; i < clsArr.length; i++) {
            clsArr2[i] = primitiveToWrapper(clsArr[i]);
        }
        return clsArr2;
    }

    public static String toCanonicalName(String str) {
        String deleteWhitespace = StringUtils.deleteWhitespace(str);
        if (deleteWhitespace == null) {
            throw new NullArgumentException("className");
        } else if (!deleteWhitespace.endsWith(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            return deleteWhitespace;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            while (deleteWhitespace.endsWith(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
                deleteWhitespace = deleteWhitespace.substring(0, deleteWhitespace.length() - 2);
                stringBuffer.append("[");
            }
            String str2 = (String) abbreviationMap.get(deleteWhitespace);
            if (str2 != null) {
                stringBuffer.append(str2);
            } else {
                stringBuffer.append("L");
                stringBuffer.append(deleteWhitespace);
                stringBuffer.append(";");
            }
            return stringBuffer.toString();
        }
    }

    public static Class[] toClass(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        if (objArr.length == 0) {
            return ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        Class[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            clsArr[i] = objArr[i].getClass();
        }
        return clsArr;
    }

    public static Class wrapperToPrimitive(Class cls) {
        return (Class) wrapperPrimitiveMap.get(cls);
    }

    public static Class[] wrappersToPrimitives(Class[] clsArr) {
        if (clsArr == null) {
            return null;
        }
        if (clsArr.length == 0) {
            return clsArr;
        }
        Class[] clsArr2 = new Class[clsArr.length];
        for (int i = 0; i < clsArr.length; i++) {
            clsArr2[i] = wrapperToPrimitive(clsArr[i]);
        }
        return clsArr2;
    }

    public static String getPackageCanonicalName(Class cls) {
        return cls == null ? "" : getPackageCanonicalName(cls.getName());
    }

    public static String getPackageName(Class cls) {
        return cls == null ? "" : getPackageName(cls.getName());
    }

    public static String getShortCanonicalName(Class cls) {
        return cls == null ? "" : getShortCanonicalName(cls.getName());
    }

    public static String getShortClassName(Class cls) {
        return cls == null ? "" : getShortClassName(cls.getName());
    }

    public static String getPackageCanonicalName(String str) {
        return getPackageName(getCanonicalName(str));
    }

    public static String getPackageName(String str) {
        if (str == null) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return "";
        }
        return str.substring(0, lastIndexOf);
    }

    public static String getShortCanonicalName(String str) {
        return getShortClassName(getCanonicalName(str));
    }

    public static String getShortClassName(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        int indexOf = str.indexOf(36, lastIndexOf == -1 ? 0 : lastIndexOf + 1);
        String substring = str.substring(lastIndexOf + 1);
        if (indexOf != -1) {
            substring = substring.replace('$', '.');
        }
        return substring;
    }

    public static Class getClass(ClassLoader classLoader, String str) throws ClassNotFoundException {
        return getClass(classLoader, str, true);
    }

    public static Class getClass(String str) throws ClassNotFoundException {
        return getClass(str, true);
    }

    public static boolean isAssignable(Class cls, Class cls2) {
        boolean z = false;
        if (cls2 == null) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        }
        if (cls.equals(cls2)) {
            return true;
        }
        if (!cls.isPrimitive()) {
            return cls2.isAssignableFrom(cls);
        }
        if (!cls2.isPrimitive()) {
            return false;
        }
        if (Integer.TYPE.equals(cls)) {
            if (Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2)) {
                z = true;
            }
            return z;
        } else if (Long.TYPE.equals(cls)) {
            if (Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2)) {
                z = true;
            }
            return z;
        } else if (Boolean.TYPE.equals(cls) || Double.TYPE.equals(cls)) {
            return false;
        } else {
            if (Float.TYPE.equals(cls)) {
                return Double.TYPE.equals(cls2);
            }
            if (Character.TYPE.equals(cls)) {
                if (Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2)) {
                    z = true;
                }
                return z;
            } else if (Short.TYPE.equals(cls)) {
                if (Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2)) {
                    z = true;
                }
                return z;
            } else {
                if (Byte.TYPE.equals(cls) && (Short.TYPE.equals(cls2) || Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2))) {
                    z = true;
                }
                return z;
            }
        }
    }

    public static Class getClass(String str, boolean z) throws ClassNotFoundException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            Class cls = class$org$apache$commons$lang$ClassUtils;
            if (cls == null) {
                cls = class$("org.apache.commons.lang.ClassUtils");
                class$org$apache$commons$lang$ClassUtils = cls;
            }
            contextClassLoader = cls.getClassLoader();
        }
        return getClass(contextClassLoader, str, z);
    }
}
