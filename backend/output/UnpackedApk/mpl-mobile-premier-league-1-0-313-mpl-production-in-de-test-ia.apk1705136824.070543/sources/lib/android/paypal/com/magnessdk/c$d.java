package lib.android.paypal.com.magnessdk;

import com.facebook.react.modules.statusbar.StatusBarModule;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.mpl.androidapp.imagepicker.HyperVergeKycCapture;
import com.mpl.androidapp.onesignal.OneSingnalConstant;
import com.netcore.android.SMTEventParamKeys;
import com.razorpay.AnalyticsConstants;

public enum c$d {
    ANDROID_ID("android_id"),
    APP_FIRST_INSTALL_TIME("app_first_install_time"),
    APP_GUID("app_guid"),
    APP_ID("app_id"),
    APP_LAST_UPDATE_TIME("app_last_update_time"),
    APP_VERSION("app_version"),
    COMP_VERSION("comp_version"),
    CONF_URL("conf_url"),
    CPU("cpu"),
    DEVICE_MODEL(OneSingnalConstant.TAG_DEVICE_MODEL),
    DEVICE_NAME("device_name"),
    DISK("disk"),
    EMULATOR_FLAGS("ef"),
    GSF_ID("gsf_id"),
    IN_TREATMENT("t"),
    IS_EMULATOR("is_emulator"),
    IS_ROOTED("is_rooted"),
    MAC_ADDRS("mac_addrs"),
    MAGNES_GUID("magnes_guid"),
    MAGNES_SOURCE("magnes_source"),
    NOT_COLLECTIBLE_LIST("nc"),
    NOTIF_TOKEN("notif_token"),
    OS_TYPE("os_type"),
    OS_VERSION("os_version"),
    PAYLOAD_TYPE("payload_type"),
    ROOTED_FLAGS("rf"),
    SCREEN("screen"),
    SENSOR_METADATA("smd"),
    SMS_ENABLED("sms_enabled"),
    SOURCE_APP_VERSION("source_app_version"),
    SYSTEM("system"),
    T("t"),
    TOTAL_STORAGE_SPACE("total_storage_space"),
    USER_AGENT(AnalyticsConstants.USER_AGENT);
    
    public final String I;

    public enum a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f5984a = null;

        /* renamed from: b  reason: collision with root package name */
        public static final a f5985b = null;

        /* renamed from: c  reason: collision with root package name */
        public static final a f5986c = null;

        /* renamed from: e  reason: collision with root package name */
        public static final /* synthetic */ a[] f5987e = null;

        /* renamed from: d  reason: collision with root package name */
        public final String f5988d;

        /* access modifiers changed from: public */
        static {
            f5984a = new a("CORES", 0, "cores");
            f5985b = new a("MAX_FREQUENCY", 1, "maxFreq");
            a aVar = new a("MIN_FREQUENCY", 2, "minFreq");
            f5986c = aVar;
            f5987e = new a[]{f5984a, f5985b, aVar};
        }

        /* access modifiers changed from: public */
        a(String str, int i, String str2) {
            this.f5988d = str2;
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f5987e.clone();
        }

