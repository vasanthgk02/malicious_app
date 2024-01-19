package com.brentvatne.react;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.graphics.Matrix;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnTimedMetaDataAvailableListener;
import android.media.MediaPlayer.TrackInfo;
import android.media.TimedMetaData;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.widget.MediaController;
import android.widget.MediaController.MediaPlayerControl;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.vending.expansion.zipfile.ZipResourceFile;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.netcore.android.SMTConfigConstants;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.yqritc.scalablevideoview.ScalableType;
import com.yqritc.scalablevideoview.ScalableVideoView;
import com.yqritc.scalablevideoview.ScaleManager;
import com.yqritc.scalablevideoview.Size;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;
import io.antmedia.android.broadcaster.LiveVideoBroadcaster;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.HashMap;
import org.jboss.netty.handler.codec.http.HttpHeaders.Names;

@SuppressLint({"ViewConstructor"})
public class ReactVideoView extends ScalableVideoView implements OnPreparedListener, OnErrorListener, OnBufferingUpdateListener, OnSeekCompleteListener, OnCompletionListener, OnInfoListener, LifecycleEventListener, MediaPlayerControl {
    public boolean isCompleted = false;
    public float mActiveRate = 1.0f;
    public boolean mBackgroundPaused = false;
    public RCTEventEmitter mEventEmitter;
    public boolean mIsFullscreen = false;
    public int mMainVer = 0;
    public boolean mMediaPlayerValid = false;
    public boolean mMuted = false;
    public int mPatchVer = 0;
    public boolean mPaused = false;
    public boolean mPlayInBackground = false;
    public Handler mProgressUpdateHandler = new Handler();
    public float mProgressUpdateInterval = 250.0f;
    public Runnable mProgressUpdateRunnable = null;
    public float mRate = 1.0f;
    public boolean mRepeat = false;
    public ReadableMap mRequestHeaders = null;
    public ScalableType mResizeMode = ScalableType.LEFT_TOP;
    public long mSeekTime = 0;
    public boolean mSrcIsAsset = false;
    public boolean mSrcIsNetwork = false;
    public String mSrcType = "mp4";
    public String mSrcUriString = null;
    public float mStereoPan = 0.0f;
    public ThemedReactContext mThemedReactContext;
    public boolean mUseNativeControls = false;
    public int mVideoBufferedDuration = 0;
    public int mVideoDuration = 0;
    public float mVolume = 1.0f;
    public MediaController mediaController;
    public Handler videoControlHandler = new Handler();

    public enum Events {
        EVENT_LOAD_START("onVideoLoadStart"),
        EVENT_LOAD("onVideoLoad"),
        EVENT_ERROR("onVideoError"),
        EVENT_PROGRESS("onVideoProgress"),
        EVENT_TIMED_METADATA("onTimedMetadata"),
        EVENT_SEEK("onVideoSeek"),
        EVENT_END("onVideoEnd"),
        EVENT_STALLED("onPlaybackStalled"),
        EVENT_RESUME("onPlaybackResume"),
        EVENT_READY_FOR_DISPLAY("onReadyForDisplay"),
        EVENT_FULLSCREEN_WILL_PRESENT("onVideoFullscreenPlayerWillPresent"),
        EVENT_FULLSCREEN_DID_PRESENT("onVideoFullscreenPlayerDidPresent"),
        EVENT_FULLSCREEN_WILL_DISMISS("onVideoFullscreenPlayerWillDismiss"),
        EVENT_FULLSCREEN_DID_DISMISS("onVideoFullscreenPlayerDidDismiss");
        
        public final String mName;

        /* access modifiers changed from: public */
        Events(String str) {
            this.mName = str;
        }

        public String toString() {
            return this.mName;
        }
    }

    @TargetApi(23)
    public class TimedMetaDataAvailableListener implements OnTimedMetaDataAvailableListener {
        public TimedMetaDataAvailableListener() {
        }

        public void onTimedMetaDataAvailable(MediaPlayer mediaPlayer, TimedMetaData timedMetaData) {
            WritableMap createMap = Arguments.createMap();
            try {
                String str = new String(timedMetaData.getMetaData(), "UTF-8");
                WritableMap createMap2 = Arguments.createMap();
                createMap2.putString(HSLCriteriaBuilder.VALUE, str.substring(str.lastIndexOf("\u0003") + 1));
                createMap2.putString("identifier", "id3/TDEN");
                WritableNativeArray writableNativeArray = new WritableNativeArray();
                writableNativeArray.pushMap(createMap2);
                createMap.putArray(LiveVideoBroadcaster.METADATA, writableNativeArray);
                createMap.putDouble("target", (double) ReactVideoView.this.getId());
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            ReactVideoView reactVideoView = ReactVideoView.this;
            reactVideoView.mEventEmitter.receiveEvent(reactVideoView.getId(), Events.EVENT_TIMED_METADATA.toString(), createMap);
        }
    }

