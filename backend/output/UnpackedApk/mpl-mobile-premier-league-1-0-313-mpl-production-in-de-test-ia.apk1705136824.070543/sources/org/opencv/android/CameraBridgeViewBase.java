package org.opencv.android;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Iterator;
import java.util.List;
import org.opencv.R$styleable;
import org.opencv.android.JavaCameraView.JavaCameraSizeAccessor;
import org.opencv.core.Mat;
import org.opencv.core.Size;

public abstract class CameraBridgeViewBase extends SurfaceView implements Callback {
    public Bitmap mCacheBitmap;
    public int mCameraIndex = -1;
    public FpsMeter mFpsMeter = null;
    public int mFrameHeight;
    public int mFrameWidth;
    public CvCameraViewListener2 mListener;
    public int mMaxHeight;
    public int mMaxWidth;
    public int mPreviewFormat = 1;
    public float mScale = 0.0f;
    public int mState = 0;
    public boolean mSurfaceExist;
    public Object mSyncObject = new Object();

    public interface CvCameraViewListener {
        Mat onCameraFrame(Mat mat);

        void onCameraViewStarted(int i, int i2);

        void onCameraViewStopped();
    }

    public interface CvCameraViewListener2 {
    }

    public class CvCameraViewListenerAdapter implements CvCameraViewListener2 {
        public CvCameraViewListener mOldStyleListener;
        public int mPreviewFormat = 1;

        public CvCameraViewListenerAdapter(CvCameraViewListener cvCameraViewListener) {
            this.mOldStyleListener = cvCameraViewListener;
        }
    }

    public interface ListItemAccessor {
    }

