package com.google.android.datatransport.runtime.backends;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.datatransport.runtime.backends.BackendResponse.Status;

public final class AutoValue_BackendResponse extends BackendResponse {
    public final long nextRequestWaitMillis;
    public final Status status;

    public AutoValue_BackendResponse(Status status2, long j) {
        if (status2 != null) {
            this.status = status2;
            this.nextRequestWaitMillis = j;
            return;
        }
        throw new NullPointerException("Null status");
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendResponse)) {
            return false;
        }
        AutoValue_BackendResponse autoValue_BackendResponse = (AutoValue_BackendResponse) ((BackendResponse) obj);
        if (!this.status.equals(autoValue_BackendResponse.status) || this.nextRequestWaitMillis != autoValue_BackendResponse.nextRequestWaitMillis) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        long j = this.nextRequestWaitMillis;
        return ((this.status.hashCode() ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("BackendResponse{status=");
        outline73.append(this.status);
        outline73.append(", nextRequestWaitMillis=");
        return GeneratedOutlineSupport.outline58(outline73, this.nextRequestWaitMillis, "}");
    }
}
