package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: InvalidModuleException.kt */
public final class InvalidModuleException extends IllegalStateException {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public InvalidModuleException(String str) {
        // Intrinsics.checkNotNullParameter(str, "message");
        super(str);
    }
}
