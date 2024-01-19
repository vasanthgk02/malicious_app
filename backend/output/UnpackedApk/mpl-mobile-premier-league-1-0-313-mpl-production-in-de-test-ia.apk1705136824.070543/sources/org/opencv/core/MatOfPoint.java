package org.opencv.core;

import androidx.recyclerview.widget.LinearLayoutManager;

public class MatOfPoint extends Mat {
    public MatOfPoint() {
    }

    public MatOfPoint(Mat mat) {
        super(mat, new Range(LinearLayoutManager.INVALID_OFFSET, Integer.MAX_VALUE));
        if (!empty() && Mat.n_checkVector(this.nativeObj, 2, 4) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }
}