    public CameraBridgeViewBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int attributeCount = attributeSet.getAttributeCount();
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Attr count: ");
        outline73.append(Integer.valueOf(attributeCount));
        outline73.toString();
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.CameraBridgeViewBase);
        if (obtainStyledAttributes.getBoolean(R$styleable.CameraBridgeViewBase_show_fps, false) && this.mFpsMeter == null) {
            FpsMeter fpsMeter = new FpsMeter();
            this.mFpsMeter = fpsMeter;
            int i = this.mFrameWidth;
            int i2 = this.mFrameHeight;
            fpsMeter.mWidth = i;
            fpsMeter.mHeight = i2;
        }
        this.mCameraIndex = obtainStyledAttributes.getInt(R$styleable.CameraBridgeViewBase_camera_id, -1);
        getHolder().addCallback(this);
        this.mMaxWidth = -1;
        this.mMaxHeight = -1;
        obtainStyledAttributes.recycle();
    }

    public Size calculateCameraFrameSize(List<?> list, ListItemAccessor listItemAccessor, int i, int i2) {
        int i3 = this.mMaxWidth;
        if (i3 != -1 && i3 < i) {
            i = i3;
        }
        int i4 = this.mMaxHeight;
        if (i4 != -1 && i4 < i2) {
            i2 = i4;
        }
        Iterator<?> it = list.iterator();
        int i5 = 0;
        int i6 = 0;
        while (it.hasNext()) {
            JavaCameraSizeAccessor javaCameraSizeAccessor = (JavaCameraSizeAccessor) listItemAccessor;
            Camera.Size size = (Camera.Size) it.next();
            int i7 = size.width;
            int i8 = size.height;
            if (i7 <= i && i8 <= i2 && i7 >= i5 && i8 >= i6) {
                i6 = i8;
                i5 = i7;
            }
        }
        return new Size((double) i5, (double) i6);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void checkCurrentState() {
        /*
            r6 = this;
            int r0 = r6.mState
            if (r0 == 0) goto L_0x00f4
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 == r2) goto L_0x000a
            goto L_0x007a
        L_0x000a:
            r0 = r6
            org.opencv.android.JavaCameraView r0 = (org.opencv.android.JavaCameraView) r0
            r0.mStopThread = r2     // Catch:{ InterruptedException -> 0x0024 }
            monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0024 }
            r0.notify()     // Catch:{ all -> 0x001e }
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            java.lang.Thread r4 = r0.mThread     // Catch:{ InterruptedException -> 0x0024 }
            if (r4 == 0) goto L_0x0028
            java.lang.Thread r4 = r0.mThread     // Catch:{ InterruptedException -> 0x0024 }
            r4.join()     // Catch:{ InterruptedException -> 0x0024 }
            goto L_0x0028
        L_0x001e:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            throw r4     // Catch:{ InterruptedException -> 0x0024 }
        L_0x0021:
            r2 = move-exception
            goto L_0x00f1
        L_0x0024:
            r4 = move-exception
            r4.printStackTrace()     // Catch:{ all -> 0x0021 }
        L_0x0028:
            r0.mThread = r1
            monitor-enter(r0)
            android.hardware.Camera r4 = r0.mCamera     // Catch:{ all -> 0x00ee }
            if (r4 == 0) goto L_0x003e
            android.hardware.Camera r4 = r0.mCamera     // Catch:{ all -> 0x00ee }
            r4.stopPreview()     // Catch:{ all -> 0x00ee }
            android.hardware.Camera r4 = r0.mCamera     // Catch:{ all -> 0x00ee }
            r4.setPreviewCallback(r1)     // Catch:{ all -> 0x00ee }
            android.hardware.Camera r4 = r0.mCamera     // Catch:{ all -> 0x00ee }
            r4.release()     // Catch:{ all -> 0x00ee }
        L_0x003e:
            r0.mCamera = r1     // Catch:{ all -> 0x00ee }
            org.opencv.core.Mat[] r4 = r0.mFrameChain     // Catch:{ all -> 0x00ee }
            if (r4 == 0) goto L_0x0056
            org.opencv.core.Mat[] r4 = r0.mFrameChain     // Catch:{ all -> 0x00ee }
            r4 = r4[r3]     // Catch:{ all -> 0x00ee }
            long r4 = r4.nativeObj     // Catch:{ all -> 0x00ee }
            org.opencv.core.Mat.n_release(r4)     // Catch:{ all -> 0x00ee }
            org.opencv.core.Mat[] r4 = r0.mFrameChain     // Catch:{ all -> 0x00ee }
            r4 = r4[r2]     // Catch:{ all -> 0x00ee }
            long r4 = r4.nativeObj     // Catch:{ all -> 0x00ee }
            org.opencv.core.Mat.n_release(r4)     // Catch:{ all -> 0x00ee }
        L_0x0056:
            org.opencv.android.JavaCameraView$JavaCameraFrame[] r4 = r0.mCameraFrame     // Catch:{ all -> 0x00ee }
            if (r4 == 0) goto L_0x0070
            org.opencv.android.JavaCameraView$JavaCameraFrame[] r4 = r0.mCameraFrame     // Catch:{ all -> 0x00ee }
            r4 = r4[r3]     // Catch:{ all -> 0x00ee }
            org.opencv.core.Mat r4 = r4.mRgba     // Catch:{ all -> 0x00ee }
            long r4 = r4.nativeObj     // Catch:{ all -> 0x00ee }
            org.opencv.core.Mat.n_release(r4)     // Catch:{ all -> 0x00ee }
            org.opencv.android.JavaCameraView$JavaCameraFrame[] r4 = r0.mCameraFrame     // Catch:{ all -> 0x00ee }
            r4 = r4[r2]     // Catch:{ all -> 0x00ee }
            org.opencv.core.Mat r4 = r4.mRgba     // Catch:{ all -> 0x00ee }
            long r4 = r4.nativeObj     // Catch:{ all -> 0x00ee }
            org.opencv.core.Mat.n_release(r4)     // Catch:{ all -> 0x00ee }
        L_0x0070:
            monitor-exit(r0)     // Catch:{ all -> 0x00ee }
            r0.mCameraFrameReady = r3
            android.graphics.Bitmap r0 = r6.mCacheBitmap
            if (r0 == 0) goto L_0x007a
            r0.recycle()
        L_0x007a:
            r6.mState = r3
            if (r3 == 0) goto L_0x00e2
            if (r3 == r2) goto L_0x0082
            goto L_0x00f4
        L_0x0082:
            int r0 = r6.getWidth()
            int r4 = r6.getHeight()
            r5 = r6
            org.opencv.android.JavaCameraView r5 = (org.opencv.android.JavaCameraView) r5
            boolean r0 = r5.initializeCamera(r0, r4)     // Catch:{ Exception -> 0x00a8 }
            if (r0 != 0) goto L_0x0094
            goto L_0x00ac
        L_0x0094:
            r5.mCameraFrameReady = r3     // Catch:{ Exception -> 0x00a8 }
            r5.mStopThread = r3     // Catch:{ Exception -> 0x00a8 }
            java.lang.Thread r0 = new java.lang.Thread     // Catch:{ Exception -> 0x00a8 }
            org.opencv.android.JavaCameraView$CameraWorker r4 = new org.opencv.android.JavaCameraView$CameraWorker     // Catch:{ Exception -> 0x00a8 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x00a8 }
            r0.<init>(r4)     // Catch:{ Exception -> 0x00a8 }
            r5.mThread = r0     // Catch:{ Exception -> 0x00a8 }
            r0.start()     // Catch:{ Exception -> 0x00a8 }
            goto L_0x00ad
        L_0x00a8:
            r0 = move-exception
            r0.getMessage()
        L_0x00ac:
            r2 = 0
        L_0x00ad:
            if (r2 != 0) goto L_0x00d2
            android.app.AlertDialog$Builder r0 = new android.app.AlertDialog$Builder
            android.content.Context r1 = r6.getContext()
            r0.<init>(r1)
            android.app.AlertDialog r0 = r0.create()
            r0.setCancelable(r3)
            java.lang.String r1 = "It seems that you device does not support camera (or it is locked). Application will be closed."
            r0.setMessage(r1)
            r1 = -3
            org.opencv.android.CameraBridgeViewBase$1 r2 = new org.opencv.android.CameraBridgeViewBase$1
            r2.<init>()
            java.lang.String r3 = "OK"
            r0.setButton(r1, r3, r2)
            r0.show()
        L_0x00d2:
            org.opencv.android.CameraBridgeViewBase$CvCameraViewListener2 r0 = r6.mListener
            if (r0 == 0) goto L_0x00f4
            int r1 = r6.mFrameWidth
            int r2 = r6.mFrameHeight
            org.opencv.android.CameraBridgeViewBase$CvCameraViewListenerAdapter r0 = (org.opencv.android.CameraBridgeViewBase.CvCameraViewListenerAdapter) r0
            org.opencv.android.CameraBridgeViewBase$CvCameraViewListener r0 = r0.mOldStyleListener
            r0.onCameraViewStarted(r1, r2)
            goto L_0x00f4
        L_0x00e2:
            org.opencv.android.CameraBridgeViewBase$CvCameraViewListener2 r0 = r6.mListener
            if (r0 == 0) goto L_0x00f4
            org.opencv.android.CameraBridgeViewBase$CvCameraViewListenerAdapter r0 = (org.opencv.android.CameraBridgeViewBase.CvCameraViewListenerAdapter) r0
            org.opencv.android.CameraBridgeViewBase$CvCameraViewListener r0 = r0.mOldStyleListener
            r0.onCameraViewStopped()
            goto L_0x00f4
        L_0x00ee:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00ee }
            throw r1
        L_0x00f1:
            r0.mThread = r1
            throw r2
        L_0x00f4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.opencv.android.CameraBridgeViewBase.checkCurrentState():void");
    }

    public void setCameraIndex(int i) {
        this.mCameraIndex = i;
    }

    public void setCvCameraViewListener(CvCameraViewListener2 cvCameraViewListener2) {
        this.mListener = cvCameraViewListener2;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        synchronized (this.mSyncObject) {
            if (!this.mSurfaceExist) {
                this.mSurfaceExist = true;
                checkCurrentState();
            } else {
                this.mSurfaceExist = false;
                checkCurrentState();
                this.mSurfaceExist = true;
                checkCurrentState();
            }
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        synchronized (this.mSyncObject) {
            this.mSurfaceExist = false;
            checkCurrentState();
        }
    }

    public void setCvCameraViewListener(CvCameraViewListener cvCameraViewListener) {
        CvCameraViewListenerAdapter cvCameraViewListenerAdapter = new CvCameraViewListenerAdapter(cvCameraViewListener);
        cvCameraViewListenerAdapter.mPreviewFormat = this.mPreviewFormat;
        this.mListener = cvCameraViewListenerAdapter;
    }
}
