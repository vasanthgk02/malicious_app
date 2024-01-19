package org.apache.pdfbox.pdmodel.graphics.predictor;

public class Average extends PredictorAlgorithm {
    public void decodeLine(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4) {
        int bpp = getBpp() * getWidth();
        for (int i5 = 0; i5 < bpp; i5++) {
            bArr2[i5 + i4] = (byte) (bArr[i5 + i2] + ((abovePixel(bArr2, i4, i3, i5) + leftPixel(bArr2, i4, i3, i5)) >>> 2));
        }
    }

    public void encodeLine(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4) {
        int bpp = getBpp() * getWidth();
        for (int i5 = 0; i5 < bpp; i5++) {
            bArr2[i5 + i4] = (byte) (bArr[i5 + i2] - ((abovePixel(bArr, i2, i, i5) + leftPixel(bArr, i2, i, i5)) >>> 2));
        }
    }
}
