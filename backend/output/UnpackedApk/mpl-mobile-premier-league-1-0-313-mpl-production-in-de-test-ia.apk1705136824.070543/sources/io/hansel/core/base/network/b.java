package io.hansel.core.base.network;

import io.hansel.core.json.CoreJSONException;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public CoreJSONObject f5101a;

    public b(long j, CoreJSONObject coreJSONObject, boolean z, boolean z2) {
        this.f5101a = null;
        this.f5101a = new CoreJSONObject();
        a(z);
        a(j);
        a(coreJSONObject);
    }

    public b(CoreJSONObject coreJSONObject) {
        this.f5101a = null;
        this.f5101a = coreJSONObject;
        if (coreJSONObject == null) {
            this.f5101a = new CoreJSONObject();
        }
    }

    private void a(boolean z) {
        try {
            this.f5101a.put((String) "manual_sync", z);
        } catch (CoreJSONException e2) {
            HSLLogger.printStackTrace(e2, "Some issue with init manual sync", LogGroup.AI);
        }
    }

    public CoreJSONObject a() {
        return this.f5101a;
    }

    public void a(long j) {
        try {
            this.f5101a.put((String) "event_time", j);
        } catch (CoreJSONException e2) {
            HSLLogger.printStackTrace(e2);
        }
    }

    public void a(CoreJSONObject coreJSONObject) {
        try {
            this.f5101a.put((String) "patches_applied", (Object) coreJSONObject);
        } catch (CoreJSONException e2) {
            HSLLogger.printStackTrace(e2);
        }
    }

    public long b() {
        return this.f5101a.optLong("event_time");
    }

    public CoreJSONObject c() {
        return a();
    }

    public String toString() {
        return this.f5101a.toString();
    }
}
