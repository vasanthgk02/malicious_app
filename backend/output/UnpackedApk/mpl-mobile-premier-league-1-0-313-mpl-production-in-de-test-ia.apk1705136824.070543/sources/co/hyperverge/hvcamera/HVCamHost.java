package co.hyperverge.hvcamera;

import java.io.File;

public abstract class HVCamHost {
    public abstract void flashScreen();

    public abstract int getAspectRatio();

    public abstract File getPhotoDirectory();

    public abstract String getPhotoFilename();

    public abstract float getPictureMegapixels();

    public abstract float getPreviewMegapixels();

    public abstract String getVideoFilename();

    public abstract boolean isShouldCaptureHighResolutionImage();

    public abstract void onCameraFlipCallback();

    public abstract void onCamerasFound(int i);

    public abstract void onFilterMode(int i, String str);

    public abstract void onFlashAuto();

    public abstract void onFlashNull();

    public abstract void onFlashOff();

    public abstract void onFlashOn();

    public abstract void onFlashTorchOn();

    public abstract void onLayoutChange();

    public abstract void onNewPreviewFrame(byte[] bArr, int i, int i2, int i3, int i4, byte[] bArr2);

    public abstract void onPictureFailed();

    public abstract void onPictureReady(byte[] bArr);

    public abstract void onPictureSaved(File file);

    public abstract void onPictureSizeSet(int i, int i2);

    public abstract void onReady();

    public abstract void onViewDimensionChange(int i, int i2);

    public abstract void setScreenFlashOff();

    public abstract void showCrossHair(float f2, float f3, boolean z);

    public abstract void zoomMaxLevel(int i);
}
