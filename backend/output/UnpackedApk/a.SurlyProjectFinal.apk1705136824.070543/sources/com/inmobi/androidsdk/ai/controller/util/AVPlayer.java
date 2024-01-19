package com.inmobi.androidsdk.ai.controller.util;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.VideoView;
import com.inmobi.androidsdk.ai.container.IMWebView;
import com.inmobi.androidsdk.ai.controller.JSController.Dimensions;
import com.inmobi.androidsdk.ai.controller.JSController.PlayerProperties;
import com.inmobi.androidsdk.impl.Constants;
import com.inmobi.androidsdk.impl.Constants.playerState;

public class AVPlayer extends VideoView implements OnCompletionListener, OnErrorListener, OnPreparedListener {
    private static int MEDIA_ERROR_CODE_NETWORK_ERROR = 2;
    private static int MEDIA_ERROR_CODE_UNKNOWN = -1;
    private static String MEDIA_TRACKING_EVENT_ENDED = "ended";
    private static String MEDIA_TRACKING_EVENT_PAUSE = "pause";
    private static String MEDIA_TRACKING_EVENT_PLAY = "play";
    private static final int MSG_PRGORESS_MONITOR = 1001;
    private static String transientText = "Loading. Please Wait..";
    /* access modifiers changed from: private */
    public AudioManager aManager = ((AudioManager) getContext().getSystemService("audio"));
    private ViewGroup backGround;
    private String contentURL;
    /* access modifiers changed from: private */
    public int curVolume;
    /* access modifiers changed from: private */
    public int devVolume;
    private boolean isComplete = false;
    private boolean isMuted;
    private boolean isPrepared = false;
    private AVPlayerListener listener;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case AVPlayer.MSG_PRGORESS_MONITOR /*1001*/:
                    if (AVPlayer.this.postEvent()) {
                        synchronized (this) {
                            int volume = AVPlayer.this.aManager.getStreamVolume(3);
                            if (volume != AVPlayer.this.curVolume) {
                                AVPlayer.this.curVolume = volume;
                                AVPlayer.this.devVolume = AVPlayer.this.curVolume;
                                AVPlayer.this.fireMediaVolumeChangeEvent();
                            }
                        }
                        int currPosition = Math.round((float) (AVPlayer.this.getCurrentPosition() / 1000));
                        int duration = Math.round((float) (AVPlayer.this.getDuration() / 1000));
                        if (AVPlayer.this.prevPosition != currPosition) {
                            AVPlayer.this.fireMediaTimeUpdateEvent(currPosition, duration);
                            AVPlayer.this.prevPosition = currPosition;
                        }
                        AVPlayer.this.mHandler.sendEmptyMessageDelayed(AVPlayer.MSG_PRGORESS_MONITOR, 1000);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private IMWebView mIMWebView;
    private MediaPlayer mPlayer;
    private playerState mState;
    private Dimensions playDimensions;
    private PlayerProperties playProperties;
    /* access modifiers changed from: private */
    public int prevPosition = -1;
    private RelativeLayout transientLayout;

    public AVPlayer(Context context, IMWebView imWebView) {
        super(context);
        this.mIMWebView = imWebView;
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.curVolume = this.aManager.getStreamVolume(3);
        this.devVolume = this.curVolume;
        getHolder().addCallback(new Callback() {
            public void surfaceDestroyed(SurfaceHolder holder) {
                AVPlayer.this.post(new Runnable() {
                    public void run() {
                        AVPlayer.this.releasePlayer(false);
                    }
                });
            }

            public void surfaceCreated(SurfaceHolder holder) {
            }

            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            }
        });
    }

    public void setPlayData(PlayerProperties properties, String url) {
        this.playProperties = properties;
        this.contentURL = url;
    }

    /* access modifiers changed from: 0000 */
    public void displayControl() {
        if (this.playProperties.showControl()) {
            MediaController ctrl = new MediaController(getContext());
            setMediaController(ctrl);
            ctrl.setAnchorView(this);
        }
    }

    /* access modifiers changed from: 0000 */
    public void loadContent() {
        this.contentURL = this.contentURL.trim();
        this.contentURL = Utils.convert(this.contentURL);
        this.mState = playerState.INIT;
        addTransientMessage();
        setVideoPath(this.contentURL);
        displayControl();
        setOnCompletionListener(this);
        setOnErrorListener(this);
        setOnPreparedListener(this);
    }

    /* access modifiers changed from: 0000 */
    public void startContent() {
        if (this.mState == playerState.SHOWING) {
            this.mState = this.isComplete ? playerState.COMPLETED : playerState.PAUSED;
        } else if (this.playProperties.isAutoPlay() && this.mState == playerState.INIT) {
            start();
        }
    }

    public void play() {
        if (this.playProperties.doMute()) {
            mute();
        }
        loadContent();
    }

    public void setListener(AVPlayerListener listener2) {
        this.listener = listener2;
    }

