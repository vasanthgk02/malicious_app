package io.hansel.core.base.network;

import android.content.Context;
import io.hansel.core.module.IMessageBroker;
import io.hansel.core.network.request.HSLServerRequest;
import io.hansel.core.network.request.HSLServerResponseHandler;
import java.io.InputStream;

public class e implements HSLServerResponseHandler {

    /* renamed from: a  reason: collision with root package name */
    public Context f5105a;

    /* renamed from: b  reason: collision with root package name */
    public IMessageBroker f5106b;

    public e(Context context, IMessageBroker iMessageBroker) {
        this.f5105a = context;
        this.f5106b = iMessageBroker;
    }

    public void parseResponse(HSLServerRequest hSLServerRequest, InputStream inputStream, int i) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e8, code lost:
        if (r8 != false) goto L_0x00ea;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008f A[Catch:{ Exception -> 0x00e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parseResponse(io.hansel.core.network.request.HSLServerRequest r8, java.lang.String r9, int r10) {
        /*
            r7 = this;
            java.lang.String r8 = "TgAuthResponseHandler:  "
            java.lang.String r8 = com.android.tools.r8.GeneratedOutlineSupport.outline41(r8, r10)
            io.hansel.core.logger.LogGroup r0 = io.hansel.core.logger.LogGroup.TG
            io.hansel.core.logger.HSLLogger.d(r8, r0)
            android.content.Context r8 = r7.f5105a
            boolean r8 = io.hansel.core.base.utils.HSLInternalUtils.isTGStatusKnown(r8)
            android.content.Context r1 = r7.f5105a
            boolean r1 = io.hansel.core.base.utils.HSLInternalUtils.isInTestGroup(r1)
            r2 = 0
            java.lang.String r3 = "Failed to add Test Device"
            r4 = 0
            if (r9 == 0) goto L_0x00e8
            r5 = 512(0x200, float:7.17E-43)
            r6 = 1
            if (r10 != r5) goto L_0x0027
            java.lang.String r3 = "The Auth Key has expired, please get the new URL from the Hansel dashboard"
            r9 = 0
            goto L_0x0085
        L_0x0027:
            r5 = 513(0x201, float:7.19E-43)
            if (r10 != r5) goto L_0x002f
            java.lang.String r3 = "This device has been previously added as a Test Device"
            r9 = 1
            goto L_0x0085
        L_0x002f:
            r5 = 514(0x202, float:7.2E-43)
            if (r10 != r5) goto L_0x003d
            java.lang.String r9 = "Failed to add the test device"
            io.hansel.core.logger.HSLLogger.w(r9, r0)     // Catch:{ Exception -> 0x003a }
            r9 = r1
            goto L_0x0084
        L_0x003a:
            r8 = move-exception
            goto L_0x00e4
        L_0x003d:
            r0 = 200(0xc8, float:2.8E-43)
            if (r10 < r0) goto L_0x0087
            r0 = 299(0x12b, float:4.19E-43)
            if (r10 <= r0) goto L_0x0046
            goto L_0x0087
        L_0x0046:
            io.hansel.core.json.CoreJSONObject r10 = new io.hansel.core.json.CoreJSONObject     // Catch:{ Exception -> 0x003a }
            r10.<init>(r9)     // Catch:{ Exception -> 0x003a }
            java.lang.String r9 = "is_error"
            boolean r9 = r10.getBoolean(r9)     // Catch:{ Exception -> 0x003a }
            if (r9 == 0) goto L_0x0055
            r9 = r1
            goto L_0x0085
        L_0x0055:
            java.lang.String r9 = "api_response"
            io.hansel.core.json.CoreJSONObject r9 = r10.optJSONObject(r9)     // Catch:{ Exception -> 0x003a }
            java.lang.String r10 = "tg"
            boolean r9 = r9.optBoolean(r10, r4)     // Catch:{ Exception -> 0x003a }
            if (r9 == 0) goto L_0x0069
            if (r9 == r1) goto L_0x0069
            java.lang.String r3 = "Your device has been successfully added as a Test Device"
            goto L_0x0085
        L_0x0069:
            if (r1 == 0) goto L_0x0070
            if (r9 == r1) goto L_0x0070
            java.lang.String r3 = "Your device has been successfully removed from the Test Devices list"
            goto L_0x0085
        L_0x0070:
            if (r1 == 0) goto L_0x0084
            if (r9 == 0) goto L_0x0084
            java.lang.String r3 = "This is a Test Device"
            io.hansel.core.module.IMessageBroker r10 = r7.f5106b     // Catch:{ Exception -> 0x00e2 }
            io.hansel.core.module.EventsConstants r0 = io.hansel.core.module.EventsConstants.DEVICE_IN_TESTGROUP     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r0 = r0.name()     // Catch:{ Exception -> 0x00e2 }
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x00e2 }
            r10.publishEvent(r0, r5)     // Catch:{ Exception -> 0x00e2 }
            goto L_0x0085
        L_0x0084:
            r3 = r2
        L_0x0085:
            r10 = 0
            goto L_0x008d
        L_0x0087:
            if (r8 == 0) goto L_0x008a
            goto L_0x008b
        L_0x008a:
            r3 = r2
        L_0x008b:
            r10 = 1
            r9 = r1
        L_0x008d:
            if (r10 != 0) goto L_0x00cd
            android.content.Context r10 = r7.f5105a     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r0 = "is_tg_status_known"
            io.hansel.core.base.utils.HSLInternalUtils.setBooleanInSharedPreferences(r10, r0, r6)     // Catch:{ Exception -> 0x00e2 }
            android.content.Context r10 = r7.f5105a     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r0 = "is_in_testgroup"
            io.hansel.core.base.utils.HSLInternalUtils.setBooleanInSharedPreferences(r10, r0, r9)     // Catch:{ Exception -> 0x00e2 }
            if (r1 != r9) goto L_0x00a1
            if (r8 != 0) goto L_0x00cd
        L_0x00a1:
            java.lang.String r8 = "TGResponse:    tgStatusChanged to known"
            io.hansel.core.logger.HSLLogger.d(r8)     // Catch:{ Exception -> 0x00e2 }
            io.hansel.core.module.IMessageBroker r8 = r7.f5106b     // Catch:{ Exception -> 0x00e2 }
            io.hansel.core.module.EventsConstants r10 = io.hansel.core.module.EventsConstants.CLEAR_TTL     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r10 = r10.name()     // Catch:{ Exception -> 0x00e2 }
            r8.publishEvent(r10, r2)     // Catch:{ Exception -> 0x00e2 }
            if (r9 == 0) goto L_0x00c0
            io.hansel.core.module.IMessageBroker r8 = r7.f5106b     // Catch:{ Exception -> 0x00e2 }
            io.hansel.core.module.EventsConstants r10 = io.hansel.core.module.EventsConstants.DEVICE_IN_TESTGROUP     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r10 = r10.name()     // Catch:{ Exception -> 0x00e2 }
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x00e2 }
            r8.publishEvent(r10, r0)     // Catch:{ Exception -> 0x00e2 }
        L_0x00c0:
            io.hansel.core.module.IMessageBroker r8 = r7.f5106b     // Catch:{ Exception -> 0x00e2 }
            io.hansel.core.module.EventsConstants r10 = io.hansel.core.module.EventsConstants.APPLICATION_DID_MOVE_TO_FOREGROUND     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r10 = r10.name()     // Catch:{ Exception -> 0x00e2 }
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x00e2 }
            r8.publishEvent(r10, r0)     // Catch:{ Exception -> 0x00e2 }
        L_0x00cd:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e2 }
            r8.<init>()     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r10 = "hsl-tg-"
            r8.append(r10)     // Catch:{ Exception -> 0x00e2 }
            r8.append(r9)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00e2 }
            io.hansel.core.logger.HSLLogger.i(r8)     // Catch:{ Exception -> 0x00e2 }
            goto L_0x00ea
        L_0x00e2:
            r8 = move-exception
            r2 = r3
        L_0x00e4:
            io.hansel.core.logger.HSLLogger.printStackTrace(r8)
            goto L_0x00eb
        L_0x00e8:
            if (r8 == 0) goto L_0x00eb
        L_0x00ea:
            r2 = r3
        L_0x00eb:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "TGResponseMessage:    "
            r8.append(r9)
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            io.hansel.core.logger.HSLLogger.d(r8)
            if (r2 == 0) goto L_0x0104
            io.hansel.hanselsdk.Hansel.showToast(r2, r4)
        L_0x0104:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.core.base.network.e.parseResponse(io.hansel.core.network.request.HSLServerRequest, java.lang.String, int):void");
    }
}
