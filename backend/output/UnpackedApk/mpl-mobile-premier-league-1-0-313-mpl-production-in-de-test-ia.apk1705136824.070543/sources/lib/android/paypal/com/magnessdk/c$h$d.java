package lib.android.paypal.com.magnessdk;

public enum c$h$d {
    AUDIT_JSON_URL("https://c.paypal.com/r/v1/device/mg-audit"),
    DEVICE_INFO_URL("https://c.paypal.com/r/v1/device/client-metadata"),
    PRODUCTION_BEACON_URL("https://b.stats.paypal.com/counter.cgi"),
    PRODUCTION_JSON_URL("https://c.paypal.com/r/v1/device/mg"),
    RAMP_CONFIG_URL("https://www.paypalobjects.com/rdaAssets/magnes/magnes_android_rac.json"),
    REMOTE_CONFIG_URL("https://www.paypalobjects.com/rdaAssets/magnes/magnes_android_rec.json"),
    SANDBOX_DEVICE_INFO_URL("https://c.sandbox.paypal.com/r/v1/device/client-metadata"),
    SANDBOX_S_URL("https://c.sandbox.paypal.com/r/v1/device/s"),
    SENSOR_URL("https://c.paypal.com/r/v1/device/s"),
    STAGE_AUDIT_JSON_URL("https://www.stage2du13.stage.paypal.com/r/v1/device/mg-audit"),
    STAGE_PROD_JSON_URL("https://www.stage2du13.stage.paypal.com/r/v1/device/mg");
    
    public final String l;

    /* access modifiers changed from: public */
    c$h$d(String str) {
        this.l = str;
    }

    public String toString() {
        return this.l;
    }
}
