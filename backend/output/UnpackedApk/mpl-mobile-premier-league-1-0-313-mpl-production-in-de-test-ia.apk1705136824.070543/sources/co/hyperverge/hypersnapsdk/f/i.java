package co.hyperverge.hypersnapsdk.f;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore.Images.Media;
import android.view.Display;
import android.view.WindowManager;
import androidx.core.widget.CompoundButtonCompat;
import co.hyperverge.hypersnapsdk.HyperSnapSDK;
import co.hyperverge.hypersnapsdk.c.g;
import co.hyperverge.hypersnapsdk.c.n;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import io.sentry.android.core.DefaultAndroidEventProcessor;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import org.apache.fontbox.cmap.CMapParser;

/* compiled from: Utils */
public class i {

    /* renamed from: b  reason: collision with root package name */
    public static int f3183b = 95;

    static {
        new ArrayList(Arrays.asList(new String[]{"android.permission.CAMERA"}));
    }

    public static boolean a(Activity activity) {
        return activity != null && !activity.isFinishing() && !activity.isDestroyed();
    }

    public static Bitmap b(Bitmap bitmap) {
        double d2;
        double d3;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        double d4 = 1.0d;
        if (width > height) {
            if (width > 1500) {
                d2 = ((double) 1500) * 1.0d;
                d3 = (double) width;
            }
            return Bitmap.createScaledBitmap(bitmap, (int) (((double) width) * d4), (int) (((double) height) * d4), true);
        }
        if (height > 1500) {
            d2 = ((double) 1500) * 1.0d;
            d3 = (double) height;
        }
        return Bitmap.createScaledBitmap(bitmap, (int) (((double) width) * d4), (int) (((double) height) * d4), true);
        d4 = d2 / d3;
        return Bitmap.createScaledBitmap(bitmap, (int) (((double) width) * d4), (int) (((double) height) * d4), true);
    }

    public static boolean c(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        Display defaultDisplay2 = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point2 = new Point();
        defaultDisplay2.getRealSize(point2);
        return point.y < point2.y;
    }

    public static boolean d(Context context) {
        return !((context.getApplicationContext().getApplicationInfo().flags & 2) != 0);
    }

    public static int a(int i) {
        if (i != 0 || n.m() == null) {
            return i;
        }
        if (n.m() != null) {
            Map<String, Boolean> j = n.m().j();
            if ((j == null || !j.containsKey("orientation-back-camera")) ? false : j.get("orientation-back-camera").booleanValue()) {
                return 6;
            }
            return i;
        }
        throw null;
    }

    public static String d(String str) {
        StringBuilder sb = new StringBuilder("hvsdk_android_");
        if (HyperSnapSDK.getInstance() != null) {
            String appId = HyperSnapSDK.f2946b.getAppId();
            String valueOf = String.valueOf(System.currentTimeMillis());
            sb.append("3.6.38");
            sb.append("_");
            sb.append(appId);
            sb.append("_");
            sb.append(valueOf);
            return GeneratedOutlineSupport.outline63(sb, "_", str, ".zip");
        }
        throw null;
    }

