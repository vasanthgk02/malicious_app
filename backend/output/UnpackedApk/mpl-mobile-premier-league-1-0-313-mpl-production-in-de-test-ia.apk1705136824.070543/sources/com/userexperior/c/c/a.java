package com.userexperior.c.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.WindowManager;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.razorpay.AnalyticsConstants;
import com.userexperior.a.a.a.c;
import com.userexperior.utilities.b;
import com.userexperior.utilities.l;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import org.apache.fontbox.cmap.CMapParser;

public class a implements Parcelable {
    public static final Creator<a> CREATOR = new Creator<a>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new a(parcel, 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new a[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public static final String f3875a = a.class.getSimpleName();
    @c(a = "manufacturer")

    /* renamed from: b  reason: collision with root package name */
    public final String f3876b;
    @c(a = "model")

    /* renamed from: c  reason: collision with root package name */
    public final String f3877c;
    @c(a = "apiLevel")

    /* renamed from: d  reason: collision with root package name */
    public final String f3878d;
    @c(a = "osVersion")

    /* renamed from: e  reason: collision with root package name */
    public final String f3879e;
    @c(a = "deviceId")

    /* renamed from: f  reason: collision with root package name */
    public String f3880f;
    @c(a = "width")
    public int g;
    @c(a = "height")
    public int h;
    @c(a = "ueSDKVersion")
    public String i;
    @c(a = "appVersion")
    public String j;
    @c(a = "networkOperator")
    public String k;
    @c(a = "networkType")
    public String l;
    @c(a = "tIntM")
    public String m;
    @c(a = "aIntM")
    public String n;
    @c(a = "tRAM")
    public String o;
    @c(a = "aRAM")
    public String p;
    @c(a = "city")
    public String q;
    @c(a = "state")
    public String r;
    @c(a = "country")
    public String s;
    @c(a = "platform")
    public int t;
    @c(a = "rv")
    public String u;
    @c(a = "fw")
    public String v;
    @c(a = "sv")
    public String w;

    /* JADX WARNING: Removed duplicated region for block: B:11:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00fe  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a() {
        /*
            r12 = this;
            java.lang.String r0 = "ex : DI - sdlp "
            r12.<init>()
            java.lang.String r1 = "1.5.2"
            r12.u = r1
            java.lang.String r1 = "an"
            r12.v = r1
            java.lang.String r1 = android.os.Build.MANUFACTURER
            r12.f3876b = r1
            java.lang.String r1 = android.os.Build.MODEL
            r12.f3877c = r1
            int r1 = android.os.Build.VERSION.SDK_INT
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r12.f3878d = r1
            java.lang.String r1 = android.os.Build.VERSION.RELEASE
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r12.f3879e = r1
            java.lang.String r1 = r12.i
            r12.i = r1
            java.lang.String r1 = b()
            r12.j = r1
            java.lang.String r1 = c()
            r12.l = r1
            java.lang.String r2 = "WiFi"
            r3 = 0
            if (r1 == 0) goto L_0x0042
            boolean r1 = r1.equalsIgnoreCase(r2)
            if (r1 == 0) goto L_0x0042
        L_0x0040:
            r1 = r3
            goto L_0x0061
        L_0x0042:
            android.content.Context r1 = com.userexperior.utilities.a.a()
            java.lang.String r4 = "phone"
            java.lang.Object r1 = r1.getSystemService(r4)
            android.telephony.TelephonyManager r1 = (android.telephony.TelephonyManager) r1
            c()
            java.lang.String r4 = c()
            boolean r2 = r4.equalsIgnoreCase(r2)
            if (r2 != 0) goto L_0x0040
            if (r1 == 0) goto L_0x0040
            java.lang.String r1 = r1.getNetworkOperatorName()
        L_0x0061:
            r12.k = r1
            int r1 = r12.g
            r12.g = r1
            int r1 = r12.h
            r12.h = r1
            int r1 = r12.t
            r12.t = r1
            java.io.File r1 = new java.io.File
            android.content.Context r2 = com.userexperior.utilities.a.a()
            java.io.File r2 = r2.getFilesDir()
            java.io.File r2 = r2.getAbsoluteFile()
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            long r1 = r1.getTotalSpace()
            java.lang.String r1 = a(r1)
            r12.m = r1
            java.io.File r1 = new java.io.File
            android.content.Context r2 = com.userexperior.utilities.a.a()
            java.io.File r2 = r2.getFilesDir()
            java.io.File r2 = r2.getAbsoluteFile()
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            long r1 = r1.getUsableSpace()
            java.lang.String r1 = a(r1)
            r12.n = r1
            android.content.Context r1 = com.userexperior.utilities.a.a()
            java.lang.String r2 = "activity"
            java.lang.Object r1 = r1.getSystemService(r2)
            android.app.ActivityManager r1 = (android.app.ActivityManager) r1
            android.app.ActivityManager$MemoryInfo r4 = new android.app.ActivityManager$MemoryInfo
            r4.<init>()
            r5 = 0
            if (r1 == 0) goto L_0x00c8
            r1.getMemoryInfo(r4)
            long r7 = r4.totalMem
            goto L_0x00c9
        L_0x00c8:
            r7 = r5
        L_0x00c9:
            java.lang.String r1 = a(r7)
            r12.o = r1
            android.content.Context r1 = com.userexperior.utilities.a.a()
            java.lang.Object r1 = r1.getSystemService(r2)
            android.app.ActivityManager r1 = (android.app.ActivityManager) r1
            android.app.ActivityManager$MemoryInfo r2 = new android.app.ActivityManager$MemoryInfo
            r2.<init>()
            if (r1 == 0) goto L_0x00e5
            r1.getMemoryInfo(r2)
            long r5 = r2.availMem
        L_0x00e5:
            java.lang.String r1 = a(r5)
            r12.p = r1
            android.content.Context r1 = com.userexperior.utilities.a.a()
            java.lang.String r2 = "UserExperior"
            r4 = 0
            android.content.SharedPreferences r5 = r1.getSharedPreferences(r2, r4)
            java.lang.String r6 = "latitudeLongitude"
            java.lang.String r3 = r5.getString(r6, r3)
            if (r3 == 0) goto L_0x0187
            java.lang.String r5 = " "
            java.lang.String[] r3 = r3.split(r5)
            r5 = r3[r4]
            java.lang.Double r5 = java.lang.Double.valueOf(r5)
            double r7 = r5.doubleValue()
            r5 = 1
            r3 = r3[r5]
            java.lang.Double r3 = java.lang.Double.valueOf(r3)
            double r9 = r3.doubleValue()
            android.location.Geocoder r6 = new android.location.Geocoder
            java.util.Locale r3 = java.util.Locale.getDefault()
            r6.<init>(r1, r3)
            r11 = 1
            java.util.List r1 = r6.getFromLocation(r7, r9, r11)     // Catch:{ IOException -> 0x016e, Exception -> 0x0154 }
            if (r1 == 0) goto L_0x0187
            boolean r3 = r1.isEmpty()     // Catch:{ IOException -> 0x016e, Exception -> 0x0154 }
            if (r3 != 0) goto L_0x0187
            java.lang.Object r3 = r1.get(r4)     // Catch:{ IOException -> 0x016e, Exception -> 0x0154 }
            android.location.Address r3 = (android.location.Address) r3     // Catch:{ IOException -> 0x016e, Exception -> 0x0154 }
            java.lang.String r3 = r3.getLocality()     // Catch:{ IOException -> 0x016e, Exception -> 0x0154 }
            java.lang.Object r5 = r1.get(r4)     // Catch:{ IOException -> 0x016e, Exception -> 0x0154 }
            android.location.Address r5 = (android.location.Address) r5     // Catch:{ IOException -> 0x016e, Exception -> 0x0154 }
            java.lang.String r5 = r5.getAdminArea()     // Catch:{ IOException -> 0x016e, Exception -> 0x0154 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ IOException -> 0x016e, Exception -> 0x0154 }
            android.location.Address r1 = (android.location.Address) r1     // Catch:{ IOException -> 0x016e, Exception -> 0x0154 }
            java.lang.String r1 = r1.getCountryName()     // Catch:{ IOException -> 0x016e, Exception -> 0x0154 }
            r12.q = r3     // Catch:{ IOException -> 0x016e, Exception -> 0x0154 }
            r12.r = r5     // Catch:{ IOException -> 0x016e, Exception -> 0x0154 }
            r12.s = r1     // Catch:{ IOException -> 0x016e, Exception -> 0x0154 }
            goto L_0x0187
        L_0x0154:
            r1 = move-exception
            java.util.logging.Level r3 = java.util.logging.Level.SEVERE
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r0)
            java.lang.String r0 = r1.getMessage()
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            com.userexperior.utilities.b.a(r3, r0)
            r1.printStackTrace()
            goto L_0x0187
        L_0x016e:
            r1 = move-exception
            java.util.logging.Level r3 = java.util.logging.Level.SEVERE
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r0)
            java.lang.String r0 = r1.getMessage()
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            com.userexperior.utilities.b.a(r3, r0)
            r1.printStackTrace()
        L_0x0187:
            android.content.Context r0 = com.userexperior.utilities.a.a()
            java.lang.String r1 = com.userexperior.utilities.l.y(r0)
            r12.v = r1
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r2, r4)
            java.lang.String r1 = "sv"
            java.lang.String r2 = "7.1.4"
            java.lang.String r0 = r0.getString(r1, r2)
            r12.w = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.c.c.a.<init>():void");
    }

    public a(Parcel parcel) {
        this.u = "1.5.2";
        this.v = "an";
        this.f3876b = parcel.readString();
        this.f3877c = parcel.readString();
        this.f3878d = parcel.readString();
        this.f3879e = parcel.readString();
        this.f3880f = parcel.readString();
        this.g = parcel.readInt();
        this.h = parcel.readInt();
        this.v = parcel.readString();
        this.w = parcel.readString();
    }

    public /* synthetic */ a(Parcel parcel, byte b2) {
        this(parcel);
    }

    public static String a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddyyyy-HH:mm:ss", Locale.US);
        Date date = new Date(1667774799607L);
        String outline50 = GeneratedOutlineSupport.outline50("V2–2-", simpleDateFormat.format(date));
        try {
            b.a(Level.INFO, Constants.ACCEPT_TIME_SEPARATOR_SERVER.concat(String.valueOf(new SimpleDateFormat("MMddyyyyHHmmss", Locale.US).format(date))));
        } catch (Exception e2) {
            e2.getMessage();
        }
        StringBuilder sb = new StringBuilder("UE SDK version : [ ");
        sb.append(outline50);
        sb.append(" ]");
        return outline50;
    }

    public static String a(long j2) {
        return Long.toString(j2 / 1000000);
    }

    public static Point b(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Display defaultDisplay = windowManager != null ? windowManager.getDefaultDisplay() : null;
        Point point = new Point();
        if (defaultDisplay != null) {
            defaultDisplay.getRealSize(point);
        }
        return point;
    }

    public static String b() {
        PackageInfo packageInfo;
        try {
            Context a2 = com.userexperior.utilities.a.a();
            packageInfo = a2.getPackageManager().getPackageInfo(a2.getPackageName(), 0);
        } catch (NameNotFoundException e2) {
            Level level = Level.SEVERE;
            b.a(level, "ex : DI - getAppVersion " + e2.getMessage());
            e2.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo == null) {
            return null;
        }
        String str = packageInfo.versionName;
        int i2 = packageInfo.versionCode;
        if (str == null) {
            return null;
        }
        return str + " [" + i2 + CMapParser.MARK_END_OF_ARRAY;
    }

    public static String c() {
        String str = AnalyticsConstants.NOT_AVAILABLE;
        Context a2 = com.userexperior.utilities.a.a();
        synchronized (a2) {
            ConnectivityManager connectivityManager = (ConnectivityManager) a2.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    str = "OFFLINE";
                } else if (activeNetworkInfo.getType() == 1) {
                    str = "WiFi";
                } else if (activeNetworkInfo.getType() == 0) {
                    if (VERSION.SDK_INT <= 28) {
                        str = "";
                        TelephonyManager telephonyManager = (TelephonyManager) com.userexperior.utilities.a.a().getSystemService("phone");
                        if (telephonyManager != null) {
                            switch (telephonyManager.getNetworkType()) {
                                case 1:
                                case 2:
                                case 4:
                                case 7:
                                case 11:
                                case 16:
                                    str = AnalyticsConstants.NETWORK_2G;
                                    break;
                                case 3:
                                case 5:
                                case 6:
                                case 8:
                                case 9:
                                case 10:
                                case 12:
                                case 14:
                                case 15:
                                case 17:
                                    str = AnalyticsConstants.NETWORK_3G;
                                    break;
                                case 13:
                                case 18:
                                case 19:
                                    break;
                                case 20:
                                    str = "5G";
                                    break;
                                default:
                                    str = "UNKNOWN";
                                    break;
                            }
                        }
                    }
                    str = AnalyticsConstants.NETWORK_4G;
                }
            }
        }
        return str;
    }

    public final a a(Context context) {
        String h2 = l.h(context);
        Point b2 = b(context);
        this.f3880f = h2;
        this.i = a();
        this.g = b2.x;
        this.h = b2.y;
        this.t = 1;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f3876b);
        parcel.writeString(this.f3877c);
        parcel.writeString(this.f3878d);
        parcel.writeString(this.f3879e);
        parcel.writeString(this.f3880f);
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        parcel.writeInt(this.t);
        parcel.writeString(this.m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
        parcel.writeString(this.s);
        parcel.writeString(this.u);
        parcel.writeString(this.v);
        parcel.writeString(this.w);
    }
}
