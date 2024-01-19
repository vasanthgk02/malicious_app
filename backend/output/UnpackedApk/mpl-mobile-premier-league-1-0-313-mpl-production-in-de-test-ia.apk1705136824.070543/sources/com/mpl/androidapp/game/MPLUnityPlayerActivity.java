package com.mpl.androidapp.game;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.inca.security.Proxy.iIiIiIiIii;
import com.mpl.androidapp.MPLApplication;
import com.mpl.androidapp.R;
import com.mpl.androidapp.analytics.ExternalAnalytics;
import com.mpl.androidapp.cleverTap.MplCtEventConstants.CtNativeLaunchInitiated;
import com.mpl.androidapp.cleverTap.MplCtEventInitiate;
import com.mpl.androidapp.database.DatabaseClient;
import com.mpl.androidapp.exception.UnityExceptionHandler.ExceptionHandlerCallback;
import com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature.GenericFileDownloadFeatureCallback;
import com.mpl.androidapp.filehandling.downloadservice.models.FeatureFileDownloadInput;
import com.mpl.androidapp.notification.NotificationBuilder;
import com.mpl.androidapp.react.MPLReactContainerActivity;
import com.mpl.androidapp.react.MPLReactContainerActivity.GameEventCallback;
import com.mpl.androidapp.responsiblegaming.RgConfigs;
import com.mpl.androidapp.unity.base.UnityPlayerBaseActivity;
import com.mpl.androidapp.unity.features.InvokeMplFeatures;
import com.mpl.androidapp.updater.gameengine.GEInteractor;
import com.mpl.androidapp.utils.AdsData;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.CommonUtils;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.Constant.ApiEndPoints;
import com.mpl.androidapp.utils.Constant.ChannelConstants;
import com.mpl.androidapp.utils.Constant.EventsConstants;
import com.mpl.androidapp.utils.Constant.VideoRecordingConstants;
import com.mpl.androidapp.utils.DialogData;
import com.mpl.androidapp.utils.DialogData.TYPE;
import com.mpl.androidapp.utils.FileUtils;
import com.mpl.androidapp.utils.GameConstant;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.mpl.androidapp.utils.MTimeListener;
import com.mpl.androidapp.utils.NetworkMonitorUtil.NetworkStateChange;
import com.mpl.androidapp.utils.Util;
import com.mpl.androidapp.utils.WindowUtil;
import com.mpl.androidapp.utils.encryptedPrefs.MEncryptedPrefUtils;
import com.mpl.androidapp.webview.vm.WebViewGameVm;
import com.razorpay.AnalyticsConstants;
import com.unity3d.player.UnityPlayer;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.fontbox.cmap.CMap;
import org.apache.fontbox.cmap.CMapParser;
import org.json.JSONException;
import org.json.JSONObject;

