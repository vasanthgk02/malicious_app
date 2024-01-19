package com.google.android.datatransport.cct.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.List;

public final class AutoValue_BatchedLogRequest extends BatchedLogRequest {
    public final List<LogRequest> logRequests;

    public AutoValue_BatchedLogRequest(List<LogRequest> list) {
        if (list != null) {
            this.logRequests = list;
            return;
        }
        throw new NullPointerException("Null logRequests");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BatchedLogRequest) {
            return this.logRequests.equals(((AutoValue_BatchedLogRequest) ((BatchedLogRequest) obj)).logRequests);
        }
        return false;
    }

    public int hashCode() {
        return this.logRequests.hashCode() ^ 1000003;
    }

    public String toString() {
        return GeneratedOutlineSupport.outline64(GeneratedOutlineSupport.outline73("BatchedLogRequest{logRequests="), this.logRequests, "}");
    }
}
