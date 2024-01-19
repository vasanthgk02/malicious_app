package com.google.firebase.perf.session;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.perf.application.AppStateMonitor;
import com.google.firebase.perf.application.AppStateUpdateHandler;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.config.ConfigurationConstants$SessionsMaxDurationMinutes;
import com.google.firebase.perf.config.DeviceCacheManager;
import com.google.firebase.perf.session.gauges.GaugeManager;
import com.google.firebase.perf.util.Optional;
import com.google.firebase.perf.v1.ApplicationProcessState;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Keep
public class SessionManager extends AppStateUpdateHandler {
    @SuppressLint({"StaticFieldLeak"})
    public static final SessionManager instance = new SessionManager();
    public final AppStateMonitor appStateMonitor;
    public final Set<WeakReference<SessionAwareObject>> clients;
    public final GaugeManager gaugeManager;
    public PerfSession perfSession;
    public Future syncInitFuture;

    public SessionManager() {
        this(GaugeManager.getInstance(), PerfSession.create(), AppStateMonitor.getInstance());
    }

    public static SessionManager getInstance() {
        return instance;
    }

    private void logGaugeMetadataIfCollectionEnabled(ApplicationProcessState applicationProcessState) {
        PerfSession perfSession2 = this.perfSession;
        if (perfSession2.isGaugeAndEventCollectionEnabled) {
            this.gaugeManager.logGaugeMetadata(perfSession2.sessionId, applicationProcessState);
        }
    }

    private void startOrStopCollectingGauges(ApplicationProcessState applicationProcessState) {
        PerfSession perfSession2 = this.perfSession;
        if (perfSession2.isGaugeAndEventCollectionEnabled) {
            this.gaugeManager.startCollectingGauges(perfSession2, applicationProcessState);
        } else {
            this.gaugeManager.stopCollectingGauges();
        }
    }

    @VisibleForTesting
    public Future getSyncInitFuture() {
        return this.syncInitFuture;
    }

    public void initializeGaugeCollection() {
        logGaugeMetadataIfCollectionEnabled(ApplicationProcessState.FOREGROUND);
        startOrStopCollectingGauges(ApplicationProcessState.FOREGROUND);
    }

    public /* synthetic */ void lambda$setApplicationContext$0$SessionManager(Context context, PerfSession perfSession2) {
        this.gaugeManager.initializeGaugeMetadataManager(context);
        if (perfSession2.isGaugeAndEventCollectionEnabled()) {
            this.gaugeManager.logGaugeMetadata(perfSession2.sessionId(), ApplicationProcessState.FOREGROUND);
        }
    }

    public void onUpdateAppState(ApplicationProcessState applicationProcessState) {
        super.onUpdateAppState(applicationProcessState);
        if (!this.appStateMonitor.isColdStart) {
            if (applicationProcessState == ApplicationProcessState.FOREGROUND) {
                updatePerfSession(applicationProcessState);
            } else if (!updatePerfSessionIfExpired()) {
                startOrStopCollectingGauges(applicationProcessState);
            }
        }
    }

    public final PerfSession perfSession() {
        return this.perfSession;
    }

    public void registerForSessionUpdates(WeakReference<SessionAwareObject> weakReference) {
        synchronized (this.clients) {
            this.clients.add(weakReference);
        }
    }

