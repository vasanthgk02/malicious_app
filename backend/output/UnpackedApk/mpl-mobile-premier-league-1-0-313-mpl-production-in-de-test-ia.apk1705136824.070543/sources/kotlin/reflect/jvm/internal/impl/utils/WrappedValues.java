package kotlin.reflect.jvm.internal.impl.utils;

import io.hansel.core.criteria.HSLCriteriaBuilder;
import kotlin.jvm.internal.Intrinsics;

public class WrappedValues {
    public static final Object NULL_VALUE = new Object() {
        public String toString() {
            return "NULL_VALUE";
        }
    };

    public static final class ThrowableWrapper {
        public final Throwable throwable;

        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str = i != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i != 1 ? 3 : 2)];
            if (i != 1) {
                objArr[0] = "throwable";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
            }
            if (i != 1) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
            } else {
                objArr[1] = "getThrowable";
            }
            if (i != 1) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            throw (i != 1 ? new IllegalArgumentException(format) : new IllegalStateException(format));
        }

        public ThrowableWrapper(Throwable th, AnonymousClass1 r2) {
            if (th != null) {
                this.throwable = th;
            } else {
                $$$reportNull$$$0(0);
                throw null;
            }
        }

        public String toString() {
            return this.throwable.toString();
        }
    }

    public static class WrappedProcessCanceledException extends RuntimeException {
    }

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str = (i == 1 || i == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 1 || i == 2) ? 2 : 3)];
        if (i == 1 || i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
        } else if (i != 3) {
            objArr[0] = HSLCriteriaBuilder.VALUE;
        } else {
            objArr[0] = "throwable";
        }
        if (i == 1 || i == 2) {
            objArr[1] = "escapeNull";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
        }
        if (!(i == 1 || i == 2)) {
            if (i == 3) {
                objArr[2] = "escapeThrowable";
            } else if (i != 4) {
                objArr[2] = "unescapeNull";
            } else {
                objArr[2] = "unescapeExceptionOrNull";
            }
        }
        String format = String.format(str, objArr);
        throw ((i == 1 || i == 2) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    public static <V> V unescapeExceptionOrNull(Object obj) {
        if (obj != null) {
            unescapeThrowable(obj);
            if (obj == null) {
                $$$reportNull$$$0(0);
                throw null;
            } else if (obj == NULL_VALUE) {
                return null;
            } else {
                return obj;
            }
        } else {
            $$$reportNull$$$0(4);
            throw null;
        }
    }

    public static <V> V unescapeThrowable(Object obj) {
        if (!(obj instanceof ThrowableWrapper)) {
            return obj;
        }
        Throwable th = ((ThrowableWrapper) obj).throwable;
        if (th != null) {
            Intrinsics.checkNotNullParameter(th, "e");
            throw th;
        }
        ThrowableWrapper.$$$reportNull$$$0(1);
        throw null;
    }
}
