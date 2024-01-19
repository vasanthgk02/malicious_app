package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.EventInternal.Builder;
import com.google.android.datatransport.runtime.ProtoEncoderDoNotUse;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.backends.AutoValue_BackendRequest;
import com.google.android.datatransport.runtime.backends.AutoValue_BackendResponse;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.BackendResponse.Status;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped.Reason;
import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_PersistedEvent;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.firebase.encoders.proto.ProtobufEncoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.Executor;

public class Uploader {
    public final BackendRegistry backendRegistry;
    public final ClientHealthMetricsStore clientHealthMetricsStore;
    public final Clock clock;
    public final Context context;
    public final EventStore eventStore;
    public final Executor executor;
    public final SynchronizationGuard guard;
    public final Clock uptimeClock;
    public final WorkScheduler workScheduler;

    public Uploader(Context context2, BackendRegistry backendRegistry2, EventStore eventStore2, WorkScheduler workScheduler2, Executor executor2, SynchronizationGuard synchronizationGuard, Clock clock2, Clock clock3, ClientHealthMetricsStore clientHealthMetricsStore2) {
        this.context = context2;
        this.backendRegistry = backendRegistry2;
        this.eventStore = eventStore2;
        this.workScheduler = workScheduler2;
        this.executor = executor2;
        this.guard = synchronizationGuard;
        this.clock = clock2;
        this.uptimeClock = clock3;
        this.clientHealthMetricsStore = clientHealthMetricsStore2;
    }

    public boolean isNetworkAvailable() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public /* synthetic */ Boolean lambda$logAndUpdateState$2$Uploader(TransportContext transportContext) {
        return Boolean.valueOf(this.eventStore.hasPendingEventsFor(transportContext));
    }

    public /* synthetic */ Iterable lambda$logAndUpdateState$3$Uploader(TransportContext transportContext) {
        return this.eventStore.loadBatch(transportContext);
    }

    public /* synthetic */ Object lambda$logAndUpdateState$4$Uploader(Iterable iterable, TransportContext transportContext, long j) {
        this.eventStore.recordFailure(iterable);
        this.eventStore.recordNextCallTime(transportContext, this.clock.getTime() + j);
        return null;
    }

    public /* synthetic */ Object lambda$logAndUpdateState$5$Uploader(Iterable iterable) {
        this.eventStore.recordSuccess(iterable);
        return null;
    }

    public /* synthetic */ Object lambda$logAndUpdateState$6$Uploader() {
        this.clientHealthMetricsStore.resetClientMetrics();
        return null;
    }

    public /* synthetic */ Object lambda$logAndUpdateState$7$Uploader(Map map) {
        for (Entry entry : map.entrySet()) {
            this.clientHealthMetricsStore.recordLogEventDropped((long) ((Integer) entry.getValue()).intValue(), Reason.INVALID_PAYLOD, (String) entry.getKey());
        }
        return null;
    }

    public /* synthetic */ Object lambda$logAndUpdateState$8$Uploader(TransportContext transportContext, long j) {
        this.eventStore.recordNextCallTime(transportContext, this.clock.getTime() + j);
        return null;
    }

