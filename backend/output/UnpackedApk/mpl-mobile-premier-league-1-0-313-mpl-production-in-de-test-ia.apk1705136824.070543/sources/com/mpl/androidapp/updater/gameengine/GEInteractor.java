package com.mpl.androidapp.updater.gameengine;

import android.app.job.JobParameters;
import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.StatFs;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.EventPublishHelper;
import com.mpl.androidapp.appdetails.StorageInformation;
import com.mpl.androidapp.cleverTap.AssetsAnalytics;
import com.mpl.androidapp.cleverTap.AssetsAnalyticsProps;
import com.mpl.androidapp.config.UpdaterAnalytics;
import com.mpl.androidapp.notification.NotificationBuilder;
import com.mpl.androidapp.react.MPLReactContainerActivity;
import com.mpl.androidapp.react.RNListener;
import com.mpl.androidapp.updater.downloadmanager.DownloadFeature;
import com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams;
import com.mpl.androidapp.updater.downloadmanager.di.entrypoints.AssetDownloadEntryPoint;
import com.mpl.androidapp.updater.job.JobSchedulerHelper;
import com.mpl.androidapp.updater.model.GameAssets;
import com.mpl.androidapp.updater.repo.DownloadHelper;
import com.mpl.androidapp.updater.repo.ResponseListener;
import com.mpl.androidapp.updater.util.GEUtil;
import com.mpl.androidapp.updater.util.MD5Helper;
import com.mpl.androidapp.updater.util.ResponseUtil;
import com.mpl.androidapp.updater.util.UpdaterConstant.Event;
import com.mpl.androidapp.utils.AssetsConfigReader;
import com.mpl.androidapp.utils.AssetsUtils;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.CommonUtils;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.Constant.EventsConstants;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.mpl.network.modules.MClient;
import com.mpl.network.modules.listeners.IResponseListener;
import com.mpl.network.modules.request.MOkHttpDownloadRequest;
import com.mpl.network.modules.request.RequestPriority;
import com.mpl.securepreferences.MPreferences;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.fontbox.cmap.CMapParser;
import org.json.JSONObject;

public class GEInteractor implements Interactor {
    public static GEInteractor INSTANCE = null;
    public static final long SIZE_KB = 1024;
    public static final long SIZE_MB = 1048576;
    public static final String TAG = "GEInteractor<--->Assets_Download_Checking-->";
    public final HashMap<Integer, Integer> idProgress = new HashMap<>();
    public NotificationBuilder mNotificationBuilder;

