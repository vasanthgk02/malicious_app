package com.mpl.androidapp.react.modules;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaRecorder;
import android.os.Build.VERSION;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.FacebookSdk;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.mpl.androidapp.utils.FileUtils;
import com.mpl.androidapp.utils.MLogger;
import java.io.File;
import java.io.IOException;
import org.apache.fontbox.cmap.CMapParser;
import org.json.JSONObject;

@ReactModule(name = "AudioModule")
public class AudioModule extends ReactContextBaseJavaModule {
    public static final String TAG = "AudioModule";
    public MediaPlayer mediaPlayer;
    public MediaRecorder myAudioRecorder;

    public AudioModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    /* access modifiers changed from: private */
    public void sendEvent(ReactContext reactContext, String str, WritableMap writableMap) {
        ((RCTDeviceEventEmitter) reactContext.getJSModule(RCTDeviceEventEmitter.class)).emit(str, writableMap);
    }

    public String getName() {
        return TAG;
    }

    @ReactMethod
    public void pausePlay() {
        try {
            if (this.mediaPlayer == null) {
                return;
            }
            if (this.mediaPlayer.isPlaying()) {
                this.mediaPlayer.pause();
                MLogger.t(FacebookSdk.getApplicationContext(), 1, "Pausing Audio");
                return;
            }
            this.mediaPlayer.start();
            MLogger.t(FacebookSdk.getApplicationContext(), 1, "Playing Audio");
        } catch (Exception e2) {
            MLogger.e(TAG, "pausePlay: ", e2);
        }
    }

