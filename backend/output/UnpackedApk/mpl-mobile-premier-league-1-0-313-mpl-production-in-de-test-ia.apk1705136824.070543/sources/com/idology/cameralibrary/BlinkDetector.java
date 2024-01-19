package com.idology.cameralibrary;

import android.os.Build;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class BlinkDetector {
    public Mat cameraPreviewFrame;
    public final int deviceRotation;
    public CascadeClassifier mEyesCascade;
    public CascadeClassifier mFaceCascade;
    public CascadeClassifier mLeftEyeCascade;
    public CascadeClassifier mRightEyeCascade;

    public BlinkDetector(byte[] bArr, int i, int i2, CascadeClassifier cascadeClassifier, CascadeClassifier cascadeClassifier2, CascadeClassifier cascadeClassifier3, CascadeClassifier cascadeClassifier4, int i3) {
        int i4 = i;
        int i5 = i2;
        Mat mat = new Mat((i5 / 2) + i5, i, CvType.CV_8UC1);
        byte[] bArr2 = bArr;
        mat.put(0, 0, bArr);
        Mat mat2 = new Mat();
        Imgproc.cvtColor_0(mat.nativeObj, mat2.nativeObj, 96, 4);
        Mat mat3 = new Mat(i2, i, CvType.CV_8UC4);
        this.cameraPreviewFrame = mat3;
        Imgproc.cvtColor_0(mat2.nativeObj, mat3.nativeObj, 10, 1);
        Mat.n_release(mat2.nativeObj);
        this.deviceRotation = i3;
        if (Build.MODEL.equals("Nexus 6P")) {
            reorientCameraPreviewFrame6P();
        } else {
            reorientCameraPreviewFrame();
        }
        this.mFaceCascade = cascadeClassifier;
        this.mEyesCascade = cascadeClassifier2;
        this.mLeftEyeCascade = cascadeClassifier3;
        this.mRightEyeCascade = cascadeClassifier4;
    }

    public final void releaseResources() {
        Mat.n_release(this.cameraPreviewFrame.nativeObj);
    }

    public final void reorientCameraPreviewFrame() {
        int i = this.deviceRotation;
        if (i != -270) {
            if (i != -180) {
                if (i == -90) {
                    return;
                }
                if (i != 90) {
                    if (i != 180) {
                        if (i != 270) {
                            Mat mat = this.cameraPreviewFrame;
                            Core.transpose(mat, mat);
                            Mat mat2 = this.cameraPreviewFrame;
                            Core.flip(mat2, mat2, 0);
                            return;
                        }
                        return;
                    }
                }
            }
            Mat mat3 = this.cameraPreviewFrame;
            Core.transpose(mat3, mat3);
            Mat mat4 = this.cameraPreviewFrame;
            Core.flip(mat4, mat4, 1);
            return;
        }
        Mat mat5 = this.cameraPreviewFrame;
        Core.flip(mat5, mat5, 0);
    }

    public final void reorientCameraPreviewFrame6P() {
        int i = this.deviceRotation;
        if (i != -270) {
            if (i != -180) {
                if (i != -90) {
                    if (i == 90) {
                        return;
                    }
                    if (i != 180) {
                        if (i != 270) {
                            Mat mat = this.cameraPreviewFrame;
                            Core.transpose(mat, mat);
                            Mat mat2 = this.cameraPreviewFrame;
                            Core.flip(mat2, mat2, 1);
                            return;
                        }
                    }
                }
                Mat mat3 = this.cameraPreviewFrame;
                Core.flip(mat3, mat3, 0);
                return;
            }
            Mat mat4 = this.cameraPreviewFrame;
            Core.transpose(mat4, mat4);
            Mat mat5 = this.cameraPreviewFrame;
            Core.flip(mat5, mat5, 0);
        }
    }
}
