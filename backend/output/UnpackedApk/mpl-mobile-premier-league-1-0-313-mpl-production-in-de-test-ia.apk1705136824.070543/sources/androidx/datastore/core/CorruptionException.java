package androidx.datastore.core;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/datastore/core/CorruptionException;", "Ljava/io/IOException;", "message", "", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Serializer.kt */
public final class CorruptionException extends IOException {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public CorruptionException(String str, Throwable th, int i) {
        // int i2 = i & 2;
        // Intrinsics.checkNotNullParameter(str, "message");
        super(str, null);
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public CorruptionException(String str, Throwable th) {
        // Intrinsics.checkNotNullParameter(str, "message");
        super(str, th);
    }
}
