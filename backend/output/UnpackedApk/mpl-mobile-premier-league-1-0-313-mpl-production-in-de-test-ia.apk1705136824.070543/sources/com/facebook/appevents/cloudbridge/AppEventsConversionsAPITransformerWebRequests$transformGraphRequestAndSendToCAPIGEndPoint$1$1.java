package com.facebook.appevents.cloudbridge;

import com.facebook.internal.Utility;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "responseCode", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: AppEventsConversionsAPITransformerWebRequests.kt */
public final class AppEventsConversionsAPITransformerWebRequests$transformGraphRequestAndSendToCAPIGEndPoint$1$1 extends Lambda implements Function2<String, Integer, Unit> {
    public final /* synthetic */ List<Map<String, Object>> $processedEvents;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public AppEventsConversionsAPITransformerWebRequests$transformGraphRequestAndSendToCAPIGEndPoint$1$1(List<? extends Map<String, ? extends Object>> list) {
        // this.$processedEvents = list;
        super(2);
    }

    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m159invoke$lambda0(Integer num, List list) {
        Intrinsics.checkNotNullParameter(list, "$processedEvents");
        if (!ArraysKt___ArraysJvmKt.contains(AppEventsConversionsAPITransformerWebRequests.ACCEPTABLE_HTTP_RESPONSE, num)) {
            AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests = AppEventsConversionsAPITransformerWebRequests.INSTANCE;
            Intrinsics.checkNotNullParameter(list, "processedEvents");
            if (!ArraysKt___ArraysJvmKt.contains(AppEventsConversionsAPITransformerWebRequests.RETRY_EVENTS_HTTP_RESPONSE, num)) {
                return;
            }
            if (AppEventsConversionsAPITransformerWebRequests.currentRetryCount >= 5) {
                appEventsConversionsAPITransformerWebRequests.getTransformedEvents$facebook_core_release().clear();
                AppEventsConversionsAPITransformerWebRequests.currentRetryCount = 0;
                return;
            }
            appEventsConversionsAPITransformerWebRequests.getTransformedEvents$facebook_core_release().addAll(0, list);
            AppEventsConversionsAPITransformerWebRequests.currentRetryCount++;
        }
    }

    public Object invoke(Object obj, Object obj2) {
        String str = (String) obj;
        Utility.runOnNonUiThread(new Runnable((Integer) obj2, this.$processedEvents) {
            public final /* synthetic */ Integer f$0;
            public final /* synthetic */ List f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                AppEventsConversionsAPITransformerWebRequests$transformGraphRequestAndSendToCAPIGEndPoint$1$1.m159invoke$lambda0(this.f$0, this.f$1);
            }
        });
        return Unit.INSTANCE;
    }
}
