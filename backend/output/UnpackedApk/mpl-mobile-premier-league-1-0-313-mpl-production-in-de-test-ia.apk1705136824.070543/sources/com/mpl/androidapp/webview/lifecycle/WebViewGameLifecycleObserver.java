package com.mpl.androidapp.webview.lifecycle;

import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.mpl.androidapp.utils.MLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\b\u0010\b\u001a\u00020\u0004H\u0007¨\u0006\n"}, d2 = {"Lcom/mpl/androidapp/webview/lifecycle/WebViewGameLifecycleObserver;", "Landroidx/lifecycle/LifecycleObserver;", "()V", "onCreateEvent", "", "onDestroyEvent", "onPauseEvent", "onResumeEvent", "onStartEvent", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebViewGameLifecycleObserver.kt */
public final class WebViewGameLifecycleObserver implements LifecycleObserver {
    public static final Companion Companion = new Companion(null);
    public static final String MSG_CALLBACK_ON_CREATE = "On create life cycle callback";
    public static final String MSG_CALLBACK_ON_DESTROY = "On destroy life cycle callback";
    public static final String MSG_CALLBACK_ON_PAUSE = "On pause life cycle callback";
    public static final String MSG_CALLBACK_ON_RESUME = "On resume life cycle callback";
    public static final String MSG_CALLBACK_ON_START = "On start life cycle callback";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/mpl/androidapp/webview/lifecycle/WebViewGameLifecycleObserver$Companion;", "", "()V", "MSG_CALLBACK_ON_CREATE", "", "MSG_CALLBACK_ON_DESTROY", "MSG_CALLBACK_ON_PAUSE", "MSG_CALLBACK_ON_RESUME", "MSG_CALLBACK_ON_START", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebViewGameLifecycleObserver.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @OnLifecycleEvent(Event.ON_CREATE)
    public final void onCreateEvent() {
        MLogger.d("WebViewGames", MSG_CALLBACK_ON_CREATE);
    }

    @OnLifecycleEvent(Event.ON_DESTROY)
    public final void onDestroyEvent() {
        MLogger.d("WebViewGames", MSG_CALLBACK_ON_DESTROY);
    }

    @OnLifecycleEvent(Event.ON_PAUSE)
    public final void onPauseEvent() {
        MLogger.d("WebViewGames", MSG_CALLBACK_ON_PAUSE);
    }

    @OnLifecycleEvent(Event.ON_RESUME)
    public final void onResumeEvent() {
        MLogger.d("WebViewGames", MSG_CALLBACK_ON_RESUME);
    }

    @OnLifecycleEvent(Event.ON_START)
    public final void onStartEvent() {
        MLogger.d("WebViewGames", MSG_CALLBACK_ON_START);
    }
}
