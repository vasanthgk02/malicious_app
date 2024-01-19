package org.apache.pdfbox.pdmodel.graphics.predictor;

public class Up extends PredictorAlgorithm {
    public void decodeLine(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4) {
        int bpp = getBpp() * getWidth();
        int i5 = 0;
        if (i4 - i3 >= 0) {
            while (i5 < bpp) {
                int i6 = i4 + i5;
                bArr2[i6] = (byte) (bArr[i2 + i5] + bArr2[i6 - i3]);
                i5++;
            }
        } else if (getHeight() > 0) {
            while (i5 < bpp) {
                bArr2[i4 + i5] = bArr[i2 + i5];
                i5++;
            }
        }
    }

    public void encodeLine(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4) {
        int bpp = getBpp() * getWidth();
        int i5 = 0;
        if (i2 - i >= 0) {
            while (i5 < bpp) {
                int i6 = i2 + i5;
                bArr2[i4 + i5] = (byte) (bArr[i6] - bArr[i6 - i]);
                i5++;
            }
        } else if (getHeight() > 0) {
            while (i5 < bpp) {
                bArr2[i4 + i5] = bArr[i2 + i5];
                i5++;
            }
        }
    }
}
