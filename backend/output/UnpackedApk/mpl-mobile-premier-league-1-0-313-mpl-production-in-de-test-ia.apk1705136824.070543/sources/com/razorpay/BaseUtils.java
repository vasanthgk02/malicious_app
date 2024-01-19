package com.razorpay;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.media.RingtoneManager;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.config.ConfigConstant;
import com.mpl.androidapp.onesignal.OneSingnalConstant;
import com.mpl.androidapp.updater.util.UpdaterConstant.Response;
import com.mpl.androidapp.utils.Constant;
import com.razorpay.AdvertisingIdUtil.d__1_;
import com.smartfoxserver.v2.protocol.serialization.DefaultObjectDumpFormatter;
import com.xiaomi.mipush.sdk.Constants;
import in.juspay.hypersdk.core.Labels.Device;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.text.ExtendedMessageFormat;
import org.apache.pdfbox.filter.ASCII85InputStream;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.apache.pdfbox.pdmodel.common.function.type4.Parser.Tokenizer;
import org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import proguard.annotation.Keep;
import proguard.annotation.KeepClassMembers;
import sfs2x.client.requests.game.CreateSFSGameRequest;

@Keep
@KeepClassMembers
public class BaseUtils {
    public static String PERMISSION_DISABLED = "permission disabled";
    public static char[] Q_$2$ = {'r', 'z', 'p', 'i', 's', ASCII85InputStream.PADDING_U, 'n', 't', 'e', 'd', 'g', 'l', 'o', 'y', 'v', 'w'};
    public static char R$$r_ = 4;
    public static int a_$P$ = 0;
    public static int d__1_ = 1;
    public static String ipAddress;
    public static boolean isCompatibleWithGooglePay = true;
    public static boolean sWebViewDebuggingEnabled = l_$w$.R$$r_.booleanValue();

    static {
        int i = d__1_ + 73;
        a_$P$ = i % 128;
        int i2 = i % 2;
    }

    /* JADX WARNING: type inference failed for: r12v1 */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        if (r4 == r5) goto L_0x00b8;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String G__G_(byte r10, int r11, java.lang.String r12) {
        /*
            if (r12 == 0) goto L_0x0006
            char[] r12 = r12.toCharArray()
        L_0x0006:
            char[] r12 = (char[]) r12
            char[] r0 = Q_$2$
            char r1 = R$$r_
            char[] r2 = new char[r11]
            int r3 = r11 % 2
            r4 = 39
            if (r3 == 0) goto L_0x0017
            r3 = 39
            goto L_0x0019
        L_0x0017:
            r3 = 61
        L_0x0019:
            if (r3 == r4) goto L_0x001c
            goto L_0x0024
        L_0x001c:
            int r11 = r11 + -1
            char r3 = r12[r11]
            int r3 = r3 - r10
            char r3 = (char) r3
            r2[r11] = r3
        L_0x0024:
            r3 = 1
            if (r11 <= r3) goto L_0x00e6
            r3 = 0
        L_0x0028:
            if (r3 >= r11) goto L_0x00e6
            int r4 = d__1_
            r5 = 17
            int r4 = r4 + r5
            int r6 = r4 % 128
            a_$P$ = r6
            int r4 = r4 % 2
            if (r4 == 0) goto L_0x0041
            char r4 = r12[r3]
            int r5 = r3 + 0
            char r5 = r12[r5]
            if (r4 != r5) goto L_0x0050
            goto L_0x00b8
        L_0x0041:
            char r4 = r12[r3]
            int r6 = r3 + 1
            char r6 = r12[r6]
            r7 = 77
            if (r4 != r6) goto L_0x004d
            r5 = 77
        L_0x004d:
            if (r5 == r7) goto L_0x00b7
            r5 = r6
        L_0x0050:
            int r6 = com.razorpay.D$_X_.a_$P$(r4, r1)
            int r4 = com.razorpay.D$_X_.R$$r_(r4, r1)
            int r7 = com.razorpay.D$_X_.a_$P$(r5, r1)
            int r5 = com.razorpay.D$_X_.R$$r_(r5, r1)
            if (r4 != r5) goto L_0x007d
            int r6 = com.razorpay.D$_X_.d__1_(r6, r1)
            int r7 = com.razorpay.D$_X_.d__1_(r7, r1)
            int r4 = com.razorpay.D$_X_.R$$r_(r6, r4, r1)
            int r5 = com.razorpay.D$_X_.R$$r_(r7, r5, r1)
            char r4 = r0[r4]
            r2[r3] = r4
            int r4 = r3 + 1
            char r5 = r0[r5]
            r2[r4] = r5
            goto L_0x00e2
        L_0x007d:
            if (r6 != r7) goto L_0x00a4
            int r8 = d__1_
            int r8 = r8 + 65
            int r9 = r8 % 128
            a_$P$ = r9
            int r8 = r8 % 2
            int r4 = com.razorpay.D$_X_.d__1_(r4, r1)
            int r5 = com.razorpay.D$_X_.d__1_(r5, r1)
            int r4 = com.razorpay.D$_X_.R$$r_(r6, r4, r1)
            int r5 = com.razorpay.D$_X_.R$$r_(r7, r5, r1)
            char r4 = r0[r4]
            r2[r3] = r4
            int r4 = r3 + 1
            char r5 = r0[r5]
            r2[r4] = r5
            goto L_0x00e2
        L_0x00a4:
            int r5 = com.razorpay.D$_X_.R$$r_(r6, r5, r1)
            int r4 = com.razorpay.D$_X_.R$$r_(r7, r4, r1)
            char r5 = r0[r5]
            r2[r3] = r5
            int r5 = r3 + 1
            char r4 = r0[r4]
            r2[r5] = r4
            goto L_0x00e2
        L_0x00b7:
            r5 = r6
        L_0x00b8:
            int r6 = d__1_
            int r6 = r6 + 29
            int r7 = r6 % 128
            a_$P$ = r7
            int r6 = r6 % 2
            r7 = 60
            if (r6 == 0) goto L_0x00c9
            r6 = 34
            goto L_0x00cb
        L_0x00c9:
            r6 = 60
        L_0x00cb:
            if (r6 == r7) goto L_0x00d8
            int r4 = r4 / r10
            char r4 = (char) r4
            r2[r3] = r4
            int r4 = r3 * 0
            int r5 = r5 << r10
            char r5 = (char) r5
            r2[r4] = r5
            goto L_0x00e2
        L_0x00d8:
            int r4 = r4 - r10
            char r4 = (char) r4
            r2[r3] = r4
            int r4 = r3 + 1
            int r5 = r5 - r10
            char r5 = (char) r5
            r2[r4] = r5
        L_0x00e2:
            int r3 = r3 + 2
            goto L_0x0028
        L_0x00e6:
            java.lang.String r10 = new java.lang.String
            r10.<init>(r2)
            int r11 = a_$P$
            int r11 = r11 + 25
            int r12 = r11 % 128
            d__1_ = r12
            int r11 = r11 % 2
            if (r11 == 0) goto L_0x00f8
            return r10
        L_0x00f8:
            r10 = 0
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.razorpay.BaseUtils.G__G_(byte, int, java.lang.String):java.lang.String");
    }

    public static String MD5Hash(String str) {
        try {
            String bigInteger = new BigInteger(1, MessageDigest.getInstance("MD5").digest(str.getBytes())).toString(16);
            while (true) {
                if ((bigInteger.length() < 32 ? 31 : ExtendedMessageFormat.QUOTE) == '\'') {
                    return bigInteger;
                }
                int i = a_$P$ + 97;
                d__1_ = i % 128;
                if ((i % 2 == 0 ? '[' : '#') != '#') {
                    bigInteger = "0".concat(bigInteger);
                    int i2 = 74 / 0;
                } else {
                    bigInteger = "0".concat(bigInteger);
                }
            }
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static /* synthetic */ JSONObject access$000(HttpsURLConnection httpsURLConnection) throws IOException, JSONException {
        int i = a_$P$ + 123;
        d__1_ = i % 128;
        int i2 = i % 2;
        JSONObject responseJson = getResponseJson(httpsURLConnection);
        int i3 = a_$P$ + 55;
        d__1_ = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return responseJson;
        }
        int i4 = 17 / 0;
        return responseJson;
    }

    public static /* synthetic */ String access$100() {
        String str;
        int i = a_$P$ + 31;
        d__1_ = i % 128;
        if (!(i % 2 != 0)) {
            str = ipAddress;
            int i2 = 71 / 0;
        } else {
            str = ipAddress;
        }
        int i3 = a_$P$ + 69;
        d__1_ = i3 % 128;
        int i4 = i3 % 2;
        return str;
    }

    public static /* synthetic */ String access$102(String str) {
        int i = d__1_ + 11;
        a_$P$ = i % 128;
        char c2 = i % 2 != 0 ? 'C' : '2';
        ipAddress = str;
        if (c2 != 'C') {
            int i2 = d__1_ + 59;
            a_$P$ = i2 % 128;
            int i3 = i2 % 2;
            return str;
        }
        throw null;
    }

    public static String buildSerial() {
        int i = d__1_ + 77;
        a_$P$ = i % 128;
        int i2 = i % 2;
        String str = Build.SERIAL;
        int i3 = a_$P$ + 35;
        d__1_ = i3 % 128;
        int i4 = i3 % 2;
        return str;
    }

