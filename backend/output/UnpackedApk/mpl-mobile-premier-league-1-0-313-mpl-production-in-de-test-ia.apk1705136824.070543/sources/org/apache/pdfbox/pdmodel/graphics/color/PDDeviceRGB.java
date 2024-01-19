package org.apache.pdfbox.pdmodel.graphics.color;

import org.apache.pdfbox.cos.COSName;

public final class PDDeviceRGB extends PDDeviceColorSpace {
    public static final PDDeviceRGB INSTANCE = new PDDeviceRGB();
    public final PDColor initialColor = new PDColor(new float[]{0.0f, 0.0f, 0.0f}, (PDColorSpace) this);

    public float[] getDefaultDecode(int i) {
        return new float[]{0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f};
    }

    public PDColor getInitialColor() {
        return this.initialColor;
    }

    public String getName() {
        return COSName.DEVICERGB.getName();
    }

    public int getNumberOfComponents() {
        return 3;
    }

    public float[] toRGB(float[] fArr) {
        if (fArr.length == 3) {
            return fArr;
        }
        return this.initialColor.getComponents();
    }
}
