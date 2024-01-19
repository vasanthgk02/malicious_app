package com.mpl.androidapp.react.modules;

import android.app.Activity;
import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.Toast;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.google.gson.Gson;
import com.mpl.androidapp.EventPublishHelper;
import com.mpl.androidapp.MPLApplication;
import com.mpl.androidapp.R;
import com.mpl.androidapp.cleverTap.AssetsAnalytics;
import com.mpl.androidapp.cleverTap.AssetsAnalyticsProps;
import com.mpl.androidapp.config.ConfigConstant;
import com.mpl.androidapp.config.ConfigManager;
import com.mpl.androidapp.config.UpdaterAnalytics;
import com.mpl.androidapp.game.AllGame;
import com.mpl.androidapp.game.ApkInfo;
import com.mpl.androidapp.notification.NotificationBuilder;
import com.mpl.androidapp.react.MPLReactContainerActivity;
import com.mpl.androidapp.react.RNListener;
import com.mpl.androidapp.spacemanagment.GamesActivity;
import com.mpl.androidapp.spacemanagment.SpaceUtils;
import com.mpl.androidapp.ui.NonSealedApkFragment;
import com.mpl.androidapp.updater.AppInitialization;
import com.mpl.androidapp.updater.IntegrityCheck;
import com.mpl.androidapp.updater.downloadmanager.DownloadNotificationDisplayFeature;
import com.mpl.androidapp.updater.downloadmanager.di.entrypoints.NotificationDisplayEntryPoint;
import com.mpl.androidapp.updater.downloadmanager.utils.Constants;
import com.mpl.androidapp.updater.gameengine.GEInteractor;
import com.mpl.androidapp.updater.interactor.DBInteractor;
import com.mpl.androidapp.updater.model.GameAssets;
import com.mpl.androidapp.updater.repo.DownloadHelper;
import com.mpl.androidapp.updater.repo.DownloadProgressReceiver;
import com.mpl.androidapp.updater.repo.ResponseListener;
import com.mpl.androidapp.updater.util.GEUtil;
import com.mpl.androidapp.updater.util.ServiceUtil;
import com.mpl.androidapp.updater.util.StatusType;
import com.mpl.androidapp.updater.util.UpdaterConstant.Event;
import com.mpl.androidapp.updater.util.UpdaterConstant.Response;
import com.mpl.androidapp.utils.AssetsConfigReader;
import com.mpl.androidapp.utils.AssetsUtils;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.CommonUtils;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.Constant.EventsConstants;
import com.mpl.androidapp.utils.CountryUtils;
import com.mpl.androidapp.utils.DialogData.TYPE;
import com.mpl.androidapp.utils.FileUtils;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.mpl.androidapp.utils.NetworkUtils;
import com.mpl.androidapp.utils.OriginalGameConstant;
import com.mpl.androidapp.utils.Util;
import com.mpl.network.modules.listeners.IResponseListener;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import com.twitter.sdk.android.tweetui.TweetUtils;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;
import io.antmedia.android.broadcaster.LiveVideoBroadcaster;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.fontbox.cmap.CMapParser;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.jboss.netty.channel.ChannelPipelineCoverage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ReactModule(name = "GameLaunchHelper")
public class GameLaunchHelper extends ReactContextBaseJavaModule {
    public static final int APK_DOWNLOAD_DEFAULT_STATUS = -7765;
    public static final int REQUEST_INSTALL = 8787;
    public static final String TAG = "GameLaunchHelper";
    public static final Map<Integer, OriginalGameConstant> mOriginals = new HashMap();
    public boolean isRegistered;
    public final Context mContext;
    public long mDownloadRequestId;
    public int mInstallingGameId;
    public final ReactContext mReactContext;
    public final BroadcastReceiver onDownloadCompleteReceiver = new BroadcastReceiver() {
        /* JADX WARNING: Can't wrap try/catch for region: R(6:13|14|15|(1:21)|22|23) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x00c1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onReceive(android.content.Context r11, android.content.Intent r12) {
            /*
                r10 = this;
                java.lang.String r11 = "onReceive: "
                java.lang.String r0 = "GameLaunchHelper"
                r1 = 2
                r2 = 1
                r3 = 0
                r4 = 0
                com.mpl.androidapp.react.modules.GameLaunchHelper r5 = com.mpl.androidapp.react.modules.GameLaunchHelper.this     // Catch:{ Exception -> 0x00f9 }
                android.content.Context r5 = r5.mContext     // Catch:{ Exception -> 0x00f9 }
                java.lang.String r6 = "download"
                java.lang.Object r5 = r5.getSystemService(r6)     // Catch:{ Exception -> 0x00f9 }
                android.app.DownloadManager r5 = (android.app.DownloadManager) r5     // Catch:{ Exception -> 0x00f9 }
                java.lang.String r6 = "extra_download_id"
                r7 = -1
                long r6 = r12.getLongExtra(r6, r7)     // Catch:{ Exception -> 0x00f9 }
                r12 = 3
                java.lang.Object[] r12 = new java.lang.Object[r12]     // Catch:{ Exception -> 0x00f9 }
                r12[r3] = r11     // Catch:{ Exception -> 0x00f9 }
                com.mpl.androidapp.react.modules.GameLaunchHelper r8 = com.mpl.androidapp.react.modules.GameLaunchHelper.this     // Catch:{ Exception -> 0x00f9 }
                long r8 = r8.mDownloadRequestId     // Catch:{ Exception -> 0x00f9 }
                java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ Exception -> 0x00f9 }
                r12[r2] = r8     // Catch:{ Exception -> 0x00f9 }
                java.lang.Long r8 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x00f9 }
                r12[r1] = r8     // Catch:{ Exception -> 0x00f9 }
                com.mpl.androidapp.utils.MLogger.d(r0, r12)     // Catch:{ Exception -> 0x00f9 }
                com.mpl.androidapp.react.modules.GameLaunchHelper r12 = com.mpl.androidapp.react.modules.GameLaunchHelper.this     // Catch:{ Exception -> 0x00f9 }
                long r8 = r12.mDownloadRequestId     // Catch:{ Exception -> 0x00f9 }
                int r12 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
                if (r12 != 0) goto L_0x00d7
                if (r5 == 0) goto L_0x005b
                android.app.DownloadManager$Query r12 = new android.app.DownloadManager$Query     // Catch:{ Exception -> 0x00f9 }
                r12.<init>()     // Catch:{ Exception -> 0x00f9 }
                long[] r6 = new long[r2]     // Catch:{ Exception -> 0x00f9 }
                com.mpl.androidapp.react.modules.GameLaunchHelper r7 = com.mpl.androidapp.react.modules.GameLaunchHelper.this     // Catch:{ Exception -> 0x00f9 }
                long r7 = r7.mDownloadRequestId     // Catch:{ Exception -> 0x00f9 }
                r6[r3] = r7     // Catch:{ Exception -> 0x00f9 }
                android.app.DownloadManager$Query r12 = r12.setFilterById(r6)     // Catch:{ Exception -> 0x00f9 }
                android.database.Cursor r4 = r5.query(r12)     // Catch:{ Exception -> 0x00f9 }
            L_0x005b:
                if (r4 == 0) goto L_0x00e0
                r4.moveToFirst()     // Catch:{ Exception -> 0x00f9 }
                java.lang.String r12 = "local_uri"
                int r12 = r4.getColumnIndex(r12)     // Catch:{ Exception -> 0x00f9 }
                java.lang.String r12 = r4.getString(r12)     // Catch:{ Exception -> 0x00f9 }
                java.lang.String r5 = "status"
                int r5 = r4.getColumnIndex(r5)     // Catch:{ Exception -> 0x00f9 }
                int r5 = r4.getInt(r5)     // Catch:{ Exception -> 0x00f9 }
                java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x00f9 }
                r6[r3] = r11     // Catch:{ Exception -> 0x00f9 }
                com.mpl.androidapp.utils.MLogger.d(r0, r6)     // Catch:{ Exception -> 0x00f9 }
                r11 = 8
                if (r5 != r11) goto L_0x00cd
                boolean r11 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x00f9 }
                if (r11 != 0) goto L_0x00cd
                android.net.Uri r11 = android.net.Uri.parse(r12)     // Catch:{ Exception -> 0x00f9 }
                if (r11 == 0) goto L_0x00cd
                java.io.File r11 = new java.io.File     // Catch:{ Exception -> 0x00f9 }
                android.net.Uri r12 = android.net.Uri.parse(r12)     // Catch:{ Exception -> 0x00f9 }
                java.lang.String r12 = r12.getPath()     // Catch:{ Exception -> 0x00f9 }
                r11.<init>(r12)     // Catch:{ Exception -> 0x00f9 }
                boolean r12 = r11.exists()     // Catch:{ Exception -> 0x00c1 }
                if (r12 == 0) goto L_0x00c1
                java.lang.String r12 = r11.getName()     // Catch:{ Exception -> 0x00c1 }
                boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x00c1 }
                if (r12 != 0) goto L_0x00c1
                java.lang.String r12 = r11.getName()     // Catch:{ Exception -> 0x00c1 }
                java.lang.String r5 = ".apk"
                boolean r12 = r12.endsWith(r5)     // Catch:{ Exception -> 0x00c1 }
                if (r12 == 0) goto L_0x00c1
                com.mpl.androidapp.react.modules.GameLaunchHelper r12 = com.mpl.androidapp.react.modules.GameLaunchHelper.this     // Catch:{ Exception -> 0x00c1 }
                java.lang.String r5 = com.mpl.androidapp.utils.FileUtils.getFileNameWithoutExtension(r11)     // Catch:{ Exception -> 0x00c1 }
                int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ Exception -> 0x00c1 }
                r12.mInstallingGameId = r5     // Catch:{ Exception -> 0x00c1 }
            L_0x00c1:
                com.mpl.androidapp.react.modules.GameLaunchHelper r12 = com.mpl.androidapp.react.modules.GameLaunchHelper.this     // Catch:{ Exception -> 0x00f9 }
                android.app.Activity r12 = r12.getCurrentActivity()     // Catch:{ Exception -> 0x00f9 }
                r5 = 8787(0x2253, float:1.2313E-41)
                com.mpl.androidapp.utils.FileUtils.installApkNew(r12, r11, r5)     // Catch:{ Exception -> 0x00f9 }
                goto L_0x00e0
            L_0x00cd:
                java.lang.Object[] r11 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x00f9 }
                java.lang.String r12 = "onReceive: unknown"
                r11[r3] = r12     // Catch:{ Exception -> 0x00f9 }
                com.mpl.androidapp.utils.MLogger.d(r0, r11)     // Catch:{ Exception -> 0x00f9 }
                goto L_0x00e0
            L_0x00d7:
                java.lang.Object[] r11 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x00f9 }
                java.lang.String r12 = "onReceive: downloaded and saved download id is not matching"
                r11[r3] = r12     // Catch:{ Exception -> 0x00f9 }
                com.mpl.androidapp.utils.MLogger.d(r0, r11)     // Catch:{ Exception -> 0x00f9 }
            L_0x00e0:
                com.mpl.androidapp.react.modules.GameLaunchHelper r11 = com.mpl.androidapp.react.modules.GameLaunchHelper.this
                android.content.Context r11 = r11.mContext
                com.mpl.androidapp.react.modules.GameLaunchHelper r12 = com.mpl.androidapp.react.modules.GameLaunchHelper.this
                android.content.BroadcastReceiver r12 = r12.onDownloadCompleteReceiver
                r11.unregisterReceiver(r12)
                com.mpl.androidapp.react.modules.GameLaunchHelper r11 = com.mpl.androidapp.react.modules.GameLaunchHelper.this
                r11.isRegistered = r3
                if (r4 == 0) goto L_0x011e
                goto L_0x011b
            L_0x00f7:
                r11 = move-exception
                goto L_0x011f
            L_0x00f9:
                r11 = move-exception
                java.lang.Object[] r12 = new java.lang.Object[r1]     // Catch:{ all -> 0x00f7 }
                java.lang.String r1 = "Could not open the downloaded file"
                r12[r3] = r1     // Catch:{ all -> 0x00f7 }
                r12[r2] = r11     // Catch:{ all -> 0x00f7 }
                com.mpl.androidapp.utils.MLogger.e(r0, r12)     // Catch:{ all -> 0x00f7 }
                com.mpl.androidapp.react.modules.GameLaunchHelper r11 = com.mpl.androidapp.react.modules.GameLaunchHelper.this
                android.content.Context r11 = r11.mContext
                com.mpl.androidapp.react.modules.GameLaunchHelper r12 = com.mpl.androidapp.react.modules.GameLaunchHelper.this
                android.content.BroadcastReceiver r12 = r12.onDownloadCompleteReceiver
                r11.unregisterReceiver(r12)
                com.mpl.androidapp.react.modules.GameLaunchHelper r11 = com.mpl.androidapp.react.modules.GameLaunchHelper.this
                r11.isRegistered = r3
                if (r4 == 0) goto L_0x011e
            L_0x011b:
                r4.close()
            L_0x011e:
                return
            L_0x011f:
                com.mpl.androidapp.react.modules.GameLaunchHelper r12 = com.mpl.androidapp.react.modules.GameLaunchHelper.this
                android.content.Context r12 = r12.mContext
                com.mpl.androidapp.react.modules.GameLaunchHelper r0 = com.mpl.androidapp.react.modules.GameLaunchHelper.this
                android.content.BroadcastReceiver r0 = r0.onDownloadCompleteReceiver
                r12.unregisterReceiver(r0)
                com.mpl.androidapp.react.modules.GameLaunchHelper r12 = com.mpl.androidapp.react.modules.GameLaunchHelper.this
                r12.isRegistered = r3
                if (r4 == 0) goto L_0x0138
                r4.close()
            L_0x0138:
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.react.modules.GameLaunchHelper.AnonymousClass2.onReceive(android.content.Context, android.content.Intent):void");
        }
    };
    public int previousProgress;

    public GameLaunchHelper(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mContext = reactApplicationContext.getBaseContext();
        this.mReactContext = reactApplicationContext;
        reactApplicationContext.addActivityEventListener(new ActivityEventListener() {
            public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
                MLogger.d(GameLaunchHelper.TAG, "onActivityResult: ", Integer.valueOf(i), Integer.valueOf(i2), intent);
                if (i == 8787 && GameLaunchHelper.this.getCurrentActivity() != null) {
                    String str = i2 == -1 ? "Install Succeeded!" : i2 == 0 ? "Install Canceled!" : "Install Failed!";
                    CommonUtils.sendInstallStatusToReact(GameLaunchHelper.this.mReactContext, str, GameLaunchHelper.this.mInstallingGameId);
                    CommonUtils.sendInstallStatusNotification(GameLaunchHelper.this.mReactContext, str, GameLaunchHelper.this.mInstallingGameId);
                }
            }

            public void onNewIntent(Intent intent) {
            }
        });
    }

    private void addAssetsInstalledAndUpdateAvailableToJson(JSONArray jSONArray, int i, JSONObject jSONObject) {
        String str;
        boolean z;
        int i2 = i;
        JSONObject jSONObject2 = jSONObject;
        try {
            boolean optBoolean = jSONObject2.optBoolean("isTournamentSupported", false);
            boolean optBoolean2 = jSONObject2.optBoolean("isBattleSupported", false);
            boolean isAssetsAvailable = GEInteractor.getInstance().isAssetsAvailable(getCurrentActivity().getApplicationContext(), i2);
            if (!optBoolean2 || !optBoolean) {
                if (!isAssetsAvailable) {
                    isAssetsAvailable = GEInteractor.getInstance().isAssetsAvailable(getCurrentActivity().getApplicationContext(), CommonUtils.changeToBattleGameId(i));
                }
                jSONObject2.put("isGameInstalled", isAssetsAvailable);
            } else {
                if (!GEInteractor.getInstance().isAssetsAvailable(getCurrentActivity().getApplicationContext(), i2 + 1000000)) {
                    if (!isAssetsAvailable) {
                        z = false;
                        jSONObject2.put("isGameInstalled", z);
                    }
                }
                z = true;
                jSONObject2.put("isGameInstalled", z);
            }
            if (jSONObject2.optBoolean("isGameInstalled")) {
                if (!optBoolean || !optBoolean2) {
                    boolean isAssetsAvailable2 = GEInteractor.getInstance().isAssetsAvailable(getCurrentActivity().getApplicationContext(), CommonUtils.changeToBattleGameId(i));
                    boolean isAssetsAvailable3 = GEInteractor.getInstance().isAssetsAvailable(getCurrentActivity().getApplicationContext(), i2);
                    long directorySizeLegacy = Util.getDirectorySizeLegacy(new File(GEUtil.getGameAssetsPathByGameId(getCurrentActivity().getApplicationContext(), i2))) / 1048576;
                    if (directorySizeLegacy == 0) {
                        directorySizeLegacy = Util.getDirectorySizeLegacy(new File(GEUtil.getGameAssetsPathByGameId(getCurrentActivity().getApplicationContext(), CommonUtils.changeToBattleGameId(i)))) / 1048576;
                    }
                    String str2 = directorySizeLegacy + " MB";
                    jSONObject2.put("isUpdateAvailable", (isAssetsAvailable3 && !AssetsUtils.isGameAssetsVersionValid(getCurrentActivity().getApplicationContext(), i2)) || (isAssetsAvailable2 && !AssetsUtils.isGameAssetsVersionValid(getCurrentActivity().getApplicationContext(), CommonUtils.changeToBattleGameId(i))));
                    if (isAssetsAvailable3) {
                        jSONObject2.put("gameVersion", MSharedPreferencesUtils.getDownloadedAssetVersion(this.mContext, i2, 0));
                    } else {
                        jSONObject2.put("gameVersion", MSharedPreferencesUtils.getDownloadedAssetVersion(this.mContext, CommonUtils.changeToBattleGameId(i), 0));
                    }
                    str = str2;
                } else {
                    long directorySizeLegacy2 = Util.getDirectorySizeLegacy(new File(GEUtil.getGameAssetsPathByGameId(getCurrentActivity().getApplicationContext(), i2)));
                    int i3 = 1000000 + i2;
                    long directorySizeLegacy3 = Util.getDirectorySizeLegacy(new File(GEUtil.getGameAssetsPathByGameId(getCurrentActivity().getApplicationContext(), i3)));
                    str = ((directorySizeLegacy2 + directorySizeLegacy3) / 1048576) + " MB";
                    boolean isAssetsAvailable4 = GEInteractor.getInstance().isAssetsAvailable(getCurrentActivity().getApplicationContext(), i3);
                    boolean isAssetsAvailable5 = GEInteractor.getInstance().isAssetsAvailable(getCurrentActivity().getApplicationContext(), i2);
                    jSONObject2.put("isUpdateAvailable", (isAssetsAvailable5 && !AssetsUtils.isGameAssetsVersionValid(getCurrentActivity().getApplicationContext(), i2)) || (isAssetsAvailable4 && !AssetsUtils.isGameAssetsVersionValid(getCurrentActivity().getApplicationContext(), i3)));
                    if (isAssetsAvailable5) {
                        jSONObject2.put("gameVersion", MSharedPreferencesUtils.getDownloadedAssetVersion(this.mContext, i2, 0));
                    } else {
                        jSONObject2.put("gameVersion", MSharedPreferencesUtils.getDownloadedAssetVersion(this.mContext, i3, 0));
                    }
                }
                jSONObject2.put("gameSize", str);
                jSONArray.put(jSONObject2);
            }
        } catch (Exception e2) {
            MLogger.d(TAG, GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("error in addAssetsInstalledAndUpdateAvailableToJson: ")));
        }
    }

    private void checkDownloadProgress(int i, int i2, String str, String str2, String str3, long j, boolean z) {
        long j2 = j;
        StringBuilder outline75 = GeneratedOutlineSupport.outline75("checkDownloadProgress() called with: gameId = [", i, "], serverVersionCode = [", i2, "], gameIconUrl = [");
        GeneratedOutlineSupport.outline103(outline75, str, "], gameName = [", str2, "], packageName = [");
        outline75.append(str3);
        outline75.append("], downloadId = [");
        outline75.append(j2);
        outline75.append("], isForceUpdate = [");
        outline75.append(z);
        outline75.append(CMapParser.MARK_END_OF_ARRAY);
        MLogger.d(TAG, outline75.toString());
        DownloadManager downloadManager = (DownloadManager) this.mContext.getSystemService(Constant.DOWNLOAD);
        if (downloadManager != null) {
            Timer timer = new Timer();
            Query query = new Query();
            query.setFilterById(new long[]{j2});
            publishProgressToReact(2, str, str2, str3, i, i2, z);
            final DownloadManager downloadManager2 = downloadManager;
            final Query query2 = query;
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            final int i3 = i;
            final int i4 = i2;
            final boolean z2 = z;
            final Timer timer2 = timer;
            AnonymousClass7 r7 = new TimerTask() {
                public void run() {
                    MLogger.d(GameLaunchHelper.TAG, "run: checking progress 1");
                    Cursor query = downloadManager2.query(query2);
                    if (query == null || !query.moveToFirst()) {
                        MLogger.e(GameLaunchHelper.TAG, "run: checking progress 1 Cursor is null");
                        Timer timer = timer2;
                        if (timer != null) {
                            timer.cancel();
                        }
                        cancel();
                        return;
                    }
                    int i = query.getInt(query.getColumnIndex("status"));
                    int i2 = query.getInt(query.getColumnIndex("total_size"));
                    int i3 = query.getInt(query.getColumnIndex("bytes_so_far"));
                    MLogger.d(GameLaunchHelper.TAG, "DownloadManager::status 1 ", Integer.valueOf(i));
                    if (i == 1) {
                        MLogger.d(GameLaunchHelper.TAG, GeneratedOutlineSupport.outline43("DownloadManager:STATUS_PENDING ", i2, "  ", i3));
                    } else if (i == 2) {
                        int i4 = (int) ((((float) i3) / ((float) i2)) * 100.0f);
                        GameLaunchHelper.this.publishProgressToReact(i4, str4, str5, str6, i3, i4, z2);
                        MLogger.d(GameLaunchHelper.TAG, "DownloadManager:STATUS_RUNNING ", Integer.valueOf(i4));
                    } else if (i == 4) {
                        GameLaunchHelper gameLaunchHelper = GameLaunchHelper.this;
                        gameLaunchHelper.publishProgressToReact((int) ((((float) i3) / ((float) i2)) * 100.0f), str4, str5, str6, i3, i4, z2);
                        MLogger.d(GameLaunchHelper.TAG, GeneratedOutlineSupport.outline43("DownloadManager:STATUS_PAUSED ", i2, "  ", i3));
                    } else if (i == 8) {
                        GameLaunchHelper.this.previousProgress = 0;
                        GameLaunchHelper.this.sendDownloadCompletedEventToReact(i3);
                        timer2.cancel();
                        MLogger.d(GameLaunchHelper.TAG, "run: cancel task:", Boolean.valueOf(cancel()));
                        MLogger.d(GameLaunchHelper.TAG, GeneratedOutlineSupport.outline43("DownloadManager:STATUS_SUCCESSFUL ", i2, "  ", i3));
                    } else if (i != 16) {
                        MLogger.d(GameLaunchHelper.TAG, GeneratedOutlineSupport.outline41("DownloadManager:status ", i));
                    } else {
                        MLogger.d(GameLaunchHelper.TAG, GeneratedOutlineSupport.outline43("DownloadManager:STATUS_FAILED ", i2, "  ", i3));
                        GameLaunchHelper.this.mDownloadRequestId = 0;
                        GameLaunchHelper.this.previousProgress = 0;
                        try {
                            if (Util.getPackageNameBasedOnGameId(i3) != null) {
                                ApkInfo thirdPartyAppInfoBasedOnPackageName = CommonUtils.getThirdPartyAppInfoBasedOnPackageName(Util.getPackageNameBasedOnGameId(i3));
                                if (thirdPartyAppInfoBasedOnPackageName != null) {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("Game Name", thirdPartyAppInfoBasedOnPackageName.getGameName());
                                    jSONObject.put("Game Id", thirdPartyAppInfoBasedOnPackageName.getGameId());
                                    jSONObject.put(AssetsAnalytics.PROP_GAME_DOWNLOAD_SIZE, thirdPartyAppInfoBasedOnPackageName.getSize());
                                    jSONObject.put(AssetsAnalytics.PROP_GAME_VERSION, thirdPartyAppInfoBasedOnPackageName.getGameVersion());
                                    jSONObject.put(AssetsAnalytics.PROP_IS_FORCE_UPDATE, thirdPartyAppInfoBasedOnPackageName.getForceUpdate());
                                    jSONObject.put(AssetsAnalytics.PROP_GAME_PLAYED, Double.parseDouble(thirdPartyAppInfoBasedOnPackageName.getGamePlays()));
                                    jSONObject.put(AssetsAnalytics.PROP_GAME_INSTALL_COUNT, Double.parseDouble(thirdPartyAppInfoBasedOnPackageName.getInstalls()));
                                    jSONObject.put("Is Success", false);
                                    CleverTapAnalyticsUtils.sendEvent((String) AssetsAnalytics.EVENT_GAME_DOWNLOAD_COMPLETED, jSONObject.toString());
                                }
                            }
                        } catch (Exception unused) {
                            MLogger.e(GameLaunchHelper.TAG, "Game Download Completed: ");
                        }
                        timer2.cancel();
                        MLogger.d(GameLaunchHelper.TAG, "run: cancel task:", Boolean.valueOf(cancel()));
                        GameLaunchHelper.this.deleteGameDownloadPref((long) i4, i3);
                        GameLaunchHelper.this.sendDownloadFailedEventToReact(i3);
                    }
                    if (!query.isClosed()) {
                        query.close();
                    }
                }
            };
            timer.scheduleAtFixedRate(r7, 0, 200);
        }
    }

    private boolean checkForAssetsMerging(AllGame allGame) {
        boolean z;
        boolean booleanValue = allGame.getIsTournamentSupported().booleanValue();
        boolean booleanValue2 = allGame.getIsBattleSupported().booleanValue();
        int intValue = allGame.getId().intValue() % 1000000;
        MLogger.d(TAG, "checkForAssetsMerging: ", "isTournamentSupported: ", Boolean.valueOf(booleanValue), "isBattleSupported: ", Boolean.valueOf(booleanValue2), "gameId: ", Integer.valueOf(intValue));
        boolean isBundleMergeFlow = AssetsUtils.isBundleMergeFlow();
        if (!booleanValue || !booleanValue2) {
            if (booleanValue) {
                z = GEInteractor.getInstance().isAssetsAvailable(this.mContext, intValue);
                if (!z && isBundleMergeFlow) {
                    z = GEInteractor.getInstance().isAssetsAvailable(this.mContext, CommonUtils.changeToBattleGameId(intValue));
                }
            } else if (booleanValue2) {
                z = GEInteractor.getInstance().isAssetsAvailable(this.mContext, CommonUtils.changeToBattleGameId(intValue));
            }
            MLogger.d(TAG, "checkForAssetsMerging:isAssetsAvailable ", Boolean.valueOf(z));
            return z;
        }
        boolean isAssetsAvailable = GEInteractor.getInstance().isAssetsAvailable(this.mContext, intValue);
        boolean isAssetsAvailable2 = GEInteractor.getInstance().isAssetsAvailable(this.mContext, CommonUtils.changeToBattleGameId(intValue));
        MLogger.d(TAG, "checkForAssetsMerging: ", "isTournamentAssetsAvailable: ", Boolean.valueOf(isAssetsAvailable), "isBattleAssetsAvailable: ", Boolean.valueOf(isAssetsAvailable2));
        if (AssetsUtils.isMergedAssetsAreDownloaded(CommonUtils.changeToBattleGameId(intValue))) {
            z = GEInteractor.getInstance().isAssetsAvailable(this.mContext, CommonUtils.changeToBattleGameId(intValue));
            boolean isGameAssetsVersionValid = AssetsUtils.isGameAssetsVersionValid(MPLApplication.getInstance(), CommonUtils.changeToBattleGameId(intValue));
            MLogger.d(TAG, "checkForAssetsMerging: ", "isAssetsAvailable: ", Boolean.valueOf(z), "isBattleAssetsValid: ", Boolean.valueOf(isGameAssetsVersionValid));
            if (!isGameAssetsVersionValid) {
                GEInteractor.getInstance().deleteAssets(this.mContext, intValue);
                GEInteractor.getInstance().deleteAssets(this.mContext, CommonUtils.changeToBattleGameId(intValue));
            }
            MLogger.d(TAG, "checkForAssetsMerging:isAssetsAvailable ", Boolean.valueOf(z));
            return z;
        } else if (!isAssetsAvailable || !isAssetsAvailable2) {
            GEInteractor.getInstance().deleteAssets(this.mContext, intValue);
            GEInteractor.getInstance().deleteAssets(this.mContext, CommonUtils.changeToBattleGameId(intValue));
        } else {
            boolean isGameAssetsVersionValid2 = AssetsUtils.isGameAssetsVersionValid(MPLApplication.getInstance(), intValue);
            boolean isGameAssetsVersionValid3 = AssetsUtils.isGameAssetsVersionValid(MPLApplication.getInstance(), CommonUtils.changeToBattleGameId(intValue));
            MLogger.d(TAG, "checkForAssetsMerging: ", "isTournamentAssetsValid: ", Boolean.valueOf(isGameAssetsVersionValid2), "isBattleAssetsValid: ", Boolean.valueOf(isGameAssetsVersionValid3));
            if (!isGameAssetsVersionValid2 || !isGameAssetsVersionValid3) {
                GEInteractor.getInstance().deleteAssets(this.mContext, intValue);
                GEInteractor.getInstance().deleteAssets(this.mContext, CommonUtils.changeToBattleGameId(intValue));
            } else {
                z = true;
                MLogger.d(TAG, "checkForAssetsMerging:isAssetsAvailable ", Boolean.valueOf(z));
                return z;
            }
        }
        z = false;
        MLogger.d(TAG, "checkForAssetsMerging:isAssetsAvailable ", Boolean.valueOf(z));
        return z;
    }

    private String checkTamperedAppInstalled(int i) {
        boolean z;
        try {
            if (!MSharedPreferencesUtils.isTamperedAppsCheckEnabled()) {
                return "";
            }
            ArrayList arrayList = new ArrayList();
            HashSet<String> gameIdsListForTamperCheck = MSharedPreferencesUtils.getGameIdsListForTamperCheck();
            if (!gameIdsListForTamperCheck.contains(String.valueOf(i)) && !gameIdsListForTamperCheck.contains(ChannelPipelineCoverage.ALL)) {
                return "";
            }
            HashMap<String, String> tamperedAppsCheckList = MSharedPreferencesUtils.getTamperedAppsCheckList();
            if (tamperedAppsCheckList == null || tamperedAppsCheckList.isEmpty()) {
                z = false;
            } else {
                z = false;
                for (Entry next : tamperedAppsCheckList.entrySet()) {
                    String str = (String) next.getValue();
                    if (Util.isAppInstalled(this.mContext, (String) next.getKey())) {
                        arrayList.add(str);
                        z = true;
                    }
                }
            }
            if (!z) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
                sb.append(",");
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
            if (arrayList.size() == 1) {
                sb.append(" app found.\nPlease uninstall this app and try again");
            } else {
                sb.append(" apps found.\nPlease uninstall these apps and try again");
            }
            return sb.toString();
        } catch (Exception e2) {
            MLogger.e(TAG, "checkTamperedAppInstalled: ", e2);
            return "";
        }
    }

    /* access modifiers changed from: private */
    public void deleteGameDownloadPref(long j, int i) {
        MLogger.d(TAG, "deleteGameDownloadPref() called with: serverVersionCode = [" + j + "], gameId = [" + i + CMapParser.MARK_END_OF_ARRAY);
        try {
            Util.deleteRecursive(FileUtils.getThirdPartyAppDownloadDir(this.mContext, i, j));
            Context context = this.mContext;
            MSharedPreferencesUtils.deleteNormalPref(context, i + "_" + j, Constant.THIRD_PARTY_APK_GAME_STATUS);
            MSharedPreferencesUtils.deleteNormalPref(this.mContext, String.valueOf(this.mDownloadRequestId), Constant.THIRD_PARTY_APK_GAME_STATUS);
        } catch (IOException e2) {
            MLogger.e(TAG, "getThirdPartyApkDownloadProgressStatus: ", e2);
        }
    }

    private int getApkDownloadStatus(long j) {
        MLogger.d(TAG, "getApkDownloadStatus: ", Long.valueOf(j));
        int i = APK_DOWNLOAD_DEFAULT_STATUS;
        try {
            Query query = new Query();
            query.setFilterById(new long[]{j});
            DownloadManager downloadManager = (DownloadManager) this.mContext.getSystemService(Constant.DOWNLOAD);
            if (downloadManager != null) {
                Cursor query2 = downloadManager.query(query);
                if (query2 != null && query2.moveToFirst() && query2.getCount() > 0) {
                    i = query2.getInt(query2.getColumnIndex("status"));
                    MLogger.d(TAG, "getApkDownloadStatus:status ", Integer.valueOf(i));
                }
                if (query2 != null) {
                    query2.close();
                }
            }
        } catch (Exception unused) {
        }
        return i;
    }

    private ApkInfo getApkInfo(String str) {
        return (ApkInfo) new Gson().fromJson(str, ApkInfo.class);
    }

    private long getDownloadId(int i, long j) {
        MLogger.d(TAG, "getDownloadId: ", Integer.valueOf(i), Long.valueOf(j));
        Context context = this.mContext;
        return Long.parseLong(MSharedPreferencesUtils.getStringInNormalPref(context, Constant.THIRD_PARTY_APK_GAME_STATUS, i + "_" + j, String.valueOf(0)));
    }

    private AllGame getGameInfo(String str) {
        return (AllGame) new Gson().fromJson(str, AllGame.class);
    }

    private void getThirdPartyApkDownloadProgressStatus(long j, int i, int i2, Promise promise) {
        int apkDownloadStatus = getApkDownloadStatus(j);
        MLogger.d(TAG, "getThirdPartyApkDownloadProgressStatus: ", Integer.valueOf(apkDownloadStatus));
        if (apkDownloadStatus == 8) {
            String apkDownloadedFilePath = FileUtils.getApkDownloadedFilePath(this.mContext, j);
            MLogger.d(TAG, "getThirdPartyApkDownloadProgressStatus: ", apkDownloadedFilePath);
            if (TextUtils.isEmpty(apkDownloadedFilePath)) {
                MLogger.d(TAG, "getThirdPartyApkDownloadProgressStatus: file path is empty");
                deleteGameDownloadPref((long) i, i2);
                promise.resolve("third_party_apk_corrupted");
            } else if (new File(Uri.parse(apkDownloadedFilePath).getPath()).exists()) {
                promise.resolve("install_downloaded_third_party_apk");
                MLogger.d(TAG, "getThirdPartyApkDownloadProgressStatus: file not present");
            } else {
                MLogger.d(TAG, "getThirdPartyApkDownloadProgressStatus: file not present apk is corrupted");
                deleteGameDownloadPref((long) i, i2);
                promise.resolve("third_party_apk_corrupted");
            }
        } else if (apkDownloadStatus == 16) {
            DownloadManager downloadManager = (DownloadManager) this.mContext.getSystemService(Constant.DOWNLOAD);
            if (downloadManager != null) {
                downloadManager.remove(new long[]{this.mDownloadRequestId});
            }
            try {
                if (Util.getPackageNameBasedOnGameId(i2) != null) {
                    ApkInfo thirdPartyAppInfoBasedOnPackageName = CommonUtils.getThirdPartyAppInfoBasedOnPackageName(Util.getPackageNameBasedOnGameId(i2));
                    if (thirdPartyAppInfoBasedOnPackageName != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("Game Name", thirdPartyAppInfoBasedOnPackageName.getGameName());
                        jSONObject.put("Game Id", thirdPartyAppInfoBasedOnPackageName.getGameId());
                        jSONObject.put(AssetsAnalytics.PROP_GAME_DOWNLOAD_SIZE, thirdPartyAppInfoBasedOnPackageName.getSize());
                        jSONObject.put(AssetsAnalytics.PROP_GAME_PLAYED, Double.parseDouble(thirdPartyAppInfoBasedOnPackageName.getGamePlays()));
                        jSONObject.put(AssetsAnalytics.PROP_GAME_VERSION, thirdPartyAppInfoBasedOnPackageName.getGameVersion());
                        jSONObject.put(AssetsAnalytics.PROP_IS_FORCE_UPDATE, thirdPartyAppInfoBasedOnPackageName.getForceUpdate());
                        jSONObject.put(AssetsAnalytics.PROP_GAME_INSTALL_COUNT, Double.parseDouble(thirdPartyAppInfoBasedOnPackageName.getInstalls()));
                        jSONObject.put("Is Success", false);
                        CleverTapAnalyticsUtils.sendEvent((String) AssetsAnalytics.EVENT_GAME_DOWNLOAD_COMPLETED, jSONObject.toString());
                    }
                }
            } catch (Exception unused) {
                MLogger.e(TAG, "Game Download Completed: ");
            }
            deleteGameDownloadPref((long) i, i2);
            promise.resolve("third_party_apk_downloading_failed");
        } else if (apkDownloadStatus == 2 || apkDownloadStatus == 4) {
            promise.resolve("third_party_apk_downloading");
            AllGame gameInfo = CommonUtils.getGameInfo(Integer.valueOf(i2));
            if (gameInfo == null || gameInfo.getGameConfigGameInfo() == null || gameInfo.getGameConfigGameInfo().getApkInfo() == null) {
                MLogger.d(TAG, "getThirdPartyApkDownloadProgressStatus: game info is null");
            } else {
                ApkInfo apkInfo = gameInfo.getGameConfigGameInfo().getApkInfo();
                checkDownloadProgress(i2, i, gameInfo.getIcons().getLogo(), apkInfo.getGameName(), apkInfo.getPackageName(), j, apkInfo.getForceUpdate());
            }
            this.mDownloadRequestId = j;
        } else {
            promise.resolve("third_party_apk_unknown");
        }
    }

    private void launchPlayStore(int i, Promise promise) {
        if (promise != null) {
            promise.resolve("third_party_download_from_playstore");
        }
        if (getCurrentActivity() != null) {
            String packageNameBasedOnGameId = Util.getPackageNameBasedOnGameId(i);
            boolean isOriginalsApp = Util.isOriginalsApp(i);
            String redirectUrl = Util.getRedirectUrl(i);
            if (isOriginalsApp) {
                launchOriginalGame(getCurrentActivity(), packageNameBasedOnGameId, i);
            } else if (!TextUtils.isEmpty(redirectUrl)) {
                Util.openLinkInBrowser(getCurrentActivity(), redirectUrl);
            } else {
                Util.openAppInPlayStore(getCurrentActivity(), packageNameBasedOnGameId);
            }
        }
    }

    private void processAssetsDownloadFlow(AllGame allGame, final Promise promise) {
        int intValue = (allGame.getId().intValue() % 1000000) + 1000000;
        MLogger.d(TAG, "processAssetsDownloadFlow: ", Integer.valueOf(intValue));
        int gameVersion = AssetsUtils.getGameVersion(intValue);
        int downloadedAssetVersion = MSharedPreferencesUtils.getDownloadedAssetVersion(this.mContext, intValue, 0);
        MLogger.d(TAG, "processAssetsDownloadFlow:gameVersion ", Integer.valueOf(gameVersion), "downloadedVersion", Integer.valueOf(downloadedAssetVersion));
        if (!AssetsConfigReader.listOfGameAssetsAvailableArray(this.mContext).contains(Integer.valueOf(intValue)) || gameVersion > downloadedAssetVersion) {
            MLogger.d(TAG, "processAssetsDownloadFlow: Download flow");
            boolean isCurrentlyDownloadingAssets = AssetsUtils.isCurrentlyDownloadingAssets(intValue);
            MLogger.d(TAG, "processAssetsDownloadFlow: ", Boolean.valueOf(isCurrentlyDownloadingAssets));
            if (isCurrentlyDownloadingAssets) {
                promise.resolve("game_assets_downloading_progress");
            } else if (AssetsUtils.isBundleMergeFlow()) {
                downloadGameAssetsByGameId(intValue, allGame.getName(), 0, promise);
            } else {
                promise.resolve("game_assets_downloading");
            }
        } else {
            MLogger.d(TAG, "processAssetsDownloadFlow: Prebundle flow");
            GEInteractor.getInstance().initializeGameAssetsFirstTime(this.mContext, new RNListener() {
                public boolean isHasRequiredPermission() {
                    return false;
                }

                public void publishResult(String str) {
                    if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("Success")) {
                        promise.resolve("launch_game");
                    }
                }
            });
        }
    }

