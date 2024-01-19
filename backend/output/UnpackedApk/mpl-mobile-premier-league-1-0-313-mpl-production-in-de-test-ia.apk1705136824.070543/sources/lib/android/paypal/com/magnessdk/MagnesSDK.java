package lib.android.paypal.com.magnessdk;

import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.SMTConfigConstants;
import com.razorpay.AnalyticsConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import lib.android.paypal.com.magnessdk.MagnesSettings.Builder;
import lib.android.paypal.com.magnessdk.b.a;
import lib.android.paypal.com.magnessdk.network.b;
import lib.android.paypal.com.magnessdk.network.base.e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MagnesSDK {

    /* renamed from: d  reason: collision with root package name */
    public static MagnesSDK f5956d;

    /* renamed from: a  reason: collision with root package name */
    public e f5957a;

    /* renamed from: b  reason: collision with root package name */
    public MagnesSettings f5958b;

    /* renamed from: f  reason: collision with root package name */
    public Handler f5959f;
    public HandlerThread g;
    public h h;
    public d i;
    public k j;
    public l k;

    public MagnesSDK() {
        k kVar;
        l lVar;
        synchronized (k.class) {
            if (k.bx == null) {
                k.bx = new k();
            }
            kVar = k.bx;
        }
        this.j = kVar;
        synchronized (l.class) {
            if (l.bx == null) {
                l.bx = new l();
            }
            lVar = l.bx;
        }
        this.k = lVar;
    }

    public static synchronized MagnesSDK getInstance() {
        MagnesSDK magnesSDK;
        synchronized (MagnesSDK.class) {
            try {
                if (f5956d == null) {
                    f5956d = new MagnesSDK();
                }
                magnesSDK = f5956d;
            }
        }
        return magnesSDK;
    }

    public MagnesResult collectAndSubmit(Context context, String str, HashMap<String, String> hashMap) throws InvalidInputException {
        Class<i> cls;
        String str2;
        boolean z;
        String str3;
        String str4 = str;
        HashMap<String, String> hashMap2 = hashMap;
        Class<MagnesSDK> cls2 = MagnesSDK.class;
        StringBuilder outline80 = GeneratedOutlineSupport.outline80("SUBMIT method called with paypalClientMetaDataId : ", str4, " , Is pass in additionalData null? : ");
        outline80.append(Boolean.toString(hashMap2 == null));
        a.a(cls2, 0, outline80.toString());
        if (str4 == null || str.length() <= 32) {
            StringBuilder outline802 = GeneratedOutlineSupport.outline80("COLLECT method called with paypalClientMetaDataId : ", str4, " , Is pass in additionalData null? : ");
            outline802.append(Boolean.toString(hashMap2 == null));
            a.a(cls2, 0, outline802.toString());
            if (str4 == null || str.length() <= 32) {
                if (this.f5958b == null) {
                    a.a(cls2, 2, (String) "No MagnesSettings specified, using platform default.");
                    MagnesSettings build = new Builder(context).build();
                    this.f5958b = build;
                    setUp(build);
                }
                if (this.f5957a != null) {
                    if (e.o) {
                        a.a(cls2, 0, (String) "nc presents, collecting coreData.");
                        h hVar = new h();
                        this.h = hVar;
                        hVar.a(this.f5958b, this.i, this.f5957a);
                        e.o = false;
                    }
                    i iVar = new i(true);
                    MagnesSettings magnesSettings = this.f5958b;
                    d dVar = this.i;
                    e eVar = this.f5957a;
                    String str5 = this.h.bx;
                    Handler handler = this.f5959f;
                    Class<i> cls3 = i.class;
                    a.a(cls3, 0, (String) "collecting RiskBlobDynamicData");
                    iVar.cU = eVar;
                    Context context2 = magnesSettings.context;
                    iVar.cF = (TelephonyManager) context2.getSystemService("phone");
                    iVar.cG = (WifiManager) context2.getApplicationContext().getSystemService(AnalyticsConstants.WIFI);
                    iVar.cJ = (LocationManager) context2.getSystemService("location");
                    iVar.cH = (ConnectivityManager) context2.getSystemService("connectivity");
                    iVar.cI = (BatteryManager) context2.getSystemService("batterymanager");
                    iVar.cK = (PowerManager) context2.getSystemService("power");
                    iVar.cL = context2.getPackageManager();
                    iVar.ct = iVar.a(context2, (String) "android.permission.ACCESS_COARSE_LOCATION") || iVar.a(context2, (String) SMTConfigConstants.LOCATION_PERMISSION_MF_KEY);
                    iVar.cv = iVar.a(context2, (String) SMTConfigConstants.READ_STORAGE_PERMISSION_MF_KEY);
                    iVar.cw = iVar.a(context2, (String) SMTConfigConstants.WRITE_STORAGE_PERMISSION_MF_KEY);
                    iVar.cu = iVar.a(context2, (String) "android.permission.READ_PHONE_STATE");
                    iVar.cy = iVar.a(context2, (String) "android.permission.ACCESS_NETWORK_STATE");
                    iVar.cx = iVar.a(context2, (String) "android.permission.ACCESS_WIFI_STATE");
                    iVar.cA = hashMap2;
                    iVar.f6105co = System.currentTimeMillis();
                    iVar.cf = eVar.k.optString(c$j.CONF_VERSION.toString());
                    iVar.bO = str4;
                    iVar.ck = str5;
                    if (str4 == null) {
                        iVar.bO = f.a(false);
                    }
                    TelephonyManager telephonyManager = iVar.cF;
                    if (telephonyManager != null) {
                        int phoneType = telephonyManager.getPhoneType();
                        if (phoneType == 0) {
                            str3 = "none";
                        } else if (phoneType == 1) {
                            iVar.ca = "gsm";
                            iVar.cD = iVar.ct ? (GsmCellLocation) f.a((Object) telephonyManager.getCellLocation(), GsmCellLocation.class) : null;
                        } else if (phoneType != 2) {
                            StringBuilder outline73 = GeneratedOutlineSupport.outline73("unknown (");
                            outline73.append(telephonyManager.getPhoneType());
                            outline73.append(")");
                            str3 = outline73.toString();
                        } else {
                            iVar.ca = "cdma";
                            try {
                                iVar.cE = iVar.ct ? (CdmaCellLocation) f.a((Object) telephonyManager.getCellLocation(), CdmaCellLocation.class) : null;
                            } catch (Exception e2) {
                                a.a(cls3, 3, (Throwable) e2);
                            }
                        }
                        iVar.ca = str3;
                    }
                    WifiManager wifiManager = iVar.cG;
                    if (wifiManager != null) {
                        iVar.cC = iVar.cx ? wifiManager.getConnectionInfo() : null;
                    }
                    ConnectivityManager connectivityManager = iVar.cH;
                    if (connectivityManager != null) {
                        iVar.cB = iVar.cy ? connectivityManager.getActiveNetworkInfo() : null;
                    }
                    if (VERSION.SDK_INT >= 29) {
                        if (!iVar.a(context2, (String) "android.permission.READ_PRIVILEGED_PHONE_STATE")) {
                            TelephonyManager telephonyManager2 = iVar.cF;
                            if (telephonyManager2 == null || !telephonyManager2.hasCarrierPrivileges()) {
                                z = false;
                                iVar.cs = z;
                            }
                        }
                        z = true;
                        iVar.cs = z;
                    }
                    j jVar = iVar.cV;
                    jVar.bC = handler;
                    jVar.bA = eVar;
                    jVar.bD = magnesSettings;
                    jVar.bB = new JSONArray();
                    iVar.a(82, magnesSettings);
                    iVar.a(81, magnesSettings);
                    iVar.a(16, magnesSettings);
                    iVar.a(21, magnesSettings);
                    iVar.a(75, magnesSettings);
                    iVar.a(23, magnesSettings);
                    iVar.a(27, magnesSettings);
                    iVar.a(28, magnesSettings);
                    iVar.a(25, magnesSettings);
                    iVar.a(56, magnesSettings);
                    iVar.a(72, magnesSettings);
                    iVar.a(42, magnesSettings);
                    iVar.a(43, magnesSettings);
                    iVar.a(45, magnesSettings);
                    iVar.a(53, magnesSettings);
                    iVar.a(80, magnesSettings);
                    iVar.a(71, magnesSettings);
                    iVar.a(4, magnesSettings);
                    iVar.a(57, magnesSettings);
                    iVar.a(58, magnesSettings);
                    iVar.a(6, magnesSettings);
                    iVar.a(30, magnesSettings);
                    iVar.a(29, magnesSettings);
                    iVar.a(13, magnesSettings);
                    iVar.a(68, magnesSettings);
                    iVar.a(49, magnesSettings);
                    iVar.a(84, magnesSettings);
                    iVar.a(5, magnesSettings);
                    iVar.a(48, magnesSettings);
                    iVar.a(11, magnesSettings);
                    iVar.a(85, magnesSettings);
                    iVar.a(46, magnesSettings);
                    iVar.a(79, magnesSettings);
                    iVar.a(87, magnesSettings);
                    iVar.a(98, magnesSettings);
                    iVar.a(99, magnesSettings);
                    g.bj = false;
                    if (iVar.cT) {
                        cls = cls3;
                        if (iVar.a(dVar, magnesSettings.magnesSource, g.bk, "s", magnesSettings.context)) {
                            j jVar2 = iVar.cV;
                            String str6 = iVar.bO;
                            JSONObject jSONObject = iVar.cR;
                            jVar2.by = str6;
                            jVar2.bz = jSONObject;
                            jVar2.a(96, magnesSettings);
                            jVar2.a(97, magnesSettings);
                            jVar2.a(102, magnesSettings);
                            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
                            newSingleThreadScheduledExecutor.schedule(new Runnable(jSONObject) {

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ JSONObject f6106a;

                                {
                                    this.f6106a = r2;
                                }

                                public void run() {
                                    JSONObject jSONObject;
                                    if (j.this.bE != null && this.f6106a.optBoolean(c$l.AC.toString(), false)) {
                                        j jVar = j.this;
                                        jVar.bB.put(jVar.bE.a_());
                                    }
                                    if (j.this.bF != null && this.f6106a.optBoolean(c$l.GY.toString(), false)) {
                                        j jVar2 = j.this;
                                        jVar2.bB.put(jVar2.bF.a_());
                                    }
                                    if (j.this.bG != null && this.f6106a.optBoolean(c$l.MG.toString(), false)) {
                                        j jVar3 = j.this;
                                        jVar3.bB.put(jVar3.bG.a_());
                                    }
                                    j jVar4 = j.this;
                                    if (jVar4 != null) {
                                        try {
                                            MagnesSDK instance = MagnesSDK.getInstance();
                                            if (instance.i == null) {
                                                instance.i = new d(instance.f5958b, instance.f5959f);
                                            }
                                            JSONObject optJSONObject = instance.i.h.optJSONObject("s");
                                            boolean z = optJSONObject != null && optJSONObject.optInt(c$i.RAMP_THRESHOLD.toString(), 0) < 0;
                                            if (z) {
                                                jSONObject = g.b(jVar4.by, jVar4.bB, "s");
                                            } else {
                                                String str = jVar4.by;
                                                JSONArray jSONArray = jVar4.bB;
                                                JSONObject jSONObject2 = new JSONObject();
                                                jSONObject2.put("pairing_id", str);
                                                jSONObject2.put("s", jSONArray);
                                                jSONObject = jSONObject2;
                                            }
                                            b bVar = new b(c$h$d.PRODUCTION_JSON_URL, jSONObject, z, jVar4.bD, jVar4.bC);
                                            if (bVar.f6123f.enableNetworkOnCallerThread) {
                                                bVar.b();
                                            } else {
                                                bVar.d();
                                            }
                                        } catch (Exception e2) {
                                            a.a(j.class, 3, (Throwable) e2);
                                        }
                                    } else {
                                        throw null;
                                    }
                                }
                            }, (long) jVar2.bA.k.optInt(c$j.SENSOR_COLLECT_TIME.toString(), 5), TimeUnit.SECONDS);
                            newSingleThreadScheduledExecutor.shutdown();
                        }
                    } else {
                        cls = cls3;
                    }
                    if (iVar.a(dVar, magnesSettings.magnesSource, g.bk, "hw", magnesSettings.context)) {
                        iVar.a(89, magnesSettings);
                        iVar.a(92, magnesSettings);
                        iVar.a(93, magnesSettings);
                        iVar.a(91, magnesSettings);
                    }
                    a.a(cls, 0, (String) "finishing RiskBlobDynamicData");
                    JSONObject a2 = iVar.a();
                    JSONObject a3 = this.h.a();
                    Iterator<String> keys = a2.keys();
                    while (keys.hasNext()) {
                        try {
                            String next = keys.next();
                            Object opt = a3.opt(next);
                            if (opt == null || !(opt instanceof JSONObject)) {
                                opt = a2.get(next);
                            } else {
                                JSONObject jSONObject2 = a2.getJSONObject(next);
                                Iterator<String> keys2 = jSONObject2.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    ((JSONObject) opt).put(next2, jSONObject2.get(next2));
                                }
                            }
                            a3.put(next, opt);
                        } catch (JSONException e3) {
                            a.a(h.class, 3, (Throwable) e3);
                        }
                    }
                    try {
                        Class<?> cls4 = getClass();
                        a.a(cls4, 0, "Device Info JSONObject : " + a3.toString(2));
                        str2 = a3.getString("pairing_id");
                    } catch (JSONException e4) {
                        a.a(cls2, 3, (Throwable) e4);
                        str2 = null;
                    }
                    MagnesResult magnesResult = new MagnesResult();
                    magnesResult.deviceInfo = a3;
                    magnesResult.paypalclientmetadataid = str2;
                    b bVar = new b(c$h$d.DEVICE_INFO_URL, a3, false, this.f5958b, this.f5959f);
                    if (bVar.f6123f.enableNetworkOnCallerThread) {
                        bVar.b();
                    } else {
                        bVar.d();
                    }
                    MagnesSettings magnesSettings2 = this.f5958b;
                    if (!magnesSettings2.disableBeacon && magnesSettings2.environment == Environment.LIVE) {
                        new lib.android.paypal.com.magnessdk.network.a(c$h$d.PRODUCTION_BEACON_URL, this.f5958b, this.f5959f, a3).a();
                    }
                    return magnesResult;
                }
                throw null;
            }
            throw new InvalidInputException(c$b$b.CMID_EXCEPTION_MESSAGE.toString());
        }
        throw new InvalidInputException(c$b$b.CMID_EXCEPTION_MESSAGE.toString());
    }

    public MagnesSettings setUp(MagnesSettings magnesSettings) {
        this.f5958b = magnesSettings;
        if (this.g == null) {
            HandlerThread handlerThread = new HandlerThread("MagnesHandlerThread");
            this.g = handlerThread;
            handlerThread.start();
            this.f5959f = e.a(this.g.getLooper(), this);
        }
        this.f5957a = new e(magnesSettings, this.f5959f);
        this.i = new d(magnesSettings, this.f5959f);
        if (this.j == null) {
            throw null;
        } else if (this.k != null) {
            if (this.h == null) {
                h hVar = new h();
                this.h = hVar;
                hVar.a(magnesSettings, this.i, this.f5957a);
            }
            return magnesSettings;
        } else {
            throw null;
        }
    }
}
