package com.idology.idscan.check;

import org.opencv.core.Scalar;

public class IdDocumentFinder {
    public static final Scalar WHITE;

    static {
        Scalar scalar = new Scalar(255.0d, 255.0d, 255.0d, 255.0d);
        WHITE = scalar;
    }
}
