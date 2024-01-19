package com.idology.cameralibrary;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertController.AlertParams;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.idology.cameralibrary.CameraPreview.Mode;
import com.idology.cameralibrary.Constants.CardCombination;
import com.inca.security.Proxy.iIiIiIiIii;
import com.mpl.androidapp.imagepicker.IdologyKycIdCapture;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.opencv.objdetect.CascadeClassifier;

public class CameraActivity extends AppCompatActivity implements ICameraActivity {
    public static int retryCount;
    public Thread background;
    public RelativeLayout borderLayout;
    public LinearLayout botLayout;
    public ImageButton cameraButton;
    public String cardType;
    public Constants constants;
    public int deviceRotation;
    public AlertDialog exitAlert;
    public ImageButton flashButton;
    public ImageButton helpButton;
    public float layoutPadding = 10.0f;
    public RelativeLayout licenseBorder;
    public ImageButton licenseButton;
    public boolean livelinessDetected;
    public byte[] mData;
    public CascadeClassifier mEyesCascade;
    public CascadeClassifier mFaceCascade;
    public CascadeClassifier mLeftEyeCascade;
    public PictureCallback mPicture;
    public CameraPreview mPreview;
    public CascadeClassifier mRightEyeCascade;
    public AlertDialog msgAlert;
    public Options options;
    public TextView overlayText;
    public RelativeLayout passportBorder;
    public ImageButton passportButton;
    public int permissionsCount = 0;
    public ScreenCompat screenCompat;
    public TextView selectionText;
    public RelativeLayout selfieBorder;
    public TextView tapText;
    public LinearLayout topLayout;

    static {
        boolean initDebug = TypeUtilsKt.initDebug();
    }

