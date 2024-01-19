package org.apache.pdfbox.pdmodel.graphics.predictor;

public class Sub extends PredictorAlgorithm {
    public void decodeLine(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4) {
        int bpp = getBpp() * getWidth();
        int bpp2 = getBpp();
        int i5 = 0;
        while (i5 < bpp && i5 < bpp2) {
            bArr2[i5 + i4] = bArr[i5 + i2];
            i5++;
        }
        for (int bpp3 = getBpp(); bpp3 < bpp; bpp3++) {
            int i6 = bpp3 + i4;
            bArr2[i6] = (byte) (bArr[bpp3 + i2] + bArr2[i6 - bpp2]);
        }
    }

    public void encodeLine(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4) {
        int bpp = getBpp() * getWidth();
        int bpp2 = getBpp();
        int i5 = 0;
        while (i5 < bpp && i5 < bpp2) {
            bArr2[i5 + i4] = bArr[i5 + i2];
            i5++;
        }
        for (int bpp3 = getBpp(); bpp3 < bpp; bpp3++) {
            int i6 = bpp3 + i2;
            bArr2[bpp3 + i4] = (byte) (bArr[i6] - bArr[i6 - bpp2]);
        }
    }
}
