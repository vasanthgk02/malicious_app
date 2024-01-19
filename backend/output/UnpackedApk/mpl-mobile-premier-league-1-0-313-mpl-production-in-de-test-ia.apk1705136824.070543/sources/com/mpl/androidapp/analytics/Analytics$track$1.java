package com.mpl.androidapp.analytics;

import com.mpl.androidapp.analytics.events.EventsBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/mpl/androidapp/analytics/events/EventsBuilder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Analytics.kt */
public final class Analytics$track$1 extends Lambda implements Function1<EventsBuilder, Unit> {
    public static final Analytics$track$1 INSTANCE = new Analytics$track$1();

    public Analytics$track$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((EventsBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(EventsBuilder eventsBuilder) {
        Intrinsics.checkNotNullParameter(eventsBuilder, "$this$null");
    }
}
