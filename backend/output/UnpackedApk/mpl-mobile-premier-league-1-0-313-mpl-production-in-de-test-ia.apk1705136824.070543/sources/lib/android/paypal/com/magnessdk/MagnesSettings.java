package lib.android.paypal.com.magnessdk;

import android.content.Context;
import lib.android.paypal.com.magnessdk.network.base.MagnesNetworkingFactoryImpl;

public class MagnesSettings {
    public String appGuid;
    public Context context;
    public boolean disableBeacon = false;
    public boolean disableRemoteConfig = false;
    public boolean enableNetworkOnCallerThread;
    public Environment environment;
    public MagnesNetworkingFactoryImpl magnesNetworkingFactoryImpl;
    public int magnesSource = -1;
    public String notificationToken;

    public static class Builder {
        public String appGuid;
        public Context context;
        public boolean disableBeacon = false;
        public boolean disableRemoteConfig = false;
        public Environment environment = Environment.LIVE;
        public int sourceFlow = -1;

        public Builder(Context context2) {
            this.context = context2;
        }

        public MagnesSettings build() {
            return new MagnesSettings(this, null);
        }
    }

    public MagnesSettings(Builder builder, AnonymousClass1 r4) {
        this.magnesSource = builder.sourceFlow;
        this.appGuid = builder.appGuid;
        this.notificationToken = null;
        this.disableRemoteConfig = builder.disableRemoteConfig;
        this.disableBeacon = builder.disableBeacon;
        this.context = builder.context;
        this.magnesNetworkingFactoryImpl = null;
        this.enableNetworkOnCallerThread = false;
        this.environment = builder.environment;
    }

    public int getMagnesSource() {
        return this.magnesSource;
    }
}