public class MPLUnityPlayerActivity extends UnityPlayerBaseActivity implements ExceptionHandlerCallback, GenericFileDownloadFeatureCallback, GameEventCallback, NetworkStateChange {
    public static final String TAG = "MPLUnityPlayerActivity";
    public static final String TAG_RES = "ResponsibleGamingTimer";
    public static final String V_2_PLAYER_PREFS = ".v2.playerprefs";
    public AlertDialog alertDialog;
    public String crashBattleId = AnalyticsConstants.NOT_AVAILABLE;
    public String gameConfigJson = null;
    public boolean isAdsEnabled;
    public boolean isAssetsHashEnabled;
    public boolean isInternalUser;
    public boolean isKafkaEnabled = false;
    public boolean isMinimized;
    public boolean isOverlayRequired;
    public boolean isQuitRequiredByAndroid = false;
    public String isScreenShotOptions = "default";
    public boolean isScreenshotUiDisabled = false;
    public boolean isVolumeButtonPressed = false;
    public RelativeLayout mAdsView;
    public String mAssetsHash;
    public Bundle mBundle;
    public String mCountryCode;
    public AlertDialog mFraudAlertDialog;
    public int mGameId;
    public final BroadcastReceiver mNetworkChangeListener = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.hasExtra("noConnectivity")) {
                boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
                MLogger.d(MPLUnityPlayerActivity.TAG, "onReceive: ", Boolean.valueOf(booleanExtra));
                if (!booleanExtra) {
                    MPLUnityPlayerActivity.this.initInternalEventSdks();
                }
            }
        }
    };
    public CountDownTimer mNotificationCountDownTimer;
    public boolean mPauseResumeNotificationEnabled;
    public int mTournamentId;
    public int minimizeCount = 0;
    public long minimizedTime;
    public List<Integer> notificationList = new ArrayList();
    public long onCreateTimeStamp;
    public RgConfigs rgConfigs;

    public String GetAssetBundlesDirectory(int i) {
        MLogger.d(TAG, "MPL:", "GetAssetBundlesDirectory: ");
        return GEInteractor.getInstance().loadAssets(this, i);
    }

    public String GetMinimizationData() {
        MLogger.d(TAG, "GetMinimizationData");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isMinimized", this.isMinimized);
            jSONObject.put("minimizedTime", this.minimizedTime);
            jSONObject.put("minimizeCount", this.minimizeCount);
        } catch (Exception e2) {
            MLogger.e(TAG, "GetMinimizationData: ", e2);
        }
        MLogger.d(TAG, "GetMinimizationData: ", jSONObject.toString());
        return jSONObject.toString();
    }

    public String GetSessionConfig() {
        MLogger.d(TAG, "Starting_Game", "GetSessionConfig: ");
        return this.gameConfigJson;
    }

    public String GetSponsorDirectory(int i) {
        MLogger.d(TAG, "MPL:", "GetSponsorDirectory: ");
        return FileUtils.getSponsorDirPathById(this, String.valueOf(i));
    }

    public boolean IsGameAssetsValid(int i) {
        MLogger.d(TAG, Constant.ASSETS_CHECKING, "IsGameAssetsValid: ", Integer.valueOf(i));
        boolean isValidGameAssets = GEInteractor.isValidGameAssets(getApplicationContext(), i, true, this.mAssetsHash, this.isAssetsHashEnabled);
        MLogger.d(TAG, Constant.ASSETS_CHECKING, "IsGameAssetsValid: ", "\nGame Id:", Integer.valueOf(i), "\nAssets Hash:", this.mAssetsHash, "\nIsAssetsHashEnabled:", Boolean.valueOf(this.isAssetsHashEnabled), "\nIs Valid: ", Boolean.valueOf(isValidGameAssets));
        if (!isValidGameAssets) {
            deleteAssetsAndReDownload(i);
        }
        return isValidGameAssets;
    }

    public void IsLocalVoiceChatMute(boolean z) {
        Intent intent = new Intent();
        intent.setAction(VideoRecordingConstants.INIT_RECORDING_MONITORING);
        intent.putExtra(Constant.IS_LOCAL_VOICE_CHAT_MUTED, z);
        sendBroadcast(intent);
    }

    public void IsRemoteVoiceChatMute(boolean z) {
        Intent intent = new Intent();
        intent.setAction(VideoRecordingConstants.INIT_RECORDING_MONITORING);
        intent.putExtra(Constant.IS_REMOTE_VOICE_CHAT_MUTED, z);
        sendBroadcast(intent);
    }

    public void LaunchNativeGame(int i, String str) {
        InvokeMplFeatures.INSTANCE.launchNativeGames(getApplicationContext(), i, str);
    }

    public void Log(String str) {
        MLogger.d(TAG, "Log: ", str);
    }

    public void OnGameLoaded() {
        MLogger.d(TAG, "Starting_Game", "OnGameLoaded: ");
        MLogger.d(TAG, "OnGameLoaded");
    }

    public boolean QuitSession(String str) {
        setRequestedOrientation(7);
        MLogger.d(TAG, "QuitSession: ", "MPLAndroid: Quit Session with params ", str);
        if (TextUtils.isEmpty(str)) {
            redirectToRN("null");
        } else if (TextUtils.isEmpty(str) || !"quit_app".equalsIgnoreCase(str)) {
            redirectToRN(GeneratedOutlineSupport.outline50("quitGame", str));
        } else {
            System.exit(0);
        }
        return true;
    }

    public void RemoveAd(String str) {
        MLogger.d(TAG, "RemoveAd: ", Boolean.valueOf(this.isAdsEnabled));
        if (this.isAdsEnabled && this.mUnityPlayer != null) {
            Activity activity = UnityPlayer.currentActivity;
            if (activity != null) {
                activity.runOnUiThread(new Runnable() {
                    public void run() {
                        if (MPLUnityPlayerActivity.this.mUnityPlayer != null && MPLUnityPlayerActivity.this.mAdsView != null) {
                            MPLUnityPlayerActivity.this.mUnityPlayer.removeView(MPLUnityPlayerActivity.this.mAdsView);
                        }
                    }
                });
            }
        }
    }

    public void SendLocalNotification(String str, String str2) {
        MLogger.d(TAG, "SendLocalNotification: ", GeneratedOutlineSupport.outline53("Sending Local Notification with title: ", str, ", message: ", str2));
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        Notification build = new Builder(getApplicationContext()).setContentTitle(str).setContentText(str2).setSmallIcon(R.drawable.ic_stat_mpl).setWhen(System.currentTimeMillis()).build();
        build.flags |= 16;
        int i = build.defaults | 1;
        build.defaults = i;
        build.defaults = i | 2;
        if (notificationManager != null) {
            notificationManager.notify(0, build);
        }
    }

    public void SendPauseResumeNotification(String str) {
        String str2;
        try {
            MLogger.d(TAG, "SendPauseResumeNotification() called with: notificationData = [" + str2 + CMapParser.MARK_END_OF_ARRAY);
            if (this.mPauseResumeNotificationEnabled && !TextUtils.isEmpty(str) && CommonUtils.isJSONValid(str)) {
                JSONObject jSONObject = new JSONObject(str2);
                final int optInt = jSONObject.optInt("gameId", 0);
                final String optString = jSONObject.optString(WebViewGameVm.KEY_BATTLE_ID, "");
                int optInt2 = jSONObject.optInt("pauseTimer", 60);
                final NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
                if ("resume".equalsIgnoreCase(jSONObject.optString("type", "pause"))) {
                    if (this.mNotificationCountDownTimer != null) {
                        this.mNotificationCountDownTimer.cancel();
                    }
                    notificationManager.cancel(optInt);
                    return;
                }
                String optString2 = jSONObject.optString(WebViewGameVm.KEY_GAME_ICON, "");
                String format = String.format(getString(R.string.tap_to_resume), new Object[]{Integer.valueOf(optInt2)});
                if (!TextUtils.isEmpty(this.mCountryCode) && "ID".equalsIgnoreCase(this.mCountryCode)) {
                    format = String.format(getString(R.string.tap_to_resume_id), new Object[]{Integer.valueOf(optInt2)});
                }
                Intent intent = new Intent(this, MPLUnityPlayerActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Feature", "Minimisation Pause");
                intent.putExtra("Feature", "Minimisation Pause");
                intent.putExtras(bundle);
                long j = (long) (optInt2 * 1000);
                final NotificationCompat.Builder when = new NotificationCompat.Builder((Context) this, (String) ChannelConstants.GAME_PLAY_PAUSE_CHANNEL_ID).setColor(ContextCompat.getColor(this, R.color.notif_action_button)).setContentTitle(jSONObject.optString("title", "")).setContentText(format).setContentIntent(PendingIntent.getActivity(this, (int) Calendar.getInstance().getTimeInMillis(), intent, 134217728)).addExtras(bundle).setSmallIcon((int) R.drawable.ic_stat_mpl).setDefaults(-1).setLargeIcon(getLargeIconInNotification(optString2, this)).setSubText(MBuildConfigUtils.getAppName()).setTimeoutAfter(j).setWhen(System.currentTimeMillis());
                Notification build = when.build();
                build.flags |= 16;
                if (notificationManager != null) {
                    notificationManager.notify(optInt, build);
                }
                sendNotificationReceivedEvent("Minimisation Pause");
                final int[] iArr = {optInt2};
                final int[] iArr2 = {0};
                AnonymousClass4 r0 = new CountDownTimer(j, 1000) {
                    public void onFinish() {
                        MLogger.d(MPLUnityPlayerActivity.TAG, "onFinish:SendPauseResumeNotification ");
                        Intent intent = new Intent(Constant.ACTION_GAME_DISCONNECTION);
                        intent.putExtra(Constant.GAME_DATA, MEncryptedPrefUtils.INSTANCE.getGameData());
                        intent.putExtra(Constant.GAME_CONFIG, MEncryptedPrefUtils.INSTANCE.getGameConfig());
                        MPLUnityPlayerActivity.this.sendBroadcast(intent);
                        Intent intent2 = new Intent(MPLUnityPlayerActivity.this.getApplicationContext(), MPLReactContainerActivity.class);
                        intent2.putExtra("Feature", "Minimisation Timeout");
                        Bundle bundle = new Bundle();
                        bundle.putString("Feature", "Minimisation Timeout");
                        bundle.putString("action", "OPEN_DEEP_LINK");
                        bundle.putString("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"GameHistory\",\"param\":{\"battleId\":\"" + optString + "\",\"gameId\":" + optInt + "}}}");
                        intent2.putExtras(bundle);
                        when.setContentIntent(PendingIntent.getActivity(MPLUnityPlayerActivity.this.getApplicationContext(), (int) Calendar.getInstance().getTimeInMillis(), intent2, 134217728));
                        when.addExtras(bundle);
                        if (TextUtils.isEmpty(MPLUnityPlayerActivity.this.mCountryCode) || !"ID".equalsIgnoreCase(MPLUnityPlayerActivity.this.mCountryCode)) {
                            when.setContentText(MPLUnityPlayerActivity.this.getString(R.string.tap_to_check_result));
                        } else {
                            when.setContentText(MPLUnityPlayerActivity.this.getString(R.string.tap_to_check_result_id));
                        }
                        when.setChannelId(ChannelConstants.GAME_PLAY_PAUSE_CHANNEL_ID);
                        NotificationManager notificationManager = notificationManager;
                        if (notificationManager != null) {
                            notificationManager.notify(optInt, when.build());
                        }
                        MPLUnityPlayerActivity.this.sendNotificationReceivedEvent("Minimisation Timeout");
                        MPLUnityPlayerActivity.this.killMyProcess(true);
                    }

                    public void onTick(long j) {
                        int[] iArr = iArr2;
                        iArr[0] = iArr[0] + 1;
                        MLogger.d(MPLUnityPlayerActivity.TAG, "onTick:SendPauseResumeNotification ", Integer.valueOf(iArr[0]));
                        if (TextUtils.isEmpty(MPLUnityPlayerActivity.this.mCountryCode) || !"ID".equalsIgnoreCase(MPLUnityPlayerActivity.this.mCountryCode)) {
                            NotificationCompat.Builder builder = when;
                            String string = MPLUnityPlayerActivity.this.getString(R.string.tap_to_resume);
                            int[] iArr2 = iArr;
                            int i = iArr2[0];
                            iArr2[0] = i - 1;
                            builder.setContentText(String.format(string, new Object[]{Integer.valueOf(i)}));
                        } else {
                            NotificationCompat.Builder builder2 = when;
                            String string2 = MPLUnityPlayerActivity.this.getString(R.string.tap_to_resume_id);
                            int[] iArr3 = iArr;
                            int i2 = iArr3[0];
                            iArr3[0] = i2 - 1;
                            builder2.setContentText(String.format(string2, new Object[]{Integer.valueOf(i2)}));
                        }
                        if (iArr2[0] > 2) {
                            when.setChannelId(Constant.GAME_CHANNEL_ID);
                        }
                        NotificationManager notificationManager = notificationManager;
                        if (notificationManager != null) {
                            notificationManager.notify(optInt, when.build());
                        }
                    }
                };
                this.mNotificationCountDownTimer = r0;
                r0.start();
            }
        } catch (Exception unused) {
            MLogger.e(TAG, "SendPauseResumeNotification: ");
        }
    }

    public void ShowAds(final String str) {
        MLogger.d(TAG, "ShowAds:with json ", Boolean.valueOf(this.isAdsEnabled), str);
        try {
            if (this.isAdsEnabled) {
                runOnUiThread(new Runnable() {
                    public void run() {
                        if (MPLUnityPlayerActivity.this.mUnityPlayer != null) {
                            AdsData adsData = (AdsData) new Gson().fromJson(str, AdsData.class);
                            adsData.setPlacementId("1593271145387");
                            LayoutParams layoutParams = new LayoutParams(WindowUtil.dpToPx((float) adsData.getWidth().intValue(), UnityPlayer.currentActivity), WindowUtil.dpToPx((float) adsData.getHeight().intValue(), UnityPlayer.currentActivity));
                            layoutParams.gravity = 81;
                            MPLUnityPlayerActivity.this.mAdsView = new RelativeLayout(UnityPlayer.currentActivity);
                            MPLUnityPlayerActivity.this.mAdsView.setLayoutParams(layoutParams);
                            MPLUnityPlayerActivity.this.mAdsView.setGravity(81);
                            adsData.setActivity(UnityPlayer.currentActivity);
                            adsData.setAdsContainer(MPLUnityPlayerActivity.this.mAdsView);
                            adsData.setPlacementId(adsData.getPlacementId());
                            MPLUnityPlayerActivity.this.mUnityPlayer.addView(MPLUnityPlayerActivity.this.mAdsView);
                        }
                    }
                });
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "showAds: ", e2);
        }
    }

    public boolean SubmitSessionResult(final String str, final String str2) {
        setRequestedOrientation(7);
        MLogger.d("MPL", GeneratedOutlineSupport.outline50("MPLAndroid: Submitting result with signature: ", str2));
        MLogger.d("MPL", GeneratedOutlineSupport.outline50("MPLAndroid: Result: ", str));
        Util.getTimeFromLib(new MTimeListener() {
            public void onFail(Exception exc) {
                MPLUnityPlayerActivity.this.calculateTimes(str, str2, Util.getSystemTime());
            }

            public void onSuccess(Date date) {
                MPLUnityPlayerActivity.this.calculateTimes(str, str2, date);
            }
        });
        return true;
    }

    public void ToggleUserFollowStatus(int i, boolean z) {
        MLogger.d(TAG, "ToggleUserFollowStatus: ", Integer.valueOf(i), Boolean.valueOf(z));
        Intent intent = new Intent();
        intent.setAction(VideoRecordingConstants.INIT_RECORDING_MONITORING);
        intent.putExtra(Constant.SHOULD_FOLLOW_USER, z);
        intent.putExtra(Constant.TOGGLE_USER_FOLLOW_STATUS, "toggle");
        intent.putExtra(Constant.FOLLOWED_USER_ID, i);
        sendBroadcast(intent);
    }

    /* access modifiers changed from: 0000 */
    public void addViewInWindow() {
    }

    /* access modifiers changed from: 0000 */
    public void calculateTimes(String str, String str2, Date date) {
        try {
            MLogger.d(TAG, "calculateTimes: ");
            JSONObject jSONObject = new JSONObject(str);
            long time = date.getTime();
            long optLong = time - jSONObject.optLong(GameConstant.GAME_START_TIME);
            jSONObject.put(GameConstant.GAME_END_TIME, time);
            jSONObject.put(GameConstant.TOURNAMENT_ID_ANDROID, this.mTournamentId);
            jSONObject.put(GameConstant.GAME_PLAY_DURATION, optLong);
            jSONObject.put(GameConstant.GAME_SIGNATURE, str2);
            jSONObject.put(GameConstant.GAME_ANDROID_APP_VERSION_NAME, String.valueOf(MBuildConfigUtils.getCurrentAppVersionName()));
            jSONObject.put(GameConstant.GAME_ANDROID_APP_VERSION_CODE, String.valueOf(MBuildConfigUtils.getInstalledAppVersionCode()));
            jSONObject.put(GameConstant.GAME_ANDROID_APP_TYPE, String.valueOf(MBuildConfigUtils.getAppType()));
            MLogger.d(TAG, GameConstant.GAME_PLAY_DURATION, CMap.SPACE, Long.valueOf(optLong));
            MLogger.d(TAG, GameConstant.GAME_END_TIME, CMap.SPACE, Long.valueOf(time));
            MLogger.d("MPL", "MPLAndroid: Session Result with time failure: " + jSONObject.length() + " -> " + jSONObject);
            redirectToRN(jSONObject.toString());
        } catch (JSONException e2) {
            MLogger.e(TAG, "calculateTimes: ", e2);
        }
    }

    public boolean checkPermission(String str) {
        if (VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(this, str) == 0) {
            return true;
        }
        return false;
    }

    public void clearAllGenericNotification() {
        List<Integer> list = this.notificationList;
        if (list != null && list.size() > 0) {
            for (Integer intValue : this.notificationList) {
                NotificationBuilder.clearSingleGenericNotification(this, intValue.intValue());
            }
        }
    }

    public void clearGenericNotificationForId(int i) {
        NotificationBuilder.clearSingleGenericNotification(this, i);
    }

    /* access modifiers changed from: 0000 */
    public Long convertToMs(Long l) {
        return Long.valueOf(TimeUnit.NANOSECONDS.toMillis(l.longValue()));
    }

    /* access modifiers changed from: 0000 */
    public Long convertToSeconds(Long l) {
        return Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(l.longValue()));
    }

    /* access modifiers changed from: 0000 */
    public void createScreenShotFile(String str, String str2) {
        InvokeMplFeatures.INSTANCE.createScreenShotFileFeature(str, str2, UnityPlayer.currentActivity, (ViewGroup) getWindow().getDecorView(), Boolean.valueOf(this.isScreenshotUiDisabled), this.isScreenShotOptions);
    }

    /* access modifiers changed from: 0000 */
    public void deleteAssetsAndReDownload(int i) {
        Toast.makeText(getApplicationContext(), getString(R.string.assets_mismatch_play), 1).show();
        HashMap hashMap = new HashMap();
        hashMap.put("Game Id", String.valueOf(i));
        hashMap.put(EventsConstants.PARAMS_TRIGGER_REASON, "Asset Bundle Mismatch");
        hashMap.put(EventsConstants.PARAMS_ACTION_TAKEN, "Deleting Assets");
        hashMap.put(EventsConstants.PARAMS_SOURCE, "After Tutorial Loaded");
        hashMap.put("Start Time", String.valueOf(System.currentTimeMillis()));
        CleverTapAnalyticsUtils.sendEvent((String) Constant.EVENT_USER_GAME_FRAUD, hashMap);
        GEInteractor.getInstance().deleteAssets(this, i);
        MLogger.d(Constant.ASSETS_CHECKING, "Assets are modified");
    }

    /* access modifiers changed from: 0000 */
    public void deleteCrashFile() {
        try {
            File file = new File(getExternalFilesDir(null).getAbsolutePath() + "/UTemp/Log.txt");
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception unused) {
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = this.isOverlayRequired;
        if (z) {
            boolean z2 = true;
            if (this.isVolumeButtonPressed) {
                if (motionEvent.getAction() == 1) {
                    z2 = false;
                }
                this.isVolumeButtonPressed = z2;
            } else if (z && (motionEvent.getFlags() & 1) == 1) {
                showOverlayDialog(getString(R.string.overlay_dialog_title), getString(R.string.overlay_dialog_msg), getString(R.string.close));
                return true;
            }
        }
        UnityPlayer unityPlayer = this.mUnityPlayer;
        if (unityPlayer != null) {
            return unityPlayer.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void downloadFile(boolean z, String str, String str2, String str3, String str4, String str5) {
        FeatureFileDownloadInput featureFileDownloadInput = new FeatureFileDownloadInput(z, str, str2, str3, str5, str4);
        InvokeMplFeatures.INSTANCE.genericFileDownloadFeature(this, featureFileDownloadInput, this);
    }

    /* access modifiers changed from: 0000 */
    public void exceptionHandlerEvent(String str) {
        InvokeMplFeatures.INSTANCE.crashInterceptedExceptionHandler(this, this.gameConfigJson, this.crashBattleId, str);
    }

    /* access modifiers changed from: 0000 */
    public void forceUploadGameDataFromNative(String str) {
        MLogger.v("GameDisconnectionHandling", GeneratedOutlineSupport.outline50("forceUploadGameDataFromNative() called with ", str));
        MEncryptedPrefUtils.INSTANCE.putForceUploadFlag(true);
        storeOrDiscardGameData(MEncryptedPrefUtils.INSTANCE.getGameBattleId(), str, false);
        sendEventToServerothergames("Connection Lost", str);
    }

    public void gameClosed() {
        InvokeMplFeatures.INSTANCE.unityGameClosed(this, this.gameConfigJson, this.crashBattleId);
    }

    public void genericFileDownloadStatus(String str) {
        MLogger.d("DownloadingFileFromServer", GeneratedOutlineSupport.outline50("Response sent to unity ->", str));
        UnityPlayer.UnitySendMessage("MPL", "DownloadStatus", str);
    }

    public String getAccessToken() {
        String str = "";
        try {
            String accessUserToken = MSharedPreferencesUtils.getAccessUserToken();
            if (accessUserToken != null) {
                return accessUserToken;
            }
            str = new JSONObject(this.gameConfigJson).optString(GameConstant.AUTH_TOKEN, str);
            return str;
        } catch (Exception unused) {
        }
    }

    public byte[] getBadgeIcon(String str, boolean z) {
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), CommonUtils.getBadgeId(str, z));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        decodeResource.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public String getCommonHeaders() {
        try {
            return new GsonBuilder().create().toJson((Object) CommonUtils.getCommonHeaders());
        } catch (Exception unused) {
            return null;
        }
    }

    public String getGameConfig() {
        return this.gameConfigJson;
    }

    public int getIntPreferences(String str, int i) {
        MLogger.d(TAG, "getIntPreferences: ", str, Integer.valueOf(i));
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + V_2_PLAYER_PREFS, 0);
        if (sharedPreferences != null) {
            i = sharedPreferences.getInt(str, i);
        }
        MLogger.d(TAG, "getIntPreferences: ", Integer.valueOf(i));
        return i;
    }

    /* access modifiers changed from: 0000 */
    public Bitmap getLargeIconInNotification(String str, Context context) {
        Bitmap bitmap;
        try {
            URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection());
            uRLConnection.setConnectTimeout(10000);
            uRLConnection.setReadTimeout(10000);
            bitmap = BitmapFactory.decodeStream(uRLConnection.getInputStream());
        } catch (Exception e2) {
            MLogger.e(TAG, "getLargeIconInNotification: ", e2);
            bitmap = null;
        }
        return (bitmap != null || context == null) ? bitmap : BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);
    }

    public UnityPlayer getMainUnityPlayer() {
        return this.mUnityPlayer;
    }

    public String getRAMAvailability() {
        return InvokeMplFeatures.INSTANCE.getRamAvailabilityForUnity(getAvailableRamMbForUnity(), getAvailableRamPercentForUnity());
    }

    public String getStringPreferences(String str, String str2) {
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + V_2_PLAYER_PREFS, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getString(str, "");
        }
        return "";
    }

    /* access modifiers changed from: 0000 */
    public SurfaceView getSurfaceView(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                SurfaceView surfaceView = getSurfaceView((ViewGroup) childAt);
                if (surfaceView != null) {
                    return surfaceView;
                }
            } else if (childAt instanceof SurfaceView) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("view of type");
                outline73.append(childAt.getClass().getName());
                MLogger.d(TAG, outline73.toString());
                return (SurfaceView) childAt;
            }
        }
        return null;
    }

    public void hideMultiScreenDialog() {
        AlertDialog alertDialog2 = this.mFraudAlertDialog;
        if (alertDialog2 != null && alertDialog2.isShowing()) {
            this.mFraudAlertDialog.dismiss();
        }
    }

    public void informStartGameToNative(int i, String str) {
        MLogger.v("GameDisconnectionHandling", "informStartGameToNative() called with gameId " + i + " & battleId " + str);
        MEncryptedPrefUtils.INSTANCE.putGameBattleId(str);
        MEncryptedPrefUtils.INSTANCE.putGameId(i);
        MEncryptedPrefUtils.INSTANCE.putGameConfig(this.gameConfigJson);
        MEncryptedPrefUtils.INSTANCE.putGameData("");
        MEncryptedPrefUtils.INSTANCE.putForceUploadFlag(false);
    }

    /* access modifiers changed from: 0000 */
    public void initInternalEventSdks() {
        try {
            MLogger.d(TAG, "initInternalEventSdks() called");
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                public void run() {
                    DatabaseClient.getInstance(MPLUnityPlayerActivity.this.getApplicationContext()).sendData();
                    DatabaseClient.getInstance(MPLUnityPlayerActivity.this.getApplicationContext()).sendDataAll();
                }
            });
        } catch (Exception unused) {
            MLogger.e(TAG, "initInternalEventSdks: ");
        }
    }

    public void killMyProcess(boolean z) {
        MLogger.d(TAG, "killMyProcess() called with: shouldCloseActivity = [" + z + CMapParser.MARK_END_OF_ARRAY);
        if (MPLApplication.getRgSessionManager() != null) {
            MPLApplication.getRgSessionManager().onAppBackground();
        }
        if (z) {
            finish();
        }
        Process.killProcess(Process.myPid());
    }

    /* access modifiers changed from: 0000 */
    public void killProcessChallengeQuit(String str) {
        MLogger.d(TAG, "killProcessChallengeQuit: ");
        Intent intent = new Intent(this, MPLReactContainerActivity.class);
        Bundle bundle = this.mBundle;
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (!"null".equals(str)) {
            intent.putExtra(Constant.GAME_SCORE, str);
        }
        startActivity(intent);
        killMyProcess(false);
    }

    public void launchMiniProfile(String str) {
        InvokeMplFeatures.INSTANCE.launchMiniProfile(this, str);
    }

    public void logCrashlytics(String str, String str2, String str3) {
        InvokeMplFeatures.INSTANCE.firebaseCrashLogFeature(this, str, str2, str3);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 3232) {
            UnityPlayer.UnitySendMessage("MPL", GameConstant.MPL_START_REMATCH_GAME_FUNC, this.gameConfigJson);
        }
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, 1430891458, bundle);
    }

    public void onDestroy() {
        iIiIiIiIii.IiiiIiiiII(this, 2004858592, new Object[0]);
    }

    public void onFailure(String str) {
        MLogger.v("GameDisconnectionHandling", GeneratedOutlineSupport.outline50("sendEventToServerothergames() failure in Unity", str));
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        MLogger.d(TAG, "onGenericMotionEvent() called with: event = [" + motionEvent + CMapParser.MARK_END_OF_ARRAY);
        UnityPlayer unityPlayer = this.mUnityPlayer;
        if (unityPlayer != null) {
            return unityPlayer.injectEvent(motionEvent);
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        boolean z = i == 25 || i == 24 || i == 82 || i == 26 || i == 164;
        this.isVolumeButtonPressed = z;
        MLogger.d(TAG, "isVolumeButtonPressed", Boolean.valueOf(z));
        UnityPlayer unityPlayer = this.mUnityPlayer;
        if (unityPlayer != null) {
            return unityPlayer.onKeyUp(i, keyEvent);
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void onMultiWindowModeChanged(boolean z) {
        super.onMultiWindowModeChanged(z);
        if (z) {
            showMultiScreenDialog();
        } else {
            hideMultiScreenDialog();
        }
    }

    public void onNetworkStateChange() {
        MSharedPreferencesUtils.setNetworkProviders(this, CommonUtils.getSimCarrierNames(this));
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        MLogger.d(TAG, "onNewIntent: ");
        UnityPlayer unityPlayer = this.mUnityPlayer;
        if (unityPlayer != null) {
            unityPlayer.newIntent(intent);
        }
        if (!this.mPauseResumeNotificationEnabled) {
            MLogger.d(TAG, "onNewIntent: Notification feature is OFF");
        } else if (intent != null && !TextUtils.isEmpty(intent.getStringExtra("Feature"))) {
            sendNotificationClickedEvent(intent.getStringExtra("Feature"));
        }
    }

    public void onPictureInPictureModeChanged(boolean z) {
        super.onPictureInPictureModeChanged(z);
        if (z) {
            showMultiScreenDialog();
        } else {
            hideMultiScreenDialog();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        boolean z;
        if (i == 1023) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                MLogger.d(TAG, "Permission not granted");
                z = false;
            } else {
                z = true;
            }
            try {
                JSONObject jSONObject = new JSONObject(this.gameConfigJson);
                jSONObject.put(GameConstant.IS_PERMISSION_ACCEPTED, z);
                this.gameConfigJson = jSONObject.toString();
            } catch (JSONException e2) {
                MLogger.e(TAG, "startGameWithStartTime: ", e2);
            }
            UnityPlayer.UnitySendMessage("MPL", GameConstant.MPL_START_GAME_FUNC, this.gameConfigJson);
        }
    }

    public void onResume() {
        iIiIiIiIii.IiiiIiiiII(this, 2112673450, new Object[0]);
    }

    public void onStart() {
        iIiIiIiIii.IiiiIiiiII(this, -134844925, new Object[0]);
    }

    public void onStop() {
        iIiIiIiIii.IiiiIiiiII(this, -264075220, new Object[0]);
    }

    public void onSuccess(String str) {
        MLogger.v("GameDisconnectionHandling", GeneratedOutlineSupport.outline50("sendEventToServerothergames() success in Unity", str));
        MLogger.v("GameDisconnectionHandling", "clear game data called from onSuccess() method in Unity");
        MEncryptedPrefUtils.INSTANCE.clearGameData();
        deleteCrashFile();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        try {
            MLogger.v("GameDisconnectionHandling", "onWindowFocusChanged() called with " + z);
            MEncryptedPrefUtils.INSTANCE.putGameFocusState(z);
        } catch (Exception e2) {
            MLogger.e("GameDisconnectionHandling", GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("onWindowFocusChanged() failed ")));
        }
    }

    /* access modifiers changed from: 0000 */
    public void openSettingApplication() {
        startActivity(new Intent("android.settings.SETTINGS"));
    }

    /* access modifiers changed from: 0000 */
    public void prepareGameLaunch() {
        boolean booleanExtra = getIntent().getBooleanExtra(GameConstant.GAME_IS_ADS_ENABLED, false);
        this.isAdsEnabled = booleanExtra;
        if (booleanExtra) {
            addViewInWindow();
        }
        this.gameConfigJson = getIntent().getStringExtra("json_extra");
        this.isOverlayRequired = getIntent().getBooleanExtra(GameConstant.IS_OVERLAY_DETECTION_REQUIRED, false);
        this.mGameId = getIntent().getIntExtra("GameId", -1);
        this.mTournamentId = getIntent().getIntExtra("TournamentId", -1);
        this.isQuitRequiredByAndroid = getIntent().getBooleanExtra(GameConstant.IS_QUIT_BY_ANDROID, false);
        this.mBundle = getIntent().getExtras();
        this.isScreenshotUiDisabled = getIntent().getBooleanExtra(GameConstant.GAME_IS_SCREEN_SHARE_UI_DISABLED, false);
        this.isScreenShotOptions = getIntent().getStringExtra(GameConstant.GAME_IS_SCREEN_SHARE_OPTION);
        this.isKafkaEnabled = getIntent().getBooleanExtra(GameConstant.IS_KAFKA_ENABLED, false);
        this.mAssetsHash = getIntent().getStringExtra(GameConstant.ASSETS_DIRECTORY_HASH);
        this.isAssetsHashEnabled = getIntent().getBooleanExtra(GameConstant.ASSETS_DIRECTORY_MATCH_ENABLED, false);
        this.isInternalUser = getIntent().getBooleanExtra(GameConstant.GAME_INTERNAL_USER, false);
        MLogger.d(TAG, "onCreate called", "\nisKafkaEnabled: ", Boolean.valueOf(this.isKafkaEnabled), "\nisAssetsHashEnabled: ", Boolean.valueOf(this.isAssetsHashEnabled), "\nisInternalUser: ", Boolean.valueOf(this.isInternalUser), "\nAssets Hash: ", this.mAssetsHash);
        MLogger.d(TAG, "onCreate called", Boolean.valueOf(this.isKafkaEnabled));
        Util.getTimeFromLib(new MTimeListener() {
            public void onFail(Exception exc) {
                MLogger.d("MPL", "MPLAndroid: Start game with config after time failure: ");
                MPLUnityPlayerActivity.this.startGameWithStartTime(Util.getSystemTime());
            }

            public void onSuccess(Date date) {
                MLogger.d("MPL", "MPLAndroid: Start game with config after time success: ");
                MPLUnityPlayerActivity.this.startGameWithStartTime(date);
            }
        });
        if (!this.isAdsEnabled) {
            RelativeLayout relativeLayout = this.mAdsView;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
        }
        sendEventLaunchCompleted();
    }

    public void publishNotification(String str, String str2, String str3) {
        InvokeMplFeatures.INSTANCE.notificationForUgcShare(this, this.mGameId, this.mTournamentId, str, str2);
    }

    /* access modifiers changed from: 0000 */
    public void quitChallenge(String str) {
        MLogger.d(TAG, str, Integer.valueOf(this.mGameId));
        UnityPlayer unityPlayer = this.mUnityPlayer;
        if (unityPlayer != null) {
            unityPlayer.requestFocus();
        }
        UnityPlayer.UnitySendMessage("MPL", GameConstant.MPL_QUIT_CHALLENGE_FUNC, str);
    }

    /* access modifiers changed from: 0000 */
    public void redirectToRN(String str) {
        MLogger.d(TAG, "redirectToRN: ");
        Intent intent = new Intent(this, MPLReactContainerActivity.class);
        Bundle bundle = this.mBundle;
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (!"null".equals(str)) {
            intent.putExtra(Constant.GAME_SCORE, str);
        }
        startActivity(intent);
        if (this.isQuitRequiredByAndroid) {
            killMyProcess(false);
        } else if (!isFinishing() && !isDestroyed()) {
            finish();
        }
    }

    public void requestPermission(final String str) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, str)) {
            MLogger.d(TAG, "Audion permission not granted");
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(false);
            builder.setTitle(getString(R.string.permission_required));
            builder.setMessage(getString(R.string.audio_permission_dialog_msg));
            builder.setPositiveButton(17039379, new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    ActivityCompat.requestPermissions(MPLUnityPlayerActivity.this, new String[]{str}, Constant.PERMISSIONS_REQUEST_AUDIO);
                }
            });
            AlertDialog create = builder.create();
            if (!isFinishing()) {
                create.show();
                return;
            }
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{str}, Constant.PERMISSIONS_REQUEST_AUDIO);
    }

    /* access modifiers changed from: 0000 */
    public void sendAFEvent(String str, String str2) {
        MLogger.d(TAG, "sendAFEvent: ", str);
        try {
            CleverTapAnalyticsUtils.sendAppsFlyerEvent(this, str, Util.jsonToMap(new JSONObject(str2)));
        } catch (Exception unused) {
        }
    }

    public void sendCrashMessage(String str) {
        exceptionHandlerEvent(str);
    }

    /* access modifiers changed from: 0000 */
    public void sendEvent(String str, String str2) {
        MLogger.d(TAG, "MPL:", "sendEvent: ", str);
        try {
            CleverTapAnalyticsUtils.sendEventFromGame(str, str2, this.mCountryCode, this.isKafkaEnabled, this.isInternalUser);
        } catch (Exception e2) {
            MLogger.e(TAG, "sendEvent: ", e2);
        }
    }

    public void sendEventLaunchCompleted() {
        String str = this.gameConfigJson;
        if (str != null && str.length() > 0) {
            MplCtEventInitiate.INSTANCE.sendEventNativeLaunchStatus(CtNativeLaunchInitiated.EVENT_NAME_LAUNCH_COMPLETED, this.gameConfigJson, true, "");
        }
    }

    public boolean sendEventToServer(String str, String str2) {
        InvokeMplFeatures.INSTANCE.sendEventForGamesFeature(getApplicationContext(), str, str2, this.gameConfigJson, ApiEndPoints.RUMMY_EVENT, this);
        return false;
    }

    public boolean sendEventToServerothergames(String str, String str2) {
        InvokeMplFeatures.INSTANCE.sendEventForGamesFeature(getApplicationContext(), str, str2, this.gameConfigJson, ApiEndPoints.ALL_GAMES_DISCONNECTION_EVENT, this);
        return false;
    }

    public void sendGamesEventToKafka(String str, String str2) {
        try {
            MLogger.d(TAG, "sendGamesEventToKafka: ", str);
            HashMap<String, Object> jsonToMap = Util.jsonToMap(new JSONObject(str2));
            jsonToMap.putAll(CleverTapAnalyticsUtils.commonPropertiesForEvents(false));
            ExternalAnalytics.INSTANCE.sendKafkaEvent(str, jsonToMap);
        } catch (Exception e2) {
            MLogger.e(TAG, "sendGamesEventToKafka: ", e2.getMessage());
        }
    }

    /* access modifiers changed from: 0000 */
    public void sendNotificationClickedEvent(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Feature", str);
            sendEvent("MPL Notification Clicked", jSONObject.toString());
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: 0000 */
    public void sendNotificationReceivedEvent(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Feature", str);
            sendEvent("MPL Notification Received", jSONObject.toString());
        } catch (Exception unused) {
        }
    }

    public void sendNotificationWithImageFromUnity(int i, String str, String str2, String str3) {
        NotificationBuilder.sendNotificationWithImageFromUnity(this, Integer.valueOf(i), str, str2, str3);
        this.notificationList.add(Integer.valueOf(i));
    }

    public void setIntPreferences(String str, int i) {
        MLogger.d(TAG, "setIntPreferences: ", str, Integer.valueOf(i));
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + V_2_PLAYER_PREFS, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt(str, i).apply();
        }
    }

    public void setScreenSecure(boolean z) {
        setScreenSecureForUnity(z);
    }

    public void setStringPreferences(String str, String str2) {
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + V_2_PLAYER_PREFS, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(str, str2).apply();
        }
    }

    public void shareImageToSocial(String str, String str2, String str3, String str4) {
        InvokeMplFeatures.INSTANCE.shareImageToSocial(this, this.mGameId, str3, str4, str2, str);
    }

    public void shareTextFromUnity(String str) {
        if (str != null && str.length() > 0) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", str);
            intent.setType("text/plain");
            startActivity(Intent.createChooser(intent, null));
        }
    }

    public void shareTextToSocial(String str, String str2, String str3, String str4) {
        InvokeMplFeatures.INSTANCE.shareTextToSocial(this, this.mGameId, str3, str4, str2, str);
    }

    public void shareUnityScreenshot(String str, String str2) {
        MLogger.d(TAG, "shareUnityScreenshot: ");
        createScreenShotFile(str, str2);
    }

    public void showMultiScreenDialog() {
        String string = getString(R.string.multi_screen_dialog_message);
        DialogData dialogData = new DialogData();
        dialogData.setBody(string);
        dialogData.setDialogType(TYPE.SPLIT_SCREEN);
        dialogData.setPopUpName("Split Screen Pop Up");
        dialogData.setShouldCloseApp(true);
        suspiciousAppsFound(dialogData);
    }

    /* access modifiers changed from: 0000 */
    public void showOverlayDialog(String str, String str2, String str3) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(EventsConstants.PARAMS_TRIGGER_REASON, "Overlay Detection");
            hashMap.put(EventsConstants.PARAMS_ACTION_TAKEN, "Closing Game");
            hashMap.put("Game Id", String.valueOf(this.mGameId));
            hashMap.put("Start Time", String.valueOf(System.currentTimeMillis()));
            CleverTapAnalyticsUtils.sendEvent((String) Constant.EVENT_USER_GAME_FRAUD, hashMap);
            if (!isFinishing()) {
                if (!isDestroyed()) {
                    if (this.alertDialog != null && this.alertDialog.isShowing()) {
                        this.alertDialog.dismiss();
                        this.alertDialog = null;
                    }
                    if (this.alertDialog == null) {
                        View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.network_failed_dialog, (ViewGroup) findViewById(R.id.error_root_dialog));
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        Typeface createFromAsset = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/RobotoCondensed-Bold.ttf");
                        Typeface createFromAsset2 = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/RobotoCondensed-Regular.ttf");
                        TextView textView = (TextView) inflate.findViewById(R.id.dialog_title);
                        textView.setTypeface(createFromAsset);
                        textView.setText(str);
                        TextView textView2 = (TextView) inflate.findViewById(R.id.dialog_msg);
                        textView2.setTypeface(createFromAsset2);
                        textView2.setText(str2);
                        Button button = (Button) inflate.findViewById(R.id.dialog_ok);
                        button.setTypeface(createFromAsset);
                        button.setText(str3);
                        button.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                if (MPLUnityPlayerActivity.this.alertDialog != null) {
                                    MPLUnityPlayerActivity.this.alertDialog.dismiss();
                                    MPLUnityPlayerActivity.this.killMyProcess(false);
                                }
                            }
                        });
                        builder.setView(inflate);
                        builder.setCancelable(true);
                        this.alertDialog = builder.create();
                    }
                    if (!isFinishing() && this.alertDialog != null && !this.alertDialog.isShowing()) {
                        this.alertDialog.show();
                    }
                }
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "showDialog: ", e2);
        }
    }

    /* JADX WARNING: type inference failed for: r5v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r5v4 */
    /* JADX WARNING: type inference failed for: r5v12 */
    /* JADX WARNING: type inference failed for: r5v15 */
    /* JADX WARNING: type inference failed for: r5v16 */
    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r5v1, types: [boolean]
      assigns: []
      uses: [?[int, short, byte, char], boolean]
      mth insns count: 163
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x01d8  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void startGameWithStartTime(java.util.Date r27) {
        /*
            r26 = this;
            r1 = r26
            java.lang.String r0 = "lobbyGamePlayZLTEvents"
            java.lang.String r2 = "Unity Bridge Time From Process Start"
            java.lang.String r3 = "Unity Process Start Time"
            java.lang.String r4 = "Launch Time From Native To Unity"
            java.lang.String r5 = ""
            java.lang.String r6 = "GamePauseNotificationEnabled"
            java.lang.String r7 = "StartTime"
            java.lang.String r8 = "CountryCode"
            java.lang.String r9 = "startGameWithStartTime: "
            java.lang.String r10 = "MPLUnityPlayerActivity"
            java.lang.String r11 = r1.gameConfigJson
            if (r11 == 0) goto L_0x0216
            long r14 = r27.getTime()     // Catch:{ JSONException -> 0x01c4 }
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x01c4 }
            org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01c4 }
            r16 = r9
            java.lang.String r9 = r1.gameConfigJson     // Catch:{ JSONException -> 0x01c2 }
            r13.<init>(r9)     // Catch:{ JSONException -> 0x01c2 }
            r13.put(r7, r14)     // Catch:{ JSONException -> 0x01c2 }
            java.lang.String r9 = "SystemStartTime"
            r13.put(r9, r11)     // Catch:{ JSONException -> 0x01c2 }
            java.lang.String r9 = "IsLogEnabled"
            boolean r11 = com.mpl.androidapp.utils.MBuildConfigUtils.isLogEnabled()     // Catch:{ JSONException -> 0x01c2 }
            r13.put(r9, r11)     // Catch:{ JSONException -> 0x01c2 }
            r9 = 3
            java.lang.Object[] r11 = new java.lang.Object[r9]     // Catch:{ JSONException -> 0x01c2 }
            r9 = 0
            r11[r9] = r7     // Catch:{ JSONException -> 0x01c2 }
            java.lang.String r7 = " "
            r9 = 1
            r11[r9] = r7     // Catch:{ JSONException -> 0x01c2 }
            java.lang.Long r7 = java.lang.Long.valueOf(r14)     // Catch:{ JSONException -> 0x01c2 }
            r9 = 2
            r11[r9] = r7     // Catch:{ JSONException -> 0x01c2 }
            com.mpl.androidapp.utils.MLogger.d(r10, r11)     // Catch:{ JSONException -> 0x01c2 }
            boolean r7 = r13.has(r8)     // Catch:{ JSONException -> 0x01c2 }
            if (r7 == 0) goto L_0x0067
            java.lang.String r7 = r13.optString(r8, r5)     // Catch:{ JSONException -> 0x01c2 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ JSONException -> 0x01c2 }
            if (r7 != 0) goto L_0x0067
            java.lang.String r5 = r13.optString(r8, r5)     // Catch:{ JSONException -> 0x01c2 }
            r1.mCountryCode = r5     // Catch:{ JSONException -> 0x01c2 }
        L_0x0067:
            boolean r5 = r13.has(r6)     // Catch:{ JSONException -> 0x01c2 }
            if (r5 == 0) goto L_0x0074
            r5 = 0
            boolean r6 = r13.optBoolean(r6, r5)     // Catch:{ JSONException -> 0x01c2 }
            r1.mPauseResumeNotificationEnabled = r6     // Catch:{ JSONException -> 0x01c2 }
        L_0x0074:
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x01c2 }
            java.lang.String r7 = "GameStartTimeFromNative"
            long r7 = r13.optLong(r7)     // Catch:{ JSONException -> 0x01c2 }
            java.lang.String r9 = "gameLaunchTimeStamp"
            long r11 = r13.optLong(r9)     // Catch:{ JSONException -> 0x01c2 }
            java.lang.String r9 = "PreProcessTimeFromNative"
            long r14 = r13.optLong(r9)     // Catch:{ JSONException -> 0x01c2 }
            java.lang.String r9 = "PreProcessEndTimeFromNative"
            long r17 = r13.optLong(r9)     // Catch:{ JSONException -> 0x01c2 }
            r19 = r11
            long r11 = r5 - r7
            r21 = r10
            long r9 = r1.onCreateTimeStamp     // Catch:{ JSONException -> 0x01be }
            long r9 = r5 - r9
            r22 = r5
            long r5 = r1.onCreateTimeStamp     // Catch:{ JSONException -> 0x01be }
            long r24 = r7 + r14
            long r5 = r5 - r24
            r24 = r14
            long r14 = r1.onCreateTimeStamp     // Catch:{ JSONException -> 0x01be }
            long r14 = r14 - r17
            r13.put(r4, r11)     // Catch:{ JSONException -> 0x01be }
            r13.put(r3, r5)     // Catch:{ JSONException -> 0x01be }
            r13.put(r2, r5)     // Catch:{ JSONException -> 0x01be }
            r17 = r14
            org.json.JSONObject r14 = r13.optJSONObject(r0)     // Catch:{ JSONException -> 0x01be }
            if (r14 == 0) goto L_0x00e3
            r14.put(r4, r11)     // Catch:{ JSONException -> 0x01be }
            r14.put(r3, r5)     // Catch:{ JSONException -> 0x01be }
            r14.put(r2, r9)     // Catch:{ JSONException -> 0x01be }
            java.lang.String r2 = "Bridge Time From React To Native"
            java.lang.String r3 = "launchGameTimeStamp"
            long r3 = r14.optLong(r3)     // Catch:{ JSONException -> 0x01be }
            long r3 = r7 - r3
            r14.put(r2, r3)     // Catch:{ JSONException -> 0x01be }
            r13.put(r0, r14)     // Catch:{ JSONException -> 0x01be }
            r2 = 2
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ JSONException -> 0x01be }
            java.lang.String r2 = "startGameWithStartTime:zltEventParams "
            r3 = 0
            r0[r3] = r2     // Catch:{ JSONException -> 0x01be }
            r2 = 1
            r0[r2] = r14     // Catch:{ JSONException -> 0x01be }
            r2 = r21
            com.mpl.androidapp.utils.MLogger.d(r2, r0)     // Catch:{ JSONException -> 0x01bc }
            goto L_0x00e5
        L_0x00e3:
            r2 = r21
        L_0x00e5:
            r0 = 10
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ JSONException -> 0x01bc }
            r3 = 0
            r0[r3] = r16     // Catch:{ JSONException -> 0x01bc }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01bc }
            r3.<init>()     // Catch:{ JSONException -> 0x01bc }
            java.lang.String r4 = "\ngameStartTimeFromNative:"
            r3.append(r4)     // Catch:{ JSONException -> 0x01bc }
            r3.append(r7)     // Catch:{ JSONException -> 0x01bc }
            java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x01bc }
            r4 = 1
            r0[r4] = r3     // Catch:{ JSONException -> 0x01bc }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01bc }
            r3.<init>()     // Catch:{ JSONException -> 0x01bc }
            java.lang.String r4 = "\ngameLaunchTimeStampFromReact:"
            r3.append(r4)     // Catch:{ JSONException -> 0x01bc }
            r7 = r19
            r3.append(r7)     // Catch:{ JSONException -> 0x01bc }
            java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x01bc }
            r4 = 2
            r0[r4] = r3     // Catch:{ JSONException -> 0x01bc }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01bc }
            r3.<init>()     // Catch:{ JSONException -> 0x01bc }
            java.lang.String r4 = "\nonCreateTimeStamp:"
            r3.append(r4)     // Catch:{ JSONException -> 0x01bc }
            long r7 = r1.onCreateTimeStamp     // Catch:{ JSONException -> 0x01bc }
            r3.append(r7)     // Catch:{ JSONException -> 0x01bc }
            java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x01bc }
            r4 = 3
            r0[r4] = r3     // Catch:{ JSONException -> 0x01bc }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01bc }
            r3.<init>()     // Catch:{ JSONException -> 0x01bc }
            java.lang.String r4 = "\npreProcessTimeForUnity:"
            r3.append(r4)     // Catch:{ JSONException -> 0x01bc }
            r7 = r24
            r3.append(r7)     // Catch:{ JSONException -> 0x01bc }
            java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x01bc }
            r4 = 4
            r0[r4] = r3     // Catch:{ JSONException -> 0x01bc }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01bc }
            r3.<init>()     // Catch:{ JSONException -> 0x01bc }
            java.lang.String r4 = "\ntimeFromOnCreateToSendMessage:"
            r3.append(r4)     // Catch:{ JSONException -> 0x01bc }
            r3.append(r9)     // Catch:{ JSONException -> 0x01bc }
            java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x01bc }
            r4 = 5
            r0[r4] = r3     // Catch:{ JSONException -> 0x01bc }
            r3 = 6
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01bc }
            r4.<init>()     // Catch:{ JSONException -> 0x01bc }
            java.lang.String r7 = "\ntimeFromNativeToUnity:"
            r4.append(r7)     // Catch:{ JSONException -> 0x01bc }
            r4.append(r11)     // Catch:{ JSONException -> 0x01bc }
            java.lang.String r4 = r4.toString()     // Catch:{ JSONException -> 0x01bc }
            r0[r3] = r4     // Catch:{ JSONException -> 0x01bc }
            r3 = 7
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01bc }
            r4.<init>()     // Catch:{ JSONException -> 0x01bc }
            java.lang.String r7 = "\ntimeToStartUnityProcessV2:"
            r4.append(r7)     // Catch:{ JSONException -> 0x01bc }
            r14 = r17
            r4.append(r14)     // Catch:{ JSONException -> 0x01bc }
            java.lang.String r4 = r4.toString()     // Catch:{ JSONException -> 0x01bc }
            r0[r3] = r4     // Catch:{ JSONException -> 0x01bc }
            r3 = 8
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01bc }
            r4.<init>()     // Catch:{ JSONException -> 0x01bc }
            java.lang.String r7 = "\ntimeToStartUnityProcess:"
            r4.append(r7)     // Catch:{ JSONException -> 0x01bc }
            r4.append(r5)     // Catch:{ JSONException -> 0x01bc }
            java.lang.String r4 = r4.toString()     // Catch:{ JSONException -> 0x01bc }
            r0[r3] = r4     // Catch:{ JSONException -> 0x01bc }
            r3 = 9
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01bc }
            r4.<init>()     // Catch:{ JSONException -> 0x01bc }
            java.lang.String r5 = "\nTime Taken in ZLT calculation:"
            r4.append(r5)     // Catch:{ JSONException -> 0x01bc }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x01bc }
            long r5 = r5 - r22
            r4.append(r5)     // Catch:{ JSONException -> 0x01bc }
            java.lang.String r4 = r4.toString()     // Catch:{ JSONException -> 0x01bc }
            r0[r3] = r4     // Catch:{ JSONException -> 0x01bc }
            com.mpl.androidapp.utils.MLogger.d(r2, r0)     // Catch:{ JSONException -> 0x01bc }
            java.lang.String r0 = r13.toString()     // Catch:{ JSONException -> 0x01bc }
            r1.gameConfigJson = r0     // Catch:{ JSONException -> 0x01bc }
            r3 = 0
            r5 = 1
            goto L_0x01d4
        L_0x01bc:
            r0 = move-exception
            goto L_0x01c8
        L_0x01be:
            r0 = move-exception
            r2 = r21
            goto L_0x01c8
        L_0x01c2:
            r0 = move-exception
            goto L_0x01c7
        L_0x01c4:
            r0 = move-exception
            r16 = r9
        L_0x01c7:
            r2 = r10
        L_0x01c8:
            r3 = 2
            java.lang.Object[] r4 = new java.lang.Object[r3]
            r3 = 0
            r4[r3] = r16
            r5 = 1
            r4[r5] = r0
            com.mpl.androidapp.utils.MLogger.e(r2, r4)
        L_0x01d4:
            com.unity3d.player.UnityPlayer r0 = r1.mUnityPlayer
            if (r0 == 0) goto L_0x01db
            r0.setFilterTouchesWhenObscured(r5)
        L_0x01db:
            r4 = 5
            java.lang.Object[] r0 = new java.lang.Object[r4]
            r0[r3] = r16
            java.lang.String r3 = "isOverlayRequired: "
            r0[r5] = r3
            boolean r3 = r1.isOverlayRequired
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r4 = 2
            r0[r4] = r3
            java.lang.String r3 = "isQuitRequiredByAndroid: "
            r5 = 3
            r0[r5] = r3
            boolean r3 = r1.isQuitRequiredByAndroid
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r5 = 4
            r0[r5] = r3
            com.mpl.androidapp.utils.MLogger.d(r2, r0)
            java.lang.Object[] r0 = new java.lang.Object[r4]
            java.lang.String r3 = "MPL:"
            r4 = 0
            r0[r4] = r3
            java.lang.String r3 = "launchGameAfterRecordingResult:5 "
            r4 = 1
            r0[r4] = r3
            com.mpl.androidapp.utils.MLogger.d(r2, r0)
            java.lang.String r0 = r1.gameConfigJson
            java.lang.String r2 = "MPL"
            java.lang.String r3 = "StartGame"
            com.unity3d.player.UnityPlayer.UnitySendMessage(r2, r3, r0)
        L_0x0216:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.game.MPLUnityPlayerActivity.startGameWithStartTime(java.util.Date):void");
    }

    public void storeOrDiscardGameData(String str, String str2, boolean z) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("storeOrDiscardGameData() called with ");
        outline73.append(String.valueOf(z));
        outline73.append(" || ");
        outline73.append(str);
        outline73.append(" || ");
        outline73.append(str2);
        MLogger.v("GameDisconnectionHandling", outline73.toString());
        if (z) {
            MLogger.i("GameDisconnectionHandling", "clear game data called from storeOrDiscardGameData() method");
            MEncryptedPrefUtils.INSTANCE.clearGameData();
            deleteCrashFile();
            return;
        }
        MEncryptedPrefUtils.INSTANCE.putGameBattleId(str);
        MEncryptedPrefUtils.INSTANCE.putGameConfig(this.gameConfigJson);
        MEncryptedPrefUtils.INSTANCE.putGameData(str2);
    }

    /* access modifiers changed from: 0000 */
    public void suspiciousAppsFound(final DialogData dialogData) {
        try {
            if (!isFinishing()) {
                if (!isDestroyed()) {
                    if (this.mFraudAlertDialog == null || !this.mFraudAlertDialog.isShowing()) {
                        View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.suspicious_app_found_dialog, (ViewGroup) findViewById(R.id.error_root_dialog));
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        Typeface createFromAsset = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/RobotoCondensed-Regular.ttf");
                        Typeface createFromAsset2 = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/RobotoCondensed-Bold.ttf");
                        TextView textView = (TextView) inflate.findViewById(R.id.dialog_title);
                        if (!TextUtils.isEmpty(dialogData.getTitle())) {
                            textView.setTypeface(createFromAsset2);
                            textView.setText(dialogData.getTitle());
                            textView.setVisibility(0);
                        } else {
                            textView.setVisibility(8);
                        }
                        TextView textView2 = (TextView) inflate.findViewById(R.id.dialog_msg);
                        if (!TextUtils.isEmpty(dialogData.getBody())) {
                            textView2.setTypeface(createFromAsset);
                            textView2.setText(dialogData.getBody());
                            textView2.setVisibility(0);
                        } else {
                            textView2.setVisibility(8);
                        }
                        Button button = (Button) inflate.findViewById(R.id.dialog_ok);
                        if (!TextUtils.isEmpty(dialogData.getOkButton())) {
                            button.setTypeface(createFromAsset2);
                            button.setText(dialogData.getOkButton());
                            button.setVisibility(0);
                        } else {
                            button.setVisibility(8);
                        }
                        Button button2 = (Button) inflate.findViewById(R.id.dialog_cancel);
                        if (!TextUtils.isEmpty(dialogData.getCancelButton())) {
                            button2.setTypeface(createFromAsset);
                            button2.setText(dialogData.getCancelButton());
                            button2.setVisibility(0);
                        } else {
                            button2.setVisibility(8);
                        }
                        builder.setView(inflate);
                        builder.setCancelable(false);
                        builder.setIcon(R.mipmap.ic_launcher);
                        this.mFraudAlertDialog = builder.create();
                        button.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                if (MPLUnityPlayerActivity.this.mFraudAlertDialog != null) {
                                    MPLUnityPlayerActivity.this.mFraudAlertDialog.dismiss();
                                }
                                if (!dialogData.isShouldCloseApp()) {
                                    MPLUnityPlayerActivity.this.openSettingApplication();
                                } else {
                                    System.exit(0);
                                }
                            }
                        });
                        if (!isFinishing() && this.mFraudAlertDialog != null && !this.mFraudAlertDialog.isShowing()) {
                            this.mFraudAlertDialog.show();
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put(EventsConstants.POP_UP_NAME, dialogData.getPopUpName());
                        CleverTapAnalyticsUtils.sendEvent((String) EventsConstants.POP_UP_SHOWN, hashMap);
                    }
                }
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "showDialog: ", e2);
        }
    }

    /* access modifiers changed from: 0000 */
    public void unityGameInitiated() {
        InvokeMplFeatures.INSTANCE.unityGameInstantiated(this, this.gameConfigJson);
    }

    public void updateBattleId(String str) {
        try {
            this.crashBattleId = str;
            InvokeMplFeatures.INSTANCE.unityGameUpdated(this, this.gameConfigJson, str);
            FirebaseCrashlytics.getInstance().setCustomKey((String) "BattleId", this.crashBattleId);
        } catch (Exception unused) {
        }
    }

    public void setStringPreferences(String str) {
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + V_2_PLAYER_PREFS, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(str, "").apply();
        }
    }

    /* access modifiers changed from: 0000 */
    public void sendEvent(String str) {
        MLogger.d(TAG, "MPL:", "sendEvent: ");
        try {
            CleverTapAnalyticsUtils.sendEventFromGame(str, "{}", this.mCountryCode, this.isKafkaEnabled, this.isInternalUser);
        } catch (Exception unused) {
        }
    }

    public void setIntPreferences(String str) {
        MLogger.d(TAG, "setIntPreferences: ", str);
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + V_2_PLAYER_PREFS, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt(str, 1).apply();
        }
    }

    public boolean QuitSession() {
        setRequestedOrientation(7);
        MLogger.d(TAG, "QuitSession: ");
        redirectToRN("null");
        return true;
    }
}