    public void onCompletion(MediaPlayer mp) {
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "AVPlayer-> onCompletion");
        }
        this.mState = playerState.COMPLETED;
        this.isComplete = true;
        fireMediaTrackingEvent(MEDIA_TRACKING_EVENT_ENDED);
        stopProgressMonitor();
        if (this.playProperties.doLoop()) {
            synchronized (this) {
                if (!isPaused()) {
                    start();
                }
            }
        } else if (this.playProperties.exitOnComplete()) {
            releasePlayer(false);
        }
    }

    public boolean onError(MediaPlayer mp, int what, int extra) {
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "AVPlayer-> Player error : " + what);
        }
        clearTransientMessage();
        releasePlayer(false);
        if (this.listener != null) {
            this.listener.onError(this);
        }
        int code = MEDIA_ERROR_CODE_UNKNOWN;
        if (what == 100) {
            code = MEDIA_ERROR_CODE_NETWORK_ERROR;
        }
        fireMediaErrorEvent(code);
        return false;
    }

    public void onPrepared(MediaPlayer mp) {
        this.mPlayer = mp;
        if (this.isMuted) {
            try {
                this.mPlayer.setVolume(0.0f, 0.0f);
            } catch (Exception e) {
            }
        }
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "AVPlayer-> onPrepared");
        }
        clearTransientMessage();
        if (this.listener != null) {
            this.listener.onPrepared(this);
        }
        this.isPrepared = true;
        startContent();
    }

    /* access modifiers changed from: 0000 */
    public void removeView() {
        try {
            ViewGroup parent = (ViewGroup) getParent();
            if (parent != null) {
                parent.removeView(this);
            }
        } catch (Exception e) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
        fireMediaCloseEvent(r3, r0);
        r2.prevPosition = -1;
        stopProgressMonitor();
        unMute();
        resetVolume();
        stopPlayback();
        removeView();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002b, code lost:
        if (r2.listener == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
        r2.listener.onComplete(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0036, code lost:
        r0 = java.lang.Math.round((float) (getCurrentPosition() / 1000));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000b, code lost:
        r2.mState = com.inmobi.androidsdk.impl.Constants.playerState.RELEASED;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        if (r2.prevPosition == -1) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        r0 = r2.prevPosition;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void releasePlayer(boolean r3) {
        /*
            r2 = this;
            r1 = -1
            monitor-enter(r2)
            boolean r0 = r2.isReleased()     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x000a
            monitor-exit(r2)     // Catch:{ all -> 0x0033 }
        L_0x0009:
            return
        L_0x000a:
            monitor-exit(r2)     // Catch:{ all -> 0x0033 }
            com.inmobi.androidsdk.impl.Constants$playerState r0 = com.inmobi.androidsdk.impl.Constants.playerState.RELEASED
            r2.mState = r0
            int r0 = r2.prevPosition
            if (r0 == r1) goto L_0x0036
            int r0 = r2.prevPosition
        L_0x0015:
            r2.fireMediaCloseEvent(r3, r0)
            r2.prevPosition = r1
            r2.stopProgressMonitor()
            r2.unMute()
            r2.resetVolume()
            r2.stopPlayback()
            r2.removeView()
            com.inmobi.androidsdk.ai.controller.util.AVPlayerListener r0 = r2.listener
            if (r0 == 0) goto L_0x0009
            com.inmobi.androidsdk.ai.controller.util.AVPlayerListener r0 = r2.listener
            r0.onComplete(r2)
            goto L_0x0009
        L_0x0033:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0033 }
            throw r0
        L_0x0036:
            int r0 = r2.getCurrentPosition()
            int r0 = r0 / 1000
            float r0 = (float) r0
            int r0 = java.lang.Math.round(r0)
            goto L_0x0015
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.androidsdk.ai.controller.util.AVPlayer.releasePlayer(boolean):void");
    }

    /* access modifiers changed from: 0000 */
    public void addTransientMessage() {
        this.transientLayout = new RelativeLayout(getContext());
        this.transientLayout.setLayoutParams(getLayoutParams());
        this.transientLayout.setBackgroundColor(-16777216);
        TextView transientView = new TextView(getContext());
        transientView.setText(transientText);
        transientView.setTextColor(-1);
        LayoutParams msgparams = new LayoutParams(-2, -2);
        msgparams.addRule(13);
        this.transientLayout.addView(transientView, msgparams);
        ((ViewGroup) getParent()).addView(this.transientLayout);
    }

    /* access modifiers changed from: 0000 */
    public void clearTransientMessage() {
        if (this.transientLayout != null) {
            ((ViewGroup) getParent()).removeView(this.transientLayout);
        }
    }

    public synchronized void start() {
        if (this.mState == null || this.mState != playerState.PLAYING) {
            super.start();
            this.mState = playerState.PLAYING;
            this.isComplete = false;
            startProgressMonitor();
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "AVPlayer -> start playing");
            }
            if (this.isPrepared) {
                fireMediaTrackingEvent(MEDIA_TRACKING_EVENT_PLAY);
            }
        }
    }

    public synchronized void pause() {
        if (this.mState == null || this.mState != playerState.PAUSED) {
            super.pause();
            this.mState = playerState.PAUSED;
            stopProgressMonitor();
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "AVPlayer -> pause");
            }
            fireMediaTrackingEvent(MEDIA_TRACKING_EVENT_PAUSE);
        }
    }

    private void fireMediaTrackingEvent(String eventType) {
        if (this.mIMWebView != null) {
            this.mIMWebView.injectJavaScript("window.mraidview.fireMediaTrackingEvent('" + eventType + "','" + this.playProperties.id + "');");
        }
    }

    private void fireMediaErrorEvent(int code) {
        if (this.mIMWebView != null) {
            this.mIMWebView.injectJavaScript("window.mraidview.fireMediaErrorEvent('" + this.playProperties.id + "'," + code + ");");
        }
    }

    /* access modifiers changed from: private */
    public void fireMediaTimeUpdateEvent(int currentTime, int duration) {
        if (this.mIMWebView != null) {
            this.mIMWebView.injectJavaScript("window.mraidview.fireMediaTimeUpdateEvent('" + this.playProperties.id + "'," + currentTime + "," + duration + ");");
        }
    }

    private void fireMediaCloseEvent(boolean viaUserInteraction, int currentTime) {
        if (this.mIMWebView != null) {
            this.mIMWebView.injectJavaScript("window.mraidview.fireMediaCloseEvent('" + this.playProperties.id + "'," + viaUserInteraction + "," + currentTime + ");");
        }
    }

    /* access modifiers changed from: private */
    public void fireMediaVolumeChangeEvent() {
        if (this.mIMWebView != null) {
            this.mIMWebView.injectJavaScript("window.mraidview.fireMediaVolumeChangeEvent('" + this.playProperties.id + "'," + getVolume() + "," + isMediaMuted() + ");");
        }
    }

    private void startProgressMonitor() {
        this.mHandler.sendEmptyMessage(MSG_PRGORESS_MONITOR);
    }

    private void stopProgressMonitor() {
        this.mHandler.removeMessages(MSG_PRGORESS_MONITOR);
    }

    public String getPropertyID() {
        return this.playProperties.id;
    }

    public boolean isInlineVideo() {
        return !this.playProperties.isFullScreen();
    }

    private boolean isPaused() {
        return this.mState == playerState.PAUSED || this.mState == playerState.HIDDEN;
    }

    private boolean isReleased() {
        return this.mState == playerState.RELEASED;
    }

    /* access modifiers changed from: private */
    public boolean postEvent() {
        return this.mState == playerState.PLAYING;
    }

    public String getMediaURL() {
        return this.contentURL;
    }

    public playerState getState() {
        return this.mState;
    }

    private void resetVolume() {
        this.aManager.setStreamVolume(3, this.devVolume, 4);
    }

    public void mute() {
        if (this.mPlayer != null && !this.isMuted) {
            this.isMuted = true;
            try {
                this.mPlayer.setVolume(0.0f, 0.0f);
            } catch (Exception e) {
            }
            fireMediaVolumeChangeEvent();
        }
    }

    public void unMute() {
        if (this.mPlayer != null && this.isMuted) {
            this.isMuted = false;
            try {
                this.mPlayer.setVolume(0.0f, 1.0f);
            } catch (Exception e) {
            }
            fireMediaVolumeChangeEvent();
        }
    }

    public boolean isMediaMuted() {
        return this.curVolume == 0 || this.isMuted;
    }

    public synchronized void setVolume(int volume) {
        int vol = getVolumeToSet(volume);
        if (this.curVolume != vol) {
            this.curVolume = vol;
            this.aManager.setStreamVolume(3, this.curVolume, 4);
            fireMediaVolumeChangeEvent();
        }
    }

    public synchronized int getVolume() {
        try {
            if (!isPlaying()) {
                this.curVolume = this.aManager.getStreamVolume(3);
            }
        }
        return (this.curVolume * 100) / this.aManager.getStreamMaxVolume(3);
    }

    private int getVolumeToSet(int volume) {
        return (this.aManager.getStreamMaxVolume(3) * volume) / 100;
    }

    public void hide() {
        try {
            if (isPlaying()) {
                pause();
            }
            this.backGround.setVisibility(8);
            this.mState = playerState.HIDDEN;
        } catch (Exception e) {
        }
    }

    public void show() {
        this.mState = playerState.SHOWING;
        this.backGround.setVisibility(0);
        setVisibility(0);
    }

    public void seekPlayer(int seekPos) {
        if (seekPos <= getDuration()) {
            seekTo(seekPos);
        }
    }

    public void setBackGroundLayout(ViewGroup lyt) {
        this.backGround = lyt;
    }

    public ViewGroup getBackGroundLayout() {
        return this.backGround;
    }

    public PlayerProperties getProperties() {
        return this.playProperties;
    }

    public Dimensions getPlayDimensions() {
        return this.playDimensions;
    }

    public void setPlayDimensions(Dimensions d) {
        this.playDimensions = d;
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int visibility) {
        try {
            super.onWindowVisibilityChanged(visibility);
        } catch (Exception e) {
        }
    }
}
