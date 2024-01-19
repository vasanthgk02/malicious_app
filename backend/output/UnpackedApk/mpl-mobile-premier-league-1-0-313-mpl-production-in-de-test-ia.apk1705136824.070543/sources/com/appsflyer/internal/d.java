package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.appsflyer.AFLogger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.text.ExtendedMessageFormat;
import org.apache.fontbox.ttf.GlyfDescript;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.jboss.netty.handler.codec.http.HttpCodecUtil;

public final class d {
    public static int AFInAppEventParameterName = 654970919;
    public static int AFInAppEventType = 46;
    public static long AFKeystoreWrapper = 2500677876331219564L;
    public static int AFLogger$LogLevel = 1;
    public static short[] AppsFlyer2dXConversionCallback = null;
    public static int getLevel = 0;
    public static byte[] valueOf = {-28, 82, -75, -77, -75, -112, -75, 92, 78, -75, -126, 85, -75, -107, 1, -75, -75, -75, -23, 71, -72, 65, 77, 86, 97, -115, -73, 85, -82, 87, -74, 85, -67, 126, -114, -65, -66, -71, 74, -78, 73, -31, -89, 77, 119, -22, 95, -89, GlyfDescript.X_DUAL, -102, -85, -86, -83, 94, -90, 93, -44, 122, -32, 47, 35, -46, 37, -33, 96, -103, 32, 29, -21, -51, 51, -47, -40, 90, -94, -91, 89, -109, -5, -52, -26, -43, HttpCodecUtil.COMMA, -33, 46, 33, 40, -63, BaseParser.ASCII_NINE, 111, -110, -34, 33, -40, 125, -110, -34, BaseParser.ASCII_NINE, -37, 122, -111, -41, 47, 40, -44, 105, -122, 37, -44, 109, -101, -47, 126, -106, -43, -45, 41, HttpCodecUtil.DOUBLE_QUOTE, 49};
    public static int values = -1788657313;

    /* renamed from: com.appsflyer.internal.d$d  reason: collision with other inner class name */
    public static class C0063d extends HashMap<String, Object> {
        public static int[] AFKeystoreWrapper = {-1041640720, -580952221, -682261191, 1975752198, 1596100974, 33660823, -2012054640, 786855284, -687188837, -557632087, -1752968691, -601168586, 1741490382, -853106437, 593608985, 2118353676, 665220696, -441603600};
        public static boolean AFLogger$LogLevel = true;
        public static int AFVersionDeclaration = 0;
        public static boolean AppsFlyer2dXConversionCallback = true;
        public static int getLevel = 1;
        public static char[] valueOf = {385, 401, 384, 397, 387, 394, 388, 389, 392, 395, 319, 390, 403, 408, 406, 391, 407, 386, 399, 398, 345, 402, 363, 404, 355, 332, 333, 329, 335, 340, 339, 344, 336, 337, 343, 396, 341, 325, 400};
        public static int values = 287;
        public final Map<String, Object> AFInAppEventParameterName;
        public final Context AFInAppEventType;

        /* renamed from: com.appsflyer.internal.d$d$a */
        public static class a {
            public static boolean AFInAppEventParameterName = true;
            public static char[] AFInAppEventType = {265};
            public static int AFKeystoreWrapper = 0;
            public static int init = 1;
            public static int valueOf = 217;
            public static boolean values = true;

            public static String AFInAppEventParameterName(String str) throws Exception {
                String str2;
                int i = AFKeystoreWrapper + 33;
                init = i % 128;
                boolean z = false;
                boolean z2 = i % 2 != 0;
                byte[] AFInAppEventType2 = AFInAppEventType(str);
                if (!z2) {
                    str2 = valueOf(AFInAppEventParameterName(AFInAppEventType2));
                    int i2 = 19 / 0;
                } else {
                    str2 = valueOf(AFInAppEventParameterName(AFInAppEventType2));
                }
                int i3 = AFKeystoreWrapper + 35;
                init = i3 % 128;
                if (i3 % 2 != 0) {
                    z = true;
                }
                if (z) {
                    return str2;
                }
                throw null;
            }

            public static byte[] AFInAppEventType(String str) throws Exception {
                int i = init + 65;
                AFKeystoreWrapper = i % 128;
                int i2 = i % 2;
                byte[] bytes = str.getBytes();
                int i3 = AFKeystoreWrapper + 51;
                init = i3 % 128;
                if (!(i3 % 2 == 0)) {
                    return bytes;
                }
                throw null;
            }