    @ReactMethod
    public void playFile(String str, final Promise promise) {
        MediaPlayer mediaPlayer2 = new MediaPlayer();
        this.mediaPlayer = mediaPlayer2;
        try {
            if (mediaPlayer2.isPlaying()) {
                this.mediaPlayer.stop();
                this.mediaPlayer.release();
                this.mediaPlayer = null;
            }
            if (this.mediaPlayer == null) {
                this.mediaPlayer = new MediaPlayer();
            }
            this.mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
                public void onCompletion(MediaPlayer mediaPlayer) {
                    MLogger.d(AudioModule.TAG, "streamRecording OnCompletion() called with: mp = [" + mediaPlayer + CMapParser.MARK_END_OF_ARRAY);
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    promise.resolve("ended");
                }
            });
            this.mediaPlayer.setDataSource(str);
            this.mediaPlayer.prepare();
            this.mediaPlayer.start();
            MLogger.t(FacebookSdk.getApplicationContext(), 1, "Playing Audio");
        } catch (Exception e2) {
            MLogger.e(TAG, "playFile: ", e2);
            promise.reject((String) "fail", e2.getMessage());
        }
    }

    @ReactMethod
    public void playUrl(String str, final Promise promise) {
        MediaPlayer mediaPlayer2 = new MediaPlayer();
        this.mediaPlayer = mediaPlayer2;
        try {
            if (mediaPlayer2.isPlaying()) {
                this.mediaPlayer.stop();
                this.mediaPlayer.release();
                this.mediaPlayer = null;
            }
            if (this.mediaPlayer == null) {
                this.mediaPlayer = new MediaPlayer();
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "playUrl: ", e2);
        }
        this.mediaPlayer.setOnErrorListener(new OnErrorListener() {
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                StringBuilder sb = new StringBuilder();
                sb.append("streamRecording onError() called with: mp = [");
                sb.append(mediaPlayer);
                sb.append("], what = [");
                sb.append(i);
                sb.append("], extra = [");
                MLogger.d(AudioModule.TAG, GeneratedOutlineSupport.outline57(sb, i2, CMapParser.MARK_END_OF_ARRAY));
                promise.reject((String) "fail", GeneratedOutlineSupport.outline43("", i, "  ", i2));
                mediaPlayer.reset();
                return false;
            }
        });
        this.mediaPlayer.setOnPreparedListener(new OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                MLogger.d(AudioModule.TAG, "streamRecording onPrepared() called with: mp = [" + mediaPlayer + CMapParser.MARK_END_OF_ARRAY);
                mediaPlayer.start();
            }
        });
        this.mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                MLogger.d(AudioModule.TAG, "streamRecording OnCompletion() called with: mp = [" + mediaPlayer + CMapParser.MARK_END_OF_ARRAY);
                mediaPlayer.stop();
                mediaPlayer.release();
                promise.resolve("ended");
            }
        });
        this.mediaPlayer.setOnBufferingUpdateListener(new OnBufferingUpdateListener() {
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                WritableMap createMap = Arguments.createMap();
                createMap.putInt("percent", i);
                AudioModule audioModule = AudioModule.this;
                audioModule.sendEvent(audioModule.getReactApplicationContext(), "audio_played_percentage", createMap);
            }
        });
        try {
            this.mediaPlayer.setDataSource(str);
            this.mediaPlayer.prepareAsync();
        } catch (IllegalArgumentException e3) {
            MLogger.e(TAG, "streamRecording: ", e3);
            promise.reject((String) "fail", e3.getMessage());
        } catch (IllegalStateException e4) {
            MLogger.e(TAG, "streamRecording: ", e4);
            promise.reject((String) "fail", e4.getMessage());
        } catch (IOException e5) {
            MLogger.e(TAG, "streamRecording: ", e5);
            promise.reject((String) "fail", e5.getMessage());
        }
    }

    @ReactMethod
    public void startRecord(String str, Promise promise) {
        try {
            if (getCurrentActivity() != null) {
                int optInt = new JSONObject(str).optInt("maxDuration", 600000);
                File appExternalAudioRecordedStoragePath = FileUtils.getAppExternalAudioRecordedStoragePath(getCurrentActivity());
                File file = new File(appExternalAudioRecordedStoragePath, "MPL_Record_" + System.currentTimeMillis() + ".aac");
                if (!file.exists()) {
                    file.createNewFile();
                }
                MediaRecorder mediaRecorder = new MediaRecorder();
                this.myAudioRecorder = mediaRecorder;
                mediaRecorder.setAudioSource(1);
                this.myAudioRecorder.setOutputFormat(6);
                this.myAudioRecorder.setAudioEncoder(3);
                if (VERSION.SDK_INT >= 26) {
                    this.myAudioRecorder.setOutputFile(file);
                } else {
                    this.myAudioRecorder.setOutputFile(file.getAbsolutePath());
                }
                if (optInt > 0) {
                    this.myAudioRecorder.setMaxDuration(optInt);
                }
                this.myAudioRecorder.prepare();
                this.myAudioRecorder.start();
                promise.resolve(file.getAbsolutePath());
                MLogger.t(getCurrentActivity(), 0, "Recording Start");
                return;
            }
            promise.reject((String) "fail", (String) "Activity is null");
        } catch (Exception e2) {
            MLogger.e(TAG, "recordAudio: ", e2);
            promise.reject((String) "fail", e2.getMessage());
        }
    }

    @ReactMethod
    public void stopPlay() {
        try {
            Object[] objArr = new Object[2];
            objArr[0] = "stopPlay: ";
            objArr[1] = Boolean.valueOf(this.mediaPlayer != null && this.mediaPlayer.isPlaying());
            MLogger.d(TAG, objArr);
            if (this.mediaPlayer != null && this.mediaPlayer.isPlaying()) {
                this.mediaPlayer.stop();
                this.mediaPlayer.release();
                this.mediaPlayer.reset();
                this.mediaPlayer = null;
            }
            if (getCurrentActivity() != null) {
                MLogger.t(getCurrentActivity(), 1, "Stoping Audio");
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "stopPlay: ", e2);
        }
    }

    @ReactMethod
    public void stopRecord(Promise promise) {
        try {
            if (this.myAudioRecorder != null) {
                this.myAudioRecorder.stop();
                this.myAudioRecorder.release();
                this.myAudioRecorder = null;
            }
            MLogger.t(getCurrentActivity(), 0, "Recording Stop");
            promise.resolve("success");
        } catch (Exception e2) {
            MLogger.e(TAG, "stopRecording: ", e2);
            promise.reject((String) "fail", e2.getMessage());
        }
    }
}