    private void processMPLUpdateFlow(Promise promise) {
        MLogger.d(TAG, "processMPLUpdateFlow: ");
        if (DBInteractor.getCurrentDownloadedAppVersionCode() > MBuildConfigUtils.getInstalledAppVersionCode()) {
            promise.resolve("install_downloaded_apk");
        } else if (!MBuildConfigUtils.isCashApp() && !MSharedPreferencesUtils.isProAppDownloadRequired()) {
            promise.resolve("download_from_playstore");
        } else if (GEInteractor.getInstance().isSpaceAvailable(this.mContext)) {
            EventPublishHelper.publishInitialStatusEvent(this.mContext, StatusType.CHECKING_UPDATE);
            promise.resolve("apk_downloading");
        } else {
            promise.resolve("no_storage_available");
        }
    }

    /* access modifiers changed from: private */
    public void publishProgressToReact(int i, String str, String str2, String str3, int i2, int i3, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("publishProgressToReact() called with: progress = [");
        sb.append(i);
        sb.append("], gameIconUrl = [");
        sb.append(str);
        sb.append("], gameName = [");
        GeneratedOutlineSupport.outline103(sb, str2, "], packageName = [", str3, "], gameId = [");
        sb.append(i2);
        sb.append("], serverCode = [");
        sb.append(i3);
        sb.append("], isForceUpdate = [");
        MLogger.d(TAG, GeneratedOutlineSupport.outline66(sb, z, CMapParser.MARK_END_OF_ARRAY));
        if (!Util.isAutoDownloadEnabled(i2)) {
            Bundle bundle = new Bundle();
            bundle.putInt("id", 990);
            bundle.putInt("gameId", i2);
            bundle.putString("gameIconUrl", str);
            bundle.putString("gameName", str2);
            bundle.putString("packageName", str3);
            bundle.putString("serverVersion", String.valueOf(i3));
            bundle.putBoolean("isForceUpdate", z);
            MLogger.d(TAG, "publishProgressToReact: ", Integer.valueOf(i), Integer.valueOf(this.previousProgress), Integer.valueOf(i2));
            if ((i % 2 == 0 || i % 3 == 0 || i % 5 == 0) && i > this.previousProgress) {
                MLogger.d(TAG, "Sending data to react progressResponse: ", Integer.valueOf(i));
                this.previousProgress = i;
                bundle.putInt("progress", i);
                bundle.putString("status", "downloading");
                bundle.putString("notificationStatus", "downloading");
                DownloadProgressReceiver downloadProgressReceiver = MPLReactContainerActivity.resultReceiver;
                if (downloadProgressReceiver != null) {
                    downloadProgressReceiver.send(19, bundle);
                }
            } else if (i >= 100 && i > this.previousProgress) {
                MLogger.d(TAG, "Sending data to react progressResponse: ", Integer.valueOf(i));
                this.previousProgress = i;
                bundle.putInt("progress", i);
                bundle.putString("status", "installing");
                bundle.putString("notificationStatus", "downloading");
                DownloadProgressReceiver downloadProgressReceiver2 = MPLReactContainerActivity.resultReceiver;
                if (downloadProgressReceiver2 != null) {
                    downloadProgressReceiver2.send(19, bundle);
                }
            }
        }
    }

