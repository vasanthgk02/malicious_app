package org.opencv.android;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.view.Surface;
import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@TargetApi(21)
public class Camera2Renderer extends CameraGLRendererBase {
    public Handler mBackgroundHandler;
    public HandlerThread mBackgroundThread;
    public CameraDevice mCameraDevice;
    public String mCameraID;
    public Semaphore mCameraOpenCloseLock = new Semaphore(1);
    public CameraCaptureSession mCaptureSession;
    public Builder mPreviewRequestBuilder;
    public Size mPreviewSize = new Size(-1, -1);
    public final StateCallback mStateCallback = new StateCallback() {
        public void onDisconnected(CameraDevice cameraDevice) {
            cameraDevice.close();
            Camera2Renderer camera2Renderer = Camera2Renderer.this;
            camera2Renderer.mCameraDevice = null;
            camera2Renderer.mCameraOpenCloseLock.release();
        }

        public void onError(CameraDevice cameraDevice, int i) {
            cameraDevice.close();
            Camera2Renderer camera2Renderer = Camera2Renderer.this;
            camera2Renderer.mCameraDevice = null;
            camera2Renderer.mCameraOpenCloseLock.release();
        }

        public void onOpened(CameraDevice cameraDevice) {
            Camera2Renderer camera2Renderer = Camera2Renderer.this;
            camera2Renderer.mCameraDevice = cameraDevice;
            camera2Renderer.mCameraOpenCloseLock.release();
            Camera2Renderer.this.createCameraPreviewSession();
        }
    };

    public Camera2Renderer(CameraGLSurfaceView cameraGLSurfaceView) {
        super(cameraGLSurfaceView);
    }