    public static void checkForLatestVersion(Context context, int i) {
        if (Y$_o$.J$_0_().b__J_()) {
            int i2 = a_$P$ + 61;
            d__1_ = i2 % 128;
            if (i2 % 2 != 0) {
                if (isMerchantAppDebuggable(context)) {
                    if ((i < Y$_o$.J$_0_().E$_j$() ? '7' : 'Q') != 'Q') {
                        int i3 = a_$P$ + 43;
                        d__1_ = i3 % 128;
                        int i4 = i3 % 2;
                        Toast.makeText(context, Y$_o$.J$_0_().B$$W$(), 1).show();
                        return;
                    }
                    return;
                }
                return;
            }
            isMerchantAppDebuggable(context);
            throw null;
        }
    }

    public static boolean checkUpiRegisteredApp(Context context, String str) {
        int i = d__1_ + 49;
        a_$P$ = i % 128;
        int i2 = i % 2;
        char c2 = 65535;
        if (str.hashCode() == 1170339061) {
            if (!(!str.equals(BaseConstants.GOOGLE_PAY_PKG))) {
                int i3 = d__1_ + 65;
                a_$P$ = i3 % 128;
                int i4 = i3 % 2;
                c2 = 0;
            }
        }
        if (c2 != 0) {
            return true;
        }
        return isCompatibleWithGooglePay;
    }

