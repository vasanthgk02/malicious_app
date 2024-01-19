package com.google.firebase.perf.application;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.perf.application.AppStateMonitor.AppStateCallback;
import com.google.firebase.perf.v1.ApplicationProcessState;
import java.lang.ref.WeakReference;

public abstract class AppStateUpdateHandler implements AppStateCallback {
    public final WeakReference<AppStateCallback> appStateCallback;
    public final AppStateMonitor appStateMonitor;
    public ApplicationProcessState currentAppState;
    public boolean isRegisteredForAppState;

    public AppStateUpdateHandler() {
        this(AppStateMonitor.getInstance());
    }

    public ApplicationProcessState getAppState() {
        return this.currentAppState;
    }

    @VisibleForTesting
    public WeakReference<AppStateCallback> getAppStateCallback() {
        return this.appStateCallback;
    }

    public void incrementTsnsCount(int i) {
        this.appStateMonitor.tsnsCount.addAndGet(i);
    }

    public void onUpdateAppState(ApplicationProcessState applicationProcessState) {
        ApplicationProcessState applicationProcessState2 = this.currentAppState;
        ApplicationProcessState applicationProcessState3 = ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN;
        if (applicationProcessState2 == applicationProcessState3) {
            this.currentAppState = applicationProcessState;
        } else if (applicationProcessState2 != applicationProcessState && applicationProcessState != applicationProcessState3) {
            this.currentAppState = ApplicationProcessState.FOREGROUND_BACKGROUND;
        }
    }

    public void registerForAppState() {
        if (!this.isRegisteredForAppState) {
            AppStateMonitor appStateMonitor2 = this.appStateMonitor;
            this.currentAppState = appStateMonitor2.currentAppState;
            WeakReference<AppStateCallback> weakReference = this.appStateCallback;
            synchronized (appStateMonitor2.appStateSubscribers) {
                appStateMonitor2.appStateSubscribers.add(weakReference);
            }
            this.isRegisteredForAppState = true;
        }
    }

    public void unregisterForAppState() {
        if (this.isRegisteredForAppState) {
            AppStateMonitor appStateMonitor2 = this.appStateMonitor;
            WeakReference<AppStateCallback> weakReference = this.appStateCallback;
            synchronized (appStateMonitor2.appStateSubscribers) {
                appStateMonitor2.appStateSubscribers.remove(weakReference);
            }
            this.isRegisteredForAppState = false;
        }
    }

    public AppStateUpdateHandler(AppStateMonitor appStateMonitor2) {
        this.isRegisteredForAppState = false;
        this.currentAppState = ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN;
        this.appStateMonitor = appStateMonitor2;
        this.appStateCallback = new WeakReference<>(this);
    }
}
