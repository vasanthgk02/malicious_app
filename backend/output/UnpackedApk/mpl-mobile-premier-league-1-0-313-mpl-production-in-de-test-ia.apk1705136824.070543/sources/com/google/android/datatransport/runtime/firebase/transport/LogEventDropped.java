package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.proto.ProtoEnum;

public final class LogEventDropped {
    public final long events_dropped_count_;
    public final Reason reason_;

    public static final class Builder {
        public long events_dropped_count_ = 0;
        public Reason reason_ = Reason.REASON_UNKNOWN;

        public LogEventDropped build() {
            return new LogEventDropped(this.events_dropped_count_, this.reason_);
        }
    }

    public enum Reason implements ProtoEnum {
        REASON_UNKNOWN(0),
        MESSAGE_TOO_OLD(1),
        CACHE_FULL(2),
        PAYLOAD_TOO_BIG(3),
        MAX_RETRIES_REACHED(4),
        INVALID_PAYLOD(5),
        SERVER_ERROR(6);
        
        public final int number_;

        /* access modifiers changed from: public */
        Reason(int i) {
            this.number_ = i;
        }

        public int getNumber() {
            return this.number_;
        }
    }

    static {
        Reason reason = Reason.REASON_UNKNOWN;
    }

    public LogEventDropped(long j, Reason reason) {
        this.events_dropped_count_ = j;
        this.reason_ = reason;
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
