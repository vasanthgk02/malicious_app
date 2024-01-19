package androidx.datastore.preferences;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite.DefaultInstanceBasedParser;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke;
import androidx.datastore.preferences.protobuf.Parser;
import androidx.datastore.preferences.protobuf.RawMessageInfo;

public final class PreferencesProto$Value extends GeneratedMessageLite<PreferencesProto$Value, Builder> implements Object {
    public static final int BOOLEAN_FIELD_NUMBER = 1;
    public static final PreferencesProto$Value DEFAULT_INSTANCE;
    public static final int DOUBLE_FIELD_NUMBER = 7;
    public static final int FLOAT_FIELD_NUMBER = 2;
    public static final int INTEGER_FIELD_NUMBER = 3;
    public static final int LONG_FIELD_NUMBER = 4;
    public static volatile Parser<PreferencesProto$Value> PARSER = null;
    public static final int STRING_FIELD_NUMBER = 5;
    public static final int STRING_SET_FIELD_NUMBER = 6;
    public int bitField0_;
    public int valueCase_ = 0;
    public Object value_;

    public static final class Builder extends androidx.datastore.preferences.protobuf.GeneratedMessageLite.Builder<PreferencesProto$Value, Builder> implements Object {
        public Builder() {
            super(PreferencesProto$Value.DEFAULT_INSTANCE);
        }

        public Builder(PreferencesProto$1 preferencesProto$1) {
            super(PreferencesProto$Value.DEFAULT_INSTANCE);
        }
    }

    public enum ValueCase {
        BOOLEAN(1),
        FLOAT(2),
        INTEGER(3),
        LONG(4),
        STRING(5),
        STRING_SET(6),
        DOUBLE(7),
        VALUE_NOT_SET(0);
        
        public final int value;

        /* access modifiers changed from: public */
        ValueCase(int i) {
            this.value = i;
        }

        public static ValueCase forNumber(int i) {
            switch (i) {
                case 0:
                    return VALUE_NOT_SET;
                case 1:
                    return BOOLEAN;
                case 2:
                    return FLOAT;
                case 3:
                    return INTEGER;
                case 4:
                    return LONG;
                case 5:
                    return STRING;
                case 6:
                    return STRING_SET;
                case 7:
                    return DOUBLE;
                default:
                    return null;
            }
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static ValueCase valueOf(int i) {
            return forNumber(i);
        }
    }

    static {
        PreferencesProto$Value preferencesProto$Value = new PreferencesProto$Value();
        DEFAULT_INSTANCE = preferencesProto$Value;
        GeneratedMessageLite.defaultInstanceMap.put(PreferencesProto$Value.class, preferencesProto$Value);
    }

    public static void access$1300(PreferencesProto$Value preferencesProto$Value, String str) {
        if (str != null) {
            preferencesProto$Value.valueCase_ = 5;
            preferencesProto$Value.value_ = str;
            return;
        }
        throw null;
    }

    public static void access$1700(PreferencesProto$Value preferencesProto$Value, androidx.datastore.preferences.PreferencesProto$StringSet.Builder builder) {
        if (preferencesProto$Value != null) {
            preferencesProto$Value.value_ = builder.build();
            preferencesProto$Value.valueCase_ = 6;
            return;
        }
        throw null;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public final Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (methodToInvoke.ordinal()) {
            case 0:
                return Byte.valueOf(1);
            case 1:
                return null;
            case 2:
                return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0007\u0001\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001:\u0000\u00024\u0000\u00037\u0000\u00045\u0000\u0005;\u0000\u0006<\u0000\u00073\u0000", new Object[]{"value_", "valueCase_", "bitField0_", PreferencesProto$StringSet.class});
            case 3:
                return new PreferencesProto$Value();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<PreferencesProto$Value> parser = PARSER;
                if (parser == null) {
                    synchronized (PreferencesProto$Value.class) {
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
