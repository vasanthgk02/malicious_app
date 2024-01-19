package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.Keep;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.perf.application.AppStateMonitor;
import com.google.firebase.perf.application.AppStateUpdateHandler;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.metrics.validator.PerfMetricValidator;
import com.google.firebase.perf.session.PerfSession;
import com.google.firebase.perf.session.SessionAwareObject;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.session.gauges.GaugeManager;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Constants$TraceNames;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.TraceMetric;
import java.lang.ref.WeakReference;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Trace extends AppStateUpdateHandler implements Parcelable, SessionAwareObject {
    @Keep
    public static final Creator<Trace> CREATOR = new Creator<Trace>() {
        public Object createFromParcel(Parcel parcel) {
            return new Trace(parcel, false, null);
        }

        public Object[] newArray(int i) {
            return new Trace[i];
        }
    };
    public static final AndroidLogger logger = AndroidLogger.getInstance();
    public final Clock clock;
    public final Map<String, Counter> counterNameToCounterMap;
    public final Map<String, String> customAttributesMap;
    public Timer endTime;
    public final GaugeManager gaugeManager;
    public final String name;
    public final Trace parent;
    public final WeakReference<SessionAwareObject> sessionAwareObject;
    public final List<PerfSession> sessions;
    public Timer startTime;
    public final List<Trace> subtraces;
    public final TransportManager transportManager;

    static {
        new ConcurrentHashMap();
    }

    public Trace(String str, TransportManager transportManager2, Clock clock2, AppStateMonitor appStateMonitor, GaugeManager gaugeManager2) {
        super(appStateMonitor);
        this.sessionAwareObject = new WeakReference<>(this);
        this.parent = null;
        this.name = str.trim();
        this.subtraces = new ArrayList();
        this.counterNameToCounterMap = new ConcurrentHashMap();
        this.customAttributesMap = new ConcurrentHashMap();
        this.clock = clock2;
        this.transportManager = transportManager2;
        this.sessions = Collections.synchronizedList(new ArrayList());
        this.gaugeManager = gaugeManager2;
    }

    public final void checkAttribute(String str, String str2) {
        if (isStopped()) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Trace '%s' has been stopped", new Object[]{this.name}));
        } else if (this.customAttributesMap.containsKey(str) || this.customAttributesMap.size() < 5) {
            String validateAttribute = PerfMetricValidator.validateAttribute(new SimpleEntry(str, str2));
            if (validateAttribute != null) {
                throw new IllegalArgumentException(validateAttribute);
            }
        } else {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Exceeds max limit of number of attributes - %d", new Object[]{Integer.valueOf(5)}));
        }
    }

    @Keep
    public int describeContents() {
        return 0;
    }

    public void finalize() throws Throwable {
        try {
            if (hasStarted() && !isStopped()) {
                logger.warn("Trace '%s' is started but not stopped when it is destructed!", this.name);
                incrementTsnsCount(1);
            }
        } finally {
            super.finalize();
        }
    }

    @Keep
    public String getAttribute(String str) {
        return this.customAttributesMap.get(str);
    }

    @Keep
    public Map<String, String> getAttributes() {
        return new HashMap(this.customAttributesMap);
    }

    @Keep
    public long getLongMetric(String str) {
        Counter counter = str != null ? this.counterNameToCounterMap.get(str.trim()) : null;
        if (counter == null) {
            return 0;
        }
        return counter.getCount();
    }

    @VisibleForTesting
    public boolean hasStarted() {
        return this.startTime != null;
    }

    @Keep
    public void incrementMetric(String str, long j) {
        String validateMetricName = PerfMetricValidator.validateMetricName(str);
        if (validateMetricName != null) {
            logger.error("Cannot increment metric '%s'. Metric name is invalid.(%s)", str, validateMetricName);
        } else if (!hasStarted()) {
            logger.warn("Cannot increment metric '%s' for trace '%s' because it's not started", str, this.name);
        } else if (isStopped()) {
            logger.warn("Cannot increment metric '%s' for trace '%s' because it's been stopped", str, this.name);
        } else {
            String trim = str.trim();
            Counter counter = this.counterNameToCounterMap.get(trim);
            if (counter == null) {
                counter = new Counter(trim);
                this.counterNameToCounterMap.put(trim, counter);
            }
            counter.count.addAndGet(j);
            logger.debug("Incrementing metric '%s' to %d on trace '%s'", str, Long.valueOf(counter.getCount()), this.name);
        }
    }

    @VisibleForTesting
    public boolean isStopped() {
        return this.endTime != null;
    }

    @Keep
    public void putAttribute(String str, String str2) {
        boolean z = false;
        try {
            str = str.trim();
            str2 = str2.trim();
            checkAttribute(str, str2);
            logger.debug("Setting attribute '%s' to '%s' on trace '%s'", str, str2, this.name);
            z = true;
        } catch (Exception e2) {
            logger.error("Can not set attribute '%s' with value '%s' (%s)", str, str2, e2.getMessage());
        }
        if (z) {
            this.customAttributesMap.put(str, str2);
        }
    }

    @Keep
    public void putMetric(String str, long j) {
        String validateMetricName = PerfMetricValidator.validateMetricName(str);
        if (validateMetricName != null) {
            logger.error("Cannot set value for metric '%s'. Metric name is invalid.(%s)", str, validateMetricName);
        } else if (!hasStarted()) {
            logger.warn("Cannot set value for metric '%s' for trace '%s' because it's not started", str, this.name);
        } else if (isStopped()) {
            logger.warn("Cannot set value for metric '%s' for trace '%s' because it's been stopped", str, this.name);
        } else {
            String trim = str.trim();
            Counter counter = this.counterNameToCounterMap.get(trim);
            if (counter == null) {
                counter = new Counter(trim);
                this.counterNameToCounterMap.put(trim, counter);
            }
            counter.count.set(j);
            logger.debug("Setting metric '%s' to '%s' on trace '%s'", str, Long.valueOf(j), this.name);
        }
    }

    @Keep
    public void removeAttribute(String str) {
        if (isStopped()) {
            AndroidLogger androidLogger = logger;
            if (androidLogger.isLogcatEnabled && androidLogger.logWrapper == null) {
                throw null;
            }
            return;
        }
        this.customAttributesMap.remove(str);
    }

    @Keep
    public void start() {
        Object obj;
        if (!ConfigResolver.getInstance().isPerformanceMonitoringEnabled()) {
            logger.debug("Trace feature is disabled.");
            return;
        }
        String str = this.name;
        if (str == null) {
            obj = "Trace name must not be null";
        } else if (str.length() > 100) {
            obj = String.format(Locale.US, "Trace name must not exceed %d characters", new Object[]{Integer.valueOf(100)});
        } else {
            if (str.startsWith("_")) {
                Constants$TraceNames[] values = Constants$TraceNames.values();
                int length = values.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        if (values[i].toString().equals(str)) {
                            break;
                        }
                        i++;
                    } else if (!str.startsWith("_st_")) {
                        obj = "Trace name must not start with '_'";
                    }
                }
            }
            obj = null;
        }
        if (obj != null) {
            logger.error("Cannot start trace '%s'. Trace name is invalid.(%s)", this.name, obj);
        } else if (this.startTime != null) {
            logger.error("Trace '%s' has already started, should not start again!", this.name);
        } else if (this.clock != null) {
            this.startTime = new Timer();
            registerForAppState();
            PerfSession perfSession = SessionManager.getInstance().perfSession();
            SessionManager.getInstance().registerForSessionUpdates(this.sessionAwareObject);
            updateSession(perfSession);
            if (perfSession.isGaugeAndEventCollectionEnabled) {
                this.gaugeManager.collectGaugeMetricOnce(perfSession.creationTime);
            }
        } else {
            throw null;
        }
    }

    @Keep
    public void stop() {
        if (!hasStarted()) {
            logger.error("Trace '%s' has not been started so unable to stop!", this.name);
        } else if (isStopped()) {
            logger.error("Trace '%s' has already stopped, should not stop again!", this.name);
        } else {
            SessionManager.getInstance().unregisterForSessionUpdates(this.sessionAwareObject);
            unregisterForAppState();
            if (this.clock != null) {
                Timer timer = new Timer();
                this.endTime = timer;
                if (this.parent == null) {
                    if (!this.subtraces.isEmpty()) {
                        Trace trace = this.subtraces.get(this.subtraces.size() - 1);
                        if (trace.endTime == null) {
                            trace.endTime = timer;
                        }
                    }
                    if (!this.name.isEmpty()) {
                        TransportManager transportManager2 = this.transportManager;
                        transportManager2.executorService.execute(new Runnable(new TraceMetricBuilder(this).build(), getAppState()) {
                            public final /* synthetic */ TraceMetric f$1;
                            public final /* synthetic */ ApplicationProcessState f$2;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                            }

                            public final void run() {
                                TransportManager.this.lambda$log$2$TransportManager(this.f$1, this.f$2);
                            }
                        });
                        if (SessionManager.getInstance().perfSession().isGaugeAndEventCollectionEnabled) {
                            this.gaugeManager.collectGaugeMetricOnce(SessionManager.getInstance().perfSession().creationTime);
                        }
                    } else {
                        AndroidLogger androidLogger = logger;
                        if (androidLogger.isLogcatEnabled && androidLogger.logWrapper == null) {
                            throw null;
                        }
                    }
                }
                return;
            }
            throw null;
        }
    }

    public void updateSession(PerfSession perfSession) {
        if (perfSession == null) {
            logger.warn("Unable to add new SessionId to the Trace. Continuing without it.");
            return;
        }
        if (hasStarted() && !isStopped()) {
            this.sessions.add(perfSession);
        }
    }

    @Keep
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.parent, 0);
        parcel.writeString(this.name);
        parcel.writeList(this.subtraces);
        parcel.writeMap(this.counterNameToCounterMap);
        parcel.writeParcelable(this.startTime, 0);
        parcel.writeParcelable(this.endTime, 0);
        synchronized (this.sessions) {
            parcel.writeList(this.sessions);
        }
    }

    public Trace(Parcel parcel, boolean z, AnonymousClass1 r5) {
        super(z ? null : AppStateMonitor.getInstance());
        this.sessionAwareObject = new WeakReference<>(this);
        this.parent = (Trace) parcel.readParcelable(Trace.class.getClassLoader());
        this.name = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.subtraces = arrayList;
        parcel.readList(arrayList, Trace.class.getClassLoader());
        this.counterNameToCounterMap = new ConcurrentHashMap();
        this.customAttributesMap = new ConcurrentHashMap();
        parcel.readMap(this.counterNameToCounterMap, Counter.class.getClassLoader());
        this.startTime = (Timer) parcel.readParcelable(Timer.class.getClassLoader());
        this.endTime = (Timer) parcel.readParcelable(Timer.class.getClassLoader());
        List<PerfSession> synchronizedList = Collections.synchronizedList(new ArrayList());
        this.sessions = synchronizedList;
        parcel.readList(synchronizedList, PerfSession.class.getClassLoader());
        if (z) {
            this.transportManager = null;
            this.clock = null;
            this.gaugeManager = null;
            return;
        }
        this.transportManager = TransportManager.instance;
        this.clock = new Clock();
        this.gaugeManager = GaugeManager.getInstance();
    }
}
