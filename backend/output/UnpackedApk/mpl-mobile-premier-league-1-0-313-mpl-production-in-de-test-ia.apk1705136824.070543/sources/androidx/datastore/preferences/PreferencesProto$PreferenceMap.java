package androidx.datastore.preferences;

import androidx.datastore.preferences.protobuf.CodedInputStream.StreamDecoder;
import androidx.datastore.preferences.protobuf.ExtensionRegistryLite;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite.DefaultInstanceBasedParser;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke;
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.MapFieldLite;
import androidx.datastore.preferences.protobuf.Parser;
import androidx.datastore.preferences.protobuf.RawMessageInfo;
import androidx.datastore.preferences.protobuf.UninitializedMessageException;
import androidx.datastore.preferences.protobuf.WireFormat$FieldType;
import java.io.IOException;
import java.io.InputStream;

public final class PreferencesProto$PreferenceMap extends GeneratedMessageLite<PreferencesProto$PreferenceMap, Builder> implements Object {
    public static final PreferencesProto$PreferenceMap DEFAULT_INSTANCE;
    public static volatile Parser<PreferencesProto$PreferenceMap> PARSER = null;
    public static final int PREFERENCES_FIELD_NUMBER = 1;
    public MapFieldLite<String, PreferencesProto$Value> preferences_ = MapFieldLite.EMPTY_MAP_FIELD;

    public static final class Builder extends androidx.datastore.preferences.protobuf.GeneratedMessageLite.Builder<PreferencesProto$PreferenceMap, Builder> implements Object {
        public Builder() {
            super(PreferencesProto$PreferenceMap.DEFAULT_INSTANCE);
        }

        public Builder(PreferencesProto$1 preferencesProto$1) {
            super(PreferencesProto$PreferenceMap.DEFAULT_INSTANCE);
        }
    }

    public static final class PreferencesDefaultEntryHolder {
        public static final MapEntryLite<String, PreferencesProto$Value> defaultEntry = new MapEntryLite<>(WireFormat$FieldType.STRING, "", WireFormat$FieldType.MESSAGE, PreferencesProto$Value.DEFAULT_INSTANCE);
    }

    static {
        PreferencesProto$PreferenceMap preferencesProto$PreferenceMap = new PreferencesProto$PreferenceMap();
        DEFAULT_INSTANCE = preferencesProto$PreferenceMap;
        GeneratedMessageLite.defaultInstanceMap.put(PreferencesProto$PreferenceMap.class, preferencesProto$PreferenceMap);
    }

    public static PreferencesProto$PreferenceMap parseFrom(InputStream inputStream) throws IOException {
        GeneratedMessageLite parsePartialFrom = GeneratedMessageLite.parsePartialFrom(DEFAULT_INSTANCE, new StreamDecoder(inputStream, 4096, null), ExtensionRegistryLite.getEmptyRegistry());
        if (parsePartialFrom == null || parsePartialFrom.isInitialized()) {
            return (PreferencesProto$PreferenceMap) parsePartialFrom;
        }
        throw new InvalidProtocolBufferException(new UninitializedMessageException().getMessage());
    }

    public final Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (methodToInvoke.ordinal()) {
            case 0:
                return Byte.valueOf(1);
            case 1:
                return null;
            case 2:
                return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", PreferencesDefaultEntryHolder.defaultEntry});
            case 3:
                return new PreferencesProto$PreferenceMap();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<PreferencesProto$PreferenceMap> parser = PARSER;
                if (parser == null) {
                    synchronized (PreferencesProto$PreferenceMap.class) {
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
