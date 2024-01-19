package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.runtime.TransportContext.Builder;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.Collections;
import java.util.Set;

public class TransportRuntime implements TransportInternal {
    public static volatile TransportRuntimeComponent instance;
    public final Clock eventClock;
    public final Scheduler scheduler;
    public final Uploader uploader;
    public final Clock uptimeClock;

    public TransportRuntime(Clock clock, Clock clock2, Scheduler scheduler2, Uploader uploader2, WorkInitializer workInitializer) {
        this.eventClock = clock;
        this.uptimeClock = clock2;
        this.scheduler = scheduler2;
        this.uploader = uploader2;
        workInitializer.executor.execute(new Runnable() {
            public final void run() {
                WorkInitializer.this.lambda$ensureContextsScheduled$1$WorkInitializer();
            }
        });
    }

    public static TransportRuntime getInstance() {
        TransportRuntimeComponent transportRuntimeComponent = instance;
        if (transportRuntimeComponent != null) {
            return (TransportRuntime) ((DaggerTransportRuntimeComponent) transportRuntimeComponent).transportRuntimeProvider.get();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static void initialize(Context context) {
        if (instance == null) {
            synchronized (TransportRuntime.class) {
                if (instance == null) {
                    if (context != null) {
                        Class<Context> cls = Context.class;
                        if (context != null) {
                            instance = new DaggerTransportRuntimeComponent(context, null);
                        } else {
                            throw new IllegalStateException(cls.getCanonicalName() + " must be set");
                        }
                    } else {
                        throw null;
                    }
                }
            }
        }
    }

    public TransportFactory newFactory(EncodedDestination encodedDestination) {
        Set<T> set;
        if (encodedDestination instanceof EncodedDestination) {
            set = Collections.unmodifiableSet(encodedDestination.getSupportedEncodings());
        } else {
            set = Collections.singleton(new Encoding("proto"));
        }
        Builder builder = TransportContext.builder();
        builder.setBackendName(encodedDestination.getName());
        AutoValue_TransportContext.Builder builder2 = (AutoValue_TransportContext.Builder) builder;
        builder2.extras = encodedDestination.getExtras();
        return new TransportFactoryImpl(set, builder2.build(), this);
    }
}
