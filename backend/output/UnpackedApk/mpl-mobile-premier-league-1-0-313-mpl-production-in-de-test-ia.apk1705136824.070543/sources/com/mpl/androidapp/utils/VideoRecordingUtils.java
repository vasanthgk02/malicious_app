package com.mpl.androidapp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.device.yearclass.YearClass;
import com.facebook.proguard.annotations.DoNotStrip;
import com.mpl.androidapp.react.modules.FileUploadHelperModule;
import com.mpl.androidapp.utils.Constant.VideoRecordingConstants;
import com.mpl.securepreferences.MPreferences;
import com.paynimo.android.payment.util.Constant;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.apache.fontbox.cmap.CMapParser;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.json.JSONException;
import org.json.JSONObject;

@DoNotStrip
@Keep
public class VideoRecordingUtils {
    public static void clearPaths() {
        MLogger.d(VideoRecordingConstants.TAG, "clearPaths() called");
        MPreferences.remove(VideoRecordingConstants.RECORDED_VIDEO_PATH, false);
        MPreferences.remove(VideoRecordingConstants.VIDEO_THUMBNAIL_PATH, false);
        MPreferences.remove(VideoRecordingConstants.GAME_RECORDING_DATA, false);
        MPreferences.remove(VideoRecordingConstants.RECORDED_VIDEO_HASH, true);
    }