    public CameraActivity() {
        Constants constants2 = Constants.ourInstance;
        this.constants = constants2;
        Objects.requireNonNull(constants2);
        this.cardType = "driverLicense";
        this.deviceRotation = -1;
        this.cameraButton = null;
        this.helpButton = null;
        this.passportButton = null;
        this.licenseButton = null;
        this.flashButton = null;
        this.selectionText = null;
        this.overlayText = null;
        this.tapText = null;
        this.selfieBorder = null;
        this.licenseBorder = null;
        this.passportBorder = null;
        this.topLayout = null;
        this.botLayout = null;
        this.borderLayout = null;
        this.livelinessDetected = false;
        this.mPicture = new PictureCallback() {
            /* JADX WARNING: Removed duplicated region for block: B:18:0x007f  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onPictureTaken(byte[] r9, android.hardware.Camera r10) {
                /*
                    r8 = this;
                    com.idology.cameralibrary.CameraActivity r10 = com.idology.cameralibrary.CameraActivity.this
                    r10.mData = r9
                    android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options
                    r0.<init>()
                    r1 = 1
                    r0.inJustDecodeBounds = r1
                    int r2 = r9.length
                    r3 = 0
                    android.graphics.BitmapFactory.decodeByteArray(r9, r3, r2, r0)
                    int r9 = r0.outWidth
                    float r9 = (float) r9
                    int r2 = r0.outHeight
                    float r2 = (float) r2
                L_0x0017:
                    r4 = 3000(0xbb8, float:4.204E-42)
                    float r4 = (float) r4
                    int r4 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
                    if (r4 <= 0) goto L_0x0028
                    double r4 = (double) r9
                    r6 = 4606281698874543309(0x3feccccccccccccd, double:0.9)
                    double r4 = r4 * r6
                    float r9 = (float) r4
                    goto L_0x0017
                L_0x0028:
                    int r4 = r0.outWidth
                    float r4 = (float) r4
                    float r4 = r4 / r9
                    int r9 = (int) r9
                    r0.outWidth = r9
                    float r2 = r2 / r4
                    int r9 = (int) r2
                    r0.outHeight = r9
                    r9 = 80
                    r0.inDensity = r9
                    r0.inMutable = r1
                    r0.inPurgeable = r1
                    r10.options = r0
                    int r9 = com.idology.cameralibrary.CameraActivity.retryCount
                    r10 = 3
                    if (r9 >= r10) goto L_0x00be
                    com.idology.cameralibrary.CameraActivity r9 = com.idology.cameralibrary.CameraActivity.this
                    com.idology.cameralibrary.Constants r0 = r9.constants
                    com.idology.cameralibrary.Constants$CardCombination r0 = r0.combination
                    int r0 = r0.ordinal()
                    if (r0 == 0) goto L_0x0074
                    if (r0 == r1) goto L_0x006a
                    r2 = 2
                    if (r0 == r2) goto L_0x007d
                    if (r0 == r10) goto L_0x0074
                    r10 = 4
                    if (r0 == r10) goto L_0x007d
                    java.lang.String r10 = "Unknown document / side combination: "
                    java.lang.StringBuilder r10 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r10)
                    com.idology.cameralibrary.Constants r9 = r9.constants
                    com.idology.cameralibrary.Constants$CardCombination r9 = r9.combination
                    r10.append(r9)
                    r10.toString()
                    r1 = 0
                    goto L_0x007d
                L_0x006a:
                    int r10 = com.idology.cameralibrary.CameraActivity.retryCount
                    int r10 = r10 + r1
                    com.idology.cameralibrary.CameraActivity.retryCount = r10
                    boolean r1 = r9.badImageCheck()
                    goto L_0x007d
                L_0x0074:
                    int r10 = com.idology.cameralibrary.CameraActivity.retryCount
                    int r10 = r10 + r1
                    com.idology.cameralibrary.CameraActivity.retryCount = r10
                    boolean r1 = r9.badImageCheck()
                L_0x007d:
                    if (r1 != 0) goto L_0x00be
                    com.idology.cameralibrary.CameraActivity r9 = com.idology.cameralibrary.CameraActivity.this
                    com.idology.cameralibrary.Constants r10 = r9.constants
                    com.idology.utilities.ActivitySpinner r10 = r10.spinner
                    r10.cancel()
                    androidx.appcompat.app.AlertDialog$Builder r10 = new androidx.appcompat.app.AlertDialog$Builder
                    r10.<init>(r9)
                    com.idology.cameralibrary.Constants r0 = r9.constants
                    java.util.Objects.requireNonNull(r0)
                    androidx.appcompat.app.AlertController$AlertParams r0 = r10.P
                    java.lang.String r1 = "Please review the tips to take a better image"
                    r0.mMessage = r1
                    com.idology.cameralibrary.Constants r0 = r9.constants
                    java.util.Objects.requireNonNull(r0)
                    com.idology.cameralibrary.CameraActivity$5 r0 = new com.idology.cameralibrary.CameraActivity$5
                    r0.<init>()
                    androidx.appcompat.app.AlertController$AlertParams r1 = r10.P
                    java.lang.String r2 = "Okay"
                    r1.mPositiveButtonText = r2
                    r1.mPositiveButtonListener = r0
                    com.idology.cameralibrary.Constants r0 = r9.constants
                    java.util.Objects.requireNonNull(r0)
                    androidx.appcompat.app.AlertController$AlertParams r0 = r10.P
                    java.lang.String r1 = "There's a problem with this image"
                    r0.mTitle = r1
                    r0.mCancelable = r3
                    androidx.appcompat.app.AlertDialog r10 = r10.show()
                    r9.msgAlert = r10
                    goto L_0x00f2
                L_0x00be:
                    com.idology.cameralibrary.CameraActivity.retryCount = r3
                    android.content.Intent r9 = new android.content.Intent
                    com.idology.cameralibrary.CameraActivity r10 = com.idology.cameralibrary.CameraActivity.this
                    android.content.Context r10 = r10.getApplicationContext()
                    java.lang.Class<com.idology.cameralibrary.PreviewActivity> r0 = com.idology.cameralibrary.PreviewActivity.class
                    r9.<init>(r10, r0)
                    com.idology.cameralibrary.CameraActivity r10 = com.idology.cameralibrary.CameraActivity.this
                    byte[] r0 = r10.mData
                    com.idology.cameralibrary.PreviewActivity.mBitmapData = r0
                    android.graphics.BitmapFactory$Options r0 = r10.options
                    int r1 = r0.outHeight
                    com.idology.cameralibrary.PreviewActivity.mImageHeight = r1
                    int r1 = r0.outWidth
                    com.idology.cameralibrary.PreviewActivity.mImageWidth = r1
                    com.idology.cameralibrary.PreviewActivity.options = r0
                    r0 = 0
                    r10.mData = r0
                    com.idology.cameralibrary.CameraPreview r10 = r10.mPreview
                    android.view.SurfaceHolder r1 = r10.getHolder()
                    r10.surfaceDestroyed(r1)
                    com.idology.cameralibrary.CameraActivity r10 = com.idology.cameralibrary.CameraActivity.this
                    r10.mPreview = r0
                    r10.startActivity(r9)
                L_0x00f2:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.idology.cameralibrary.CameraActivity.AnonymousClass4.onPictureTaken(byte[], android.hardware.Camera):void");
            }
        };
    }

    public static void access$1000(CameraActivity cameraActivity, int i) {
        long j = (long) 300;
        cameraActivity.tapText.animate().setDuration(j);
        float f2 = (float) i;
        cameraActivity.tapText.animate().rotationBy(f2);
        cameraActivity.overlayText.animate().setDuration(j);
        cameraActivity.overlayText.animate().rotationBy(f2);
        cameraActivity.flashButton.animate().setDuration(j);
        cameraActivity.flashButton.animate().rotationBy(f2);
        cameraActivity.cameraButton.animate().setDuration(j);
        cameraActivity.cameraButton.animate().rotationBy(f2);
        cameraActivity.helpButton.animate().setDuration(j);
        cameraActivity.helpButton.animate().rotationBy(f2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:132:0x0728  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0786  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x07f8  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0881  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x04a4  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x04a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean badImageCheck() {
        /*
            r58 = this;
            r1 = r58
            byte[] r0 = r1.mData
            org.opencv.core.Mat r2 = new org.opencv.core.Mat
            int r3 = r0.length
            int r4 = org.opencv.core.CvType.CV_8UC1
            r5 = 1
            r2.<init>(r5, r3, r4)
            r3 = 0
            r2.put(r3, r3, r0)
            org.opencv.core.Mat r0 = new org.opencv.core.Mat
            long r4 = r2.nativeObj
            long r4 = org.opencv.imgcodecs.Imgcodecs.imdecode_0(r4, r3)
            r0.<init>(r4)
            com.idology.cameralibrary.Constants r2 = r1.constants
            java.lang.String r4 = r2.selectedSide
            java.util.Objects.requireNonNull(r2)
            java.lang.String r2 = "FRONT"
            boolean r2 = r4.equals(r2)
            java.lang.String r4 = "back"
            java.lang.String r5 = "front"
            if (r2 == 0) goto L_0x0031
            r2 = r5
            goto L_0x0032
        L_0x0031:
            r2 = r4
        L_0x0032:
            com.idology.idscan.check.IdImageCheckResult r6 = new com.idology.idscan.check.IdImageCheckResult
            r6.<init>(r2)
            com.idology.idscan.check.IdDocumentFinder r7 = new com.idology.idscan.check.IdDocumentFinder
            org.opencv.core.Mat r7 = new org.opencv.core.Mat
            r7.<init>()
            long r8 = r0.nativeObj
            long r10 = r7.nativeObj
            r12 = 0
            r14 = 4643176031446892544(0x406fe00000000000, double:255.0)
            r16 = 8
            double r23 = org.opencv.imgproc.Imgproc.threshold_0(r8, r10, r12, r14, r16)
            org.opencv.core.Mat r8 = new org.opencv.core.Mat
            r8.<init>()
            long r9 = r7.nativeObj
            long r11 = r8.nativeObj
            r13 = 4613937818241073152(0x4008000000000000, double:3.0)
            r15 = 4613937818241073152(0x4008000000000000, double:3.0)
            org.opencv.imgproc.Imgproc.blur_2(r9, r11, r13, r15)
            org.opencv.core.Mat r9 = new org.opencv.core.Mat
            r9.<init>()
            r10 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r21 = r23 * r10
            long r10 = r8.nativeObj
            long r12 = r9.nativeObj
            r17 = r10
            r19 = r12
            org.opencv.imgproc.Imgproc.Canny_1(r17, r19, r21, r23)
            org.opencv.core.Mat r8 = new org.opencv.core.Mat
            r8.<init>()
            int r10 = r0.rows()
            int r11 = r0.cols()
            int r10 = java.lang.Math.min(r10, r11)
            double r10 = (double) r10
            r12 = 4621819117588971520(0x4024000000000000, double:10.0)
            double r23 = r10 / r12
            r10 = 4616189618054758400(0x4010000000000000, double:4.0)
            double r25 = r23 / r10
            long r14 = r9.nativeObj
            long r10 = r8.nativeObj
            r18 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r20 = 4580687790476533049(0x3f91df46a2529d39, double:0.017453292519943295)
            r22 = 100
            r16 = r10
            org.opencv.imgproc.Imgproc.HoughLinesP_0(r14, r16, r18, r20, r22, r23, r25)
            int r10 = r8.cols()
            if (r10 <= 0) goto L_0x010f
            long r10 = r8.nativeObj
            int r10 = org.opencv.core.Mat.n_channels(r10)
            long r10 = (long) r10
            long r12 = r8.total()
            long r12 = r12 * r10
            int r10 = (int) r12
            int[] r10 = new int[r10]
            r8.get(r3, r3, r10)
            r11 = 2147483647(0x7fffffff, float:NaN)
            r12 = -2147483648(0xffffffff80000000, float:-0.0)
            r13 = 2147483647(0x7fffffff, float:NaN)
            r14 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x00c2:
            int r15 = r8.cols()
            if (r3 >= r15) goto L_0x0105
            int r15 = r3 * 4
            r16 = r8
            r8 = r10[r15]
            int r17 = r15 + 1
            r1 = r10[r17]
            int r17 = r15 + 2
            r18 = r4
            r4 = r10[r17]
            int r15 = r15 + 3
            r15 = r10[r15]
            int r8 = java.lang.Math.min(r8, r4)
            int r11 = java.lang.Math.min(r11, r8)
            int r4 = java.lang.Math.max(r4, r4)
            int r14 = java.lang.Math.max(r14, r4)
            int r4 = java.lang.Math.min(r1, r15)
            int r13 = java.lang.Math.min(r13, r4)
            int r1 = java.lang.Math.max(r1, r15)
            int r12 = java.lang.Math.max(r12, r1)
            int r3 = r3 + 1
            r1 = r58
            r8 = r16
            r4 = r18
            goto L_0x00c2
        L_0x0105:
            r18 = r4
            org.opencv.core.Rect r1 = new org.opencv.core.Rect
            int r14 = r14 - r11
            int r12 = r12 - r13
            r1.<init>(r11, r13, r14, r12)
            goto L_0x011f
        L_0x010f:
            r18 = r4
            org.opencv.core.Rect r1 = new org.opencv.core.Rect
            int r3 = r0.cols()
            int r4 = r0.rows()
            r8 = 0
            r1.<init>(r8, r8, r3, r4)
        L_0x011f:
            int r3 = r9.cols()
            r4 = 1
            int r3 = r3 - r4
            double r10 = (double) r3
            r25 = r10
            r27 = 0
            org.opencv.core.Scalar r3 = com.idology.idscan.check.IdDocumentFinder.WHITE
            long r10 = r9.nativeObj
            r19 = r10
            double[] r3 = r3.val
            r8 = 0
            r29 = r3[r8]
            r31 = r3[r4]
            r4 = 2
            r33 = r3[r4]
            r8 = 3
            r35 = r3[r8]
            r21 = 0
            r41 = 0
            r23 = 0
            org.opencv.imgproc.Imgproc.line_2(r19, r21, r23, r25, r27, r29, r31, r33, r35)
            int r3 = r9.cols()
            r8 = 1
            int r3 = r3 - r8
            double r10 = (double) r3
            r39 = r10
            int r3 = r9.cols()
            int r3 = r3 - r8
            double r10 = (double) r3
            r43 = r10
            int r3 = r9.rows()
            int r3 = r3 - r8
            double r10 = (double) r3
            r45 = r10
            org.opencv.core.Scalar r3 = com.idology.idscan.check.IdDocumentFinder.WHITE
            long r10 = r9.nativeObj
            r37 = r10
            double[] r3 = r3.val
            r10 = 0
            r47 = r3[r10]
            r49 = r3[r8]
            r51 = r3[r4]
            r10 = 3
            r53 = r3[r10]
            org.opencv.imgproc.Imgproc.line_2(r37, r39, r41, r43, r45, r47, r49, r51, r53)
            int r3 = r9.cols()
            int r3 = r3 - r8
            double r10 = (double) r3
            r21 = r10
            int r3 = r9.rows()
            int r3 = r3 - r8
            double r10 = (double) r3
            r23 = r10
            r25 = 0
            int r3 = r9.rows()
            int r3 = r3 - r8
            double r10 = (double) r3
            r27 = r10
            org.opencv.core.Scalar r3 = com.idology.idscan.check.IdDocumentFinder.WHITE
            long r10 = r9.nativeObj
            r19 = r10
            double[] r3 = r3.val
            r10 = 0
            r29 = r3[r10]
            r31 = r3[r8]
            r33 = r3[r4]
            r10 = 3
            r35 = r3[r10]
            org.opencv.imgproc.Imgproc.line_2(r19, r21, r23, r25, r27, r29, r31, r33, r35)
            r39 = 0
            int r3 = r9.rows()
            int r3 = r3 - r8
            double r10 = (double) r3
            r41 = r10
            r43 = 0
            r45 = 0
            org.opencv.core.Scalar r3 = com.idology.idscan.check.IdDocumentFinder.WHITE
            long r10 = r9.nativeObj
            r37 = r10
            double[] r3 = r3.val
            r8 = 0
            r47 = r3[r8]
            r8 = 1
            r49 = r3[r8]
            r51 = r3[r4]
            r8 = 3
            r53 = r3[r8]
            org.opencv.imgproc.Imgproc.line_2(r37, r39, r41, r43, r45, r47, r49, r51, r53)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            org.opencv.core.Mat r8 = new org.opencv.core.Mat
            r8.<init>()
            org.opencv.core.Mat r10 = new org.opencv.core.Mat
            r10.<init>()
            r11 = 5
            double r11 = (double) r11
            double r13 = (double) r4
            org.opencv.core.Mat r4 = new org.opencv.core.Mat
            r19 = 0
            r20 = r11
            r22 = r11
            r24 = r13
            r26 = r13
            long r11 = org.opencv.imgproc.Imgproc.getStructuringElement_0(r19, r20, r22, r24, r26)
            r4.<init>(r11)
            long r11 = r9.nativeObj
            long r13 = r10.nativeObj
            r15 = r5
            long r4 = r4.nativeObj
            r19 = r11
            r21 = r13
            r23 = r4
            org.opencv.imgproc.Imgproc.dilate_2(r19, r21, r23)
            r25 = 3
            r26 = 2
            org.opencv.core.Mat r4 = new org.opencv.core.Mat
            r4.<init>()
            long r10 = r10.nativeObj
            long r12 = r4.nativeObj
            r5 = r15
            long r14 = r8.nativeObj
            r19 = r10
            r21 = r12
            r23 = r14
            org.opencv.imgproc.Imgproc.findContours_1(r19, r21, r23, r25, r26)
            java.util.ArrayList r10 = new java.util.ArrayList
            int r11 = r4.rows()
            r10.<init>(r11)
            int r11 = r4.rows()
            int r12 = org.opencv.core.CvType.CV_32SC2
            int r13 = r4.type()
            if (r12 != r13) goto L_0x08a1
            int r12 = r4.cols()
            r13 = 1
            if (r12 != r13) goto L_0x08a1
            r10.clear()
            int r12 = r11 * 2
            int[] r12 = new int[r12]
            r13 = 0
            r4.get(r13, r13, r12)
        L_0x023c:
            r14 = 32
            if (r13 >= r11) goto L_0x026a
            int r15 = r13 * 2
            r16 = r5
            r5 = r12[r15]
            r17 = r0
            r19 = r1
            long r0 = (long) r5
            long r0 = r0 << r14
            int r15 = r15 + 1
            r5 = r12[r15]
            long r14 = (long) r5
            r20 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r14 = r14 & r20
            long r0 = r0 | r14
            org.opencv.core.Mat r5 = new org.opencv.core.Mat
            r5.<init>(r0)
            r10.add(r5)
            int r13 = r13 + 1
            r5 = r16
            r0 = r17
            r1 = r19
            goto L_0x023c
        L_0x026a:
            r17 = r0
            r19 = r1
            r16 = r5
            java.util.Iterator r0 = r10.iterator()
        L_0x0274:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x028e
            java.lang.Object r1 = r0.next()
            org.opencv.core.Mat r1 = (org.opencv.core.Mat) r1
            org.opencv.core.MatOfPoint r5 = new org.opencv.core.MatOfPoint
            r5.<init>(r1)
            r3.add(r5)
            long r11 = r1.nativeObj
            org.opencv.core.Mat.n_release(r11)
            goto L_0x0274
        L_0x028e:
            r10.clear()
            long r0 = r4.nativeObj
            org.opencv.core.Mat.n_release(r0)
            long r0 = r8.nativeObj
            int r0 = org.opencv.core.Mat.n_channels(r0)
            long r0 = (long) r0
            long r4 = r8.total()
            long r4 = r4 * r0
            int r0 = (int) r4
            int[] r1 = new int[r0]
            r4 = 0
            r8.get(r4, r4, r1)
            int r4 = r7.rows()
            int r5 = r7.cols()
            int r5 = r5 * r4
            boolean r4 = r8.empty()
            r12 = -1
            if (r4 != 0) goto L_0x05d5
            r4 = 0
            r15 = 0
            r20 = 4636033603912859648(0x4056800000000000, double:90.0)
            r13 = -1
            r24 = 0
        L_0x02c6:
            if (r4 == r12) goto L_0x04e1
            org.opencv.core.MatOfPoint2f r12 = new org.opencv.core.MatOfPoint2f
            r12.<init>()
            java.lang.Object r26 = r3.get(r4)
            r10 = r26
            org.opencv.core.MatOfPoint r10 = (org.opencv.core.MatOfPoint) r10
            int r11 = org.opencv.core.CvType.CV_32FC2
            r26 = r6
            r29 = r7
            long r6 = r10.nativeObj
            r10 = r2
            r30 = r3
            long r2 = r12.nativeObj
            org.opencv.core.Mat.n_convertTo(r6, r2, r11)
            long r2 = r12.nativeObj
            r6 = 0
            double r2 = org.opencv.imgproc.Imgproc.contourArea_0(r2, r6)
            org.opencv.core.MatOfPoint2f r6 = new org.opencv.core.MatOfPoint2f
            r6.<init>()
            int r7 = (r2 > r24 ? 1 : (r2 == r24 ? 0 : -1))
            if (r7 <= 0) goto L_0x0494
            r31 = 4606732058837280358(0x3fee666666666666, double:0.95)
            r7 = r10
            double r10 = (double) r5
            double r10 = r10 * r31
            int r31 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r31 >= 0) goto L_0x048a
            long r10 = r12.nativeObj
            r31 = r2
            r2 = 1
            double r2 = org.opencv.imgproc.Imgproc.arcLength_0(r10, r2)
            r10 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            double r37 = r2 * r10
            r39 = 1
            long r2 = r12.nativeObj
            long r10 = r6.nativeObj
            r33 = r2
            r35 = r10
            org.opencv.imgproc.Imgproc.approxPolyDP_0(r33, r35, r37, r39)
            org.opencv.core.Point[] r2 = r6.toArray()
            boolean r3 = r6.empty()
            if (r3 != 0) goto L_0x032f
            org.opencv.core.Point[] r3 = r6.toArray()
            int r3 = r3.length
            goto L_0x0330
        L_0x032f:
            r3 = 0
        L_0x0330:
            r6 = 4
            if (r3 != r6) goto L_0x048a
            long r13 = (long) r4
            org.opencv.core.RotatedRect r3 = new org.opencv.core.RotatedRect
            long r10 = r12.nativeObj
            double[] r6 = org.opencv.imgproc.Imgproc.minAreaRect_0(r10)
            r3.<init>(r6)
            org.opencv.core.Scalar r6 = new org.opencv.core.Scalar
            r34 = 4643176031446892544(0x406fe00000000000, double:255.0)
            r36 = 4643176031446892544(0x406fe00000000000, double:255.0)
            r38 = 4643176031446892544(0x406fe00000000000, double:255.0)
            r40 = 4643176031446892544(0x406fe00000000000, double:255.0)
            r33 = r6
            r33.<init>(r34, r36, r38, r40)
            int r10 = r2.length
            if (r10 != 0) goto L_0x036e
            r56 = r1
            r25 = r3
            r35 = r5
            r34 = r7
            r33 = r8
            r20 = r13
            r2 = 0
            r8 = r0
            goto L_0x0481
        L_0x036e:
            int r10 = r2.length
            r11 = 3
            int[] r11 = new int[r11]
            r12 = 2
            r11[r12] = r12
            r15 = 1
            r11[r15] = r12
            r12 = 0
            r11[r12] = r10
            java.lang.Class<int> r12 = int.class
            java.lang.Object r11 = java.lang.reflect.Array.newInstance(r12, r11)
            int[][][] r11 = (int[][][]) r11
            r12 = 0
        L_0x0384:
            if (r12 >= r10) goto L_0x03f7
            r15 = r2[r12]
            r20 = r13
            double r13 = r15.x
            int r13 = (int) r13
            r14 = r2[r12]
            double r14 = r14.y
            int r14 = (int) r14
            int r15 = r12 + 1
            int r24 = r15 % r10
            r25 = r3
            r3 = r2[r24]
            r34 = r7
            r33 = r8
            double r7 = r3.x
            int r3 = (int) r7
            r7 = r2[r24]
            double r7 = r7.y
            int r7 = (int) r7
            r8 = r0
            r56 = r1
            double r0 = (double) r13
            r37 = r0
            double r0 = (double) r14
            r39 = r0
            double r0 = (double) r3
            r41 = r0
            double r0 = (double) r7
            r43 = r0
            long r0 = r9.nativeObj
            r35 = r0
            double[] r0 = r6.val
            r1 = 0
            r45 = r0[r1]
            r1 = 1
            r47 = r0[r1]
            r1 = 2
            r49 = r0[r1]
            r1 = 3
            r51 = r0[r1]
            r53 = 4
            r54 = 8
            r55 = 0
            org.opencv.imgproc.Imgproc.line_0(r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r54, r55)
            r0 = r11[r12]
            r1 = 0
            r0 = r0[r1]
            r0[r1] = r13
            r0 = r11[r12]
            r0 = r0[r1]
            r13 = 1
            r0[r13] = r14
            r0 = r11[r12]
            r0 = r0[r13]
            r0[r1] = r3
            r0 = r11[r12]
            r0 = r0[r13]
            r0[r13] = r7
            r0 = r8
            r12 = r15
            r13 = r20
            r3 = r25
            r8 = r33
            r7 = r34
            r1 = r56
            goto L_0x0384
        L_0x03f7:
            r56 = r1
            r25 = r3
            r34 = r7
            r33 = r8
            r20 = r13
            r8 = r0
            r0 = 1
            r1 = 0
            r2 = 0
        L_0x0406:
            if (r1 >= r10) goto L_0x047f
            r6 = r11[r1]
            int r1 = r1 + 1
            int r7 = r1 % r10
            r7 = r11[r7]
            r12 = r6[r0]
            r13 = 0
            r12 = r12[r13]
            r14 = r6[r13]
            r13 = r14[r13]
            int r12 = r12 - r13
            double r12 = (double) r12
            r14 = r6[r0]
            r14 = r14[r0]
            r15 = 0
            r6 = r6[r15]
            r6 = r6[r0]
            int r14 = r14 - r6
            r35 = r5
            double r5 = (double) r14
            r14 = r7[r0]
            r14 = r14[r15]
            r24 = r7[r15]
            r24 = r24[r15]
            int r14 = r14 - r24
            r24 = r10
            r36 = r11
            double r10 = (double) r14
            r14 = r7[r0]
            r14 = r14[r0]
            r7 = r7[r15]
            r0 = r7[r0]
            int r14 = r14 - r0
            double r14 = (double) r14
            double r37 = r12 * r12
            double r39 = r5 * r5
            double r39 = r39 + r37
            double r37 = java.lang.Math.sqrt(r39)
            double r39 = r10 * r10
            double r41 = r14 * r14
            double r41 = r41 + r39
            double r39 = java.lang.Math.sqrt(r41)
            double r12 = r12 / r37
            double r5 = r5 / r37
            double r10 = r10 / r39
            double r14 = r14 / r39
            double r12 = r12 * r10
            double r5 = r5 * r14
            double r5 = r5 + r12
            double r5 = java.lang.Math.acos(r5)
            r10 = 4640537203540230144(0x4066800000000000, double:180.0)
            double r5 = r5 * r10
            r10 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            double r5 = r5 / r10
            double r2 = java.lang.Math.max(r2, r5)
            r0 = 1
            r10 = r24
            r5 = r35
            r11 = r36
            goto L_0x0406
        L_0x047f:
            r35 = r5
        L_0x0481:
            r13 = r20
            r15 = r25
            r24 = r31
            r20 = r2
            goto L_0x049d
        L_0x048a:
            r56 = r1
            r35 = r5
            r34 = r7
            r33 = r8
        L_0x0492:
            r8 = r0
            goto L_0x049d
        L_0x0494:
            r56 = r1
            r35 = r5
            r33 = r8
            r34 = r10
            goto L_0x0492
        L_0x049d:
            int r0 = r4 * 4
            r0 = r56[r0]
            r1 = -1
            if (r0 == r1) goto L_0x04a6
            r4 = r0
            goto L_0x04cf
        L_0x04a6:
            r0 = 0
            r2 = -1
        L_0x04a8:
            if (r4 == r1) goto L_0x04cd
            int r3 = r8 / 4
            if (r0 >= r3) goto L_0x04cd
            int r3 = r4 * 4
            int r5 = r3 + 2
            r5 = r56[r5]
            if (r5 == r1) goto L_0x04ba
            if (r5 == r2) goto L_0x04ba
            r4 = r5
            goto L_0x04cf
        L_0x04ba:
            int r2 = r3 + 1
            r2 = r56[r2]
            if (r2 == r1) goto L_0x04c1
            goto L_0x04c5
        L_0x04c1:
            int r3 = r3 + 3
            r2 = r56[r3]
        L_0x04c5:
            int r0 = r0 + 1
            r57 = r4
            r4 = r2
            r2 = r57
            goto L_0x04a8
        L_0x04cd:
            r0 = -1
            r4 = -1
        L_0x04cf:
            r12 = -1
            r0 = r8
            r6 = r26
            r7 = r29
            r3 = r30
            r8 = r33
            r2 = r34
            r5 = r35
            r1 = r56
            goto L_0x02c6
        L_0x04e1:
            r34 = r2
            r30 = r3
            r26 = r6
            r29 = r7
            r33 = r8
            r0 = 0
            int r2 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x05d1
            int r0 = (int) r13
            org.opencv.core.Scalar r1 = com.idology.idscan.check.IdDocumentFinder.WHITE
            r48 = 4
            r49 = 8
            r52 = 16
            r53 = 0
            r55 = 0
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = r30.size()
            r2.<init>(r3)
            int r3 = r30.size()
            if (r3 <= 0) goto L_0x05ab
            java.util.Iterator r3 = r30.iterator()
        L_0x0511:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0521
            java.lang.Object r4 = r3.next()
            org.opencv.core.MatOfPoint r4 = (org.opencv.core.MatOfPoint) r4
            r2.add(r4)
            goto L_0x0511
        L_0x0521:
            int r3 = r2.size()
            if (r3 <= 0) goto L_0x05a5
            org.opencv.core.Mat r4 = new org.opencv.core.Mat
            int r5 = org.opencv.core.CvType.CV_32SC2
            r6 = 1
            r4.<init>(r3, r6, r5)
            int r5 = r3 * 2
            int[] r6 = new int[r5]
            r7 = 0
        L_0x0534:
            if (r7 >= r3) goto L_0x055a
            java.lang.Object r8 = r2.get(r7)
            org.opencv.core.Mat r8 = (org.opencv.core.Mat) r8
            long r10 = r8.nativeObj
            int r8 = r7 * 2
            r12 = 32
            r30 = r2
            r31 = r3
            long r2 = r10 >> r12
            int r3 = (int) r2
            r6[r8] = r3
            int r8 = r8 + 1
            r2 = -1
            long r10 = r10 & r2
            int r11 = (int) r10
            r6[r8] = r11
            int r7 = r7 + 1
            r2 = r30
            r3 = r31
            goto L_0x0534
        L_0x055a:
            r37 = 0
            r38 = 0
            int r2 = r4.type()
            int r3 = org.opencv.core.CvType.channels(r2)
            int r3 = r5 % r3
            if (r3 != 0) goto L_0x0587
            r3 = r2 & 7
            r7 = 4
            if (r3 != r7) goto L_0x057b
            long r2 = r4.nativeObj
            r35 = r2
            r39 = r5
            r40 = r6
            org.opencv.core.Mat.nPutI(r35, r37, r38, r39, r40)
            goto L_0x05b0
        L_0x057b:
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
            java.lang.String r1 = "Mat data type is not compatible: "
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline41(r1, r2)
            r0.<init>(r1)
            throw r0
        L_0x0587:
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
            java.lang.String r1 = "Provided data element number ("
            java.lang.String r3 = ") should be multiple of the Mat channels count ("
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline74(r1, r5, r3)
            int r2 = org.opencv.core.CvType.channels(r2)
            r1.append(r2)
            java.lang.String r2 = ")"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x05a5:
            org.opencv.core.Mat r4 = new org.opencv.core.Mat
            r4.<init>()
            goto L_0x05b0
        L_0x05ab:
            org.opencv.core.Mat r4 = new org.opencv.core.Mat
            r4.<init>()
        L_0x05b0:
            long r2 = r9.nativeObj
            r35 = r2
            long r2 = r4.nativeObj
            r37 = r2
            double[] r1 = r1.val
            r2 = 0
            r40 = r1[r2]
            r2 = 1
            r42 = r1[r2]
            r2 = 2
            r44 = r1[r2]
            r2 = 3
            r46 = r1[r2]
            r1 = r33
            long r1 = r1.nativeObj
            r50 = r1
            r39 = r0
            org.opencv.imgproc.Imgproc.drawContours_0(r35, r37, r39, r40, r42, r44, r46, r48, r49, r50, r52, r53, r55)
        L_0x05d1:
            r10 = r13
            r0 = r20
            goto L_0x05e8
        L_0x05d5:
            r34 = r2
            r26 = r6
            r29 = r7
            r2 = -1
            r20 = 4636033603912859648(0x4056800000000000, double:90.0)
            r15 = 0
            r10 = r2
            r0 = r20
            r24 = 0
        L_0x05e8:
            int r2 = r9.rows()
            int r3 = r9.cols()
            int r3 = r3 * r2
            double r2 = (double) r3
            r4 = 4621819117588971520(0x4024000000000000, double:10.0)
            double r2 = r2 / r4
            float r2 = (float) r2
            r3 = 0
            int r5 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x06d6
            double r2 = (double) r2
            int r4 = (r24 > r2 ? 1 : (r24 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x06d6
            int r2 = r29.cols()
            int r3 = r29.rows()
            r4 = r26
            r4.imageWidth = r2
            r4.imageHeight = r3
            org.opencv.core.Rect r2 = r15.boundingRect()
            int r2 = r2.width
            org.opencv.core.Rect r3 = r15.boundingRect()
            int r3 = r3.height
            r4.documentWidth = r2
            r4.documentHeight = r3
            org.opencv.core.Scalar r2 = new org.opencv.core.Scalar
            r25 = 4643176031446892544(0x406fe00000000000, double:255.0)
            r27 = 4643176031446892544(0x406fe00000000000, double:255.0)
            r29 = 4643176031446892544(0x406fe00000000000, double:255.0)
            r31 = 4643176031446892544(0x406fe00000000000, double:255.0)
            r24 = r2
            r24.<init>(r25, r27, r29, r31)
            r3 = 2
            r5 = 8
            r6 = 0
            r7 = 4
            org.opencv.core.Point[] r8 = new org.opencv.core.Point[r7]
            r15.points(r8)
            r10 = 0
        L_0x0646:
            if (r10 >= r7) goto L_0x0689
            r7 = r8[r10]
            double r11 = r7.x
            int r7 = (int) r11
            double r11 = (double) r7
            r37 = r11
            r7 = r8[r10]
            double r11 = r7.y
            int r7 = (int) r11
            double r11 = (double) r7
            r39 = r11
            int r10 = r10 + 1
            int r7 = r10 % 4
            r11 = r8[r7]
            double r11 = r11.x
            int r11 = (int) r11
            double r11 = (double) r11
            r41 = r11
            r7 = r8[r7]
            double r11 = r7.y
            int r7 = (int) r11
            double r11 = (double) r7
            r43 = r11
            long r11 = r9.nativeObj
            r35 = r11
            double[] r7 = r2.val
            r11 = 0
            r45 = r7[r11]
            r11 = 1
            r47 = r7[r11]
            r11 = 2
            r49 = r7[r11]
            r11 = 3
            r51 = r7[r11]
            r53 = r3
            r54 = r5
            r55 = r6
            org.opencv.imgproc.Imgproc.line_0(r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r54, r55)
            r7 = 4
            goto L_0x0646
        L_0x0689:
            r2 = 0
            r3 = 0
        L_0x068b:
            r5 = 4
            if (r2 >= r5) goto L_0x06d1
            r5 = r8[r2]
            int r6 = r9.rows()
            int r7 = r9.cols()
            int r6 = java.lang.Math.max(r6, r7)
            double r6 = (double) r6
            r10 = 4581421828931458171(0x3f947ae147ae147b, double:0.02)
            double r6 = r6 * r10
            int r6 = (int) r6
            double r10 = r5.x
            double r12 = (double) r6
            r14 = 0
            double r12 = r14 - r12
            int r7 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r7 < 0) goto L_0x06cc
            int r7 = r9.cols()
            int r7 = r7 + r6
            double r14 = (double) r7
            int r7 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r7 > 0) goto L_0x06cc
            double r10 = r5.y
            int r5 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r5 < 0) goto L_0x06cc
            int r5 = r9.rows()
            int r5 = r5 + r6
            double r5 = (double) r5
            int r7 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r7 > 0) goto L_0x06cc
            r5 = 1
            goto L_0x06cd
        L_0x06cc:
            r5 = 0
        L_0x06cd:
            int r3 = r3 + r5
            int r2 = r2 + 1
            goto L_0x068b
        L_0x06d1:
            r4.cornersLocated = r3
            r4.maxCornerAngle = r0
            goto L_0x06f8
        L_0x06d6:
            r4 = r26
            int r0 = r29.cols()
            int r1 = r29.rows()
            r4.imageWidth = r0
            r4.imageHeight = r1
            r1 = r19
            int r0 = r1.width
            int r1 = r1.height
            r4.documentWidth = r0
            r4.documentHeight = r1
            r0 = 4
            r4.cornersLocated = r0
            r0 = 4636033603912859648(0x4056800000000000, double:90.0)
            r4.maxCornerAngle = r0
        L_0x06f8:
            int r0 = r34.hashCode()
            r1 = 3015911(0x2e04e7, float:4.226191E-39)
            if (r0 == r1) goto L_0x0717
            r1 = 97705513(0x5d2de29, float:1.9829914E-35)
            if (r0 == r1) goto L_0x070b
            r1 = r16
            r5 = r34
            goto L_0x0725
        L_0x070b:
            r1 = r16
            r5 = r34
            boolean r0 = r5.equals(r1)
            if (r0 == 0) goto L_0x0725
            r0 = 0
            goto L_0x0726
        L_0x0717:
            r1 = r16
            r0 = r18
            r5 = r34
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0725
            r0 = 1
            goto L_0x0726
        L_0x0725:
            r0 = -1
        L_0x0726:
            if (r0 == 0) goto L_0x0786
            r2 = 1
            if (r0 == r2) goto L_0x072f
            r2 = r58
            goto L_0x07e9
        L_0x072f:
            r2 = r58
            android.graphics.BitmapFactory$Options r0 = r2.options
            byte[] r3 = r2.mData
            r6 = 160(0xa0, float:2.24E-43)
            r0.inDensity = r6
            r6 = 2
            r0.inSampleSize = r6
            r6 = 0
            r0.inJustDecodeBounds = r6
            int r7 = r3.length
            android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeByteArray(r3, r6, r7, r0)
            int r14 = r0.outWidth
            int r15 = r0.outHeight
            int r6 = r14 * r15
            int[] r6 = new int[r6]
            r10 = 0
            r12 = 0
            r13 = 0
            r8 = r3
            r9 = r6
            r11 = r14
            r8.getPixels(r9, r10, r11, r12, r13, r14, r15)
            com.google.zxing.RGBLuminanceSource r7 = new com.google.zxing.RGBLuminanceSource
            int r8 = r0.outWidth
            int r0 = r0.outHeight
            r7.<init>(r8, r0, r6)
            r3.recycle()
            com.google.zxing.BinaryBitmap r0 = new com.google.zxing.BinaryBitmap
            com.google.zxing.common.HybridBinarizer r3 = new com.google.zxing.common.HybridBinarizer
            r3.<init>(r7)
            r0.<init>(r3)
            com.google.zxing.pdf417.PDF417Reader r3 = new com.google.zxing.pdf417.PDF417Reader     // Catch:{ NotFoundException -> 0x0782, Exception -> 0x077e }
            r3.<init>()     // Catch:{ NotFoundException -> 0x0782, Exception -> 0x077e }
            com.google.zxing.Result r0 = r3.decode(r0)     // Catch:{ NotFoundException -> 0x0782, Exception -> 0x077e }
            java.lang.String r0 = r0.text     // Catch:{ NotFoundException -> 0x0782, Exception -> 0x077e }
            int r0 = r0.length()     // Catch:{ NotFoundException -> 0x0782, Exception -> 0x077e }
            if (r0 <= 0) goto L_0x0782
            r0 = 1
            goto L_0x0783
        L_0x077e:
            r0 = move-exception
            r0.getMessage()
        L_0x0782:
            r0 = 0
        L_0x0783:
            r4.barcodeLocated = r0
            goto L_0x07e9
        L_0x0786:
            r2 = r58
            org.opencv.objdetect.CascadeClassifier r0 = r2.mFaceCascade
            org.opencv.core.MatOfRect r3 = new org.opencv.core.MatOfRect
            r3.<init>()
            int r6 = r17.cols()
            int r7 = r17.rows()
            int r6 = java.lang.Math.min(r6, r7)
            double r6 = (double) r6
            r8 = 4621819117588971520(0x4024000000000000, double:10.0)
            double r6 = r6 / r8
            long r6 = java.lang.Math.round(r6)
            int r7 = (int) r6
            int r6 = r17.cols()
            int r8 = r17.rows()
            int r6 = java.lang.Math.max(r6, r8)
            double r8 = (double) r6
            r10 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r8 = r8 / r10
            long r8 = java.lang.Math.round(r8)
            int r6 = (int) r8
            double r7 = (double) r7
            r28 = r7
            r30 = r7
            double r6 = (double) r6
            r32 = r6
            r34 = r6
            long r6 = r0.nativeObj
            r18 = r6
            r0 = r17
            long r6 = r0.nativeObj
            r20 = r6
            long r6 = r3.nativeObj
            r22 = r6
            r24 = 4608083138725491507(0x3ff3333333333333, double:1.2)
            r26 = 5
            r27 = 2
            org.opencv.objdetect.CascadeClassifier.detectMultiScale_0(r18, r20, r22, r24, r26, r27, r28, r30, r32, r34)
            org.opencv.core.Rect[] r0 = r3.toArray()
            int r0 = r0.length
            if (r0 <= 0) goto L_0x07e6
            r0 = 1
            goto L_0x07e7
        L_0x07e6:
            r0 = 0
        L_0x07e7:
            r4.faceLocated = r0
        L_0x07e9:
            java.lang.String r0 = r2.cardType
            com.idology.cameralibrary.Constants r3 = r2.constants
            java.util.Objects.requireNonNull(r3)
            java.lang.String r3 = "driverLicense"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0881
            com.idology.idscan.check.DuplexCardResultApprover r0 = new com.idology.idscan.check.DuplexCardResultApprover
            com.idology.cameralibrary.Constants r3 = r2.constants
            java.lang.String r3 = r3.selectedSide
            java.lang.String r6 = "USA"
            r0.<init>(r6, r3)
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x0813
            int r0 = r0.getFrontErrorCount(r4)
            if (r0 != 0) goto L_0x0811
            r0 = 1
            goto L_0x0812
        L_0x0811:
            r0 = 0
        L_0x0812:
            return r0
        L_0x0813:
            int r1 = retryCount
            boolean r3 = r4.imageError
            if (r3 == 0) goto L_0x081c
            r0 = 1
        L_0x081a:
            r1 = 1
            goto L_0x0874
        L_0x081c:
            r3 = 1
            if (r1 < r3) goto L_0x0879
            r3 = 3
            if (r1 > r3) goto L_0x0879
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            boolean r5 = r0.isDocumentTooSmall(r4)
            if (r5 == 0) goto L_0x0832
            java.lang.String r5 = "Document Too Small"
            r3.add(r5)
        L_0x0832:
            boolean r0 = r0.isBorderTooSmall(r4)
            if (r0 == 0) goto L_0x083d
            java.lang.String r0 = "Document Border Too Small"
            r3.add(r0)
        L_0x083d:
            int r0 = r4.cornersLocated
            r5 = 4
            if (r0 >= r5) goto L_0x0848
            java.lang.String r0 = "Document Missing Four Corners"
            r3.add(r0)
            goto L_0x085d
        L_0x0848:
            if (r0 <= r5) goto L_0x0850
            java.lang.String r0 = "Document Edge Not Detected"
            r3.add(r0)
            goto L_0x085d
        L_0x0850:
            double r5 = r4.maxCornerAngle
            r7 = 4636737291354636288(0x4059000000000000, double:100.0)
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 <= 0) goto L_0x085d
            java.lang.String r0 = "Document is Skewed"
            r3.add(r0)
        L_0x085d:
            boolean r0 = r4.barcodeLocated
            r4 = 1
            if (r0 != 0) goto L_0x086f
            if (r1 == r4) goto L_0x086a
            int r0 = r3.size()
            if (r0 <= 0) goto L_0x086f
        L_0x086a:
            java.lang.String r0 = "Barcode Not Detected"
            r3.add(r0)
        L_0x086f:
            int r0 = r3.size()
            goto L_0x081a
        L_0x0874:
            if (r0 != 0) goto L_0x0877
            goto L_0x0878
        L_0x0877:
            r1 = 0
        L_0x0878:
            return r1
        L_0x0879:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Attempted to check for back errors less than 1 or more than 3 times."
            r0.<init>(r1)
            throw r0
        L_0x0881:
            r0 = 1
            java.lang.String r1 = r2.cardType
            com.idology.cameralibrary.Constants r3 = r2.constants
            java.util.Objects.requireNonNull(r3)
            java.lang.String r3 = "passport"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x089f
            com.idology.idscan.check.PassportResultApprover r1 = new com.idology.idscan.check.PassportResultApprover
            r1.<init>()
            int r1 = r1.getFrontErrorCount(r4)
            if (r1 != 0) goto L_0x089d
            goto L_0x089e
        L_0x089d:
            r0 = 0
        L_0x089e:
            return r0
        L_0x089f:
            r0 = 0
            return r0
        L_0x08a1:
            r2 = r58
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "CvType.CV_32SC2 != m.type() ||  m.cols()!=1\n"
            r1.append(r3)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.idology.cameralibrary.CameraActivity.badImageCheck():boolean");
    }

    public final void callDelegate() {
        if (CameraLib.mCameraCallBack != null) {
            HashMap hashMap = new HashMap();
            String str = this.livelinessDetected ? BaseParser.TRUE : BaseParser.FALSE;
            Objects.requireNonNull(this.constants);
            hashMap.put(IdologyKycIdCapture.IDO_FRONT_IMAGE_KEY, this.constants.frontString);
            Objects.requireNonNull(this.constants);
            hashMap.put(IdologyKycIdCapture.IDO_BACK_IMAGE_KEY, this.constants.backString);
            Objects.requireNonNull(this.constants);
            hashMap.put("Selfie_Image", this.constants.selfieString);
            Objects.requireNonNull(this.constants);
            hashMap.put("Document_Type", this.cardType);
            Objects.requireNonNull(this.constants);
            hashMap.put("liveliness", str);
            CameraLib.mCameraCallBack.captureResults(hashMap);
        }
    }

    public void captureImage() {
        AlertDialog alertDialog = this.msgAlert;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        AlertDialog alertDialog2 = this.exitAlert;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
        AlertDialog alertDialog3 = this.constants.blinkDialog;
        if (alertDialog3 != null) {
            alertDialog3.dismiss();
        }
        this.constants.spinner.start();
        CameraPreview cameraPreview = this.mPreview;
        PictureCallback pictureCallback = this.mPicture;
        if (cameraPreview != null) {
            try {
                cameraPreview.mCamera.takePicture(null, null, pictureCallback);
            } catch (RuntimeException e2) {
                e2.getMessage();
            }
        } else {
            throw null;
        }
    }

    public final CascadeClassifier getCascadeClassifier(int i) throws IOException {
        String str;
        InputStream openRawResource = getResources().openRawResource(i);
        File dir = getDir("cascade", 0);
        TypedValue typedValue = new TypedValue();
        getResources().getValue(i, typedValue, true);
        CharSequence charSequence = typedValue.string;
        if (charSequence == null) {
            str = null;
        } else {
            str = charSequence.toString();
            int lastIndexOf = str.lastIndexOf(File.separator);
            if (lastIndexOf > -1 && lastIndexOf < str.length() - 1) {
                str = str.substring(lastIndexOf + 1);
            }
        }
        File file = new File(dir, str);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                int read = openRawResource.read(bArr);
                if (read == -1) {
                    return new CascadeClassifier(file.getAbsolutePath());
                }
                fileOutputStream.write(bArr, 0, read);
            } finally {
                openRawResource.close();
                fileOutputStream.close();
            }
        }
    }

    public final void getUserPermissions(Mode mode) {
        boolean z = ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0;
        String[] strArr = {"android.permission.CAMERA"};
        Constants constants2 = this.constants;
        int i = constants2.alertCount;
        if (i <= 0) {
            i = constants2.defaultAlertCount;
        }
        if (!z) {
            int i2 = this.permissionsCount;
            if (i2 < i) {
                this.permissionsCount = i2 + 1;
                ActivityCompat.requestPermissions(this, strArr, 1);
                return;
            }
        }
        if (z) {
            startCamera(mode);
        } else if (!z && this.permissionsCount >= 3) {
            this.constants.spinner.cancel();
            String str = this.constants.exitText.equals("") ? this.constants.defaultExitText : this.constants.exitText;
            Builder builder = new Builder(this);
            builder.P.mMessage = str;
            Objects.requireNonNull(this.constants);
            AnonymousClass6 r7 = new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    CameraActivity.this.finish();
                }
            };
            AlertParams alertParams = builder.P;
            alertParams.mPositiveButtonText = "Exit";
            alertParams.mPositiveButtonListener = r7;
            Objects.requireNonNull(this.constants);
            AlertParams alertParams2 = builder.P;
            alertParams2.mTitle = "Error";
            alertParams2.mCancelable = false;
            this.exitAlert = builder.show();
        }
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, -260465615, bundle);
    }

    public void onDestroy() {
        iIiIiIiIii.IiiiIiiiII(this, -116223082, new Object[0]);
    }

    public void onResume() {
        iIiIiIiIii.IiiiIiiiII(this, 562063702, new Object[0]);
    }

    public void openHelp(View view) {
        startActivity(new Intent(getApplicationContext(), HelpActivity.class));
    }

    public final void reqPermissions() {
        int ordinal = this.constants.combination.ordinal();
        if (ordinal == 0) {
            Constants constants2 = this.constants;
            Objects.requireNonNull(constants2);
            constants2.selectedSide = "FRONT";
            getUserPermissions(Mode.Front);
        } else if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal == 3) {
                    Constants constants3 = this.constants;
                    Objects.requireNonNull(constants3);
                    constants3.selectedSide = "FRONT";
                    if (!this.constants.frontString.equals("")) {
                        callDelegate();
                        finish();
                        return;
                    }
                    getUserPermissions(Mode.Front);
                    return;
                } else if (ordinal != 4) {
                    return;
                }
            }
            if (!this.constants.selfieString.equals("")) {
                callDelegate();
                finish();
                return;
            }
            Constants constants4 = this.constants;
            Objects.requireNonNull(constants4);
            constants4.selectedSide = "SELFIE";
            this.tapText.setVisibility(4);
            this.topLayout.setVisibility(4);
            if (Constants.ourInstance.livelinessEnabled) {
                TextView textView = this.overlayText;
                Objects.requireNonNull(this.constants);
                textView.setText("Blink to Take Selfie");
                this.botLayout.setVisibility(4);
            } else {
                TextView textView2 = this.overlayText;
                Objects.requireNonNull(this.constants);
                textView2.setText("Take Selfie Picture");
                this.botLayout.setVisibility(0);
            }
            this.selfieBorder.setVisibility(0);
            this.passportBorder.setVisibility(4);
            this.licenseBorder.setVisibility(4);
            ScreenCompat screenCompat2 = this.screenCompat;
            RelativeLayout relativeLayout = this.selfieBorder;
            screenCompat2.calculateLayoutSize(relativeLayout, 20.0f);
            this.selfieBorder = relativeLayout;
            getUserPermissions(Mode.Selfie);
        } else {
            Constants constants5 = this.constants;
            Objects.requireNonNull(constants5);
            constants5.selectedSide = "BACK";
            if (!this.constants.backString.equals("")) {
                callDelegate();
                finish();
                return;
            }
            getUserPermissions(Mode.Back);
            TextView textView3 = this.overlayText;
            Objects.requireNonNull(this.constants);
            textView3.setText("Take Back ID / License Picture");
            Constants constants6 = this.constants;
            Objects.requireNonNull(constants6);
            constants6.selectedSide = "BACK";
        }
    }

    public final void startCamera(final Mode mode) {
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.camera_preview);
        CameraPreview cameraPreview = this.mPreview;
        if (cameraPreview == null) {
            CameraPreview cameraPreview2 = new CameraPreview(this, mode, this.mFaceCascade, this.mEyesCascade, this.mLeftEyeCascade, this.mRightEyeCascade);
            this.mPreview = cameraPreview2;
            frameLayout.addView(cameraPreview2);
            runOnUiThread(new Runnable() {
                public void run() {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            if (mode.equals(Mode.Back)) {
                                CameraActivity cameraActivity = CameraActivity.this;
                                cameraActivity.mPreview.useFlash(cameraActivity.constants.defaultBackImageFlash, "torch");
                                CameraActivity.this.flashButton.setImageResource(R$drawable.flash);
                                CameraActivity.this.mPreview.setMode(Mode.Back);
                            }
                        }
                    }, 1000);
                }
            });
            if (!getPackageManager().hasSystemFeature("android.hardware.camera.flash")) {
                this.flashButton.setVisibility(4);
            }
            return;
        }
        frameLayout.removeView(cameraPreview);
        CameraPreview cameraPreview3 = this.mPreview;
        cameraPreview3.surfaceDestroyed(cameraPreview3.getHolder());
        this.mPreview = null;
        startCamera(mode);
    }

    public void toggleCardType(View view) {
        Constants constants2 = this.constants;
        if (constants2.documentType == CameraSdkSettings$DocumentType.Any) {
            retryCount = 0;
            String str = this.cardType;
            Objects.requireNonNull(constants2);
            if (str.equalsIgnoreCase("driverLicense")) {
                Objects.requireNonNull(this.constants);
                this.cardType = "passport";
                TextView textView = this.overlayText;
                Objects.requireNonNull(this.constants);
                textView.setText("Take Front ID / License Picture");
                this.passportButton.setImageResource(R$drawable.passport_selected);
                this.licenseButton.setImageResource(R$drawable.license_disabled);
                TextView textView2 = this.selectionText;
                Objects.requireNonNull(this.constants);
                textView2.setText("Passport Selected");
                TextView textView3 = this.overlayText;
                Objects.requireNonNull(this.constants);
                textView3.setText("Take Front Passport Picture");
                this.licenseButton.setEnabled(true);
                this.passportButton.setEnabled(false);
                this.passportBorder.setVisibility(0);
                this.licenseBorder.setVisibility(4);
                Constants constants3 = this.constants;
                constants3.frontString = "";
                constants3.combination = CardCombination.passportFront;
            } else {
                Objects.requireNonNull(this.constants);
                this.cardType = "driverLicense";
                this.passportButton.setImageResource(R$drawable.passport_disabled);
                this.licenseButton.setImageResource(R$drawable.license_selected);
                TextView textView4 = this.overlayText;
                Objects.requireNonNull(this.constants);
                textView4.setText("Take Front ID / License Picture");
                TextView textView5 = this.selectionText;
                Objects.requireNonNull(this.constants);
                textView5.setText("ID/License Selected");
                this.licenseButton.setEnabled(false);
                this.passportButton.setEnabled(true);
                this.licenseBorder.setVisibility(0);
                this.passportBorder.setVisibility(4);
                Constants constants4 = this.constants;
                if (constants4.frontString != "") {
                    TextView textView6 = this.overlayText;
                    Objects.requireNonNull(constants4);
                    textView6.setText("Take Back ID / License Picture");
                }
                this.constants.combination = CardCombination.licenseFront;
            }
            Constants constants5 = this.constants;
            Objects.requireNonNull(constants5);
            constants5.selectedSide = "FRONT";
        }
    }

    public void toggleFlash(View view) {
        Camera camera = this.mPreview.mCamera;
        if (camera != null && camera.getParameters().getFlashMode().equals("torch")) {
            this.mPreview.useFlash(false, "");
            this.flashButton.setImageResource(R$drawable.noflash);
            return;
        }
        this.mPreview.useFlash(true, "torch");
        this.flashButton.setImageResource(R$drawable.flash);
    }

    public void captureImage(View view) {
        AlertDialog alertDialog = this.msgAlert;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        AlertDialog alertDialog2 = this.exitAlert;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
        AlertDialog alertDialog3 = this.constants.blinkDialog;
        if (alertDialog3 != null) {
            alertDialog3.dismiss();
        }
        CameraPreview cameraPreview = this.mPreview;
        PictureCallback pictureCallback = this.mPicture;
        if (cameraPreview != null) {
            try {
                cameraPreview.mCamera.takePicture(null, null, pictureCallback);
            } catch (RuntimeException e2) {
                e2.getMessage();
            }
            this.constants.spinner.start();
            return;
        }
        throw null;
    }
}
