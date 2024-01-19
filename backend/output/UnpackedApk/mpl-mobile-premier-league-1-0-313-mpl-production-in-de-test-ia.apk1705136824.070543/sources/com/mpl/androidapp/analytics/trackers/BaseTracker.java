package com.mpl.androidapp.analytics.trackers;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.analytics.events.Events;
import com.mpl.androidapp.utils.MLogger;
import java.util.HashMap;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\tH\u0016J4\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\"\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00180\u0017j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0018`\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u000fH\u0016J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/mpl/androidapp/analytics/trackers/BaseTracker;", "Lcom/mpl/androidapp/analytics/trackers/Tracker;", "()V", "isEnabled", "", "()Z", "setEnabled", "(Z)V", "logLevel", "Lcom/mpl/androidapp/analytics/trackers/LogLevel;", "tag", "", "getTag", "()Ljava/lang/String;", "enableAnalytics", "", "enabled", "isAnalyticsEnabled", "level", "printProps", "eventTrack", "Lcom/mpl/androidapp/analytics/events/Events;", "props", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "start", "trackEvent", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseTracker.kt */
public abstract class BaseTracker implements Tracker {
    public boolean isEnabled;
    public LogLevel logLevel = LogLevel.NONE;
    public final String tag;

    public BaseTracker() {
        String simpleName = BaseTracker.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "this::class.java.simpleName");
        this.tag = simpleName;
    }

    private final void printProps(Events events, HashMap<String, Object> hashMap) {
        if (this.logLevel == LogLevel.DEBUG) {
            MLogger.d(this.tag, "--------------------------------------------");
            MLogger.d(this.tag, GeneratedOutlineSupport.outline59(GeneratedOutlineSupport.outline73("== Sending Event From "), this.tag, '}'));
            MLogger.d(this.tag, Intrinsics.stringPlus("++ Event name: ", events.getName()));
            MLogger.d(this.tag, ">>>>> Props [Start]");
            for (Entry next : hashMap.entrySet()) {
                String str = this.tag;
                MLogger.d(str, ((String) next.getKey()) + " : " + next.getValue());
            }
            MLogger.d(this.tag, "<<<<< Props [End]");
        }
    }

    public void enableAnalytics(boolean z) {
        this.isEnabled = z;
    }

    public final String getTag() {
        return this.tag;
    }

    public boolean isAnalyticsEnabled() {
        MLogger.d(this.tag, Intrinsics.stringPlus("Enabled : ", Boolean.valueOf(this.isEnabled)));
        return this.isEnabled;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public void logLevel(LogLevel logLevel2) {
        Intrinsics.checkNotNullParameter(logLevel2, "level");
        this.logLevel = logLevel2;
    }

    public final void setEnabled(boolean z) {
        this.isEnabled = z;
    }

    public void start() {
        MLogger.d(this.tag, "Tracker has started!!");
    }

    public void trackEvent(Events events) {
        Intrinsics.checkNotNullParameter(events, "eventTrack");
        HashMap<String, Object> properties = events.getProperties();
        if (properties == null) {
            properties = new HashMap<>();
        }
        printProps(events, properties);
    }
}
