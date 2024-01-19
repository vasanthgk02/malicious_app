package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: FakePureImplementationsProvider.kt */
public final class FakePureImplementationsProvider {
    public static final FakePureImplementationsProvider INSTANCE = null;
    public static final HashMap<FqName, FqName> pureImplementations = new HashMap<>();

    static {
        implementedWith(FqNames.mutableList, fqNameListOf("java.util.ArrayList", "java.util.LinkedList"));
        implementedWith(FqNames.mutableSet, fqNameListOf("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        implementedWith(FqNames.mutableMap, fqNameListOf("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        implementedWith(new FqName((String) "java.util.function.Function"), fqNameListOf("java.util.function.UnaryOperator"));
        implementedWith(new FqName((String) "java.util.function.BiFunction"), fqNameListOf("java.util.function.BinaryOperator"));
    }

    public static final List<FqName> fqNameListOf(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String fqName : strArr) {
            arrayList.add(new FqName(fqName));
        }
        return arrayList;
    }

    public static final void implementedWith(FqName fqName, List<FqName> list) {
        HashMap<FqName, FqName> hashMap = pureImplementations;
        for (T next : list) {
            FqName fqName2 = (FqName) next;
            hashMap.put(next, fqName);
        }
    }
}
