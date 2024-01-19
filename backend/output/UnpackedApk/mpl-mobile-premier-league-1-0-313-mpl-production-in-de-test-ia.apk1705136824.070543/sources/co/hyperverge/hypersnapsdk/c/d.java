package co.hyperverge.hypersnapsdk.c;

import android.location.Location;
import android.media.ExifInterface;
import co.hyperverge.hypersnapsdk.HyperSnapSDK;
import co.hyperverge.hypersnapsdk.f.c;
import co.hyperverge.hypersnapsdk.f.i;
import co.hyperverge.hypersnapsdk.objects.IPAddress;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.fontbox.cmap.CMapParser;

/* compiled from: ExifHelper */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public String f3092b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f3093c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f3094d = null;

    /* renamed from: e  reason: collision with root package name */
    public String f3095e = null;

    /* renamed from: f  reason: collision with root package name */
    public String f3096f = null;
    public String g = null;
    public String h = null;
    public String i = null;
    public String j = null;
    public String k = null;
    public String l = null;
    public String m = null;
    public String n = null;
    public String o = null;
    public String p = null;
    public String q = null;
    public String r = null;
    public String t = null;

    public void a(byte[] bArr, String str, Location location) {
        File file = new File(str);
        try {
            new FileOutputStream(file).write(bArr);
            ExifInterface exifInterface = new ExifInterface(file.getAbsolutePath());
            this.f3092b = exifInterface.getAttribute("FNumber");
            this.f3093c = exifInterface.getAttribute("DateTime");
            this.f3094d = exifInterface.getAttribute("ExposureTime");
            this.f3095e = exifInterface.getAttribute("Flash");
            this.f3096f = exifInterface.getAttribute("FocalLength");
            this.g = exifInterface.getAttribute("GPSAltitude");
            this.h = exifInterface.getAttribute("GPSAltitudeRef");
            this.i = exifInterface.getAttribute("GPSDateStamp");
            if (location != null) {
                this.j = c.a(location.getLatitude());
                this.l = c.a(location.getLongitude());
                this.k = c.b(location.getLatitude());
                this.m = c.b(location.getLongitude());
            }
            this.n = exifInterface.getAttribute("GPSProcessingMethod");
            this.o = exifInterface.getAttribute("GPSTimeStamp");
            this.p = exifInterface.getAttribute("ISOSpeedRatings");
            this.q = exifInterface.getAttribute("Make");
            this.r = exifInterface.getAttribute("Model");
            this.t = exifInterface.getAttribute("WhiteBalance");
            exifInterface.getAttribute("UserComment");
            exifInterface.getLatLong(new float[2]);
            file.delete();
        } catch (Exception e2) {
            i.a((Throwable) e2);
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
        }
    }

    public void a(String str, String str2, IPAddress iPAddress) {
        try {
            ExifInterface exifInterface = new ExifInterface(str);
            String str3 = this.f3092b;
            if (str3 != null) {
                exifInterface.setAttribute("FNumber", str3);
            }
            String str4 = this.f3093c;
            if (str4 != null) {
                exifInterface.setAttribute("DateTime", str4);
            }
            String str5 = this.f3094d;
            if (str5 != null) {
                exifInterface.setAttribute("ExposureTime", str5);
            }
            String str6 = this.f3095e;
            if (str6 != null) {
                exifInterface.setAttribute("Flash", str6);
            }
            String str7 = this.f3096f;
            if (str7 != null) {
                exifInterface.setAttribute("FocalLength", str7);
            }
            String str8 = this.g;
            if (str8 != null) {
                exifInterface.setAttribute("GPSAltitude", str8);
            }
            String str9 = this.h;
            if (str9 != null) {
                exifInterface.setAttribute("GPSAltitudeRef", str9);
            }
            String str10 = this.i;
            if (str10 != null) {
                exifInterface.setAttribute("GPSDateStamp", str10);
            }
            exifInterface.setAttribute("GPSLatitude", this.j);
            exifInterface.setAttribute("GPSLongitude", this.l);
            exifInterface.setAttribute("GPSLatitudeRef", this.k);
            exifInterface.setAttribute("GPSLongitudeRef", this.m);
            exifInterface.setAttribute("UserComment", a(str2, iPAddress));
            String str11 = this.n;
            if (str11 != null) {
                exifInterface.setAttribute("GPSProcessingMethod", str11);
            }
            String str12 = this.o;
            if (str12 != null) {
                exifInterface.setAttribute("GPSTimeStamp", str12);
            }
            String str13 = this.p;
            if (str13 != null) {
                exifInterface.setAttribute("ISOSpeedRatings", str13);
            }
            String str14 = this.q;
            if (str14 != null) {
                exifInterface.setAttribute("Make", str14);
            }
            String str15 = this.r;
            if (str15 != null) {
                exifInterface.setAttribute("Model", str15);
            }
            String str16 = this.t;
            if (str16 != null) {
                exifInterface.setAttribute("WhiteBalance", str16);
            }
            exifInterface.saveAttributes();
        } catch (Exception e2) {
            i.a((Throwable) e2);
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
        }
    }

    public String a(String str, IPAddress iPAddress) {
        StringBuilder sb = new StringBuilder("hvsdk_android_");
        if (HyperSnapSDK.getInstance() != null) {
            String appId = HyperSnapSDK.f2946b.getAppId();
            sb.append("3.6.38");
            sb.append("_");
            sb.append(appId);
            if (!k.a(str)) {
                sb.append("_");
                sb.append(str);
            } else if (!k.a(o.i())) {
                sb.append("_");
                sb.append(o.i());
            }
            if (iPAddress != null) {
                try {
                    String ip = iPAddress.getIp();
                    String city = iPAddress.getGeoDetails().getCity();
                    String country = iPAddress.getGeoDetails().getCountry();
                    String countryCode = iPAddress.getGeoDetails().getCountryCode();
                    sb.append("_");
                    sb.append(ip);
                    sb.append("_");
                    sb.append(city);
                    sb.append("_");
                    sb.append(country);
                    sb.append("_");
                    sb.append(countryCode);
                } catch (Exception unused) {
                }
            }
            return String.valueOf(sb);
        }
        throw null;
    }

    public void a(File file, Location location) throws IOException {
        "readExifFromFile() called with: file = [" + file + "], location = [" + location + CMapParser.MARK_END_OF_ARRAY;
        ExifInterface exifInterface = new ExifInterface(file.getPath());
        this.f3092b = exifInterface.getAttribute("FNumber");
        this.f3093c = exifInterface.getAttribute("DateTime");
        this.f3094d = exifInterface.getAttribute("ExposureTime");
        this.f3095e = exifInterface.getAttribute("Flash");
        this.f3096f = exifInterface.getAttribute("FocalLength");
        this.g = exifInterface.getAttribute("GPSAltitude");
        this.h = exifInterface.getAttribute("GPSAltitudeRef");
        this.i = exifInterface.getAttribute("GPSDateStamp");
        if (location != null) {
            this.j = c.a(location.getLatitude());
            this.l = c.a(location.getLongitude());
            this.k = c.b(location.getLatitude());
            this.m = c.b(location.getLongitude());
        }
        this.n = exifInterface.getAttribute("GPSProcessingMethod");
        this.o = exifInterface.getAttribute("GPSTimeStamp");
        this.p = exifInterface.getAttribute("ISOSpeedRatings");
        this.q = exifInterface.getAttribute("Make");
        this.r = exifInterface.getAttribute("Model");
        this.t = exifInterface.getAttribute("WhiteBalance");
        exifInterface.getAttribute("UserComment");
        exifInterface.getLatLong(new float[2]);
    }
}
