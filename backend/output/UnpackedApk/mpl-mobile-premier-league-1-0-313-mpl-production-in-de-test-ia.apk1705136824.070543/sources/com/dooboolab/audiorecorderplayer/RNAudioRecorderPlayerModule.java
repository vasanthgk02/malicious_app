package com.dooboolab.audiorecorderplayer;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.modules.core.PermissionListener;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001CB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u001f\u001a\u00020\tH\u0016J+\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u001d2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0#2\u0006\u0010$\u001a\u00020%H\u0016¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0007J\u0010\u0010+\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0007J\u0010\u0010,\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0007J\u0010\u0010-\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0007J\u0018\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u0002002\u0006\u0010)\u001a\u00020*H\u0007J\"\u00101\u001a\u00020(2\u0006\u0010\u0003\u001a\u0002022\u0006\u00103\u001a\u00020\t2\b\u00104\u001a\u0004\u0018\u000105H\u0002J\u0018\u00106\u001a\u00020(2\u0006\u00107\u001a\u0002002\u0006\u0010)\u001a\u00020*H\u0007J\u0018\u00108\u001a\u00020(2\u0006\u00109\u001a\u0002002\u0006\u0010)\u001a\u00020*H\u0007J\"\u0010:\u001a\u00020(2\u0006\u0010;\u001a\u00020\t2\b\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010)\u001a\u00020*H\u0007J*\u0010>\u001a\u00020(2\u0006\u0010;\u001a\u00020\t2\b\u0010?\u001a\u0004\u0018\u00010=2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*H\u0007J\u0010\u0010A\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0007J\u0010\u0010B\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/dooboolab/audiorecorderplayer/RNAudioRecorderPlayerModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "Lcom/facebook/react/modules/core/PermissionListener;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "_meteringEnabled", "", "audioFileURL", "", "mTask", "Ljava/util/TimerTask;", "mTimer", "Ljava/util/Timer;", "mediaPlayer", "Landroid/media/MediaPlayer;", "mediaRecorder", "Landroid/media/MediaRecorder;", "pausedRecordTime", "", "recordHandler", "Landroid/os/Handler;", "getRecordHandler", "()Landroid/os/Handler;", "setRecordHandler", "(Landroid/os/Handler;)V", "recorderRunnable", "Ljava/lang/Runnable;", "subsDurationMillis", "", "totalPausedRecordTime", "getName", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)Z", "pausePlayer", "", "promise", "Lcom/facebook/react/bridge/Promise;", "pauseRecorder", "resumePlayer", "resumeRecorder", "seekToPlayer", "time", "", "sendEvent", "Lcom/facebook/react/bridge/ReactContext;", "eventName", "params", "Lcom/facebook/react/bridge/WritableMap;", "setSubscriptionDuration", "sec", "setVolume", "volume", "startPlayer", "path", "httpHeaders", "Lcom/facebook/react/bridge/ReadableMap;", "startRecorder", "audioSet", "meteringEnabled", "stopPlayer", "stopRecorder", "Companion", "react-native-audio-recorder-player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RNAudioRecorderPlayerModule.kt */
public final class RNAudioRecorderPlayerModule extends ReactContextBaseJavaModule implements PermissionListener {
    public static final Companion Companion = new Companion(null);
    public static String defaultFileName = "sound.mp4";
    public static String tag = "RNAudioRecorderPlayer";
    public boolean _meteringEnabled;
    public String audioFileURL = "";
    public TimerTask mTask;
    public Timer mTimer;
    public MediaPlayer mediaPlayer;
    public MediaRecorder mediaRecorder;
    public long pausedRecordTime;
    public final ReactApplicationContext reactContext;
    public Handler recordHandler = new Handler(Looper.getMainLooper());
    public Runnable recorderRunnable;
    public int subsDurationMillis = 500;
    public long totalPausedRecordTime;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/dooboolab/audiorecorderplayer/RNAudioRecorderPlayerModule$Companion;", "", "()V", "defaultFileName", "", "tag", "react-native-audio-recorder-player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RNAudioRecorderPlayerModule.kt */
    public static final class Companion {
        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public RNAudioRecorderPlayerModule(ReactApplicationContext reactApplicationContext) {
        // Intrinsics.checkNotNullParameter(reactApplicationContext, "reactContext");
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    /* access modifiers changed from: private */
    public final void sendEvent(ReactContext reactContext2, String str, WritableMap writableMap) {
        ((RCTDeviceEventEmitter) reactContext2.getJSModule(RCTDeviceEventEmitter.class)).emit(str, writableMap);
    }

    /* renamed from: startPlayer$lambda-4  reason: not valid java name */
    public static final void m114startPlayer$lambda4(RNAudioRecorderPlayerModule rNAudioRecorderPlayerModule, String str, Promise promise, MediaPlayer mediaPlayer2) {
        Intrinsics.checkNotNullParameter(rNAudioRecorderPlayerModule, "this$0");
        Intrinsics.checkNotNullParameter(str, "$path");
        Intrinsics.checkNotNullParameter(promise, "$promise");
        mediaPlayer2.start();
        rNAudioRecorderPlayerModule.mTask = new RNAudioRecorderPlayerModule$startPlayer$1$1(mediaPlayer2, rNAudioRecorderPlayerModule);
        Timer timer = new Timer();
        rNAudioRecorderPlayerModule.mTimer = timer;
        Intrinsics.checkNotNull(timer);
        timer.schedule(rNAudioRecorderPlayerModule.mTask, 0, (long) rNAudioRecorderPlayerModule.subsDurationMillis);
        if (Intrinsics.areEqual(str, "DEFAULT")) {
            str = rNAudioRecorderPlayerModule.reactContext.getCacheDir() + '/' + defaultFileName;
        }
        promise.resolve(str);
    }

    /* renamed from: startPlayer$lambda-5  reason: not valid java name */
    public static final void m115startPlayer$lambda5(RNAudioRecorderPlayerModule rNAudioRecorderPlayerModule, MediaPlayer mediaPlayer2) {
        Intrinsics.checkNotNullParameter(rNAudioRecorderPlayerModule, "this$0");
        WritableMap createMap = Arguments.createMap();
        createMap.putInt(InlineAnimation.DURATION, mediaPlayer2.getDuration());
        createMap.putInt("currentPosition", mediaPlayer2.getDuration());
        rNAudioRecorderPlayerModule.sendEvent(rNAudioRecorderPlayerModule.reactContext, "rn-playback", createMap);
        Timer timer = rNAudioRecorderPlayerModule.mTimer;
        Intrinsics.checkNotNull(timer);
        timer.cancel();
        mediaPlayer2.stop();
        mediaPlayer2.release();
        rNAudioRecorderPlayerModule.mediaPlayer = null;
    }

    public String getName() {
        return tag;
    }

    public final Handler getRecordHandler() {
        return this.recordHandler;
    }

    public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        return i == 200 && iArr[0] == 0;
    }

