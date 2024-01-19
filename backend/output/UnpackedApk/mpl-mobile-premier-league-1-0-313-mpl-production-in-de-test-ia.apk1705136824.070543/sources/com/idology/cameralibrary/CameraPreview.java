package com.idology.cameralibrary;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Canvas;
import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import androidx.appcompat.app.AlertController.AlertParams;
import androidx.appcompat.app.AlertDialog.Builder;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.crimzoncode.tqcontests.util.TQConstants;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.idology.cameralibrary.ActivationKey.Feature;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.PDPrintFieldAttributeObject;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.objdetect.CascadeClassifier;

public class CameraPreview extends SurfaceView implements Callback, PreviewCallback {
    public boolean autoFocusInProgress = false;
    public BlinkStatus blinkStatus = BlinkStatus.Unknown;
    public ICameraActivity cameraActivity;
    public Constants constants = Constants.ourInstance;
    public boolean detectionStarted = false;
    public AutoFocusCallback focusCallBack = new AutoFocusCallback() {
        public void onAutoFocus(boolean z, Camera camera) {
            Camera camera2 = CameraPreview.this.mCamera;
            if (camera2 != null && z) {
                camera2.cancelAutoFocus();
            }
            CameraPreview.this.autoFocusInProgress = false;
        }
    };
    public Camera mCamera;
    public Activity mContext;
    public CascadeClassifier mEyeCascade;
    public Rect[][] mEyes = new Rect[0][];
    public CascadeClassifier mFaceCascade;
    public Rect[] mFaces = new Rect[0];
    public SurfaceHolder mHolder;
    public CascadeClassifier mLeftEyeCascade;
    public Rect[][][] mLeftEyes = new Rect[0][][];
    public CascadeClassifier mRightEyeCascade;
    public Rect[][][] mRightEyes = new Rect[0][][];
    public boolean mUseSelfie;
    public Mode mode;
    public int previewHeight = 0;
    public long previewStartTime = System.currentTimeMillis();
    public int previewWidth = 0;
    public boolean showingDialog = false;

    public enum BlinkStatus {
        Unknown,
        EyesOpen,
        Winking,
        EyesShut,
        Peeping,
        Blinking,
        Invalid
    }

    public enum Mode {
        Front,
        Back,
        Selfie
    }

    public CameraPreview(CameraActivity cameraActivity2, Mode mode2, CascadeClassifier cascadeClassifier, CascadeClassifier cascadeClassifier2, CascadeClassifier cascadeClassifier3, CascadeClassifier cascadeClassifier4) {
        super(cameraActivity2);
        boolean z = false;
        this.cameraActivity = cameraActivity2;
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.mFaceCascade = cascadeClassifier;
        this.mEyeCascade = cascadeClassifier2;
        this.mLeftEyeCascade = cascadeClassifier3;
        this.mRightEyeCascade = cascadeClassifier4;
        this.mode = mode2;
        z = mode2 == Mode.Selfie ? true : z;
        this.mUseSelfie = z;
        this.mContext = cameraActivity2;
        Camera camera = this.mCamera;
        if (camera != null) {
            camera.release();
            this.mCamera = null;
        }
        try {
            Camera open = Camera.open(z ? 1 : 0);
            this.mCamera = open;
            open.setDisplayOrientation(90);
            if (Build.MODEL.equals("Nexus 5X")) {
                this.mCamera.setDisplayOrientation(270);
            }
            if (z) {
                if (Build.MODEL.equals("Nexus 6P")) {
                    this.mCamera.setDisplayOrientation(270);
                }
                if (Build.MODEL.equals("Nexus 5X")) {
                    this.mCamera.setDisplayOrientation(90);
                }
            }
            this.mCamera.setParameters(setCameraFeatures());
        } catch (Exception e2) {
            e2.getMessage();
        }
        SurfaceHolder holder = getHolder();
        this.mHolder = holder;
        holder.setType(3);
        this.mHolder.addCallback(this);
        Camera camera2 = this.mCamera;
        if (camera2 != null) {
            Parameters parameters = camera2.getParameters();
            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
            String str = (supportedFocusModes == null || !supportedFocusModes.contains("auto")) ? "" : "auto";
            parameters.setWhiteBalance("auto");
            parameters.setPictureFormat(256);
            if (this.mUseSelfie) {
                this.mCamera.setParameters(parameters);
                parameters.setJpegQuality(80);
                this.mCamera.setPreviewCallback(null);
                return;
            }
            if (!str.equalsIgnoreCase("")) {
                parameters.setFocusMode(str);
            }
            this.mCamera.setParameters(parameters);
            parameters.setJpegQuality(90);
            this.mCamera.setPreviewCallback(null);
            this.autoFocusInProgress = true;
        }
    }

