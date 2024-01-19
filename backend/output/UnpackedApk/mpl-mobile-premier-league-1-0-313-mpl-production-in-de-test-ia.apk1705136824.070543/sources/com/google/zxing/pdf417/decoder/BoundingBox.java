package com.google.zxing.pdf417.decoder;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

public final class BoundingBox {
    public ResultPoint bottomLeft;
    public ResultPoint bottomRight;
    public BitMatrix image;
    public int maxX;
    public int maxY;
    public int minX;
    public int minY;
    public ResultPoint topLeft;
    public ResultPoint topRight;

    public BoundingBox(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) throws NotFoundException {
        if (!(resultPoint == null && resultPoint3 == null) && (!(resultPoint2 == null && resultPoint4 == null) && ((resultPoint == null || resultPoint2 != null) && (resultPoint3 == null || resultPoint4 != null)))) {
            this.image = bitMatrix;
            this.topLeft = resultPoint;
            this.bottomLeft = resultPoint2;
            this.topRight = resultPoint3;
            this.bottomRight = resultPoint4;
            calculateMinMaxValues();
            return;
        }
        throw NotFoundException.INSTANCE;
    }

    public final void calculateMinMaxValues() {
        ResultPoint resultPoint = this.topLeft;
        if (resultPoint == null) {
            this.topLeft = new ResultPoint(0.0f, this.topRight.y);
            this.bottomLeft = new ResultPoint(0.0f, this.bottomRight.y);
        } else if (this.topRight == null) {
            this.topRight = new ResultPoint((float) (this.image.width - 1), resultPoint.y);
            this.bottomRight = new ResultPoint((float) (this.image.width - 1), this.bottomLeft.y);
        }
        this.minX = (int) Math.min(this.topLeft.x, this.bottomLeft.x);
        this.maxX = (int) Math.max(this.topRight.x, this.bottomRight.x);
        this.minY = (int) Math.min(this.topLeft.y, this.topRight.y);
        this.maxY = (int) Math.max(this.bottomLeft.y, this.bottomRight.y);
    }

    public BoundingBox(BoundingBox boundingBox) {
        BitMatrix bitMatrix = boundingBox.image;
        ResultPoint resultPoint = boundingBox.topLeft;
        ResultPoint resultPoint2 = boundingBox.bottomLeft;
        ResultPoint resultPoint3 = boundingBox.topRight;
        ResultPoint resultPoint4 = boundingBox.bottomRight;
        this.image = bitMatrix;
        this.topLeft = resultPoint;
        this.bottomLeft = resultPoint2;
        this.topRight = resultPoint3;
        this.bottomRight = resultPoint4;
        calculateMinMaxValues();
    }
}
