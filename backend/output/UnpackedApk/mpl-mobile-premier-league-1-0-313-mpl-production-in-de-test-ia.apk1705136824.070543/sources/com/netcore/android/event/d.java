package com.netcore.android.event;

import com.netcore.android.logger.SMTLogger;
import com.netcore.android.network.SMTApiService;
import com.netcore.android.network.SMTNetworkManager;
import com.netcore.android.network.models.SMTRequest;
import com.netcore.android.network.models.SMTResponse;
import com.userexperior.models.recording.enums.UeCustomType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SMTEventProcessor.kt */
public final class d {

    /* renamed from: b  reason: collision with root package name */
    public static volatile d f1075b;

    /* renamed from: c  reason: collision with root package name */
    public static final a f1076c = new a(null);

    /* renamed from: a  reason: collision with root package name */
    public final String f1077a = d.class.getSimpleName();

    /* compiled from: SMTEventProcessor.kt */
    public static final class a {
        public a() {
        }

        private final d a() {
            return new d();
        }

        public final d b() {
            d a2 = d.f1075b;
            if (a2 == null) {
                synchronized (this) {
                    a2 = d.f1075b;
                    if (a2 == null) {
                        a2 = d.f1076c.a();
                        d.f1075b = a2;
                    }
                }
            }
            return a2;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final SMTResponse b(SMTRequest sMTRequest) {
        SMTResponse a2;
        Intrinsics.checkNotNullParameter(sMTRequest, "request");
        synchronized (this) {
            sMTRequest.setRetryCount$smartech_release(sMTRequest.getRetryCount$smartech_release() + 1);
            a2 = a(sMTRequest);
        }
        return a2;
    }

    private final SMTResponse a(SMTRequest sMTRequest) {
        SMTResponse sMTResponse = null;
        try {
            sMTResponse = new SMTApiService(sMTRequest).makeApiCall();
            if (sMTResponse.isSuccess()) {
                SMTLogger sMTLogger = SMTLogger.INSTANCE;
                String str = this.f1077a;
                Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
                sMTLogger.v(str, "Events processed successfully.");
            } else if (sMTRequest.getRetryCount$smartech_release() <= SMTNetworkManager.Companion.getMAX_RETRY_COUNT()) {
                sMTRequest.setRetryCount$smartech_release(sMTRequest.getRetryCount$smartech_release() + 1);
                Thread.sleep(1000);
                a(sMTRequest);
            }
        } catch (Exception e2) {
            SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
            String str2 = this.f1077a;
            Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
            sMTLogger2.v(str2, String.valueOf(e2.getMessage()));
        }
        return sMTResponse;
    }
}