    public /* synthetic */ Object lambda$upload$0$Uploader(TransportContext transportContext, int i) {
        this.workScheduler.schedule(transportContext, i + 1);
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:6|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0031, code lost:
        r6.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0024, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r3.workScheduler.schedule(r4, r5 + 1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0026 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void lambda$upload$1$Uploader(com.google.android.datatransport.runtime.TransportContext r4, int r5, java.lang.Runnable r6) {
        /*
            r3 = this;
            com.google.android.datatransport.runtime.synchronization.SynchronizationGuard r0 = r3.guard     // Catch:{ SynchronizationException -> 0x0026 }
            com.google.android.datatransport.runtime.scheduling.persistence.EventStore r1 = r3.eventStore     // Catch:{ SynchronizationException -> 0x0026 }
            java.util.Objects.requireNonNull(r1)     // Catch:{ SynchronizationException -> 0x0026 }
            com.google.android.datatransport.runtime.scheduling.jobscheduling.-$$Lambda$7iIGXG4rziTDaCv7wibWFWjAdgo r2 = new com.google.android.datatransport.runtime.scheduling.jobscheduling.-$$Lambda$7iIGXG4rziTDaCv7wibWFWjAdgo     // Catch:{ SynchronizationException -> 0x0026 }
            r2.<init>()     // Catch:{ SynchronizationException -> 0x0026 }
            r0.runCriticalSection(r2)     // Catch:{ SynchronizationException -> 0x0026 }
            boolean r0 = r3.isNetworkAvailable()     // Catch:{ SynchronizationException -> 0x0026 }
            if (r0 != 0) goto L_0x0020
            com.google.android.datatransport.runtime.synchronization.SynchronizationGuard r0 = r3.guard     // Catch:{ SynchronizationException -> 0x0026 }
            com.google.android.datatransport.runtime.scheduling.jobscheduling.-$$Lambda$Uploader$-PizdFkrUS80CHQoeatutNhEQNk r1 = new com.google.android.datatransport.runtime.scheduling.jobscheduling.-$$Lambda$Uploader$-PizdFkrUS80CHQoeatutNhEQNk     // Catch:{ SynchronizationException -> 0x0026 }
            r1.<init>(r4, r5)     // Catch:{ SynchronizationException -> 0x0026 }
            r0.runCriticalSection(r1)     // Catch:{ SynchronizationException -> 0x0026 }
            goto L_0x002d
        L_0x0020:
            r3.logAndUpdateState(r4, r5)     // Catch:{ SynchronizationException -> 0x0026 }
            goto L_0x002d
        L_0x0024:
            r4 = move-exception
            goto L_0x0031
        L_0x0026:
            com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler r0 = r3.workScheduler     // Catch:{ all -> 0x0024 }
            int r5 = r5 + 1
            r0.schedule(r4, r5)     // Catch:{ all -> 0x0024 }
        L_0x002d:
            r6.run()
            return
        L_0x0031:
            r6.run()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader.lambda$upload$1$Uploader(com.google.android.datatransport.runtime.TransportContext, int, java.lang.Runnable):void");
    }

    public void logAndUpdateState(TransportContext transportContext, int i) {
        BackendResponse backendResponse;
        TransportContext transportContext2 = transportContext;
        AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) transportContext2;
        TransportBackend transportBackend = this.backendRegistry.get(autoValue_TransportContext.backendName);
        long j = 0;
        while (((Boolean) this.guard.runCriticalSection(new CriticalSection(transportContext2) {
            public final /* synthetic */ TransportContext f$1;

            {
                this.f$1 = r2;
            }

            public final Object execute() {
                return Uploader.this.lambda$logAndUpdateState$2$Uploader(this.f$1);
            }
        })).booleanValue()) {
            Iterable<PersistedEvent> iterable = (Iterable) this.guard.runCriticalSection(new CriticalSection(transportContext2) {
                public final /* synthetic */ TransportContext f$1;

                {
                    this.f$1 = r2;
                }

                public final Object execute() {
                    return Uploader.this.lambda$logAndUpdateState$3$Uploader(this.f$1);
                }
            });
            if (iterable.iterator().hasNext()) {
                if (transportBackend == null) {
                    ImageOriginUtils.d("Uploader", "Unknown backend for %s, deleting event batch for it...", transportContext2);
                    backendResponse = BackendResponse.fatalError();
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (PersistedEvent persistedEvent : iterable) {
                        arrayList.add(((AutoValue_PersistedEvent) persistedEvent).event);
                    }
                    if (autoValue_TransportContext.extras != null) {
                        SynchronizationGuard synchronizationGuard = this.guard;
                        ClientHealthMetricsStore clientHealthMetricsStore2 = this.clientHealthMetricsStore;
                        Objects.requireNonNull(clientHealthMetricsStore2);
                        ClientMetrics clientMetrics = (ClientMetrics) synchronizationGuard.runCriticalSection(new CriticalSection() {
                            public final Object execute() {
                                return ClientHealthMetricsStore.this.loadClientMetrics();
                            }
                        });
                        Builder builder = EventInternal.builder();
                        builder.setEventMillis(this.clock.getTime());
                        builder.setUptimeMillis(this.uptimeClock.getTime());
                        builder.setTransportName("GDT_CLIENT_METRICS");
                        Encoding encoding = new Encoding("proto");
                        if (clientMetrics != null) {
                            ProtobufEncoder protobufEncoder = ProtoEncoderDoNotUse.ENCODER;
                            if (protobufEncoder != null) {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                try {
                                    protobufEncoder.encode(clientMetrics, byteArrayOutputStream);
                                } catch (IOException unused) {
                                }
                                builder.setEncodedPayload(new EncodedPayload(encoding, byteArrayOutputStream.toByteArray()));
                                arrayList.add(transportBackend.decorate(builder.build()));
                            } else {
                                throw null;
                            }
                        } else {
                            throw null;
                        }
                    }
                    backendResponse = transportBackend.send(new AutoValue_BackendRequest(arrayList, autoValue_TransportContext.extras, null));
                }
                AutoValue_BackendResponse autoValue_BackendResponse = (AutoValue_BackendResponse) backendResponse;
                if (autoValue_BackendResponse.status == Status.TRANSIENT_ERROR) {
                    SynchronizationGuard synchronizationGuard2 = this.guard;
                    $$Lambda$Uploader$ZKeHJDmEN9lylT8tr_osjYUpsfQ r0 = new CriticalSection(iterable, transportContext, j) {
                        public final /* synthetic */ Iterable f$1;
                        public final /* synthetic */ TransportContext f$2;
                        public final /* synthetic */ long f$3;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                        }

                        public final Object execute() {
                            return Uploader.this.lambda$logAndUpdateState$4$Uploader(this.f$1, this.f$2, this.f$3);
                        }
                    };
                    synchronizationGuard2.runCriticalSection(r0);
                    this.workScheduler.schedule(transportContext2, i + 1, true);
                    return;
                }
                this.guard.runCriticalSection(new CriticalSection(iterable) {
                    public final /* synthetic */ Iterable f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final Object execute() {
                        return Uploader.this.lambda$logAndUpdateState$5$Uploader(this.f$1);
                    }
                });
                Status status = autoValue_BackendResponse.status;
                if (status == Status.OK) {
                    j = Math.max(j, autoValue_BackendResponse.nextRequestWaitMillis);
                    if (autoValue_TransportContext.extras != null) {
                        this.guard.runCriticalSection(new CriticalSection() {
                            public final Object execute() {
                                return Uploader.this.lambda$logAndUpdateState$6$Uploader();
                            }
                        });
                    }
                } else if (status == Status.INVALID_PAYLOAD) {
                    HashMap hashMap = new HashMap();
                    for (PersistedEvent persistedEvent2 : iterable) {
                        String str = ((AutoValue_EventInternal) ((AutoValue_PersistedEvent) persistedEvent2).event).transportName;
                        if (!hashMap.containsKey(str)) {
                            hashMap.put(str, Integer.valueOf(1));
                        } else {
                            hashMap.put(str, Integer.valueOf(((Integer) hashMap.get(str)).intValue() + 1));
                        }
                    }
                    this.guard.runCriticalSection(new CriticalSection(hashMap) {
                        public final /* synthetic */ Map f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final Object execute() {
                            return Uploader.this.lambda$logAndUpdateState$7$Uploader(this.f$1);
                        }
                    });
                }
            } else {
                return;
            }
        }
        this.guard.runCriticalSection(new CriticalSection(transportContext2, j) {
            public final /* synthetic */ TransportContext f$1;
            public final /* synthetic */ long f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Object execute() {
                return Uploader.this.lambda$logAndUpdateState$8$Uploader(this.f$1, this.f$2);
            }
        });
    }
}
