package androidx.datastore.preferences;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite.DefaultInstanceBasedParser;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke;
import androidx.datastore.preferences.protobuf.Internal.ProtobufList;
import androidx.datastore.preferences.protobuf.Parser;
import androidx.datastore.preferences.protobuf.ProtobufArrayList;
import androidx.datastore.preferences.protobuf.RawMessageInfo;

public final class PreferencesProto$StringSet extends GeneratedMessageLite<PreferencesProto$StringSet, Builder> implements Object {
    public static final PreferencesProto$StringSet DEFAULT_INSTANCE;
    public static volatile Parser<PreferencesProto$StringSet> PARSER = null;
    public static final int STRINGS_FIELD_NUMBER = 1;
    public ProtobufList<String> strings_ = ProtobufArrayList.EMPTY_LIST;

    public static final class Builder extends androidx.datastore.preferences.protobuf.GeneratedMessageLite.Builder<PreferencesProto$StringSet, Builder> implements Object {
        public Builder() {
            super(PreferencesProto$StringSet.DEFAULT_INSTANCE);
        }

        public Builder(PreferencesProto$1 preferencesProto$1) {
            super(PreferencesProto$StringSet.DEFAULT_INSTANCE);
        }
    }

    static {
        PreferencesProto$StringSet preferencesProto$StringSet = new PreferencesProto$StringSet();
        DEFAULT_INSTANCE = preferencesProto$StringSet;
        GeneratedMessageLite.defaultInstanceMap.put(PreferencesProto$StringSet.class, preferencesProto$StringSet);
    }

    public final Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (methodToInvoke.ordinal()) {
            case 0:
                return Byte.valueOf(1);
            case 1:
                return null;
            case 2:
                return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
            case 3:
                return new PreferencesProto$StringSet();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<PreferencesProto$StringSet> parser = PARSER;
                if (parser == null) {
                    synchronized (PreferencesProto$StringSet.class) {
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
