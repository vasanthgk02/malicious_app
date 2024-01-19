package org.apache.commons.lang.enums;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.fontbox.cmap.CMapParser;

public abstract class Enum implements Comparable, Serializable {
    public static final Map EMPTY_MAP = Collections.unmodifiableMap(new HashMap(0));
    public static Map cEnumClasses = new WeakHashMap();
    public static /* synthetic */ Class class$org$apache$commons$lang$enums$Enum = null;
    public static /* synthetic */ Class class$org$apache$commons$lang$enums$ValuedEnum = null;
    public static final long serialVersionUID = -487045951170455942L;
    public final transient int iHashCode;
    public final String iName;
    public transient String iToString = null;

    public static class Entry {
        public final List list;
        public final Map map;
        public final List unmodifiableList;
        public final Map unmodifiableMap;

        public Entry() {
            HashMap hashMap = new HashMap();
            this.map = hashMap;
            this.unmodifiableMap = Collections.unmodifiableMap(hashMap);
            ArrayList arrayList = new ArrayList(25);
            this.list = arrayList;
            this.unmodifiableList = Collections.unmodifiableList(arrayList);
        }
    }

    public Enum(String str) {
        init(str);
        this.iName = str;
        this.iHashCode = (str.hashCode() * 3) + getEnumClass().hashCode() + 7;
    }

    public static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public static Entry createEntry(Class cls) {
        Entry entry = new Entry();
        Class<? super T> superclass = cls.getSuperclass();
        while (true) {
            if (superclass == null) {
                break;
            }
            Class<? super T> cls2 = class$org$apache$commons$lang$enums$Enum;
            if (cls2 == null) {
                cls2 = class$("org.apache.commons.lang.enums.Enum");
                class$org$apache$commons$lang$enums$Enum = cls2;
            }
            if (superclass == cls2) {
                break;
            }
            Class<? super T> cls3 = class$org$apache$commons$lang$enums$ValuedEnum;
            if (cls3 == null) {
                cls3 = class$("org.apache.commons.lang.enums.ValuedEnum");
                class$org$apache$commons$lang$enums$ValuedEnum = cls3;
            }
            if (superclass == cls3) {
                break;
            }
            Entry entry2 = (Entry) cEnumClasses.get(superclass);
            if (entry2 != null) {
                entry.list.addAll(entry2.list);
                entry.map.putAll(entry2.map);
                break;
            }
            superclass = superclass.getSuperclass();
        }
        return entry;
    }

    public static Entry getEntry(Class cls) {
        if (cls != null) {
            Class cls2 = class$org$apache$commons$lang$enums$Enum;
            if (cls2 == null) {
                cls2 = class$("org.apache.commons.lang.enums.Enum");
                class$org$apache$commons$lang$enums$Enum = cls2;
            }
            if (cls2.isAssignableFrom(cls)) {
                return (Entry) cEnumClasses.get(cls);
            }
            throw new IllegalArgumentException("The Class must be a subclass of Enum");
        }
        throw new IllegalArgumentException("The Enum Class must not be null");
    }

    public static Enum getEnum(Class cls, String str) {
        Entry entry = getEntry(cls);
        if (entry == null) {
            return null;
        }
        return (Enum) entry.map.get(str);
    }

    public static List getEnumList(Class cls) {
        Entry entry = getEntry(cls);
        if (entry == null) {
            return Collections.EMPTY_LIST;
        }
        return entry.unmodifiableList;
    }

    public static Map getEnumMap(Class cls) {
        Entry entry = getEntry(cls);
        if (entry == null) {
            return EMPTY_MAP;
        }
        return entry.unmodifiableMap;
    }

