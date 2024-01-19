package org.apache.pdfbox.pdmodel.graphics.color;

import org.apache.pdfbox.cos.COSName;

public final class PDDeviceGray extends PDDeviceColorSpace {
    public static final PDDeviceGray INSTANCE = new PDDeviceGray();
    public final PDColor initialColor = new PDColor(new float[]{0.0f}, (PDColorSpace) this);

    public float[] getDefaultDecode(int i) {
        return new float[]{0.0f, 1.0f};
    }

    public PDColor getInitialColor() {
        return this.initialColor;
    }

    public String getName() {
        return COSName.DEVICEGRAY.getName();
    }

    public int getNumberOfComponents() {
        return 1;
    }

    public float[] toRGB(float[] fArr) {
        return new float[]{fArr[0], fArr[0], fArr[0]};
    }
}
