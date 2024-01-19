package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View.MeasureSpec;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.internal.VideoControlView.MediaPlayerControl;

public class VideoView extends SurfaceView implements MediaPlayerControl {
    public String TAG;
    public GestureDetector gestureDetector;
    public int mAudioSession;
    public OnBufferingUpdateListener mBufferingUpdateListener;
    public OnCompletionListener mCompletionListener;
    public int mCurrentBufferPercentage;
    public int mCurrentState;
    public OnErrorListener mErrorListener;
    public OnInfoListener mInfoListener;
    public boolean mLooping;
    public VideoControlView mMediaController;
    public MediaPlayer mMediaPlayer;
    public OnCompletionListener mOnCompletionListener;
    public OnErrorListener mOnErrorListener;
    public OnInfoListener mOnInfoListener;
    public OnPreparedListener mOnPreparedListener;
    public OnPreparedListener mPreparedListener;
    public Callback mSHCallback;
    public int mSeekWhenPrepared;
    public OnVideoSizeChangedListener mSizeChangedListener;
    public int mSurfaceHeight;
    public SurfaceHolder mSurfaceHolder;
    public int mSurfaceWidth;
    public int mTargetState;
    public Uri mUri;
    public int mVideoHeight;
    public int mVideoWidth;

    public VideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public int getBufferPercentage() {
        if (this.mMediaPlayer != null) {
            return this.mCurrentBufferPercentage;
        }
        return 0;
    }

