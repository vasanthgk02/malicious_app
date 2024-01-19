package kotlin.reflect.jvm.internal.impl.storage;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.WrappedValues;
import kotlin.reflect.jvm.internal.impl.utils.WrappedValues.ThrowableWrapper;
import kotlin.text.CharsKt__CharKt;

public class LockBasedStorageManager implements StorageManager {
    public static final StorageManager NO_LOCKS = new LockBasedStorageManager("NO_LOCKS", ExceptionHandlingStrategy.THROW, EmptySimpleLock.INSTANCE) {
        public <K, V> RecursionDetectedResult<V> recursionDetectedDefault(String str, K k) {
            return new RecursionDetectedResult<>(null, true);
        }
    };
    public static final String PACKAGE_NAME;
    public final String debugText;
    public final ExceptionHandlingStrategy exceptionHandlingStrategy;
    public final SimpleLock lock;

    public static class CacheWithNotNullValuesBasedOnMemoizedFunction<K, V> extends CacheWithNullableValuesBasedOnMemoizedFunction<K, V> implements CacheWithNotNullValues<K, V> {
        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str = i != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i != 3 ? 3 : 2)];
            if (i == 1) {
                objArr[0] = "map";
            } else if (i == 2) {
                objArr[0] = "computation";
            } else if (i != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            }
            if (i != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            } else {
                objArr[1] = "computeIfAbsent";
            }
            if (i == 2) {
                objArr[2] = "computeIfAbsent";
            } else if (i != 3) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            throw (i != 3 ? new IllegalArgumentException(format) : new IllegalStateException(format));
        }

        public CacheWithNotNullValuesBasedOnMemoizedFunction(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap concurrentMap, AnonymousClass1 r3) {
            super(lockBasedStorageManager, concurrentMap, null);
        }

        public V computeIfAbsent(K k, Function0<? extends V> function0) {
            V invoke = invoke(new KeyWithComputation(k, function0));
            if (invoke != null) {
                return invoke;
            }
            $$$reportNull$$$0(3);
            throw null;
        }
    }

    public static class CacheWithNullableValuesBasedOnMemoizedFunction<K, V> extends MapBasedMemoizedFunction<KeyWithComputation<K, V>, V> implements CacheWithNullableValues<K, V> {
        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "map";
            } else if (i != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computation";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction";
            if (i != 2) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "computeIfAbsent";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public CacheWithNullableValuesBasedOnMemoizedFunction(kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager r1, java.util.concurrent.ConcurrentMap r2, kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.AnonymousClass1 r3) {
            /*
                r0 = this;
                r3 = 0
                if (r1 == 0) goto L_0x0013
                if (r2 == 0) goto L_0x000e
                kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction$1 r3 = new kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction$1
                r3.<init>()
                r0.<init>(r1, r2, r3)
                return
            L_0x000e:
                r1 = 1
                $$$reportNull$$$0(r1)
                throw r3
            L_0x0013:
                r1 = 0
                $$$reportNull$$$0(r1)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.CacheWithNullableValuesBasedOnMemoizedFunction.<init>(kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager, java.util.concurrent.ConcurrentMap, kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager$1):void");
        }
    }

    public interface ExceptionHandlingStrategy {
        public static final ExceptionHandlingStrategy THROW = new ExceptionHandlingStrategy() {
            public RuntimeException handleException(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "e");
                throw th;
            }
        };
    }

    public static class KeyWithComputation<K, V> {
        public final Function0<? extends V> computation;
        public final K key;

        public KeyWithComputation(K k, Function0<? extends V> function0) {
            this.key = k;
            this.computation = function0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && KeyWithComputation.class == obj.getClass() && this.key.equals(((KeyWithComputation) obj).key);
        }

        public int hashCode() {
            return this.key.hashCode();
        }
    }

    public static class LockBasedLazyValue<T> implements NullableLazyValue<T> {
        public final Function0<? extends T> computable;
        public final LockBasedStorageManager storageManager;
        public volatile Object value;

        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str = (i == 2 || i == 3) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[((i == 2 || i == 3) ? 2 : 3)];
            if (i == 1) {
                objArr[0] = "computable";
            } else if (i == 2 || i == 3) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[0] = "storageManager";
            }
            if (i == 2) {
                objArr[1] = "recursionDetected";
            } else if (i != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[1] = "renderDebugInformation";
            }
            if (!(i == 2 || i == 3)) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            throw ((i == 2 || i == 3) ? new IllegalStateException(format) : new IllegalArgumentException(format));
        }

        public LockBasedLazyValue(LockBasedStorageManager lockBasedStorageManager, Function0<? extends T> function0) {
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
                throw null;
            } else if (function0 != null) {
                this.value = NotValue.NOT_COMPUTED;
                this.storageManager = lockBasedStorageManager;
                this.computable = function0;
            } else {
                $$$reportNull$$$0(1);
                throw null;
            }
        }

        public T invoke() {
            T t = this.value;
            if (!(t instanceof NotValue)) {
                WrappedValues.unescapeThrowable(t);
                return t;
            }
            this.storageManager.lock.lock();
            try {
                T t2 = this.value;
                if (!(t2 instanceof NotValue)) {
                    WrappedValues.unescapeThrowable(t2);
                } else {
                    if (t2 == NotValue.COMPUTING) {
                        this.value = NotValue.RECURSION_WAS_DETECTED;
                        RecursionDetectedResult recursionDetected = recursionDetected(true);
                        if (!recursionDetected.fallThrough) {
                            t2 = recursionDetected.value;
                        }
                    }
                    if (t2 == NotValue.RECURSION_WAS_DETECTED) {
                        RecursionDetectedResult recursionDetected2 = recursionDetected(false);
                        if (!recursionDetected2.fallThrough) {
                            t2 = recursionDetected2.value;
                        }
                    }
                    this.value = NotValue.COMPUTING;
                    t2 = this.computable.invoke();
                    postCompute(t2);
                    this.value = t2;
                }
                this.storageManager.lock.unlock();
                return t2;
            } catch (Throwable th) {
                this.storageManager.lock.unlock();
                throw th;
            }
        }

        public void postCompute(T t) {
        }

        public RecursionDetectedResult<T> recursionDetected(boolean z) {
            RecursionDetectedResult<T> recursionDetectedDefault = this.storageManager.recursionDetectedDefault("in a lazy value", null);
            if (recursionDetectedDefault != null) {
                return recursionDetectedDefault;
            }
            $$$reportNull$$$0(2);
            throw null;
        }
    }

    public static abstract class LockBasedLazyValueWithPostCompute<T> extends LockBasedLazyValue<T> {
        public volatile SingleThreadValue<T> valuePostCompute;

        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computable";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValueWithPostCompute";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public LockBasedLazyValueWithPostCompute(kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager r2, kotlin.jvm.functions.Function0<? extends T> r3) {
            /*
                r1 = this;
                r0 = 0
                if (r2 == 0) goto L_0x0010
                if (r3 == 0) goto L_0x000b
                r1.<init>(r2, r3)
                r1.valuePostCompute = r0
                return
            L_0x000b:
                r2 = 1
                $$$reportNull$$$0(r2)
                throw r0
            L_0x0010:
                r2 = 0
                $$$reportNull$$$0(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValueWithPostCompute.<init>(kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager, kotlin.jvm.functions.Function0):void");
        }

        public T invoke() {
            SingleThreadValue<T> singleThreadValue = this.valuePostCompute;
            if (singleThreadValue != null) {
                boolean z = false;
                if (singleThreadValue.thread == Thread.currentThread()) {
                    if (singleThreadValue.thread == Thread.currentThread()) {
                        z = true;
                    }
                    if (z) {
                        return singleThreadValue.value;
                    }
                    throw new IllegalStateException("No value in this thread (hasValue should be checked before)");
                }
            }
            return super.invoke();
        }

        public final void postCompute(T t) {
            this.valuePostCompute = new SingleThreadValue<>(t);
            try {
                AnonymousClass5 r1 = (AnonymousClass5) this;
                if (t != null) {
                    r5.invoke(t);
                } else {
                    AnonymousClass5.$$$reportNull$$$0(2);
                    throw null;
                }
            } finally {
                this.valuePostCompute = null;
            }
        }
    }

    public static class LockBasedNotNullLazyValue<T> extends LockBasedLazyValue<T> implements NotNullLazyValue<T> {
        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str = i != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i != 2 ? 3 : 2)];
            if (i == 1) {
                objArr[0] = "computable";
            } else if (i != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            }
            if (i != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            } else {
                objArr[1] = "invoke";
            }
            if (i != 2) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            throw (i != 2 ? new IllegalArgumentException(format) : new IllegalStateException(format));
        }

        /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public LockBasedNotNullLazyValue(kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager r2, kotlin.jvm.functions.Function0<? extends T> r3) {
            /*
                r1 = this;
                r0 = 0
                if (r2 == 0) goto L_0x000e
                if (r3 == 0) goto L_0x0009
                r1.<init>(r2, r3)
                return
            L_0x0009:
                r2 = 1
                $$$reportNull$$$0(r2)
                throw r0
            L_0x000e:
                r2 = 0
                $$$reportNull$$$0(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedNotNullLazyValue.<init>(kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager, kotlin.jvm.functions.Function0):void");
        }

        public T invoke() {
            T invoke = super.invoke();
            if (invoke != null) {
                return invoke;
            }
            $$$reportNull$$$0(2);
            throw null;
        }
    }

    public static abstract class LockBasedNotNullLazyValueWithPostCompute<T> extends LockBasedLazyValueWithPostCompute<T> implements NotNullLazyValue<T> {
        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str = i != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i != 2 ? 3 : 2)];
            if (i == 1) {
                objArr[0] = "computable";
            } else if (i != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            }
            if (i != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            } else {
                objArr[1] = "invoke";
            }
            if (i != 2) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            throw (i != 2 ? new IllegalArgumentException(format) : new IllegalStateException(format));
        }

        /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public LockBasedNotNullLazyValueWithPostCompute(kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager r2, kotlin.jvm.functions.Function0<? extends T> r3) {
            /*
                r1 = this;
                r0 = 0
                if (r2 == 0) goto L_0x000e
                if (r3 == 0) goto L_0x0009
                r1.<init>(r2, r3)
                return
            L_0x0009:
                r2 = 1
                $$$reportNull$$$0(r2)
                throw r0
            L_0x000e:
                r2 = 0
                $$$reportNull$$$0(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedNotNullLazyValueWithPostCompute.<init>(kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager, kotlin.jvm.functions.Function0):void");
        }

        public T invoke() {
            T invoke = super.invoke();
            if (invoke != null) {
                return invoke;
            }
            $$$reportNull$$$0(2);
            throw null;
        }
    }

    public static class MapBasedMemoizedFunction<K, V> implements MemoizedFunctionToNullable<K, V> {
        public final ConcurrentMap<K, Object> cache;
        public final Function1<? super K, ? extends V> compute;
        public final LockBasedStorageManager storageManager;

        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str = (i == 3 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[((i == 3 || i == 4) ? 2 : 3)];
            if (i == 1) {
                objArr[0] = "map";
            } else if (i == 2) {
                objArr[0] = "compute";
            } else if (i == 3 || i == 4) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[0] = "storageManager";
            }
            if (i == 3) {
                objArr[1] = "recursionDetected";
            } else if (i != 4) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[1] = "raceCondition";
            }
            if (!(i == 3 || i == 4)) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            throw ((i == 3 || i == 4) ? new IllegalStateException(format) : new IllegalArgumentException(format));
        }

        public MapBasedMemoizedFunction(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap<K, Object> concurrentMap, Function1<? super K, ? extends V> function1) {
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
                throw null;
            } else if (concurrentMap == null) {
                $$$reportNull$$$0(1);
                throw null;
            } else if (function1 != null) {
                this.storageManager = lockBasedStorageManager;
                this.cache = concurrentMap;
                this.compute = function1;
            } else {
                $$$reportNull$$$0(2);
                throw null;
            }
        }

        public V invoke(K k) {
            Object obj;
            Throwable th;
            Throwable th2;
            Object obj2 = this.cache.get(k);
            if (obj2 != null && obj2 != NotValue.COMPUTING) {
                return WrappedValues.unescapeExceptionOrNull(obj2);
            }
            this.storageManager.lock.lock();
            Object obj3 = this.cache.get(k);
            if (obj3 == NotValue.COMPUTING) {
                obj3 = NotValue.RECURSION_WAS_DETECTED;
                RecursionDetectedResult recursionDetectedDefault = this.storageManager.recursionDetectedDefault("", k);
                if (recursionDetectedDefault == null) {
                    $$$reportNull$$$0(3);
                    throw null;
                } else if (!recursionDetectedDefault.fallThrough) {
                    obj = recursionDetectedDefault.value;
                    this.storageManager.lock.unlock();
                    return obj;
                }
            }
            try {
                if (obj3 == NotValue.RECURSION_WAS_DETECTED) {
                    RecursionDetectedResult recursionDetectedDefault2 = this.storageManager.recursionDetectedDefault("", k);
                    if (recursionDetectedDefault2 == null) {
                        $$$reportNull$$$0(3);
                        throw null;
                    } else if (!recursionDetectedDefault2.fallThrough) {
                        obj = recursionDetectedDefault2.value;
                        this.storageManager.lock.unlock();
                        return obj;
                    }
                }
                if (obj3 != null) {
                    obj = WrappedValues.unescapeExceptionOrNull(obj3);
                    this.storageManager.lock.unlock();
                    return obj;
                }
                try {
                    this.cache.put(k, NotValue.COMPUTING);
                    V invoke = this.compute.invoke(k);
                    Object put = this.cache.put(k, invoke == null ? WrappedValues.NULL_VALUE : invoke);
                    if (put == NotValue.COMPUTING) {
                        return invoke;
                    }
                    th2 = raceCondition(k, put);
                    try {
                        throw th2;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    th2 = null;
                    if (TypeUtilsKt.isProcessCanceledException(th)) {
                        this.cache.remove(k);
                        throw ((RuntimeException) th);
                    } else if (th != th2) {
                        Object put2 = this.cache.put(k, new ThrowableWrapper(th, null));
                        if (put2 != NotValue.COMPUTING) {
                            throw raceCondition(k, put2);
                        }
                        ((AnonymousClass1) this.storageManager.exceptionHandlingStrategy).handleException(th);
                        throw null;
                    } else {
                        ((AnonymousClass1) this.storageManager.exceptionHandlingStrategy).handleException(th);
                        throw null;
                    }
                }
            } finally {
                this.storageManager.lock.unlock();
            }
        }

        public final AssertionError raceCondition(K k, Object obj) {
            AssertionError assertionError = new AssertionError("Race condition detected on input " + k + ". Old value is " + obj + " under " + this.storageManager);
            LockBasedStorageManager.sanitizeStackTrace(assertionError);
            return assertionError;
        }
    }

    public static class MapBasedMemoizedFunctionToNotNull<K, V> extends MapBasedMemoizedFunction<K, V> implements MemoizedFunctionToNotNull<K, V> {
        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str = i != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i != 3 ? 3 : 2)];
            if (i == 1) {
                objArr[0] = "map";
            } else if (i == 2) {
                objArr[0] = "compute";
            } else if (i != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            }
            if (i != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            } else {
                objArr[1] = "invoke";
            }
            if (i != 3) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            throw (i != 3 ? new IllegalArgumentException(format) : new IllegalStateException(format));
        }

        /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public MapBasedMemoizedFunctionToNotNull(kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager r2, java.util.concurrent.ConcurrentMap<K, java.lang.Object> r3, kotlin.jvm.functions.Function1<? super K, ? extends V> r4) {
            /*
                r1 = this;
                r0 = 0
                if (r3 == 0) goto L_0x000e
                if (r4 == 0) goto L_0x0009
                r1.<init>(r2, r3, r4)
                return
            L_0x0009:
                r2 = 2
                $$$reportNull$$$0(r2)
                throw r0
            L_0x000e:
                r2 = 1
                $$$reportNull$$$0(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.MapBasedMemoizedFunctionToNotNull.<init>(kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager, java.util.concurrent.ConcurrentMap, kotlin.jvm.functions.Function1):void");
        }

        public V invoke(K k) {
            V invoke = super.invoke(k);
            if (invoke != null) {
                return invoke;
            }
            $$$reportNull$$$0(3);
            throw null;
        }
    }

    public enum NotValue {
        NOT_COMPUTED,
        COMPUTING,
        RECURSION_WAS_DETECTED
    }

    public static class RecursionDetectedResult<T> {
        public final boolean fallThrough;
        public final T value;

        public RecursionDetectedResult(T t, boolean z) {
            this.value = t;
            this.fallThrough = z;
        }

        public String toString() {
            if (this.fallThrough) {
                return "FALL_THROUGH";
            }
            return String.valueOf(this.value);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void $$$reportNull$$$0(int r13) {
        /*
            r0 = 37
            r1 = 20
            r2 = 13
            r3 = 10
            if (r13 == r3) goto L_0x0013
            if (r13 == r2) goto L_0x0013
            if (r13 == r1) goto L_0x0013
            if (r13 == r0) goto L_0x0013
            java.lang.String r4 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            goto L_0x0015
        L_0x0013:
            java.lang.String r4 = "@NotNull method %s.%s must not return null"
        L_0x0015:
            r5 = 3
            r6 = 2
            if (r13 == r3) goto L_0x0021
            if (r13 == r2) goto L_0x0021
            if (r13 == r1) goto L_0x0021
            if (r13 == r0) goto L_0x0021
            r7 = 3
            goto L_0x0022
        L_0x0021:
            r7 = 2
        L_0x0022:
            java.lang.Object[] r7 = new java.lang.Object[r7]
            java.lang.String r8 = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager"
            java.lang.String r9 = "compute"
            r10 = 1
            r11 = 0
            if (r13 == r10) goto L_0x0067
            if (r13 == r5) goto L_0x0067
            r5 = 5
            if (r13 == r5) goto L_0x0067
            r5 = 6
            if (r13 == r5) goto L_0x0062
            switch(r13) {
                case 8: goto L_0x0067;
                case 9: goto L_0x005f;
                case 10: goto L_0x005c;
                case 11: goto L_0x005f;
                case 12: goto L_0x0057;
                case 13: goto L_0x005c;
                case 14: goto L_0x005f;
                case 15: goto L_0x0052;
                case 16: goto L_0x005f;
                case 17: goto L_0x0057;
                case 18: goto L_0x0052;
                case 19: goto L_0x005f;
                case 20: goto L_0x005c;
                case 21: goto L_0x005f;
                case 22: goto L_0x0052;
                case 23: goto L_0x004d;
                case 24: goto L_0x004d;
                case 25: goto L_0x0057;
                case 26: goto L_0x004d;
                case 27: goto L_0x0057;
                case 28: goto L_0x004d;
                case 29: goto L_0x0048;
                case 30: goto L_0x004d;
                case 31: goto L_0x004d;
                case 32: goto L_0x004d;
                case 33: goto L_0x0048;
                case 34: goto L_0x004d;
                case 35: goto L_0x0042;
                case 36: goto L_0x003c;
                case 37: goto L_0x005c;
                default: goto L_0x0037;
            }
        L_0x0037:
            java.lang.String r5 = "debugText"
            r7[r11] = r5
            goto L_0x006b
        L_0x003c:
            java.lang.String r5 = "throwable"
            r7[r11] = r5
            goto L_0x006b
        L_0x0042:
            java.lang.String r5 = "source"
            r7[r11] = r5
            goto L_0x006b
        L_0x0048:
            java.lang.String r5 = "postCompute"
            r7[r11] = r5
            goto L_0x006b
        L_0x004d:
            java.lang.String r5 = "computable"
            r7[r11] = r5
            goto L_0x006b
        L_0x0052:
            java.lang.String r5 = "map"
            r7[r11] = r5
            goto L_0x006b
        L_0x0057:
            java.lang.String r5 = "onRecursiveCall"
            r7[r11] = r5
            goto L_0x006b
        L_0x005c:
            r7[r11] = r8
            goto L_0x006b
        L_0x005f:
            r7[r11] = r9
            goto L_0x006b
        L_0x0062:
            java.lang.String r5 = "lock"
            r7[r11] = r5
            goto L_0x006b
        L_0x0067:
            java.lang.String r5 = "exceptionHandlingStrategy"
            r7[r11] = r5
        L_0x006b:
            java.lang.String r5 = "sanitizeStackTrace"
            java.lang.String r11 = "createMemoizedFunctionWithNullableValues"
            java.lang.String r12 = "createMemoizedFunction"
            if (r13 == r3) goto L_0x0082
            if (r13 == r2) goto L_0x0082
            if (r13 == r1) goto L_0x007f
            if (r13 == r0) goto L_0x007c
            r7[r10] = r8
            goto L_0x0084
        L_0x007c:
            r7[r10] = r5
            goto L_0x0084
        L_0x007f:
            r7[r10] = r11
            goto L_0x0084
        L_0x0082:
            r7[r10] = r12
        L_0x0084:
            switch(r13) {
                case 4: goto L_0x00c0;
                case 5: goto L_0x00c0;
                case 6: goto L_0x00c0;
                case 7: goto L_0x00bb;
                case 8: goto L_0x00bb;
                case 9: goto L_0x00b8;
                case 10: goto L_0x00c4;
                case 11: goto L_0x00b8;
                case 12: goto L_0x00b8;
                case 13: goto L_0x00c4;
                case 14: goto L_0x00b8;
                case 15: goto L_0x00b8;
                case 16: goto L_0x00b8;
                case 17: goto L_0x00b8;
                case 18: goto L_0x00b8;
                case 19: goto L_0x00b5;
                case 20: goto L_0x00c4;
                case 21: goto L_0x00b5;
                case 22: goto L_0x00b5;
                case 23: goto L_0x00b0;
                case 24: goto L_0x00b0;
                case 25: goto L_0x00b0;
                case 26: goto L_0x00ab;
                case 27: goto L_0x00ab;
                case 28: goto L_0x00a6;
                case 29: goto L_0x00a6;
                case 30: goto L_0x00a1;
                case 31: goto L_0x009c;
                case 32: goto L_0x0097;
                case 33: goto L_0x0097;
                case 34: goto L_0x0094;
                case 35: goto L_0x008f;
                case 36: goto L_0x008c;
                case 37: goto L_0x00c4;
                default: goto L_0x0087;
            }
        L_0x0087:
            java.lang.String r5 = "createWithExceptionHandling"
            r7[r6] = r5
            goto L_0x00c4
        L_0x008c:
            r7[r6] = r5
            goto L_0x00c4
        L_0x008f:
            java.lang.String r5 = "recursionDetectedDefault"
            r7[r6] = r5
            goto L_0x00c4
        L_0x0094:
            r7[r6] = r9
            goto L_0x00c4
        L_0x0097:
            java.lang.String r5 = "createNullableLazyValueWithPostCompute"
            r7[r6] = r5
            goto L_0x00c4
        L_0x009c:
            java.lang.String r5 = "createRecursionTolerantNullableLazyValue"
            r7[r6] = r5
            goto L_0x00c4
        L_0x00a1:
            java.lang.String r5 = "createNullableLazyValue"
            r7[r6] = r5
            goto L_0x00c4
        L_0x00a6:
            java.lang.String r5 = "createLazyValueWithPostCompute"
            r7[r6] = r5
            goto L_0x00c4
        L_0x00ab:
            java.lang.String r5 = "createRecursionTolerantLazyValue"
            r7[r6] = r5
            goto L_0x00c4
        L_0x00b0:
            java.lang.String r5 = "createLazyValue"
            r7[r6] = r5
            goto L_0x00c4
        L_0x00b5:
            r7[r6] = r11
            goto L_0x00c4
        L_0x00b8:
            r7[r6] = r12
            goto L_0x00c4
        L_0x00bb:
            java.lang.String r5 = "replaceExceptionHandling"
            r7[r6] = r5
            goto L_0x00c4
        L_0x00c0:
            java.lang.String r5 = "<init>"
            r7[r6] = r5
        L_0x00c4:
            java.lang.String r4 = java.lang.String.format(r4, r7)
            if (r13 == r3) goto L_0x00d6
            if (r13 == r2) goto L_0x00d6
            if (r13 == r1) goto L_0x00d6
            if (r13 == r0) goto L_0x00d6
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            r13.<init>(r4)
            goto L_0x00db
        L_0x00d6:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            r13.<init>(r4)
        L_0x00db:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.$$$reportNull$$$0(int):void");
    }

    static {
        String canonicalName = LockBasedStorageManager.class.getCanonicalName();
        String str = "";
        Intrinsics.checkNotNullParameter(canonicalName, "<this>");
        Intrinsics.checkNotNullParameter(".", "delimiter");
        Intrinsics.checkNotNullParameter(str, "missingDelimiterValue");
        int lastIndexOf$default = CharsKt__CharKt.lastIndexOf$default((CharSequence) canonicalName, (String) ".", 0, false, 6);
        if (lastIndexOf$default != -1) {
            str = canonicalName.substring(0, lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        PACKAGE_NAME = str;
    }

    public LockBasedStorageManager(String str, ExceptionHandlingStrategy exceptionHandlingStrategy2, SimpleLock simpleLock) {
        if (str == null) {
            $$$reportNull$$$0(4);
            throw null;
        } else if (exceptionHandlingStrategy2 == null) {
            $$$reportNull$$$0(5);
            throw null;
        } else if (simpleLock != null) {
            this.lock = simpleLock;
            this.exceptionHandlingStrategy = exceptionHandlingStrategy2;
            this.debugText = str;
        } else {
            $$$reportNull$$$0(6);
            throw null;
        }
    }

    public static <K> ConcurrentMap<K, Object> createConcurrentHashMap() {
        return new ConcurrentHashMap(3, 1.0f, 2);
    }

    public static <T extends Throwable> T sanitizeStackTrace(T t) {
        if (t != null) {
            StackTraceElement[] stackTrace = t.getStackTrace();
            int length = stackTrace.length;
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (!stackTrace[i2].getClassName().startsWith(PACKAGE_NAME)) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
            List subList = Arrays.asList(stackTrace).subList(i, length);
            t.setStackTrace((StackTraceElement[]) subList.toArray(new StackTraceElement[subList.size()]));
            return t;
        }
        $$$reportNull$$$0(36);
        throw null;
    }

    public <T> T compute(Function0<? extends T> function0) {
        this.lock.lock();
        try {
            T invoke = function0.invoke();
            this.lock.unlock();
            return invoke;
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    public <K, V> CacheWithNotNullValues<K, V> createCacheWithNotNullValues() {
        return new CacheWithNotNullValuesBasedOnMemoizedFunction(this, createConcurrentHashMap(), null);
    }

    public <K, V> CacheWithNullableValues<K, V> createCacheWithNullableValues() {
        return new CacheWithNullableValuesBasedOnMemoizedFunction(this, createConcurrentHashMap(), null);
    }

    public <T> NotNullLazyValue<T> createLazyValue(Function0<? extends T> function0) {
        if (function0 != null) {
            return new LockBasedNotNullLazyValue(this, function0);
        }
        $$$reportNull$$$0(23);
        throw null;
    }

    public <T> NotNullLazyValue<T> createLazyValueWithPostCompute(Function0<? extends T> function0, Function1<? super Boolean, ? extends T> function1, Function1<? super T, Unit> function12) {
        final Function1<? super Boolean, ? extends T> function13 = function1;
        final Function1<? super T, Unit> function14 = function12;
        AnonymousClass5 r0 = new LockBasedNotNullLazyValueWithPostCompute<T>(this, this, function0) {
            public static /* synthetic */ void $$$reportNull$$$0(int i) {
                String str = i != 2 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                Object[] objArr = new Object[(i != 2 ? 2 : 3)];
                if (i != 2) {
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
                } else {
                    objArr[0] = HSLCriteriaBuilder.VALUE;
                }
                if (i != 2) {
                    objArr[1] = "recursionDetected";
                } else {
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
                }
                if (i == 2) {
                    objArr[2] = "doPostCompute";
                }
                String format = String.format(str, objArr);
                throw (i != 2 ? new IllegalStateException(format) : new IllegalArgumentException(format));
            }

            public RecursionDetectedResult<T> recursionDetected(boolean z) {
                Function1 function1 = function13;
                if (function1 != null) {
                    return new RecursionDetectedResult<>(function1.invoke(Boolean.valueOf(z)), false);
                }
                RecursionDetectedResult<T> recursionDetected = super.recursionDetected(z);
                if (recursionDetected != null) {
                    return recursionDetected;
                }
                $$$reportNull$$$0(0);
                throw null;
            }
        };
        return r0;
    }

    public <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(Function1<? super K, ? extends V> function1) {
        return new MapBasedMemoizedFunctionToNotNull(this, createConcurrentHashMap(), function1);
    }

    public <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(Function1<? super K, ? extends V> function1) {
        return new MapBasedMemoizedFunction(this, createConcurrentHashMap(), function1);
    }

    public <T> NullableLazyValue<T> createNullableLazyValue(Function0<? extends T> function0) {
        return new LockBasedLazyValue(this, function0);
    }

    public <T> NotNullLazyValue<T> createRecursionTolerantLazyValue(Function0<? extends T> function0, final T t) {
        return new LockBasedNotNullLazyValue<T>(this, this, function0) {
            public RecursionDetectedResult<T> recursionDetected(boolean z) {
                return new RecursionDetectedResult<>(t, false);
            }
        };
    }

    public <K, V> RecursionDetectedResult<V> recursionDetectedDefault(String str, K k) {
        StringBuilder outline78 = GeneratedOutlineSupport.outline78("Recursion detected ", str);
        outline78.append(k == null ? "" : GeneratedOutlineSupport.outline48("on input: ", k));
        outline78.append(" under ");
        outline78.append(this);
        AssertionError assertionError = new AssertionError(outline78.toString());
        sanitizeStackTrace(assertionError);
        throw assertionError;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(ColorPropConverter.PREFIX_RESOURCE);
        sb.append(Integer.toHexString(hashCode()));
        sb.append(" (");
        return GeneratedOutlineSupport.outline62(sb, this.debugText, ")");
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LockBasedStorageManager(java.lang.String r5) {
        /*
            r4 = this;
            kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager$ExceptionHandlingStrategy r0 = kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.ExceptionHandlingStrategy.THROW
            kotlin.reflect.jvm.internal.impl.storage.SimpleLock$Companion r1 = kotlin.reflect.jvm.internal.impl.storage.SimpleLock.Companion
            kotlin.reflect.jvm.internal.impl.storage.DefaultSimpleLock r1 = new kotlin.reflect.jvm.internal.impl.storage.DefaultSimpleLock
            r2 = 0
            r3 = 1
            r1.<init>(r2, r3)
            r4.<init>(r5, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.<init>(java.lang.String):void");
    }
}
