package com.mpl.androidapp.analytics.events;

import com.mpl.androidapp.analytics.events.Events.SessionEvents;
import com.twitter.sdk.android.tweetui.TweetUtils;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0016\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0001J\u0015\u0010\u0014\u001a\u00020\u0015*\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0001H\u0004R;\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u00078FX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/mpl/androidapp/analytics/events/EventsBuilder;", "", "name", "", "(Ljava/lang/String;)V", "data", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getData", "()Ljava/util/HashMap;", "data$delegate", "Lkotlin/Lazy;", "getName", "()Ljava/lang/String;", "setName", "build", "Lcom/mpl/androidapp/analytics/events/Event;", "put", "key", "value", "set", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EventsBuilder.kt */
public class EventsBuilder {
    public final Lazy data$delegate;
    public String name;

    public EventsBuilder() {
        this(null, 1, null);
    }

    public EventsBuilder(String str) {
        this.name = str;
        this.data$delegate = TweetUtils.lazy((Function0<? extends T>) EventsBuilder$data$2.INSTANCE);
    }

    public final Event build() {
        String str = this.name;
        if (!(str == null || CharsKt__CharKt.isBlank(str))) {
            String str2 = this.name;
            SessionEvents sessionEvents = null;
            if (str2 == null) {
                return null;
            }
            if (Intrinsics.areEqual(str2, "App Session Time V2")) {
                sessionEvents = new SessionEvents(str2, getData());
            }
            return sessionEvents;
        }
        throw new IllegalArgumentException("Events should contain a name look at DISPLAY/EVENT annotation class");
    }

    public final HashMap<String, Object> getData() {
        return (HashMap) this.data$delegate.getValue();
    }

    public final String getName() {
        return this.name;
    }

    public final EventsBuilder put(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(obj, HSLCriteriaBuilder.VALUE);
        HashMap<String, Object> data = getData();
        if (data != null && !data.containsKey(str)) {
            data.put(str, obj);
        }
        return this;
    }

    public final void set(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(obj, HSLCriteriaBuilder.VALUE);
        HashMap<String, Object> data = getData();
        if (data != null && !data.containsKey(str)) {
            data.put(str, obj);
        }
    }

    public final void setName(String str) {
        this.name = str;
    }

    public /* synthetic */ EventsBuilder(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }
}