    private void saveDownloadId(int i, int i2, long j) {
        MLogger.d(TAG, "saveDownloadId: ", Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j));
        Context context = this.mContext;
        MSharedPreferencesUtils.saveStringInNormalPref(context, Constant.THIRD_PARTY_APK_GAME_STATUS, i + "_" + i2, String.valueOf(j));
    }

    private void sendDownloadAttribution(ApkInfo apkInfo) {
        try {
            if (getCurrentActivity() != null && apkInfo.getGameId() != null) {
                final int intValue = apkInfo.getGameId().intValue();
                boolean isInstallTrackEnabled = apkInfo.isInstallTrackEnabled();
                final String installTrackUrl = apkInfo.getInstallTrackUrl();
                MLogger.d(TAG, "sendDownloadAttribution:1 ", Integer.valueOf(intValue), Boolean.valueOf(isInstallTrackEnabled), installTrackUrl);
                if (isInstallTrackEnabled && !TextUtils.isEmpty(installTrackUrl)) {
                    getCurrentActivity().runOnUiThread(new Runnable() {
                        public void run() {
                            MLogger.d(GameLaunchHelper.TAG, "sendDownloadAttribution:2 ", Integer.valueOf(intValue));
                            new WebView(GameLaunchHelper.this.getCurrentActivity()).loadUrl(installTrackUrl);
                            MLogger.d(GameLaunchHelper.TAG, "sendDownloadAttribution:3 ", Integer.valueOf(intValue));
                        }
                    });
                }
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "sendDownloadAttribution: ", e2);
        }
    }

    /* access modifiers changed from: private */
    public void sendDownloadCompletedEventToReact(int i) {
        MLogger.d(TAG, "sendDownloadCompletedEventToReact: ");
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("id", 990);
            bundle.putInt("progress", 100);
            bundle.putInt("gameId", i);
            bundle.putString("status", "installing");
            bundle.putString("notificationStatus", "downloading");
            bundle.putString("gameIconUrl", Util.getThirdPartyApkGameIconUrl(i));
            bundle.putString("gameName", Util.getAppNameBasedOnGameId(i));
            bundle.putString("packageName", Util.getPackageNameBasedOnGameId(i));
            bundle.putString("serverVersion", String.valueOf(Util.getThirdPartyApkDownloadVersion(i)));
            if (MPLReactContainerActivity.resultReceiver != null) {
                MPLReactContainerActivity.resultReceiver.send(19, bundle);
            }
            ApkInfo thirdPartyAppInfoBasedOnPackageName = CommonUtils.getThirdPartyAppInfoBasedOnPackageName(Util.getPackageNameBasedOnGameId(i));
            if (thirdPartyAppInfoBasedOnPackageName != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("Game Name", thirdPartyAppInfoBasedOnPackageName.getGameName());
                jSONObject.put("Game Id", thirdPartyAppInfoBasedOnPackageName.getGameId());
                jSONObject.put(AssetsAnalytics.PROP_GAME_DOWNLOAD_SIZE, thirdPartyAppInfoBasedOnPackageName.getSize());
                jSONObject.put(AssetsAnalytics.PROP_GAME_VERSION, thirdPartyAppInfoBasedOnPackageName.getGameVersion());
                jSONObject.put(AssetsAnalytics.PROP_IS_FORCE_UPDATE, thirdPartyAppInfoBasedOnPackageName.getForceUpdate());
                jSONObject.put(AssetsAnalytics.PROP_GAME_PLAYED, Double.parseDouble(thirdPartyAppInfoBasedOnPackageName.getGamePlays()));
                jSONObject.put(AssetsAnalytics.PROP_GAME_INSTALL_COUNT, Double.parseDouble(thirdPartyAppInfoBasedOnPackageName.getInstalls()));
                jSONObject.put("Is Success", true);
                CleverTapAnalyticsUtils.sendEvent((String) AssetsAnalytics.EVENT_GAME_DOWNLOAD_COMPLETED, jSONObject.toString());
            }
        } catch (Exception unused) {
            MLogger.e(TAG, "startProcessForThirdPartyApk: ");
        }
    }

    /* access modifiers changed from: private */
    public void sendDownloadFailedEventToReact(int i) {
        MLogger.d(TAG, "sendDownloadFailedEventToReact: ");
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("id", 990);
            bundle.putInt("progress", 100);
            bundle.putInt("gameId", i);
            bundle.putString("status", "failed");
            bundle.putString("notificationStatus", "failed");
            bundle.putString("gameIconUrl", Util.getThirdPartyApkGameIconUrl(i));
            bundle.putString("gameName", Util.getAppNameBasedOnGameId(i));
            bundle.putString("packageName", Util.getPackageNameBasedOnGameId(i));
            bundle.putString("serverVersion", String.valueOf(Util.getThirdPartyApkDownloadVersion(i)));
            if (MPLReactContainerActivity.resultReceiver != null) {
                MPLReactContainerActivity.resultReceiver.send(19, bundle);
            }
            ApkInfo thirdPartyAppInfoBasedOnPackageName = CommonUtils.getThirdPartyAppInfoBasedOnPackageName(Util.getPackageNameBasedOnGameId(i));
            if (thirdPartyAppInfoBasedOnPackageName != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("Game Name", thirdPartyAppInfoBasedOnPackageName.getGameName());
                jSONObject.put("Game Id", thirdPartyAppInfoBasedOnPackageName.getGameId());
                jSONObject.put(AssetsAnalytics.PROP_GAME_DOWNLOAD_SIZE, thirdPartyAppInfoBasedOnPackageName.getSize());
                jSONObject.put(AssetsAnalytics.PROP_GAME_VERSION, thirdPartyAppInfoBasedOnPackageName.getGameVersion());
                jSONObject.put(AssetsAnalytics.PROP_IS_FORCE_UPDATE, thirdPartyAppInfoBasedOnPackageName.getForceUpdate());
                jSONObject.put(AssetsAnalytics.PROP_GAME_PLAYED, Double.parseDouble(thirdPartyAppInfoBasedOnPackageName.getGamePlays()));
                jSONObject.put(AssetsAnalytics.PROP_GAME_INSTALL_COUNT, Double.parseDouble(thirdPartyAppInfoBasedOnPackageName.getInstalls()));
                jSONObject.put("Is Success", false);
                CleverTapAnalyticsUtils.sendEvent((String) AssetsAnalytics.EVENT_GAME_DOWNLOAD_COMPLETED, jSONObject.toString());
            }
        } catch (Exception unused) {
            MLogger.e(TAG, "startProcessForThirdPartyApk: ");
        }
    }

    private void setGameIdInDatabase(int i, long j) {
        if (getCurrentActivity() != null) {
            String valueOf = String.valueOf(i);
            NotificationDisplayEntryPoint notificationDisplayEntryPoint = (NotificationDisplayEntryPoint) TweetUtils.fromApplication(getCurrentActivity(), NotificationDisplayEntryPoint.class);
            DownloadNotificationDisplayFeature downloadNotificationDisplayFeature = new DownloadNotificationDisplayFeature(notificationDisplayEntryPoint.ioDispatcher(), notificationDisplayEntryPoint.optionalDownloadVisitInsertUseCase(), notificationDisplayEntryPoint.OptionalDownloadVisitUpdateUseCase(), notificationDisplayEntryPoint.optionalDownloadVisitCheckUseCase(), notificationDisplayEntryPoint.optionalDownloadVisitDeleteUseCase());
            downloadNotificationDisplayFeature.runInsertFeature(valueOf, j);
        }
    }

    private void showGameLaunchFailToast(String str, boolean z, boolean z2) {
        String str2;
        Bundle bundle = new Bundle();
        String string = this.mContext.getString(R.string.suspicious_app_detected);
        bundle.putString(NonSealedApkFragment.ARG_DIALOG_TYPE, TYPE.COMMON.name());
        if (z) {
            if (str.startsWith("Developer")) {
                bundle.putString(NonSealedApkFragment.ARG_DIALOG_TYPE, TYPE.DEVELOPER_OPTION.name());
                string = "Developer Options is Enabled";
            } else {
                bundle.putString(NonSealedApkFragment.ARG_DIALOG_TYPE, TYPE.USB_DEBUGGING.name());
                string = "USB debugging is Enabled";
            }
            str2 = "GO to Setting";
        } else {
            str2 = LiveVideoBroadcaster.OK;
        }
        bundle.putBoolean("isDeveloperOptionEnabled", z);
        bundle.putBoolean("isMagnificationEnabled", z2);
        bundle.putString("title", string);
        bundle.putString("message", str);
        bundle.putString(NonSealedApkFragment.ARG_BTN_TITLE, str2);
        if (z2) {
            bundle.putString(NonSealedApkFragment.ARG_DIALOG_TYPE, TYPE.MAGNIFICATION.name());
        }
        DownloadProgressReceiver downloadProgressReceiver = MPLReactContainerActivity.resultReceiver;
        if (downloadProgressReceiver != null) {
            downloadProgressReceiver.send(18, bundle);
        }
    }

    private void showToast(final String str) {
        if (getCurrentActivity() != null) {
            getCurrentActivity().runOnUiThread(new Runnable() {
                public void run() {
                    Toast.makeText(GameLaunchHelper.this.mContext, str, 1).show();
                }
            });
        }
    }

    private void startProcessForThirdPartyApk(int i, String str, int i2, Promise promise, boolean z) {
        int i3 = i;
        int i4 = i2;
        Promise promise2 = promise;
        StringBuilder sb = new StringBuilder();
        sb.append("startProcessForThirdPartyApk() called with: gameId = [");
        sb.append(i3);
        sb.append("], gameName = [");
        sb.append(str);
        sb.append("], serverVersionCode = [");
        sb.append(i4);
        sb.append("], promise = [");
        sb.append(promise2);
        sb.append("], isForceUpdate = [");
        MLogger.d(TAG, GeneratedOutlineSupport.outline66(sb, z, CMapParser.MARK_END_OF_ARRAY));
        String thirdPartyApkGameIconUrl = Util.getThirdPartyApkGameIconUrl(i);
        String packageNameBasedOnGameId = Util.getPackageNameBasedOnGameId(i);
        long j = (long) i4;
        File thirdPartyApkOutputFile = FileUtils.getThirdPartyApkOutputFile(this.mContext, i3, j);
        long downloadId = getDownloadId(i3, j);
        this.mDownloadRequestId = downloadId;
        MLogger.d(TAG, "startProcessForThirdPartyApk: ", Long.valueOf(downloadId), Integer.valueOf(i));
        int apkDownloadStatus = getApkDownloadStatus(this.mDownloadRequestId);
        MLogger.d(TAG, "startProcessForThirdPartyApk: ", Integer.valueOf(apkDownloadStatus));
        long j2 = this.mDownloadRequestId;
        if (j2 == 0 || apkDownloadStatus == -7765) {
            this.previousProgress = 0;
            String thirdPartyApkDownloadUrl = Util.getThirdPartyApkDownloadUrl(i);
            if (TextUtils.isEmpty(thirdPartyApkDownloadUrl)) {
                promise2.resolve("third_party_apk_downloading_failed");
                return;
            }
            long downloadFile = CommonUtils.downloadFile(this.mContext, thirdPartyApkDownloadUrl, thirdPartyApkOutputFile, str, "Downloading...", new IResponseListener<String>() {
                public void onResponseFail(Exception exc) {
                }

                public void progressResponse(long j, long j2, boolean z) {
                }

                public void onResponseSuccess(String str) {
                    MLogger.d(IResponseListener.TAG, "onResponseSuccess:startProcessForThirdPartyApk ", str);
                }
            });
            this.mDownloadRequestId = downloadFile;
            setGameIdInDatabase(i3, downloadFile);
            try {
                ApkInfo thirdPartyAppInfoBasedOnPackageName = CommonUtils.getThirdPartyAppInfoBasedOnPackageName(packageNameBasedOnGameId);
                if (thirdPartyAppInfoBasedOnPackageName != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("Game Name", thirdPartyAppInfoBasedOnPackageName.getGameName());
                    jSONObject.put("Game Id", thirdPartyAppInfoBasedOnPackageName.getGameId());
                    jSONObject.put(AssetsAnalytics.PROP_GAME_DOWNLOAD_SIZE, thirdPartyAppInfoBasedOnPackageName.getSize());
                    jSONObject.put(AssetsAnalytics.PROP_GAME_VERSION, thirdPartyAppInfoBasedOnPackageName.getGameVersion());
                    jSONObject.put(AssetsAnalytics.PROP_IS_FORCE_UPDATE, thirdPartyAppInfoBasedOnPackageName.getForceUpdate());
                    jSONObject.put(AssetsAnalytics.PROP_GAME_PLAYED, Double.parseDouble(thirdPartyAppInfoBasedOnPackageName.getGamePlays()));
                    jSONObject.put(AssetsAnalytics.PROP_GAME_INSTALL_COUNT, Double.parseDouble(thirdPartyAppInfoBasedOnPackageName.getInstalls()));
                    CleverTapAnalyticsUtils.sendEvent((String) AssetsAnalytics.EVENT_GAME_DOWNLOAD_INITIATED, jSONObject.toString());
                }
                sendDownloadAttribution(thirdPartyAppInfoBasedOnPackageName);
            } catch (Exception unused) {
                MLogger.e(TAG, "startProcessForThirdPartyApk: ");
            }
            MSharedPreferencesUtils.saveIntInNormalPref(this.mContext, Constant.THIRD_PARTY_APK_GAME_STATUS, String.valueOf(this.mDownloadRequestId), i3);
            saveDownloadId(i3, i4, this.mDownloadRequestId);
            checkDownloadProgress(i, i2, thirdPartyApkGameIconUrl, str, packageNameBasedOnGameId, this.mDownloadRequestId, z);
            promise2.resolve("third_party_apk_downloading");
            return;
        }
        getThirdPartyApkDownloadProgressStatus(j2, i2, i, promise);
    }

    @ReactMethod
    public void apkDownloadStatus(Promise promise) {
        boolean z;
        int i;
        Promise promise2 = promise;
        MLogger.d(TAG, Constant.APP_UPDATE_CHECK, "apkDownloadStatus:1 ");
        File apkOutputFile = FileUtils.getApkOutputFile(this.mContext, DBInteractor.getAppDownloadProgressVersionCode());
        boolean ApkIntegrityCheck = IntegrityCheck.ApkIntegrityCheck(apkOutputFile);
        MLogger.d(TAG, Constant.APP_UPDATE_CHECK, "apkDownloadStatus:2 ", "outFile:", Boolean.valueOf(apkOutputFile.exists()), "isFileAvailable: ", Boolean.valueOf(ApkIntegrityCheck));
        if (ApkIntegrityCheck) {
            i = (int) apkOutputFile.length();
            z = true;
        } else {
            i = 0;
            z = false;
        }
        MLogger.d(TAG, Constant.APP_UPDATE_CHECK, "apkDownloadStatus:3 ", "isFileDownloaded:", Boolean.valueOf(z), "downloadedSize:", Integer.valueOf(i), "isFileAvailable: ", Boolean.valueOf(ApkIntegrityCheck));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isFileDownloaded", z);
            jSONObject.put("downloadedSize", i);
            jSONObject.put("timeTakenToDownload", MSharedPreferencesUtils.getTimeTakenToDownload());
            promise2.resolve(jSONObject.toString());
        } catch (Exception e2) {
            MLogger.e(TAG, Constant.APP_UPDATE_CHECK, "apkDownloadStatus: ", e2);
            promise2.reject((String) "fail", "JSON Exception: " + e2.getLocalizedMessage());
        }
    }

    @ReactMethod
    public void cancelAssetsDownload(String str) {
        try {
            AllGame gameInfo = getGameInfo(str);
            int intValue = gameInfo.getId().intValue();
            MLogger.d(TAG, "GEInteractor", "cancelAssetsDownload: ", Integer.valueOf(intValue), gameInfo.getName());
            NetworkUtils.cancelRequest(Event.GAME_ASSETS_TAG + CommonUtils.changeToBattleGameId(intValue));
            NetworkUtils.cancelRequest(Event.GAME_ASSETS_TAG + intValue);
            NetworkUtils.cancelRequest("assets_download_v2_" + CommonUtils.changeToBattleGameId(intValue));
            NetworkUtils.cancelRequest("assets_download_v2_" + intValue);
            GEInteractor.getInstance().deleteAssets(this.mContext, intValue);
            GEInteractor.getInstance().deleteAssets(this.mContext, CommonUtils.changeToBattleGameId(intValue));
        } catch (Exception e2) {
            MLogger.e(TAG, "cancelAssetsDownload: ", e2);
        }
    }

    @ReactMethod
    public void cancelInstallNotification() {
        ServiceUtil.clearNotification(this.mContext, ServiceUtil.INSTALL_UPDATE_NOTIF_ID);
    }

    @ReactMethod
    public void cancelThirdPartyGameDownload(String str) {
        try {
            ApkInfo apkInfo = getApkInfo(str);
            int thirdPartyApkDownloadVersion = Util.getThirdPartyApkDownloadVersion(apkInfo);
            int intValue = apkInfo.getGameId().intValue();
            MLogger.d(TAG, "cancelThirdPartyGameDownload: ", Integer.valueOf(intValue), apkInfo.getGameName());
            long j = (long) thirdPartyApkDownloadVersion;
            ((DownloadManager) this.mContext.getSystemService(Constant.DOWNLOAD)).remove(new long[]{getDownloadId(intValue, j)});
            deleteGameDownloadPref(j, intValue);
        } catch (Exception e2) {
            MLogger.e(TAG, "cancelThirdPartyGameDownload: ", e2);
        }
    }

    public boolean checkDeveloperOption(int i) {
        boolean z;
        try {
            if (MSharedPreferencesUtils.isDeveloperOptionCheckEnabled()) {
                boolean isDeveloperOptionEnabled = Util.isDeveloperOptionEnabled(this.mContext);
                HashSet<String> gameIdsListForDebuggingCheck = MSharedPreferencesUtils.getGameIdsListForDebuggingCheck();
                if (isDeveloperOptionEnabled && (gameIdsListForDebuggingCheck.contains(String.valueOf(i)) || gameIdsListForDebuggingCheck.contains(ChannelPipelineCoverage.ALL))) {
                    z = true;
                    MLogger.d(TAG, "checkDeveloperOption: ", Boolean.valueOf(z));
                    return z;
                }
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "checkDeveloperOption: ", e2);
        }
        z = false;
        MLogger.d(TAG, "checkDeveloperOption: ", Boolean.valueOf(z));
        return z;
    }

    @ReactMethod
    public void checkForUpdate() {
        MLogger.d(TAG, "checkForUpdate called");
        AppInitialization.from(this.mContext).checkUpdateAvailableCall(this.mContext, StatusType.CHECKING_UPDATE);
    }

    @ReactMethod
    public void checkIfAssetsInstalledOrNot(String str, Promise promise) {
        MLogger.d("installed apk or not", str);
        JSONArray jSONArray = new JSONArray();
        try {
            JSONArray jSONArray2 = new JSONArray(str);
            int length = jSONArray2.length();
            for (int i = 0; i <= length; i++) {
                int optInt = jSONArray2.optInt(i);
                MLogger.d("installed apk or not", "" + optInt);
                if (GEInteractor.getInstance().isAssetsAvailable(getCurrentActivity().getApplicationContext(), optInt)) {
                    MLogger.d("installedapk or not", optInt + BaseParser.TRUE);
                    jSONArray.put(optInt);
                }
            }
            promise.resolve(jSONArray.toString());
        } catch (Exception e2) {
            promise.reject(e2.getMessage());
            e2.getMessage();
        }
    }

    public boolean checkMagnificationSetting(int i) {
        boolean z;
        try {
            if (ConfigManager.getPlatformConfig() != null && ConfigManager.getPlatformConfig().optBoolean(ConfigConstant.GAME_MAGNIFICATION_OPTION_CHECK_ENABLED, false) && ((MSharedPreferencesUtils.getGameIdsListForMagnificationCheck().contains(String.valueOf(i)) || MSharedPreferencesUtils.getGameIdsListForMagnificationCheck().contains(ChannelPipelineCoverage.ALL)) && Util.isMagnificationSettingEnabled(this.mContext))) {
                z = true;
                MLogger.d(TAG, "checkMagnificationSetting: ", Boolean.valueOf(z));
                return z;
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "checkMagnificationSetting: ", e2);
        }
        z = false;
        MLogger.d(TAG, "checkMagnificationSetting: ", Boolean.valueOf(z));
        return z;
    }

    @ReactMethod
    public void checkManualDownload(Promise promise) {
        int i;
        if (MSharedPreferencesUtils.isUpdateCriticalInUpdaterV2()) {
            i = MSharedPreferencesUtils.getUpdateApkVersion();
        } else {
            i = MBuildConfigUtils.getInstalledAppVersionCode();
        }
        boolean z = MBuildConfigUtils.isCashApp() || MSharedPreferencesUtils.isProAppDownloadRequired();
        int currentDownloadedAppVersionCode = DBInteractor.getCurrentDownloadedAppVersionCode();
        boolean ApkIntegrityCheck = IntegrityCheck.ApkIntegrityCheck(FileUtils.getApkOutputFile(this.mContext, currentDownloadedAppVersionCode));
        boolean isSpaceAvailable = GEInteractor.getInstance().isSpaceAvailable(this.mContext);
        if (!z || (currentDownloadedAppVersionCode >= i && (ApkIntegrityCheck || currentDownloadedAppVersionCode <= MBuildConfigUtils.getInstalledAppVersionCode()))) {
            if (!z && currentDownloadedAppVersionCode < i) {
                promise.resolve("download_from_playstore");
            } else if (ApkIntegrityCheck) {
                promise.resolve("install_downloaded_apk");
            } else {
                promise.resolve("no_update_found");
            }
        } else if (isSpaceAvailable) {
            promise.resolve("apk_downloading");
        } else {
            promise.resolve("no_storage_available");
        }
    }

    @ReactMethod
    public void checkManualDownloadUpdate2(final String str, final Promise promise) {
        try {
            MLogger.d(TAG, "checkManualDownloadUpdate2: ", "isUpdaterV2Enabled:", Boolean.valueOf(MSharedPreferencesUtils.getUpdaterV2Enabled()));
            DownloadHelper.getInstance().getUpdateSummary(new ResponseListener() {
                public void onFailure(String str) {
                    promise.resolve("no_update_found");
                }

                public void onSuccess(String str) {
                    if (MSharedPreferencesUtils.isUpdateAvailableInUpdaterV2()) {
                        int updater2Version = MSharedPreferencesUtils.getUpdater2Version();
                        boolean ApkIntegrityCheck = IntegrityCheck.ApkIntegrityCheck(FileUtils.getApkOutputFile(GameLaunchHelper.this.mContext, updater2Version));
                        boolean isSpaceAvailable = GEInteractor.getInstance().isSpaceAvailable(GameLaunchHelper.this.mContext);
                        if (ApkIntegrityCheck || updater2Version <= MBuildConfigUtils.getInstalledAppVersionCode()) {
                            promise.resolve("install_downloaded_apk");
                        } else if (isSpaceAvailable) {
                            promise.resolve("apk_downloading");
                            MSharedPreferencesUtils.setEntryPoint(str);
                            DBInteractor.setActiveAppVersionCode(updater2Version);
                            DBInteractor.setAppDownloadProgressVersionCode(DBInteractor.getActiveAppVersionCode());
                            ServiceUtil.getInstance().startService(GameLaunchHelper.this.mContext, false);
                            EventPublishHelper.bindServiceEvent(GameLaunchHelper.this.mContext, true);
                        } else {
                            promise.resolve("no_storage_available");
                        }
                    } else {
                        promise.resolve("no_update_found");
                    }
                }
            });
        } catch (Exception unused) {
            promise.resolve("no_update_found");
        }
    }

    public boolean checkUSBDebuggingOption(int i) {
        boolean z;
        try {
            if (MSharedPreferencesUtils.isUsbDebuggingCheckEnabled()) {
                boolean isUsbDebuggingEnabled = Util.isUsbDebuggingEnabled(this.mContext);
                HashSet<String> gameIdsListForDebuggingCheck = MSharedPreferencesUtils.getGameIdsListForDebuggingCheck();
                if (isUsbDebuggingEnabled && (gameIdsListForDebuggingCheck.contains(String.valueOf(i)) || gameIdsListForDebuggingCheck.contains(ChannelPipelineCoverage.ALL))) {
                    z = true;
                    MLogger.d(TAG, "checkUSBDebuggingOption: ", Boolean.valueOf(z));
                    return z;
                }
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "checkUSBDebuggingOption: ", e2);
        }
        z = false;
        MLogger.d(TAG, "checkUSBDebuggingOption: ", Boolean.valueOf(z));
        return z;
    }

    @ReactMethod
    public void deleteAssetByGameId(int i, Promise promise) {
        if (i != 0 && promise != null) {
            GEInteractor.getInstance().deleteAssets(this.mContext, i);
            GEInteractor.getInstance().deleteAssets(this.mContext, i + 1000000);
            promise.resolve("Success");
        }
    }

    @ReactMethod
    public void deleteAssetsAndReDownload(int i, String str, final Promise promise) {
        MLogger.d(TAG, "deleteAssetsAndReDownload: ");
        HashMap hashMap = new HashMap();
        hashMap.put("Game Id", String.valueOf(i));
        hashMap.put("Game Name", str);
        hashMap.put(EventsConstants.USER_MOBILE_NUMBER, CountryUtils.getUniqueIdForThirdPartySDKs());
        hashMap.put(EventsConstants.PARAMS_TRIGGER_REASON, "Asset Bundle Mismatch");
        hashMap.put(EventsConstants.PARAMS_ACTION_TAKEN, "Re-Starting Download");
        hashMap.put(EventsConstants.PARAMS_SOURCE, "GameLauncherHelper");
        hashMap.put("Start Time", String.valueOf(System.currentTimeMillis()));
        CleverTapAnalyticsUtils.sendEvent((String) Constant.EVENT_USER_GAME_FRAUD, hashMap);
        MLogger.d(Constant.ASSETS_CHECKING, "Assets are modified");
        if (!GEInteractor.getInstance().deleteAssets(this.mContext, i)) {
            System.exit(0);
        } else if (AssetsConfigReader.listOfGameAssetsAvailableArray(this.mContext).contains(Integer.valueOf(i))) {
            int gameVersion = AssetsUtils.getGameVersion(i);
            GameAssets gameObjectForAsset = AssetsConfigReader.getGameObjectForAsset(this.mContext, i);
            if (gameObjectForAsset != null) {
                MLogger.d(TAG, "deleteAssetsAndReDownload: ", "serverVersionForGameId: ", Integer.valueOf(gameVersion), "localGameAsset.getGameId: ", Integer.valueOf(gameObjectForAsset.getGameId()), "localGameAsset.getAssetVersion: ", Integer.valueOf(gameObjectForAsset.getAssetVersion()), "localGameAsset.getGameVersion: ", Integer.valueOf(gameObjectForAsset.getGameVersion()));
                if (gameVersion > gameObjectForAsset.getAssetVersion()) {
                    MLogger.d(TAG, "deleteAssetsAndReDownload: Pre bundle game assets version is not matching, Downloading again");
                    promise.resolve("game_assets_downloading");
                    return;
                }
                GEInteractor.getInstance().initializeGameAssetsFirstTime(this.mContext, new RNListener() {
                    public boolean isHasRequiredPermission() {
                        return false;
                    }

                    public void publishResult(String str) {
                        if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("Success")) {
                            promise.resolve("launch_game");
                        }
                    }
                });
            }
        } else if (!GEInteractor.getInstance().isAssetsAvailable(this.mContext, i)) {
            promise.resolve("game_assets_downloading");
        } else {
            MLogger.d(Constant.ASSETS_CHECKING, "Assets are present");
        }
    }

    @ReactMethod
    public void downloadFromPlaystore() {
        MLogger.d(TAG, "downloadFromPlaystore called");
        Util.openAppInPlayStore(this.mContext);
    }

    @ReactMethod
    public void downloadGameAssets(String str, Promise promise) {
        processAssetsDownloadFlow(getGameInfo(str), promise);
    }

    @ReactMethod
    public void downloadGameAssetsByGameId(int i, String str, int i2, Promise promise) {
        boolean isCurrentlyDownloadingAssets = AssetsUtils.isCurrentlyDownloadingAssets(i);
        MLogger.d(TAG, "downloadGameAssetsByGameId() called with: gameId = [" + i + "], gameName = [" + str + "], tournamentId = [" + i2 + "], isDownloading = [" + isCurrentlyDownloadingAssets + CMapParser.MARK_END_OF_ARRAY);
        if (GEInteractor.getInstance().isSpaceAvailable(this.mContext)) {
            GEInteractor.getInstance().downloadGameAssets(this.mContext, i, i2);
            promise.resolve("game_assets_downloading_progress");
            return;
        }
        promise.resolve("no_storage_available");
    }

    @ReactMethod
    public void downloadThirdPartyGameApk(int i, Promise promise) {
        int i2 = i;
        Promise promise2 = promise;
        MLogger.d(TAG, "downloadThirdPartyGameApk: ", Integer.valueOf(i));
        if (!Util.isGameSupportedForDevice(this.mContext, i2)) {
            MLogger.d(TAG, "downloadThirdPartyGameApk: device does not support for this apk");
            promise2.resolve("device_does_not_support");
            return;
        }
        int thirdPartyApkDownloadSpaceRequired = Util.getThirdPartyApkDownloadSpaceRequired(i);
        if (!GEInteractor.getInstance().isSpaceAvailableToInstallApp(this.mContext, thirdPartyApkDownloadSpaceRequired)) {
            MLogger.d(TAG, "downloadThirdPartyGameApk: Low Storage");
            promise2.resolve("third_party_no_storage_available");
        } else if (!Util.isGameSupportedMinVersion(i) && !GEInteractor.getInstance().isGameCodeAvailable(this.mContext, i2)) {
            MLogger.d(TAG, "downloadThirdPartyGameApk: This game does not support min version fail");
            if (DBInteractor.getCurrentDownloadedAppVersionCode() > MBuildConfigUtils.getInstalledAppVersionCode()) {
                promise2.resolve("install_downloaded_apk");
            } else if (MBuildConfigUtils.isCashApp() || MSharedPreferencesUtils.isProAppDownloadRequired()) {
                if (GEInteractor.getInstance().isSpaceAvailableToInstallApp(this.mContext, thirdPartyApkDownloadSpaceRequired)) {
                    EventPublishHelper.publishInitialStatusEvent(this.mContext, StatusType.CHECKING_UPDATE);
                    promise2.resolve("apk_downloading");
                } else {
                    promise2.resolve("third_party_no_storage_available");
                }
            }
        } else if (!Util.isGameSignatureMatched(this.mContext, i2)) {
            MLogger.d(TAG, "getThirdPartyGameApkStatus:: Signature mismatch ", Integer.valueOf(i));
            promise2.resolve("third_party_apk_signature_mismatched");
        } else {
            int thirdPartyApkDownloadVersion = Util.getThirdPartyApkDownloadVersion(i);
            String appNameBasedOnGameId = Util.getAppNameBasedOnGameId(i);
            String packageNameBasedOnGameId = Util.getPackageNameBasedOnGameId(i);
            boolean appInstalledOrNot = Util.appInstalledOrNot(this.mContext, packageNameBasedOnGameId);
            boolean isPlayStoreThirdPartyApp = Util.isPlayStoreThirdPartyApp(i);
            boolean isOriginalsApp = Util.isOriginalsApp(i);
            boolean isForceUpdate = Util.isForceUpdate(i);
            if (appInstalledOrNot) {
                long installedApkVersion = Util.getInstalledApkVersion(this.mContext, packageNameBasedOnGameId);
                MLogger.d(TAG, "downloadThirdPartyGameApk: ", Long.valueOf(installedApkVersion), Integer.valueOf(thirdPartyApkDownloadVersion));
                long j = (long) thirdPartyApkDownloadVersion;
                if (j <= installedApkVersion) {
                    try {
                        Util.deleteRecursive(FileUtils.getThirdPartyAppDownloadDir(this.mContext, i2, j));
                    } catch (IOException e2) {
                        MLogger.printStackTrace(e2);
                    }
                    promise2.resolve("third_party_download_error");
                } else if (isPlayStoreThirdPartyApp || isOriginalsApp) {
                    MLogger.d(TAG, "downloadThirdPartyGameApk: not installed should redirect to isPlayStoreApp");
                    launchPlayStore(i, promise);
                } else {
                    MLogger.d(TAG, "downloadThirdPartyGameApk: version mismatch downloading again");
                    startProcessForThirdPartyApk(i, appNameBasedOnGameId, thirdPartyApkDownloadVersion, promise, isForceUpdate);
                }
            } else if (isPlayStoreThirdPartyApp || isOriginalsApp) {
                MLogger.d(TAG, "downloadThirdPartyGameApk: not installed should redirect to playstore");
                launchPlayStore(i, promise);
            } else {
                MLogger.d(TAG, "downloadThirdPartyGameApk: not installed");
                startProcessForThirdPartyApk(i, appNameBasedOnGameId, thirdPartyApkDownloadVersion, promise, isForceUpdate);
            }
        }
    }

    @ReactMethod
    public void downloadThirdPartyGameApkConfig(String str, Promise promise) {
        MLogger.d(TAG, "downloadThirdPartyGameApkConfig: ", str);
        ApkInfo apkInfo = getApkInfo(str);
        if (apkInfo == null) {
            promise.reject((String) "fail", (String) "Fail to parse json");
            return;
        }
        MLogger.d(TAG, "downloadThirdPartyGameApkConfig: ", apkInfo.getGameId());
        if (!Util.isGameSupportedForDevice(this.mContext, apkInfo)) {
            MLogger.d(TAG, "downloadThirdPartyGameApkConfig: device does not support for this apk");
            promise.resolve("device_does_not_support");
            return;
        }
        int thirdPartyApkDownloadSpaceRequired = Util.getThirdPartyApkDownloadSpaceRequired(apkInfo);
        if (!GEInteractor.getInstance().isSpaceAvailableToInstallApp(this.mContext, thirdPartyApkDownloadSpaceRequired)) {
            MLogger.d(TAG, "downloadThirdPartyGameApkConfig: Low Storage");
            promise.resolve("third_party_no_storage_available");
        } else if (!Util.isGameSupportedMinVersion(apkInfo) && !GEInteractor.getInstance().isGameCodeAvailable(this.mContext, apkInfo.getGameId().intValue())) {
            MLogger.d(TAG, "downloadThirdPartyGameApkConfig: This game does not support min version fail");
            if (DBInteractor.getCurrentDownloadedAppVersionCode() > MBuildConfigUtils.getInstalledAppVersionCode()) {
                promise.resolve("install_downloaded_apk");
            } else if (MBuildConfigUtils.isCashApp() || MSharedPreferencesUtils.isProAppDownloadRequired()) {
                if (GEInteractor.getInstance().isSpaceAvailableToInstallApp(this.mContext, thirdPartyApkDownloadSpaceRequired)) {
                    EventPublishHelper.publishInitialStatusEvent(this.mContext, StatusType.CHECKING_UPDATE);
                    promise.resolve("apk_downloading");
                } else {
                    promise.resolve("third_party_no_storage_available");
                }
            }
        } else if (!Util.isGameSignatureMatched(this.mContext, apkInfo)) {
            MLogger.d(TAG, "downloadThirdPartyGameApkConfig:: Signature mismatch ", apkInfo);
            promise.resolve("third_party_apk_signature_mismatched");
        } else {
            int parseInt = Integer.parseInt(apkInfo.getGameVersion());
            apkInfo.getGameName();
            String packageName = apkInfo.getPackageName();
            boolean appInstalledOrNot = Util.appInstalledOrNot(this.mContext, packageName);
            boolean isPlayStoreThirdPartyApp = Util.isPlayStoreThirdPartyApp(apkInfo);
            boolean isOriginals = Util.isOriginals(apkInfo);
            if (appInstalledOrNot) {
                long installedApkVersion = Util.getInstalledApkVersion(this.mContext, packageName);
                MLogger.d(TAG, "downloadThirdPartyGameApkConfig: ", Long.valueOf(installedApkVersion), Integer.valueOf(parseInt));
                long j = (long) parseInt;
                if (j <= installedApkVersion) {
                    try {
                        Util.deleteRecursive(FileUtils.getThirdPartyAppDownloadDir(this.mContext, apkInfo.getGameId().intValue(), j));
                    } catch (IOException e2) {
                        MLogger.printStackTrace(e2);
                    }
                    promise.resolve("third_party_download_error");
                } else if (isPlayStoreThirdPartyApp || isOriginals) {
                    MLogger.d(TAG, "downloadThirdPartyGameApkConfig: not installed should redirect to isPlayStoreApp");
                    launchPlayStore(apkInfo.getGameId().intValue(), promise);
                } else {
                    MLogger.d(TAG, "downloadThirdPartyGameApkConfig: version mismatch downloading again");
                    startProcessForThirdPartyApk(apkInfo, promise);
                }
            } else if (isPlayStoreThirdPartyApp || isOriginals) {
                MLogger.d(TAG, "downloadThirdPartyGameApkConfig: not installed should redirect to playstore");
                launchPlayStore(apkInfo.getGameId().intValue(), promise);
            } else {
                MLogger.d(TAG, "downloadThirdPartyGameApkConfig: not installed");
                startProcessForThirdPartyApk(apkInfo, promise);
            }
        }
    }

    @ReactMethod
    public void getAssetsAvailableStatus(String str) {
        boolean z;
        boolean z2 = true;
        boolean z3 = false;
        MLogger.d(TAG, "getAssetsAvailableStatus: ");
        try {
            AllGame gameInfo = getGameInfo(str);
            boolean z4 = (gameInfo == null || gameInfo.getGameConfigGameInfo() == null || gameInfo.getGameConfigGameInfo().getApkInfo() == null) ? false : true;
            MLogger.d(TAG, "getAssetsAvailableStatus: ", Boolean.valueOf(z4));
            if (!z4 && gameInfo != null) {
                boolean booleanValue = gameInfo.getIsTournamentSupported().booleanValue();
                boolean booleanValue2 = gameInfo.getIsBattleSupported().booleanValue();
                int intValue = gameInfo.getId().intValue() % 1000000;
                String name = gameInfo.getName();
                MLogger.d(TAG, "checkForAssetsMerging: ", "isTournamentSupported: ", Boolean.valueOf(booleanValue), "isBattleSupported: ", Boolean.valueOf(booleanValue2), "gameId: ", Integer.valueOf(intValue), "gameName: ", name);
                boolean isBundleMergeFlow = AssetsUtils.isBundleMergeFlow();
                AssetsAnalyticsProps assetsAnalyticsProps = new AssetsAnalyticsProps();
                if (booleanValue && booleanValue2) {
                    boolean isAssetsAvailable = GEInteractor.getInstance().isAssetsAvailable(this.mContext, intValue);
                    boolean isAssetsAvailable2 = GEInteractor.getInstance().isAssetsAvailable(this.mContext, CommonUtils.changeToBattleGameId(intValue));
                    MLogger.d(TAG, "checkForAssetsMerging: ", "isTournamentAssetsAvailable: ", Boolean.valueOf(isAssetsAvailable), "isBattleAssetsAvailable: ", Boolean.valueOf(isAssetsAvailable2));
                    if (AssetsUtils.isMergedAssetsAreDownloaded(CommonUtils.changeToBattleGameId(intValue))) {
                        z = GEInteractor.getInstance().isAssetsAvailable(this.mContext, CommonUtils.changeToBattleGameId(intValue));
                        if (z) {
                            assetsAnalyticsProps.setLatest(AssetsUtils.isGameAssetsVersionValid(MPLApplication.getInstance(), CommonUtils.changeToBattleGameId(intValue)));
                        }
                    } else {
                        z = isAssetsAvailable && isAssetsAvailable2;
                        if (z) {
                            boolean isGameAssetsVersionValid = AssetsUtils.isGameAssetsVersionValid(MPLApplication.getInstance(), intValue);
                            boolean isGameAssetsVersionValid2 = AssetsUtils.isGameAssetsVersionValid(MPLApplication.getInstance(), CommonUtils.changeToBattleGameId(intValue));
                            if (!isGameAssetsVersionValid || !isGameAssetsVersionValid2) {
                                z2 = false;
                            }
                            assetsAnalyticsProps.setLatest(z2);
                        }
                    }
                    z3 = z;
                } else if (booleanValue) {
                    boolean isAssetsAvailable3 = GEInteractor.getInstance().isAssetsAvailable(this.mContext, intValue);
                    if (!isAssetsAvailable3 && isBundleMergeFlow) {
                        isAssetsAvailable3 = GEInteractor.getInstance().isAssetsAvailable(this.mContext, CommonUtils.changeToBattleGameId(intValue));
                    }
                    z3 = isAssetsAvailable3;
                    if (z3) {
                        assetsAnalyticsProps.setLatest(AssetsUtils.isGameAssetsVersionValid(MPLApplication.getInstance(), intValue));
                    }
                } else if (booleanValue2) {
                    z3 = GEInteractor.getInstance().isAssetsAvailable(this.mContext, CommonUtils.changeToBattleGameId(intValue));
                    if (z3) {
                        assetsAnalyticsProps.setLatest(AssetsUtils.isGameAssetsVersionValid(MPLApplication.getInstance(), CommonUtils.changeToBattleGameId(intValue)));
                    }
                }
                assetsAnalyticsProps.setAlreadyDownloaded(z3);
                assetsAnalyticsProps.setAssetsType("Assets");
                assetsAnalyticsProps.setGameName(name);
                assetsAnalyticsProps.setGameId(intValue);
                AssetsAnalytics.sendGameFileStatusEvent(assetsAnalyticsProps);
            }
        } catch (Exception unused) {
        }
    }

    @ReactMethod
    public void getGameStatus(int i, String str, final Promise promise) {
        MLogger.d(TAG, "getGameStatus: ", Integer.valueOf(i), str);
        try {
            if (checkDeveloperOption(i)) {
                promise.reject((String) "fail", (String) "game_check_fail");
                showGameLaunchFailToast("Developer Option is ON.\nPlease disable it from setting and try again", true, false);
            } else if (checkUSBDebuggingOption(i)) {
                promise.reject((String) "fail", (String) "game_check_fail");
                showGameLaunchFailToast("USB Debugging is ON.\nPlease disable it from setting and try again", true, false);
            } else {
                String checkTamperedAppInstalled = checkTamperedAppInstalled(i);
                if (!TextUtils.isEmpty(checkTamperedAppInstalled)) {
                    promise.reject((String) "fail", (String) "game_check_fail");
                    showGameLaunchFailToast(checkTamperedAppInstalled, false, false);
                } else if (checkMagnificationSetting(i)) {
                    promise.reject((String) "fail", (String) "game_check_fail");
                    showGameLaunchFailToast("Screen Magnification setting is Enabled.\nPlease turn it off from Setting -> Accessibility and relaunch app", false, true);
                } else {
                    if (!MSharedPreferencesUtils.getGamesWithoutAssetsDownload().contains(String.valueOf(i))) {
                        if (!(CommonUtils.getGameInfo(Integer.valueOf(i)) == null || CommonUtils.getGameInfo(Integer.valueOf(i)).getGameConfigGameInfo() == null || CommonUtils.getGameInfo(Integer.valueOf(i)).getGameConfigGameInfo().getApkInfo() == null)) {
                            if (!CommonUtils.getGameInfo(Integer.valueOf(i)).getGameConfigGameInfo().getApkInfo().isThirdParty() && !CommonUtils.getGameInfo(Integer.valueOf(i)).getGameConfigGameInfo().getApkInfo().isWebSupport() && !CommonUtils.getGameInfo(Integer.valueOf(i)).getGameConfigGameInfo().getApkInfo().isThirdPartyMatchMaking()) {
                                if (CommonUtils.getGameInfo(Integer.valueOf(i)).getGameConfigGameInfo().getApkInfo().isWebSupportMatchMaking()) {
                                }
                            }
                        }
                        MLogger.d(TAG, "getGameStatus: checking Already given game ids");
                        if (!GEInteractor.getInstance().isGameCodeAvailable(this.mContext, i)) {
                            if (DBInteractor.getCurrentDownloadedAppVersionCode() > MBuildConfigUtils.getInstalledAppVersionCode()) {
                                promise.resolve("install_downloaded_apk");
                            } else {
                                if (!MBuildConfigUtils.isCashApp()) {
                                    if (!MSharedPreferencesUtils.isProAppDownloadRequired()) {
                                        promise.resolve("download_from_playstore");
                                    }
                                }
                                if (GEInteractor.getInstance().isSpaceAvailable(this.mContext)) {
                                    EventPublishHelper.publishInitialStatusEvent(this.mContext, StatusType.CHECKING_UPDATE);
                                    promise.resolve("apk_downloading");
                                } else {
                                    promise.resolve("no_storage_available");
                                }
                            }
                        } else if (!GEInteractor.getInstance().isAssetsAvailable(this.mContext, i)) {
                            if (AssetsConfigReader.listOfGameAssetsAvailableArray(this.mContext).contains(Integer.valueOf(i))) {
                                GEInteractor.getInstance().initializeGameAssetsFirstTime(this.mContext, new RNListener() {
                                    public boolean isHasRequiredPermission() {
                                        return false;
                                    }

                                    public void publishResult(String str) {
                                        if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("Success")) {
                                            promise.resolve("launch_game");
                                        }
                                    }
                                });
                            } else {
                                boolean isCurrentlyDownloadingAssets = AssetsUtils.isCurrentlyDownloadingAssets(i);
                                MLogger.d(TAG, "getGameStatus: ", Boolean.valueOf(isCurrentlyDownloadingAssets));
                                if (isCurrentlyDownloadingAssets) {
                                    promise.resolve("game_assets_downloading_progress");
                                } else {
                                    promise.resolve("game_assets_downloading");
                                }
                            }
                        } else if (GEInteractor.isValidGameAssets(getReactApplicationContext().getApplicationContext(), i, false, "", AssetsUtils.isAssetsDirectoryCheckEnabled())) {
                            promise.resolve("launch_game");
                        } else {
                            deleteAssetsAndReDownload(i, str, promise);
                        }
                    }
                    MLogger.d(TAG, "getGameStatus: checking third parties apks");
                    String packageNameBasedOnGameId = Util.getPackageNameBasedOnGameId(i);
                    if (TextUtils.isEmpty(packageNameBasedOnGameId)) {
                        promise.resolve("launch_game");
                    } else {
                        boolean appInstalledOrNot = Util.appInstalledOrNot(this.mContext, packageNameBasedOnGameId);
                        long thirdPartyApkDownloadVersion = (long) Util.getThirdPartyApkDownloadVersion(i);
                        if (appInstalledOrNot) {
                            long installedApkVersion = Util.getInstalledApkVersion(this.mContext, packageNameBasedOnGameId);
                            MLogger.d(TAG, "getGameStatus: ", Long.valueOf(installedApkVersion), Long.valueOf(thirdPartyApkDownloadVersion));
                            if (thirdPartyApkDownloadVersion <= installedApkVersion) {
                                Util.deleteRecursive(FileUtils.getThirdPartyAppDownloadDir(this.mContext, i, thirdPartyApkDownloadVersion));
                                promise.resolve("launch_game");
                            } else {
                                downloadThirdPartyGameApk(i, promise);
                            }
                        } else {
                            downloadThirdPartyGameApk(i, promise);
                        }
                    }
                }
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "getGameStatus", e2);
        }
    }

    @ReactMethod
    public void getGameStatusV2(String str, Promise promise) {
        try {
            AllGame gameInfo = getGameInfo(str);
            int intValue = gameInfo.getId().intValue();
            String name = gameInfo.getName();
            MLogger.d(TAG, "getGameStatusV2: ", "gameId:", Integer.valueOf(intValue), "gameName:", name);
            if (checkDeveloperOption(intValue)) {
                promise.reject((String) "fail", (String) "game_check_fail");
                showGameLaunchFailToast("Developer Option is ON.\nPlease disable it from setting and try again", true, false);
            } else if (checkUSBDebuggingOption(intValue)) {
                promise.reject((String) "fail", (String) "game_check_fail");
                showGameLaunchFailToast("USB Debugging is ON.\nPlease disable it from setting and try again", true, false);
            } else {
                String checkTamperedAppInstalled = checkTamperedAppInstalled(intValue);
                if (!TextUtils.isEmpty(checkTamperedAppInstalled)) {
                    promise.reject((String) "fail", (String) "game_check_fail");
                    showGameLaunchFailToast(checkTamperedAppInstalled, false, false);
                } else if (checkMagnificationSetting(intValue)) {
                    promise.reject((String) "fail", (String) "game_check_fail");
                    showGameLaunchFailToast("Screen Magnification setting is Enabled.\nPlease turn it off from Setting -> Accessibility and relaunch app", false, true);
                } else {
                    if (AssetsUtils.isMergedAssetsAreDownloaded(intValue)) {
                        intValue = CommonUtils.changeToBattleGameId(intValue);
                    }
                    checkForAssetsMerging(gameInfo);
                    if (!MSharedPreferencesUtils.getGamesWithoutAssetsDownload().contains(String.valueOf(intValue))) {
                        if (!(gameInfo.getGameConfigGameInfo() == null || gameInfo.getGameConfigGameInfo().getApkInfo() == null)) {
                            if (!gameInfo.getGameConfigGameInfo().getApkInfo().isThirdParty() && !gameInfo.getGameConfigGameInfo().getApkInfo().isWebSupport() && !gameInfo.getGameConfigGameInfo().getApkInfo().isThirdPartyMatchMaking()) {
                                if (gameInfo.getGameConfigGameInfo().getApkInfo().isWebSupportMatchMaking()) {
                                }
                            }
                        }
                        MLogger.d(TAG, "getGameStatusV2: checking Already given game ids");
                        if (!GEInteractor.getInstance().isGameCodeAvailable(this.mContext, intValue)) {
                            processMPLUpdateFlow(promise);
                        } else if (!checkForAssetsMerging(gameInfo)) {
                            processAssetsDownloadFlow(gameInfo, promise);
                        } else if (GEInteractor.isValidGameAssets(getReactApplicationContext().getApplicationContext(), intValue, false, "", AssetsUtils.isAssetsDirectoryCheckEnabled())) {
                            promise.resolve("launch_game");
                        } else {
                            deleteAssetsAndReDownload(intValue, name, promise);
                        }
                    }
                    MLogger.d(TAG, "getGameStatusV2: checking third parties apks");
                    String packageNameBasedOnGameId = Util.getPackageNameBasedOnGameId(intValue);
                    if (TextUtils.isEmpty(packageNameBasedOnGameId)) {
                        promise.resolve("launch_game");
                    } else {
                        boolean appInstalledOrNot = Util.appInstalledOrNot(this.mContext, packageNameBasedOnGameId);
                        long thirdPartyApkDownloadVersion = (long) Util.getThirdPartyApkDownloadVersion(intValue);
                        if (appInstalledOrNot) {
                            long installedApkVersion = Util.getInstalledApkVersion(this.mContext, packageNameBasedOnGameId);
                            MLogger.d(TAG, "getGameStatusV2: ", Long.valueOf(installedApkVersion), Long.valueOf(thirdPartyApkDownloadVersion));
                            if (thirdPartyApkDownloadVersion <= installedApkVersion) {
                                Util.deleteRecursive(FileUtils.getThirdPartyAppDownloadDir(this.mContext, intValue, thirdPartyApkDownloadVersion));
                                promise.resolve("launch_game");
                            } else {
                                downloadThirdPartyGameApk(intValue, promise);
                            }
                        } else {
                            downloadThirdPartyGameApk(intValue, promise);
                        }
                    }
                }
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "getGameStatusV2", e2);
        }
    }

    @ReactMethod
    public void getInstalledMPLGames(String str, Promise promise) {
        boolean z;
        String str2 = str;
        Promise promise2 = promise;
        if (str2 == null || TextUtils.isEmpty(str)) {
            promise2.reject((String) "fail", (String) "games string are empty");
            return;
        }
        boolean z2 = true;
        try {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray(str2);
            int length = jSONArray2.length();
            if (getCurrentActivity() != null) {
                int i = 0;
                while (i < length) {
                    JSONObject optJSONObject = jSONArray2.optJSONObject(i);
                    String optString = optJSONObject.optString("gameInfo");
                    int optInt = optJSONObject.optInt("id");
                    if (TextUtils.isEmpty(optString) || optString.length() <= 3) {
                        addAssetsInstalledAndUpdateAvailableToJson(jSONArray, optInt, optJSONObject);
                    } else {
                        String optString2 = new JSONObject(optString).optString("apkInfo");
                        if (TextUtils.isEmpty(optString2) || optString2.length() <= 3) {
                            addAssetsInstalledAndUpdateAvailableToJson(jSONArray, optInt, optJSONObject);
                        } else {
                            JSONObject jSONObject = new JSONObject(optString2);
                            if (Util.appInstalledOrNot(getCurrentActivity().getApplicationContext(), jSONObject.optString("packageName"))) {
                                optJSONObject.put("isGameInstalled", z2);
                                long installedApkVersion = Util.getInstalledApkVersion(getCurrentActivity().getApplicationContext(), jSONObject.optString("packageName"));
                                if (installedApkVersion != 0) {
                                    if (Long.parseLong(jSONObject.optString("gameVersion")) > installedApkVersion) {
                                        z = true;
                                        optJSONObject.put("isUpdateAvailable", z);
                                        optJSONObject.put("gameVersion", installedApkVersion);
                                        jSONArray.put(optJSONObject);
                                    }
                                }
                                z = false;
                                optJSONObject.put("isUpdateAvailable", z);
                                optJSONObject.put("gameVersion", installedApkVersion);
                                jSONArray.put(optJSONObject);
                            }
                        }
                    }
                    i++;
                    z2 = true;
                }
                promise2.resolve(jSONArray.toString());
                return;
            }
            promise2.reject((String) "fail", (String) "Current activity is null");
        } catch (Exception e2) {
            MLogger.d(TAG, GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("error in getInstalledMPLGames: ")));
            promise2.reject((String) "fail", (String) "Fail to parse json");
        }
    }

    public String getName() {
        return TAG;
    }

    @ReactMethod
    public void getReleaseNotes(Promise promise) {
        if (getCurrentActivity() != null) {
            promise.resolve(MSharedPreferencesUtils.getStringInNormalPref(getCurrentActivity(), Response.RELEASE_NOTES, ""));
        }
    }

    @ReactMethod
    public void getThirdPartyGameApkStatus(int i, int i2, String str, Promise promise) {
        Throwable th;
        FileOutputStream fileOutputStream;
        Throwable th2;
        int i3 = i;
        Promise promise2 = promise;
        MLogger.d(TAG, "getThirdPartyGameApkStatus: ");
        try {
            if (!TextUtils.isEmpty(str) && CommonUtils.isJSONValid(str)) {
                OriginalGameConstant originalGameConstant = (OriginalGameConstant) new Gson().fromJson(str, OriginalGameConstant.class);
                if (originalGameConstant != null) {
                    mOriginals.put(Integer.valueOf(i), originalGameConstant);
                }
            }
        } catch (Exception unused) {
        }
        if (checkDeveloperOption(i)) {
            promise2.reject((String) "fail", (String) "game_check_fail");
            showGameLaunchFailToast("Developer Option is ON.\nPlease disable it from setting and try again", true, false);
            return;
        } else if (checkUSBDebuggingOption(i)) {
            promise2.reject((String) "fail", (String) "game_check_fail");
            showGameLaunchFailToast("USB Debugging is ON.\nPlease disable it from setting and try again", true, false);
            return;
        } else {
            String checkTamperedAppInstalled = checkTamperedAppInstalled(i);
            if (!TextUtils.isEmpty(checkTamperedAppInstalled)) {
                promise2.reject((String) "fail", (String) "game_check_fail");
                showGameLaunchFailToast(checkTamperedAppInstalled, false, false);
                return;
            } else if (checkMagnificationSetting(i)) {
                promise2.reject((String) "fail", (String) "game_check_fail");
                return;
            } else if (!Util.isGameSupportedForDevice(this.mContext, i3)) {
                MLogger.d(TAG, "getThirdPartyGameApkStatus: device does not support for this apk");
                promise2.resolve("device_does_not_support");
                return;
            } else {
                int thirdPartyApkDownloadSpaceRequired = Util.getThirdPartyApkDownloadSpaceRequired(i);
                if (!GEInteractor.getInstance().isSpaceAvailableToInstallApp(this.mContext, thirdPartyApkDownloadSpaceRequired)) {
                    MLogger.d(TAG, "getThirdPartyGameApkStatus: Low Storage");
                    promise2.resolve("third_party_no_storage_available");
                    return;
                } else if (!Util.isGameSupportedMinVersion(i) && !GEInteractor.getInstance().isGameCodeAvailable(this.mContext, i3)) {
                    MLogger.d(TAG, "getThirdPartyGameApkStatus: This game does not support min version fail");
                    if (DBInteractor.getCurrentDownloadedAppVersionCode() > MBuildConfigUtils.getInstalledAppVersionCode()) {
                        promise2.resolve("install_downloaded_apk");
                    } else if (MBuildConfigUtils.isCashApp() || MSharedPreferencesUtils.isProAppDownloadRequired()) {
                        if (GEInteractor.getInstance().isSpaceAvailableToInstallApp(this.mContext, thirdPartyApkDownloadSpaceRequired)) {
                            EventPublishHelper.publishInitialStatusEvent(this.mContext, StatusType.CHECKING_UPDATE);
                            promise2.resolve("apk_downloading");
                        } else {
                            promise2.resolve("third_party_no_storage_available");
                        }
                    }
                    return;
                } else if (!Util.isGameSignatureMatched(this.mContext, i3)) {
                    MLogger.d(TAG, "getThirdPartyGameApkStatus:: Signature mismatch ", Integer.valueOf(i));
                    promise2.resolve("third_party_apk_signature_mismatched");
                    return;
                } else {
                    long j = (long) i2;
                    long downloadId = getDownloadId(i3, j);
                    MLogger.d(TAG, "getThirdPartyGameApkStatus:", "downloadRequestId ", Long.valueOf(downloadId), "gameId: ", Integer.valueOf(i), "serverVersionCode: ", Integer.valueOf(i2));
                    if (!Util.isAssetsAvailable(this.mContext, "", Constant.MPL_PRE_BUILD_APK_FILE_NAME) || MBuildConfigUtils.getLaunchingGameId() != i3) {
                        MLogger.d(TAG, "getThirdPartyGameApkStatus:This is not pre bundled apk, Downloading Now");
                        if (downloadId != 0) {
                            int apkDownloadStatus = getApkDownloadStatus(downloadId);
                            MLogger.d(TAG, "getThirdPartyGameApkStatus: ", Integer.valueOf(apkDownloadStatus));
                            if (apkDownloadStatus == -7765) {
                                promise2.resolve("third_party_apk_download");
                            } else {
                                getThirdPartyApkDownloadProgressStatus(downloadId, i2, i, promise);
                            }
                        } else {
                            MLogger.d(TAG, "getThirdPartyGameApkStatus:Sending event for download ");
                            if (Util.showDownloadPopUp(i)) {
                                promise2.resolve("third_party_apk_download");
                            } else {
                                launchPlayStore(i3, promise2);
                            }
                        }
                    } else {
                        MLogger.d(TAG, "getThirdPartyGameApkStatus:This is pre bundled apk,Extracting Now");
                        try {
                            InputStream open = this.mContext.getResources().getAssets().open(Constant.MPL_PRE_BUILD_APK_FILE_NAME);
                            try {
                                fileOutputStream = new FileOutputStream(FileUtils.getThirdPartyApkOutputFile(this.mContext, i3, j));
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = open.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, read);
                                }
                                promise2.resolve("install_downloaded_third_party_apk");
                                fileOutputStream.close();
                                open.close();
                            } catch (Throwable th3) {
                                th = th3;
                                if (open != null) {
                                    open.close();
                                }
                                throw th;
                            }
                        } catch (Exception unused2) {
                            if (downloadId != 0) {
                                int apkDownloadStatus2 = getApkDownloadStatus(downloadId);
                                MLogger.d(TAG, "getThirdPartyGameApkStatus: ", Integer.valueOf(apkDownloadStatus2));
                                if (apkDownloadStatus2 == -7765) {
                                    promise2.resolve("third_party_apk_download");
                                } else {
                                    getThirdPartyApkDownloadProgressStatus(downloadId, i2, i, promise);
                                }
                            } else {
                                MLogger.d(TAG, "getThirdPartyGameApkStatus:Sending event for download ");
                                if (Util.showDownloadPopUp(i)) {
                                    promise2.resolve("third_party_apk_download");
                                } else {
                                    launchPlayStore(i3, promise2);
                                }
                            }
                        } catch (Throwable th4) {
                            th.addSuppressed(th4);
                        }
                    }
                    return;
                }
            }
        }
        throw th2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:93:0x022d A[SYNTHETIC, Splitter:B:93:0x022d] */
    @com.facebook.react.bridge.ReactMethod
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getThirdPartyGameApkStatusConfig(java.lang.String r19, com.facebook.react.bridge.Promise r20) {
        /*
            r18 = this;
            r7 = r18
            r0 = r19
            r6 = r20
            r1 = 2
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r3 = 0
            java.lang.String r4 = "getThirdPartyGameApkStatusConfig: "
            r2[r3] = r4
            r5 = 1
            r2[r5] = r0
            java.lang.String r8 = "GameLaunchHelper"
            com.mpl.androidapp.utils.MLogger.d(r8, r2)
            com.mpl.androidapp.game.ApkInfo r2 = r18.getApkInfo(r19)
            java.lang.String r9 = "fail"
            if (r2 == 0) goto L_0x02f0
            java.lang.Integer r10 = r2.getGameId()
            if (r10 == 0) goto L_0x02f0
            java.lang.Integer r10 = r2.getGameId()
            int r10 = r10.intValue()
            if (r10 != 0) goto L_0x0030
            goto L_0x02f0
        L_0x0030:
            java.lang.Integer r10 = r2.getGameId()
            int r10 = r10.intValue()
            boolean r10 = r7.checkDeveloperOption(r10)
            java.lang.String r11 = "game_check_fail"
            if (r10 == 0) goto L_0x0049
            r6.reject(r9, r11)
            java.lang.String r0 = "Developer Option is ON.\nPlease disable it from setting and try again"
            r7.showGameLaunchFailToast(r0, r5, r3)
            return
        L_0x0049:
            java.lang.Integer r10 = r2.getGameId()
            int r10 = r10.intValue()
            boolean r10 = r7.checkUSBDebuggingOption(r10)
            if (r10 == 0) goto L_0x0060
            r6.reject(r9, r11)
            java.lang.String r0 = "USB Debugging is ON.\nPlease disable it from setting and try again"
            r7.showGameLaunchFailToast(r0, r5, r3)
            return
        L_0x0060:
            java.lang.Integer r10 = r2.getGameId()
            int r10 = r10.intValue()
            java.lang.String r10 = r7.checkTamperedAppInstalled(r10)
            boolean r12 = android.text.TextUtils.isEmpty(r10)
            if (r12 != 0) goto L_0x0079
            r6.reject(r9, r11)
            r7.showGameLaunchFailToast(r10, r3, r3)
            return
        L_0x0079:
            java.lang.Integer r10 = r2.getGameId()
            int r10 = r10.intValue()
            boolean r10 = r7.checkMagnificationSetting(r10)
            if (r10 == 0) goto L_0x0090
            r6.reject(r9, r11)
            java.lang.String r0 = "Screen Magnification setting is Enabled.\nPlease turn it off from Setting -> Accessibility and relaunch app"
            r7.showGameLaunchFailToast(r0, r3, r5)
            return
        L_0x0090:
            android.content.Context r9 = r7.mContext
            boolean r9 = com.mpl.androidapp.utils.Util.isGameSupportedForDevice(r9, r2)
            if (r9 != 0) goto L_0x00a7
            java.lang.Object[] r0 = new java.lang.Object[r5]
            java.lang.String r1 = "getThirdPartyGameApkStatusConfig: device does not support for this apk"
            r0[r3] = r1
            com.mpl.androidapp.utils.MLogger.d(r8, r0)
            java.lang.String r0 = "device_does_not_support"
            r6.resolve(r0)
            return
        L_0x00a7:
            int r9 = com.mpl.androidapp.utils.Util.getThirdPartyApkDownloadSpaceRequired(r2)
            com.mpl.androidapp.updater.gameengine.GEInteractor r10 = com.mpl.androidapp.updater.gameengine.GEInteractor.getInstance()
            android.content.Context r11 = r7.mContext
            boolean r10 = r10.isSpaceAvailableToInstallApp(r11, r9)
            java.lang.String r11 = "third_party_no_storage_available"
            if (r10 != 0) goto L_0x00c6
            java.lang.Object[] r0 = new java.lang.Object[r5]
            java.lang.String r1 = "getThirdPartyGameApkStatusConfig: Low Storage"
            r0[r3] = r1
            com.mpl.androidapp.utils.MLogger.d(r8, r0)
            r6.resolve(r11)
            return
        L_0x00c6:
            boolean r10 = com.mpl.androidapp.utils.Util.isGameSupportedMinVersion(r2)
            if (r10 != 0) goto L_0x0122
            com.mpl.androidapp.updater.gameengine.GEInteractor r10 = com.mpl.androidapp.updater.gameengine.GEInteractor.getInstance()
            android.content.Context r12 = r7.mContext
            java.lang.Integer r13 = r2.getGameId()
            int r13 = r13.intValue()
            boolean r10 = r10.isGameCodeAvailable(r12, r13)
            if (r10 != 0) goto L_0x0122
            java.lang.Object[] r0 = new java.lang.Object[r5]
            java.lang.String r1 = "getThirdPartyGameApkStatusConfig: This game does not support min version fail"
            r0[r3] = r1
            com.mpl.androidapp.utils.MLogger.d(r8, r0)
            int r0 = com.mpl.androidapp.updater.interactor.DBInteractor.getCurrentDownloadedAppVersionCode()
            int r1 = com.mpl.androidapp.utils.MBuildConfigUtils.getInstalledAppVersionCode()
            if (r0 <= r1) goto L_0x00f9
            java.lang.String r0 = "install_downloaded_apk"
            r6.resolve(r0)
            goto L_0x0121
        L_0x00f9:
            boolean r0 = com.mpl.androidapp.utils.MBuildConfigUtils.isCashApp()
            if (r0 != 0) goto L_0x0105
            boolean r0 = com.mpl.androidapp.utils.MSharedPreferencesUtils.isProAppDownloadRequired()
            if (r0 == 0) goto L_0x0121
        L_0x0105:
            com.mpl.androidapp.updater.gameengine.GEInteractor r0 = com.mpl.androidapp.updater.gameengine.GEInteractor.getInstance()
            android.content.Context r1 = r7.mContext
            boolean r0 = r0.isSpaceAvailableToInstallApp(r1, r9)
            if (r0 == 0) goto L_0x011e
            android.content.Context r0 = r7.mContext
            com.mpl.androidapp.updater.util.StatusType r1 = com.mpl.androidapp.updater.util.StatusType.CHECKING_UPDATE
            com.mpl.androidapp.EventPublishHelper.publishInitialStatusEvent(r0, r1)
            java.lang.String r0 = "apk_downloading"
            r6.resolve(r0)
            goto L_0x0121
        L_0x011e:
            r6.resolve(r11)
        L_0x0121:
            return
        L_0x0122:
            android.content.Context r9 = r7.mContext
            boolean r9 = com.mpl.androidapp.utils.Util.isGameSignatureMatched(r9, r2)
            if (r9 != 0) goto L_0x013f
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r1 = "getThirdPartyGameApkStatusConfig:: Signature mismatch "
            r0[r3] = r1
            java.lang.Integer r1 = r2.getGameId()
            r0[r5] = r1
            com.mpl.androidapp.utils.MLogger.d(r8, r0)
            java.lang.String r0 = "third_party_apk_signature_mismatched"
            r6.resolve(r0)
            return
        L_0x013f:
            java.lang.Integer r9 = r2.getGameId()
            int r9 = r9.intValue()
            java.lang.String r10 = r2.getGameVersion()
            int r10 = java.lang.Integer.parseInt(r10)
            long r10 = (long) r10
            long r9 = r7.getDownloadId(r9, r10)
            r11 = 7
            java.lang.Object[] r11 = new java.lang.Object[r11]
            java.lang.String r12 = "getThirdPartyGameApkStatusConfig:"
            r11[r3] = r12
            java.lang.String r12 = "downloadRequestId "
            r11[r5] = r12
            java.lang.Long r12 = java.lang.Long.valueOf(r9)
            r11[r1] = r12
            r12 = 3
            java.lang.String r13 = "gameId: "
            r11[r12] = r13
            r12 = 4
            java.lang.Integer r13 = r2.getGameId()
            r11[r12] = r13
            r12 = 5
            java.lang.String r13 = "serverVersionCode: "
            r11[r12] = r13
            r12 = 6
            java.lang.String r13 = r2.getGameVersion()
            int r13 = java.lang.Integer.parseInt(r13)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r11[r12] = r13
            com.mpl.androidapp.utils.MLogger.d(r8, r11)
            com.google.gson.Gson r11 = new com.google.gson.Gson     // Catch:{ Exception -> 0x01aa }
            r11.<init>()     // Catch:{ Exception -> 0x01aa }
            java.lang.Class<com.mpl.androidapp.utils.OriginalGameConstant> r12 = com.mpl.androidapp.utils.OriginalGameConstant.class
            java.lang.Object r0 = r11.fromJson(r0, r12)     // Catch:{ Exception -> 0x01aa }
            com.mpl.androidapp.utils.OriginalGameConstant r0 = (com.mpl.androidapp.utils.OriginalGameConstant) r0     // Catch:{ Exception -> 0x01aa }
            java.lang.Object[] r11 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x01aa }
            r11[r3] = r4     // Catch:{ Exception -> 0x01aa }
            r11[r5] = r0     // Catch:{ Exception -> 0x01aa }
            com.mpl.androidapp.utils.MLogger.d(r8, r11)     // Catch:{ Exception -> 0x01aa }
            if (r0 == 0) goto L_0x01ab
            java.util.Map<java.lang.Integer, com.mpl.androidapp.utils.OriginalGameConstant> r11 = mOriginals     // Catch:{ Exception -> 0x01aa }
            java.lang.Integer r12 = r2.getGameId()     // Catch:{ Exception -> 0x01aa }
            r11.put(r12, r0)     // Catch:{ Exception -> 0x01aa }
            goto L_0x01ab
        L_0x01aa:
        L_0x01ab:
            android.content.Context r0 = r7.mContext
            java.lang.String r11 = ""
            java.lang.String r12 = "mpl_app.zip"
            boolean r0 = com.mpl.androidapp.utils.Util.isAssetsAvailable(r0, r11, r12)
            r13 = 0
            java.lang.String r15 = "third_party_apk_download"
            if (r0 == 0) goto L_0x029f
            int r0 = com.mpl.androidapp.utils.MBuildConfigUtils.getLaunchingGameId()
            java.lang.Integer r16 = r2.getGameId()
            int r11 = r16.intValue()
            if (r0 != r11) goto L_0x029f
            java.lang.Object[] r0 = new java.lang.Object[r5]
            java.lang.String r4 = "getThirdPartyGameApkStatusConfig:This is pre bundled apk,Extracting Now"
            r0[r3] = r4
            com.mpl.androidapp.utils.MLogger.d(r8, r0)
            android.content.Context r0 = r7.mContext     // Catch:{ Exception -> 0x0239 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ Exception -> 0x0239 }
            android.content.res.AssetManager r0 = r0.getAssets()     // Catch:{ Exception -> 0x0239 }
            java.io.InputStream r4 = r0.open(r12)     // Catch:{ Exception -> 0x0239 }
            java.io.FileOutputStream r11 = new java.io.FileOutputStream     // Catch:{ all -> 0x0227 }
            android.content.Context r0 = r7.mContext     // Catch:{ all -> 0x0227 }
            java.lang.Integer r12 = r2.getGameId()     // Catch:{ all -> 0x0227 }
            int r12 = r12.intValue()     // Catch:{ all -> 0x0227 }
            java.lang.String r16 = r2.getGameVersion()     // Catch:{ all -> 0x0227 }
            int r5 = java.lang.Integer.parseInt(r16)     // Catch:{ all -> 0x0227 }
            r17 = r2
            long r1 = (long) r5
            java.io.File r0 = com.mpl.androidapp.utils.FileUtils.getThirdPartyApkOutputFile(r0, r12, r1)     // Catch:{ all -> 0x0225 }
            r11.<init>(r0)     // Catch:{ all -> 0x0225 }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0219 }
        L_0x0202:
            int r1 = r4.read(r0)     // Catch:{ all -> 0x0219 }
            if (r1 <= 0) goto L_0x020c
            r11.write(r0, r3, r1)     // Catch:{ all -> 0x0219 }
            goto L_0x0202
        L_0x020c:
            java.lang.String r0 = "install_downloaded_third_party_apk"
            r6.resolve(r0)     // Catch:{ all -> 0x0219 }
            r11.close()     // Catch:{ all -> 0x0225 }
            r4.close()     // Catch:{ Exception -> 0x0237 }
            goto L_0x02ef
        L_0x0219:
            r0 = move-exception
            r1 = r0
            r11.close()     // Catch:{ all -> 0x021f }
            goto L_0x0224
        L_0x021f:
            r0 = move-exception
            r2 = r0
            r1.addSuppressed(r2)     // Catch:{ all -> 0x0225 }
        L_0x0224:
            throw r1     // Catch:{ all -> 0x0225 }
        L_0x0225:
            r0 = move-exception
            goto L_0x022a
        L_0x0227:
            r0 = move-exception
            r17 = r2
        L_0x022a:
            r1 = r0
            if (r4 == 0) goto L_0x0236
            r4.close()     // Catch:{ all -> 0x0231 }
            goto L_0x0236
        L_0x0231:
            r0 = move-exception
            r2 = r0
            r1.addSuppressed(r2)     // Catch:{ Exception -> 0x0237 }
        L_0x0236:
            throw r1     // Catch:{ Exception -> 0x0237 }
        L_0x0237:
            goto L_0x023b
        L_0x0239:
            r17 = r2
        L_0x023b:
            int r0 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r0 == 0) goto L_0x0277
            int r0 = r7.getApkDownloadStatus(r9)
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "getThirdPartyGameApkStatus: "
            r1[r3] = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            r3 = 1
            r1[r3] = r2
            com.mpl.androidapp.utils.MLogger.d(r8, r1)
            r1 = -7765(0xffffffffffffe1ab, float:NaN)
            if (r0 != r1) goto L_0x025d
            r6.resolve(r15)
            goto L_0x02ef
        L_0x025d:
            java.lang.String r0 = r17.getGameVersion()
            int r4 = java.lang.Integer.parseInt(r0)
            java.lang.Integer r0 = r17.getGameId()
            int r5 = r0.intValue()
            r1 = r18
            r2 = r9
            r6 = r20
            r1.getThirdPartyApkDownloadProgressStatus(r2, r4, r5, r6)
            goto L_0x02ef
        L_0x0277:
            r1 = 1
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r1 = "getThirdPartyGameApkStatus:Sending event for download "
            r0[r3] = r1
            com.mpl.androidapp.utils.MLogger.d(r8, r0)
            java.lang.Integer r0 = r17.getGameId()
            int r0 = r0.intValue()
            boolean r0 = com.mpl.androidapp.utils.Util.showDownloadPopUp(r0)
            if (r0 == 0) goto L_0x0293
            r6.resolve(r15)
            goto L_0x02ef
        L_0x0293:
            java.lang.Integer r0 = r17.getGameId()
            int r0 = r0.intValue()
            r7.launchPlayStore(r0, r6)
            goto L_0x02ef
        L_0x029f:
            r17 = r2
            r1 = 1
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r2 = "getThirdPartyGameApkStatusConfig:This is not pre bundled apk,Downloading Now "
            r0[r3] = r2
            com.mpl.androidapp.utils.MLogger.d(r8, r0)
            int r0 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r0 == 0) goto L_0x02cf
            int r0 = r7.getApkDownloadStatus(r9)
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r3] = r4
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            r2[r1] = r3
            com.mpl.androidapp.utils.MLogger.d(r8, r2)
            r1 = -7765(0xffffffffffffe1ab, float:NaN)
            if (r0 != r1) goto L_0x02c9
            r6.resolve(r15)
            goto L_0x02ef
        L_0x02c9:
            r2 = r17
            r7.getThirdPartyApkDownloadProgressStatus(r9, r2, r6)
            goto L_0x02ef
        L_0x02cf:
            r2 = r17
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r1 = "getThirdPartyGameApkStatusConfig:Sending event for download "
            r0[r3] = r1
            com.mpl.androidapp.utils.MLogger.d(r8, r0)
            java.lang.Integer r0 = r2.getGameId()
            int r0 = r0.intValue()
            boolean r1 = com.mpl.androidapp.utils.Util.showDownloadPopUp(r0)
            if (r1 == 0) goto L_0x02ec
            r6.resolve(r15)
            goto L_0x02ef
        L_0x02ec:
            r7.launchPlayStore(r0, r6)
        L_0x02ef:
            return
        L_0x02f0:
            java.lang.String r0 = "Fail to parse json"
            r6.reject(r9, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.react.modules.GameLaunchHelper.getThirdPartyGameApkStatusConfig(java.lang.String, com.facebook.react.bridge.Promise):void");
    }

    @ReactMethod
    public void installDownloadedAPK(Promise promise) {
        MLogger.d(TAG, Constant.APP_UPDATE_CHECK, "installDownloadedAPK: ");
        File apkOutputFile = FileUtils.getApkOutputFile(this.mContext, DBInteractor.getCurrentDownloadedAppVersionCode());
        if (!IntegrityCheck.ApkIntegrityCheck(apkOutputFile)) {
            MLogger.d(TAG, Constant.APP_UPDATE_CHECK, "installDownloadedAPK:Deleting apk ");
            UpdaterAnalytics.integrityCheckFailEvent(2, "");
            apkOutputFile.delete();
            AppInitialization.from(this.mContext).checkUpdateAvailableCall(this.mContext, StatusType.DOWNLOADED_APK_INTEGRITY_FAIL);
            promise.resolve("apk_downloading");
        } else if (GEInteractor.getInstance().isSpaceAvailableToInstallApp(this.mContext)) {
            FileUtils.installApk(getCurrentActivity() != null ? getCurrentActivity() : this.mContext, apkOutputFile);
            promise.resolve("ok");
        } else {
            promise.resolve("low_storage_message_app");
        }
    }

    @ReactMethod
    public void installThirdPartyApk(int i, Promise promise) {
        MLogger.d(TAG, "installThirdPartyApk: ", Integer.valueOf(i));
        if (MSharedPreferencesUtils.getGamesWithoutAssetsDownload().contains(String.valueOf(i)) || MSharedPreferencesUtils.isGamesIdWithoutAssetsDownload(i)) {
            long thirdPartyApkDownloadVersion = (long) Util.getThirdPartyApkDownloadVersion(i);
            long downloadId = getDownloadId(i, thirdPartyApkDownloadVersion);
            if (getApkDownloadStatus(downloadId) == 8 || (Util.isAssetsAvailable(this.mContext, "", Constant.MPL_PRE_BUILD_APK_FILE_NAME) && MBuildConfigUtils.getLaunchingGameId() == i)) {
                String apkDownloadedFilePath = FileUtils.getApkDownloadedFilePath(this.mContext, downloadId);
                if (Util.isAssetsAvailable(this.mContext, "", Constant.MPL_PRE_BUILD_APK_FILE_NAME) && MBuildConfigUtils.getLaunchingGameId() == i) {
                    apkDownloadedFilePath = FileUtils.getThirdPartyApkOutputFile(this.mContext, i, thirdPartyApkDownloadVersion).getPath();
                }
                MLogger.d(TAG, "downloadThirdPartyGameApk: ", apkDownloadedFilePath);
                if (TextUtils.isEmpty(apkDownloadedFilePath)) {
                    deleteGameDownloadPref(thirdPartyApkDownloadVersion, i);
                    promise.resolve("third_party_apk_corrupted");
                    return;
                }
                File file = new File(Uri.parse(apkDownloadedFilePath).getPath());
                if (file.exists()) {
                    this.mInstallingGameId = i;
                    FileUtils.installApkNew(getCurrentActivity(), file, REQUEST_INSTALL);
                    promise.resolve("ok");
                    return;
                }
                deleteGameDownloadPref(thirdPartyApkDownloadVersion, i);
                promise.resolve("third_party_apk_corrupted");
            }
        }
    }

    @ReactMethod
    public void installThirdPartyApkConfig(String str, Promise promise) {
        MLogger.d(TAG, "installThirdPartyApkConfig: ", str);
        ApkInfo apkInfo = getApkInfo(str);
        if (apkInfo == null) {
            promise.reject((String) "fail", (String) "Fail to parse json");
        } else if (apkInfo.getGameId() == null) {
            promise.reject((String) "fail", (String) "Game id is null");
        } else {
            MLogger.d(TAG, "installThirdPartyApkConfig: ", apkInfo.getGameId());
            if (MSharedPreferencesUtils.getGamesWithoutAssetsDownload().contains(String.valueOf(apkInfo.getGameId())) || MSharedPreferencesUtils.isGamesIdWithoutAssetsDownload(apkInfo.getGameId().intValue())) {
                long thirdPartyApkDownloadVersion = (long) Util.getThirdPartyApkDownloadVersion(apkInfo);
                long downloadId = getDownloadId(apkInfo.getGameId().intValue(), thirdPartyApkDownloadVersion);
                if (getApkDownloadStatus(downloadId) == 8 || (Util.isAssetsAvailable(this.mContext, "", Constant.MPL_PRE_BUILD_APK_FILE_NAME) && MBuildConfigUtils.getLaunchingGameId() == apkInfo.getGameId().intValue())) {
                    String apkDownloadedFilePath = FileUtils.getApkDownloadedFilePath(this.mContext, downloadId);
                    if (Util.isAssetsAvailable(this.mContext, "", Constant.MPL_PRE_BUILD_APK_FILE_NAME) && MBuildConfigUtils.getLaunchingGameId() == apkInfo.getGameId().intValue()) {
                        apkDownloadedFilePath = FileUtils.getThirdPartyApkOutputFile(this.mContext, apkInfo.getGameId().intValue(), thirdPartyApkDownloadVersion).getPath();
                    }
                    MLogger.d(TAG, "installThirdPartyApkConfig: ", apkDownloadedFilePath);
                    if (TextUtils.isEmpty(apkDownloadedFilePath)) {
                        deleteGameDownloadPref(thirdPartyApkDownloadVersion, apkInfo.getGameId().intValue());
                        promise.resolve("third_party_apk_corrupted");
                    } else {
                        File file = new File(Uri.parse(apkDownloadedFilePath).getPath());
                        if (file.exists()) {
                            this.mInstallingGameId = apkInfo.getGameId().intValue();
                            FileUtils.installApkNew(getCurrentActivity(), file, REQUEST_INSTALL);
                            promise.resolve("ok");
                        } else {
                            deleteGameDownloadPref(thirdPartyApkDownloadVersion, apkInfo.getGameId().intValue());
                            promise.resolve("third_party_apk_corrupted");
                        }
                    }
                }
            }
        }
    }

    @ReactMethod
    public void installThirdPartyApkWithGameId(int i) {
        MLogger.d(TAG, "installThirdPartyApk: ", Integer.valueOf(i));
        if (MSharedPreferencesUtils.getGamesWithoutAssetsDownload().contains(String.valueOf(i)) || MSharedPreferencesUtils.isGamesIdWithoutAssetsDownload(i)) {
            long thirdPartyApkDownloadVersion = (long) Util.getThirdPartyApkDownloadVersion(i);
            long downloadId = getDownloadId(i, thirdPartyApkDownloadVersion);
            if (getApkDownloadStatus(downloadId) == 8) {
                String apkDownloadedFilePath = FileUtils.getApkDownloadedFilePath(this.mContext, downloadId);
                MLogger.d(TAG, "downloadThirdPartyGameApk: ", apkDownloadedFilePath);
                if (TextUtils.isEmpty(apkDownloadedFilePath)) {
                    deleteGameDownloadPref(thirdPartyApkDownloadVersion, i);
                    return;
                }
                File file = new File(Uri.parse(apkDownloadedFilePath).getPath());
                if (file.exists()) {
                    this.mInstallingGameId = i;
                    FileUtils.installApkNew(getCurrentActivity(), file, REQUEST_INSTALL);
                    return;
                }
                deleteGameDownloadPref(thirdPartyApkDownloadVersion, i);
            }
        }
    }

    @ReactMethod
    public void installThirdPartyApkWithGameIdConfig(String str) {
        MLogger.d(TAG, "installThirdPartyApkWithGameIdConfig: ");
        ApkInfo apkInfo = getApkInfo(str);
        if (apkInfo != null) {
            MLogger.d(TAG, "installThirdPartyApkWithGameIdConfig: ", apkInfo.getGameId());
            if (MSharedPreferencesUtils.getGamesWithoutAssetsDownload().contains(String.valueOf(apkInfo.getGameId())) || MSharedPreferencesUtils.isGamesIdWithoutAssetsDownload(apkInfo.getGameId().intValue())) {
                long parseLong = Long.parseLong(apkInfo.getGameVersion());
                long downloadId = getDownloadId(apkInfo.getGameId().intValue(), parseLong);
                if (getApkDownloadStatus(downloadId) == 8) {
                    String apkDownloadedFilePath = FileUtils.getApkDownloadedFilePath(this.mContext, downloadId);
                    MLogger.d(TAG, "installThirdPartyApkWithGameIdConfig: ", apkDownloadedFilePath);
                    if (TextUtils.isEmpty(apkDownloadedFilePath)) {
                        deleteGameDownloadPref(parseLong, apkInfo.getGameId().intValue());
                    } else {
                        File file = new File(Uri.parse(apkDownloadedFilePath).getPath());
                        if (file.exists()) {
                            this.mInstallingGameId = apkInfo.getGameId().intValue();
                            FileUtils.installApkNew(getCurrentActivity(), file, REQUEST_INSTALL);
                        } else {
                            deleteGameDownloadPref(parseLong, apkInfo.getGameId().intValue());
                        }
                    }
                }
            }
        }
    }

    @ReactMethod
    public void isMPLUpdateRequired(int i, Promise promise) {
        MLogger.d(TAG, "isMPLUpdateRequired: ", Integer.valueOf(i));
        int thirdPartyApkDownloadSpaceRequired = Util.getThirdPartyApkDownloadSpaceRequired(i);
        if (!Util.isGameSupportedMinVersion(i) && !GEInteractor.getInstance().isGameCodeAvailable(this.mContext, i)) {
            MLogger.d(TAG, "isMPLUpdateRequired: This game does not support min version fail");
            if (DBInteractor.getCurrentDownloadedAppVersionCode() > MBuildConfigUtils.getInstalledAppVersionCode()) {
                promise.resolve("install_downloaded_apk");
            } else if (MBuildConfigUtils.isCashApp() || MSharedPreferencesUtils.isProAppDownloadRequired()) {
                if (GEInteractor.getInstance().isSpaceAvailableToInstallApp(this.mContext, thirdPartyApkDownloadSpaceRequired)) {
                    EventPublishHelper.publishInitialStatusEvent(this.mContext, StatusType.CHECKING_UPDATE);
                    promise.resolve("apk_downloading");
                } else {
                    promise.resolve("third_party_no_storage_available");
                }
            }
        } else if (!Util.isGameSignatureMatched(this.mContext, i)) {
            MLogger.d(TAG, "getThirdPartyGameApkStatus:: Signature mismatch ", Integer.valueOf(i));
            promise.resolve("third_party_apk_signature_mismatched");
        } else if (checkDeveloperOption(i)) {
            promise.reject((String) "fail", (String) "game_check_fail");
            showGameLaunchFailToast("Developer Option is ON.\nPlease disable it from setting and try again", true, false);
        } else if (checkUSBDebuggingOption(i)) {
            promise.reject((String) "fail", (String) "game_check_fail");
            showGameLaunchFailToast("USB Debugging is ON.\nPlease disable it from setting and try again", true, false);
        } else {
            String checkTamperedAppInstalled = checkTamperedAppInstalled(i);
            if (!TextUtils.isEmpty(checkTamperedAppInstalled)) {
                promise.reject((String) "fail", (String) "game_check_fail");
                showGameLaunchFailToast(checkTamperedAppInstalled, false, false);
            } else if (checkMagnificationSetting(i)) {
                promise.reject((String) "fail", (String) "game_check_fail");
                showGameLaunchFailToast("Screen Magnification setting is Enabled.\nPlease turn it off from Setting -> Accessibility and relaunch app", false, true);
            } else {
                promise.resolve("no_update_required");
            }
        }
    }

    @ReactMethod
    public void isMPLUpdateRequiredConfig(String str, Promise promise) {
        MLogger.d(TAG, "isMPLUpdateRequiredConfig: ", str);
        ApkInfo apkInfo = getApkInfo(str);
        if (apkInfo == null) {
            promise.reject((String) "fail", (String) "Fail to parse json");
            return;
        }
        MLogger.d(TAG, "isMPLUpdateRequiredConfig: ", apkInfo.getGameId());
        int thirdPartyApkDownloadSpaceRequired = Util.getThirdPartyApkDownloadSpaceRequired(apkInfo);
        if (!Util.isGameSupportedMinVersion(apkInfo) && !GEInteractor.getInstance().isGameCodeAvailable(this.mContext, apkInfo.getGameId().intValue())) {
            MLogger.d(TAG, "isMPLUpdateRequiredConfig: This game does not support min version fail");
            if (DBInteractor.getCurrentDownloadedAppVersionCode() > MBuildConfigUtils.getInstalledAppVersionCode()) {
                promise.resolve("install_downloaded_apk");
            } else if (MBuildConfigUtils.isCashApp() || MSharedPreferencesUtils.isProAppDownloadRequired()) {
                if (GEInteractor.getInstance().isSpaceAvailableToInstallApp(this.mContext, thirdPartyApkDownloadSpaceRequired)) {
                    EventPublishHelper.publishInitialStatusEvent(this.mContext, StatusType.CHECKING_UPDATE);
                    promise.resolve("apk_downloading");
                } else {
                    promise.resolve("third_party_no_storage_available");
                }
            }
        } else if (!Util.isGameSignatureMatched(this.mContext, apkInfo)) {
            MLogger.d(TAG, "getThirdPartyGameApkStatus:: Signature mismatch ", apkInfo.getGameId());
            promise.resolve("third_party_apk_signature_mismatched");
        } else if (checkDeveloperOption(apkInfo.getGameId().intValue())) {
            promise.reject((String) "fail", (String) "game_check_fail");
            showGameLaunchFailToast("Developer Option is ON.\nPlease disable it from setting and try again", true, false);
        } else if (checkUSBDebuggingOption(apkInfo.getGameId().intValue())) {
            promise.reject((String) "fail", (String) "game_check_fail");
            showGameLaunchFailToast("USB Debugging is ON.\nPlease disable it from setting and try again", true, false);
        } else {
            String checkTamperedAppInstalled = checkTamperedAppInstalled(apkInfo.getGameId().intValue());
            if (!TextUtils.isEmpty(checkTamperedAppInstalled)) {
                promise.reject((String) "fail", (String) "game_check_fail");
                showGameLaunchFailToast(checkTamperedAppInstalled, false, false);
            } else if (checkMagnificationSetting(apkInfo.getGameId().intValue())) {
                promise.reject((String) "fail", (String) "game_check_fail");
                showGameLaunchFailToast("Screen Magnification setting is Enabled.\nPlease turn it off from Setting -> Accessibility and relaunch app", false, true);
            } else {
                MLogger.d(TAG, "isMPLUpdateRequiredConfig:no_update_required ", apkInfo.getGameId());
                promise.resolve("no_update_required");
            }
        }
    }

    public void launchOriginalGame(Context context, String str, int i) {
        try {
            if (!Util.isAttributionEnabled(i) || TextUtils.isEmpty(Util.getAttributionUrl(i))) {
                Util.openAppThroughPlayStore(context, str);
            } else {
                Util.openLinkInBrowser(context, Util.getAttributionUrl(i));
            }
            CleverTapAnalyticsUtils.setOriginalPlayStoreRedirectionEvent();
            if (Util.shouldShowNotification(i)) {
                new NotificationBuilder(context).createStickyNotificationForOriginals(i);
            }
            String appNameBasedOnGameId = Util.getAppNameBasedOnGameId(i);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("title", appNameBasedOnGameId);
            jSONObject.put(InlineAnimation.DELAY, 2000);
            jSONObject.put("message", "Click Install and continue on MPL Pro to play");
            jSONObject.put("color", "");
            jSONObject.put("position", RNGestureHandlerModule.KEY_HIT_SLOP_BOTTOM);
            jSONObject.put("toastType", "Install");
            Util.showCustomToast(jSONObject.toString());
        } catch (Exception e2) {
            MLogger.e(TAG, "launchOriginalGame: ", e2);
        }
    }

    @ReactMethod
    public void openAllApps() {
        MLogger.d(TAG, "openAllApps");
        if (getCurrentActivity() != null) {
            Intent intent = new Intent(getCurrentActivity(), GamesActivity.class);
            intent.putExtra(SpaceUtils.INTENT_IS_SINGLE_MPL_GAME, false);
            getCurrentActivity().startActivity(intent);
        }
    }

    @ReactMethod
    public void openMPLGames(String str) {
        MLogger.d(TAG, GeneratedOutlineSupport.outline50("openMPLGames: ", str));
        if (str != null && getCurrentActivity() != null) {
            Intent intent = new Intent(getCurrentActivity(), GamesActivity.class);
            intent.putExtra(SpaceUtils.INTENT_IS_SINGLE_MPL_GAME, false);
            intent.putExtra(SpaceUtils.INTENT_ALL_MPL_GAMES, str);
            getCurrentActivity().startActivity(intent);
        }
    }

    @ReactMethod
    public void openSingleMPLGame(String str) {
        MLogger.d(TAG, GeneratedOutlineSupport.outline50("openSingleMPLGame: ", str));
        if (str != null && getCurrentActivity() != null) {
            Intent intent = new Intent(getCurrentActivity(), GamesActivity.class);
            intent.putExtra(SpaceUtils.INTENT_IS_SINGLE_MPL_GAME, true);
            intent.putExtra(SpaceUtils.INTENT_MPL_GAME, str);
            getCurrentActivity().startActivity(intent);
        }
    }

    @ReactMethod
    public void registerDownloadCompleteReceiver() {
        try {
            MLogger.d(TAG, "registerDownloadCompleteReceiver:isRegistered " + this.isRegistered);
            if (this.onDownloadCompleteReceiver != null && this.mContext != null) {
                this.mContext.registerReceiver(this.onDownloadCompleteReceiver, new IntentFilter(Constants.FILTER_DOWNLOAD_COMPLETE));
                this.isRegistered = true;
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "registerDownloadCompleteReceiver:isRegistered ", e2);
        }
    }

    @ReactMethod
    public void unRegisterDownloadCompleteReceiver() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("unRegisterDownloadCompleteReceiver:isRegistered ");
        outline73.append(this.isRegistered);
        MLogger.d(TAG, outline73.toString());
        unRegisterReceiver();
    }

    @ReactMethod
    public void unRegisterReceiver() {
        try {
            MLogger.d(TAG, "unRegisterReceiver:isRegistered " + this.isRegistered);
            if (this.onDownloadCompleteReceiver != null && this.isRegistered) {
                this.mContext.unregisterReceiver(this.onDownloadCompleteReceiver);
                this.isRegistered = false;
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "unRegisterReceiver:isRegistered ", e2);
        }
    }

    @ReactMethod
    public void uninstallApp(String str) {
        if (getCurrentActivity() != null) {
            Util.uninstallApp(getCurrentActivity(), str);
        }
    }

    @ReactMethod
    public void updateAssets(int i, String str, final Promise promise) {
        if (!GEInteractor.getInstance().isAssetsAvailable(this.mContext, i)) {
            if (i < 1000000) {
                i += 1000000;
            } else {
                promise.reject((String) "fail", (String) "Assets are not available");
                return;
            }
        }
        if (!GEInteractor.getInstance().deleteAssets(this.mContext, i)) {
            promise.reject((String) "fail", (String) "Assets are not available");
        } else if (AssetsConfigReader.listOfGameAssetsAvailableArray(this.mContext).contains(Integer.valueOf(i))) {
            GEInteractor.getInstance().initializeGameAssetsFirstTime(this.mContext, new RNListener() {
                public boolean isHasRequiredPermission() {
                    return false;
                }

                public void publishResult(String str) {
                    if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("Success")) {
                        promise.resolve("Successful");
                    }
                }
            });
        } else if (!GEInteractor.getInstance().isAssetsAvailable(this.mContext, i)) {
            downloadGameAssetsByGameId(i, str, 0, promise);
        } else {
            MLogger.d(Constant.ASSETS_CHECKING, "Assets are present");
        }
    }

    @ReactMethod
    public void updaterSummaryData(Promise promise) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isUpdateAvailable", MSharedPreferencesUtils.isUpdateAvailableInUpdaterV2());
            jSONObject.put("isUpdateCritical", MSharedPreferencesUtils.isUpdateCriticalInUpdaterV2());
            jSONObject.put("version", MSharedPreferencesUtils.getUpdater2Version());
            jSONObject.put("popUpShow", MSharedPreferencesUtils.getShowPopup());
            jSONObject.put("canSkipPopup", MSharedPreferencesUtils.canSkipPopup());
            jSONObject.put("url", MSharedPreferencesUtils.getApkUrl());
            jSONObject.put(Response.RELEASE_NOTES, MSharedPreferencesUtils.getReleasePoints());
            jSONObject.put("eligibilityCriteria", MSharedPreferencesUtils.getEligibilityCriteria());
            promise.resolve(jSONObject.toString());
        } catch (JSONException e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("JSON Exception: ");
            outline73.append(e2.getLocalizedMessage());
            promise.reject((String) "fail", outline73.toString());
        }
    }

    private void checkDownloadProgress(ApkInfo apkInfo, long j) {
        MLogger.d(TAG, "checkDownloadProgress: ", Long.valueOf(j), apkInfo.getGameId());
        DownloadManager downloadManager = (DownloadManager) this.mContext.getSystemService(Constant.DOWNLOAD);
        if (downloadManager != null) {
            Timer timer = new Timer();
            Query query = new Query();
            query.setFilterById(new long[]{j});
            ApkInfo apkInfo2 = apkInfo;
            publishProgressToReact(2, apkInfo);
            final DownloadManager downloadManager2 = downloadManager;
            final Query query2 = query;
            final ApkInfo apkInfo3 = apkInfo;
            final Timer timer2 = timer;
            AnonymousClass8 r0 = new TimerTask() {
                public void run() {
                    MLogger.d(GameLaunchHelper.TAG, "run: checking progress 2");
                    Cursor query = downloadManager2.query(query2);
                    if (query == null || !query.moveToFirst()) {
                        MLogger.e(GameLaunchHelper.TAG, "run: checking progress 2 Cursor is null");
                        Timer timer = timer2;
                        if (timer != null) {
                            timer.cancel();
                        }
                        cancel();
                        return;
                    }
                    int i = query.getInt(query.getColumnIndex("status"));
                    int i2 = query.getInt(query.getColumnIndex("total_size"));
                    int i3 = query.getInt(query.getColumnIndex("bytes_so_far"));
                    MLogger.d(GameLaunchHelper.TAG, "DownloadManager::status 2 ", Integer.valueOf(i));
                    if (i == 1) {
                        MLogger.d(GameLaunchHelper.TAG, GeneratedOutlineSupport.outline43("DownloadManager:STATUS_PENDING ", i2, "  ", i3));
                    } else if (i == 2) {
                        int i4 = (int) ((((float) i3) / ((float) i2)) * 100.0f);
                        GameLaunchHelper.this.publishProgressToReact(i4, apkInfo3);
                        MLogger.d(GameLaunchHelper.TAG, "DownloadManager:STATUS_RUNNING ", Integer.valueOf(i4));
                    } else if (i == 4) {
                        GameLaunchHelper.this.publishProgressToReact((int) ((((float) i3) / ((float) i2)) * 100.0f), apkInfo3);
                        MLogger.d(GameLaunchHelper.TAG, GeneratedOutlineSupport.outline43("DownloadManager:STATUS_PAUSED ", i2, "  ", i3));
                    } else if (i == 8) {
                        GameLaunchHelper.this.previousProgress = 0;
                        GameLaunchHelper.this.sendDownloadCompletedEventToReact(apkInfo3);
                        timer2.cancel();
                        MLogger.d(GameLaunchHelper.TAG, "run: cancel task:", Boolean.valueOf(cancel()));
                        MLogger.d(GameLaunchHelper.TAG, GeneratedOutlineSupport.outline43("DownloadManager:STATUS_SUCCESSFUL ", i2, "  ", i3));
                    } else if (i == 16) {
                        MLogger.d(GameLaunchHelper.TAG, GeneratedOutlineSupport.outline43("DownloadManager:STATUS_FAILED ", i2, "  ", i3));
                        GameLaunchHelper.this.mDownloadRequestId = 0;
                        GameLaunchHelper.this.previousProgress = 0;
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("Game Name", apkInfo3.getGameName());
                            jSONObject.put("Game Id", apkInfo3.getGameId());
                            jSONObject.put(AssetsAnalytics.PROP_GAME_DOWNLOAD_SIZE, apkInfo3.getSize());
                            jSONObject.put(AssetsAnalytics.PROP_GAME_VERSION, apkInfo3.getGameVersion());
                            jSONObject.put(AssetsAnalytics.PROP_IS_FORCE_UPDATE, apkInfo3.getForceUpdate());
                            jSONObject.put(AssetsAnalytics.PROP_GAME_PLAYED, Double.parseDouble(apkInfo3.getGamePlays()));
                            jSONObject.put(AssetsAnalytics.PROP_GAME_INSTALL_COUNT, Double.parseDouble(apkInfo3.getInstalls()));
                            jSONObject.put("Is Success", false);
                            CleverTapAnalyticsUtils.sendEvent((String) AssetsAnalytics.EVENT_GAME_DOWNLOAD_COMPLETED, jSONObject.toString());
                        } catch (Exception unused) {
                            MLogger.e(GameLaunchHelper.TAG, "Game Download Completed: ");
                        }
                        timer2.cancel();
                        MLogger.d(GameLaunchHelper.TAG, "run: cancel task:", Boolean.valueOf(cancel()));
                        GameLaunchHelper.this.deleteGameDownloadPref(Long.parseLong(apkInfo3.getGameVersion()), apkInfo3.getGameId().intValue());
                        GameLaunchHelper.this.sendDownloadFailedEventToReact(apkInfo3);
                    }
                    if (!query.isClosed()) {
                        query.close();
                    }
                }
            };
            timer.scheduleAtFixedRate(r0, 0, 200);
        }
    }

    /* access modifiers changed from: private */
    public void sendDownloadCompletedEventToReact(ApkInfo apkInfo) {
        MLogger.d(TAG, "sendDownloadCompletedEventToReact: ");
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("id", 990);
            bundle.putInt("progress", 100);
            bundle.putInt("gameId", apkInfo.getGameId().intValue());
            bundle.putString("status", "installing");
            bundle.putString("notificationStatus", "downloading");
            bundle.putString("gameIconUrl", apkInfo.getLogo());
            bundle.putString("gameName", apkInfo.getGameName());
            bundle.putString("packageName", apkInfo.getPackageName());
            bundle.putString("serverVersion", apkInfo.getGameVersion());
            if (MPLReactContainerActivity.resultReceiver != null) {
                MPLReactContainerActivity.resultReceiver.send(19, bundle);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Game Name", apkInfo.getGameName());
            jSONObject.put("Game Id", apkInfo.getGameId());
            jSONObject.put(AssetsAnalytics.PROP_GAME_DOWNLOAD_SIZE, apkInfo.getSize());
            jSONObject.put(AssetsAnalytics.PROP_GAME_VERSION, apkInfo.getGameVersion());
            jSONObject.put(AssetsAnalytics.PROP_IS_FORCE_UPDATE, apkInfo.getForceUpdate());
            jSONObject.put(AssetsAnalytics.PROP_GAME_PLAYED, Double.parseDouble(apkInfo.getGamePlays()));
            jSONObject.put(AssetsAnalytics.PROP_GAME_INSTALL_COUNT, Double.parseDouble(apkInfo.getInstalls()));
            jSONObject.put("Is Success", true);
            CleverTapAnalyticsUtils.sendEvent((String) AssetsAnalytics.EVENT_GAME_DOWNLOAD_COMPLETED, jSONObject.toString());
        } catch (Exception unused) {
            MLogger.e(TAG, "startProcessForThirdPartyApk: ");
        }
    }

    /* access modifiers changed from: private */
    public void sendDownloadFailedEventToReact(ApkInfo apkInfo) {
        MLogger.d(TAG, "sendDownloadFailedEventToReact: ");
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("id", 990);
            bundle.putInt("progress", 100);
            bundle.putInt("gameId", apkInfo.getGameId().intValue());
            bundle.putString("status", "failed");
            bundle.putString("notificationStatus", "failed");
            bundle.putString("gameIconUrl", apkInfo.getLogo());
            bundle.putString("gameName", apkInfo.getGameName());
            bundle.putString("packageName", apkInfo.getPackageName());
            bundle.putString("serverVersion", apkInfo.getGameVersion());
            if (MPLReactContainerActivity.resultReceiver != null) {
                MPLReactContainerActivity.resultReceiver.send(19, bundle);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Game Name", apkInfo.getGameName());
            jSONObject.put("Game Id", apkInfo.getGameId());
            jSONObject.put(AssetsAnalytics.PROP_GAME_DOWNLOAD_SIZE, apkInfo.getSize());
            jSONObject.put(AssetsAnalytics.PROP_GAME_VERSION, apkInfo.getGameVersion());
            jSONObject.put(AssetsAnalytics.PROP_IS_FORCE_UPDATE, apkInfo.getForceUpdate());
            jSONObject.put(AssetsAnalytics.PROP_GAME_PLAYED, Double.parseDouble(apkInfo.getGamePlays()));
            jSONObject.put(AssetsAnalytics.PROP_GAME_INSTALL_COUNT, Double.parseDouble(apkInfo.getInstalls()));
            jSONObject.put("Is Success", false);
            CleverTapAnalyticsUtils.sendEvent((String) AssetsAnalytics.EVENT_GAME_DOWNLOAD_COMPLETED, jSONObject.toString());
        } catch (Exception unused) {
            MLogger.e(TAG, "startProcessForThirdPartyApk: ");
        }
    }

    /* access modifiers changed from: private */
    public void publishProgressToReact(int i, ApkInfo apkInfo) {
        MLogger.d(TAG, "publishProgressToReact: ", Integer.valueOf(i), Integer.valueOf(this.previousProgress), Boolean.valueOf(apkInfo.isAutoDownload()));
        if (!apkInfo.isAutoDownload()) {
            Bundle bundle = new Bundle();
            bundle.putInt("id", 990);
            bundle.putInt("gameId", apkInfo.getGameId().intValue());
            bundle.putString("gameIconUrl", apkInfo.getLogo());
            bundle.putString("gameName", apkInfo.getGameName());
            bundle.putString("packageName", apkInfo.getPackageName());
            bundle.putString("serverVersion", apkInfo.getGameVersion());
            MLogger.d(TAG, "publishProgressToReact: ", Integer.valueOf(i), Integer.valueOf(this.previousProgress), apkInfo.getGameId());
            if ((i % 2 == 0 || i % 3 == 0 || i % 5 == 0) && i > this.previousProgress) {
                MLogger.d(TAG, "Sending data to react progressResponse: ", Integer.valueOf(i));
                this.previousProgress = i;
                bundle.putInt("progress", i);
                bundle.putString("status", "downloading");
                bundle.putString("notificationStatus", "downloading");
                DownloadProgressReceiver downloadProgressReceiver = MPLReactContainerActivity.resultReceiver;
                if (downloadProgressReceiver != null) {
                    downloadProgressReceiver.send(19, bundle);
                }
            } else if (i >= 100 && i > this.previousProgress) {
                MLogger.d(TAG, "Sending data to react progressResponse: ", Integer.valueOf(i));
                this.previousProgress = i;
                bundle.putInt("gameId", apkInfo.getGameId().intValue());
                bundle.putString("status", "installing");
                bundle.putString("notificationStatus", "downloading");
                DownloadProgressReceiver downloadProgressReceiver2 = MPLReactContainerActivity.resultReceiver;
                if (downloadProgressReceiver2 != null) {
                    downloadProgressReceiver2.send(19, bundle);
                }
            }
        }
    }

    private void startProcessForThirdPartyApk(ApkInfo apkInfo, Promise promise) {
        Promise promise2 = promise;
        String logo = apkInfo.getLogo();
        String packageName = apkInfo.getPackageName();
        File thirdPartyApkOutputFile = FileUtils.getThirdPartyApkOutputFile(this.mContext, apkInfo.getGameId().intValue(), Long.parseLong(apkInfo.getGameVersion()));
        long downloadId = getDownloadId(apkInfo.getGameId().intValue(), Long.parseLong(apkInfo.getGameVersion()));
        this.mDownloadRequestId = downloadId;
        MLogger.d(TAG, "startProcessForThirdPartyApk:With Apk Info ", Long.valueOf(downloadId), apkInfo.getGameId());
        int apkDownloadStatus = getApkDownloadStatus(this.mDownloadRequestId);
        MLogger.d(TAG, "startProcessForThirdPartyApk:With Apk Info ", Integer.valueOf(apkDownloadStatus));
        long j = this.mDownloadRequestId;
        if (j == 0 || apkDownloadStatus == -7765) {
            ApkInfo apkInfo2 = apkInfo;
            this.previousProgress = 0;
            String downloadUrl = apkInfo.getDownloadUrl();
            if (TextUtils.isEmpty(downloadUrl)) {
                promise2.resolve("third_party_apk_downloading_failed");
                return;
            }
            this.mDownloadRequestId = CommonUtils.downloadFile(this.mContext, downloadUrl, thirdPartyApkOutputFile, apkInfo.getGameName(), "Downloading...", new IResponseListener<String>() {
                public void onResponseFail(Exception exc) {
                }

                public void progressResponse(long j, long j2, boolean z) {
                }

                public void onResponseSuccess(String str) {
                    MLogger.d(IResponseListener.TAG, "onResponseSuccess:startProcessForThirdPartyApk:With Apk Info ", str);
                }
            });
            setGameIdInDatabase(apkInfo.getGameId().intValue(), this.mDownloadRequestId);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("Game Name", apkInfo.getGameName());
                jSONObject.put("Game Id", apkInfo.getGameId());
                jSONObject.put(AssetsAnalytics.PROP_GAME_DOWNLOAD_SIZE, apkInfo.getSize());
                jSONObject.put(AssetsAnalytics.PROP_GAME_VERSION, apkInfo.getGameVersion());
                jSONObject.put(AssetsAnalytics.PROP_IS_FORCE_UPDATE, apkInfo.getForceUpdate());
                jSONObject.put(AssetsAnalytics.PROP_GAME_PLAYED, Double.parseDouble(apkInfo.getGamePlays()));
                jSONObject.put(AssetsAnalytics.PROP_GAME_INSTALL_COUNT, Double.parseDouble(apkInfo.getInstalls()));
                CleverTapAnalyticsUtils.sendEvent((String) AssetsAnalytics.EVENT_GAME_DOWNLOAD_INITIATED, jSONObject.toString());
            } catch (Exception unused) {
                MLogger.e(TAG, "startProcessForThirdPartyApk:With Apk Info ");
            }
            MSharedPreferencesUtils.saveIntInNormalPref(this.mContext, Constant.THIRD_PARTY_APK_GAME_STATUS, String.valueOf(this.mDownloadRequestId), apkInfo.getGameId().intValue());
            saveDownloadId(apkInfo.getGameId().intValue(), Integer.parseInt(apkInfo.getGameVersion()), this.mDownloadRequestId);
            checkDownloadProgress(apkInfo.getGameId().intValue(), Integer.parseInt(apkInfo.getGameVersion()), logo, apkInfo.getGameName(), packageName, this.mDownloadRequestId, apkInfo.getForceUpdate());
            promise2.resolve("third_party_apk_downloading");
            sendDownloadAttribution(apkInfo);
            return;
        }
        getThirdPartyApkDownloadProgressStatus(j, apkInfo, promise2);
    }

    private void getThirdPartyApkDownloadProgressStatus(long j, ApkInfo apkInfo, Promise promise) {
        int apkDownloadStatus = getApkDownloadStatus(j);
        MLogger.d(TAG, "getThirdPartyApkDownloadProgressStatus: ", Integer.valueOf(apkDownloadStatus));
        if (apkDownloadStatus == 8) {
            String apkDownloadedFilePath = FileUtils.getApkDownloadedFilePath(this.mContext, j);
            MLogger.d(TAG, "getThirdPartyApkDownloadProgressStatus: ", apkDownloadedFilePath);
            if (TextUtils.isEmpty(apkDownloadedFilePath)) {
                MLogger.d(TAG, "getThirdPartyApkDownloadProgressStatus: file path is empty");
                deleteGameDownloadPref(Long.parseLong(apkInfo.getGameVersion()), apkInfo.getGameId().intValue());
                promise.resolve("third_party_apk_corrupted");
            } else if (new File(Uri.parse(apkDownloadedFilePath).getPath()).exists()) {
                promise.resolve("install_downloaded_third_party_apk");
                MLogger.d(TAG, "getThirdPartyApkDownloadProgressStatus: file not present");
            } else {
                MLogger.d(TAG, "getThirdPartyApkDownloadProgressStatus: file not present apk is currupted");
                deleteGameDownloadPref(Long.parseLong(apkInfo.getGameVersion()), apkInfo.getGameId().intValue());
                promise.resolve("third_party_apk_corrupted");
            }
        } else if (apkDownloadStatus == 16) {
            DownloadManager downloadManager = (DownloadManager) this.mContext.getSystemService(Constant.DOWNLOAD);
            if (downloadManager != null) {
                downloadManager.remove(new long[]{this.mDownloadRequestId});
            }
            if (apkInfo != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("Game Name", apkInfo.getGameName());
                    jSONObject.put("Game Id", apkInfo.getGameId());
                    jSONObject.put(AssetsAnalytics.PROP_GAME_DOWNLOAD_SIZE, apkInfo.getSize());
                    jSONObject.put(AssetsAnalytics.PROP_GAME_VERSION, apkInfo.getGameVersion());
                    jSONObject.put(AssetsAnalytics.PROP_IS_FORCE_UPDATE, apkInfo.getForceUpdate());
                    jSONObject.put(AssetsAnalytics.PROP_GAME_PLAYED, Double.parseDouble(apkInfo.getGamePlays()));
                    jSONObject.put(AssetsAnalytics.PROP_GAME_INSTALL_COUNT, Double.parseDouble(apkInfo.getInstalls()));
                    jSONObject.put("Is Success", false);
                    CleverTapAnalyticsUtils.sendEvent((String) AssetsAnalytics.EVENT_GAME_DOWNLOAD_COMPLETED, jSONObject.toString());
                    deleteGameDownloadPref(Long.parseLong(apkInfo.getGameVersion()), apkInfo.getGameId().intValue());
                } catch (Exception unused) {
                    MLogger.e(TAG, "Game Download Completed: ");
                }
            }
            promise.resolve("third_party_apk_downloading_failed");
        } else if (apkDownloadStatus == 2 || apkDownloadStatus == 4) {
            promise.resolve("third_party_apk_downloading");
            if (apkInfo != null) {
                checkDownloadProgress(apkInfo, j);
            } else {
                MLogger.d(TAG, "getThirdPartyApkDownloadProgressStatus: game info is null");
            }
            this.mDownloadRequestId = j;
        } else {
            promise.resolve("third_party_apk_unknown");
        }
    }
}
