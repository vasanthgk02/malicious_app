package org.apache.pdfbox.pdmodel.graphics.predictor;

public class None extends PredictorAlgorithm {
    public void decode(byte[] bArr, byte[] bArr2) {
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
    }

    public void decodeLine(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4) {
        int bpp = getBpp() * getWidth();
        for (int i5 = 0; i5 < bpp; i5++) {
            bArr2[i4 + i5] = bArr[i2 + i5];
        }
    }

    public void encode(byte[] bArr, byte[] bArr2) {
        checkBufsiz(bArr2, bArr);
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
    }

    public void encodeLine(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4) {
        int bpp = getBpp() * getWidth();
        for (int i5 = 0; i5 < bpp; i5++) {
            bArr2[i4 + i5] = bArr[i2 + i5];
        }
    }
}