    private void setBlinkStatus(BlinkStatus blinkStatus2) {
        blinkStatus2.toString();
        this.blinkStatus = blinkStatus2;
    }

    public final void doBlinkDetection(byte[] bArr) {
        long currentTimeMillis = System.currentTimeMillis() - this.previewStartTime;
        if ((PreviewActivity.blinkCount == 0 && currentTimeMillis < RemoteConfigManager.MIN_APP_START_CONFIG_FETCH_DELAY_MS) || currentTimeMillis < TQConstants.COUNTDOWN_DURATION) {
            return;
        }
        if (currentTimeMillis > MqttAsyncClient.DISCONNECT_TIMEOUT) {
            this.showingDialog = true;
            Constants constants2 = this.constants;
            Builder builder = new Builder(super.getContext());
            Objects.requireNonNull(this.constants);
            builder.P.mMessage = "Please try again";
            AnonymousClass1 r3 = new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    CameraPreview cameraPreview = CameraPreview.this;
                    cameraPreview.surfaceCreated(cameraPreview.getHolder());
                    CameraPreview cameraPreview2 = CameraPreview.this;
                    cameraPreview2.showingDialog = false;
                    cameraPreview2.previewStartTime = System.currentTimeMillis();
                }
            };
            AlertParams alertParams = builder.P;
            alertParams.mPositiveButtonText = "Retry";
            alertParams.mPositiveButtonListener = r3;
            alertParams.mCancelable = false;
            Objects.requireNonNull(this.constants);
            builder.P.mTitle = "No Blink Detected";
            constants2.blinkDialog = builder.show();
            if (PreviewActivity.blinkCount < 3) {
                resetBlinkDetection();
            } else {
                CameraActivity cameraActivity2 = (CameraActivity) this.cameraActivity;
                cameraActivity2.livelinessDetected = false;
                cameraActivity2.captureImage();
            }
            return;
        }
        if (!this.detectionStarted) {
            this.detectionStarted = true;
            System.currentTimeMillis();
        }
        BlinkDetector blinkDetector = new BlinkDetector(bArr, this.previewWidth, this.previewHeight, this.mFaceCascade, this.mEyeCascade, this.mLeftEyeCascade, this.mRightEyeCascade, getDeviceRotation());
        MatOfRect matOfRect = new MatOfRect();
        double min = (double) ((int) (((float) Math.min(blinkDetector.cameraPreviewFrame.cols(), blinkDetector.cameraPreviewFrame.rows())) * 0.25f));
        CascadeClassifier cascadeClassifier = blinkDetector.mFaceCascade;
        if (cascadeClassifier != null) {
            CascadeClassifier.detectMultiScale_0(cascadeClassifier.nativeObj, blinkDetector.cameraPreviewFrame.nativeObj, matOfRect.nativeObj, 1.1d, 5, 0, min, min, 0.0d, 0.0d);
        }
        Rect[] array = matOfRect.toArray();
        Rect[][] rectArr = new Rect[array.length][];
        Rect[][][] rectArr2 = new Rect[array.length][][];
        Rect[][][] rectArr3 = new Rect[array.length][][];
        int i = 0;
        while (i < array.length) {
            Mat submat = blinkDetector.cameraPreviewFrame.submat(array[i]);
            MatOfRect matOfRect2 = new MatOfRect();
            double cols = (double) ((int) (((double) submat.cols()) * 0.5d));
            CascadeClassifier.detectMultiScale_0(blinkDetector.mEyesCascade.nativeObj, submat.nativeObj, matOfRect2.nativeObj, 1.1d, 3, 0, cols, (double) ((int) ((cols * 22.0d) / 90.0d)), 0.0d, 0.0d);
            Rect[] array2 = matOfRect2.toArray();
            rectArr[i] = array2;
            rectArr2[i] = new Rect[array2.length][];
            rectArr3[i] = new Rect[array2.length][];
            int i2 = 0;
            while (i2 < array2.length) {
                int min2 = (int) (((double) Math.min(array2[i2].width, array2[i2].height)) * 0.25d);
                Rect rect = array2[i2];
                rect.x -= min2;
                rect.y -= min2;
                int i3 = min2 * 2;
                rect.width += i3;
                rect.height += i3;
                Mat submat2 = submat.submat(rect);
                double rows = (double) ((int) (((double) submat2.rows()) / 2.0d));
                CascadeClassifier.detectMultiScale_0(blinkDetector.mLeftEyeCascade.nativeObj, new Mat(Mat.n_submat(submat2.nativeObj, 0, 0, submat2.cols() / 2, submat2.rows())).nativeObj, matOfRect2.nativeObj, 1.1d, 4, 0, rows, rows, 0.0d, 0.0d);
                rectArr2[i][i2] = matOfRect2.toArray();
                Mat mat = new Mat(Mat.n_submat(submat2.nativeObj, submat2.cols() / 2, 0, submat2.cols() / 2, submat2.rows()));
                int i4 = i2;
                MatOfRect matOfRect3 = matOfRect2;
                int i5 = i;
                Rect[][][] rectArr4 = rectArr3;
                CascadeClassifier.detectMultiScale_0(blinkDetector.mRightEyeCascade.nativeObj, mat.nativeObj, matOfRect3.nativeObj, 1.1d, 4, 0, rows, rows, 0.0d, 0.0d);
                rectArr4[i5][i4] = matOfRect3.toArray();
                i2 = i4 + 1;
                matOfRect2 = matOfRect3;
                rectArr3 = rectArr4;
                array2 = array2;
                submat = submat;
                i = i5;
            }
            Rect[][][] rectArr5 = rectArr3;
            i++;
        }
        blinkDetector.releaseResources();
        this.mFaces = array;
        this.mEyes = rectArr;
        this.mLeftEyes = rectArr2;
        this.mRightEyes = rectArr3;
        if (array.length != 1) {
            this.blinkStatus = BlinkStatus.Unknown;
        } else if (rectArr[0].length != 1) {
            this.blinkStatus = BlinkStatus.Unknown;
        } else {
            int i6 = (rectArr2[0][0].length > 0 ? 1 : 0) + (this.mRightEyes[0][0].length > 0 ? 1 : 0);
            if (i6 == 0) {
                BlinkStatus blinkStatus2 = this.blinkStatus;
                if (blinkStatus2 == BlinkStatus.Winking || blinkStatus2 == BlinkStatus.EyesOpen) {
                    setBlinkStatus(BlinkStatus.EyesShut);
                }
            } else if (i6 == 1) {
                BlinkStatus blinkStatus3 = this.blinkStatus;
                if (blinkStatus3 == BlinkStatus.EyesOpen) {
                    setBlinkStatus(BlinkStatus.Winking);
                } else if (blinkStatus3 == BlinkStatus.EyesShut) {
                    setBlinkStatus(BlinkStatus.Peeping);
                }
            } else if (i6 != 2) {
                setBlinkStatus(BlinkStatus.Invalid);
            } else {
                BlinkStatus blinkStatus4 = this.blinkStatus;
                if (blinkStatus4 == BlinkStatus.Unknown || blinkStatus4 == BlinkStatus.Invalid) {
                    setBlinkStatus(BlinkStatus.EyesOpen);
                } else if (blinkStatus4 == BlinkStatus.EyesShut || blinkStatus4 == BlinkStatus.Peeping) {
                    setBlinkStatus(BlinkStatus.Blinking);
                }
            }
        }
        if (this.blinkStatus == BlinkStatus.Blinking) {
            resetBlinkDetection();
            CameraActivity cameraActivity3 = (CameraActivity) this.cameraActivity;
            cameraActivity3.livelinessDetected = true;
            cameraActivity3.captureImage();
        }
    }

    public int getDeviceRotation() {
        return ((CameraActivity) this.cameraActivity).deviceRotation;
    }

    public final void initCamera(SurfaceHolder surfaceHolder) throws IOException {
        this.mCamera.setPreviewDisplay(surfaceHolder);
        int i = 0;
        while (i < 1) {
            Camera camera = this.mCamera;
            Parameters parameters = camera.getParameters();
            Size previewSize = parameters.getPreviewSize();
            int previewFormat = parameters.getPreviewFormat();
            if (previewFormat == 17) {
                int i2 = previewSize.width;
                this.previewWidth = i2;
                int i3 = previewSize.height;
                this.previewHeight = i3;
                camera.addCallbackBuffer(new byte[((ImageFormat.getBitsPerPixel(previewFormat) * (i2 * i3)) / 8)]);
                i++;
            } else {
                throw new UnsupportedOperationException(GeneratedOutlineSupport.outline41("Unknown imageFormat: ", previewFormat));
            }
        }
        this.mCamera.setPreviewCallbackWithBuffer(this);
        this.mCamera.startPreview();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        try {
            if (!this.autoFocusInProgress) {
                if (!this.showingDialog) {
                    int ordinal = this.mode.ordinal();
                    if (!(ordinal == 0 || ordinal == 1)) {
                        if (ordinal != 2) {
                            "Unsupported CameraPreview Mode: " + this.mode;
                        } else if (this.constants.activationKey.isEnabled(Feature.SelfieAndLivelinessEnabled)) {
                            doBlinkDetection(bArr);
                        }
                    }
                    this.mCamera.addCallbackBuffer(bArr);
                    return;
                }
            }
            this.mCamera.addCallbackBuffer(bArr);
        } catch (Exception e2) {
            e2.getMessage();
        } catch (Throwable th) {
            this.mCamera.addCallbackBuffer(bArr);
            throw th;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            try {
                if (this.mCamera != null) {
                    this.autoFocusInProgress = true;
                    this.mCamera.autoFocus(this.focusCallBack);
                }
            } catch (RuntimeException e2) {
                e2.getMessage();
                e2.getMessage();
            }
        }
        return true;
    }

    public void resetBlinkDetection() {
        this.blinkStatus = BlinkStatus.Unknown;
        this.mFaces = new Rect[0];
        this.mEyes = new Rect[0][];
        this.mLeftEyes = new Rect[0][][];
        this.mRightEyes = new Rect[0][][];
        this.previewStartTime = System.currentTimeMillis();
        this.detectionStarted = false;
        PreviewActivity.blinkCount++;
    }

    public final Parameters setCameraFeatures() {
        Parameters parameters = this.mCamera.getParameters();
        List<Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
        float height = ((float) this.mContext.getWindowManager().getDefaultDisplay().getHeight()) / ((float) this.mContext.getWindowManager().getDefaultDisplay().getWidth());
        int i = this.constants.standardImageSize ? 2048 : 3200;
        float f2 = Float.MAX_VALUE;
        float f3 = Float.MAX_VALUE;
        for (Size next : supportedPictureSizes) {
            float abs = (float) Math.abs(next.width - i);
            if (f3 > 0.0f && abs < f3) {
                parameters.setPictureSize(next.width, next.height);
                f3 = abs;
            }
        }
        float f4 = Float.NaN;
        List<Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        for (Size next2 : supportedPreviewSizes) {
            float f5 = ((float) next2.width) / ((float) next2.height);
            float abs2 = Math.abs(height - f5);
            if (abs2 < f2) {
                f4 = f5;
                f2 = abs2;
            }
        }
        Iterator<Size> it = supportedPreviewSizes.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Size next3 = it.next();
            int i2 = next3.width;
            int i3 = next3.height;
            if (((float) i2) / ((float) i3) == f4) {
                parameters.setPreviewSize(i2, i3);
                break;
            }
        }
        parameters.setPictureFormat(256);
        parameters.setJpegQuality(85);
        int[] iArr = (int[]) GeneratedOutlineSupport.outline30(parameters.getSupportedPreviewFpsRange(), 1);
        parameters.setPreviewFpsRange(iArr[0], iArr[1]);
        return parameters;
    }

    public void setMode(Mode mode2) {
        this.mode = mode2;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Camera camera = this.mCamera;
        if (camera != null && this.mHolder != null) {
            try {
                camera.stopPreview();
            } catch (Exception e2) {
                e2.getMessage();
            }
            try {
                initCamera(surfaceHolder);
            } catch (Exception e3) {
                e3.getMessage();
            }
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        try {
            if (this.mCamera != null) {
                initCamera(surfaceHolder);
            }
        } catch (IOException e2) {
            e2.getMessage();
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Camera camera = this.mCamera;
        if (camera != null) {
            camera.setPreviewCallback(null);
            this.mCamera.stopPreview();
            this.mCamera.release();
            this.mCamera = null;
        }
    }

    public void useFlash(boolean z, String str) {
        Camera camera = this.mCamera;
        if (camera != null) {
            Parameters parameters = camera.getParameters();
            if (z) {
                parameters.setFlashMode(str);
            } else {
                parameters.setFlashMode(PDPrintFieldAttributeObject.CHECKED_STATE_OFF);
            }
            this.mCamera.setParameters(parameters);
            this.mCamera.setPreviewCallback(null);
        }
    }
}