    public static String b(String str) {
        try {
            return str.substring(str.lastIndexOf(".") + 1);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean b() {
        if (!Build.BRAND.startsWith("generic") || !Build.DEVICE.startsWith("generic")) {
            String str = Build.FINGERPRINT;
            if (!str.startsWith("generic") && !str.startsWith("unknown")) {
                String str2 = Build.HARDWARE;
                if (!str2.contains(CommonUtils.GOLDFISH) && !str2.contains(CommonUtils.RANCHU)) {
                    String str3 = Build.MODEL;
                    if (!str3.contains("google_sdk") && !str3.contains("Emulator") && !str3.contains("Android SDK built for x86") && !Build.MANUFACTURER.contains("Genymotion")) {
                        String str4 = Build.PRODUCT;
                        if (!str4.contains("sdk_google") && !str4.contains("google_sdk") && !str4.contains("sdk") && !str4.contains("sdk_x86") && !str4.contains("sdk_gphone64_arm64") && !str4.contains("vbox86p") && !str4.contains(DefaultAndroidEventProcessor.EMULATOR) && !str4.contains("simulator")) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static String a() {
        return Build.SUPPORTED_ABIS[0];
    }

    public static String a(boolean z) {
        try {
            for (T inetAddresses : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                Iterator<T> it = Collections.list(inetAddresses.getInetAddresses()).iterator();
                while (true) {
                    if (it.hasNext()) {
                        InetAddress inetAddress = (InetAddress) it.next();
                        if (!inetAddress.isLoopbackAddress()) {
                            String hostAddress = inetAddress.getHostAddress();
                            boolean z2 = hostAddress.indexOf(58) < 0;
                            if (z) {
                                if (z2) {
                                    return hostAddress;
                                }
                            } else if (!z2) {
                                int indexOf = hostAddress.indexOf(37);
                                return indexOf < 0 ? hostAddress.toUpperCase() : hostAddress.substring(0, indexOf).toUpperCase();
                            }
                        }
                    }
                }
            }
        } catch (Exception e2) {
            a((Throwable) e2);
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
        }
        return "";
    }

    public static long a(String str, Context context, MediaMetadataRetriever mediaMetadataRetriever) {
        String str2;
        long j = 0;
        if (str != null) {
            try {
                mediaMetadataRetriever.setDataSource(context, Uri.fromFile(new File(str)));
                str2 = mediaMetadataRetriever.extractMetadata(9);
            } catch (Exception e2) {
                a((Throwable) e2);
                return 0;
            }
        } else {
            str2 = null;
        }
        if (str2 != null) {
            j = Long.parseLong(str2);
        }
        return j;
    }

    public static int b(int i) {
        return new Random().nextInt(i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0045, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004e, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x007f, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0088, code lost:
        throw r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r5, java.util.List<java.lang.String> r6, java.io.File r7) {
        /*
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0089 }
            r0.<init>(r7)     // Catch:{ Exception -> 0x0089 }
            java.util.zip.ZipOutputStream r7 = new java.util.zip.ZipOutputStream     // Catch:{ all -> 0x007d }
            r7.<init>(r0)     // Catch:{ all -> 0x007d }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0063 }
        L_0x000e:
            boolean r1 = r6.hasNext()     // Catch:{ all -> 0x0063 }
            if (r1 == 0) goto L_0x006b
            java.lang.Object r1 = r6.next()     // Catch:{ all -> 0x0063 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0063 }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x0063 }
            r2.<init>(r1)     // Catch:{ all -> 0x0063 }
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x004f }
            r1.<init>(r2)     // Catch:{ Exception -> 0x004f }
            java.util.zip.ZipEntry r3 = new java.util.zip.ZipEntry     // Catch:{ all -> 0x0043 }
            java.lang.String r2 = r2.getName()     // Catch:{ all -> 0x0043 }
            r3.<init>(r2)     // Catch:{ all -> 0x0043 }
            r7.putNextEntry(r3)     // Catch:{ all -> 0x0043 }
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch:{ all -> 0x0043 }
        L_0x0034:
            int r3 = r1.read(r2)     // Catch:{ all -> 0x0043 }
            if (r3 < 0) goto L_0x003f
            r4 = 0
            r7.write(r2, r4, r3)     // Catch:{ all -> 0x0043 }
            goto L_0x0034
        L_0x003f:
            r1.close()     // Catch:{ Exception -> 0x004f }
            goto L_0x000e
        L_0x0043:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0045 }
        L_0x0045:
            r3 = move-exception
            r1.close()     // Catch:{ all -> 0x004a }
            goto L_0x004e
        L_0x004a:
            r1 = move-exception
            r2.addSuppressed(r1)     // Catch:{ Exception -> 0x004f }
        L_0x004e:
            throw r3     // Catch:{ Exception -> 0x004f }
        L_0x004f:
            r1 = move-exception
            a(r1)     // Catch:{ all -> 0x0063 }
            co.hyperverge.hypersnapsdk.c.n r2 = co.hyperverge.hypersnapsdk.c.n.m()     // Catch:{ all -> 0x0063 }
            co.hyperverge.hypersnapsdk.service.a.b r3 = r2.i     // Catch:{ all -> 0x0063 }
            if (r3 != 0) goto L_0x0065
            co.hyperverge.hypersnapsdk.service.a.a r3 = new co.hyperverge.hypersnapsdk.service.a.a     // Catch:{ all -> 0x0063 }
            r3.<init>(r5)     // Catch:{ all -> 0x0063 }
            r2.i = r3     // Catch:{ all -> 0x0063 }
            goto L_0x0065
        L_0x0063:
            r6 = move-exception
            goto L_0x0072
        L_0x0065:
            co.hyperverge.hypersnapsdk.service.a.b r2 = r2.i     // Catch:{ all -> 0x0063 }
            r2.a(r1)     // Catch:{ all -> 0x0063 }
            goto L_0x000e
        L_0x006b:
            r7.close()     // Catch:{ all -> 0x007d }
            r0.close()     // Catch:{ Exception -> 0x0089 }
            goto L_0x009e
        L_0x0072:
            throw r6     // Catch:{ all -> 0x0073 }
        L_0x0073:
            r1 = move-exception
            r7.close()     // Catch:{ all -> 0x0078 }
            goto L_0x007c
        L_0x0078:
            r7 = move-exception
            r6.addSuppressed(r7)     // Catch:{ all -> 0x007d }
        L_0x007c:
            throw r1     // Catch:{ all -> 0x007d }
        L_0x007d:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x007f }
        L_0x007f:
            r7 = move-exception
            r0.close()     // Catch:{ all -> 0x0084 }
            goto L_0x0088
        L_0x0084:
            r0 = move-exception
            r6.addSuppressed(r0)     // Catch:{ Exception -> 0x0089 }
        L_0x0088:
            throw r7     // Catch:{ Exception -> 0x0089 }
        L_0x0089:
            r6 = move-exception
            co.hyperverge.hypersnapsdk.c.n r7 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r0 = r7.i
            if (r0 != 0) goto L_0x0099
            co.hyperverge.hypersnapsdk.service.a.a r0 = new co.hyperverge.hypersnapsdk.service.a.a
            r0.<init>(r5)
            r7.i = r0
        L_0x0099:
            co.hyperverge.hypersnapsdk.service.a.b r5 = r7.i
            r5.a(r6)
        L_0x009e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hypersnapsdk.f.i.a(android.content.Context, java.util.List, java.io.File):void");
    }

    public static byte[] a(ContentResolver contentResolver, Uri uri) {
        try {
            InputStream openInputStream = contentResolver.openInputStream(uri);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = openInputStream.read(bArr);
                if (read == -1) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e2) {
            String.format("Error getting bytes from uri: %s,\nerror: %s", new Object[]{uri.toString(), a((Throwable) e2)});
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
            return null;
        } catch (OutOfMemoryError e3) {
            String.format("Out of memory error: %s,\nerror: %s", new Object[]{uri.toString(), a((Throwable) e3)});
            if (n.m().i != null) {
                n.m().i.a(e3);
            }
            return null;
        }
    }

    public static File a(ContentResolver contentResolver, Uri uri, File file) {
        String extensionFromMimeType;
        "saveDocToFilesDir() called with: contentResolver = [" + contentResolver + "], uri = [" + uri + "], hvDir = [" + file + CMapParser.MARK_END_OF_ARRAY;
        File file2 = new File(file, System.currentTimeMillis() + "." + extensionFromMimeType);
        try {
            byte[] a2 = a(contentResolver, uri);
            if (a2 == null) {
                return null;
            }
            if (Objects.equals(extensionFromMimeType, "pdf")) {
                new FileOutputStream(file2).write(a2);
            } else {
                Bitmap b2 = b(g.a(Media.getBitmap(contentResolver, uri), CompoundButtonCompat.getOrientation(a2)));
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                if (b2 == null) {
                    return null;
                }
                b2.compress(CompressFormat.JPEG, 90, fileOutputStream);
                b2.recycle();
            }
            return file2;
        } catch (Exception e2) {
            String.format("Error writing bytes to file: %s,\nerror: %s", new Object[]{file2.getPath(), a((Throwable) e2)});
            return null;
        } catch (OutOfMemoryError e3) {
            String.format("Out of memory error: %s,\nerror: %s", new Object[]{file2.getPath(), a((Throwable) e3)});
            return null;
        }
    }

    public static boolean a(List<String> list, String str) {
        for (String lowerCase : list) {
            if (lowerCase.toLowerCase().contains(str)) {
                return true;
            }
        }
        return false;
    }

    public static long a(Date date) {
        return (GeneratedOutlineSupport.outline13() - date.getTime()) / 60000;
    }

    public static Bitmap a(Bitmap bitmap) {
        try {
            return Bitmap.createBitmap(bitmap, (int) (((double) bitmap.getWidth()) * 0.6666666666666667d), 0, (int) (((double) bitmap.getWidth()) * 0.3333333333333333d), (int) (((double) bitmap.getHeight()) * 0.5d));
        } catch (Exception | OutOfMemoryError e2) {
            a(e2);
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
            return null;
        }
    }

    public static String a(Throwable th) {
        if (th == null) {
            return "Exception is null";
        }
        String message = th.getMessage();
        return (message == null || message.isEmpty()) ? "Exception has no message" : message;
    }
}