    public boolean cacPreviewSize(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        if (this.mCameraID == null) {
            return false;
        }
        try {
            float f2 = ((float) i3) / ((float) i4);
            int i5 = 0;
            int i6 = 0;
            for (Size size : ((StreamConfigurationMap) ((CameraManager) this.mView.getContext().getSystemService("camera")).getCameraCharacteristics(this.mCameraID).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(SurfaceTexture.class)) {
                int width = size.getWidth();
                int height = size.getHeight();
                if (i3 >= width && i4 >= height && i5 <= width && i6 <= height && ((double) Math.abs(f2 - (((float) width) / ((float) height)))) < 0.2d) {
                    i6 = height;
                    i5 = width;
                }
            }
            if (!(i5 == 0 || i6 == 0)) {
                if (this.mPreviewSize.getWidth() != i5 || this.mPreviewSize.getHeight() != i6) {
                    this.mPreviewSize = new Size(i5, i6);
                    return true;
                }
            }
        } catch (CameraAccessException | IllegalArgumentException | SecurityException unused) {
        }
        return false;
    }

    public void closeCamera() {
        try {
            this.mCameraOpenCloseLock.acquire();
            if (this.mCaptureSession != null) {
                this.mCaptureSession.close();
                this.mCaptureSession = null;
            }
            if (this.mCameraDevice != null) {
                this.mCameraDevice.close();
                this.mCameraDevice = null;
            }
            this.mCameraOpenCloseLock.release();
        } catch (InterruptedException e2) {
            throw new RuntimeException("Interrupted while trying to lock camera closing.", e2);
        } catch (Throwable th) {
            this.mCameraOpenCloseLock.release();
            throw th;
        }
    }

    public final void createCameraPreviewSession() {
        int width = this.mPreviewSize.getWidth();
        int height = this.mPreviewSize.getHeight();
        if (width >= 0 && height >= 0) {
            try {
                this.mCameraOpenCloseLock.acquire();
                if (this.mCameraDevice == null) {
                    this.mCameraOpenCloseLock.release();
                } else if (this.mCaptureSession != null) {
                    this.mCameraOpenCloseLock.release();
                } else if (this.mSTexture == null) {
                    this.mCameraOpenCloseLock.release();
                } else {
                    this.mSTexture.setDefaultBufferSize(width, height);
                    Surface surface = new Surface(this.mSTexture);
                    Builder createCaptureRequest = this.mCameraDevice.createCaptureRequest(1);
                    this.mPreviewRequestBuilder = createCaptureRequest;
                    createCaptureRequest.addTarget(surface);
                    this.mCameraDevice.createCaptureSession(Arrays.asList(new Surface[]{surface}), new CameraCaptureSession.StateCallback() {
                        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
                            Camera2Renderer.this.mCameraOpenCloseLock.release();
                        }

                        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
                            Camera2Renderer camera2Renderer = Camera2Renderer.this;
                            camera2Renderer.mCaptureSession = cameraCaptureSession;
                            try {
                                camera2Renderer.mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
                                Camera2Renderer.this.mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(2));
                                Camera2Renderer.this.mCaptureSession.setRepeatingRequest(Camera2Renderer.this.mPreviewRequestBuilder.build(), null, Camera2Renderer.this.mBackgroundHandler);
                            } catch (CameraAccessException unused) {
                            }
                            Camera2Renderer.this.mCameraOpenCloseLock.release();
                        }
                    }, this.mBackgroundHandler);
                }
            } catch (CameraAccessException unused) {
            } catch (InterruptedException e2) {
                throw new RuntimeException("Interrupted while createCameraPreviewSession", e2);
            }
        }
    }

    public void doStart() {
        HandlerThread handlerThread = this.mBackgroundThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            try {
                this.mBackgroundThread.join();
                this.mBackgroundThread = null;
                this.mBackgroundHandler = null;
            } catch (InterruptedException unused) {
            }
        }
        HandlerThread handlerThread2 = new HandlerThread("CameraBackground");
        this.mBackgroundThread = handlerThread2;
        handlerThread2.start();
        this.mBackgroundHandler = new Handler(this.mBackgroundThread.getLooper());
        super.doStart();
    }

    public void doStop() {
        super.doStop();
        HandlerThread handlerThread = this.mBackgroundThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            try {
                this.mBackgroundThread.join();
                this.mBackgroundThread = null;
                this.mBackgroundHandler = null;
            } catch (InterruptedException unused) {
            }
        }
    }

    public void openCamera(int i) {
        String str;
        CameraManager cameraManager = (CameraManager) this.mView.getContext().getSystemService("camera");
        try {
            String[] cameraIdList = cameraManager.getCameraIdList();
            if (cameraIdList.length != 0) {
                int i2 = 0;
                if (i == -1) {
                    this.mCameraID = cameraIdList[0];
                } else {
                    int length = cameraIdList.length;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        str = cameraIdList[i2];
                        CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
                        if (!((i == 99 && ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 1) || (i == 98 && ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 0))) {
                            i2++;
                        }
                    }
                    this.mCameraID = str;
                }
                if (this.mCameraID != null) {
                    if (this.mCameraOpenCloseLock.tryAcquire(2500, TimeUnit.MILLISECONDS)) {
                        cameraManager.openCamera(this.mCameraID, this.mStateCallback, this.mBackgroundHandler);
                    } else {
                        throw new RuntimeException("Time out waiting to lock camera opening.");
                    }
                }
            }
        } catch (CameraAccessException | IllegalArgumentException | InterruptedException | SecurityException unused) {
        }
    }

    public void setCameraPreviewSize(int i, int i2) {
        int i3 = this.mMaxCameraWidth;
        if (i3 > 0 && i3 < i) {
            i = i3;
        }
        int i4 = this.mMaxCameraHeight;
        if (i4 > 0 && i4 < i2) {
            i2 = i4;
        }
        try {
            this.mCameraOpenCloseLock.acquire();
            boolean cacPreviewSize = cacPreviewSize(i, i2);
            this.mCameraWidth = this.mPreviewSize.getWidth();
            this.mCameraHeight = this.mPreviewSize.getHeight();
            if (!cacPreviewSize) {
                this.mCameraOpenCloseLock.release();
                return;
            }
            if (this.mCaptureSession != null) {
                this.mCaptureSession.close();
                this.mCaptureSession = null;
            }
            this.mCameraOpenCloseLock.release();
            createCameraPreviewSession();
        } catch (InterruptedException e2) {
            this.mCameraOpenCloseLock.release();
            throw new RuntimeException("Interrupted while setCameraPreviewSize.", e2);
        }
    }
}