    public static String constructBasicAuth(String str) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(":");
        String encodeToString = Base64.encodeToString(sb.toString().getBytes("UTF-8"), 2);
        int i = d__1_ + 107;
        a_$P$ = i % 128;
        if ((i % 2 != 0 ? '>' : 30) != 30) {
            int i2 = 26 / 0;
        }
        return encodeToString;
    }

    public static PublicKey constructPublicKey(String str) {
        try {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes(), 0)));
            int i = a_$P$ + 31;
            d__1_ = i % 128;
            int i2 = i % 2;
            return generatePublic;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String decryptFile(String str) {
        boolean z;
        String str2;
        try {
            O_$B_ o_$b_ = new O_$B_();
            String intern = G__G_(92, 14, "\u0001\u0002\u0003\u0000\u0005\u0006\u0007\u0002\u0004\u000b\b\u0001\t\n").intern();
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(intern.getBytes("UTF-8"));
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            int length = digest.length;
            int i = 0;
            while (true) {
                z = true;
                if (!(i < length)) {
                    break;
                }
                int i2 = d__1_ + 123;
                a_$P$ = i2 % 128;
                int i3 = i2 % 2;
                stringBuffer.append(String.format("%02x", new Object[]{Byte.valueOf(digest[i])}));
                i++;
            }
            if ((32 > stringBuffer.toString().length() ? 11 : DefaultObjectDumpFormatter.TOKEN_DIVIDER) != ';') {
                int i4 = d__1_ + 105;
                a_$P$ = i4 % 128;
                int i5 = i4 % 2;
                str2 = stringBuffer.toString();
            } else {
                str2 = stringBuffer.toString().substring(0, 32);
            }
            String G__G_ = o_$b_.G__G_(str, str2, G__G_(31, 16, "\u000b\b\u0000\u0004\u000e\t\b\u000f\u0001\f\u0006\u0007\u0007\u000b\t\n").intern());
            int i6 = a_$P$ + 49;
            d__1_ = i6 % 128;
            if (i6 % 2 == 0) {
                z = false;
            }
            if (z) {
                return G__G_;
            }
            int i7 = 13 / 0;
            return G__G_;
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2, "error", "Unable to decrypt file");
            StringBuilder sb = new StringBuilder("Unable to decrypt file, ");
            sb.append(e2.getMessage());
            sb.toString();
            return null;
        }
    }

    public static int dpToPixels(Context context, int i) {
        float f2;
        int i2 = d__1_ + 31;
        a_$P$ = i2 % 128;
        if (i2 % 2 == 0) {
            f2 = TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
        } else {
            f2 = TypedValue.applyDimension(0, (float) i, context.getResources().getDisplayMetrics());
        }
        return (int) f2;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static void enableJavaScriptInWebView(WebView webView) {
        WebSettings settings;
        boolean z;
        int i = d__1_ + 41;
        a_$P$ = i % 128;
        if ((i % 2 != 0 ? '*' : 'K') != 'K') {
            settings = webView.getSettings();
            z = false;
        } else {
            settings = webView.getSettings();
            z = true;
        }
        settings.setJavaScriptEnabled(z);
        int i2 = d__1_ + 101;
        a_$P$ = i2 % 128;
        int i3 = i2 % 2;
    }

    public static void fetchIP(final RzpJSONCallback rzpJSONCallback) {
        new Thread(new Runnable() {
            /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0063 */
            /* JADX WARNING: Removed duplicated region for block: B:23:0x005f A[SYNTHETIC, Splitter:B:23:0x005f] */
            /* JADX WARNING: Removed duplicated region for block: B:29:0x0075 A[SYNTHETIC, Splitter:B:29:0x0075] */
            /* JADX WARNING: Removed duplicated region for block: B:33:0x007b A[Catch:{ Exception -> 0x007f }] */
            /* JADX WARNING: Unknown top exception splitter block from list: {B:26:0x0063=Splitter:B:26:0x0063, B:20:0x0056=Splitter:B:20:0x0056} */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r6 = this;
                    java.lang.String r0 = "warning"
                    java.lang.String r1 = "error"
                    r2 = 0
                    java.net.URL r3 = new java.net.URL     // Catch:{ SocketTimeoutException -> 0x0063, Exception -> 0x0055 }
                    java.lang.String r4 = "https://approvals-api.getsimpl.com/my-ip"
                    r3.<init>(r4)     // Catch:{ SocketTimeoutException -> 0x0063, Exception -> 0x0055 }
                    java.net.URLConnection r3 = r3.openConnection()     // Catch:{ SocketTimeoutException -> 0x0063, Exception -> 0x0055 }
                    java.lang.Object r3 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r3)     // Catch:{ SocketTimeoutException -> 0x0063, Exception -> 0x0055 }
                    java.net.URLConnection r3 = (java.net.URLConnection) r3     // Catch:{ SocketTimeoutException -> 0x0063, Exception -> 0x0055 }
                    javax.net.ssl.HttpsURLConnection r3 = (javax.net.ssl.HttpsURLConnection) r3     // Catch:{ SocketTimeoutException -> 0x0063, Exception -> 0x0055 }
                    java.lang.String r2 = "GET"
                    r3.setRequestMethod(r2)     // Catch:{ SocketTimeoutException -> 0x0051, Exception -> 0x004e, all -> 0x004b }
                    r2 = 150(0x96, float:2.1E-43)
                    r3.setReadTimeout(r2)     // Catch:{ SocketTimeoutException -> 0x0051, Exception -> 0x004e, all -> 0x004b }
                    r2 = 250(0xfa, float:3.5E-43)
                    r3.setConnectTimeout(r2)     // Catch:{ SocketTimeoutException -> 0x0051, Exception -> 0x004e, all -> 0x004b }
                    int r2 = r3.getResponseCode()     // Catch:{ SocketTimeoutException -> 0x0051, Exception -> 0x004e, all -> 0x004b }
                    r4 = 200(0xc8, float:2.8E-43)
                    if (r2 != r4) goto L_0x0039
                    org.json.JSONObject r2 = com.razorpay.BaseUtils.access$000(r3)     // Catch:{ SocketTimeoutException -> 0x0051, Exception -> 0x004e, all -> 0x004b }
                    com.razorpay.RzpJSONCallback r4 = r2     // Catch:{ SocketTimeoutException -> 0x0051, Exception -> 0x004e, all -> 0x004b }
                    r4.onResponse(r2)     // Catch:{ SocketTimeoutException -> 0x0051, Exception -> 0x004e, all -> 0x004b }
                    goto L_0x0047
                L_0x0039:
                    com.razorpay.RzpJSONCallback r2 = r2     // Catch:{ SocketTimeoutException -> 0x0051, Exception -> 0x004e, all -> 0x004b }
                    org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ SocketTimeoutException -> 0x0051, Exception -> 0x004e, all -> 0x004b }
                    r4.<init>()     // Catch:{ SocketTimeoutException -> 0x0051, Exception -> 0x004e, all -> 0x004b }
                    org.json.JSONObject r4 = r4.put(r1, r1)     // Catch:{ SocketTimeoutException -> 0x0051, Exception -> 0x004e, all -> 0x004b }
                    r2.onResponse(r4)     // Catch:{ SocketTimeoutException -> 0x0051, Exception -> 0x004e, all -> 0x004b }
                L_0x0047:
                    r3.disconnect()     // Catch:{ Exception -> 0x007f }
                    return
                L_0x004b:
                    r1 = move-exception
                    r2 = r3
                    goto L_0x0079
                L_0x004e:
                    r1 = move-exception
                    r2 = r3
                    goto L_0x0056
                L_0x0051:
                    r2 = r3
                    goto L_0x0063
                L_0x0053:
                    r1 = move-exception
                    goto L_0x0079
                L_0x0055:
                    r1 = move-exception
                L_0x0056:
                    java.lang.String r3 = r1.getMessage()     // Catch:{ all -> 0x0053 }
                    com.razorpay.AnalyticsUtil.reportError(r1, r0, r3)     // Catch:{ all -> 0x0053 }
                    if (r2 == 0) goto L_0x0078
                    r2.disconnect()     // Catch:{ Exception -> 0x007f }
                    return
                L_0x0063:
                    com.razorpay.RzpJSONCallback r3 = r2     // Catch:{ all -> 0x0053 }
                    org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x0053 }
                    r4.<init>()     // Catch:{ all -> 0x0053 }
                    java.lang.String r5 = "timeout"
                    org.json.JSONObject r1 = r4.put(r1, r5)     // Catch:{ all -> 0x0053 }
                    r3.onResponse(r1)     // Catch:{ all -> 0x0053 }
                    if (r2 == 0) goto L_0x0078
                    r2.disconnect()     // Catch:{ Exception -> 0x007f }
                L_0x0078:
                    return
                L_0x0079:
                    if (r2 == 0) goto L_0x007e
                    r2.disconnect()     // Catch:{ Exception -> 0x007f }
                L_0x007e:
                    throw r1     // Catch:{ Exception -> 0x007f }
                L_0x007f:
                    r1 = move-exception
                    java.lang.String r2 = r1.getMessage()
                    com.razorpay.AnalyticsUtil.reportError(r1, r0, r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.razorpay.BaseUtils.AnonymousClass4.run():void");
            }
        }).start();
        int i = a_$P$ + 83;
        d__1_ = i % 128;
        int i2 = i % 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0036, code lost:
        if (r6.metaData == null) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.HashMap<java.lang.String, java.lang.String> getAllPluginsFromManifest(android.content.Context r6) {
        /*
            int r0 = d__1_
            int r0 = r0 + 11
            int r1 = r0 % 128
            a_$P$ = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L_0x0026
            android.content.pm.PackageManager r0 = r6.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0095 }
            java.lang.String r6 = r6.getPackageName()     // Catch:{ NameNotFoundException -> 0x0095 }
            r2 = 16414(0x401e, float:2.3001E-41)
            android.content.pm.ApplicationInfo r6 = r0.getApplicationInfo(r6, r2)     // Catch:{ NameNotFoundException -> 0x0095 }
            android.os.Bundle r0 = r6.metaData     // Catch:{ NameNotFoundException -> 0x0095 }
            r2 = 1
            if (r0 != 0) goto L_0x0022
            r0 = 0
            goto L_0x0023
        L_0x0022:
            r0 = 1
        L_0x0023:
            if (r0 == r2) goto L_0x0043
            goto L_0x0038
        L_0x0026:
            android.content.pm.PackageManager r0 = r6.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0095 }
            java.lang.String r6 = r6.getPackageName()     // Catch:{ NameNotFoundException -> 0x0095 }
            r2 = 128(0x80, float:1.8E-43)
            android.content.pm.ApplicationInfo r6 = r0.getApplicationInfo(r6, r2)     // Catch:{ NameNotFoundException -> 0x0095 }
            android.os.Bundle r0 = r6.metaData     // Catch:{ NameNotFoundException -> 0x0095 }
            if (r0 != 0) goto L_0x0043
        L_0x0038:
            int r6 = d__1_
            int r6 = r6 + 73
            int r0 = r6 % 128
            a_$P$ = r0
            int r6 = r6 % 2
            return r1
        L_0x0043:
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ NameNotFoundException -> 0x0095 }
            r0.<init>()     // Catch:{ NameNotFoundException -> 0x0095 }
            android.os.Bundle r2 = r6.metaData     // Catch:{ NameNotFoundException -> 0x0095 }
            java.util.Set r2 = r2.keySet()     // Catch:{ NameNotFoundException -> 0x0095 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ NameNotFoundException -> 0x0095 }
        L_0x0052:
            boolean r3 = r2.hasNext()     // Catch:{ NameNotFoundException -> 0x0095 }
            r4 = 90
            if (r3 == 0) goto L_0x005d
            r3 = 67
            goto L_0x005f
        L_0x005d:
            r3 = 90
        L_0x005f:
            if (r3 == r4) goto L_0x0094
            java.lang.Object r3 = r2.next()     // Catch:{ NameNotFoundException -> 0x0095 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ NameNotFoundException -> 0x0095 }
            java.lang.String r4 = "com.razorpay.plugin."
            boolean r4 = r3.contains(r4)     // Catch:{ NameNotFoundException -> 0x0095 }
            r5 = 82
            if (r4 == 0) goto L_0x0074
            r4 = 50
            goto L_0x0076
        L_0x0074:
            r4 = 82
        L_0x0076:
            if (r4 == r5) goto L_0x0052
            android.os.Bundle r4 = r6.metaData     // Catch:{ NameNotFoundException -> 0x0095 }
            java.lang.String r4 = r4.getString(r3)     // Catch:{ NameNotFoundException -> 0x0095 }
            if (r4 == 0) goto L_0x0052
            int r4 = a_$P$
            int r4 = r4 + 111
            int r5 = r4 % 128
            d__1_ = r5
            int r4 = r4 % 2
            android.os.Bundle r4 = r6.metaData     // Catch:{ NameNotFoundException -> 0x0095 }
            java.lang.String r4 = r4.getString(r3)     // Catch:{ NameNotFoundException -> 0x0095 }
            r0.put(r3, r4)     // Catch:{ NameNotFoundException -> 0x0095 }
            goto L_0x0052
        L_0x0094:
            return r0
        L_0x0095:
            r6 = move-exception
            java.lang.String r0 = r6.getMessage()
            java.lang.String r2 = "critical"
            com.razorpay.AnalyticsUtil.reportError(r6, r2, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.razorpay.BaseUtils.getAllPluginsFromManifest(android.content.Context):java.util.HashMap");
    }

    public static String getAndroidId(Context context) {
        int i = a_$P$ + 3;
        d__1_ = i % 128;
        char c2 = i % 2 == 0 ? 'I' : 15;
        ContentResolver contentResolver = context.getContentResolver();
        if (c2 == 15) {
            return Secure.getString(contentResolver, "android_id");
        }
        Secure.getString(contentResolver, "android_id");
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
        return com.razorpay.BaseConstants.DEVELOPMENT;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0016, code lost:
        if (1 != (r3.getApplicationInfo().flags | 2)) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
        if (((r3.getApplicationInfo().flags & 2) != 0) != true) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getAppBuildType(android.content.Context r3) {
        /*
            int r0 = d__1_
            int r0 = r0 + 57
            int r1 = r0 % 128
            a_$P$ = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0019
            android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo()
            int r3 = r3.flags
            r3 = r3 | 2
            if (r2 == r3) goto L_0x0028
            goto L_0x003d
        L_0x0019:
            android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo()
            int r3 = r3.flags
            r3 = r3 & 2
            if (r3 == 0) goto L_0x0025
            r3 = 1
            goto L_0x0026
        L_0x0025:
            r3 = 0
        L_0x0026:
            if (r3 == r2) goto L_0x003d
        L_0x0028:
            int r3 = a_$P$
            int r3 = r3 + 81
            int r0 = r3 % 128
            d__1_ = r0
            int r3 = r3 % 2
            if (r3 != 0) goto L_0x0035
            goto L_0x0036
        L_0x0035:
            r1 = 1
        L_0x0036:
            if (r1 != r2) goto L_0x003b
            java.lang.String r3 = "production"
            return r3
        L_0x003b:
            r3 = 0
            throw r3
        L_0x003d:
            java.lang.String r3 = "development"
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.razorpay.BaseUtils.getAppBuildType(android.content.Context):java.lang.String");
    }

    public static String getAppNameOfPackageName(String str, Context context) throws Exception {
        try {
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
            int i = applicationInfo.labelRes;
            Resources resourcesForApplication = packageManager.getResourcesForApplication(applicationInfo);
            if (i != 0) {
                return resourcesForApplication.getString(i);
            }
            int i2 = d__1_ + 7;
            a_$P$ = i2 % 128;
            int i3 = i2 % 2;
            String charSequence = applicationInfo.nonLocalizedLabel.toString();
            int i4 = d__1_ + 11;
            a_$P$ = i4 % 128;
            int i5 = i4 % 2;
            return charSequence;
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2, AnalyticsConstants.ERROR_EXCEPTION, e2.getLocalizedMessage());
            e2.printStackTrace();
            throw e2;
        }
    }

    public static String getAppNameOfResolveInfo(ResolveInfo resolveInfo, Context context) throws Exception {
        int i = d__1_ + 113;
        a_$P$ = i % 128;
        int i2 = i % 2;
        String appNameOfPackageName = getAppNameOfPackageName(resolveInfo.activityInfo.packageName, context);
        int i3 = d__1_ + 93;
        a_$P$ = i3 % 128;
        if (i3 % 2 == 0) {
            return appNameOfPackageName;
        }
        throw null;
    }

    public static String getBase64FromOtherAppsResource(Context context, String str) {
        int i = a_$P$ + 89;
        d__1_ = i % 128;
        int i2 = i % 2;
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
            String base64FromResource = getBase64FromResource(packageManager.getResourcesForApplication(applicationInfo), applicationInfo.icon);
            int i3 = a_$P$ + 101;
            d__1_ = i3 % 128;
            int i4 = i3 % 2;
            return base64FromResource;
        } catch (NameNotFoundException e2) {
            AnalyticsUtil.reportError(e2, "critical", e2.getLocalizedMessage());
            e2.printStackTrace();
            return null;
        }
    }

    public static String getBase64FromResource(Resources resources, int i) {
        Bitmap decodeResource = BitmapFactory.decodeResource(resources, i);
        if (decodeResource == null) {
            char c2 = '[';
            int i2 = d__1_ + 91;
            a_$P$ = i2 % 128;
            int i3 = i2 % 2;
            Drawable drawable = resources.getDrawable(i);
            if ((drawable != null ? ',' : '$') == ',') {
                if ((drawable instanceof BitmapDrawable ? '[' : 1) != '[') {
                    decodeResource = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Config.ARGB_8888);
                    Canvas canvas = new Canvas(decodeResource);
                    drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                    drawable.draw(canvas);
                } else {
                    int i4 = d__1_ + 107;
                    a_$P$ = i4 % 128;
                    if (i4 % 2 != 0) {
                        c2 = 'b';
                    }
                    BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                    if (c2 != 'b') {
                        decodeResource = bitmapDrawable.getBitmap();
                    } else {
                        bitmapDrawable.getBitmap();
                        throw null;
                    }
                }
            }
        }
        if (decodeResource == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        decodeResource.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("data:image/png;base64,");
        outline73.append(Base64.encodeToString(byteArray, 2));
        return outline73.toString();
    }

    public static String getCarrierOperatorName(Context context) {
        int i = a_$P$ + 39;
        d__1_ = i % 128;
        int i2 = i % 2;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if ((telephonyManager != null ? (char) 27 : 23) != 23) {
            int i3 = a_$P$ + 85;
            d__1_ = i3 % 128;
            int i4 = i3 % 2;
            return telephonyManager.getNetworkOperatorName();
        }
        String str = PERMISSION_DISABLED;
        int i5 = a_$P$ + 107;
        d__1_ = i5 % 128;
        if (i5 % 2 != 0) {
            return str;
        }
        throw null;
    }

    public static String getCellularNetworkProviderName(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(context, "phone");
        if ((telephonyManager != null ? 'L' : 13) != 'L') {
            int i = d__1_ + 123;
            a_$P$ = i % 128;
            int i2 = i % 2;
            return "unknown";
        }
        int i3 = a_$P$ + 11;
        d__1_ = i3 % 128;
        if (i3 % 2 != 0) {
            return telephonyManager.getNetworkOperatorName();
        }
        telephonyManager.getNetworkOperatorName();
        throw null;
    }

    public static String getCellularNetworkType(Context context) {
        int i = a_$P$ + 5;
        d__1_ = i % 128;
        if (!(i % 2 == 0)) {
            try {
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return AnalyticsConstants.NETWORK_2G;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return AnalyticsConstants.NETWORK_3G;
                    case 13:
                        return AnalyticsConstants.NETWORK_4G;
                    default:
                        int i2 = d__1_ + 13;
                        a_$P$ = i2 % 128;
                        int i3 = i2 % 2;
                        return AnalyticsConstants.NOT_AVAILABLE;
                }
            } catch (Exception e2) {
                AnalyticsUtil.reportError(e2, "warning", e2.getLocalizedMessage());
                return AnalyticsConstants.NOT_AVAILABLE;
            }
        } else {
            ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
            throw null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005e, code lost:
        if (r0.isConnected() != false) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006a, code lost:
        if ((!r0.isConnected()) != false) goto L_0x0070;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.razorpay.J$_0_ getDataNetworkType(android.content.Context r6) {
        /*
            int r0 = a_$P$
            int r0 = r0 + 13
            int r1 = r0 % 128
            d__1_ = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0010
            r0 = 0
            goto L_0x0011
        L_0x0010:
            r0 = 1
        L_0x0011:
            java.lang.String r3 = "android.permission.ACCESS_NETWORK_STATE"
            r4 = 0
            if (r0 == 0) goto L_0x009d
            boolean r0 = hasPermission(r6, r3)
            if (r0 == 0) goto L_0x009a
            java.lang.String r0 = "connectivity"
            java.lang.Object r6 = getSystemService(r6, r0)
            android.net.ConnectivityManager r6 = (android.net.ConnectivityManager) r6
            if (r6 == 0) goto L_0x009a
            android.net.NetworkInfo r0 = r6.getNetworkInfo(r2)
            if (r0 == 0) goto L_0x0044
            boolean r0 = r0.isConnected()
            if (r0 == 0) goto L_0x0044
            int r6 = d__1_
            int r6 = r6 + 69
            int r0 = r6 % 128
            a_$P$ = r0
            int r6 = r6 % 2
            if (r6 != 0) goto L_0x0041
            com.razorpay.J$_0_ r6 = com.razorpay.J$_0_.WIFI
            return r6
        L_0x0041:
            com.razorpay.J$_0_ r6 = com.razorpay.J$_0_.WIFI
            throw r4
        L_0x0044:
            r0 = 7
            android.net.NetworkInfo r0 = r6.getNetworkInfo(r0)
            if (r0 == 0) goto L_0x0070
            int r3 = d__1_
            int r3 = r3 + 101
            int r5 = r3 % 128
            a_$P$ = r5
            int r3 = r3 % 2
            if (r3 == 0) goto L_0x0061
            boolean r0 = r0.isConnected()
            r3 = 13
            int r3 = r3 / r1
            if (r0 == 0) goto L_0x0070
            goto L_0x006d
        L_0x0061:
            boolean r0 = r0.isConnected()
            if (r0 == 0) goto L_0x0069
            r0 = 0
            goto L_0x006a
        L_0x0069:
            r0 = 1
        L_0x006a:
            if (r0 == 0) goto L_0x006d
            goto L_0x0070
        L_0x006d:
            com.razorpay.J$_0_ r6 = com.razorpay.J$_0_.BLUETOOTH
            return r6
        L_0x0070:
            android.net.NetworkInfo r6 = r6.getNetworkInfo(r1)
            r0 = 10
            if (r6 == 0) goto L_0x007b
            r3 = 10
            goto L_0x007d
        L_0x007b:
            r3 = 77
        L_0x007d:
            if (r3 == r0) goto L_0x0080
            goto L_0x009a
        L_0x0080:
            boolean r6 = r6.isConnected()
            if (r6 == 0) goto L_0x0087
            r1 = 1
        L_0x0087:
            if (r1 == r2) goto L_0x008a
            goto L_0x009a
        L_0x008a:
            com.razorpay.J$_0_ r6 = com.razorpay.J$_0_.CELLULAR
            int r0 = a_$P$
            int r0 = r0 + 105
            int r1 = r0 % 128
            d__1_ = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x0099
            return r6
        L_0x0099:
            throw r4
        L_0x009a:
            com.razorpay.J$_0_ r6 = com.razorpay.J$_0_.UNKNOWN
            return r6
        L_0x009d:
            hasPermission(r6, r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.razorpay.BaseUtils.getDataNetworkType(android.content.Context):com.razorpay.J$_0_");
    }

    public static Map<String, String> getDeviceAttributes(Context context) {
        String str;
        HashMap hashMap = new HashMap();
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
            int i = a_$P$ + 5;
            d__1_ = i % 128;
            int i2 = i % 2;
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            hashMap.put(ConfigConstant.DEVICE_ID, O__Y_.d__1_(context).getString(Constant.ADVERTISIING_ID, null));
            if ((VERSION.SDK_INT <= 28 ? 16 : Tokenizer.FF) != 12) {
                if (!(telephonyManager != null)) {
                    str = "null";
                } else {
                    int i3 = d__1_ + 1;
                    a_$P$ = i3 % 128;
                    if ((i3 % 2 != 0 ? (char) 19 : 23) == 23) {
                        str = telephonyManager.getSimSerialNumber();
                    } else {
                        telephonyManager.getSimSerialNumber();
                        throw null;
                    }
                }
                hashMap.put("sim_serial_number", str);
            } else {
                hashMap.put("sim_serial_number", PERMISSION_DISABLED);
                hashMap.put("build_unique_id", UUID.randomUUID().toString());
            }
        } else {
            hashMap.put(ConfigConstant.DEVICE_ID, PERMISSION_DISABLED);
            hashMap.put("sim_serial_number", PERMISSION_DISABLED);
        }
        hashMap.put("device_manufacturer", Build.MANUFACTURER);
        hashMap.put(OneSingnalConstant.TAG_DEVICE_MODEL, Build.MODEL);
        return hashMap;
    }

    public static void getDeviceParamValues(final Context context, final RzpJSONCallback rzpJSONCallback) {
        final JSONObject jSONObject = new JSONObject();
        try {
            fetchIP(new RzpJSONCallback() {
                public final void onResponse(JSONObject jSONObject) {
                    try {
                        if (jSONObject.getString(CreateSFSGameRequest.KEY_INVITATION_PARAMS) != null) {
                            BaseUtils.access$102(jSONObject.getString(CreateSFSGameRequest.KEY_INVITATION_PARAMS));
                        }
                    } catch (JSONException unused) {
                    }
                }
            });
            AdvertisingIdUtil.Q_$2$(context, new d__1_() {
                public final void Q_$2$(String str) {
                    try {
                        jSONObject.put(Constant.ADVERTISIING_ID, str);
                        jSONObject.put("is_roming", BaseUtils.isNetworkRoaming(context));
                        jSONObject.put("carrier_network", BaseUtils.getCarrierOperatorName(context));
                        jSONObject.put("carrier_Id", "null");
                        Map<String, String> deviceAttributes = BaseUtils.getDeviceAttributes(context);
                        jSONObject.put("device_Id", deviceAttributes.get(ConfigConstant.DEVICE_ID));
                        jSONObject.put("device_manufacturer", deviceAttributes.get("device_manufacturer"));
                        jSONObject.put(OneSingnalConstant.TAG_DEVICE_MODEL, deviceAttributes.get(OneSingnalConstant.TAG_DEVICE_MODEL));
                        jSONObject.put("serial_number", BaseUtils.buildSerial());
                        jSONObject.put("ip_address", BaseUtils.access$100());
                        jSONObject.put("wifi_ssid", BaseUtils.getWifiSSID(context));
                        jSONObject.put("android_id", BaseUtils.getAndroidId(context));
                        jSONObject.put("safety_net basic_integrity", BaseParser.TRUE);
                        jSONObject.put("safety_net_cts_profile_match", "null");
                        rzpJSONCallback.onResponse(jSONObject);
                    } catch (JSONException e2) {
                        AnalyticsUtil.reportError(e2, "warning", e2.getMessage());
                    }
                }
            });
            int i = d__1_ + 7;
            a_$P$ = i % 128;
            char c2 = 2;
            if (i % 2 == 0) {
                c2 = 25;
            }
            if (c2 != 25) {
                throw null;
            }
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2, "warning", e2.getMessage());
        }
    }

    public static int getDisplayHeight(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        int i2 = a_$P$ + 29;
        d__1_ = i2 % 128;
        if ((i2 % 2 == 0 ? '$' : 21) == 21) {
            return i;
        }
        throw null;
    }

    public static int getDisplayWidth(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = a_$P$ + 21;
        d__1_ = i2 % 128;
        if (!(i2 % 2 == 0)) {
            return i;
        }
        throw null;
    }

    public static String getFileFromInternal(Activity activity, String str, String str2) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(activity.openFileInput(getVersionedAssetName(getLocalVersion(activity, str2).toString(), str)), "UTF-8"));
        StringBuilder sb = new StringBuilder();
        int i = a_$P$ + 25;
        d__1_ = i % 128;
        int i2 = i % 2;
        while (true) {
            String readLine = bufferedReader.readLine();
            if ((readLine != null ? (char) 6 : 13) != 6) {
                bufferedReader.close();
                return decryptFile(sb.toString());
            }
            int i3 = d__1_ + 115;
            a_$P$ = i3 % 128;
            int i4 = i3 % 2;
            sb.append(readLine);
        }
    }

    public static JSONObject getJSONFromIntentData(Intent intent) {
        JSONObject jSONObject = new JSONObject();
        if (intent != null) {
            int i = a_$P$ + 81;
            d__1_ = i % 128;
            if (i % 2 != 0) {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    Iterator it = extras.keySet().iterator();
                    while (it.hasNext()) {
                        int i2 = d__1_ + 105;
                        a_$P$ = i2 % 128;
                        if (!(i2 % 2 != 0)) {
                            String str = (String) it.next();
                            try {
                                jSONObject.put(str, extras.get(str));
                            } catch (JSONException e2) {
                                AnalyticsUtil.reportError(e2, AnalyticsConstants.ERROR_EXCEPTION, e2.getLocalizedMessage());
                            }
                        } else {
                            String str2 = (String) it.next();
                            jSONObject.put(str2, extras.get(str2));
                            throw null;
                        }
                    }
                }
            } else {
                intent.getExtras();
                throw null;
            }
        }
        return jSONObject;
    }

    public static Object getJsonValue(String str, JSONObject jSONObject, Object obj) {
        Object jsonValue = getJsonValue(str.split("\\."), (Object) jSONObject, 0);
        if ((jsonValue != null ? '-' : '7') != '7') {
            int i = a_$P$ + 27;
            d__1_ = i % 128;
            int i2 = i % 2;
            return jsonValue;
        }
        int i3 = a_$P$ + 31;
        d__1_ = i3 % 128;
        if ((i3 % 2 == 0 ? 'X' : ']') != 'X') {
            return obj;
        }
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004b, code lost:
        if ((r3.metaData == null ? 14 : 'J') != 14) goto L_0x004d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getKeyId(android.content.Context r3) {
        /*
            int r0 = d__1_
            int r0 = r0 + 115
            int r1 = r0 % 128
            a_$P$ = r1
            int r0 = r0 % 2
            r1 = 69
            if (r0 == 0) goto L_0x0011
            r0 = 69
            goto L_0x0013
        L_0x0011:
            r0 = 91
        L_0x0013:
            r2 = 0
            if (r0 == r1) goto L_0x0032
            android.content.pm.PackageManager r0 = r3.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0061 }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ NameNotFoundException -> 0x0061 }
            r1 = 128(0x80, float:1.8E-43)
            android.content.pm.ApplicationInfo r3 = r0.getApplicationInfo(r3, r1)     // Catch:{ NameNotFoundException -> 0x0061 }
            android.os.Bundle r0 = r3.metaData     // Catch:{ NameNotFoundException -> 0x0061 }
            r1 = 65
            if (r0 != 0) goto L_0x002d
            r0 = 84
            goto L_0x002f
        L_0x002d:
            r0 = 65
        L_0x002f:
            if (r0 == r1) goto L_0x004d
            goto L_0x0060
        L_0x0032:
            android.content.pm.PackageManager r0 = r3.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0061 }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ NameNotFoundException -> 0x0061 }
            r1 = 5842(0x16d2, float:8.186E-42)
            android.content.pm.ApplicationInfo r3 = r0.getApplicationInfo(r3, r1)     // Catch:{ NameNotFoundException -> 0x0061 }
            android.os.Bundle r0 = r3.metaData     // Catch:{ NameNotFoundException -> 0x0061 }
            r1 = 14
            if (r0 != 0) goto L_0x0049
            r0 = 14
            goto L_0x004b
        L_0x0049:
            r0 = 74
        L_0x004b:
            if (r0 == r1) goto L_0x0060
        L_0x004d:
            android.os.Bundle r3 = r3.metaData     // Catch:{ NameNotFoundException -> 0x0061 }
            java.lang.String r0 = "com.razorpay.ApiKey"
            java.lang.String r3 = r3.getString(r0)     // Catch:{ NameNotFoundException -> 0x0061 }
            int r0 = d__1_
            int r0 = r0 + 43
            int r1 = r0 % 128
            a_$P$ = r1
            int r0 = r0 % 2
            return r3
        L_0x0060:
            return r2
        L_0x0061:
            r3 = move-exception
            java.lang.String r0 = r3.getMessage()
            java.lang.String r1 = "critical"
            com.razorpay.AnalyticsUtil.reportError(r3, r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.razorpay.BaseUtils.getKeyId(android.content.Context):java.lang.String");
    }

    public static List<ResolveInfo> getListOfAppsWhichHandleDeepLink(Context context, String str) {
        Intent intent = new Intent();
        intent.setData(Uri.parse(str));
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 131072);
        int i = d__1_ + 117;
        a_$P$ = i % 128;
        int i2 = i % 2;
        return queryIntentActivities;
    }

    public static String getLocalVersion(Activity activity, String str) {
        int i = d__1_ + 19;
        a_$P$ = i % 128;
        int i2 = i % 2;
        String G__G_ = O__Y_.G__G_(activity, str);
        if (!(G__G_ == null)) {
            return G__G_;
        }
        String versionFromJsonString = getVersionFromJsonString("{\n  \"hash\" : \"c1765e36597259555155225b5d2c7962\",\n  \"magic_hash\": \"c23e7bd19a918dc3858102e78c8a41d9\"\n}\n", str);
        int i3 = d__1_ + 27;
        a_$P$ = i3 % 128;
        int i4 = i3 % 2;
        return versionFromJsonString;
    }

    public static String getLocale() {
        StringBuilder sb = new StringBuilder();
        sb.append(Locale.getDefault().getLanguage());
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        sb.append(Locale.getDefault().getCountry());
        String obj = sb.toString();
        int i = a_$P$ + 121;
        d__1_ = i % 128;
        if ((i % 2 == 0 ? '#' : 19) != 19) {
            int i2 = 1 / 0;
        }
        return obj;
    }

    public static HashMap<String, String> getMapFromJSONObject(JSONObject jSONObject) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            Iterator<String> keys = jSONObject.keys();
            int i = d__1_ + 45;
            a_$P$ = i % 128;
            while (true) {
                int i2 = i % 2;
                if ((keys.hasNext() ? 'G' : 'O') == 'O') {
                    break;
                }
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
                i = d__1_ + 113;
                a_$P$ = i % 128;
            }
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2, AnalyticsConstants.ERROR_EXCEPTION, e2.getMessage());
            e2.printStackTrace();
        }
        return hashMap;
    }

    public static int getNetworkType(Context context) {
        J$_0_ dataNetworkType = getDataNetworkType(context);
        int i = 1;
        if (dataNetworkType == J$_0_.WIFI) {
            int i2 = d__1_ + 11;
            a_$P$ = i2 % 128;
            if (i2 % 2 == 0) {
                i = 0;
            }
            int i3 = a_$P$ + 123;
            d__1_ = i3 % 128;
            if ((i3 % 2 == 0 ? 'Q' : '6') == '6') {
                return i;
            }
            throw null;
        } else if (dataNetworkType == J$_0_.BLUETOOTH) {
            int i4 = d__1_ + 43;
            a_$P$ = i4 % 128;
            int i5 = i4 % 2;
            return 1;
        } else {
            if ((dataNetworkType == J$_0_.CELLULAR ? (char) 16 : 14) != 14) {
                String cellularNetworkType = getCellularNetworkType(context);
                if (cellularNetworkType.equalsIgnoreCase(AnalyticsConstants.NETWORK_2G)) {
                    return 2;
                }
                if (cellularNetworkType.equalsIgnoreCase(AnalyticsConstants.NETWORK_3G)) {
                    int i6 = d__1_ + 85;
                    a_$P$ = i6 % 128;
                    if (i6 % 2 != 0) {
                        return 2;
                    }
                    return 3;
                }
                if ((cellularNetworkType.equalsIgnoreCase(AnalyticsConstants.NETWORK_4G) ? '_' : 25) != 25) {
                    int i7 = d__1_ + 125;
                    a_$P$ = i7 % 128;
                    if (i7 % 2 != 0) {
                    }
                    return 4;
                }
            }
            return -1;
        }
    }

    public static String getRandomString() {
        String bigInteger = new BigInteger(130, new SecureRandom()).toString(32);
        int i = d__1_ + 49;
        a_$P$ = i % 128;
        if ((i % 2 != 0 ? 25 : '.') != 25) {
            return bigInteger;
        }
        throw null;
    }

    public static JSONObject getResponseJson(HttpsURLConnection httpsURLConnection) throws IOException, JSONException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
        StringBuilder sb = new StringBuilder();
        int i = d__1_ + 95;
        a_$P$ = i % 128;
        while (true) {
            int i2 = i % 2;
            String readLine = bufferedReader.readLine();
            if ((readLine != null ? 'c' : 9) != 'c') {
                bufferedReader.close();
                return new JSONObject(sb.toString());
            }
            int i3 = d__1_ + 101;
            a_$P$ = i3 % 128;
            if (i3 % 2 != 0) {
                sb.append(readLine);
                int i4 = 80 / 0;
            } else {
                sb.append(readLine);
            }
            i = a_$P$ + 45;
            d__1_ = i % 128;
        }
    }

    public static HashSet<String> getSetOfPackageNamesSupportingUpi(Context context) {
        List<ResolveInfo> listOfAppsWhichHandleDeepLink = getListOfAppsWhichHandleDeepLink(context, BaseConstants.UPI_URL_SCHEMA);
        HashSet<String> hashSet = new HashSet<>();
        if (listOfAppsWhichHandleDeepLink != null && listOfAppsWhichHandleDeepLink.size() > 0) {
            Iterator<ResolveInfo> it = listOfAppsWhichHandleDeepLink.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                try {
                    hashSet.add(it.next().activityInfo.packageName);
                } catch (Exception e2) {
                    AnalyticsUtil.reportError(e2, "critical", e2.getLocalizedMessage());
                }
            }
        }
        if ((hashSet.size() > 0 ? 'U' : 'W') != 'W' && !checkUpiRegisteredApp(context, BaseConstants.GOOGLE_PAY_PKG)) {
            int i = d__1_ + 97;
            a_$P$ = i % 128;
            if (i % 2 != 0) {
                hashSet.remove(BaseConstants.GOOGLE_PAY_PKG);
                int i2 = 97 / 0;
            } else {
                hashSet.remove(BaseConstants.GOOGLE_PAY_PKG);
            }
        }
        if (hashSet.size() > 0) {
            int i3 = a_$P$ + 81;
            d__1_ = i3 % 128;
            int i4 = i3 % 2;
            if ((!checkUpiRegisteredApp(context, BaseConstants.TRUE_CALLER_PKG) ? 'Z' : 18) == 'Z') {
                int i5 = d__1_ + 27;
                a_$P$ = i5 % 128;
                if (i5 % 2 == 0) {
                    hashSet.remove(BaseConstants.TRUE_CALLER_PKG);
                } else {
                    hashSet.remove(BaseConstants.TRUE_CALLER_PKG);
                    throw null;
                }
            }
        }
        return hashSet;
    }

    public static <T> T getSystemService(Context context, String str) {
        int i = d__1_ + 105;
        a_$P$ = i % 128;
        boolean z = i % 2 != 0;
        Context applicationContext = context.getApplicationContext();
        if (!z) {
            return applicationContext.getSystemService(str);
        }
        applicationContext.getSystemService(str);
        throw null;
    }

    public static String getVersionFromJsonString(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            boolean z = false;
            if (!(str2.equalsIgnoreCase("otpelf_version"))) {
                if (str2.equalsIgnoreCase("magic_version")) {
                    z = true;
                }
                if (z) {
                    int i = d__1_ + 69;
                    a_$P$ = i % 128;
                    if (i % 2 == 0) {
                        return jSONObject.getString("magic_hash");
                    }
                    jSONObject.getString("magic_hash");
                    throw null;
                }
                return null;
            }
            int i2 = a_$P$ + 11;
            d__1_ = i2 % 128;
            int i3 = i2 % 2;
            String string = jSONObject.getString(Response.HASH);
            int i4 = a_$P$ + 53;
            d__1_ = i4 % 128;
            int i5 = i4 % 2;
            return string;
        } catch (Exception unused) {
        }
    }

    public static String getVersionedAssetName(String str, String str2) {
        String replaceAll = str.replaceAll("\\.", Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        StringBuilder sb = new StringBuilder();
        sb.append(replaceAll);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        sb.append(str2);
        String obj = sb.toString();
        int i = a_$P$ + 59;
        d__1_ = i % 128;
        if ((i % 2 == 0 ? '&' : 21) == 21) {
            return obj;
        }
        throw null;
    }

    public static CharSequence getWebViewUserAgent(Context context) {
        CharSequence returnUndefinedIfNull = AnalyticsUtil.returnUndefinedIfNull(new WebView(context).getSettings().getUserAgentString());
        int i = d__1_ + 65;
        a_$P$ = i % 128;
        int i2 = i % 2;
        return returnUndefinedIfNull;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
        if ((r4.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) != true) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002d, code lost:
        r4 = ((android.net.wifi.WifiManager) r4.getApplicationContext().getSystemService(com.razorpay.AnalyticsConstants.WIFI)).getConnectionInfo().getSSID();
        r0 = a_$P$ + 41;
        d__1_ = r0 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004b, code lost:
        if ((r0 % 2) != 0) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004d, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004e, code lost:
        if (r1 == true) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
        throw null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
        if (r4.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) goto L_0x002d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getWifiSSID(android.content.Context r4) {
        /*
            int r0 = a_$P$
            int r0 = r0 + 101
            int r1 = r0 % 128
            d__1_ = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            java.lang.String r3 = "android.permission.ACCESS_WIFI_STATE"
            if (r0 == 0) goto L_0x001f
            int r0 = r4.checkCallingOrSelfPermission(r3)
            r3 = 15
            int r3 = r3 / r1
            if (r0 != 0) goto L_0x002a
            goto L_0x002d
        L_0x001f:
            int r0 = r4.checkCallingOrSelfPermission(r3)
            if (r0 != 0) goto L_0x0027
            r0 = 1
            goto L_0x0028
        L_0x0027:
            r0 = 0
        L_0x0028:
            if (r0 == r2) goto L_0x002d
        L_0x002a:
            java.lang.String r4 = PERMISSION_DISABLED
            return r4
        L_0x002d:
            android.content.Context r4 = r4.getApplicationContext()
            java.lang.String r0 = "wifi"
            java.lang.Object r4 = r4.getSystemService(r0)
            android.net.wifi.WifiManager r4 = (android.net.wifi.WifiManager) r4
            android.net.wifi.WifiInfo r4 = r4.getConnectionInfo()
            java.lang.String r4 = r4.getSSID()
            int r0 = a_$P$
            int r0 = r0 + 41
            int r3 = r0 % 128
            d__1_ = r3
            int r0 = r0 % 2
            if (r0 != 0) goto L_0x004e
            r1 = 1
        L_0x004e:
            if (r1 == r2) goto L_0x0051
            return r4
        L_0x0051:
            r4 = 0
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.razorpay.BaseUtils.getWifiSSID(android.content.Context):java.lang.String");
    }

    public static Certificate getX509Certificate(SslCertificate sslCertificate) {
        int i = d__1_ + 125;
        a_$P$ = i % 128;
        if (i % 2 == 0) {
            byte[] byteArray = SslCertificate.saveState(sslCertificate).getByteArray("x509-certificate");
            boolean z = false;
            if (!(byteArray != null)) {
                int i2 = a_$P$ + 117;
                d__1_ = i2 % 128;
                if (i2 % 2 == 0) {
                    z = true;
                }
                if (!z) {
                    return null;
                }
                throw null;
            }
            try {
                return CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(byteArray));
            } catch (CertificateException e2) {
                AnalyticsUtil.reportError(e2, "critical", e2.getLocalizedMessage());
                return null;
            }
        } else {
            SslCertificate.saveState(sslCertificate).getByteArray("x509-certificate");
            throw null;
        }
    }

    public static boolean hasFeature(Context context, String str) {
        int i = a_$P$ + 77;
        d__1_ = i % 128;
        char c2 = i % 2 == 0 ? '^' : '2';
        PackageManager packageManager = context.getPackageManager();
        if (c2 == '2') {
            boolean hasSystemFeature = packageManager.hasSystemFeature(str);
            int i2 = d__1_ + 115;
            a_$P$ = i2 % 128;
            if ((i2 % 2 != 0 ? 5 : 'M') != 'M') {
                int i3 = 70 / 0;
            }
            return hasSystemFeature;
        }
        packageManager.hasSystemFeature(str);
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
        if ((r4.checkCallingOrSelfPermission(r5) == 0 ? '(' : 23) != '(') goto L_0x0032;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean hasPermission(android.content.Context r4, java.lang.String r5) {
        /*
            int r0 = d__1_
            int r0 = r0 + 49
            int r1 = r0 % 128
            a_$P$ = r1
            int r0 = r0 % 2
            r1 = 53
            if (r0 == 0) goto L_0x0011
            r0 = 53
            goto L_0x0013
        L_0x0011:
            r0 = 86
        L_0x0013:
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L_0x0023
            int r4 = r4.checkCallingOrSelfPermission(r5)     // Catch:{ Exception -> 0x003e }
            if (r4 != 0) goto L_0x001f
            r4 = 1
            goto L_0x0020
        L_0x001f:
            r4 = 0
        L_0x0020:
            if (r4 == r2) goto L_0x0033
            goto L_0x0032
        L_0x0023:
            int r4 = r4.checkCallingOrSelfPermission(r5)     // Catch:{ Exception -> 0x003e }
            r5 = 40
            if (r4 != 0) goto L_0x002e
            r4 = 40
            goto L_0x0030
        L_0x002e:
            r4 = 23
        L_0x0030:
            if (r4 == r5) goto L_0x0033
        L_0x0032:
            return r3
        L_0x0033:
            int r4 = a_$P$
            int r4 = r4 + 33
            int r5 = r4 % 128
            d__1_ = r5
            int r4 = r4 % 2
            return r2
        L_0x003e:
            r4 = move-exception
            java.lang.String r5 = r4.getMessage()
            java.lang.String r0 = "critical"
            com.razorpay.AnalyticsUtil.reportError(r4, r0, r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.razorpay.BaseUtils.hasPermission(android.content.Context, java.lang.String):boolean");
    }

    public static String installedApps(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            Iterator<ApplicationInfo> it = context.getPackageManager().getInstalledApplications(0).iterator();
            while (true) {
                if ((it.hasNext() ? '5' : 'R') != '5') {
                    return sb.toString();
                }
                ApplicationInfo next = it.next();
                if (((next.flags & 1) == 0 ? 8 : 'B') == 8) {
                    int i = d__1_ + 99;
                    a_$P$ = i % 128;
                    if (i % 2 == 0) {
                        if (sb.length() != 0) {
                            sb.append(",");
                        }
                        sb.append(next.packageName);
                    } else {
                        sb.length();
                        throw null;
                    }
                }
                int i2 = a_$P$ + 51;
                d__1_ = i2 % 128;
                int i3 = i2 % 2;
            }
        } catch (Throwable unused) {
            return "Apps not available";
        }
    }

    public static boolean isDeviceHaveCorrectTlsVersion() {
        int i = d__1_ + 121;
        a_$P$ = i % 128;
        if (i % 2 == 0) {
            try {
                String[] protocols = SSLContext.getDefault().getDefaultSSLParameters().getProtocols();
                if ((protocols == null ? '?' : 28) != 28) {
                    return false;
                }
                int length = protocols.length;
                int i2 = 0;
                while (i2 < length) {
                    int i3 = d__1_ + 115;
                    a_$P$ = i3 % 128;
                    if (i3 % 2 == 0) {
                        String str = protocols[i2];
                        if (!str.startsWith(SSLSocketFactoryFactory.DEFAULT_PROTOCOL) || str.equalsIgnoreCase("TLSv1")) {
                            i2++;
                        } else {
                            int i4 = a_$P$ + 85;
                            d__1_ = i4 % 128;
                            if ((i4 % 2 == 0 ? '2' : '9') != '9') {
                                return false;
                            }
                            return true;
                        }
                    } else {
                        protocols[i2].startsWith(SSLSocketFactoryFactory.DEFAULT_PROTOCOL);
                        throw null;
                    }
                }
            } catch (NoSuchAlgorithmException e2) {
                AnalyticsUtil.reportError(e2, "critical", e2.getMessage());
            }
        } else {
            SSLContext.getDefault().getDefaultSSLParameters().getProtocols();
            throw null;
        }
        int i5 = a_$P$ + 87;
        d__1_ = i5 % 128;
        int i6 = i5 % 2;
        return false;
    }

    public static boolean isMerchantAppDebuggable(Context context) {
        if (((context.getApplicationInfo().flags & 2) != 0 ? 'V' : 'Q') != 'Q') {
            int i = a_$P$ + 93;
            d__1_ = i % 128;
            return i % 2 != 0;
        }
        int i2 = d__1_ + 87;
        a_$P$ = i2 % 128;
        if ((i2 % 2 != 0 ? '9' : '$') == '$') {
            return false;
        }
        throw null;
    }

    private boolean isMocked(Context context, Location location) {
        int i = d__1_ + 1;
        a_$P$ = i % 128;
        int i2 = i % 2;
        boolean isFromMockProvider = location.isFromMockProvider();
        int i3 = d__1_ + 119;
        a_$P$ = i3 % 128;
        if (i3 % 2 == 0) {
            return isFromMockProvider;
        }
        throw null;
    }

    public static boolean isNetworkRoaming(Context context) {
        int i = a_$P$ + 81;
        d__1_ = i % 128;
        int i2 = i % 2;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if ((telephonyManager != null ? '+' : 'R') != '+') {
            return false;
        }
        int i3 = a_$P$ + 59;
        d__1_ = i3 % 128;
        int i4 = i3 % 2;
        return telephonyManager.isNetworkRoaming();
    }

    public static Boolean isUserRegisteredOnTruePay(Context context) {
        boolean z;
        try {
            boolean z2 = true;
            if ((context.getPackageManager().getComponentEnabledSetting(new ComponentName(BaseConstants.TRUE_CALLER_PKG, "com.truecaller.truepay.UserRegistered")) == 1 ? 26 : StringEscapeUtils.CSV_QUOTE) != '\"') {
                int i = a_$P$ + 15;
                d__1_ = i % 128;
                int i2 = i % 2;
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            int i3 = a_$P$ + 11;
            d__1_ = i3 % 128;
            if (i3 % 2 == 0) {
                z2 = false;
            }
            if (z2) {
                return valueOf;
            }
            throw null;
        } catch (Exception e2) {
            e2.printStackTrace();
            AnalyticsUtil.reportError(e2, "error", e2.getMessage());
            return Boolean.FALSE;
        }
    }

    public static ArrayList<String> jsonStringArrayToArrayList(JSONArray jSONArray) throws Exception {
        ArrayList<String> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            if (!(i < jSONArray.length())) {
                int i2 = a_$P$ + 25;
                d__1_ = i2 % 128;
                int i3 = i2 % 2;
                return arrayList;
            }
            int i4 = d__1_ + 97;
            a_$P$ = i4 % 128;
            int i5 = i4 % 2;
            arrayList.add(jSONArray.getString(i));
            i++;
        }
    }

    public static String makeUrlEncodedPayload(JSONObject jSONObject) throws JSONException {
        StringBuilder sb = new StringBuilder();
        Iterator<String> keys = jSONObject.keys();
        while (true) {
            if (!(!keys.hasNext())) {
                String next = keys.next();
                sb.append(String.format("%s=%s&", new Object[]{next, Uri.encode(jSONObject.getString(next))}));
                int i = a_$P$ + 3;
                d__1_ = i % 128;
                int i2 = i % 2;
            } else {
                String obj = sb.deleteCharAt(sb.length() - 1).toString();
                int i3 = d__1_ + 3;
                a_$P$ = i3 % 128;
                int i4 = i3 % 2;
                return obj;
            }
        }
    }

    public static String nanoTimeToSecondsString(long j, int i) {
        int i2 = a_$P$ + 69;
        d__1_ = i2 % 128;
        int i3 = i2 % 2;
        String valueOf = String.valueOf(round(((double) j) / 1.0E9d, i));
        int i4 = d__1_ + 19;
        a_$P$ = i4 % 128;
        int i5 = i4 % 2;
        return valueOf;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003a, code lost:
        throw new java.lang.IllegalArgumentException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0016, code lost:
        if (r5 >= 0) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0019, code lost:
        if (r5 >= 0) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static double round(double r3, int r5) {
        /*
            int r0 = d__1_
            int r0 = r0 + 13
            int r1 = r0 % 128
            a_$P$ = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0010
            r0 = 0
            goto L_0x0011
        L_0x0010:
            r0 = 1
        L_0x0011:
            if (r0 == r2) goto L_0x0019
            r0 = 74
            int r0 = r0 / r1
            if (r5 < 0) goto L_0x0035
            goto L_0x001b
        L_0x0019:
            if (r5 < 0) goto L_0x0035
        L_0x001b:
            java.math.BigDecimal r0 = new java.math.BigDecimal
            r0.<init>(r3)
            java.math.RoundingMode r3 = java.math.RoundingMode.HALF_UP
            java.math.BigDecimal r3 = r0.setScale(r5, r3)
            double r3 = r3.doubleValue()
            int r5 = a_$P$
            int r5 = r5 + 53
            int r0 = r5 % 128
            d__1_ = r0
            int r5 = r5 % 2
            return r3
        L_0x0035:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            r3.<init>()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.razorpay.BaseUtils.round(double, int):double");
    }

    public static void setBaseWebViewSettings() {
        int i = d__1_ + 49;
        a_$P$ = i % 128;
        if ((i % 2 == 0) || 48 == 48) {
            WebView.setWebContentsDebuggingEnabled(sWebViewDebuggingEnabled);
        }
        int i2 = a_$P$ + 25;
        d__1_ = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    public static void setCompatibleWithGooglePay(boolean z) {
        int i = d__1_ + 53;
        a_$P$ = i % 128;
        char c2 = i % 2 != 0 ? '[' : '=';
        isCompatibleWithGooglePay = z;
        if (c2 == '[') {
            throw null;
        }
    }

    public static void setWebViewSettings(Context context, WebView webView, boolean z) {
        int i = a_$P$ + 37;
        d__1_ = i % 128;
        int i2 = i % 2;
        setBaseWebViewSettings();
        enableJavaScriptInWebView(webView);
        CookieManager.getInstance().setAcceptCookie(true);
        webView.setTag("");
        WebSettings settings = webView.getSettings();
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setTextZoom(100);
        String path = context.getApplicationContext().getDir("database", 0).getPath();
        if ((VERSION.SDK_INT < 24 ? 'O' : 15) == 'O') {
            settings.setGeolocationDatabasePath(path);
        }
        if (27 == 27) {
            int i3 = a_$P$ + 35;
            d__1_ = i3 % 128;
            int i4 = i3 % 2;
            CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
        }
        if (z) {
            int i5 = a_$P$ + 23;
            d__1_ = i5 % 128;
            int i6 = i5 % 2;
            settings.setCacheMode(2);
        }
        settings.setSaveFormData(false);
        webView.addJavascriptInterface(new I$_e_(context), "StorageBridge");
    }

    public static void setup() {
        int i = a_$P$ + 111;
        d__1_ = i % 128;
        char c2 = i % 2 == 0 ? 7 : '$';
        AnalyticsUtil.reset();
        if (c2 != 7) {
            int i2 = d__1_ + 121;
            a_$P$ = i2 % 128;
            int i3 = i2 % 2;
            return;
        }
        throw null;
    }

    public static void startActivityForResult(String str, String str2, Activity activity) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        if (!(str2 == null)) {
            int i = d__1_ + 53;
            a_$P$ = i % 128;
            if (i % 2 != 0) {
                str2.length();
                throw null;
            } else if (str2.length() > 0) {
                intent.setPackage(str2);
                int i2 = a_$P$ + 31;
                d__1_ = i2 % 128;
                int i3 = i2 % 2;
            }
        }
        activity.startActivityForResult(intent, 99);
        int i4 = a_$P$ + 1;
        d__1_ = i4 % 128;
        int i5 = i4 % 2;
    }

    public static boolean storeFileInInternal(Activity activity, String str, String str2) {
        int i = d__1_ + 119;
        a_$P$ = i % 128;
        int i2 = i % 2;
        try {
            FileOutputStream openFileOutput = activity.openFileOutput(str, 0);
            openFileOutput.write(str2.getBytes());
            openFileOutput.close();
            int i3 = d__1_ + 39;
            a_$P$ = i3 % 128;
            int i4 = i3 % 2;
            return true;
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2, "error", "Error in saving file: ".concat(String.valueOf(str)));
            "Error in saving file: ".concat(String.valueOf(str));
            return false;
        }
    }

    public static void updateLocalVersion(Activity activity, String str, String str2) {
        int i = a_$P$ + 65;
        d__1_ = i % 128;
        char c2 = i % 2 == 0 ? 'L' : 'B';
        O__Y_.G__G_(activity, str, str2);
        if (c2 != 'B') {
            throw null;
        }
    }

    public String getAccounts(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.GET_ACCOUNTS") == 0) {
            StringBuilder sb = new StringBuilder();
            Account[] accounts = ((AccountManager) context.getSystemService(Device.ACCOUNT)).getAccounts();
            int length = accounts.length;
            int i = 0;
            while (i < length) {
                int i2 = a_$P$ + 77;
                d__1_ = i2 % 128;
                if (i2 % 2 != 0) {
                    sb.append(accounts[i].name);
                    sb.append(",");
                    i++;
                } else {
                    sb.append(accounts[i].name);
                    sb.append(",");
                    i += 67;
                }
            }
            return sb.toString();
        }
        String str = PERMISSION_DISABLED;
        int i3 = d__1_ + 91;
        a_$P$ = i3 % 128;
        if (!(i3 % 2 == 0)) {
            int i4 = 48 / 0;
        }
        return str;
    }

    public String getAvailableMemory(Context context) {
        MemoryInfo memoryInfo = new MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(memoryInfo.availMem / 1048576));
        sb.append("MB");
        String obj = sb.toString();
        int i = d__1_ + 73;
        a_$P$ = i % 128;
        int i2 = i % 2;
        return obj;
    }

    public String getBatteryLevel(Context context) {
        float intExtra;
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int i = d__1_ + 81;
            a_$P$ = i % 128;
            if ((i % 2 != 0 ? 31 : '*') != 31) {
                intExtra = ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
            } else {
                intExtra = ((float) registerReceiver.getIntExtra("level", -1)) - ((float) registerReceiver.getIntExtra("scale", -1));
            }
            return String.valueOf(intExtra * 100.0f);
        }
        int i2 = a_$P$ + 9;
        d__1_ = i2 % 128;
        int i3 = i2 % 2;
        return com.mpl.androidapp.updater.downloadmanager.utils.Constants.DOWNLOAD_STATUS_UNKNOWN;
    }

    public String getDeviceUptime() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(SystemClock.elapsedRealtime()));
        sb.append("ms");
        String obj = sb.toString();
        int i = d__1_ + 109;
        a_$P$ = i % 128;
        int i2 = i % 2;
        return obj;
    }

    public String getDisplayResolution(Context context) {
        int i = d__1_ + 51;
        a_$P$ = i % 128;
        int i2 = i % 2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        String format = String.format(Locale.ENGLISH, "%dx%dx%d", new Object[]{Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels), Integer.valueOf(displayMetrics.densityDpi)});
        int i3 = d__1_ + 79;
        a_$P$ = i3 % 128;
        if ((i3 % 2 != 0 ? ':' : '@') != ':') {
            return format;
        }
        int i4 = 70 / 0;
        return format;
    }

    public String getParentAppVersion(Context context) {
        PackageInfo packageInfo;
        int i = d__1_ + 31;
        a_$P$ = i % 128;
        if (i % 2 == 0) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (NameNotFoundException e2) {
                AnalyticsUtil.reportError(e2, AnalyticsConstants.ERROR_EXCEPTION, e2.getMessage());
                return "Permission Disabled";
            }
        } else {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
        }
        return packageInfo.versionName;
    }

    public String getRingtoneHash(Context context) {
        int i = d__1_ + 49;
        a_$P$ = i % 128;
        int i2 = i % 2;
        String MD5Hash = MD5Hash(RingtoneManager.getRingtone(context, RingtoneManager.getActualDefaultRingtoneUri(context, 1)).getTitle(context));
        int i3 = a_$P$ + 63;
        d__1_ = i3 % 128;
        int i4 = i3 % 2;
        return MD5Hash;
    }

    public String getScreenBrightness(Context context) {
        int i = a_$P$ + 99;
        d__1_ = i % 128;
        int i2 = i % 2;
        String string = System.getString(context.getContentResolver(), "screen_brightness");
        int i3 = d__1_ + 35;
        a_$P$ = i3 % 128;
        int i4 = i3 % 2;
        return string;
    }

    public String getScreenBrightnessMode(Context context) {
        int i = a_$P$ + 19;
        d__1_ = i % 128;
        int i2 = i % 2;
        String string = System.getString(context.getContentResolver(), "screen_brightness_mode");
        int i3 = a_$P$ + 125;
        d__1_ = i3 % 128;
        if ((i3 % 2 == 0 ? 'W' : 15) != 'W') {
            return string;
        }
        int i4 = 63 / 0;
        return string;
    }

    public String getScreenOffTimeout(Context context) {
        String string = System.getString(context.getContentResolver(), "screen_off_timeout");
        StringBuilder sb = new StringBuilder();
        sb.append(string);
        sb.append("ms");
        String obj = sb.toString();
        int i = a_$P$ + 11;
        d__1_ = i % 128;
        if (!(i % 2 == 0)) {
            return obj;
        }
        throw null;
    }

    public String getSystemFontSize(Context context) {
        int i = a_$P$ + 45;
        d__1_ = i % 128;
        int i2 = i % 2;
        String valueOf = String.valueOf(context.getResources().getConfiguration().fontScale);
        int i3 = a_$P$ + 83;
        d__1_ = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return valueOf;
        }
        throw null;
    }

    public String getTotalInternalStorage() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        String valueOf = String.valueOf(statFs.getBlockCountLong() * statFs.getBlockSizeLong());
        int i = d__1_ + 113;
        a_$P$ = i % 128;
        if (i % 2 == 0) {
            return valueOf;
        }
        throw null;
    }

    public String getWallpaperID(Context context) {
        if ((VERSION.SDK_INT >= 24 ? 'b' : '@') != '@') {
            int i = d__1_ + 53;
            a_$P$ = i % 128;
            int i2 = i % 2;
            WallpaperManager instance = WallpaperManager.getInstance(context);
            int wallpaperId = instance.getWallpaperId(1);
            return String.format(Locale.ENGLISH, "%d-%d", new Object[]{Integer.valueOf(instance.getWallpaperId(2)), Integer.valueOf(wallpaperId)});
        }
        String str = PERMISSION_DISABLED;
        int i3 = d__1_ + 61;
        a_$P$ = i3 % 128;
        int i4 = i3 % 2;
        return str;
    }

    public static Object getJsonValue(String[] strArr, Object obj, int i) {
        JSONArray jSONArray;
        while (i != strArr.length) {
            String str = strArr[i];
            if ((obj instanceof JSONObject ? '5' : '@') != '@') {
                obj = ((JSONObject) obj).opt(str);
            } else {
                if (obj instanceof JSONArray) {
                    int i2 = a_$P$ + 17;
                    d__1_ = i2 % 128;
                    if (i2 % 2 == 0) {
                        jSONArray = (JSONArray) obj;
                        int i3 = 75 / 0;
                        if ((TextUtils.isDigitsOnly(str) ? 'P' : 'V') == 'V') {
                        }
                    } else {
                        jSONArray = (JSONArray) obj;
                        if (!TextUtils.isDigitsOnly(str)) {
                        }
                    }
                    int i4 = a_$P$ + 111;
                    d__1_ = i4 % 128;
                    if ((i4 % 2 == 0 ? 'S' : '7') != '7') {
                        obj = jSONArray.opt(Integer.parseInt(str));
                        i %= 0;
                    } else {
                        obj = jSONArray.opt(Integer.parseInt(str));
                    }
                }
                return null;
            }
            i++;
        }
        int i5 = a_$P$ + 11;
        d__1_ = i5 % 128;
        if (i5 % 2 != 0) {
            return obj;
        }
        throw null;
    }
}