    public ReactVideoView(ThemedReactContext themedReactContext) {
        super(themedReactContext, null);
        this.mThemedReactContext = themedReactContext;
        this.mEventEmitter = (RCTEventEmitter) themedReactContext.getJSModule(RCTEventEmitter.class);
        themedReactContext.addLifecycleEventListener(this);
        initializeMediaPlayerIfNeeded();
        setSurfaceTextureListener(this);
        this.mProgressUpdateRunnable = new Runnable() {
            public void run() {
                ReactVideoView reactVideoView = ReactVideoView.this;
                if (reactVideoView.mMediaPlayerValid && !reactVideoView.isCompleted && !reactVideoView.mPaused && !reactVideoView.mBackgroundPaused) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putDouble("currentTime", ((double) ReactVideoView.this.mMediaPlayer.getCurrentPosition()) / 1000.0d);
                    createMap.putDouble("playableDuration", ((double) ReactVideoView.this.mVideoBufferedDuration) / 1000.0d);
                    createMap.putDouble("seekableDuration", ((double) ReactVideoView.this.mVideoDuration) / 1000.0d);
                    ReactVideoView reactVideoView2 = ReactVideoView.this;
                    reactVideoView2.mEventEmitter.receiveEvent(reactVideoView2.getId(), Events.EVENT_PROGRESS.toString(), createMap);
                    ReactVideoView reactVideoView3 = ReactVideoView.this;
                    reactVideoView3.mProgressUpdateHandler.postDelayed(reactVideoView3.mProgressUpdateRunnable, (long) Math.round(reactVideoView3.mProgressUpdateInterval));
                }
            }
        };
    }

    public final float calulateRelativeVolume() {
        return new BigDecimal((double) ((1.0f - Math.abs(this.mStereoPan)) * this.mVolume)).setScale(1, 4).floatValue();
    }

    public boolean canPause() {
        return true;
    }

    public boolean canSeekBackward() {
        return true;
    }

    public boolean canSeekForward() {
        return true;
    }

    public int getAudioSessionId() {
        return 0;
    }

    public int getBufferPercentage() {
        return 0;
    }

    public final void initializeMediaPlayerIfNeeded() {
        if (this.mMediaPlayer == null) {
            this.mMediaPlayerValid = false;
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.mMediaPlayer = mediaPlayer;
            mediaPlayer.setScreenOnWhilePlaying(true);
            this.mMediaPlayer.setOnVideoSizeChangedListener(this);
            this.mMediaPlayer.setOnErrorListener(this);
            this.mMediaPlayer.setOnPreparedListener(this);
            this.mMediaPlayer.setOnBufferingUpdateListener(this);
            this.mMediaPlayer.setOnSeekCompleteListener(this);
            this.mMediaPlayer.setOnCompletionListener(this);
            this.mMediaPlayer.setOnInfoListener(this);
            if (VERSION.SDK_INT >= 23) {
                this.mMediaPlayer.setOnTimedMetaDataAvailableListener(new TimedMetaDataAvailableListener());
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        int i = this.mMainVer;
        if (i > 0) {
            setSrc(this.mSrcUriString, this.mSrcType, this.mSrcIsNetwork, this.mSrcIsAsset, this.mRequestHeaders, i, this.mPatchVer);
        } else {
            setSrc(this.mSrcUriString, this.mSrcType, this.mSrcIsNetwork, this.mSrcIsAsset, this.mRequestHeaders, 0, 0);
        }
        setKeepScreenOn(true);
    }

    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        selectTimedMetadataTrack(mediaPlayer);
        this.mVideoBufferedDuration = (int) Math.round(((double) (this.mVideoDuration * i)) / 100.0d);
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        this.isCompleted = true;
        this.mEventEmitter.receiveEvent(getId(), Events.EVENT_END.toString(), null);
        if (!this.mRepeat) {
            setKeepScreenOn(false);
        }
    }

    public void onDetachedFromWindow() {
        this.mMediaPlayerValid = false;
        super.onDetachedFromWindow();
        setKeepScreenOn(false);
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("what", i);
        createMap.putInt(MiPushMessage.KEY_EXTRA, i2);
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putMap("error", createMap);
        this.mEventEmitter.receiveEvent(getId(), Events.EVENT_ERROR.toString(), createMap2);
        return true;
    }

    public void onHostDestroy() {
    }

    public void onHostPause() {
        if (this.mMediaPlayerValid && !this.mPaused && !this.mPlayInBackground) {
            this.mBackgroundPaused = true;
            this.mMediaPlayer.pause();
        }
    }

    public void onHostResume() {
        this.mBackgroundPaused = false;
        if (this.mMediaPlayerValid && !this.mPlayInBackground && !this.mPaused) {
            new Handler().post(new Runnable() {
                public void run() {
                    ReactVideoView.this.setPausedModifier(false);
                }
            });
        }
    }

    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        if (i == 3) {
            this.mEventEmitter.receiveEvent(getId(), Events.EVENT_READY_FOR_DISPLAY.toString(), Arguments.createMap());
        } else if (i == 701) {
            this.mEventEmitter.receiveEvent(getId(), Events.EVENT_STALLED.toString(), Arguments.createMap());
        } else if (i == 702) {
            this.mEventEmitter.receiveEvent(getId(), Events.EVENT_RESUME.toString(), Arguments.createMap());
        }
        return false;
    }

