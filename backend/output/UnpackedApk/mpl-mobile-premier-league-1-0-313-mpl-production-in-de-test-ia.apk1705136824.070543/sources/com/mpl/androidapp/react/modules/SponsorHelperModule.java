package com.mpl.androidapp.react.modules;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.mpl.androidapp.R;
import com.mpl.androidapp.utils.CommonUtils;
import com.mpl.androidapp.utils.FileUtils;
import com.mpl.androidapp.utils.MLogger;
import java.io.File;
import java.io.IOException;

@ReactModule(name = "SponsorHelperModule")
public class SponsorHelperModule extends ReactContextBaseJavaModule {
    public static final String TAG = "SponsorHelperModule";
    public final Context mContext;

    public SponsorHelperModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mContext = reactApplicationContext.getBaseContext();
    }

    /* access modifiers changed from: private */
    public void extract(File file, File file2) {
        new Thread(new Runnable(file, file2) {
            public final /* synthetic */ File f$0;
            public final /* synthetic */ File f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                SponsorHelperModule.lambda$extract$0(this.f$0, this.f$1);
            }
        }).start();
    }

    public static /* synthetic */ void lambda$extract$0(File file, File file2) {
        try {
            CommonUtils.extractZipFile(file, file2);
        } catch (IOException e2) {
            MLogger.e(TAG, "", e2);
        }
    }

    private void showToast() {
        Context context = this.mContext;
        Toast.makeText(context, context.getString(R.string.apk_integrity_install_fail), 1).show();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x011b  */
    @com.facebook.react.bridge.ReactMethod
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void downloadExtractFile(java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            r6 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r2 = "downloadExtractFile() called with: sponsorId = ["
            java.lang.String r3 = "], url = ["
            java.lang.String r4 = "], params = ["
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline82(r2, r7, r3, r8, r4)
            java.lang.String r3 = "]"
            java.lang.String r2 = com.android.tools.r8.GeneratedOutlineSupport.outline62(r2, r9, r3)
            r3 = 0
            r1[r3] = r2
            java.lang.String r2 = "SponsorHelperModule"
            com.mpl.androidapp.utils.MLogger.d(r2, r1)
            com.mpl.androidapp.updater.gameengine.GEInteractor r1 = com.mpl.androidapp.updater.gameengine.GEInteractor.getInstance()
            android.content.Context r4 = r6.mContext
            boolean r1 = r1.isSpaceAvailable(r4)
            if (r1 == 0) goto L_0x0129
            com.google.gson.Gson r1 = new com.google.gson.Gson
            r1.<init>()
            java.lang.Class<com.mpl.androidapp.utils.NetworkCallParams> r4 = com.mpl.androidapp.utils.NetworkCallParams.class
            java.lang.Object r9 = r1.fromJson(r9, r4)
            com.mpl.androidapp.utils.NetworkCallParams r9 = (com.mpl.androidapp.utils.NetworkCallParams) r9
            java.io.File r1 = new java.io.File
            android.content.Context r4 = r6.mContext
            java.lang.String r4 = com.mpl.androidapp.utils.FileUtils.getSponsorDir(r4)
            r1.<init>(r4)
            java.io.File r4 = new java.io.File
            java.lang.String r5 = ".zip"
            java.lang.String r7 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r7, r5)
            r4.<init>(r1, r7)
            boolean r7 = r4.exists()     // Catch:{ IOException -> 0x0055 }
            if (r7 != 0) goto L_0x005e
            boolean r7 = r4.createNewFile()     // Catch:{ IOException -> 0x0055 }
            goto L_0x005f
        L_0x0055:
            java.lang.Object[] r7 = new java.lang.Object[r0]
            java.lang.String r1 = "downloadExtractFile: "
            r7[r3] = r1
            com.mpl.androidapp.utils.MLogger.d(r2, r7)
        L_0x005e:
            r7 = 0
        L_0x005f:
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r5 = "downloadExtractFile:isFileCreated "
            r1[r3] = r5
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            r1[r0] = r7
            com.mpl.androidapp.utils.MLogger.d(r2, r1)
            com.mpl.network.modules.request.MOkHttpDownloadRequest$Builder r7 = new com.mpl.network.modules.request.MOkHttpDownloadRequest$Builder
            r7.<init>()
            com.mpl.network.modules.request.MOkHttpDownloadRequest$Builder r7 = r7.setUrl(r8)
            com.mpl.network.modules.request.MOkHttpDownloadRequest$Builder r7 = r7.setDestFile(r4)
            java.lang.String r8 = r4.getName()
            com.mpl.network.modules.request.MOkHttpDownloadRequest$Builder r7 = r7.setDestFileName(r8)
            com.mpl.network.modules.request.RequestPriority r8 = com.mpl.network.modules.request.RequestPriority.LOW
            com.mpl.network.modules.request.MOkHttpDownloadRequest$Builder r7 = r7.setRequestPriority(r8)
            java.util.List r8 = com.mpl.androidapp.utils.CommonUtils.getCommonHeaders()
            com.mpl.network.modules.request.MOkHttpDownloadRequest$Builder r7 = r7.setHeaders(r8)
            r8 = 10000(0x2710, float:1.4013E-41)
            com.mpl.network.modules.request.MOkHttpDownloadRequest$Builder r7 = r7.setConnectTimeout(r8)
            com.mpl.network.modules.request.MOkHttpDownloadRequest$Builder r7 = r7.setReadTimeout(r8)
            com.mpl.network.modules.request.MOkHttpDownloadRequest$Builder r7 = r7.setRetryOnConnectionFailure(r0)
            com.mpl.androidapp.react.modules.SponsorHelperModule$1 r0 = new com.mpl.androidapp.react.modules.SponsorHelperModule$1
            r0.<init>()
            com.mpl.network.modules.request.MOkHttpDownloadRequest$Builder r7 = r7.setResponseListener(r0)
            java.lang.String r0 = "post_request"
            com.mpl.network.modules.request.MOkHttpDownloadRequest$Builder r7 = r7.setTag(r0)
            int r0 = r9.getConnectionTimeOut()
            if (r0 < r8) goto L_0x00ba
            int r0 = r9.getConnectionTimeOut()
            goto L_0x00bc
        L_0x00ba:
            r0 = 10000(0x2710, float:1.4013E-41)
        L_0x00bc:
            r7.setConnectTimeout(r0)
            int r0 = r9.getReadTimeOut()
            if (r0 < r8) goto L_0x00ca
            int r0 = r9.getReadTimeOut()
            goto L_0x00cc
        L_0x00ca:
            r0 = 10000(0x2710, float:1.4013E-41)
        L_0x00cc:
            r7.setReadTimeout(r0)
            int r0 = r9.getWriteTimeOut()
            if (r0 < r8) goto L_0x00da
            int r0 = r9.getWriteTimeOut()
            goto L_0x00dc
        L_0x00da:
            r0 = 10000(0x2710, float:1.4013E-41)
        L_0x00dc:
            r7.setWriteTimeout(r0)
            int r0 = r9.getPingInterval()
            if (r0 < r8) goto L_0x00e9
            int r8 = r9.getPingInterval()
        L_0x00e9:
            r7.setPingInterval(r8)
            boolean r8 = r9.isRetryOption()
            r7.setRetryOnConnectionFailure(r8)
            java.lang.String r8 = r9.getHost()
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x0104
            java.lang.String r8 = r9.getHost()
            r7.setHost(r8)
        L_0x0104:
            java.lang.String r8 = r9.getScheme()
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x0115
            java.lang.String r8 = r9.getScheme()
            r7.setScheme(r8)
        L_0x0115:
            int r8 = r9.getPort()
            if (r8 <= 0) goto L_0x0122
            int r8 = r9.getPort()
            r7.setPort(r8)
        L_0x0122:
            com.mpl.network.modules.request.MOkHttpDownloadRequest r7 = r7.build()
            com.mpl.network.modules.MClient.executeAsync(r7)
        L_0x0129:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.react.modules.SponsorHelperModule.downloadExtractFile(java.lang.String, java.lang.String, java.lang.String):void");
    }

    public String getName() {
        return TAG;
    }

    @ReactMethod
    public void isPathAvailable(String str, Promise promise) {
        if (TextUtils.isEmpty(str)) {
            promise.resolve(Boolean.FALSE);
        } else {
            promise.resolve(Boolean.valueOf(FileUtils.isSponsorFileAvailable(this.mContext, str)));
        }
    }
}
