package com.google.firebase.perf.v1;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite.MethodToInvoke;
import com.google.protobuf.IntArrayList;
import com.google.protobuf.Internal$ListAdapter$Converter;
import com.google.protobuf.Internal.IntList;
import com.google.protobuf.Parser;
import com.google.protobuf.RawMessageInfo;

public final class PerfSession extends GeneratedMessageLite<PerfSession, Builder> implements Object {
    public static final PerfSession DEFAULT_INSTANCE;
    public static volatile Parser<PerfSession> PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 1;
    public static final int SESSION_VERBOSITY_FIELD_NUMBER = 2;
    public static final Internal$ListAdapter$Converter<Integer, SessionVerbosity> sessionVerbosity_converter_ = new Internal$ListAdapter$Converter<Integer, SessionVerbosity>() {
    };
    public int bitField0_;
    public String sessionId_ = "";
    public IntList sessionVerbosity_ = IntArrayList.EMPTY_LIST;

    public static final class Builder extends com.google.protobuf.GeneratedMessageLite.Builder<PerfSession, Builder> implements Object {
        public Builder() {
            super(PerfSession.DEFAULT_INSTANCE);
        }

        public Builder(AnonymousClass1 r1) {
            super(PerfSession.DEFAULT_INSTANCE);
        }
    }

    static {
        PerfSession perfSession = new PerfSession();
        DEFAULT_INSTANCE = perfSession;
        GeneratedMessageLite.defaultInstanceMap.put(PerfSession.class, perfSession);
    }

    public static void access$100(PerfSession perfSession, String str) {
        if (perfSession != null) {
            str.getClass();
            perfSession.bitField0_ |= 1;
            perfSession.sessionId_ = str;
            return;
        }
        throw null;
    }

    public static void access$500(PerfSession perfSession, SessionVerbosity sessionVerbosity) {
        if (perfSession != null) {
            sessionVerbosity.getClass();
            IntList intList = perfSession.sessionVerbosity_;
            if (!intList.isModifiable()) {
                int size = intList.size();
                perfSession.sessionVerbosity_ = ((IntArrayList) intList).mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
            }
            ((IntArrayList) perfSession.sessionVerbosity_).addInt(sessionVerbosity.getNumber());
            return;
        }
        throw null;
    }

    public final Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (methodToInvoke.ordinal()) {
            case 0:
                return Byte.valueOf(1);
            case 1:
                return null;
            case 2:
                return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001e", new Object[]{"bitField0_", "sessionId_", "sessionVerbosity_", SessionVerbosity.internalGetVerifier()});
            case 3:
                return new PerfSession();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<PerfSession> parser = PARSER;
                if (parser == null) {
                    synchronized (PerfSession.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