    public static byte[] GetMD5HashOfString(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("md5");
            instance.reset();
            instance.update(str.getBytes());
            return instance.digest();
        } catch (Throwable th) {
            MLogger.e(TAG, th);
            return null;
        }
    }

    public static String GetMD5HashOfStringNew(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest instance = MessageDigest.getInstance("md5");
            instance.reset();
            instance.update(str.getBytes());
            for (byte b2 : instance.digest()) {
                sb.append(Integer.toHexString((b2 & 240) >> 4));
                sb.append(Integer.toHexString(b2 & 15));
            }
        } catch (Throwable th) {
            MLogger.e(TAG, "GetMD5HashOfStringNew: ", th);
        }
        return sb.toString();
    }

    public static String dirMD5(String str) {
        StringBuilder sb = new StringBuilder();
        File[] listFiles = new File(str).listFiles();
        int i = 0;
        while (listFiles != null && i < listFiles.length) {
            sb.append(getMd5OfFileNew(listFiles[i].toString()));
            i++;
        }
        return new StringBuilder(GetMD5HashOfStringNew(sb.toString())).toString();
    }

    /* access modifiers changed from: private */
    public void extract(Context context, GameAssets gameAssets, File file, File file2, int i) {
        $$Lambda$GEInteractor$SLWdTw2uiE4rWWKAw4unLeV6Jg r0 = new Runnable(file, file2, gameAssets, context) {
            public final /* synthetic */ File f$1;
            public final /* synthetic */ File f$2;
            public final /* synthetic */ GameAssets f$3;
            public final /* synthetic */ Context f$4;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
            }

            public final void run() {
                GEInteractor.this.lambda$extract$0$GEInteractor(this.f$1, this.f$2, this.f$3, this.f$4);
            }
        };
        new Thread(r0).start();
    }

    private List<Integer> getGameIdToDownloadAssets(Context context) {
        ArrayList arrayList = new ArrayList();
        List<Integer> listOfGameAssetsAvailableArray = AssetsConfigReader.listOfGameAssetsAvailableArray(context);
        boolean z = false;
        for (Integer next : AssetsConfigReader.listOfGameCodeAvailable(context)) {
            if (isAssetsAvailable(context, next.intValue()) || !(listOfGameAssetsAvailableArray == null || listOfGameAssetsAvailableArray.size() == 0 || !listOfGameAssetsAvailableArray.contains(next))) {
                z = true;
            } else {
                arrayList.add(next);
            }
        }
        if (z) {
            initializeGameAssetsFirstTime(context, null);
        }
        return arrayList;
    }

    public static GEInteractor getInstance() {
        GEInteractor gEInteractor;
        GEInteractor gEInteractor2 = INSTANCE;
        if (gEInteractor2 != null) {
            return gEInteractor2;
        }
        synchronized (GEInteractor.class) {
            try {
                gEInteractor = new GEInteractor();
                INSTANCE = gEInteractor;
            }
        }
        return gEInteractor;
    }

    public static String getMd5OfFile(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[1024];
            MessageDigest instance = MessageDigest.getInstance("MD5");
            int i = 0;
            while (i != -1) {
                i = fileInputStream.read(bArr);
                if (i > 0) {
                    instance.update(bArr, 0, i);
                }
            }
            fileInputStream.close();
            for (byte b2 : instance.digest()) {
                sb.append(Integer.toString((b2 & 255) + 256, 16).substring(1));
            }
        } catch (Throwable th) {
            MLogger.e(TAG, th);
        }
        return sb.toString().toUpperCase();
    }

    public static String getMd5OfFileNew(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[1024];
            MessageDigest instance = MessageDigest.getInstance("MD5");
            int i = 0;
            while (i != -1) {
                i = fileInputStream.read(bArr);
                if (i > 0) {
                    instance.update(bArr, 0, i);
                }
            }
            fileInputStream.close();
            for (byte b2 : instance.digest()) {
                sb.append(Integer.toString((b2 & 255) + 256, 16).substring(1));
            }
        } catch (Throwable th) {
            MLogger.e(TAG, "getMd5OfFileNew: ", th);
        }
        return sb.toString().toUpperCase();
    }

    private void initDownloadManager(Context context, GameAssets gameAssets, int i, String str, File file, int i2, long j) {
        try {
            gameAssets.setGameId(i);
            AssetsUtils.addCurrentlyDownloadingAssetsIds(i);
            try {
                DownloadTaskParams downloadTaskParams = new DownloadTaskParams(gameAssets.getUrl(), i, str, file.getAbsolutePath(), gameAssets, i2, j, this.idProgress.get(Integer.valueOf(i)).intValue(), false);
                AssetDownloadEntryPoint assetDownloadEntryPoint = (AssetDownloadEntryPoint) TweetUtils.get(TweetUtils.getApplication(context.getApplicationContext()), AssetDownloadEntryPoint.class);
                DownloadFeature downloadFeature = new DownloadFeature(downloadTaskParams, assetDownloadEntryPoint.downloadAssetsService(), assetDownloadEntryPoint.downloadProgressAssetsService(), assetDownloadEntryPoint.gameAssetResourceRepo(), assetDownloadEntryPoint.getGameResourceUseCase(), assetDownloadEntryPoint.updateAssetsAnalyticsUseCase(), assetDownloadEntryPoint.InsertAssetEntryUseCase(), assetDownloadEntryPoint.ioDispatcher(), false);
                downloadFeature.runFeature();
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            MLogger.e(TAG, "", e);
        }
    }

    public static boolean isValidGameAssets(Context context, int i, boolean z, String str, boolean z2) {
        String str2;
        Context context2 = context;
        int changeToBattleGameId = AssetsUtils.isMergedAssetsAreDownloaded(i) ? CommonUtils.changeToBattleGameId(i) : i;
        MLogger.d(TAG, "isValidGameAssets before hash checking", "\nGameId: ", Integer.valueOf(changeToBattleGameId), "\nhash: ", str, "\nisAssetsDirEnabled: ", Boolean.valueOf(z2), "\nIsFromGame: ", Boolean.valueOf(z));
        if (!AssetsUtils.isGameAssetsVersionValid(context2, changeToBattleGameId)) {
            return false;
        }
        File file = new File(GEUtil.getGameAssetsPathByGameId(context2, changeToBattleGameId));
        File[] listFiles = file.listFiles();
        if (GEUtil.validateGameJson(context2, changeToBattleGameId)) {
            HashMap<String, String> fileHashForAssets = GEUtil.getFileHashForAssets(context2, changeToBattleGameId);
            if (fileHashForAssets == null || fileHashForAssets.size() == 0 || listFiles == null || listFiles.length == 0 || fileHashForAssets.get(Constant.JSON_LENGTH) == null || TextUtils.isEmpty(fileHashForAssets.get(Constant.JSON_LENGTH)) || Integer.parseInt(fileHashForAssets.get(Constant.JSON_LENGTH)) != listFiles.length - 1) {
                return false;
            }
            for (File file2 : listFiles) {
                if (!"mpl-manifest.json".equals(file2.getName())) {
                    String md5OfFile = getMd5OfFile(file2.toString());
                    MLogger.d(TAG, "md5Files of ", file2.getName(), md5OfFile);
                    if (!fileHashForAssets.containsKey(file2.getName()) || TextUtils.isEmpty(fileHashForAssets.get(file2.getName())) || !md5OfFile.equalsIgnoreCase(fileHashForAssets.get(file2.getName()))) {
                        MLogger.d(TAG, "Assets is modified");
                        return false;
                    }
                }
            }
            if (z2) {
                if (z) {
                    MLogger.d(TAG, Constant.ASSETS_CHECKING, "isValidGameAssets: Taking hash from prams");
                    str2 = str;
                } else {
                    MLogger.d(TAG, "isValidGameAssets: Taking hash from preferences");
                    str2 = MSharedPreferencesUtils.getGameHashForGameId(changeToBattleGameId).toUpperCase();
                }
                String upperCase = dirMD5(file.getAbsolutePath()).toUpperCase();
                MLogger.d(TAG, "isValidGameAssets:After hash checking HashCompare: ", "\nGame ID: ", Integer.valueOf(changeToBattleGameId), "\nIs From Game: ", Boolean.valueOf(z), "\nPath: ", file.getAbsolutePath(), "\nSavedHash: ", str2, "\nCalculatedHash: ", upperCase);
                if (TextUtils.isEmpty(str2) || !upperCase.equalsIgnoreCase(str2)) {
                    MLogger.d(TAG, "isValidGameAssets: HashCompare: Directory Hash is not valid");
                    HashMap hashMap = new HashMap();
                    hashMap.put("Game Id", String.valueOf(changeToBattleGameId));
                    hashMap.put(EventsConstants.PARAMS_TRIGGER_REASON, "Asset Bundle Directory Mismatch");
                    hashMap.put(EventsConstants.PARAMS_ACTION_TAKEN, "Nothing");
                    hashMap.put("Start Time", String.valueOf(System.currentTimeMillis()));
                    CleverTapAnalyticsUtils.sendEvent((String) Constant.EVENT_USER_GAME_FRAUD, hashMap);
                    return false;
                }
                MLogger.d(TAG, "isValidGameAssets: Directory hash passed");
            } else {
                MLogger.d(TAG, "isValidGameAssets: Directory check is disabled");
            }
            return true;
        }
        MLogger.d(TAG, "JSON is modified");
        return false;
    }

    /* access modifiers changed from: private */
    public void publishProgress(int i, int i2) {
        try {
            MLogger.d(TAG, "publishProgress() called with: id = [" + i + "], progress = [" + i2 + CMapParser.MARK_END_OF_ARRAY);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", i);
            jSONObject.put("progress", i2);
            Bundle bundle = new Bundle();
            bundle.putString(Event.DOWNLOADED_ASSETS_DATA, jSONObject.toString());
            if (MPLReactContainerActivity.resultReceiver != null) {
                MPLReactContainerActivity.resultReceiver.send(i2 == -3333 ? 23 : 3, bundle);
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "", e2);
        }
    }

    private void sendEvent(int i, long j, long j2) {
        HashMap hashMap = new HashMap();
        hashMap.put("Game Name", CommonUtils.getGameNameForID(i));
        hashMap.put("Game ID", String.valueOf(i));
        hashMap.put("Freed Space", Long.valueOf(j));
        hashMap.put("New Size", Long.valueOf(j2));
        CleverTapAnalyticsUtils.sendEvent((String) "Game Assets Deleted", hashMap);
    }

    public boolean canGameLaunch(Context context, int i) {
        return isGameCodeAvailable(context, i) && isAssetsAvailable(context, i);
    }

    public void copyAssets(Context context) {
        CommonUtils.copyAssetZipToExternalStorage(context, GEUtil.getGameAssetsRelativeZipPath(), GEUtil.getGameAssetsInternalStorageZipPath(context));
    }

    public boolean deleteAssets(Context context, int i) {
        MLogger.i(TAG, "deleteAssets: ", Integer.valueOf(i));
        if (isAssetsAvailable(context, i)) {
            return deleteRecursive(new File(GEUtil.getGameAssetsPathByGameId(context, i)));
        }
        return false;
    }

    public void deleteAssetsBasedOnGamePlayed(JobParameters jobParameters, Context context) {
        Context context2 = context;
        int i = 2;
        try {
            if (!(MPreferences.getSecure() == null || MPreferences.getGeneral() == null)) {
                List<Integer> listOfGameCodeAvailable = AssetsConfigReader.listOfGameCodeAvailable(context);
                StorageInformation storageInformation = new StorageInformation(context2);
                int i2 = 1;
                while (listOfGameCodeAvailable != null && i2 < listOfGameCodeAvailable.size()) {
                    if (i2 != i) {
                        long currentTimeMillis = System.currentTimeMillis() - MSharedPreferencesUtils.getGamePlayedTime(i2);
                        long minGamePlayedTimeForDeletionFromConfig = MSharedPreferencesUtils.getMinGamePlayedTimeForDeletionFromConfig();
                        long currentTimeMillis2 = System.currentTimeMillis() - MSharedPreferencesUtils.getAssetsDownloadTime(i2);
                        Object[] objArr = new Object[8];
                        objArr[0] = JobSchedulerHelper.TAG;
                        objArr[1] = Integer.valueOf(i2);
                        objArr[i] = "timeInterval";
                        objArr[3] = Long.valueOf(currentTimeMillis);
                        objArr[4] = "timeIntervalFromConfig";
                        objArr[5] = Long.valueOf(minGamePlayedTimeForDeletionFromConfig);
                        objArr[6] = "assetsDownloadTimeInterval";
                        objArr[7] = Long.valueOf(currentTimeMillis2);
                        MLogger.d(TAG, objArr);
                        if (currentTimeMillis > minGamePlayedTimeForDeletionFromConfig || currentTimeMillis2 > minGamePlayedTimeForDeletionFromConfig) {
                            long j = storageInformation.getpackageSize();
                            try {
                                if (deleteAssets(context2, i2)) {
                                    MLogger.d(TAG, JobSchedulerHelper.TAG, "onStartJob deleting assets for game id", Integer.valueOf(i2), Boolean.TRUE);
                                    long j2 = storageInformation.getpackageSize();
                                    MSharedPreferencesUtils.putOrUpdateGamePlayedTime(i2);
                                    MSharedPreferencesUtils.putAssetsDownloadTime(i2);
                                    sendEvent(i2, j - j2, j2);
                                }
                                i2++;
                                i = 2;
                            } catch (Exception e2) {
                                e = e2;
                                MLogger.e(TAG, "deleteAssetsBasedOnGamePlayed: ", e);
                            }
                        }
                    }
                    i2++;
                    i = 2;
                }
            }
        } catch (Exception e3) {
            e = e3;
            MLogger.e(TAG, "deleteAssetsBasedOnGamePlayed: ", e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0048, code lost:
        com.mpl.androidapp.utils.MSharedPreferencesUtils.saveBooleanInNormalPref(r10, com.mpl.androidapp.utils.Constant.IS_POKER_ASSETS_DELETED_FIRST_TIME, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004b, code lost:
        throw r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x003b, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        com.mpl.androidapp.utils.MLogger.e(TAG, "deletePokerAssetsForFirstTime: ");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x003d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void deletePokerAssetsForFirstTime(android.content.Context r10, int r11) {
        /*
            r9 = this;
            java.lang.String r0 = "deletePokerAssetsForFirstTime: "
            java.lang.String r1 = "GEInteractor<--->Assets_Download_Checking-->"
            java.lang.String r2 = "isPokerAssetsDeletedFirstTimeV5"
            r3 = 0
            r4 = 1
            boolean r5 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getBooleanInNormalPref(r10, r2, r3)     // Catch:{ Exception -> 0x003d }
            r6 = 3
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x003d }
            r6[r3] = r0     // Catch:{ Exception -> 0x003d }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x003d }
            r6[r4] = r7     // Catch:{ Exception -> 0x003d }
            r7 = 2
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x003d }
            r6[r7] = r8     // Catch:{ Exception -> 0x003d }
            com.mpl.androidapp.utils.MLogger.d(r1, r6)     // Catch:{ Exception -> 0x003d }
            if (r5 != 0) goto L_0x0044
            r9.deleteAssets(r10, r11)     // Catch:{ Exception -> 0x003d }
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x003d }
            java.io.File r6 = r10.getFilesDir()     // Catch:{ Exception -> 0x003d }
            java.lang.String r6 = r6.getAbsolutePath()     // Catch:{ Exception -> 0x003d }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x003d }
            r5.<init>(r6, r11)     // Catch:{ Exception -> 0x003d }
            r9.deleteRecursive(r5)     // Catch:{ Exception -> 0x003d }
            goto L_0x0044
        L_0x003b:
            r11 = move-exception
            goto L_0x0048
        L_0x003d:
            java.lang.Object[] r11 = new java.lang.Object[r4]     // Catch:{ all -> 0x003b }
            r11[r3] = r0     // Catch:{ all -> 0x003b }
            com.mpl.androidapp.utils.MLogger.e(r1, r11)     // Catch:{ all -> 0x003b }
        L_0x0044:
            com.mpl.androidapp.utils.MSharedPreferencesUtils.saveBooleanInNormalPref(r10, r2, r4)
            return
        L_0x0048:
            com.mpl.androidapp.utils.MSharedPreferencesUtils.saveBooleanInNormalPref(r10, r2, r4)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.updater.gameengine.GEInteractor.deletePokerAssetsForFirstTime(android.content.Context, int):void");
    }

    public void deletePreBundleAssetsDueToArtChange(final Context context) {
        MLogger.d(TAG, "deletePreBundleAssetsDueToArtChange: ");
        new Thread(new Runnable() {
            public void run() {
                try {
                    for (GameAssets next : AssetsConfigReader.listOfGameAssetsAvailable(context)) {
                        GEInteractor.this.deleteAssets(context, next.getGameId());
                        GEInteractor.this.deleteRecursive(new File(context.getFilesDir().getAbsolutePath(), String.valueOf(next.getGameId())));
                    }
                } catch (Exception e2) {
                    MLogger.e(GEInteractor.TAG, "run:deletePreBundleAssetsDueToArtChange ", e2);
                }
            }
        }).start();
    }

    public boolean deleteRecursive(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            int i = 0;
            while (listFiles != null && i < listFiles.length) {
                deleteRecursive(listFiles[i]);
                i++;
            }
        }
        return file.delete();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:6|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0034, code lost:
        com.mpl.androidapp.utils.MSharedPreferencesUtils.saveBooleanInNormalPref(r10, com.mpl.androidapp.utils.Constant.IS_RUMMY_ASSETS_DELETED_FIRST_TIME, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0037, code lost:
        throw r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0027, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        com.mpl.androidapp.utils.MLogger.e(TAG, "deleteRummyAssetsForFirstTime: ");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0029 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void deleteRummyAssetsForFirstTime(android.content.Context r10, int r11) {
        /*
            r9 = this;
            java.lang.String r0 = "deleteRummyAssetsForFirstTime: "
            java.lang.String r1 = "GEInteractor<--->Assets_Download_Checking-->"
            java.lang.String r2 = "isRummyAssetsDeletedFirstTime"
            r3 = 0
            r4 = 1
            boolean r5 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getBooleanInNormalPref(r10, r2, r3)     // Catch:{ Exception -> 0x0029 }
            r6 = 3
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0029 }
            r6[r3] = r0     // Catch:{ Exception -> 0x0029 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x0029 }
            r6[r4] = r7     // Catch:{ Exception -> 0x0029 }
            r7 = 2
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x0029 }
            r6[r7] = r8     // Catch:{ Exception -> 0x0029 }
            com.mpl.androidapp.utils.MLogger.d(r1, r6)     // Catch:{ Exception -> 0x0029 }
            if (r5 != 0) goto L_0x0030
            r9.deleteAssets(r10, r11)     // Catch:{ Exception -> 0x0029 }
            goto L_0x0030
        L_0x0027:
            r11 = move-exception
            goto L_0x0034
        L_0x0029:
            java.lang.Object[] r11 = new java.lang.Object[r4]     // Catch:{ all -> 0x0027 }
            r11[r3] = r0     // Catch:{ all -> 0x0027 }
            com.mpl.androidapp.utils.MLogger.e(r1, r11)     // Catch:{ all -> 0x0027 }
        L_0x0030:
            com.mpl.androidapp.utils.MSharedPreferencesUtils.saveBooleanInNormalPref(r10, r2, r4)
            return
        L_0x0034:
            com.mpl.androidapp.utils.MSharedPreferencesUtils.saveBooleanInNormalPref(r10, r2, r4)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.updater.gameengine.GEInteractor.deleteRummyAssetsForFirstTime(android.content.Context, int):void");
    }

    public void downloadGameAssets(Context context, int i, int i2) {
        Iterator<Integer> it;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Integer num;
        int i3 = i;
        int gameVersion = AssetsUtils.getGameVersion(i);
        this.mNotificationBuilder = new NotificationBuilder(context);
        Integer valueOf = Integer.valueOf(0);
        MLogger.d(TAG, "downloadGameAssets: ", "Game id", Integer.valueOf(i));
        File gameAssetsDownloadDirPath = GEUtil.getGameAssetsDownloadDirPath(context);
        if (gameAssetsDownloadDirPath.exists() || gameAssetsDownloadDirPath.mkdirs()) {
            String str7 = "guest";
            String str8 = "gameId";
            String str9 = "gameVersion";
            String str10 = "assets";
            String str11 = "v2";
            List<Integer> gameIdToDownloadAssets = getGameIdToDownloadAssets(context);
            String str12 = "updates";
            if (i3 == 0) {
                File file = gameAssetsDownloadDirPath;
                Iterator<Integer> it2 = gameIdToDownloadAssets.iterator();
                while (it2.hasNext()) {
                    int intValue = it2.next().intValue();
                    String str13 = str11;
                    if (!isAssetsAvailable(context, intValue)) {
                        it = it2;
                        this.idProgress.put(Integer.valueOf(intValue), valueOf);
                        Uri parse = Uri.parse(Constant.SET_BASE_URL);
                        Builder builder = new Builder();
                        num = valueOf;
                        builder.scheme(parse.getScheme());
                        builder.authority(parse.getAuthority());
                        builder.appendPath(str12);
                        if (AssetsUtils.isAssetsVersioningEnabled(intValue) || AssetsUtils.isNewAssetsApiCallRequiredV2(intValue)) {
                            builder.appendPath(str13);
                        }
                        builder.appendPath(str10);
                        if (MSharedPreferencesUtils.getGuestUserLogin()) {
                            builder.appendPath(str7);
                        }
                        builder.appendPath(String.valueOf(intValue));
                        builder.appendQueryParameter(str8, Uri.encode(String.valueOf(intValue)));
                        builder.appendQueryParameter(str9, Uri.encode("0"));
                        builder.appendQueryParameter("unityVersion", Uri.encode("19"));
                        builder.appendQueryParameter("isCountryCodeEnabled", String.valueOf(true));
                        builder.appendQueryParameter("locationVersion", String.valueOf(2));
                        String uri = builder.build().toString();
                        DownloadHelper instance = DownloadHelper.getInstance();
                        String outline41 = GeneratedOutlineSupport.outline41("assets_download_v2_", intValue);
                        str6 = str7;
                        str5 = str13;
                        str4 = str12;
                        str3 = str10;
                        final int i4 = intValue;
                        final Context context2 = context;
                        str2 = str9;
                        final File file2 = file;
                        str = str8;
                        final int i5 = i2;
                        AnonymousClass2 r0 = new ResponseListener() {
                            public void onFailure(String str) {
                                MLogger.d(GEInteractor.TAG, "Download failed");
                                AssetsAnalyticsProps assetsAnalyticsProps = new AssetsAnalyticsProps();
                                assetsAnalyticsProps.setAvailableOnServer(false);
                                assetsAnalyticsProps.setGameId(i4);
                                assetsAnalyticsProps.setInstalledVersion(MSharedPreferencesUtils.getDownloadedAssetVersion(context2, i4, 0));
                                assetsAnalyticsProps.setServerVersion(0);
                                assetsAnalyticsProps.setUpdateAssets(false);
                                AssetsAnalytics.sendGameFileAvailableEvent(assetsAnalyticsProps);
                            }

                            public void onSuccess(String str) {
                                GameAssets parseAssetsDetails = ResponseUtil.parseAssetsDetails(str);
                                boolean z = true;
                                MLogger.d(GEInteractor.TAG, parseAssetsDetails.toString());
                                String outline57 = GeneratedOutlineSupport.outline57(new StringBuilder(), i4, ".zip");
                                UpdaterAnalytics.gameAssetsAvailableEvent(parseAssetsDetails.getGameName(), i4, false, parseAssetsDetails);
                                AssetsAnalyticsProps assetsAnalyticsProps = new AssetsAnalyticsProps();
                                assetsAnalyticsProps.setAvailableOnServer(true);
                                if (parseAssetsDetails.getGameVersion() <= 1) {
                                    z = false;
                                }
                                assetsAnalyticsProps.setUpdateAssets(z);
                                assetsAnalyticsProps.setAssetsVersion(parseAssetsDetails.getAssetVersion());
                                assetsAnalyticsProps.setGameName(parseAssetsDetails.getGameName());
                                assetsAnalyticsProps.setGameId(i4);
                                assetsAnalyticsProps.setServerVersion(parseAssetsDetails.getAssetVersion());
                                assetsAnalyticsProps.setInstalledVersion(MSharedPreferencesUtils.getDownloadedAssetVersion(context2, i4, 0));
                                assetsAnalyticsProps.setAssetsSize(parseAssetsDetails.getSize());
                                AssetsAnalytics.sendGameFileAvailableEvent(assetsAnalyticsProps);
                                if (AssetsUtils.isNewDownloader(i4)) {
                                    GEInteractor.this.downloadGameAssetsV2(context2, parseAssetsDetails, i4, outline57, file2, i5);
                                } else {
                                    GEInteractor.this.downloadGameAssets(context2, parseAssetsDetails, i4, outline57, file2, i5);
                                }
                            }
                        };
                        instance.getDownloadUrl(uri, outline41, r0);
                    } else {
                        str5 = str13;
                        str4 = str12;
                        str3 = str10;
                        str2 = str9;
                        str = str8;
                        it = it2;
                        num = valueOf;
                        str6 = str7;
                    }
                    it2 = it;
                    valueOf = num;
                    str7 = str6;
                    str11 = str5;
                    str12 = str4;
                    str10 = str3;
                    str9 = str2;
                    str8 = str;
                }
            } else if (!isAssetsAvailable(context, i)) {
                File file3 = gameAssetsDownloadDirPath;
                this.idProgress.put(Integer.valueOf(i), valueOf);
                Uri parse2 = Uri.parse(Constant.SET_BASE_URL);
                Builder builder2 = new Builder();
                builder2.scheme(parse2.getScheme());
                builder2.authority(parse2.getAuthority());
                builder2.appendPath(str12);
                if (AssetsUtils.isAssetsVersioningEnabled(i) || AssetsUtils.isNewAssetsApiCallRequiredV2(i)) {
                    builder2.appendPath(str11);
                }
                builder2.appendPath(str10);
                if (MSharedPreferencesUtils.getGuestUserLogin()) {
                    builder2.appendPath(str7);
                }
                builder2.appendPath(String.valueOf(i));
                builder2.appendQueryParameter(str9, Uri.encode(String.valueOf(gameVersion)));
                builder2.appendQueryParameter(str8, Uri.encode(String.valueOf(i)));
                builder2.appendQueryParameter("unityVersion", Uri.encode("19"));
                builder2.appendQueryParameter("isCountryCodeEnabled", String.valueOf(true));
                builder2.appendQueryParameter("locationVersion", String.valueOf(2));
                String uri2 = builder2.build().toString();
                DownloadHelper instance2 = DownloadHelper.getInstance();
                String outline412 = GeneratedOutlineSupport.outline41("assets_download_v2_", i3);
                final Context context3 = context;
                final int i6 = i;
                final File file4 = file3;
                final int i7 = i2;
                AnonymousClass1 r02 = new ResponseListener() {
                    public void onFailure(String str) {
                        MLogger.d(GEInteractor.TAG, "Download failed");
                        GEInteractor.this.publishProgress(i6, Constant.ASSETS_DOWNLOAD_FAILED_CODE);
                        GEInteractor.this.publishProgress(context3, i6, Constant.ASSETS_DOWNLOAD_FAILED_CODE);
                        AssetsAnalyticsProps assetsAnalyticsProps = new AssetsAnalyticsProps();
                        assetsAnalyticsProps.setAvailableOnServer(false);
                        assetsAnalyticsProps.setGameId(i6);
                        assetsAnalyticsProps.setInstalledVersion(MSharedPreferencesUtils.getDownloadedAssetVersion(context3, i6, 0));
                        assetsAnalyticsProps.setServerVersion(0);
                        assetsAnalyticsProps.setUpdateAssets(false);
                        AssetsAnalytics.sendGameFileAvailableEvent(assetsAnalyticsProps);
                    }

                    public void onSuccess(String str) {
                        GameAssets parseAssetsDetails = ResponseUtil.parseAssetsDetails(str);
                        boolean z = true;
                        if (parseAssetsDetails == null || GEInteractor.this.isAssetsAvailable(context3, i6)) {
                            MLogger.d(GEInteractor.TAG, "Null response");
                        } else if (GEInteractor.this.isSpaceAvailable(context3)) {
                            MLogger.d(GEInteractor.TAG, parseAssetsDetails.toString());
                            String outline57 = GeneratedOutlineSupport.outline57(new StringBuilder(), i6, ".zip");
                            UpdaterAnalytics.gameAssetsAvailableEvent(parseAssetsDetails.getGameName(), i6, false, parseAssetsDetails);
                            AssetsAnalyticsProps assetsAnalyticsProps = new AssetsAnalyticsProps();
                            assetsAnalyticsProps.setAvailableOnServer(true);
                            if (parseAssetsDetails.getGameVersion() <= 1) {
                                z = false;
                            }
                            assetsAnalyticsProps.setUpdateAssets(z);
                            assetsAnalyticsProps.setAssetsVersion(parseAssetsDetails.getAssetVersion());
                            assetsAnalyticsProps.setGameName(parseAssetsDetails.getGameName());
                            assetsAnalyticsProps.setGameId(i6);
                            assetsAnalyticsProps.setServerVersion(parseAssetsDetails.getAssetVersion());
                            assetsAnalyticsProps.setInstalledVersion(MSharedPreferencesUtils.getDownloadedAssetVersion(context3, i6, 0));
                            assetsAnalyticsProps.setAssetsSize(parseAssetsDetails.getSize());
                            AssetsAnalytics.sendGameFileAvailableEvent(assetsAnalyticsProps);
                            if (AssetsUtils.isNewDownloader(i6)) {
                                GEInteractor.this.downloadGameAssetsV2(context3, parseAssetsDetails, i6, outline57, file4, i7);
                            } else {
                                GEInteractor.this.downloadGameAssets(context3, parseAssetsDetails, i6, outline57, file4, i7);
                            }
                        } else {
                            UpdaterAnalytics.lowStoragePromptedEvent(UpdaterAnalytics.GAME, String.valueOf(i6), (int) parseAssetsDetails.getSize());
                        }
                    }
                };
                instance2.getDownloadUrl(uri2, outline412, r02);
            }
            return;
        }
        MLogger.e(TAG, "downloadGameAssets: ", "Something went wrong while creating dir for assets");
    }

    public void downloadGameAssetsV2(Context context, GameAssets gameAssets, int i, String str, File file, int i2) {
        MLogger.d(TAG, "downloadGameAssets: ", gameAssets, str, Integer.valueOf(i2));
        initDownloadManager(context, gameAssets, i, str, file, i2, 1048576);
    }

    public void extractAssets(Context context) {
        try {
            CommonUtils.extractZipFile(new File(GEUtil.getGameAssetsInternalStorageZipPath(context)), new File(GEUtil.getGameDirInternalStoragePath(context)));
        } catch (IOException e2) {
            MLogger.e(TAG, "", e2);
        }
    }

    public void initializeGameAssetsFirstTime(Context context, RNListener rNListener) {
        MLogger.d(TAG, "initializeGameAssetsFirstTime: ");
        new Thread(new Runnable(context, rNListener) {
            public final /* synthetic */ Context f$1;
            public final /* synthetic */ RNListener f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                GEInteractor.this.lambda$initializeGameAssetsFirstTime$1$GEInteractor(this.f$1, this.f$2);
            }
        }).start();
    }

    public boolean isAssetsAvailable(Context context, int i) {
        return new File(GEUtil.getGameAssetsPathByGameId(context, i)).exists();
    }

    public boolean isGameCodeAvailable(Context context, int i) {
        return AssetsConfigReader.listOfGameCodeAvailable(context).contains(Integer.valueOf(i));
    }

    public boolean isSpaceAvailable(Context context) {
        if (!CommonUtils.isExternalStorageWritable()) {
            return false;
        }
        StatFs statFs = new StatFs(GEUtil.getGameDirInternalStoragePath(context));
        long blockSizeLong = statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
        MLogger.d(TAG, "****************************************");
        long j = blockSizeLong / 1048576;
        MLogger.d(TAG, "SPACE Available ", Long.valueOf(blockSizeLong / 1073741824), Long.valueOf(j), Long.valueOf(blockSizeLong / 1024));
        MLogger.d(TAG, "****************************************");
        if (j > 250) {
            return true;
        }
        return false;
    }

    public boolean isSpaceAvailableToInstallApp(Context context) {
        if (!CommonUtils.isExternalStorageWritable()) {
            return false;
        }
        StatFs statFs = new StatFs(GEUtil.getGameDirInternalStoragePath(context));
        if ((statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong()) / 1048576 > 150) {
            return true;
        }
        return false;
    }

    public boolean isValidMD5(Context context, int i, String str, File file) {
        MLogger.d(TAG, "isValidMD5: ", "Game Id:", Integer.valueOf(i), "expectedChecksum:", str);
        return MD5Helper.checkMD5(str, new File(GEUtil.getGameAssetsPathByGameId(context, i)));
    }

    public /* synthetic */ void lambda$extract$0$GEInteractor(File file, File file2, GameAssets gameAssets, Context context) {
        try {
            boolean extractZipFile = CommonUtils.extractZipFile(file, file2);
            String dirMD5 = dirMD5(file2.getAbsolutePath());
            MLogger.d(TAG, "HashCompare: ", "Game ID: ", Integer.valueOf(gameAssets.getGameId()), "Path: ", file2.getAbsolutePath(), "Hash: ", dirMD5);
            MSharedPreferencesUtils.saveGameHashForGameId(gameAssets.getGameId(), dirMD5);
            file.delete();
            UpdaterAnalytics.gameAssetsInstalledEvent(gameAssets.getGameName(), gameAssets.getGameId(), gameAssets, true, false);
            publishProgress(context, gameAssets.getGameId(), 100);
            if (gameAssets.getAssetVersion() != 0) {
                MSharedPreferencesUtils.setDownloadedAssetVersion(context, gameAssets.getGameId(), gameAssets.getAssetVersion());
            } else {
                MSharedPreferencesUtils.setDownloadedAssetVersion(context, gameAssets.getGameId(), AssetsUtils.getGameVersion(gameAssets.getGameId()));
            }
            AssetsAnalyticsProps assetsAnalyticsProps = new AssetsAnalyticsProps();
            assetsAnalyticsProps.setGameName(gameAssets.getGameName());
            assetsAnalyticsProps.setGameId(gameAssets.getGameId());
            assetsAnalyticsProps.setAssetsType("Assets");
            assetsAnalyticsProps.setAssetsInstallSuccess(extractZipFile);
            AssetsAnalytics.sendGameFileInstallStatusEvent(assetsAnalyticsProps);
            AssetsUtils.addGameIdForMergedAssetsDownload(gameAssets.getGameId());
        } catch (IOException e2) {
            MLogger.e(TAG, "", e2);
        }
    }

    public /* synthetic */ void lambda$initializeGameAssetsFirstTime$1$GEInteractor(Context context, RNListener rNListener) {
        List<GameAssets> listOfGameAssetsAvailable = AssetsConfigReader.listOfGameAssetsAvailable(context);
        if (listOfGameAssetsAvailable != null && listOfGameAssetsAvailable.size() > 0) {
            for (int i = 0; i < listOfGameAssetsAvailable.size(); i++) {
                GameAssets gameAssets = listOfGameAssetsAvailable.get(i);
                if (!isAssetsAvailable(context, gameAssets.getGameId())) {
                    UpdaterAnalytics.gameAssetsAvailableEvent(gameAssets.getGameName(), gameAssets.getGameId(), true, gameAssets);
                    UpdaterAnalytics.gameAssetsInstalledEvent(gameAssets.getGameName(), gameAssets.getGameId(), gameAssets, true, true);
                }
                MSharedPreferencesUtils.setDownloadedAssetVersion(context, gameAssets.getGameId(), gameAssets.getAssetVersion());
                AssetsUtils.addGameIdForMergedAssetsDownload(gameAssets.getGameId());
            }
            GEInteractor instance = getInstance();
            instance.copyAssets(context);
            instance.extractAssets(context);
            instance.saveHashForPreBundleAssets(context);
        }
        if (rNListener != null) {
            rNListener.publishResult("Success");
        }
    }

    public String loadAssets(Context context, int i) {
        return GEUtil.getGameAssetsPathByGameId(context, i);
    }

    public void saveHashForPreBundleAssets(Context context) {
        MLogger.d(TAG, "saveHashForPreBundleAssets:HashCompare: ");
        for (GameAssets next : AssetsConfigReader.listOfGameAssetsAvailable(context)) {
            File file = new File(GEUtil.getGameAssetsPathByGameId(context, next.getGameId()));
            String dirMD5 = dirMD5(file.getAbsolutePath());
            MLogger.d(TAG, "HashCompare: ", "\nGame ID: ", Integer.valueOf(next.getGameId()), "\nAssets Version: ", Integer.valueOf(next.getAssetVersion()), "\nPath: ", file.getAbsolutePath(), "\nHash: ", dirMD5);
            MSharedPreferencesUtils.saveGameHashForGameId(next.getGameId(), dirMD5);
            if (AssetsUtils.isPokerGameId(next.getGameId())) {
                AssetsUtils.movePokerAssets(context, next.getGameId(), next.getAssetVersion());
            }
        }
    }

    public boolean isSpaceAvailableToInstallApp(Context context, int i) {
        if (!CommonUtils.isExternalStorageWritable()) {
            return false;
        }
        StatFs statFs = new StatFs(GEUtil.getGameDirInternalStoragePath(context));
        if ((statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong()) / 1048576 > ((long) i)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void publishProgress(Context context, int i, int i2) {
        try {
            MLogger.d(TAG, "publishProgress() called with: context id = [" + i + "], progress = [" + i2 + CMapParser.MARK_END_OF_ARRAY);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", i);
            jSONObject.put("progress", i2);
            Bundle bundle = new Bundle();
            bundle.putString(Event.DOWNLOADED_ASSETS_DATA, jSONObject.toString());
            EventPublishHelper.publishAssetsBundleDownloadedStatusEvent(context, bundle);
        } catch (Exception e2) {
            MLogger.e(TAG, "", e2);
        }
    }

    /* access modifiers changed from: private */
    public void downloadGameAssets(Context context, GameAssets gameAssets, int i, String str, File file, int i2) {
        String str2 = str;
        try {
            gameAssets.setGameId(i);
            final File file2 = new File(file, str2);
            if (!file2.exists()) {
                file2.createNewFile();
            }
            int length = (int) file2.length();
            AssetsUtils.addCurrentlyDownloadingAssetsIds(i);
            int currentlyDownloadingAssetsPosition = AssetsUtils.getCurrentlyDownloadingAssetsPosition(i);
            AssetsAnalyticsProps assetsAnalyticsProps = new AssetsAnalyticsProps();
            assetsAnalyticsProps.setAssetsType("Assets");
            assetsAnalyticsProps.setGameName(gameAssets.getGameName());
            assetsAnalyticsProps.setGameId(gameAssets.getGameId());
            assetsAnalyticsProps.setAssetsSize(gameAssets.getSize());
            assetsAnalyticsProps.setUpdateAssets(gameAssets.getGameVersion() > 1);
            assetsAnalyticsProps.setAssetsVersion(gameAssets.getAssetVersion());
            assetsAnalyticsProps.setQueued(currentlyDownloadingAssetsPosition > 0);
            assetsAnalyticsProps.setQueuePriority(currentlyDownloadingAssetsPosition);
            assetsAnalyticsProps.setDownloadType("New");
            AssetsAnalytics.sendGameFileDownloadInitiatedEvent(assetsAnalyticsProps);
            MOkHttpDownloadRequest.Builder retryOnConnectionFailure = new MOkHttpDownloadRequest.Builder().setUrl(gameAssets.getUrl()).setDestFileName(str2).setDestFile(file2).setHeaders(CommonUtils.getCommonHeaders()).setDownloadedSize((long) length).setRequestPriority(RequestPriority.LOW).setRetryOnConnectionFailure(true);
            MOkHttpDownloadRequest.Builder tag = retryOnConnectionFailure.setTag(Event.GAME_ASSETS_TAG + i);
            final GameAssets gameAssets2 = gameAssets;
            final int i3 = i;
            final Context context2 = context;
            final File file3 = file;
            final int i4 = i2;
            AnonymousClass3 r4 = new IResponseListener<String>() {
                public void onResponseFail(Exception exc) {
                    MLogger.e(IResponseListener.TAG, "onResponseFail:downloadGameAssets ", exc);
                    UpdaterAnalytics.gameAssetsDownloadFailedEvent(gameAssets2.getGameName(), i3, (int) (gameAssets2.getSize() / 1048576), false, gameAssets2, exc);
                    File file = file2;
                    if (file != null && file.exists()) {
                        file2.delete();
                    }
                    AssetsUtils.deleteCurrentlyDownloadingAssetsIds(i3);
                    GEInteractor.this.mNotificationBuilder.buildNotification(gameAssets2.getGameName(), "Game Downloading failed. Please go to game page and try again", i3, i4);
                    GEInteractor.this.publishProgress(i3, Constant.ASSETS_DOWNLOAD_FAILED_CODE);
                    GEInteractor.this.publishProgress(context2, i3, Constant.ASSETS_DOWNLOAD_FAILED_CODE);
                }

                public void progressResponse(long j, long j2, boolean z) {
                    int i = (int) ((((float) j) / ((float) j2)) * 100.0f);
                    int intValue = ((Integer) GEInteractor.this.idProgress.get(Integer.valueOf(i3))).intValue();
                    if (i < 21 && i % 5 == 0 && intValue < i) {
                        GEInteractor.this.idProgress.put(Integer.valueOf(i3), Integer.valueOf(i));
                        GEInteractor.this.publishProgress(i3, i);
                        GEInteractor.this.publishProgress(context2, i3, i);
                    } else if (i % 20 == 0 && intValue < i && i < 100) {
                        GEInteractor.this.idProgress.put(Integer.valueOf(i3), Integer.valueOf(i));
                        GEInteractor.this.publishProgress(i3, i);
                        GEInteractor.this.publishProgress(context2, i3, i);
                    }
                }

                public void onResponseSuccess(String str) {
                    UpdaterAnalytics.gameAssetsDownloadedEvent(gameAssets2.getGameName(), i3, (int) (gameAssets2.getSize() / 1048576), false, gameAssets2);
                    GEInteractor.this.extract(context2, gameAssets2, file2, file3, i4);
                    MSharedPreferencesUtils.putAssetsDownloadTime(i3);
                    AssetsUtils.deleteCurrentlyDownloadingAssetsIds(i3);
                }
            };
            MOkHttpDownloadRequest.Builder responseListener = tag.setResponseListener(r4);
            if (AssetsUtils.isIncreasedTimeOutGameId(i)) {
                MLogger.d(TAG, "downloadGameAssets: Changing timeout for these assets");
                responseListener.setReadTimeout(AssetsUtils.increaseTimeOut());
                responseListener.setWriteTimeout(AssetsUtils.increaseTimeOut());
                responseListener.setConnectTimeout(AssetsUtils.increaseTimeOut());
                responseListener.setPingInterval(AssetsUtils.increaseTimeOut());
                responseListener.setRetryOnConnectionFailure(true);
            }
            MClient.executeAsync(responseListener.build());
        } catch (IOException e2) {
            MLogger.e(TAG, "", e2);
        }
    }
}