    private String getNameInOtherClassLoader(Object obj) {
        try {
            return (String) obj.getClass().getMethod("getName", null).invoke(obj, null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            throw new IllegalStateException("This should not happen");
        }
    }

    private void init(String str) {
        Entry entry;
        if (!StringUtils.isEmpty(str)) {
            Class enumClass = getEnumClass();
            if (enumClass != null) {
                Class cls = getClass();
                boolean z = false;
                while (true) {
                    if (cls == null) {
                        break;
                    }
                    Class cls2 = class$org$apache$commons$lang$enums$Enum;
                    if (cls2 == null) {
                        cls2 = class$("org.apache.commons.lang.enums.Enum");
                        class$org$apache$commons$lang$enums$Enum = cls2;
                    }
                    if (cls == cls2) {
                        break;
                    }
                    Class cls3 = class$org$apache$commons$lang$enums$ValuedEnum;
                    if (cls3 == null) {
                        cls3 = class$("org.apache.commons.lang.enums.ValuedEnum");
                        class$org$apache$commons$lang$enums$ValuedEnum = cls3;
                    }
                    if (cls == cls3) {
                        break;
                    } else if (cls == enumClass) {
                        z = true;
                        break;
                    } else {
                        cls = cls.getSuperclass();
                    }
                }
                if (z) {
                    Class cls4 = class$org$apache$commons$lang$enums$Enum;
                    if (cls4 == null) {
                        cls4 = class$("org.apache.commons.lang.enums.Enum");
                        class$org$apache$commons$lang$enums$Enum = cls4;
                    }
                    synchronized (cls4) {
                        entry = (Entry) cEnumClasses.get(enumClass);
                        if (entry == null) {
                            entry = createEntry(enumClass);
                            WeakHashMap weakHashMap = new WeakHashMap();
                            weakHashMap.putAll(cEnumClasses);
                            weakHashMap.put(enumClass, entry);
                            cEnumClasses = weakHashMap;
                        }
                    }
                    if (!entry.map.containsKey(str)) {
                        entry.map.put(str, this);
                        entry.list.add(this);
                        return;
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("The Enum name must be unique, '");
                    stringBuffer.append(str);
                    stringBuffer.append("' has already been added");
                    throw new IllegalArgumentException(stringBuffer.toString());
                }
                throw new IllegalArgumentException("getEnumClass() must return a superclass of this class");
            }
            throw new IllegalArgumentException("getEnumClass() must not be null");
        }
        throw new IllegalArgumentException("The Enum name must not be empty or null");
    }

    public static Iterator iterator(Class cls) {
        return getEnumList(cls).iterator();
    }

    public int compareTo(Object obj) {
        if (obj == this) {
            return 0;
        }
        if (obj.getClass() == getClass()) {
            return this.iName.compareTo(((Enum) obj).iName);
        }
        if (obj.getClass().getName().equals(getClass().getName())) {
            return this.iName.compareTo(getNameInOtherClassLoader(obj));
        }
        StringBuffer outline71 = GeneratedOutlineSupport.outline71("Different enum class '");
        outline71.append(ClassUtils.getShortClassName((Class) obj.getClass()));
        outline71.append("'");
        throw new ClassCastException(outline71.toString());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == getClass()) {
            return this.iName.equals(((Enum) obj).iName);
        }
        if (!obj.getClass().getName().equals(getClass().getName())) {
            return false;
        }
        return this.iName.equals(getNameInOtherClassLoader(obj));
    }

    public Class getEnumClass() {
        return getClass();
    }

    public final String getName() {
        return this.iName;
    }

    public final int hashCode() {
        return this.iHashCode;
    }

    public Object readResolve() {
        Entry entry = (Entry) cEnumClasses.get(getEnumClass());
        if (entry == null) {
            return null;
        }
        return entry.map.get(getName());
    }

    public String toString() {
        if (this.iToString == null) {
            String shortClassName = ClassUtils.getShortClassName(getEnumClass());
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(shortClassName);
            stringBuffer.append("[");
            stringBuffer.append(getName());
            stringBuffer.append(CMapParser.MARK_END_OF_ARRAY);
            this.iToString = stringBuffer.toString();
        }
        return this.iToString;
    }
}
