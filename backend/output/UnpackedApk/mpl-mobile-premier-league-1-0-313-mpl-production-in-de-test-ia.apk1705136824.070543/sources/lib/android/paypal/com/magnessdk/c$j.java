package lib.android.paypal.com.magnessdk;

public enum c$j {
    CONF_VERSION("conf_version"),
    CONF_ENDPOINT_URL("endpoint_url"),
    CONF_REFRESH_TIME_KEY("conf_refresh_time_interval"),
    ANDROID_APPS_TO_CHECK("android_apps_to_check"),
    NOT_COLLECTABLE("nc"),
    MG_ID("m"),
    SENSOR_COLLECT_TIME("s");
    
    public final String h;

    /* access modifiers changed from: public */
    c$j(String str) {
        this.h = str;
    }

    public String toString() {
        return this.h;
    }
}
