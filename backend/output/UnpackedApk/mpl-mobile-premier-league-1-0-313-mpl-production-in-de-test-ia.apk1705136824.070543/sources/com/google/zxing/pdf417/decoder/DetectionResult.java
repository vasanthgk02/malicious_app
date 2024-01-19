package com.google.zxing.pdf417.decoder;

import com.google.zxing.ResultPoint;
import java.util.Formatter;

public final class DetectionResult {
    public final int barcodeColumnCount;
    public final BarcodeMetadata barcodeMetadata;
    public BoundingBox boundingBox;
    public final DetectionResultColumn[] detectionResultColumns;

    public DetectionResult(BarcodeMetadata barcodeMetadata2, BoundingBox boundingBox2) {
        this.barcodeMetadata = barcodeMetadata2;
        int i = barcodeMetadata2.columnCount;
        this.barcodeColumnCount = i;
        this.boundingBox = boundingBox2;
        this.detectionResultColumns = new DetectionResultColumn[(i + 2)];
    }

    public static int adjustRowNumberIfValid(int i, int i2, Codeword codeword) {
        if (codeword.hasValidRowNumber()) {
            return i2;
        }
        if (!(i != -1 && codeword.bucket == (i % 3) * 3)) {
            return i2 + 1;
        }
        codeword.rowNumber = i;
        return 0;
    }

    public final void adjustIndicatorColumnRowNumbers(DetectionResultColumn detectionResultColumn) {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        int i;
        if (detectionResultColumn != null) {
            DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn = (DetectionResultRowIndicatorColumn) detectionResultColumn;
            BarcodeMetadata barcodeMetadata2 = this.barcodeMetadata;
            Codeword[] codewordArr = detectionResultRowIndicatorColumn.codewords;
            for (Codeword codeword : codewordArr) {
                if (codeword != null) {
                    codeword.setRowNumberAsRowIndicatorColumn();
                }
            }
            detectionResultRowIndicatorColumn.removeIncorrectCodewords(codewordArr, barcodeMetadata2);
            BoundingBox boundingBox2 = detectionResultRowIndicatorColumn.boundingBox;
            if (detectionResultRowIndicatorColumn.isLeft) {
                resultPoint = boundingBox2.topLeft;
            } else {
                resultPoint = boundingBox2.topRight;
            }
            if (detectionResultRowIndicatorColumn.isLeft) {
                resultPoint2 = boundingBox2.bottomLeft;
            } else {
                resultPoint2 = boundingBox2.bottomRight;
            }
            int imageRowToCodewordIndex = detectionResultRowIndicatorColumn.imageRowToCodewordIndex((int) resultPoint.y);
            int imageRowToCodewordIndex2 = detectionResultRowIndicatorColumn.imageRowToCodewordIndex((int) resultPoint2.y);
            int i2 = -1;
            int i3 = 0;
            int i4 = 1;
            while (imageRowToCodewordIndex < imageRowToCodewordIndex2) {
                if (codewordArr[imageRowToCodewordIndex] != null) {
                    Codeword codeword2 = codewordArr[imageRowToCodewordIndex];
                    int i5 = codeword2.rowNumber;
                    int i6 = i5 - i2;
                    if (i6 == 0) {
                        i3++;
                    } else {
                        if (i6 == 1) {
                            int max = Math.max(i4, i3);
                            i = codeword2.rowNumber;
                            i4 = max;
                        } else if (i6 < 0 || i5 >= barcodeMetadata2.rowCount || i6 > imageRowToCodewordIndex) {
                            codewordArr[imageRowToCodewordIndex] = null;
                        } else {
                            if (i4 > 2) {
                                i6 *= i4 - 2;
                            }
                            boolean z = i6 >= imageRowToCodewordIndex;
                            for (int i7 = 1; i7 <= i6 && !z; i7++) {
                                z = codewordArr[imageRowToCodewordIndex - i7] != null;
                            }
                            if (z) {
                                codewordArr[imageRowToCodewordIndex] = null;
                            } else {
                                i = codeword2.rowNumber;
                            }
                        }
                        i2 = i;
                        i3 = 1;
                    }
                }
                imageRowToCodewordIndex++;
            }
        }
    }

    public String toString() {
        DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
        DetectionResultColumn detectionResultColumn = detectionResultColumnArr[0];
        if (detectionResultColumn == null) {
            detectionResultColumn = detectionResultColumnArr[this.barcodeColumnCount + 1];
        }
        Formatter formatter = new Formatter();
        for (int i = 0; i < detectionResultColumn.codewords.length; i++) {
            formatter.format("CW %3d:", new Object[]{Integer.valueOf(i)});
            for (int i2 = 0; i2 < this.barcodeColumnCount + 2; i2++) {
                DetectionResultColumn[] detectionResultColumnArr2 = this.detectionResultColumns;
                if (detectionResultColumnArr2[i2] == null) {
                    formatter.format("    |   ", new Object[0]);
                } else {
                    Codeword codeword = detectionResultColumnArr2[i2].codewords[i];
                    if (codeword == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        formatter.format(" %3d|%3d", new Object[]{Integer.valueOf(codeword.rowNumber), Integer.valueOf(codeword.value)});
                    }
                }
            }
            formatter.format("%n", new Object[0]);
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }
}
