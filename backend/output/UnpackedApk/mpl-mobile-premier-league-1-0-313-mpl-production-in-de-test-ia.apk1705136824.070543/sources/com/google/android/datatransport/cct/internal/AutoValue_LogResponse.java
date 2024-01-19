package com.google.android.datatransport.cct.internal;

import com.android.tools.r8.GeneratedOutlineSupport;

public final class AutoValue_LogResponse extends LogResponse {
    public final long nextRequestWaitMillis;

    public AutoValue_LogResponse(long j) {
        this.nextRequestWaitMillis = j;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogResponse)) {
            return false;
        }
        if (this.nextRequestWaitMillis != ((AutoValue_LogResponse) ((LogResponse) obj)).nextRequestWaitMillis) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        long j = this.nextRequestWaitMillis;
        return 1000003 ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return GeneratedOutlineSupport.outline58(GeneratedOutlineSupport.outline73("LogResponse{nextRequestWaitMillis="), this.nextRequestWaitMillis, "}");
    }
}