        public String toString() {
            return this.f5988d;
        }
    }

    public enum b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f5989a = null;

        /* renamed from: b  reason: collision with root package name */
        public static final b f5990b = null;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ b[] f5991d = null;

        /* renamed from: c  reason: collision with root package name */
        public final String f5992c;

        /* access modifiers changed from: public */
        static {
            f5989a = new b("TOTAL_SD", 0, "total_sd");
            b bVar = new b("TOTAL_UD", 1, "total_ud");
            f5990b = bVar;
            f5991d = new b[]{f5989a, bVar};
        }

        /* access modifiers changed from: public */
        b(String str, int i, String str2) {
            this.f5992c = str2;
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f5991d.clone();
        }

        public String toString() {
            return this.f5992c;
        }
    }

    public enum c {

        /* renamed from: a  reason: collision with root package name */
        public static final c f5993a = null;

        /* renamed from: b  reason: collision with root package name */
        public static final c f5994b = null;

        /* renamed from: c  reason: collision with root package name */
        public static final c f5995c = null;

        /* renamed from: d  reason: collision with root package name */
        public static final c f5996d = null;

        /* renamed from: e  reason: collision with root package name */
        public static final c f5997e = null;

        /* renamed from: f  reason: collision with root package name */
        public static final c f5998f = null;
        public static final c g = null;
        public static final c h = null;
        public static final c i = null;
        public static final c j = null;
        public static final c k = null;
        public static final c l = null;
        public static final c m = null;
        public static final c n = null;
        public static final c o = null;
        public static final c p = null;
        public static final c q = null;
        public static final c r = null;
        public static final c s = null;
        public static final /* synthetic */ c[] u = null;
        public final String t;

        /* access modifiers changed from: public */
        static {
            f5993a = new c("ANDROID_SDK_BUILD_FOR_X86", 0, "Android SDK built for x86");
            f5994b = new c("ANDROID_X86", 1, "android_x86");
            f5995c = new c("ANDY", 2, "andy");
            f5996d = new c("ANDY_OS", 3, "AndyOS");
            f5997e = new c("ANDY_OSX", 4, "AndyOSX");
            f5998f = new c("DRIOD_4X", 5, "Driod4X");
            g = new c("DROID_4X", 6, "Droid4X");
            h = new c("GENERIC", 7, "generic");
            i = new c("GENERIC_X86", 8, "generic_x86");
            j = new c("GENY_MOTION", 9, "Genymotion");
            k = new c("GOLDFISH", 10, CommonUtils.GOLDFISH);
            l = new c("GOODLE_SDK", 11, "google_sdk");
            m = new c("SDK", 12, "sdk");
            n = new c("UNKNOWN", 13, "unknown");
            o = new c("VBOX_86", 14, "vbox86");
            p = new c("VBOX_86P", 15, "vbox86p");
            q = new c("RANCHU", 16, CommonUtils.RANCHU);
            r = new c("REMIXEMU", 17, "remixemu");
            c cVar = new c("TTVM_X86", 18, "ttVM_x86");
            s = cVar;
            u = new c[]{f5993a, f5994b, f5995c, f5996d, f5997e, f5998f, g, h, i, j, k, l, m, n, o, p, q, r, cVar};
        }

        /* access modifiers changed from: public */
        c(String str, int i2, String str2) {
            this.t = str2;
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) u.clone();
        }

        public String toString() {
            return this.t;
        }
    }

    public enum d {

        /* renamed from: a  reason: collision with root package name */
        public static final d f5999a = null;

        /* renamed from: b  reason: collision with root package name */
        public static final d f6000b = null;

        /* renamed from: c  reason: collision with root package name */
        public static final d f6001c = null;

        /* renamed from: d  reason: collision with root package name */
        public static final d f6002d = null;

        /* renamed from: e  reason: collision with root package name */
        public static final d f6003e = null;

        /* renamed from: f  reason: collision with root package name */
        public static final d f6004f = null;
        public static final d g = null;
        public static final /* synthetic */ d[] i = null;
        public final String h;

        /* access modifiers changed from: public */
        static {
            f5999a = new d("DENSITY", 0, AnalyticsConstants.DENSITY);
            f6000b = new d("DENSITY_DPI", 1, "densityDpi");
            f6001c = new d(StatusBarModule.HEIGHT_KEY, 2, "height");
            f6002d = new d("SCALE", 3, "scale");
            f6003e = new d("WIDTH", 4, "width");
            f6004f = new d("X_DPI", 5, "xdpi");
            d dVar = new d("Y_DPI", 6, "ydpi");
            g = dVar;
            i = new d[]{f5999a, f6000b, f6001c, f6002d, f6003e, f6004f, dVar};
        }

        /* access modifiers changed from: public */
        d(String str, int i2, String str2) {
            this.h = str2;
        }

        public static d valueOf(String str) {
            return (d) Enum.valueOf(d.class, str);
        }

        public static d[] values() {
            return (d[]) i.clone();
        }

        public String toString() {
            return this.h;
        }
    }

    public enum e {

        /* renamed from: a  reason: collision with root package name */
        public static final e f6005a = null;

        /* renamed from: b  reason: collision with root package name */
        public static final e f6006b = null;

        /* renamed from: c  reason: collision with root package name */
        public static final e f6007c = null;

        /* renamed from: d  reason: collision with root package name */
        public static final e f6008d = null;

        /* renamed from: e  reason: collision with root package name */
        public static final e f6009e = null;

        /* renamed from: f  reason: collision with root package name */
        public static final e f6010f = null;
        public static final e g = null;
        public static final /* synthetic */ e[] i = null;
        public final String h;

        /* access modifiers changed from: public */
        static {
            f6005a = new e("FIFO_MAX_EVENT_COUNT", 0, "mec");
            f6006b = new e("MAX_RANGE", 1, HyperVergeKycCapture.MR);
            f6007c = new e("NAME", 2, "n");
            f6008d = new e("POWER", 3, "pwr");
            f6009e = new e("RESOLUTION", 4, "re");
            f6010f = new e("VENDOR", 5, "v");
            e eVar = new e("VERSION", 6, "ver");
            g = eVar;
            i = new e[]{f6005a, f6006b, f6007c, f6008d, f6009e, f6010f, eVar};
        }

        /* access modifiers changed from: public */
        e(String str, int i2, String str2) {
            this.h = str2;
        }

        public static e valueOf(String str) {
            return (e) Enum.valueOf(e.class, str);
        }

        public static e[] values() {
            return (e[]) i.clone();
        }

        public String toString() {
            return this.h;
        }
    }

    public enum f {

        /* renamed from: a  reason: collision with root package name */
        public static final f f6011a = null;

        /* renamed from: b  reason: collision with root package name */
        public static final f f6012b = null;

        /* renamed from: c  reason: collision with root package name */
        public static final f f6013c = null;

        /* renamed from: d  reason: collision with root package name */
        public static final f f6014d = null;

        /* renamed from: e  reason: collision with root package name */
        public static final f f6015e = null;

        /* renamed from: f  reason: collision with root package name */
        public static final f f6016f = null;
        public static final f g = null;
        public static final f h = null;
        public static final f i = null;
        public static final f j = null;
        public static final f k = null;
        public static final f l = null;
        public static final /* synthetic */ f[] n = null;
        public final String m;

        /* access modifiers changed from: public */
        static {
            f6011a = new f("VERSION", 0, "version");
            f6012b = new f("BOARD", 1, "board");
            f6013c = new f("BOOTLOADER", 2, "bootloader");
            f6014d = new f("CPU_ABI1", 3, "cpu_abi1");
            f6015e = new f("DISPLAY", 4, "display");
            f6016f = new f("RADIO", 5, SMTEventParamKeys.SMT_RADIO);
            g = new f("FINGERPRINT", 6, "fingerprint");
            h = new f("HARDWARE", 7, "hardware");
            i = new f("MANUFACTURER", 8, "manufacturer");
            j = new f("PRODUCT", 9, "product");
            k = new f("TIME", 10, "time");
            f fVar = new f("SYSTEM_TYPE", 11, "system_type");
            l = fVar;
            n = new f[]{f6011a, f6012b, f6013c, f6014d, f6015e, f6016f, g, h, i, j, k, fVar};
        }

        /* access modifiers changed from: public */
        f(String str, int i2, String str2) {
            this.m = str2;
        }

        public static f valueOf(String str) {
            return (f) Enum.valueOf(f.class, str);
        }

        public static f[] values() {
            return (f[]) n.clone();
        }

        public String toString() {
            return this.m;
        }
    }

    /* access modifiers changed from: public */
    c$d(String str) {
        this.I = str;
    }

    public String toString() {
        return this.I;
    }
}
