package com.cardinalcommerce.shared.cs.f;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import com.cardinalcommerce.shared.cs.utils.a;
import com.cardinalcommerce.shared.cs.utils.h;
import com.mpl.androidapp.utils.Constant.EventsConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d implements Serializable {
    public float A;
    public int B;
    public float C;
    public double D;
    public double E;
    public long G;

    /* renamed from: a  reason: collision with root package name */
    public char[] f2122a;

    /* renamed from: b  reason: collision with root package name */
    public char[] f2123b;

    /* renamed from: c  reason: collision with root package name */
    public char[] f2124c;

    /* renamed from: d  reason: collision with root package name */
    public char[] f2125d = h.a(Build.SERIAL);

    /* renamed from: e  reason: collision with root package name */
    public long f2126e;

    /* renamed from: f  reason: collision with root package name */
    public char[] f2127f;
    public int g;
    public char[] h;
    public char[] i;
    public char[] j;
    public char[] k;
    public char[] l;
    public char[] m;
    public char[] n;
    public char[] o;
    public char[] p;
    public char[] q;
    public char[] r;
    public char[] s;
    public char[] t;
    public char[] u;
    public char[] v;
    public char[] w;
    public char[] x;
    public char[] y;
    public char[] z;

    public d(Context context) {
        this.h = h.a(String.valueOf(context.getResources().getDisplayMetrics().densityDpi));
        this.g = (int) context.getResources().getDisplayMetrics().density;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Display defaultDisplay = windowManager != null ? windowManager.getDefaultDisplay() : null;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (defaultDisplay != null) {
            defaultDisplay.getMetrics(displayMetrics);
        }
        this.f2127f = h.a(displayMetrics.widthPixels + "*" + displayMetrics.heightPixels);
        this.i = h.a(Resources.getSystem().getConfiguration().locale.toString().replaceAll("_", Constants.ACCEPT_TIME_SEPARATOR_SERVER));
        this.j = null;
        if (ContextCompat.checkSelfPermission(context, "android.permission.BLUETOOTH") == 0) {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                this.k = h.a(defaultAdapter.getName());
            }
        } else {
            this.k = h.a((String) "N/A");
        }
        this.l = h.a(Build.BOARD);
        this.m = h.a(Build.BOOTLOADER);
        this.f2123b = h.a(Build.BRAND);
        this.n = h.a(Build.DEVICE);
        this.p = h.a(Build.DISPLAY);
        this.o = h.a(Build.FINGERPRINT);
        this.q = h.a(Build.HARDWARE);
        this.r = h.a(Build.ID);
        this.f2124c = h.a(Build.MANUFACTURER);
        this.s = h.a(Build.PRODUCT);
        this.t = h.a(Build.RADIO);
        this.u = h.a(Build.SERIAL);
        this.y = h.a(Arrays.toString(Build.SUPPORTED_32_BIT_ABIS));
        this.z = h.a(Arrays.toString(Build.SUPPORTED_64_BIT_ABIS));
        this.x = h.a(Build.TAGS);
        this.f2126e = Build.TIME;
        this.w = h.a(Build.TYPE);
        this.v = h.a(Build.USER);
        DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
        this.A = displayMetrics2.density;
        this.B = displayMetrics2.densityDpi;
        this.C = displayMetrics2.scaledDensity;
        this.D = (double) displayMetrics2.xdpi;
        this.E = (double) displayMetrics2.ydpi;
        this.f2122a = h.a(Build.MODEL);
        this.f2123b = h.a(Build.BRAND);
        this.f2124c = h.a(Build.MANUFACTURER);
        StatFs statFs = new StatFs(Environment.getRootDirectory().getPath());
        this.G = statFs.getTotalBytes();
        h.a(statFs.toString());
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("AdvertisingId", h.b(this.j));
            jSONObject.putOpt("Board", h.b(this.l));
            jSONObject.putOpt("BootLoader", h.b(this.m));
            jSONObject.putOpt("Brand", h.b(this.f2123b));
            jSONObject.putOpt("ColorDepth", h.b(this.h));
            jSONObject.putOpt("Density", Integer.valueOf(Integer.parseInt(String.valueOf(Math.round(this.A)))));
            jSONObject.putOpt("DensityDpi", Integer.valueOf(this.B));
            jSONObject.putOpt("Device", h.b(this.n));
            jSONObject.putOpt("DeviceName", h.b(this.k));
            jSONObject.putOpt(EventsConstants.PROP_PHONE_DISPLAY, h.b(this.p));
            jSONObject.putOpt("Fingerprint", h.b(this.o));
            jSONObject.putOpt("GetTotalBytes", Long.valueOf(this.G));
            jSONObject.putOpt("Hardware", h.b(this.q));
            jSONObject.putOpt("Id", h.b(this.r));
            jSONObject.putOpt("Locale", h.b(this.i));
            jSONObject.putOpt("Manufacturer", h.b(this.f2124c));
            jSONObject.putOpt("Model", h.b(this.f2122a));
            jSONObject.putOpt("Product", h.b(this.s));
            jSONObject.putOpt("Radio", h.b(this.t));
            jSONObject.putOpt("ScaledDensity", Float.valueOf(this.C));
            jSONObject.putOpt("ScreenDensity", Integer.valueOf(this.g));
            jSONObject.putOpt("ScreenResolution", h.b(this.f2127f));
            jSONObject.putOpt("Serial", h.b(this.u));
            jSONObject.putOpt("SerialNumber", h.b(this.f2125d));
            if (h.a(this.y)) {
                jSONObject.putOpt("Supported32BitAbis", new JSONArray(Collections.singletonList(h.b(this.y))));
            }
            if (h.a(this.z)) {
                jSONObject.putOpt("Supported64BitAbis", new JSONArray(Collections.singletonList(h.b(this.z))));
            }
            jSONObject.putOpt("Tags", h.b(this.x));
            jSONObject.putOpt("Time", String.valueOf(this.f2126e));
            jSONObject.putOpt("Type", h.b(this.w));
            jSONObject.putOpt("User", h.b(this.v));
            jSONObject.putOpt("Xdpi", Double.valueOf(this.D));
            jSONObject.putOpt("Ydpi", Double.valueOf(this.E));
        } catch (JSONException e2) {
            a.e().b(String.valueOf(13101), e2.getLocalizedMessage(), null);
        }
        return jSONObject;
    }
}
