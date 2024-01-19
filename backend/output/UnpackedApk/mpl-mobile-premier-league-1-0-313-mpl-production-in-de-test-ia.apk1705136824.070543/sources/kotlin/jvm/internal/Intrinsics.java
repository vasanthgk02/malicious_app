package kotlin.jvm.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;

public class Intrinsics {
    public static boolean areEqual(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static void checkExpressionValueIsNotNull(Object obj, String str) {
        if (obj == null) {
            IllegalStateException illegalStateException = new IllegalStateException(GeneratedOutlineSupport.outline50(str, " must not be null"));
            sanitizeStackTrace(illegalStateException);
            throw illegalStateException;
        }
    }

    public static void checkNotNull(Object obj) {
        if (obj == null) {
            NullPointerException nullPointerException = new NullPointerException();
            sanitizeStackTrace(nullPointerException);
            throw nullPointerException;
        }
    }

    public static void checkNotNullExpressionValue(Object obj, String str) {
        if (obj == null) {
            NullPointerException nullPointerException = new NullPointerException(GeneratedOutlineSupport.outline50(str, " must not be null"));
            sanitizeStackTrace(nullPointerException);
            throw nullPointerException;
        }
    }

    public static void checkNotNullParameter(Object obj, String str) {
        if (obj == null) {
            NullPointerException nullPointerException = new NullPointerException(createParameterIsNullExceptionMessage(str));
            sanitizeStackTrace(nullPointerException);
            throw nullPointerException;
        }
    }

    public static void checkParameterIsNotNull(Object obj, String str) {
        if (obj == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(createParameterIsNullExceptionMessage(str));
            sanitizeStackTrace(illegalArgumentException);
            throw illegalArgumentException;
        }
    }

    public static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static int compare(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i == 0 ? 0 : 1;
    }

    public static String createParameterIsNullExceptionMessage(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        StringBuilder outline82 = GeneratedOutlineSupport.outline82("Parameter specified as non-null is null: method ", stackTraceElement.getClassName(), ".", stackTraceElement.getMethodName(), ", parameter ");
        outline82.append(str);
        return outline82.toString();
    }

    public static void reifiedOperationMarker() {
        throw new UnsupportedOperationException("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static <T extends Throwable> T sanitizeStackTrace(T t) {
        sanitizeStackTrace(t, Intrinsics.class.getName());
        return t;
    }

    public static String stringPlus(String str, Object obj) {
        return GeneratedOutlineSupport.outline48(str, obj);
    }

    public static void throwNpe() {
        KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException();
        sanitizeStackTrace(kotlinNullPointerException);
        throw kotlinNullPointerException;
    }

    public static void throwUninitializedPropertyAccessException(String str) {
        UninitializedPropertyAccessException uninitializedPropertyAccessException = new UninitializedPropertyAccessException(GeneratedOutlineSupport.outline52("lateinit property ", str, " has not been initialized"));
        sanitizeStackTrace(uninitializedPropertyAccessException);
        throw uninitializedPropertyAccessException;
    }

    public static void checkNotNull(Object obj, String str) {
        if (obj == null) {
            NullPointerException nullPointerException = new NullPointerException(str);
            sanitizeStackTrace(nullPointerException);
            throw nullPointerException;
        }
    }

    public static <T extends Throwable> T sanitizeStackTrace(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return t;
    }
}