    @ReactMethod
    public final void pausePlayer(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 == null) {
            promise.reject((String) "pausePlay", (String) "mediaPlayer is null on pause.");
            return;
        }
        try {
            Intrinsics.checkNotNull(mediaPlayer2);
            mediaPlayer2.pause();
            promise.resolve("pause player");
        } catch (Exception e2) {
            Intrinsics.stringPlus("pausePlay exception: ", e2.getMessage());
            promise.reject((String) "pausePlay", e2.getMessage());
        }
    }

    @ReactMethod
    public final void pauseRecorder(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        MediaRecorder mediaRecorder2 = this.mediaRecorder;
        if (mediaRecorder2 == null) {
            promise.reject((String) "pauseRecorder", (String) "Recorder is null.");
            return;
        }
        try {
            Intrinsics.checkNotNull(mediaRecorder2);
            mediaRecorder2.pause();
            this.pausedRecordTime = SystemClock.elapsedRealtime();
            Runnable runnable = this.recorderRunnable;
            if (runnable != null) {
                Handler recordHandler2 = getRecordHandler();
                Intrinsics.checkNotNull(recordHandler2);
                recordHandler2.removeCallbacks(runnable);
            }
            promise.resolve("Recorder paused.");
        } catch (Exception e2) {
            Intrinsics.stringPlus("pauseRecorder exception: ", e2.getMessage());
            promise.reject((String) "pauseRecorder", e2.getMessage());
        }
    }

