package lib.android.paypal.com.magnessdk;

import com.mpl.androidapp.config.ConfigConstant;
import com.razorpay.AnalyticsConstants;
import com.rudderstack.android.sdk.core.ecomm.ECommerceParamNames;
import in.juspay.hypersdk.core.Labels.Device;

public enum c$e {
    BASE_STATION_ID("base_station_id"),
    BATTERY("battery"),
    BSSID("bssid"),
    BSSID_ARRAY("bssid_array"),
    C("c"),
    CDMA_NETWORK_ID("cdma_network_id"),
    CDMA_SYSTEM_ID("cdma_system_id"),
    CELL_ID("cell_id"),
    CONF_VERSION("conf_version"),
    CONN_TYPE("conn_type"),
    DC_ID("dc_id"),
    DEVICE_ID(ConfigConstant.DEVICE_ID),
    DEVICE_UPTIME("device_uptime"),
    DISK("disk"),
    DS("ds"),
    IP_ADDRESSES("ip_addresses"),
    IP_ADDRS("ip_addrs"),
    IS_DEV_MODE_ON("dmo"),
    KNOWN_APPS("known_apps"),
    LINKER_ID("linker_id"),
    LOCALE_COUNTRY("locale_country"),
    LOCALE_LANG("locale_lang"),
    LOCATION("location"),
    LOCATION_AREA_CODE("location_area_code"),
    MEMORY(Device.MEMORY),
    MG_ID("mg_id"),
    NETWORK_OPERATOR("network_operator"),
    PHONE_TYPE("phone_type"),
    PL("pl"),
    PROXY_SETTING("proxy_setting"),
    RISK_COMP_SESSION_ID("risk_comp_session_id"),
    ROAMING("roaming"),
    SCREEN("screen"),
    SERIAL_NUMBER("serial_number"),
    SIM_OPERATOR_NAME("sim_operator_name"),
    SIM_SERIAL_NUMBER("sim_serial_number"),
    SR("sr"),
    SSID("ssid"),
    SUBSCRIBER_ID("subscriber_id"),
    T("t"),
    TIMESTAMP("timestamp"),
    TZ("tz"),
    TZ_NAME("tz_name"),
    VPN_SETTING("VPN_setting");
    
    public final String S;

    public enum a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f6023a = null;

        /* renamed from: b  reason: collision with root package name */
        public static final a f6024b = null;

        /* renamed from: c  reason: collision with root package name */
        public static final a f6025c = null;

        /* renamed from: d  reason: collision with root package name */
        public static final a f6026d = null;

        /* renamed from: e  reason: collision with root package name */
        public static final a f6027e = null;

        /* renamed from: f  reason: collision with root package name */
        public static final a f6028f = null;
        public static final a g = null;
        public static final /* synthetic */ a[] i = null;
        public final String h;

        /* access modifiers changed from: public */
        static {
            f6023a = new a("CURRENT", 0, "current");
            f6024b = new a("LEVEL", 1, "level");
            f6025c = new a("METHOD", 2, AnalyticsConstants.METHOD);
            f6026d = new a("LOW_POWER", 3, "low_power");
            f6027e = new a("STATE", 4, "state");
            f6028f = new a("TEMP", 5, "temp");
            a aVar = new a("VOLTAGE", 6, "voltage");
            g = aVar;
            i = new a[]{f6023a, f6024b, f6025c, f6026d, f6027e, f6028f, aVar};
        }

        /* access modifiers changed from: public */
        a(String str, int i2, String str2) {
            this.h = str2;
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) i.clone();
        }

        public String toString() {
            return this.h;
        }
    }

    public enum b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f6029a = null;

        /* renamed from: b  reason: collision with root package name */
        public static final b f6030b = null;

        /* renamed from: c  reason: collision with root package name */
        public static final b f6031c = null;

        /* renamed from: e  reason: collision with root package name */
        public static final /* synthetic */ b[] f6032e = null;

        /* renamed from: d  reason: collision with root package name */
        public final String f6033d;

        /* access modifiers changed from: public */
        static {
            f6029a = new b("FREE_SD", 0, "free_sd");
            f6030b = new b("FREE_UD", 1, "free_ud");
            b bVar = new b("MOUNTED", 2, "mounted");
            f6031c = bVar;
            f6032e = new b[]{f6029a, f6030b, bVar};
        }

        /* access modifiers changed from: public */
        b(String str, int i, String str2) {
            this.f6033d = str2;
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f6032e.clone();
        }

        public String toString() {
            return this.f6033d;
        }
    }

    public enum c {

        /* renamed from: a  reason: collision with root package name */
        public static final c f6034a = null;

        /* renamed from: b  reason: collision with root package name */
        public static final c f6035b = null;

        /* renamed from: c  reason: collision with root package name */
        public static final c f6036c = null;

        /* renamed from: d  reason: collision with root package name */
        public static final c f6037d = null;

        /* renamed from: e  reason: collision with root package name */
        public static final c f6038e = null;
        public static final /* synthetic */ c[] g = null;

        /* renamed from: f  reason: collision with root package name */
        public final String f6039f;

        /* access modifiers changed from: public */
        static {
            f6034a = new c("FREE", 0, "free");
            f6035b = new c("FREE_RUNTIME", 1, "free_runtime");
            f6036c = new c("MAX_RUNTIME", 2, "max_runtime");
            f6037d = new c("TOTAL", 3, ECommerceParamNames.TOTAL);
            c cVar = new c("TOTAL_RUNTIME", 4, "total_runtime");
            f6038e = cVar;
            g = new c[]{f6034a, f6035b, f6036c, f6037d, cVar};
        }

        /* access modifiers changed from: public */
        c(String str, int i, String str2) {
            this.f6039f = str2;
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) g.clone();
        }

        public String toString() {
            return this.f6039f;
        }
    }

    /* access modifiers changed from: public */
    c$e(String str) {
        this.S = str;
    }

    public String toString() {
        return this.S;
    }
}
