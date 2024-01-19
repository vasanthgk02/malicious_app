package com.userexperior.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.userexperior.models.recording.a;
import com.userexperior.utilities.b;
import com.userexperior.utilities.l;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3998a = "h";

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f3999b = "0123456789ABCDEF".toCharArray();

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f4000c = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy"};

    public static double a(File file) {
        long j = 0;
        for (File file2 : file.listFiles()) {
            if (file2 == null || !file2.isFile()) {
                j = (long) (a(file2) + ((double) j));
            } else {
                j = file2.length() + j;
            }
        }
        return (((double) j) / 1024.0d) / 1024.0d;
    }

    public static long a(long j, long j2, TimeUnit timeUnit) {
        return timeUnit.convert(Math.abs(j - j2), TimeUnit.MILLISECONDS);
    }

    public static Bitmap a(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    public static String a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(CommonUtils.SHA1_INSTANCE);
            byte[] bytes = str.getBytes("UTF-8");
            if (bytes != null) {
                instance.update(bytes, 0, bytes.length);
            }
            byte[] digest = instance.digest();
            char[] cArr = new char[(digest.length * 2)];
            for (int i = 0; i < digest.length; i++) {
                byte b2 = digest[i] & 255;
                int i2 = i * 2;
                cArr[i2] = f3999b[b2 >>> 4];
                cArr[i2 + 1] = f3999b[b2 & 15];
            }
            return new String(cArr);
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static String a(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:sss", Locale.US).format(date);
    }

    public static HashMap<String, Object> a(JSONObject jSONObject) throws JSONException {
        HashMap<String, Object> hashMap = new HashMap<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONArray) {
                obj = a((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = a((JSONObject) obj);
            }
            hashMap.put(next, obj);
        }
        return hashMap;
    }

    public static List<Object> a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONArray) {
                obj = a((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = a((JSONObject) obj);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0049, code lost:
        if (r1.equals(r0) == false) goto L_0x004b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r6) {
        /*
            long r0 = com.userexperior.utilities.l.j(r6)
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x000b
            return
        L_0x000b:
            long r0 = com.userexperior.utilities.l.j(r6)
            long r2 = java.lang.System.currentTimeMillis()
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS
            long r0 = a(r0, r2, r4)
            r2 = 1800(0x708, double:8.893E-321)
            r4 = 0
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 < 0) goto L_0x0039
            java.lang.String r0 = com.userexperior.utilities.l.g(r6)
            java.lang.String r1 = "_"
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline78(r0, r1)
            long r1 = java.lang.System.currentTimeMillis()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.userexperior.utilities.l.b(r6, r0)
            goto L_0x004b
        L_0x0039:
            java.lang.String r0 = com.userexperior.models.recording.a.j()
            java.lang.String r1 = com.userexperior.models.recording.a.k()
            if (r0 == 0) goto L_0x0051
            if (r1 == 0) goto L_0x0051
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0051
        L_0x004b:
            com.userexperior.models.recording.a.a(r4)
            com.userexperior.models.recording.a.b(r4)
        L_0x0051:
            com.userexperior.utilities.l.k(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.e.h.a(android.content.Context):void");
    }

    public static Date b(String str) {
        String[] strArr = f4000c;
        Date date = new Date();
        if (str.length() > 1 && str.startsWith("'") && str.endsWith("'")) {
            str = str.substring(1, str.length() - 1);
        }
        for (String a2 : strArr) {
            SimpleDateFormat a3 = i.a(a2);
            a3.set2DigitYearStart(date);
            ParsePosition parsePosition = new ParsePosition(0);
            Date parse = a3.parse(str, parsePosition);
            if (parsePosition.getIndex() != 0) {
                return parse;
            }
        }
        return null;
    }

    public static void b(Context context) {
        StringBuilder outline78 = GeneratedOutlineSupport.outline78(l.g(context), "_");
        outline78.append(System.currentTimeMillis());
        l.b(context, outline78.toString());
        a.a((String) null);
        a.b((String) null);
        l.k(context);
    }

    public static void b(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                for (File b2 : file.listFiles()) {
                    b(b2);
                }
            }
            StringBuilder sb = new StringBuilder("c file - ");
            sb.append(file.getName());
            sb.append(" deleted = ");
            sb.append(file.delete());
        }
    }

    public static Date c(String str) {
        try {
            return new SimpleDateFormat("yyyy/MM/dd", Locale.US).parse(str);
        } catch (ParseException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void c(File file) {
        try {
            new RandomAccessFile(file, "rws").close();
        } catch (IOException e2) {
            Level level = Level.SEVERE;
            b.a(level, "Error closeFile(): " + e2.getMessage());
            new StringBuilder("error while closing file: ").append(e2.getMessage());
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.getMessage();
        }
    }

    public static boolean d(String str) {
        return str.matches("(([0-9]{4})/[0-9]{2})/([0-9]{2})");
    }
}
