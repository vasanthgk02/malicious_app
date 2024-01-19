package com.google.zxing.pdf417.decoder;

public final class DetectionResultRowIndicatorColumn extends DetectionResultColumn {
    public final boolean isLeft;

    public DetectionResultRowIndicatorColumn(BoundingBox boundingBox, boolean z) {
        super(boundingBox);
        this.isLeft = z;
    }

    public BarcodeMetadata getBarcodeMetadata() {
        Codeword[] codewordArr = this.codewords;
        BarcodeValue barcodeValue = new BarcodeValue();
        BarcodeValue barcodeValue2 = new BarcodeValue();
        BarcodeValue barcodeValue3 = new BarcodeValue();
        BarcodeValue barcodeValue4 = new BarcodeValue();
        for (Codeword codeword : codewordArr) {
            if (codeword != null) {
                codeword.setRowNumberAsRowIndicatorColumn();
                int i = codeword.value % 30;
                int i2 = codeword.rowNumber;
                if (!this.isLeft) {
                    i2 += 2;
                }
                int i3 = i2 % 3;
                if (i3 == 0) {
                    barcodeValue2.setValue((i * 3) + 1);
                } else if (i3 == 1) {
                    barcodeValue4.setValue(i / 3);
                    barcodeValue3.setValue(i % 3);
                } else if (i3 == 2) {
                    barcodeValue.setValue(i + 1);
                }
            }
        }
        if (barcodeValue.getValue().length == 0 || barcodeValue2.getValue().length == 0 || barcodeValue3.getValue().length == 0 || barcodeValue4.getValue().length == 0 || barcodeValue.getValue()[0] <= 0 || barcodeValue2.getValue()[0] + barcodeValue3.getValue()[0] < 3 || barcodeValue2.getValue()[0] + barcodeValue3.getValue()[0] > 90) {
            return null;
        }
        BarcodeMetadata barcodeMetadata = new BarcodeMetadata(barcodeValue.getValue()[0], barcodeValue2.getValue()[0], barcodeValue3.getValue()[0], barcodeValue4.getValue()[0]);
        removeIncorrectCodewords(codewordArr, barcodeMetadata);
        return barcodeMetadata;
    }

    public final void removeIncorrectCodewords(Codeword[] codewordArr, BarcodeMetadata barcodeMetadata) {
        for (int i = 0; i < codewordArr.length; i++) {
            Codeword codeword = codewordArr[i];
            if (codewordArr[i] != null) {
                int i2 = codeword.value % 30;
                int i3 = codeword.rowNumber;
                if (i3 > barcodeMetadata.rowCount) {
                    codewordArr[i] = null;
                } else {
                    if (!this.isLeft) {
                        i3 += 2;
                    }
                    int i4 = i3 % 3;
                    if (i4 != 0) {
                        if (i4 != 1) {
                            if (i4 == 2 && i2 + 1 != barcodeMetadata.columnCount) {
                                codewordArr[i] = null;
                            }
                        } else if (i2 / 3 != barcodeMetadata.errorCorrectionLevel || i2 % 3 != barcodeMetadata.rowCountLowerPart) {
                            codewordArr[i] = null;
                        }
                    } else if ((i2 * 3) + 1 != barcodeMetadata.rowCountUpperPart) {
                        codewordArr[i] = null;
                    }
                }
            }
        }
    }

    public String toString() {
        return "IsLeft: " + this.isLeft + 10 + super.toString();
    }
}