    public void setApplicationContext(Context context) {
        this.syncInitFuture = Executors.newSingleThreadExecutor().submit(new Runnable(context, this.perfSession) {
            public final /* synthetic */ Context f$1;
            public final /* synthetic */ PerfSession f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                SessionManager.this.lambda$setApplicationContext$0$SessionManager(this.f$1, this.f$2);
            }
        });
    }

    @VisibleForTesting
    public void setPerfSession(PerfSession perfSession2) {
        this.perfSession = perfSession2;
    }

    public void unregisterForSessionUpdates(WeakReference<SessionAwareObject> weakReference) {
        synchronized (this.clients) {
            this.clients.remove(weakReference);
        }
    }

    public void updatePerfSession(ApplicationProcessState applicationProcessState) {
        synchronized (this.clients) {
            this.perfSession = PerfSession.create();
            Iterator<WeakReference<SessionAwareObject>> it = this.clients.iterator();
            while (it.hasNext()) {
                SessionAwareObject sessionAwareObject = (SessionAwareObject) it.next().get();
                if (sessionAwareObject != null) {
                    sessionAwareObject.updateSession(this.perfSession);
                } else {
                    it.remove();
                }
            }
        }
        logGaugeMetadataIfCollectionEnabled(applicationProcessState);
        startOrStopCollectingGauges(applicationProcessState);
    }

    public boolean updatePerfSessionIfExpired() {
        ConfigurationConstants$SessionsMaxDurationMinutes configurationConstants$SessionsMaxDurationMinutes;
        long j;
        PerfSession perfSession2 = this.perfSession;
        if (perfSession2 != null) {
            long minutes = TimeUnit.MICROSECONDS.toMinutes(perfSession2.creationTime.getDurationMicros());
            ConfigResolver instance2 = ConfigResolver.getInstance();
            if (instance2 != null) {
                synchronized (ConfigurationConstants$SessionsMaxDurationMinutes.class) {
                    if (ConfigurationConstants$SessionsMaxDurationMinutes.instance == null) {
                        ConfigurationConstants$SessionsMaxDurationMinutes.instance = new ConfigurationConstants$SessionsMaxDurationMinutes();
                    }
                    configurationConstants$SessionsMaxDurationMinutes = ConfigurationConstants$SessionsMaxDurationMinutes.instance;
                }
                Optional<Long> metadataLong = instance2.getMetadataLong(configurationConstants$SessionsMaxDurationMinutes);
                if (!metadataLong.isAvailable() || !instance2.isSessionsMaxDurationMinutesValid(((Long) metadataLong.get()).longValue())) {
                    Optional<Long> remoteConfigLong = instance2.getRemoteConfigLong(configurationConstants$SessionsMaxDurationMinutes);
                    if (!remoteConfigLong.isAvailable() || !instance2.isSessionsMaxDurationMinutesValid(((Long) remoteConfigLong.get()).longValue())) {
                        Optional<Long> deviceCacheLong = instance2.getDeviceCacheLong(configurationConstants$SessionsMaxDurationMinutes);
                        if (deviceCacheLong.isAvailable() && instance2.isSessionsMaxDurationMinutesValid(((Long) deviceCacheLong.get()).longValue())) {
                            j = ((Long) deviceCacheLong.get()).longValue();
                        } else if (configurationConstants$SessionsMaxDurationMinutes != null) {
                            j = Long.valueOf(240).longValue();
                        } else {
                            throw null;
                        }
                    } else {
                        DeviceCacheManager deviceCacheManager = instance2.deviceCacheManager;
                        if (configurationConstants$SessionsMaxDurationMinutes != null) {
                            j = ((Long) GeneratedOutlineSupport.outline28((Long) remoteConfigLong.get(), deviceCacheManager, "com.google.firebase.perf.SessionsMaxDurationMinutes", remoteConfigLong)).longValue();
                        } else {
                            throw null;
                        }
                    }
                } else {
                    j = ((Long) metadataLong.get()).longValue();
                }
                if (!(minutes > j)) {
                    return false;
                }
                updatePerfSession(this.appStateMonitor.currentAppState);
                return true;
            }
            throw null;
        }
        throw null;
    }

    @VisibleForTesting
    public SessionManager(GaugeManager gaugeManager2, PerfSession perfSession2, AppStateMonitor appStateMonitor2) {
        this.clients = new HashSet();
        this.gaugeManager = gaugeManager2;
        this.perfSession = perfSession2;
        this.appStateMonitor = appStateMonitor2;
        registerForAppState();
    }
}
