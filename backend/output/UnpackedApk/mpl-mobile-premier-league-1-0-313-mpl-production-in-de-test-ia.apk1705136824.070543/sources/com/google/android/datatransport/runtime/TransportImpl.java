package com.google.android.datatransport.runtime;

import com.google.android.datatransport.AutoValue_Event;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.TransportContext.Builder;
import com.google.android.datatransport.runtime.scheduling.Scheduler;

public final class TransportImpl<T> implements Transport<T> {
    public final String name;
    public final Encoding payloadEncoding;
    public final Transformer<T, byte[]> transformer;
    public final TransportContext transportContext;
    public final TransportInternal transportInternal;

    public TransportImpl(TransportContext transportContext2, String str, Encoding encoding, Transformer<T, byte[]> transformer2, TransportInternal transportInternal2) {
        this.transportContext = transportContext2;
        this.name = str;
        this.payloadEncoding = encoding;
        this.transformer = transformer2;
        this.transportInternal = transportInternal2;
    }

    public void schedule(Event<T> event, TransportScheduleCallback transportScheduleCallback) {
        TransportInternal transportInternal2 = this.transportInternal;
        TransportContext transportContext2 = this.transportContext;
        if (transportContext2 == null) {
            throw new NullPointerException("Null transportContext");
        } else if (event != null) {
            String str = this.name;
            if (str != null) {
                Transformer<T, byte[]> transformer2 = this.transformer;
                if (transformer2 != null) {
                    Encoding encoding = this.payloadEncoding;
                    if (encoding != null) {
                        TransportRuntime transportRuntime = (TransportRuntime) transportInternal2;
                        Scheduler scheduler = transportRuntime.scheduler;
                        AutoValue_Event autoValue_Event = (AutoValue_Event) event;
                        Priority priority = autoValue_Event.priority;
                        Builder builder = TransportContext.builder();
                        AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) transportContext2;
                        builder.setBackendName(autoValue_TransportContext.backendName);
                        builder.setPriority(priority);
                        AutoValue_TransportContext.Builder builder2 = (AutoValue_TransportContext.Builder) builder;
                        builder2.extras = autoValue_TransportContext.extras;
                        TransportContext build = builder2.build();
                        EventInternal.Builder builder3 = EventInternal.builder();
                        builder3.setEventMillis(transportRuntime.eventClock.getTime());
                        builder3.setUptimeMillis(transportRuntime.uptimeClock.getTime());
                        builder3.setTransportName(str);
                        builder3.setEncodedPayload(new EncodedPayload(encoding, (byte[]) transformer2.apply(autoValue_Event.payload)));
                        AutoValue_EventInternal.Builder builder4 = (AutoValue_EventInternal.Builder) builder3;
                        builder4.code = autoValue_Event.code;
                        scheduler.schedule(build, builder4.build(), transportScheduleCallback);
                        return;
                    }
                    throw new NullPointerException("Null encoding");
                }
                throw new NullPointerException("Null transformer");
            }
            throw new NullPointerException("Null transportName");
        } else {
            throw new NullPointerException("Null event");
        }
    }
}
