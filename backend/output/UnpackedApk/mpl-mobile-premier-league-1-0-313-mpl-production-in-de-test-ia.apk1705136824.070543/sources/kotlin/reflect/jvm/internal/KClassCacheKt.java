package kotlin.reflect.jvm.internal;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.pcollections.ConsPStack;
import kotlin.reflect.jvm.internal.pcollections.HashPMap;
import kotlin.reflect.jvm.internal.pcollections.MapEntry;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0000\u001a&\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\b\b\u0000\u0010\t*\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000bH\u0000\"*\u0010\u0000\u001a\u001e\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00040\u00040\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"K_CLASS_CACHE", "Lkotlin/reflect/jvm/internal/pcollections/HashPMap;", "", "kotlin.jvm.PlatformType", "", "clearKClassCache", "", "getOrCreateKotlinClass", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "jClass", "Ljava/lang/Class;", "kotlin-reflection"}, k = 2, mv = {1, 4, 1})
/* compiled from: kClassCache.kt */
public final class KClassCacheKt {
    public static HashPMap<String, Object> K_CLASS_CACHE;

    static {
        HashPMap<Object, Object> hashPMap = HashPMap.EMPTY;
        if (hashPMap != null) {
            Intrinsics.checkNotNullExpressionValue(hashPMap, "HashPMap.empty<String, Any>()");
            K_CLASS_CACHE = hashPMap;
            return;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/pcollections/HashPMap", "empty"}));
    }

    public static final <T> KClassImpl<T> getOrCreateKotlinClass(Class<T> cls) {
        Object obj;
        Intrinsics.checkNotNullParameter(cls, "jClass");
        String name = cls.getName();
        HashPMap<String, Object> hashPMap = K_CLASS_CACHE;
        Class<T> cls2 = null;
        if (hashPMap != null) {
            ConsPStack consPStack = (ConsPStack) hashPMap.intMap.root.get((long) name.hashCode());
            if (consPStack == null) {
                consPStack = ConsPStack.EMPTY;
            }
            while (true) {
                if (consPStack == null || consPStack.size <= 0) {
                    obj = null;
                } else {
                    MapEntry mapEntry = (MapEntry) consPStack.first;
                    if (mapEntry.key.equals(name)) {
                        obj = mapEntry.value;
                        break;
                    }
                    consPStack = consPStack.rest;
                }
            }
            obj = null;
            if (obj instanceof WeakReference) {
                KClassImpl<T> kClassImpl = (KClassImpl) ((WeakReference) obj).get();
                if (kClassImpl != null) {
                    cls2 = kClassImpl.jClass;
                }
                if (Intrinsics.areEqual(cls2, cls)) {
                    return kClassImpl;
                }
            } else if (obj != null) {
                for (WeakReference weakReference : (WeakReference[]) obj) {
                    KClassImpl<T> kClassImpl2 = (KClassImpl) weakReference.get();
                    if (Intrinsics.areEqual(kClassImpl2 != null ? kClassImpl2.jClass : null, cls)) {
                        return kClassImpl2;
                    }
                }
                int length = ((Object[]) obj).length;
                WeakReference[] weakReferenceArr = new WeakReference[(length + 1)];
                System.arraycopy(obj, 0, weakReferenceArr, 0, length);
                KClassImpl<T> kClassImpl3 = new KClassImpl<>(cls);
                weakReferenceArr[length] = new WeakReference(kClassImpl3);
                HashPMap<String, Object> plus = K_CLASS_CACHE.plus(name, weakReferenceArr);
                Intrinsics.checkNotNullExpressionValue(plus, "K_CLASS_CACHE.plus(name, newArray)");
                K_CLASS_CACHE = plus;
                return kClassImpl3;
            }
            KClassImpl<T> kClassImpl4 = new KClassImpl<>(cls);
            HashPMap<String, Object> plus2 = K_CLASS_CACHE.plus(name, new WeakReference(kClassImpl4));
            Intrinsics.checkNotNullExpressionValue(plus2, "K_CLASS_CACHE.plus(name, WeakReference(newKClass))");
            K_CLASS_CACHE = plus2;
            return kClassImpl4;
        }
        throw null;
    }
}
