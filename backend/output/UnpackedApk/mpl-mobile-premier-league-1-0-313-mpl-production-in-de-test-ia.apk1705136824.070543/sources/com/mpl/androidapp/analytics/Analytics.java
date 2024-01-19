package com.mpl.androidapp.analytics;

import com.mpl.androidapp.analytics.events.EventsBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J#\u0010\u0002\u001a\u00020\u00032\u0019\b\u0002\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\b\bH&¨\u0006\t"}, d2 = {"Lcom/mpl/androidapp/analytics/Analytics;", "", "track", "", "builder", "Lcom/mpl/androidapp/analytics/events/EventsBuilder;", "setup", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Analytics.kt */
public interface Analytics {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Analytics.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void track$default(Analytics analytics, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    function1 = Analytics$track$1.INSTANCE;
                }
                analytics.track(function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: track");
        }
    }

    void track(EventsBuilder eventsBuilder);

    void track(Function1<? super EventsBuilder, Unit> function1);
}
