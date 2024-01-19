package io.hansel.ujmtracker.m;

import io.hansel.core.network.request.HSLServerRequest;
import io.hansel.core.network.request.HSLServerResponseHandler;
import java.io.InputStream;

public class m implements HSLServerResponseHandler {

    /* renamed from: a  reason: collision with root package name */
    public k f5399a;

    /* renamed from: b  reason: collision with root package name */
    public j f5400b;

    public m(k kVar, j jVar) {
        this.f5399a = kVar;
        this.f5400b = jVar;
    }

    public void parseResponse(HSLServerRequest hSLServerRequest, InputStream inputStream, int i) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parseResponse(io.hansel.core.network.request.HSLServerRequest r2, java.lang.String r3, int r4) {
        /*
            r1 = this;
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r0 = "TrackerResponseHandler:  "
            r2.append(r0)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            io.hansel.core.logger.HSLLogger.d(r2)
            if (r3 == 0) goto L_0x002e
            r2 = 200(0xc8, float:2.8E-43)
            if (r4 < r2) goto L_0x002e
            r2 = 300(0x12c, float:4.2E-43)
            if (r4 >= r2) goto L_0x002e
            io.hansel.core.json.CoreJSONObject r2 = new io.hansel.core.json.CoreJSONObject     // Catch:{ Exception -> 0x002a }
            r2.<init>(r3)     // Catch:{ Exception -> 0x002a }
            java.lang.String r4 = "is_error"
            boolean r2 = r2.getBoolean(r4)     // Catch:{ Exception -> 0x002a }
            goto L_0x002f
        L_0x002a:
            r2 = move-exception
            io.hansel.core.logger.HSLLogger.printStackTrace(r2)
        L_0x002e:
            r2 = 1
        L_0x002f:
            if (r2 == 0) goto L_0x0039
            io.hansel.ujmtracker.m.j r2 = r1.f5400b
            if (r2 == 0) goto L_0x0040
            r2.a()
            goto L_0x0040
        L_0x0039:
            io.hansel.ujmtracker.m.k r2 = r1.f5399a
            if (r2 == 0) goto L_0x0040
            r2.a(r3)
        L_0x0040:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.ujmtracker.m.m.parseResponse(io.hansel.core.network.request.HSLServerRequest, java.lang.String, int):void");
    }
}
