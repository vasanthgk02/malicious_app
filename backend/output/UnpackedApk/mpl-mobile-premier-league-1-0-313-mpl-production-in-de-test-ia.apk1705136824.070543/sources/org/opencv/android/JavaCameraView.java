package org.opencv.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CameraManager;
import android.util.AttributeSet;
import java.util.concurrent.Semaphore;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewListener;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewListener2;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewListenerAdapter;
import org.opencv.android.CameraBridgeViewBase.ListItemAccessor;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class JavaCameraView extends CameraBridgeViewBase implements PreviewCallback {
    public byte[] mBuffer;
    public Camera mCamera;
    public CameraDevice mCameraDevice;
    public JavaCameraFrame[] mCameraFrame;
    public boolean mCameraFrameReady = false;
    public Semaphore mCameraOpenCloseLock = new Semaphore(1);
    public int mChainIdx = 0;
    public Mat[] mFrameChain;
    public final StateCallback mStateCallback = new StateCallback() {
        public void onDisconnected(CameraDevice cameraDevice) {
            JavaCameraView.this.mCameraOpenCloseLock.release();
            cameraDevice.close();
            JavaCameraView.this.mCameraDevice = null;
        }

        public void onError(CameraDevice cameraDevice, int i) {
            JavaCameraView.this.mCameraOpenCloseLock.release();
            cameraDevice.close();
            JavaCameraView.this.mCameraDevice = null;
        }

        public void onOpened(CameraDevice cameraDevice) {
            JavaCameraView.this.mCameraOpenCloseLock.release();
            JavaCameraView javaCameraView = JavaCameraView.this;
            javaCameraView.mCameraDevice = cameraDevice;
            if (javaCameraView == null) {
                throw null;
            }
        }
    };
    public boolean mStopThread;
    public SurfaceTexture mSurfaceTexture;
    public Thread mThread;

    public class CameraWorker implements Runnable {
        public CameraWorker(AnonymousClass1 r2) {
        }

        public void run() {
            boolean z;
            Mat mat;
            boolean z2;
            do {
                synchronized (JavaCameraView.this) {
                    while (!JavaCameraView.this.mCameraFrameReady && !JavaCameraView.this.mStopThread) {
                        try {
                            JavaCameraView.this.wait();
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (JavaCameraView.this.mCameraFrameReady) {
                        JavaCameraView.this.mChainIdx = 1 - JavaCameraView.this.mChainIdx;
                        JavaCameraView.this.mCameraFrameReady = false;
                        z = true;
                    } else {
                        z = false;
                    }
                }
                JavaCameraView javaCameraView = JavaCameraView.this;
                if (!javaCameraView.mStopThread && z && !javaCameraView.mFrameChain[1 - javaCameraView.mChainIdx].empty()) {
                    JavaCameraView javaCameraView2 = JavaCameraView.this;
                    JavaCameraFrame javaCameraFrame = javaCameraView2.mCameraFrame[1 - javaCameraView2.mChainIdx];
                    CvCameraViewListener2 cvCameraViewListener2 = javaCameraView2.mListener;
                    if (cvCameraViewListener2 != null) {
                        CvCameraViewListenerAdapter cvCameraViewListenerAdapter = (CvCameraViewListenerAdapter) cvCameraViewListener2;
                        int i = cvCameraViewListenerAdapter.mPreviewFormat;
                        if (i == 1) {
                            CvCameraViewListener cvCameraViewListener = cvCameraViewListenerAdapter.mOldStyleListener;
                            Imgproc.cvtColor(javaCameraFrame.mYuvFrameData, javaCameraFrame.mRgba, 96, 4);
                            mat = cvCameraViewListener.onCameraFrame(javaCameraFrame.mRgba);
                        } else if (i != 2) {
                            mat = null;
                        } else {
                            CvCameraViewListener cvCameraViewListener3 = cvCameraViewListenerAdapter.mOldStyleListener;
                            Mat mat2 = javaCameraFrame.mYuvFrameData;
                            int i2 = javaCameraFrame.mHeight;
                            int i3 = javaCameraFrame.mWidth;
                            if (mat2 != null) {
                                mat = cvCameraViewListener3.onCameraFrame(new Mat(Mat.n_submat_rr(mat2.nativeObj, 0, i2, 0, i3)));
                            } else {
                                throw null;
                            }
                        }
                    } else {
                        Imgproc.cvtColor(javaCameraFrame.mYuvFrameData, javaCameraFrame.mRgba, 96, 4);
                        mat = javaCameraFrame.mRgba;
                    }
                    if (mat != null) {
                        try {
                            Bitmap bitmap = javaCameraView2.mCacheBitmap;
                            if (bitmap != null) {
                                Utils.nMatToBitmap2(mat.nativeObj, bitmap, false);
                            } else {
                                throw new IllegalArgumentException("bmp == null");
                            }
                        } catch (Exception e3) {
                            "Mat type: " + mat;
                            javaCameraView2.mCacheBitmap.getWidth();
                            javaCameraView2.mCacheBitmap.getHeight();
                            e3.getMessage();
                            z2 = false;
                        }
                    }
                    z2 = true;
                    if (z2 && javaCameraView2.mCacheBitmap != null) {
                        Canvas lockCanvas = javaCameraView2.getHolder().lockCanvas();
                        if (lockCanvas != null) {
                            lockCanvas.drawColor(0, Mode.CLEAR);
                            if (javaCameraView2.mScale != 0.0f) {
                                lockCanvas.drawBitmap(javaCameraView2.mCacheBitmap, new Rect(0, 0, javaCameraView2.mCacheBitmap.getWidth(), javaCameraView2.mCacheBitmap.getHeight()), new Rect((int) ((((float) lockCanvas.getWidth()) - (javaCameraView2.mScale * ((float) javaCameraView2.mCacheBitmap.getWidth()))) / 2.0f), (int) ((((float) lockCanvas.getHeight()) - (javaCameraView2.mScale * ((float) javaCameraView2.mCacheBitmap.getHeight()))) / 2.0f), (int) ((javaCameraView2.mScale * ((float) javaCameraView2.mCacheBitmap.getWidth())) + ((((float) lockCanvas.getWidth()) - (javaCameraView2.mScale * ((float) javaCameraView2.mCacheBitmap.getWidth()))) / 2.0f)), (int) ((javaCameraView2.mScale * ((float) javaCameraView2.mCacheBitmap.getHeight())) + ((((float) lockCanvas.getHeight()) - (javaCameraView2.mScale * ((float) javaCameraView2.mCacheBitmap.getHeight()))) / 2.0f))), null);
                            } else {
                                lockCanvas.drawBitmap(javaCameraView2.mCacheBitmap, new Rect(0, 0, javaCameraView2.mCacheBitmap.getWidth(), javaCameraView2.mCacheBitmap.getHeight()), new Rect((lockCanvas.getWidth() - javaCameraView2.mCacheBitmap.getWidth()) / 2, (lockCanvas.getHeight() - javaCameraView2.mCacheBitmap.getHeight()) / 2, javaCameraView2.mCacheBitmap.getWidth() + ((lockCanvas.getWidth() - javaCameraView2.mCacheBitmap.getWidth()) / 2), javaCameraView2.mCacheBitmap.getHeight() + ((lockCanvas.getHeight() - javaCameraView2.mCacheBitmap.getHeight()) / 2)), null);
                            }
                            FpsMeter fpsMeter = javaCameraView2.mFpsMeter;
                            if (fpsMeter != null) {
                                if (!fpsMeter.mIsInitialized) {
                                    fpsMeter.mFramesCouner = 0;
                                    fpsMeter.mFrequency = Core.getTickFrequency_0();
                                    fpsMeter.mprevFrameTime = Core.getTickCount_0();
                                    fpsMeter.mStrfps = "";
                                    Paint paint = new Paint();
                                    fpsMeter.mPaint = paint;
                                    paint.setColor(-16776961);
                                    fpsMeter.mPaint.setTextSize(20.0f);
                                    fpsMeter.mIsInitialized = true;
                                } else {
                                    int i4 = fpsMeter.mFramesCouner + 1;
                                    fpsMeter.mFramesCouner = i4;
                                    if (i4 % 20 == 0) {
                                        long tickCount_0 = Core.getTickCount_0();
                                        double d2 = (fpsMeter.mFrequency * 20.0d) / ((double) (tickCount_0 - fpsMeter.mprevFrameTime));
                                        fpsMeter.mprevFrameTime = tickCount_0;
                                        if (fpsMeter.mWidth == 0 || fpsMeter.mHeight == 0) {
                                            fpsMeter.mStrfps = FpsMeter.FPS_FORMAT.format(d2) + " FPS";
                                        } else {
                                            fpsMeter.mStrfps = FpsMeter.FPS_FORMAT.format(d2) + " FPS@" + Integer.valueOf(fpsMeter.mWidth) + "x" + Integer.valueOf(fpsMeter.mHeight);
                                        }
                                    }
                                }
                                FpsMeter fpsMeter2 = javaCameraView2.mFpsMeter;
                                lockCanvas.drawText(fpsMeter2.mStrfps, 20.0f, 30.0f, fpsMeter2.mPaint);
                            }
                            javaCameraView2.getHolder().unlockCanvasAndPost(lockCanvas);
                        }
                    }
                }
            } while (!JavaCameraView.this.mStopThread);
        }
    }

    public class JavaCameraFrame {
        public int mHeight;
        public Mat mRgba = new Mat();
        public int mWidth;
        public Mat mYuvFrameData;

        public JavaCameraFrame(Mat mat, int i, int i2) {
            this.mWidth = i;
            this.mHeight = i2;
            this.mYuvFrameData = mat;
        }
    }

    public static class JavaCameraSizeAccessor implements ListItemAccessor {
    }

    public JavaCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x008d A[Catch:{ Exception -> 0x0012 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008e A[Catch:{ Exception -> 0x0012 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean initializeCamera(int r10, int r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            r0 = 0
            r9.mCamera = r0     // Catch:{ all -> 0x0209 }
            int r0 = r9.mCameraIndex     // Catch:{ all -> 0x0209 }
            r1 = -1
            r2 = 0
            r3 = 1
            if (r0 != r1) goto L_0x004e
            android.hardware.Camera r0 = android.hardware.Camera.open()     // Catch:{ Exception -> 0x0012 }
            r9.mCamera = r0     // Catch:{ Exception -> 0x0012 }
            goto L_0x0016
        L_0x0012:
            r0 = move-exception
            r0.getLocalizedMessage()     // Catch:{ all -> 0x0209 }
        L_0x0016:
            android.hardware.Camera r0 = r9.mCamera     // Catch:{ all -> 0x0209 }
            if (r0 != 0) goto L_0x00b8
            r0 = 0
            r4 = 0
        L_0x001c:
            int r5 = android.hardware.Camera.getNumberOfCameras()     // Catch:{ all -> 0x0209 }
            if (r0 >= r5) goto L_0x00b8
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0209 }
            r5.<init>()     // Catch:{ all -> 0x0209 }
            java.lang.String r6 = "Trying to open camera with new open("
            r5.append(r6)     // Catch:{ all -> 0x0209 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0209 }
            r5.append(r6)     // Catch:{ all -> 0x0209 }
            java.lang.String r6 = ")"
            r5.append(r6)     // Catch:{ all -> 0x0209 }
            r5.toString()     // Catch:{ all -> 0x0209 }
            android.hardware.Camera r5 = android.hardware.Camera.open(r0)     // Catch:{ RuntimeException -> 0x0043 }
            r9.mCamera = r5     // Catch:{ RuntimeException -> 0x0043 }
            r4 = 1
            goto L_0x0047
        L_0x0043:
            r5 = move-exception
            r5.getLocalizedMessage()     // Catch:{ all -> 0x0209 }
        L_0x0047:
            if (r4 == 0) goto L_0x004b
            goto L_0x00b8
        L_0x004b:
            int r0 = r0 + 1
            goto L_0x001c
        L_0x004e:
            int r0 = r9.mCameraIndex     // Catch:{ all -> 0x0209 }
            int r4 = r9.mCameraIndex     // Catch:{ all -> 0x0209 }
            r5 = 98
            r6 = 99
            if (r4 != r6) goto L_0x0070
            android.hardware.Camera$CameraInfo r4 = new android.hardware.Camera$CameraInfo     // Catch:{ all -> 0x0209 }
            r4.<init>()     // Catch:{ all -> 0x0209 }
            r7 = 0
        L_0x005e:
            int r8 = android.hardware.Camera.getNumberOfCameras()     // Catch:{ all -> 0x0209 }
            if (r7 >= r8) goto L_0x008b
            android.hardware.Camera.getCameraInfo(r7, r4)     // Catch:{ all -> 0x0209 }
            int r8 = r4.facing     // Catch:{ all -> 0x0209 }
            if (r8 != 0) goto L_0x006d
        L_0x006b:
            r0 = r7
            goto L_0x008b
        L_0x006d:
            int r7 = r7 + 1
            goto L_0x005e
        L_0x0070:
            int r4 = r9.mCameraIndex     // Catch:{ all -> 0x0209 }
            if (r4 != r5) goto L_0x008b
            android.hardware.Camera$CameraInfo r4 = new android.hardware.Camera$CameraInfo     // Catch:{ all -> 0x0209 }
            r4.<init>()     // Catch:{ all -> 0x0209 }
            r7 = 0
        L_0x007a:
            int r8 = android.hardware.Camera.getNumberOfCameras()     // Catch:{ all -> 0x0209 }
            if (r7 >= r8) goto L_0x008b
            android.hardware.Camera.getCameraInfo(r7, r4)     // Catch:{ all -> 0x0209 }
            int r8 = r4.facing     // Catch:{ all -> 0x0209 }
            if (r8 != r3) goto L_0x0088
            goto L_0x006b
        L_0x0088:
            int r7 = r7 + 1
            goto L_0x007a
        L_0x008b:
            if (r0 != r6) goto L_0x008e
            goto L_0x00b8
        L_0x008e:
            if (r0 != r5) goto L_0x0091
            goto L_0x00b8
        L_0x0091:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0209 }
            r4.<init>()     // Catch:{ all -> 0x0209 }
            java.lang.String r5 = "Trying to open camera with new open("
            r4.append(r5)     // Catch:{ all -> 0x0209 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0209 }
            r4.append(r5)     // Catch:{ all -> 0x0209 }
            java.lang.String r5 = ")"
            r4.append(r5)     // Catch:{ all -> 0x0209 }
            r4.toString()     // Catch:{ all -> 0x0209 }
            r9.openCamera()     // Catch:{ RuntimeException -> 0x00b4 }
            android.hardware.Camera r0 = android.hardware.Camera.open(r0)     // Catch:{ RuntimeException -> 0x00b4 }
            r9.mCamera = r0     // Catch:{ RuntimeException -> 0x00b4 }
            goto L_0x00b8
        L_0x00b4:
            r0 = move-exception
            r0.getLocalizedMessage()     // Catch:{ all -> 0x0209 }
        L_0x00b8:
            android.hardware.Camera r0 = r9.mCamera     // Catch:{ all -> 0x0209 }
            if (r0 != 0) goto L_0x00be
            monitor-exit(r9)     // Catch:{ all -> 0x0209 }
            return r2
        L_0x00be:
            android.hardware.Camera r0 = r9.mCamera     // Catch:{ Exception -> 0x0203 }
            android.hardware.Camera$Parameters r0 = r0.getParameters()     // Catch:{ Exception -> 0x0203 }
            java.util.List r4 = r0.getSupportedPreviewSizes()     // Catch:{ Exception -> 0x0203 }
            if (r4 == 0) goto L_0x0207
            org.opencv.android.JavaCameraView$JavaCameraSizeAccessor r5 = new org.opencv.android.JavaCameraView$JavaCameraSizeAccessor     // Catch:{ Exception -> 0x0203 }
            r5.<init>()     // Catch:{ Exception -> 0x0203 }
            org.opencv.core.Size r4 = r9.calculateCameraFrameSize(r4, r5, r10, r11)     // Catch:{ Exception -> 0x0203 }
            r5 = 17
            r0.setPreviewFormat(r5)     // Catch:{ Exception -> 0x0203 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0203 }
            r5.<init>()     // Catch:{ Exception -> 0x0203 }
            java.lang.String r6 = "Set preview size to "
            r5.append(r6)     // Catch:{ Exception -> 0x0203 }
            double r6 = r4.width     // Catch:{ Exception -> 0x0203 }
            int r6 = (int) r6     // Catch:{ Exception -> 0x0203 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0203 }
            r5.append(r6)     // Catch:{ Exception -> 0x0203 }
            java.lang.String r6 = "x"
            r5.append(r6)     // Catch:{ Exception -> 0x0203 }
            double r6 = r4.height     // Catch:{ Exception -> 0x0203 }
            int r6 = (int) r6     // Catch:{ Exception -> 0x0203 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0203 }
            r5.append(r6)     // Catch:{ Exception -> 0x0203 }
            r5.toString()     // Catch:{ Exception -> 0x0203 }
            double r5 = r4.width     // Catch:{ Exception -> 0x0203 }
            int r5 = (int) r5     // Catch:{ Exception -> 0x0203 }
            double r6 = r4.height     // Catch:{ Exception -> 0x0203 }
            int r4 = (int) r6     // Catch:{ Exception -> 0x0203 }
            r0.setPreviewSize(r5, r4)     // Catch:{ Exception -> 0x0203 }
            java.lang.String r4 = android.os.Build.MODEL     // Catch:{ Exception -> 0x0203 }
            java.lang.String r5 = "GT-I9100"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0203 }
            if (r4 != 0) goto L_0x0115
            r0.setRecordingHint(r3)     // Catch:{ Exception -> 0x0203 }
        L_0x0115:
            java.util.List r4 = r0.getSupportedFocusModes()     // Catch:{ Exception -> 0x0203 }
            if (r4 == 0) goto L_0x0128
            java.lang.String r5 = "continuous-video"
            boolean r4 = r4.contains(r5)     // Catch:{ Exception -> 0x0203 }
            if (r4 == 0) goto L_0x0128
            java.lang.String r4 = "continuous-video"
            r0.setFocusMode(r4)     // Catch:{ Exception -> 0x0203 }
        L_0x0128:
            android.hardware.Camera r4 = r9.mCamera     // Catch:{ Exception -> 0x0203 }
            r4.setParameters(r0)     // Catch:{ Exception -> 0x0203 }
            android.hardware.Camera r0 = r9.mCamera     // Catch:{ Exception -> 0x0203 }
            android.hardware.Camera$Parameters r0 = r0.getParameters()     // Catch:{ Exception -> 0x0203 }
            android.hardware.Camera$Size r4 = r0.getPreviewSize()     // Catch:{ Exception -> 0x0203 }
            int r4 = r4.width     // Catch:{ Exception -> 0x0203 }
            r9.mFrameWidth = r4     // Catch:{ Exception -> 0x0203 }
            android.hardware.Camera$Size r4 = r0.getPreviewSize()     // Catch:{ Exception -> 0x0203 }
            int r4 = r4.height     // Catch:{ Exception -> 0x0203 }
            r9.mFrameHeight = r4     // Catch:{ Exception -> 0x0203 }
            android.view.ViewGroup$LayoutParams r4 = r9.getLayoutParams()     // Catch:{ Exception -> 0x0203 }
            int r4 = r4.width     // Catch:{ Exception -> 0x0203 }
            if (r4 != r1) goto L_0x0164
            android.view.ViewGroup$LayoutParams r4 = r9.getLayoutParams()     // Catch:{ Exception -> 0x0203 }
            int r4 = r4.height     // Catch:{ Exception -> 0x0203 }
            if (r4 != r1) goto L_0x0164
            float r11 = (float) r11     // Catch:{ Exception -> 0x0203 }
            int r1 = r9.mFrameHeight     // Catch:{ Exception -> 0x0203 }
            float r1 = (float) r1     // Catch:{ Exception -> 0x0203 }
            float r11 = r11 / r1
            float r10 = (float) r10     // Catch:{ Exception -> 0x0203 }
            int r1 = r9.mFrameWidth     // Catch:{ Exception -> 0x0203 }
            float r1 = (float) r1     // Catch:{ Exception -> 0x0203 }
            float r10 = r10 / r1
            float r10 = java.lang.Math.min(r11, r10)     // Catch:{ Exception -> 0x0203 }
            r9.mScale = r10     // Catch:{ Exception -> 0x0203 }
            goto L_0x0167
        L_0x0164:
            r10 = 0
            r9.mScale = r10     // Catch:{ Exception -> 0x0203 }
        L_0x0167:
            org.opencv.android.FpsMeter r10 = r9.mFpsMeter     // Catch:{ Exception -> 0x0203 }
            if (r10 == 0) goto L_0x0175
            org.opencv.android.FpsMeter r10 = r9.mFpsMeter     // Catch:{ Exception -> 0x0203 }
            int r11 = r9.mFrameWidth     // Catch:{ Exception -> 0x0203 }
            int r1 = r9.mFrameHeight     // Catch:{ Exception -> 0x0203 }
            r10.mWidth = r11     // Catch:{ Exception -> 0x0203 }
            r10.mHeight = r1     // Catch:{ Exception -> 0x0203 }
        L_0x0175:
            int r10 = r9.mFrameWidth     // Catch:{ Exception -> 0x0203 }
            int r11 = r9.mFrameHeight     // Catch:{ Exception -> 0x0203 }
            int r10 = r10 * r11
            int r11 = r0.getPreviewFormat()     // Catch:{ Exception -> 0x0203 }
            int r11 = android.graphics.ImageFormat.getBitsPerPixel(r11)     // Catch:{ Exception -> 0x0203 }
            int r10 = r10 * r11
            int r10 = r10 / 8
            byte[] r10 = new byte[r10]     // Catch:{ Exception -> 0x0203 }
            r9.mBuffer = r10     // Catch:{ Exception -> 0x0203 }
            android.hardware.Camera r11 = r9.mCamera     // Catch:{ Exception -> 0x0203 }
            r11.addCallbackBuffer(r10)     // Catch:{ Exception -> 0x0203 }
            android.hardware.Camera r10 = r9.mCamera     // Catch:{ Exception -> 0x0203 }
            r10.setPreviewCallbackWithBuffer(r9)     // Catch:{ Exception -> 0x0203 }
            r10 = 2
            org.opencv.core.Mat[] r11 = new org.opencv.core.Mat[r10]     // Catch:{ Exception -> 0x0203 }
            r9.mFrameChain = r11     // Catch:{ Exception -> 0x0203 }
            org.opencv.core.Mat r0 = new org.opencv.core.Mat     // Catch:{ Exception -> 0x0203 }
            int r1 = r9.mFrameHeight     // Catch:{ Exception -> 0x0203 }
            int r4 = r9.mFrameHeight     // Catch:{ Exception -> 0x0203 }
            int r4 = r4 / r10
            int r1 = r1 + r4
            int r4 = r9.mFrameWidth     // Catch:{ Exception -> 0x0203 }
            int r5 = org.opencv.core.CvType.CV_8UC1     // Catch:{ Exception -> 0x0203 }
            r0.<init>(r1, r4, r5)     // Catch:{ Exception -> 0x0203 }
            r11[r2] = r0     // Catch:{ Exception -> 0x0203 }
            org.opencv.core.Mat[] r11 = r9.mFrameChain     // Catch:{ Exception -> 0x0203 }
            org.opencv.core.Mat r0 = new org.opencv.core.Mat     // Catch:{ Exception -> 0x0203 }
            int r1 = r9.mFrameHeight     // Catch:{ Exception -> 0x0203 }
            int r4 = r9.mFrameHeight     // Catch:{ Exception -> 0x0203 }
            int r4 = r4 / r10
            int r1 = r1 + r4
            int r4 = r9.mFrameWidth     // Catch:{ Exception -> 0x0203 }
            int r5 = org.opencv.core.CvType.CV_8UC1     // Catch:{ Exception -> 0x0203 }
            r0.<init>(r1, r4, r5)     // Catch:{ Exception -> 0x0203 }
            r11[r3] = r0     // Catch:{ Exception -> 0x0203 }
            int r11 = r9.mFrameWidth     // Catch:{ Exception -> 0x0203 }
            int r0 = r9.mFrameHeight     // Catch:{ Exception -> 0x0203 }
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ Exception -> 0x0203 }
            android.graphics.Bitmap r11 = android.graphics.Bitmap.createBitmap(r11, r0, r1)     // Catch:{ Exception -> 0x0203 }
            r9.mCacheBitmap = r11     // Catch:{ Exception -> 0x0203 }
            org.opencv.android.JavaCameraView$JavaCameraFrame[] r10 = new org.opencv.android.JavaCameraView.JavaCameraFrame[r10]     // Catch:{ Exception -> 0x0203 }
            r9.mCameraFrame = r10     // Catch:{ Exception -> 0x0203 }
            org.opencv.android.JavaCameraView$JavaCameraFrame r11 = new org.opencv.android.JavaCameraView$JavaCameraFrame     // Catch:{ Exception -> 0x0203 }
            org.opencv.core.Mat[] r0 = r9.mFrameChain     // Catch:{ Exception -> 0x0203 }
            r0 = r0[r2]     // Catch:{ Exception -> 0x0203 }
            int r1 = r9.mFrameWidth     // Catch:{ Exception -> 0x0203 }
            int r4 = r9.mFrameHeight     // Catch:{ Exception -> 0x0203 }
            r11.<init>(r0, r1, r4)     // Catch:{ Exception -> 0x0203 }
            r10[r2] = r11     // Catch:{ Exception -> 0x0203 }
            org.opencv.android.JavaCameraView$JavaCameraFrame[] r10 = r9.mCameraFrame     // Catch:{ Exception -> 0x0203 }
            org.opencv.android.JavaCameraView$JavaCameraFrame r11 = new org.opencv.android.JavaCameraView$JavaCameraFrame     // Catch:{ Exception -> 0x0203 }
            org.opencv.core.Mat[] r0 = r9.mFrameChain     // Catch:{ Exception -> 0x0203 }
            r0 = r0[r3]     // Catch:{ Exception -> 0x0203 }
            int r1 = r9.mFrameWidth     // Catch:{ Exception -> 0x0203 }
            int r4 = r9.mFrameHeight     // Catch:{ Exception -> 0x0203 }
            r11.<init>(r0, r1, r4)     // Catch:{ Exception -> 0x0203 }
            r10[r3] = r11     // Catch:{ Exception -> 0x0203 }
            android.graphics.SurfaceTexture r10 = new android.graphics.SurfaceTexture     // Catch:{ Exception -> 0x0203 }
            r11 = 10
            r10.<init>(r11)     // Catch:{ Exception -> 0x0203 }
            r9.mSurfaceTexture = r10     // Catch:{ Exception -> 0x0203 }
            android.hardware.Camera r11 = r9.mCamera     // Catch:{ Exception -> 0x0203 }
            r11.setPreviewTexture(r10)     // Catch:{ Exception -> 0x0203 }
            android.hardware.Camera r10 = r9.mCamera     // Catch:{ Exception -> 0x0203 }
            r10.startPreview()     // Catch:{ Exception -> 0x0203 }
            r2 = 1
            goto L_0x0207
        L_0x0203:
            r10 = move-exception
            r10.printStackTrace()     // Catch:{ all -> 0x0209 }
        L_0x0207:
            monitor-exit(r9)     // Catch:{ all -> 0x0209 }
            return r2
        L_0x0209:
            r10 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x0209 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.opencv.android.JavaCameraView.initializeCamera(int, int):boolean");
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        int length = bArr.length;
        synchronized (this) {
            this.mFrameChain[this.mChainIdx].put(0, 0, bArr);
            this.mCameraFrameReady = true;
            notify();
        }
        Camera camera2 = this.mCamera;
        if (camera2 != null) {
            camera2.addCallbackBuffer(this.mBuffer);
        }
    }

    public final void openCamera() {
        CameraManager cameraManager = (CameraManager) getContext().getSystemService("camera");
        try {
            cameraManager.openCamera(cameraManager.getCameraIdList()[0], this.mStateCallback, null);
        } catch (CameraAccessException e2) {
            e2.printStackTrace();
        }
    }
}
