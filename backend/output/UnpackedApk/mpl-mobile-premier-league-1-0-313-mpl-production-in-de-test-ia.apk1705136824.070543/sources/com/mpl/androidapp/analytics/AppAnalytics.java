package com.mpl.androidapp.analytics;

import com.mpl.androidapp.analytics.events.Event;
import com.mpl.androidapp.analytics.events.Events;
import com.mpl.androidapp.analytics.events.EventsBuilder;
import com.mpl.androidapp.analytics.trackers.Tracker;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J!\u0010\n\u001a\u00020\u00072\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00070\u000e¢\u0006\u0002\b\u000fH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/mpl/androidapp/analytics/AppAnalytics;", "Lcom/mpl/androidapp/analytics/Analytics;", "trackers", "", "Lcom/mpl/androidapp/analytics/trackers/Tracker;", "(Ljava/util/Set;)V", "send", "", "event", "Lcom/mpl/androidapp/analytics/events/Event;", "track", "builder", "Lcom/mpl/androidapp/analytics/events/EventsBuilder;", "setup", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AppAnalytics.kt */
public final class AppAnalytics implements Analytics {
    public final Set<Tracker> trackers;

    public AppAnalytics(Set<? extends Tracker> set) {
        Intrinsics.checkNotNullParameter(set, "trackers");
        this.trackers = set;
        for (Tracker tracker : set) {
            if (tracker.isAnalyticsEnabled()) {
                tracker.start();
            }
        }
    }

    private final void send(Event event) {
        if (event != null) {
            for (Tracker trackEvent : this.trackers) {
                trackEvent.trackEvent((Events) event);
            }
        }
    }

    public void track(Function1<? super EventsBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "setup");
        EventsBuilder eventsBuilder = new EventsBuilder(null, 1, null);
        function1.invoke(eventsBuilder);
        send(eventsBuilder.build());
    }

    public void track(EventsBuilder eventsBuilder) {
        Intrinsics.checkNotNullParameter(eventsBuilder, "builder");
        send(eventsBuilder.build());
    }
}
