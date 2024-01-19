package com.google.zxing.pdf417.decoder;

import java.util.Formatter;

public class DetectionResultColumn {
    public final BoundingBox boundingBox;
    public final Codeword[] codewords;

    public DetectionResultColumn(BoundingBox boundingBox2) {
        this.boundingBox = new BoundingBox(boundingBox2);
        this.codewords = new Codeword[((boundingBox2.maxY - boundingBox2.minY) + 1)];
    }

    public final Codeword getCodewordNearby(int i) {
        Codeword codeword = this.codewords[i - this.boundingBox.minY];
        if (codeword != null) {
            return codeword;
        }
        for (int i2 = 1; i2 < 5; i2++) {
            int i3 = (i - this.boundingBox.minY) - i2;
            if (i3 >= 0) {
                Codeword codeword2 = this.codewords[i3];
                if (codeword2 != null) {
                    return codeword2;
                }
            }
            int i4 = (i - this.boundingBox.minY) + i2;
            Codeword[] codewordArr = this.codewords;
            if (i4 < codewordArr.length) {
                Codeword codeword3 = codewordArr[i4];
                if (codeword3 != null) {
                    return codeword3;
                }
            }
        }
        return null;
    }

    public final int imageRowToCodewordIndex(int i) {
        return i - this.boundingBox.minY;
    }

    public String toString() {
        Formatter formatter = new Formatter();
        int i = 0;
        for (Codeword codeword : this.codewords) {
            if (codeword == null) {
                formatter.format("%3d:    |   %n", new Object[]{Integer.valueOf(i)});
                i++;
            } else {
                formatter.format("%3d: %3d|%3d%n", new Object[]{Integer.valueOf(i), Integer.valueOf(codeword.rowNumber), Integer.valueOf(codeword.value)});
                i++;
            }
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }
}
