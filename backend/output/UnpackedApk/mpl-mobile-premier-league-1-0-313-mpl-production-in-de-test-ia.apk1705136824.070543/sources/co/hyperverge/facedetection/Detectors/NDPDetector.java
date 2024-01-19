package co.hyperverge.facedetection.Detectors;

import android.content.Context;
import android.content.res.AssetManager;
import com.getkeepsafe.relinker.ReLinkerInstance;
import java.io.File;

public class NDPDetector extends HVFaceDetector {
    public AssetManager mgr;

    public native synchronized String detectFaces(byte[] bArr, int i, int i2, int i3, String str);

    public native synchronized int getAverageIntensity(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, boolean z);

    public boolean initialize(Context context) {
        new ReLinkerInstance().loadLibrary(context, "ndp-detector", null, null);
        AssetManager assets = context.getResources().getAssets();
        this.mgr = assets;
        loadModel(assets, null, 640, 480, 20, 11);
        try {
            new File("/sdcard/saved/").mkdirs();
        } catch (Exception e2) {
            e2.getMessage();
        }
        return true;
    }

    public native synchronized void loadModel(AssetManager assetManager, String str, int i, int i2, int i3, int i4);

    public void release() {
        releaseModel(0);
    }

    public native synchronized void releaseModel(long j);
}
