package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* compiled from: NameUtils.kt */
public final class NameUtils {
    public static final Regex SANITIZE_AS_JAVA_INVALID_CHARACTERS = new Regex((String) "[^\\p{L}\\p{Digit}]");

    public static final String sanitizeAsJavaIdentifier(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return SANITIZE_AS_JAVA_INVALID_CHARACTERS.replace(str, "_");
    }
}
