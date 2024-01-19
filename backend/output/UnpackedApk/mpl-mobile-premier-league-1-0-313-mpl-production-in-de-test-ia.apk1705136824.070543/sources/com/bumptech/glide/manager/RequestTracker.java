package com.bumptech.glide.manager;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.bumptech.glide.request.Request;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public class RequestTracker {
    public boolean isPaused;
    public final List<Request> pendingRequests = new ArrayList();
    public final Set<Request> requests = Collections.newSetFromMap(new WeakHashMap());

    public boolean clearAndRemove(Request request) {
        boolean z = true;
        if (request == null) {
            return true;
        }
        boolean remove = this.requests.remove(request);
        if (!this.pendingRequests.remove(request) && !remove) {
            z = false;
        }
        if (z) {
            request.clear();
        }
        return z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{numRequests=");
        sb.append(this.requests.size());
        sb.append(", isPaused=");
        return GeneratedOutlineSupport.outline66(sb, this.isPaused, "}");
    }
}
