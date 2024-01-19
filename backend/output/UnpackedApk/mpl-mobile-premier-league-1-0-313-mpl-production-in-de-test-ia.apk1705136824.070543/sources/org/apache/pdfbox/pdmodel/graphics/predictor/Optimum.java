package org.apache.pdfbox.pdmodel.graphics.predictor;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.fontbox.cmap.CMap;

public class Optimum extends PredictorAlgorithm {
    public PredictorAlgorithm[] filter = {new None(), new Sub(), new Up(), new Average(), new Paeth()};

    public void checkBufsiz(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int width = getWidth();
        if (length == getHeight() * ((getBpp() * width) + 1)) {
            if (bArr2.length != getBpp() * getHeight() * getWidth()) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("raw.length != width * height * bpp, raw.length=");
                outline73.append(bArr2.length);
                outline73.append(" w,h,bpp=");
                outline73.append(getWidth());
                outline73.append(",");
                outline73.append(getHeight());
                outline73.append(",");
                outline73.append(getBpp());
                throw new IllegalArgumentException(outline73.toString());
            }
            return;
        }
        StringBuilder outline732 = GeneratedOutlineSupport.outline73("filtered.length != (width*bpp + 1) * height, ");
        outline732.append(bArr.length);
        outline732.append(CMap.SPACE);
        int width2 = getWidth();
        outline732.append(getHeight() * ((getBpp() * width2) + 1));
        outline732.append("w,h,bpp=");
        outline732.append(getWidth());
        outline732.append(",");
        outline732.append(getHeight());
        outline732.append(",");
        outline732.append(getBpp());
        throw new IllegalArgumentException(outline732.toString());
    }

    public void decode(byte[] bArr, byte[] bArr2) {
        checkBufsiz(bArr, bArr2);
        int bpp = getBpp() * getWidth();
        int i = bpp + 1;
        for (int i2 = 0; i2 < getHeight(); i2++) {
            int i3 = i2 * i;
            this.filter[bArr[i3]].decodeLine(bArr, bArr2, i, i3 + 1, bpp, i2 * bpp);
        }
    }

    public void decodeLine(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4) {
        throw new UnsupportedOperationException("decodeLine");
    }

    public void encode(byte[] bArr, byte[] bArr2) {
        checkBufsiz(bArr2, bArr);
        throw new UnsupportedOperationException("encode");
    }

    public void encodeLine(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4) {
        throw new UnsupportedOperationException("encodeLine");
    }

    public void setBpp(int i) {
        super.setBpp(i);
        int i2 = 0;
        while (true) {
            PredictorAlgorithm[] predictorAlgorithmArr = this.filter;
            if (i2 < predictorAlgorithmArr.length) {
                predictorAlgorithmArr[i2].setBpp(i);
                i2++;
            } else {
                return;
            }
        }
    }

    public void setHeight(int i) {
        super.setHeight(i);
        int i2 = 0;
        while (true) {
            PredictorAlgorithm[] predictorAlgorithmArr = this.filter;
            if (i2 < predictorAlgorithmArr.length) {
                predictorAlgorithmArr[i2].setHeight(i);
                i2++;
            } else {
                return;
            }
        }
    }

    public void setWidth(int i) {
        super.setWidth(i);
        int i2 = 0;
        while (true) {
            PredictorAlgorithm[] predictorAlgorithmArr = this.filter;
            if (i2 < predictorAlgorithmArr.length) {
                predictorAlgorithmArr[i2].setWidth(i);
                i2++;
            } else {
                return;
            }
        }
    }
}