    @ReactMethod
    public final void resumePlayer(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 == null) {
            promise.reject((String) "resume", (String) "mediaPlayer is null on resume.");
            return;
        }
        Intrinsics.checkNotNull(mediaPlayer2);
        if (mediaPlayer2.isPlaying()) {
            promise.reject((String) "resume", (String) "mediaPlayer is already running.");
            return;
        }
        try {
            MediaPlayer mediaPlayer3 = this.mediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer3);
            MediaPlayer mediaPlayer4 = this.mediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer4);
            mediaPlayer3.seekTo(mediaPlayer4.getCurrentPosition());
            MediaPlayer mediaPlayer5 = this.mediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer5);
            mediaPlayer5.start();
            promise.resolve("resume player");
        } catch (Exception e2) {
            Intrinsics.stringPlus("mediaPlayer resume: ", e2.getMessage());
            promise.reject((String) "resume", e2.getMessage());
        }
    }

    @ReactMethod
    public final void resumeRecorder(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        MediaRecorder mediaRecorder2 = this.mediaRecorder;
        if (mediaRecorder2 == null) {
            promise.reject((String) "resumeReocrder", (String) "Recorder is null.");
            return;
        }
        try {
            Intrinsics.checkNotNull(mediaRecorder2);
            mediaRecorder2.resume();
            this.totalPausedRecordTime = (SystemClock.elapsedRealtime() - this.pausedRecordTime) + this.totalPausedRecordTime;
            Runnable runnable = this.recorderRunnable;
            if (runnable != null) {
                Handler recordHandler2 = getRecordHandler();
                Intrinsics.checkNotNull(recordHandler2);
                recordHandler2.postDelayed(runnable, (long) this.subsDurationMillis);
            }
            promise.resolve("Recorder resumed.");
        } catch (Exception e2) {
            Intrinsics.stringPlus("Recorder resume: ", e2.getMessage());
            promise.reject((String) "resumeRecorder", e2.getMessage());
        }
    }

    @ReactMethod
    public final void seekToPlayer(double d2, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 == null) {
            promise.reject((String) "seekTo", (String) "mediaPlayer is null on seek.");
            return;
        }
        Intrinsics.checkNotNull(mediaPlayer2);
        mediaPlayer2.seekTo((int) d2);
        promise.resolve("pause player");
    }

    public final void setRecordHandler(Handler handler) {
        this.recordHandler = handler;
    }

    @ReactMethod
    public final void setSubscriptionDuration(double d2, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        int i = (int) (d2 * ((double) 1000));
        this.subsDurationMillis = i;
        promise.resolve(Intrinsics.stringPlus("setSubscriptionDuration: ", Integer.valueOf(i)));
    }

    @ReactMethod
    public final void setVolume(double d2, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 == null) {
            promise.reject((String) "setVolume", (String) "player is null.");
            return;
        }
        float f2 = (float) d2;
        Intrinsics.checkNotNull(mediaPlayer2);
        mediaPlayer2.setVolume(f2, f2);
        promise.resolve("set volume");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0023, code lost:
        if (r6.getCurrentPosition() > 1) goto L_0x0027;
     */
    @com.facebook.react.bridge.ReactMethod
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void startPlayer(java.lang.String r6, com.facebook.react.bridge.ReadableMap r7, com.facebook.react.bridge.Promise r8) {
        /*
            r5 = this;
            java.lang.String r0 = "path"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "promise"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            android.media.MediaPlayer r0 = r5.mediaPlayer
            java.lang.String r1 = "startPlay"
            if (r0 == 0) goto L_0x003d
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            boolean r6 = r0.isPlaying()
            r7 = 1
            if (r6 != 0) goto L_0x0026
            android.media.MediaPlayer r6 = r5.mediaPlayer
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            int r6 = r6.getCurrentPosition()
            if (r6 <= r7) goto L_0x0026
            goto L_0x0027
        L_0x0026:
            r7 = 0
        L_0x0027:
            if (r7 == 0) goto L_0x0037
            android.media.MediaPlayer r6 = r5.mediaPlayer
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            r6.start()
            java.lang.String r6 = "player resumed."
            r8.resolve(r6)
            return
        L_0x0037:
            java.lang.String r6 = "Player is already running. Stop it first."
            r8.reject(r1, r6)
            return
        L_0x003d:
            android.media.MediaPlayer r0 = new android.media.MediaPlayer
            r0.<init>()
            r5.mediaPlayer = r0
            java.lang.String r0 = "DEFAULT"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r0)     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            if (r0 == 0) goto L_0x0071
            android.media.MediaPlayer r7 = r5.mediaPlayer     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            r0.<init>()     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            com.facebook.react.bridge.ReactApplicationContext r2 = r5.reactContext     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            java.io.File r2 = r2.getCacheDir()     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            r0.append(r2)     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            r2 = 47
            r0.append(r2)     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            java.lang.String r2 = defaultFileName     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            r0.append(r2)     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            r7.setDataSource(r0)     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            goto L_0x00b8
        L_0x0071:
            if (r7 == 0) goto L_0x00b0
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            r0.<init>()     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            com.facebook.react.bridge.ReadableMapKeySetIterator r2 = r7.keySetIterator()     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            java.lang.String r3 = "httpHeaders.keySetIterator()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
        L_0x0081:
            boolean r3 = r2.hasNextKey()     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            if (r3 == 0) goto L_0x0098
            java.lang.String r3 = r2.nextKey()     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            java.lang.String r4 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            java.lang.String r4 = r7.getString(r3)     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            r0.put(r3, r4)     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            goto L_0x0081
        L_0x0098:
            android.media.MediaPlayer r7 = r5.mediaPlayer     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            android.app.Activity r2 = r5.getCurrentActivity()     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            android.net.Uri r3 = android.net.Uri.parse(r6)     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            r7.setDataSource(r2, r3, r0)     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            goto L_0x00b8
        L_0x00b0:
            android.media.MediaPlayer r7 = r5.mediaPlayer     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            r7.setDataSource(r6)     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
        L_0x00b8:
            android.media.MediaPlayer r7 = r5.mediaPlayer     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            com.dooboolab.audiorecorderplayer.-$$Lambda$A9wQaeRvi2EuwvwGt4ZD__oKMhk r0 = new com.dooboolab.audiorecorderplayer.-$$Lambda$A9wQaeRvi2EuwvwGt4ZD__oKMhk     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            r0.<init>(r6, r8)     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            r7.setOnPreparedListener(r0)     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            android.media.MediaPlayer r6 = r5.mediaPlayer     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            com.dooboolab.audiorecorderplayer.-$$Lambda$BrZiyrjSYozJfDeTvIx8d55sNN4 r7 = new com.dooboolab.audiorecorderplayer.-$$Lambda$BrZiyrjSYozJfDeTvIx8d55sNN4     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            r7.<init>()     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            r6.setOnCompletionListener(r7)     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            android.media.MediaPlayer r6 = r5.mediaPlayer     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            r6.prepare()     // Catch:{ IOException -> 0x00db, NullPointerException -> 0x00e3 }
            goto L_0x00e3
        L_0x00db:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            r8.reject(r1, r6)
        L_0x00e3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dooboolab.audiorecorderplayer.RNAudioRecorderPlayerModule.startPlayer(java.lang.String, com.facebook.react.bridge.ReadableMap, com.facebook.react.bridge.Promise):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        if (androidx.core.content.ContextCompat.checkSelfPermission(r6.reactContext, com.netcore.android.SMTConfigConstants.WRITE_STORAGE_PERMISSION_MF_KEY) != 0) goto L_0x002f;
     */
    @com.facebook.react.bridge.ReactMethod
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void startRecorder(java.lang.String r7, com.facebook.react.bridge.ReadableMap r8, boolean r9, com.facebook.react.bridge.Promise r10) {
        /*
            r6 = this;
            java.lang.String r0 = "Try again after adding permission."
            java.lang.String r1 = "No permission granted."
            java.lang.String r2 = "path"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r2)
            java.lang.String r2 = "promise"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r2)
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ NullPointerException -> 0x0173 }
            r3 = 23
            if (r2 < r3) goto L_0x005b
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ NullPointerException -> 0x0173 }
            r3 = 33
            r4 = 0
            java.lang.String r5 = "android.permission.RECORD_AUDIO"
            if (r2 >= r3) goto L_0x0041
            com.facebook.react.bridge.ReactApplicationContext r2 = r6.reactContext     // Catch:{ NullPointerException -> 0x0173 }
            int r2 = androidx.core.content.ContextCompat.checkSelfPermission(r2, r5)     // Catch:{ NullPointerException -> 0x0173 }
            java.lang.String r3 = "android.permission.WRITE_EXTERNAL_STORAGE"
            if (r2 != 0) goto L_0x002f
            com.facebook.react.bridge.ReactApplicationContext r2 = r6.reactContext     // Catch:{ NullPointerException -> 0x0173 }
            int r2 = androidx.core.content.ContextCompat.checkSelfPermission(r2, r3)     // Catch:{ NullPointerException -> 0x0173 }
            if (r2 == 0) goto L_0x0041
        L_0x002f:
            android.app.Activity r7 = r6.getCurrentActivity()     // Catch:{ NullPointerException -> 0x0173 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch:{ NullPointerException -> 0x0173 }
            java.lang.String[] r8 = new java.lang.String[]{r5, r3}     // Catch:{ NullPointerException -> 0x0173 }
            androidx.core.app.ActivityCompat.requestPermissions(r7, r8, r4)     // Catch:{ NullPointerException -> 0x0173 }
            r10.reject(r1, r0)     // Catch:{ NullPointerException -> 0x0173 }
            return
        L_0x0041:
            com.facebook.react.bridge.ReactApplicationContext r2 = r6.reactContext     // Catch:{ NullPointerException -> 0x0173 }
            int r2 = androidx.core.content.ContextCompat.checkSelfPermission(r2, r5)     // Catch:{ NullPointerException -> 0x0173 }
            if (r2 == 0) goto L_0x005b
            android.app.Activity r7 = r6.getCurrentActivity()     // Catch:{ NullPointerException -> 0x0173 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch:{ NullPointerException -> 0x0173 }
            java.lang.String[] r8 = new java.lang.String[]{r5}     // Catch:{ NullPointerException -> 0x0173 }
            androidx.core.app.ActivityCompat.requestPermissions(r7, r8, r4)     // Catch:{ NullPointerException -> 0x0173 }
            r10.reject(r1, r0)     // Catch:{ NullPointerException -> 0x0173 }
            return
        L_0x005b:
            java.lang.String r0 = "DEFAULT"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r0)
            if (r0 == 0) goto L_0x007f
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            com.facebook.react.bridge.ReactApplicationContext r0 = r6.reactContext
            java.io.File r0 = r0.getCacheDir()
            r7.append(r0)
            r0 = 47
            r7.append(r0)
            java.lang.String r0 = defaultFileName
            r7.append(r0)
            java.lang.String r7 = r7.toString()
        L_0x007f:
            r6.audioFileURL = r7
            r6._meteringEnabled = r9
            android.media.MediaRecorder r7 = r6.mediaRecorder
            if (r7 != 0) goto L_0x008e
            android.media.MediaRecorder r7 = new android.media.MediaRecorder
            r7.<init>()
            r6.mediaRecorder = r7
        L_0x008e:
            r7 = 48000(0xbb80, float:6.7262E-41)
            r9 = 128000(0x1f400, float:1.79366E-40)
            r0 = 3
            r1 = 2
            r2 = 1
            if (r8 == 0) goto L_0x00fe
            android.media.MediaRecorder r3 = r6.mediaRecorder
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.String r4 = "AudioSourceAndroid"
            boolean r5 = r8.hasKey(r4)
            if (r5 == 0) goto L_0x00aa
            int r2 = r8.getInt(r4)
        L_0x00aa:
            r3.setAudioSource(r2)
            android.media.MediaRecorder r2 = r6.mediaRecorder
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.String r3 = "OutputFormatAndroid"
            boolean r4 = r8.hasKey(r3)
            if (r4 == 0) goto L_0x00be
            int r1 = r8.getInt(r3)
        L_0x00be:
            r2.setOutputFormat(r1)
            android.media.MediaRecorder r1 = r6.mediaRecorder
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.String r2 = "AudioEncoderAndroid"
            boolean r3 = r8.hasKey(r2)
            if (r3 == 0) goto L_0x00d2
            int r0 = r8.getInt(r2)
        L_0x00d2:
            r1.setAudioEncoder(r0)
            android.media.MediaRecorder r0 = r6.mediaRecorder
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r1 = "AudioSamplingRateAndroid"
            boolean r2 = r8.hasKey(r1)
            if (r2 == 0) goto L_0x00e6
            int r7 = r8.getInt(r1)
        L_0x00e6:
            r0.setAudioSamplingRate(r7)
            android.media.MediaRecorder r7 = r6.mediaRecorder
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            java.lang.String r0 = "AudioEncodingBitRateAndroid"
            boolean r1 = r8.hasKey(r0)
            if (r1 == 0) goto L_0x00fa
            int r9 = r8.getInt(r0)
        L_0x00fa:
            r7.setAudioEncodingBitRate(r9)
            goto L_0x0126
        L_0x00fe:
            android.media.MediaRecorder r8 = r6.mediaRecorder
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            r8.setAudioSource(r2)
            android.media.MediaRecorder r8 = r6.mediaRecorder
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            r8.setOutputFormat(r1)
            android.media.MediaRecorder r8 = r6.mediaRecorder
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            r8.setAudioEncoder(r0)
            android.media.MediaRecorder r8 = r6.mediaRecorder
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            r8.setAudioEncodingBitRate(r9)
            android.media.MediaRecorder r8 = r6.mediaRecorder
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            r8.setAudioSamplingRate(r7)
        L_0x0126:
            android.media.MediaRecorder r7 = r6.mediaRecorder
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            java.lang.String r8 = r6.audioFileURL
            r7.setOutputFile(r8)
            android.media.MediaRecorder r7 = r6.mediaRecorder     // Catch:{ Exception -> 0x0168 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch:{ Exception -> 0x0168 }
            r7.prepare()     // Catch:{ Exception -> 0x0168 }
            r7 = 0
            r6.totalPausedRecordTime = r7     // Catch:{ Exception -> 0x0168 }
            android.media.MediaRecorder r7 = r6.mediaRecorder     // Catch:{ Exception -> 0x0168 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch:{ Exception -> 0x0168 }
            r7.start()     // Catch:{ Exception -> 0x0168 }
            long r7 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0168 }
            com.dooboolab.audiorecorderplayer.RNAudioRecorderPlayerModule$startRecorder$1 r9 = new com.dooboolab.audiorecorderplayer.RNAudioRecorderPlayerModule$startRecorder$1     // Catch:{ Exception -> 0x0168 }
            r9.<init>(r7, r6)     // Catch:{ Exception -> 0x0168 }
            r6.recorderRunnable = r9     // Catch:{ Exception -> 0x0168 }
            if (r9 == 0) goto L_0x0160
            r9.run()     // Catch:{ Exception -> 0x0168 }
            java.lang.String r7 = "file:///"
            java.lang.String r8 = r6.audioFileURL     // Catch:{ Exception -> 0x0168 }
            java.lang.String r7 = kotlin.jvm.internal.Intrinsics.stringPlus(r7, r8)     // Catch:{ Exception -> 0x0168 }
            r10.resolve(r7)     // Catch:{ Exception -> 0x0168 }
            goto L_0x0172
        L_0x0160:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x0168 }
            java.lang.String r8 = "null cannot be cast to non-null type java.lang.Runnable"
            r7.<init>(r8)     // Catch:{ Exception -> 0x0168 }
            throw r7     // Catch:{ Exception -> 0x0168 }
        L_0x0168:
            r7 = move-exception
            java.lang.String r7 = r7.getMessage()
            java.lang.String r8 = "startRecord"
            r10.reject(r8, r7)
        L_0x0172:
            return
        L_0x0173:
            r7 = move-exception
            r7.toString()
            r10.reject(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dooboolab.audiorecorderplayer.RNAudioRecorderPlayerModule.startRecorder(java.lang.String, com.facebook.react.bridge.ReadableMap, boolean, com.facebook.react.bridge.Promise):void");
    }

    @ReactMethod
    public final void stopPlayer(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        Timer timer = this.mTimer;
        if (timer != null) {
            Intrinsics.checkNotNull(timer);
            timer.cancel();
        }
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 == null) {
            promise.resolve("Already stopped player");
            return;
        }
        try {
            Intrinsics.checkNotNull(mediaPlayer2);
            mediaPlayer2.release();
            this.mediaPlayer = null;
            promise.resolve("stopped player");
        } catch (Exception e2) {
            Intrinsics.stringPlus("stopPlay exception: ", e2.getMessage());
            promise.reject((String) "stopPlay", e2.getMessage());
        }
    }

    @ReactMethod
    public final void stopRecorder(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        if (this.recordHandler != null) {
            Runnable runnable = this.recorderRunnable;
            if (runnable != null) {
                Handler recordHandler2 = getRecordHandler();
                Intrinsics.checkNotNull(recordHandler2);
                recordHandler2.removeCallbacks(runnable);
            }
        }
        MediaRecorder mediaRecorder2 = this.mediaRecorder;
        if (mediaRecorder2 == null) {
            promise.reject((String) "stopRecord", (String) "recorder is null.");
            return;
        }
        try {
            Intrinsics.checkNotNull(mediaRecorder2);
            mediaRecorder2.stop();
        } catch (RuntimeException e2) {
            String message = e2.getMessage();
            if (message != null) {
                Intrinsics.stringPlus("", message);
            }
            promise.reject((String) "stopRecord", e2.getMessage());
        }
        MediaRecorder mediaRecorder3 = this.mediaRecorder;
        Intrinsics.checkNotNull(mediaRecorder3);
        mediaRecorder3.release();
        this.mediaRecorder = null;
        promise.resolve(Intrinsics.stringPlus("file:///", this.audioFileURL));
    }
}
