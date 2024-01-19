package kotlin.io;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlin/io/AccessDeniedException;", "Lkotlin/io/FileSystemException;", "file", "Ljava/io/File;", "other", "reason", "", "(Ljava/io/File;Ljava/io/File;Ljava/lang/String;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Exceptions.kt */
public final class AccessDeniedException extends FileSystemException {
    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AccessDeniedException(java.io.File r1, java.io.File r2, java.lang.String r3, int r4) {
        /*
            r0 = this;
            r2 = r4 & 2
            r2 = r4 & 4
            r4 = 0
            if (r2 == 0) goto L_0x0008
            r3 = r4
        L_0x0008:
            java.lang.String r2 = "file"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r0.<init>(r1, r4, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.AccessDeniedException.<init>(java.io.File, java.io.File, java.lang.String, int):void");
    }
}
