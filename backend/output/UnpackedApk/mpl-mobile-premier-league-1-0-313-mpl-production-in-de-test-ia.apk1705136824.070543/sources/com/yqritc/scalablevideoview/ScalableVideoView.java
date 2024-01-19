package com.yqritc.scalablevideoview;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import java.io.FileDescriptor;
import java.io.IOException;

public class ScalableVideoView extends TextureView implements SurfaceTextureListener, OnVideoSizeChangedListener {
    public MediaPlayer mMediaPlayer;
    public ScalableType mScalableType;

    public ScalableVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void setDataSource(AssetFileDescriptor assetFileDescriptor) throws IOException {
        FileDescriptor fileDescriptor = assetFileDescriptor.getFileDescriptor();
        long startOffset = assetFileDescriptor.getStartOffset();
        long length = assetFileDescriptor.getLength();
        initializeMediaPlayer();
        this.mMediaPlayer.setDataSource(fileDescriptor, startOffset, length);
        assetFileDescriptor.close();
    }

    public int getCurrentPosition() {
        return this.mMediaPlayer.getCurrentPosition();
    }

    public int getDuration() {
        return this.mMediaPlayer.getDuration();
    }

    public int getVideoHeight() {
        return this.mMediaPlayer.getVideoHeight();
    }

    public int getVideoWidth() {
        return this.mMediaPlayer.getVideoWidth();
    }

    public final void initializeMediaPlayer() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            MediaPlayer mediaPlayer2 = new MediaPlayer();
            this.mMediaPlayer = mediaPlayer2;
            mediaPlayer2.setOnVideoSizeChangedListener(this);
            setSurfaceTextureListener(this);
            return;
        }
        mediaPlayer.reset();
    }

    public boolean isPlaying() {
        return this.mMediaPlayer.isPlaying();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mMediaPlayer != null) {
            if (isPlaying()) {
                this.mMediaPlayer.stop();
            }
            this.mMediaPlayer.reset();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Surface surface = new Surface(surfaceTexture);
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(surface);
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        scaleVideoSize(i, i2);
    }

    public void pause() {
        this.mMediaPlayer.pause();
    }

    public final void scaleVideoSize(int i, int i2) {
        if (i != 0 && i2 != 0) {
            Matrix scaleMatrix = new ScaleManager(new Size(getWidth(), getHeight()), new Size(i, i2)).getScaleMatrix(this.mScalableType);
            if (scaleMatrix != null) {
                setTransform(scaleMatrix);
            }
        }
    }

    public void setAssetData(String str) throws IOException {
        setDataSource(getContext().getAssets().openFd(str));
    }

    public void setLooping(boolean z) {
        this.mMediaPlayer.setLooping(z);
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.mMediaPlayer.setOnCompletionListener(onCompletionListener);
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.mMediaPlayer.setOnErrorListener(onErrorListener);
    }

    public void setOnInfoListener(OnInfoListener onInfoListener) {
        this.mMediaPlayer.setOnInfoListener(onInfoListener);
    }

    public void setRawData(int i) throws IOException {
        setDataSource(getResources().openRawResourceFd(i));
    }

    public void setScalableType(ScalableType scalableType) {
        this.mScalableType = scalableType;
        scaleVideoSize(getVideoWidth(), getVideoHeight());
    }

    public void start() {
        this.mMediaPlayer.start();
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mScalableType = ScalableType.NONE;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.scaleStyle, 0, 0);
            if (obtainStyledAttributes != null) {
                int i2 = R$styleable.scaleStyle_scalableType;
                ScalableType scalableType = ScalableType.NONE;
                int i3 = obtainStyledAttributes.getInt(i2, 0);
                obtainStyledAttributes.recycle();
                this.mScalableType = ScalableType.values()[i3];
            }
        }
    }

    public void setDataSource(String str) throws IOException {
        initializeMediaPlayer();
        this.mMediaPlayer.setDataSource(str);
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        initializeMediaPlayer();
        this.mMediaPlayer.setDataSource(fileDescriptor);
    }
}
