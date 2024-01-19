package com.cardinalcommerce.shared.cs.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.cardinalcommerce.shared.cs.utils.a;
import com.cardinalcommerce.shared.cs.utils.h;
import java.io.Serializable;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

public class l implements Serializable {
    public int A;
    public char[] B;
    public int C;

    /* renamed from: a  reason: collision with root package name */
    public char[] f2158a;

    /* renamed from: b  reason: collision with root package name */
    public char[] f2159b;

    /* renamed from: c  reason: collision with root package name */
    public char[] f2160c;

    /* renamed from: d  reason: collision with root package name */
    public char[] f2161d;

    /* renamed from: e  reason: collision with root package name */
    public int f2162e;

    /* renamed from: f  reason: collision with root package name */
    public char[] f2163f;
    public char[] g;
    public char[] h;
    public char[] i;
    public char[] j;
    public char[] k;
    public char[] l;
    public char[] m;
    public boolean n;
    public boolean o;
    public boolean p;
    public char[] q;
    public char[] r;
    public char[] s;
    public int t;
    public char[] u;
    public char[] v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public l(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            this.f2163f = h.a(telephonyManager.getDeviceId());
            this.g = h.a(telephonyManager.getSubscriberId());
            this.h = h.a(telephonyManager.getGroupIdLevel1());
            this.i = h.a(telephonyManager.getLine1Number());
            this.j = h.a(telephonyManager.getMmsUAProfUrl());
            this.k = h.a(telephonyManager.getMmsUserAgent());
            this.f2162e = telephonyManager.getNetworkType();
            this.l = h.a(telephonyManager.getNetworkOperator());
            this.m = h.a(telephonyManager.getNetworkOperatorName());
            this.q = h.a(telephonyManager.getSimCountryIso());
            this.r = h.a(telephonyManager.getSimOperator());
            this.s = h.a(telephonyManager.getSimOperatorName());
            this.f2159b = h.a(telephonyManager.getSimSerialNumber());
            this.t = telephonyManager.getSimState();
            this.u = h.a(telephonyManager.getVoiceMailAlphaTag());
            this.w = telephonyManager.hasIccCard();
            if (VERSION.SDK_INT >= 23) {
                this.A = telephonyManager.getPhoneCount();
                this.n = telephonyManager.isHearingAidCompatibilitySupported();
                this.o = telephonyManager.isTtyModeSupported();
                this.p = telephonyManager.isWorldPhone();
            }
            this.x = telephonyManager.isNetworkRoaming();
            this.y = telephonyManager.isSmsCapable();
            this.z = telephonyManager.isVoiceCapable();
            this.f2158a = h.a(telephonyManager.getDeviceSoftwareVersion());
            this.f2159b = h.a(telephonyManager.getSimSerialNumber());
            this.f2161d = h.a(telephonyManager.getNetworkCountryIso());
            this.v = h.a(telephonyManager.getVoiceMailNumber());
            this.f2160c = h.a(TimeZone.getDefault().getDisplayName());
            int phoneType = telephonyManager.getPhoneType();
            this.C = phoneType;
            if (phoneType == 0) {
                this.B = h.a((String) "PHONE_TYPE_NONE");
            } else if (phoneType == 1) {
                this.B = h.a((String) "PHONE_TYPE_GSM");
            } else if (phoneType == 2) {
                this.B = h.a((String) "CDMA");
            }
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("DeviceId", h.b(this.f2163f));
            jSONObject.putOpt("GroupIdentifierLevel1", h.b(this.h));
            jSONObject.putOpt("HasIccCard", Boolean.valueOf(this.w));
            jSONObject.putOpt("IMEINumber", h.b(this.f2158a));
            jSONObject.putOpt("IsHearingAidCompatibilitySupported", Boolean.valueOf(this.n));
            jSONObject.putOpt("IsNetworkRoaming", Boolean.valueOf(this.x));
            jSONObject.putOpt("IsSmsCapable", Boolean.valueOf(this.y));
            jSONObject.putOpt("IsTtySupported", Boolean.valueOf(this.o));
            jSONObject.putOpt("IsVoiceCapable", Boolean.valueOf(this.z));
            jSONObject.putOpt("IsWorldPhone", Boolean.valueOf(this.p));
            jSONObject.putOpt("Line1Number", h.b(this.i));
            jSONObject.putOpt("MmsUAProfUrl", h.b(this.j));
            jSONObject.putOpt("MmsUserAgent", h.b(this.k));
            jSONObject.putOpt("NetworkCountryISO", h.b(this.f2161d));
            jSONObject.putOpt("NetworkOperator", h.b(this.l));
            jSONObject.putOpt("NetworkOperatorName", h.b(this.m));
            jSONObject.putOpt("NetworkType", Integer.valueOf(this.f2162e));
            jSONObject.putOpt("PhoneCount", Integer.valueOf(this.A));
            jSONObject.putOpt("PhoneType", Integer.valueOf(this.C));
            jSONObject.putOpt("PhoneTypeString", h.b(this.B));
            jSONObject.putOpt("SimCountryISO", h.b(this.q));
            jSONObject.putOpt("SimOperator", h.b(this.r));
            jSONObject.putOpt("SimOperatorName", h.b(this.s));
            jSONObject.putOpt("SimSerialNumber", h.b(this.f2159b));
            jSONObject.putOpt("SimState", Integer.valueOf(this.t));
            jSONObject.putOpt("SubscriberId", h.b(this.g));
            jSONObject.putOpt("TimeZone", h.b(this.f2160c));
            jSONObject.putOpt("VoiceMailAlphaTag", h.b(this.u));
            jSONObject.putOpt("VoiceMailNumber", h.b(this.v));
        } catch (JSONException e2) {
            a.e().b(String.valueOf(13101), e2.getLocalizedMessage(), null);
        }
        return jSONObject;
    }
}