    @SuppressLint({"DrawAllocation"})
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && this.mMediaPlayerValid) {
            int videoWidth = getVideoWidth();
            int videoHeight = getVideoHeight();
            if (videoWidth != 0 && videoHeight != 0) {
                Matrix scaleMatrix = new ScaleManager(new Size(getWidth(), getHeight()), new Size(videoWidth, videoHeight)).getScaleMatrix(this.mScalableType);
                if (scaleMatrix != null) {
                    setTransform(scaleMatrix);
                }
            }
        }
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        this.mMediaPlayerValid = true;
        this.mVideoDuration = mediaPlayer.getDuration();
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("width", mediaPlayer.getVideoWidth());
        createMap.putInt("height", mediaPlayer.getVideoHeight());
        if (mediaPlayer.getVideoWidth() > mediaPlayer.getVideoHeight()) {
            createMap.putString("orientation", SMTConfigConstants.SCREEN_ORIENTATION_LANDSCAPE);
        } else {
            createMap.putString("orientation", SMTConfigConstants.SCREEN_ORIENTATION_PORTRAIT);
        }
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putDouble(InlineAnimation.DURATION, ((double) this.mVideoDuration) / 1000.0d);
        createMap2.putDouble("currentTime", ((double) mediaPlayer.getCurrentPosition()) / 1000.0d);
        createMap2.putMap("naturalSize", createMap);
        createMap2.putBoolean("canPlayFastForward", true);
        createMap2.putBoolean("canPlaySlowForward", true);
        createMap2.putBoolean("canPlaySlowReverse", true);
        createMap2.putBoolean("canPlayReverse", true);
        createMap2.putBoolean("canPlayFastForward", true);
        createMap2.putBoolean("canStepBackward", true);
        createMap2.putBoolean("canStepForward", true);
        this.mEventEmitter.receiveEvent(getId(), Events.EVENT_LOAD.toString(), createMap2);
        setResizeModeModifier(this.mResizeMode);
        setRepeatModifier(this.mRepeat);
        setPausedModifier(this.mPaused);
        setMutedModifier(this.mMuted);
        setProgressUpdateInterval(this.mProgressUpdateInterval);
        setRateModifier(this.mRate);
        if (this.mUseNativeControls) {
            if (this.mediaController == null) {
                this.mediaController = new MediaController(getContext());
            }
            this.mediaController.setMediaPlayer(this);
            this.mediaController.setAnchorView(this);
            this.videoControlHandler.post(new Runnable() {
                public void run() {
                    ReactVideoView.this.mediaController.setEnabled(true);
                    ReactVideoView.this.mediaController.show();
                }
            });
        }
        selectTimedMetadataTrack(mediaPlayer);
    }

    public void onSeekComplete(MediaPlayer mediaPlayer) {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("currentTime", ((double) getCurrentPosition()) / 1000.0d);
        createMap.putDouble("seekTime", ((double) this.mSeekTime) / 1000.0d);
        this.mEventEmitter.receiveEvent(getId(), Events.EVENT_SEEK.toString(), createMap);
        this.mSeekTime = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mUseNativeControls) {
            if (this.mediaController == null) {
                this.mediaController = new MediaController(getContext());
            }
            this.mediaController.show();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void seekTo(int i) {
        if (this.mMediaPlayerValid) {
            this.mSeekTime = (long) i;
            this.mMediaPlayer.seekTo(i);
            if (this.isCompleted) {
                int i2 = this.mVideoDuration;
                if (i2 != 0 && i < i2) {
                    this.isCompleted = false;
                }
            }
        }
    }

    public final void selectTimedMetadataTrack(MediaPlayer mediaPlayer) {
        if (VERSION.SDK_INT >= 23) {
            try {
                TrackInfo[] trackInfo = mediaPlayer.getTrackInfo();
                int i = 0;
                while (true) {
                    if (i >= trackInfo.length) {
                        break;
                    } else if (trackInfo[i].getTrackType() == 3) {
                        mediaPlayer.selectTrack(i);
                        break;
                    } else {
                        i++;
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public void setControls(boolean z) {
        this.mUseNativeControls = z;
    }

    public void setFullscreen(boolean z) {
        if (z != this.mIsFullscreen) {
            this.mIsFullscreen = z;
            Activity currentActivity = this.mThemedReactContext.getCurrentActivity();
            if (currentActivity != null) {
                View decorView = currentActivity.getWindow().getDecorView();
                if (this.mIsFullscreen) {
                    this.mEventEmitter.receiveEvent(getId(), Events.EVENT_FULLSCREEN_WILL_PRESENT.toString(), null);
                    decorView.setSystemUiVisibility(4102);
                    this.mEventEmitter.receiveEvent(getId(), Events.EVENT_FULLSCREEN_DID_PRESENT.toString(), null);
                } else {
                    this.mEventEmitter.receiveEvent(getId(), Events.EVENT_FULLSCREEN_WILL_DISMISS.toString(), null);
                    decorView.setSystemUiVisibility(0);
                    this.mEventEmitter.receiveEvent(getId(), Events.EVENT_FULLSCREEN_DID_DISMISS.toString(), null);
                }
            }
        }
    }

    public void setMutedModifier(boolean z) {
        this.mMuted = z;
        if (this.mMediaPlayerValid) {
            if (z) {
                this.mMediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                float f2 = this.mStereoPan;
                if (f2 < 0.0f) {
                    this.mMediaPlayer.setVolume(this.mVolume, calulateRelativeVolume());
                } else if (f2 > 0.0f) {
                    this.mMediaPlayer.setVolume(calulateRelativeVolume(), this.mVolume);
                } else {
                    float f3 = this.mVolume;
                    this.mMediaPlayer.setVolume(f3, f3);
                }
            }
        }
    }

    public void setPausedModifier(boolean z) {
        this.mPaused = z;
        if (this.mMediaPlayerValid) {
            if (z) {
                if (this.mMediaPlayer.isPlaying()) {
                    pause();
                }
            } else if (!this.mMediaPlayer.isPlaying()) {
                start();
                float f2 = this.mRate;
                if (f2 != this.mActiveRate) {
                    setRateModifier(f2);
                }
                this.mProgressUpdateHandler.post(this.mProgressUpdateRunnable);
            }
            setKeepScreenOn(!this.mPaused);
        }
    }

    public void setPlayInBackground(boolean z) {
        this.mPlayInBackground = z;
    }

    public void setProgressUpdateInterval(float f2) {
        this.mProgressUpdateInterval = f2;
    }

    public void setRateModifier(float f2) {
        this.mRate = f2;
        if (this.mMediaPlayerValid && VERSION.SDK_INT >= 23 && !this.mPaused) {
            try {
                this.mMediaPlayer.setPlaybackParams(this.mMediaPlayer.getPlaybackParams().setSpeed(f2));
                this.mActiveRate = f2;
            } catch (Exception unused) {
            }
        }
    }

    public void setRepeatModifier(boolean z) {
        this.mRepeat = z;
        if (this.mMediaPlayerValid) {
            setLooping(z);
        }
    }

    public void setResizeModeModifier(ScalableType scalableType) {
        this.mResizeMode = scalableType;
        if (this.mMediaPlayerValid) {
            setScalableType(scalableType);
            invalidate();
        }
    }

    public void setSrc(String str, String str2, boolean z, boolean z2, ReadableMap readableMap, int i, int i2) {
        this.mSrcUriString = str;
        this.mSrcType = str2;
        this.mSrcIsNetwork = z;
        this.mSrcIsAsset = z2;
        this.mRequestHeaders = readableMap;
        this.mMainVer = i;
        this.mPatchVer = i2;
        this.mMediaPlayerValid = false;
        this.mVideoDuration = 0;
        this.mVideoBufferedDuration = 0;
        initializeMediaPlayerIfNeeded();
        this.mMediaPlayer.reset();
        if (z) {
            try {
                CookieManager instance = CookieManager.getInstance();
                Uri parse = Uri.parse(str);
                String cookie = instance.getCookie(parse.buildUpon().build().toString());
                HashMap hashMap = new HashMap();
                if (cookie != null) {
                    hashMap.put(Names.COOKIE, cookie);
                }
                if (this.mRequestHeaders != null) {
                    ReadableMap readableMap2 = this.mRequestHeaders;
                    HashMap hashMap2 = new HashMap();
                    if (readableMap2 != null) {
                        ReadableMapKeySetIterator keySetIterator = readableMap2.keySetIterator();
                        while (keySetIterator.hasNextKey()) {
                            String nextKey = keySetIterator.nextKey();
                            hashMap2.put(nextKey, readableMap2.getString(nextKey));
                        }
                    }
                    hashMap.putAll(hashMap2);
                }
                ThemedReactContext themedReactContext = this.mThemedReactContext;
                initializeMediaPlayer();
                this.mMediaPlayer.setDataSource(themedReactContext, parse, hashMap);
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        } else if (!z2) {
            AssetFileDescriptor assetFileDescriptor = null;
            if (this.mMainVer > 0) {
                try {
                    ZipResourceFile aPKExpansionZipFile = k.getAPKExpansionZipFile(this.mThemedReactContext, this.mMainVer, this.mPatchVer);
                    assetFileDescriptor = aPKExpansionZipFile.getAssetFileDescriptor(str.replace(".mp4", "") + ".mp4");
                } catch (IOException e3) {
                    e3.printStackTrace();
                } catch (NullPointerException e4) {
                    e4.printStackTrace();
                }
            }
            if (assetFileDescriptor == null) {
                int identifier = this.mThemedReactContext.getResources().getIdentifier(str, "drawable", this.mThemedReactContext.getPackageName());
                if (identifier == 0) {
                    identifier = this.mThemedReactContext.getResources().getIdentifier(str, "raw", this.mThemedReactContext.getPackageName());
                }
                setRawData(identifier);
            } else {
                FileDescriptor fileDescriptor = assetFileDescriptor.getFileDescriptor();
                long startOffset = assetFileDescriptor.getStartOffset();
                long length = assetFileDescriptor.getLength();
                initializeMediaPlayer();
                this.mMediaPlayer.setDataSource(fileDescriptor, startOffset, length);
            }
        } else if (str.startsWith("content://")) {
            Uri parse2 = Uri.parse(str);
            ThemedReactContext themedReactContext2 = this.mThemedReactContext;
            initializeMediaPlayer();
            this.mMediaPlayer.setDataSource(themedReactContext2, parse2);
        } else {
            setDataSource(str);
        }
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        createMap2.merge(this.mRequestHeaders);
        createMap.putString("uri", str);
        createMap.putString("type", str2);
        createMap.putMap(ReactVideoViewManager.PROP_SRC_HEADERS, createMap2);
        createMap.putBoolean(ReactVideoViewManager.PROP_SRC_IS_NETWORK, z);
        int i3 = this.mMainVer;
        if (i3 > 0) {
            createMap.putInt(ReactVideoViewManager.PROP_SRC_MAINVER, i3);
            int i4 = this.mPatchVer;
            if (i4 > 0) {
                createMap.putInt(ReactVideoViewManager.PROP_SRC_PATCHVER, i4);
            }
        }
        WritableMap createMap3 = Arguments.createMap();
        createMap3.putMap(ReactVideoViewManager.PROP_SRC, createMap);
        this.mEventEmitter.receiveEvent(getId(), Events.EVENT_LOAD_START.toString(), createMap3);
        this.isCompleted = false;
        try {
            this.mMediaPlayer.setOnPreparedListener(this);
            this.mMediaPlayer.prepareAsync();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public void setStereoPan(float f2) {
        this.mStereoPan = f2;
        setMutedModifier(this.mMuted);
    }

    public void setVolumeModifier(float f2) {
        this.mVolume = f2;
        setMutedModifier(this.mMuted);
    }
}
