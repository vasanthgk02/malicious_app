package org.apache.pdfbox.pdmodel.interactive.pagenavigation;

import com.facebook.imagepipeline.common.RotationOptions;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;

public enum PDTransitionDirection {
    LEFT_TO_RIGHT(0),
    BOTTOM_TO_TOP(90),
    RIGHT_TO_LEFT(RotationOptions.ROTATE_180),
    TOP_TO_BOTTOM(270),
    TOP_LEFT_TO_BOTTOM_RIGHT(315),
    NONE(0) {
        public COSBase getCOSBase() {
            return COSName.NONE;
        }
    };
    
    public int degrees;

    public COSBase getCOSBase() {
        return COSInteger.get((long) this.degrees);
    }

    /* access modifiers changed from: public */
    PDTransitionDirection(int i) {
        this.degrees = i;
    }
}
