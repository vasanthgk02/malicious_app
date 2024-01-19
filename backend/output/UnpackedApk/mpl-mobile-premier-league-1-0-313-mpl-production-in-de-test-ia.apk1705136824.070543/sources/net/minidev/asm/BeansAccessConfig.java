package net.minidev.asm;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class BeansAccessConfig {
    public static HashMap<Class<?>, HashMap<String, String>> classFiledNameMapper = new HashMap<>();
    public static HashMap<Class<?>, LinkedHashSet<Class<?>>> classMapper = new HashMap<>();

    static {
        Class<Object> cls = Object.class;
        addTypeMapper(cls, DefaultConverter.class);
        addTypeMapper(cls, ConvertDate.class);
    }

    public static void addTypeMapper(Class<?> cls, Class<?> cls2) {
        synchronized (classMapper) {
            LinkedHashSet linkedHashSet = classMapper.get(cls);
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet();
                classMapper.put(cls, linkedHashSet);
            }
            linkedHashSet.add(cls2);
        }
    }
}
