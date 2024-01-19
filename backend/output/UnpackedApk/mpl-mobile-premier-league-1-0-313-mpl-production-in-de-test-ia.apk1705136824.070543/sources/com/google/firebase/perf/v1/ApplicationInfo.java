package com.google.firebase.perf.v1;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite.MethodToInvoke;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.RawMessageInfo;
import com.google.protobuf.WireFormat$FieldType;

public final class ApplicationInfo extends GeneratedMessageLite<ApplicationInfo, Builder> implements Object {
    public static final int ANDROID_APP_INFO_FIELD_NUMBER = 3;
    public static final int APPLICATION_PROCESS_STATE_FIELD_NUMBER = 5;
    public static final int APP_INSTANCE_ID_FIELD_NUMBER = 2;
    public static final int CUSTOM_ATTRIBUTES_FIELD_NUMBER = 6;
    public static final ApplicationInfo DEFAULT_INSTANCE;
    public static final int GOOGLE_APP_ID_FIELD_NUMBER = 1;
    public static volatile Parser<ApplicationInfo> PARSER;
    public AndroidApplicationInfo androidAppInfo_;
    public String appInstanceId_ = "";
    public int applicationProcessState_;
    public int bitField0_;
    public MapFieldLite<String, String> customAttributes_ = MapFieldLite.EMPTY_MAP_FIELD;
    public String googleAppId_ = "";

    public static final class Builder extends com.google.protobuf.GeneratedMessageLite.Builder<ApplicationInfo, Builder> implements Object {
        public Builder() {
            super(ApplicationInfo.DEFAULT_INSTANCE);
        }

        public Builder(AnonymousClass1 r1) {
            super(ApplicationInfo.DEFAULT_INSTANCE);
        }
    }

    public static final class CustomAttributesDefaultEntryHolder {
        public static final MapEntryLite<String, String> defaultEntry;

        static {
            WireFormat$FieldType wireFormat$FieldType = WireFormat$FieldType.STRING;
            defaultEntry = new MapEntryLite<>(wireFormat$FieldType, "", wireFormat$FieldType, "");
        }
    }

    static {
        ApplicationInfo applicationInfo = new ApplicationInfo();
        DEFAULT_INSTANCE = applicationInfo;
        GeneratedMessageLite.defaultInstanceMap.put(ApplicationInfo.class, applicationInfo);
    }

    public static void access$100(ApplicationInfo applicationInfo, String str) {
        if (applicationInfo != null) {
            str.getClass();
            applicationInfo.bitField0_ |= 1;
            applicationInfo.googleAppId_ = str;
            return;
        }
        throw null;
    }

    public static void access$1000(ApplicationInfo applicationInfo, ApplicationProcessState applicationProcessState) {
        if (applicationInfo != null) {
            applicationInfo.applicationProcessState_ = applicationProcessState.getNumber();
            applicationInfo.bitField0_ |= 8;
            return;
        }
        throw null;
    }

    public static void access$400(ApplicationInfo applicationInfo, String str) {
        if (applicationInfo != null) {
            str.getClass();
            applicationInfo.bitField0_ |= 2;
            applicationInfo.appInstanceId_ = str;
            return;
        }
        throw null;
    }

    public static void access$700(ApplicationInfo applicationInfo, AndroidApplicationInfo androidApplicationInfo) {
        if (applicationInfo != null) {
            androidApplicationInfo.getClass();
            applicationInfo.androidAppInfo_ = androidApplicationInfo;
            applicationInfo.bitField0_ |= 4;
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
                return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0006\u0005\u0001\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0005ဌ\u0003\u00062", new Object[]{"bitField0_", "googleAppId_", "appInstanceId_", "androidAppInfo_", "applicationProcessState_", ApplicationProcessState.internalGetVerifier(), "customAttributes_", CustomAttributesDefaultEntryHolder.defaultEntry});
            case 3:
                return new ApplicationInfo();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<ApplicationInfo> parser = PARSER;
                if (parser == null) {
                    synchronized (ApplicationInfo.class) {
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

    public boolean hasAppInstanceId() {
        return (this.bitField0_ & 2) != 0;
    }
}
