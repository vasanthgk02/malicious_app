package com.mpl.androidapp.react.modules;

import androidx.annotation.Keep;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.mpl.androidapp.utils.FileUtils;
import com.mpl.androidapp.utils.VideoRecordingUtils;

@DoNotStrip
@ReactModule(name = "VideoRecordingModule")
@Keep
public class VideoRecordingModule extends ReactContextBaseJavaModule {
    public static final String TAG = "VideoRecordingModule";

    public VideoRecordingModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public static void deleteAllRecodedFiles() {
        VideoRecordingUtils.deleteAllRecordingFiles();
    }

    @ReactMethod
    public static void getFacebookAccessToken(Promise promise) {
        promise.resolve(VideoRecordingUtils.getFacebookAccessToken());
    }

    @ReactMethod
    public static void getFacebookId(Promise promise) {
        promise.resolve(VideoRecordingUtils.getFacebookId());
    }

    @ReactMethod
    public static void getVideoSharingTokenUIVisiblityFromConfig(Promise promise) {
        promise.resolve(Boolean.valueOf(VideoRecordingUtils.getVideoSharingTokenUIVisibilityFromConfig()));
    }

    @ReactMethod
    public static void getVideoSharingTrackTimeFromConfig(Promise promise) {
        promise.resolve(VideoRecordingUtils.getVideoSharingTrackTimeFromConfig());
    }

    @ReactMethod
    public static void isVideoShareCancelFTUETutorialShown(Promise promise) {
        promise.resolve(Boolean.valueOf(VideoRecordingUtils.isVideoShareCancelFTUETutorialShown()));
    }

    @ReactMethod
    public static void setFacebookAccessToken(String str) {
        VideoRecordingUtils.setFacebookAccessToken(str);
    }

    @ReactMethod
    public static void setFacebookId(String str) {
        VideoRecordingUtils.setFacebookId(str);
    }

    @ReactMethod
    public static void toggleUserSettingVideoShareCancelFTUETutorialShown(boolean z) {
        VideoRecordingUtils.toggleUserSettingVideoShareCancelFTUETutorialShown(z);
    }

    @ReactMethod
    public static void toggleVideoShareCancelFTUETutorialShown(boolean z) {
        VideoRecordingUtils.toggleVideoShareCancelFTUETutorialShown(z);
    }

    @ReactMethod
    public void deleteFiles(String str) {
        FileUtils.deleteFile(str);
    }

    @ReactMethod
    public void deletePaths() {
        VideoRecordingUtils.clearPaths();
    }

    public String getName() {
        return TAG;
    }

    @ReactMethod
    public void getUserSettingAudioRecordingRequire(Promise promise) {
        promise.resolve(Boolean.valueOf(VideoRecordingUtils.getUserSettingAudioRecordingRequire()));
    }

    @ReactMethod
    public void getUserSettingVideoRecordingRequire(Promise promise) {
        promise.resolve(Boolean.valueOf(VideoRecordingUtils.getUserSettingVideoRecordingRequire()));
    }

    @ReactMethod
    public void getVideoRecordingRequire(Promise promise) {
        promise.resolve(Boolean.valueOf(VideoRecordingUtils.isVideoRecordingRequireFromConfig()));
    }

    @ReactMethod
    public void getVideoSharingBonusTokenFBFromConfig(Promise promise) {
        promise.resolve(VideoRecordingUtils.getVideoSharingBonusTokenFBFromConfig());
    }

    @ReactMethod
    public void getVideoSharingBonusTokenWAFromConfig(Promise promise) {
        promise.resolve(VideoRecordingUtils.getVideoSharingBonusTokenWAFromConfig());
    }

    @ReactMethod
    public void getVideoSharingCoolDownTimerFBFromConfig(Promise promise) {
        promise.resolve(VideoRecordingUtils.getVideoSharingCoolDownTimerFBFromConfig());
    }

    @ReactMethod
    public void getVideoSharingCoolDownTimerWAFromConfig(Promise promise) {
        promise.resolve(VideoRecordingUtils.getVideoSharingCoolDownTimerWAFromConfig());
    }

    @ReactMethod
    public void getVideoSharingTextFromConfig(Promise promise) {
        promise.resolve(VideoRecordingUtils.getVideoSharingTextFromConfig());
    }

    @ReactMethod
    public void isVideoFTUETutorialShown(Promise promise) {
        promise.resolve(Boolean.valueOf(VideoRecordingUtils.isVideoFTUETutorialShown()));
    }

    @ReactMethod
    public void isVideoShareFTUETutorialShown(Promise promise) {
        promise.resolve(Boolean.valueOf(VideoRecordingUtils.isVideoShareFTUETutorialShown()));
    }

    @ReactMethod
    public void setUserSettingAudioRecordingRequire(boolean z) {
        VideoRecordingUtils.setUserSettingAudioRecordingRequire(z);
    }

    @ReactMethod
    public void setUserSettingVideoRecordingRequire(boolean z) {
        VideoRecordingUtils.setUserSettingVideoRecordingRequire(z);
    }

    @ReactMethod
    public void toggleVideoFTUETutorialShownStatus(boolean z) {
        VideoRecordingUtils.toggleVideoFTUETutorialShownStatus(z);
    }

    @ReactMethod
    public void toggleVideoShareFTUETutorialShownStatus(boolean z) {
        VideoRecordingUtils.toggleVideoShareFTUETutorialShownStatus(z);
    }
}
