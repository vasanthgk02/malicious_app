package com.shield.android.c;

import android.annotation.SuppressLint;
import android.app.usage.StorageStatsManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.rudderstack.android.sdk.core.ecomm.ECommerceParamNames;
import com.shield.android.b.a;
import com.shield.android.internal.f;
import com.shield.android.internal.j;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java8.util.concurrent.CompletableFuture;
import java8.util.function.Supplier;
import org.json.JSONException;
import org.json.JSONObject;

public class h extends f {

    /* renamed from: b  reason: collision with root package name */
    public final Context f1518b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f1519c = {"/sys/devices/soc0/serial_number", "/sys/devices/system/chip-id/unique_id", "/proc/serial_num"};

    /* renamed from: d  reason: collision with root package name */
    public final String[] f1520d = {"/product/operator/app", "/product/app", "/product/priv-app"};

    /* renamed from: e  reason: collision with root package name */
    public final ExecutorService f1521e;

    /* renamed from: f  reason: collision with root package name */
    public final a f1522f;

    public h(Context context, a aVar, ExecutorService executorService) {
        this.f1518b = context;
        this.f1522f = aVar;
        this.f1521e = executorService;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(15:105|106|107|108|109|(3:111|112|(10:114|117|(1:119)|120|121|122|129|(1:131)|132|133))|115|117|(0)|120|(2:121|122)|129|(0)|132|133) */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x012b, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0134, code lost:
        throw r5;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:108:0x018f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:111:0x01a1 */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0173 A[Catch:{ Exception -> 0x01a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01a0 A[Catch:{ Exception -> 0x01a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01ae A[Catch:{ Exception -> 0x01b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01f2  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004a A[Catch:{ Exception -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0053 A[Catch:{ Exception -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005a A[Catch:{ Exception -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0063 A[Catch:{ Exception -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0167  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void p() {
        /*
            r11 = this;
            java.lang.String r0 = "shmlusr.txt"
            java.lang.String r1 = ""
            android.content.Context r2 = r11.f1518b
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            r4 = 0
            java.io.File r5 = r2.getFilesDir()     // Catch:{ Exception -> 0x007e }
            java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ Exception -> 0x007e }
            java.io.File r6 = r2.getCacheDir()     // Catch:{ Exception -> 0x007e }
            java.lang.String r6 = r6.getAbsolutePath()     // Catch:{ Exception -> 0x007e }
            java.io.File r7 = r2.getExternalFilesDir(r4)     // Catch:{ Exception -> 0x0031 }
            if (r7 == 0) goto L_0x0043
            java.io.File r7 = r2.getExternalFilesDir(r4)     // Catch:{ Exception -> 0x0031 }
            java.lang.Object r7 = java.util.Objects.requireNonNull(r7)     // Catch:{ Exception -> 0x0031 }
            java.io.File r7 = (java.io.File) r7     // Catch:{ Exception -> 0x0031 }
            java.lang.String r7 = r7.getAbsolutePath()     // Catch:{ Exception -> 0x0031 }
            goto L_0x0044
        L_0x0031:
            r7 = move-exception
            com.shield.android.internal.f r8 = com.shield.android.internal.f.a()     // Catch:{ Exception -> 0x007e }
            boolean r8 = r8.f1677b     // Catch:{ Exception -> 0x007e }
            if (r8 == 0) goto L_0x0043
            java.lang.String r8 = r7.getMessage()     // Catch:{ Exception -> 0x007e }
            if (r8 == 0) goto L_0x0043
            r7.getLocalizedMessage()     // Catch:{ Exception -> 0x007e }
        L_0x0043:
            r7 = r1
        L_0x0044:
            java.io.File r8 = r2.getExternalCacheDir()     // Catch:{ Exception -> 0x007e }
            if (r8 == 0) goto L_0x0053
            java.io.File r8 = r2.getExternalCacheDir()     // Catch:{ Exception -> 0x007e }
            java.lang.String r8 = r8.getAbsolutePath()     // Catch:{ Exception -> 0x007e }
            goto L_0x0054
        L_0x0053:
            r8 = r1
        L_0x0054:
            int r9 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x007e }
            r10 = 24
            if (r9 < r10) goto L_0x0063
            java.io.File r2 = r2.getDataDir()     // Catch:{ Exception -> 0x007e }
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ Exception -> 0x007e }
            goto L_0x0064
        L_0x0063:
            r2 = r1
        L_0x0064:
            java.lang.String r9 = "file_path"
            r3.put(r9, r5)     // Catch:{ Exception -> 0x007e }
            java.lang.String r5 = "cache_path"
            r3.put(r5, r6)     // Catch:{ Exception -> 0x007e }
            java.lang.String r5 = "external_file_dir"
            r3.put(r5, r7)     // Catch:{ Exception -> 0x007e }
            java.lang.String r5 = "external_cache_dir"
            r3.put(r5, r8)     // Catch:{ Exception -> 0x007e }
            java.lang.String r5 = "data_dir"
            r3.put(r5, r2)     // Catch:{ Exception -> 0x007e }
            goto L_0x0090
        L_0x007e:
            r2 = move-exception
            com.shield.android.internal.f r5 = com.shield.android.internal.f.a()
            boolean r5 = r5.f1677b
            if (r5 == 0) goto L_0x0090
            java.lang.String r5 = r2.getMessage()
            if (r5 == 0) goto L_0x0090
            r2.getLocalizedMessage()
        L_0x0090:
            java.lang.String r2 = r3.toString()
            if (r2 != 0) goto L_0x0097
            r2 = r1
        L_0x0097:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r3 = r11.f1517a
            java.lang.String r5 = "FILE_PATHS"
            r3.put(r5, r2)
            android.content.Context r2 = r11.f1518b
            java.lang.String r2 = r11.b(r2)
            int r3 = android.os.Build.VERSION.SDK_INT
            r5 = 29
            java.lang.String r6 = "DEVICE_UUID"
            if (r3 >= r5) goto L_0x0167
            android.content.Context r3 = r11.f1518b
            java.io.File r3 = r3.getObbDir()     // Catch:{ Exception -> 0x00f4 }
            boolean r5 = r3.exists()     // Catch:{ Exception -> 0x00f4 }
            if (r5 == 0) goto L_0x00f4
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x00f4 }
            r5.<init>(r3, r0)     // Catch:{ Exception -> 0x00f4 }
            boolean r3 = r5.exists()     // Catch:{ Exception -> 0x00f4 }
            if (r3 != 0) goto L_0x00f4
            java.io.File r3 = r5.getParentFile()     // Catch:{ Exception -> 0x00f4 }
            if (r3 == 0) goto L_0x00f4
            java.io.File r3 = r5.getParentFile()     // Catch:{ Exception -> 0x00f4 }
            boolean r3 = r3.mkdirs()     // Catch:{ Exception -> 0x00f4 }
            if (r3 == 0) goto L_0x00f4
            java.io.FileWriter r3 = new java.io.FileWriter     // Catch:{ IOException -> 0x00e2 }
            r3.<init>(r5)     // Catch:{ IOException -> 0x00e2 }
            r3.append(r2)     // Catch:{ IOException -> 0x00e2 }
            r3.flush()     // Catch:{ IOException -> 0x00e2 }
            r3.close()     // Catch:{ IOException -> 0x00e2 }
            goto L_0x00f4
        L_0x00e2:
            r2 = move-exception
            com.shield.android.internal.f r3 = com.shield.android.internal.f.a()     // Catch:{ Exception -> 0x00f4 }
            boolean r3 = r3.f1677b     // Catch:{ Exception -> 0x00f4 }
            if (r3 == 0) goto L_0x00f4
            java.lang.String r3 = r2.getMessage()     // Catch:{ Exception -> 0x00f4 }
            if (r3 == 0) goto L_0x00f4
            r2.getLocalizedMessage()     // Catch:{ Exception -> 0x00f4 }
        L_0x00f4:
            android.content.Context r2 = r11.f1518b
            java.io.File r3 = r2.getObbDir()     // Catch:{ Exception -> 0x015a }
            boolean r5 = r3.exists()     // Catch:{ Exception -> 0x015a }
            if (r5 == 0) goto L_0x015a
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x015a }
            r5.<init>(r3, r0)     // Catch:{ Exception -> 0x015a }
            boolean r0 = r5.exists()     // Catch:{ Exception -> 0x015a }
            if (r0 == 0) goto L_0x015a
            java.io.FileReader r0 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x0148, IOException -> 0x0135 }
            r0.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0148, IOException -> 0x0135 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0129 }
            r3.<init>()     // Catch:{ all -> 0x0129 }
        L_0x0115:
            int r5 = r0.read()     // Catch:{ all -> 0x0129 }
            r7 = -1
            if (r5 == r7) goto L_0x0121
            char r5 = (char) r5     // Catch:{ all -> 0x0129 }
            r3.append(r5)     // Catch:{ all -> 0x0129 }
            goto L_0x0115
        L_0x0121:
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0129 }
            r0.close()     // Catch:{ FileNotFoundException -> 0x0148, IOException -> 0x0135 }
            goto L_0x015e
        L_0x0129:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x012b }
        L_0x012b:
            r5 = move-exception
            r0.close()     // Catch:{ all -> 0x0130 }
            goto L_0x0134
        L_0x0130:
            r0 = move-exception
            r3.addSuppressed(r0)     // Catch:{ FileNotFoundException -> 0x0148, IOException -> 0x0135 }
        L_0x0134:
            throw r5     // Catch:{ FileNotFoundException -> 0x0148, IOException -> 0x0135 }
        L_0x0135:
            r0 = move-exception
            com.shield.android.internal.f r3 = com.shield.android.internal.f.a()     // Catch:{ Exception -> 0x015a }
            boolean r3 = r3.f1677b     // Catch:{ Exception -> 0x015a }
            if (r3 == 0) goto L_0x015a
            java.lang.String r3 = r0.getMessage()     // Catch:{ Exception -> 0x015a }
            if (r3 == 0) goto L_0x015a
            r0.getLocalizedMessage()     // Catch:{ Exception -> 0x015a }
            goto L_0x015a
        L_0x0148:
            r0 = move-exception
            com.shield.android.internal.f r3 = com.shield.android.internal.f.a()     // Catch:{ Exception -> 0x015a }
            boolean r3 = r3.f1677b     // Catch:{ Exception -> 0x015a }
            if (r3 == 0) goto L_0x015a
            java.lang.String r3 = r0.getMessage()     // Catch:{ Exception -> 0x015a }
            if (r3 == 0) goto L_0x015a
            r0.getLocalizedMessage()     // Catch:{ Exception -> 0x015a }
        L_0x015a:
            java.lang.String r3 = r11.b(r2)
        L_0x015e:
            if (r3 != 0) goto L_0x0161
            r3 = r1
        L_0x0161:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r0 = r11.f1517a
            r0.put(r6, r3)
            goto L_0x016f
        L_0x0167:
            if (r2 != 0) goto L_0x016a
            r2 = r1
        L_0x016a:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r0 = r11.f1517a
            r0.put(r6, r2)
        L_0x016f:
            com.shield.android.b.a r0 = r11.f1522f     // Catch:{ Exception -> 0x01a1 }
            if (r0 == 0) goto L_0x01a0
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x01a1 }
            r2.<init>()     // Catch:{ Exception -> 0x01a1 }
            java.util.concurrent.CountDownLatch r3 = new java.util.concurrent.CountDownLatch     // Catch:{ Exception -> 0x018f }
            r4 = 1
            r3.<init>(r4)     // Catch:{ Exception -> 0x018f }
            com.google.android.gms.tasks.Task<com.google.android.gms.appset.AppSetIdInfo> r4 = r0.f1506b     // Catch:{ Exception -> 0x018f }
            com.shield.android.b.-$$Lambda$TFv2vYYOvi_ZU1CrkFyZT9HBPHM r5 = new com.shield.android.b.-$$Lambda$TFv2vYYOvi_ZU1CrkFyZT9HBPHM     // Catch:{ Exception -> 0x018f }
            r5.<init>(r2, r0, r3)     // Catch:{ Exception -> 0x018f }
            r4.addOnCompleteListener(r5)     // Catch:{ Exception -> 0x018f }
            r4 = 1
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ Exception -> 0x018f }
            r3.await(r4, r0)     // Catch:{ Exception -> 0x018f }
        L_0x018f:
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x01a1 }
            java.lang.String r2 = "appSetIDJson.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)     // Catch:{ Exception -> 0x01a1 }
            java.lang.String r2 = "APP_SET_ID"
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r3 = r11.f1517a     // Catch:{ Exception -> 0x01a1 }
            r3.put(r2, r0)     // Catch:{ Exception -> 0x01a1 }
            goto L_0x01a1
        L_0x01a0:
            throw r4     // Catch:{ Exception -> 0x01a1 }
        L_0x01a1:
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x01b3 }
            java.lang.String r2 = "/system/build.prop"
            r0.<init>(r2)     // Catch:{ Exception -> 0x01b3 }
            boolean r2 = r0.exists()     // Catch:{ Exception -> 0x01b3 }
            if (r2 == 0) goto L_0x01b3
            long r2 = r0.lastModified()     // Catch:{ Exception -> 0x01b3 }
            goto L_0x01b5
        L_0x01b3:
            r2 = -1
        L_0x01b5:
            java.lang.String r0 = java.lang.String.valueOf(r2)
            if (r0 != 0) goto L_0x01bc
            r0 = r1
        L_0x01bc:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r2 = r11.f1517a
            java.lang.String r3 = "BUILD_PROP_MODIFIED_TIME"
            r2.put(r3, r0)
            android.content.Context r0 = r11.f1518b
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.util.HashMap r0 = r11.a(r0)     // Catch:{ Exception -> 0x01d2 }
            r2.putAll(r0)     // Catch:{ Exception -> 0x01d2 }
            goto L_0x01e6
        L_0x01d2:
            r0 = move-exception
            java.lang.String r3 = "h"
            com.shield.android.internal.f r3 = com.shield.android.internal.f.a(r3)
            boolean r3 = r3.f1677b
            if (r3 == 0) goto L_0x01e6
            java.lang.String r3 = r0.getMessage()
            if (r3 == 0) goto L_0x01e6
            r0.getLocalizedMessage()
        L_0x01e6:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>(r2)
            java.lang.String r0 = r0.toString()
            if (r0 != 0) goto L_0x01f2
            goto L_0x01f3
        L_0x01f2:
            r1 = r0
        L_0x01f3:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r0 = r11.f1517a
            java.lang.String r2 = "EXTRA"
            r0.put(r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shield.android.c.h.p():void");
    }

    /* access modifiers changed from: private */
    public void q() {
        String str;
        long j;
        long j2;
        long j3;
        long j4;
        String str2;
        long j5;
        String str3 = "";
        String str4 = "error";
        try {
            JSONObject jSONObject = new JSONObject();
            StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            StatFs statFs2 = new StatFs(Environment.getDataDirectory().getAbsolutePath());
            if (VERSION.SDK_INT >= 26) {
                StorageManager storageManager = (StorageManager) this.f1518b.getSystemService("storage");
                File[] externalFilesDirs = this.f1518b.getExternalFilesDirs(null);
                int length = externalFilesDirs.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        j4 = 0;
                        j3 = 0;
                        j2 = 0;
                        j = 0;
                        break;
                    }
                    StorageVolume storageVolume = storageManager.getStorageVolume(externalFilesDirs[i]);
                    if (storageVolume != null) {
                        if (storageVolume.isPrimary()) {
                            StorageStatsManager storageStatsManager = (StorageStatsManager) this.f1518b.getSystemService("storagestats");
                            ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
                            CompletableFuture[] completableFutureArr = {CompletableFuture.supplyAsync(new Supplier(storageStatsManager) {
                                public final /* synthetic */ StorageStatsManager f$0;

                                {
                                    this.f$0 = r1;
                                }

                                public final Object get() {
                                    return h.b(this.f$0);
                                }
                            }, newFixedThreadPool).exceptionally($$Lambda$6JlgKp0oC9gMjyEL4P_rMOeZu64.INSTANCE), CompletableFuture.supplyAsync(new Supplier(storageStatsManager) {
                                public final /* synthetic */ StorageStatsManager f$0;

                                {
                                    this.f$0 = r1;
                                }

                                public final Object get() {
                                    return h.a(this.f$0);
                                }
                            }, newFixedThreadPool).exceptionally($$Lambda$RHhyvBV0jspoaBKn3YFmxl3iI.INSTANCE)};
                            CompletableFuture.andTree(completableFutureArr, 0, 1).get();
                            newFixedThreadPool.shutdown();
                            Long[] lArr = (Long[]) Arrays.stream(completableFutureArr).map($$Lambda$OnnVhR9f8NdektaZb7jvsjK2PrQ.INSTANCE).toArray($$Lambda$_HE35vqcA8hGIeBmKg9BJjrCfE.INSTANCE);
                            j3 = lArr[0].longValue();
                            j = lArr[1].longValue();
                            j4 = 0;
                            j2 = 0;
                            break;
                        }
                    }
                    i++;
                }
            } else {
                j4 = statFs.getBlockCountLong() * statFs.getBlockSizeLong();
                long availableBlocksLong = statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
                long blockCountLong = statFs2.getBlockCountLong() * statFs2.getBlockSizeLong();
                j = statFs2.getAvailableBlocksLong() * statFs2.getBlockSizeLong();
                long j6 = availableBlocksLong;
                j3 = blockCountLong;
                j2 = j6;
            }
            NumberFormat numberInstance = DecimalFormat.getNumberInstance(Locale.ENGLISH);
            numberInstance.setMinimumFractionDigits(2);
            numberInstance.setMaximumFractionDigits(2);
            String format = numberInstance.format((double) (((float) (j4 + j3)) / 1.0E9f));
            String format2 = numberInstance.format((double) (((float) (j + j2)) / 1.0E9f));
            try {
                str2 = numberInstance.format((double) (((float) (((long) statFs2.getBlockCount()) * ((long) statFs2.getBlockSize()))) / 1.0E9f));
            } catch (Exception unused) {
                str2 = str4;
            }
            try {
                long j7 = 0;
                for (String file : this.f1520d) {
                    File file2 = new File(file);
                    if (file2.exists()) {
                        j7 += a(file2);
                    }
                }
                j5 = j7;
            } catch (Exception unused2) {
                j5 = 0;
            }
            try {
                str4 = numberInstance.format((double) (((float) j5) / 1.0E9f));
            } catch (Exception unused3) {
            }
            try {
                jSONObject.put(ECommerceParamNames.TOTAL, format);
                jSONObject.put("free", format2);
                jSONObject.put("user_storage_total", str2);
                jSONObject.put("preload_apps_usage", str4);
            } catch (JSONException e2) {
                if (f.a().f1677b && e2.getMessage() != null) {
                    e2.getLocalizedMessage();
                }
            }
            str = jSONObject.toString();
        } catch (Exception e3) {
            if (f.a().f1677b && e3.getMessage() != null) {
                e3.getLocalizedMessage();
            }
            str = str3;
        }
        if (str != null) {
            str3 = str;
        }
        this.f1517a.put("DISKSPACE", str3);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01cb A[Catch:{ CameraAccessException -> 0x0277 }] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0280  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0193  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void r() {
        /*
            r19 = this;
            r1 = r19
            java.lang.String[] r0 = r1.f1519c
            int r2 = r0.length
            r3 = 0
            r4 = 0
        L_0x0007:
            java.lang.String r5 = "[^A-Za-z0-9 \\s\\-_.]+"
            java.lang.String r6 = "/system/bin/cat"
            r7 = 2
            r8 = 1
            java.lang.String r9 = ""
            if (r4 >= r2) goto L_0x002b
            r10 = r0[r4]
            java.lang.String[] r11 = new java.lang.String[r7]     // Catch:{ Exception -> 0x0028 }
            r11[r3] = r6     // Catch:{ Exception -> 0x0028 }
            r11[r8] = r10     // Catch:{ Exception -> 0x0028 }
            java.lang.String r10 = r1.a(r11)     // Catch:{ Exception -> 0x0028 }
            java.lang.String r10 = r10.replaceAll(r5, r9)     // Catch:{ Exception -> 0x0028 }
            int r11 = r10.length()     // Catch:{ Exception -> 0x0028 }
            if (r11 <= 0) goto L_0x0028
            goto L_0x002c
        L_0x0028:
            int r4 = r4 + 1
            goto L_0x0007
        L_0x002b:
            r10 = r9
        L_0x002c:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r0 = r1.f1517a
            java.lang.String r2 = "BOARD_NUMBER"
            r0.put(r2, r10)
            java.lang.String r0 = "/proc/partitions"
            java.lang.String[] r0 = new java.lang.String[]{r6, r0}     // Catch:{ Exception -> 0x0042 }
            java.lang.String r0 = r1.a(r0)     // Catch:{ Exception -> 0x0042 }
            java.lang.String r0 = r0.replaceAll(r5, r9)     // Catch:{ Exception -> 0x0042 }
            goto L_0x0057
        L_0x0042:
            r0 = move-exception
            java.lang.String r2 = "h"
            com.shield.android.internal.f r2 = com.shield.android.internal.f.a(r2)
            boolean r2 = r2.f1677b
            if (r2 == 0) goto L_0x0056
            java.lang.String r2 = r0.getMessage()
            if (r2 == 0) goto L_0x0056
            r0.getLocalizedMessage()
        L_0x0056:
            r0 = r9
        L_0x0057:
            if (r0 != 0) goto L_0x005a
            r0 = r9
        L_0x005a:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r2 = r1.f1517a
            java.lang.String r4 = "PARTITIONS_INFO"
            r2.put(r4, r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 24
            if (r0 < r2) goto L_0x00b7
            android.content.Context r0 = r1.f1518b
            java.lang.String r2 = "storage"
            java.lang.Object r0 = r0.getSystemService(r2)
            android.os.storage.StorageManager r0 = (android.os.storage.StorageManager) r0
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.List r0 = r0.getStorageVolumes()     // Catch:{ Exception -> 0x0116 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0116 }
        L_0x007e:
            boolean r4 = r0.hasNext()     // Catch:{ Exception -> 0x0116 }
            if (r4 == 0) goto L_0x00ad
            java.lang.Object r4 = r0.next()     // Catch:{ Exception -> 0x0116 }
            android.os.storage.StorageVolume r4 = (android.os.storage.StorageVolume) r4     // Catch:{ Exception -> 0x0116 }
            java.lang.Class r5 = r4.getClass()     // Catch:{ Exception -> 0x007e }
            java.lang.String r6 = "getFatVolumeId"
            java.lang.Class[] r10 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x007e }
            java.lang.reflect.Method r5 = r5.getDeclaredMethod(r6, r10)     // Catch:{ Exception -> 0x007e }
            java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x007e }
            java.lang.Object r4 = r5.invoke(r4, r6)     // Catch:{ Exception -> 0x007e }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ Exception -> 0x007e }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x007e }
            r5 = -1
            if (r4 == r5) goto L_0x007e
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x007e }
            r2.add(r4)     // Catch:{ Exception -> 0x007e }
            goto L_0x007e
        L_0x00ad:
            java.util.Collections.sort(r2)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r0 = ","
            java.lang.String r0 = android.text.TextUtils.join(r0, r2)     // Catch:{ Exception -> 0x0116 }
            goto L_0x0117
        L_0x00b7:
            java.io.File r0 = new java.io.File     // Catch:{  }
            java.lang.String r2 = "/sys/block/mmcblk1"
            r0.<init>(r2)     // Catch:{  }
            java.io.File r2 = new java.io.File     // Catch:{  }
            java.lang.String r4 = "/sys/block/mmcblk0"
            r2.<init>(r4)     // Catch:{  }
            boolean r4 = r0.exists()     // Catch:{  }
            if (r4 == 0) goto L_0x00d4
            boolean r0 = r0.isDirectory()     // Catch:{  }
            if (r0 == 0) goto L_0x00d4
            java.lang.String r0 = "mmcblk1"
            goto L_0x00e5
        L_0x00d4:
            boolean r0 = r2.exists()     // Catch:{  }
            if (r0 == 0) goto L_0x00e3
            boolean r0 = r2.isDirectory()     // Catch:{  }
            if (r0 == 0) goto L_0x00e3
            java.lang.String r0 = "mmcblk0"
            goto L_0x00e5
        L_0x00e3:
            java.lang.String r0 = "mmcblk2"
        L_0x00e5:
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch:{  }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{  }
            r4.<init>()     // Catch:{  }
            java.lang.String r5 = "cat /sys/block/"
            r4.append(r5)     // Catch:{  }
            r4.append(r0)     // Catch:{  }
            java.lang.String r0 = "/device/cid"
            r4.append(r0)     // Catch:{  }
            java.lang.String r0 = r4.toString()     // Catch:{  }
            java.lang.Process r0 = r2.exec(r0)     // Catch:{  }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{  }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{  }
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{  }
            r4.<init>(r0)     // Catch:{  }
            r2.<init>(r4)     // Catch:{  }
            java.lang.String r0 = r2.readLine()     // Catch:{  }
            goto L_0x0117
        L_0x0116:
            r0 = r9
        L_0x0117:
            if (r0 != 0) goto L_0x011a
            r0 = r9
        L_0x011a:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r2 = r1.f1517a
            java.lang.String r4 = "SDCARD_UUIDS"
            r2.put(r4, r0)
            java.lang.String r0 = android.os.Build.BRAND
            if (r0 != 0) goto L_0x0126
            r0 = r9
        L_0x0126:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r2 = r1.f1517a
            java.lang.String r4 = "BRAND"
            r2.put(r4, r0)
            java.lang.String r0 = android.os.Build.MODEL
            if (r0 != 0) goto L_0x0132
            r0 = r9
        L_0x0132:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r2 = r1.f1517a
            java.lang.String r4 = "DEVICE_MODEL"
            r2.put(r4, r0)
            android.content.Context r2 = r1.f1518b
            java.lang.String r0 = "uimode"
            java.lang.Object r0 = r2.getSystemService(r0)     // Catch:{ Exception -> 0x014d }
            android.app.UiModeManager r0 = (android.app.UiModeManager) r0     // Catch:{ Exception -> 0x014d }
            int r0 = r0.getCurrentModeType()     // Catch:{ Exception -> 0x014d }
            r4 = 4
            if (r0 != r4) goto L_0x015f
            java.lang.String r0 = "tv"
            goto L_0x0178
        L_0x014d:
            r0 = move-exception
            com.shield.android.internal.f r4 = com.shield.android.internal.f.a()
            boolean r4 = r4.f1677b
            if (r4 == 0) goto L_0x015f
            java.lang.String r4 = r0.getMessage()
            if (r4 == 0) goto L_0x015f
            r0.getLocalizedMessage()
        L_0x015f:
            android.content.res.Resources r0 = r2.getResources()     // Catch:{ Exception -> 0x0170 }
            android.content.res.Configuration r0 = r0.getConfiguration()     // Catch:{ Exception -> 0x0170 }
            int r0 = r0.screenLayout     // Catch:{ Exception -> 0x0170 }
            r0 = r0 & 15
            r2 = 3
            if (r0 < r2) goto L_0x0170
            r0 = 1
            goto L_0x0171
        L_0x0170:
            r0 = 0
        L_0x0171:
            if (r0 == 0) goto L_0x0176
            java.lang.String r0 = "tablet"
            goto L_0x0178
        L_0x0176:
            java.lang.String r0 = "phone"
        L_0x0178:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r2 = r1.f1517a
            java.lang.String r4 = "DEVICE_TYPE"
            r2.put(r4, r0)
            java.lang.String r0 = android.os.Build.FINGERPRINT
            if (r0 != 0) goto L_0x0184
            r0 = r9
        L_0x0184:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r2 = r1.f1517a
            java.lang.String r4 = "OS_BUILD_NUMBER"
            r2.put(r4, r0)
            java.lang.String r0 = "os.arch"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            if (r0 != 0) goto L_0x0194
            r0 = r9
        L_0x0194:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r2 = r1.f1517a
            java.lang.String r4 = "CPU"
            r2.put(r4, r0)
            android.content.Context r0 = r1.f1518b     // Catch:{ Exception -> 0x027b }
            java.lang.String r2 = "camera"
            java.lang.Object r0 = r0.getSystemService(r2)     // Catch:{ Exception -> 0x027b }
            android.hardware.camera2.CameraManager r0 = (android.hardware.camera2.CameraManager) r0     // Catch:{ Exception -> 0x027b }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ CameraAccessException -> 0x0277 }
            r2.<init>()     // Catch:{ CameraAccessException -> 0x0277 }
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ CameraAccessException -> 0x0277 }
            r4.<init>()     // Catch:{ CameraAccessException -> 0x0277 }
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ CameraAccessException -> 0x0277 }
            r5.<init>()     // Catch:{ CameraAccessException -> 0x0277 }
            org.json.JSONArray r6 = new org.json.JSONArray     // Catch:{ CameraAccessException -> 0x0277 }
            r6.<init>()     // Catch:{ CameraAccessException -> 0x0277 }
            org.json.JSONArray r10 = new org.json.JSONArray     // Catch:{ CameraAccessException -> 0x0277 }
            r10.<init>()     // Catch:{ CameraAccessException -> 0x0277 }
            java.lang.String[] r11 = r0.getCameraIdList()     // Catch:{ CameraAccessException -> 0x0277 }
            if (r11 == 0) goto L_0x025d
            int r12 = r11.length     // Catch:{ CameraAccessException -> 0x0277 }
            if (r12 <= 0) goto L_0x025d
            int r12 = r11.length     // Catch:{ CameraAccessException -> 0x0277 }
            r13 = 0
        L_0x01c9:
            if (r13 >= r12) goto L_0x025d
            r14 = r11[r13]     // Catch:{ CameraAccessException -> 0x0277 }
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ CameraAccessException -> 0x0277 }
            r15.<init>()     // Catch:{ CameraAccessException -> 0x0277 }
            android.hardware.camera2.CameraCharacteristics r14 = r0.getCameraCharacteristics(r14)     // Catch:{ CameraAccessException -> 0x0277 }
            android.hardware.camera2.CameraCharacteristics$Key r7 = android.hardware.camera2.CameraCharacteristics.LENS_FACING     // Catch:{ CameraAccessException -> 0x0277 }
            java.lang.Object r7 = r14.get(r7)     // Catch:{ CameraAccessException -> 0x0277 }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ CameraAccessException -> 0x0277 }
            int r7 = r7.intValue()     // Catch:{ CameraAccessException -> 0x0277 }
            android.hardware.camera2.CameraCharacteristics$Key r8 = android.hardware.camera2.CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP     // Catch:{ CameraAccessException -> 0x0277 }
            java.lang.Object r8 = r14.get(r8)     // Catch:{ CameraAccessException -> 0x0277 }
            android.hardware.camera2.params.StreamConfigurationMap r8 = (android.hardware.camera2.params.StreamConfigurationMap) r8     // Catch:{ CameraAccessException -> 0x0277 }
            r14 = 256(0x100, float:3.59E-43)
            android.util.Size[] r8 = r8.getOutputSizes(r14)     // Catch:{ CameraAccessException -> 0x0277 }
            int r14 = r8.length     // Catch:{ CameraAccessException -> 0x0277 }
            if (r14 <= 0) goto L_0x0237
            r8 = r8[r3]     // Catch:{ CameraAccessException -> 0x0277 }
            java.lang.String r14 = "max_resolution"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ CameraAccessException -> 0x0277 }
            r3.<init>()     // Catch:{ CameraAccessException -> 0x0277 }
            r16 = r0
            int r0 = r8.getHeight()     // Catch:{ CameraAccessException -> 0x0277 }
            r3.append(r0)     // Catch:{ CameraAccessException -> 0x0277 }
            java.lang.String r0 = " x "
            r3.append(r0)     // Catch:{ CameraAccessException -> 0x0277 }
            int r0 = r8.getWidth()     // Catch:{ CameraAccessException -> 0x0277 }
            r3.append(r0)     // Catch:{ CameraAccessException -> 0x0277 }
            java.lang.String r0 = r3.toString()     // Catch:{ CameraAccessException -> 0x0277 }
            r15.put(r14, r0)     // Catch:{ CameraAccessException -> 0x0277 }
            java.lang.String r0 = "megapixels"
            int r3 = r8.getWidth()     // Catch:{ CameraAccessException -> 0x0277 }
            int r8 = r8.getHeight()     // Catch:{ CameraAccessException -> 0x0277 }
            int r3 = r3 * r8
            float r3 = (float) r3     // Catch:{ CameraAccessException -> 0x0277 }
            r8 = 1203982336(0x47c35000, float:100000.0)
            float r3 = r3 / r8
            int r3 = java.lang.Math.round(r3)     // Catch:{ CameraAccessException -> 0x0277 }
            r14 = r9
            double r8 = (double) r3
            r17 = 4621819117588971520(0x4024000000000000, double:10.0)
            double r8 = r8 / r17
            r15.put(r0, r8)     // Catch:{ CameraAccessException -> 0x0278, Exception -> 0x027c }
            goto L_0x023a
        L_0x0237:
            r16 = r0
            r14 = r9
        L_0x023a:
            if (r7 != 0) goto L_0x0242
            r4.put(r15)     // Catch:{ CameraAccessException -> 0x0278, Exception -> 0x027c }
            r3 = 1
        L_0x0240:
            r8 = 2
            goto L_0x0253
        L_0x0242:
            r3 = 1
            if (r7 != r3) goto L_0x0249
            r5.put(r15)     // Catch:{ CameraAccessException -> 0x0278, Exception -> 0x027c }
            goto L_0x0240
        L_0x0249:
            r8 = 2
            if (r7 != r8) goto L_0x0250
            r6.put(r15)     // Catch:{ CameraAccessException -> 0x0278, Exception -> 0x027c }
            goto L_0x0253
        L_0x0250:
            r10.put(r15)     // Catch:{ CameraAccessException -> 0x0278, Exception -> 0x027c }
        L_0x0253:
            int r13 = r13 + 1
            r9 = r14
            r0 = r16
            r3 = 0
            r7 = 2
            r8 = 1
            goto L_0x01c9
        L_0x025d:
            r14 = r9
            java.lang.String r0 = "front"
            r2.put(r0, r4)     // Catch:{ CameraAccessException -> 0x0278, Exception -> 0x027c }
            java.lang.String r0 = "back"
            r2.put(r0, r5)     // Catch:{ CameraAccessException -> 0x0278, Exception -> 0x027c }
            java.lang.String r0 = "external"
            r2.put(r0, r6)     // Catch:{ CameraAccessException -> 0x0278, Exception -> 0x027c }
            java.lang.String r0 = "unknown"
            r2.put(r0, r10)     // Catch:{ CameraAccessException -> 0x0278, Exception -> 0x027c }
            java.lang.String r0 = r2.toString()     // Catch:{ CameraAccessException -> 0x0278, Exception -> 0x027c }
            goto L_0x027e
        L_0x0277:
            r14 = r9
        L_0x0278:
            java.lang.String r0 = "disabled"
            goto L_0x027e
        L_0x027b:
            r14 = r9
        L_0x027c:
            java.lang.String r0 = "error"
        L_0x027e:
            if (r0 != 0) goto L_0x0282
            r9 = r14
            goto L_0x0283
        L_0x0282:
            r9 = r0
        L_0x0283:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r0 = r1.f1517a
            java.lang.String r2 = "CAMERA_INFO"
            r0.put(r2, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shield.android.c.h.r():void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0226 A[SYNTHETIC, Splitter:B:130:0x0226] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x02f1  */
    /* JADX WARNING: Removed duplicated region for block: B:192:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00c5 A[Catch:{ Exception -> 0x00f4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0159 A[Catch:{ Exception -> 0x0172 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void s() {
        /*
            r15 = this;
            java.lang.String r0 = "disabled"
            java.lang.String r1 = "error"
            java.lang.String r2 = "h"
            java.lang.String r3 = ""
            android.content.Context r4 = r15.f1518b
            java.lang.String r5 = "sensor"
            java.lang.Object r4 = r4.getSystemService(r5)     // Catch:{ Exception -> 0x0020 }
            android.hardware.SensorManager r4 = (android.hardware.SensorManager) r4     // Catch:{ Exception -> 0x0020 }
            r5 = 8
            android.hardware.Sensor r4 = r4.getDefaultSensor(r5)     // Catch:{ Exception -> 0x0020 }
            if (r4 != 0) goto L_0x001d
            java.lang.String r4 = "0"
            goto L_0x0033
        L_0x001d:
            java.lang.String r4 = "1"
            goto L_0x0033
        L_0x0020:
            r4 = move-exception
            com.shield.android.internal.f r5 = com.shield.android.internal.f.a(r2)
            boolean r5 = r5.f1677b
            if (r5 == 0) goto L_0x0032
            java.lang.String r5 = r4.getMessage()
            if (r5 == 0) goto L_0x0032
            r4.getLocalizedMessage()
        L_0x0032:
            r4 = r3
        L_0x0033:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r5 = r15.f1517a
            java.lang.String r6 = "PROXIMITY"
            r5.put(r6, r4)
            android.content.Context r4 = r15.f1518b
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r6 = 1
            r7 = 0
            java.lang.String r8 = "wifi"
            java.lang.Object r8 = r4.getSystemService(r8)     // Catch:{ Exception -> 0x00a3 }
            android.net.wifi.WifiManager r8 = (android.net.wifi.WifiManager) r8     // Catch:{ Exception -> 0x00a3 }
            if (r8 == 0) goto L_0x0090
            java.lang.String r9 = "android.permission.ACCESS_WIFI_STATE"
            int r4 = r4.checkCallingOrSelfPermission(r9)     // Catch:{ Exception -> 0x00a3 }
            if (r4 != 0) goto L_0x0057
            r4 = 1
            goto L_0x0058
        L_0x0057:
            r4 = 0
        L_0x0058:
            if (r4 == 0) goto L_0x0090
            android.net.wifi.WifiInfo r4 = r8.getConnectionInfo()     // Catch:{ Exception -> 0x00a3 }
            if (r4 == 0) goto L_0x0080
            java.lang.String r4 = r4.getMacAddress()     // Catch:{ Exception -> 0x00a3 }
            if (r4 == 0) goto L_0x0070
            java.lang.String r8 = ":"
            java.lang.String r4 = r4.replace(r8, r3)     // Catch:{ Exception -> 0x00a3 }
            r5.add(r4)     // Catch:{ Exception -> 0x00a3 }
            goto L_0x00b6
        L_0x0070:
            com.shield.android.internal.f r4 = com.shield.android.internal.f.a(r2)     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r8 = "Fail to get wifi message"
            java.lang.Object[] r9 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x00a3 }
            boolean r4 = r4.f1677b     // Catch:{ Exception -> 0x00a3 }
            if (r4 == 0) goto L_0x00b6
            java.lang.String.format(r8, r9)     // Catch:{ Exception -> 0x00a3 }
            goto L_0x00b6
        L_0x0080:
            com.shield.android.internal.f r4 = com.shield.android.internal.f.a(r2)     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r8 = "Wi-Fi not enabled, skipping."
            java.lang.Object[] r9 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x00a3 }
            boolean r4 = r4.f1677b     // Catch:{ Exception -> 0x00a3 }
            if (r4 == 0) goto L_0x00b6
            java.lang.String.format(r8, r9)     // Catch:{ Exception -> 0x00a3 }
            goto L_0x00b6
        L_0x0090:
            com.shield.android.internal.f r4 = com.shield.android.internal.f.a(r2)     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r8 = "Wi-Fi is not a supported system service"
            java.lang.Object[] r9 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x00a3 }
            boolean r4 = r4.f1677b     // Catch:{ Exception -> 0x00a3 }
            if (r4 == 0) goto L_0x009f
            java.lang.String.format(r8, r9)     // Catch:{ Exception -> 0x00a3 }
        L_0x009f:
            r5.add(r0)     // Catch:{ Exception -> 0x00a3 }
            goto L_0x00b6
        L_0x00a3:
            com.shield.android.internal.f r4 = com.shield.android.internal.f.a(r2)
            java.lang.Object[] r8 = new java.lang.Object[r7]
            boolean r4 = r4.f1677b
            if (r4 == 0) goto L_0x00b3
            java.lang.String r4 = "Wi-Fi permission denied."
            java.lang.String.format(r4, r8)
        L_0x00b3:
            r5.add(r1)
        L_0x00b6:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f4 }
            r4.<init>()     // Catch:{ Exception -> 0x00f4 }
            java.util.Enumeration r8 = java.net.NetworkInterface.getNetworkInterfaces()     // Catch:{ Exception -> 0x00f4 }
        L_0x00bf:
            boolean r9 = r8.hasMoreElements()     // Catch:{ Exception -> 0x00f4 }
            if (r9 == 0) goto L_0x00ec
            java.lang.Object r9 = r8.nextElement()     // Catch:{ Exception -> 0x00f4 }
            java.net.NetworkInterface r9 = (java.net.NetworkInterface) r9     // Catch:{ Exception -> 0x00f4 }
            byte[] r9 = r9.getHardwareAddress()     // Catch:{ Exception -> 0x00f4 }
            if (r9 != 0) goto L_0x00d2
            goto L_0x00bf
        L_0x00d2:
            int r10 = r9.length     // Catch:{ Exception -> 0x00f4 }
            r11 = 0
        L_0x00d4:
            if (r11 >= r10) goto L_0x00bf
            byte r12 = r9[r11]     // Catch:{ Exception -> 0x00f4 }
            java.lang.String r13 = "%02X"
            java.lang.Object[] r14 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x00f4 }
            java.lang.Byte r12 = java.lang.Byte.valueOf(r12)     // Catch:{ Exception -> 0x00f4 }
            r14[r7] = r12     // Catch:{ Exception -> 0x00f4 }
            java.lang.String r12 = java.lang.String.format(r13, r14)     // Catch:{ Exception -> 0x00f4 }
            r4.append(r12)     // Catch:{ Exception -> 0x00f4 }
            int r11 = r11 + 1
            goto L_0x00d4
        L_0x00ec:
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00f4 }
            r5.add(r4)     // Catch:{ Exception -> 0x00f4 }
            goto L_0x0109
        L_0x00f4:
            r4 = move-exception
            com.shield.android.internal.f r8 = com.shield.android.internal.f.a(r2)
            boolean r8 = r8.f1677b
            if (r8 == 0) goto L_0x0106
            java.lang.String r8 = r4.getMessage()
            if (r8 == 0) goto L_0x0106
            r4.getLocalizedMessage()
        L_0x0106:
            r5.add(r1)
        L_0x0109:
            java.util.Collections.sort(r5)
            int r4 = r5.size()
            if (r4 > 0) goto L_0x0114
            r4 = r3
            goto L_0x0143
        L_0x0114:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r8 = "{"
            r4.<init>(r8)
            java.util.Iterator r5 = r5.iterator()
        L_0x011f:
            boolean r8 = r5.hasNext()
            if (r8 == 0) goto L_0x013a
            java.lang.Object r8 = r5.next()
            java.lang.String r8 = (java.lang.String) r8
            int r9 = r4.length()
            if (r9 <= r6) goto L_0x0136
            java.lang.String r9 = ","
            r4.append(r9)
        L_0x0136:
            r4.append(r8)
            goto L_0x011f
        L_0x013a:
            java.lang.String r5 = "}"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
        L_0x0143:
            if (r4 != 0) goto L_0x0146
            r4 = r3
        L_0x0146:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r5 = r15.f1517a
            java.lang.String r8 = "MAC_ADDRESSES"
            r5.put(r8, r4)
            android.content.Context r4 = r15.f1518b
            android.app.WallpaperManager r4 = android.app.WallpaperManager.getInstance(r4)     // Catch:{ Exception -> 0x0172 }
            android.graphics.drawable.Drawable r4 = r4.getDrawable()     // Catch:{ Exception -> 0x0172 }
            if (r4 == 0) goto L_0x0172
            android.graphics.Bitmap r4 = r15.a(r4)     // Catch:{ Exception -> 0x0172 }
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0172 }
            r5.<init>()     // Catch:{ Exception -> 0x0172 }
            android.graphics.Bitmap$CompressFormat r8 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x0172 }
            r9 = 10
            r4.compress(r8, r9, r5)     // Catch:{ Exception -> 0x0172 }
            byte[] r4 = r5.toByteArray()     // Catch:{ Exception -> 0x0172 }
            java.lang.String r4 = android.util.Base64.encodeToString(r4, r7)     // Catch:{ Exception -> 0x0172 }
            goto L_0x0173
        L_0x0172:
            r4 = r3
        L_0x0173:
            java.lang.String r5 = "SHA-256"
            java.security.MessageDigest r5 = java.security.MessageDigest.getInstance(r5)     // Catch:{ Exception -> 0x0188 }
            java.nio.charset.Charset r8 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ Exception -> 0x0188 }
            byte[] r4 = r4.getBytes(r8)     // Catch:{ Exception -> 0x0188 }
            byte[] r4 = r5.digest(r4)     // Catch:{ Exception -> 0x0188 }
            java.lang.String r4 = com.shield.android.e.d.a(r4)     // Catch:{ Exception -> 0x0188 }
            goto L_0x019b
        L_0x0188:
            r4 = move-exception
            com.shield.android.internal.f r5 = com.shield.android.internal.f.a()
            boolean r5 = r5.f1677b
            if (r5 == 0) goto L_0x019a
            java.lang.String r5 = r4.getMessage()
            if (r5 == 0) goto L_0x019a
            r4.getLocalizedMessage()
        L_0x019a:
            r4 = r3
        L_0x019b:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r5 = r15.f1517a
            java.lang.String r8 = "WALLPAPER"
            r5.put(r8, r4)
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x01fb }
            r4.<init>()     // Catch:{ Exception -> 0x01fb }
            android.content.Context r5 = r15.f1518b     // Catch:{ Exception -> 0x01fb }
            java.lang.String r8 = "activity"
            java.lang.Object r5 = r5.getSystemService(r8)     // Catch:{ Exception -> 0x01fb }
            android.app.ActivityManager r5 = (android.app.ActivityManager) r5     // Catch:{ Exception -> 0x01fb }
            android.app.ActivityManager$MemoryInfo r8 = new android.app.ActivityManager$MemoryInfo     // Catch:{ Exception -> 0x01fb }
            r8.<init>()     // Catch:{ Exception -> 0x01fb }
            r5.getMemoryInfo(r8)     // Catch:{ Exception -> 0x01fb }
            long r9 = r8.totalMem     // Catch:{ Exception -> 0x01fb }
            long r11 = r8.availMem     // Catch:{ Exception -> 0x01fb }
            java.text.NumberFormat r5 = java.text.DecimalFormat.getNumberInstance()     // Catch:{ Exception -> 0x01fb }
            r8 = 2
            r5.setMinimumFractionDigits(r8)     // Catch:{ Exception -> 0x01fb }
            r5.setMaximumFractionDigits(r8)     // Catch:{ Exception -> 0x01fb }
            float r8 = (float) r9     // Catch:{ Exception -> 0x01fb }
            r9 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r8 = r8 / r9
            double r13 = (double) r8     // Catch:{ Exception -> 0x01fb }
            java.lang.String r8 = r5.format(r13)     // Catch:{ Exception -> 0x01fb }
            float r10 = (float) r11     // Catch:{ Exception -> 0x01fb }
            float r10 = r10 / r9
            double r9 = (double) r10     // Catch:{ Exception -> 0x01fb }
            java.lang.String r5 = r5.format(r9)     // Catch:{ Exception -> 0x01fb }
            java.lang.String r9 = "total"
            r4.put(r9, r8)     // Catch:{ JSONException -> 0x01e8 }
            java.lang.String r8 = "free"
            r4.put(r8, r5)     // Catch:{ JSONException -> 0x01e8 }
            java.lang.String r4 = r4.toString()     // Catch:{ JSONException -> 0x01e8 }
            goto L_0x020e
        L_0x01e8:
            r4 = move-exception
            com.shield.android.internal.f r5 = com.shield.android.internal.f.a()     // Catch:{ Exception -> 0x01fb }
            boolean r5 = r5.f1677b     // Catch:{ Exception -> 0x01fb }
            if (r5 == 0) goto L_0x020d
            java.lang.String r5 = r4.getMessage()     // Catch:{ Exception -> 0x01fb }
            if (r5 == 0) goto L_0x020d
            r4.getLocalizedMessage()     // Catch:{ Exception -> 0x01fb }
            goto L_0x020d
        L_0x01fb:
            r4 = move-exception
            com.shield.android.internal.f r5 = com.shield.android.internal.f.a()
            boolean r5 = r5.f1677b
            if (r5 == 0) goto L_0x020d
            java.lang.String r5 = r4.getMessage()
            if (r5 == 0) goto L_0x020d
            r4.getLocalizedMessage()
        L_0x020d:
            r4 = r3
        L_0x020e:
            if (r4 != 0) goto L_0x0211
            r4 = r3
        L_0x0211:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r5 = r15.f1517a
            java.lang.String r8 = "RAMSIZE"
            r5.put(r8, r4)
            android.content.Context r4 = r15.f1518b
            java.lang.String r5 = "android.permission.BLUETOOTH"
            int r4 = r4.checkCallingOrSelfPermission(r5)     // Catch:{ Exception -> 0x023c }
            if (r4 != 0) goto L_0x0223
            goto L_0x0224
        L_0x0223:
            r6 = 0
        L_0x0224:
            if (r6 == 0) goto L_0x024f
            android.bluetooth.BluetoothAdapter r0 = android.bluetooth.BluetoothAdapter.getDefaultAdapter()     // Catch:{ all -> 0x023a }
            if (r0 != 0) goto L_0x022d
            goto L_0x0233
        L_0x022d:
            java.lang.String r4 = r0.getName()     // Catch:{ all -> 0x023a }
            if (r4 != 0) goto L_0x0235
        L_0x0233:
            r0 = r3
            goto L_0x024f
        L_0x0235:
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x023a }
            goto L_0x024f
        L_0x023a:
            r0 = r1
            goto L_0x024f
        L_0x023c:
            r0 = move-exception
            com.shield.android.internal.f r1 = com.shield.android.internal.f.a()
            boolean r1 = r1.f1677b
            if (r1 == 0) goto L_0x0233
            java.lang.String r1 = r0.getMessage()
            if (r1 == 0) goto L_0x0233
            r0.getLocalizedMessage()
            goto L_0x0233
        L_0x024f:
            if (r0 != 0) goto L_0x0252
            r0 = r3
        L_0x0252:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r1 = r15.f1517a
            java.lang.String r4 = "DEVICE_NAME"
            r1.put(r4, r0)
            java.lang.String r0 = "/system/bin/cat"
            java.lang.String r1 = "/proc/cpuinfo"
            java.lang.String[] r0 = new java.lang.String[]{r0, r1}     // Catch:{ Exception -> 0x026c }
            java.lang.String r0 = r15.a(r0)     // Catch:{ Exception -> 0x026c }
            java.lang.String r1 = "[^A-Za-z0-9 \\s\\-_.]+"
            java.lang.String r0 = r0.replaceAll(r1, r3)     // Catch:{ Exception -> 0x026c }
            goto L_0x027f
        L_0x026c:
            r0 = move-exception
            com.shield.android.internal.f r1 = com.shield.android.internal.f.a(r2)
            boolean r1 = r1.f1677b
            if (r1 == 0) goto L_0x027e
            java.lang.String r1 = r0.getMessage()
            if (r1 == 0) goto L_0x027e
            r0.getLocalizedMessage()
        L_0x027e:
            r0 = r3
        L_0x027f:
            if (r0 != 0) goto L_0x0282
            r0 = r3
        L_0x0282:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r1 = r15.f1517a
            java.lang.String r2 = "CPU_INFO"
            r1.put(r2, r0)
            java.util.UUID r0 = new java.util.UUID     // Catch:{ Exception -> 0x02dc }
            r1 = 1186680826959645954(0x1077efecc0b24d02, double:2.4669297115218948E-229)
            r4 = -5988876978535335093(0xace33c1e52e2fb4b, double:-1.8442503140481377E-92)
            r0.<init>(r1, r4)     // Catch:{ Exception -> 0x02dc }
            java.util.UUID r1 = new java.util.UUID     // Catch:{ Exception -> 0x02dc }
            r4 = -2129748144642739255(0xe2719d58a985b3c9, double:-1.6229728350858627E166)
            r6 = 8654423357094679310(0x781ab030af78d30e, double:3.524813189889319E270)
            r1.<init>(r4, r6)     // Catch:{ Exception -> 0x02dc }
            java.util.UUID r2 = new java.util.UUID     // Catch:{ Exception -> 0x02dc }
            r4 = -1301668207276963122(0xedef8ba979d64ace, double:-3.563403477674908E221)
            r6 = -6645017420763422227(0xa3c827dcd51d21ed, double:-2.5964014370906125E-136)
            r2.<init>(r4, r6)     // Catch:{ Exception -> 0x02dc }
            java.util.UUID r4 = new java.util.UUID     // Catch:{ Exception -> 0x02dc }
            r5 = -7348484286925749626(0x9a04f07998404286, double:-2.4639730719150333E-183)
            r7 = -6083546864340672619(0xab92e65be0885f95, double:-8.640911267670052E-99)
            r4.<init>(r5, r7)     // Catch:{ Exception -> 0x02dc }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x02dc }
            r5.<init>()     // Catch:{ Exception -> 0x02dc }
            r5.add(r2)     // Catch:{ Exception -> 0x02dc }
            r5.add(r1)     // Catch:{ Exception -> 0x02dc }
            r5.add(r4)     // Catch:{ Exception -> 0x02dc }
            r5.add(r0)     // Catch:{ Exception -> 0x02dc }
            com.shield.android.c.-$$Lambda$pDNzWzGBjtjJ1NkCo0c0kHG4wBs r0 = new com.shield.android.c.-$$Lambda$pDNzWzGBjtjJ1NkCo0c0kHG4wBs     // Catch:{ Exception -> 0x02dc }
            r0.<init>(r5)     // Catch:{ Exception -> 0x02dc }
            goto L_0x02ef
        L_0x02dc:
            r0 = move-exception
            com.shield.android.internal.f r1 = com.shield.android.internal.f.a()
            boolean r1 = r1.f1677b
            if (r1 == 0) goto L_0x02ee
            java.lang.String r1 = r0.getMessage()
            if (r1 == 0) goto L_0x02ee
            r0.getLocalizedMessage()
        L_0x02ee:
            r0 = 0
        L_0x02ef:
            if (r0 == 0) goto L_0x031a
            java.util.concurrent.ExecutorService r1 = java.util.concurrent.Executors.newSingleThreadExecutor()
            java.util.concurrent.Future r0 = r1.submit(r0)     // Catch:{ Exception -> 0x0317, all -> 0x0312 }
            r4 = 1000(0x3e8, double:4.94E-321)
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x0317, all -> 0x0312 }
            java.lang.Object r0 = r0.get(r4, r2)     // Catch:{ Exception -> 0x0317, all -> 0x0312 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0317, all -> 0x0312 }
            java.lang.String r2 = "DRM_ID"
            if (r0 != 0) goto L_0x0308
            goto L_0x0309
        L_0x0308:
            r3 = r0
        L_0x0309:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.String> r0 = r15.f1517a     // Catch:{ Exception -> 0x0317, all -> 0x0312 }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x0317, all -> 0x0312 }
            r1.shutdown()
            goto L_0x031a
        L_0x0312:
            r0 = move-exception
            r1.shutdown()
            throw r0
        L_0x0317:
            r1.shutdown()
        L_0x031a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shield.android.c.h.s():void");
    }

    public final String a(String[] strArr) {
        try {
            StringBuilder sb = new StringBuilder();
            byte[] bArr = new byte[1024];
            InputStream inputStream = new ProcessBuilder(strArr).start().getInputStream();
            while (inputStream.read(bArr) != -1) {
                sb.append(new String(bArr));
            }
            inputStream.close();
            return sb.toString();
        } catch (Exception e2) {
            if (f.a(com.userexperior.e.h.f3998a).f1677b && e2.getMessage() != null) {
                e2.getLocalizedMessage();
            }
            return "";
        }
    }

    @SuppressLint({"HardwareIds"})
    public final String b(Context context) {
        try {
            String string = Secure.getString(context.getContentResolver(), "android_id");
            if (j.a((CharSequence) string)) {
                return "";
            }
            return string;
        } catch (Exception e2) {
            if (f.a().f1677b && e2.getMessage() != null) {
                e2.getLocalizedMessage();
            }
            return "";
        }
    }

    public static /* synthetic */ Long b(StorageStatsManager storageStatsManager) {
        try {
            return Long.valueOf(storageStatsManager.getTotalBytes(StorageManager.UUID_DEFAULT));
        } catch (IOException unused) {
            return Long.valueOf(0);
        }
    }

    public final String b(String str, String str2) {
        return j.a((CharSequence) str) ? str2 : str;
    }

    public static /* synthetic */ Long a(StorageStatsManager storageStatsManager) {
        try {
            return Long.valueOf(storageStatsManager.getFreeBytes(StorageManager.UUID_DEFAULT));
        } catch (IOException unused) {
            return Long.valueOf(0);
        }
    }

    public final Bitmap a(Drawable drawable) {
        Bitmap bitmap;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Config.ARGB_8888);
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0032, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 28) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0055, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 28) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0057, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x005b, code lost:
        r3.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x005e, code lost:
        r0 = r3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0005 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.util.List<java.util.UUID> r4) throws java.lang.Exception {
        /*
            java.util.Iterator r4 = r4.iterator()
            r0 = 0
        L_0x0005:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x006e
            java.lang.Object r1 = r4.next()
            java.util.UUID r1 = (java.util.UUID) r1
            r2 = 28
            android.media.MediaDrm r3 = new android.media.MediaDrm     // Catch:{ Exception -> 0x003e }
            r3.<init>(r1)     // Catch:{ Exception -> 0x003e }
            java.lang.String r0 = "deviceUniqueId"
            byte[] r0 = r3.getPropertyByteArray(r0)     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
            if (r0 == 0) goto L_0x0030
            java.lang.String r4 = com.shield.android.e.d.a(r0)     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r2) goto L_0x002c
            r3.close()
            goto L_0x002f
        L_0x002c:
            r3.release()
        L_0x002f:
            return r4
        L_0x0030:
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r2) goto L_0x005b
            goto L_0x0057
        L_0x0035:
            r4 = move-exception
            r0 = r3
            goto L_0x0060
        L_0x0038:
            r0 = move-exception
            r1 = r0
            r0 = r3
            goto L_0x003f
        L_0x003c:
            r4 = move-exception
            goto L_0x0060
        L_0x003e:
            r1 = move-exception
        L_0x003f:
            com.shield.android.internal.f r3 = com.shield.android.internal.f.a()     // Catch:{ all -> 0x003c }
            boolean r3 = r3.f1677b     // Catch:{ all -> 0x003c }
            if (r3 == 0) goto L_0x0050
            java.lang.String r3 = r1.getMessage()     // Catch:{ all -> 0x003c }
            if (r3 == 0) goto L_0x0050
            r1.getLocalizedMessage()     // Catch:{ all -> 0x003c }
        L_0x0050:
            if (r0 == 0) goto L_0x0005
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = r0
            if (r1 < r2) goto L_0x005b
        L_0x0057:
            r3.close()
            goto L_0x005e
        L_0x005b:
            r3.release()
        L_0x005e:
            r0 = r3
            goto L_0x0005
        L_0x0060:
            if (r0 == 0) goto L_0x006d
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 < r2) goto L_0x006a
            r0.close()
            goto L_0x006d
        L_0x006a:
            r0.release()
        L_0x006d:
            throw r4
        L_0x006e:
            java.lang.String r4 = ""
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shield.android.c.h.a(java.util.List):java.lang.String");
    }

    public final long a(File file) {
        try {
            if (!file.exists()) {
                return 0;
            }
            if (!file.isDirectory()) {
                return file.length();
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(file);
            long j = 0;
            while (!linkedList.isEmpty()) {
                File file2 = (File) linkedList.remove(0);
                if (file2.exists()) {
                    File[] listFiles = file2.listFiles();
                    if (listFiles != null) {
                        if (listFiles.length != 0) {
                            for (File file3 : listFiles) {
                                j += file3.length();
                                if (file3.isDirectory()) {
                                    linkedList.add(file3);
                                }
                            }
                        }
                    }
                }
            }
            return j;
        } catch (Exception unused) {
        }
    }

    public final HashMap<String, String> a(Context context) {
        HashMap hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        try {
            Process exec = Runtime.getRuntime().exec("getprop");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            hashMap = new HashMap();
            Pattern compile = Pattern.compile("(?<=\\[).+?(?=\\])");
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                Matcher matcher = compile.matcher(readLine);
                int i = 0;
                Object obj = "";
                while (matcher.find()) {
                    if (i == 0) {
                        obj = matcher.group();
                    } else {
                        hashMap.put(obj, matcher.group());
                    }
                    i++;
                }
            }
            bufferedReader.close();
            exec.waitFor();
        } catch (Exception unused) {
            hashMap = null;
        }
        if (hashMap == null) {
            hashMap = new HashMap();
        } else {
            hashMap2.putAll(hashMap);
        }
        try {
            String str = (String) hashMap.get("ro.boot.verifiedbootstate");
            if (!j.a((CharSequence) str)) {
                hashMap2.put("verified_boot_state", str);
            }
            String str2 = (String) hashMap.get("sys.oem_unlock_allowed");
            if (!j.a((CharSequence) str2)) {
                hashMap2.put("oem_unlock_allowed", str2);
            }
            String str3 = (String) hashMap.get("ro.boot.vbmeta.device_state");
            if (!j.a((CharSequence) str3)) {
                hashMap2.put("bootloader_state", str3);
            }
            hashMap2.put("build_board", b((String) hashMap.get("ro.product.board"), Build.BOARD));
            hashMap2.put("build_bootloader", b((String) hashMap.get("ro.bootloader"), Build.BOOTLOADER));
            hashMap2.put("build_brand", b((String) hashMap.get("ro.product.odm.brand"), b((String) hashMap.get("ro.product.system.brand"), b((String) hashMap.get("ro.product.brand"), Build.BRAND))));
            hashMap2.put("build_CPU_ABI", b((String) hashMap.get("ro.product.cpu.abilist"), TextUtils.join(",", Build.SUPPORTED_ABIS)));
            hashMap2.put("build_device", b((String) hashMap.get("ro.product.device"), Build.DEVICE));
            hashMap2.put("build_display", b((String) hashMap.get("ro.build.display.id"), Build.DISPLAY));
            hashMap2.put("build_fingerprint", b((String) hashMap.get("ro.build.fingerprint"), Build.FINGERPRINT));
            hashMap2.put("build_hardware", b((String) hashMap.get("ro.hardware"), Build.HARDWARE));
            hashMap2.put("build_host", b((String) hashMap.get("ro.build.host"), Build.HOST));
            hashMap2.put("build_id", b((String) hashMap.get("ro.build.id"), Build.ID));
            hashMap2.put("build_manufacturer", b(b((String) hashMap.get("ro.product.manufacturer"), (String) hashMap.get("ro.product.vendor.manufacturer")), Build.MANUFACTURER));
            hashMap2.put("build_model", b((String) hashMap.get("ro.product.model"), Build.MODEL));
            hashMap2.put("build_product", b((String) hashMap.get("ro.product.name"), Build.PRODUCT));
            hashMap2.put("build_tags", b((String) hashMap.get("ro.build.tags"), Build.TAGS));
            hashMap2.put("build_time", b((String) hashMap.get("ro.build.date.utc"), String.valueOf(Build.TIME)));
            hashMap2.put("build_type", b((String) hashMap.get("ro.build.type"), Build.TYPE));
            hashMap2.put("build_version_codename", b((String) hashMap.get("ro.build.version.codename"), VERSION.CODENAME));
            hashMap2.put("build_version_incremental", b((String) hashMap.get("ro.build.version.incremental"), VERSION.INCREMENTAL));
            hashMap2.put("build_version_release", b((String) hashMap.get("ro.build.version.release"), VERSION.RELEASE));
            hashMap2.put("build_gsm_serial", b((String) hashMap.get("vendor.gsm.serial"), ""));
            hashMap2.put("build_ap_serial", b((String) hashMap.get("ro.boot.ap_serial"), ""));
            hashMap2.put("build_em_did", b((String) hashMap.get("ro.boot.em.did"), ""));
            hashMap2.put("build_bsn_id", b((String) hashMap.get("ro.boot.bsn"), ""));
            hashMap2.put("build_un_id", b((String) hashMap.get("ro.boot.un"), ""));
        } catch (Exception e2) {
            if (f.a(com.userexperior.e.h.f3998a).f1677b && e2.getMessage() != null) {
                e2.getLocalizedMessage();
            }
        }
        return hashMap2;
    }
}
