package com.mpl.androidapp.game;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;
import com.mpl.androidapp.MPLApplication;
import com.mpl.androidapp.R;
import com.mpl.androidapp.react.MPLReactContainerActivity;
import com.mpl.androidapp.updater.gameengine.GEInteractor;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.CommonUtils;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.Constant.VideoRecordingConstants;
import com.mpl.androidapp.utils.FileUtils;
import com.mpl.androidapp.utils.GameConstant;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MTimeListener;
import com.mpl.androidapp.utils.Util;
import com.unity3d.player.UnityPlayer;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;
import org.apache.fontbox.cmap.CMap;
import org.apache.fontbox.cmap.CMapParser;
import org.json.JSONException;
import org.json.JSONObject;

public class MPLUnityPlayerActivity_backup extends Activity {
    public static final String TAG = "GamePlay:";
    public String gameConfigJson = null;
    public boolean is1V1 = false;
    public Bundle mBundle;
    public UnityPlayer mUnityPlayer;

    /* access modifiers changed from: private */
    public void calculateTimes(String str, String str2, Date date) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            long time = date.getTime();
            long optLong = time - jSONObject.optLong(GameConstant.GAME_START_TIME);
            jSONObject.put(GameConstant.GAME_END_TIME, time);
            jSONObject.put(GameConstant.GAME_PLAY_DURATION, optLong);
            jSONObject.put(GameConstant.GAME_SIGNATURE, str2);
            jSONObject.put(GameConstant.GAME_ANDROID_APP_VERSION_NAME, String.valueOf(MBuildConfigUtils.getCurrentAppVersionName()));
            jSONObject.put(GameConstant.GAME_ANDROID_APP_VERSION_CODE, String.valueOf(MBuildConfigUtils.getInstalledAppVersionCode()));
            jSONObject.put(GameConstant.GAME_ANDROID_APP_TYPE, String.valueOf(MBuildConfigUtils.getAppType()));
            MLogger.d(TAG, GameConstant.GAME_PLAY_DURATION, CMap.SPACE, Long.valueOf(optLong));
            MLogger.d(TAG, GameConstant.GAME_END_TIME, CMap.SPACE, Long.valueOf(time));
            MLogger.d("MPL", "MPLAndroid: Session Result with time failure: " + jSONObject.length() + " -> " + jSONObject.toString());
            redirectToRN(jSONObject.toString());
        } catch (JSONException e2) {
            MLogger.e(TAG, "calculateTimes: ", e2);
        }
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, MPLUnityPlayerActivity.class);
    }

    private void redirectToRN(String str) {
        Intent intent = new Intent(this, MPLReactContainerActivity.class);
        Bundle bundle = this.mBundle;
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (!"null".equals(str)) {
            intent.putExtra(Constant.GAME_SCORE, str);
        }
        startActivity(intent);
        finish();
    }

    private void sendEvent(String str, String str2) {
        MLogger.d(TAG, GeneratedOutlineSupport.outline54("sendEvent() called with: event = [", str, "], eventProp = [", str2, CMapParser.MARK_END_OF_ARRAY));
        PrintStream printStream = System.out;
        printStream.println("MPLAndroid: Send " + str + " event with properties: " + str2);
        CleverTapAnalyticsUtils.sendEventFromGame(str, str2, "", false, false);
    }

    /* access modifiers changed from: private */
    public void startGameWithStartTime(Date date) {
        try {
            long time = date.getTime();
            JSONObject jSONObject = new JSONObject(this.gameConfigJson);
            jSONObject.put(GameConstant.GAME_START_TIME, time);
            jSONObject.put(GameConstant.GAME_LOG_ENABLED, MBuildConfigUtils.isLogEnabled());
            MLogger.d(TAG, GameConstant.GAME_START_TIME, CMap.SPACE, Long.valueOf(time));
            this.gameConfigJson = jSONObject.toString();
        } catch (JSONException e2) {
            MLogger.e(TAG, "startGameWithStartTime: ", e2);
        }
        MLogger.d(TAG, "startGameWithStartTime: ", Boolean.valueOf(this.is1V1));
        UnityPlayer.UnitySendMessage("MPL", GameConstant.MPL_START_GAME_FUNC, this.gameConfigJson);
    }

    public String GetAssetBundlesDirectory(int i) {
        MLogger.d(TAG, "GetAssetBundlesDirectory: ");
        return GEInteractor.getInstance().loadAssets(this, i);
    }

    public String GetSessionConfig() {
        MLogger.d(TAG, "GetSessionConfig: ");
        return this.gameConfigJson;
    }

    public String GetSponsorDirectory(int i) {
        MLogger.d(TAG, "GetSponsorDirectory: ");
        return FileUtils.getSponsorDirPathById(this, String.valueOf(i));
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

    public void Log(String str) {
    }

    public void OnGameLoaded() {
        MLogger.d(TAG, "OnGameLoaded Start");
        runOnUiThread(new Runnable() {
            public void run() {
                MLogger.d(MPLUnityPlayerActivity_backup.TAG, "OnGameLoaded End");
            }
        });
    }

    public boolean QuitSession(String str) {
        setRequestedOrientation(7);
        PrintStream printStream = System.out;
        printStream.println("MPLAndroid: Quit Session with params" + str);
        if (TextUtils.isEmpty(str)) {
            redirectToRN("null");
        } else {
            redirectToRN(GeneratedOutlineSupport.outline50("quitGame", str));
        }
        return true;
    }

    public void SendLocalNotification(String str, String str2) {
        PrintStream printStream = System.out;
        printStream.println("MPLAndroid: Sending Local Notification with title: " + str + ", message: " + str2);
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        Notification build = new Builder(getApplicationContext()).setContentTitle(str).setContentText(str2).setSmallIcon(R.drawable.ic_stat_mpl).setWhen(System.currentTimeMillis()).build();
        build.flags = build.flags | 16;
        int i = build.defaults | 1;
        build.defaults = i;
        build.defaults = i | 2;
        if (notificationManager != null) {
            notificationManager.notify(0, build);
        }
    }

    public boolean SubmitSessionResult(final String str, final String str2) {
        setRequestedOrientation(7);
        MLogger.d("MPL", GeneratedOutlineSupport.outline50("MPLAndroid: Submitting result with signature: ", str2));
        MLogger.d("MPL", GeneratedOutlineSupport.outline50("MPLAndroid: Result: ", str));
        Util.getTimeFromLib(new MTimeListener() {
            public void onFail(Exception exc) {
                MPLUnityPlayerActivity_backup.this.calculateTimes(str, str2, Util.getSystemTime());
            }

            public void onSuccess(Date date) {
                MPLUnityPlayerActivity_backup.this.calculateTimes(str, str2, date);
            }
        });
        return true;
    }

    public boolean checkPermission(String str) {
        if (VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(this, str) == 0) {
            return true;
        }
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 2) {
            return this.mUnityPlayer.injectEvent(keyEvent);
        }
        keyEvent.getAction();
        return super.dispatchKeyEvent(keyEvent);
    }

    public byte[] getBadgeIcon(String str, boolean z) {
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), CommonUtils.getBadgeId(str, z));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        decodeResource.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mUnityPlayer.configurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        UnityPlayer unityPlayer = new UnityPlayer(this);
        this.mUnityPlayer = unityPlayer;
        this.mUnityPlayer.init(unityPlayer.getSettings().getInt("gles_mode", 1), false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_unity_layout);
        ((FrameLayout) findViewById(R.id.game_container)).addView(this.mUnityPlayer.getView());
        this.mUnityPlayer.requestFocus();
        this.gameConfigJson = getIntent().getStringExtra("json_extra");
        this.is1V1 = getIntent().getBooleanExtra(GameConstant.IS_1V1, false);
        this.mBundle = getIntent().getExtras();
        startGame();
    }

    public void onDestroy() {
        this.mUnityPlayer.quit();
        setRequestedOrientation(7);
        super.onDestroy();
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        UnityPlayer unityPlayer = this.mUnityPlayer;
        if (unityPlayer != null) {
            return unityPlayer.injectEvent(motionEvent);
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.mUnityPlayer.injectEvent(keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.mUnityPlayer.injectEvent(keyEvent);
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.mUnityPlayer.lowMemory();
    }

    public void onNewIntent(Intent intent) {
        setIntent(intent);
    }

    public void onPause() {
        this.mUnityPlayer.pause();
        super.onPause();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1023) {
            boolean z = iArr.length > 0 && iArr[0] == 0;
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
        super.onResume();
        this.mUnityPlayer.resume();
    }

    public void onStart() {
        super.onStart();
        boolean isAppIsInBackground = CommonUtils.isAppIsInBackground(MPLApplication.getInstance());
        MLogger.d(VideoRecordingConstants.TAG, "onStart() called isAppBackground: ", Boolean.valueOf(isAppIsInBackground));
        if (!isAppIsInBackground) {
            Intent intent = new Intent();
            intent.setAction(VideoRecordingConstants.INIT_RECORDING_MONITORING);
            intent.putExtra(VideoRecordingConstants.IS_GAME_PAUSED, false);
            sendBroadcast(intent);
        }
        this.mUnityPlayer.start();
    }

    public void onStop() {
        this.mUnityPlayer.stop();
        super.onStop();
        MLogger.d(VideoRecordingConstants.TAG, "onStop() called isAppBackground: ", Boolean.valueOf(CommonUtils.isAppIsInBackground(MPLApplication.getInstance())));
        Intent intent = new Intent();
        intent.setAction(VideoRecordingConstants.INIT_RECORDING_MONITORING);
        intent.putExtra(VideoRecordingConstants.IS_GAME_PAUSED, true);
        sendBroadcast(intent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mUnityPlayer.injectEvent(motionEvent);
    }

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (i == 15) {
            this.mUnityPlayer.lowMemory();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.mUnityPlayer.windowFocusChanged(z);
    }

    public void requestPermission(final String str) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, str)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(false);
            builder.setTitle(getString(R.string.permission_required));
            builder.setMessage(getString(R.string.audio_permission_dialog_msg));
            builder.setPositiveButton(17039379, new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    ActivityCompat.requestPermissions(MPLUnityPlayerActivity_backup.this, new String[]{str}, Constant.PERMISSIONS_REQUEST_AUDIO);
                }
            });
            builder.create().show();
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{str}, Constant.PERMISSIONS_REQUEST_AUDIO);
    }

    public void returnToPlayerActivity() {
        UnityPlayer.currentActivity.runOnUiThread(new Runnable() {
            public void run() {
                MLogger.d(DevelopmentPlatformProvider.UNITY_PLATFORM, "Application close currentActivity");
                MPLUnityPlayerActivity_backup.this.mUnityPlayer.quit();
                UnityPlayer.currentActivity.finish();
            }
        });
    }

    public void startGame() {
        Util.getTimeFromLib(new MTimeListener() {
            public void onFail(Exception exc) {
                MLogger.d("MPL", "MPLAndroid: Start game with config after time failure: ");
                MPLUnityPlayerActivity_backup.this.startGameWithStartTime(Util.getSystemTime());
            }

            public void onSuccess(Date date) {
                MLogger.d("MPL", "MPLAndroid: Start game with config after time success: ");
                MPLUnityPlayerActivity_backup.this.startGameWithStartTime(date);
            }
        });
    }

    private void sendEvent(String str) {
        MLogger.d(TAG, GeneratedOutlineSupport.outline52("sendEvent() called with: event = [", str, CMapParser.MARK_END_OF_ARRAY));
        CleverTapAnalyticsUtils.sendEventFromGame(str, "{}", "", false, false);
    }

    public boolean QuitSession() {
        setRequestedOrientation(7);
        System.out.println("MPLAndroid: Quit Session without params");
        redirectToRN("null");
        return true;
    }
}
