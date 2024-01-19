package com.shield.android.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoTdscdma;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrength;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.mpl.androidapp.utils.Constant;
import com.netcore.android.SMTConfigConstants;
import com.razorpay.AnalyticsConstants;
import com.shield.android.e.g;
import com.shield.android.internal.f;
import com.shield.android.internal.j;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public class c extends f {

    /* renamed from: b  reason: collision with root package name */
    public final Context f1512b;

    public c(Context context) {
        this.f1512b = context;
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public final void a(Context context) {
        String str;
        String str2;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            b(context);
            String networkOperatorName = telephonyManager.getNetworkOperatorName();
            String str3 = "";
            if (networkOperatorName == null) {
                networkOperatorName = str3;
            }
            this.f1517a.put("CARRIER", networkOperatorName);
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (networkCountryIso == null) {
                networkCountryIso = str3;
            }
            this.f1517a.put("CARRIER_ISO_CODE", networkCountryIso);
            this.f1517a.put("GSM_CONNECTION", "disabled");
            String b2 = b((String) "gsm.operator.numeric");
            if (j.a((CharSequence) b2) || b2.length() <= 3) {
                str = str3;
                str2 = str;
            } else {
                str2 = b2.substring(0, 3).replace(",", str3);
                str = b2.substring(3).replace(",", str3);
            }
            if (str2 == null) {
                str2 = str3;
            }
            this.f1517a.put("CARRIER_COUNTRY_CODE", str2);
            if (str == null) {
                str = str3;
            }
            this.f1517a.put("CARRIER_NETWORK_CODE", str);
            String b3 = b((String) "gsm.sim.state");
            if (b3 == null) {
                b3 = str3;
            }
            this.f1517a.put("SIM_STATE", b3);
            String b4 = b((String) "gsm.operator.isroaming");
            if (b4 != null) {
                str3 = b4;
            }
            this.f1517a.put("IS_ROAMING", str3);
        } catch (Exception e2) {
            if (f.a("CARRIER EXCEPTION").f1677b && e2.getMessage() != null) {
                e2.getLocalizedMessage();
            }
        }
    }

    public final String b(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getDeclaredMethod(Constant.GET, new Class[]{String.class}).invoke(null, new Object[]{str});
        } catch (Exception unused) {
            return "";
        }
    }

    public final String c(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (VERSION.SDK_INT < 29) {
                return d(context);
            }
            ArrayList arrayList = new ArrayList();
            SignalStrength signalStrength = telephonyManager.getSignalStrength();
            if (signalStrength == null) {
                return "error";
            }
            for (CellSignalStrength dbm : signalStrength.getCellSignalStrengths()) {
                arrayList.add(String.valueOf(dbm.getDbm()));
            }
            return TextUtils.join(",", arrayList);
        } catch (Exception unused) {
            return "error";
        }
    }

    public final String d(Context context) throws SecurityException {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (!(context.checkCallingOrSelfPermission(SMTConfigConstants.LOCATION_PERMISSION_MF_KEY) == 0)) {
            return "disabled";
        }
        try {
            List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
            if (allCellInfo == null) {
                return "";
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < allCellInfo.size(); i++) {
                if (allCellInfo.get(i).isRegistered()) {
                    if (allCellInfo.get(i) instanceof CellInfoWcdma) {
                        arrayList.add(String.valueOf(((CellInfoWcdma) allCellInfo.get(i)).getCellSignalStrength().getDbm()));
                    } else if (allCellInfo.get(i) instanceof CellInfoGsm) {
                        arrayList.add(String.valueOf(((CellInfoGsm) allCellInfo.get(i)).getCellSignalStrength().getDbm()));
                    } else if (allCellInfo.get(i) instanceof CellInfoLte) {
                        arrayList.add(String.valueOf(((CellInfoLte) allCellInfo.get(i)).getCellSignalStrength().getDbm()));
                    } else if (allCellInfo.get(i) instanceof CellInfoCdma) {
                        arrayList.add(String.valueOf(((CellInfoCdma) allCellInfo.get(i)).getCellSignalStrength().getDbm()));
                    } else if (VERSION.SDK_INT >= 29 && (allCellInfo.get(i) instanceof CellInfoTdscdma)) {
                        arrayList.add(String.valueOf(((CellInfoTdscdma) allCellInfo.get(i)).getCellSignalStrength().getDbm()));
                    }
                }
            }
            return TextUtils.join(",", arrayList);
        } catch (Exception unused) {
            return "error";
        }
    }

    public final String e(Context context) {
        String str;
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService(AnalyticsConstants.WIFI);
            if (!(context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0)) {
                return "disabled";
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (!j.a((CharSequence) connectionInfo.getBSSID())) {
                if (!"00:00:00:00:00:00".equals(connectionInfo.getBSSID())) {
                    str = connectionInfo.getBSSID();
                    return str;
                }
            }
            str = "";
            return str;
        } catch (Exception unused) {
            return "error";
        }
    }

    public final String f(Context context) {
        String str = "error";
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService(AnalyticsConstants.WIFI);
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) {
                if (wifiManager.getConnectionInfo() != null) {
                    int ipAddress = wifiManager.getConnectionInfo().getIpAddress();
                    if (ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN)) {
                        ipAddress = Integer.reverseBytes(ipAddress);
                    }
                    try {
                        str = InetAddress.getByAddress(BigInteger.valueOf((long) ipAddress).toByteArray()).getHostAddress();
                    } catch (UnknownHostException unused) {
                    }
                    return str;
                }
            }
            return "disabled";
        } catch (Exception unused2) {
            return str;
        }
    }

    public final String g(Context context) {
        String str;
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService(AnalyticsConstants.WIFI);
            if (!(context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0)) {
                return "disabled";
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (!j.a((CharSequence) connectionInfo.getSSID())) {
                if (!"<unknown ssid>".equals(connectionInfo.getSSID())) {
                    str = connectionInfo.getSSID();
                    return str.replaceAll("\"", "");
                }
            }
            str = "";
            return str.replaceAll("\"", "");
        } catch (Exception unused) {
            return "error";
        }
    }

    public final void b(Context context) {
        String str;
        String str2 = "";
        if (VERSION.SDK_INT >= 23) {
            try {
                String host = ((ConnectivityManager) context.getSystemService("connectivity")).getDefaultProxy().getHost();
                if (host == null) {
                    host = str2;
                }
                this.f1517a.put("proxy_address", host);
            } catch (Exception unused) {
                this.f1517a.put("proxy_address", str2);
            }
        } else {
            try {
                str = System.getProperty("http.proxyHost");
            } catch (Exception unused2) {
                str = str2;
            }
            if (str == null) {
                str = str2;
            }
            try {
                this.f1517a.put("proxy_address", str);
            } catch (Exception unused3) {
                this.f1517a.put("proxy_address", str2);
            }
        }
        String str3 = g.f1583b;
        if (str3 != null) {
            str2 = str3;
        }
        this.f1517a.put("SERVER_CERTIFICATE_ISSUER", str2);
    }
}