    public static void deleteAllRecordedThumbNailsFiles() {
        String recordingVideoThumbnailOutputFolderPath = getRecordingVideoThumbnailOutputFolderPath();
        MLogger.d(VideoRecordingConstants.TAG, "Files ", GeneratedOutlineSupport.outline50("Path: ", recordingVideoThumbnailOutputFolderPath));
        if (!TextUtils.isEmpty(recordingVideoThumbnailOutputFolderPath)) {
            File[] listFiles = new File(recordingVideoThumbnailOutputFolderPath).listFiles();
            if (listFiles != null) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Size: ");
                outline73.append(listFiles.length);
                MLogger.d(VideoRecordingConstants.TAG, "Files ", outline73.toString());
                for (File file : listFiles) {
                    StringBuilder outline732 = GeneratedOutlineSupport.outline73(" delete: ");
                    outline732.append(file.delete());
                    MLogger.d(VideoRecordingConstants.TAG, "Files ", "FileName: ", file.getName(), outline732.toString());
                }
            }
        }
    }

    public static void deleteAllRecordedVideosFiles() {
        String recordingVideoOutputFolderPath = getRecordingVideoOutputFolderPath();
        MLogger.d(VideoRecordingConstants.TAG, "Files ", GeneratedOutlineSupport.outline50("Path: ", recordingVideoOutputFolderPath));
        if (!TextUtils.isEmpty(recordingVideoOutputFolderPath)) {
            File[] listFiles = new File(recordingVideoOutputFolderPath).listFiles();
            if (listFiles != null) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Size: ");
                outline73.append(listFiles.length);
                MLogger.d(VideoRecordingConstants.TAG, "Files ", outline73.toString());
                for (File file : listFiles) {
                    if (!FileUploadHelperModule.uploadingPaths.contains(file.getAbsolutePath())) {
                        CleverTapAnalyticsUtils.sendVideoDeletedEvent("Played Again Without Uploading");
                        StringBuilder outline732 = GeneratedOutlineSupport.outline73(" delete: ");
                        outline732.append(file.delete());
                        MLogger.d(VideoRecordingConstants.TAG, "deleteAllRecordedVideosFiles ", "FileName: ", file.getName(), outline732.toString());
                    } else {
                        MLogger.d(VideoRecordingConstants.TAG, "deleteAllRecordedVideosFiles: ", "not deleting files");
                    }
                }
            }
        }
    }

    public static void deleteAllRecordingFiles() {
        deleteAllRecordedThumbNailsFiles();
        deleteAllRecordedVideosFiles();
        clearPaths();
    }

    public static String getAutoFillExtraTextFromConfig() {
        return MPreferences.getString(VideoRecordingConstants.RECORDING_AUTO_FILL_EXTRA_TEXT, "", true);
    }

    public static String getFacebookAccessToken() {
        String string = MPreferences.getString(VideoRecordingConstants.FACEBOOK_ACCESS_TOKEN, "", true);
        MLogger.i(VideoRecordingConstants.TAG, "getFacebookAccessToken", string);
        return string;
    }

    public static String getFacebookId() {
        return MPreferences.getString(VideoRecordingConstants.FACEBOOK_ID, "", true);
    }

    public static int getMaxWaitTimeForSharingFromConfig() {
        String str = "5";
        String string = MPreferences.getString(VideoRecordingConstants.CONFIG_MAX_WAITING_TIME_REQUIRED, str, true);
        MLogger.i(VideoRecordingConstants.TAG, "getMaxWaitTimeForSharingFromConfig", string);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        if (string != null) {
            str = string;
        }
        return (int) timeUnit.toMillis((long) Integer.parseInt(str));
    }

    public static String getPostUrlForVideoSharing() {
        String string = MPreferences.getString(VideoRecordingConstants.VIDEO_POST_URL_CONFIG, VideoRecordingConstants.VIDEO_POST_URL, true);
        if (string != null && string.contains("https:")) {
            return string;
        }
        return MBuildConfigUtils.getMainUrl() + "/" + MPreferences.getString(VideoRecordingConstants.VIDEO_POST_URL_CONFIG, VideoRecordingConstants.VIDEO_POST_URL, true);
    }

    public static HashMap<String, Object> getRecordedVideoEventProp() {
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(MPreferences.getString(VideoRecordingConstants.GAME_RECORDING_DATA, "", false));
            hashMap.put("Game Id", Integer.valueOf(jSONObject.optInt("gameId", 0)));
            hashMap.put("Game Name", jSONObject.optString("gameName", ""));
            hashMap.put("Tournament ID", Integer.valueOf(jSONObject.optInt("tournamentId", 0)));
            hashMap.put("Tournament Name", jSONObject.optString(VideoRecordingConstants.TOURNAMENT_NAME, ""));
            hashMap.put("Game Score", Integer.valueOf(jSONObject.optInt(VideoRecordingConstants.SCORE, 0)));
            hashMap.put("Duration", Long.valueOf(jSONObject.optLong(VideoRecordingConstants.GAME_PLAY_DURATION)));
            hashMap.put("Tournament Type", "Default");
            hashMap.put("Creation Date", SimpleDateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime()));
            hashMap.put("Is Sponsor Tournament", Boolean.valueOf(jSONObject.optInt(VideoRecordingConstants.IS_SPONSER_TOURNAMENT) == 1));
            hashMap.put("Video Type", "Game Play");
        } catch (JSONException e2) {
            MLogger.i(VideoRecordingConstants.TAG, "postDataToServer", e2);
        }
        return hashMap;
    }

    public static String getRecordingVideoOutputFolderPath() {
        MLogger.d(VideoRecordingConstants.TAG, "getRecordingVideoOutputFolderPath() called:");
        if (!CommonUtils.isExternalStorageWritable()) {
            return null;
        }
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "MPL/Videos");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String getRecordingVideoThumbnailOutputFolderPath() {
        MLogger.d(VideoRecordingConstants.TAG, "getRecordingVideoThumbnailOutputFolderPath() called:");
        if (!CommonUtils.isExternalStorageWritable()) {
            return null;
        }
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "MPL/Thumbnails");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static int getTotalUserPlayedGame(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getInt(VideoRecordingConstants.USER_PLAYED_GAME_COUNT, 0);
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public static boolean getUserSettingAudioRecordingRequire() {
        boolean parseBoolean = Boolean.parseBoolean(MPreferences.getString(VideoRecordingConstants.IS_AUDIO_RECORDING_REQUIRED_USER_SETTING, BaseParser.TRUE, true));
        MLogger.d(VideoRecordingConstants.TAG, "getUserSettingAudioRecordingRequire() called ", Boolean.valueOf(parseBoolean));
        return parseBoolean;
    }

    public static boolean getUserSettingVideoRecordingRequire() {
        String string = MPreferences.getString(VideoRecordingConstants.IS_VIDEO_RECORDING_REQUIRED_USER_SETTING, BaseParser.FALSE, true);
        if (TextUtils.isEmpty(string) || !Boolean.parseBoolean(string)) {
            return false;
        }
        return true;
    }

    public static String getVideoFeatureTagsFromConfig() {
        return MPreferences.getString(VideoRecordingConstants.RECORDED_VIDEO_CONFIG_FEATURE_TAGS, "", true);
    }

    public static String getVideoSharingBonusCashFBFromConfig() {
        return MPreferences.getString(VideoRecordingConstants.VIDEO_SHARING_BONUS_CASH_FB, "3", true);
    }

    public static String getVideoSharingBonusTokenFBFromConfig() {
        return MPreferences.getString(VideoRecordingConstants.VIDEO_SHARING_BONUS_TOKEN_FB, "3", true);
    }

    public static String getVideoSharingBonusTokenWAFromConfig() {
        return MPreferences.getString(VideoRecordingConstants.VIDEO_SHARING_BONUS_TOKEN_WA, "3", true);
    }

    public static String getVideoSharingCoolDownTimerFBFromConfig() {
        return MPreferences.getString(VideoRecordingConstants.VIDEO_COOLDOWN_TIMER_FB, Constant.BANKCODE_ICICI, true);
    }

    public static String getVideoSharingCoolDownTimerWAFromConfig() {
        return MPreferences.getString(VideoRecordingConstants.VIDEO_COOLDOWN_TIMER_WA, Constant.BANKCODE_ICICI, true);
    }

    public static String getVideoSharingTextFromConfig() {
        return MPreferences.getString(VideoRecordingConstants.VIDEO_SHARE_TEXT, "I am playing {TOURNAMENT_NAME} with total prize of {REWARD_AMOUNT} {REWARD_CURRENCY} on MPL! Click the link {URL} to play and win!", true);
    }

    public static boolean getVideoSharingTokenUIVisibilityFromConfig() {
        return Boolean.parseBoolean(MPreferences.getString(VideoRecordingConstants.RECORDED_VIDEO_TOKEN_UI_CONFIG, BaseParser.FALSE, true));
    }

    public static String getVideoSharingTrackTimeFromConfig() {
        return MPreferences.getString(VideoRecordingConstants.RECORDED_VIDEO_CONFIG_TRACK_TIME, "3", true);
    }

    public static String getVideoTagsFromConfig() {
        return MPreferences.getString(VideoRecordingConstants.RECORDED_VIDEO_CONFIG_TAGS, "[\"PlayMPL\"]", true);
    }

    public static int getYearClass(Context context) {
        if (YearClass.mYearCategory == null) {
            synchronized (YearClass.class) {
                try {
                    if (YearClass.mYearCategory == null) {
                        YearClass.mYearCategory = Integer.valueOf(YearClass.categorizeByYear2016Method(context));
                    }
                }
            }
        }
        return YearClass.mYearCategory.intValue();
    }

    public static void increaseUserPlayedGame(Context context) {
        int totalUserPlayedGame = getTotalUserPlayedGame(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt(VideoRecordingConstants.USER_PLAYED_GAME_COUNT, totalUserPlayedGame + 1).apply();
        }
    }

    public static boolean isVideoFTUETutorialShown() {
        MLogger.d(VideoRecordingConstants.TAG, "isVideoFTUETutorialShown() called");
        return Boolean.parseBoolean(MPreferences.getString(VideoRecordingConstants.VIDEO_RECORDING_FTUE_SHOWNS, BaseParser.FALSE, true));
    }

    public static boolean isVideoRecordingRequireFromConfig() {
        return Boolean.parseBoolean(MPreferences.getString(VideoRecordingConstants.IS_VIDEO_FEATURE_ENABLED, BaseParser.FALSE, true));
    }

    public static boolean isVideoShareCancelFTUETutorialShown() {
        MLogger.d(VideoRecordingConstants.TAG, "isVideoShareCancelFTUETutorialShown() called");
        return MPreferences.getBoolean(VideoRecordingConstants.VIDEO_SHARE_CANCEL_FTUE_SHOWNS, false, true);
    }

    public static boolean isVideoShareFTUETutorialShown() {
        MLogger.d(VideoRecordingConstants.TAG, "isVideoShareFTUETutorialShown() called");
        return Boolean.parseBoolean(MPreferences.getString(VideoRecordingConstants.VIDEO_SHARE_FTUE_SHOWNS, BaseParser.FALSE, true));
    }

    public static void setFacebookAccessToken(String str) {
        MPreferences.putString(VideoRecordingConstants.FACEBOOK_ACCESS_TOKEN, str, true);
    }

    public static void setFacebookId(String str) {
        MPreferences.putString(VideoRecordingConstants.FACEBOOK_ID, str, true);
    }

    public static void setInitiallyUserPlayedGame(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt(VideoRecordingConstants.USER_PLAYED_GAME_COUNT, 0).apply();
        }
    }

    public static void setUserSettingAudioRecordingRequire(boolean z) {
        MLogger.d(VideoRecordingConstants.TAG, "setUserSettingAudioRecordingRequire() called with: isRequire = [" + z + CMapParser.MARK_END_OF_ARRAY);
        MPreferences.putBoolean(VideoRecordingConstants.IS_AUDIO_RECORDING_REQUIRED_USER_SETTING, z, true);
    }

    public static void setUserSettingVideoRecordingRequire(boolean z) {
        MLogger.d(VideoRecordingConstants.TAG, "setUserSettingVideoRecordingRequire() called with: isRequire = [" + z + CMapParser.MARK_END_OF_ARRAY);
        MPreferences.putBoolean(VideoRecordingConstants.IS_VIDEO_RECORDING_REQUIRED_USER_SETTING, z, true);
    }

    public static void setVideoSizeExceededSetting(boolean z) {
        MLogger.i(VideoRecordingConstants.TAG, "setVideoRecordingRunningStorageSetting", Boolean.valueOf(z));
        MPreferences.putString(VideoRecordingConstants.IS_VIDEO_SIZE_EXCEED, String.valueOf(z), true);
    }

    public static boolean shouldTakeExtraTextFromConfig() {
        return Boolean.parseBoolean(MPreferences.getString(VideoRecordingConstants.RECORDING_SHOULD_TAKE_EXTRA_TEXT, BaseParser.FALSE, true));
    }

    public static void toggleUserSettingVideoShareCancelFTUETutorialShown(boolean z) {
        MLogger.d(VideoRecordingConstants.TAG, "toggleUserSettingVideoShareCancelFTUETutorialShown() called with: isShown = [" + z + CMapParser.MARK_END_OF_ARRAY);
        MPreferences.putBoolean(VideoRecordingConstants.VIDEO_SHARE_CANCEL_FTUE_SETTING_SHOWNS, z, true);
    }

    public static void toggleVideoFTUETutorialShownStatus(boolean z) {
        MLogger.d(VideoRecordingConstants.TAG, "toggleVideoFTUETutorialShownStatus() called with: isShown = [" + z + CMapParser.MARK_END_OF_ARRAY);
        MPreferences.putBoolean(VideoRecordingConstants.VIDEO_RECORDING_FTUE_SHOWNS, z, true);
    }

    public static void toggleVideoShareCancelFTUETutorialShown(boolean z) {
        MLogger.d(VideoRecordingConstants.TAG, "toggleVideoShareCancelFTUETutorialShown() called with: isShown = [" + z + CMapParser.MARK_END_OF_ARRAY);
        MPreferences.putBoolean(VideoRecordingConstants.VIDEO_SHARE_CANCEL_FTUE_SHOWNS, z, true);
    }

    public static void toggleVideoShareFTUETutorialShownStatus(boolean z) {
        MLogger.d(VideoRecordingConstants.TAG, "toggleVideoShareFTUETutorialShownStatus() called with: isShown = [" + z + CMapParser.MARK_END_OF_ARRAY);
        MPreferences.putBoolean(VideoRecordingConstants.VIDEO_SHARE_FTUE_SHOWNS, z, true);
    }
}
