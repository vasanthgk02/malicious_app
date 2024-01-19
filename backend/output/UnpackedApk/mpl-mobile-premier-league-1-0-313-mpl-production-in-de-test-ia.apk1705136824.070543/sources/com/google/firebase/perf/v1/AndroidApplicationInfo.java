package com.google.firebase.perf.v1;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite.MethodToInvoke;
import com.google.protobuf.Parser;
import com.google.protobuf.RawMessageInfo;

public final class AndroidApplicationInfo extends GeneratedMessageLite<AndroidApplicationInfo, Builder> implements Object {
    public static final AndroidApplicationInfo DEFAULT_INSTANCE;
    public static final int PACKAGE_NAME_FIELD_NUMBER = 1;
    public static volatile Parser<AndroidApplicationInfo> PARSER = null;
    public static final int SDK_VERSION_FIELD_NUMBER = 2;
    public static final int VERSION_NAME_FIELD_NUMBER = 3;
    public int bitField0_;
    public String packageName_ = "";
    public String sdkVersion_ = "";
    public String versionName_ = "";

    public static final class Builder extends com.google.protobuf.GeneratedMessageLite.Builder<AndroidApplicationInfo, Builder> implements Object {
        public Builder() {
            super(AndroidApplicationInfo.DEFAULT_INSTANCE);
        }

        public Builder(AnonymousClass1 r1) {
            super(AndroidApplicationInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        AndroidApplicationInfo androidApplicationInfo = new AndroidApplicationInfo();
        DEFAULT_INSTANCE = androidApplicationInfo;
        GeneratedMessageLite.defaultInstanceMap.put(AndroidApplicationInfo.class, androidApplicationInfo);
    }

    public static void access$100(AndroidApplicationInfo androidApplicationInfo, String str) {
        if (androidApplicationInfo != null) {
            str.getClass();
            androidApplicationInfo.bitField0_ |= 1;
            androidApplicationInfo.packageName_ = str;
            return;
        }
        throw null;
    }

    public static void access$400(AndroidApplicationInfo androidApplicationInfo, String str) {
        if (androidApplicationInfo != null) {
            str.getClass();
            androidApplicationInfo.bitField0_ |= 2;
            androidApplicationInfo.sdkVersion_ = str;
            return;
        }
        throw null;
    }

    public static void access$700(AndroidApplicationInfo androidApplicationInfo, String str) {
        if (androidApplicationInfo != null) {
            str.getClass();
            androidApplicationInfo.bitField0_ |= 4;
            androidApplicationInfo.versionName_ = str;
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
                return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002", new Object[]{"bitField0_", "packageName_", "sdkVersion_", "versionName_"});
            case 3:
                return new AndroidApplicationInfo();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<AndroidApplicationInfo> parser = PARSER;
                if (parser == null) {
                    synchronized (AndroidApplicationInfo.class) {
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
