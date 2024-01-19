package com.mpl.androidapp.deviceinfo;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.utils.MLogger;
import java.lang.reflect.Method;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public final class TelephonyInfo {
    public static final String TAG = "TelephonyInfo";
    public static final String[] deviceIdMethodNames = {"getDeviceIdGemini", "getDeviceId", "getDeviceIdDs", "getDefault"};
    public static final String[] simStatusMethodNames = {"getSimStateGemini", "getSimState"};
    public String imeiSIM1;
    public String imeiSIM2;
    public boolean isSIM1Ready;
    public boolean isSIM2Ready;

    public static class GeminiMethodNotFoundException extends Exception {
        public static final long serialVersionUID = -996812356902545308L;

        public GeminiMethodNotFoundException(String str) {
            super(str);
        }
    }

    public static String getDeviceIdBySlot(TelephonyManager telephonyManager, String str, int i) throws GeminiMethodNotFoundException {
        try {
            Object invoke = Class.forName(telephonyManager.getClass().getName()).getMethod(str, new Class[]{Integer.TYPE}).invoke(telephonyManager, new Object[]{Integer.valueOf(i)});
            if (invoke != null) {
                return invoke.toString();
            }
            return null;
        } catch (Exception e2) {
            MLogger.e(TAG, "", e2);
            throw new GeminiMethodNotFoundException(str);
        }
    }

    public static TelephonyInfo getInstance(TelephonyManager telephonyManager) {
        TelephonyInfo telephonyInfo = new TelephonyInfo();
        telephonyInfo.imeiSIM1 = "";
        telephonyInfo.imeiSIM2 = "";
        for (String str : deviceIdMethodNames) {
            try {
                telephonyInfo.imeiSIM1 = getDeviceIdBySlot(telephonyManager, str, 0);
                telephonyInfo.imeiSIM2 = getDeviceIdBySlot(telephonyManager, str, 1);
            } catch (GeminiMethodNotFoundException unused) {
            }
        }
        telephonyInfo.isSIM1Ready = false;
        telephonyInfo.isSIM2Ready = false;
        for (String str2 : simStatusMethodNames) {
            try {
                telephonyInfo.isSIM1Ready = getSIMStateBySlot(telephonyManager, str2, 0);
                telephonyInfo.isSIM2Ready = getSIMStateBySlot(telephonyManager, str2, 1);
            } catch (GeminiMethodNotFoundException unused2) {
            }
        }
        return telephonyInfo;
    }

    public static boolean getSIMStateBySlot(TelephonyManager telephonyManager, String str, int i) throws GeminiMethodNotFoundException {
        try {
            Object invoke = Class.forName(telephonyManager.getClass().getName()).getMethod(str, new Class[]{Integer.TYPE}).invoke(telephonyManager, new Object[]{Integer.valueOf(i)});
            if (invoke == null || Integer.parseInt(invoke.toString()) != 5) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            MLogger.e(TAG, "", e2);
            throw new GeminiMethodNotFoundException(str);
        }
    }

    public static void printTelephonyManagerMethodNamesForThisDevice(Context context) {
        try {
            for (Method method : Class.forName(((TelephonyManager) context.getSystemService("phone")).getClass().getName()).getMethods()) {
                System.out.println("\n" + method + " declared by " + method.getDeclaringClass());
            }
        } catch (ClassNotFoundException e2) {
            MLogger.e(TAG, "", e2);
        }
    }

    public String getImsiSIM1() {
        return this.imeiSIM1;
    }

    public String getImsiSIM2() {
        return this.imeiSIM2;
    }

    public boolean isDualSIM() {
        return this.imeiSIM2 != null;
    }

    public boolean isSIM1Ready() {
        return this.isSIM1Ready;
    }

    public boolean isSIM2Ready() {
        return this.isSIM2Ready;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("TelephonyInfo{imeiSIM1='");
        GeneratedOutlineSupport.outline99(outline73, this.imeiSIM1, ExtendedMessageFormat.QUOTE, ", imeiSIM2='");
        GeneratedOutlineSupport.outline99(outline73, this.imeiSIM2, ExtendedMessageFormat.QUOTE, ", isSIM1Ready=");
        outline73.append(this.isSIM1Ready);
        outline73.append(", isSIM2Ready=");
        return GeneratedOutlineSupport.outline65(outline73, this.isSIM2Ready, '}');
    }
}
