package com.RNFetchBlob;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.util.SparseArray;
import androidx.core.content.FileProvider;
import com.RNFetchBlob.RNFetchBlobProgressConfig.ReportType;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.PromiseImpl;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.network.CookieJarContainer;
import com.facebook.react.modules.network.ForwardingCookieHandler;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.mpl.androidapp.updater.util.UpdaterConstant.Response;
import com.mpl.androidapp.utils.Constant;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

public class RNFetchBlob extends ReactContextBaseJavaModule {
    public static boolean ActionViewVisible = false;
    public static ReactApplicationContext RCTContext;
    public static LinkedBlockingQueue<Runnable> fsTaskQueue = new LinkedBlockingQueue<>();
    public static ThreadPoolExecutor fsThreadPool;
    public static SparseArray<Promise> promiseTable = new SparseArray<>();
    public static LinkedBlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>();
    public static ThreadPoolExecutor threadPool;
    public final OkHttpClient mClient;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, RemoteConfigManager.MIN_APP_START_CONFIG_FETCH_DELAY_MS, TimeUnit.MILLISECONDS, taskQueue);
        threadPool = threadPoolExecutor;
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(2, 10, RemoteConfigManager.MIN_APP_START_CONFIG_FETCH_DELAY_MS, TimeUnit.MILLISECONDS, taskQueue);
        fsThreadPool = threadPoolExecutor2;
    }

    public RNFetchBlob(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        if (ImageOriginUtils.sClient == null) {
            ImageOriginUtils.sClient = ImageOriginUtils.createClientBuilder().build();
        }
        this.mClient = ImageOriginUtils.sClient;
        ((CookieJarContainer) this.mClient.cookieJar()).setCookieJar(new JavaNetCookieJar(new ForwardingCookieHandler(reactApplicationContext)));
        RCTContext = reactApplicationContext;
        reactApplicationContext.addActivityEventListener(new ActivityEventListener(this) {
            public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
                if (i == RNFetchBlobConst.GET_CONTENT_INTENT.intValue() && i2 == -1) {
                    ((Promise) RNFetchBlob.promiseTable.get(RNFetchBlobConst.GET_CONTENT_INTENT.intValue())).resolve(intent.getData().toString());
                    RNFetchBlob.promiseTable.remove(RNFetchBlobConst.GET_CONTENT_INTENT.intValue());
                }
            }

            public void onNewIntent(Intent intent) {
            }
        });
    }

    @ReactMethod
    public void actionViewIntent(String str, String str2, final Promise promise) {
        try {
            Activity currentActivity = getCurrentActivity();
            Uri uriForFile = FileProvider.getUriForFile(currentActivity, getReactApplicationContext().getPackageName() + ".provider", new File(str));
            if (VERSION.SDK_INT >= 24) {
                Intent dataAndType = new Intent("android.intent.action.VIEW").setDataAndType(uriForFile, str2);
                dataAndType.setFlags(1);
                dataAndType.addFlags(ClientDefaults.MAX_MSG_SIZE);
                if (dataAndType.resolveActivity(getCurrentActivity().getPackageManager()) != null) {
                    getReactApplicationContext().startActivity(dataAndType);
                }
            } else {
                Intent intent = new Intent("android.intent.action.VIEW");
                getReactApplicationContext().startActivity(intent.setDataAndType(Uri.parse("file://" + str), str2).setFlags(ClientDefaults.MAX_MSG_SIZE));
            }
            ActionViewVisible = true;
            RCTContext.addLifecycleEventListener(new LifecycleEventListener(this) {
                public void onHostDestroy() {
                }

                public void onHostPause() {
                }

                public void onHostResume() {
                    if (RNFetchBlob.ActionViewVisible) {
                        promise.resolve(null);
                    }
                    RNFetchBlob.RCTContext.removeLifecycleEventListener(this);
                }
            });
        } catch (Exception e2) {
            promise.reject((String) PromiseImpl.ERROR_DEFAULT_CODE, e2.getLocalizedMessage());
        }
    }

    @ReactMethod
    public void addCompleteDownload(ReadableMap readableMap, Promise promise) {
        ReadableMap readableMap2 = readableMap;
        Promise promise2 = promise;
        DownloadManager downloadManager = (DownloadManager) RCTContext.getSystemService(Constant.DOWNLOAD);
        if (readableMap2 == null || !readableMap2.hasKey("path")) {
            promise2.reject((String) "EINVAL", (String) "RNFetchblob.addCompleteDownload config or path missing.");
            return;
        }
        String normalizePath = RNFetchBlobFS.normalizePath(readableMap2.getString("path"));
        if (normalizePath == null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("RNFetchblob.addCompleteDownload can not resolve URI:");
            outline73.append(readableMap2.getString("path"));
            promise2.reject((String) "EINVAL", outline73.toString());
            return;
        }
        try {
            WritableMap statFile = RNFetchBlobFS.statFile(normalizePath);
            String str = "";
            String string = readableMap2.hasKey("title") ? readableMap2.getString("title") : str;
            if (readableMap2.hasKey("description")) {
                str = readableMap2.getString("description");
            }
            downloadManager.addCompletedDownload(string, str, true, readableMap2.hasKey("mime") ? readableMap2.getString("mime") : null, normalizePath, Long.valueOf(statFile.getString(Response.SIZE)).longValue(), readableMap2.hasKey("showNotification") && readableMap2.getBoolean("showNotification"));
            promise2.resolve(null);
        } catch (Exception e2) {
            promise2.reject((String) PromiseImpl.ERROR_DEFAULT_CODE, e2.getLocalizedMessage());
        }
    }

    @ReactMethod
    public void cancelRequest(String str, Callback callback) {
        try {
            RNFetchBlobReq.cancelTask(str);
            callback.invoke(null, str);
        } catch (Exception e2) {
            callback.invoke(e2.getLocalizedMessage(), null);
        }
    }

    @ReactMethod
    public void closeStream(String str, Callback callback) {
        RNFetchBlobFS.closeStream(str, callback);
    }

    @ReactMethod
    public void cp(final String str, final String str2, final Callback callback) {
        threadPool.execute(new Runnable(this) {
            /* JADX WARNING: type inference failed for: r4v0 */
            /* JADX WARNING: type inference failed for: r4v1, types: [java.io.InputStream] */
            /* JADX WARNING: type inference failed for: r0v2, types: [java.io.OutputStream] */
            /* JADX WARNING: type inference failed for: r4v2, types: [java.io.InputStream] */
            /* JADX WARNING: type inference failed for: r0v8, types: [java.io.OutputStream] */
            /* JADX WARNING: type inference failed for: r0v12 */
            /* JADX WARNING: type inference failed for: r0v14 */
            /* JADX WARNING: type inference failed for: r4v3 */
            /* JADX WARNING: type inference failed for: r9v0 */
            /* JADX WARNING: type inference failed for: r4v4 */
            /* JADX WARNING: type inference failed for: r0v16 */
            /* JADX WARNING: type inference failed for: r4v5 */
            /* JADX WARNING: type inference failed for: r9v1 */
            /* JADX WARNING: type inference failed for: r4v6 */
            /* JADX WARNING: type inference failed for: r0v17 */
            /* JADX WARNING: type inference failed for: r7v4, types: [java.io.OutputStream, java.io.FileOutputStream] */
            /* JADX WARNING: type inference failed for: r4v7 */
            /* JADX WARNING: type inference failed for: r4v8 */
            /* JADX WARNING: type inference failed for: r4v10 */
            /* JADX WARNING: type inference failed for: r4v11 */
            /* JADX WARNING: type inference failed for: r4v12 */
            /* JADX WARNING: type inference failed for: r4v13 */
            /* JADX WARNING: type inference failed for: r4v14 */
            /* JADX WARNING: type inference failed for: r0v23 */
            /* JADX WARNING: Multi-variable type inference failed */
            /* JADX WARNING: Removed duplicated region for block: B:39:0x00ba A[SYNTHETIC, Splitter:B:39:0x00ba] */
            /* JADX WARNING: Removed duplicated region for block: B:44:0x00c2 A[Catch:{ Exception -> 0x00be }] */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x00d2  */
            /* JADX WARNING: Removed duplicated region for block: B:50:0x00da  */
            /* JADX WARNING: Removed duplicated region for block: B:53:0x00e3 A[SYNTHETIC, Splitter:B:53:0x00e3] */
            /* JADX WARNING: Removed duplicated region for block: B:58:0x00eb A[Catch:{ Exception -> 0x00e7 }] */
            /* JADX WARNING: Unknown variable types count: 10 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r10 = this;
                    java.lang.String r0 = r3
                    java.lang.String r1 = r4
                    com.facebook.react.bridge.Callback r2 = r5
                    java.lang.String r3 = ""
                    java.lang.String r0 = com.RNFetchBlob.RNFetchBlobFS.normalizePath(r0)
                    r4 = 0
                    r5 = 1
                    r6 = 0
                    boolean r7 = com.RNFetchBlob.RNFetchBlobFS.isPathExists(r0)     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
                    if (r7 != 0) goto L_0x0034
                    java.lang.Object[] r1 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
                    r7.<init>()     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
                    java.lang.String r8 = "Source file at path`"
                    r7.append(r8)     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
                    r7.append(r0)     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
                    java.lang.String r0 = "` does not exist"
                    r7.append(r0)     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
                    java.lang.String r0 = r7.toString()     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
                    r1[r6] = r0     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
                    r2.invoke(r1)     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
                    goto L_0x00df
                L_0x0034:
                    java.io.File r7 = new java.io.File     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
                    r7.<init>(r1)     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
                    boolean r7 = r7.exists()     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
                    if (r7 != 0) goto L_0x0069
                    java.io.File r7 = new java.io.File     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
                    r7.<init>(r1)     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
                    boolean r7 = r7.createNewFile()     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
                    if (r7 != 0) goto L_0x0069
                    java.lang.Object[] r0 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
                    r7.<init>()     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
                    java.lang.String r8 = "Destination file at '"
                    r7.append(r8)     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
                    r7.append(r1)     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
                    java.lang.String r1 = "' already exists"
                    r7.append(r1)     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
                    java.lang.String r1 = r7.toString()     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
                    r0[r6] = r1     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
                    r2.invoke(r0)     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
                    goto L_0x00df
                L_0x0069:
                    java.io.InputStream r0 = com.RNFetchBlob.RNFetchBlobFS.inputStreamFromPath(r0)     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
                    java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0099, all -> 0x0094 }
                    r7.<init>(r1)     // Catch:{ Exception -> 0x0099, all -> 0x0094 }
                    r1 = 10240(0x2800, float:1.4349E-41)
                    byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x0091, all -> 0x008e }
                L_0x0076:
                    int r4 = r0.read(r1)     // Catch:{ Exception -> 0x0091, all -> 0x008e }
                    if (r4 <= 0) goto L_0x0080
                    r7.write(r1, r6, r4)     // Catch:{ Exception -> 0x0091, all -> 0x008e }
                    goto L_0x0076
                L_0x0080:
                    r0.close()     // Catch:{ Exception -> 0x0088 }
                    r7.close()     // Catch:{ Exception -> 0x0088 }
                    r0 = r3
                    goto L_0x00d0
                L_0x0088:
                    r0 = move-exception
                    java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
                    goto L_0x00ca
                L_0x008e:
                    r1 = move-exception
                    r4 = r7
                    goto L_0x0095
                L_0x0091:
                    r1 = move-exception
                    r4 = r7
                    goto L_0x009a
                L_0x0094:
                    r1 = move-exception
                L_0x0095:
                    r9 = r4
                    r4 = r0
                    r0 = r9
                    goto L_0x00e1
                L_0x0099:
                    r1 = move-exception
                L_0x009a:
                    r9 = r4
                    r4 = r0
                    r0 = r9
                    goto L_0x00a5
                L_0x009e:
                    r0 = move-exception
                    r1 = r0
                    r0 = r4
                    goto L_0x00e1
                L_0x00a2:
                    r0 = move-exception
                    r1 = r0
                    r0 = r4
                L_0x00a5:
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e0 }
                    r7.<init>()     // Catch:{ all -> 0x00e0 }
                    r7.append(r3)     // Catch:{ all -> 0x00e0 }
                    java.lang.String r1 = r1.getLocalizedMessage()     // Catch:{ all -> 0x00e0 }
                    r7.append(r1)     // Catch:{ all -> 0x00e0 }
                    java.lang.String r1 = r7.toString()     // Catch:{ all -> 0x00e0 }
                    if (r4 == 0) goto L_0x00c0
                    r4.close()     // Catch:{ Exception -> 0x00be }
                    goto L_0x00c0
                L_0x00be:
                    r0 = move-exception
                    goto L_0x00c6
                L_0x00c0:
                    if (r0 == 0) goto L_0x00cf
                    r0.close()     // Catch:{ Exception -> 0x00be }
                    goto L_0x00cf
                L_0x00c6:
                    java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
                L_0x00ca:
                    java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline38(r0, r1)
                    goto L_0x00d0
                L_0x00cf:
                    r0 = r1
                L_0x00d0:
                    if (r0 == r3) goto L_0x00da
                    java.lang.Object[] r1 = new java.lang.Object[r5]
                    r1[r6] = r0
                    r2.invoke(r1)
                    goto L_0x00df
                L_0x00da:
                    java.lang.Object[] r0 = new java.lang.Object[r6]
                    r2.invoke(r0)
                L_0x00df:
                    return
                L_0x00e0:
                    r1 = move-exception
                L_0x00e1:
                    if (r4 == 0) goto L_0x00e9
                    r4.close()     // Catch:{ Exception -> 0x00e7 }
                    goto L_0x00e9
                L_0x00e7:
                    r0 = move-exception
                    goto L_0x00ef
                L_0x00e9:
                    if (r0 == 0) goto L_0x00f2
                    r0.close()     // Catch:{ Exception -> 0x00e7 }
                    goto L_0x00f2
                L_0x00ef:
                    r0.getLocalizedMessage()
                L_0x00f2:
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.RNFetchBlob.RNFetchBlob.AnonymousClass5.run():void");
            }
        });
    }

    @ReactMethod
    public void createFile(String str, String str2, String str3, Promise promise) {
        ThreadPoolExecutor threadPoolExecutor = threadPool;
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final Promise promise2 = promise;
        AnonymousClass2 r1 = new Runnable(this) {
            public void run() {
                RNFetchBlobFS.createFile(str4, str5, str6, promise2);
            }
        };
        threadPoolExecutor.execute(r1);
    }

    @ReactMethod
    public void createFileASCII(final String str, final ReadableArray readableArray, final Promise promise) {
        threadPool.execute(new Runnable(this) {
            public void run() {
                RNFetchBlobFS.createFileASCII(str, readableArray, promise);
            }
        });
    }

    @ReactMethod
    public void df(final Callback callback) {
        fsThreadPool.execute(new Runnable(this) {
            public void run() {
                RNFetchBlobFS.df(callback);
            }
        });
    }

    @ReactMethod
    public void enableProgressReport(String str, int i, int i2) {
        RNFetchBlobReq.progressReport.put(str, new RNFetchBlobProgressConfig(true, i, i2, ReportType.Download));
    }

    @ReactMethod
    public void enableUploadProgressReport(String str, int i, int i2) {
        RNFetchBlobReq.uploadProgressReport.put(str, new RNFetchBlobProgressConfig(true, i, i2, ReportType.Upload));
    }

    @ReactMethod
    public void exists(String str, Callback callback) {
        if (RNFetchBlobFS.isAsset(str)) {
            try {
                RCTContext.getAssets().openFd(str.replace("bundle-assets://", ""));
                callback.invoke(Boolean.TRUE, Boolean.FALSE);
            } catch (IOException unused) {
                Boolean bool = Boolean.FALSE;
                callback.invoke(bool, bool);
            }
        } else {
            String normalizePath = RNFetchBlobFS.normalizePath(str);
            if (normalizePath != null) {
                callback.invoke(Boolean.valueOf(new File(normalizePath).exists()), Boolean.valueOf(new File(normalizePath).isDirectory()));
                return;
            }
            Boolean bool2 = Boolean.FALSE;
            callback.invoke(bool2, bool2);
        }
    }

    @ReactMethod
    public void fetchBlob(ReadableMap readableMap, String str, String str2, String str3, ReadableMap readableMap2, String str4, Callback callback) {
        RNFetchBlobReq rNFetchBlobReq = new RNFetchBlobReq(readableMap, str, str2, str3, readableMap2, str4, null, this.mClient, callback);
        rNFetchBlobReq.run();
    }

    @ReactMethod
    public void fetchBlobForm(ReadableMap readableMap, String str, String str2, String str3, ReadableMap readableMap2, ReadableArray readableArray, Callback callback) {
        RNFetchBlobReq rNFetchBlobReq = new RNFetchBlobReq(readableMap, str, str2, str3, readableMap2, null, readableArray, this.mClient, callback);
        rNFetchBlobReq.run();
    }

    public Map<String, Object> getConstants() {
        return RNFetchBlobFS.getSystemfolders(getReactApplicationContext());
    }

    @ReactMethod
    public void getContentIntent(String str, Promise promise) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        if (str != null) {
            intent.setType(str);
        } else {
            intent.setType("*/*");
        }
        promiseTable.put(RNFetchBlobConst.GET_CONTENT_INTENT.intValue(), promise);
        getReactApplicationContext().startActivityForResult(intent, RNFetchBlobConst.GET_CONTENT_INTENT.intValue(), null);
    }

    public String getName() {
        return "RNFetchBlob";
    }

    @ReactMethod
    public void getSDCardApplicationDir(Promise promise) {
        RNFetchBlobFS.getSDCardApplicationDir(getReactApplicationContext(), promise);
    }

    @ReactMethod
    public void getSDCardDir(Promise promise) {
        RNFetchBlobFS.getSDCardDir(promise);
    }

    @ReactMethod
    public void hash(final String str, final String str2, final Promise promise) {
        threadPool.execute(new Runnable(this) {
            public void run() {
                RNFetchBlobFS.hash(str, str2, promise);
            }
        });
    }

    @ReactMethod
    public void ls(String str, Promise promise) {
        RNFetchBlobFS.ls(str, promise);
    }

    @ReactMethod
    public void lstat(String str, Callback callback) {
        String normalizePath = RNFetchBlobFS.normalizePath(str);
        new AsyncTask<String, Integer, Integer>() {
            public Object doInBackground(Object[] objArr) {
                String[] strArr = (String[]) objArr;
                WritableArray createArray = Arguments.createArray();
                Integer valueOf = Integer.valueOf(0);
                if (strArr[0] == null) {
                    Callback.this.invoke("the path specified for lstat is either `null` or `undefined`.");
                } else {
                    File file = new File(strArr[0]);
                    if (!file.exists()) {
                        Callback.this.invoke(GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73("failed to lstat path `"), strArr[0], "` because it does not exist or it is not a folder"));
                    } else {
                        if (file.isDirectory()) {
                            for (String str : file.list()) {
                                createArray.pushMap(RNFetchBlobFS.statFile(file.getPath() + "/" + str));
                            }
                        } else {
                            createArray.pushMap(RNFetchBlobFS.statFile(file.getAbsolutePath()));
                        }
                        Callback.this.invoke(null, createArray);
                    }
                }
                return valueOf;
            }
        }.execute(new String[]{normalizePath});
    }

    @ReactMethod
    public void mkdir(String str, Promise promise) {
        RNFetchBlobFS.mkdir(str, promise);
    }

    @ReactMethod
    public void mv(String str, String str2, Callback callback) {
        RNFetchBlobFS.mv(str, str2, callback);
    }

    @ReactMethod
    public void readFile(final String str, final String str2, final Promise promise) {
        threadPool.execute(new Runnable(this) {
            /* JADX WARNING: Removed duplicated region for block: B:17:0x0082 A[Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }] */
            /* JADX WARNING: Removed duplicated region for block: B:18:0x00a0 A[Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r11 = this;
                    java.lang.String r0 = r3
                    java.lang.String r1 = r4
                    com.facebook.react.bridge.Promise r2 = r5
                    java.lang.String r3 = "bundle-assets://"
                    java.lang.String r4 = com.RNFetchBlob.RNFetchBlobFS.normalizePath(r0)
                    if (r4 == 0) goto L_0x000f
                    r0 = r4
                L_0x000f:
                    java.lang.String r5 = "EUNSPECIFIED"
                    r6 = 0
                    if (r4 == 0) goto L_0x0049
                    boolean r7 = r4.startsWith(r3)     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    if (r7 == 0) goto L_0x0049
                    java.lang.String r4 = ""
                    java.lang.String r3 = r0.replace(r3, r4)     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    com.facebook.react.bridge.ReactApplicationContext r4 = com.RNFetchBlob.RNFetchBlob.RCTContext     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    android.content.res.AssetManager r4 = r4.getAssets()     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    android.content.res.AssetFileDescriptor r4 = r4.openFd(r3)     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    long r7 = r4.getLength()     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    int r4 = (int) r7     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    byte[] r7 = new byte[r4]     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    com.facebook.react.bridge.ReactApplicationContext r8 = com.RNFetchBlob.RNFetchBlob.RCTContext     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    android.content.res.AssetManager r8 = r8.getAssets()     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    java.io.InputStream r3 = r8.open(r3)     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    int r8 = r3.read(r7, r6, r4)     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    r3.close()     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    goto L_0x0080
                L_0x0043:
                    r0 = move-exception
                    goto L_0x010b
                L_0x0046:
                    r1 = move-exception
                    goto L_0x0113
                L_0x0049:
                    if (r4 != 0) goto L_0x0067
                    com.facebook.react.bridge.ReactApplicationContext r3 = com.RNFetchBlob.RNFetchBlob.RCTContext     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    android.net.Uri r4 = android.net.Uri.parse(r0)     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    java.io.InputStream r3 = r3.openInputStream(r4)     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    int r4 = r3.available()     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    byte[] r7 = new byte[r4]     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    int r8 = r3.read(r7)     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    r3.close()     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    goto L_0x0080
                L_0x0067:
                    java.io.File r3 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    r3.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    long r7 = r3.length()     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    int r4 = (int) r7     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    byte[] r7 = new byte[r4]     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    r8.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    int r3 = r8.read(r7)     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    r8.close()     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    r8 = r3
                L_0x0080:
                    if (r8 >= r4) goto L_0x00a0
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    r1.<init>()     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    java.lang.String r3 = "Read only "
                    r1.append(r3)     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    r1.append(r8)     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    java.lang.String r3 = " bytes of "
                    r1.append(r3)     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    r1.append(r4)     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    java.lang.String r1 = r1.toString()     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    r2.reject(r5, r1)     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    goto L_0x0138
                L_0x00a0:
                    java.lang.String r1 = r1.toLowerCase()     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    r3 = -1
                    int r4 = r1.hashCode()     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    r8 = -1396204209(0xffffffffacc79d4f, float:-5.673385E-12)
                    r9 = 2
                    r10 = 1
                    if (r4 == r8) goto L_0x00cf
                    r8 = 3600241(0x36ef71, float:5.045012E-39)
                    if (r4 == r8) goto L_0x00c5
                    r8 = 93106001(0x58caf51, float:1.3229938E-35)
                    if (r4 == r8) goto L_0x00bb
                    goto L_0x00d8
                L_0x00bb:
                    java.lang.String r4 = "ascii"
                    boolean r1 = r1.equals(r4)     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    if (r1 == 0) goto L_0x00d8
                    r3 = 1
                    goto L_0x00d8
                L_0x00c5:
                    java.lang.String r4 = "utf8"
                    boolean r1 = r1.equals(r4)     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    if (r1 == 0) goto L_0x00d8
                    r3 = 2
                    goto L_0x00d8
                L_0x00cf:
                    java.lang.String r4 = "base64"
                    boolean r1 = r1.equals(r4)     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    if (r1 == 0) goto L_0x00d8
                    r3 = 0
                L_0x00d8:
                    if (r3 == 0) goto L_0x0103
                    if (r3 == r10) goto L_0x00f0
                    if (r3 == r9) goto L_0x00e7
                    java.lang.String r1 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    r1.<init>(r7)     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    r2.resolve(r1)     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    goto L_0x0138
                L_0x00e7:
                    java.lang.String r1 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    r1.<init>(r7)     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    r2.resolve(r1)     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    goto L_0x0138
                L_0x00f0:
                    com.facebook.react.bridge.WritableArray r1 = com.facebook.react.bridge.Arguments.createArray()     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    int r3 = r7.length     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                L_0x00f5:
                    if (r6 >= r3) goto L_0x00ff
                    byte r4 = r7[r6]     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    r1.pushInt(r4)     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    int r6 = r6 + 1
                    goto L_0x00f5
                L_0x00ff:
                    r2.resolve(r1)     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    goto L_0x0138
                L_0x0103:
                    java.lang.String r1 = android.util.Base64.encodeToString(r7, r9)     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    r2.resolve(r1)     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043 }
                    goto L_0x0138
                L_0x010b:
                    java.lang.String r0 = r0.getLocalizedMessage()
                    r2.reject(r5, r0)
                    goto L_0x0138
                L_0x0113:
                    java.lang.String r1 = r1.getLocalizedMessage()
                    java.lang.String r3 = "EISDIR"
                    boolean r4 = r1.contains(r3)
                    if (r4 == 0) goto L_0x012b
                    java.lang.String r4 = "Expecting a file but '"
                    java.lang.String r5 = "' is a directory; "
                    java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline53(r4, r0, r5, r1)
                    r2.reject(r3, r0)
                    goto L_0x0138
                L_0x012b:
                    java.lang.String r3 = "No such file '"
                    java.lang.String r4 = "'; "
                    java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline53(r3, r0, r4, r1)
                    java.lang.String r1 = "ENOENT"
                    r2.reject(r1, r0)
                L_0x0138:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.RNFetchBlob.RNFetchBlob.AnonymousClass6.run():void");
            }
        });
    }

    @ReactMethod
    public void readStream(String str, String str2, int i, int i2, String str3) {
        final ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        ThreadPoolExecutor threadPoolExecutor = fsThreadPool;
        final String str4 = str;
        final String str5 = str2;
        final int i3 = i;
        final int i4 = i2;
        final String str6 = str3;
        AnonymousClass11 r0 = new Runnable(this) {
            /* JADX WARNING: Removed duplicated region for block: B:22:0x006f  */
            /* JADX WARNING: Removed duplicated region for block: B:31:0x009b A[Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }] */
            /* JADX WARNING: Removed duplicated region for block: B:54:0x011f A[Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r15 = this;
                    com.RNFetchBlob.RNFetchBlobFS r0 = new com.RNFetchBlob.RNFetchBlobFS
                    com.facebook.react.bridge.ReactApplicationContext r1 = r2
                    r0.<init>(r1)
                    java.lang.String r1 = r3
                    java.lang.String r2 = r4
                    int r3 = r5
                    int r4 = r6
                    java.lang.String r5 = r7
                    java.lang.String r6 = "bundle-assets://"
                    java.lang.String r7 = "base64"
                    java.lang.String r8 = "error"
                    java.lang.String r9 = com.RNFetchBlob.RNFetchBlobFS.normalizePath(r1)
                    if (r9 == 0) goto L_0x001e
                    r1 = r9
                L_0x001e:
                    boolean r10 = r2.equalsIgnoreCase(r7)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    if (r10 == 0) goto L_0x0027
                    r10 = 4095(0xfff, float:5.738E-42)
                    goto L_0x0029
                L_0x0027:
                    r10 = 4096(0x1000, float:5.74E-42)
                L_0x0029:
                    if (r3 <= 0) goto L_0x002c
                    goto L_0x002d
                L_0x002c:
                    r3 = r10
                L_0x002d:
                    java.lang.String r10 = ""
                    if (r9 == 0) goto L_0x0046
                    boolean r11 = r1.startsWith(r6)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    if (r11 == 0) goto L_0x0046
                    com.facebook.react.bridge.ReactApplicationContext r9 = com.RNFetchBlob.RNFetchBlob.RCTContext     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    android.content.res.AssetManager r9 = r9.getAssets()     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    java.lang.String r6 = r1.replace(r6, r10)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    java.io.InputStream r6 = r9.open(r6)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    goto L_0x0061
                L_0x0046:
                    if (r9 != 0) goto L_0x0057
                    com.facebook.react.bridge.ReactApplicationContext r6 = com.RNFetchBlob.RNFetchBlob.RCTContext     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    android.content.ContentResolver r6 = r6.getContentResolver()     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    android.net.Uri r9 = android.net.Uri.parse(r1)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    java.io.InputStream r6 = r6.openInputStream(r9)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    goto L_0x0061
                L_0x0057:
                    java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    java.io.File r9 = new java.io.File     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    r9.<init>(r1)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    r6.<init>(r9)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                L_0x0061:
                    byte[] r9 = new byte[r3]     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    java.lang.String r11 = "utf8"
                    boolean r11 = r2.equalsIgnoreCase(r11)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    java.lang.String r12 = "data"
                    r13 = -1
                    r14 = 0
                    if (r11 == 0) goto L_0x009b
                    java.lang.String r3 = "UTF-8"
                    java.nio.charset.Charset r3 = java.nio.charset.Charset.forName(r3)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    java.nio.charset.CharsetEncoder r3 = r3.newEncoder()     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                L_0x0079:
                    int r7 = r6.read(r9)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    if (r7 == r13) goto L_0x00ff
                    java.nio.ByteBuffer r11 = java.nio.ByteBuffer.wrap(r9)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    java.nio.CharBuffer r11 = r11.asCharBuffer()     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    r3.encode(r11)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    java.lang.String r11 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    r11.<init>(r9, r14, r7)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    r0.emitStreamEvent(r5, r12, r11)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    if (r4 <= 0) goto L_0x0098
                    long r13 = (long) r4     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    android.os.SystemClock.sleep(r13)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                L_0x0098:
                    r13 = -1
                    r14 = 0
                    goto L_0x0079
                L_0x009b:
                    java.lang.String r11 = "ascii"
                    boolean r11 = r2.equalsIgnoreCase(r11)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    if (r11 == 0) goto L_0x00d3
                L_0x00a3:
                    int r3 = r6.read(r9)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    r7 = -1
                    if (r3 == r7) goto L_0x00ff
                    com.facebook.react.bridge.WritableArray r7 = com.facebook.react.bridge.Arguments.createArray()     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    r11 = 0
                L_0x00af:
                    if (r11 >= r3) goto L_0x00b9
                    byte r13 = r9[r11]     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    r7.pushInt(r13)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    int r11 = r11 + 1
                    goto L_0x00af
                L_0x00b9:
                    com.facebook.react.bridge.WritableMap r3 = com.facebook.react.bridge.Arguments.createMap()     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    java.lang.String r11 = "event"
                    r3.putString(r11, r12)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    java.lang.String r11 = "detail"
                    r3.putArray(r11, r7)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    com.facebook.react.modules.core.DeviceEventManagerModule$RCTDeviceEventEmitter r7 = r0.emitter     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    r7.emit(r5, r3)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    if (r4 <= 0) goto L_0x00a3
                    long r13 = (long) r4     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    android.os.SystemClock.sleep(r13)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    goto L_0x00a3
                L_0x00d3:
                    boolean r7 = r2.equalsIgnoreCase(r7)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    if (r7 == 0) goto L_0x0101
                L_0x00d9:
                    int r7 = r6.read(r9)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    r11 = -1
                    if (r7 == r11) goto L_0x00ff
                    r11 = 2
                    if (r7 >= r3) goto L_0x00f1
                    byte[] r13 = new byte[r7]     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    r14 = 0
                    java.lang.System.arraycopy(r9, r14, r13, r14, r7)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    java.lang.String r7 = android.util.Base64.encodeToString(r13, r11)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    r0.emitStreamEvent(r5, r12, r7)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    goto L_0x00f8
                L_0x00f1:
                    java.lang.String r7 = android.util.Base64.encodeToString(r9, r11)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    r0.emitStreamEvent(r5, r12, r7)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                L_0x00f8:
                    if (r4 <= 0) goto L_0x00d9
                    long r13 = (long) r4     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    android.os.SystemClock.sleep(r13)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    goto L_0x00d9
                L_0x00ff:
                    r3 = 0
                    goto L_0x011d
                L_0x0101:
                    java.lang.String r3 = "EINVAL"
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    r4.<init>()     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    java.lang.String r7 = "Unrecognized encoding `"
                    r4.append(r7)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    r4.append(r2)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    java.lang.String r7 = "`, should be one of `base64`, `utf8`, `ascii`"
                    r4.append(r7)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    java.lang.String r4 = r4.toString()     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    r0.emitStreamEvent(r5, r8, r3, r4)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    r3 = 1
                L_0x011d:
                    if (r3 != 0) goto L_0x0124
                    java.lang.String r3 = "end"
                    r0.emitStreamEvent(r5, r3, r10)     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                L_0x0124:
                    r6.close()     // Catch:{ FileNotFoundException -> 0x013a, Exception -> 0x0128 }
                    goto L_0x0147
                L_0x0128:
                    r1 = move-exception
                    java.lang.String r3 = "Failed to convert data to "
                    java.lang.String r4 = " encoded string. This might be because this encoding cannot be used for this data."
                    java.lang.String r2 = com.android.tools.r8.GeneratedOutlineSupport.outline52(r3, r2, r4)
                    java.lang.String r3 = "EUNSPECIFIED"
                    r0.emitStreamEvent(r5, r8, r3, r2)
                    r1.printStackTrace()
                    goto L_0x0147
                L_0x013a:
                    java.lang.String r2 = "No such file '"
                    java.lang.String r3 = "'"
                    java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline52(r2, r1, r3)
                    java.lang.String r2 = "ENOENT"
                    r0.emitStreamEvent(r5, r8, r2, r1)
                L_0x0147:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.RNFetchBlob.RNFetchBlob.AnonymousClass11.run():void");
            }
        };
        threadPoolExecutor.execute(r0);
    }

    @ReactMethod
    public void removeSession(ReadableArray readableArray, Callback callback) {
        RNFetchBlobFS.removeSession(readableArray, callback);
    }

    @ReactMethod
    public void scanFile(final ReadableArray readableArray, final Callback callback) {
        final ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        threadPool.execute(new Runnable(this) {
            public void run() {
                int size = readableArray.size();
                String[] strArr = new String[size];
                String[] strArr2 = new String[size];
                for (int i = 0; i < size; i++) {
                    ReadableMap map = readableArray.getMap(i);
                    if (map.hasKey("path")) {
                        strArr[i] = map.getString("path");
                        if (map.hasKey("mime")) {
                            strArr2[i] = map.getString("mime");
                        } else {
                            strArr2[i] = null;
                        }
                    }
                }
                RNFetchBlobFS rNFetchBlobFS = new RNFetchBlobFS(reactApplicationContext);
                Callback callback = callback;
                try {
                    MediaScannerConnection.scanFile(rNFetchBlobFS.mCtx, strArr, strArr2, new OnScanCompletedListener(rNFetchBlobFS, callback) {
                        public final /* synthetic */ Callback val$callback;

                        {
                            this.val$callback = r2;
                        }

                        public void onScanCompleted(String str, Uri uri) {
                            this.val$callback.invoke(null, Boolean.TRUE);
                        }
                    });
                } catch (Exception e2) {
                    callback.invoke(e2.getLocalizedMessage(), null);
                }
            }
        });
    }

    @ReactMethod
    public void slice(String str, String str2, int i, int i2, Promise promise) {
        RNFetchBlobFS.slice(str, str2, i, i2, promise);
    }

    @ReactMethod
    public void stat(String str, Callback callback) {
        RNFetchBlobFS.stat(str, callback);
    }

    @ReactMethod
    public void unlink(String str, Callback callback) {
        RNFetchBlobFS.unlink(str, callback);
    }

    @ReactMethod
    public void writeArrayChunk(String str, ReadableArray readableArray, Callback callback) {
        RNFetchBlobFS.writeArrayChunk(str, readableArray, callback);
    }

    @ReactMethod
    public void writeChunk(String str, String str2, Callback callback) {
        RNFetchBlobFS rNFetchBlobFS = RNFetchBlobFS.fileStreams.get(str);
        try {
            rNFetchBlobFS.writeStreamInstance.write(RNFetchBlobFS.stringToBytes(str2, rNFetchBlobFS.encoding));
            callback.invoke(new Object[0]);
        } catch (Exception e2) {
            callback.invoke(e2.getLocalizedMessage());
        }
    }

    @ReactMethod
    public void writeFile(String str, String str2, String str3, boolean z, Promise promise) {
        ThreadPoolExecutor threadPoolExecutor = threadPool;
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final boolean z2 = z;
        final Promise promise2 = promise;
        AnonymousClass8 r1 = new Runnable(this) {
            public void run() {
                RNFetchBlobFS.writeFile(str4, str5, str6, z2, promise2);
            }
        };
        threadPoolExecutor.execute(r1);
    }

    @ReactMethod
    public void writeFileArray(String str, ReadableArray readableArray, boolean z, Promise promise) {
        ThreadPoolExecutor threadPoolExecutor = threadPool;
        final String str2 = str;
        final ReadableArray readableArray2 = readableArray;
        final boolean z2 = z;
        final Promise promise2 = promise;
        AnonymousClass7 r1 = new Runnable(this) {
            public void run() {
                RNFetchBlobFS.writeFile(str2, readableArray2, z2, promise2);
            }
        };
        threadPoolExecutor.execute(r1);
    }

    @ReactMethod
    public void writeStream(String str, String str2, boolean z, Callback callback) {
        RNFetchBlobFS rNFetchBlobFS = new RNFetchBlobFS(getReactApplicationContext());
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (!file.exists()) {
                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                    callback.invoke("ENOTDIR", "Failed to create parent directory of '" + str + "'");
                    return;
                } else if (!file.createNewFile()) {
                    callback.invoke("ENOENT", "File '" + str + "' does not exist and could not be created");
                    return;
                }
            } else if (file.isDirectory()) {
                callback.invoke("EISDIR", "Expecting a file but '" + str + "' is a directory");
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(str, z);
            rNFetchBlobFS.encoding = str2;
            String uuid = UUID.randomUUID().toString();
            RNFetchBlobFS.fileStreams.put(uuid, rNFetchBlobFS);
            rNFetchBlobFS.writeStreamInstance = fileOutputStream;
            callback.invoke(null, null, uuid);
        } catch (Exception e2) {
            callback.invoke(PromiseImpl.ERROR_DEFAULT_CODE, GeneratedOutlineSupport.outline38(e2, GeneratedOutlineSupport.outline80("Failed to create write stream at path `", str, "`; ")));
        }
    }
}
