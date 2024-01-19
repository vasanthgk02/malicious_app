package io.antmedia.android.broadcaster.encoder;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.PixelCopy;
import android.view.PixelCopy.OnPixelCopyFinishedListener;
import android.view.Surface;
import android.view.SurfaceView;
import com.badlogic.gdx.graphics.GL20;
import io.antmedia.android.broadcaster.LiveVideoBroadcaster.EncoderListener;
import io.antmedia.android.broadcaster.encoder.gles.EglCore;
import io.antmedia.android.broadcaster.encoder.gles.FullFrameRect;
import io.antmedia.android.broadcaster.encoder.gles.GlUtil;
import io.antmedia.android.broadcaster.encoder.gles.Texture2dProgram;
import io.antmedia.android.broadcaster.encoder.gles.Texture2dProgram.ProgramType;
import io.antmedia.android.broadcaster.encoder.gles.WindowSurface;
import io.antmedia.android.broadcaster.network.IMediaMuxer;
import java.io.IOException;

public class VideoHandler extends Thread {
    public static final String TAG = VideoHandler.class.getSimpleName();
    public final EncoderListener encoderListener;
    public boolean endOfStream = false;
    public int frameRate;
    public int height;
    public SurfaceView inputSurfaceView;
    public EglCore mEglCore;
    public FullFrameRect mFullScreen;
    public float[] mIdentityMatrix;
    public VideoEncoderCore mVideoEncoder;
    public long recordStartTime;
    public boolean stopped = false;
    public HandlerThread videoEncoderInputThread;
    public VideoInputHandler videoInputHandler;
    public int width;
    public WindowSurface windowSurface;

    public class VideoInputHandler extends Handler {
        public static final int DRAW_SURFACE = 2;
        public static final int START = 1;
        public static final int STOP = 3;

        public VideoInputHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                VideoHandler.this.mEglCore = new EglCore(EGL14.eglGetCurrentContext(), 1);
                VideoHandler videoHandler = VideoHandler.this;
                videoHandler.windowSurface = new WindowSurface(videoHandler.mEglCore, VideoHandler.this.mVideoEncoder.getInputSurface(), false);
                VideoHandler.this.windowSurface.makeCurrent();
                VideoHandler.this.mFullScreen = new FullFrameRect(new Texture2dProgram(ProgramType.TEXTURE_2D));
            } else if (i == 2) {
                final Bitmap createBitmap = Bitmap.createBitmap(VideoHandler.this.width, VideoHandler.this.height, Config.ARGB_8888);
                if (VERSION.SDK_INT >= 24) {
                    Surface surface = VideoHandler.this.inputSurfaceView.getHolder().getSurface();
                    if (surface.isValid()) {
                        try {
                            PixelCopy.request(surface, createBitmap, new OnPixelCopyFinishedListener() {
                                public void onPixelCopyFinished(int i) {
                                    if (i == 0) {
                                        VideoHandler.TAG;
                                        if (!VideoHandler.this.stopped) {
                                            VideoHandler.this.drawBitmap(createBitmap);
                                            createBitmap.recycle();
                                            VideoInputHandler.this.requestDraw();
                                            return;
                                        }
                                        return;
                                    }
                                    VideoHandler.TAG;
                                }
                            }, this);
                        } catch (IllegalStateException unused) {
                            VideoHandler.TAG;
                            VideoHandler.this.encoderListener.inputNotValid();
                        }
                    } else {
                        VideoHandler.TAG;
                        VideoHandler.this.encoderListener.inputNotValid();
                    }
                } else {
                    VideoHandler.TAG;
                }
            } else if (i == 3) {
                removeMessages(2);
                VideoHandler.this.videoEncoderInputThread.quitSafely();
                VideoHandler.this.windowSurface.release();
                VideoHandler.this.mFullScreen.release(true);
                VideoHandler.this.mEglCore.release();
            }
        }

        public void requestDraw() {
            sendMessageDelayed(obtainMessage(2), (long) (1000 / VideoHandler.this.frameRate));
        }

        public void requestStart() {
            sendMessage(obtainMessage(1));
        }

        public void requestStop() {
            VideoHandler.this.stopped = true;
            sendMessage(obtainMessage(3));
        }
    }

    public VideoHandler(EncoderListener encoderListener2) {
        this.encoderListener = encoderListener2;
    }

    public void drawBitmap(Bitmap bitmap) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(GL20.GL_TEXTURE_2D, iArr[0]);
        int i = iArr[0];
        GLES20.glTexParameteri(GL20.GL_TEXTURE_2D, GL20.GL_TEXTURE_MIN_FILTER, GL20.GL_LINEAR);
        GLES20.glTexParameteri(GL20.GL_TEXTURE_2D, GL20.GL_TEXTURE_MAG_FILTER, GL20.GL_LINEAR);
        GlUtil.checkGlError("loadImageTexture");
        GLUtils.texImage2D(GL20.GL_TEXTURE_2D, 0, bitmap, 0);
        this.mFullScreen.drawFrame(i, this.mIdentityMatrix);
        this.windowSurface.setPresentationTime((System.currentTimeMillis() - this.recordStartTime) * 1000000);
        this.windowSurface.swapBuffers();
        GLES20.glDeleteTextures(1, iArr, 0);
    }

    public Surface getInputSurface() {
        VideoEncoderCore videoEncoderCore = this.mVideoEncoder;
        if (videoEncoderCore != null) {
            return videoEncoderCore.getInputSurface();
        }
        return null;
    }

    public long getRecordStartTime() {
        return this.recordStartTime;
    }

    public void prepareEncoder(int i, int i2, int i3, int i4, IMediaMuxer iMediaMuxer) throws IllegalStateException {
        try {
            this.frameRate = i4;
            this.width = i;
            this.height = i2;
            VideoEncoderCore videoEncoderCore = new VideoEncoderCore(i, i2, i3, i4, iMediaMuxer);
            this.mVideoEncoder = videoEncoderCore;
            float[] fArr = new float[16];
            this.mIdentityMatrix = fArr;
            Matrix.setIdentityM(fArr, 0);
        } catch (IOException e2) {
            this.mVideoEncoder = null;
            throw new RuntimeException(e2);
        }
    }

    public void run() {
        this.videoInputHandler.requestStart();
        this.videoInputHandler.requestDraw();
        do {
            this.mVideoEncoder.drainEncoder(this.endOfStream);
        } while (!this.endOfStream);
        this.videoInputHandler.requestStop();
        this.mVideoEncoder.release();
        this.mVideoEncoder.getInputSurface().release();
        this.mVideoEncoder.stopMuxer();
    }

    public void setInputSurfaceView(SurfaceView surfaceView) {
        this.inputSurfaceView = surfaceView;
        HandlerThread handlerThread = new HandlerThread("VideoEncoderInputThread");
        this.videoEncoderInputThread = handlerThread;
        handlerThread.start();
        this.videoInputHandler = new VideoInputHandler(this.videoEncoderInputThread.getLooper());
    }

    public void setRecordStartTime(long j) {
        this.recordStartTime = j;
    }

    public void stopEncoder() {
        this.endOfStream = true;
    }
}
