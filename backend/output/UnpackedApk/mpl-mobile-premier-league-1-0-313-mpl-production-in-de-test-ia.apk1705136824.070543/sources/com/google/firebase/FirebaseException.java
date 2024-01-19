package com.google.firebase;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public class FirebaseException extends Exception {
    @Deprecated
    public FirebaseException() {
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public FirebaseException(String str) {
        // Preconditions.checkNotEmpty(str, "Detail message must not be empty");
        super(str);
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public FirebaseException(String str, Throwable th) {
        // Preconditions.checkNotEmpty(str, "Detail message must not be empty");
        super(str, th);
    }
}