    public int getCurrentPosition() {
        if (isInPlaybackState()) {
            return this.mMediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    public int getDuration() {
        if (isInPlaybackState()) {
            return this.mMediaPlayer.getDuration();
        }
        return -1;
    }

    public final boolean isInPlaybackState() {
        if (this.mMediaPlayer != null) {
            int i = this.mCurrentState;
            if (!(i == -1 || i == 0 || i == 1)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPlaying() {
        return isInPlaybackState() && this.mMediaPlayer.isPlaying();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = (i == 4 || i == 24 || i == 25 || i == 82 || i == 5 || i == 6) ? false : true;
        if (isInPlaybackState() && z && this.mMediaController != null) {
            if (i == 79 || i == 85) {
                if (this.mMediaPlayer.isPlaying()) {
                    pause();
                    this.mMediaController.show();
                } else {
                    start();
                    this.mMediaController.hide();
                }
                return true;
            } else if (i == 126) {
                if (!this.mMediaPlayer.isPlaying()) {
                    start();
                    this.mMediaController.hide();
                }
                return true;
            } else if (i == 86 || i == 127) {
                if (this.mMediaPlayer.isPlaying()) {
                    pause();
                    this.mMediaController.show();
                }
                return true;
            } else {
                toggleMediaControlsVisiblity();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void onMeasure(int i, int i2) {
        int i3;
        int defaultSize = SurfaceView.getDefaultSize(this.mVideoWidth, i);
        int defaultSize2 = SurfaceView.getDefaultSize(this.mVideoHeight, i2);
        if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            int mode2 = MeasureSpec.getMode(i2);
            int size2 = MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i4 = this.mVideoWidth;
                int i5 = i4 * size2;
                int i6 = this.mVideoHeight;
                if (i5 < size * i6) {
                    defaultSize = (i4 * size2) / i6;
                    defaultSize2 = size2;
                } else {
                    if (i4 * size2 > size * i6) {
                        i3 = (i6 * size) / i4;
                    }
                    defaultSize = size;
                    defaultSize2 = size2;
                }
            } else if (mode == 1073741824) {
                int i7 = (this.mVideoHeight * size) / this.mVideoWidth;
                if (mode2 != Integer.MIN_VALUE || i7 <= size2) {
                    i3 = i7;
                }
                defaultSize = size;
                defaultSize2 = size2;
            } else if (mode2 == 1073741824) {
                int i8 = (this.mVideoWidth * size2) / this.mVideoHeight;
                if (mode != Integer.MIN_VALUE || i8 <= size) {
                    defaultSize = i8;
                    defaultSize2 = size2;
                }
                defaultSize = size;
                defaultSize2 = size2;
            } else {
                int i9 = this.mVideoWidth;
                int i10 = this.mVideoHeight;
                if (mode2 != Integer.MIN_VALUE || i10 <= size2) {
                    defaultSize2 = i10;
                } else {
                    i9 = (i9 * size2) / i10;
                    defaultSize2 = size2;
                }
                if (mode != Integer.MIN_VALUE || i9 <= size) {
                    defaultSize = i9;
                } else {
                    i3 = (this.mVideoHeight * size) / this.mVideoWidth;
                }
            }
            defaultSize = size;
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.gestureDetector.onTouchEvent(motionEvent) || super.onTouchEvent(motionEvent);
    }

    public final void openVideo() {
        if (this.mUri != null && this.mSurfaceHolder != null) {
            release(false);
            try {
                MediaPlayer mediaPlayer = new MediaPlayer();
                this.mMediaPlayer = mediaPlayer;
                if (this.mAudioSession != 0) {
                    mediaPlayer.setAudioSessionId(this.mAudioSession);
                } else {
                    this.mAudioSession = mediaPlayer.getAudioSessionId();
                }
                this.mMediaPlayer.setOnPreparedListener(this.mPreparedListener);
                this.mMediaPlayer.setOnVideoSizeChangedListener(this.mSizeChangedListener);
                this.mMediaPlayer.setOnCompletionListener(this.mCompletionListener);
                this.mMediaPlayer.setOnErrorListener(this.mErrorListener);
                this.mMediaPlayer.setOnInfoListener(this.mInfoListener);
                this.mMediaPlayer.setOnBufferingUpdateListener(this.mBufferingUpdateListener);
                this.mCurrentBufferPercentage = 0;
                this.mMediaPlayer.setLooping(this.mLooping);
                this.mMediaPlayer.setDataSource(getContext(), this.mUri);
                this.mMediaPlayer.setDisplay(this.mSurfaceHolder);
                this.mMediaPlayer.setAudioStreamType(3);
                this.mMediaPlayer.setScreenOnWhilePlaying(true);
                this.mMediaPlayer.prepareAsync();
                this.mCurrentState = 1;
                if (this.mMediaPlayer != null) {
                    VideoControlView videoControlView = this.mMediaController;
                    if (videoControlView != null) {
                        videoControlView.setMediaPlayer(this);
                        this.mMediaController.setEnabled(isInPlaybackState());
                    }
                }
            } catch (Exception unused) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unable to open content: ");
                outline73.append(this.mUri);
                outline73.toString();
                this.mCurrentState = -1;
                this.mTargetState = -1;
                this.mErrorListener.onError(this.mMediaPlayer, 1, 0);
            }
        }
    }

    public void pause() {
        if (isInPlaybackState() && this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.pause();
            this.mCurrentState = 4;
        }
        this.mTargetState = 4;
    }

    public final void release(boolean z) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            this.mCurrentState = 0;
            if (z) {
                this.mTargetState = 0;
            }
        }
    }

    public void seekTo(int i) {
        if (isInPlaybackState()) {
            this.mMediaPlayer.seekTo(i);
            this.mSeekWhenPrepared = 0;
            return;
        }
        this.mSeekWhenPrepared = i;
    }

    public void setMediaController(VideoControlView videoControlView) {
        VideoControlView videoControlView2 = this.mMediaController;
        if (videoControlView2 != null) {
            videoControlView2.hide();
        }
        this.mMediaController = videoControlView;
        if (this.mMediaPlayer != null && videoControlView != null) {
            videoControlView.setMediaPlayer(this);
            this.mMediaController.setEnabled(isInPlaybackState());
        }
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    public void setOnInfoListener(OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    public void start() {
        if (isInPlaybackState()) {
            this.mMediaPlayer.start();
            this.mCurrentState = 3;
        }
        this.mTargetState = 3;
    }

    public final void toggleMediaControlsVisiblity() {
        if (this.mMediaController.getVisibility() == 0) {
            this.mMediaController.hide();
        } else {
            this.mMediaController.show();
        }
    }

    public VideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = "VideoView";
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mSurfaceHolder = null;
        this.mMediaPlayer = null;
        this.mSizeChangedListener = new OnVideoSizeChangedListener() {
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                VideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                VideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                VideoView videoView = VideoView.this;
                if (videoView.mVideoWidth != 0 && videoView.mVideoHeight != 0) {
                    SurfaceHolder holder = videoView.getHolder();
                    VideoView videoView2 = VideoView.this;
                    holder.setFixedSize(videoView2.mVideoWidth, videoView2.mVideoHeight);
                    VideoView.this.requestLayout();
                }
            }
        };
        this.mPreparedListener = new OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoView videoView = VideoView.this;
                videoView.mCurrentState = 2;
                OnPreparedListener onPreparedListener = videoView.mOnPreparedListener;
                if (onPreparedListener != null) {
                    onPreparedListener.onPrepared(videoView.mMediaPlayer);
                }
                VideoControlView videoControlView = VideoView.this.mMediaController;
                if (videoControlView != null) {
                    videoControlView.setEnabled(true);
                }
                VideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                VideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                VideoView videoView2 = VideoView.this;
                int i = videoView2.mSeekWhenPrepared;
                if (i != 0) {
                    videoView2.seekTo(i);
                }
                VideoView videoView3 = VideoView.this;
                if (videoView3.mVideoWidth == 0 || videoView3.mVideoHeight == 0) {
                    VideoView videoView4 = VideoView.this;
                    if (videoView4.mTargetState == 3) {
                        videoView4.start();
                        return;
                    }
                    return;
                }
                SurfaceHolder holder = videoView3.getHolder();
                VideoView videoView5 = VideoView.this;
                holder.setFixedSize(videoView5.mVideoWidth, videoView5.mVideoHeight);
                VideoView videoView6 = VideoView.this;
                if (videoView6.mSurfaceWidth != videoView6.mVideoWidth || videoView6.mSurfaceHeight != videoView6.mVideoHeight) {
                    return;
                }
                if (videoView6.mTargetState == 3) {
                    videoView6.start();
                    VideoControlView videoControlView2 = VideoView.this.mMediaController;
                    if (videoControlView2 != null) {
                        videoControlView2.show();
                    }
                } else if (videoView6.isPlaying()) {
                } else {
                    if (i != 0 || VideoView.this.getCurrentPosition() > 0) {
                        VideoControlView videoControlView3 = VideoView.this.mMediaController;
                        if (videoControlView3 != null) {
                            videoControlView3.show();
                        }
                    }
                }
            }
        };
        this.mCompletionListener = new OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoView videoView = VideoView.this;
                videoView.mCurrentState = 5;
                videoView.mTargetState = 5;
                OnCompletionListener onCompletionListener = videoView.mOnCompletionListener;
                if (onCompletionListener != null) {
                    onCompletionListener.onCompletion(videoView.mMediaPlayer);
                }
            }
        };
        this.mInfoListener = new OnInfoListener() {
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                OnInfoListener onInfoListener = VideoView.this.mOnInfoListener;
                if (onInfoListener != null) {
                    onInfoListener.onInfo(mediaPlayer, i, i2);
                }
                return true;
            }
        };
        this.mErrorListener = new OnErrorListener() {
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                VideoView videoView = VideoView.this;
                String str = videoView.TAG;
                videoView.mCurrentState = -1;
                videoView.mTargetState = -1;
                VideoControlView videoControlView = videoView.mMediaController;
                if (videoControlView != null) {
                    videoControlView.hide();
                }
                VideoView videoView2 = VideoView.this;
                OnErrorListener onErrorListener = videoView2.mOnErrorListener;
                if (onErrorListener != null) {
                    onErrorListener.onError(videoView2.mMediaPlayer, i, i2);
                }
                return true;
            }
        };
        this.mBufferingUpdateListener = new OnBufferingUpdateListener() {
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                VideoView.this.mCurrentBufferPercentage = i;
            }
        };
        this.gestureDetector = new GestureDetector(getContext(), new SimpleOnGestureListener() {
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (VideoView.this.isInPlaybackState()) {
                    VideoView videoView = VideoView.this;
                    if (videoView.mMediaController != null) {
                        videoView.toggleMediaControlsVisiblity();
                    }
                }
                return false;
            }
        });
        this.mSHCallback = new Callback() {
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                VideoView videoView = VideoView.this;
                videoView.mSurfaceWidth = i2;
                videoView.mSurfaceHeight = i3;
                boolean z = true;
                boolean z2 = videoView.mTargetState == 3;
                VideoView videoView2 = VideoView.this;
                if (!(videoView2.mVideoWidth == i2 && videoView2.mVideoHeight == i3)) {
                    z = false;
                }
                VideoView videoView3 = VideoView.this;
                if (videoView3.mMediaPlayer != null && z2 && z) {
                    int i4 = videoView3.mSeekWhenPrepared;
                    if (i4 != 0) {
                        videoView3.seekTo(i4);
                    }
                    VideoView.this.start();
                    VideoControlView videoControlView = VideoView.this.mMediaController;
                    if (videoControlView != null) {
                        videoControlView.show();
                    }
                }
            }

            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoView videoView = VideoView.this;
                videoView.mSurfaceHolder = surfaceHolder;
                videoView.openVideo();
            }

            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoView videoView = VideoView.this;
                videoView.mSurfaceHolder = null;
                VideoControlView videoControlView = videoView.mMediaController;
                if (videoControlView != null) {
                    videoControlView.hide();
                }
                VideoView.this.release(true);
            }
        };
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        getHolder().addCallback(this.mSHCallback);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setClickable(true);
        requestFocus();
        this.mCurrentState = 0;
        this.mTargetState = 0;
    }
}
