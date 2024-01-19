package com.cardinalcommerce.shared.cs.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import androidx.core.content.ContextCompat;
import com.cardinalcommerce.shared.cs.utils.a;
import com.razorpay.AnalyticsConstants;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import org.json.JSONException;
import org.json.JSONObject;

public class h implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    public char[] f2136c;

    /* renamed from: d  reason: collision with root package name */
    public char[] f2137d;

    /* renamed from: e  reason: collision with root package name */
    public char[] f2138e;

    /* renamed from: f  reason: collision with root package name */
    public int f2139f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public final a n = a.e();

    @SuppressLint({"HardwareIds"})
    public h(Context context) {
        String str;
        WifiInfo wifiInfo = null;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            loop0:
            while (true) {
                if (!networkInterfaces.hasMoreElements()) {
                    break;
                }
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress()) {
                            str = nextElement.getHostAddress();
                            break loop0;
                        }
                    }
                }
            }
        } catch (Exception e2) {
            this.n.b("IP Address", e2.toString(), null);
        }
        com.cardinalcommerce.shared.cs.utils.h.a(str);
        if (VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_WIFI_STATE") == 0) {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(AnalyticsConstants.WIFI);
            wifiInfo = wifiManager != null ? wifiManager.getConnectionInfo() : wifiInfo;
            if (wifiInfo != null) {
                this.f2137d = com.cardinalcommerce.shared.cs.utils.h.a(wifiInfo.getMacAddress());
                this.f2136c = com.cardinalcommerce.shared.cs.utils.h.a(wifiInfo.getBSSID());
                this.f2138e = com.cardinalcommerce.shared.cs.utils.h.a(wifiInfo.getSSID());
                this.f2139f = wifiInfo.getNetworkId();
                this.g = wifiManager.is5GHzBandSupported();
                this.h = wifiManager.isDeviceToApRttSupported();
                this.i = wifiManager.isEnhancedPowerReportingSupported();
                this.j = wifiManager.isP2pSupported();
                this.k = wifiManager.isPreferredNetworkOffloadSupported();
                this.l = wifiManager.isTdlsSupported();
                this.m = wifiManager.isScanAlwaysAvailable();
                return;
            }
            return;
        }
        str = null;
        com.cardinalcommerce.shared.cs.utils.h.a(str);
        if (VERSION.SDK_INT >= 23) {
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("Is5GHzBandSupport", Boolean.valueOf(this.g));
            jSONObject.putOpt("IsDeviceToApRttSupported", Boolean.valueOf(this.h));
            jSONObject.putOpt("IsEnhancedPowerReportingSupported", Boolean.valueOf(this.i));
            jSONObject.putOpt("IsP2pSupported", Boolean.valueOf(this.j));
            jSONObject.putOpt("IsPreferredNetworkOffloadSupported", Boolean.valueOf(this.k));
            jSONObject.putOpt("IsScanAlwaysAvailable", Boolean.valueOf(this.m));
            jSONObject.putOpt("IsTdlsSupported", Boolean.valueOf(this.l));
            jSONObject.putOpt("BSSID", com.cardinalcommerce.shared.cs.utils.h.b(this.f2136c));
            jSONObject.putOpt("NetworkID", Integer.valueOf(this.f2139f));
            jSONObject.putOpt("SSID", com.cardinalcommerce.shared.cs.utils.h.b(this.f2138e));
            jSONObject.putOpt("WifiMacAddress", com.cardinalcommerce.shared.cs.utils.h.b(this.f2137d));
        } catch (JSONException e2) {
            a.e().b(String.valueOf(13101), e2.getLocalizedMessage(), null);
        }
        return jSONObject;
    }
}