            public static String valueOf(byte[] bArr) throws Exception {
                String str;
                StringBuilder sb = new StringBuilder();
                int length = bArr.length;
                int i = 0;
                while (true) {
                    if (!(i < length)) {
                        return sb.toString();
                    }
                    int i2 = init + 63;
                    AFKeystoreWrapper = i2 % 128;
                    if ((i2 % 2 != 0 ? '%' : 13) != 13) {
                        str = Integer.toHexString(bArr[i]);
                        if (str.length() != 0) {
                            sb.append(str);
                            i++;
                        }
                    } else {
                        String hexString = Integer.toHexString(bArr[i]);
                        if (hexString.length() == 1) {
                            str = hexString;
                        } else {
                            str = hexString;
                            sb.append(str);
                            i++;
                        }
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(AFInAppEventType(null, null, "", 126 - TextUtils.indexOf("", '0', 0)).intern());
                    sb2.append(str);
                    str = sb2.toString();
                    int i3 = init + 71;
                    AFKeystoreWrapper = i3 % 128;
                    int i4 = i3 % 2;
                    sb.append(str);
                    i++;
                }
            }

            public static byte[] AFInAppEventParameterName(byte[] bArr) throws Exception {
                int i = 0;
                int i2 = init + 55;
                AFKeystoreWrapper = i2 % 128;
                int i3 = i2 % 2;
                while (true) {
                    if ((i < bArr.length ? 'I' : 'X') != 'I') {
                        return bArr;
                    }
                    int i4 = AFKeystoreWrapper + 119;
                    init = i4 % 128;
                    int i5 = i4 % 2;
                    bArr[i] = (byte) (bArr[i] ^ ((i % 2) + 42));
                    i++;
                }
            }

            /* JADX WARNING: type inference failed for: r7v1 */
            /* JADX WARNING: type inference failed for: r5v1 */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public static java.lang.String AFInAppEventType(java.lang.String r5, int[] r6, java.lang.String r7, int r8) {
                /*
                    if (r7 == 0) goto L_0x0008
                    java.lang.String r0 = "ISO-8859-1"
                    byte[] r7 = r7.getBytes(r0)
                L_0x0008:
                    byte[] r7 = (byte[]) r7
                    if (r5 == 0) goto L_0x0010
                    char[] r5 = r5.toCharArray()
                L_0x0010:
                    char[] r5 = (char[]) r5
                    java.lang.Object r0 = com.appsflyer.internal.dq.valueOf
                    monitor-enter(r0)
                    char[] r1 = AFInAppEventType     // Catch:{ all -> 0x00a9 }
                    int r2 = valueOf     // Catch:{ all -> 0x00a9 }
                    boolean r3 = values     // Catch:{ all -> 0x00a9 }
                    r4 = 0
                    if (r3 == 0) goto L_0x004b
                    int r5 = r7.length     // Catch:{ all -> 0x00a9 }
                    com.appsflyer.internal.dq.AFInAppEventType = r5     // Catch:{ all -> 0x00a9 }
                    char[] r5 = new char[r5]     // Catch:{ all -> 0x00a9 }
                    com.appsflyer.internal.dq.AFInAppEventParameterName = r4     // Catch:{ all -> 0x00a9 }
                L_0x0025:
                    int r6 = com.appsflyer.internal.dq.AFInAppEventParameterName     // Catch:{ all -> 0x00a9 }
                    int r3 = com.appsflyer.internal.dq.AFInAppEventType     // Catch:{ all -> 0x00a9 }
                    if (r6 >= r3) goto L_0x0044
                    int r6 = com.appsflyer.internal.dq.AFInAppEventParameterName     // Catch:{ all -> 0x00a9 }
                    int r3 = com.appsflyer.internal.dq.AFInAppEventType     // Catch:{ all -> 0x00a9 }
                    int r3 = r3 + -1
                    int r4 = com.appsflyer.internal.dq.AFInAppEventParameterName     // Catch:{ all -> 0x00a9 }
                    int r3 = r3 - r4
                    byte r3 = r7[r3]     // Catch:{ all -> 0x00a9 }
                    int r3 = r3 + r8
                    char r3 = r1[r3]     // Catch:{ all -> 0x00a9 }
                    int r3 = r3 - r2
                    char r3 = (char) r3     // Catch:{ all -> 0x00a9 }
                    r5[r6] = r3     // Catch:{ all -> 0x00a9 }
                    int r6 = com.appsflyer.internal.dq.AFInAppEventParameterName     // Catch:{ all -> 0x00a9 }
                    int r6 = r6 + 1
                    com.appsflyer.internal.dq.AFInAppEventParameterName = r6     // Catch:{ all -> 0x00a9 }
                    goto L_0x0025
                L_0x0044:
                    java.lang.String r6 = new java.lang.String     // Catch:{ all -> 0x00a9 }
                    r6.<init>(r5)     // Catch:{ all -> 0x00a9 }
                    monitor-exit(r0)     // Catch:{ all -> 0x00a9 }
                    return r6
                L_0x004b:
                    boolean r7 = AFInAppEventParameterName     // Catch:{ all -> 0x00a9 }
                    if (r7 == 0) goto L_0x007c
                    int r6 = r5.length     // Catch:{ all -> 0x00a9 }
                    com.appsflyer.internal.dq.AFInAppEventType = r6     // Catch:{ all -> 0x00a9 }
                    char[] r6 = new char[r6]     // Catch:{ all -> 0x00a9 }
                    com.appsflyer.internal.dq.AFInAppEventParameterName = r4     // Catch:{ all -> 0x00a9 }
                L_0x0056:
                    int r7 = com.appsflyer.internal.dq.AFInAppEventParameterName     // Catch:{ all -> 0x00a9 }
                    int r3 = com.appsflyer.internal.dq.AFInAppEventType     // Catch:{ all -> 0x00a9 }
                    if (r7 >= r3) goto L_0x0075
                    int r7 = com.appsflyer.internal.dq.AFInAppEventParameterName     // Catch:{ all -> 0x00a9 }
                    int r3 = com.appsflyer.internal.dq.AFInAppEventType     // Catch:{ all -> 0x00a9 }
                    int r3 = r3 + -1
                    int r4 = com.appsflyer.internal.dq.AFInAppEventParameterName     // Catch:{ all -> 0x00a9 }
                    int r3 = r3 - r4
                    char r3 = r5[r3]     // Catch:{ all -> 0x00a9 }
                    int r3 = r3 - r8
                    char r3 = r1[r3]     // Catch:{ all -> 0x00a9 }
                    int r3 = r3 - r2
                    char r3 = (char) r3     // Catch:{ all -> 0x00a9 }
                    r6[r7] = r3     // Catch:{ all -> 0x00a9 }
                    int r7 = com.appsflyer.internal.dq.AFInAppEventParameterName     // Catch:{ all -> 0x00a9 }
                    int r7 = r7 + 1
                    com.appsflyer.internal.dq.AFInAppEventParameterName = r7     // Catch:{ all -> 0x00a9 }
                    goto L_0x0056
                L_0x0075:
                    java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x00a9 }
                    r5.<init>(r6)     // Catch:{ all -> 0x00a9 }
                    monitor-exit(r0)     // Catch:{ all -> 0x00a9 }
                    return r5
                L_0x007c:
                    int r5 = r6.length     // Catch:{ all -> 0x00a9 }
                    com.appsflyer.internal.dq.AFInAppEventType = r5     // Catch:{ all -> 0x00a9 }
                    char[] r5 = new char[r5]     // Catch:{ all -> 0x00a9 }
                    com.appsflyer.internal.dq.AFInAppEventParameterName = r4     // Catch:{ all -> 0x00a9 }
                L_0x0083:
                    int r7 = com.appsflyer.internal.dq.AFInAppEventParameterName     // Catch:{ all -> 0x00a9 }
                    int r3 = com.appsflyer.internal.dq.AFInAppEventType     // Catch:{ all -> 0x00a9 }
                    if (r7 >= r3) goto L_0x00a2
                    int r7 = com.appsflyer.internal.dq.AFInAppEventParameterName     // Catch:{ all -> 0x00a9 }
                    int r3 = com.appsflyer.internal.dq.AFInAppEventType     // Catch:{ all -> 0x00a9 }
                    int r3 = r3 + -1
                    int r4 = com.appsflyer.internal.dq.AFInAppEventParameterName     // Catch:{ all -> 0x00a9 }
                    int r3 = r3 - r4
                    r3 = r6[r3]     // Catch:{ all -> 0x00a9 }
                    int r3 = r3 - r8
                    char r3 = r1[r3]     // Catch:{ all -> 0x00a9 }
                    int r3 = r3 - r2
                    char r3 = (char) r3     // Catch:{ all -> 0x00a9 }
                    r5[r7] = r3     // Catch:{ all -> 0x00a9 }
                    int r7 = com.appsflyer.internal.dq.AFInAppEventParameterName     // Catch:{ all -> 0x00a9 }
                    int r7 = r7 + 1
                    com.appsflyer.internal.dq.AFInAppEventParameterName = r7     // Catch:{ all -> 0x00a9 }
                    goto L_0x0083
                L_0x00a2:
                    java.lang.String r6 = new java.lang.String     // Catch:{ all -> 0x00a9 }
                    r6.<init>(r5)     // Catch:{ all -> 0x00a9 }
                    monitor-exit(r0)     // Catch:{ all -> 0x00a9 }
                    return r6
                L_0x00a9:
                    r5 = move-exception
                    monitor-exit(r0)
                    throw r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.d.C0063d.a.AFInAppEventType(java.lang.String, int[], java.lang.String, int):java.lang.String");
            }
        }

        public C0063d(Map<String, Object> map, Context context) {
            this.AFInAppEventParameterName = map;
            this.AFInAppEventType = context;
            put(AFKeystoreWrapper(), valueOf());
        }

        public static StringBuilder AFKeystoreWrapper(String... strArr) throws Exception {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                if (!(i < 3)) {
                    break;
                }
                int i2 = AFVersionDeclaration + 115;
                getLevel = i2 % 128;
                int i3 = i2 % 2;
                arrayList.add(Integer.valueOf(strArr[i].length()));
                i++;
            }
            Collections.sort(arrayList);
            int intValue = ((Integer) arrayList.get(0)).intValue();
            StringBuilder sb = new StringBuilder();
            for (int i4 = 0; i4 < intValue; i4++) {
                Integer num = null;
                int i5 = 0;
                while (true) {
                    if (i5 >= 3) {
                        break;
                    }
                    int i6 = AFVersionDeclaration + 9;
                    getLevel = i6 % 128;
                    int i7 = i6 % 2;
                    char charAt = strArr[i5].charAt(i4);
                    if (num != null) {
                        charAt ^= num.intValue();
                    }
                    num = Integer.valueOf(charAt);
                    i5++;
                }
                sb.append(Integer.toHexString(num.intValue()));
            }
            return sb;
        }

        private String valueOf() {
            String str;
            int i;
            try {
                String obj = this.AFInAppEventParameterName.get(AFKeystoreWrapper(new int[]{-1899588981, -1318960983, -1691895223, -558378366, 1030854471, 1371389815}, 11 - TextUtils.lastIndexOf("", '0')).intern()).toString();
                String obj2 = this.AFInAppEventParameterName.get(values(null, null, "", 127 - (ViewConfiguration.getEdgeSlop() >> 16)).intern()).toString();
                String replaceAll = AFKeystoreWrapper(new int[]{2132071032, -601586316, -962328678, 813651916}, (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 5).intern().replaceAll(values(null, null, "", (Process.myPid() >> 22) + 127).intern(), "");
                StringBuilder sb = new StringBuilder();
                sb.append(obj);
                sb.append(obj2);
                sb.append(replaceAll);
                String AFInAppEventParameterName2 = ag.AFInAppEventParameterName(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append(AFInAppEventParameterName2.substring(0, 16));
                str = sb2.toString();
            } catch (Exception e2) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(AFKeystoreWrapper(new int[]{-1949264818, -580764174, 2116105142, -1956685057, 295240503, -746952577, -1167971128, -471731909, -1987558749, 1301340063, -1261330329, 477539634, 511241764, -1429573061, -1414121878, -90998272, -766132867, -1213863867, -1995737546, -681845067, -1483690074, 247335825}, 43 - ExpandableListView.getPackedPositionChild(0)).intern());
                sb3.append(e2);
                AFLogger.AFKeystoreWrapper(sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append("");
                sb4.append(values(null, null, "£¡¢¡ ", TextUtils.indexOf("", '0', 0) + 128).intern());
                str = sb4.toString();
            }
            String str2 = str;
            try {
                Intent registerReceiver = this.AFInAppEventType.registerReceiver(null, new IntentFilter(AFKeystoreWrapper(new int[]{2059820036, 1390753898, -599243215, 125346245, 1718122237, -465653955, -1904075570, -807816471, -1964179853, 620430317, 381720347, 1115013456, 1290512775, -1514598378, -724876653, -1940554289, -2077541635, 1490938601, 215740391, -2037742076}, 36 - TextUtils.lastIndexOf("", '0', 0)).intern()));
                int i2 = -2700;
                if (registerReceiver != null) {
                    i2 = registerReceiver.getIntExtra(values(null, null, "¤", 127 - (ViewConfiguration.getFadingEdgeLength() >> 16)).intern(), -2700);
                } else {
                    int i3 = AFVersionDeclaration + 75;
                    getLevel = i3 % 128;
                    int i4 = i3 % 2;
                }
                String str3 = this.AFInAppEventType.getApplicationInfo().nativeLibraryDir;
                if ((str3 != null ? 'a' : 19) == 'a') {
                    if (str3.contains(values(null, null, "¥£", 128 - (ViewConfiguration.getZoomControlsTimeout() > 0 ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0 ? 0 : -1))).intern())) {
                        i = 1;
                        int size = ((SensorManager) this.AFInAppEventType.getSystemService(values(null, null, "", 128 - (Process.getElapsedCpuTime() > 0 ? 1 : (Process.getElapsedCpuTime() == 0 ? 0 : -1))).intern())).getSensorList(-1).size();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(AFKeystoreWrapper(new int[]{1526226703, -1938860710}, -ExpandableListView.getPackedPositionChild(0)).intern());
                        sb5.append(i2);
                        sb5.append(values(null, null, "¦", (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 127).intern());
                        sb5.append(i);
                        sb5.append(AFKeystoreWrapper(new int[]{-1464259222, -1415623062}, 2 - (ViewConfiguration.getWindowTouchSlop() >> 8)).intern());
                        sb5.append(size);
                        sb5.append(AFKeystoreWrapper(new int[]{773775018, 123656625}, TextUtils.indexOf("", '0', 0, 0) + 3).intern());
                        sb5.append(this.AFInAppEventParameterName.size());
                        String obj3 = sb5.toString();
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(str2);
                        sb6.append(a.AFInAppEventParameterName(obj3));
                        String obj4 = sb6.toString();
                        int i5 = AFVersionDeclaration + 67;
                        getLevel = i5 % 128;
                        int i6 = i5 % 2;
                        return obj4;
                    }
                }
                i = 0;
                int size2 = ((SensorManager) this.AFInAppEventType.getSystemService(values(null, null, "", 128 - (Process.getElapsedCpuTime() > 0 ? 1 : (Process.getElapsedCpuTime() == 0 ? 0 : -1))).intern())).getSensorList(-1).size();
                StringBuilder sb52 = new StringBuilder();
                sb52.append(AFKeystoreWrapper(new int[]{1526226703, -1938860710}, -ExpandableListView.getPackedPositionChild(0)).intern());
                sb52.append(i2);
                sb52.append(values(null, null, "¦", (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 127).intern());
                sb52.append(i);
                sb52.append(AFKeystoreWrapper(new int[]{-1464259222, -1415623062}, 2 - (ViewConfiguration.getWindowTouchSlop() >> 8)).intern());
                sb52.append(size2);
                sb52.append(AFKeystoreWrapper(new int[]{773775018, 123656625}, TextUtils.indexOf("", '0', 0, 0) + 3).intern());
                sb52.append(this.AFInAppEventParameterName.size());
                String obj32 = sb52.toString();
                StringBuilder sb62 = new StringBuilder();
                sb62.append(str2);
                sb62.append(a.AFInAppEventParameterName(obj32));
                String obj42 = sb62.toString();
                int i52 = AFVersionDeclaration + 67;
                getLevel = i52 % 128;
                int i62 = i52 % 2;
                return obj42;
            } catch (Exception e3) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append(AFKeystoreWrapper(new int[]{-1949264818, -580764174, 2116105142, -1956685057, 295240503, -746952577, -1167971128, -471731909, -1987558749, 1301340063, -1261330329, 477539634, 511241764, -1429573061, -1414121878, -90998272, -766132867, -1213863867, -1995737546, -681845067, -1483690074, 247335825}, 44 - MeasureSpec.makeMeasureSpec(0, 0)).intern());
                sb7.append(e3);
                AFLogger.AFKeystoreWrapper(sb7.toString());
                StringBuilder sb8 = new StringBuilder();
                sb8.append(str2);
                sb8.append(values(null, null, "¤¢¢¡¡§§", 127 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)).intern());
                return sb8.toString();
            }
        }

        /* JADX WARNING: type inference failed for: r7v1 */
        /* JADX WARNING: type inference failed for: r5v1 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.lang.String values(java.lang.String r5, int[] r6, java.lang.String r7, int r8) {
            /*
                if (r7 == 0) goto L_0x0008
                java.lang.String r0 = "ISO-8859-1"
                byte[] r7 = r7.getBytes(r0)
            L_0x0008:
                byte[] r7 = (byte[]) r7
                if (r5 == 0) goto L_0x0010
                char[] r5 = r5.toCharArray()
            L_0x0010:
                char[] r5 = (char[]) r5
                java.lang.Object r0 = com.appsflyer.internal.dq.valueOf
                monitor-enter(r0)
                char[] r1 = valueOf     // Catch:{ all -> 0x00a9 }
                int r2 = values     // Catch:{ all -> 0x00a9 }
                boolean r3 = AFLogger$LogLevel     // Catch:{ all -> 0x00a9 }
                r4 = 0
                if (r3 == 0) goto L_0x004b
                int r5 = r7.length     // Catch:{ all -> 0x00a9 }
                com.appsflyer.internal.dq.AFInAppEventType = r5     // Catch:{ all -> 0x00a9 }
                char[] r5 = new char[r5]     // Catch:{ all -> 0x00a9 }
                com.appsflyer.internal.dq.AFInAppEventParameterName = r4     // Catch:{ all -> 0x00a9 }
            L_0x0025:
                int r6 = com.appsflyer.internal.dq.AFInAppEventParameterName     // Catch:{ all -> 0x00a9 }
                int r3 = com.appsflyer.internal.dq.AFInAppEventType     // Catch:{ all -> 0x00a9 }
                if (r6 >= r3) goto L_0x0044
                int r6 = com.appsflyer.internal.dq.AFInAppEventParameterName     // Catch:{ all -> 0x00a9 }
                int r3 = com.appsflyer.internal.dq.AFInAppEventType     // Catch:{ all -> 0x00a9 }
                int r3 = r3 + -1
                int r4 = com.appsflyer.internal.dq.AFInAppEventParameterName     // Catch:{ all -> 0x00a9 }
                int r3 = r3 - r4
                byte r3 = r7[r3]     // Catch:{ all -> 0x00a9 }
                int r3 = r3 + r8
                char r3 = r1[r3]     // Catch:{ all -> 0x00a9 }
                int r3 = r3 - r2
                char r3 = (char) r3     // Catch:{ all -> 0x00a9 }
                r5[r6] = r3     // Catch:{ all -> 0x00a9 }
                int r6 = com.appsflyer.internal.dq.AFInAppEventParameterName     // Catch:{ all -> 0x00a9 }
                int r6 = r6 + 1
                com.appsflyer.internal.dq.AFInAppEventParameterName = r6     // Catch:{ all -> 0x00a9 }
                goto L_0x0025
            L_0x0044:
                java.lang.String r6 = new java.lang.String     // Catch:{ all -> 0x00a9 }
                r6.<init>(r5)     // Catch:{ all -> 0x00a9 }
                monitor-exit(r0)     // Catch:{ all -> 0x00a9 }
                return r6
            L_0x004b:
                boolean r7 = AppsFlyer2dXConversionCallback     // Catch:{ all -> 0x00a9 }
                if (r7 == 0) goto L_0x007c
                int r6 = r5.length     // Catch:{ all -> 0x00a9 }
                com.appsflyer.internal.dq.AFInAppEventType = r6     // Catch:{ all -> 0x00a9 }
                char[] r6 = new char[r6]     // Catch:{ all -> 0x00a9 }
                com.appsflyer.internal.dq.AFInAppEventParameterName = r4     // Catch:{ all -> 0x00a9 }
            L_0x0056:
                int r7 = com.appsflyer.internal.dq.AFInAppEventParameterName     // Catch:{ all -> 0x00a9 }
                int r3 = com.appsflyer.internal.dq.AFInAppEventType     // Catch:{ all -> 0x00a9 }
                if (r7 >= r3) goto L_0x0075
                int r7 = com.appsflyer.internal.dq.AFInAppEventParameterName     // Catch:{ all -> 0x00a9 }
                int r3 = com.appsflyer.internal.dq.AFInAppEventType     // Catch:{ all -> 0x00a9 }
                int r3 = r3 + -1
                int r4 = com.appsflyer.internal.dq.AFInAppEventParameterName     // Catch:{ all -> 0x00a9 }
                int r3 = r3 - r4
                char r3 = r5[r3]     // Catch:{ all -> 0x00a9 }
                int r3 = r3 - r8
                char r3 = r1[r3]     // Catch:{ all -> 0x00a9 }
                int r3 = r3 - r2
                char r3 = (char) r3     // Catch:{ all -> 0x00a9 }
                r6[r7] = r3     // Catch:{ all -> 0x00a9 }
                int r7 = com.appsflyer.internal.dq.AFInAppEventParameterName     // Catch:{ all -> 0x00a9 }
                int r7 = r7 + 1
                com.appsflyer.internal.dq.AFInAppEventParameterName = r7     // Catch:{ all -> 0x00a9 }
                goto L_0x0056
            L_0x0075:
                java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x00a9 }
                r5.<init>(r6)     // Catch:{ all -> 0x00a9 }
                monitor-exit(r0)     // Catch:{ all -> 0x00a9 }
                return r5
            L_0x007c:
                int r5 = r6.length     // Catch:{ all -> 0x00a9 }
                com.appsflyer.internal.dq.AFInAppEventType = r5     // Catch:{ all -> 0x00a9 }
                char[] r5 = new char[r5]     // Catch:{ all -> 0x00a9 }
                com.appsflyer.internal.dq.AFInAppEventParameterName = r4     // Catch:{ all -> 0x00a9 }
            L_0x0083:
                int r7 = com.appsflyer.internal.dq.AFInAppEventParameterName     // Catch:{ all -> 0x00a9 }
                int r3 = com.appsflyer.internal.dq.AFInAppEventType     // Catch:{ all -> 0x00a9 }
                if (r7 >= r3) goto L_0x00a2
                int r7 = com.appsflyer.internal.dq.AFInAppEventParameterName     // Catch:{ all -> 0x00a9 }
                int r3 = com.appsflyer.internal.dq.AFInAppEventType     // Catch:{ all -> 0x00a9 }
                int r3 = r3 + -1
                int r4 = com.appsflyer.internal.dq.AFInAppEventParameterName     // Catch:{ all -> 0x00a9 }
                int r3 = r3 - r4
                r3 = r6[r3]     // Catch:{ all -> 0x00a9 }
                int r3 = r3 - r8
                char r3 = r1[r3]     // Catch:{ all -> 0x00a9 }
                int r3 = r3 - r2
                char r3 = (char) r3     // Catch:{ all -> 0x00a9 }
                r5[r7] = r3     // Catch:{ all -> 0x00a9 }
                int r7 = com.appsflyer.internal.dq.AFInAppEventParameterName     // Catch:{ all -> 0x00a9 }
                int r7 = r7 + 1
                com.appsflyer.internal.dq.AFInAppEventParameterName = r7     // Catch:{ all -> 0x00a9 }
                goto L_0x0083
            L_0x00a2:
                java.lang.String r6 = new java.lang.String     // Catch:{ all -> 0x00a9 }
                r6.<init>(r5)     // Catch:{ all -> 0x00a9 }
                monitor-exit(r0)     // Catch:{ all -> 0x00a9 }
                return r6
            L_0x00a9:
                r5 = move-exception
                monitor-exit(r0)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.d.C0063d.values(java.lang.String, int[], java.lang.String, int):java.lang.String");
        }

        private String AFKeystoreWrapper() {
            try {
                String num = Integer.toString(VERSION.SDK_INT);
                String obj = this.AFInAppEventParameterName.get(AFKeystoreWrapper(new int[]{-1899588981, -1318960983, -1691895223, -558378366, 1030854471, 1371389815}, Process.getGidForName("") + 13).intern()).toString();
                String obj2 = this.AFInAppEventParameterName.get(values(null, null, "", 127 - (ExpandableListView.getPackedPositionForGroup(0) > 0 ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0 ? 0 : -1))).intern()).toString();
                if (obj2 == null) {
                    int i = AFVersionDeclaration + 93;
                    getLevel = i % 128;
                    int i2 = i % 2;
                    obj2 = AFKeystoreWrapper(new int[]{-2011555701, -332013502, -1705604504, 1213686013}, (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 8).intern();
                    int i3 = getLevel + 57;
                    AFVersionDeclaration = i3 % 128;
                    int i4 = i3 % 2;
                }
                StringBuilder sb = new StringBuilder(obj);
                sb.reverse();
                StringBuilder AFKeystoreWrapper2 = AFKeystoreWrapper(num, obj2, sb.toString());
                int length = AFKeystoreWrapper2.length();
                if (length > 4) {
                    int i5 = AFVersionDeclaration + 31;
                    getLevel = i5 % 128;
                    int i6 = i5 % 2;
                    AFKeystoreWrapper2.delete(4, length);
                    int i7 = getLevel + 35;
                    AFVersionDeclaration = i7 % 128;
                    int i8 = i7 % 2;
                } else {
                    while (true) {
                        if ((length < 4 ? '/' : 26) != '/') {
                            break;
                        }
                        int i9 = getLevel + 55;
                        AFVersionDeclaration = i9 % 128;
                        if ((i9 % 2 != 0 ? StringEscapeUtils.CSV_QUOTE : ']') != ']') {
                            length += 41;
                            AFKeystoreWrapper2.append('n');
                        } else {
                            length++;
                            AFKeystoreWrapper2.append('1');
                        }
                    }
                }
                AFKeystoreWrapper2.insert(0, values(null, null, "", 127 - (Process.myTid() >> 22)).intern());
                return AFKeystoreWrapper2.toString();
            } catch (Exception e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(values(null, null, "", (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 127).intern());
                sb2.append(e2);
                AFLogger.AFKeystoreWrapper(sb2.toString());
                return AFKeystoreWrapper(new int[]{1823803466, 2057373644, 1748011517, 210350023}, 7 - (Process.myTid() >> 22)).intern();
            }
        }

        public static String AFKeystoreWrapper(int[] iArr, int i) {
            String str;
            synchronized (dm.valueOf) {
                char[] cArr = new char[4];
                char[] cArr2 = new char[(iArr.length << 1)];
                int[] iArr2 = (int[]) AFKeystoreWrapper.clone();
                dm.AFInAppEventParameterName = 0;
                while (dm.AFInAppEventParameterName < iArr.length) {
                    cArr[0] = (char) (iArr[dm.AFInAppEventParameterName] >> 16);
                    cArr[1] = (char) iArr[dm.AFInAppEventParameterName];
                    cArr[2] = (char) (iArr[dm.AFInAppEventParameterName + 1] >> 16);
                    cArr[3] = (char) iArr[dm.AFInAppEventParameterName + 1];
                    dm.values = (cArr[0] << 16) + cArr[1];
                    dm.AFKeystoreWrapper = (cArr[2] << 16) + cArr[3];
                    dm.values(iArr2);
                    for (int i2 = 0; i2 < 16; i2++) {
                        int i3 = dm.values ^ iArr2[i2];
                        dm.values = i3;
                        dm.AFKeystoreWrapper = dm.AFInAppEventParameterName(i3) ^ dm.AFKeystoreWrapper;
                        int i4 = dm.values;
                        dm.values = dm.AFKeystoreWrapper;
                        dm.AFKeystoreWrapper = i4;
                    }
                    int i5 = dm.values;
                    dm.values = dm.AFKeystoreWrapper;
                    dm.AFKeystoreWrapper = i5;
                    dm.AFKeystoreWrapper = i5 ^ iArr2[16];
                    dm.values ^= iArr2[17];
                    int i6 = dm.AFKeystoreWrapper;
                    cArr[0] = (char) (dm.values >>> 16);
                    cArr[1] = (char) dm.values;
                    cArr[2] = (char) (dm.AFKeystoreWrapper >>> 16);
                    cArr[3] = (char) dm.AFKeystoreWrapper;
                    dm.values(iArr2);
                    cArr2[dm.AFInAppEventParameterName << 1] = cArr[0];
                    cArr2[(dm.AFInAppEventParameterName << 1) + 1] = cArr[1];
                    cArr2[(dm.AFInAppEventParameterName << 1) + 2] = cArr[2];
                    cArr2[(dm.AFInAppEventParameterName << 1) + 3] = cArr[3];
                    dm.AFInAppEventParameterName += 2;
                }
                str = new String(cArr2, 0, i);
            }
            return str;
        }
    }

    public static String AFInAppEventType(String str, String str2, int i) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, AFInAppEventType(str2).charAt(0));
        String obj = sb.toString();
        int i2 = getLevel + 123;
        AFLogger$LogLevel = i2 % 128;
        int i3 = i2 % 2;
        return obj;
    }

    public static String AFKeystoreWrapper(Context context, long j) {
        String str;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        if ((valueOf(AFKeystoreWrapper((String) "굱鿐괐ᗒ論犁蒮⮥팑╭﹥䉹薩ὶ퀑飄籺ை껒嘱ꯖ絭앩ࣅ艫圾ᬲ璞軀ㆂ픴⻄䡎", Color.red(0)).intern()) ? 'L' : 'Z') != 'L') {
            str = AFKeystoreWrapper((String) "嗞磸嗮륣", ViewConfiguration.getWindowTouchSlop() >> 8).intern();
        } else {
            int i = AFLogger$LogLevel + 101;
            getLevel = i % 128;
            if (!(i % 2 != 0)) {
                str = AFKeystoreWrapper((String) "臏䓗臾႖", View.getDefaultSize(0, 0)).intern();
            } else {
                str = AFKeystoreWrapper((String) "臏䓗臾႖", View.getDefaultSize(0, 1)).intern();
            }
            int i2 = AFLogger$LogLevel + 63;
            getLevel = i2 % 128;
            int i3 = i2 % 2;
        }
        sb2.append(str);
        sb.append(AFKeystoreWrapper(context, sb2));
        try {
            sb.append(new SimpleDateFormat(AFKeystoreWrapper((Process.myTid() >> 22) - 47, (byte) (-75 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), 1788657434 - View.resolveSize(0, 0), (short) (TextUtils.indexOf("", '0') + 1), KeyEvent.getDeadChar(0, 0) - 654970919).intern(), Locale.US).format(new Date(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime)));
            int i4 = AFLogger$LogLevel + 101;
            getLevel = i4 % 128;
            int i5 = i4 % 2;
            sb.append(j);
            valueOf(sb3);
            return valueOf(AFInAppEventType(AFInAppEventType(values(sb.toString()), sb2.toString(), 17), sb3.toString(), 27), Long.valueOf(j));
        } catch (NameNotFoundException unused) {
            return AFKeystoreWrapper((String) "Ⲿ倨Ⳝ?膠锚ﳻ揚կ뼘꬛翧趀配减圶ၱ羽詊慢㨌▻ﳺઑ擜౞훺풝轩齃ཛྷ︤뤹ꃿ", TextUtils.indexOf("", "", 0)).intern();
        }
    }

    public static String valueOf(String str, Long l) {
        int i = getLevel + 39;
        AFLogger$LogLevel = i % 128;
        int i2 = i % 2;
        long j = 0;
        if (!(str != null) || l == null || str.length() != 32) {
            return AFKeystoreWrapper((String) "Ⲿ倨Ⳝ?膠锚ﳻ揚կ뼘꬛翧趀配减圶ၱ羽詊慢㨌▻ﳺઑ擜౞훺풝轩齃ཛྷ︤뤹ꃿ", -1 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0 ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0 ? 0 : -1))).intern();
        }
        StringBuilder sb = new StringBuilder(str);
        String obj = l.toString();
        int i3 = AFLogger$LogLevel + 9;
        getLevel = i3 % 128;
        int i4 = i3 % 2;
        int i5 = 0;
        int i6 = 0;
        while (i5 < obj.length()) {
            int i7 = getLevel + 5;
            AFLogger$LogLevel = i7 % 128;
            if (i7 % 2 == 0) {
                i6 <<= Character.getNumericValue(obj.charAt(i5));
                i5 += 113;
            } else {
                i6 += Character.getNumericValue(obj.charAt(i5));
                i5++;
            }
        }
        String hexString = Integer.toHexString(i6);
        sb.replace(7, hexString.length() + 7, hexString);
        int i8 = 0;
        while (true) {
            if (i8 >= sb.length()) {
                break;
            }
            j += (long) Character.getNumericValue(sb.charAt(i8));
            i8++;
        }
        while (j > 100) {
            j %= 100;
        }
        sb.insert(23, (int) j);
        if (j < 10) {
            int i9 = getLevel + 23;
            AFLogger$LogLevel = i9 % 128;
            int i10 = i9 % 2;
            sb.insert(23, AFKeystoreWrapper((String) "嗞磸嗮륣", TextUtils.indexOf("", "", 0)).intern());
            int i11 = AFLogger$LogLevel + 33;
            getLevel = i11 % 128;
            int i12 = i11 % 2;
        }
        return sb.toString();
    }

    public static String values(String str) {
        int i = getLevel + 83;
        AFLogger$LogLevel = i % 128;
        if (!(i % 2 == 0)) {
            return ag.AFKeystoreWrapper(ag.AFInAppEventParameterName(str));
        }
        int i2 = 87 / 0;
        return ag.AFKeystoreWrapper(ag.AFInAppEventParameterName(str));
    }

    public static String AFInAppEventType(String str) {
        int i = getLevel + 59;
        AFLogger$LogLevel = i % 128;
        int i2 = i % 2;
        String num = Integer.toString(Integer.parseInt(str, 2), 16);
        int i3 = getLevel + 5;
        AFLogger$LogLevel = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return num;
        }
        int i4 = 31 / 0;
        return num;
    }

    public static String values(Context context) {
        String str = null;
        if ((System.getProperties().containsKey(AFKeystoreWrapper((ViewConfiguration.getMinimumFlingVelocity() >> 16) + -47, (byte) (38 - View.combineMeasuredStates(0, 0)), 1788657418 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0 ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0 ? 0 : -1)), (short) (ViewConfiguration.getPressedStateDuration() >> 16), -654970860 - (SystemClock.currentThreadTimeMillis() > -1 ? 1 : (SystemClock.currentThreadTimeMillis() == -1 ? 0 : -1))).intern()) ? 'G' : '^') != '^') {
            int i = getLevel + 33;
            AFLogger$LogLevel = i % 128;
            int i2 = i % 2;
            try {
                Matcher matcher = Pattern.compile(AFKeystoreWrapper((String) "鵴ꕴ鵚⼲尸䣏່釐뒷ᅂ折夊츾碑", (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))).intern()).matcher(context.getCacheDir().getPath().replace(AFKeystoreWrapper((ViewConfiguration.getScrollBarSize() >> 8) - 47, (byte) (TextUtils.getCapsMode("", 0, 0) - 89), Color.red(0) + 1788657360, (short) ((SystemClock.currentThreadTimeMillis() > -1 ? 1 : (SystemClock.currentThreadTimeMillis() == -1 ? 0 : -1)) - 1), Color.argb(0, 0, 0, 0) - 654970847).intern(), ""));
                if (matcher.find()) {
                    int i3 = getLevel + 79;
                    AFLogger$LogLevel = i3 % 128;
                    int i4 = i3 % 2;
                    str = matcher.group(1);
                }
                int i5 = AFLogger$LogLevel + 45;
                getLevel = i5 % 128;
                int i6 = i5 % 2;
            } catch (Exception e2) {
                ak AFInAppEventType2 = ak.AFInAppEventType();
                String intern = AFKeystoreWrapper((String) "奱倹夲?撾ﮙ炪?㌀੔趍觺क़␑圱瀠￟", 1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))).intern();
                StringBuilder sb = new StringBuilder();
                sb.append(AFKeystoreWrapper(((Process.getThreadPriority(0) + 20) >> 6) - 47, (byte) (Color.blue(0) + 42), 1788657382 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0 ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0 ? 0 : -1)), (short) (ViewConfiguration.getKeyRepeatTimeout() >> 16), Drawable.resolveOpacity(0, 0) - 654970841).intern());
                sb.append(e2);
                AFInAppEventType2.AFInAppEventParameterName(intern, sb.toString());
            }
        }
        return str;
    }

    public static String AFInAppEventType(Context context) {
        PackageManager packageManager;
        String packageName;
        int i = getLevel + 21;
        AFLogger$LogLevel = i % 128;
        boolean z = true;
        if (!(i % 2 == 0)) {
            try {
                packageManager = context.getPackageManager();
                packageName = context.getPackageName();
            } catch (NameNotFoundException unused) {
                return null;
            }
        } else {
            packageManager = context.getPackageManager();
            packageName = context.getPackageName();
        }
        String str = packageManager.getPackageInfo(packageName, 0).packageName;
        int i2 = AFLogger$LogLevel + 51;
        getLevel = i2 % 128;
        if (i2 % 2 == 0) {
            z = false;
        }
        if (!z) {
            return str;
        }
        throw null;
    }

    public static boolean valueOf(String str) {
        int i = AFLogger$LogLevel + 111;
        getLevel = i % 128;
        if (i % 2 != 0) {
        }
        try {
            Class.forName(str);
            int i2 = AFLogger$LogLevel + 31;
            getLevel = i2 % 128;
            int i3 = i2 % 2;
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        if ((!valueOf(AFKeystoreWrapper((java.lang.String) "Ⲵ軃ⳕӁ䕅凹宰쒆ի㪶箩౜羻卼ⵓ㙠凅觋퓙?訆뾖ﺐ苣ﲪ푾ꁪꭗ훦", android.graphics.Color.alpha(0)).intern())) != true) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004a, code lost:
        if (valueOf(AFKeystoreWrapper((java.lang.String) "Ⲵ軃ⳕӁ䕅凹宰쒆ի㪶箩౜羻卼ⵓ㙠凅觋퓙?訆뾖ﺐ苣ﲪ푾ꁪꭗ훦", android.graphics.Color.alpha(1)).intern()) != false) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0080, code lost:
        r1 = AFKeystoreWrapper((java.lang.String) "嗞磸嗮륣", (android.widget.ExpandableListView.getPackedPositionForGroup(0) > 0 ? 1 : (android.widget.ExpandableListView.getPackedPositionForGroup(0) == 0 ? 0 : -1)));
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0164  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void valueOf(java.lang.StringBuilder r17) {
        /*
            r0 = r17
            int r1 = getLevel
            int r1 = r1 + 75
            int r2 = r1 % 128
            AFLogger$LogLevel = r2
            int r1 = r1 % 2
            r2 = 3
            if (r1 != 0) goto L_0x0011
            r1 = 3
            goto L_0x0013
        L_0x0011:
            r1 = 87
        L_0x0013:
            r3 = 79
            java.lang.String r4 = "Ⲵ軃ⳕӁ䕅凹宰쒆ի㪶箩౜羻卼ⵓ㙠凅觋퓙?訆뾖ﺐ苣ﲪ푾ꁪꭗ훦"
            r5 = -1
            java.lang.String r6 = "嗞磸嗮륣"
            java.lang.String r7 = "臏䓗臾႖"
            r8 = 0
            r10 = 1
            r11 = 0
            if (r1 == r2) goto L_0x003a
            int r1 = android.graphics.Color.alpha(r11)
            java.lang.String r1 = AFKeystoreWrapper(r4, r1)
            java.lang.String r1 = r1.intern()
            boolean r1 = valueOf(r1)
            if (r1 == 0) goto L_0x0036
            r1 = 0
            goto L_0x0037
        L_0x0036:
            r1 = 1
        L_0x0037:
            if (r1 == r10) goto L_0x0080
            goto L_0x004c
        L_0x003a:
            int r1 = android.graphics.Color.alpha(r10)
            java.lang.String r1 = AFKeystoreWrapper(r4, r1)
            java.lang.String r1 = r1.intern()
            boolean r1 = valueOf(r1)
            if (r1 == 0) goto L_0x0080
        L_0x004c:
            int r1 = AFLogger$LogLevel
            int r1 = r1 + 69
            int r2 = r1 % 128
            getLevel = r2
            int r1 = r1 % 2
            r2 = 85
            if (r1 == 0) goto L_0x005d
            r1 = 79
            goto L_0x005f
        L_0x005d:
            r1 = 85
        L_0x005f:
            if (r1 == r2) goto L_0x0074
            long r1 = android.os.SystemClock.uptimeMillis()
            r12 = 1
            int r4 = (r1 > r12 ? 1 : (r1 == r12 ? 0 : -1))
            int r1 = r5 << r4
            java.lang.String r1 = AFKeystoreWrapper(r7, r1)
            java.lang.String r1 = r1.intern()
            goto L_0x008e
        L_0x0074:
            long r1 = android.os.SystemClock.uptimeMillis()
            int r4 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            int r4 = r4 + r5
            java.lang.String r1 = AFKeystoreWrapper(r7, r4)
            goto L_0x008a
        L_0x0080:
            long r1 = android.widget.ExpandableListView.getPackedPositionForGroup(r11)
            int r4 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            java.lang.String r1 = AFKeystoreWrapper(r6, r4)
        L_0x008a:
            java.lang.String r1 = r1.intern()
        L_0x008e:
            r0.append(r1)
            int r1 = android.view.View.combineMeasuredStates(r11, r11)
            int r1 = -47 - r1
            java.lang.String r2 = ""
            int r4 = android.text.TextUtils.getOffsetAfter(r2, r11)
            int r4 = r4 + 68
            byte r4 = (byte) r4
            r12 = 1788657409(0x6a9cbf01, float:9.474721E25)
            long r13 = android.os.SystemClock.uptimeMillis()
            r15 = 48
            int r16 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            int r12 = r16 + r12
            int r13 = android.view.ViewConfiguration.getKeyRepeatTimeout()
            int r13 = r13 >> 16
            short r13 = (short) r13
            r14 = -654970902(0xffffffffd8f5efea, float:-2.1632862E15)
            int r16 = android.text.TextUtils.lastIndexOf(r2, r15)
            int r14 = r14 - r16
            java.lang.String r1 = AFKeystoreWrapper(r1, r4, r12, r13, r14)
            java.lang.String r1 = r1.intern()
            boolean r1 = valueOf(r1)
            if (r1 == 0) goto L_0x00e2
            int r1 = android.text.TextUtils.indexOf(r2, r2, r11, r11)
            java.lang.String r1 = AFKeystoreWrapper(r7, r1)
            java.lang.String r1 = r1.intern()
            int r4 = AFLogger$LogLevel
            int r4 = r4 + 67
            int r12 = r4 % 128
            getLevel = r12
            int r4 = r4 % 2
            goto L_0x00ee
        L_0x00e2:
            int r1 = android.text.TextUtils.indexOf(r2, r2, r11)
            java.lang.String r1 = AFKeystoreWrapper(r6, r1)
            java.lang.String r1 = r1.intern()
        L_0x00ee:
            r0.append(r1)
            int r1 = android.widget.ExpandableListView.getPackedPositionGroup(r8)
            java.lang.String r4 = "秠ᔅ禁鼇䥯巓?䘢倿ꅰ瞃軸⫯좺ⅹ듇҃ሀ?娕?⑈M"
            java.lang.String r1 = AFKeystoreWrapper(r4, r1)
            java.lang.String r1 = r1.intern()
            boolean r1 = valueOf(r1)
            if (r1 == 0) goto L_0x0107
            r1 = 0
            goto L_0x0108
        L_0x0107:
            r1 = 1
        L_0x0108:
            if (r1 == r10) goto L_0x0117
            int r1 = android.view.KeyEvent.normalizeMetaState(r11)
            java.lang.String r1 = AFKeystoreWrapper(r7, r1)
        L_0x0112:
            java.lang.String r1 = r1.intern()
            goto L_0x0121
        L_0x0117:
            int r1 = android.widget.ExpandableListView.getPackedPositionChild(r8)
            int r5 = r5 - r1
            java.lang.String r1 = AFKeystoreWrapper(r6, r5)
            goto L_0x0112
        L_0x0121:
            r0.append(r1)
            int r1 = android.view.ViewConfiguration.getMaximumDrawingCacheSize()
            int r1 = r1 >> 24
            int r1 = -47 - r1
            int r2 = android.text.TextUtils.lastIndexOf(r2, r15, r11)
            int r3 = r3 - r2
            byte r2 = (byte) r3
            r3 = 1788657410(0x6a9cbf02, float:9.474722E25)
            r4 = 0
            float r5 = android.graphics.PointF.length(r4, r4)
            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            int r4 = r4 + r3
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            int r5 = android.graphics.Color.rgb(r11, r11, r11)
            int r3 = r3 - r5
            short r3 = (short) r3
            r5 = -671748094(0xffffffffd7f5f002, float:-5.4082235E14)
            int r8 = android.graphics.Color.rgb(r11, r11, r11)
            int r5 = r5 - r8
            java.lang.String r1 = AFKeystoreWrapper(r1, r2, r4, r3, r5)
            java.lang.String r1 = r1.intern()
            boolean r1 = valueOf(r1)
            if (r1 == 0) goto L_0x0164
            int r1 = android.graphics.drawable.Drawable.resolveOpacity(r11, r11)
            java.lang.String r1 = AFKeystoreWrapper(r7, r1)
            goto L_0x016e
        L_0x0164:
            int r1 = android.view.ViewConfiguration.getKeyRepeatTimeout()
            int r1 = r1 >> 16
            java.lang.String r1 = AFKeystoreWrapper(r6, r1)
        L_0x016e:
            java.lang.String r1 = r1.intern()
            r0.append(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.d.valueOf(java.lang.StringBuilder):void");
    }

    public static String AFKeystoreWrapper(String str) {
        int i = getLevel + 103;
        AFLogger$LogLevel = i % 128;
        if (i % 2 != 0 ? !str.contains(AFKeystoreWrapper((String) "均刄坩玨ס", ViewConfiguration.getMaximumDrawingCacheSize() >> 24).intern()) : !str.contains(AFKeystoreWrapper((String) "均刄坩玨ס", ViewConfiguration.getMaximumDrawingCacheSize() << 23).intern())) {
            return str;
        }
        String[] split = str.split(AFKeystoreWrapper(-46 - (ViewConfiguration.getZoomControlsTimeout() > 0 ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0 ? 0 : -1)), (byte) (Color.argb(0, 0, 0, 0) - 88), ImageFormat.getBitsPerPixel(0) + 1788657406, (short) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (ExpandableListView.getPackedPositionForGroup(0) > 0 ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0 ? 0 : -1)) - 654970863).intern());
        int length = split.length;
        StringBuilder sb = new StringBuilder();
        int i2 = length - 1;
        sb.append(split[i2]);
        sb.append(AFKeystoreWrapper((String) "均刄坩玨ס", (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1))).intern());
        int i3 = getLevel + 105;
        AFLogger$LogLevel = i3 % 128;
        int i4 = i3 % 2;
        int i5 = 1;
        while (true) {
            if ((i5 < i2 ? ExtendedMessageFormat.QUOTE : '0') != '\'') {
                sb.append(split[0]);
                return sb.toString();
            }
            int i6 = getLevel + 119;
            AFLogger$LogLevel = i6 % 128;
            if (i6 % 2 == 0) {
                sb.append(split[i5]);
                sb.append(AFKeystoreWrapper((String) "均刄坩玨ס", 0 / TextUtils.indexOf("", '7', 0, 1)).intern());
                i5 += 79;
            } else {
                sb.append(split[i5]);
                sb.append(AFKeystoreWrapper((String) "均刄坩玨ס", TextUtils.indexOf("", '0', 0, 0) + 1).intern());
                i5++;
            }
        }
    }

    public static String AFKeystoreWrapper(Context context, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        String packageName = context.getPackageName();
        String AFKeystoreWrapper2 = AFKeystoreWrapper(packageName);
        sb.append(AFKeystoreWrapper((String) "臏䓗臾႖", ViewConfiguration.getScrollBarSize() >> 8).intern());
        sb2.append(AFKeystoreWrapper2);
        if ((values(context) == null ? '9' : 6) != '9') {
            sb.append(AFKeystoreWrapper((String) "臏䓗臾႖", AndroidCharacter.getMirror('0') - '0').intern());
            sb2.append(packageName);
        } else {
            sb.append(AFKeystoreWrapper((String) "嗞磸嗮륣", (ViewConfiguration.getZoomControlsTimeout() > 0 ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0 ? 0 : -1)) - 1).intern());
            sb2.append(packageName);
            int i = getLevel + 43;
            AFLogger$LogLevel = i % 128;
            int i2 = i % 2;
        }
        String AFInAppEventType2 = AFInAppEventType(context);
        if (!(AFInAppEventType2 != null)) {
            sb.append(AFKeystoreWrapper((String) "嗞磸嗮륣", (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))).intern());
            sb2.append(packageName);
        } else {
            sb.append(AFKeystoreWrapper((String) "臏䓗臾႖", Gravity.getAbsoluteGravity(0, 0)).intern());
            sb2.append(AFInAppEventType2);
            int i3 = AFLogger$LogLevel + 75;
            getLevel = i3 % 128;
            int i4 = i3 % 2;
        }
        sb2.append(Boolean.TRUE.toString());
        return sb2.toString();
    }

    /* JADX WARNING: type inference failed for: r8v1 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String AFKeystoreWrapper(java.lang.String r8, int r9) {
        /*
            if (r8 == 0) goto L_0x0006
            char[] r8 = r8.toCharArray()
        L_0x0006:
            char[] r8 = (char[]) r8
            java.lang.Object r0 = com.appsflyer.internal.dl.AFInAppEventParameterName
            monitor-enter(r0)
            long r1 = AFKeystoreWrapper     // Catch:{ all -> 0x0047 }
            char[] r8 = com.appsflyer.internal.dl.AFInAppEventType(r1, r8, r9)     // Catch:{ all -> 0x0047 }
            r9 = 4
            com.appsflyer.internal.dl.AFKeystoreWrapper = r9     // Catch:{ all -> 0x0047 }
        L_0x0014:
            int r1 = com.appsflyer.internal.dl.AFKeystoreWrapper     // Catch:{ all -> 0x0047 }
            int r2 = r8.length     // Catch:{ all -> 0x0047 }
            if (r1 >= r2) goto L_0x003e
            int r1 = com.appsflyer.internal.dl.AFKeystoreWrapper     // Catch:{ all -> 0x0047 }
            int r1 = r1 - r9
            com.appsflyer.internal.dl.values = r1     // Catch:{ all -> 0x0047 }
            int r1 = com.appsflyer.internal.dl.AFKeystoreWrapper     // Catch:{ all -> 0x0047 }
            int r2 = com.appsflyer.internal.dl.AFKeystoreWrapper     // Catch:{ all -> 0x0047 }
            char r2 = r8[r2]     // Catch:{ all -> 0x0047 }
            int r3 = com.appsflyer.internal.dl.AFKeystoreWrapper     // Catch:{ all -> 0x0047 }
            int r3 = r3 % r9
            char r3 = r8[r3]     // Catch:{ all -> 0x0047 }
            r2 = r2 ^ r3
            long r2 = (long) r2     // Catch:{ all -> 0x0047 }
            int r4 = com.appsflyer.internal.dl.values     // Catch:{ all -> 0x0047 }
            long r4 = (long) r4     // Catch:{ all -> 0x0047 }
            long r6 = AFKeystoreWrapper     // Catch:{ all -> 0x0047 }
            long r4 = r4 * r6
            long r2 = r2 ^ r4
            int r3 = (int) r2     // Catch:{ all -> 0x0047 }
            char r2 = (char) r3     // Catch:{ all -> 0x0047 }
            r8[r1] = r2     // Catch:{ all -> 0x0047 }
            int r1 = com.appsflyer.internal.dl.AFKeystoreWrapper     // Catch:{ all -> 0x0047 }
            int r1 = r1 + 1
            com.appsflyer.internal.dl.AFKeystoreWrapper = r1     // Catch:{ all -> 0x0047 }
            goto L_0x0014
        L_0x003e:
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x0047 }
            int r2 = r8.length     // Catch:{ all -> 0x0047 }
            int r2 = r2 - r9
            r1.<init>(r8, r9, r2)     // Catch:{ all -> 0x0047 }
            monitor-exit(r0)     // Catch:{ all -> 0x0047 }
            return r1
        L_0x0047:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.d.AFKeystoreWrapper(java.lang.String, int):java.lang.String");
    }

    public static String AFKeystoreWrapper(int i, byte b2, int i2, short s, int i3) {
        String obj;
        int i4;
        int i5;
        synchronized (du.getLevel) {
            StringBuilder sb = new StringBuilder();
            int i6 = i + AFInAppEventType;
            int i7 = 0;
            boolean z = i6 == -1;
            if (z) {
                if (valueOf != null) {
                    i6 = (byte) (valueOf[AFInAppEventParameterName + i3] + AFInAppEventType);
                } else {
                    i6 = (short) (AppsFlyer2dXConversionCallback[AFInAppEventParameterName + i3] + AFInAppEventType);
                }
            }
            if (i6 > 0) {
                int i8 = ((i3 + i6) - 2) + AFInAppEventParameterName;
                if (z) {
                    i7 = 1;
                }
                du.AFKeystoreWrapper = i8 + i7;
                du.AFInAppEventParameterName = b2;
                char c2 = (char) (i2 + values);
                du.valueOf = c2;
                sb.append(c2);
                du.AFInAppEventType = du.valueOf;
                du.values = 1;
                while (du.values < i6) {
                    if (valueOf != null) {
                        byte[] bArr = valueOf;
                        du.AFKeystoreWrapper = du.AFKeystoreWrapper - 1;
                        du.valueOf = (char) (du.AFInAppEventType + (((byte) (bArr[i5] + s)) ^ du.AFInAppEventParameterName));
                    } else {
                        short[] sArr = AppsFlyer2dXConversionCallback;
                        du.AFKeystoreWrapper = du.AFKeystoreWrapper - 1;
                        du.valueOf = (char) (du.AFInAppEventType + (((short) (sArr[i4] + s)) ^ du.AFInAppEventParameterName));
                    }
                    sb.append(du.valueOf);
                    du.AFInAppEventType = du.valueOf;
                    du.values++;
                }
            }
            obj = sb.toString();
        }
        return obj;
    }
}
